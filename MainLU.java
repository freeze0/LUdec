import java.util.*;

public class MainLU {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Fill n");
        int n = sc.nextInt();
        double a[][], L[][], U[][], b[], y[], x[];
        a = new double[n][n];
        L = new double[n][n];
        U = new double[n][n];
        b = new double[n];
        y = new double[n];
        x = new double[n];
        double sum = 0.0;
        System.out.println("Fill matrix");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = sc.nextDouble();
            }
        }
        System.out.println("Fill vector b");
        for (int i = 0; i < n; i++) {
            b[i] = sc.nextDouble();
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(a[i][j] + " | ");
            }
            System.out.println(b[i]);
        }
        System.out.println();
        for (int i = 0; i < n; i++)
        {
            for (int k = i; k < n; k++)
            {
                sum = 0.0;
                for (int j = 0; j < i; j++)
                    sum += (L[i][j] * U[j][k]);
                U[i][k] = a[i][k] - sum;
            }
            for (int k = i; k < n; k++)
            {
                if (i == k)
                    L[i][i] = 1;
                else
                {
                    sum = 0.0;
                    for (int j = 0; j < i; j++)
                        sum += (L[k][j] * U[j][i]);
                    L[k][i] = (a[k][i] - sum) / U[i][i];
                }
            }
        }
        for (int i = 0; i < n; i++) {
            sum = 0.0;
            for (int k = 0; k < i; k++)
                sum+=L[i][k]*y[k];
            for (int j = 0; j < n; j++)
                y[i]=b[i]-sum;
        }
        for (int i = 0; i < n; i++) {
            sum = 0.0;
            for (int k = i + 1; k < n; k++)
                sum+=U[i][k]*x[k];
            for (int j = 0; j < n; j++)
                x[i]=(y[i]-sum)/(U[i][i]);
        }
        System.out.println();
        for (int i = 0; i < n; i++) {
            System.out.println(x[i]);
        }
        for (int i=0; i<n; i++) {
            sum =0.0;
            for (int j=0; j<n; j++){
                sum+=a[i][j]*x[j];
            }
            System.out.print("inaccuracy is: "+Math.abs(b[i]-sum)+" | ");
        }

        /*for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(L[i][j] + " | ");
            }
            System.out.println();
        }
        System.out.println();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(U[i][j] + " | ");
            }
            System.out.println();
        }
        System.out.println();
        */

    }
}

/*

1 -2 3
3 1 -1
2 5 2


 */