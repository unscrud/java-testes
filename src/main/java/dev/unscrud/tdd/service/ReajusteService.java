package dev.unscrud.tdd.service;

import java.math.BigDecimal;

import dev.unscrud.tdd.modelo.Funcionario;

public class ReajusteService {
  void concederReajuste(Funcionario funcionario, Desempenho desempenho) {
    BigDecimal reajuste;

    switch (desempenho) {
      case A_DESEJAR:
        reajuste = funcionario.getSalario().multiply(new BigDecimal("0.03"));
        break;
      case BOM:
        reajuste = funcionario.getSalario().multiply(new BigDecimal("0.15"));
        break;
      case OTIMO:
        reajuste = funcionario.getSalario().multiply(new BigDecimal("0.2"));
        break;

      default:
        reajuste = BigDecimal.ZERO;
    }

    funcionario.reajustarSalario(reajuste);
  }
}
