package com.example.practise;

import android.app.Activity;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.io.File;
import java.util.List;

public class custom_adapter extends ArrayAdapter {
    private Activity context;
    private List<String>wordlist;
    public custom_adapter(Activity _context , @NonNull List<String>_booklist) {
        super(_context,R.layout.list_layout, _booklist);
        context=_context;
        wordlist=_booklist;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater=context.getLayoutInflater();
        View view=layoutInflater.inflate(R.layout.list_layout,null,true);
        String word=wordlist.get(position),w;int i=0;
       TextView b=view.findViewById(R.id.btn);
       ImageButton b2=view.findViewById(R.id.delete);
        w="Word:\n";
        while(i<word.length()&&word.charAt(i)!='|')
        {

            w=w+String.valueOf(word.charAt(i));i++;
        }i++;
        w=w+"\nmeaning:\n";
        while(i<word.length()&&word.charAt(i)!='|')
        {
            w=w+String.valueOf(word.charAt(i));i++;
        }i++;
        w=w+"\nEXample :\n";
        while(i<word.length()&&word.charAt(i)!='|')
        {
            w=w+String.valueOf(word.charAt(i));i++;
        } i++;
        w=w+"\n";
        while(i<word.length()&&word.charAt(i)!='|')
        {
            w=w+String.valueOf(word.charAt(i));i++;
        } i++;
        w=w+"\n";
        while(i<word.length()&&word.charAt(i)!='|')
        {
            w=w+String.valueOf(word.charAt(i));i++;
        }
        b.setText(w);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                File path = Environment.getExternalStorageDirectory();
                File dir = new File(path + "/SUSMOY");
                dir.mkdirs();
                File mfile = new File(dir, "A.txt");
                String name="";
                for(int i=6;i<b.getText().toString().length();i++)
                {
                    if(b.getText().toString().charAt(i)=='\n')
                    {
                        break;
                    }
                    else
                    {
                       name+=b.getText().toString().charAt(i);
                    }
                }
                Rw.delete(mfile,name);
            }
        });
        return view;
    }
}
