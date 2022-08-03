package cvmaker.com;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.databinding.DataBindingUtil;

import android.Manifest;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.github.dhaval2404.imagepicker.ImagePicker;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import cvmaker.com.databinding.ActivityInputInfoBinding;

public class InputInfo extends AppCompatActivity {
    private ActivityInputInfoBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_input_info);



        binding.nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (binding.nameEt.getText().toString().isEmpty()) {
                    binding.nameEt.setError("Please Enter Name");
                    binding.nameEt.requestFocus();
                    return;
                }
                if (binding.phoneEt.getText().toString().isEmpty()) {
                    binding.phoneEt.setError("Please Enter Phone");
                    binding.phoneEt.requestFocus();
                    return;
                }
                if (binding.addressEt.getText().toString().isEmpty()) {
                    binding.addressEt.setError("Please Enter Address");
                    binding.addressEt.requestFocus();
                    return;
                }
                if (binding.careerObjectiveEt.getText().toString().isEmpty()) {
                    binding.careerObjectiveEt.setError("Please Enter Career Objective");
                    binding.careerObjectiveEt.requestFocus();
                    return;
                }

                Intent intent = new Intent(InputInfo.this, SndActivity.class);
                intent.putExtra("name", binding.nameEt.getText().toString());
                intent.putExtra("address", binding.addressEt.getText().toString());
                intent.putExtra("mail", binding.mailEt.getText().toString());
                intent.putExtra("phone", binding.phoneEt.getText().toString());
                intent.putExtra("objective", binding.careerObjectiveEt.getText().toString());


                intent.putExtra("graduation", binding.graduationEt.getText().toString());
                intent.putExtra("bscgpa", binding.bscGpaEt.getText().toString());
                intent.putExtra("bscdepartment", binding.bscDept.getText().toString());
                intent.putExtra("university", binding.universityEt.getText().toString());

                intent.putExtra("collegeName", binding.collegeNameEt.getText().toString());
                intent.putExtra("hscDept", binding.hscDepartmentEt.getText().toString());
                intent.putExtra("hscPassingYear", binding.hscPassingYearEt.getText().toString());
                intent.putExtra("hscGpa", binding.hscGpa.getText().toString());
                intent.putExtra("hscBoard", binding.hscBoardEt.getText().toString());

                intent.putExtra("schoolName", binding.schoolNameEt.getText().toString());
                intent.putExtra("sscDept", binding.sscSubjectEt.getText().toString());
                intent.putExtra("sscPassingYear", binding.sscPassingYearEt.getText().toString());
                intent.putExtra("sscGpa", binding.sscGpa.getText().toString());
                intent.putExtra("sscBoard", binding.sscBoardEt.getText().toString());
                intent.putExtra("skill", binding.skillEt.getText().toString());

                startActivity(intent);

            }
        });
    }


}