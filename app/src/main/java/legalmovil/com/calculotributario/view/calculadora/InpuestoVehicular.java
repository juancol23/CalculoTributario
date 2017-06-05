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

public class InpuestoVehicular extends AppCompatActivity {


        private EditText campoValor;
        private TextView montoPagar;
        private float vehi = 0.0f;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_inpuesto_vehicular);

            campoValor = (EditText) findViewById(R.id.campoValor);
            montoPagar = (TextView) findViewById(R.id.campo_pagar);


            campoValor.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                }
                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    if (!campoValor.getText().toString().equals(""))
                    {
                        if(campoValor.getText().toString()!="") {

                            //    int UTI = 4050;

                            Double valorProduto = Double.parseDouble(campoValor.getText().toString());
                            if(valorProduto >= 11 ){
                                Double resultado = valorProduto * 0.01;
                                //double aux2 = Integer.valueOf(et2.getText().toString());
                                montoPagar.setText( String.format( "%.2f", resultado ) );
                            }else{
                                montoPagar.setText(String.format("%.2f", 0.0));
                            }


                        }
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


    public void onClickCalAV(View v){
        Intent i = new Intent(InpuestoVehicular.this,MenuCalculadora.class);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(i);
    }
}
