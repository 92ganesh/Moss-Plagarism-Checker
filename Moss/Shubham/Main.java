import java.io.*;
import java.lang.*;

class Main{
 public static void main(String[] args) throws IOException
 {  //InputStreamReader r = new InputStreamReader(System.in);
     FileReader r = new FileReader("E:/My Java Projects/src/custom.txt");
     BufferedReader br = new BufferedReader(r);

     int t = Integer.parseInt(br.readLine());
     while(t > 0)
     {   String s[] = br.readLine().split(" ");
         long a = Long.parseLong(s[0]);
         long b = Long.parseLong(s[1]);

         String bin_a = Long.toBinaryString(a);
         String bin_b = Long.toBinaryString(b);

         //System.out.println(bin_a+" "+bin_b);
         int countA=0,countB=0;
         for(int i=0;i<bin_a.length();i++)
         {  if(bin_a.charAt(i)=='1') countA++;
         }
         for(int i=0;i<bin_b.length();i++)
         {  if(bin_b.charAt(i)=='1') countB++;
         }

         long min=0;
         if(countB==0||(a!=0&&b==1))
             min=-1;
         else if(countB>countA)
         {   if(bin_b.charAt(bin_b.length() - 1) == '1')
             {  min=countB - countA;
             }else
             {   String num = Long.toBinaryString(b-1);
                 int countN=0;
                 for(int i=0;i<num.length();i++)
                 {  if(num.charAt(i)=='1') countN++;
                 }
                 min=countN - countA+1;
             }
         }else if(countB==countA)
         {  if(bin_b.charAt(bin_b.length() - 1) == '1')
             {  min=2;
             }else
            {   int countN=0,i=bin_b.length()-1;
                while(bin_b.charAt(i)=='0')
                {
                    countN++; i--;
                }
                min=countN;
            }
         }else if(countB<countA)
         {  if(bin_b.charAt(bin_b.length() - 1) == '1')
            {  min=2;
            }else
            {
             int n = countA - countB+1;
             int i,zero=0;
             for(i = bin_b.length() - 1; bin_b.charAt(i) != '1'; i--)
             { zero++;
             }
             if(i == n)
                 min=1;
             else
             {   int countN=0;
                 i=bin_b.length()-1;
                 while(bin_b.charAt(i)=='0')
                 {
                     countN++; i--;
                 }
                 min=countN+1;

             }
            }
         }

         if(min!=-1)
         {  if(b>=a && (b-a)<min)
            {   min = b-a;
            }
         }
         System.out.println(min);

        t--;
     }
 }
}