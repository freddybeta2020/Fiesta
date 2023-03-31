package com.example.fiesta;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RadioButton jrbpalco, jrblateral, jrbvip, jrbgeneral, jrbaguardiente,jrbron, jrbwhisky;
    EditText jetcantidad,jetbotella;
    CheckBox jcbpropina;

    TextView jtvtotal;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Ocultar la barra de titulo por defecto
        getSupportActionBar().hide();
        //Asociar los objetos Xml con los objetos Java
        jrbpalco=findViewById(R.id.rbpalco);
        jrblateral=findViewById(R.id.rblateral);
        jrbvip=findViewById(R.id.rbvip);
        jrbgeneral=findViewById(R.id.rbgeneral);
        jrbaguardiente=findViewById(R.id.rbaguardiente);
        jrbron=findViewById(R.id.rbron);
        jrbwhisky=findViewById(R.id.rbwhisky);
        jetcantidad=findViewById(R.id.etcantidad);
        jetbotella=findViewById(R.id.etbotellas);
        jcbpropina=findViewById(R.id.cbpropina);
        jtvtotal=findViewById(R.id.tvtotal);



    }
    public void Calcular(View view){
        String cantidadPersonas;
        String cantidadBotella;
        //Pasar la informacion de un objeto Java a una variables de RAM

        cantidadPersonas=jetcantidad.getText().toString();
        cantidadBotella =jetbotella.getText().toString();

        if(cantidadPersonas.isEmpty() ){
            Toast.makeText(this, "La cantidad es requerida ", Toast.LENGTH_SHORT).show();
            jetcantidad.requestFocus();
        }if(cantidadBotella.isEmpty()){
                Toast.makeText(this, "La cantidad es requerida ", Toast.LENGTH_SHORT).show();
                jetbotella.requestFocus();
        }else{
                int cantidadp,cantidadb,precioPalco=0,precioLicor=0,propina=0;
                float subTotalp,subTotalb,total;
                //Conversion de String a entero
                cantidadp=Integer.parseInt(cantidadPersonas);
                cantidadb=Integer.parseInt(cantidadBotella);
                //Validar que la cantidad de personas sea mayor de cero
               if (cantidadp==0){
                   Toast.makeText(this, "La cantidad de personas debe ser mayor a  0", Toast.LENGTH_SHORT).show();
                   jetcantidad.setText("");
                   jetcantidad.requestFocus();
               }
              if (cantidadb==0){
                Toast.makeText(this, "La cantidad de botellas debe ser mayor a  0", Toast.LENGTH_SHORT).show();
                jetcantidad.setText("");
                jetcantidad.requestFocus();

              }else{
                  if(jrbvip.isChecked()){
                      precioPalco=500000;
                  }
                  if(jrbpalco.isChecked()){
                      precioPalco=350000;
                  }
                  if(jrblateral.isChecked()){
                      precioPalco=250000;
                  }
                  if(jrbgeneral.isChecked()){
                      precioPalco=25000;
                  }
                  if(jrbaguardiente.isChecked()){
                      precioLicor=150000;
                  }
                  if(jrbron.isChecked()){
                      precioLicor=180000;
                  }
                  if (jrbwhisky.isChecked()){
                      precioLicor=250000;
                  }
                  if(jcbpropina.isChecked()){
                      propina=10;
                  }
                }
                subTotalp= precioPalco * cantidadp;
                subTotalb= precioLicor * cantidadb;
                total = subTotalb+subTotalp;

              // imprimir resultados
               jtvtotal.setText(String.valueOf(total));
            }

    }

    public  void  Limpiar(View view){
        jrbpalco.setChecked(true);
        jrbron.setChecked(true);
        jetbotella.setText("");
        jetcantidad.setText("");
        jtvtotal.setText("0");
    }

}