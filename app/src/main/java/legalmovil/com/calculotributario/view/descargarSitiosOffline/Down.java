package legalmovil.com.calculotributario.view.descargarSitiosOffline;

import android.app.DownloadManager;

import android.content.Context;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;
import com.koushikdutta.ion.ProgressCallback;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;

import legalmovil.com.calculotributario.R;

public class Down extends AppCompatActivity {

    private static final String TAG = "TAG";
    Button btnDescargar,btnDescargar2,btnDescargar3;
    DownloadManager downloadManager;

    static int fCount = 0;
    private static boolean mDownloading = true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_down);


       // isExternalStorageWritable();
      //  isExternalStorageReadable();


        btnDescargar = (Button) findViewById(R.id.btnD);
        btnDescargar2 = (Button) findViewById(R.id.btnD2);
        btnDescargar3 = (Button) findViewById(R.id.btnD3);

        btnDescargar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              /*  downloadManager = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);
                Uri uri = Uri.parse("http://legalmovil.com/offline/penal/penal.pdf");
                DownloadManager.Request request = new DownloadManager.Request(uri);
                request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
                Long reference = downloadManager.enqueue(request);
                Toast.makeText(getApplicationContext(),"eliminado", Toast.LENGTH_LONG).show();
*/
                File direct = new File(Environment.getExternalStorageDirectory() + "/DirName");

               /* if (!direct.exists()) {
                    File wallpaperDirectory = new File("/sdcard/DirName/");
                    wallpaperDirectory.mkdirs();
                }*/
               // File file = new File(new File("/storage/sdcard/DirName/"), "comercio.html");
              //  File file = getBaseContext().getFileStreamPath("/sdcard/DirName/comercio.html");

               /* File ruta_sd = Environment.getExternalStorageDirectory();

                File file = new File(ruta_sd.getAbsolutePath(), "prueba_sd.txt");

                if (file.exists()) {

                    Log.e(TAG, "delete: " + file.delete());
                    Log.e(TAG, "existe: " + file.exists());
                }*/
                try {
                    File ruta_sd = Environment.getExternalStorageDirectory();


                    File file = new File("file:///android_asset");
                    OutputStreamWriter fout =
                            new OutputStreamWriter(
                                    new FileOutputStream(file));

                    fout.write("Texto de prueba.");
                    fout.close();
                    Log.e(TAG, "creado: " + file.exists());
/*
                    downloadManager = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);
                    Uri uri = Uri.parse("https://legalmovil.com/Codigos/c_de_comercio.html");
                    DownloadManager.Request request = new DownloadManager.Request(uri);
                    request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
                    //request.setTitle("Comercio");
                  //  request.setDestinationInExternalPublicDir(Environment.getExternalStorageDirectory(),"/sdcard/DirName/","comercio.html");
                    request.setDestinationInExternalFilesDir(Down.this,"/sdcard/DirName/","comercio.html");

                    Long reference = downloadManager.enqueue(request);*/

                } catch (Exception e) {
                    e.printStackTrace();
                }

            }

        });

        btnDescargar2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               /* downloadManager = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);
                Uri uri = Uri.parse("http://legalmovil.com/offline/1.png");
                DownloadManager.Request request = new DownloadManager.Request(uri);
                request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
                Long reference = downloadManager.enqueue(request);*/
                String name ="index.html";

                File direct = new File(Environment.getExternalStorageDirectory() + "/DirName");

                if (!direct.exists()) {
                    File wallpaperDirectory = new File("/sdcard/DirName/");
                    wallpaperDirectory.mkdirs();
                }else{

                    File file = new File(new File("/sdcard/DirName/"), name);

                    if (file.exists())
                        file.delete();
                    try {
                        downloadManager = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);
                        Uri uri = Uri.parse("https://legalmovil.com/Codigos/c_de_comercio.html");
                        DownloadManager.Request request = new DownloadManager.Request(uri);
                        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
                        //request.setTitle("Comercio");
                        request.setDestinationInExternalFilesDir(Down.this,"/sdcard/DirName/",name);
                        Long reference = downloadManager.enqueue(request);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        btnDescargar3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                File mydownload = new File (Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)+ "/OffCod2");

                if (!mydownload.exists()){
                    mydownload.mkdir();
                }
               // Toast.makeText(getApplicationContext(),"Borrado"+mydownload, Toast.LENGTH_LONG).show();
                downloadManager = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);
                Uri uri = Uri.parse("https://legalmovil.com/Codigos/c_de_comercio.html");
                DownloadManager.Request request = new DownloadManager.Request(uri);
                request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
                //request.setTitle("Comercio");
                request.setDestinationInExternalFilesDir(Down.this,"/sdcard/DirName/","index.html");
                Long reference = downloadManager.enqueue(request);

            }
        });
    }

    private void createDirectoryAndSaveFile(Bitmap imageToSave, String fileName) {

        File direct = new File(Environment.getExternalStorageDirectory() + "/DirName");

        if (!direct.exists()) {
            File wallpaperDirectory = new File("/sdcard/DirName/");
            wallpaperDirectory.mkdirs();
        }
        File file = new File(new File("/sdcard/DirName/"), "comercio.html");

        if (file.exists())
            file.delete();
        try {
            downloadManager = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);
            Uri uri = Uri.parse("https://legalmovil.com/Codigos/c_de_comercio.html");
            DownloadManager.Request request = new DownloadManager.Request(uri);
            request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
            //request.setTitle("Comercio");
            request.setDestinationInExternalFilesDir(Down.this,"/sdcard/DirName/","comercio.html");
            Long reference = downloadManager.enqueue(request);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    void EliminarArchivos(File ArchivoDirectorio) { /* Parametro File (Ruta) */
        if (ArchivoDirectorio.isDirectory()) /* Si es Directorio */
        {
      /* Recorremos sus Hijos y los ELiminamos */
            for (File hijo : ArchivoDirectorio.listFiles())
                EliminarArchivos(hijo); /*Recursividad Para Saber si no hay Subcarpetas */
        }
        else
            ArchivoDirectorio.delete(); /* Si no, se trata de un File ,solo lo Eliminamos*/
    }
    /* Checks if external storage is available for read and write */
    public boolean isExternalStorageWritable() {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state)) {
            Log.e(TAG, "isExternalStorageWritable: true");
            return true;

        }
        Log.e(TAG, "isExternalStorageWritable: false");

        return false;
    }

    /* Checks if external storage is available to at least read */
    public boolean isExternalStorageReadable() {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state) ||
                Environment.MEDIA_MOUNTED_READ_ONLY.equals(state)) {
            Log.e(TAG, "isExternalStorageReadable: true");

            return true;
        }
        Log.e(TAG, "isExternalStorageReadable: false");
        return false;
    }
    public File getAlbumStorageDir(String albumName) {
        // Get the directory for the user's public pictures directory.
        File file = new File(Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_MOVIES), albumName);
        if (!file.mkdirs()) {
            Log.e(TAG, "Directory not created");
        }

        return file;
    }
}




























