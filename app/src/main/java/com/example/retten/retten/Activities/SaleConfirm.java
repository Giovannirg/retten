package com.example.retten.retten.Activities;

import android.content.DialogInterface;
import android.content.pm.ActivityInfo;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.retten.retten.Helpers.GraphicOverlay;
import com.example.retten.retten.Helpers.RectOverlay;
import com.example.retten.retten.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.ml.vision.FirebaseVision;
import com.google.firebase.ml.vision.barcode.FirebaseVisionBarcode;
import com.google.firebase.ml.vision.barcode.FirebaseVisionBarcodeDetector;
import com.google.firebase.ml.vision.barcode.FirebaseVisionBarcodeDetectorOptions;
import com.google.firebase.ml.vision.common.FirebaseVisionImage;
import com.wonderkiln.camerakit.CameraKitError;
import com.wonderkiln.camerakit.CameraKitEvent;
import com.wonderkiln.camerakit.CameraKitEventListener;
import com.wonderkiln.camerakit.CameraKitImage;
import com.wonderkiln.camerakit.CameraKitVideo;
import com.wonderkiln.camerakit.CameraView;

import java.util.List;

import dmax.dialog.SpotsDialog;

public class SaleConfirm extends AppCompatActivity {

    CameraView cameraView;
    Button btnDetect;
    android.app.AlertDialog waitingDialog;
    GraphicOverlay graphicOverlay;


    @Override
    protected void onResume() {
        super.onResume();
        cameraView.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        cameraView.stop();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sale_confirm);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        graphicOverlay = (GraphicOverlay) findViewById(R.id.graphic_overlay);
        cameraView = (CameraView) findViewById(R.id.cameraview);
        btnDetect = (Button) findViewById(R.id.btn_detect);
        waitingDialog = new SpotsDialog.Builder()
                .setContext(this)
                .setMessage("Bitte warten Sie")
                .setCancelable(false)
                .build();

        btnDetect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cameraView.start();
                cameraView.captureImage();
                graphicOverlay.clear();

            }
        });

        cameraView.addCameraKitListener(new CameraKitEventListener() {
            @Override
            public void onEvent(CameraKitEvent cameraKitEvent) {

            }

            @Override
            public void onError(CameraKitError cameraKitError) {

            }

            @Override
            public void onImage(CameraKitImage cameraKitImage) {
                waitingDialog.show();
                Bitmap bitmap = cameraKitImage.getBitmap();
                bitmap = Bitmap.createScaledBitmap(bitmap,cameraView.getWidth(),cameraView.getHeight(), false);
                cameraView.stop();

                runDetector(bitmap);
            }

            @Override
            public void onVideo(CameraKitVideo cameraKitVideo) {


            }


        });


    }

    private void runDetector(Bitmap bitmap) {

        FirebaseVisionImage image = FirebaseVisionImage.fromBitmap(bitmap);
        FirebaseVisionBarcodeDetectorOptions options = new FirebaseVisionBarcodeDetectorOptions.Builder()
                .setBarcodeFormats(
                        FirebaseVisionBarcode.FORMAT_QR_CODE,
                        FirebaseVisionBarcode.FORMAT_PDF417

                )
                .build();

        FirebaseVisionBarcodeDetector detector = FirebaseVision.getInstance().getVisionBarcodeDetector(options);

        detector.detectInImage(image)
                .addOnSuccessListener(new OnSuccessListener<List<FirebaseVisionBarcode>>() {
                    @Override
                    public void onSuccess(List<FirebaseVisionBarcode> firebaseVisionBarcodes) {
                        processResult(firebaseVisionBarcodes);
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(SaleConfirm.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });

    }

    private void processResult(List<FirebaseVisionBarcode> firebaseVisionBarcodes) {
        for (FirebaseVisionBarcode item : firebaseVisionBarcodes) {
            //Recteck zeichen

            Rect rectBounds = item.getBoundingBox();
            RectOverlay rectOverlay = new RectOverlay(graphicOverlay,rectBounds);
            graphicOverlay.add(rectOverlay);



            int value_type = item.getValueType();
            switch (value_type) {
                case FirebaseVisionBarcode.TYPE_TEXT: {
                    android.support.v7.app.AlertDialog.Builder builder = new android.support.v7.app.AlertDialog.Builder(this);
                    builder.setMessage(item.getRawValue());
                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int i) {
                            dialog.dismiss();
                        }
                    });
                    android.support.v7.app.AlertDialog dialog = builder.create();
                    dialog.show();
                }
                break;

                case FirebaseVisionBarcode.TYPE_PRODUCT: {
                    String info = new StringBuilder("Name: ")
                            .append(item.getContactInfo().getName().getFormattedName())
                            .append("\n")
                            .append("Sell Code")
                            .append(item.getContactInfo().getAddresses())//Muss checken wie es wäre für produkt
                            .toString();
                    android.support.v7.app.AlertDialog.Builder builder = new android.support.v7.app.AlertDialog.Builder(this);
                    builder.setMessage(item.getRawValue());

                }


                default:
                    break;
            }

        }
        waitingDialog.dismiss();
    }

}



