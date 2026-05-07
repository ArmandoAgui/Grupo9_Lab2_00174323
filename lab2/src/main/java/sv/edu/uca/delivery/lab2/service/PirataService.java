package sv.edu.uca.delivery.lab2.service;

import sv.edu.uca.delivery.lab2.dto.PirataDto;
import sv.edu.uca.delivery.lab2.entity.Pirata;

import java.util.List;
import java.util.UUID;

public interface PirataService {
    List<Pirata> findAll();

    Pirata findById(UUID id);

    void deleteById(UUID id);

    Pirata create(PirataDto data);

    Pirata update(UUID id, PirataDto data);
}
