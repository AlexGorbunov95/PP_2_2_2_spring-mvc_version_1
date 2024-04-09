package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import service.ServiceCar;
import service.ServiceCarImp;



@Controller
public class CarsController {
    @Autowired
    private ServiceCar serviceCar;

    public CarsController(ServiceCarImp serviceCarImp) {
        this.serviceCar = serviceCarImp;
    }

    @GetMapping(value = "/cars")
    public String printCars(@RequestParam(required = false) Integer count, Model model) {
        if (count == null) {
            model.addAttribute("cars", serviceCar.addCar());
        } else {
            model.addAttribute("cars", serviceCar.getCarCount(count));
        }
        return "Car";
    }
}
