package com.example.william.weirdform;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etUsername ;
    EditText etPhone ;
    CheckBox cbRemember ;
    Button btnLogin ;
    Button btnCancel ;
    WebView wvHtml ;
    int counter ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialize();

        cbRemember.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean state) {
                if (state) {
                    Toast.makeText(MainActivity.this, etUsername.getText().toString(), Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public void initialize(){
         etUsername = findViewById(R.id.etUsername);
         etPhone = findViewById(R.id.etPhone);
         cbRemember = findViewById(R.id.cbRemember);
         btnLogin = findViewById(R.id.btnLogin);
         btnCancel = findViewById(R.id.btnCancel);
         wvHtml = findViewById(R.id.wvHtml);
         counter = 0;
    }

    public void clickLoginBtn(View view){
        counter = 0;
        cbRemember.setVisibility(View.VISIBLE);

        Log.e("Username : ", etUsername.getText().toString());
        Log.e("Phone : ", etPhone.getText().toString());
    }

    public void clickCancelBtn(View view) {
        counter++;

        if (counter == 1){
            wvHtml.loadUrl("file:///android_asset/page.html");
        }
        else if (counter == 2) {
            wvHtml.loadUrl("https://www.ibsu.edu.ge/en/");
        }
    }
}
