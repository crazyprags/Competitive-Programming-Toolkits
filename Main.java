import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static class Pair {
        int node;
        long wt;

        public Pair(int node, long wt) {
            this.node = node;
            this.wt = wt;
        }
    }

    static int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    public static void build(int[] arr, int[] seg, int low, int high, int ind) {
        if (low == high) {
            seg[ind] = arr[low];
            return;
        }

        int mid = low + (high - low) / 2;

        build(arr, seg, low, mid, 2 * ind + 1);
        build(arr, seg, mid + 1, high, 2 * ind + 2);

        seg[ind] = gcd(seg[2 * ind + 1], seg[2 * ind + 2]);
    }

    public static void find(int[] seg, int low, int high, int l, int r, int ind, int x, int cnt[], int trstp) {
        if (high < l || r < low || r<l || high<low) return ;
        if (low >= l && high <= r)
        {
            if (seg[ind] % x == 0) return ;
            while(low!=high)
            {
                int mid = (low+high)/2;
                if(seg[2*ind+1]%x!=0)
                {
                    if(seg[2*ind+2]%x!=0)
                    {
                        cnt[0]+=2;
                        return;
                    }
                    ind = 2*ind+1;
                    high = mid;
                }

                else {
                    ind = 2*ind+2;
                    low = mid+1;
                }
            }

            cnt[0]++;
            return;
        }

        int mid = (low+high)/2;
        find(seg, low, mid, l, r, 2*ind+1, x, cnt, trstp);
        if(cnt[0]>1)    return;
        find(seg, mid+1, high, l, r, 2*ind+2, x, cnt, trstp);
    }

    public static void update(int[] seg, int low, int high, int ind, int i, int val)
    {
        if(high==low)
        {
            seg[ind] = val;
            return;
        }

        int mid = (low+high)/2;
        if(i<=mid)  update(seg, low, mid, 2*ind+1, i, val);
        else update(seg, mid+1, high, 2*ind+2, i, val);

        seg[ind] = gcd(seg[2*ind+1], seg[2*ind+2]);
    }

    public static void solve() throws IOException
    {
        
    }

    public static void main(String[] args) throws IOException {
        int t = 1;
        while(t-->0)
        {
            solve();
        }
    }
}
