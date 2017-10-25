package model.player.type;

import java.util.ArrayList;
import java.util.Random;

import controller.IController;
import model.IGameLogic;
import model.card.type.Color;
import model.card.type.ICard;
import model.card.type.NullCard;

/**
 * Class that implements the constructor associated to the VirtualPlayer
 * 
 * @author Daniela Campos
 */
public class VirtualPlayer extends AbstractPlayer {
  
  /**
   * Constructor of an object of the VirtualPlayer Class
   * 
   * @param name name of the player
   */
  public VirtualPlayer(String name) {
    super(name);
  }
  
  @Override
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
    
    Random randomNum = new Random();
    int rN = randomNum.nextInt(4);
    
    return Color.getColors()[rN];
    
  }
}
