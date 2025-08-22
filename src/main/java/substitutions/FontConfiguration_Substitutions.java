package substitutions;

import com.oracle.svm.core.annotate.Substitute;
import com.oracle.svm.core.annotate.TargetClass;

import java.io.File;

@TargetClass(className = "sun.awt.FontConfiguration")
public final class FontConfiguration_Substitutions {

  @Substitute
  private void findFontConfigFile() {}

  @Substitute
  private void readFontConfigFile(File f) {}

  @Substitute
  private void initFontConfig() {}

  @Substitute
  public String getExtraFontPath() {
    return null;
  }
}
