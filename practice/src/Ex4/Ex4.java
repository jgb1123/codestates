package Ex4;

import java.util.Arrays;
import java.util.Scanner;

public class Ex4 {
    static final String realId = "jgb1123";
    static final String realPass = "1234";
    static final String[] forbid = {"킹", "시발", "꺼저", "미친"};
    static final String[] trans = {"열", "사랑", "용기", "희망"};
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("유튜브 계정의 아이디를 입력하세요 : ");
        String id = sc.nextLine();
        System.out.print("유튜브 계정의 비밀번호를 입력하세요 : ");
        String pass = sc.nextLine();

        if(!id.equals(realId)||!pass.equals(realPass)){
            System.out.println("유튜브의 계정의 아이디 및 비밀번호를 다시 확인해 주세요.");
            return;
        }
        System.out.printf("안녕하세요 %s님.\n", id);
        System.out.println("유튜브 영상의 자막을 생성해 주세요.");
        String caption = sc.nextLine();

        System.out.println("프로그램의 금칙어 리스트입니다.");
        System.out.println(Arrays.toString(forbid));

        System.out.println("자막 순화 프로그램 결과입니다.");
        for(int i=0 ; i< forbid.length; i++){
            if(caption.contains(forbid[i])){
                caption = caption.replace(forbid[i], trans[i]);
            }
        }
        System.out.println(caption);
    }
}
