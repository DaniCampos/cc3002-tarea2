package model.card.deck;

import model.card.CardPile;
import model.card.ICardPile;
import model.card.type.ICard;
import model.card.type.NumericCard;
import model.card.type.Symbol;

public class TestinDeckStrategy implements IDeckStrategy {
  
  ICardPile mazo;
  
  /*public TestinDeckStrategy() {
    mazo = new CardPile();
  }*/
  @Override
  public ICardPile createDeck() {
    return new CardPile();
    
  }
  /*
  ICard cero = new NumericCard(color, Symbol.ZERO);
  ICard uno = new NumericCard(color, Symbol.ONE);
  ICard dos = new NumericCard(color, Symbol.TWO);
  ICard tres = new NumericCard(color, Symbol.THREE);
  ICard cuatro = new NumericCard(color, Symbol.FOUR);*/

}
