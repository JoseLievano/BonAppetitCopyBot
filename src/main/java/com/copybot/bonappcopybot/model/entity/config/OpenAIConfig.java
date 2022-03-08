package com.copybot.bonappcopybot.model.entity.config;

import lombok.*;

import javax.persistence.*;

@Table
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OpenAIConfig {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column
    private String APIKEY;

}
