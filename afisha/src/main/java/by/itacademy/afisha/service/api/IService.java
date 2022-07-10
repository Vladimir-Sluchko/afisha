package by.itacademy.afisha.service.api;

import java.util.UUID;

public interface IService<F,D,T> {
    D create (D eventFilm);
    T get (UUID uuid);
}
