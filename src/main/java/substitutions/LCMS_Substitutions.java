package substitutions;

import com.oracle.svm.core.annotate.Substitute;
import com.oracle.svm.core.annotate.TargetClass;
import sun.java2d.cmm.Profile;

// usage of java.awt
@TargetClass(className = "sun.java2d.cmm.lcms.LCMS")
public final class LCMS_Substitutions {

  @Substitute
  private static long loadProfileNative(byte[] data, Object ref) {
    return 0L;
  }

  @Substitute
  public byte[] getProfileData(Profile p) {
    return null;
  }

}
