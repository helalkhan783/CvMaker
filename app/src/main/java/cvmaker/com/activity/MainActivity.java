package cvmaker.com.activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.play.core.appupdate.AppUpdateInfo;
import com.google.android.play.core.appupdate.AppUpdateManager;
import com.google.android.play.core.appupdate.AppUpdateManagerFactory;
import com.google.android.play.core.install.model.UpdateAvailability;
import com.google.android.play.core.tasks.Task;

import java.util.Objects;

import cvmaker.com.R;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                UpdateApp(1, MainActivity.this);

            }
        }, 2000);
    }


    public void UpdateApp(int maintainaceCode, Context context) {
        AppUpdateManager appUpdateManager = AppUpdateManagerFactory.create(this);
        Task<AppUpdateInfo> appUpdateInfoTask = appUpdateManager.getAppUpdateInfo();
        // Checks that the platform will allow the specified type of update.
        appUpdateInfoTask.addOnSuccessListener(result -> {

            if (result.updateAvailability() == UpdateAvailability.UPDATE_AVAILABLE) {
//                requestUpdate(result);
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                @SuppressLint("InflateParams")
                View view = ((Activity) context).getLayoutInflater().inflate(R.layout.update_dialog, null);
                //Set the view
                builder.setView(view);
                TextView dialogName, dialogSpeech;
                Button noThanks, update;
                noThanks = view.findViewById(R.id.noThanks);
                update = view.findViewById(R.id.updateApp);
                dialogName = view.findViewById(R.id.dialogName);
                dialogSpeech = view.findViewById(R.id.dialogSpeech);
                ImageView imageIcon = view.findViewById(R.id.img_icon);

                imageIcon.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.launcher));//set warning image
                AlertDialog alertDialog = builder.create();
                Objects.requireNonNull(alertDialog.getWindow()).setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                alertDialog.setCancelable(false);
                alertDialog.setCanceledOnTouchOutside(false);

                if (maintainaceCode == 1) {
                    update.setVisibility(View.VISIBLE);
                    noThanks.setText("Exit");
                    dialogName.setVisibility(View.VISIBLE);
                    dialogSpeech.setVisibility(View.VISIBLE);

                }
                if (maintainaceCode == 2) {
                    update.setVisibility(View.VISIBLE);
                    dialogSpeech.setVisibility(View.GONE);
                    dialogName.setVisibility(View.GONE);
                    noThanks.setText("No Thanks");
                    dialogName.setVisibility(View.VISIBLE);

                }

                noThanks.setOnClickListener(v -> {
                    if (maintainaceCode == 2) {
                        update.setVisibility(View.VISIBLE);
                        dialogName.setVisibility(View.VISIBLE);
                        manage();
                        return;
                    } else {
                        finish();
                    }

                });
                update.setOnClickListener(v -> {
                    try {
                        context.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + getPackageName())));
                    } catch (android.content.ActivityNotFoundException anfe) {
                        context.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + getPackageName())));
                    }
                });

                alertDialog.show();


            } else {
                manage();
            }
        }).addOnFailureListener(e -> {
           // Toast.makeText(MainActivity.this, "" + e.getMessage(), Toast.LENGTH_SHORT).show();
            manage();
        });
    }

    private void manage() {
        Intent intent = new Intent(MainActivity.this,ItemActivity.class);
        startActivity(intent);
        finish();
    }


}