package model.card;

import java.util.Collections;
import java.util.Stack;

import model.card.type.ICard;

/**
 * Class that implements the constructor and methods of the ICardPile interface
 * 
 * @author Daniela Campos
 */
public class CardPile implements ICardPile {
  
  private Stack<ICard> pila;
  private int tamano;
  
  
  /**
   * Constructor of an object of the CardPile Class
   */
  public CardPile() {
    
    this.pila = new Stack<ICard>();
    this.tamano = 0;
  }

  @Override
  public int getSize() {
    
    return this.tamano;
  }

  @Override
  public ICard pushCard(ICard newCard) {
    
    ++this.tamano;
    return this.pila.push(newCard);
  }

  @Override
  public ICard popCard() {
    
    ICard actual = (ICard) this.pila.pop();
    --this.tamano;
    return actual;
  }

  @Override
  public ICard peekCard() {
    
    return (ICard) this.pila.peek();
  }

  @Override//Collections.shuffle(stack)
  public void shuffle() {
    
    Collections.shuffle(pila);
  }

  @Override
  public boolean isEmpty() {
    
    return pila.isEmpty();
  }

  @Override
  public void pushCards(ICardPile otherPile) {
    
    while(!otherPile.isEmpty()) {
      ICard nueva = otherPile.popCard();
      this.pushCard(nueva);
    }
  }
}
