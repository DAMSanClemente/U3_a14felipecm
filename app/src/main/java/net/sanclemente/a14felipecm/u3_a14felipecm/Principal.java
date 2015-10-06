package net.sanclemente.a14felipecm.u3_a14felipecm;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Principal extends Activity {

    Button boton_toast;

    private static final int COD_PETICION_SECUNDARIA = 200;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        boton_toast = (Button) findViewById(R.id.boton_data);
        //boton_toast.setOnClickListener(new View.OnClickListener() {
            //@Override
            //public void onClick(View v) {
                if(!savedInstanceState.getString("TELEFONO").isEmpty()) {
                    Toast.makeText(Principal.this, savedInstanceState.getString("TELEFONO"), Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(Principal.this, "No hay nada", Toast.LENGTH_SHORT).show();
                }
            //}
        //});
    }


    public void lanzarSegunda(View v){
        Intent intent = new Intent(this, Secundaria.class);
        startActivityForResult(intent, COD_PETICION_SECUNDARIA);
    }

 /*   public void mostrarToastStrings(View v){
        //Bundle extras=getIntent().getExtras();
        //savedInstanceState.get()
        Toast.makeText(Principal.this, extras.getString("TELEFONO"), Toast.LENGTH_SHORT).show();
    }*/

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if (requestCode == COD_PETICION_SECUNDARIA){
            if (resultCode == RESULT_OK){
                if(data.hasExtra("TELEFONO")) {
                    Bundle estado =data.getExtras();
                    //estado.putString("TEXTO", data.getExtras().getString("TEXTO"));
                    //estado.putString("TELEFONO", data.getExtras().getString("TELEFONO"));
                    //Toast.makeText(Principal.this, data.getExtras().getString("TELEFONO"), Toast.LENGTH_SHORT).show();
                    this.onRestoreInstanceState(estado);
                }else{
                    Toast.makeText(Principal.this, "No hay nada", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }



    @Override
    protected void onSaveInstanceState(Bundle estado) {
        //estado.putString("TELEFONO", et.getText().toString());
        super.onSaveInstanceState(estado);
        Toast.makeText(Principal.this, estado.getString("TELEFONO")+"saveinstance",Toast.LENGTH_SHORT).show();
        //Toast.makeText(this, "Gardado estado: "+et.getText(), Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState){
        super.onRestoreInstanceState(savedInstanceState);
        Toast.makeText(Principal.this, savedInstanceState.getString("TELEFONO")+"restoreinstace", Toast.LENGTH_SHORT).show();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_principal, menu);
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
}
