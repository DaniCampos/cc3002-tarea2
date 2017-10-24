package model;

import java.util.ArrayList;

import controller.IController;
import model.card.*;
import model.card.deck.IDeckStrategy;
import model.card.type.ICard;
import model.card.type.NullCard;
import model.player.*;
import model.player.type.IPlayer;

public class GameLogic implements IGameLogic {
  
  private ICardPilesManager cardsManager;
  private IPlayerManager playerManager;
  private ArrayList<ICard> drawWell;
  
  public GameLogic(IDeckStrategy deckStrategy, IPlayerListBuilder playerListBuilder) {
    
    cardsManager = new CardPilesManager(deckStrategy);
    playerManager = new PlayerManager(playerListBuilder);
    drawWell = new ArrayList<ICard>();
    
    for(IPlayer player : playerManager.getPlayers()) {
      
      ArrayList<ICard> mano = this.cardsManager.drawCards(7);
      player.addToHand(mano);
    }
    
  }
  @Override
  public boolean hasEnded() {
    for(IPlayer player : playerManager.getPlayers()) {
      if(player.hasWon()) return true;
    }
    return false;
  }

  @Override
  public IPlayer getCurrentPlayer() {
    return playerManager.getCurrentPlayer();
  }

  @Override
  public ICard getCurrentPlayedCard() {
    
    return cardsManager.getCurrentPlayedCard();
  }

  @Override
  public void autoShoutUNO(IController ctrl) {
    
    if(getCurrentPlayer().hasSaidUNO()) {
      ctrl.showMessage("UNO!");
    }
    
  }

  @Override
  public void startTurn(IController ctrl) {
    playerManager.startTurn();
    if(!isDrawWellEmpty()) {
      //ctrl.playTurn();
      this.drawCardsFromWell(getCurrentPlayer(), ctrl);
    }

    this.autoShoutUNO(ctrl);
    
  }

  @Override
  public void skipPlayer() {
    
    this.playerManager.skipPlayer();
  }

  @Override
  public void addToDrawWell(int number) {
    drawWell.addAll(this.cardsManager.drawCards(number));
  }

  @Override
  public void resetDrawWell() {
    
    drawWell = new ArrayList<ICard>();
  }

  @Override
  public boolean isDrawWellEmpty() {
    
    return this.drawWell.size() == 0;
  }

  @Override
  public void drawCardsFromWell(IPlayer player, IController ctrl) {
    
    player.addToHand(drawWell);
    this.resetDrawWell();
    ctrl.showMessage("Jugador robo cartas"); 
    
  } 

  @Override
  public void invertDirection() {
    this.playerManager.invertDirection();  
  }

  @Override
  public boolean playCard(ICard playedCard, IController ctrl) {
    
    
    boolean playable = playedCard.isPlayableOver(this.cardsManager.getCurrentPlayedCard());
    if(playable) {
      playedCard.executeAction(this, ctrl);
      this.cardsManager.discard(playedCard);
      return true;
    }
    else {
      ICard nullCard = new NullCard();
      nullCard.executeAction(this, ctrl);
      return false;
    }
    
  }

  @Override
  public ICard drawOneCard(IPlayer player) {
    ArrayList<ICard> agregar = new ArrayList<ICard>();
    ICard drawedCard = this.cardsManager.drawCard();
    agregar.add(drawedCard);
    player.addToHand(agregar);
    return drawedCard;
  }

  @Override
  public void announceWinner(IController ctrl) {
    
    if(this.getCurrentPlayer().hasWon()) {
      ctrl.showMessage("Jugador actual gano");
    }
    
  }

}
