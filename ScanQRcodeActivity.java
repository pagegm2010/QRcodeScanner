package com.example.nitro5.myqrcodescanner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.google.zxing.Result;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import me.dm7.barcodescanner.zxing.ZXingScannerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ScanQRcodeActivity extends AppCompatActivity implements ZXingScannerView.ResultHandler {

    ZXingScannerView ScannerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        ScannerView = new ZXingScannerView( this );
        setContentView( ScannerView);
    }
    int t = 0;
    @Override
    public void handleResult(Result result) {

                t=Integer.parseInt(result.getText())  ;

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(MyInterface.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            MyInterface myInterface = retrofit.create(MyInterface.class);
            Call<List<Product>> call = myInterface.getProduct();
            call.enqueue(new Callback<List<Product>>() {
                @Override
                public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
                    List<Product> productList = response.body();
                    //Creating an String array for the ListView
                    //looping through all the customers and inserting the names inside the string array

                     String result1 = new String();
                    int a =0;
                    for (int i = 0; i < productList.size(); i++) {
                        a=productList.get(i).getId();
                      if(t==a){
                           result1 = "ชื่อยา : "+productList.get(i).getName().toString()+"\n"
                                 +"ส่วนประกอบของยา : "+productList.get(i).getIngredient().toString()+"\n"
                                 +"สรรพคุณของยา : "+productList.get(i).getProperties().toString()+"\n"
                                   +"วิธีรับประทาน : "+productList.get(i).getHowtoeat().toString()+"\n"
                                   +"วิธีเก็บรักษา : "+productList.get(i).getKeeping().toString()+"\n"
                                  +"คำเตือน : "+productList.get(i).getWarning().toString()+"\n";

                       }
                    }

                    Toast.makeText( getApplicationContext(),result1,Toast.LENGTH_LONG).show();
                   MainActivity.textResult.setText(result1 ); ;
                }
                @Override
                public void onFailure(Call<List<Product>> call, Throwable t) {
                    Toast.makeText(getApplicationContext(),
                            t.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });


        onBackPressed();
    }

    @Override
    protected void onPause() {
        super.onPause();
        ScannerView.stopCamera();
    }

    @Override
    protected void onResume() {
        super.onResume();

        ScannerView.setResultHandler( this );
        ScannerView.startCamera();
    }


}
