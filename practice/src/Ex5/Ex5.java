package Ex5;

import java.util.Scanner;

public class Ex5 {
    public static void main(String[] args) {
        System.out.println("피보나치 수열 프로그램 시작.");
        int num = getUserInput();     // 사용자로부터 입력을 받는다.

        int[] fib = getFibonacci(num);  // 배열을 생성한다.

        printNumbers(fib);  //배열을 출력하고 종료한다.

    }
    private static int getUserInput(){
        Scanner sc = new Scanner(System.in);
        System.out.print("원하는 수열의 개수를 입력해 주세요 : ");
        int num = sc.nextInt();
        sc.close();
        return num;
    }
    private static int[] getFibonacci(int num){
        int[] fib = new int[num];
        for(int i=0 ; i<num ; i++){
            if(i<2) fib[i] = 1;
            else fib[i] = fib[i-2]+fib[i-1];
        }return fib;
    }
    private static void printNumbers(int[] fib){
        System.out.println("피보나치 수열 출력");
        for(int a : fib){
            System.out.println(a);
        }
        System.out.println("프로그램을 종료합니다.");
    }
}
