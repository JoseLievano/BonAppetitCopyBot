package com.copybot.bonappcopybot.model.entity.drinks.wine;

import lombok.*;

import javax.persistence.*;

@Table
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class WineCopy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column
    private String occasion;

    @Column
    private String lang;

    @Column
    private String copy;

    @ManyToOne(cascade = CascadeType.DETACH, optional = false)
    @JoinColumn(name = "wine_id", nullable = false)
    private Wine wine;

}
