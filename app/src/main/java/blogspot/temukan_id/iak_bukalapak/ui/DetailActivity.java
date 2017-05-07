package blogspot.temukan_id.iak_bukalapak.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import blogspot.temukan_id.iak_bukalapak.R;

public class DetailActivity extends AppCompatActivity {

    private TextView tvJudul,tvHarga,tvRate_count;
    private ImageView img;
    private RatingBar ratingBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        tvJudul = (TextView) findViewById(R.id.tvJudul);
        tvHarga = (TextView) findViewById(R.id.tvHarga);
        tvRate_count = (TextView) findViewById(R.id.tvCount);
        img = (ImageView) findViewById(R.id.header_image);
        ratingBar = (RatingBar) findViewById(R.id.rtbProductRating);

        Intent intent = getIntent();

        tvJudul.setText(intent.getStringExtra("nama"));
        tvHarga.setText(intent.getStringExtra("harga"));
        ratingBar.setRating(Float.parseFloat(intent.getStringExtra("ranting_rate")));
    }
}
