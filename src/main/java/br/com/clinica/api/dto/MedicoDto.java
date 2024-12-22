package br.com.clinica.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record MedicoDto(@NotNull @NotBlank String nome,@NotNull @NotBlank String sobrenome,@NotNull @NotBlank String especialidade,@NotNull @NotBlank String cpf,@NotNull @NotBlank String crm) {

}
