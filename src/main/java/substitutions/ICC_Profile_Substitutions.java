package substitutions;

import com.oracle.svm.core.annotate.Substitute;
import com.oracle.svm.core.annotate.TargetClass;
import sun.java2d.cmm.Profile;

// usage of java.awt
@TargetClass(className = "java.awt.color.ICC_Profile")
public final class ICC_Profile_Substitutions {
  @Substitute
  private Profile cmmProfile() {
    return null;
  }

  @Substitute
  public int getNumComponents() {
    return 3;
  }
}
