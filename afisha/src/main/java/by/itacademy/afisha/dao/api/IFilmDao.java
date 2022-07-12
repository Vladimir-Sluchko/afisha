package by.itacademy.afisha.dao.api;

import by.itacademy.afisha.dao.apiEvent.IEventDao;
import by.itacademy.afisha.dao.entity.Concert;
import by.itacademy.afisha.dao.entity.Film;
import by.itacademy.afisha.dao.entity.enums.Type;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IFilmDao extends IEventDao<Film> {
    List<Film> findByType(Type type);
    Page<Film> findByType(Type type, Pageable pageable);

}
