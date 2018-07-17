package exercise;

public class CarTest {
    private  Car car;

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public static void main(String[] args) {
        Car car = new Car();
         Car falali = new Falali();
        car.runto("成都");
        CarTest carTest = new CarTest();
        carTest.setCar(falali);
        falali.runto("香港");
    }
}
