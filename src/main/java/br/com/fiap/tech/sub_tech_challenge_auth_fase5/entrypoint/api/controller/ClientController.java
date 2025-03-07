package br.com.fiap.tech.sub_tech_challenge_auth_fase5.entrypoint.api.controller;

import br.com.fiap.tech.sub_tech_challenge_auth_fase5.application.client.entities.ClientEntity;
import br.com.fiap.tech.sub_tech_challenge_auth_fase5.application.client.services.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/client")
@RequiredArgsConstructor
public class ClientController {

    @Value("${auth0.client-id}")
    private String clientId;

    @Value("${auth0.client-secret}")
    private String clientSecret;

    @Value("${auth0.audience}")
    private String audience;

    @Value("${auth0.domain}")
    private String auth0Domain;

    private final ClientService clientService;

    @GetMapping("/{cpf}")
    public ResponseEntity<ClientEntity> getClient(@PathVariable String cpf) {

        return ResponseEntity.ok().body(clientService.buscaClientePorCPF(cpf));
    }

    @PostMapping()
    public ResponseEntity<ClientEntity> registerClient(@RequestBody ClientEntity client) {


        return ResponseEntity.status(HttpStatus.CREATED).body(clientService.registraCliente(client));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody ClientEntity client) {

        Boolean isAuthorized = clientService.login(client.getCpf(), client.getPassword());

        if (!isAuthorized) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Usuário ou senha incorreta");
        }

        RestTemplate restTemplate = new RestTemplate();
        String auth0Url = "https://" + auth0Domain + "/oauth/token";

        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");

        String requestBody = "{"
                + "\"grant_type\":\"client_credentials\","
                + "\"audience\":\"" + audience + "\","
                + "\"client_id\":\"" + clientId + "\","
                + "\"client_secret\":\"" + clientSecret + "\""
                + "}";

        HttpEntity<String> entity = new HttpEntity<>(requestBody, headers);

        ResponseEntity<String> response = restTemplate.exchange(
                auth0Url, HttpMethod.POST, entity, String.class);


        return ResponseEntity.ok().body(response.getBody());
    }

}
