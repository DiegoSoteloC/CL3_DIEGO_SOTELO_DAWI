package pe.edu.diegosotelocl3.examencl3.dto;

import java.time.LocalDate;

public record CarDto(Integer car_id,
                     String make,
                     String model,
                     Integer year,
                     String vin,
                     String license_plate,
                     String owner_name,
                     String owner_contact,
                     LocalDate purchase_date,
                     Integer mileage,
                     String engine_type,
                     String color,
                     String insurance_company,
                     String insurance_policy_number,
                     LocalDate registration_expiration_date,
                     LocalDate service_due_date
) {
}
