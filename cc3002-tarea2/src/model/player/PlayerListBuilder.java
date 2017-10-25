package model.player;

import java.util.ArrayList;

import model.player.type.IPlayer;

/**
 * Class that implements the constructor and methods of the IPlayerListBuilder interface.
 * 
 * @author Daniela Campos
 */
public class PlayerListBuilder implements IPlayerListBuilder {
  
  ArrayList<IPlayer> playerList;
  
  /**
   * Constructor of an object of the PlayerListBuilderCard Class
   */
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
