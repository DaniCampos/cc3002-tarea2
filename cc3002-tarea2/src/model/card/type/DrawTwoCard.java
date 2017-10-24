package model.card.type;

import controller.IController;
import model.IGameLogic;

public class DrawTwoCard extends AbstractCard {

  public DrawTwoCard(Color color) {
    this.color = color;
    this.symbol = Symbol.DRAW_TWO;
  }
  
  @Override
  public void executeAction(IGameLogic game, IController ctrl) {
     //game.playCard(this, ctrl);
     ctrl.showMessage("Se jugó" + this.getColor().toString() + " " + this.getSymbol().toString());
     game.addToDrawWell(2);  
  }
}
