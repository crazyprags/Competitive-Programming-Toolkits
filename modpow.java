import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;
public class modpow
{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static boolean sieve[];
    static int MOD = (int)1e9+7;
    int power(int a, int b)
    {
        if(b==0)    return 1;
        a%=MOD;
        int half_power = power(a, b/2);
        if(b%2==0)  return (half_power*half_power)%MOD;
        else return (half_power*half_power*a)%MOD;
    }
    public static void main(String args[])
    {

    }
}
