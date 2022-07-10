package dev.unscrud.tdd.service;

public enum Desempenho {
  A_DESEJAR("0.03"),
  BOM("0.15"),
  OTIMO("0.2");

  private String porcentagem;

  Desempenho(String porcentagem) {
    this.porcentagem = porcentagem;
  }

  public String getPorcentagem() {
    return porcentagem;
  }

}
