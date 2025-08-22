package substitutions;

import com.oracle.svm.core.annotate.Substitute;
import com.oracle.svm.core.annotate.TargetClass;

import java.awt.*;

// usage of java.awt
@TargetClass(className = "java.awt.Toolkit")
public final class Toolkit_Substitutions {

  @Substitute
  public static void loadLibraries() {}

  @Substitute
  private static void initStatic() {}

  @Substitute
  public static synchronized Toolkit getDefaultToolkit() {
    return null;
  }
}
