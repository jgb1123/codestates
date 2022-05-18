package Ex1;

import java.util.Scanner;

public class Ex1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("사용 전력을 정수로 입력하세요. [kWh] : ");
        int usedP = sc.nextInt();
        sc.close();
        double fee;         // 코드1 최종 요금 fee
        double fee2 = 0;    // 코드2 최종 요금 fee2
        double[] rate = {60.7, 125.9, 187.9, 280.6, 417.7, 670.6};
        if(usedP<0){
            System.out.println("잘못된 입력입니다.");
            return;
        }
        // 코드1
        if(usedP<=100){
            fee = usedP*rate[0];
        }else if(usedP<=200){
            fee = 100 * rate[0]+ (usedP-100)*rate[1];
        }else if (usedP <= 300) {
            fee = 100 * (rate[0] + rate[1]) + (usedP-200)*rate[2];
        }else if (usedP <= 400) {
            fee = 100 * (rate[0] + rate[1] + rate[2]) + (usedP-300)*rate[3];
        }else if (usedP <= 500) {
            fee = 100 * (rate[0]+ rate[1] + rate[2] + rate[3]) + (usedP-400)*rate[4];
        }else{
            fee = 100 * (rate[0]+ rate[1] + rate[2] + rate[3] + rate[4]) + (usedP-500)*rate[5];
        }
        System.out.println("=====================================코드1");
        System.out.printf("%d[kWh]의 전기 요금은 %.1f원 입니다.\n\n", usedP, fee);

        // 코드2
        int a = usedP/100;
        int b = 0;
        while(b<a){
            if(b==5) break;
            fee2 = fee2+100*rate[b];
            b++;
        }
        fee2 = fee2+(usedP-100*b)*rate[b];
        System.out.println("=====================================코드2");
        System.out.printf("%d[kWh]의 전기 요금은 %.1f원 입니다.\n", usedP, fee2);
    }
}