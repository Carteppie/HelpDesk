package com.example.helpdesk;

import androidx.appcompat.app.AppCompatActivity;
import androidx.collection.ArrayMap;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.example.helpdesk.api.APIService;
import com.example.helpdesk.api.ApiUtils;
import org.json.JSONObject;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;

public class NovoChamado extends AppCompatActivity {

        private APIService mAPIService;
        private TextView mResponseTv;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.novo_chamado);

            final EditText edtMensagem = (EditText) findViewById(R.id.edt_mensagem);
            Button btnEnviarMensagem = (Button) findViewById(R.id.btn_enviar_mensgem);

            mAPIService = ApiUtils.getService();

            btnEnviarMensagem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    String mensagem = edtMensagem.getText().toString().trim();

                    if (!TextUtils.isEmpty(mensagem)) {
                        enviarMensagem(mensagem, getApplicationContext());
                    }

                }
            });
        }

        public void enviarMensagem(String descricao, final Context context) {


            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");

            Date dataEnvio = new Date();
            mAPIService = ApiUtils.getService();

            Map<String, String> jsonParams = new ArrayMap<>();
            jsonParams.put("Descricao", descricao);
            jsonParams.put("dataEnvio", sdf.format(dataEnvio.getTime()));

            RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8"),(new JSONObject(jsonParams)).toString());

            Call<ResponseBody> response = mAPIService.salvarMensagem(body);

            response.enqueue(new Callback<ResponseBody>()
            {
                @Override
                public void onResponse(Call<ResponseBody> call, retrofit2.Response<ResponseBody> rawResponse)
                {
                    try
                    {
                        Toast.makeText(context, "Enviada com sucesso!!!", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(NovoChamado.this, TabsActivity.class);
                        startActivity(intent);
                    }
                    catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                }

                @Override
                public void onFailure(Call<ResponseBody> call, Throwable throwable)
                {
                    // other stuff...
                    Toast.makeText(context, "O Envio da mensagem falhou!!!", Toast.LENGTH_SHORT).show();
                }
            });
        }

    }
