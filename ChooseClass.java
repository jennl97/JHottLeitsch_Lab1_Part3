package com.example.jenniferhott_leitsch.jhott_leitsch_lab1;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class ChooseClass extends AppCompatActivity {
    private String firstName = "";
    private String lastName = "";
    private String phone = "";
    private String birthDate = "";
    private String isDegreeCert = "";
    private String degreeCert = "";

    private Toast toastError = null;

    private CheckedTextView ctv1;
    private CheckedTextView ctv2;
    private CheckedTextView ctv3;
    private CheckedTextView ctv4;

    private RadioButton rb1;
    private RadioButton rb2;
    private RadioButton rb3;
    private RadioButton rb4;
    private RadioButton rb5;
    private RadioButton rb6;
    private RadioButton rb7;
    private RadioButton rb8;

    private RadioGroup rg1;
    private RadioGroup rg2;
    private RadioGroup rg3;
    private RadioGroup rg4;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_class);

        ctv1 = findViewById(R.id.ctv1);
        ctv2 = findViewById(R.id.ctv2);
        ctv3 = findViewById(R.id.ctv3);
        ctv4 = findViewById(R.id.ctv4);

        rb1 = findViewById(R.id.rd1);
        rb2 = findViewById(R.id.rd2);
        rb3 = findViewById(R.id.rd3);
        rb4 = findViewById(R.id.rd4);
        rb5 = findViewById(R.id.rd5);
        rb6 = findViewById(R.id.rd6);
        rb7 = findViewById(R.id.rd7);
        rb8 = findViewById(R.id.rd8);



        final Button btnNext = findViewById(R.id.btnNext);

        Bundle extras = getIntent().getExtras();
        if(extras != null){
            firstName = extras.getString("FirstName");
            lastName = extras.getString("LastName");
            phone = extras.getString("Phone");
            birthDate = extras.getString("BirthDate");
            isDegreeCert = extras.getString("isDegreeCert");
            degreeCert = extras.getString("degreeCert");
         }

         btnNext.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {

                 RadioButton radioButton;
                 String cvt1Text = "";
                 String cvt2Text = "";
                 String cvt3Text = "";
                 String cvt4Text = "";

                 String radio1Text = "";
                 String radio2Text = "";
                 String radio3Text = "";
                 String radio4Text = "";

                 rg1 = findViewById(R.id.rg1);
                 rg2 = findViewById(R.id.rg2);
                 rg3 = findViewById(R.id.rg3);
                 rg4 = findViewById(R.id.rg4);
                 int selectedTime1 = 0, selectedTime2 = 0, selectedTime3 = 0, selectedTime4 = 0;

                 if (ctv1.isChecked()){
                     cvt1Text = ctv1.getText().toString();
                     selectedTime1 = rg1.getCheckedRadioButtonId();
                     radioButton = findViewById(selectedTime1);
                     radio1Text = radioButton.getText().toString();
                     }

                 if (ctv2.isChecked()){
                     cvt2Text = ctv2.getText().toString();
                     selectedTime2 = rg2.getCheckedRadioButtonId();
                     radioButton = findViewById(selectedTime2);
                     radio2Text = radioButton.getText().toString();
                 }
                 if (ctv3.isChecked()){
                     cvt3Text = ctv3.getText().toString();
                     selectedTime3 = rg3.getCheckedRadioButtonId();
                     radioButton = findViewById(selectedTime3);
                     radio3Text = radioButton.getText().toString();
                 }
                 if (ctv4.isChecked()){
                     cvt4Text = ctv4.getText().toString();
                     selectedTime4 = rg4.getCheckedRadioButtonId();
                     radioButton = findViewById(selectedTime4);
                     radio4Text = radioButton.getText().toString();
                 }

                 if (radioCheck(selectedTime1, selectedTime2, selectedTime3, selectedTime4)){
                     Intent nextScreen = new Intent(ChooseClass.this, Summary.class);
                     nextScreen.putExtra("FirstName", firstName);
                     nextScreen.putExtra("LastName", lastName);
                     nextScreen.putExtra("Phone", phone);
                     nextScreen.putExtra("BirthDate", birthDate);
                     nextScreen.putExtra("isDegreeCert", isDegreeCert);
                     nextScreen.putExtra("degreeCert", degreeCert);

                     nextScreen.putExtra("Class1", cvt1Text);
                     nextScreen.putExtra("Selected1", radio1Text);

                     nextScreen.putExtra("Class2",cvt2Text);
                     nextScreen.putExtra("Selected2", radio2Text);

                     nextScreen.putExtra("Class3", cvt3Text);
                     nextScreen.putExtra("Selected3",radio3Text);

                     nextScreen.putExtra("Class4", cvt4Text);
                     nextScreen.putExtra("Selected4", radio4Text);

                     startActivity(nextScreen);

                 } else {
                     Toast.makeText(getApplicationContext(),"Timeslot conflict.", Toast.LENGTH_SHORT).show();
                 }

                 }
         });

        rb1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                rb1.setError(null);
                rb2.setError(null);
                rb3.setError(null);
                rb4.setError(null);
                rb5.setError(null);
                rb6.setError(null);
                rb7.setError(null);
                rb8.setError(null);
            }
        });

        rb2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                rb1.setError(null);
                rb2.setError(null);
                rb3.setError(null);
                rb4.setError(null);
                rb5.setError(null);
                rb6.setError(null);
                rb7.setError(null);
                rb8.setError(null);
            }
        });

        rb3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                rb1.setError(null);
                rb2.setError(null);
                rb3.setError(null);
                rb4.setError(null);
                rb5.setError(null);
                rb6.setError(null);
                rb7.setError(null);
                rb8.setError(null);
            }
        });
        rb4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                rb1.setError(null);
                rb2.setError(null);
                rb3.setError(null);
                rb4.setError(null);
                rb5.setError(null);
                rb6.setError(null);
                rb7.setError(null);
                rb8.setError(null);
            }
        });
        rb5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                rb1.setError(null);
                rb2.setError(null);
                rb3.setError(null);
                rb4.setError(null);
                rb5.setError(null);
                rb6.setError(null);
                rb7.setError(null);
                rb8.setError(null);
            }
        });
        rb6.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                rb1.setError(null);
                rb2.setError(null);
                rb3.setError(null);
                rb4.setError(null);
                rb5.setError(null);
                rb6.setError(null);
                rb7.setError(null);
                rb8.setError(null);
            }
        });
        rb7.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                rb1.setError(null);
                rb2.setError(null);
                rb3.setError(null);
                rb4.setError(null);
                rb5.setError(null);
                rb6.setError(null);
                rb7.setError(null);
                rb8.setError(null);
            }
        });
        rb8.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                rb1.setError(null);
                rb2.setError(null);
                rb3.setError(null);
                rb4.setError(null);
                rb5.setError(null);
                rb6.setError(null);
                rb7.setError(null);
                rb8.setError(null);
            }
        });

        ctv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ctv1.isChecked()){
                    enableDisable(ctv1,rb1,rb2, Color.BLUE, false);
                } else {
                    enableDisable(ctv1,rb1,rb2, Color.WHITE, true);
                }
            }
        });

        ctv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ctv2.isChecked()){
                    enableDisable(ctv1,rb3,rb4, Color.BLUE, false);
                } else {
                    enableDisable(ctv1,rb3,rb4, Color.WHITE, true);
                }
            }
        });

        ctv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ctv3.isChecked()){
                    enableDisable(ctv1,rb5,rb6, Color.BLUE, false);
                } else {
                    enableDisable(ctv1,rb5,rb6, Color.WHITE, true);
                }
            }
        });

        ctv4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ctv4.isChecked()){
                    enableDisable(ctv1,rb7,rb8, Color.BLUE, false);
                } else {
                    enableDisable(ctv1,rb7,rb8, Color.WHITE, true);
                }
            }
        });

 }

 public void enableDisable(CheckedTextView ctv1, RadioButton rb1, RadioButton rb2, Integer bgColor, Boolean state){
        ctv1.setChecked(state);
        ctv1.setBackgroundColor(bgColor);
        rb1.setEnabled(state);
        rb2.setEnabled(state);

        if (!state){
            rb1.setChecked(state);
            rb2.setChecked(state);
        }

 }

 public boolean radioCheck(int selectedTime1, int selectedTime2, int selectedTime3, int selectedTime4){
        if ((selectedTime1 == R.id.rd2) && (selectedTime4 == R.id.rd7)) {
         rb2.setError("Timeslot clonflict");
         rb7.setError("Timeslot clonflict");
         return false;
     }

     if ((selectedTime1 == R.id.rd1) && (selectedTime2 == R.id.rd3)) {
         rb1.setError("Timeslot clonflict");
         rb3.setError("Timeslot clonflict");
         return false;
     }

     if ((selectedTime3 == R.id.rd5) && (selectedTime4 == R.id.rd8)) {
         rb5.setError("Timeslot clonflict");
         rb8.setError("Timeslot clonflict");
         return false;
     }


        return true;
 }


}
