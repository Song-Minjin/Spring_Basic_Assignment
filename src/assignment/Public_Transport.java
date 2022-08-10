package assignment;

// 상위 클래스 : 대중교통
public class Public_Transport {
    static int cnt = 0;
    int number;
    int passenger = 0;
    int max_passenger;
    int basic_fare;
    String status;
    int fuel_amount = 100;
    int speed;

    //새 고유 번호 생성
    public int createNumber() {
        ++cnt;
        return cnt;
    }

    // 잔여 좌석 확인
    public int getAvailable() {
        return max_passenger - passenger;
    }

    // 요금 체크
    public int checkFare() {
        return basic_fare * passenger;
    }

    // 연료 부족
    public boolean outOfFuel(){
        return (fuel_amount < 10);
    }

    // 연료량 감소
    public void useFuel(int fuel_change) {
        fuel_amount += fuel_change;
        if (outOfFuel()){
            changeStatus();
        }
    }

    // 연료량 증가 (주유)
    public void refuel(int fuel_change) {
        fuel_amount += fuel_change;
    }

    // 속도 변경
    public void changeSpeed(int speed_change) {
        if (outOfFuel()) {
            speed += speed_change;
        } else {
            System.out.println("⚠ 주유량을 확인해주세요.");
        }
    }

    // 상태 변경
    public void changeStatus() {}

}