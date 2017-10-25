package model.card.type;

import controller.IController;
import model.IGameLogic;

/**
 * Class that implements the constructor and methods associated to the DrawTwoCard, extends Abstract Card
 * 
 * @author Daniela Campos
 */
public class DrawTwoCard extends AbstractCard {
  
  /**
   * Constructor of an object of the DrawTwoCards class
   * 
   * @param color color of the card
   */
  public DrawTwoCard(Color color) {
    this.color = color;
    this.symbol = Symbol.DRAW_TWO;
  }
  
  @Override
  public void executeAction(IGameLogic game, IController ctrl) {
    
     ctrl.showMessage("Se jugó " + this.getColor().toString() + " " + this.getSymbol().toString());
     game.addToDrawWell(2);  
  }
}
