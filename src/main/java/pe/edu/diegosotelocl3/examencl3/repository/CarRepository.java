package pe.edu.diegosotelocl3.examencl3.repository;

import org.springframework.data.repository.CrudRepository;
import pe.edu.diegosotelocl3.examencl3.entity.Car;

public interface CarRepository extends CrudRepository<Car, Integer> {
}
