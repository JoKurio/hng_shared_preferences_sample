package io.github.jokurio.hngi6_mobile_task1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final EditText myName = findViewById(R.id.name);
        final EditText myPassword = findViewById(R.id.password);
        Button buttonLogin = findViewById(R.id.login_button);
        Button buttonRegister = findViewById(R.id.register_button);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = myName.getText().toString();
                String password = myPassword.getText().toString();

                SharedPreferences myPreferences = getSharedPreferences("MYPREFS",MODE_PRIVATE);
                String myDetails = myPreferences.getString(user + password + "data","username or password is incorrect");
                SharedPreferences.Editor editor = myPreferences.edit();
                editor.putString("display",myDetails);
                editor.apply();

                Intent intent = new Intent(LoginActivity.this, Dashboard.class);
                startActivity(intent);
            }
        });

        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent register = new Intent(LoginActivity.this,Register.class);
                startActivity(register);
            }
        });
    }
}
