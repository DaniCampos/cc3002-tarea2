package model.player.type;

import controller.IController;
import model.IGameLogic;
import model.card.type.Color;
import model.card.type.ICard;

public class VirtualPlayer extends AbstractPlayer {
  
  public VirtualPlayer() {
    super();
  }
  
  @Override //puede ser una carta no válida
  public ICard getCardToPlay(IGameLogic game, IController ctrl) {
    int randomNum = 0 + (int)(Math.random() * (this.getHandSize() - 1)); 
    return this.getCardFromHand(randomNum);
  }
  
  @Override
  public Color selectColor(IGameLogic game, IController ctrl) {
    
    int randomNum = 2 + (int)(Math.random() * 5);
    return Color.getColors()[randomNum];
    
  }
}
