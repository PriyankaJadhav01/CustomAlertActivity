package java.tata.piyu.customalertactivity;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    final Context context = this;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.buttonList);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.activity_custom_custom_alert);
                Button dialogButton = dialog.findViewById(R.id.dialogButtonOk);
                dialogButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                        startActivity(new Intent(MainActivity.this, ExpandedListViewActivity.class));
                        Toast.makeText(getApplicationContext(), "Dismissed..!!", Toast.LENGTH_SHORT).show();

                    }
                });
                dialog.show();

            }
        });
    }
}
