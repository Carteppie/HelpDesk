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

public class ChamadosAberto extends Fragment {

    ListView listViewChamadosEnviados;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.fragment_aberto, container, false);

        final List<Chamado> chamados = new ArrayList<Chamado>();

          ChamadoTask chamadoTask = new ChamadoTask(view.getContext(), new OnEventListener<String>() {

            @Override
            public void onSuccess(String result) {
                Toast.makeText(view.getContext(), "Chamados Aberto " , Toast.LENGTH_LONG).show();
                Gson gson = new Gson();
                Chamado[] chamados1 = gson.fromJson(result, Chamado[].class);

                for (Chamado chamado: chamados1) {
                    if (chamado.getStatus().toLowerCase().equals("aberto")) {

                        chamados.add(chamado);
                    }


                    ArrayAdapter<Chamado> adapter = new ArrayAdapter<Chamado>(getActivity(),
                        android.R.layout.simple_list_item_1, chamados);

                listViewChamadosEnviados = (ListView) view.findViewById(R.id.lista_chamados_enviados);
                listViewChamadosEnviados.setAdapter(adapter);
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
