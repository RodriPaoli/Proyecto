package com.roshka.Proyecto.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Time;
import java.util.Date;

@Controller
public class HomeController {
    class Reserva {
        public String nombre;
        public String telefono;
        public Integer saldo;
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("menuItem", "Rocoto relleno");
        return "home";
    }

    @GetMapping("/reservas")
    public String getReservas() {

        return "reservas";
    }
    @GetMapping("/reservas-raw")
    public @ResponseBody Reserva getReservasRaw() {
        Reserva reserva = new Reserva();
        reserva.nombre = "Duke";
        reserva.telefono = "123";
        reserva.saldo = 50000;
        return reserva;
    }
    @PostMapping ("/reservas")
    public String postReservas(@RequestParam("nombre")String nombre,
                               @RequestParam("apellido") String apellido,
                               @RequestParam("telefono") Integer telefono,
                               @RequestParam("dia") Date dia,
                               @RequestParam("hora") Time hora,
                               @RequestParam("cantidad") Integer cantidad,
                               @RequestParam("observaciones") String observaciones,
                               Model m){
        System.out.println(nombre + telefono);
        //Llamar a la base de datos

        m.addAttribute("m_nombre", nombre);
        m.addAttribute("m_apellido", apellido);
        m.addAttribute("m_telefono", telefono);
        m.addAttribute("m_dia", dia);
        m.addAttribute("m_hora", hora);
        m.addAttribute("m_cantidad", cantidad);
        m.addAttribute("m_observaciones", observaciones);
        return "resultado";
    }
}

