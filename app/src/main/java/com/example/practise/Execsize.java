package com.example.practise;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.text.method.ScrollingMovementMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.util.Random;

public class Execsize extends AppCompatActivity {
    static String s, w = "", m = "", a1 = "", a2 = "", a3 = ""; static int swap=0;
    EditText e1, e2, e3, e4, e5, e6;
    TextView t1, t2, t3;
    Button b1, b2, b3, b4, b5;
    Data datam;
    int now = 0, u, l;
    int first = 0, last = 0, rand = 0, show = 0;
    File mfile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_execsize);
        File path = Environment.getExternalStorageDirectory();
        File dir = new File(path + "/SUSMOY");
        dir.mkdirs();
        mfile = new File(dir, "A.txt");
        datam = Rw.read(mfile);
        t1 = findViewById(R.id.size);
        t3 = findViewById(R.id.answer);
        t3.setMovementMethod(new ScrollingMovementMethod());
        t1.setText("Total words saved : "+String.valueOf(datam.length));
        t2 = findViewById(R.id.word);
        b4 = findViewById(R.id.show);
        e1 = findViewById(R.id.Upper);
        e2 = findViewById(R.id.lower);
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (show == 0) {
                    show = 1;
                    setall(now);
                } else {
                    show = 0;
                    t3.setText("");
                }
            }
        });
        b5 = findViewById(R.id.next);
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (rand == 1) {
                    Random rand = new Random();
                    now = rand.nextInt(u - l + 1) + l;
                    setall(now);
                    show = 0;
                    t3.setText("");

                } else if (first == 1) {
                    System.out.println(u + "first " + l);
                    if (now == u) {
                        now = l;
                    } else {
                        now++;
                    }

                    setall(now);
                    show = 0;
                    t3.setText("");
                } else if (last == 1) {
                    System.out.println(u + " last " + l);
                    if (now == l) {
                        now = u;
                    } else {
                        now--;
                    }
                    setall(now);
                    show = 0;
                    t3.setText("");
                } else {
                    setall(0);
                    show = 0;
                    t3.setText("");
                }
            }
        });

    }

    public int trans(String s) {

        int i = 0, j = 1;
        int num = 0, flag = 1;
        while (i <= s.length() - 1) {
            if (s.charAt(i) == '0' || s.charAt(i) == '1' || s.charAt(i) == '2' || s.charAt(i) == '3' || s.charAt(i) == '4' || s.charAt(i) == '5' || s.charAt(i) == '6' || s.charAt(i) == '7' || s.charAt(i) == '8' || s.charAt(i) == '9') {

            } else {
                flag = 0;
            }
            i++;
        }
        if (flag == 0 || s.length() == 0) {
            num = -1;
        } else {
            i = s.length() - 1;
            while (i >= 0) {
                num = (int) (s.charAt(i) - '0') * j + num;
                j = j * 10;
                i--;
            }
        }
        return num;

    }

    public void setall(int now) {

        s = datam.data[now];
        int i = 0;
        w =String.valueOf(now+1+" :-");
        m = "";
        a1 = "";
        a2 = "";
        a3 = "";
        while (i < s.length() && s.charAt(i) != '|') {

            w = w + String.valueOf(s.charAt(i));
            i++;
        }
        i++;
        while (i < s.length() && s.charAt(i) != '|') {

            m = m + String.valueOf(s.charAt(i));
            i++;
        }
        i++;
        while (i < s.length() && s.charAt(i) != '|') {

            a1 = a1 + String.valueOf(s.charAt(i));
            i++;
        }
        i++;
        while (i < s.length() && s.charAt(i) != '|') {

            a2 = a2 + String.valueOf(s.charAt(i));
            i++;
        }
        i++;
        while (i < s.length() && s.charAt(i) != '|') {

            a3 = a3 + String.valueOf(s.charAt(i));
            i++;
        }

        if(swap==0)
        {
            t2.setText(w);
        }else
        {
            t2.setText(m);
        }
        if (show == 1) {
            if(swap==0)
            {
                t3.setText("MEANING :" + m + "\nEXAMPLES :\n" + a1 + "\n" + a2 + "\n" + a3 + "\n");
            }else
            {
                t3.setText("MEANING :" + w + "\nEXAMPLES :\n" + a1 + "\n" + a2 + "\n" + a3 + "\n");
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_layout, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.menu_layout_first)
        {
            u = trans(e1.getText().toString());
            l = trans(e2.getText().toString());
            //       System.out.println(e1.getText().toString()+"fuvk"+e2.getText().toString()+"fuck"+u+"fuck"+l);
            if (u >= l && l >= 0 && u < datam.length) {

            } else {
                u = datam.length - 1;
                l = 0;

            }
            rand = 0;
            first = 1;
            last = 0;
            now = l;
            setall(now);
        }
        else if(item.getItemId()==R.id.menu_layout_last)
        {
            u = trans(e1.getText().toString());
            l = trans(e2.getText().toString());
            if (u >= l && l >= 0 && u < datam.length) {

            } else {
                u = datam.length - 1;
                l = 0;

            }
            rand = 0;
            first = 0;
            last = 1;
            now = u;
            setall(now);
        }else if(item.getItemId()==R.id.menu_layout_randm)
        {
            u = trans(e1.getText().toString().trim());
            l = trans(e2.getText().toString().trim());
            if (u >= l && l >= 0 && u < datam.length) {

            } else {
                u = datam.length - 1;
                l = 0;

            }
            rand = 1;
            first = 0;
            last = 0;
            now = l;
            setall(now);
        }else if(item.getItemId()==R.id.menu_layout_swat)
        {
            swap=swap^1;
            setall(now);
        }else if(item.getItemId()==R.id.menu_layout_delete)
        {
            String temp="";
           if(swap==0)
           {
            String temp1= t2.getText().toString();int flag=0;
             for(int i=1;i<temp1.length();i++)
             {
                 if(temp1.charAt(i-1)=='-')
                 {
                     flag=1;
                 }
                 if(flag==1)
                 {
                     temp=temp+String.valueOf(temp1.charAt(i));
                 }
             }

           }
           else
           {
            String  temp1=t3.getText().toString();
            int flag=0,flag2=1;
               for(int i=1;i<temp1.length();i++)
               {
                   if(temp1.charAt(i-1)=='-')
                   {
                       flag=1;
                   }
                   if(flag==1&&temp1.charAt(i)=='\n')
                   {
                       flag2=0;
                   }
                   if(flag==1&&flag2==1)
                   {
                       temp=temp+String.valueOf(temp1.charAt(i));
                   }
               }
           }
           Rw.delete(mfile,temp);
        }
        return super.onOptionsItemSelected(item);
    }
}
