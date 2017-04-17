package ifpb.edu.br.celebinoandroidapp.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import ifpb.edu.br.celebinoandroidapp.R;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_splash_screen);
        Thread thread = new Thread(){
            @Override
            public void run() {
                try {
                    sleep(2000);
                    Intent intent = new Intent(SplashScreen.this, LoginActivity.class);
                    startActivity(intent);
                    finish();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        thread.start();
    }
}
