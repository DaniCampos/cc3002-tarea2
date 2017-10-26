package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import model.card.type.*;

public class AbstractCardTest {

  ICard carta;
  ICard carta2;
  ICard carta3;
  ICard carta4;
  ICard carta5;
  ICard carta6;
  ICard carta7;
  ICard carta8;
  

  @Before
  public void setUp() throws Exception {
    carta = new NumericCard(model.card.type.Color.BLUE, Symbol.FIVE);
    carta2 = new NumericCard(model.card.type.Color.BLUE, Symbol.SIX);
    carta3 = new WildCard();
    carta4 = new WildDrawCard();
    carta5 = new NumericCard(model.card.type.Color.GREEN, Symbol.FIVE);
    carta6 = new DrawTwoCard(model.card.type.Color.BLUE);
    carta7 = new InvertCard(model.card.type.Color.BLUE);
    carta7 = new SkipCard(model.card.type.Color.BLUE);
    carta8 = new NullCard();
  }


  @Test
  public void test() {
    
    assertEquals(carta.toString(), "BLUE FIVE");
    
    boolean jugable = carta.isPlayableOver(carta2);
    assertEquals(jugable, true);
    
    boolean jugable2 = carta3.isPlayableOver(carta2);
    assertEquals(jugable2, true);
    
    boolean jugable3 = carta4.isPlayableOver(carta2);
    assertEquals(jugable3, true);
    
    boolean jugable4 = carta.isPlayableOver(carta5);
    assertEquals(jugable4, true);
    
    assertEquals(carta.isFirstPlayable(), true);
    
    assertEquals(carta.isDiscardable(), true);
    
    assertEquals(carta8.isFirstPlayable(), false);
    
    assertEquals(carta8.isDiscardable(), false);
    
    boolean jugable5 = carta8.isPlayableOver(carta5);
    assertEquals(jugable5, false);
    
    assertEquals(carta3.toString(), "WILD");
    
    assertEquals(carta3.isFirstPlayable(), false);
    assertEquals(carta4.isFirstPlayable(), false);
    
    assertEquals(carta4.toString(), "WILD_DRAW_FOUR");
    
    
    
    
  }
  

}
