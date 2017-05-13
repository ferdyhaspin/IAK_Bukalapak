package blogspot.temukan_id.iak_bukalapak.util;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.io.IOException;
import java.util.List;

import blogspot.temukan_id.iak_bukalapak.pojo.Model_Produk;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by gm on 07/05/17.
 */

public class PostDataAsynctack extends AsyncTask<Void,Integer,String> {

    private Context context;
    private ProgressDialog dialog;
    private String username,password;

    public PostDataAsynctack(Context context,String username,String password) {
        this.context = context;
        this.username = username;
        this.password = password;
    }

    @Override
    protected void onPreExecute() {
        showProgress();
    }

    @Override
    protected String doInBackground(Void... voids) {
        OkHttpClient okHttpClient = new OkHttpClient();

        RequestBody formBody = new FormBody.Builder()
                .add("username", username)
                .add("password", password)
                .build();

        Request request = new Request.Builder()
                .url(Api.url)
                .post(formBody)
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

    @Override
    protected void onPostExecute(String s) {
        Toast.makeText(context, ""+s, Toast.LENGTH_SHORT).show();
        hideProgress();
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
