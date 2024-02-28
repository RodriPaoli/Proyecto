package com.roshka.Proyecto.controller;

import com.roshka.Proyecto.model.Reserva;
import com.roshka.Proyecto.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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
        Reserva r = new Reserva();
        model.addAttribute("reserva", r);
        return "reservas";
    }

    @GetMapping("/contacto")
    public String contacto(Model model) {
        return "contacto";
    }
    @PostMapping ("/resultado")
//    public String postReservas(@RequestParam("nombre")String nombre,
//                               @RequestParam("apellido") String apellido,
//                               @RequestParam("telefono") Integer telefono,
//                               @RequestParam("fecha") LocalDate fecha,
//                               @RequestParam("horario") LocalTime horario,
//                               @RequestParam("cantidad") Integer cantidad,
//                               @RequestParam("observaciones") String observaciones,
//                               Model m){
        public String postReservas(Reserva r, Model m) {
//        System.out.println(nombre + telefono);
        //Llamar a la base de datos
//        Reserva r = new Reserva();
//        r.setNombre(nombre);
//        r.setApellido(apellido);
//        r.setTelefono(telefono);
//        r.setFecha(fecha);
//        r.setHorario(horario);
//        r.setCantidad(cantidad);
//        r.setObservaciones(observaciones);

        repo.save(r);

        m.addAttribute("m_nombre", r.nombre);
        m.addAttribute("m_apellido", r.apellido);
        m.addAttribute("m_telefono", r.telefono);
        m.addAttribute("m_fechaE", r.fechaE);
        m.addAttribute("m_fechaS", r.fechaS);
        m.addAttribute("m_cantidad", r.cantidad);
        m.addAttribute("m_observaciones", r.observaciones);
        m.addAttribute("m_presupuesto", r.presupuesto);
        return "resultado";


    }
}

