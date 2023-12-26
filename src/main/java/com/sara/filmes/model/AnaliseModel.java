package com.sara.filmes.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TB_ANALISES")
public class AnaliseModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "filme_id")
    private FilmeModel filme;

    @Column(length = 1000)
    @NotBlank(message = "resenha não pode ser nula")
    private String resenha;

    @Column(length = 1000)
    @NotBlank(message = "titulo não pode ser nulo")
    private String titulo;

    @NotNull(message = "nota não pode ser nula")
    @Min(value = 1, message = "nota deve ser igual ou maior que 1")
    @Max(value = 5, message = "nota deve ser igual ou menor que 5")
    private byte nota;
}
