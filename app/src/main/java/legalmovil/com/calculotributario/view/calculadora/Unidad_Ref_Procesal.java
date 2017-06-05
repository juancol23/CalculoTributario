package legalmovil.com.calculotributario.view.calculadora;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import legalmovil.com.calculotributario.R;

public class Unidad_Ref_Procesal extends AppCompatActivity {
    private EditText campoValor;
    private TextView campoResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unidad__ref__procesal);

        campoValor = (EditText) findViewById(R.id.campoValor);
        campoResultado = (TextView) findViewById(R.id.campoResultado);



        campoValor.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if (!campoValor.getText().toString().equals(""))
                {
                    if(campoValor.getText().toString()!="") {
                        Integer aux1 = Integer.valueOf(campoValor.getText().toString());
                        // if ((aux1 != null)) {
                        double multiplo = 405;
                        double resultado = aux1 * multiplo;
                        campoResultado.setText("" + resultado);
                        //}

                    }
                }

            }

            @Override
            public void afterTextChanged(Editable s) {


            }
        });


    }

    public void onClickCalAs(View v){
        Intent i = new Intent(Unidad_Ref_Procesal.this,MenuCalculadora.class);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(i);
    }
}
