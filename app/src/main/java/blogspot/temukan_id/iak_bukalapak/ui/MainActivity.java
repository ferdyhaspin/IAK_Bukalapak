package blogspot.temukan_id.iak_bukalapak.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

import blogspot.temukan_id.iak_bukalapak.GetDataAsynctack;
import blogspot.temukan_id.iak_bukalapak.R;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private RecyclerView recyclerView;
    private Button btnAll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //toolbar
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");

        //recyclerview
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));

        new GetDataAsynctack(this,recyclerView).execute();
        // button
        btnAll = (Button) findViewById(R.id.btnAll);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.i_keranjang:
                Toast.makeText(this, "Keranjang", Toast.LENGTH_SHORT).show();
                return true;
        }
        return false;
    }

    //asynctack mengambil data produk
    /*KerjakanBackgroundTask x = new KerjakanBackgroundTask(this,recyclerView);
    x.execute();*/
}
