package com.wordnik.swagger.codegen.languages;

import io.swagger.parser.SwaggerParser;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.cli.BasicParser;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wordnik.swagger.codegen.CodegenConfig;
import com.wordnik.swagger.codegen.SupportingFile;
import com.wordnik.swagger.codegen.languages.JaxRSServerCodegen;
import com.wordnik.swagger.models.Swagger;

public class AgsJaxRSServerCodegen extends JaxRSServerCodegen {
	public String getName() {
		return "agsjaxrs";
	}

	public AgsJaxRSServerCodegen() {
		super();

	}

	public void init(CommandLine cmd) {
		super.init(cmd);
		String jsonFileName = null;
		jsonFileName = cmd.getOptionValue("i");

		String resourcePath = getResourcePathFromFile(jsonFileName);
		if (resourcePath == null) {
			resourcePath = "";
		} else if (resourcePath.length() > 0) {
			resourcePath = resourcePath.replace('"', ' ');
			resourcePath = resourcePath.trim();
			if (resourcePath.charAt(0) == '/') {
				resourcePath = resourcePath.substring(1);
			}

			resourcePath = resourcePath.replace('/', '.');
			resourcePath = "." + resourcePath;
		}
		
		apiPackage = "com.avon.ags.gen.api" + resourcePath.toLowerCase();
		modelPackage = "com.avon.ags.gen.model" + resourcePath.toLowerCase();
		templateDir = "agsJavaJaxRS";
		apiTemplateFiles.clear();
		apiTemplateFiles.put("api.mustache", ".java");
		apiTemplateFiles.put("api.interface.mustache", "Interface.java");
		apiTemplateFiles.put("api.stub.mustache", "STUB.java");
		
		
	    supportingFiles.clear();
	    //supportingFiles.add(new SupportingFile("pom.mustache", "", "pom.xml"));
	    //supportingFiles.add(new SupportingFile("README.mustache", "", "README.md"));
	    supportingFiles.add(new SupportingFile("ApiException.mustache", 
	      (sourceFolder + File.separator + apiPackage).replace(".", java.io.File.separator), "ApiException.java"));
	    supportingFiles.add(new SupportingFile("ApiOriginFilter.mustache", 
	      (sourceFolder + File.separator + apiPackage).replace(".", java.io.File.separator), "ApiOriginFilter.java"));
	    supportingFiles.add(new SupportingFile("ApiResponseMessage.mustache", 
	      (sourceFolder + File.separator + apiPackage).replace(".", java.io.File.separator), "ApiResponseMessage.java"));
	    supportingFiles.add(new SupportingFile("NotFoundException.mustache", 
	      (sourceFolder + File.separator + apiPackage).replace(".", java.io.File.separator), "NotFoundException.java"));
	    supportingFiles.add(new SupportingFile("BadRequestException.mustache", 
	  	      (sourceFolder + File.separator + apiPackage).replace(".", java.io.File.separator), "BadRequestException.java"));
	    supportingFiles.add(new SupportingFile("InternalServerErrorException.mustache", 
	  	      (sourceFolder + File.separator + apiPackage).replace(".", java.io.File.separator), "InternalServerErrorException.java"));
	    
//	    supportingFiles.add(new SupportingFile("web.mustache", 
//	      ("src/main/webapp/WEB-INF"), "web.xml"));

		try {
			Set<String> resourceNames = getResourceNames(jsonFileName);
			for (String resourceName : resourceNames) {
				FileUtils.writeStringToFile(new File(outputFolder + File.separator + sourceFolder + "/../resources/META-INF/services/" + apiPackage + "." + resourceName + "ApiInterface"), apiPackage + "." + resourceName + "ApiSTUB");
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	}
	
	private Set<String> getResourceNames(String jsonFileName) {
		Set<String> ret = new HashSet<String>();
		
		if (null != jsonFileName) {
			Swagger swagger = new SwaggerParser().read(jsonFileName);
			if (null != swagger) {
				for (String path: swagger.getPaths().keySet()) {
					ret.add(initialCaps(getBasePath(path)));
				}
			}
		}
		return ret;
	}
	
	private static String getBasePath(String path) {
		String basePath = path;
		if(path.startsWith("/"))
	    	basePath = path.substring(1);
	    int pos = basePath.indexOf("/");
	    if(pos > 0)
	    	return basePath.substring(0, pos);
	    else
	    	return (StringUtils.isEmpty(basePath) ? "default" : basePath);
	}
	
	private static String getResourcePathFromFile(String jsonFileName) {
		  if (jsonFileName == null)
		   return null;
		  ObjectMapper mapper = new ObjectMapper();
		  try {

		   JsonNode rootNode = mapper.readValue(new File(jsonFileName),
		     JsonNode.class); // src can be a File, URL, InputStream etc
		   if(rootNode.get("resourcePath")!=null)
		    return rootNode.get("resourcePath").toString();
		   if(rootNode.get("info")!=null){
		    JsonNode x=rootNode.get("info").get("title");
		    if(x!=null){
		     return x.toString().trim().replaceAll(" ", "");
		    }
		   }
		   return "generic";

		  } catch (Throwable e) {

		   e.printStackTrace();

		  }

		  return null;
		 }

}
