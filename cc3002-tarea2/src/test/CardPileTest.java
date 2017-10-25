package test;

import static org.junit.Assert.*;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import model.card.*;
import model.card.type.*;

public class CardPileTest {

  /*@BeforeClass
  public static void setUpBeforeClass() throws Exception {}

  @AfterClass
  public static void tearDownAfterClass() throws Exception {}*/
  private ICard carta1;
  private ICard carta2;
  private ICard carta3;
  private ICardPile pilaCartas;

  @Before
  public void setUp() throws Exception {
    carta1 = new NumericCard(model.card.type.Color.BLUE, Symbol.ZERO);
    carta2 = new NumericCard(model.card.type.Color.BLUE, Symbol.ONE);
    carta3 = new NumericCard(model.card.type.Color.BLUE, Symbol.TWO);
    pilaCartas = new CardPile();
  }

  @Test
  public void testCardPileIni() {

    assertNotNull(pilaCartas);
    assertEquals(pilaCartas.getSize(), 0);
  }

  /*@Test
  public void test() {
    fail("Not yet implemented");
  }*/

}
