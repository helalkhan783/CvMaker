package cvmaker.com.fragment;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.List;

import cvmaker.com.R;
import cvmaker.com.adapter.AmbulanceAdapter;
import cvmaker.com.adapter.CurrentAdapter;
import cvmaker.com.adapter.FireServiceAdapter;
import cvmaker.com.adapter.HospitalAdapter;
import cvmaker.com.adapter.PoliceAdapter;
import cvmaker.com.adapter.ThanaAdapter;
import cvmaker.com.all_list.CurrentList;
import cvmaker.com.all_list.PoliceList;
import cvmaker.com.all_list.ambulance_list.AmbulanceList;
import cvmaker.com.all_list.fireservice_list.FireserviceList;
import cvmaker.com.databinding.FragmentOnlineShebaBinding;
import cvmaker.com.all_list.hospital_list.HospitalList;
import cvmaker.com.model.AmbulanceModel;
import cvmaker.com.model.CurrentModel;
import cvmaker.com.model.FireServiceModel;
import cvmaker.com.model.HospitalMode;
import cvmaker.com.model.PoliceModel;
import cvmaker.com.utils.BholaServiceUtil;
import cvmaker.com.utils.OnlineShebaUtil;


public class OnlineSheba extends BaseFragment {
    FragmentOnlineShebaBinding binding;
    String portion, service;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_online_sheba, container, false);
        portion = getArguments().getString("portion");
        service = getArguments().getString("service");


        if (service.isEmpty()) {
            binding.upazillaName.setText("" + portion + "র সেবা সমূহ");
            binding.toplayout.setVisibility(View.GONE);
            binding.onlineShevaRv.setVisibility(View.VISIBLE);
            binding.onlineShevaRv.setHasFixedSize(true);
            binding.onlineShevaRv.setLayoutManager(new GridLayoutManager(getContext(), 2));
            binding.onlineShevaRv.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.HORIZONTAL));
            binding.onlineShevaRv.setNestedScrollingEnabled(false);
            ThanaAdapter adapter = new ThanaAdapter(getActivity(), BholaServiceUtil.bholaSadarServiceName(), BholaServiceUtil.serviceImage(), portion);
            binding.onlineShevaRv.setAdapter(adapter);

        } else {
            binding.upazillaName.setText("" + portion + "র " + service + " সমূহ");

            binding.toplayout.setVisibility(View.VISIBLE);
            binding.onlineShevaRv.setVisibility(View.GONE);


            if (portion.equals(OnlineShebaUtil.bholaSadar)) {
                gotoBholaAll(service);
            } else if (portion.equals(OnlineShebaUtil.bordunuddin)) {
                gotoAllBorhunuddin(service);


            } else if (portion.equals(OnlineShebaUtil.lalmohon)) {
                gotoAllLalmohon(service);

            } else if (portion.equals(OnlineShebaUtil.tazumoddin)) {
                gotoAllTazumoddin(service);

            } else if (portion.equals(OnlineShebaUtil.charfassion)) {
                gotoAllcharfashion(service);

            } else if (portion.equals(OnlineShebaUtil.monpura)) {
                gotoAllMonpura(service);

            } else {
                gotoAllDaulatkhan(service);

            }


        }


        return binding.getRoot();
    }


    private void gotoAllDaulatkhan(String currentName) {
        if (currentName.equals(BholaServiceUtil.hospital)) {
            setHospitalData(HospitalList.daulatKhanHospitals());
            return;
        } else if (currentName.equals(BholaServiceUtil.fireService)) {
            fireServiceDataSet(FireserviceList.fireserviceList());
            return;
        } else if (currentName.equals(BholaServiceUtil.police)) {
            setPoliceData(PoliceList.daulatkhaPolice());
            binding.upazillaName.setText("" + portion + "র আইনি সেবা");

            return;
        } else if (currentName.equals(BholaServiceUtil.ambulance)) {
            setAmbulaceData(AmbulanceList.daulatkhaAmbulance());
            return;
        } else if (currentName.equals(BholaServiceUtil.rentCar)) {
            Toast.makeText(getContext(), "" + portion + "\n" + currentName, Toast.LENGTH_SHORT).show();
            return;
        } else {
            binding.upazillaName.setText("" + portion + "র জরুরি বিদ্যুৎ");
            setBidyutData(CurrentList.daulatkhaCurrent());
        }
    }

    private void gotoAllMonpura(String currentName) {
        if (currentName.equals(BholaServiceUtil.hospital)) {
            setHospitalData(HospitalList.getMonpuraHospitalList());
            return;
        } else if (currentName.equals(BholaServiceUtil.fireService)) {
            fireServiceDataSet(FireserviceList.fireserviceList());
            return;
        } else if (currentName.equals(BholaServiceUtil.police)) {
            setPoliceData(PoliceList.monpuraPolice());
            binding.upazillaName.setText("" + portion + "র আইনি সেবা");

            return;
        } else if (currentName.equals(BholaServiceUtil.ambulance)) {
            setAmbulaceData(AmbulanceList.monpuraAmbulance());
            return;
        } else if (currentName.equals(BholaServiceUtil.rentCar)) {
            Toast.makeText(getContext(), "" + portion + "\n" + currentName, Toast.LENGTH_SHORT).show();
            return;
        } else {
            binding.upazillaName.setText("" + portion + "র জরুরি বিদ্যুৎ");
            setBidyutData(CurrentList.monpuraCurrent());
        }
    }

    private void gotoAllcharfashion(String currentName) {
        if (currentName.equals(BholaServiceUtil.hospital)) {
            setHospitalData(HospitalList.getCharHospitalList());
            return;
        } else if (currentName.equals(BholaServiceUtil.fireService)) {
            fireServiceDataSet(FireserviceList.fireserviceList());
            return;
        } else if (currentName.equals(BholaServiceUtil.police)) {
            setPoliceData(PoliceList.charfashionThana());
            binding.upazillaName.setText("" + portion + "র আইনি সেবা");

            return;
        } else if (currentName.equals(BholaServiceUtil.ambulance)) {
            setAmbulaceData(AmbulanceList.charfashionAmbulace());
            return;
        } else if (currentName.equals(BholaServiceUtil.rentCar)) {
            Toast.makeText(getContext(), "" + portion + "\n" + currentName, Toast.LENGTH_SHORT).show();
            return;
        } else {
            binding.upazillaName.setText("" + portion + "র জরুরি বিদ্যুৎ");
            setBidyutData(CurrentList.charfashionCurrent());
        }
    }

    private void gotoAllTazumoddin(String currentName) {

        if (currentName.equals(BholaServiceUtil.hospital)) {
            setHospitalData(HospitalList.getTazumoddinHospitalList());
            return;
        } else if (currentName.equals(BholaServiceUtil.fireService)) {
            fireServiceDataSet(FireserviceList.fireserviceList());
            return;
        } else if (currentName.equals(BholaServiceUtil.police)) {
            setPoliceData(PoliceList.tajumuddon());
            binding.upazillaName.setText("" + portion + "র আইনি সেবা");

            return;
        } else if (currentName.equals(BholaServiceUtil.ambulance)) {
            setAmbulaceData(AmbulanceList.tajumuddinAmbulance());
            return;
        } else if (currentName.equals(BholaServiceUtil.rentCar)) {
            Toast.makeText(getContext(), "" + portion + "\n" + currentName, Toast.LENGTH_SHORT).show();
            return;
        } else {
            binding.upazillaName.setText("" + portion + "র জরুরি বিদ্যুৎ");
            setBidyutData(CurrentList.tajumuddonCurrent());
        }
    }

    private void gotoAllLalmohon(String currentName) {
        if (currentName.equals(BholaServiceUtil.hospital)) {
            setHospitalData(HospitalList.getLalmohonHospitalList());
            return;
        } else if (currentName.equals(BholaServiceUtil.police)) {
            setPoliceData(PoliceList.lalmohonPolice());
            binding.upazillaName.setText("" + portion + "র আইনি সেবা");

            return;
        } else if (currentName.equals(BholaServiceUtil.fireService)) {
            fireServiceDataSet(FireserviceList.fireserviceList());
            return;
        } else if (currentName.equals(BholaServiceUtil.ambulance)) {
            setAmbulaceData(AmbulanceList.lalmohonAmbulance());
            return;
        } else if (currentName.equals(BholaServiceUtil.rentCar)) {
            Toast.makeText(getContext(), "" + portion + "\n" + currentName, Toast.LENGTH_SHORT).show();
            return;
        } else if (currentName.equals(BholaServiceUtil.rentCar)) {
            Toast.makeText(getContext(), "" + portion + "\n" + currentName, Toast.LENGTH_SHORT).show();
            return;
        } else {
            binding.upazillaName.setText("" + portion + "র জরুরি বিদ্যুৎ");
            setBidyutData(CurrentList.lalmohonCurrent());
        }
    }

    private void gotoAllBorhunuddin(String currentName) {
        if (currentName.equals(BholaServiceUtil.hospital)) {
            setHospitalData(HospitalList.getBorhunuddinlList())
            ;
            return;
        } else if (currentName.equals(BholaServiceUtil.fireService)) {
            fireServiceDataSet(FireserviceList.fireserviceList());
            return;
        } else if (currentName.equals(BholaServiceUtil.police)) {
            setPoliceData(PoliceList.borhunuddinPolice());
            binding.upazillaName.setText("" + portion + "র আইনি সেবা");

            return;
        } else if (currentName.equals(BholaServiceUtil.ambulance)) {
            setAmbulaceData(AmbulanceList.borhunuddinAmbulance());
            return;
        } else if (currentName.equals(BholaServiceUtil.rentCar)) {
            Toast.makeText(getContext(), "" + portion + "\n" + currentName, Toast.LENGTH_SHORT).show();
            return;
        } else {
            binding.upazillaName.setText("" + portion + "র জরুরি বিদ্যুৎ");
            setBidyutData(CurrentList.borhunuddinCurrent());
        }
    }

    private void gotoBholaAll(String currentName) {

        if (currentName.equals(BholaServiceUtil.hospital)) {
            setHospitalData(HospitalList.getBholaHospitalList());
            return;
        } else if (currentName.equals(BholaServiceUtil.fireService)) {

            fireServiceDataSet(FireserviceList.fireserviceList());
            return;
        } else if (currentName.equals(BholaServiceUtil.police)) {
            binding.upazillaName.setText("" + portion + "র আইনি সেবা");

            setPoliceData(PoliceList.bholaPoliceList());
            return;
        } else if (currentName.equals(BholaServiceUtil.ambulance)) {
            setAmbulaceData(AmbulanceList.bholaAmbulacelist());
            return;
        } else if (currentName.equals(BholaServiceUtil.rentCar)) {
            Toast.makeText(getContext(), "" + portion + "\n" + currentName, Toast.LENGTH_SHORT).show();
            return;
        } else {
            binding.upazillaName.setText("" + portion + "র জরুরি বিদ্যুৎ");
            setBidyutData(CurrentList.bholaCurrent());

        }
    }

    private void setBidyutData(List<CurrentModel> currentModelList) {

        if (currentModelList == null) {
            binding.subOnlineShevaRv.setVisibility(View.GONE);
            binding.dataNotFound.setVisibility(View.VISIBLE);
            return;
        }
        binding.dataNotFound.setVisibility(View.GONE);
        binding.subOnlineShevaRv.setVisibility(View.VISIBLE);
        binding.subOnlineShevaRv.setHasFixedSize(true);
        binding.subOnlineShevaRv.setLayoutManager(new LinearLayoutManager(getContext()));
        CurrentAdapter adapter = new CurrentAdapter(getActivity(), currentModelList, portion);
        binding.subOnlineShevaRv.setAdapter(adapter);

    }

    private void setPoliceData(List<PoliceModel> policeModels) {

        binding.subOnlineShevaRv.setHasFixedSize(true);
        binding.subOnlineShevaRv.setLayoutManager(new LinearLayoutManager(getContext()));
        PoliceAdapter adapter = new PoliceAdapter(getActivity(), policeModels, portion);
        binding.subOnlineShevaRv.setAdapter(adapter);

    }

    private void fireServiceDataSet(List<FireServiceModel> fireserviceList) {
        binding.subOnlineShevaRv.setHasFixedSize(true);
        binding.subOnlineShevaRv.setLayoutManager(new LinearLayoutManager(getContext()));
        FireServiceAdapter adapter = new FireServiceAdapter(getActivity(), fireserviceList, portion);
        binding.subOnlineShevaRv.setAdapter(adapter);


    }

    private void setAmbulaceData(List<AmbulanceModel> ambulanceModelList) {

        if (ambulanceModelList == null) {
            binding.subOnlineShevaRv.setVisibility(View.GONE);
            binding.dataNotFound.setVisibility(View.VISIBLE);
            return;
        }
        binding.dataNotFound.setVisibility(View.GONE);
        binding.subOnlineShevaRv.setVisibility(View.VISIBLE);

        binding.subOnlineShevaRv.setHasFixedSize(true);
        binding.subOnlineShevaRv.setLayoutManager(new LinearLayoutManager(getContext()));
        AmbulanceAdapter adapter = new AmbulanceAdapter(getActivity(), ambulanceModelList, portion);
        binding.subOnlineShevaRv.setAdapter(adapter);


    }

    private void setHospitalData(List<HospitalMode> hospitalList) {
        binding.subOnlineShevaRv.setHasFixedSize(true);
        binding.subOnlineShevaRv.setLayoutManager(new LinearLayoutManager(getContext()));
        HospitalAdapter adapter = new HospitalAdapter(getActivity(), hospitalList, portion);
        binding.subOnlineShevaRv.setAdapter(adapter);

    }

}