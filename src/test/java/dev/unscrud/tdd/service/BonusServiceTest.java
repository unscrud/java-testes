package dev.unscrud.tdd.service;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dev.unscrud.tdd.modelo.Funcionario;

public class BonusServiceTest {
  private BonusService service;
  private Funcionario funcionario;
  private static int testesExecutados;

  @BeforeEach
  private void contarTestes() {
    testesExecutados += 1;
  }

  @BeforeAll
  private static void mostrarMensagemInicial() {
    System.out.println("Iniciando a execução dos testes.");
  }

  @AfterAll
  private static void mostrarContagem() {
    System.out.println("Foram executados " + testesExecutados + " testes.");
  }

  private void inicializar(String valor) {
    this.service = new BonusService();
    this.funcionario = new Funcionario("Daniel", LocalDate.now(), new BigDecimal(valor));
  }

  @Test
  void bonusDeveriaSerZeroParaFuncionarioComSalarioMuitoAlto() {
    inicializar("25000");
    try {
      service.calcularBonus(funcionario);
      fail("Não lançou a exception.");
    } catch (Exception e) {
      assertEquals("Funcionário com salário maior que R$ 10.000,00 não pode receber bonus.", e.getMessage());
    }

  }

  @Test
  void bonusDeveriaSerDezPorCentoDoSalario() {
    inicializar("2500");
    BigDecimal bonus = service.calcularBonus(funcionario);
    assertEquals(new BigDecimal("250.00"), bonus);
  }

  @Test
  void bonusDeveriaSerDezPorCentoDoSalarioNoLimite() {
    inicializar("10000");
    BigDecimal bonus = service.calcularBonus(funcionario);
    assertEquals(new BigDecimal("1000.00"), bonus);
  }
}
