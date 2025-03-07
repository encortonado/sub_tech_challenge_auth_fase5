package br.com.fiap.tech.sub_tech_challenge_auth_fase5.application.client.services;

import br.com.fiap.tech.sub_tech_challenge_auth_fase5.application.client.entities.ClientEntity;
import br.com.fiap.tech.sub_tech_challenge_auth_fase5.application.client.ports.IClientService;
import br.com.fiap.tech.sub_tech_challenge_auth_fase5.entrypoint.persistance.ClientRepository;
import br.com.fiap.tech.sub_tech_challenge_auth_fase5.infrastructure.exceptions.CustomErrorTypeException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClientService implements IClientService {

    private final ClientRepository clientRepository;

    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public ClientEntity registraCliente(ClientEntity clienteDTO) {
        ClientEntity clientToSave = new ClientEntity();

        clientToSave.setCpf(clienteDTO.getCpf());
        clientToSave.setPassword(passwordEncoder.encode(clienteDTO.getPassword()));

        return clientRepository.save(clientToSave);
    }

    @Override
    public ClientEntity buscaClientePorCPF(String cpf) {
        return clientRepository.findByCpf(cpf).orElseThrow(
                () -> new CustomErrorTypeException("Cliente nao encontrado com esse CPF."));
    }

    @Override
    public Boolean login(String cpf, String senha) {
        ClientEntity clientEntity = buscaClientePorCPF(cpf);

        return passwordEncoder.matches(senha, clientEntity.getPassword());
    }
}
