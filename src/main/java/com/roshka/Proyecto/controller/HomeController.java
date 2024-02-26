package com.roshka.Proyecto.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
                               @RequestParam("telefono") String telefono,
                               Model m){
        System.out.println(nombre + telefono);
        //Llamar a la base de datos

        m.addAttribute("m_nombre", nombre);
        m.addAttribute("m_telefono", telefono);
        return "resultado";
    }

}
