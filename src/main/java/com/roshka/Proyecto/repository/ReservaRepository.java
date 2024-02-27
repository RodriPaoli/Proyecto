package com.roshka.Proyecto.repository;

import com.roshka.Proyecto.model.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalTime;


@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Integer> {
    @Override
    Reserva getById(Integer integer);

    @Override
    Reserva getReferenceById(Integer integer);
}