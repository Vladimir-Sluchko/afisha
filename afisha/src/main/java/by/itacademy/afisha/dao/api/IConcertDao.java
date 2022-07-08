package by.itacademy.afisha.dao.api;

import by.itacademy.afisha.dao.entity.Concert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface IConcertDao extends JpaRepository<Concert, UUID> {
}
