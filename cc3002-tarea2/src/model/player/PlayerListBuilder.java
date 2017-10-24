package model.player;

import java.util.ArrayList;

import model.player.type.IPlayer;

public class PlayerListBuilder implements IPlayerListBuilder {
  
  ArrayList<IPlayer> playerList;
  
  public PlayerListBuilder() {
    playerList = new ArrayList<IPlayer>();
  }
 
  @Override
  public void addPlayer(IPlayer player) {
    
    playerList.add(player);
  }

  @Override
  public ArrayList<IPlayer> buildPlayerList() {
    
    ArrayList<IPlayer> players = playerList;
    playerList = new ArrayList<IPlayer>();
    return players;
  }

}
