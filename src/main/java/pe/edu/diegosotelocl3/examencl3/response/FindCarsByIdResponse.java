package pe.edu.diegosotelocl3.examencl3.response;

import pe.edu.diegosotelocl3.examencl3.dto.CarDto;

public record FindCarsByIdResponse(String code,
                                   String error,
                                   CarDto car) {
}
