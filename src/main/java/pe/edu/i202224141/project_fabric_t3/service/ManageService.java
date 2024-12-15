package pe.edu.i202224141.project_fabric_t3.service;

import pe.edu.i202224141.project_fabric_t3.dto.CarDetailDto;
import pe.edu.i202224141.project_fabric_t3.dto.CarDto;

import java.util.List;
import java.util.Optional;

public interface ManageService {

    List<CarDto> getAllCars()throws Exception;

    Optional<CarDetailDto> getCarById(int carId) throws Exception;

    boolean updateCar(CarDto carDto) throws Exception;

    boolean deleteCarById (int carId) throws Exception;

    boolean addCar(CarDetailDto carDetailDto) throws Exception;

}
