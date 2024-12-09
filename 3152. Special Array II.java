/*
Pre-process -> Using sliding window technique, find the sets of nums range that satisfy the even, odd parity requirements as stated by qn
Methodology -> For each query, optimise to check if query fits range by "guessing" the most probable optimal range. This means the most probable range must be the one whose start index <= query start.
  We can find the index for this optimal range using binary search. 
  We finally check if the range as outputted by the binary search indeed satisfies query.
*/

class Solution {
    List<List<Integer>> validIndex;
    List<Integer> startIndex;
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        validIndex = new ArrayList<>();
        startIndex = new ArrayList<>();
        int start = 0;
        int end = 0;
        boolean isEven = nums[0] % 2 == 0;
        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] % 2 == 0) == isEven) {
                end = i;
                isEven = !isEven;
            } else {
                validIndex.add(Arrays.asList(start, end));
                startIndex.add(start);
                start = i;
                end = i;
                isEven = !(nums[i] % 2 == 0);
            }
        }
        validIndex.add(Arrays.asList(start, end));
        startIndex.add(start);


        boolean[] res = new boolean[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            res[i] = queryInRanges(query);
        }

        return res;
    }

    public boolean queryInRanges(int[] query) {
        // boolean res = false;
        int i = binSearch(query[0]);
        // System.out.println(i);
        List<Integer> validRange = validIndex.get(i);
        int validStart = validRange.get(0);
        int validEnd = validRange.get(1);
        int start = query[0];
        int end = query[1];
        boolean res = start >= validStart 
            && end <= validEnd;
        return res;
    }

    public int binSearch(int number) {

        
        int left = 0;
        int right = startIndex.size() - 1;
        int res = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (startIndex.get(mid) == number) {
                return mid;
            } else if (startIndex.get(mid) < number) {
                res = mid;
                left = mid + 1; 
            } else {
                right = mid - 1; 
            }
        }

        return res; 
    }
}
