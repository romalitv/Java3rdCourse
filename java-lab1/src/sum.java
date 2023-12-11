class sum {

    public double summing(double n, double m, double a, double b, double C) {

        double sums = 0;

        if (a > n && b > m) {
            System.out.println("S = 0");
            return 0;
        }

        for (double i = a; i<=n; i++) {
            for (double j = b; j<=m; j++) {
                if(i == C) {
                    System.out.println("Division by zero");
                    return 0;
                }
                sums = sums + (i*j)/(i-C);
            }
        }

        System.out.println("Summation = " + sums);


        return sums;
    }
}
