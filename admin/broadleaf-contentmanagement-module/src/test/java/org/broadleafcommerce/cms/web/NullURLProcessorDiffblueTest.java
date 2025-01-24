package org.broadleafcommerce.cms.web;

import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {NullURLProcessor.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class NullURLProcessorDiffblueTest {
  @Autowired
  private NullURLProcessor nullURLProcessor;

  /**
   * Test {@link NullURLProcessor#canProcessURL(String)}.
   * <p>
   * Method under test: {@link NullURLProcessor#canProcessURL(String)}
   */
  @Test
  public void testCanProcessURL() {
    // Arrange, Act and Assert
    assertTrue(nullURLProcessor.canProcessURL("https://example.org/example"));
  }

  /**
   * Test {@link NullURLProcessor#processURL(String)}.
   * <p>
   * Method under test: {@link NullURLProcessor#processURL(String)}
   */
  @Test
  public void testProcessURL() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> nullURLProcessor.processURL("https://example.org/example"));
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link NullURLProcessor}
   *   <li>{@link NullURLProcessor#getInstance()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing observers.
    //   Diffblue Cover was unable to create an assertion.
    //   Add getters for the following fields or make them package-private:
    //     NullURLProcessor._instance

    // Arrange and Act
    (new NullURLProcessor()).getInstance();
  }
}
