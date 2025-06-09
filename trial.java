import java.io.*;

public class trial {
    static int M = (int) 1e9 + 7;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] factorial = new int[100001];
    static int[] modinv = new int[100001];

    static int modpow(int a, int b) {
        if (b == 0) return 1;
        a %= M;

        int halfpow = modpow(a, b / 2);
        int result = (int) ((1L * halfpow * halfpow) % M);
        if (b % 2 == 1) {
            result = (int) ((1L * result * a) % M);
        }
        return result;
    }

    static void precomputeFactorials() {
        factorial[0] = 1;
        modinv[0] = 1;
        for (int i = 1; i < factorial.length; i++) {
            factorial[i] = (int) ((1L * factorial[i - 1] * i) % M);
            modinv[i] = modpow(factorial[i], M - 2);
        }
    }

    static int ncr(int n, int r) {
        if (r > n) return 0;
        int num = factorial[n];
        int denom = (int) ((1L * modinv[r] * modinv[n - r]) % M);
        return (int) ((1L * num * denom) % M);
    }

    public static void main(String args[]) throws IOException {
        String[] nr = br.readLine().trim().split(" ");
        int n = Integer.parseInt(nr[0]);
        int r = Integer.parseInt(nr[1]);

        precomputeFactorials();  // Must call before nCr computation

        System.out.println(ncr(n, r)); // Should print 6 for input "4 2"
    }
}
