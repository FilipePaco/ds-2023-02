package com.builder;

public class Endereco {
    private String rua;
    private String setor;
    private String cep;
    private String numero;
    private String cidade;
    private String estado;
    private String bloco;
    private String quadra;

    
    private Endereco() {}


    public String getRua() {
        return rua;
    }

    public String getSetor() {
        return setor;
    }

    public String getCep() {
        return cep;
    }

    public String getNumero() {
        return numero;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEstado() {
        return estado;
    }

    public String getBloco() {
        return bloco;
    }

    public String getQuadra() {
        return quadra;
    }

    public static class Builder {
        private Endereco endereco;

        public Builder() {
            endereco = new Endereco();
        }

        public Builder rua(String rua) {
            endereco.rua = rua;
            return this;
        }

        public Builder setor(String setor) {
            endereco.setor = setor;
            return this;
        }

        public Builder cep(String cep) {
            endereco.cep = cep;
            return this;
        }

        public Builder numero(String numero) {
            endereco.numero = numero;
            return this;
        }

        public Builder cidade(String cidade) {
            endereco.cidade = cidade;
            return this;
        }

        public Builder estado(String estado) {
            endereco.estado = estado;
            return this;
        }

        public Builder bloco(String bloco) {
            endereco.bloco = bloco;
            return this;
        }

        public Builder quadra(String quadra) {
            endereco.quadra = quadra;
            return this;
        }

        public Endereco build() {
            return endereco;
        }
    }
}
