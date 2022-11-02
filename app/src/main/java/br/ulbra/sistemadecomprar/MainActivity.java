package br.ulbra.sistemadecomprar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    CheckBox cbFeijao, cbCarne, cbLeite, cbArroz;
    Button btntotal;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cbFeijao = (CheckBox) findViewById(R.id.cbFeijao);
        cbCarne = (CheckBox) findViewById(R.id.cbCarne);
        cbLeite = (CheckBox) findViewById(R.id.cbLeite);
        cbArroz = (CheckBox) findViewById(R.id.cbArroz);
        btntotal = (Button) findViewById(R.id.btntotal);
        btntotal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double total = 0;
                if (cbArroz.isChecked()) {
                    total += 2.69;
                }
                if (cbLeite.isChecked()) {
                    total += 5.00;
                }
                if (cbCarne.isChecked()) {
                    total += 10.00;
                }
                if (cbFeijao.isChecked()) {
                    total += 2.30;
                }
            DecimalFormat f = new DecimalFormat("0.00");
                AlertDialog.Builder dialogo = new AlertDialog.Builder(MainActivity.this);
                dialogo.setTitle("aviso");
                dialogo.setMessage("Valor total da compra: " + String.valueOf(f.format(total)));
                dialogo.setNeutralButton("OK", null);
                dialogo.show();
            }
        });
    }
}
