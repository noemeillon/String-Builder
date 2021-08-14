public class Solution {
    
    /**
    * Find the biggest clonable string for each subpart (0-i) of the target
    */
    private static String getClone(String currentString, String targetString, int index) {
        boolean found = false;

        while (!found) {
            String substring = targetString.substring(0, index - currentString.length());

            if (!substring.contains(currentString)) {
                currentString = currentString.substring(1, currentString.length());
            }
            else {
                found = true;
            }
        }
        
        // Biggest clonable substring
        return currentString;
    }

    /**
    * Find the cost to construct a target string
    * Iteratively get the minimum cost for each 'subpart' inside the target and return the minimum cost for the entire target
    */
    public static int buildString(String target, int cloneCost, int appendCost) {
        if (target.length() > 1) {
            String biggestIndexClone = "";

            int[] indexCost = new int[target.length()];
            indexCost[0] = appendCost;

            for (int i = 1; i < target.length(); i++) {
                biggestIndexClone = getClone(biggestIndexClone += target.charAt(i), target, i + 1);

                int appendingCost = indexCost[i - 1] + appendCost;
                int cloningCost = indexCost[i - biggestIndexClone.length()] + cloneCost;

                // If a substring is found, check if to reach target[0, i] it should clone a substring or append a character - cheapest cost is added
                if (biggestIndexClone.isEmpty()) {
                    indexCost[i] = appendingCost;
                }
                else {
                    indexCost[i] = appendingCost <= cloningCost ? appendingCost : cloningCost;
                }
            }

            return indexCost[indexCost.length - 1]; // the cheapest cost to create the string is located at the end of the array
        }
        else if (target.length() == 1) { // Single character target
            return appendCost;
        }
        else { // Empty target string
            return 0;
        }
    }
    
    /**
    * Run the string builder
    * First arg should be the target string, second the cost of cloning a string and the third the cost of appending a character
    */
    public static void main(String args[]) {
        System.out.println(Solution.buildString(args[0], Integer.parseInt(args[1]), Integer.parseInt(args[2])));
    }
}
