package substitutions;

import com.oracle.svm.core.annotate.Substitute;
import com.oracle.svm.core.annotate.TargetClass;

@TargetClass(className = "sun.java2d.Disposer")
public final class Disposer_Substitutions {

  @Substitute
  private static void initIDs() {}
}
