package ifpb.edu.br.celebinoandroidapp.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import ifpb.edu.br.celebinoandroidapp.Classes.User;
import ifpb.edu.br.celebinoandroidapp.Interfaces.ApiInterface;
import ifpb.edu.br.celebinoandroidapp.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginActivity extends AppCompatActivity {
    public static final String BASE_URL = "";
    private EditText mEmailView;
    private EditText mPasswordView;
    private String email;
    private String password;
    private TextView failedLoginMessage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mEmailView = (EditText) findViewById(R.id.emailLabel);
        mPasswordView = (EditText) findViewById(R.id.senhaLabel);
        failedLoginMessage = (TextView)findViewById((R.id.failedLoginTextView));
        Button mLogInButton = (Button) findViewById(R.id.logInButton);
        mLogInButton.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View view) {
                failedLoginMessage.setText("");
                email = mEmailView.getText().toString();
                password = mPasswordView.getText().toString();
                loginProcessWithRetrofit(email, password);
            }
        });
        Button mSignUpButton = (Button)findViewById(R.id.signUpButton);
        mSignUpButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                email = mEmailView.getText().toString();
                password = mPasswordView.getText().toString();
                signUpProcessWithRetrofit(email, password);
            }
        });


    }
    private ApiInterface getInterfaceService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        final ApiInterface mInterfaceService = retrofit.create(ApiInterface.class);
        return mInterfaceService;
    }
    private void  loginProcessWithRetrofit(final String email, String password){
        ApiInterface mApiService = this.getInterfaceService();
        Call<User> mService = mApiService.authenticate(email, password);
        mService.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                int returnedResponse = response.code();
                Toast.makeText(LoginActivity.this, "Returned " + returnedResponse, Toast.LENGTH_LONG).show();
                //showProgress(false);
                if(returnedResponse == 200){
                    // redirect to Main Activity page
                    Intent loginIntent = new Intent(LoginActivity.this, UserActivity.class);
                    loginIntent.putExtra("EMAIL", email);
                    startActivity(loginIntent);
                }
                if(returnedResponse == 404 || returnedResponse == 401){
                    // use the registration button to register
                    failedLoginMessage.setText(getResources().getString(R.string.registration_message));
                    mPasswordView.requestFocus();
                }
            }
            @Override
            public void onFailure(Call<User> call, Throwable t) {
                call.cancel();
                Toast.makeText(LoginActivity.this, "Please check your network connection and internet permission", Toast.LENGTH_LONG).show();
            }
        });
    }
    private void signUpProcessWithRetrofit(final String email, String password){
        ApiInterface mApiService = this.getInterfaceService();
        Call<User> mService = mApiService.registration(email, password);
        mService.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                int returnedResponse = response.code();
                //showProgress(false);
                if(returnedResponse == 200){
                    // redirect to Main Activity page
                    Intent loginIntent = new Intent(LoginActivity.this, UserActivity.class);
                    loginIntent.putExtra("EMAIL", email);
                    startActivity(loginIntent);
                }
                if(returnedResponse == 404){
                    // use the registration button to register
                    failedLoginMessage.setText(getResources().getString(R.string.registration_failed));
                    mPasswordView.requestFocus();
                }
            }
            @Override
            public void onFailure(Call<User> call, Throwable t) {
                call.cancel();
                Toast.makeText(LoginActivity.this, "Please check your network connection and internet permission", Toast.LENGTH_LONG).show();
            }
        });
    }

}

