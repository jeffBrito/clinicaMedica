package br.com.clinica.api.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ClienteDto(@NotNull @NotBlank String nome,@NotNull @NotBlank String sobrenome,@NotNull LocalDate dataNasc,@NotNull @NotBlank String cpf,String telefone,@NotNull @NotBlank String email) {

}
