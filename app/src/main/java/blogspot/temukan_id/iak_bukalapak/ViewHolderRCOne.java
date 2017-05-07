package blogspot.temukan_id.iak_bukalapak;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

/**
 * Created by gm on 05/05/17.
 */

public class ViewHolderRCOne extends RecyclerView.ViewHolder{

    public TextView tvJudul,tvSeller,tvFeedback,tvHarga,tvCount;
    public ImageView img;
    public RatingBar ratingBar;
    public LinearLayout container;

    public ViewHolderRCOne(View itemView) {
        super(itemView);

        tvJudul = (TextView) itemView.findViewById(R.id.tvJudul);
        tvSeller = (TextView) itemView.findViewById(R.id.tvSeller);
        tvFeedback = (TextView) itemView.findViewById(R.id.tvFeedback);
        tvHarga = (TextView) itemView.findViewById(R.id.tvHarga);
        img  = (ImageView) itemView.findViewById(R.id.img);
        ratingBar = (RatingBar) itemView.findViewById(R.id.rtbProductRating);
        tvCount = (TextView) itemView.findViewById(R.id.tvCount);
        container = (LinearLayout) itemView.findViewById(R.id.container);
    }
}
