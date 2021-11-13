package com.example.practise;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.File;

public class add extends AppCompatActivity {

    EditText e1,e2,e3,w,m;
    Button adde;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        w=findViewById(R.id.editTextTextMultiLine);
        m=findViewById(R.id.editTextTextMultiLine2);
        e1=findViewById(R.id.editTextTextMultiLine3);
        e2=findViewById(R.id.editTextTextMultiLine4);
        e3=findViewById(R.id.editTextTextMultiLine5);
        adde=findViewById(R.id.adder);
        File path= Environment.getExternalStorageDirectory();
        File dir=new File(path+"/SUSMOY");
        dir.mkdirs();
        File mfile=new File(dir,"A.txt");
        adde.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s=w.getText().toString().trim().toLowerCase()+String.valueOf('|')+m.getText().toString()+String.valueOf('|')+e1.getText().toString()+String.valueOf('|')+e2.getText().toString()+String.valueOf('|')+e3.getText().toString();
                Rw.delete(mfile,s);
                Rw.write(s,mfile);
            }
        });

    }
}