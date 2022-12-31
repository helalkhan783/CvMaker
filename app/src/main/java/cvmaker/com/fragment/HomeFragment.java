package cvmaker.com.fragment;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import cvmaker.com.R;
import cvmaker.com.adapter.DistrictAdapter;
import cvmaker.com.databinding.FragmentHomeBinding;
import cvmaker.com.utils.OnlineShebaUtil;


public class HomeFragment extends Fragment {
    FragmentHomeBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false);
        customiseDrawer();

      binding.homeRvPortion.bottomNavigation.setOnNavigationItemSelectedListener(item -> {

            switch (item.getItemId()) {

                case R.id.resume:
                    Navigation.findNavController(getView()).navigate(R.id.action_homeFragment_to_main_Fragment);
                    break;

                case R.id.menu:
                    if (binding.drawerLayout.isDrawerOpen(Gravity.LEFT))
                        binding.drawerLayout.closeDrawer(Gravity.LEFT);
                    else binding.drawerLayout.openDrawer(Gravity.LEFT);

                    break;


            }
            return true;
        });



        binding.homeRvPortion.onlineShevaRv.setHasFixedSize(true);
        binding.homeRvPortion.onlineShevaRv.setLayoutManager(new GridLayoutManager(getContext(), 2));
        binding.homeRvPortion.onlineShevaRv.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.HORIZONTAL));
        binding.homeRvPortion.onlineShevaRv.setNestedScrollingEnabled(false);

        DistrictAdapter adapter = new DistrictAdapter(getActivity(), OnlineShebaUtil.getUpazillaName(), OnlineShebaUtil.getUpazillaImage());
        binding.homeRvPortion.onlineShevaRv.setAdapter(adapter);




        return binding.getRoot();
    }

    private void customiseDrawer() {
        int width = (getResources().getDisplayMetrics().widthPixels / 2) + 100;
        DrawerLayout.LayoutParams params = (DrawerLayout.LayoutParams) binding.navbar.getLayoutParams();
        params.width = width;
        binding.navbar.setLayoutParams(params);

    }
}