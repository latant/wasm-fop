package substitutions;

import com.oracle.svm.core.annotate.Substitute;
import com.oracle.svm.core.annotate.TargetClass;

import java.awt.image.IndexColorModel;

@TargetClass(className = "sun.awt.image.BufImgSurfaceData")
public final class BufImgSurfaceData_Substitutions {

  @Substitute
  private static void initIDs(Class<?> ICM, Class<?> ICMColorData) {}

  @Substitute
  protected void initRaster(
    Object theArray,
    int offset,
    int bitoffset,
    int width,
    int height,
    int pixStr,
    int scanStr,
    IndexColorModel icm
  ) {}

}
