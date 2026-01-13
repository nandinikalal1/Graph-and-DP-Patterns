import java.util.*;

public class AdjListGraph {
 // Edge class is inner class of AdjListGraph. helper class
 //you can create it directly in main //new Edge
 //no extra hidden 
    static class Edge{
        int src;
        int dest;
        int wt;
    //constructor
public Edge(int s, int d, int w){
    this.src = s;
    this.dest = d;
    this.wt = w;
    }
}
    public static void main(String args[]){
        /*
              (5)
           0------1
                /  \
         (1)   /    \  (3)
              /  (1) \
             2 ------ 3
             |
             | (2)
             |
             4
        */
       int V = 5; // no of vertices = size of array
    // To visualise in form of Adjacent list: for ever vertix -> store list of edges
    ArrayList <Edge> [] graph = new ArrayList [V]; //null -> convert
    //AL Datatype at evvery index of array which has edges information and of size V
    //Every index i -> has ArrayList of Edges
    //Intialialy index of every graph will have null stored (undefined)
    //we have to create ArrayList null -> empty array list. For this we need loop
    for(int i=0; i<V ;i++){
        graph[i] = new ArrayList<>(); //go ti index i and create new ArrayList to store edges
    }
    //Vertex 0
    graph[0].add(new Edge(0,1,5));
    //Vertex 1
    graph[1].add(new Edge(1,0,5));
    graph[1].add(new Edge(1,2,1));
    graph[1].add(new Edge(1,3,3));
    //Vertex 2
    graph[2].add(new Edge(2,1,1));
    graph[2].add(new Edge(2,3,1));
    graph[2].add(new Edge(2,4,2));
    //Vertex 3
    graph[3].add(new Edge(3,1,3));
    graph[3].add(new Edge(3, 2, 1));
    //Vertex 4
    graph[4].add(new Edge(4,2,2));

    //In this way we defined all edges in the form of array of arraylists
    //Ques: for any vertex give it's neighbor's info. Ex: V=2
    for(int i=0; i<graph[2].size(); i++){ // loop at index 2 we get array list which has info of edges (s,d,w)
        //Traverse the array list
        Edge e = graph[2].get(i); //for any vertex which has edges -> has info of s,d,w
        //for any vertex it's destination will gives it's neighbor vertices information
        System.out.println(e.dest);
    }
    }

  }


