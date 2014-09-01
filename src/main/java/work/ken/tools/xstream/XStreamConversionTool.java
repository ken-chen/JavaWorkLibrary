package work.ken.tools.xstream;

import java.io.Writer;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.json.JsonHierarchicalStreamDriver;
import com.thoughtworks.xstream.io.json.JsonWriter;


public class XStreamConversionTool {

	private final static Log logger = LogFactory.getLog(XStreamConversionTool.class); 
	
	static final XStream xstreamForJson = new XStream(new JsonHierarchicalStreamDriver() {

		public HierarchicalStreamWriter createWriter(Writer writer) {
			return new JsonWriter(writer, JsonWriter.DROP_ROOT_MODE);
		}
	});
	
	static final XStream xstreamForJsonWithRoot = new XStream(new JsonHierarchicalStreamDriver() {

		public HierarchicalStreamWriter createWriter(Writer writer) {
			return new JsonWriter(writer, JsonWriter.STRICT_MODE);
		}
	});
	
	static final XStream xstreamForXml = new XStream();

	public static String getXmlString(Object object) {
		logger.debug("Converting object to XML");
		return xstreamForXml.toXML(object);
	}
	
	public static String getJsonString(Object object){
		logger.debug("Converting object to JSON no root mode.");
		return xstreamForJson.toXML(object);
	}
	
	public static String getJsonStringWithRoot(Object object){
		logger.debug("Converting object to JSON with root.");
		return xstreamForJsonWithRoot.toXML(object);
	}
}
