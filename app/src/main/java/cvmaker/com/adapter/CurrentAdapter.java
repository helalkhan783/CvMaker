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
import cvmaker.com.model.CurrentModel;
import cvmaker.com.model.PoliceModel;

public class CurrentAdapter extends RecyclerView.Adapter<CurrentAdapter.MyHolder> {
    private FragmentActivity context;
    private List<CurrentModel> currentModelList;
    private String portion;


    public CurrentAdapter(FragmentActivity context, List<CurrentModel> currentModels, String portion) {
        this.context = context;
        this.currentModelList = currentModels;
        this.portion = portion;
    }

    @NonNull
    @NotNull
    @Override
    public CurrentAdapter.MyHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        SubItemLayoutBinding binding =
                DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.sub_item_layout, parent, false);
        return new CurrentAdapter.MyHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull CurrentAdapter.MyHolder holder, int position) {
        CurrentModel current = currentModelList.get(position);
        holder.binding.addressLayout.setVisibility(View.GONE);
        holder.binding.address.setVisibility(View.GONE);
        holder.binding.cardView.setBackgroundTintList(ColorStateList.valueOf(context.getResources().getColor(R.color.police_col)));
        holder.binding.name.setText("" + current.getCurrentOfficeName());
        holder.binding.numberOne.setText(current.getNumberOne() + "    ");
        if (current.getNumberTwo().isEmpty()) {
            holder.binding.numberTwo.setVisibility(View.GONE);
        }
        holder.binding.numberTwo.setText("" + current.getNumberTwo() + "    ");

        holder.binding.numberOne.setOnClickListener(view -> {
            dialPhoneNumber(current.getNumberOne());
        });

        holder.binding.numberTwo.setOnClickListener(view -> {
            dialPhoneNumber(current.getNumberTwo());

        });

    }


    @Override
    public int getItemCount() {
        return currentModelList.size();
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



