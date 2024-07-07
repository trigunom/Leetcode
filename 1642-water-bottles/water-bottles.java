class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int drinkCount = numBottles;
        int emptyBottles = numBottles;
        
        while (emptyBottles >= numExchange) {
            int newBottles = emptyBottles / numExchange;
            drinkCount += newBottles;
            emptyBottles = newBottles + (emptyBottles % numExchange);
        }
        
        return drinkCount;
    }
}