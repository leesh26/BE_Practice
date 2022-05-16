package com.codestates.seb.lol_program;

public class LOL_Program {
  public static void main(String[] args) {
    //TODO:
    System.out.println("[안내] 스타크래프트를 시작합니다.");
    System.out.println("[안내] 자신의 유닛 정보를 입력해주세요.");
    LoL_char user1 = new LoL_char();
    user1.user_create();
    user1.user_print(user1.info);

    System.out.println("========================================");
    System.out.println("[안내] 상대 유닛 정보를 입력해 주세요");

    LoL_char user2 = new LoL_char();
    user2.user_create();
    user2.user_print(user2.info);

    user1.attack(user1.user_info_int(user1.info), user2.user_info_int(user2.info));
  }
}