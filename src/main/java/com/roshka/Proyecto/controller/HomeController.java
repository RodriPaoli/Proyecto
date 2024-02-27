package com.roshka.Proyecto.controller;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.roshka.Proyecto.model.Reserva;
import com.roshka.Proyecto.repository.ReservaRepository;

@Controller
public class HomeController {

    @Autowired
    ReservaRepository repo;

    @GetMapping("/")
    public String home(Model model) {
        return "home";
    }

    @GetMapping("/reservas")
    public String getReservas(Model model) {
        Optional<Reserva> optReserva = repo.findById(Integer.valueOf(1));
        if(optReserva.isPresent()){
            model.addAttribute("reserva", optReserva.get());
        }
        return "reservas";
    }

    @PostMapping ("/resultado")
    public String postReservas(@RequestParam("nombre")String nombre,
                               @RequestParam("apellido") String apellido,
                               @RequestParam("telefono") Integer telefono,
                               @RequestParam("fecha") LocalDate fecha,
                               @RequestParam("horario") LocalTime horario,
                               @RequestParam("cantidad") Integer cantidad,
                               @RequestParam("observaciones") String observaciones,
                               Model m) {
        System.out.println(nombre + telefono);
        // Validar los parametros recibidos
        //Llamar a la base de datos
        Reserva r = new Reserva();
        r.setNombre(nombre);
        r.setApellido(apellido);
        r.setTelefono(telefono);
        //...
        Reserva reservaGuardada = repo.save(r);

        // retornar a la pagina los datos via el model
        m.addAttribute("m_nombre", reservaGuardada.getNombre());
        m.addAttribute("m_apellido", apellido);
        m.addAttribute("m_telefono", telefono);
        m.addAttribute("m_fecha", fecha);
        m.addAttribute("m_horario", horario);
        m.addAttribute("m_cantidad", cantidad);
        m.addAttribute("m_observaciones", observaciones);
        return "resultado";
    }
}

