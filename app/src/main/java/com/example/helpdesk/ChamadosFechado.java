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
import com.example.helpdesk.api.OnEventListener;
import com.example.helpdesk.model.Chamado;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;


public class ChamadosFechado extends Fragment {

    ListView listViewChamadosFechados;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.fragment_fechado, container, false);

        listViewChamadosFechados = (ListView) view.findViewById(R.id.lista_mensagens_fechada);

        List<Chamado> chamados = new ArrayList<Chamado>();

        ChamadoTask chamadoTask = new ChamadoTask(view.getContext(), new OnEventListener<String>() {


            @Override
            public void onSuccess(String result) {
                Toast.makeText(view.getContext(), "Chamados Fechados " + result , Toast.LENGTH_LONG).show();
                Gson gson = new Gson();
                Chamado[] chamadosFechados = gson.fromJson(result, Chamado[].class);

                ArrayAdapter<Chamado> adapter = new ArrayAdapter<Chamado>(getActivity(),
                        android.R.layout.simple_list_item_2, chamadosFechados);

                listViewChamadosFechados = (ListView) view.findViewById(R.id.lista_mensagens_fechada);
                listViewChamadosFechados.setAdapter(adapter);
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
