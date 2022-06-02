package guru.springframework.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private  String description;
    private BigDecimal amount;

    // if you don't make cascade : you can freely delete, it won't affect
    @ManyToOne
    private Recipe recipe;

    // loaded every time , by default , but just to show you how
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private UnitMeasure uom;

    public void setId(Long id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }
    public Long getId() {return id;}
    public String getDescription() {
        return description;
    }
    public BigDecimal getAmount() {
        return amount;
    }
    public Recipe getRecipe() {
        return recipe;
    }
    public UnitMeasure getUom() {
        return uom;
    }
    public void setUom(UnitMeasure uom) {
        this.uom = uom;
    }
}
