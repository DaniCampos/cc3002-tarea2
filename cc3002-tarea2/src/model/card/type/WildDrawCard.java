package model.card.type;

import controller.IController;
import model.IGameLogic;

public class WildDrawCard extends AbstractCard {

  public WildDrawCard () {
    this.symbol = Symbol.WILD_DRAW_FOUR;
    this.color = Color.NONE;
  }
  
  @Override
  public boolean isFirstPlayable() {
    return false;
  }

  @Override
  public void executeAction(IGameLogic game, IController ctrl) {
     //game.playCard(this, ctrl);
     ctrl.showMessage("Se jugó" + this.getColor().toString() + " " + this.getSymbol().toString());
     game.addToDrawWell(4); 
     game.getCurrentPlayer().selectColor(game, ctrl);
  }
}
