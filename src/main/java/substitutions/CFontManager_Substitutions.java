package substitutions;

import com.oracle.svm.core.annotate.Substitute;
import com.oracle.svm.core.annotate.TargetClass;

@TargetClass(className = "sun.font.CFontManager")
public final class CFontManager_Substitutions {

  @Substitute
  protected void loadFonts() {}
}
