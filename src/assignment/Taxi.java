package assignment;

// 하위 클래스 : 택시
public class Taxi extends Public_Transport {
    String destination;
    int distance;
    int basic_distance;
    int fare_per_distance;

    public Taxi() {
        this.number = create_new_number();
        this.max_passenger = 4;
        this.passenger = 0;
        this.available = max_passenger - passenger;
        this.status = "일반";
        this.fuel_amount = 100;
        this.basic_fare = 3000;
        this.fare_per_distance = 1000;
        this.basic_distance = 1;
        this.speed = 0;
    }

    @Override
    public void takeOnPassenger(int new_passenger) {
        if (status.equals("일반")) {
            if (new_passenger > available) {
                System.out.println("alert('최대 승객 수 초과')");
            } else {
                this.passenger += new_passenger;
                this.available -= new_passenger;
                changeStatus("탑승 불가");
            }
        }
    }

    public int get_total_fare() {
        return basic_fare + fare_per_distance * (distance - basic_distance);
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }
}
