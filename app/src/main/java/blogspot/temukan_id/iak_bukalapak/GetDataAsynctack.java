package blogspot.temukan_id.iak_bukalapak;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Looper;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import blogspot.temukan_id.iak_bukalapak.pojo.Model_Produk;
import blogspot.temukan_id.iak_bukalapak.util.Api;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by gm on 05/05/17.
 */

public class GetDataAsynctack extends AsyncTask<Void, Integer, String> {

    private Context context;
    private ProgressDialog dialog;
    private List<Model_Produk> list;
    private RecyclerView recyclerview;

    public GetDataAsynctack(Context context, RecyclerView recyclerview) {
        this.context = context;
        this.recyclerview = recyclerview;
        list = new ArrayList<>();
    }

    /**
     * Sebelum Proses
     */
    @Override
    protected void onPreExecute() {
        showProgress();
    }

    /**
     * Proses
     */
    @Override
    protected String doInBackground(Void... voids) {

        OkHttpClient okHttpClient = new OkHttpClient();

        Request request = new Request.Builder()
                .url(Api.url)
                .get()
                .build();

        Response response;


        try {

            response = okHttpClient.newCall(request).execute();
            return response.body().string();

        } catch (IOException e) {
            e.printStackTrace();
        }


        return null;
    }

    /**
     * Selesai , Sesudah Proses
     */
    @Override
    protected void onPostExecute(String response) {
        hideProgress();
        if (!(response == null)) {
            try {
                JSONObject jsonObject = new JSONObject(response);

                JSONArray products = jsonObject.getJSONArray("products");

                // mengambil json data produk
                for (int i = 0; i < products.length(); i++) {
                    JSONObject object = products.getJSONObject(i);

                    Log.e("nama produk", object.getString("name"));

                    Model_Produk x = new Model_Produk();
                    x.setNama(object.getString("name"));
                    x.setHarga(object.getLong("price"));
                    x.setSaller(object.getString("seller_name"));
                    x.setFeedback("93% (" + object.getLong("seller_positive_feedback") + " feedback)");

                    // mengambil json array image produk
                    JSONArray objectImg = object.getJSONArray("images");

                    x.setImg(objectImg.get(0).toString());

                    //mengambil ranting
                    JSONObject objectRanting = object.getJSONObject("rating");

                    x.setRating_rate(objectRanting.getString("average_rate"));
                    x.setRating_count(objectRanting.getLong("user_count"));

                    // add data pojo model_produk ke list
                    list.add(x);
                }

                recyclerview.setAdapter(new AdapterRCOne(context, list));

            } catch (JSONException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            Toast.makeText(context, "Response Null", Toast.LENGTH_SHORT).show();
        }

    }

    public void showProgress() {
        dialog = new ProgressDialog(context);
        dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        dialog.setMessage("Loading. Please Wait...");
        dialog.setIndeterminate(true);
        dialog.setCanceledOnTouchOutside(false);
        dialog.show();
    }

    public void hideProgress() {
        dialog.dismiss();
    }
}
