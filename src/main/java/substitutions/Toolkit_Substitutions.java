package substitutions;

import com.oracle.svm.core.annotate.Substitute;
import com.oracle.svm.core.annotate.TargetClass;

// usage of java.awt
@TargetClass(className = "java.awt.Toolkit")
public final class Toolkit_Substitutions {

  @Substitute
  public static void loadLibraries() {}

  @Substitute
  private static void initStatic() {}
}
