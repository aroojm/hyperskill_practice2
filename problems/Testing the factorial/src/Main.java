public long get(int x) {
    if (x == -1) {
        return -1;
        }
    else if (x == 0) {
        return 1;
        }
    else {
        long fact = 1;
        for (int i = 2; i <= x; i++) {
        fact = fact * i;
        }
        return fact;
        }
}