package substitutions;

import com.oracle.svm.core.annotate.Substitute;
import com.oracle.svm.core.annotate.TargetClass;

@TargetClass(className = "java.awt.image.SampleModel")
public final class SampleModel_Substitutions {

  @Substitute
  private static void initIDs() {}
}
