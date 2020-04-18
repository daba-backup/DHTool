package com.daxie.tool;

import java.io.File;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;

/**
 * Methods to handle XML.
 * @author Daba
 *
 */
public class XMLFunctions {
	private static Logger logger=LoggerFactory.getLogger(XMLFunctions.class);
	
	/**
	 * Creates a XML file.
	 * @param file File
	 * @param document org.w3c.dom.Document
	 * @return -1 on error and 0 on success
	 */
	public static int WriteXML(File file,Document document) {
		Transformer transformer=null;
		try {
			TransformerFactory factory=TransformerFactory.newInstance();
			transformer=factory.newTransformer();
		}
		catch(TransformerConfigurationException e) {
			logger.error("Error during configuration for XML output.",e);
			return -1;
		}
		
		transformer.setOutputProperty("indent", "yes");
		transformer.setOutputProperty("encoding", "UTF-8");
		
		try {
			transformer.transform(new DOMSource(document), new StreamResult(file));
		}
		catch(TransformerException e) {
			logger.error("Error while writing.",e);
			return -1;
		}
		
		return 0;
	}
}
