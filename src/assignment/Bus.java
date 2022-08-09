package assignment;

// 하위 클래스 : 버스
public class Bus extends Public_Transport {

    public Bus() {
        // 기본 값
        this.number = create_new_number();
        this.passenger = 0;
        this.available = max_passenger - passenger;
        this.status = "운행중";
        this.fuel_amount = 100;
        this.basic_fare = 1000;
    }

    public int fare_check(int new_passenger){
        return basic_fare * new_passenger;
    }
}

