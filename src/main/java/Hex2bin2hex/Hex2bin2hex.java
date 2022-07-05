
package Hex2bin2hex;

import java.io.*;
import java.util.HashMap;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.math.BigInteger;


public class Hex2bin2hex extends JFrame{
    
    public static void convert(File hexfile) throws IOException{
        BufferedReader in = new BufferedReader(new FileReader(hexfile));
        FileOutputStream out = new FileOutputStream(hexfile.getAbsolutePath()+".bin");
        
        String line;
        while((line = in.readLine()) != null)
            
        
        out.write(Converthex(line));
        
        in.close();
        out.close();
    } 
    
     public static int Converthex(String s) throws IOException
    {
         
         String binary = "";
        s = s.toUpperCase();
 
        HashMap<Character, String> hashMap
            = new HashMap<Character, String>();
 
        hashMap.put('0', "0000");
        hashMap.put('1', "0001");
        hashMap.put('2', "0010");
        hashMap.put('3', "0011");
        hashMap.put('4', "0100");
        hashMap.put('5', "0101");
        hashMap.put('6', "0110");
        hashMap.put('7', "0111");
        hashMap.put('8', "1000");
        hashMap.put('9', "1001");
        hashMap.put('A', "1010");
        hashMap.put('B', "1011");
        hashMap.put('C', "1100");
        hashMap.put('D', "1101");
        hashMap.put('E', "1110");
        hashMap.put('F', "1111");
 
        int i;
        char ch;
 
        for (i = 0; i < s.length(); i++) {
            ch = s.charAt(i);
            if (hashMap.containsKey(ch))
                binary += hashMap.get(ch);
            
        }
        return res1(binary);
    }
     
     public static int res1(String binary) throws IOException{
         
          
          try(FileWriter writer = new FileWriter("result.bin", false)) // запись результата
        {
           
            
            writer.write(binary);
            
          
             
            writer.flush();
        }

          
          
      return 0;    
    }
    
     public static void convert2(File binfile) throws IOException{
        BufferedReader in = new BufferedReader(new FileReader(binfile));
        FileOutputStream out = new FileOutputStream(binfile.getAbsolutePath()+".hex");
           
        String line1;
        while((line1 = in.readLine()) != null)
            for(int i = 0; i < 16; i++)
                
                    out.write(binaryTohex(line1));
        
        in.close();
        out.close();
    }
      
      
    
    public static int binaryTohex(String s) throws IOException{
        
        BigInteger num = new BigInteger(s);
       
        BigInteger i= BigInteger.parseInt(s,2);
        String hexString = Integer.toHexString(i);
        System.out.println("" + hexString);
        return res2(hexString);
        
    }

    
    public static int res2(String s) throws IOException{
          
          try(FileWriter writer1 = new FileWriter("result1.hex", false)) // запись результата
        {
           
            
            writer1.write(s);
            
          
             
            writer1.flush();
        }
          return 0;
    }
    
    public static void main(String[] args){

    
    }
    }

        
   
    
