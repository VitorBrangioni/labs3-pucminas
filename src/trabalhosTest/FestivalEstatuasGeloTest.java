package trabalhosTest;

import static org.junit.Assert.assertEquals;

import java.security.InvalidParameterException;

import org.junit.Test;

import trabalhos.FestivalEstatuasGelo;

/**
 * FestivalEstatuasGelo test
 * @author vitorbrangioni
 */
public class FestivalEstatuasGeloTest {

	@Test
	public void firstInstanceTest() {
		int[] blocos = { 1, 5, 10, 15, 25, 50 };
		int comprimentoMax = 100;
		FestivalEstatuasGelo festivalEstatuasGelo = new FestivalEstatuasGelo(blocos, comprimentoMax);

		assertEquals(2, festivalEstatuasGelo.getMinBlocos());
	}

	@Test
	public void secondInstanceTest() {
		int[] blocos = { 1, 5 };
		int comprimentoMax = 103;
		FestivalEstatuasGelo festivalEstatuasGelo = new FestivalEstatuasGelo(blocos, comprimentoMax);

		assertEquals(23, festivalEstatuasGelo.getMinBlocos());
	}

	@Test(expected = InvalidParameterException.class)
	public void nullBlocosTest() {
		new FestivalEstatuasGelo(null, 10);
	}

	@Test
	public void maxLengthEqualsZeroTest() {
		int[] blocos = { 1, 5 };
		FestivalEstatuasGelo festivalEstatuasGelo = new FestivalEstatuasGelo(blocos, 0);

		assertEquals(0, festivalEstatuasGelo.getMinBlocos());
	}
}
