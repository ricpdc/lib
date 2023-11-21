/**
 * 
 */
package es.uclm.library.business.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.ui.Model;

import es.uclm.library.persistence.GreetingDAO;

/**
 * @author Ricardo
 *
 */
public class GreetingControllerTest {

	private static GreetingController greetingController;
	private static GreetingDAO greetingDAO;
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeAll
	protected static void setUpBeforeClass() throws Exception {
		greetingController = new GreetingController();
		//greetingController = Mockito.mock(GreetingController.class);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterAll
	protected static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	protected void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	protected void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link es.uclm.library.business.controller.GreetingController#greetingForm(org.springframework.ui.Model)}.
	 */
	@Test
	public void testGreetingForm() {
		Model model = Mockito.mock(Model.class);
		GreetingDAO greetingDAO = Mockito.mock(GreetingDAO.class);
		greetingController.setGreetingDAO(greetingDAO);
		
		
		String result = greetingController.greetingForm(model);
		
		assertNotNull(greetingController.getGreeting());
		assertEquals(result, "greeting");
	}

	/**
	 * Test method for {@link es.uclm.library.business.controller.GreetingController#greetingSubmit(es.uclm.library.business.entity.Greeting, org.springframework.ui.Model)}.
	 */
	@Test
	@Disabled
	public void testGreetingSubmit() {
		throw new RuntimeException("not yet implemented");
	}

}
