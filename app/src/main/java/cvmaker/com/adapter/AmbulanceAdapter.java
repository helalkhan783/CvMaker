package cvmaker.com.adapter;

import android.content.Intent;
import android.content.res.ColorStateList;
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

import cvmaker.com.R;
import cvmaker.com.databinding.SubItemLayoutBinding;
import cvmaker.com.model.AmbulanceModel;

public class AmbulanceAdapter extends RecyclerView.Adapter<AmbulanceAdapter.MyHolder> {
    private FragmentActivity context;
    private List<AmbulanceModel> ambulanceModelList;
    private String portion;


    public AmbulanceAdapter(FragmentActivity context, List<AmbulanceModel> hospitalModelList, String portion) {
        this.context = context;
        this.ambulanceModelList = hospitalModelList;
        this.portion = portion;
    }

    @NonNull
    @NotNull
    @Override
    public AmbulanceAdapter.MyHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        SubItemLayoutBinding binding =
                DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.sub_item_layout, parent, false);
        return new AmbulanceAdapter.MyHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull AmbulanceAdapter.MyHolder holder, int position) {
        AmbulanceModel current =  ambulanceModelList.get(position);
        holder.binding.cardView.setBackgroundTintList(ColorStateList.valueOf(context.getResources().getColor(R.color.red1)));

        holder.binding.name.setText(""+current.getAmbulanceName());
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
        return ambulanceModelList.size();
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


