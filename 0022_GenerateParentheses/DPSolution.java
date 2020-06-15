// time:    O(2^n) I have 2 options each time, and in the worst case they grow n deep
// space:   O(2n)

// idea:    We compute the answer for each level and reuse them. Line 15 grabs the previous solution, while
//          line 16 grabs all the solutions before that and adds permutations based on the same logic.

class Solution {
  public List<String> generateParenthesis(int n) {
    ArrayList<ArrayList<String>> solutions = new ArrayList<>();
    // f(0);
    solutions.add(new ArrayList<String>(Arrays.asList("")));
    for (int i = 1; i <= n; i ++) {
      ArrayList<String> subSolution = new ArrayList<>();
      for (int j = 0; j < i; j++) {
        for (String around : solutions.get(j)) {
          for (String beside : solutions.get(i - 1 - j)) { 
            subSolution.add("(" + around + ")" + beside);
          }
        }
      } 
      solutions.add(subSolution);
    }
    return solutions.get(n);
  }
}