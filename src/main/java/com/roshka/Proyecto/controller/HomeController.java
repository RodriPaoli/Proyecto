package com.roshka.Proyecto.controller;

import com.roshka.Proyecto.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.sql.Time;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(Model model) {
        return "home";
    }

    @GetMapping("/reservas")
    public String getReservas() {
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
                               Model m){
        System.out.println(nombre + telefono);
        //Llamar a la base de datos

        m.addAttribute("m_nombre", nombre);
        m.addAttribute("m_apellido", apellido);
        m.addAttribute("m_telefono", telefono);
        m.addAttribute("m_fecha", fecha);
        m.addAttribute("m_horario", horario);
        m.addAttribute("m_cantidad", cantidad);
        m.addAttribute("m_observaciones", observaciones);
        return "resultado";
    }
}

