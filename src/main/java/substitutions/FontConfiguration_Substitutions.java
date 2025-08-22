package substitutions;

import com.oracle.svm.core.annotate.Substitute;
import com.oracle.svm.core.annotate.TargetClass;

@TargetClass(className = "java.lang.invoke.LambdaForm")
public final class LambdaForm_Substitutions {

  @Substitute
}
