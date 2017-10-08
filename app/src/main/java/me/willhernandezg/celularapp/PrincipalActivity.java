package me.willhernandezg.celularapp;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class PrincipalActivity extends AppCompatActivity {
    private ListView lstOpciones;
    private Resources res;
    private String opc[];
    private Intent i;
    private Context contexto;
    private String color[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        lstOpciones = (ListView)findViewById(R.id.lstOpciones);
        res = this.getResources();
        contexto = this;
        color = res.getStringArray(R.array.colores);


        opc = res.getStringArray(R.array.opciones);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, opc);

        lstOpciones.setAdapter(adapter);
        lstOpciones.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long l) {
                switch (pos){
                    case 0:
                        i = new Intent(PrincipalActivity.this, CrearCelularActivity.class);
                        startActivity(i);
                        break;
                    case 1:
                        i = new Intent(PrincipalActivity.this, ListarActivity.class);
                        startActivity(i);
                        break;
                    case 2:
                        ArrayList<Celular> celulares = Metodos.ram_samsung(Datos.obtenerCelulares());
                        String mostrar = "";
                        for (int i = 0; i < celulares.size(); i++) {
                            mostrar += "[" + color[celulares.get(i).getColor()] + ", " + celulares.get(i).getRam() + ", " + celulares.get(i).getPrecio()+ "]";
                        }
                        Toast.makeText(contexto, mostrar, Toast.LENGTH_LONG).show();
                        break;
                    case 3:
                        Toast.makeText(contexto, Metodos.apple_negros(Datos.obtenerCelulares())+"", Toast.LENGTH_SHORT).show();
                        break;
                    case 4:
                        Toast.makeText(contexto, Metodos.promedio_nokia(Datos.obtenerCelulares())+"", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
    }
}
