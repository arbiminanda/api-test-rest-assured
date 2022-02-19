package payload;

import org.json.simple.JSONObject;
import java.util.Random;

public class createMockUpAPIdata {
	
	Random rand = new Random();
	
	public JSONObject createMockUpAPI(){
        JSONObject data = new JSONObject();
        data.put("status", 200);
        data.put("content", "{\n \"prefix\": \"PT\",\n \"name\": \""+ "Create Automation " + rand.nextInt(100) + "\",\n \"suffix\": \"Tbk\",\n \"industry_id\": \"" + rand.nextInt(10) + "\",\n \"employee_size\": \"" + rand.nextInt(100) + "\",\n \"street\": \"Jl.Sudirman kav. " + rand.nextInt(100) + "\",\n \"place\": \"Sudirman Tower\",\n \"geograph_id\": " + rand.nextInt(100) + ",\n \"phone\": \"0856129009 " + rand.nextInt(100) + "\",\n}");
        data.put("content_type", "application/json");
        data.put("charset", "UTF-8");
        data.put("secret", "qzB8VqPQI3TPPtOm4Z226F7jyfIeslIFg3Cm");
        data.put("expiration", "never");
        return data;
    }
}
