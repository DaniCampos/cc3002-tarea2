package model.player.type;

import java.util.ArrayList;

import controller.IController;
import model.IGameLogic;
import model.card.type.Color;
import model.card.type.ICard;
import model.card.type.NullCard;

public abstract class AbstractPlayer implements IPlayer {
  
  protected ArrayList<ICard> mano;
  protected boolean shoutStatus;
  
  public AbstractPlayer() {
    
    this.mano = new ArrayList<ICard>();
    this.shoutStatus = false;
    
  }

  @Override
  public void addToHand(ArrayList<ICard> hand) {
    
    mano.addAll(hand);
  }

  @Override
  public boolean hasWon() {
    
    return mano.size() == 0;
  }

  @Override //puede ser una carta no válida
  public ICard getCardToPlay(IGameLogic game, IController ctrl) {
    int num = ctrl.AskForCardFromHand(this);
    return this.getCardFromHand(num);
    /*ICard cartaDesc = game.getCurrentPlayedCard();
    for(int i = 0; i < mano.size(); ++i) {
      ICard carta = mano.get(i);
      if(carta.isPlayableOver(cartaDesc)) {
        return carta; 
      }
    }
    return new NullCard();*/
  }

  @Override
  public Color selectColor(IGameLogic game, IController ctrl) {
    
    Color color = ctrl.askForColor();
    return color;
  }

  @Override
  public int getHandSize() {
    
    return mano.size();
  }

  @Override
  public boolean hasOneCard() {
    
    return getHandSize() == 1;
  }

  @Override
  public ArrayList<ICard> getHand() {
    return mano;
  }

  @Override
  public void setSaidUNO(boolean status) {
    shoutStatus = status;
    
  }

  @Override
  public boolean hasSaidUNO() {
    return shoutStatus;
  }

  @Override
  public void removeCardFromHand(ICard card) {
    
    int indice = mano.indexOf(card);
    mano.remove(indice);
  }

  @Override
  public boolean needsToDrawCard(ICard currentCard) {
    
    for(int i = 0; i < this.getHandSize(); ++i) {
      if(mano.get(i).isPlayableOver(currentCard)) {
        return false;
      }
    }
    return true;
  }

  @Override
  public ICard getCardFromHand(int number) {
    
    if(getHandSize() > number) {
      return mano.get(number);
      
    }
    else {
      return new NullCard();
    }
    
    
    
  }

}
