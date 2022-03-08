package com.copybot.bonappcopybot.model.entity.drinks.wine;

import com.copybot.bonappcopybot.model.entity.ingredients.Ingredients;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Table
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Wine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column
    private String name;

    @Column
    private String brand;

    @Column
    private String product;

    @Column
    private Integer date;

    @Column
    private String color;

    @Column
    private String ingredients;

    @Column
    private String description;

    @OneToMany(mappedBy = "wine", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<WineCopy> wineCopies = new ArrayList<>();

    public void addCopy(WineCopy copy){
        this.wineCopies.add(copy);
    }

    public void removeCopy(WineCopy copy){
        this.wineCopies.remove(copy);
    }

}
