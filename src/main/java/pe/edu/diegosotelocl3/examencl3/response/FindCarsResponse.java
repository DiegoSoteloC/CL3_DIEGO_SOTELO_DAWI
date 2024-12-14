package pe.edu.diegosotelocl3.examencl3.response;

import pe.edu.diegosotelocl3.examencl3.dto.CarDto;

public record FindCarsResponse(String code,
                               String error,
                               Iterable<CarDto> cars) {
}
