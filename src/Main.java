import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author 长白崎
 * @class["第十五届蓝桥杯JavaB组"]
 */
public class Main {
    final static PrintWriter out = new PrintWriter(System.out);//快输

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long vi[] = new long[n];//vi[0]为主队列,1到(n-1)为副队列
        while (sc.hasNext()) {
            String op = sc.next();
            if (op.equals("add")) {
                int i = sc.nextInt();
                ++vi[0];//增加主队列元素总数
            } else if (op.equals("sync")) {
                int i = sc.nextInt();
                vi[i] = vi[0] < vi[i] + 1 ? vi[i] : vi[i] + 1;//同步副队列i中的个数
            } else if (op.equals("query")) {
                out.println(find(vi));//输出同步最小总数
            }
        }
        out.flush();
        out.close();
    }

    static long find(long arr[]) {
        long min = 0x3f3f3f3f;//比较取出最小同步总数
        for (int i = 0; i < arr.length; ++i) {
            min = Math.min(min, arr[i]);
        }
        return min;
    }
}