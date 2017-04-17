package ifpb.edu.br.celebinoandroidapp.Interfaces;


import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
/**
 * Created by Ferrão on 16/04/2017.
 */


public class ConnectionServer {

    private static final String URL_BASES =

            "http://192.168.1.9:8080/Celebino/";


    private static ApiInterface service;
    private static ConnectionServer ourInstance = new ConnectionServer();

    public static ConnectionServer getInstance() {
        return ourInstance;
    }

    public ApiInterface getService() {
        return service;
    }

    private ConnectionServer() {
        updateServiceAdress();
    }

    public void updateServiceAdress() {


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL_BASES)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        service = retrofit.create(ApiInterface.class);
    }

}