package substitutions;

import com.oracle.svm.core.annotate.Substitute;
import com.oracle.svm.core.annotate.TargetClass;

// usage of any native library
@TargetClass(className = "java.lang.System")
public final class System_Substitutions {
  @Substitute
  public static void loadLibrary(String libname) {

  }
}
