package by.itacademy.afisha.dao.api;

import by.itacademy.afisha.dao.entity.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface IFilmDao extends JpaRepository<Film, UUID> {

}
