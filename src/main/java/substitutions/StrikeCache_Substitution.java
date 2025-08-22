package substitutions;

import com.oracle.svm.core.annotate.Substitute;
import com.oracle.svm.core.annotate.TargetClass;

@TargetClass(className = "sun.font.StrikeCache")
public final class StrikeCache_Substitution {

  @Substitute
  static long getInvisibleGlyphPtr() {
    return 0L;
  }
}
