package substitutions;

import com.oracle.svm.core.annotate.Substitute;
import com.oracle.svm.core.annotate.TargetClass;

@TargetClass(className = "sun.font.SunFontManager")
public final class SunFontManager_Substitutions {

  @Substitute
  private static void initIDs() {}

  @Substitute
  public void loadFontFiles() {}

  @Substitute
  protected void loadFonts() {}
}
