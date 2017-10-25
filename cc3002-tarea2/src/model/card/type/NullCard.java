package model.card.type;

import controller.IController;
import model.IGameLogic;

/**
 * Class that implements the constructor and methods associated to the NullCard, extends Abstract Card
 * 
 * @author Daniela Campos
 */
public class NullCard extends AbstractCard {

  /**
   * Constructor of an object of the NullCard Class
   */
  public NullCard() {
    this.color = Color.NONE;
    this.symbol = Symbol.NONE;
  }
  
  @Override
  public boolean isPlayableOver(ICard otherCard) {
    
     return false;
  }
  
  @Override
  public boolean isFirstPlayable() {
    
    return false;
  }

  @Override
  public void executeAction(IGameLogic game, IController ctrl) {
    
    ICard cartaRobada = game.drawOneCard(game.getCurrentPlayer());
    if(cartaRobada.isPlayableOver(game.getCurrentPlayedCard())) {
      cartaRobada.executeAction(game, ctrl);
    }
  }

  @Override
  public boolean isDiscardable() {

    return false;
  }
}
