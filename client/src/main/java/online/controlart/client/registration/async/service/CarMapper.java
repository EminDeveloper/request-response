package online.controlart.client.registration.async.service;

import online.controlart.client.dto.CarDto;
import online.controlart.client.registration.async.persistance.Car;
import org.springframework.stereotype.Component;

@Component
public class CarMapper {

    Car toCar(CarDto carDto) {
        return Car.builder()
                .id(carDto.getId())
                .color(carDto.getColor())
                .name(carDto.getName())
                .build();
    }

    CarDto toCarDto(Car car) {
        return CarDto.builder()
                .id(car.getId())
                .color(car.getColor())
                .name(car.getName())
                .build();
    }
}