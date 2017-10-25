package model.card.type;

import controller.IController;
import model.IGameLogic;

/**
 * Class that implements the constructor and methods associated to the WildDrawCard, extends Abstract Card
 * 
 * @author Daniela Campos
 */
public class WildDrawCard extends AbstractCard {

  /**
   * Constructor of an object of the WildDrawCard Class
   */
  public WildDrawCard () {
    this.symbol = Symbol.WILD_DRAW_FOUR;
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
    
     ctrl.showMessage("Se jugó" + " "+ this.getSymbol().toString());
     game.addToDrawWell(4);     
     this.setColor(game.getCurrentPlayer().selectColor(game, ctrl));
     ctrl.showMessage("Color elegido " + this.getColor().toString());
  }
}
