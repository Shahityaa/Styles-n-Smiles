package com.example.shahityaa.parlouradmin;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class home extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        final MyDB db = new MyDB(this);
        db.open();

        final TextView tv = (TextView)findViewById(R.id.tv4);
        final TextView tv3 = (TextView)findViewById(R.id.tv3);
        final EditText et = (EditText)findViewById(R.id.edit1);
        final EditText et2 = (EditText)findViewById(R.id.et2);
        Button b1 = (Button)findViewById(R.id.button1);
        Button b2 = (Button)findViewById(R.id.button2);
        Button b3 = (Button)findViewById(R.id.button3);
        Button b4 = (Button)findViewById(R.id.button4);
        Button b5 = (Button)findViewById(R.id.button5);



        b1.setOnClickListener(new OnClickListener(){

            public void onClick(View v) {
                // TODO Auto-generated method stub
                db.insertEntry(et.getText().toString(),et2.getText().toString());
                tv3.setText(et.getText().toString()+ " Added in the database");
            }

        });
        b2.setOnClickListener(new OnClickListener(){

            public void onClick(View v) {
                // TODO Auto-generated method stub
                int n=db.searchCount();
                tv3.setText(String.valueOf(n));
            }

        });

        b3.setOnClickListener(new OnClickListener(){

            public void onClick(View v) {
                // TODO Auto-generated method stub
                db.deleteVal(et.getText().toString());
                tv3.setText(et.getText().toString()+ " Deleted from the database");
            }

        });
        b4.setOnClickListener(new OnClickListener(){

            public void onClick(View v) {
                // TODO Auto-generated method stub

                tv.setText(db.getAllRecords());
            }

        });
        b5.setOnClickListener(new OnClickListener(){

            public void onClick(View v) {
                // TODO Auto-generated method stub
                db.updateEntry(et.getText().toString(),et2.getText().toString());
                tv3.setText("Price of "+et.getText().toString()+ " has been modified to "+et2.getText().toString());
            }

        });
    }
}
