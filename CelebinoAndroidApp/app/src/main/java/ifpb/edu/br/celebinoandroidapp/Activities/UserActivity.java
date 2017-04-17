package ifpb.edu.br.celebinoandroidapp.Activities;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import ifpb.edu.br.celebinoandroidapp.Entities.Garden;
import ifpb.edu.br.celebinoandroidapp.Interfaces.ConnectionServer;
import ifpb.edu.br.celebinoandroidapp.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserActivity extends Activity {
    private List<Garden> gardenss = new ArrayList<>();
    private ArrayAdapter<Garden> adapter;
    private  List<Garden> gardens;
    private int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        ListView listGarden = (ListView) findViewById(R.id.listgarden);
        gardens = new ArrayList<Garden>();
        listar();
        adapter = new ArrayAdapter<Garden>(this, android.R.layout.simple_list_item_1, gardens);
        listGarden.setAdapter(adapter);

    }
    private void listar(){
        id = 1;
        new Thread(new Runnable() {
            @Override
            public void run() {
        Call<List<Garden>> call = ConnectionServer.getInstance().getService().getAllGardens();
        call.enqueue(new Callback<List<Garden>>() {
            @Override
            public void onResponse(Call<List<Garden>> call, Response<List<Garden>> response) {
                int returnedResponse = response.code();
                try{

                    if(response.isSuccess()){

                        List<Garden> responseGar = response.body();
                        gardens.addAll(responseGar);
                        for(Garden g : responseGar){
                            Log.i("GARDEN : ",g.toString());
                        }
                    }
                    else{

                        Log.e(this.getClass().toString(), "Error on calling  " );

                    }


                }
                catch (Exception e){

                    Log.e(this.getClass().toString(), "Error on calling");

                }
            }




            @Override
            public void onFailure(Call<List<Garden>> call, Throwable t) {
                call.cancel();
                Toast.makeText(UserActivity.this, "Error: "+ t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
            }
        }).start();

    }

}
