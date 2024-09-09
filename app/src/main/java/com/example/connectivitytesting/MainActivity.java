package com.example.connectivitytesting;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        Button button= findViewById(R.id.checkConnection);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkConnectivity()){
                    Toast.makeText(getApplicationContext(),"Internet is working",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext(),"No Internet connected",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    public boolean checkConnectivity(){
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        if(networkInfo == null){
            return false;
        }
        if(networkInfo.getType() == ConnectivityManager.TYPE_WIFI){
            Toast.makeText(this,"Wifi connected",Toast.LENGTH_SHORT).show();
        }
        if(networkInfo.getType() == ConnectivityManager.TYPE_MOBILE){
            Toast.makeText(this,"Mobile data connected",Toast.LENGTH_SHORT).show();
        }
        return networkInfo.isConnectedOrConnecting();
    }
}
