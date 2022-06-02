package guru.springframework.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    @ManyToMany
    @JoinTable(name = "recipie_category",
                joinColumns = @JoinColumn(name = "recipe_id"),
                inverseJoinColumns = @JoinColumn(name = "category_id"))
    private Set<Recipe> recipies;

    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}
    public Set<Recipe> getRecipies() {return recipies;}
    public void setRecipies(Set<Recipe> recipies) {this.recipies = recipies;}
}
