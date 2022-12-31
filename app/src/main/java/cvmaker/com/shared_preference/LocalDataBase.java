package cvmaker.com.shared_preference;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.fragment.app.FragmentActivity;

public class LocalDataBase {
FragmentActivity context;

    public LocalDataBase(FragmentActivity context) {
        this.context = context;
    }

    public void saveTemplateNumber(String templateNumber) {//for save store Id
        SharedPreferences preferences = context.getSharedPreferences("TEMPLATE_ID", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("Number", templateNumber);
        editor.apply();
    }

    public String getTemplateId() {
        SharedPreferences prfs = context.getSharedPreferences("TEMPLATE_ID", Context.MODE_PRIVATE);
        String storeId = prfs.getString("Number", "");
        return storeId;
    }



}
