package legalmovil.com.calculotributario.view.splash;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import legalmovil.com.calculotributario.MainActivity;
import legalmovil.com.calculotributario.R;
import legalmovil.com.calculotributario.view.calculadora.MenuCalculadora;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //Toast.makeText(Splash.this, "La Esta vista no lo verás despues de 1 segundo", Toast.LENGTH_LONG).show();
                // Primer parametros ¿donde estoy?,¿a donde voy?.
                startActivity(new Intent(Splash.this, MenuCalculadora.class));
                finish();
            }
        }, 1000);

    }
}
