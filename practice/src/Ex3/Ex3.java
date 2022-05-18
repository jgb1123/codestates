package Ex3;

import java.util.Scanner;

public class Ex3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double sum = 0;
        System.out.print("a 값을 입력하여 주세요. : ");
        int a = sc.nextInt();
        System.out.print("b 값을 입력하여 주세요. : ");
        int b = sc.nextInt();
        sc.close();
        double[] adRates = {440.0, 510.0, 640.0, 720.0};    // 광고비
        double[] visitor = {442, 445, 471, 501};    // 실제 방문자 수
        System.out.println("입력된 광고비는 다음과 같습니다.");
        for(int i=0; i < adRates.length ; i++){     // 광고비 출력
            System.out.printf("%d번째) %.1f원  ", i+1, adRates[i]);
        }
        System.out.println("\n\n웹 페이지 방문자 예측 결과는 다음과 같습니다.");
        for(int i=0; i < adRates.length ; i++){     // 예측 결과 출력
            System.out.printf("%d번째 예측) %.1f회 방문\n", i+1, adRates[i]*a+b);
        }
        System.out.println("\n프로그램에 할당된 데이터");
        for(int i=0; i < adRates.length ; i++){     // 실제 방문자 수 (할당된 데이터)
            System.out.printf("[실제값] 웹 페이지 방문자 수 : %.1f [예측값] 웹 페이지 방문자 수 : %.1f\n", visitor[i], adRates[i]*a+b);
        }

        for(int i=0; i < adRates.length ; i++){     // 실제 방문자 수와 예측 방문자 수의 차이
            System.out.printf("\n[%d 번째 데이터] 실제 값과 예측 값의 오차 %.1f\n", i+1, visitor[i]-(adRates[i]*a+b));
            System.out.printf("오차의 제곱 : %.1f\n", Math.pow(visitor[i]-(adRates[i]*a+b), 2));
            sum += Math.pow(visitor[i]-(adRates[i]*a+b), 2);
        }
        System.out.println("========================================");
        System.out.printf("인공지능 프로그램의 성능(오차의 제곱 합) : %.1f", sum);   // 오차의 제곱 값들의 합
    }
}
