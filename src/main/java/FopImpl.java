import org.apache.fop.apps.FopConfParser;
import org.apache.fop.apps.MimeConstants;
import org.apache.xmlgraphics.io.Resource;
import org.apache.xmlgraphics.io.ResourceResolver;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.sax.SAXResult;
import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class FopImpl {
  private final Map<URI, byte[]> files = new HashMap<>();

  void clearFiles() {
    files.clear();
  }

  void removeFile(String uri) throws URISyntaxException {
    files.remove(new URI(uri));
  }

  void setFile(String uri, String content) throws URISyntaxException {
    if (content == null) {
      files.remove(new URI(uri));
    } else {
      files.put(new URI(uri), content.getBytes(StandardCharsets.ISO_8859_1));
    }
  }

  byte[] transform(String inputUri, String configUri) throws Exception {
    var inputBytes = files.get(new URI(inputUri));
    var configBytes = files.get(new URI(configUri));
    try (var input = new ByteArrayInputStream(inputBytes)) {
      try (var output = new ByteArrayOutputStream()) {
        doTransform(input, output, configBytes);
        output.flush();
        return output.toByteArray();
      }
    }
  }

  private void doTransform(InputStream input, OutputStream output, byte[] configXmlBytes) throws Exception {
    var transformerFactory = TransformerFactory.newInstance();
    var transformer = transformerFactory.newTransformer();

    var docBuilderFactory = DocumentBuilderFactory.newInstance();
    var docBuilder = docBuilderFactory.newDocumentBuilder();
    var document = docBuilder.parse(input);

    var resourceResolver = createResourceResolver();
    var parser = new FopConfParser(new ByteArrayInputStream(configXmlBytes), new URI("."), resourceResolver);
    var fopFactorBuilder = parser.getFopFactoryBuilder();
    fopFactorBuilder.setPreferRenderer(true);
    fopFactorBuilder.setStrictFOValidation(false);
    fopFactorBuilder.setTargetResolution(300);

    var fopFactory = fopFactorBuilder.build();

    var foUserAgent = fopFactory.newFOUserAgent();

    var fop = fopFactory.newFop(MimeConstants.MIME_PDF, foUserAgent, output);

    transformer.transform(
      new DOMSource(document),
      new SAXResult(fop.getDefaultHandler())
    );
  }

  private ResourceResolver createResourceResolver() {
    return new ResourceResolver() {
      public Resource getResource(URI uri) throws IOException {
        var byteArray = files.get(uri);
        if (byteArray == null) {
          throw new IOException("File at URI " + uri + " not found");
        }
        return new Resource(new ByteArrayInputStream(byteArray));
      }

      @Override
      public OutputStream getOutputStream(URI uri) throws IOException {
        throw new IOException("Writing not supported.");
      }
    };
  }
}
