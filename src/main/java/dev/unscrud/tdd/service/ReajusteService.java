package dev.unscrud.tdd.service;

import java.math.BigDecimal;

import dev.unscrud.tdd.modelo.Funcionario;

public class ReajusteService {
  void concederReajuste(Funcionario funcionario, Desempenho desempenho) {
    BigDecimal reajuste = funcionario.getSalario().multiply(new BigDecimal(desempenho.getPorcentagem()));
    funcionario.reajustarSalario(reajuste);
  }
}
