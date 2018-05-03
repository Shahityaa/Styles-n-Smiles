package com.example.shahityaa.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

public class page2 extends AppCompatActivity {

    Button calc ;
    CheckBox fac,pedi,manic,hr;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page2);

        calc = (Button) findViewById(R.id.calc);
        fac = (CheckBox)findViewById(R.id.facial);
        pedi = (CheckBox)findViewById(R.id.pedi);
        manic = (CheckBox)findViewById(R.id.manic);
        hr = (CheckBox)findViewById(R.id.hr);


        calc.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        int a ,b,c,d ;

                        if(fac.isChecked())
                        {
                            a = 2000;
                        }
                        else
                        {
                            a = 0;
                        }
                        if(pedi.isChecked())
                        {
                            b = 300;
                        }
                        else
                        {
                            b = 0;
                        }
                        if(manic.isChecked())
                        {
                            c = 250;
                        }
                        else
                        {
                            c = 0;
                        }
                        if(hr.isChecked())
                        {
                            d = 650;
                        }
                        else
                        {
                            d = 0;
                        }

                        int sum = a+b+c+d;

                        Intent i = new Intent(getApplicationContext(),page3.class);
                        i.putExtra("sum",sum);
                        startActivity(i);

                    }
                }
        );

    }
}
