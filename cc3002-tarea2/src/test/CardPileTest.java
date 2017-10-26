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
    assertEquals(pilaCartas.isEmpty(), true);
  }

  @Test
  public void test() {
    
    pilaCartas.pushCard(carta1);
    assertEquals(pilaCartas.getSize(), 1);
    
    ICard peekCata = pilaCartas.peekCard();
    assertEquals(peekCata, carta1);
    
    pilaCartas.popCard();
    assertEquals(pilaCartas.isEmpty(), true);

    ICardPile pila1 = new CardPile();
    pila1.pushCard(carta1);
    pila1.pushCard(carta2);
    pila1.pushCard(carta3);
    
    ICardPile pila2 = new CardPile();
    pila2.pushCard(carta2);
    pila2.pushCard(carta3);
    
    pilaCartas.pushCard(carta1);
    
    pilaCartas.pushCards(pila2);
    
    pilaCartas.shuffle();
    
    //assertEquals(pilaCartas, pila2);
    
    
  }

}
