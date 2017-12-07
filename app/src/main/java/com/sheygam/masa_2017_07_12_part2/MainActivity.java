package com.sheygam.masa_2017_07_12_part2;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        img = findViewById(R.id.my_img);
        String  url = "http://google.com";
        Uri uri = Uri.parse(url);
        final Intent intent = new Intent();
        intent.setData(uri);
        intent.setAction(Intent.ACTION_VIEW);
        findViewById(R.id.show_link_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);
            }
        });


        findViewById(R.id.market_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri1 = Uri.parse("market://details?id=com.nekki.shadowfight3");
                Intent intent1 = new Intent(Intent.ACTION_VIEW,uri1);
                startActivity(intent1);
            }
        });

        findViewById(R.id.call_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri1 = Uri.parse("tel:0555555555");
                Intent intent1 = new Intent(Intent.ACTION_DIAL,uri1);
                startActivity(intent1);
            }
        });

        findViewById(R.id.start_app_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = getPackageManager().getLaunchIntentForPackage("com.sheygam.masa_2017_07_12");
                Log.d("MY_TAG", "onClick: " + intent1.getAction());
//                Log.d("MY_TAG", "onClick: ");
                startActivity(intent1);
            }
        });

        findViewById(R.id.send_main_action_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent("telran.start.main.activity");
                startActivity(intent1);
            }
        });

        findViewById(R.id.myuri_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(Intent.ACTION_VIEW);
                Uri uri1 = Uri.parse("myuri://?name=vasya&age=23");
                intent1.setData(uri1);
                startActivity(intent1);
            }
        });

        findViewById(R.id.pick_img_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent();
                intent1.setAction(Intent.ACTION_PICK);
                intent1.setType("image/*");
                startActivityForResult(intent1,1);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK && requestCode == 1){
            Log.d("MY_TAG", "onActivityResult: " + data.getData());
            img.setImageURI(data.getData());
        }
    }
}
