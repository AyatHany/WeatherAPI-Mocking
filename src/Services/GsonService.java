package Services;

import com.google.gson.Gson;
import com.google.gson.JsonNull;
import com.google.gson.internal.Primitives;

import Contracts.IJsonService;

public class GsonService implements IJsonService {
    private static Gson gson = new Gson();

    @Override
    public <T> T fromJson(String jsonString, Class<T> classOfT) {
    	Object object = fromJson(jsonString, classOfT);
        return Primitives.wrap(classOfT).cast(object);

    }

    @Override
    public String toJson(Object object) {
        if(object ==null) {
        	return toJson(JsonNull.INSTANCE);
        }
        return toJson(object.getClass());
    }

}
