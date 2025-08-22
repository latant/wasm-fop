package substitutions;

import com.oracle.svm.core.annotate.Substitute;
import com.oracle.svm.core.annotate.TargetClass;

@TargetClass(className = "sun.java2d.SurfaceData")
public final class SurfaceData_Substitutions {

  @Substitute
  private static void initIDs() {}
}
