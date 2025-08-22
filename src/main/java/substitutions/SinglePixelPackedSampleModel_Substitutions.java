package substitutions;

import com.oracle.svm.core.annotate.Substitute;
import com.oracle.svm.core.annotate.TargetClass;

@TargetClass(className = "java.awt.image.SinglePixelPackedSampleModel")
public final class SinglePixelPackedSampleModel_Substitutions {

  @Substitute
  private static void initIDs() {}
}
