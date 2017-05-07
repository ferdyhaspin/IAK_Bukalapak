package blogspot.temukan_id.iak_bukalapak.pojo;

import blogspot.temukan_id.iak_bukalapak.util.Api;

/**
 * Created by gm on 30/04/17.
 */

public class Model_Produk{
    private int id;
    private String nama;
    private long harga;
    private String saller;
    private String feedback;
    private String rating_rate;
    private long rating_count;
    private String img;

    public String getRating_rate() {
        return rating_rate;
    }

    public void setRating_rate(String rating_rate) {
        this.rating_rate = rating_rate;
    }

    public long getRating_count() {
        return rating_count;
    }

    public void setRating_count(long rating_count) {
        this.rating_count = rating_count;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public long getHarga() {
        return harga;
    }

    public void setHarga(long harga) {
        this.harga = harga;
    }

    public String getSaller() {
        return saller;
    }

    public void setSaller(String saller) {
        this.saller = saller;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }
}
