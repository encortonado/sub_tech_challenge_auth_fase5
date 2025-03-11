package br.com.fiap.tech.sub_tech_challenge_auth_fase5.application.client.ports;

import br.com.fiap.tech.sub_tech_challenge_auth_fase5.application.client.entities.ClientEntity;
import br.com.fiap.tech.sub_tech_challenge_auth_fase5.entrypoint.api.model.ClientDTO;

public interface IClientService {

    ClientDTO registraCliente(ClientEntity clienteDTO);

    ClientEntity buscaClientePorCPF(String cpf);

    Boolean login(String cpf, String senha);

}
