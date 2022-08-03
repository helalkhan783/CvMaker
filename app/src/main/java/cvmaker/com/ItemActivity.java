package cvmaker.com;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import cvmaker.com.databinding.ActivityItemBinding;

public class ItemActivity extends AppCompatActivity {
    ActivityItemBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_item);
        binding.mainLayout.setOnClickListener(v -> startActivity(new Intent(ItemActivity.this, InputInfo.class)));
    }
}