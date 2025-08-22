package substitutions;

import com.oracle.svm.core.annotate.Substitute;
import com.oracle.svm.core.annotate.TargetClass;

@TargetClass(className = "java.awt.image.BufferedImage")
public final class BufferedImage_Substitutions {

  @Substitute
  private static void initIDs() {}
}
