package com.example.lenovo.myapplication;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    public void DogQuestion(View view){
        Log.d("dDDDDDDD","DSDD");
        TextView textview1 = (TextView) findViewById(R.id.textview1);
        Button button1 = (Button) findViewById(R.id.button1);
        ProgressBar progressbar1 = (ProgressBar) findViewById(R.id.progressbar1);
        ImageView imageview1 = (ImageView) findViewById(R.id.imageview1);
        ImageView imageview2 = (ImageView) findViewById(R.id.imageview2);

        Log.d("6666666666D",this.getString(R.string.button_a));
        if(button1.getText().toString().equals(this.getString(R.string.button_a))){
            AlertDialog.Builder dialog1 = new AlertDialog.Builder(MainActivity.this);
            dialog1.setTitle(R.string.dialog1_title);
            dialog1.setMessage(R.string.dialog1_message);
            dialog1.setCancelable(true);
            dialog1.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int i) {
                    TextView textview1 = (TextView) findViewById(R.id.textview1);
                    Button button1 = (Button) findViewById(R.id.button1);
                    ProgressBar progressbar1 = (ProgressBar) findViewById(R.id.progressbar1);
                    ImageView imageview1 = (ImageView) findViewById(R.id.imageview1);
                    ImageView imageview2 = (ImageView) findViewById(R.id.imageview2);

                    textview1.setText(R.string.textview_b);
                    button1.setText(R.string.button_b);
                    progressbar1.setVisibility(View.GONE);
                    imageview1.setImageResource(R.mipmap.catfury);
                    imageview1.setVisibility(View.VISIBLE);
                    imageview2.setVisibility(View.VISIBLE);
                    Toast.makeText(MainActivity.this, R.string.toast, Toast.LENGTH_SHORT).show();
                }
            });
            dialog1.setNegativeButton(R.string.cancel,new DialogInterface.OnClickListener(){
                public void onClick(DialogInterface dialog, int i){
                    ProgressBar progressbar2 = (ProgressBar) findViewById(R.id.progressbar2);
                    int progress2 =progressbar2.getProgress();
                    if(progress2 < 100){
                        progress2 = progress2 + 40;
                        progressbar2.setProgress(progress2);
                    }
                    else{
                        AlertDialog.Builder dialog2 = new AlertDialog.Builder(MainActivity.this);
                        dialog2.setTitle(R.string.dialog2_title);
                        dialog2.setMessage(R.string.dialog2_message);
                        dialog2.setPositiveButton(R.string.quit,new DialogInterface.OnClickListener(){
                            public void onClick(DialogInterface dialog, int i){
                                MainActivity.this.finish();
                            }
                        });
                        dialog2.show();
                    }
                }
            });
            dialog1.show();
        }
        else {
            textview1.setText(R.string.textview_a);
            button1.setText(R.string.button_a);
            progressbar1.setVisibility(View.VISIBLE);
            imageview1.setImageResource(R.mipmap.ic_launcher);
            imageview1.setVisibility(View.GONE);
            imageview2.setVisibility(View.GONE);
        }
    }
}