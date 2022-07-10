package by.itacademy.afisha.dao.api;

import by.itacademy.afisha.dao.apiEvent.IEventDao;
import by.itacademy.afisha.dao.entity.Concert;
import org.springframework.stereotype.Repository;

@Repository
public interface IConcertDao extends IEventDao<Concert> {
}
