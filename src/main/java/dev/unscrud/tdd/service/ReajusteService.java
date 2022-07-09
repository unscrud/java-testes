package dev.unscrud.tdd.service;

import java.math.BigDecimal;

import dev.unscrud.tdd.modelo.Funcionario;

public class ReajusteService {
  void concederReajuste(Funcionario funcionario, Desempenho desempenho) {
    if (Desempenho.A_DESEJAR.equals(desempenho)) {
      BigDecimal reajuste = funcionario.getSalario().multiply(new BigDecimal("0.03"));
      funcionario.reajustarSalario(reajuste);
    }
  }
}
