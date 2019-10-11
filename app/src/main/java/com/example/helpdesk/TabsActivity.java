package com.example.helpdesk;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

public class TabsActivity extends AppCompatActivity {

    private TabAdapter adpter;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabs);

       // final Button btnNovaMensagem = (Button) findViewById(R.id.botaoNovo);
        final FloatingActionButton botao = (FloatingActionButton) findViewById(R.id.botaoNovo);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        tabLayout = (TabLayout) findViewById(R.id.layoutTab);
        adpter = new TabAdapter(getSupportFragmentManager());
        adpter.addFragment(new ChamadosAberto(), "Aberto");
        adpter.addFragment(new ChamadosAberto(), "Solução");
        adpter.addFragment(new ChamadosAberto(), "Fechado");
        viewPager.setAdapter(adpter);
        tabLayout.setupWithViewPager(viewPager);


              botao.setOnClickListener(new View.OnClickListener() {
                 @Override
                   public void onClick(View view) {

                      Intent novaTela = new Intent(TabsActivity.this, NovoChamado.class);
                      novaTela.putExtra("teste", "Crie um novo chamado " );
                     startActivity(novaTela);

            }
        });

    }
}



      //      final Button botao = (Button) findViewById(R.id.botaoNovo);

     //       botao.setOnClickListener(new View.OnClickListener() {
    //            @Override
    //            public void onClick(View view) {

      //              Intent intent = new Intent(TabsActivity.this, NovoChamado.class);
                    //intent.putExtra("teste", "Olá " + login);
      //              startActivity(intent);

           //     }
        //    });
     //   }
  //  }




