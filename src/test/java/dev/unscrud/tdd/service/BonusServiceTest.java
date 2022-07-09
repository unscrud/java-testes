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
    BigDecimal bonus = service.calcularBonus(new Funcionario("Daniel", LocalDate.now(), new BigDecimal("25000")));
    assertEquals(new BigDecimal("0.00"), bonus);
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
