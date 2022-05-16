import java.util.Scanner;

public class Ex6 {
    public static void main(String[] args) {
        String[] list = {"등록 가능", "등록 가능", "등록 가능", "등록 가능", "등록 가능"};
        int[] listNum = {0, 0, 0, 0, 0};
        boolean keep = true;
        System.out.println("안녕하세요.");
        System.out.println("해당 프로그램의 기능입니다.");
        do{
            show_Menu();
            int num = Ex6.select_Menu();
            switch(num) {
                case 1: // 상품 등록
                    insert_Product(list);
                    show_Product_List(list, listNum);
                    break;
                case 2: // 상품 제거
                    delete_Product(list);
                    for(int i=0 ; i<5 ; i++){
                        if(list[i].equals("등록 가능")){
                            listNum[i] = 0;
                        }
                    }
                    show_Product_List(list, listNum);
                    break;
                case 3: // 물건 넣기
                    insert_Product_Num(list, listNum);
                    show_Product_List(list, listNum);
                    break;
                case 4: // 물건 빼기
                    delete_Product_Num(list, listNum);
                    show_Product_List(list, listNum);
                    break;
                case 5: //재고 조회
                    show_Product_List(list, listNum);
                    break;
                case 6: //프로그램 종료
                    keep = false;
                    System.out.println("프로그램을 종료합니다.");
                    break;
                default:
                    System.out.println("1 ~ 6만 입력해주세요.");
            }
        }while(keep);

    }
    static void show_Menu(){
        System.out.println("-----------------------------");
        System.out.println("1. 물건 정보(제품명) 등록하기");
        System.out.println("2. 물건 정보(제품명) 등록 취소하기");
        System.out.println("3. 물건 넣기(제품 입고)");
        System.out.println("4. 물건 빼기(제품 출고)");
        System.out.println("5. 재고 조회");
        System.out.println("6. 프로그램 종료");
        System.out.println("-----------------------------");
    }
    static int select_Menu(){
        Scanner sc = new Scanner(System.in);
        System.out.print("원하시는 기능을 선택하세요 : ");
        return sc.nextInt();
    }
    static void insert_Product(String[] list) {
        Scanner sc = new Scanner(System.in);
        System.out.print("등록을 원하는 제품명을 입력하세요 : ");
        String insert = sc.nextLine();
        for (int i = 0 ; i < 5 ; i++){
            if(list[i].equals("등록 가능")){
                list[i] = list[i].replace("등록 가능", insert);
                return;
            }
        }
        System.out.println("등록 가능한 자리가 부족합니다.");
    }
    static void delete_Product(String[] list) {
        Scanner sc = new Scanner(System.in);
        System.out.print("제거를 원하는 제품명을 입력하세요 : ");
        String delete = sc.nextLine();
        for (int i = 0 ; i < 5 ; i++){
            if(list[i].equals(delete)){
                list[i] = list[i].replace(delete, "등록 가능");
                return;
            }
        }
        System.out.println("제거할 제품이 없습니다.");
    }
    static void insert_Product_Num(String[] list, int[] listNum){
        Scanner sc = new Scanner(System.in);
        System.out.print("수량을 추가할 제품명을 입력하세요 : ");
        String insert = sc.nextLine();
        System.out.print("추가할 수량을 입력하세요 : ");
        int insertNum = sc.nextInt();
        for (int i = 0 ; i < 5 ; i++){
            if(list[i].equals(insert)){
                listNum[i]+=insertNum;
                return;
            }
        }
        System.out.println("일치하는 제품명이 없습니다.");
    }
    static void delete_Product_Num(String[] list, int[] listNum){
        Scanner sc = new Scanner(System.in);
        System.out.print("출고를 진행할 제품명을 입력하세요 : ");
        String insert = sc.nextLine();
        System.out.print("출고할 수량을 입력하세요 : ");
        int insertNum = sc.nextInt();
        for (int i = 0 ; i < 5 ; i++){
            if(list[i].equals(insert)){
                listNum[i]-=insertNum;
                return;
            }
        }
        System.out.println("일치하는 제품명이 없습니다.");
    }
    static void show_Product_List(String[] list, int[] listNum){
        for(int i = 0 ; i < 5 ; i++){
            System.out.printf("%s : %d개\n", list[i], listNum[i]);
        }
    }
}
