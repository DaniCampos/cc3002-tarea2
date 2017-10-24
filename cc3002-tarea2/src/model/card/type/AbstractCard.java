package model.card.type;

import controller.IController;
import model.IGameLogic;

public abstract class AbstractCard implements ICard{
  
  protected Color color;
  protected Symbol symbol;
  
  @Override
  public String toString() {
    
    return this.getColor().toString() + " " + this.getSymbol().toString(); 
  }
  
  

  @Override
  public boolean isPlayableOver(ICard otherCard) {
     
     return otherCard.getColor() == this.getColor() || otherCard.getSymbol() == this.getSymbol() ||
         this.getSymbol().getName().equals("Comodín") || this.getSymbol().getName().equals("Comodín + Roba 4"); //Symbol.WILD
  }
  
  @Override
  public boolean isFirstPlayable() {
    //return this.getSymbol().getName().equals("Comodín") | this.getSymbol().getName().equals("Comodín + Roba 4");
    return true;
    //override en null y en wilds
  }

  @Override
  public Color getColor() {
    return color;
  }

  @Override
  public Symbol getSymbol() {
    return symbol;
  }
  
  public void setColor(Color color) {
    this.color = color;
  }

  @Override
  public void executeAction(IGameLogic game, IController ctrl) {
     //game.playCard(this, ctrl);
     ctrl.showMessage("Se jugó" + " " + this.getColor().toString() + " " + this.getSymbol().toString());
    
  }

  @Override
  public boolean isDiscardable() {
    //return this.getColor().getName().equals("Sin Color") & this.getSymbol().getName().equals("Sin Símbolo");
    return true;
  }
  
  
}