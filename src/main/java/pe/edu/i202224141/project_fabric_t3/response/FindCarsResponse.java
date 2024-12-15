package pe.edu.i202224141.project_fabric_t3.response;

import pe.edu.i202224141.project_fabric_t3.dto.CarDto;

public record FindCarsResponse(String code,
                               String error,
                               Iterable<CarDto>cars) {
}
