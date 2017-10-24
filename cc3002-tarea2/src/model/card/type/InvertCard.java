package model.card.type;

import controller.IController;
import model.IGameLogic;

public class InvertCard extends AbstractCard {
  
  public InvertCard(Color color) {
    this.color = color;
    this.symbol = Symbol.INVERT;
  }
  
  @Override
  public void executeAction(IGameLogic game, IController ctrl) {
     //game.playCard(this, ctrl);
     ctrl.showMessage("Se jugó " + this.getColor().toString() + " " + this.getSymbol().toString());
     game.invertDirection();
  }
}
