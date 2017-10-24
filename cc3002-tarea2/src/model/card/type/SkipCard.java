package model.card.type;

import controller.IController;
import model.IGameLogic;

public class SkipCard extends AbstractCard {

  public SkipCard(Color color) {
    this.color = color;
    this.symbol = Symbol.SKIP;
  }
  
  @Override
  public void executeAction(IGameLogic game, IController ctrl) {
    //game.playCard(this, ctrl);
    ctrl.showMessage("Se jugó" + this.getColor().toString() + " " + this.getSymbol().toString());
    game.skipPlayer(); 
 }
}
