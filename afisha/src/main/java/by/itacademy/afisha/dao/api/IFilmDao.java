package by.itacademy.afisha.dao.api;

import by.itacademy.afisha.dao.apiEvent.IEventDao;
import by.itacademy.afisha.dao.entity.Film;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
public interface IFilmDao extends IEventDao<Film> {
    //Page<Film> findAll(Pageable pageable);

}
