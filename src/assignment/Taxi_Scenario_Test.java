package assignment;

public class Taxi_Scenario_Test {
    public static void main(String[] args) {

        // 택시 2대 생성
        Taxi taxi1 = new Taxi();
        taxi1.showInfo();
        System.out.println();

        Taxi taxi2 = new Taxi();
        taxi2.showInfo();
        System.out.println("--- 택시 2대 생성 완료 ---"+"\n");

        // 각 번호 다른지 확인 -> 잘 구현되었으면 true 출력
        System.out.println(taxi1.number != taxi2.number);
        System.out.println("--- 고유번호 구현 완료 ---"+"\n");

        // 시나리오 시작
        // 승객 탑승 + 2
        taxi1.takeOnPassenger(2, "서울역", 2);
        taxi1.showInfo();
        System.out.println("--- 시나리오 1-2번 완료 ---"+"\n");

        // 연료량 감소 -80
        taxi1.useFuel(-80);

        // 요금 결제
        taxi1.payFare();
        taxi1.showInfo();
        System.out.println("--- 시나리오 3-5번 완료 ---"+"\n");


        // 승객 탑승 + 5    -> 최대 승객 수 초과 메시지 출력
        taxi1.takeOnPassenger(5, "", 0);
        System.out.println("--- 시나리오 6-7번 완료 ---"+"\n");

        // 승객 탑승 + 3
        taxi1.takeOnPassenger(3, "구로디지털단지역", 12);
        taxi1.showInfo();
        System.out.println("--- 시나리오 8-9번 완료 ---"+"\n");

        // 연료량 감소 -20
        taxi1.useFuel(-20);

        // 요금 결제
        taxi1.payFare();
        taxi1.showInfo();
        System.out.println("--- 시나리오 10-13번 완료 ---"+"\n");


    }
}
