package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class HomeController {
    @Autowired
    LuxuryRepository luxuryRepository;
    @RequestMapping("/")
    public String listLuxurys(Model model){
        model.addAttribute("luxurys", luxuryRepository.findAll());
        return "list";
    }
    @GetMapping("/add")
    public String luxuryForm(Model model){
       model.addAttribute("luxury", new Luxury());
       return "luxuryform";
    }
    @PostMapping("/process")
    public String processForm(@Valid Luxury luxury,
                              BindingResult result){
        if (result.hasErrors()){
            return "luxuryform";
        }
       luxuryRepository.save(luxury);
        return "redirect:/";
    }

    @RequestMapping("/detail/{id}")
    public String showLuxury(@PathVariable("id") long id, Model model)

    {
        model.addAttribute("luxury", luxuryRepository.findById(id).get());
        return "show";
    }

    @RequestMapping("/update/{id}")
    public String updateLuxury(@PathVariable("id") long id,
                               Model model){
        model.addAttribute("luxury", luxuryRepository.findById(id).get());
        return "luxuryform";
    }

    @RequestMapping("/delete/{id}")
    public String delCourse(@PathVariable("id") long id){
        luxuryRepository.deleteById(id);
        return "redirect:/";

    }
}
