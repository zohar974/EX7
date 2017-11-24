package com.example.madaim.ex7;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class RegisterActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }

    public void afterRegister (View view){
        Intent intent = new Intent(this, MainActivity.class);
        Bundle bundle = new Bundle();
        EditText fn=(EditText) findViewById(R.id.ETfirst);
        EditText ln=(EditText) findViewById(R.id.ETsecond);
        String fnSendBack = fn.getText().toString();
        String lnSendback = ln.getText().toString();
        RadioGroup radioGroup= (RadioGroup)findViewById(R.id.radioGroup);
        int id = radioGroup.getCheckedRadioButtonId();
        RadioButton b = (RadioButton)findViewById(id);
        String gender=b.getText().toString();
        bundle.putString("First_name",fnSendBack);
        bundle.putString("Last_name",lnSendback);
        bundle.putString("Gender",gender);
        intent.putExtras(bundle);
        setResult(RESULT_OK,intent);
        finish();
    }
}
