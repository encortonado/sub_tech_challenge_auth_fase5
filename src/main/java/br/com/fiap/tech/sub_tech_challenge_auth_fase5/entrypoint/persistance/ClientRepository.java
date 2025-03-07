package br.com.fiap.tech.sub_tech_challenge_auth_fase5.entrypoint.persistance;

import br.com.fiap.tech.sub_tech_challenge_auth_fase5.application.client.entities.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<ClientEntity, Long> {

    Optional<ClientEntity> findByCpf(String cpf);
}
