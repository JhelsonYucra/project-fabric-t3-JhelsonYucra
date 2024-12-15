package pe.edu.i202224141.project_fabric_t3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pe.edu.i202224141.project_fabric_t3.dto.CarDto;
import pe.edu.i202224141.project_fabric_t3.service.ManageService;

import java.util.List;

@Controller
@RequestMapping("/manage")
public class ManageController {

    @Autowired
    ManageService manageService;


   @GetMapping("/start")
    public String start(Model model) {

       try {
           List<CarDto> cars = manageService.getAllCars();
           model.addAttribute("cars", cars);
           model.addAttribute("error", null);

       } catch (Exception e) {
           e.printStackTrace();
           model.addAttribute("error", "Ocurrió un error al obtener datos");
       }

       return "manage";
    }

}
