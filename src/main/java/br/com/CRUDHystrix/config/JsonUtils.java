package br.com.CRUDHystrix.config;

import javax.annotation.PostConstruct;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
@Configuration
public class JsonUtils {

	public static JSONArray logJson = new JSONArray();
	private static JSONObject objJson = new JSONObject();
	private static JSONArray rows = new JSONArray();
	
	@PostConstruct
	public static void init() throws JSONException {
		objJson.put("type", "table");
		logJson.put(objJson);
		JSONArray columns = new JSONArray();
		columns.put(new JSONObject().put("text", "Method").put("type", "string"));
		columns.put(new JSONObject().put("text", "Description").put("type", "string"));
		columns.put(new JSONObject().put("text", "Error").put("type", "string"));
		objJson.put("columns", columns);
		objJson.put("rows", rows);
	}
	public static JSONArray parseJsonObjectLog(String error, String descripiton, String method) throws JSONException {
		rows.put(new JSONArray().put(method).put(error).put(descripiton));		
		return logJson;
	}
	
}
