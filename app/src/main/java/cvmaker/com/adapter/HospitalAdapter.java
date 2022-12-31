package cvmaker.com.adapter;

import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import cvmaker.com.databinding.SubItemLayoutBinding;
import cvmaker.com.R;
import cvmaker.com.model.HospitalMode;

public class HospitalAdapter extends RecyclerView.Adapter<HospitalAdapter.MyHolder> {
    private FragmentActivity context;
    private List<HospitalMode> hospitalModelList;
    private String portion;


    public HospitalAdapter(FragmentActivity context, List<HospitalMode> hospitalModelList, String portion) {
        this.context = context;
        this.hospitalModelList = hospitalModelList;
        this.portion = portion;
    }

    @NonNull
    @NotNull
    @Override
    public HospitalAdapter.MyHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        SubItemLayoutBinding binding =
                DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.sub_item_layout, parent, false);
        return new HospitalAdapter.MyHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull HospitalAdapter.MyHolder holder, int position) {
        HospitalMode current =  hospitalModelList.get(position);
      holder.binding.name.setText(""+current.getHospitalName());
      holder.binding.numberOne.setText(current.getNumberOne()+"    ");
      if (current.getNumberTwo().isEmpty()){
          holder.binding.numberTwo.setVisibility(View.GONE);
      }
      holder.binding.numberTwo.setText(""+current.getNumberTwo()+"    ");
      holder.binding.address.setText(""+current.getAddress());

        holder.binding.numberOne.setOnClickListener(view -> {
          dialPhoneNumber(current.getNumberOne());
         });

         holder.binding.numberTwo.setOnClickListener(view -> {
             dialPhoneNumber(current.getNumberTwo());

         });

    }



    @Override
    public int getItemCount() {
        return hospitalModelList.size();
    }


    class MyHolder extends RecyclerView.ViewHolder {
        private SubItemLayoutBinding binding;

        public MyHolder(SubItemLayoutBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

    public void dialPhoneNumber(String phoneNumber) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + phoneNumber));
        if (intent.resolveActivity(context.getPackageManager()) != null) {
          context.startActivity(intent);
        }
    }

}


