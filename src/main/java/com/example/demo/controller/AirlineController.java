package com.example.demo.controller;

import com.example.demo.entities.Airline;
import com.example.demo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@RestController
public class AirlineController {
    @Autowired
    private AirlineRepository airlineRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private FilghtRepository filghtRepository;

    @Autowired
    private RefClassRepository refClassRepository;

    @Autowired
    private RefPayMentMethodsRepository refPayMentMethodsRepository;

    @Autowired
    private RefReservationStatusRepository refReservationStatusRepository;

    @Autowired
    private ReservationRepository reservationRepository;

    @RequestMapping(value = "airline/create", method = RequestMethod.GET)
    public String create(Model model) {
        model.addAttribute("airline", new Airline());
        return "form";
    }

    @RequestMapping(value = "airline/save", method = RequestMethod.POST)
    public String save(@Valid Airline airline, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "form";
        }
        airlineRepository.save(airline);
        return "redirect:/list";
    }

    @RequestMapping(value = "airline/list", method = RequestMethod.GET)
    public String getList(Model model) {
        model.addAttribute("airlines", airlineRepository.findAll());
        return "list";
    }

    @GetMapping("/airline/edit/{id}")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("airline", airlineRepository.findById(id));
        return "form";
    }

    @GetMapping("/airline/delete/{id}")
    public String delete(@PathVariable int id, RedirectAttributes redirect) {
        airlineRepository.deleteById(id);
        redirect.addFlashAttribute("success", "Deleted successfully ! ");
        return "redirect:/success";
    }

}
