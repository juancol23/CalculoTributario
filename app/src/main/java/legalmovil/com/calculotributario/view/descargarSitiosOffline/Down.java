package legalmovil.com.calculotributario.view.descargarSitiosOffline;

import android.app.DownloadManager;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

import legalmovil.com.calculotributario.R;

public class Down extends AppCompatActivity {

    Button btnDescargar,btnDescargar2,btnDescargar3;
    DownloadManager downloadManager;
    private String Tag ="TAG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_down);



        btnDescargar = (Button) findViewById(R.id.btnD);
        btnDescargar2 = (Button) findViewById(R.id.btnD2);
        btnDescargar3 = (Button) findViewById(R.id.btnD3);
        btnDescargar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                downloadManager = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);
                Uri uri = Uri.parse("http://legalmovil.com/offline/penal/penal.pdf");
                DownloadManager.Request request = new DownloadManager.Request(uri);
                request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
                Long reference = downloadManager.enqueue(request);
            }
        });

        btnDescargar2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                downloadManager = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);
                Uri uri = Uri.parse("http://legalmovil.com/offline/1.png");
                DownloadManager.Request request = new DownloadManager.Request(uri);
                request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
                Long reference = downloadManager.enqueue(request);
            }
        });

        btnDescargar3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                File mydownload = new File (Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)+ "/OffCod2");

                if (!mydownload.exists()){
                    mydownload.mkdir();
                }

                Toast.makeText(getApplicationContext(),"Borrado"+mydownload, Toast.LENGTH_LONG).show();

                downloadManager = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);
                Uri uri = Uri.parse("https://legalmovil.com/Codigos/c_de_comercio.html");
                DownloadManager.Request request = new DownloadManager.Request(uri);


                request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
                //request.setTitle("Comercio");

                  request.setDestinationInExternalFilesDir(Down.this,"OffCod2","Comer.html");


                Long reference = downloadManager.enqueue(request);






            }
        });


    }


}




























