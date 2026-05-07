package sv.edu.uca.delivery.lab2.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import sv.edu.uca.delivery.lab2.dto.PirataDto;
import sv.edu.uca.delivery.lab2.entity.Pirata;
import sv.edu.uca.delivery.lab2.repository.PirataRepository;
import sv.edu.uca.delivery.lab2.service.PirataService;

import java.util.List;
import java.util.UUID;

@Service
public class PirataServicesImpl  implements PirataService {

    private PirataRepository pirataRepository;

    public PirataServicesImpl(PirataRepository pirataRepository){
        this.pirataRepository = pirataRepository;
    }

    @Override
    public List<Pirata> findAll() {
        return pirataRepository.findAll();
    }

    @Override
    public Pirata findById(UUID id) {
        return pirataRepository.findById(id).orElse( null);
    }

    @Override
    public void deleteById(UUID id) {
        pirataRepository.deleteById(id);
    }

    @Override
    public Pirata create(PirataDto data) {
        Pirata pirata = new Pirata();
        pirata.setName(data.getName());
        pirata.setCrew(data.getCrew());
        pirata.setBounty(data.getBounty());
        pirata.setIsActive(data.getIsActive());

        return pirataRepository.save(pirata);
    }

    @Override
    public Pirata update(UUID id, PirataDto data) {
        var pirata = pirataRepository.findById(id).orElse(null);

        if (pirata == null) return null;
        pirata.setName(data.getName());
        pirata.setCrew(data.getCrew());
        pirata.setBounty(data.getBounty());
        pirata.setIsActive(data.getIsActive());
        return pirataRepository.save(pirata);
    }
}
