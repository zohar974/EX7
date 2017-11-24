package com.example.madaim.ex7;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    final int REGISTER_CODE = 1;

    public void RegisterInfo(View view)   {
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivityForResult(intent,REGISTER_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == REGISTER_CODE && resultCode== RESULT_OK){
            String gender = data.getStringExtra("Gender");
            String FirstName = data.getStringExtra("First_name");
            String LastName = data.getStringExtra("Last_name");
            if (gender.equals("Male")){
                gender="mr.";
            }
            else{
                gender="mrs.";
            }
            TextView tv = (TextView)findViewById(R.id.TVmain);
            tv.setText(getResources().getString(R.string.welcomeback,gender,FirstName,LastName));

        }
    }
}
