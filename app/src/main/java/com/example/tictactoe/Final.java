package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Final extends AppCompatActivity implements View.OnClickListener{

    Button B;
    TextView ganador;
    TextView cero;
    TextView equis;
    String mensaje;
    TextView alerta;
    int ConX;
    int ConO;
    String textoX;
    String textoO;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);

        B=(Button) findViewById(R.id.again);
        B.setOnClickListener(this);
        alerta=findViewById(R.id.mensaje);
        ganador=findViewById(R.id.gandor);
        cero=findViewById(R.id.conO);
        equis=findViewById(R.id.conX);
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
           mensaje = bundle.getString("clave");
           ConX=bundle.getInt("sumX");
           ConO=bundle.getInt("sumO");
        }
         textoX= String.valueOf(ConX);
         textoO= String.valueOf(ConO);
        equis.setText(textoX);
        cero.setText(textoO);
        ganador.setText(mensaje);
        if(mensaje.equals(":(")){
            alerta.setText("¡EMPATE!");
        }
        else{
            alerta.setText("¡GANADORR!");
        }
    }



    @Override
    public void onClick(View view){

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            mensaje = bundle.getString("clave");
            ConX=bundle.getInt("sumX");
            ConO=bundle.getInt("sumO");
        }

        Intent i=new Intent(this, MainActivity.class);

        Bundle regreso = new Bundle();
        regreso.putInt("sumX", ConX);
        regreso.putInt("sumO", ConO);
        i.putExtras(regreso);


        startActivity(i);
    }
}