package io.github.jokurio.hngi6_mobile_task1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class Register extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        final EditText userName = findViewById(R.id.new_name);
        final EditText passWord = findViewById(R.id.new_password);
        final EditText eMail = findViewById(R.id.new_email);
        Button btn = findViewById(R.id.register);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences myPreferences = getSharedPreferences("MYPREFS",MODE_PRIVATE);
                String newUser = userName.getText().toString();
                String newPassword = passWord.getText().toString();
                String newEmail = eMail.getText().toString();

                SharedPreferences.Editor editor = myPreferences.edit();
                editor.putString(newUser + newPassword + "data", newUser + "\n" + newEmail);
                editor.apply();

                Intent intent = new Intent(Register.this, LoginActivity.class);
                startActivity(intent);

            }
        });
    }
}
