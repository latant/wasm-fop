import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class FopJavaMain {
  public static void main(String[] args) {
    try {
      var impl = new FopImpl();

      var files = Files.walk(Path.of("examples")).toList();

      for (Path p : files) {
        var file = new File(p.toUri());
        if (!file.isDirectory()) {
          System.out.println("Adding file " + p);
          var bytes = Files.readAllBytes(p);
          impl.setFile("file:///" + p, new String(bytes, StandardCharsets.ISO_8859_1));
        }
      }

      for (Path p : files) {
        if (p.toString().endsWith(".fo")) {
          var outputPath = Path.of(p.toString().replace(".fo", "-java.pdf"));
          if (outputPath.equals(p)) {
            throw new RuntimeException("Output path is the same as input path: " + outputPath);
          }
          System.out.println("Transforming " + p+ " to " + outputPath);
          var output = impl.transform("file:///" + p, "file:///examples/config.xconf");
          Files.write(outputPath, output);
        }
      }
    } catch (Throwable e) {
      throw new RuntimeException(e);
    }
  }

}
