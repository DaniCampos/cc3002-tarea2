import controller.ConsoleController;
import model.GameLogic;
import model.IGameLogic;
import model.card.deck.DeckStrategy;
import model.card.deck.IDeckStrategy;
import model.player.*;
import model.player.type.*;
import view.ConsoleView;

/**
 * Main class of UNO Game
 * 
 * It instantiates model, view and controller and makes the turn loop
 * while the game hasn't ended.
 * @author eriveros
 *
 */
public class Main {

  public static void main(String[] args) {
    IPlayerListBuilder playerBuilder;
    IPlayer jugador1 = new HumanPlayer();
    IPlayer jugador2 = new VirtualPlayer();
    IPlayer jugador3 = new VirtualPlayer();
    playerBuilder = new PlayerListBuilder();
    playerBuilder.addPlayer(jugador1);
    playerBuilder.addPlayer(jugador2);
    playerBuilder.addPlayer(jugador3);
    
    IDeckStrategy deckStrategy = new DeckStrategy();

    //IGameLogic game = null;
    IGameLogic game = new GameLogic(deckStrategy, playerBuilder);
    ConsoleView view = new ConsoleView(game);
    ConsoleController ctrl = new ConsoleController(game, view);
    
    while (!game.hasEnded()) {
      ctrl.playTurn();
    }
    game.announceWinner(ctrl);
  }
   
}
