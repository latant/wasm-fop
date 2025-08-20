package substitutions;

import com.oracle.svm.core.annotate.Substitute;
import com.oracle.svm.core.annotate.TargetClass;

// usage of java.awt
@TargetClass(className = "sun.awt.PlatformGraphicsInfo")
public final class PlatformGraphicsInfo_Substitutions {

  @Substitute
  public static boolean isInAquaSession() {
    return false;
  }
}
