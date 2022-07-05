package Contracts;

import java.io.IOException;
import java.net.MalformedURLException;

public interface IWeatherService {
	public static final String weather = "";
    public String getCurrentWeather(String cityName) throws IOException, Exception;

    public String getCurrentWeather(int cityId) throws IOException, Exception;

    public String getCurrentWeather(int latitude, int longitude) throws IOException, Exception;
}
