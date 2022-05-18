package Ex7;

import java.util.Scanner;

public class Ex7 {
    public static void main(String[] args) {
        System.out.println("게임을 시작합니다.");
        CreateChar c1 =  new CreateChar();
        CreateChar c2 = new CreateChar();
        System.out.println("자신의 유닛 정보를 입력해 주세요");
        c1.create();
        c1.info_status();
        System.out.println("상대 유닛 정보를 입력해 주세요");
        c2.create();
        c2.info_status();
        c1.transToInt();
        c2.transToInt();

        do{
            CreateChar.attack(c1, c2);
        }while (c2.hpInt!=0);
    }

}
class CreateChar {
    String name, ad, def, hp;
    int adInt, defInt, hpInt;
    void create() {
        Scanner sc = new Scanner(System.in);
        System.out.print(" 유닛 [이름] 을 입력해 주세요 : ");
        this.name = sc.nextLine();
        System.out.print(" 유닛 [공격력]을 입력해 주세요 : ");
        this.ad = sc.nextLine();
        System.out.print(" 유닛 [방어력]을 입력해 주세요 : ");
        this.def = sc.nextLine();
        System.out.print(" 유닛 [체력]을 입력해 주세요 : ");
        this.hp = sc.nextLine();
    }
    void info_status(){
        System.out.println("\n생성된 유닛 정보는 다음과 같습니다");
        System.out.println(name+" 유닛이 게임에 참여하였습니다.");
        System.out.printf("[공격력] : %s\n", ad);
        System.out.printf("[방어력] : %s\n", def);
        System.out.printf("[체력] : %s\n", hp);
        System.out.println("===================================");
    }
    void transToInt(){
        adInt = Integer.parseInt(this.ad);
        defInt = Integer.parseInt(this.def);
        hpInt = Integer.parseInt(this.hp);
    }
    static void attack(CreateChar myChar, CreateChar enemy){
        int decreaseHp = myChar.adInt - enemy.defInt;
        enemy.hpInt = enemy.hpInt-decreaseHp;

        if(enemy.hpInt<0) enemy.hpInt=0;
        System.out.printf("[%s]유닛이 [공격] 하였습니다. \n", myChar.name);
        System.out.printf("상대유닛의 남은 [체력]은 %d입니다. \n", enemy.hpInt);
        System.out.println("-----------------------------------");
        if(enemy.hpInt==0)
        {
            System.out.println("더 이상 공격할 수 없습니다.\n");
            System.out.println("상대 유닛이 제거되었습니다.");
        }

    }
}
