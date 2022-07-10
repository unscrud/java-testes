package dev.unscrud.tdd.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import dev.unscrud.tdd.modelo.Funcionario;

public class ReajusteServiceTest {
  @Test
  void reajusteDeveriaSerDe3PorcentoSeDesempenhoForADesejar() {
    ReajusteService service = new ReajusteService();
    Funcionario funcionario = new Funcionario("Daniel", LocalDate.now(), new BigDecimal("1000.00"));
    service.concederReajuste(funcionario, Desempenho.A_DESEJAR);

    assertEquals(new BigDecimal("1030.00"), funcionario.getSalario());
  }

  @Test
  void reajusteDeveriaSerDe15PorcentoSeDesempenhoForBom() {
    ReajusteService service = new ReajusteService();
    Funcionario funcionario = new Funcionario("Daniel", LocalDate.now(), new BigDecimal("1000.00"));
    service.concederReajuste(funcionario, Desempenho.BOM);

    assertEquals(new BigDecimal("1150.00"), funcionario.getSalario());
  }

}
