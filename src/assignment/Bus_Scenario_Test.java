package assignment;

public class Bus_Scenario_Test {
    public static void main(String[] args) {

        // 버스 2대 생성
        Bus bus1 = new Bus();
        bus1.showInfo();
        System.out.println();

        Bus bus2 = new Bus();
        bus2.showInfo();
        System.out.println("--- 버스 2대 생성 완료 ---"+"\n");

        // 고유번호 다른지 확인 -> 잘 구현되었으면 true 출력
        System.out.println(bus1.number != bus2.number);
        System.out.println("--- 고유번호 구현 완료 ---"+"\n");

        // 시나리오 시작
        // 승객 + 2
        bus1.takeOnPassenger(2);
        bus1.showInfo();
        System.out.println("--- 시나리오 1-2번 완료 ---"+"\n");

        // 연료량 -50
        bus1.useFuel(-50);
        bus1.showInfo();
        System.out.println("--- 시나리오 3-4번 완료 ---"+"\n");

        // 상태변경 -> 차고지행
        bus1.changeStatus();

        // 주유 : 연료 + 10
        bus1.refuel(10);
        bus1.showInfo();
        System.out.println("--- 시나리오 5-7번 완료 ---"+"\n");

        // 상태 변경 -> 운행 중
        bus1.changeStatus();

        // 승객 + 45      -> '최대 승객 수 초과' 메시지 출력
        bus1.takeOnPassenger(45);
        System.out.println("--- 시나리오 8-10번 완료 ---"+"\n");

        // 승객 + 5
        bus1.takeOnPassenger(5);
        bus1.showInfo();
        System.out.println("--- 시나리오 11-12번 완료 ---"+"\n");

        // 연료량 -55      -> '주유 필요' 메시지 출력
        bus1.useFuel(-55);
        bus1.showInfo();
        System.out.println("--- 시나리오 13-15번 완료 ---"+"\n");
    }
}
