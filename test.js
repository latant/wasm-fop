const { readFileSync, writeFileSync, readdirSync, statSync } = require('fs');
const FOP = require('./fop.js');

function walkFiles(f) {
  const files = readdirSync(f)
  const result = [];
  for (const file of files) {
    const fullPath = `${f}/${file}`;
    const stat = statSync(fullPath);
    if (stat.isDirectory()) {
      result.push(...walkFiles(fullPath));
    } else {
      result.push(fullPath);
    }
  }
  return result;
}

(async () => {
  const fop = await FOP();
  const files = walkFiles('examples');
  
  files.forEach(file => {
    console.log(`Adding file: ${file}`);
    fop.setFile(`file:///${file}`, new Uint8Array(readFileSync(file)));
  })

  files.forEach(file => {
    if (!file.endsWith('.fo')) return;
    const outputPath = file.replace(".fo", "-js.pdf");
    if (outputPath === file) {
      throw new Error(`Output path is the same as input path: ${file}`);
    }
    console.log(`Transforming file: ${file} to ${outputPath}`);
    const result = fop.transform({ input: `file:///${file}`, config: 'file:///examples/config.xconf' });
    writeFileSync(outputPath, result);
  })
})().catch(e => {
  console.error('Error during FOP transformation:');
  console.error(e);
});

