package model.card.type;

import controller.IController;
import model.IGameLogic;

/**
 * Class that implements the constructor and methods associated to the SkipCard, extends Abstract Card
 * 
 * @author Daniela Campos
 */
public class SkipCard extends AbstractCard {

  /**
   * Constructor of an object of the SkipCard Class
   * 
   * @param color color of the card
   */
  public SkipCard(Color color) {
    this.color = color;
    this.symbol = Symbol.SKIP;
  }
  
  @Override
  public void executeAction(IGameLogic game, IController ctrl) {

    ctrl.showMessage("Se jugó" + this.getColor().toString() + " " + this.getSymbol().toString());
    game.skipPlayer(); 
 }
}
