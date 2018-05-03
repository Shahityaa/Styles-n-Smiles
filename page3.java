package com.example.shahityaa.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class page3 extends AppCompatActivity {

    TextView ans;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page3);

        ans = (TextView) findViewById(R.id.ans);

        Bundle extra;
        extra = getIntent().getExtras();
        int got = extra.getInt("sum");

        ans.setText("Rs " + Integer.toString(got) + " only");
        ans.requestFocus();
    }
}