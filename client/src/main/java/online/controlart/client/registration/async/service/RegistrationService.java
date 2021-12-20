package online.controlart.client.registration.async.service;

import online.controlart.client.dto.CarDto;
import online.controlart.client.dto.RegistrationDto;
import online.controlart.client.registration.async.persistance.Car;
import online.controlart.client.registration.async.persistance.CarRepository;
import online.controlart.client.registration.async.persistance.Registration;
import online.controlart.client.registration.async.persistance.RegistrationRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class RegistrationService {

    private final CarMapper carMapper;
    private final RegistrationMapper registrationMapper;
    private final CarRepository carRepository;
    private final RegistrationRepository registrationRepository;

    public RegistrationService(CarMapper carMapper, RegistrationMapper registrationMapper, CarRepository carRepository, RegistrationRepository registrationRepository) {
        this.carMapper = carMapper;
        this.registrationMapper = registrationMapper;
        this.carRepository = carRepository;
        this.registrationRepository = registrationRepository;
    }

    public void saveCar(CarDto carDto, UUID correlationId) {
        Car car = carMapper.toCar(carDto);
        car.setCorrelationId(correlationId);
        carRepository.save(car);
    }

    public void saveRegistration(UUID correlationId, RegistrationDto registrationDto){
        Registration registration = registrationMapper.toRegistration(registrationDto);
        Car car = carRepository.findByCorrelationId(correlationId);
        registration.setCar(car);
        registrationRepository.save(registration);
    }
}
