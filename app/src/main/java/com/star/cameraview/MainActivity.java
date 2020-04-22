package com.star.cameraview;

import android.Manifest;
import android.graphics.Bitmap;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.star.camera.JCameraView;
import com.star.camera.listener.ClickListener;
import com.star.camera.listener.JCameraListener;

public class MainActivity extends AppCompatActivity {

    private JCameraView cameraView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestPermissions(new String[]{
                Manifest.permission.CAMERA,
                Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.RECORD_AUDIO}, 0);
        setContentView(R.layout.activity_main);
        cameraView = findViewById(R.id.cameraView);
        cameraView.setFeatures(JCameraView.BUTTON_STATE_BOTH);
        cameraView.setLeftClickListener(new ClickListener() {
            @Override
            public void onClick() {
                finish();
            }
        });
        cameraView.setJCameraLisenter(new JCameraListener() {
            @Override
            public void captureSuccess(Bitmap bitmap) {

            }

            @Override
            public void recordSuccess(String url, Bitmap firstFrame) {

            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        cameraView.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        cameraView.onPause();
    }
}
