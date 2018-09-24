import java.io.*;
import java.util.Scanner;
import java.io.File;



class Main
{  public static void main(String[] args) throws IOException     // throwing exception is imp
    {   File file = new File("E:/My Java Projects/src/custom.txt");
        Scanner sc = new Scanner(file);


        InputStreamReader r = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(r);

        // int t = Integer.parseInt(br.readLine());
        int t = Integer.parseInt(sc.nextLine());

        int there[]=new int[4];
        int change,count;
        while(t>0)
        {  // String s = br.readLine();
            String s = sc.nextLine();
            //pf(s); pfn();
            count =0;
            for(int i=0;i<4;i++)
                there[i]=0;

            for(int i=0;i<s.length()-3;i++)
            {   change = 0;
                for(int j=i;j<i+4;j++)
                { char c = s.charAt(j);
                  switch(c)
                  {   case 'c':  there[0]++;  change=1; break;
                      case 'h':  there[1]++;  change=1; break;
                      case 'e':  there[2]++;  change=1; break;
                      case 'f':  there[3]++;  change=1; break;
                  }
                }
                if(change==1)
                {   int j;
                    for(j=0;j<4;j++)
                    {   if(there[j]==0)  break;
                    }
                    if(j==4) count++;
                }

                for(int j=0;j<4;j++)
                { //  pf(there[j]);
                    there[j]=0;
                }

            }

            if(count>0)
            {   pf("lovely "); pf(count); pfn();
            }else
            {   pf("normal");  pfn();
            }
            t--;
        }

    }


    //**********************************
    public static void pf(int x)
    { System.out.print(x);
    }
    public static void pf(double x)
    { System.out.print(x);
    }
    public static void pf(boolean x)
    { System.out.print(x);
    }
    public static void pf(String x)
    { System.out.print(x);
    }
    public static void pf(char x)
    { System.out.print(x);
    }
    public static void pfn()
    { System.out.print("\n");
    }
}