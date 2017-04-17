package ifpb.edu.br.celebinoandroidapp.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import ifpb.edu.br.celebinoandroidapp.Entities.Login;
import ifpb.edu.br.celebinoandroidapp.Entities.User;
import ifpb.edu.br.celebinoandroidapp.Interfaces.ConnectionServer;
import ifpb.edu.br.celebinoandroidapp.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SiginActivity extends AppCompatActivity {
    private EditText emailView;
    private EditText passwordView;
    private EditText usernameView;
    private EditText nameView;
    private String email;
    private String password;
    private String username;
    private String name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sigin);
        usernameView = (EditText) findViewById(R.id.usernameLabel);
        nameView = (EditText) findViewById(R.id.nameLabel);
        emailView = (EditText) findViewById(R.id.emailSg);
        passwordView = (EditText) findViewById(R.id.senhaSg);

        Button signUpButton = (Button)findViewById(R.id.siginButton);
        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                email = emailView.getText().toString();
                password = passwordView.getText().toString();
                name = nameView.getText().toString();
                username = usernameView.getText().toString();
                signUpProcessWithRetrofit(email, name,username,password);
            }
        });

    }


    private void signUpProcessWithRetrofit( String email, String name, String username, String password){

        User userObject = new User(email, name, username, password);
        Call<User> service = ConnectionServer.getInstance().getService().createUser(userObject);
        service.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                int returnedResponse = response.code();
                //showProgress(false);
                if(response.isSuccess()){
                    // redirect to Main Activity page
                    Toast.makeText(SiginActivity.this, "usuario cadastrado", Toast.LENGTH_LONG).show();
                    Intent siginIntent = new Intent(SiginActivity.this, LoginActivity.class);
                    startActivity(siginIntent);
                }
                if(returnedResponse == 404 || returnedResponse == 401 || returnedResponse == 400){
                    // use the registration button to register
                    Toast.makeText(SiginActivity.this, "error connection", Toast.LENGTH_LONG).show();
                }
            }
            @Override
            public void onFailure(Call<User> call, Throwable t) {
                call.cancel();
                Toast.makeText(SiginActivity.this, "Please check your network connection and internet permission", Toast.LENGTH_LONG).show();
            }
        });
    }
}
