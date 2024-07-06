class Solution {
    public int passThePillow(int n, int time) {
        int cycles = time / (n - 1);
        int remainder = time % (n - 1);

        if (cycles % 2 == 0) {
            return 1 + remainder;
        } else {
            return n - remainder;
        }

    }
}