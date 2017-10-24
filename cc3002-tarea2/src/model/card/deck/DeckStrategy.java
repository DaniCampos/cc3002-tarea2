package model.card.deck;

import model.card.ICardPile;
import model.card.CardPile;
import model.card.type.*;

public class DeckStrategy implements IDeckStrategy {
  
  ICardPile mazo;
  
  public DeckStrategy() {
    this.mazo = new CardPile();
  }

  @Override
  public ICardPile createDeck() {
    mazo.pushCards(createColorDeck(Color.RED));
    mazo.pushCards(createColorDeck(Color.YELLOW));
    mazo.pushCards(createColorDeck(Color.GREEN));
    mazo.pushCards(createColorDeck(Color.BLUE));
    
    return mazo;   
  }
  
  ICardPile cartasColor;
  
  public ICardPile createColorDeck(Color color) {
    
    ICard cero = new NumericCard(color, Symbol.ZERO);
    ICard uno = new NumericCard(color, Symbol.ONE);
    ICard dos = new NumericCard(color, Symbol.TWO);
    ICard tres = new NumericCard(color, Symbol.THREE);
    ICard cuatro = new NumericCard(color, Symbol.FOUR);
    ICard cinco = new NumericCard(color, Symbol.FIVE);
    ICard seis = new NumericCard(color, Symbol.SIX);
    ICard siete = new NumericCard(color, Symbol.SEVEN);
    ICard ocho = new NumericCard(color, Symbol.EIGHT);
    ICard nueve = new NumericCard(color, Symbol.NINE);
    ICard skip = new SkipCard(color);
    ICard invert = new InvertCard(color);
    ICard draw_two = new DrawTwoCard(color);
    ICard wild = new WildCard();
    ICard wild_df = new WildDrawCard();
    
    ICardPile cartasColor = new CardPile();
    
    cartasColor.pushCard(cero);
    cartasColor.pushCard(wild);
    cartasColor.pushCard(wild_df);
    
    int n = 2;
    while(n > 0) {
      cartasColor.pushCard(uno);
      cartasColor.pushCard(dos);
      cartasColor.pushCard(tres);
      cartasColor.pushCard(cuatro);
      cartasColor.pushCard(cinco);
      cartasColor.pushCard(seis);
      cartasColor.pushCard(siete);
      cartasColor.pushCard(ocho);
      cartasColor.pushCard(nueve);
      cartasColor.pushCard(skip);
      cartasColor.pushCard(invert);
      cartasColor.pushCard(draw_two);
      --n;
    }
   
    return cartasColor;

  }

}
