package com.example.momento_uno;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import com.example.momento_uno.Model.NotaM;

import com.example.momento_uno.Opearation.OperationN;
import com.google.android.material.snackbar.Snackbar;


public class RegistroActivity extends AppCompatActivity {

    private OperationN operationN;
    private Button btn_registro_guardar;
    private EditText et_Nombre_Usuario, et_Nota_Usuario;
    private NotaM model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        et_Nombre_Usuario = findViewById(R.id.et_Nombre_Usuario);
        et_Nota_Usuario = findViewById(R.id.et_Nota_Usuario);
        btn_registro_guardar= findViewById(R.id.btn_registro_guardar);
        operationN =new OperationN(getApplicationContext());

        btn_registro_guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre,nota;
                nombre = et_Nombre_Usuario.getText().toString();
                nota = et_Nota_Usuario.getText().toString();

                model = new NotaM(nombre, nota);
                int a;
                a = operationN.insert(model);
                operationN.Close();
                if (a > 0){
                    Intent intent = new Intent(RegistroActivity.this, MainActivity.class);
                    startActivity(intent);
                }else{
                    Snackbar.make(v, "No se guardó", Snackbar.LENGTH_LONG).show();
                }
            }
        });
    }
}
