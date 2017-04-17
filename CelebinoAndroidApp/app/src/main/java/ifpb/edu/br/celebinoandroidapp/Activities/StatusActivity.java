package ifpb.edu.br.celebinoandroidapp.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import ifpb.edu.br.celebinoandroidapp.Entities.Garden;
import ifpb.edu.br.celebinoandroidapp.Entities.GardenStatus;
import ifpb.edu.br.celebinoandroidapp.Interfaces.ConnectionServer;
import ifpb.edu.br.celebinoandroidapp.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StatusActivity extends AppCompatActivity {
    private  List<GardenStatus> gardenS;
    private ArrayAdapter<GardenStatus> adapterr;
    private  ListView listGardenS;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status);
        listGardenS = (ListView) findViewById(R.id.listgardenS);
        gardenS = new ArrayList<GardenStatus>();
        Bundle extras = getIntent().getExtras();
        final long idg= extras.getLong("IDG");
        Log.e("ONCLICK : ","ops"+idg);
        listarS(idg);
    }

    private void listarS(long idg){

        Call<List<GardenStatus>> call = ConnectionServer.getInstance().getService().getAllGardensStatus(idg);
        call.enqueue(new Callback<List<GardenStatus>>() {
            @Override
            public void onResponse(Call<List<GardenStatus>> call, Response<List<GardenStatus>> response) {
                int returnedResponse = response.code();
                Log.e("STATUS",returnedResponse+" "+ response.body());
                try{

                    if(returnedResponse == 200){

                        List<GardenStatus> responseGarS = response.body();
                        Log.e("STATUS",responseGarS.toString());
                        gardenS.addAll(responseGarS);
                        setAdapter(gardenS);
                        Log.e("STATUS",gardenS.toString());
                    }
                    else{

                        Log.e(this.getClass().toString(), "Error on calling kkk " );

                    }


                }
                catch (Exception e){

                    Log.e(this.getClass().toString(), "Error on calling bbb "+ e);

                }
            }


            @Override
            public void onFailure(Call<List<GardenStatus>> call, Throwable t) {
                call.cancel();
                Toast.makeText(StatusActivity.this, "Error: "+ t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });

    }

    public  void setAdapter(List<GardenStatus> gardenS){
        adapterr = new ArrayAdapter<GardenStatus>(this, android.R.layout.simple_list_item_1, gardenS);
        listGardenS.setAdapter(adapterr);
    }
}
