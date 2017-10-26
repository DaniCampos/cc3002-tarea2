package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import model.card.deck.*;

public class DeckStrategyTest {
  
  
  private IDeckStrategy deckS1;
  @Before
  public void setUp() throws Exception {
    
    deckS1 = new DeckStrategy();
    
  }

  @Test
  public void test() {
    //fail("Not yet implemented");
  }

}
