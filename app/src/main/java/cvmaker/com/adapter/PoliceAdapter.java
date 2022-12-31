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
import cvmaker.com.all_list.PoliceList;
import cvmaker.com.databinding.SubItemLayoutBinding;
import cvmaker.com.model.FireServiceModel;
import cvmaker.com.model.PoliceModel;

public class PoliceAdapter extends RecyclerView.Adapter<PoliceAdapter.MyHolder> {
    private FragmentActivity context;
    private List<PoliceModel> fireserviceLists;
    private String portion;


    public PoliceAdapter(FragmentActivity context, List<PoliceModel> fireserviceLists, String portion) {
        this.context = context;
        this.fireserviceLists = fireserviceLists;
        this.portion = portion;
    }

    @NonNull
    @NotNull
    @Override
    public PoliceAdapter.MyHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        SubItemLayoutBinding binding =
                DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.sub_item_layout, parent, false);
        return new PoliceAdapter.MyHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull PoliceAdapter.MyHolder holder, int position) {
        PoliceModel current = fireserviceLists.get(position);
        holder.binding.addressLayout.setVisibility(View.GONE);
        holder.binding.address.setVisibility(View.GONE);
        holder.binding.cardView.setBackgroundTintList(ColorStateList.valueOf(context.getResources().getColor(R.color.police_col)));
        holder.binding.name.setText("" + current.getThanaName());
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
        return fireserviceLists.size();
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


