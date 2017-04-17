package ifpb.edu.br.celebinoandroidapp.Activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
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
import retrofit2.http.Path;

public class UserActivity extends Activity {
    private List<Garden> gardenss = new ArrayList<>();
    private ArrayAdapter<Garden> adapter;
    private  List<Garden> gardens;
    private  ListView listGarden;
    private int iduser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        listGarden = (ListView) findViewById(R.id.listgarden);
        gardens = new ArrayList<Garden>();

        Bundle extras = getIntent().getExtras();
        final long iduser = extras.getLong("ID");
        listar(iduser);

        listGarden.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapter, View v, int position,
                                    long arg3)
            {

                Garden gard = (Garden) listGarden.getItemAtPosition(position);
                long idg = gard.getId();
                Intent statusIntent = new Intent(UserActivity.this, StatusActivity.class);

                statusIntent.putExtra("IDG", idg);
                startActivity(statusIntent);
                Log.e("ONCLICK : ",gard.getId().toString());

            }
        });

    }
    private void listar(long id){

        Call<List<Garden>> call = ConnectionServer.getInstance().getService().getGardens(id);
        call.enqueue(new Callback<List<Garden>>() {
            @Override
            public void onResponse(Call<List<Garden>> call, Response<List<Garden>> response) {
                int returnedResponse = response.code();
                try{

                    if(response.isSuccess()){

                        List<Garden> responseGar = response.body();
                        Log.e("STATUS",responseGar.toString());
                        gardens.addAll(responseGar);
                        setAdapter(gardens);

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

    public  void setAdapter(List<Garden> gardens){
        adapter = new ArrayAdapter<Garden>(this, android.R.layout.simple_list_item_1, gardens);
        listGarden.setAdapter(adapter);
    }


}
