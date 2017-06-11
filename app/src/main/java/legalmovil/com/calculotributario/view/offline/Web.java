package legalmovil.com.calculotributario.view.offline;

import android.app.DownloadManager;
import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import legalmovil.com.calculotributario.R;
import legalmovil.com.calculotributario.view.descargarSitiosOffline.Down;

public class Web extends AppCompatActivity {
        Button btnSincronizar, btnRefrest;
        DownloadManager downloadManager;
    WebView webView1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);

        final File file = new File (Environment
                .getExternalStorageDirectory()
                .getPath() + "/Android/data/"
                + getPackageName()
                + "/files/sdcard/DirName/index.html");

        btnSincronizar = (Button) findViewById(R.id.btnSincronizar);
        btnRefrest =  (Button) findViewById(R.id.btnRefrest);

        webView1 = (WebView) findViewById(R.id.webView1);
        Refrest();

        btnRefrest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (file.exists()) {
                    webView1.loadUrl("file://"
                            + Environment
                            .getExternalStorageDirectory()
                            .getPath() + "/Android/data/"
                            + getPackageName()
                            + "/files/sdcard/DirName/index.html");

                }if(!file.exists()){
                    webView1.loadUrl("file:///android_asset/www/404.html");
                }
            }
        });

        btnSincronizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Environment.getExternalStorageState().equals(
                        Environment.MEDIA_MOUNTED)) {

                    if (file.exists()) {
                        file.delete();
                        if (!file.exists()) {
                        downloadManager = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);
                       // Uri uri = Uri.parse("https://legalmovil.com/Codigos/c_de_comercio.html");
                        Uri uri = Uri.parse("https://legalmovil.com/Codigos/diccionario.html");
                        DownloadManager.Request request = new DownloadManager.Request(uri);
                        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
                        request.setTitle("Título");
                        request.setDestinationInExternalFilesDir(Web.this,"file:///android_asset/www/","index.html");
                        Long reference = downloadManager.enqueue(request);
                        Toast.makeText(Web.this, "Descarga Completa", Toast.LENGTH_SHORT).show();
                        Refrest();

                    }
                }
                } else {
                    Toast.makeText(getApplicationContext(), "Can't write to internal storage ",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public void Refrest(){
        File files = new File (Environment
                .getExternalStorageDirectory()
                .getPath() + "/Android/data/"
                + getPackageName()
                + "/files/sdcard/DirName/index.html");
        if (files.exists()) {
            webView1.loadUrl("file://"
                    + Environment
                    .getExternalStorageDirectory()
                    .getPath() + "/Android/data/"
                    + getPackageName()
                    + "/files/sdcard/DirName/index.html");
        }if(!files.exists()){
            webView1.loadUrl("file:///android_asset/www/404.html");
        }
    }
}

