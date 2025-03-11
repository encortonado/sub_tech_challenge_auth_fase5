package br.com.fiap.tech.sub_tech_challenge_auth_fase5.entrypoint.api.model;


import br.com.fiap.tech.sub_tech_challenge_auth_fase5.infrastructure.helper.CpfMaskSerializer;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientDTO {

    @JsonSerialize(using = CpfMaskSerializer.class)
    private String cpf;

    @JsonIgnore
    private String password;

}
