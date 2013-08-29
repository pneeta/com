package comcast.test.config.configServices.utils;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

import org.apache.http.client.methods.HttpGet;
import org.xml.sax.SAXException;

public class DomParserXPATH 
{

	public static String  getCategories(String url) throws XPathExpressionException, ParserConfigurationException, SAXException, IOException
	{
		
		String response =null;
		HttpGet get = new HttpGet(url);
		get.setHeader("Content-Type", "application/json");
		get.setHeader("Accept", "application/json;fields=data+counts");
		try
		{
			RestServiceUtil restApi=new RestServiceUtil();
			response = restApi.executeHTTPGet(get);
			System.out.println("Getting Response>>>>>>>"+response);
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
		return response;
	}
		
	
}
