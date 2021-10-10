package com.example.lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

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
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_CANCELED) return;
        //Getting the Avatar Image we show to our users
        ImageView avatarImage = (ImageView) findViewById(R.id.logo);
        //Figuring out the correct image
        String drawableName = "ic_logo_00";
        switch (data.getIntExtra("imageID", R.id.logo)) {
            case R.id.logo000:
                drawableName = "ic_logo_00";
                break;
            case R.id.logo001:
                drawableName = "ic_logo_01";
                break;
            case R.id.logo002:
                drawableName = "ic_logo_02";
                break;
            case R.id.logo003:
                drawableName = "ic_logo_03";
                break;
            case R.id.logo004:
                drawableName = "ic_logo_04";
                break;
            case R.id.logo005:
                drawableName = "ic_logo_05";
                break;
            default:
                drawableName = "ic_logo_00";
                break;
        }
        int resID = getResources().getIdentifier(drawableName, "drawable",
                getPackageName());
        avatarImage.setImageResource(resID);
    }
}