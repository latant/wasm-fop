package substitutions;

import com.oracle.svm.core.annotate.Substitute;
import com.oracle.svm.core.annotate.TargetClass;

@TargetClass(className = "sun.awt.image.IntegerComponentRaster")
public final class IntegerComponentRaster_Substitutions {

  @Substitute
  private static void initIDs() {}
}
