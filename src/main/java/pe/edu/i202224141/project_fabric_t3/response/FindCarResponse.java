package pe.edu.i202224141.project_fabric_t3.response;

import pe.edu.i202224141.project_fabric_t3.dto.CarDetailDto;

public record FindCarResponse(String code,
                              String error,
                              CarDetailDto car ){


}
