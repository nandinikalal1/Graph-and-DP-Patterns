import java.util.*;

public class graphBFS {
    static class Edge{
        int src;
        int dest;
        int wt;
        public Edge(int s, int d, int w){
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }
    static void createGraph(ArrayList<Edge> graph[]){
        for(int i=0; i<graph.length; i++){
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0,1,1));
        graph[0].add(new Edge(0,2,1));

        graph[1].add(new Edge(1,0,1));
        graph[1].add(new Edge(1,3,1));

        graph[2].add(new Edge(2,0,1));
        graph[2].add(new Edge(2,4,1));

        graph[3].add(new Edge(3,1,1));
        graph[3].add(new Edge(3,4,1));
        graph[3].add(new Edge(3,5,1));

        graph[4].add(new Edge(4,2,1));
        graph[4].add(new Edge(4,3,1));
        graph[4].add(new Edge(4,5,1));

        graph[5].add(new Edge(5,3,1));
        graph[5].add(new Edge(5,4,1));
        graph[5].add(new Edge(5,6,1));

        graph[6].add(new Edge(6,5,1));

    }
    public static void bfs(ArrayList<Edge>[] graph){    //Bfs will have ArrayList of edges of name graph
           //for the traversal 1. create a queue 
            Queue<Integer> q = new LinkedList<>(); //q will have int values
            //2. create boolean array of name vis & it's size = V (graph size)
            boolean vis[] = new boolean[graph.length]; 
            q.add(0); //Start with source = 0 (source can be anything), add it to the queue

            while(!q.isEmpty()){ //Run a loop till queue doesnt become empty
                //One by One remove elements from the queue & check if visited, Visit only if it's not visited
                int curr = q.remove(); //if visited just remove
                //visit curr
                if(!vis[curr]){ //check if curr is not visited, if curr is false

                    //visit in 3 steps
                    //1. print if not visited
                    System.out.print(curr+" "); 
                    //2. Make it's visited True
                    vis[curr] = true; 
                    //3. add all it's neighbors to the queue
                    //LOGIC TO GET NEIGHBORS OF ANY VERTEX
                    for(int i=0; i<graph[curr].size(); i++){ //we are on the curr index of graph  (current vertex - we need it's neighbors)
                       // go to graph[curr] -> from there we will get Arraylist
                          Edge e = graph[curr].get(i); //Traverse that array list & get one by one all the edges
                          q.add(e.dest);//Edge's destination is neighbor, add
                    }

                }
            }
    }
    public static void main(String args[]){
        /*
             1---3 
            /   | \
           0    |  5--6
            \   | /
            2---4
            */

        int V = 7;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        bfs(graph); //main func call
        }

}
