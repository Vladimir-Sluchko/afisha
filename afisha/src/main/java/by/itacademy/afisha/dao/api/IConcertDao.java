package by.itacademy.afisha.dao.api;

import by.itacademy.afisha.dao.entity.Concert;
import org.springframework.data.jpa.repository.JpaRepository;

import java.lang.reflect.Field;
import java.util.UUID;

public interface IConcertDao extends JpaRepository<Concert, UUID> {
}
