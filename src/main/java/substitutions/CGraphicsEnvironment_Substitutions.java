package substitutions;

import com.oracle.svm.core.annotate.Substitute;
import com.oracle.svm.core.annotate.TargetClass;

import java.awt.*;

@TargetClass(className = "sun.awt.CGraphicsEnvironment")
public final class CGraphicsEnvironment_Substitutions {

  @Substitute
  public Font[] getAllFonts() {
    return new Font[]{};
  }

}
