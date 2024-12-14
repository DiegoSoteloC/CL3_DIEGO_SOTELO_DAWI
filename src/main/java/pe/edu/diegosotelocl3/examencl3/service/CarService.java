package pe.edu.diegosotelocl3.examencl3.service;

import pe.edu.diegosotelocl3.examencl3.dto.CarCreateDto;
import pe.edu.diegosotelocl3.examencl3.dto.CarDto;

import java.util.List;
import java.util.Optional;

public interface CarService {

    List<CarDto> getAllCars() throws Exception;

    Optional<CarDto> getCarById(int id) throws Exception;

    boolean addCar(CarCreateDto carCreateDto) throws Exception;

    boolean updateCar(CarDto carDto) throws Exception;

    boolean deleteCar(int id) throws Exception;

}
