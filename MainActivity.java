package com.example.nitro5.myqrcodescanner;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static Button btnScan;
    public static TextView textResult;
    public static String pass ;
    public static ListView listView ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        btnScan = (Button)findViewById( R.id.btnScan );
        textResult = (TextView)findViewById( R.id.textResult );

        btnScan.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity( new Intent( getApplicationContext(),ScanQRcodeActivity.class ) );
            }
        } );
        textResult.setMovementMethod(new ScrollingMovementMethod());
    }
}
