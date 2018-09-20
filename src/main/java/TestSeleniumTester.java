import static org.junit.Assert.assertEquals;
import org.junit.Test;

import com.github.adamflorczak.game2048.controller.SeleniumTester;



public class TestSeleniumTester {

	
	@Test
	public void givenBingReturnBingWebPageTittle() {
		
		SeleniumTester tester = new SeleniumTester();	
		
		assertEquals(tester.getWebPageTittle("http://www.bing.com"), "Bing");
	}
	
	@Test
	public void givenBingSearchEngineWhenSearchingCapgeminiReturnSearchedWebPageTittle() throws InterruptedException {
		
		SeleniumTester tester = new SeleniumTester();
		
		assertEquals(tester.searchSomethingWithBing("Capgemini"),  "Capgemini - Bing");
	}
}
