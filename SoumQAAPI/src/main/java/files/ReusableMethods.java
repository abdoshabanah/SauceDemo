package files;

import io.restassured.path.json.JsonPath;

public class ReusableMethods {

	
	public static JsonPath rewToJson(String getNewaddress) {
		
		JsonPath js_1 = new JsonPath(getNewaddress);
		return js_1;
	}
}
