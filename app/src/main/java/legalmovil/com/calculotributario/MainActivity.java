package legalmovil.com.calculotributario;

import android.os.AsyncTask;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    private Button btnDes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btnDes = (Button) findViewById(R.id.btnDes);

        btnDes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //DownloadFiles();
                new Thread(new Runnable() {
                    public void run() {
                        DownloadFiles();
                    }
                }).start();

            }
        });

    }

    public void DownloadFiles(){

        try {
            URL u = new URL("https://github.com/juanvaldemar/legal/raw/gh-pages/Jurisprudencia/Civil/ACCESI%C3%93N%20DE%20PROPIEDAD%20POR%20EDIFICACI%C3%93N/INCUMPLIMIENTO%20DE%20LOS%20REQUISISTOS%20DE%20PROCEDENCIA/Resolucion%20001682-2012-1396666994011.pdf");
            InputStream is = u.openStream();

            DataInputStream dis = new DataInputStream(is);

            byte[] buffer = new byte[1024];
            int length;

            FileOutputStream fos = new FileOutputStream(new File(Environment.getExternalStorageDirectory() + "/" + "data/s"));
            while ((length = dis.read(buffer))>0) {
                fos.write(buffer, 0, length);
            }

        } catch (MalformedURLException mue) {
            Log.e("SYNC getUpdate", "malformed url error", mue);
        } catch (IOException ioe) {
            Log.e("SYNC getUpdate", "io error", ioe);
        } catch (SecurityException se) {
            Log.e("SYNC getUpdate", "security error", se);
        }
    }

}

