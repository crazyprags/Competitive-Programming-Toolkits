import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;
public class trial
{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static boolean sieve[];
    public static void sieveOfEratosthenes(int n)
    {
        sieve = new boolean[n+1];
        Arrays.fill(sieve, true);
        sieve[0] = sieve[1] = false;
        for(int i=2; i<=n; i++)
        {
            if(sieve[i])
            {
                for(int j=i*i; j<=n; j+=i)  sieve[j] = false;
            }
        }
    }
    public static void main(String args[])
    {

    }
}
