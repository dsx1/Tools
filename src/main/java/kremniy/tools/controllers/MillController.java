package kremniy.tools.controllers;

import kremniy.tools.dao.MillDAO;
import kremniy.tools.models.Mill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/mill")
public class MillController {

    private final MillDAO millDAO;

    @Autowired
    public MillController(MillDAO millDAO) {
        this.millDAO = millDAO;
    }

    @GetMapping()
    public String index(Model model){
        model.addAttribute("mill", millDAO.index());
        return "mill/index";
    }

    @GetMapping("/new")
    public String newMill(Model model){
        model.addAttribute("mill", new Mill());
        return "mill/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("mill") @Valid Mill mill, BindingResult bindingResult){
        if (bindingResult.hasErrors()) return "mill/new";
        millDAO.save(mill);

        return "redirect:/mill";
    }
}
