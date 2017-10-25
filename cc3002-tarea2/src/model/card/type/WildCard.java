package model.card.type;

import controller.IController;
import model.IGameLogic;

/**
 * Class that implements the constructor and methods associated to the WildCard, extends Abstract Card
 * 
 * @author Daniela Campos
 */
public class WildCard extends AbstractCard {

  /**
   * Constructor of an object of the WildCard Class
   * 
   * @param color color of the card
   */
  public WildCard() {
    this.symbol = Symbol.WILD;
    this.color = Color.NONE;
  }
  
  @Override
  public String toString() {
    
    return this.getSymbol().toString(); 
  }
  
  @Override
  public boolean isFirstPlayable() {
    
    return false;
  }

  @Override
  public void executeAction(IGameLogic game, IController ctrl) {
    
     ctrl.showMessage("Se jugó" + " " + this.getSymbol().toString());
     this.setColor(game.getCurrentPlayer().selectColor(game, ctrl));
     ctrl.showMessage("Color elegido " + this.getColor().toString());
  }
}
