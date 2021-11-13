package com.example.practise;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Environment;
import android.widget.ListView;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class show extends AppCompatActivity {
    private List<String> wordlist;
    private ListView listView;
    private custom_adapter adapter;
    Data datam;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        listView=findViewById(R.id.book_list);

        wordlist=new ArrayList<>();
        adapter=new custom_adapter(show.this,wordlist);
    }
    @Override
    protected void onStart() {
        super.onStart();
        File path = Environment.getExternalStorageDirectory();
        File dir = new File(path + "/SUSMOY");
        dir.mkdirs();
        File mfile = new File(dir, "A.txt");
        datam = Rw.read(mfile);
        for(int i=0;i<datam.length;i++)
        {
            wordlist.add(datam.data[i]);
        }
        listView.setAdapter(adapter);
                }


        }