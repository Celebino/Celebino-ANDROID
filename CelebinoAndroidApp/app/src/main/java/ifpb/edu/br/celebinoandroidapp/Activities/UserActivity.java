package ifpb.edu.br.celebinoandroidapp.Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;
import ifpb.edu.br.celebinoandroidapp.R;

public class UserActivity extends AppCompatActivity {
    private ListView listGarden;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        listGarden = (ListView) findViewById(R.id.listgarden);
        //ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, LISTANOME);
    }
}
