package substitutions;

import com.oracle.svm.core.annotate.Substitute;
import com.oracle.svm.core.annotate.TargetClass;

@TargetClass(className = "java.awt.image.Raster")
public final class Raster_Substitutions {

  @Substitute
  private static void initIDs() {}
}
