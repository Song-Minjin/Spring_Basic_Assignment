package assignment;

import java.io.PrintWriter;
import java.util.ArrayList;

// 상위 클래스 : 대중교통
public class Public_Transport {
    int number;
    public ArrayList<Integer> present_numbers;
    String status;
    int fuel_amount = 100;
    int speed;
    int passenger = 0;
    int available;
    int max_passenger;
    int basic_fare;

    public int create_new_number(){
        int new_number = 0;
        while (present_numbers.contains(new_number)){
            new_number += 1;
        }
        present_numbers.add(present_numbers.size(), new_number);
        return new_number;
    }

    public void takeOnPassenger(int new_passenger) {
        if (status.equals("운행중")) {
            if (new_passenger > available) {
                System.out.println("alert('최대 승객 수 초과')");
            } else{
                this.passenger += new_passenger;
                this.available -= new_passenger;
            }
        }
    }

    public int getFuel_amount(){
        if(fuel_amount < 10){
            System.out.println("alert('주유 필요')");
        }
        return fuel_amount;
    }

    public void useFuel(int fuel_change){
        this.fuel_amount += fuel_change;
    }

    public void refuel(int fuel_amount){
        this.fuel_amount += fuel_amount;
    }

    public void change_speed(int change_speed) {
        this.fuel_amount = getFuel_amount();
        if (fuel_amount < 10) {
            System.out.println("주유량을 확인해주세요.");
        } else{
            this.speed += change_speed;
        }
    }

    public void changeStatus(String status) {
        this.status = status;
    }
}



