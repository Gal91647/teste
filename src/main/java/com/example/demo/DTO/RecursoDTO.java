package com.example.demo.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RecursoDTO {

        @JsonProperty(access = JsonProperty.Access.READ_ONLY)
        private Long id;

        @NotNull(message = "O nome deve ser preenchido")
        private String nome;


}
