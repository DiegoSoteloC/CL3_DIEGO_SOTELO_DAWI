package pe.edu.diegosotelocl3.examencl3.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.diegosotelocl3.examencl3.dto.CarCreateDto;
import pe.edu.diegosotelocl3.examencl3.dto.CarDto;
import pe.edu.diegosotelocl3.examencl3.entity.Car;
import pe.edu.diegosotelocl3.examencl3.repository.CarRepository;
import pe.edu.diegosotelocl3.examencl3.service.CarService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    CarRepository carRepository;

    @Override
    public List<CarDto> getAllCars() throws Exception {

        List<CarDto> cars = new ArrayList<CarDto>();
        Iterable<Car> iterable = carRepository.findAll();
        iterable.forEach(car -> {
            CarDto carDto = new CarDto(car.getCar_id(),
                    car.getMake(), car.getModel(), car.getYear(), car.getVin(),
                    car.getLicense_plate(), car.getOwner_name(), car.getOwner_contact(),
                    car.getPurchase_date(), car.getMileage(), car.getEngine_type(), car.getColor(),
                    car.getInsurance_company(), car.getInsurance_policy_number(), car.getRegistration_expiration_date(),
                    car.getService_due_date());
            cars.add(carDto);
        });
        return cars;
    }

    @Override
    public Optional<CarDto> getCarById(int id) throws Exception {

        Optional<Car> optional = carRepository.findById(id);
        return optional.map(car -> new CarDto(car.getCar_id(),
                car.getMake(), car.getModel(), car.getYear(), car.getVin(),
                car.getLicense_plate(), car.getOwner_name(), car.getOwner_contact(),
                car.getPurchase_date(), car.getMileage(), car.getEngine_type(), car.getColor(),
                car.getInsurance_company(), car.getInsurance_policy_number(), car.getRegistration_expiration_date(),
                car.getService_due_date()));
    }

    @Override
    public boolean addCar(CarCreateDto carCreateDto) throws Exception {

        Car car = new Car();
        car.setMake(carCreateDto.make());
        car.setModel(carCreateDto.model());
        car.setYear(carCreateDto.year());
        car.setVin(carCreateDto.vin());
        car.setLicense_plate(carCreateDto.license_plate());
        car.setOwner_name(carCreateDto.owner_name());
        car.setOwner_contact(carCreateDto.owner_contact());
        car.setMileage(carCreateDto.mileage());
        car.setEngine_type(carCreateDto.engine_type());
        car.setColor(carCreateDto.color());
        car.setInsurance_company(carCreateDto.insurance_company());
        car.setInsurance_policy_number(carCreateDto.insurance_policy_number());

        carRepository.save(car);
        return true;
    }

    @Override
    public boolean updateCar(CarDto carDto) throws Exception {

        Optional<Car> optional = carRepository.findById(carDto.car_id());
        return optional.map(car -> {
            car.setMake(carDto.make());
            car.setModel(carDto.model());
            car.setYear(carDto.year());
            car.setVin(carDto.vin());
            car.setLicense_plate(carDto.license_plate());
            car.setOwner_name(carDto.owner_name());
            car.setOwner_contact(carDto.owner_contact());
            car.setPurchase_date(carDto.purchase_date());
            car.setMileage(carDto.mileage());
            car.setEngine_type(carDto.engine_type());
            car.setColor(carDto.color());
            car.setInsurance_company(carDto.insurance_company());
            car.setInsurance_policy_number(carDto.insurance_policy_number());
            car.setRegistration_expiration_date(carDto.registration_expiration_date());
            car.setService_due_date(carDto.service_due_date());
            carRepository.save(car);
            return true;
        }).orElse(false);
    }

    @Override
    public boolean deleteCar(int id) throws Exception {

        Optional<Car> optional = carRepository.findById(id);
        return optional.map(car -> {
            carRepository.delete(car);
            return true;
        }).orElse(false);
    }
}
