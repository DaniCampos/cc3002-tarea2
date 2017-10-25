package model.card.type;

import controller.IController;
import model.IGameLogic;

/**
 * Class that implements the constructor and methods associated to the DrawTwoCard, extends Abstract Card
 * 
 * @author Daniela Campos
 */
public class InvertCard extends AbstractCard {
  
  /**
   * Constructor of an object of the InvertCard Class
   * 
   * @param color color of the card
   */
  public InvertCard(Color color) {
    
    this.color = color;
    this.symbol = Symbol.INVERT;
  }
  
  @Override
  public void executeAction(IGameLogic game, IController ctrl) {

     ctrl.showMessage("Se jugó " + this.getColor().toString() + " " + this.getSymbol().toString());
     game.invertDirection();
  }
}
