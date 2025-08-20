const { readFileSync, writeFileSync } = require('fs');
const FOP = require('./fop.js');

(async () => {
  const fop = await FOP();
  fop.clearFiles();
  fop.setFile('file:///input.xml', new Uint8Array(readFileSync('./input.xml')));
  fop.setFile('file:///config.xml', new Uint8Array(readFileSync('./config.xml')));
  fop.setFile('file:///DejaVuSans.ttf', new Uint8Array(readFileSync('./DejaVuSans.ttf')));
  fop.setFile('file:///Roboto.ttf', new Uint8Array(readFileSync('./Roboto.ttf')));
  const result = fop.transform({input: 'file:///input.xml', config: 'file:///config.xml'});
  writeFileSync('./output-js.pdf', result);
})().catch(e => {
  console.error('Error during FOP transformation:');
  console.error(e);
});

