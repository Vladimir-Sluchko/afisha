package by.itacademy.afisha.dao.api;

import by.itacademy.afisha.dao.entity.Film;
import by.itacademy.afisha.dao.entity.enums.Type;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface IFilmDao extends JpaRepository<Film, UUID> {
    List<Film> findByType(Type type);
    Page<Film> findByType(Type type, Pageable pageable);

}
