import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import Contracts.IWeatherService;
import Services.ApplicationService;
import Services.GsonService;
import Services.WeatherService;

public class App {
    IWeatherService obj=new WeatherService();
    /*public String getCurrentWeather(String cityName) throws IOException, Exception {
    	
    	String uri ="https://api.openweathermap.org/data/2.5/weather?q="+cityName+"&appid=552f2ed7d4fba959c061080f49a5f445";
    	HttpClient client = HttpClient.newHttpClient();
    	HttpRequest request = HttpRequest.newBuilder().uri(URI.create(uri)).build();

    	HttpResponse<String> response =
    	      client.send(request, BodyHandlers.ofString());

    	return response.body();
    }*/
    public static void main(String[] args) throws Exception {
        var application = new ApplicationService(new WeatherService(), new GsonService());
        System.out.println(application.getCurrentWeather("London"));
       
    }
 
}
