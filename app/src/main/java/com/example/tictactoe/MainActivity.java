package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;
import android.app.AlertDialog;
import android.content.DialogInterface;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.widget.TextView;

import kotlin.contracts.Returns;


public class MainActivity extends AppCompatActivity {

    private Button[][] buttons = new Button[3][3];
    private boolean jugador1Turn = true;
    private int rondasJugadas;
    private String textoDelBoton;
    TextView gane;
    TextView cero;
    private String textoBtn00;
    private String textoBtn01;
    private String textoBtn02;
    private String textoBtn10;
    private String textoBtn11;
    private String textoBtn12;
    private String textoBtn20;
    private String textoBtn21;
    private String textoBtn22;
    int sumX;
    int sumO;
    int ConX;
    int ConO;

    String ganador;
    private Double checo;

    String textoX;
    String textoO;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checo=6.0;
        gane = findViewById(R.id.gano);
        cero= findViewById(R.id.cero);

        Button btn00 = findViewById(R.id.btn00);
        Button btn01 = findViewById(R.id.btn01);
        Button btn02 = findViewById(R.id.btn02);
        Button btn10 = findViewById(R.id.btn10);
        Button btn11 = findViewById(R.id.btn11);
        Button btn12 = findViewById(R.id.btn12);
        Button btn20 = findViewById(R.id.btn20);
        Button btn21 = findViewById(R.id.btn21);
        Button btn22 = findViewById(R.id.btn22);

         textoBtn00 = btn00.getText().toString();
         textoBtn01 = btn01.getText().toString();
         textoBtn02 = btn02.getText().toString();
         textoBtn10 = btn10.getText().toString();
         textoBtn11 = btn11.getText().toString();
         textoBtn12 = btn12.getText().toString();
         textoBtn20 = btn20.getText().toString();
         textoBtn21 = btn21.getText().toString();
         textoBtn22 = btn22.getText().toString();


        Bundle  regreso = getIntent().getExtras();
        if (regreso != null) {
            sumX=regreso.getInt("sumX");
            sumO=regreso.getInt("sumO");
        }

        gane.setText("X:"+sumX);
        cero.setText("O:"+sumO);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                String buttonID = "btn" + i + j;
                int resID = getResources().getIdentifier(buttonID, "id", getPackageName());
                buttons[i][j] = findViewById(resID);
                buttons[i][j].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        onButtonClick((Button) v);
                    }
                });
            }
        }

    }
    private void onButtonClick(Button button) {
        Intent i=new Intent(this, Final.class);
        if (!button.getText().toString().equals("")) {

            return;

        }




        textoDelBoton = button.getText().toString();
        if (jugador1Turn) {
            button.setText("X");
            jugador1Turn = !jugador1Turn;
        } else {
            button.setText("O");
            jugador1Turn = !jugador1Turn;
        }

        rondasJugadas++;

        checo= checkForWin(checo);
            if (checo==1.0) {
                sumX++;
                for (int q=0; q<3; q++){
                    for (int w=0; w<3; w++){
                        buttons[q][w].setText("");
                    }
                }

                ganador="X";
                Bundle bundle = new Bundle();
                bundle.putString("clave", ganador);
                bundle.putInt("sumO", sumO);
                bundle.putInt("sumX", sumX);
                i.putExtras(bundle);
                startActivity(i);
            } else if(checo==2.0) {
                sumO++;
                for (int q=0; q<3; q++){
                    for (int w=0; w<3; w++){
                        buttons[q][w].setText("");
                    }
                }
                ganador="O";
                Bundle bundle = new Bundle();
                bundle.putString("clave", ganador);
                bundle.putInt("sumX", sumX);
                bundle.putInt("sumO", sumO);
                i.putExtras(bundle);
                cero.setText("O:"+sumO);
                startActivity(i);

            }
             else if (checo==0.0  && rondasJugadas == 9) {
                for (int q=0; q<3; q++){
                    for (int w=0; w<3; w++){
                        buttons[q][w].setText("");
                    }
                }
                 ganador=":(";
                Bundle bundle = new Bundle();
                bundle.putString("clave", ganador);
                bundle.putInt("sumX", sumX);
                bundle.putInt("sumO", sumO);
                i.putExtras(bundle);
                rondasJugadas=0;
                startActivity(i);
            }
    }

    private double checkForWin(double si) {
        // Verificar victoria en las filas
        for (int i = 0; i < 3; i++) {
            if (("X".equals(buttons[i][0].getText().toString()) && "X".equals(buttons[i][1].getText().toString()) && "X".equals(buttons[i][2].getText().toString())) ||
                    ("O".equals(buttons[i][0].getText().toString()) && "O".equals(buttons[i][1].getText().toString()) && "O".equals(buttons[i][2].getText().toString()))) {
                if("X".equals(buttons[i][0].getText().toString()) || "X".equals(buttons[i][1].getText().toString()) ||
                "X".equals(buttons[i][2].getText().toString())){
                    si=1.0;
                    return si;
                }
                else{
                    si=2.0;
                    return si;
                }
            }else{
                si=0.0;
            }
        }

        // Verificar victoria en las columnas
        for (int j = 0; j < 3; j++) {
            if (("X".equals(buttons[0][j].getText().toString()) && "X".equals(buttons[1][j].getText().toString()) && "X".equals(buttons[2][j].getText().toString())) ||
                    ("O".equals(buttons[0][j].getText().toString()) && "O".equals(buttons[1][j].getText().toString()) && "O".equals(buttons[2][j].getText().toString()))) {
                if("X".equals(buttons[0][j].getText().toString()) || "X".equals(buttons[1][j].getText().toString()) ||
                        "X".equals(buttons[2][j].getText().toString())){
                    si=1.0;
                    return si;
                }
                else{
                    si=2.0;
                    return si;
                }

            }
            else{
                si=0.0;
            }
        }

        // Verificar victoria en diagonales
        if (("X".equals(textoBtn00) &&"X".equals(textoBtn11) &&"X".equals(textoBtn22)) ||
                ("O".equals(textoBtn00) && "O".equals(textoBtn11) && "O".equals(textoBtn22))){

            if("X".equals(textoBtn22)){
                si=1.0;
                return si;
            }
            else{
                si=2.0;
                return si;
            }
        }else{
            si=0.0;
        }

        //return false; // No se ha alcanzado una victoria
        return si;
    }
    private void showMessageBox(String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(message)
                .setPositiveButton("Aceptar", null)
                .show();
    }

}