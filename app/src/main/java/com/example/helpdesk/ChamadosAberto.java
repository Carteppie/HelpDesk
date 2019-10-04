package com.example.helpdesk;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import androidx.fragment.app.Fragment;

import com.example.helpdesk.api.ChamadoTask;
import com.example.helpdesk.api.MensagemTask;
import com.example.helpdesk.api.OnEventListener;
import com.example.helpdesk.model.Mensagem;
import com.example.helpdesk.model.Chamado;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;

public class ChamadosAberto extends Fragment {

    ListView listViewMensagensEnviadas;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.fragment_one, container, false);

        final List<Mensagem> mensagens = new ArrayList<Mensagem>();


          ChamadoTask chamadoTask = new ChamadoTask(view.getContext(), new OnEventListener<String>() {


            @Override
            public void onSuccess(String result) {
                Toast.makeText(view.getContext(), "SUCCESS: " + result, Toast.LENGTH_LONG).show();
                Gson gson = new Gson();
                Chamado[] mensagens = gson.fromJson(result, Chamado[].class);

                ArrayAdapter<Chamado> adapter = new ArrayAdapter<Chamado>(getActivity(),
                        android.R.layout.simple_list_item_1, mensagens);

                listViewMensagensEnviadas = (ListView) view.findViewById(R.id.lista_mensagens_enviadas);
                listViewMensagensEnviadas.setAdapter(adapter);
            }

            @Override
            public void onFailure(Exception e) {
                Toast.makeText(view.getContext(), "ERROR: " + e.getMessage(), Toast.LENGTH_LONG).show();
            }
        });

        chamadoTask.execute();
        return view;
    }
}
            // public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

  //      final View view = inflater.inflate(R.layout.fragment_one, container, false);

   //     listViewMensagensEnviadas = (ListView) view.findViewById(R.id.lista_mensagens_enviadas);

  //      List<Mensagem> mensagems = new ArrayList<Mensagem>();

  //      for(int i=0; i<30; i++)
  //          mensagems.add(new Mensagem(1L, "Mensagem " + i, Status.ENVIADA));

  //      ArrayAdapter<Mensagem> adapter = new ArrayAdapter<Mensagem>(getActivity(),
  //              android.R.layout.simple_list_item_1, mensagems);

  //      listViewMensagensEnviadas.setAdapter(adapter);
