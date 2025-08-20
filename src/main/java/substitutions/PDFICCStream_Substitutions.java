package substitutions;

import com.oracle.svm.core.annotate.Substitute;
import com.oracle.svm.core.annotate.TargetClass;

import java.io.IOException;
import java.io.OutputStream;

// usage of java.awt
@TargetClass(className = "org.apache.fop.pdf.PDFICCStream")
public final class PDFICCStream_Substitutions {

  @Substitute
  protected void outputRawStreamData(OutputStream out) throws IOException {

  }
}
