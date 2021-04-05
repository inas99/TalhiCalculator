package hr.tvz.android.talhiCalculator;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Handler;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.tvz.android.talhiCalculator.R;


import java.util.Locale;

public class MainActivity extends AppCompatActivity {



    private Handler mHandler = new Handler();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);


        Button changeLang = findViewById(R.id.changeMyLang);
        changeLang.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                //show AlertDialog to display list of languages, one can be selected
                showChangeLanguageDialog ();

            }

        });


        //Making this activity splashscreen

        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent splashIntent = new Intent(MainActivity.this,conversion_center.class);
                splashIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(splashIntent);

            }
        },5000);

    }

    private void showChangeLanguageDialog()
    {
        //array of languages to display in alert dialog
        final String[] listItems = {"English", "Français", "العربية"  , "Türkçe" , "Española"};
        AlertDialog.Builder mBuilder = new AlertDialog.Builder(MainActivity.this);
        mBuilder.setTitle("choose Language...");
        mBuilder.setSingleChoiceItems(listItems, -1, new DialogInterface.OnClickListener(){

            public void onClick(DialogInterface dialogInterface, int i){
                if (i ==0){
                     //English
                     setLocale("en");
                     recreate();
                }
                if (i ==1){
                    //French
                    setLocale("fr");
                    recreate();
                }
                if (i ==2){
                    //Arabic
                    setLocale("ar");
                    recreate();
                }
                if (i ==3){
                    //Turkish
                    setLocale("tr");
                    recreate();
                }
                if (i ==4){
                    //Spanish
                     setLocale("sp");
                     recreate();
                }

             //dismiss dialog when language selected
             dialogInterface.dismiss();
            }
         });

        AlertDialog mDialog =  mBuilder.create();
        //show alert dialog
        mDialog.show();
    }
    private void setLocale(String lang){
            Locale locale = new Locale(lang);
            Locale.setDefault(locale);
            Configuration config = new Configuration();
            config.locale = locale;
            getBaseContext().getResources().updateConfiguration(config,getBaseContext().getResources().getDisplayMetrics());
            //save data to shared preferances
            SharedPreferences.Editor editor = getSharedPreferences("settings", MODE_PRIVATE ).edit();
            editor.putString("My lang", lang);
            editor.apply();
    }
    //load language saved in shared preferences
    public void loadLocale() {
        SharedPreferences prefs = getSharedPreferences("settings", Activity.MODE_PRIVATE);
        String language = prefs.getString("My_lang", "");
        setLocale(language);

        }


    }








