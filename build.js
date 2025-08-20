import {spawnSync} from "child_process";
import { readFileSync, writeFileSync } from "fs";

function measureStep(name, run) {
  console.log(`\n${name}`);
  const start = Date.now();
  try {
    run();
  } finally {
    const duration = Date.now() - start;
    console.log(`${name} ended in ${duration} ms`);
  }
}

function runCommand(opts) {
  const {name, cmd, args, ...spawnSyncOptions} = opts;
  console.log(`\n${name}`);
  const start = Date.now();
  const result = spawnSync(cmd, args, {
    ...spawnSyncOptions,
    stdio: "inherit",
  });
  const duration = Date.now() - start;
  console.log(`${name} exited with status ${result.status} in ${duration} ms`);
  if (result.status !== 0) {
    process.exit(1);
  }
}

// runCommand({
//     name: "compileToWasm",
//     cmd: "./mvnw",
//     args: ["compiler:compile"],
// });

// runCommand({
//     name: "compileToWasm",
//     cmd: "./mvnw",
//     args: ["native:compile"],
// });

measureStep("apply-preface",() => {
  const header = readFileSync("src/main/js/fop-header.js", "utf8").toString()
  const footer = readFileSync("src/main/js/fop-footer.js", "utf8").toString()
  const content = readFileSync("target/fop.js", "utf8").toString();
  writeFileSync("target/fop.js", header + content + footer);
})
