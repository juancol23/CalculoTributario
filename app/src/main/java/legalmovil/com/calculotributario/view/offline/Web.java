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
        Button btnSincronizar;
        DownloadManager downloadManager;
    WebView webView1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);

        btnSincronizar = (Button) findViewById(R.id.btnSincronizar);
        webView1 = (WebView) findViewById(R.id.webView1);


        btnSincronizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Environment.getExternalStorageState().equals(
                        Environment.MEDIA_MOUNTED)) {
                   /* // execute this when the downloader must be fired
                    DownloadFile downloadFile = new DownloadFile();
                    downloadFile.execute("https://legalmovil.com/Codigos/c_de_comercio.html");*/
                    File file = new File (Environment
                            .getExternalStorageDirectory()
                            .getPath() + "/Android/data/"
                            + getPackageName()
                            + "/files/sdcard/DirName/index.html");
                    if (file.exists()) {
                        file.delete();
                        if (!file.exists()) {
                        downloadManager = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);
                       // Uri uri = Uri.parse("https://legalmovil.com/Codigos/c_de_comercio.html");
                        Uri uri = Uri.parse("https://legalmovil.com/Codigos/c_de_comercio.html");
                        DownloadManager.Request request = new DownloadManager.Request(uri);
                        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
                        request.setTitle("Título");
                        request.setDestinationInExternalFilesDir(Web.this,"/sdcard/DirName/","index.html");
                        Long reference = downloadManager.enqueue(request);
                        Toast.makeText(Web.this, "Descarga Completa", Toast.LENGTH_SHORT).show();
                    }
                }
                } else {
                    Toast.makeText(getApplicationContext(), "Can't write to internal storage ",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
    private class DownloadFile extends AsyncTask<String, Integer, String> {

        @Override
        protected String doInBackground(String... sUrl) {
            try {

                URL url = new URL("https://legalmovil.com/Codigos/c_de_comercio.html");
                URLConnection connection = url.openConnection();
                connection.connect();

                // download the file
                InputStream input = new BufferedInputStream(url.openStream());
                OutputStream output = new FileOutputStream(Environment
                        .getExternalStorageDirectory().getPath()
                        + "/data/"
                        + getPackageName() + "/sdcard/DirName/index.html");

                byte data[] = new byte[1024];
                int count;
                try {
                    while ((count = input.read(data)) != -1)
                        output.write(data, 0, count);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                output.flush();
                output.close();
                input.close();

                Toast.makeText(Web.this, "File downloaded", Toast.LENGTH_SHORT).show();

            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
            return null;
        }
    }

    public void Refrest(View view){
        webView1.loadUrl("file://"
                + Environment
                .getExternalStorageDirectory()
                .getPath() + "/Android/data/"
                + getPackageName()
                + "/files/sdcard/DirName/index.html");
    }
}

