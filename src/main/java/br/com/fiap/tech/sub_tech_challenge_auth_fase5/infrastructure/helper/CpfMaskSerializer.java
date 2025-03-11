package br.com.fiap.tech.sub_tech_challenge_auth_fase5.infrastructure.helper;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

public class CpfMaskSerializer extends JsonSerializer<String> {

    @Override
    public void serialize(String cpf, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        if (cpf != null && cpf.length() == 11) {
            String maskedCpf = "***.***.***-" + cpf.substring(9);
            gen.writeString(maskedCpf);
        } else {
            gen.writeString(cpf);
        }
    }
}