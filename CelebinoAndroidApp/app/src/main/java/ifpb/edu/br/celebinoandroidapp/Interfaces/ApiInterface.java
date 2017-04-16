package ifpb.edu.br.celebinoandroidapp.Interfaces;

/**
 * Created by gabri on 15/04/2017.
 */

import ifpb.edu.br.celebinoandroidapp.Entities.Login;
import ifpb.edu.br.celebinoandroidapp.Entities.User;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
public interface ApiInterface {
    @POST("user/login")
    Call<User> login(@Body Login login);
    @POST("user/logi")
    Call<User> registration(@Body Login login);
}
