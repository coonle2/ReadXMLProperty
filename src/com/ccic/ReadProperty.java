package com.ccic;

import org.apache.commons.lang.StringUtils;
import java.io.IOException;
import java.util.Iterator;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;


import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;




public class ReadProperty {
	 public static void main(String[] args) {
		//创建DocumentBuilderFactory对象  
        DocumentBuilderFactory a = DocumentBuilderFactory.newInstance();  
        try {  
            //创建DocumentBuilder对象  
            DocumentBuilder b = a.newDocumentBuilder();  
            //通过DocumentBuilder对象的parse方法返回一个Document对象  
            Document document = b.parse("src/com/ccic/ServiceConf.xml");  
            //通过Document对象的getElementsByTagName()返根节点的一个list集合  
            NodeList booklist = document.getElementsByTagName("service");  
            for(int i =0; i<booklist.getLength(); i++){
            	
                Element element = (Element)booklist.item(i);             
                Node endpointNode = element.getElementsByTagName("endpoint").item(0);
                Element  endpointElement =  (Element)endpointNode;               
//                System.out.println(element.getAttribute("name"));
//            	System.out.println(endpointElement.getAttribute("provider"));
            
//                if(element.getElementsByTagName("endpoint").item(0).getFirstChild() != null) {
//                	 System.out.println(element.getElementsByTagName("endpoint").item(0).getFirstChild().getNodeValue());
//                }
            	
                if(endpointElement.getAttribute("provider").equals("") 
                		&& element.getElementsByTagName("endpoint").item(0).getFirstChild() != null ) {
                    System.out.print(element.getAttribute("name")+"\t");               	
                	System.out.println(element.getElementsByTagName("endpoint").item(0).getFirstChild().getNodeValue());
                }
                 
               
              
            //   System.out.println( routes.getNodeName());
            }  
        } catch (ParserConfigurationException e) {  
            e.printStackTrace();  
        } catch (SAXException e) {  
            e.printStackTrace();  
        } catch (IOException e) {  
            e.printStackTrace();  
        }
	    
        
	 }

	  
}
