package ifpb.edu.br.celebinoandroidapp.Interfaces;

/**
 * Created by gabri on 15/04/2017.
 */

import ifpb.edu.br.celebinoandroidapp.Classes.User;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
public interface ApiInterface {
    @GET("api/{email}/{password}")
    Call<User> authenticate(@Path("email") String email, @Path("password") String password);
    @POST("api/{email}/{password}")
    Call<User> registration(@Path("email") String email, @Path("password") String password);
}
