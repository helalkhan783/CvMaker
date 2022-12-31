package cvmaker.com.fragment;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;

import androidx.databinding.DataBindingUtil;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.github.dhaval2404.imagepicker.ImagePicker;

import java.io.IOException;

import cvmaker.com.R;
import cvmaker.com.databinding.FragmentPdfLayoutBinding;
import cvmaker.com.shared_preference.LocalDataBase;
import cvmaker.com.utils.ManageUtils;


public class PdfLayoutFragment extends BaseFragment implements View.OnClickListener {
    private FragmentPdfLayoutBinding binding;
    private Bitmap bitmap;
    private String name, address, mail, phone, objective, graduation, bscgpa,
            bscdepartment, university, collegeName, hscDept, hscPassingYear, hscBoard,
            hscGpa, schoolName, sscDept, sscPassingYear, sscBoard, sscGpa, skill;
    private LocalDataBase localDataBase;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_pdf_layout, container, false);
        localDataBase = new LocalDataBase(getActivity());
        localDataBase.saveTemplateNumber(ManageUtils.TEMPLATE_ONE);

        saveDataToView();
        savePdf();
        setClick();

        return binding.getRoot();
    }

    private void setClick() {
        binding.designOne.imageView.setOnClickListener(this);
        binding.designTwo.imageViewTwo.setOnClickListener(this);
        binding.templateOne.setOnClickListener(this);
        binding.templateTwo.setOnClickListener(this);
    }


    private void saveDataToView() {
        name = getArguments().getString("name");
        address = getArguments().getString("address");
        mail = getArguments().getString("mail");
        phone = getArguments().getString("phone");
        objective = getArguments().getString("objective");
        graduation = getArguments().getString("graduation");
        bscgpa = getArguments().getString("bscgpa");
        bscdepartment = getArguments().getString("bscdepartment");
        university = getArguments().getString("university");
        collegeName = getArguments().getString("collegeName");
        hscDept = getArguments().getString("hscDept");
        hscPassingYear = getArguments().getString("hscPassingYear");
        hscBoard = getArguments().getString("hscBoard");
        hscGpa = getArguments().getString("hscGpa");
        schoolName = getArguments().getString("schoolName");
        sscDept = getArguments().getString("sscDept");
        sscPassingYear = getArguments().getString("sscPassingYear");
        sscBoard = getArguments().getString("sscBoard");
        sscGpa = getArguments().getString("sscGpa");
        skill = getArguments().getString("skill");


        setData(ManageUtils.TEMPLATE_ONE);


    }

    private void setData(String template) {
        if (ManageUtils.TEMPLATE_ONE.equals(template)) {
            binding.designTwoLayout.setVisibility(View.GONE);
            binding.designOneLayout.setVisibility(View.VISIBLE);
            binding.templateOne.setBackgroundColor(getResources().getColor(R.color.blue_col));
            binding.templateTwo.setBackgroundColor(getResources().getColor(R.color.white));
            binding.templateTwo.setTextColor(getResources().getColor(R.color.black));
            binding.templateOne.setTextColor(getResources().getColor(R.color.white));

            binding.designOne.nameTv.setText("Resume Of " + name);
            binding.designOne.address.setText("" + name + "\n" + address + "\n" + mail + "\n" + phone);
            binding.designOne.objective.setText("" + objective);


            binding.designOne.graduation.setText(": " + graduation);
            binding.designOne.bscGpa.setText(": " + bscgpa);
            binding.designOne.bscDept.setText(": " + bscdepartment);
            binding.designOne.university.setText(": " + university);

            binding.designOne.collegeName.setText(": " + collegeName);
            binding.designOne.hscDept.setText(": " + hscDept);
            binding.designOne.hscPassingYear.setText(": " + hscPassingYear);
            binding.designOne.hscBoard.setText(": " + hscBoard);
            binding.designOne.hscGpa.setText(": " + hscGpa);

            binding.designOne.schoolName.setText(": " + schoolName);
            binding.designOne.sscDept.setText(": " + sscDept);
            binding.designOne.sscPassingYear.setText(": " + sscPassingYear);
            binding.designOne.sscBoard.setText(": " + sscBoard);
            binding.designOne.sscGpa.setText(": " + sscGpa);

            binding.designOne.skillTv.setText("" + skill);

        } else if (ManageUtils.TEMPLATE_Two.equals(template)) {
            binding.designOneLayout.setVisibility(View.GONE);
            binding.designTwoLayout.setVisibility(View.VISIBLE);
            binding.templateOne.setBackgroundColor(getResources().getColor(R.color.white));
            binding.templateTwo.setBackgroundColor(getResources().getColor(R.color.blue_col));
            binding.templateTwo.setTextColor(getResources().getColor(R.color.white));
            binding.templateOne.setTextColor(getResources().getColor(R.color.black));

            binding.designTwo.nameTv.setText("Resume Of " + name);
            binding.designTwo.address.setText("" + name + "\n" + address + "\n" + mail + "\n" + phone);
            binding.designTwo.objective.setText("" + objective);


            binding.designTwo.graduation.setText(": " + graduation);
            binding.designTwo.bscGpa.setText(": " + bscgpa);
            binding.designTwo.bscDept.setText(": " + bscdepartment);
            binding.designTwo.university.setText(": " + university);

            binding.designTwo.collegeName.setText(": " + collegeName);
            binding.designTwo.hscDept.setText(": " + hscDept);
            binding.designTwo.hscPassingYear.setText(": " + hscPassingYear);
            binding.designTwo.hscBoard.setText(": " + hscBoard);
            binding.designTwo.hscGpa.setText(": " + hscGpa);

            binding.designTwo.schoolName.setText(": " + schoolName);
            binding.designTwo.sscDept.setText(": " + sscDept);
            binding.designTwo.sscPassingYear.setText(": " + sscPassingYear);
            binding.designTwo.sscBoard.setText(": " + sscBoard);
            binding.designTwo.sscGpa.setText(": " + sscGpa);

            binding.designTwo.skillTv.setText("" + skill);
        }

    }

    private void savePdf() {

        binding.save.setOnClickListener(v -> {
            bitmap = loadBitmapFromView(binding.linearLayout, binding.linearLayout.getWidth(), binding.linearLayout.getHeight());
            if (isWriteStoragePermissionGranted() == false) {
                Toast.makeText(getContext(), "Please give storage permission", Toast.LENGTH_SHORT).show();
                return;
            }
            isReadStoragePermissionGranted();
            createPdf(getActivity(), bitmap,name);

        });
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, final Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_CANCELED) {
            Toast.makeText(getContext(), "No Image selected", Toast.LENGTH_SHORT).show();
        } else if (resultCode == Activity.RESULT_OK) {
            Uri ImageURL = data.getData();

            try {
                Bitmap bitmapimage = getBitmapImage(getContext().getContentResolver(), ImageURL);
                binding.designOne.imageView.setImageBitmap(bitmapimage);
                binding.designTwo.imageViewTwo.setImageBitmap(bitmapimage);

            } catch (IOException e) {
                e.printStackTrace();
            }

        } else if (resultCode == ImagePicker.RESULT_ERROR) {
            Toast.makeText(getContext(), "Something Wrong", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.templateOne) {

             localDataBase.saveTemplateNumber(ManageUtils.TEMPLATE_ONE);
            setData(localDataBase.getTemplateId());

            return;
        }
        if (view.getId() == R.id.templateTwo) {


            localDataBase.saveTemplateNumber(ManageUtils.TEMPLATE_Two);

            setData(localDataBase.getTemplateId());

            return;
        }



        if (view.getId() == R.id.imageView) {
            imagePicker();
            return;
        }
        if (view.getId() == R.id.imageViewTwo) {
            imagePicker();
            return;
        }


    }

    private void imagePicker() {
        ImagePicker.with(PdfLayoutFragment.this)
                .crop()                    //Crop image(Optional), Check Customization for more option
                .compress(512)            //Final image size will be less than 1 MB(Optional)
                .maxResultSize(512, 512)    //Final image resolution will be less than 1080 x 1080(Optional)
                .start();
    }
}