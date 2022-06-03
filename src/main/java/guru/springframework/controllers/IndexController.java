package guru.springframework.controllers;

import guru.springframework.model.Category;
import guru.springframework.model.UnitMeasure;
import guru.springframework.repositories.CategoryRepository;
import guru.springframework.repositories.UnitMeasureRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
public class IndexController {

    private CategoryRepository categoryRepository;
    private UnitMeasureRepository unitMeasureRepository;

    public IndexController(CategoryRepository categoryRepository, UnitMeasureRepository unitMeasureRepository) {
        this.categoryRepository = categoryRepository;
        this.unitMeasureRepository = unitMeasureRepository;   }

    @RequestMapping({"","/","/index"})
    public String getIndexPage(){

        Optional<Category> categoryOptional = categoryRepository.findByDescription("American");
        Optional<UnitMeasure> unitMeasureOptional = unitMeasureRepository.findByDescription("Cup");


        System.out.println("Category Id is : " + categoryOptional.get().getId());
        System.out.println("UOM ID is " + unitMeasureOptional.get().getId());

        return "index";

    }
}
