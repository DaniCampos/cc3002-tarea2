package model.player.type;

import java.util.ArrayList;

import controller.IController;
import model.IGameLogic;
import model.card.type.Color;
import model.card.type.ICard;

public class VirtualPlayer extends AbstractPlayer {
  
  public VirtualPlayer(String name) {
    super(name);
  }
  
  @Override //puede ser una carta no válida
  public ICard getCardToPlay(IGameLogic game, IController ctrl) {
    if(this.needsToDrawCard(game.getCurrentPlayedCard())) {
      game.drawOneCard(this);
      ICard cartaRobada = this.getCardFromHand(this.getHandSize() - 1);
      ctrl.showMessage(this.toString() + " robo " + cartaRobada.toString());
      return cartaRobada;
    }
    else {
      ArrayList<ICard> cartasValidas = new ArrayList<ICard>();
      for(int i = 0; i < this.getHandSize(); ++i) {
        ICard carta = mano.get(i);
        if(carta.isPlayableOver(game.getCurrentPlayedCard())) {
          cartasValidas.add(carta);
        }
      }
      int randomNum = 0 + (int)(Math.random() * (cartasValidas.size() - 1));
      int num = this.getHand().indexOf(cartasValidas.get(randomNum));
      return this.getCardFromHand(num);
    }
    
  }
  
  @Override
  public Color selectColor(IGameLogic game, IController ctrl) {
    
    int randomNum = 2 + (int)(Math.random() * 5);
    return Color.getColors()[randomNum-1];
    
  }
}
