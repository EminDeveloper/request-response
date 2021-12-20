package online.controlart.client.registration.async.service;

import online.controlart.client.dto.RegistrationDto;
import online.controlart.client.registration.async.persistance.Registration;
import org.springframework.stereotype.Component;

@Component
public class RegistrationMapper {

    Registration toRegistration(RegistrationDto registrationDto){
        return Registration.builder()
                .id(registrationDto.getId())
                .date(registrationDto.getDate())
                .owner(registrationDto.getOwner())
                .signature(registrationDto.getSignature())
                .build();
    }
}
