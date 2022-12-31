package cvmaker.com.adapter;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentActivity;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import cvmaker.com.R;
import cvmaker.com.databinding.ItemLau1Binding;
import cvmaker.com.utils.BholaServiceUtil;
import cvmaker.com.utils.OnlineShebaUtil;

public class ThanaAdapter extends RecyclerView.Adapter<ThanaAdapter.MyHolder> {
    private FragmentActivity context;
    private List<String> bholaServiceName;
    private List<Integer> bholaServiceImage;
    private String portion;


    public ThanaAdapter(FragmentActivity context, List<String> upazillaNameList, List<Integer> upazillaImage, String portion) {
        this.context = context;
        this.bholaServiceName = upazillaNameList;
        this.bholaServiceImage = upazillaImage;
        this.portion = portion;
    }

    @NonNull
    @NotNull
    @Override
    public ThanaAdapter.MyHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        ItemLau1Binding binding =
                DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_lau1, parent, false);
        return new ThanaAdapter.MyHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ThanaAdapter.MyHolder holder, int position) {
        Integer currentImage = bholaServiceImage.get(position);
        String currentName = bholaServiceName.get(position);
        holder.binding.textHomeItem.setText(currentName);
        holder.binding.imageHomeItem.setImageDrawable(ContextCompat.getDrawable(context, currentImage));
        holder.itemView.setOnClickListener(view -> {
            Bundle bundle = new Bundle();
            bundle.putString("portion", portion);
            bundle.putString("service", currentName);
            Navigation.findNavController(holder.binding.getRoot()).navigate(R.id.action_onlineSheba_self, bundle);




        });

    }



    @Override
    public int getItemCount() {
        return bholaServiceName.size();
    }


    class MyHolder extends RecyclerView.ViewHolder {
        private ItemLau1Binding binding;

        public MyHolder(ItemLau1Binding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

}

