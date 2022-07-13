package by.itacademy.afisha.dao.api;

import by.itacademy.afisha.dao.entity.Concert;
import by.itacademy.afisha.dao.entity.enums.Type;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface IConcertDao extends JpaRepository<Concert, UUID> {
    List<Concert> findByType(Type type);
    Page<Concert> findByType(Type type, Pageable pageable);
}
