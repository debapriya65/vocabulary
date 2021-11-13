package com.example.practise;

import android.os.Environment;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
class Data
{
    String[] data=new String[10000];
    int length;
}
public class Rw {

   public static Data read(File mfile)
    {
        String[] dat=new String[10000];
        int len=0;
        try {
            FileReader reader = new FileReader(mfile);
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                {
                    dat[len]=line;
                    len++;
                }
            }

        }  catch (FileNotFoundException e) {

        } catch (IOException e) {

        }catch (Exception e) {

        }
        Data d=new Data();
        d.data=dat;
        d.length=len;
        return d;


    }
    public static void delete(File mfile,String s)
    {
        File path = Environment.getExternalStorageDirectory();
        File dir = new File(path + "/SUSMOY");
        dir.mkdirs();
        String[] dat=new String[10000];int len=0;
        File file = new File(dir, "temp.txt");
        try {
            FileReader reader = new FileReader(mfile);
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                {
                    int i=0;String w="";
                    while (i < line.length() && line.charAt(i) != '|') {

                        w = w + String.valueOf(line.charAt(i));
                        i++;
                    }
                  //  System.out.println(line+" fuck  w="+w+"s="+s+"=fuckfinally");
                    if(w.equals(s)==true)
                    {
                       // System.out.println(line+" fuck 2 w="+w+"s="+s+"=fuckfinally");
                    }
                    else
                    {
                        dat[len]=line;
                        len++;
                    }

                }

            }

        }  catch (FileNotFoundException e) {

        } catch (IOException e) {

        }catch (Exception e) {

        }
        for(int i=0;i<len;i++)
        {

            try{
                FileWriter fw=new FileWriter(file,true);
                PrintWriter pw=new PrintWriter(fw);
                pw.println(dat[i]);
                pw.close();

            } catch (FileNotFoundException e) {

            } catch (IOException e) {

            }catch (Exception e) {

            }
            finally {

            }

        }
        mfile.delete();
        file.renameTo(new File(dir, "A.txt"));

    }
    public static void write(String S,File mfile)
    {

        try{
            FileWriter fw=new FileWriter(mfile,true);
            PrintWriter pw=new PrintWriter(fw);
            pw.println(S);
            pw.close();
        } catch (FileNotFoundException e) {

        } catch (IOException e) {

        }catch (Exception e) {

        }
        finally {

        }
    }

}
