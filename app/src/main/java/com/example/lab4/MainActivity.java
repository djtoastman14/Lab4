package com.example.lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void OnOpenGoogleMaps(View view) {

        EditText zipCode = (EditText)findViewById(R.id.zipCode);
        Uri gmmIntentUri = Uri.parse("https://maps.google.co.in/maps?q="+zipCode.getText());
        Intent mapIntent = new Intent(Intent.ACTION_VIEW,gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        startActivity(mapIntent);
    }

    public void OnSetAvatarButton(View view) {
        Intent inten = new Intent(getApplicationContext(), ProfileActivity.class);
        startActivityForResult(inten,0);
    }
}