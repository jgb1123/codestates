package Ex8;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Ex8 {
    static Scanner sc = new Scanner(System.in);

    static final int[] menu_cost = new int[]{1000, 1500, 1000, 2000};
    static int[] menu_quantity = new int[]{99, 99, 99, 99};
    public static void main(String[] args) {
        boolean stock = true;
        while(stock) {
            start();
            int number = insertNumber(); // 주문 메뉴 번호 입력 및 반환
            int orderQuantity = insertQuantity(number); // 주문 수량 입력 및 반환
            orderAmount(number, orderQuantity);    // 총 금액 표시
            if(IntStream.of(menu_quantity).anyMatch(x -> x == 0)) { // 메뉴 재고 없으면 종료
                stock = false;
                System.out.println("\n재료 소진으로 조기 마감합니다.");
            }
        }
    }

    static void start() {
        System.out.println("안녕하세요. 김밥천국에 오신 것을 환영합니다.");
        System.out.println("-------------------------------------");
    }


    static int insertNumber() {
        System.out.println("[안내]원하시는 메뉴의 번호를 입력하여 주세요.");
        System.out.printf("1) 김밥 %d원(남은 수량 : %d개) \n", menu_cost[0], menu_quantity[0]);
        System.out.printf("2) 계란 김밥 %d원(남은 수량 : %d개) \n", menu_cost[1], menu_quantity[1]);
        System.out.printf("3) 충무 김밥 %d원(남은 수량 : %d개) \n", menu_cost[2], menu_quantity[2]);
        System.out.printf("4) 떡볶이 %d원(남은 수량 : %d개)\n", menu_cost[3], menu_quantity[3]);

        int number = sc.nextInt();

        if (number <= 0 || number > 4) {
            System.out.printf("%d번 메뉴는 없습니다. 다시 입력해 주세요.\n", number);
        }else return number;
        return insertNumber();
    }

    static int insertQuantity(int number) {
        System.out.println("-------------------------------------");
        System.out.println("몇 개를 주문하시겠습니까?");
        System.out.printf("최대 주문 가능 수량 : %d\n", menu_quantity[number-1]);
        int orderQuantity = sc.nextInt();
        if(menu_quantity[number-1]<orderQuantity) {
            System.out.printf("재고가 부족합니다. %d개 이하로 주문해 주세요.\n",menu_quantity[number-1]);
            System.out.println("수량 선택화면으로 돌아갑니다.");
        }else if(orderQuantity<0){
            System.out.println("1개 이상 주문해주세요.");
            System.out.println("수량 선택화면으로 돌아갑니다.");
        }else {
            menu_quantity[number-1]-=orderQuantity;
            return orderQuantity;
        }
        return insertQuantity(number);
    }

    static void orderAmount(int number, int orderQuantity) {
        int result = menu_cost[number - 1] * orderQuantity;
        System.out.printf("주문하신 메뉴의 총 금액은 %d원 입니다.\n", result);
        System.out.println("이용해 주셔서 감사합니다.");
    }

}