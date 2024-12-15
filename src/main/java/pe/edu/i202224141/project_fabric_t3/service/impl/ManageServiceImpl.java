package pe.edu.i202224141.project_fabric_t3.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.i202224141.project_fabric_t3.dto.CarDetailDto;
import pe.edu.i202224141.project_fabric_t3.dto.CarDto;
import pe.edu.i202224141.project_fabric_t3.entity.Car;
import pe.edu.i202224141.project_fabric_t3.repository.CarRepository;
import pe.edu.i202224141.project_fabric_t3.service.ManageService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ManageServiceImpl implements ManageService {

    @Autowired
    CarRepository carRepository;

    @Override
    public List<CarDto> getAllCars() throws Exception {

        List<CarDto> cars = new ArrayList<CarDto>();
        Iterable<Car> iterable = carRepository.findAll();
        iterable.forEach(car -> {
            cars.add(new CarDto(car.getCarId(),
                    car.getMake(),
                    car.getModel(),
                    car.getYear(),
                    car.getLicensePlate(),
                    car.getMileage(),
                    car.getColor()));
        });
        return cars;
    }

    @Override
    public Optional<CarDetailDto> getCarById(int carId) throws Exception {

        Optional<Car> optional = carRepository.findById(carId);
        return optional.map(car -> new CarDetailDto(car.getCarId(),
                car.getMake(),
                car.getModel(),
                car.getYear(),
                car.getVin(),
                car.getLicensePlate(),
                car.getOwnerName(),
                car.getOwnerContact(),
                car.getPurchaseDate(),
                car.getMileage(),
                car.getEngineType(),
                car.getColor(),
                car.getInsuranceCompany(),
                car.getInsurancePolicyNumber(),
                car.getRegistrationExpirationDate(),
                car.getServiceDueDate()));
    }

    @Override
    public boolean updateCar(CarDto carDto) throws Exception {

        Optional<Car> optional = carRepository.findById(carDto.carId());
        return optional.map(car -> {
            car.setMake(carDto.make());
            car.setModel(carDto.model());
            car.setYear(carDto.year());
            car.setLicensePlate(carDto.licensePlate());
            car.setMileage(carDto.mileage());
            car.setColor(carDto.color());
            carRepository.save(car);
            return true;

        }).orElse(false);
    }

    @Override
    public boolean deleteCarById(int carId) throws Exception {

        Optional<Car> optional = carRepository.findById(carId);
        return optional.map(car -> {
            carRepository.delete(car);
            return true;
        }).orElse(false);
    }

    @Override
    public boolean addCar(CarDetailDto carDetailDto) throws Exception {
        Optional<Car> optional = carRepository.findById(carDetailDto.carId());
        if (optional.isPresent()) {
            return false;
        } else {
            Car car = new Car();
            car.setMake(carDetailDto.make());
            car.setModel(carDetailDto.model());
            car.setYear(carDetailDto.year());
            car.setVin(carDetailDto.vin());
            car.setLicensePlate(carDetailDto.licensePlate());
            car.setOwnerName(carDetailDto.ownerName());
            car.setOwnerContact(carDetailDto.ownerContact());
            car.setPurchaseDate(carDetailDto.purchaseDate());
            car.setMileage(carDetailDto.mileage());
            car.setEngineType(carDetailDto.engineType());
            car.setColor(carDetailDto.color());
            car.setInsuranceCompany(carDetailDto.insuranceCompany());
            car.setInsurancePolicyNumber(carDetailDto.insurancePolicyNumber());
            car.setRegistrationExpirationDate(carDetailDto.registrationExpirationDate());
            car.setServiceDueDate(carDetailDto.serviceDueDate());
            carRepository.save(car);
            return true;
        }
    }
}






