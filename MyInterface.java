package com.example.nitro5.myqrcodescanner;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MyInterface {
    String BASE_URL = "http://192.168.1.182:8080/";
    @GET("jame/get_medicine.php")
    Call<List<Product>> getProduct();


}
