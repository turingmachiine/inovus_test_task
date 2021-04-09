package ru.bvb.inovus_generator.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.bvb.inovus_generator.models.CarNumber;

@Repository
public interface NumberRepository extends JpaRepository<CarNumber, Long> {

}
