package Services;

import Contracts.IWeatherService;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class WeatherService implements IWeatherService {
	
	String appID ="552f2ed7d4fba959c061080f49a5f445";
	String weather;
    @Override
    public String getCurrentWeather(String cityName) throws IOException, Exception {
    	
    	String uri ="https://api.openweathermap.org/data/2.5/weather?q="+cityName+"&appid=552f2ed7d4fba959c061080f49a5f445";
    	HttpClient client = HttpClient.newHttpClient();
    	HttpRequest request = HttpRequest.newBuilder().uri(URI.create(uri)).build();

    	HttpResponse<String> response =
    	      client.send(request, BodyHandlers.ofString());

    	return response.body();
    }

    @Override
    public String getCurrentWeather(int cityId) throws IOException, Exception {
    	String uri ="https://api.openweathermap.org/data/2.5/weather?id="+cityId+"&appid=552f2ed7d4fba959c061080f49a5f445";
    	HttpClient client = HttpClient.newHttpClient();
    	HttpRequest request = HttpRequest.newBuilder().uri(URI.create(uri)).build();

    	HttpResponse<String> response =
    	      client.send(request, BodyHandlers.ofString());

    	return response.body();
    }

    @Override
    public String getCurrentWeather(int latitude, int longitude) throws IOException, Exception {
    	String uri ="https://api.openweathermap.org/data/2.5/weather?lat="+latitude+"&lon="+longitude+"&appid=552f2ed7d4fba959c061080f49a5f445";
    	HttpClient client = HttpClient.newHttpClient();
    	HttpRequest request = HttpRequest.newBuilder().uri(URI.create(uri)).build();

    	HttpResponse<String> response =
    	      client.send(request, BodyHandlers.ofString());

    	return response.body();
    }

}