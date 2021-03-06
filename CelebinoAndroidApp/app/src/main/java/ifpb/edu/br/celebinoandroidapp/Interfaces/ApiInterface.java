package ifpb.edu.br.celebinoandroidapp.Interfaces;

/**
 * Created by gabri on 15/04/2017.
 */

import java.util.List;

import ifpb.edu.br.celebinoandroidapp.Entities.Garden;
import ifpb.edu.br.celebinoandroidapp.Entities.GardenStatus;
import ifpb.edu.br.celebinoandroidapp.Entities.Login;
import ifpb.edu.br.celebinoandroidapp.Entities.User;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApiInterface {
    @POST("user/login")
    Call<User> login(@Body Login login);

    @GET("garden/user/{id}")
    Call<List<Garden>> getGardens(@Path("id") long id);

    @GET("garden/")
    Call<List<Garden>> getAllGardens();

    @POST("user/")
    Call<User> createUser(@Body User user);

    @GET("gardenstatus/garden/{gardenId}")
    Call<List<GardenStatus>> getAllGardensStatus(@Path("gardenId") long id);
}
