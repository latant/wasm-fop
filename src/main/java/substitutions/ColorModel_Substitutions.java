package substitutions;

import com.oracle.svm.core.annotate.Substitute;
import com.oracle.svm.core.annotate.TargetClass;

@TargetClass(className = "java.awt.image.ColorModel")
public final class ColorModel_Substitutions {

  @Substitute
  private static void initIDs() {}
}
