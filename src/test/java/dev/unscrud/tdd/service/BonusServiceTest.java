package dev.unscrud.tdd.service;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import dev.unscrud.tdd.modelo.Funcionario;

public class BonusServiceTest {

  @Test
  void bonusDeveriaSerZeroParaFuncionarioComSalarioMuitoAlto() {
    BonusService service = new BonusService();

    try {
      service.calcularBonus(new Funcionario("Daniel", LocalDate.now(), new BigDecimal("25000")));
      fail("Não lançou a exception.");
    } catch (Exception e) {
      assertEquals("Funcionário com salário maior que R$ 10.000,00 não pode receber bonus.", e.getMessage());
    }

  }

  @Test
  void bonusDeveriaSerDezPorCentoDoSalario() {
    BonusService service = new BonusService();
    BigDecimal bonus = service.calcularBonus(new Funcionario("Daniel", LocalDate.now(), new BigDecimal("2500")));
    assertEquals(new BigDecimal("250.00"), bonus);
  }

  @Test
  void bonusDeveriaSerDezPorCentoDoSalarioNoLimite() {
    BonusService service = new BonusService();
    BigDecimal bonus = service.calcularBonus(new Funcionario("Daniel", LocalDate.now(), new BigDecimal("10000")));
    assertEquals(new BigDecimal("1000.00"), bonus);
  }
}
