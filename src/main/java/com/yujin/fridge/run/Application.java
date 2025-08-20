package com.yujin.fridge.run;

import com.yujin.fridge.service.FridgeService;

import java.util.Scanner;

public class Application {
    private static final FridgeService fs = new FridgeService();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("=== \uD83E\uDD6C 신선맨  \uD83C\uDF4B ===");
            System.out.println("1. 재료 조회");
            System.out.println("2. 재료 추가");
            System.out.println("3. 재료 사용");
            System.out.println("4. 재료 삭제");
            System.out.println("5. 장보기 목록");
            System.out.println("9. 프로그램 종료");
            System.out.print("메뉴를 선택해 주세요: ");

            int input = sc.nextInt();

            switch(input) {
                case 1: fs.findAllIngredients();
                        break;
                case 2: break;
                case 3: break;
                case 4: break;
                case 5: break;
                case 9:
                    System.out.println("신선맨을 종료합니다.");
                    return;
                default: break;
            }
        }


    }
}
