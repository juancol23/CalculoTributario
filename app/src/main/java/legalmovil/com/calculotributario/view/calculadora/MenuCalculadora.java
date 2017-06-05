package legalmovil.com.calculotributario.view.calculadora;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;

import legalmovil.com.calculotributario.MainActivity;
import legalmovil.com.calculotributario.R;

public class MenuCalculadora extends AppCompatActivity implements RewardedVideoAdListener{
    private InterstitialAd mInterstitialAd;
    private RewardedVideoAd mAd;

    private Button calculos_tributarios;
    private Button calculos_Vehicular;
    private Button calculos_igv;
    private Button calculos_igvvv;
    int bonus = 300;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_calculadora);

        mAd = MobileAds.getRewardedVideoAdInstance(this);
        mAd.setRewardedVideoAdListener(this);
        loadRewardedVideoAd();


        final AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);


        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());

        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                // Load the next interstitial.
                mInterstitialAd.loadAd(new AdRequest.Builder().build());
            }

        });



        calculos_tributarios =(Button) findViewById(R.id.impuesstoAlcabala);
        String Fuente_Rutas = "font/Roboto-Light.ttf";  //definimos un STRING con el valor PATH ( o ruta por                                                                                 //donde tiene que buscar ) de nuetra fuente
        Typeface TFs = Typeface.createFromAsset(getAssets(),Fuente_Rutas);
        //llamanos a la CLASS TYPEFACE y la definimos con un CREATE desde    //ASSETS con la ruta STRING
        calculos_tributarios.setTypeface(TFs);   //finalmente aplicamos TYPEFACE al TEXTVIEW


        calculos_Vehicular =(Button) findViewById(R.id.impuestoVehicular);
        String Fuente_Rutas1 = "font/Roboto-Light.ttf";  //definimos un STRING con el valor PATH ( o ruta por                                                                                 //donde tiene que buscar ) de nuetra fuente
        Typeface TFs1 = Typeface.createFromAsset(getAssets(),Fuente_Rutas1);
        //llamanos a la CLASS TYPEFACE y la definimos con un CREATE desde    //ASSETS con la ruta STRING
        calculos_Vehicular.setTypeface(TFs1);   //finalmente aplicamos TYPEFACE al TEXTVIEW

        calculos_igv =(Button) findViewById(R.id.impuestoIgv);
        String Fuente_Rutas2 = "font/Roboto-Light.ttf";  //definimos un STRING con el valor PATH ( o ruta por                                                                                 //donde tiene que buscar ) de nuetra fuente
        Typeface TFs2 = Typeface.createFromAsset(getAssets(),Fuente_Rutas2);
        //llamanos a la CLASS TYPEFACE y la definimos con un CREATE desde    //ASSETS con la ruta STRING
        calculos_igv.setTypeface(TFs2);   //finalmente aplicamos TYPEFACE al TEXTVIEW


        calculos_igvvv =(Button) findViewById(R.id.calculos_igvvv);
        String Fuente_Rutas3 = "font/Roboto-Light.ttf";  //definimos un STRING con el valor PATH ( o ruta por                                                                                 //donde tiene que buscar ) de nuetra fuente
        Typeface TFs3 = Typeface.createFromAsset(getAssets(),Fuente_Rutas3);
        //llamanos a la CLASS TYPEFACE y la definimos con un CREATE desde    //ASSETS con la ruta STRING
        calculos_igvvv.setTypeface(TFs3);   //finalmente aplicamos TYPEFACE al TEXTVIEW



    }

    private void loadRewardedVideoAd() {
        mAd.loadAd("ca-app-pub-3940256099942544/5224354917", new AdRequest.Builder().build());
    }

    public void onClickCalculadoraAlcabala(View v){
        if (mAd.isLoaded()) {
            mAd.show();
        }else {

            Intent i = new Intent(MenuCalculadora.this, CalculadoraAlcalada.class);
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(i);
        }

    }
    public void onClickCalVehicular(View v){
        if (mAd.isLoaded()) {
            mAd.show();
        }else {


            Intent i = new Intent(MenuCalculadora.this, InpuestoVehicular.class);
            startActivity(i);
        }
    }

    public void onClickCalIGV(View v){
        if (mAd.isLoaded()) {
            mAd.show();
        }else {


            Intent i = new Intent(MenuCalculadora.this, IgvEntorno.class);
            startActivity(i);
        }
    }


    public void onClickCalURP(View v){
        if (mAd.isLoaded()) {
            mAd.show();
        }else {


            Intent i = new Intent(MenuCalculadora.this, Unidad_Ref_Procesal.class);
            startActivity(i);
        }
    }

    // Required to reward the user.
    @Override
    public void onRewarded(RewardItem reward) {
        //Toast.makeText(this, "onRewarded! currency: " + reward.getType() + "  amount: " +
          //      reward.getAmount(), Toast.LENGTH_SHORT).show();
        Toast.makeText(this, "onRewarded! currency: " + reward.getType() + "  amount: " +
                bonus, Toast.LENGTH_SHORT).show();

        // Reward the user.
    }

    // The following listener methods are optional.
    @Override
    public void onRewardedVideoAdLeftApplication() {
        Toast.makeText(this, "onRewardedVideoAdLeftApplication",
                Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRewardedVideoAdClosed() {
        Toast.makeText(this, "onRewardedVideoAdClosed", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRewardedVideoAdFailedToLoad(int errorCode) {
        Toast.makeText(this, "onRewardedVideoAdFailedToLoad", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRewardedVideoAdLoaded() {
        Toast.makeText(this, "onRewardedVideoAdLoaded", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRewardedVideoAdOpened() {
        Toast.makeText(this, "onRewardedVideoAdOpened", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRewardedVideoStarted() {
        Toast.makeText(this, "onRewardedVideoStarted", Toast.LENGTH_SHORT).show();
    }
}
