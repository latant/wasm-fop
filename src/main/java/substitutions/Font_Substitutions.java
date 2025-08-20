package substitutions;

import com.oracle.svm.core.annotate.Substitute;
import com.oracle.svm.core.annotate.TargetClass;

// usage of java.awt
@TargetClass(className = "java.awt.Font")
public final class Font_Substitutions {

  @Substitute
  private static void initIDs() {};
}
