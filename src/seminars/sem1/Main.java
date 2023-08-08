package seminars.sem1;

import java.util.ArrayList;
import java.util.Date;

public class Main {

    public static int Sum(int N){
        // Сумму всех чисел от 1 до N
        int result = 0;
        for(int i = 1; i <= N; i++){ // O(N) - линейная
            result += i; // O(1)
        }

        // result = N * (N + 1) / 2; // O(1)

        return result;
    }

    public static void Simple(int N){

        for(int number = 2; number <= N; number++){ // O(N sqrt(N))
            boolean flag = true;
            for(int i = 2; i * i <= number; i++){ // O(sqrt(N))
                if(number % i == 0){
                    flag = false;
                    break;
                }
            }
            if(flag){
                System.out.println(number);
            }
        }
    }

    public static int Cubs1(int N, int K){ // O(N^4)
        int res = 0;
        for(int a=1; a<=N; a++)
            for(int b=1; b<=N; b++)
                for(int c=1; c<=N; c++)
                    for(int d=1; d<=N; d++)
                        res++;
        return res;
    }

    public static int Cubs2(int N, int K) { // O(N^K)
        if(K == 0){
            return 1;
        }
        int res = 0;
        for(int i = 1; i <= N; i++){
            res += Cubs2(N, K - 1);
        }
        return res;
    }

    public static int F1(int N){ // O(2^N) ~ O(1.6^N)
        // F[N] = F[N-1] + F[N-2], F[1] = 1, F[2] = 1
        if(N == 1 || N == 2)
            return 1;
        return F1(N-1) + F1(N-2);
    }
    public static int F2(int N){ // O(N)
        // F[N] = F[N-1] + F[N-2], F[1] = 1, F[2] = 1
        int F[] = new int[N+1]; // O(N)
        F[1] = 1; // O(1)
        F[2] = 1; // O(1)
        for(int i=3; i<=N; i++) // O(N)
            F[i] = F[i-1] + F[i-2]; // O(1)

        // O(N) + O(1) + O(1) + O(N) * O(1)
        // O(N) + O(N) = O(2*N) = 2 * O(N) = O(N)

        return F[N];
    }

    public static void Test(){
        for(int N = 10; N<=50; N++){
            Date start = new Date();
            F1(N);
            Date end = new Date();
            long time1 = end.getTime() - start.getTime();

            start = new Date();
            F2(N);
            end = new Date();
            long time2 = end.getTime() - start.getTime();

            System.out.printf("N = %d, time1 = %d, time2 = %d%n", N, time1, time2);
        }
    }

    public static void main(String[] args) {
        //System.out.println(Sum(100));
        //Simple(1000000);
        //System.out.println(Cubs2(6, 4));
        //System.out.println(F2(10));
        Test();
    }
}