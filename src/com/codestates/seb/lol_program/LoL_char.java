package com.codestates.seb.lol_program;
import java.util.Scanner;

/**
 * @LoL_char() : 게임정보를 담는 클래스
 * @name : 유닛의 이름
 * @ad :   유닛의 공격력
 * @def :  유닛의 방어력
 * @hp :   유닛의 체력
 * */
class LoL_char {
  //TODO:
  // 사용자의 입력을 받기위한 객체 생성을 진행합니다.
  Scanner sc = new Scanner(System.in);
  // 게임에 필요한 변수 타입을 사전 정의합니다.
  String[] info;

  /**
   * @user_info : 생성된 유닛의 정보를 담는 메서드
   * @this : 해당 메서드가 입력받은 변수들은 this 를
   * */
  void user_info(String name, String ad, String def, String hp) {
    this.info = new String[]{name, ad, def, hp};
  }

  /**
   * @user_create() : 유닛을 생성하는 메서드이며, 입력된 값은 user_info() 메서드에게 전달 및 반환 처리합니다.
   * 반환된 값은 시스템 정보창에 출력되도록 합니다.
   * */
  String[] user_create() {
    //TODO:
    //입력 메시지와 함께, 게임에 필요한 유닛의 정보를 입력받습니다.
    System.out.println("[시스템] 유닛 [이름] 을 입력해 주세요 :");
    String name = sc.nextLine();
    System.out.println("[시스템] 유닛 [공격력] 을 입력해 주세요 : (Ex 50)");
    String ad = sc.nextLine();
    System.out.println("[시스템] 유닛 [방어력] 을 입력해 주세요 : (Ex 1)");
    String def = sc.nextLine();
    System.out.println("[시스템] 유닛 [체력] 을 입력해 주세요 : (Ex 100)");
    String hp = sc.nextLine();

    // 입력된 값은 user_info()에 전달하여 줍니다.
    user_info(name, ad, def, hp);

    // 유저마다의 객체 생성을 위해 반환 과정 또한 정의하여 줍니다.
    return info;
  }

  /**
   * @user_print() : 입력된 배열을 통해 유닛 정보 출력
   * */
  void user_print(String[] user) {
    //TODO:
    System.out.println("[안내] 생성된 유닛 정보는 다음과 같습니다.");
    System.out.println("[안내] "+user[0]+" 유닛이 게임에 참여하였습니다.");
    System.out.println("[공격력] : " + user[1]);
    System.out.println("[방어력] : " + user[2]);
    System.out.println("[체력] : " + user[3]);
  }

  /**
   * @user_info_int() : 공격력과 방어력 등을 고려해 체력 감소를 위해 문자열을 정수형태로 전환합니다.
   * Integer.parseInt() : 정수형태로 전환합니다.
   */
  int[] user_info_int(String[] info) {
    //TODO:
    // 같은 형식의 반환을 위해 배열 선언
    int[] user_info_int = new int[info.length-1];
    // 배열의 값을 하나씩 꺼내 정수형태로 전환합니다.
    for (int i=1; i<info.length; i++){
      user_info_int[i-1] = Integer.parseInt(info[i]);
    }
    return user_info_int;
  }


  /**
   * @attack() : 공격을 수행하는 메서드
   * 아군 유닛 정보와 상대의 정보를 입력받습니다.
   * */
  void attack(int[] me_info_int, int[] enemy) {
    // 조건 1. 적군의 체력이 0 이하면 [유닛 제거] 가 됩니다.
    // 조건 2. 적군 체력이 0 이하가 아니라면 공격을 성공적으로 수행합니다.
    // 공격 정책 수식 : 적군 체력 -= 아군 유닛 공격력 / 적군 유닛 방어력
    //TODO:

    int result = enemy[2];
    while (result > 0){
      System.out.println("----------------------------------------");
      System.out.printf("[안내] [%s]유닛이 [공격] 하였습니다. \n", this.info[0]);
      result -= (me_info_int[0] / enemy[1]) ;
      if (result <= 0) break;
      System.out.println("[안내] 상대 유닛의 남은 [체력]은 " + result + "입니다.");
      System.out.println("----------------------------------------");}

    System.out.println("[안내] 상대 유닛의 남은 [체력]은 0 입니다.");
    System.out.println("----------------------------------------");
    System.out.println("[안내] 더 이상 공격할 수 없습니다.");

    System.out.println("[안내] 상대 유닛이 제거되었습니다.");

  }
}
