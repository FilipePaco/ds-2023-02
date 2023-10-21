package com.builder;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class EnderecoTest {
    @Test
    public void testBuilder() {
        Endereco endereco = new Endereco.Builder()
            .rua("Rua A")
            .setor("Setor 1")
            .cep("12345-678")
            .numero("123")
            .cidade("Cidade X")
            .estado("Estado Y")
            .bloco("Bloco Z")
            .quadra("Quadra 123")
            .build();

        assertEquals("Rua A", endereco.getRua());
        assertEquals("Setor 1", endereco.getSetor());
        assertEquals("12345-678", endereco.getCep());
        assertEquals("123", endereco.getNumero());
        assertEquals("Cidade X", endereco.getCidade());
        assertEquals("Estado Y", endereco.getEstado());
        assertEquals("Bloco Z", endereco.getBloco());
        assertEquals("Quadra 123", endereco.getQuadra());
    }
}
