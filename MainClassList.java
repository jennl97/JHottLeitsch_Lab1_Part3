package com.example.jenniferhott_leitsch.jhott_leitsch_lab1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;


public class MainClassList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_class_list);
        final Switch swDegreeCert = (Switch) findViewById(R.id.swDegreeCert);
        final Spinner spDegree = (Spinner) findViewById(R.id.spnDegree);
        final Spinner spCert = (Spinner) findViewById(R.id.spnCert);
        final TextView txtCertCertificate = (TextView) findViewById(R.id.cert);
        final TextView txtDegree = (TextView) findViewById(R.id.twoYr);
        final Button btnNext = (Button) findViewById(R.id.btnNext);
        final Spinner spMonth = (Spinner) findViewById(R.id.month);

        final EditText firstName = (EditText) findViewById(R.id.enterFName);
        final EditText lastName = (EditText) findViewById(R.id.enterLName);
        final EditText phoneNumber = (EditText) findViewById(R.id.enterPhoneNumber);
        final EditText day = (EditText) findViewById(R.id.enterDay);
        final EditText year = (EditText) findViewById(R.id.enterYear);

        firstName.requestFocus();
        swDegreeCert.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    spDegree.setVisibility(View.VISIBLE);
                    txtDegree.setVisibility(View.VISIBLE);
                    spCert.setVisibility(View.GONE);
                    txtCertCertificate.setVisibility(View.GONE);
                } else {
                    spDegree.setVisibility(View.GONE);
                    txtDegree.setVisibility(View.GONE);
                    spCert.setVisibility(View.VISIBLE);
                    txtCertCertificate.setVisibility(View.VISIBLE);

                }
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkData()){
                    String doBirth = "";
                    doBirth = spMonth.getSelectedItem().toString() + "/" + day.getText().toString() + "/" + year.getText().toString();

                    Intent nextScreen = new Intent(MainClassList.this,ChooseClass.class);
                    nextScreen.putExtra("FirstName", firstName.getText().toString());
                    nextScreen.putExtra("LastName", lastName.getText().toString());
                    nextScreen.putExtra("Phone", phoneNumber.getText().toString());
                    nextScreen.putExtra("BirthDate", doBirth);

                    if (spDegree.getVisibility() == View.VISIBLE){
                        nextScreen.putExtra("isDegreeCert","Degree");
                        nextScreen.putExtra("degreeCert", spDegree.getSelectedItem().toString());
                    } else {
                        nextScreen.putExtra("isDegreeCert", "Certificate");
                        nextScreen.putExtra("degreeCert", spCert.getSelectedItem().toString());
                    }
                    startActivity(nextScreen);
                }
            }
        });



    }


    private boolean checkData(){
        final EditText firstName = (EditText) findViewById(R.id.enterFName);
        final EditText lastName = (EditText) findViewById(R.id.enterLName);
        final EditText phoneNumber = (EditText) findViewById(R.id.enterPhoneNumber);
        final EditText day = (EditText) findViewById(R.id.enterDay);
        final EditText year = (EditText) findViewById(R.id.enterYear);

        if (firstName.getText().toString().isEmpty()){
            //error
            firstName.setError("Invalid First Name");
            firstName.requestFocus();
            return false;
        }

        if (lastName.getText().toString().isEmpty()){
            //error
            lastName.setError("Invalid Last Name");
            lastName.requestFocus();
            return false;
        }

        if (phoneNumber.getText().toString().isEmpty()){
            //error
            phoneNumber.setError("Invalid Phone Number");
            phoneNumber.requestFocus();
            return false;
        }

        if (day.getText().toString().isEmpty()){
            //error
            day.setError("Invalid Date Selection");
            day.requestFocus();
            return false;
        }

        if (year.getText().toString().isEmpty()){
            //error
            year.setError("Invalid Date Selection");
            year.requestFocus();
            return false;
        }

        return true;
    }
}
