class Solution {
    public int findTheWinner(int n, int k) {
        List<Integer> circle = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            circle.add(i);
        }
        
        int currentIndex = 0; 
        
        while (circle.size() > 1) {
            currentIndex = (currentIndex + k - 1) % circle.size();
            
            circle.remove(currentIndex);
            if (currentIndex == circle.size()) {
                currentIndex = 0;
            }
        }
        
        return circle.get(0);
    }
}