package substitutions;

import com.oracle.svm.core.annotate.Substitute;
import com.oracle.svm.core.annotate.TargetClass;

@TargetClass(className = "sun.java2d.pipe.Region")
public final class Region_Substitutions {

  @Substitute
  private static void initIDs() {}
}
