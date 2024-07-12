class Solution {
    public int maximumGain(String s, int x, int y) {
        StringBuilder varOcg = new StringBuilder(s);
        int totalPoints = 0;
        
        char first, second;
        int pointsFirst, pointsSecond;
        if (x > y) {
            first = 'a';
            second = 'b';
            pointsFirst = x;
            pointsSecond = y;
        } else {
            first = 'b';
            second = 'a';
            pointsFirst = y;
            pointsSecond = x;
        }
        
        totalPoints += removeSubstring(varOcg, first, second, pointsFirst);
        
        totalPoints += removeSubstring(varOcg, second, first, pointsSecond);
        
        return totalPoints;
    }
    
    private int removeSubstring(StringBuilder sb, char first, char second, int points) {
        int count = 0;
        int i = 0;
        while (i < sb.length() - 1) {
            if (sb.charAt(i) == first && sb.charAt(i + 1) == second) {
                sb.delete(i, i + 2);
                count++;
                i = Math.max(0, i - 1); 
            } else {
                i++;
            }
        }
        return count * points;
    }
}
