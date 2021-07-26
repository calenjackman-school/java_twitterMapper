package filters.test;

import filters.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Test the parser.
 */
public class TestParser {
    @Test
    public void testBasic() throws SyntaxError {
        Filter f = new Parser("trump").parse();
        assertTrue(f instanceof BasicFilter);
        assertTrue(((BasicFilter)f).getWord().equals("trump"));
    }

    @Test
    public void testHairy1() throws SyntaxError {
        Filter x = new Parser("trump and (evil or blue) and red or green and not not purple").parse();
        assertTrue(x.toString().equals("(((trump and (evil or blue)) and red) or (green and not not purple))"));
    }

	@Test
	public void testHairy2() throws SyntaxError {
		Filter x = new Parser("apples and bananas or pears and not grapes").parse();
		assertTrue(x.toString().equals("((apples and bananas) or (pears and not grapes))"));
	}

	@Test
	public void testHairy3() throws SyntaxError {
		Filter x = new Parser("Aubrey or Ella and Lucy or Calen and not Lucy or Aubrey").parse();
		assertTrue(x.toString().equals("(((Aubrey or (Ella and Lucy)) or (Calen and not Lucy)) or Aubrey)"));
	}
}
