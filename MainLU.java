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
                if (U[i][k]==0) {
                    System.out.println("Matrix is not compatible");
                    System.exit(0);
                }
            }
            System.out.println();
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
        for (int i = n - 1; i >= 0; i--) {
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
        System.out.println();
        for (int i=0; i<n; i++) {
            sum =0.0;
            for (int j=0; j<n; j++){
                sum+=a[i][j]*x[j];
            }
            System.out.print("inaccuracy is: "+Math.abs(b[i]-sum)+" | ");
        }
        System.out.println();
        for (int i = 0; i < n; i++) {
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
    }

    /*public static double det(double a[][], int n){
        int size=n;
        double arr[][];
        if (a[0].length>2) {
            double result = 0;
            for (int i = 0; i < a[0].length; i++){
                arr = new double[a[0].length][[a[0].length];
                for (int j = 0; j < a[0].length; j++){
                    if (j!=i) {
                        for (int k = 1; j < a[0].length; j++){
                            arr[j]=a[j][k];
                        }
                    }
                }
                result+=det(arr)
            }
        }*/
}



/*
1 -2 3
3 1 -1
2 5 2

1 2 3

1 2 3 4
2 4 6 8
1 1 1 1
1 1 1 1

1 2 1 1


 */
