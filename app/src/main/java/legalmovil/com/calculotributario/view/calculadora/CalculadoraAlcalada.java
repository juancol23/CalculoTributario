package legalmovil.com.calculotributario.view.calculadora;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import legalmovil.com.calculotributario.R;

public class CalculadoraAlcalada extends AppCompatActivity {
    private EditText campoValor;
    private TextView campoResultado2;
    private TextView textFacebtn;
    private TextView textFacebtnCodigo;
    private float valorUIT = 40500f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora_alcalada);

        textFacebtn =(TextView) findViewById(R.id.monto_alcabal);
        String Fuente_Rutas = "font/Roboto-Light.ttf";  //definimos un STRING con el valor PATH ( o ruta por                                                                                 //donde tiene que buscar ) de nuetra fuente
        Typeface TFs = Typeface.createFromAsset(getAssets(),Fuente_Rutas);
        //llamanos a la CLASS TYPEFACE y la definimos con un CREATE desde    //ASSETS con la ruta STRING
        textFacebtn.setTypeface(TFs);   //finalmente aplicamos TYPEFACE al TEXTVIEW

        textFacebtnCodigo =(TextView) findViewById(R.id.monto_alcabal_resto);
        String Fuente_Rutass = "font/Roboto-Light.ttf";  //definimos un STRING con el valor PATH ( o ruta por                                                                                 //donde tiene que buscar ) de nuetra fuente
        Typeface TFss = Typeface.createFromAsset(getAssets(),Fuente_Rutass);
        //llamanos a la CLASS TYPEFACE y la definimos con un CREATE desde    //ASSETS con la ruta STRING
        textFacebtnCodigo.setTypeface(TFss);   //finalmente aplicamos TYPEFACE al TEXTVIEW




        campoValor = (EditText) findViewById(R.id.campoValor);
        // campoResultado = (EditText) findViewById(R.id.campoResultado);

        campoResultado2 = (TextView) findViewById(R.id.campoResultado2);



       /* btnResultado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double aux1 = Integer.valueOf(campoValor.getText().toString());
                //double aux2 = Integer.valueOf(et2.getText().toString());
                double resultado = aux1 * igv;
                campoResultado2.setText(""+resultado);
            }
        });
*/      campoValor.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!campoValor.getText().toString().equals(""))
                {
                    if(campoValor.getText().toString()!="") {
                        Double valorProduto = Double.parseDouble(campoValor.getText().toString());
                        if(valorProduto >= valorUIT ){
                            Double resultado = (Double) (valorProduto - valorUIT) * 0.03f ;
                            //double aux2 = Integer.valueOf(et2.getText().toString());
                            campoResultado2.setText( String.format( "%.2f", resultado ) );
                        }else{
                            campoResultado2.setText(String.format("%.2f", 0.0));
                        }
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }



    public void onClickCalA(View v){
        Intent i = new Intent(CalculadoraAlcalada.this,MenuCalculadora.class);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(i);
    }
}