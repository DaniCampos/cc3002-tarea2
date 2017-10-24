package model.card.type;

import controller.IController;
import model.IGameLogic;

public class NullCard extends AbstractCard {

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
     
     game.drawOneCard(game.getCurrentPlayer());
  }

  @Override
  public boolean isDiscardable() {
    //return this.getColor().getName().equals("Sin Color") & this.getSymbol().getName().equals("Sin Símbolo");
    return false;
  }
}
