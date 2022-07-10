package dev.unscrud.tdd.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dev.unscrud.tdd.modelo.Funcionario;

public class ReajusteServiceTest {
  private ReajusteService service;
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

  @BeforeEach
  private void inicializar() {
    service = new ReajusteService();
    funcionario = new Funcionario("Daniel", LocalDate.now(), new BigDecimal("1000.00"));
  }

  @Test
  void reajusteDeveriaSerDe3PorcentoSeDesempenhoForADesejar() {
    service.concederReajuste(funcionario, Desempenho.A_DESEJAR);
    assertEquals(new BigDecimal("1030.00"), funcionario.getSalario());
  }

  @Test
  void reajusteDeveriaSerDe15PorcentoSeDesempenhoForBom() {
    service.concederReajuste(funcionario, Desempenho.BOM);
    assertEquals(new BigDecimal("1150.00"), funcionario.getSalario());
  }

  @Test
  void reajusteDeveriaSerDe20PorcentoSeDesempenhoForBom() {
    service.concederReajuste(funcionario, Desempenho.OTIMO);
    assertEquals(new BigDecimal("1200.00"), funcionario.getSalario());
  }

}
