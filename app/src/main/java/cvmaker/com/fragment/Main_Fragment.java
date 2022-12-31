package cvmaker.com.fragment;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cvmaker.com.R;
import cvmaker.com.databinding.FragmentMainBinding;


public class Main_Fragment extends Fragment {
    private FragmentMainBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_main_, container, false);

        binding.back.setOnClickListener(v -> {
            getActivity().onBackPressed();
        });
        binding.nextBtn.setOnClickListener(v -> {
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
            Bundle bundle = new Bundle();
            bundle.putString("name", binding.nameEt.getText().toString());
            bundle.putString("address", binding.addressEt.getText().toString());
            bundle.putString("mail", binding.mailEt.getText().toString());
            bundle.putString("phone", binding.phoneEt.getText().toString());
            bundle.putString("objective", binding.careerObjectiveEt.getText().toString());


            bundle.putString("graduation", binding.graduationEt.getText().toString());
            bundle.putString("bscgpa", binding.bscGpaEt.getText().toString());
            bundle.putString("bscdepartment", binding.bscDept.getText().toString());
            bundle.putString("university", binding.universityEt.getText().toString());

            bundle.putString("collegeName", binding.collegeNameEt.getText().toString());
            bundle.putString("hscDept", binding.hscDepartmentEt.getText().toString());
            bundle.putString("hscPassingYear", binding.hscPassingYearEt.getText().toString());
            bundle.putString("hscGpa", binding.hscGpa.getText().toString());
            bundle.putString("hscBoard", binding.hscBoardEt.getText().toString());

            bundle.putString("schoolName", binding.schoolNameEt.getText().toString());
            bundle.putString("sscDept", binding.sscSubjectEt.getText().toString());
            bundle.putString("sscPassingYear", binding.sscPassingYearEt.getText().toString());
            bundle.putString("sscGpa", binding.sscGpa.getText().toString());
            bundle.putString("sscBoard", binding.sscBoardEt.getText().toString());
            bundle.putString("skill", binding.skillEt.getText().toString());

            Navigation.findNavController(getView()).navigate(R.id.action_main_Fragment_to_pdfLayoutFragment, bundle);
        });
        return binding.getRoot();
    }
}