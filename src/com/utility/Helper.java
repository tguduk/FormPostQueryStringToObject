package com.utility;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Helper {
	public static <T> T getFormToObject(HttpServletRequest request,Class<T> clazz) throws UnsupportedEncodingException{
		request.setCharacterEncoding("UTF-8");
		String json=getFormToJson(request);
        GsonBuilder builder = new GsonBuilder();
        builder.setDateFormat("MM/dd/yy HH:mm:ss");
        Gson gson = builder.create(); 
		return gson.fromJson(json, clazz);
	}
	
	public static String   getFormToJson(HttpServletRequest request){
		List<String> tolist=new ArrayList<String>(request.getParameterMap().keySet());
		String json = "{";
		for(String key:tolist)
		   {
             if (!key.isEmpty() && key!=null)
             {
                 String item = "'" + key + "'" + ":" + "'" + request.getParameter(key) + "'" + ",";
                 json = json + item;
             }
         }
         json = json.substring(0,json.length() - 1);
         json = json + "}";
       
		
		return json;
	}


	
}
