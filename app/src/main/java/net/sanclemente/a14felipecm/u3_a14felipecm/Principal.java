package net.sanclemente.a14felipecm.u3_a14felipecm;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Principal extends Activity {

    Button boton_toast;

    private static final int COD_PETICION_SECUNDARIA = 200;
    private static final int DIALOGO_ACCION = 1;

    //Variable para crear los dialogs
    AlertDialog.Builder dialogo;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        //Listener para el boton datos, que muestra un toast
        boton_toast = (Button) findViewById(R.id.boton_data);
        boton_toast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (savedInstanceState != null) {
                    Toast.makeText(Principal.this, savedInstanceState.getString("TELEFONO"), Toast.LENGTH_SHORT).show();
                    Toast.makeText(Principal.this, savedInstanceState.getString("TEXTO"), Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(Principal.this, "No hay nada", Toast.LENGTH_SHORT).show();
                }
            }
        });

        //Listener para la pulsacion larga del boton
        Button boton = (Button) findViewById(R.id.boton_dtb);
        boton.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                // TODO Auto-generated method stub
                showDialog(1);
                return true;
            }
        });
    }


    public void lanzarSegunda(View v){
        Intent intent = new Intent(this, Secundaria.class);
        startActivityForResult(intent, COD_PETICION_SECUNDARIA);
    }

    /*public void mostrarToastStrings(View v){
        Bundle extras=getIntent().getExtras();
        //savedInstanceState.get()
        Toast.makeText(Principal.this, extras.getString("TELEFONO").toString(), Toast.LENGTH_SHORT).show();
    }*/

    @Override
    protected Dialog onCreateDialog(int id){
        dialogo = new AlertDialog.Builder(this);
        dialogo.setTitle(getResources().getString(R.string.alert_dialog_titulo));
        dialogo.setMessage(getResources().getString(R.string.alert_dialog_texto1));
        dialogo.setIcon(android.R.mipmap.sym_def_app_icon);
        dialogo.setCancelable(false);
        dialogo.setPositiveButton(getResources().getString(R.string.alert_boton_buscar), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Bundle estado = getIntent().getExtras();
                String terminoBuscar= getResources().getString(R.string.string_default_busqueda);
                if(estado !=null){
                    terminoBuscar=estado.getString("TEXTO");
                }
                Intent intent = new Intent(Intent.ACTION_WEB_SEARCH, Uri.parse(terminoBuscar));
                startActivity(intent);
                //Toast.makeText(Principal.this, "Buscar", Toast.LENGTH_SHORT).show();
            }
        });
        dialogo.setNegativeButton(getResources().getString(R.string.alert_boton_llamar), new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Bundle estado = getIntent().getExtras();
                if(estado != null){
                    Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse(estado.getString("TELEFONO")));
                    startActivity(intent);
                    //Toast.makeText(Principal.this, "Llamamos por telefono a: "+estado.getString("TELEFONO"), Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(Principal.this, getResources().getString(R.string.toast_aviso), Toast.LENGTH_SHORT).show();
                }

            }
        });
        return dialogo.create();
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if (requestCode == COD_PETICION_SECUNDARIA){
            if (resultCode == RESULT_OK) {
                if(data.hasExtra("TELEFONO")) {
                    Bundle estado =data.getExtras();
                    //estado.putString("TEXTO", data.getExtras().getString("TEXTO"));
                    //estado.putString("TELEFONO", data.getExtras().getString("TELEFONO"));
                    //Toast.makeText(Principal.this, data.getExtras().getString("TELEFONO"), Toast.LENGTH_SHORT).show();
                    //this.onRestoreInstanceState(estado);

                    this.onRestoreInstanceState(estado);
                    this.onSaveInstanceState(estado);
                    this.onCreate(estado);
                }else{
                    Toast.makeText(Principal.this, "No hay nada", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }
/*    @Override
    protected void onRestart() {
        super.onRestart();  // Always call the superclass method first
        Toast.makeText(Principal.this, "On restart", Toast.LENGTH_SHORT).show();
        // Activity being restarted from stopped state
    }*/


    @Override
    protected void onSaveInstanceState(Bundle estado) {
        //estado.putString("TELEFONO", et.getText().toString());
        estado.putString("TELEFONO", estado.getString("TELEFONO"));
        estado.putString("TEXTO", estado.getString("TEXTO"));
        super.onSaveInstanceState(estado);
        Toast.makeText(Principal.this, estado.getString("TELEFONO")+"saveinstance",Toast.LENGTH_SHORT).show();

        //Toast.makeText(this, "Gardado estado: "+et.getText(), Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState){
        super.onRestoreInstanceState(savedInstanceState);
        Toast.makeText(Principal.this, savedInstanceState.getString("TELEFONO")+"restoreinstace", Toast.LENGTH_SHORT).show();
/*        savedInstanceState.putString("TELEFONO", savedInstanceState.getString("TELEFONO"));
        savedInstanceState.putString("TEXTO", savedInstanceState.getString("TEXTO"));*/
    }

    @Override
    protected void onPause() {
        super.onPause();

        Toast.makeText(this, "Execútase: onPause. Aproveitar para gardar información por se se destrúe", Toast.LENGTH_SHORT).show();
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
