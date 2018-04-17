package com.hebin.screenshoot;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.io.File;
import java.util.Random;

public class SplashActivity extends AppCompatActivity {

//    String path = Environment.getExternalStorageDirectory().getPath()+"/Images";
    String path = "/mnt/sdcard/Images/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


        final LinearLayout llRoot = (LinearLayout) findViewById(R.id.ll_root);
        Button print = (Button) findViewById(R.id.btn_print);

        final Random random = new Random();

        print.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int i = random.nextInt(9999);
                Toast.makeText(SplashActivity.this,"图片保存成功！！",Toast.LENGTH_SHORT).show();

                File file = new File(path);
                if (!file.exists()) {
                    file.mkdirs();
                }
                ScreenShoot.getViewBitmap(llRoot, path+i+".jpg");
            }
        });
    }
}
