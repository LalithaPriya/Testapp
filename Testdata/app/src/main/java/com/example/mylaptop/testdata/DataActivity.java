package com.example.mylaptop.testdata;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;

public class DataActivity extends AppCompatActivity {

    TextView tv,et;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);
        tv = (TextView)findViewById(R.id.text);
        et = (TextView)findViewById(R.id.edit);

        final SharedPreferences prefs;
        prefs = PreferenceManager.getDefaultSharedPreferences(this);

        et.setText(prefs.getString("autoSave", ""));



        et.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                prefs.edit().putString("autoSave", s.toString()).commit();
                publishprogress
            }
        });

    }
}
