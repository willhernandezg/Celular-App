package me.willhernandezg.celularapp;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class CrearCelularActivity extends AppCompatActivity {
    private Spinner marcas, colores, sis, ram;
    private EditText cajaCapacidad, cajaPrecio;
    private Resources res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_celular);

        marcas = (Spinner) findViewById(R.id.cmbMarca);
        colores = (Spinner)findViewById(R.id.cmbColor);
        sis = (Spinner)findViewById(R.id.cmbSistema);
        ram = (Spinner)findViewById(R.id.cmbRam);
        cajaPrecio = (EditText)findViewById(R.id.txtPrecio);

        res = this.getResources();

        String opm[] = res.getStringArray(R.array.marcas);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,opm);
        marcas.setAdapter(adapter1);

        String opc[] = res.getStringArray(R.array.colores);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,opc);
        colores.setAdapter(adapter2);

        String ops[] = res.getStringArray(R.array.so);
        ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,ops);
        sis.setAdapter(adapter3);

        String opr[] = res.getStringArray(R.array.ram);
        ArrayAdapter<String> adapter4 = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,opr);
        ram.setAdapter(adapter4);
    }

    public void crear(View v){
        int marca, color, sist, ramc;
        double precio;

        marca = marcas.getSelectedItemPosition();
        color = colores.getSelectedItemPosition();
        sist = sis.getSelectedItemPosition();
        ramc = ram.getSelectedItemPosition();
        precio = Double.parseDouble(cajaPrecio.getText().toString());

        Celular c = new Celular(marca, color,sist,ramc, precio);
        c.guardar();

        Toast.makeText(this, res.getString(R.string.mensaje_guardado), Toast.LENGTH_SHORT).show();
        limpiar();
    }

    public void limpiar(View v){
        limpiar();
    }

    private void limpiar(){
        marcas.setSelection(0);
        colores.setSelection(0);
        sis.setSelection(0);
        ram.setSelection(0);
        cajaPrecio.setText("");
    }
}
