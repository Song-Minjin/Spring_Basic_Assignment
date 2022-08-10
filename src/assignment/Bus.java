package assignment;

// 하위 클래스 : 버스
public class Bus extends Public_Transport {
    String[] bus_status = {"차고지행", "운행 중"};

    // 버스 객체 생성
    public Bus() {
        // Bus 기본값 설정
        this.number = createNumber();
        this.passenger = 0;
        this.max_passenger = 30;
        this.basic_fare = 1000;
        this.status = bus_status[1];
        this.fuel_amount = 100;
        this.speed = 0;
    }

    // 승객 탑승
    public void takeOnPassenger(int new_passenger) {
        if (status.equals(bus_status[1])) {
            if (new_passenger <= getAvailable()) {
                passenger += new_passenger;
            } else {
                System.out.println("⛔ 최대 승객 수 초과");
            }
        }
    }

    @Override // 버스 상태 -> 차고지로 변경
    public void changeStatus() {
        status = (status.equals(bus_status[1])) ? bus_status[0] : bus_status[1];
        passenger = 0;
    }

    // 버스 정보 출력
    public void showInfo() {
        String info = "[ " + number + "번 버스 정보" + " 🚌 ]" + "\n"
                    + "탑승 승객 수 : " + passenger + "\n"
                    + "잔여 좌석 : " + getAvailable() + "\n"
                    + "요금 확인 : " + checkFare() + "\n"
                    + "상태 : " + status + "\n"
                    + "연료량 : " + fuel_amount;
        System.out.println(info);
        if (outOfFuel()){
            System.out.println("⚠ 주유가 필요합니다.");
        }
    }
}