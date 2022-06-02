package guru.springframework.model;

import javax.persistence.*;

@Entity
public class Notes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private  Recipe recipe;

    // Lob is for large objects, either it's binary (CLOB) or character (CLOB)
    @Lob
    private String recipeNotes;

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    public Long getId() {
        return id;
    }
}
