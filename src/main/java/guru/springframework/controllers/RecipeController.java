package guru.springframework.controllers;

import guru.springframework.services.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RecipeController {

    RecipeService recipeService;

    @RequestMapping("/recipes")
    public String getRecipes(){

        return "recipes";
    }
}
