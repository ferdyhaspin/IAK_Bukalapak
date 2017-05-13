package blogspot.temukan_id.iak_bukalapak.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import blogspot.temukan_id.iak_bukalapak.R;

public class DetailActivity extends AppCompatActivity {

    private TextView tvJudul,tvHarga,tvRate_count;
    private ImageView img;
    private RatingBar ratingBar;

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);


        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        tvJudul = (TextView) findViewById(R.id.tvJudul);
        tvHarga = (TextView) findViewById(R.id.tvHarga);
        tvRate_count = (TextView) findViewById(R.id.tvCount);
        img = (ImageView) findViewById(R.id.header_image);
        ratingBar = (RatingBar) findViewById(R.id.rtbProductRating);

        Intent intent = getIntent();

        // glide untuk ngambil image
        Glide.with(this).load(intent.getStringExtra("img"))
                .thumbnail(0.5f)
                .crossFade()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(img);

        tvJudul.setText(intent.getStringExtra("nama"));
        tvHarga.setText(intent.getStringExtra("harga"));
        ratingBar.setRating(Float.parseFloat(intent.getStringExtra("ranting_rate")));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                return true;
        }
        return false;
    }
}
