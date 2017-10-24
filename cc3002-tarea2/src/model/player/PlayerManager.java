package model.player;

import java.util.ArrayList;

import model.player.type.IPlayer;

public class PlayerManager implements IPlayerManager {
  
  private int currentPlayerIndex;
  private ArrayList<IPlayer> playerList;
  private int nextPlayerIndex;
  private Direction direction;
  
  public PlayerManager(IPlayerListBuilder players) {
    
    playerList = players.buildPlayerList();
    currentPlayerIndex = -1;
    nextPlayerIndex = 0;
    direction = Direction.COUNTERCLOCKWISE;
  }

  @Override
  public IPlayer getCurrentPlayer() {
    
    return playerList.get(currentPlayerIndex);
  }

  @Override
  public ArrayList<IPlayer> getPlayers() {
    
    return playerList;
  }

  @Override
  public void invertDirection() {
    
    if(this.direction.getValue() == 1) {
      this.direction = Direction.CLOCKWISE;
    }
    else {
      this.direction = Direction.COUNTERCLOCKWISE;
    }
  }

  @Override
  public void startTurn() {
    
    this.currentPlayerIndex = this.nextPlayerIndex;
    if(direction.getValue() == -1 && nextPlayerIndex == 0) {
      this.nextPlayerIndex = playerList.size() - 1;
    }
    else {
      this.nextPlayerIndex = (this.nextPlayerIndex + direction.getValue())%(playerList.size());
    }
    
    
  }

  @Override
  public void skipPlayer() {
  
    if(direction.getValue() == -1 && nextPlayerIndex == 0) {
      this.nextPlayerIndex = playerList.size() - 1;
    }
    else {
      this.nextPlayerIndex = (this.nextPlayerIndex + direction.getValue())%(playerList.size());
    }
  }

}
