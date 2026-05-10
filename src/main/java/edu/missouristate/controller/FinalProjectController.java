package edu.missouristate.controller;

import edu.missouristate.domain.Cats;
import edu.missouristate.service.FinalProjectService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/")
public class FinalProjectController {

    @Autowired
    private FinalProjectService catsService;

    @GetMapping
    public String getIndex(Model model) {
        List<Cats> catsList = catsService.getCats();
        model.addAttribute("catsList", catsList);
        return "index";
    }

    @GetMapping("/AddEditItems")
    public String getAddEditCats(Model model, Integer catId, HttpSession session, @ModelAttribute("message") String message, @ModelAttribute("messageType") String messageType) {
        model.addAttribute("heading", "Add Cat");

        if(catId != null){
            Cats cats = catsService.getCatsById(catId);
            if(cats != null){
                model.addAttribute("heading", "Edit Cat");
                model.addAttribute("cat", cats);
            } else {
                session.setAttribute("message", "Sorry, unable to find a cat with that ID.");
                session.setAttribute("messageType", "danger");
                model.addAttribute("cat", new Cats());
            }
        }
        else {
            // Add mode
            model.addAttribute("heading", "Add Cat");
            model.addAttribute("cat", new Cats());
        }

        return "AddEditItems";

    }


    //Process form
    @PostMapping("/AddEditItems")
    public String postAddEditCats(HttpSession session, Cats cats) {
        try{
            String message = (cats != null && cats.getId() != null) ?
                    "Cat Updated Successfully" : "Cat Added Successfully";

            catsService.saveCats(cats);

            session.setAttribute("message", message);
            session.setAttribute("messageType", "success");

            return "redirect:/";
        } catch(Exception e){
            session.setAttribute("messageType", "danger");
            session.setAttribute("message", "There was an error processing your request. Error = " + e.getMessage());
            return "redirect:/AddEditItems";
        }
    }

    //Delete Cats
    public String getDeleteCats(HttpSession session, Integer catId) {
        try{
            if (catId != null) {
                catsService.deleteCat(catId);
                session.setAttribute("message", "Cat Deleted Successfully");
                session.setAttribute("messageType", "success");
            } else {
                session.setAttribute("message", "Sorry, unable to find a cat with that ID.");
                session.setAttribute("messageType", "danger");
            }
        } catch(Exception e){
            session.setAttribute("messageType", "danger");
            session.setAttribute("message", "There was an error processing your request. Error = " + e.getMessage());
        }
        return "redirect:/";
    }

    //Edit cat
    @GetMapping("/edit/{catId}")
    public String editCat(@PathVariable Integer catId, Model model, HttpSession session) {
        return getAddEditCats(model, catId, session, "", "");
    }
    //Delete cat
    @GetMapping("/delete/{catId}")
    public String deleteCat(@PathVariable Integer catId, HttpSession session) {
        return getDeleteCats(session, catId);
    }

}
