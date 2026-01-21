public class fibonacci {
/*
//Simple Recursion
public static int fib(int n){
    if(n==0 || n==1){
        return n;
    }
    return fib(n-1) + fib(n-2); 
} 
*/
//Memoisation
    public static int fib(int n, int f[]){ //integer array 
        if(n==0 || n == 1){
            return n;
        }
        //to check if calc
        if(f[n] != 0){ //fib(n) is already calculated so need not calc
            return f[n];
        }
        f[n] = fib(n-1, f) + fib(n-2, f); // pass f in func call
         return f[n];
    
}
//Tabulation
public static int fibTabulation(int n){
    int dp[] = new int[n + 1];
    dp[0] = 0; //Intialise base case in tabulation
   dp[1] = 1;
   for(int i=2; i<=n ;i++){
    dp[i] = dp[i-1] + dp[i-2];
   }
   return dp[n]; 
}
public static void main(String args[]){
    int n = 5;
    int f[] = new int[n+1]; //by default we store 0,0,0,0 
    // //n+1 we calc from 0 to n. n+1 is nth fib
    // f array will store already calculated fib(n)
    //fib should calc
    //System.out.println(fib(n, f)); //Memoisation
    System.out.println(fibTabulation(n)); //Tabulation
}
}

/* Time Complexity
1.Simple Recursion: exponential 0(2^n)
For DP:
2. Memoisation: Linear O(n)
3.Tabulation: Linear O(n)
 */