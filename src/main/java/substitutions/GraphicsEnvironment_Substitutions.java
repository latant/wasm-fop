package substitutions;

import com.oracle.svm.core.annotate.Substitute;
import com.oracle.svm.core.annotate.TargetClass;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Locale;

@TargetClass(className = "java.awt.GraphicsEnvironment")
public final class GraphicsEnvironment_Substitutions {

  @Substitute
  public static GraphicsEnvironment getLocalGraphicsEnvironment() {
    return SpecialGraphicsEnvironment.INSTANCE;
  }

  private static class SpecialGraphicsEnvironment extends GraphicsEnvironment {
    static final SpecialGraphicsEnvironment INSTANCE = new SpecialGraphicsEnvironment();

    private SpecialGraphicsEnvironment() {}

    @Override
    public GraphicsDevice[] getScreenDevices() throws HeadlessException {
      return new GraphicsDevice[0];
    }

    @Override
    public GraphicsDevice getDefaultScreenDevice() throws HeadlessException {
      return null;
    }

    @Override
    public Graphics2D createGraphics(BufferedImage img) {
      return null;
    }

    @Override
    public Font[] getAllFonts() {
      return new Font[0];
    }

    @Override
    public String[] getAvailableFontFamilyNames() {
      return new String[0];
    }

    @Override
    public String[] getAvailableFontFamilyNames(Locale l) {
      return new String[0];
    }
  }

}
