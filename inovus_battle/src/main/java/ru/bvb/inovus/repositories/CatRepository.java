package ru.bvb.inovus.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.bvb.inovus.models.Cat;

import java.util.List;
import java.util.Optional;

public interface CatRepository extends JpaRepository<Cat, Long> {

}
