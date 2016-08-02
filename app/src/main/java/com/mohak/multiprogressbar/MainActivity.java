package com.mohak.multiprogressbar;

import android.graphics.Color;
import android.graphics.Paint;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.mohak.mutliprogressbar.MultiProg;

public class MainActivity extends AppCompatActivity {

    private MultiProg multiProg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        multiProg = (MultiProg) findViewById(R.id.multiprogMohak);
        assert multiProg != null;
        new Async().execute();

    }


    public class Async extends AsyncTask<Void, Integer, Void> {


        @Override
        protected Void doInBackground(Void... voids) {

            for (int i = 0; i <= 100; i++) {

                try {
                    Thread.sleep(100);
                    publishProgress(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {

//            prog.setmCurrentProgress(values[0]);
            multiProg.setmCurrentProgress(values[0]);
        }

        @Override
        protected void onPostExecute(Void aVoid) {

            Toast.makeText(MainActivity.this, "Download Complete", Toast.LENGTH_SHORT).show();
        }
    }
}
