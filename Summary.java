package com.example.jenniferhott_leitsch.jhott_leitsch_lab1;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Summary extends AppCompatActivity {

    private String firstName = "";
    private String lastName = "";
    private String phone ="";
    private String birthDate = "";
    private String isDegreeCert = "";
    private String degreeCert = "";
    private String class1 = "";
    private String selected1 = "";
    private String class2 = "";
    private String selected2 = "";
    private String class3 = "";
    private String selected3 = "";
    private String class4 = "";
    private String selected4 = "";


    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        Bundle extras = getIntent().getExtras();
        if(extras != null){
            firstName = extras.getString("FirstName");
            lastName = extras.getString("LastName");
            phone = extras.getString("Phone");
            birthDate = extras.getString("Birthday");
            isDegreeCert = extras.getString("isDegreeCerts");
            degreeCert = extras.getString("degreeCert");
            class1 = extras.getString("Class1");
            selected1 = extras.getString("Selected1");
            class2 = extras.getString("Class2");
            selected2 = extras.getString("Selected2");
            class3 = extras.getString("Class3");
            selected3 = extras.getString("Selected3");
            class4 = extras.getString("Class4");
            selected4 = extras.getString("Selected4");
        }

        final TextView textStudent = (TextView) findViewById(R.id.textStudent);
        final TextView textPhone = (TextView) findViewById(R.id.textPhone);
        final TextView textBirthday = (TextView) findViewById(R.id.textBirthday);
        final TextView textDegree= (TextView) findViewById(R.id.textDegree);
        final TextView textMajor= (TextView) findViewById(R.id.textMajor);
        final TextView textClassSchedule= (TextView) findViewById(R.id.textClassSchedule);

        textStudent.setText(firstName + " " + lastName);
        textPhone.setText(phone);
        textBirthday.setText(birthDate);
        textDegree.setText(isDegreeCert);
        textMajor.setText(degreeCert);

        StringBuilder ClassSchedule = new StringBuilder(250);
        if (!class1.equals("")){
            ClassSchedule.append(class1 + "\n" + selected1 + "\n\n");
        }

        if (!class2.equals("")){
            ClassSchedule.append(class2 + "\n" + selected2 + "\n\n");
        }

        if (!class3.equals("")){
            ClassSchedule.append(class3 + "\n" + selected3 + "\n\n");
        }

        if (!class4.equals("")){
            ClassSchedule.append(class4 + "\n" + selected4 + "\n\n");
        }

        textClassSchedule.setText(ClassSchedule);
    }
}
