package cvmaker.com.adapter;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentActivity;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import cvmaker.com.R;
import cvmaker.com.databinding.ItemLayoutBinding;
import cvmaker.com.utils.OnlineShebaUtil;

public class DistrictAdapter extends RecyclerView.Adapter<DistrictAdapter.MyHolder> {
    private FragmentActivity context;
    private List<String> upazillaNameList;
    private List<Integer> upazillaImage;


    public DistrictAdapter(FragmentActivity context, List<String> upazillaNameList, List<Integer> upazillaImage) {
        this.context = context;
        this.upazillaNameList = upazillaNameList;
        this.upazillaImage = upazillaImage;
    }

    @NonNull
    @NotNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        ItemLayoutBinding binding =
                DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_layout, parent, false);
        return new MyHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull MyHolder holder, int position) {
        Integer currentImage = upazillaImage.get(position);
        String currentName = upazillaNameList.get(position);
        holder.binding.textHomeItem.setText(currentName);
        holder.binding.imageHomeItem.setImageDrawable(ContextCompat.getDrawable(context, currentImage));
        holder.itemView.setOnClickListener(view -> {

            gotoNext(holder,currentName);



        });

    }

    private void gotoNext(MyHolder holder, String currentName) {
        Bundle bundle = new Bundle();
        bundle.putString("portion", currentName);
        bundle.putString("service", "");
        Navigation.findNavController(holder.binding.getRoot()).navigate(R.id.action_homeFragment_to_onlineSheba, bundle);
    }


    @Override
    public int getItemCount() {
        return upazillaNameList.size();
    }


    class MyHolder extends RecyclerView.ViewHolder {
        private ItemLayoutBinding binding;

        public MyHolder(ItemLayoutBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

}
