import java.io.*;
import java.lang.*;
import java.util.*;
class Main
{   static int id2,id1,method;
    private int V;

    private LinkedList<Integer> adj[];

   Graph(int v)
    {
        V = v;
        adj = new LinkedList[v];
        for (int i=0; i<v; ++i)
            adj[i] = new LinkedList();
    }

    void addEdge(int v, int w)
    {
        adj[v].add(w);
    }

    void DFSUtil(int v,boolean visited[])
    {
        visited[v] = true;
        if(v==id2)
        {   method = 1;
        }

         Iterator<Integer> i = adj[v].listIterator();
        while (i.hasNext()&&method==-1)
        {
            int n = i.next();
            if (!visited[n])
                DFSUtil(n, visited);
        }
    }

    void DFS(int v)
    {boolean visited[] = new boolean[V];

        DFSUtil(v, visited);
    }

    public static void main(String[] args) throws IOException     // throwing exception is imp
    {  //InputStreamReader r = new InputStreamReader(System.in);
        FileReader r = new FileReader("E:/My Java Projects/src/custom.txt");

        BufferedReader br = new BufferedReader(r);

        HashMap<String,Integer> mapa = new HashMap<>();

        Graph g = new Graph(200005);

        int id=-1,total_sets=-1;

        String s = br.readLine();
        int n= Integer.parseInt(s);
        while(n>0)
        {   String s2[] = br.readLine().split(" ");  id1=-1; id2=-1; method=-1;
            if(mapa.containsKey(s2[0])==false)
            {   id++;  id1=id;
                mapa.put(s2[0],id);  method = 2;
            }else
            {   id1 = mapa.get(s2[0]);
            }


            if(mapa.containsKey(s2[1])==false)
            {   id++;  id2=id;
                mapa.put(s2[1],id);  method = 2;
            }else
            {  id2 = mapa.get(s2[1]);
            }

            if(method==-1)
            {    g.DFS(id1);
                if(method==-1)
                {   method =2;
                }
            }


            g.addEdge(id1,id2); g.addEdge(id2,id1);
            if(method==1)
                pf("Type 1\n");
            else
                pf("Type 2\n");

            n--;
        }
/*
    for(int i=0;i<=id;i++)
    {   Iterator<Integer> it = seta[i].iterator();
        while(it.hasNext())
        {   pf(it.next()+" - ");
        }pfn();
    }
*/
    }




    //**********************************
    public static void pf(int x)
    { System.out.print(x);
    }
    public static void pf(long x)
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