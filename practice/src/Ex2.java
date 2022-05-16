import java.util.Scanner;

public class Ex2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int lowLimit = 2;
        final int highLimit = 9;
        System.out.printf("희망하는 구구단을 입력해 주세요. (%d ~ %d) : ", lowLimit, highLimit);
        int input = sc.nextInt();
        sc.close();
        if(input<lowLimit || input>highLimit){
            System.out.printf("%d단이 입력되었습니다.\n", input);
            System.out.printf("구구단은 %d단 ~ %d단 까지만 선택할 수 있습니다.", lowLimit, highLimit);
            return;
        }
        System.out.printf("%d단이 입력되었습니다.\n", input);
        for (int i=1 ; i<=9; i++){
            System.out.printf("%d * %d ="+ input * i+ "\n", input, i );
        }
    }
}
