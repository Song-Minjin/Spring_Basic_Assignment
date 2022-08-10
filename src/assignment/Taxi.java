package assignment;

// 하위 클래스 : 택시
public class Taxi extends Public_Transport {
    int basic_distance;
    int fare_per_distance;
    int total_fare;
    String destination;
    int distance;
    String[] taxi_status = {"일반", "운행 중", "운행 불가"};

    // 택시 객체 생성
    public Taxi() {
        // Taxi 기본값 설정
        this.number = createNumber();
        this.passenger = 0;
        this.max_passenger = 4;
        this.basic_fare = 3000;
        this.basic_distance = 1;
        this.destination = "없음";
        this.fare_per_distance = 1000;
        this.total_fare = 0;
        this.status = taxi_status[0];
        this.fuel_amount = 100;
        this.speed = 0;
    }

    // 승객 탑승
    public void takeOnPassenger(int new_passenger, String new_dest, int new_di) {
        if (status.equals(taxi_status[0]) && fuel_amount >= 10) {
            if (new_passenger > max_passenger) {                 // 최대 인원 초과시
                System.out.println("⛔ 최대 승객 수 초과");         // 메시지 출력
            }
            else {                                      // 승객 탑승시
                changeStatus();
                passenger += new_passenger;
                destination = new_dest;
                distance = new_di;
                getTotal_fare();
            }
        }
    }

    // 요금 결제
    public void payFare() {
        total_fare = 0;
        changeStatus();                  // 계산했으니 '일반'으로 상태 변경
    }

    // 지불할 요금 계산
    public void getTotal_fare() {
        if (distance == 0) {                // 목적지까지 거리가 0일 경우, 요금 없음
            total_fare = 0;
        }
        else if (distance <= basic_distance) {      // 목적지까지 거리가 기본 거리 이하일 경우, 기본 요금
            total_fare = basic_fare;
        }
        else {                              // 그 외의 경우 거리에 따라 계산
            total_fare = basic_fare + fare_per_distance * (distance - basic_distance);
        }
    }

    // 택시 상태 변경
    @Override
    public void changeStatus() {
        if (outOfFuel()) {                    // 연료가 없으면 상태 변경 -> '운행 불가'로 변경
            status = taxi_status[2];
        }
        else if (passenger == 0) {            // 연료도 있고 승객이 0이었는데 상태 변경(= 승객이 타는 경우) -> '운행 중'으로 변경
            status = taxi_status[1];
        }
        else {                               // 연료도 있고 승객도 타있는 상황에서 상태변경(= 승객이 계산하고 내릴 경우) -> '일반'으로 변경
            status = taxi_status[0];
            passenger = 0;
            destination = "없음";
            distance = 0;
        }
    }

    // 택시 정보 출력
    public void showInfo() {
        String info = "[ " + number + "번 택시 정보" + " 🚕 ]" + "\n"
                    + "탑승 승객 수 : " + passenger + "\n"
                    + "잔여 좌석 : " + getAvailable() + "\n"
                    + "기본 요금 확인 : " + basic_fare + "\n"
                    + "목적지 : " + destination + "\n"
                    + "목적지까지 거리 : " + distance + "km" + "\n"
                    + "지불할 요금 : " + total_fare + "\n"
                    + "상태 : " + status + "\n"
                    + "연료량 : " + fuel_amount;
        System.out.println(info);
        if (outOfFuel()){
            System.out.println("⚠ 주유가 필요합니다.");
        }
    }
}
