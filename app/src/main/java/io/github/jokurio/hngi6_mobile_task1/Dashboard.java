package io.github.jokurio.hngi6_mobile_task1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class Dashboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard);

        SharedPreferences preferences = getSharedPreferences("MYPREFS",MODE_PRIVATE);
        String display = preferences.getString("display", "");

        TextView textView = findViewById(R.id.display);
        textView.setText(display);

    }
}
