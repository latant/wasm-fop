import org.graalvm.webimage.api.JS;
import org.graalvm.webimage.api.JSObject;
import org.graalvm.webimage.api.JSString;

import java.nio.charset.StandardCharsets;
import java.util.function.Consumer;

public final class FopMain {

  @JS.Coerce
  @JS("FOP_RESULT = res;")
  static native void setResult(String res);

  @JS.Coerce
  @JS("FOP_FILE_SETTER = func;")
  static native void setFileSetter(Consumer<JSObject> func);

  @JS.Coerce
  @JS("FOP_FILE_REMOVER = func;")
  static native void setFileRemover(Consumer<JSString> func);

  @JS.Coerce
  @JS("FOP_FILES_CLEARER = func;")
  static native void setFilesClearer(Runnable func);

  @JS.Coerce
  @JS("FOP_TRANSFORMER = func;")
  static native void setTransformer(Consumer<JSObject> func);

  static FopImpl impl = new FopImpl();

  public static void main(String[] args) {
    setFilesClearer(() -> {
      impl.clearFiles();
    });
    setFileRemover(key -> {
      runCatching(() -> {
        impl.removeFile(key.asString());
      });
    });
    setFileSetter(file -> {
      runCatching(() -> {
        var fileName = (JSString) file.get("name");
        var fileContent = (JSString) file.get("content");
        impl.setFile(fileName.asString(), fileContent.asString());
      });
    });
    setTransformer(opts -> {
      runCatching(() -> {
        var inputNameJS = (JSString) opts.get("input");
        var configNameJS = (JSString) opts.get("config");
        var output = impl.transform(inputNameJS.asString(), configNameJS.asString());
        setResult(new String(output, StandardCharsets.ISO_8859_1));
      });
    });
  }

  static void runCatching(ThrowingRunnable runnable) {
    try {
      runnable.run();
    } catch (Throwable e) {
      System.err.println(e.getMessage());
      e.printStackTrace(System.err);
      throw new RuntimeException(e);
    }
  }

  @FunctionalInterface
  interface ThrowingRunnable {
    void run() throws Throwable;
  }

}
