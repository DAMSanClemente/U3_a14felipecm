package net.sanclemente.a14felipecm.u3_a14felipecm;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class Secundaria extends Activity {

    private EditText textoBusqueda;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secundaria);

        textoBusqueda = (EditText) findViewById(R.id.edit_texto);
    }

    public void cerrarSecundaria(View v){
        EditText textoTelefono = (EditText) findViewById(R.id.edit_telefono);
        Intent intent = new Intent();
        intent.putExtra("TEXTO", textoBusqueda.getText().toString());
        intent.putExtra("TELEFONO", textoTelefono.getText().toString());
        setResult(RESULT_OK, intent);
        finish();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_secundaria, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void finish() {
        super.finish();
    }
}
