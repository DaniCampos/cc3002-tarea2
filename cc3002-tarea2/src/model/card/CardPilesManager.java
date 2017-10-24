package model.card;

import java.util.ArrayList;

import model.card.deck.*;
import model.card.type.ICard;
import model.player.type.IPlayer;

public class CardPilesManager implements ICardPilesManager {
  
  private ICardPile pilaDesc;
  private ICardPile mazo;
  
  public CardPilesManager(IDeckStrategy deckStrategy) {
    
    this.pilaDesc = new CardPile();
    this.mazo = deckStrategy.createDeck();
    this.mazo.shuffle();
    ICard primera = this.mazo.popCard();
    while(!primera.isFirstPlayable()) {
      mazo.pushCard(primera);
      mazo.shuffle();
      primera = this.mazo.popCard();
    }
    this.pilaDesc.pushCard(primera);
    
  }

  @Override
  public void rebuildDeck() { 
    
    ICard cartaDesc = pilaDesc.popCard();
    mazo = pilaDesc;
    mazo.shuffle();
    pilaDesc = new CardPile();
    pilaDesc.pushCard(cartaDesc);
  }

  @Override
  public ICard drawCard() {
    return mazo.popCard();
  }

  @Override
  public int getDrawableCardsNumber() {
    return pilaDesc.getSize() + mazo.getSize() - 1;
  }

  @Override
  public ArrayList<ICard> drawCards(int cardsNumber) {
    ArrayList<ICard> list = new ArrayList<ICard>();
    while(cardsNumber != 0) {
      list.add(mazo.popCard());
      cardsNumber--;
    }
    return list;
  }
 
  @Override
  public ICard getCurrentPlayedCard() {
    return pilaDesc.peekCard();
  }

  @Override
  public void discard(ICard newCard) {
    pilaDesc.pushCard(newCard);
    
  }

  @Override
  public ArrayList<ICard> addCardsToPlayer(IPlayer player, int number) {
    ArrayList<ICard> mano = drawCards(number);
    player.addToHand(mano);
    return mano;
  }

}
