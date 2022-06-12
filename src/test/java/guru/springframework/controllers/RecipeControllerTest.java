package guru.springframework.controllers;

import guru.springframework.model.Recipe;
import guru.springframework.services.RecipeService;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import java.util.HashSet;
import java.util.Set;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

public class RecipeControllerTest extends TestCase {


    @Mock
    RecipeService recipeService;

    @Mock
    Model model;

    RecipeController recipeController;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        recipeController = new RecipeController(recipeService);
    }

    @Test
    public void testMockMVC() throws Exception{
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(recipeController).build();
        mockMvc.perform(MockMvcRequestBuilders.get("/recipes"))
                .andExpect(status().isOk())
                .andExpect(view().name("recipes"));

    }

    @Test
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