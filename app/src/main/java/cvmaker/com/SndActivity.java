package cvmaker.com;


import androidx.core.app.ActivityCompat;
import androidx.databinding.DataBindingUtil;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.pdf.PdfDocument;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.github.dhaval2404.imagepicker.ImagePicker;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import cvmaker.com.databinding.ActivitySndBinding;

public class SndActivity extends Baseactivity {
    ActivitySndBinding binding;
    Bitmap bitmap;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_snd);

        saveDataToView();
        binding.ok.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImagePicker.with(SndActivity.this)
                        .crop()                    //Crop image(Optional), Check Customization for more option
                        .compress(512)            //Final image size will be less than 1 MB(Optional)
                        .maxResultSize(512, 512)    //Final image resolution will be less than 1080 x 1080(Optional)
                        .start();
            }
        });

        savePdf();

    }

    private void saveDataToView() {
        Intent intent = getIntent();
        binding.ok.nameTv.setText("Resume Of " + intent.getStringExtra("name"));
         binding.ok.address.setText("" + intent.getStringExtra("name") + "\n" + getIntent().getStringExtra("address") + "\n" + getIntent().getStringExtra("mail") + "\n" + getIntent().getStringExtra("phone"));
        binding.ok.objective.setText("" + intent.getStringExtra("objective"));


        binding.ok.graduation.setText(": " + intent.getStringExtra("graduation"));
        binding.ok.bscGpa.setText(": " + intent.getStringExtra("bscgpa"));
        binding.ok.bscDept.setText(": " + intent.getStringExtra("bscdepartment"));
        binding.ok.university.setText(": " + intent.getStringExtra("university"));

        binding.ok.collegeName.setText(": " + intent.getStringExtra("collegeName"));
        binding.ok.hscDept.setText(": " + intent.getStringExtra("hscDept"));
        binding.ok.hscPassingYear.setText(": " + intent.getStringExtra("hscPassingYear"));
        binding.ok.hscBoard.setText(": " + intent.getStringExtra("hscBoard"));
        binding.ok.hscGpa.setText(": " + intent.getStringExtra("hscGpa"));

        binding.ok.schoolName.setText(": " + intent.getStringExtra("schoolName"));
        binding.ok.sscDept.setText(": " + intent.getStringExtra("sscDept"));
        binding.ok.sscPassingYear.setText(": " + intent.getStringExtra("sscPassingYear"));
        binding.ok.sscBoard.setText(": " + intent.getStringExtra("sscBoard"));
        binding.ok.sscGpa.setText(": " + intent.getStringExtra("sscGpa"));

        binding.ok.skillTv.setText("" + intent.getStringExtra("skill"));
    /*    Bitmap image = (Bitmap) intent.getParcelableExtra("bitmap");
        binding.ok.imageView.setImageBitmap(image);*/


    }

    private void savePdf() {
        binding.save.setOnClickListener(v -> {
            bitmap = loadBitmapFromView(binding.ok.linearLayout, binding.ok.linearLayout.getWidth(), binding.ok.linearLayout.getHeight());
            if (isWriteStoragePermissionGranted() == false) {
                Toast.makeText(SndActivity.this, "Please give storage permission", Toast.LENGTH_SHORT).show();
                return;
            }
            isReadStoragePermissionGranted();
            createPdf(SndActivity.this, bitmap);

        });
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, final Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_CANCELED) {
            Toast.makeText(getApplicationContext(), "No Image selected", Toast.LENGTH_SHORT).show();
        } else if (resultCode == Activity.RESULT_OK) {
            Uri ImageURL = data.getData();

            try {
                Bitmap bitmapimage = getBitmapImage(getApplicationContext().getContentResolver(), ImageURL);
                binding.ok.imageView.setImageBitmap(bitmapimage);

            } catch (IOException e) {
                e.printStackTrace();
            }

        } else if (resultCode == ImagePicker.RESULT_ERROR) {
            Toast.makeText(this, "Something Wrong", Toast.LENGTH_SHORT).show();
        }

    }


}