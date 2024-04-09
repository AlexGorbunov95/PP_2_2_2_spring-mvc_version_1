package service;
import model.Car;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component

public class ServiceCarImp implements ServiceCar {
    private int count;
    private List<Car> cars;

    {
        cars = new ArrayList<>();
        cars.add(new Car(++count, "Kia", 123, "black"));
        cars.add(new Car(++count, "Lada", 111, "Red"));
        cars.add(new Car(++count, "Mazda", 777, "While"));
        cars.add(new Car(++count, "Volvo", 987, "grey"));
        cars.add(new Car(++count, "Ford", 345, "blue"));
    }

    @Override
    public List<Car> addCar() {
        return cars;
    }

    @Override
    public List<Car> getCarCount(Integer count) {
        List<Car> countCars = new ArrayList<>();
        for (Car car : cars) {
            if (count != null && count >= car.getId()) {
                countCars.add(car);
            }
        }
        return countCars;
    }
}
