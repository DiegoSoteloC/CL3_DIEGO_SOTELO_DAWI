package pe.edu.diegosotelocl3.examencl3.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.diegosotelocl3.examencl3.dto.CarCreateDto;
import pe.edu.diegosotelocl3.examencl3.dto.CarDto;
import pe.edu.diegosotelocl3.examencl3.response.*;
import pe.edu.diegosotelocl3.examencl3.service.CarService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/fabric")
public class FabricApi {

    @Autowired
    CarService carService;

    @GetMapping("/all")
    public FindCarsResponse findCar() {
        try {
            List<CarDto> cars = carService.getAllCars();
            return new FindCarsResponse("01", "Car List", cars);
        } catch (Exception e){
            e.printStackTrace();
            return new FindCarsResponse("99", "el servicio no funciona", null);
        }
    }

    @GetMapping("/detail")
    public FindCarsByIdResponse findCarsByIdResponse(@RequestParam(value = "id", defaultValue = "0")String id){
        try {
            if (Integer.parseInt(id) > 0) {
                Optional<CarDto> optional = carService.getCarById (Integer.parseInt(id));
                if (optional.isPresent()) {
                    CarDto carDto = optional.get();
                    return new FindCarsByIdResponse("01","", carDto);
                } else {
                    return new FindCarsByIdResponse("02","CARRO NO ENCONTRADO", null);
                }
            } else {
                return new FindCarsByIdResponse("03", "Parameter not found", null);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new FindCarsByIdResponse("99", "EL SERVICIO NO ESTA FUNCIONANDO", null);
        }
    }

    @PostMapping("/update")
    public UpdateCarResponse updateCarResponse(@RequestBody CarDto carDto) {
        try {
            if (carService.updateCar(carDto)){
                return new UpdateCarResponse("01", "Se carro se actualizo correctamente");
            } else {
                return new UpdateCarResponse("02", "CARRO NO ENCONTRADO");
            }

        } catch (Exception e) {
            e.printStackTrace();
            return new UpdateCarResponse("99", "EL SERVICIO NO ESTA FUNCIONANDO");
        }
    }

    @DeleteMapping("/delete")
    public DeleteCarResponse deleteCarResponse(@RequestParam(value = "id", defaultValue = "0") String id) {
        try {
            if (Integer.parseInt(id) > 0) {
                if (carService.deleteCar(Integer.parseInt(id))) {
                    return new DeleteCarResponse("01", "El Carro se eliminó correctamente");
                } else {
                    return new DeleteCarResponse("02", "CARRO NO ENCONTRADO");
                }
            } else {
                return new DeleteCarResponse("03", "Parámetro no válido");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new DeleteCarResponse("99", "EL SERVICIO NO ESTÁ FUNCIONANDO");
        }
    }

    @PostMapping("/create")
    public ResponseEntity<CreateCarResponse> createCar(@RequestBody CarCreateDto carCreateDto) {
        try {
            boolean isCreated = carService.addCar(carCreateDto);
            if (isCreated) {
                return ResponseEntity.ok(new CreateCarResponse("01", "El Carro se creó correctamente"));
            } else {
                return ResponseEntity.ok(new CreateCarResponse("02", "El Carro no se pudo agregar"));
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new CreateCarResponse("99", "El servicio no funciona"));
        }
    }
}
