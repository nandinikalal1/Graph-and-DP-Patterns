//Fibonacci Concept
//go to n th stair - before going to nth stair go to n-1, n-2 stair

import java.util.Arrays;

public class climbingStairs {
    /* RECURSION : TC (2^n)
    public static int countWays(int n){ 
        if(n == 0){ //Base Case 1: If person is on ground step, Stay there so return 1
            return 1;
        }
        if(n < 0){ //Base Case 2: If steps are negative, no way
            return 0;
        }
        return countWays(n-1) + countWays(n-2); 
    }
        */

    //MEMOIZATION: TC O(n)
    /*Why ways[] is passed into the function
      Because:
      Java does not have global arrays by default
      Passing it allows all recursive calls to share the same memory
      This converts slow recursion into fast dynamic programming
      n → current step number
      ways[] → array used to remember answers already calculated */
    public static int countWays(int n, int ways[]){ 
        if(n == 0){ //Base Case 1: You are already on the ground (no steps to climb). There is exactly 1 way → “do nothing”
            return 1;
        }
        if(n < 0){ //Base Case 2: You went below ground (invalid step). There are 0 ways to reach here
        }
        /* ways[n] stores the answer for step n. If it is not -1, that means:
           We already calculated it before, No need to calculate again
           Just return the stored value, This prevents repeated recursion
            */
        if(ways[n] != -1){ //check if already calculated
            return ways[n];
        }
        ways[n] = countWays(n-1, ways) + countWays(n-2, ways);
        return ways[n] ; //Give back the number of ways to reach step n
        /*To reach step n: Either come from step n-1 Or come from step n-2
          Store result in ways[n] so we don’t recompute later */
    }
    //TABULATION: TC O(n)
    public static int countWaysTab(int n){ //pass only int n
        int dp[]= new int[n+1]; //define dp array inside the function. 1D Array of size n+1 because solution from 0 to n
        dp[0] = 1; //Intialisation (Base case in memoization)

        /*tabulation loop
         Start solving from smallest problem. Build answers up to n
        */
        for(int i=1; i<=n; i++){ // i=0 already intialised so i=1
            if(i==1){ // Case: if i == 1, negative numbers considered as 0
                dp[i] = dp[i-1] + 0;
            }else{ 
            dp[i] = dp[i-1] +dp[i-2];
            }
        }
        return dp[n];
    }

    public static void main(String args[]){
        int n = 5; //n=3 -> 3ways & n=4 -> 5ways, So total ways for n=5 = 8ways
        int ways[] = new int[n+1]; // By default when we create array 0000 is stored
        Arrays.fill(ways,-1); // This adds -1, -1-1-1-1
        System.out.println(countWays(n, ways));
        System.out.println(countWaysTab(n));
    }
}
