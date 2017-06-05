package legalmovil.com.calculotributario.view.calculadora;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;

import legalmovil.com.calculotributario.R;

public class IgvEntorno extends AppCompatActivity {
    private EditText mUno, mDos, mTres;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_igv_entorno);
        mUno = (EditText) findViewById(R.id.uno);
        mDos = (EditText) findViewById(R.id.dos);
        mTres = (EditText) findViewById(R.id.tres);




        mUno.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!mUno.getText().toString().equals("")) {
                    if (mUno.getText().toString() != "") {
                        Double valorProduto = Double.parseDouble(mUno.getText().toString());

                        if (valorProduto > 0) {
                            Double resultado = valorProduto / 1.18;
                            Double resultadoTres = 0.0;

                            mDos.setText(String.format("%.2f", resultado ));

                            mTres.setText(String.format("%.2f", resultado *0.18));

                        } else {
                            mDos.setText(String.format("%.2f", 0.0));
                            mTres.setText(String.format("%.2f", 0.0));
                        }
                    }
                }else{
                    mDos.setText(String.format("%.2f", 0.0));
                    mTres.setText(String.format("%.2f", 0.0));
                }
            }
            @Override
            public void afterTextChanged(Editable s) {
                //double aux1 = Integer.valueOf(campoValor.getText().toString());
                // double resultado = aux1 * 0.01f ;

                // montoPagar.setText( String.format( "%.2f", resultado ) );
                //double aux2 = Integer.valueOf(et2.getText().toString());
                // montoPagar.setText(""+resultado);

            }
        });

    }

    public void onClickAnteriorIGV(View v){
        Intent i = new Intent(IgvEntorno.this,MenuCalculadora.class);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(i);
    }

}
