package com.example.helpdesk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final EditText edtLogin = (EditText) findViewById(R.id.edtLogin);
        final EditText edtSenha = (EditText) findViewById(R.id.edtSenha);
        final Button button2 = (Button) findViewById(R.id.button2);

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String login = edtLogin.getText().toString();
                String chave = edtSenha.getText().toString();

                if (login.equals("") && chave.equals("")) {
                    Toast msg = Toast.makeText(getApplicationContext(), "Login realizado com sucesso", Toast.LENGTH_LONG);
                    msg.show();

                    Intent intent = new Intent(LoginActivity.this, TabsActivity.class);
                    intent.putExtra("teste", "Olá " + login);
                    startActivity(intent);

                } else{
                    Toast msg1 = Toast.makeText(getApplicationContext(),"Login ou Senha incorretos", Toast.LENGTH_LONG);
                    msg1.show();
                }
            }
        });
    }
}

