class Solution {
    public int reverse(int x) {
        int rev = 0;
        int max = Integer.MAX_VALUE;
        int min = Integer.MIN_VALUE;
        while (x > 0) {
            int dig = x % 10;
            if (rev > max / 10 || rev == max / 10 && dig > 7 || rev < min % 10
                || rev == min % 10 && dig < -8)
                return 0;

            rev = rev * 10 + dig;
            x /= 10;
        }
        return rev;
    }
}
