
import java.io.*;
import java.util.*;
//-------------------------------------------------------------------------------

public class Graph {

    int[][] a;
    int n;
    char v[];
    int deg[];

    Graph() {
        v = "ABCDEFGHIJKLMNOP".toCharArray();
        deg = new int[20];
        a = new int[20][20];
        n = 0;
    }

    //Load data from file
    void loadData(int k) {
        RandomAccessFile f;
        int i, j, x;
        String s;
        StringTokenizer t;
        a = new int[20][20];
        try {
            f = new RandomAccessFile("data.txt", "r");
            for (i = 0; i < k; i++) {
                f.readLine();//ignores the first k-1 lines
            }
            s = f.readLine();//just use the data in the k-th line
            s = s.trim();
            n = Integer.parseInt(s);
            for (i = 0; i < n; i++) {
                s = f.readLine();
                s = s.trim();
                t = new StringTokenizer(s);
                for (j = 0; j < n; j++) {
                    x = Integer.parseInt(t.nextToken().trim());
                    a[i][j] = x;
                }
            }

            f.close();
        } catch (Exception e) {
        }
    }

    void dispAdj() {
        int i, j;
        for (i = 0; i < n; i++) {
            System.out.println();
            for (j = 0; j < n; j++) {
                System.out.printf("%4d", a[i][j]);
            }
        }
    }

    void fvisit(int i, RandomAccessFile f) throws Exception {
        f.writeBytes("  " + v[i]);
    }

    void fdispAdj(RandomAccessFile f) throws Exception {
        int i, j;
        f.writeBytes("n = " + n + "\r\n");
        for (i = 0; i < n; i++) {
            f.writeBytes("\r\n");
            for (j = 0; j < n; j++) {
                f.writeBytes("  " + a[i][j]);
            }
        }
        f.writeBytes("\r\n");
    }

    // bread first traverse from vertex k  
    void breadth(int k, RandomAccessFile f) throws Exception {
        Queue q = new Queue();
        int i, h;
        boolean[] enqueued = new boolean[n];
        for (i = 0; i < n; i++) {
            enqueued[i] = false;
        }

        q.enqueue(k);
        enqueued[k] = true;

        while (!q.isEmpty()) {
            h = q.dequeue();
            fvisit(h, f);

            for (i = 0; i < n; i++) {
                if (!enqueued[i] && a[h][i] > 0) {
                    q.enqueue(i);
                    enqueued[i] = true;
                }
            }
        }

        System.out.println();
    }

    void depth_rec(boolean[] visited, int k, RandomAccessFile f) throws Exception {
        fvisit(k, f);
        visited[k] = true;
        for (int i = 0; i < n; i++) {
            if (!visited[i] && a[k][i] > 0) {
                depth_rec(visited, i, f);
            }
        }
    }

    void depth(int k, RandomAccessFile f) throws Exception {
        boolean[] visited = new boolean[20];
        int i;
        for (i = 0; i < n; i++) {
            visited[i] = false;
        }
        depth_rec(visited, k, f);
        for (i = 0; i < n; i++) {
            if (!visited[i]) {
                depth_rec(visited, i, f);
            }
        }
    }

    // This method is used for Question 3.1
    void breadth2(int k, RandomAccessFile f) throws Exception {
        Queue q = new Queue();
        int i, h;
        boolean[] enqueued = new boolean[n];
        for (i = 0; i < n; i++) {
            enqueued[i] = false;
        }

        q.enqueue(k);
        enqueued[k] = true;
        int counter = 0;
        while (!q.isEmpty()) {
            h = q.dequeue();
            if(h!=k){
                counter++;
            }
            if(counter>=1 && counter<=4 && h!=2){
                fvisit(h, f);
            }
            

            for (i = 0; i < n; i++) {
                if (!enqueued[i] && a[h][i] > 0) {
                    q.enqueue(i);
                    enqueued[i] = true;
                }
            }
        }

        System.out.println();
    }

    void f1() throws Exception {
        loadData(1);
        String fname = "f1.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        breadth(3, f);
        f.writeBytes("\r\n");
        /**
         * Question 3.1: Perform breadth-first search on the graph.
         * Starting from the vertex D (which index is 3), 
         * ONLY display the vertex right after D up to the next 4 vertices, and NOT display vertex 'C' (if any, index = 2), 
         * but still consider it as one count during traversing the graph. Hint: copy breadth(...) to breadth_2(...) 
         * and modify the method breadth_2(...) appropriately. The output f1() will be written into file 'f1.txt'. 
         * Therefore you should open this file to see/test your code output. Example: With the graph provided in 'data.txt', 
         * the content of 'f1.txt' after running this method is 
         * D A G C I B F H E
         * A G I The output does not display vertex 'C',
         * but still consider it as one count during traversing the graph.
         */
        //---------------------------------------------------------------------------------------
        //------ Start your code here------------------------------------------------------------
        breadth2(3,f);
        //------ End your code here--------------------------------------------------------------
        //---------------------------------------------------------------------------------------

        f.writeBytes("\r\n");
        f.close();
    }

    void f2() throws Exception {
        loadData(1);
        String fname = "f2.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        f.writeBytes("\r\n");
        /**
         * Question 3.2: Perform depth-first search on the graph. Starting from the vertex A (index = 0). 
         * Hint: you just call the function 'depth()' appropriately. This function is provided above The output f2() 
         * will be written into the file 'f2.txt'. Therefore you should open this file to see/test your code output. 
         * Example: With the graph provided in 'data.txt', the content of 'f2.txt' after running this method is A C F H B E G D I
         */
        //---------------------------------------------------------------------------------------
        //------ Start your code here------------------------------------------------------------
        depth(0, f);
        //------ End your code here--------------------------------------------------------------
        //---------------------------------------------------------------------------------------
        f.writeBytes("\r\n");
        f.close();
    }
}
