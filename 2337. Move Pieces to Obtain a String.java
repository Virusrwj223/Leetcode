class Solution {
    String target;

    public boolean canChange(String start, String target) {
        int targetPointer = 0;
        this.target = target;
        for (int i = 0; i < start.length(); i++) {
            if (start.charAt(i) != '_') {
                targetPointer = targetNextPiece(targetPointer) + 1;
                if (!compatible(start.charAt(i), target.charAt(targetPointer - 1), i, targetPointer - 1)) {
                    return false;
                }
            }
        }
        return hasSamePieces(start, target);
    }

    public boolean hasSamePieces(String start, String target) {
        int startNum = 0;
        int targetNum = 0;

        for (int i = 0; i < start.length(); i++) {
            if (start.charAt(i) != '_') startNum++;
            if (target.charAt(i) != '_') targetNum++;
        }

        return startNum == targetNum;
    }

    public boolean compatible(char start, char target, int startPos, int targetPos) {
        if (start != target) {
            return false;
        } else if (start == 'L' && startPos < targetPos) {
            return false;
        } else if (start == 'R' && startPos > targetPos) {
            return false;
        } else {
            return true;
        }
    }

    public int targetNextPiece(int pos) {
        for (int i = pos; i < target.length(); i++) {
            if (target.charAt(i) != '_') {
                return i;
            }
        }
        
        return target.length() - 1;
    }
}
