class Solution {
    public int minOperations(String[] logs) {
        int depth = 0;
        
        for (String operation : logs) {
            if (operation.equals("../")) {
                if (depth > 0) {
                    depth--;
                }
            } else if (!operation.equals("./")) {
                depth++;
            }
        }
        
        return depth;
    }
}