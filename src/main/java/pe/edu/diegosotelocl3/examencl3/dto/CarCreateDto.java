package pe.edu.diegosotelocl3.examencl3.dto;

public record CarCreateDto(
                           String make,
                           String model,
                           Integer year,
                           String vin,
                           String license_plate,
                           String owner_name,
                           String owner_contact,
                           Integer mileage,
                           String engine_type,
                           String color,
                           String insurance_company,
                           String insurance_policy_number

) {
}
