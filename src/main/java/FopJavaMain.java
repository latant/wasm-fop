import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FopJavaMain {
  public static void main(String[] args) {
    try {
      var impl = new FopImpl();
      var inputBytes = Files.readAllBytes(Path.of("input.xml"));
      var configBytes = Files.readAllBytes(Path.of("config.xml"));
      var fontBytes = Files.readAllBytes(Path.of("Roboto.ttf"));
      impl.setFile("file:///input.xml", new String(inputBytes, StandardCharsets.ISO_8859_1));
      impl.setFile("file:///config.xml", new String(configBytes, StandardCharsets.ISO_8859_1));
      impl.setFile("file:///Roboto.ttf", new String(fontBytes, StandardCharsets.ISO_8859_1));
      var output = impl.transform("file:///input.xml", "file:///config.xml");
      Files.write(Paths.get("output-java.pdf"), output);
    } catch (Throwable e) {
      throw new RuntimeException(e);
    }
  }
}
