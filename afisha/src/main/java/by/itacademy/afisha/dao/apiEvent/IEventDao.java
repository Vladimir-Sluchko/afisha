package by.itacademy.afisha.dao.apiEvent;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface IEventDao<T> extends JpaRepository<T,UUID> {
}
