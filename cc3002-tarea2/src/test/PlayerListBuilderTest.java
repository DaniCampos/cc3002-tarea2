package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import model.card.type.*;
import model.player.*;
import model.player.type.*;

public class PlayerListBuilderTest {
  
  private IPlayerListBuilder plb;
  private ArrayList<IPlayer> jug;
  private IPlayer player;
  private IPlayerManager plm;
  private ICard carta;
  private ICard carta2;
  private ICard carta3;
  private ArrayList<ICard> mano;
  @Before
  public void setUp() throws Exception {
    
    plb = new PlayerListBuilder();
    player = new VirtualPlayer("juan");
    plb.addPlayer(player);
    carta = new WildCard();
    mano = new ArrayList<ICard>();
    
    carta2 = new SkipCard(model.card.type.Color.BLUE);
    carta3 = new InvertCard(model.card.type.Color.GREEN);
    mano.add(carta2);
    
    
    
  }

  @Test
  public void test() {
    
    jug = plb.buildPlayerList();
    
    assertEquals(jug.contains(player), true);
    
    plb.addPlayer(player);
    
    plm = new PlayerManager(plb);
    
    assertEquals(jug, plm.getPlayers());
    
    plm.startTurn();
    
    assertEquals(plm.getCurrentPlayer(), player);
    
    plm.invertDirection();
    
    plm.skipPlayer();
    
    assertEquals(player.toString(), "juan");
    
    
    player.addToHand(mano);
    
    assertEquals(player.getHandSize(),1);
    
    assertEquals(player.hasOneCard(), true);
    
    assertEquals(player.getHand(), mano);
    
    player.setSaidUNO(true);
    
    assertEquals(player.hasSaidUNO(), true);
    
    assertEquals(player.needsToDrawCard(carta3), true);
    
    assertEquals(player.needsToDrawCard(carta2), false);
    
    assertEquals(player.getCardFromHand(0), carta2);
    
    player.removeCardFromHand(carta2);
    
    assertEquals(player.getHandSize(),0);
    
   
    
  }

}
