package by.itacademy.afisha.dao.api;

import by.itacademy.afisha.dao.apiEvent.IEventDao;
import by.itacademy.afisha.dao.entity.Film;
import org.springframework.stereotype.Repository;

@Repository
public interface IFilmDao extends IEventDao<Film> {

}
