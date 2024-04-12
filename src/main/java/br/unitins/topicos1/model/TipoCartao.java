package br.unitins.topicos1.model;

public enum TipoCartao {
    CREDITO("Crédito"),
    DEBITO("Débito");

    private String label;

    TipoCartao(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
