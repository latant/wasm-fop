package substitutions;

import com.oracle.svm.core.annotate.Substitute;
import com.oracle.svm.core.annotate.TargetClass;

@TargetClass(className = "sun.awt.image.BufImgSurfaceData")
public final class BufImgSurfaceData_Substitutions {

  @Substitute
  private static void initIDs() {}
}
