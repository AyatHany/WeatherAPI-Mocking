package Services;

import java.io.IOException;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import Contracts.IJsonService;
import Contracts.IWeatherService;

public class ApplicationService {
    private IWeatherService weatherService;
    private IJsonService jsonService;
    JsonObject json = new JsonObject();
    String response=null;
    WeatherService w;
    public ApplicationService(IWeatherService wService, IJsonService jService) {
        weatherService = wService;
        jsonService = jService;
    }

    public String getCurrentWeather(String cityName) throws IOException, Exception {
    	String obj = weatherService.getCurrentWeather(cityName);
    	Result response = new Gson().fromJson(obj,Result.class);
    	if(cityName==null || cityName=="") {
    		return "invalid input";
    	}
    	else {
    		if(response.cod=="404") {
    			return "invalid response";
    		}
    		else {
    			List w=(List) response.weather;
    			String e=w.get(0).toString();
    			/*Weather weather = new Gson().fromJson(e,Weather.class);
    			String r=weather.id.toString();
    			System.out.println(r);*/
    			String q=response.main.toString();
    			Main main=new Gson().fromJson(q,Main.class);
    			String result ="Temp : " + main.temp + '\n'+ "Weather Details : " + e;
    			return result;
    			}
    	
    	}
    }}
        // early exits if any
        // invoke weatherService method with cityName
        // check response for errors and if so early exit
        // parse response from weatherService using jsonService
        // return appropriate response
        //return null;


/*String json = "{\"name\": \"Bob\", \"id\": \"123\"}";

//Method 1: parsing into a JSON element
JsonObject jsonObject = new JsonParser().parse(json).getAsJsonObject();
System.out.println(jsonObject.get("name").getAsString());

//Method 2: parsing into a Java Object
User user = new Gson().fromJson(json, User.class);
System.out.println(user.id);*/
