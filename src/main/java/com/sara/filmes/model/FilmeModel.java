package com.sara.filmes.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TB_FILMES")
public class FilmeModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "título não pode ser nulo")
    private String titulo;

    @Column(length = 1000)
    @NotBlank(message = "sinopse não pode ser nula")
    private String sinopse;

    @NotBlank(message = "gênero não pode ser nulo")
    private String genero;

    @NotNull(message = "ano de lançamento não pode ser nulo")
    @Min(value = 1900)
    @Max(value = 2050)
    private int anoLancamento;

    @JsonIgnore
    @OneToMany(mappedBy = "filme", cascade = CascadeType.REMOVE)
    private List<AnaliseModel> analises;
}
