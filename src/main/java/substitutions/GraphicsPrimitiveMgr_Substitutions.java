package substitutions;

import com.oracle.svm.core.annotate.Substitute;
import com.oracle.svm.core.annotate.TargetClass;

@TargetClass(className = "sun.java2d.loops.GraphicsPrimitiveMgr")
public final class GraphicsPrimitiveMgr_Substitutions {

  @Substitute
  private static void initIDs(
    Class<?> GP, Class<?> ST, Class<?> CT,
    Class<?> SG2D, Class<?> Color, Class<?> AT,
    Class<?> XORComp, Class<?> AlphaComp,
    Class<?> Path2D, Class<?> Path2DFloat,
    Class<?> SHints
  ) {}

  @Substitute
  private static void registerNativeLoops() {}
}
