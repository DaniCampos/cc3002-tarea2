package model.card.type;

/**
 * Class that implements the constructor associated to the NumericCard, extends Abstract Card
 * 
 * @author Daniela Campos
 */
public class NumericCard extends AbstractCard {
  
  /**
   * Constructor of an object of the NumericCard Class
   * 
   * @param color color of the card
   * @param symbol symbol of the card
   */
  public NumericCard(Color color, Symbol symbol) {
    this.color = color;
    this.symbol = symbol;
  }
  
}
