package model.card.deck;

import model.card.ICardPile;
import model.card.CardPile;
import model.card.type.*;


/**
 * Class that implements the constructor and methods of the IDeckStrategy interface.
 * 
 * @author Daniela Campos
 */
public class DeckStrategy implements IDeckStrategy {
  
  ICardPile mazo;
  ICardPile cartasColor;
  
  /**
   * Constructor of an object of the DeckStrategy Class
   */
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
  
  /**
   * Creates a UNO deck corresponding to a color including uncolored cards.
   * @return a collection of UNO Cards
   */
  public ICardPile createColorDeck(Color color) {
    
    
    ICard skip = new SkipCard(color);
    ICard invert = new InvertCard(color);
    ICard draw_two = new DrawTwoCard(color);
    ICard wild = new WildCard();
    ICard wild_df = new WildDrawCard();
    
    ICardPile cartasColor = numericDeck(color);
    
    cartasColor.pushCard(wild);
    cartasColor.pushCard(wild_df);
    
    int n = 2;
    while(n > 0) {

      cartasColor.pushCard(skip);
      cartasColor.pushCard(invert);
      cartasColor.pushCard(draw_two);
      --n;
    }
   
    return cartasColor;

  }
  
  /**
   * Creates a UNO Numeric deck corresponding to a color including uncolored cards.
   * @return a collection of UNO Cards
   */
  public ICardPile numericDeck(Color color) {
    
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
    
    ICardPile cartasColor = new CardPile();
    
    cartasColor.pushCard(cero);
    
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
      --n;
    }
   
    return cartasColor;
  }
  
  

}
