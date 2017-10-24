package model.card;

import java.util.Collections;
import java.util.Stack;

import model.card.type.ICard;

public class CardPile implements ICardPile {
  
  private Stack<ICard> pila;
  private int tamano;
  
  //Stack tiene size()
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
    
    /*
    CardPile barajadas = new CardPile();
    float mitad = tamano/2;
    CardPile cartas = new CardPile();
    
    boolean exacto = tamano%2 == 0;
    
    while(mitad > 0){
      cartas.pushCard(pila.pop());
      -- mitad;
    }
    
    if(!exacto) {
      barajadas.pushCard(this.popCard());
    }
    
    while(!isEmpty()){
      barajadas.pushCard(this.popCard());
      barajadas.pushCard(cartas.popCard());
    }
    
    pushCards(barajadas);*/
    

    
    
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
