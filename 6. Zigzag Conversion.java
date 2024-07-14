//https://leetcode.com/problems/zigzag-conversion/?envType=study-plan-v2&envId=top-interview-150
class Solution {
    public String convert(String s, int numRows) {
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            ArrayList<String> inner = new ArrayList<>();
            result.add(inner);
            for (int j = 0; j < s.length(); j++) {
                inner.add(null);
            }
        }
        int currCol = 0;
        int currRow = 0;
        boolean isGoingDown = true;
        int interval = (numRows - 1)*2;
        if (interval == 0) return s;
        for (int i = 0; i < s.length(); i++) { 
            
            ArrayList<String> arr = result.get(currRow);
            arr.add(currCol, String.valueOf(s.charAt(i)));

            if (i % interval == 0) isGoingDown = true;
            else if((i + numRows - 1) % interval == 0) isGoingDown = false;

            if (isGoingDown) {
                currRow++;
            } else {
                currCol++;
                currRow--;

            }
        }
        String res = "";
        for (int i = 0; i < numRows; i++) {
            ArrayList<String> arr = result.get(i);
            for (int j = 0; j < arr.size(); j++) {
                String c = arr.get(j);
                if (c != null) {
                    res+=c;
                }
            }
        }

        return res;
    }
}
