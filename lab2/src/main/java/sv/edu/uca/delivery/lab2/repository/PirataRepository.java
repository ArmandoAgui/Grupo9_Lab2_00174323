package sv.edu.uca.delivery.lab2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import sv.edu.uca.delivery.lab2.entity.Pirata;

import java.util.UUID;

@Repository
@EnableJpaRepositories

public interface PirataRepository extends JpaRepository<Pirata, UUID> {

}
