package com.example.helpdesk;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.helpdesk.model.Mensagem;
import com.example.helpdesk.model.Status;

import java.util.ArrayList;
import java.util.List;

public class Tab3Fragment extends Fragment {

    ListView listViewMensagensFechada;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_three, container, false);

        listViewMensagensFechada = (ListView) view.findViewById(R.id.lista_mensagens_fechada);

        List<Mensagem> mensagens = new ArrayList<Mensagem>();

        for(int i=99; i < 150; i++)
            mensagens.add(new Mensagem(1L, "Mensagem " + i, Status.NAOENVIADA));

        ArrayAdapter<Mensagem> adapter = new ArrayAdapter<Mensagem>(getActivity(),
                android.R.layout.simple_list_item_1, mensagens);

        listViewMensagensFechada.setAdapter(adapter);

        return view;
    }
}