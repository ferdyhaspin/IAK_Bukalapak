package blogspot.temukan_id.iak_bukalapak;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.List;

import blogspot.temukan_id.iak_bukalapak.pojo.Model_Produk;
import blogspot.temukan_id.iak_bukalapak.ui.DetailActivity;

/**
 * Created by gm on 30/04/17.
 */

public class AdapterRCOne extends RecyclerView.Adapter {

    private Context context;
    private List<Model_Produk> list_produk;
    private ViewHolderRCOne holderRCOne;

    public AdapterRCOne(Context context, List<Model_Produk> list_produk) {
        this.context = context;
        this.list_produk = list_produk;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.row_item_rcone,parent,false);
        return holderRCOne = new ViewHolderRCOne(v);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        holderRCOne.tvJudul.setText(list_produk.get(position).getNama());
        holderRCOne.tvSeller.setText(list_produk.get(position).getSaller());
        holderRCOne.tvFeedback.setText(list_produk.get(position).getFeedback());
        holderRCOne.ratingBar.setRating(Float.parseFloat(list_produk.get(position).getRating_rate()));
        holderRCOne.tvCount.setText("("+list_produk.get(position).getRating_count()+")");
        holderRCOne.tvHarga.setText("RP"+String.valueOf(list_produk.get(position).getHarga()));

        Glide.with(context).load(list_produk.get(position).getImg())
                .thumbnail(0.5f)
                .crossFade()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holderRCOne.img);

        holderRCOne.container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context,DetailActivity.class);
                i.putExtra("nama",list_produk.get(position).getNama());
                i.putExtra("img" , list_produk.get(position).getImg());
                i.putExtra("ranting_rate",list_produk.get(position).getRating_rate());
                i.putExtra("ranting_count",list_produk.get(position).getRating_count());
                i.putExtra("harga","RP"+list_produk.get(position).getHarga());
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list_produk.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }
}
