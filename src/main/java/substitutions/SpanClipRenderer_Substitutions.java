package substitutions;

import com.oracle.svm.core.annotate.Substitute;
import com.oracle.svm.core.annotate.TargetClass;

@TargetClass(className = "sun.java2d.pipe.SpanClipRenderer")
public final class SpanClipRenderer_Substitutions {

  @Substitute
  private static void initIDs(Class<?> rc, Class<?> ric) {}
}
