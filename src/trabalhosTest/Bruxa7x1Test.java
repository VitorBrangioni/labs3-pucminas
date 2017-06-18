package trabalhosTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import trabalhos.Bruxa7x1;

public class Bruxa7x1Test {
	
	private Bruxa7x1 bruxa;
	
	@Before
	public void setUp() {
		this.bruxa = new Bruxa7x1();

	}

	@Test
	public void firstInputTest() {
		assertEquals(new Double(0), this.bruxa.calcule(3, 4, "+"));
	}

	@Test
	public void secondInputTest() {
		assertEquals(new Double(21), this.bruxa.calcule(17, 11, "+"));
	}
	
	@Test
	public void thirdInputTest() {
		assertEquals(new Double(2), this.bruxa.calcule(8, 9, "x"));
	}
	
	@Test
	public void fourthInputTest() {
		assertEquals(new Double(162), this.bruxa.calcule(9, 18, "x"));
	}
}
