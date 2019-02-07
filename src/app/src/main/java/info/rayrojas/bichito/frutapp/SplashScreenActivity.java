package info.rayrojas.bichito.frutapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import info.rayrojas.bichito.frutapp.activities.LoginActivity;
import info.rayrojas.bichito.frutapp.activities.ProductListActivity;

public class SplashScreenActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent o = new Intent(this, ProductListActivity.class);
        startActivity(o);
        finish();
    }
}
