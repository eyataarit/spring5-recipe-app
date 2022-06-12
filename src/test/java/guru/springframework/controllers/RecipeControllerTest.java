package guru.springframework.controllers;

import guru.springframework.model.Recipe;
import guru.springframework.services.RecipeServiceImpl;
import junit.framework.TestCase;
import org.junit.Before;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import java.util.HashSet;
import java.util.Set;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

public class RecipeControllerTest extends TestCase {


    @Mock
    RecipeServiceImpl recipeService;

    @Mock
    Model model;

    RecipeController recipeController;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        recipeController = new RecipeController(recipeService);
    }

    public void testGetRecipes() throws Exception{
        //given
        Set<Recipe> recipes = new HashSet<>();

        recipes.add(new Recipe());
        recipes.add(new Recipe());

        when(recipeService.getRecipes()).thenReturn(recipes);
        ArgumentCaptor< Set<Recipe> > argumentCaptor = ArgumentCaptor.forClass(Set.class);
        //when
        String viewName = recipeController.getRecipes(model);

        //then
        assertEquals("recipes",viewName);
        verify(recipeService,times(1)).getRecipes();

        //verify(model,times(1)).addAttribute(eq("recipes"),anySet());
        //same thing but using argumentCaptor, to specify which Set not AnySet
        verify(model,times(1)).addAttribute(eq("recipes"),argumentCaptor.capture());
        //"Verify that addAttribute has been called on model once(1) with the attribute name "recipes"
        // and value Set<Recipe> - note argumentCaptor.capture() in the verify statement above is returning Set<Recipe>"

        Set<Recipe> setInController = argumentCaptor.getValue();
        assertEquals(2,setInController.size());
    }
}