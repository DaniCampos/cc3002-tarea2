package model.card.type;

import controller.IController;
import model.IGameLogic;

public class WildCard extends AbstractCard {

  public WildCard() {
    this.symbol = Symbol.WILD;
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
     game.getCurrentPlayer().selectColor(game, ctrl);
     //ctrl.askForColor();  
  }
}
