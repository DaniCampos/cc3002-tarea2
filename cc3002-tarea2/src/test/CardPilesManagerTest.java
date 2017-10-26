package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import model.card.CardPilesManager;
import model.card.ICardPile;
import model.card.ICardPilesManager;
import model.card.deck.DeckStrategy;
import model.card.deck.IDeckStrategy;
import model.card.type.*;
import model.player.type.HumanPlayer;
import model.player.type.IPlayer;

public class CardPilesManagerTest {

  private IDeckStrategy deckS;
  private ICardPilesManager cardPM;
  private ICard carta;
  private IPlayer player;
  
  @Before
  public void setUp() throws Exception {
    
    deckS = new DeckStrategy();
    cardPM = new CardPilesManager(deckS);
    carta = new NumericCard(model.card.type.Color.BLUE, Symbol.EIGHT);
    player = new HumanPlayer("juan");
    
    
  }
  
  @Test
  public void testCardPileMaIni() {
    
    assertEquals(cardPM.getDrawableCardsNumber(), 107);
  }
  
  @Test
  public void test() {
    
    cardPM.drawCard();
    assertEquals(cardPM.getDrawableCardsNumber(), 106);
    
    cardPM.drawCards(3);
    assertEquals(cardPM.getDrawableCardsNumber(), 103);
    
    cardPM.discard(carta);
    assertEquals(cardPM.getDrawableCardsNumber(), 104);
    
    cardPM.addCardsToPlayer(player, 2);
    assertEquals(cardPM.getDrawableCardsNumber(), 102);
  }

}
