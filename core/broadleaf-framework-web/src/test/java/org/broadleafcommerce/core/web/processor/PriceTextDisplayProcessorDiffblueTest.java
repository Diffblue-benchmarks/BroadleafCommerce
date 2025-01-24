package org.broadleafcommerce.core.web.processor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.HashMap;
import java.util.Map;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.presentation.model.BroadleafTemplateContext;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml",
    "/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml",
    "/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
@ExtendWith(SpringExtension.class)
class PriceTextDisplayProcessorDiffblueTest {
  @Autowired
  private PriceTextDisplayProcessor priceTextDisplayProcessor;

  /**
   * Test {@link PriceTextDisplayProcessor#getName()}.
   * <p>
   * Method under test: {@link PriceTextDisplayProcessor#getName()}
   */
  @Test
  @DisplayName("Test getName()")
  void testGetName() {
    // Arrange, Act and Assert
    assertEquals("price", (new PriceTextDisplayProcessor()).getName());
  }

  /**
   * Test {@link PriceTextDisplayProcessor#getPrecedence()}.
   * <p>
   * Method under test: {@link PriceTextDisplayProcessor#getPrecedence()}
   */
  @Test
  @DisplayName("Test getPrecedence()")
  void testGetPrecedence() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals(1500, (new PriceTextDisplayProcessor()).getPrecedence());
  }

  /**
   * Test {@link PriceTextDisplayProcessor#getPrecedence()}.
   * <p>
   * Method under test: {@link PriceTextDisplayProcessor#getPrecedence()}
   */
  @Test
  @DisplayName("Test getPrecedence()")
  @Disabled("TODO: Complete this test")
  void testGetPrecedence2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.processor;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass11319 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.processor.PriceTextDisplayProcessor priceTextDisplayProcessor;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new PriceTextDisplayProcessor()).getPrecedence();
  }

  /**
   * Test
   * {@link PriceTextDisplayProcessor#getTagText(String, Map, String, String, BroadleafTemplateContext)}.
   * <p>
   * Method under test:
   * {@link PriceTextDisplayProcessor#getTagText(String, Map, String, String, BroadleafTemplateContext)}
   */
  @Test
  @DisplayName("Test getTagText(String, Map, String, String, BroadleafTemplateContext)")
  @Disabled("TODO: Complete this test")
  void testGetTagText() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.processor;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass11320 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.processor.PriceTextDisplayProcessor priceTextDisplayProcessor;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    PriceTextDisplayProcessor priceTextDisplayProcessor2 = new PriceTextDisplayProcessor();

    // Act
    priceTextDisplayProcessor2.getTagText("Tag Name", new HashMap<>(), "Attribute Name", "42",
        mock(BroadleafTemplateContext.class));
  }

  /**
   * Test
   * {@link PriceTextDisplayProcessor#getTagText(String, Map, String, String, BroadleafTemplateContext)}.
   * <ul>
   *   <li>Given {@code A}.</li>
   *   <li>Then return {@code £65.00}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PriceTextDisplayProcessor#getTagText(String, Map, String, String, BroadleafTemplateContext)}
   */
  @Test
  @DisplayName("Test getTagText(String, Map, String, String, BroadleafTemplateContext); given 'A'; then return '£65.00'")
  void testGetTagText_givenA_thenReturn6500() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PriceTextDisplayProcessor priceTextDisplayProcessor = new PriceTextDisplayProcessor();
    HashMap<String, String> tagAttributes = new HashMap<>();
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.parseExpression(Mockito.<String>any())).thenReturn((byte) 'A');

    // Act
    String actualTagText = priceTextDisplayProcessor.getTagText("Tag Name", tagAttributes, "Attribute Name", "42",
        context);

    // Assert
    verify(context).parseExpression(eq("42"));
    assertEquals("£65.00", actualTagText);
  }

  /**
   * Test
   * {@link PriceTextDisplayProcessor#getTagText(String, Map, String, String, BroadleafTemplateContext)}.
   * <ul>
   *   <li>Given {@link Money#Money()}.</li>
   *   <li>Then return {@code £0.00}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PriceTextDisplayProcessor#getTagText(String, Map, String, String, BroadleafTemplateContext)}
   */
  @Test
  @DisplayName("Test getTagText(String, Map, String, String, BroadleafTemplateContext); given Money(); then return '£0.00'")
  void testGetTagText_givenMoney_thenReturn000() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PriceTextDisplayProcessor priceTextDisplayProcessor = new PriceTextDisplayProcessor();
    HashMap<String, String> tagAttributes = new HashMap<>();
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.parseExpression(Mockito.<String>any())).thenReturn(new Money());

    // Act
    String actualTagText = priceTextDisplayProcessor.getTagText("Tag Name", tagAttributes, "Attribute Name", "42",
        context);

    // Assert
    verify(context).parseExpression(eq("42"));
    assertEquals("£0.00", actualTagText);
  }

  /**
   * Test
   * {@link PriceTextDisplayProcessor#getTagText(String, Map, String, String, BroadleafTemplateContext)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>Then return {@code £1.00}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PriceTextDisplayProcessor#getTagText(String, Map, String, String, BroadleafTemplateContext)}
   */
  @Test
  @DisplayName("Test getTagText(String, Map, String, String, BroadleafTemplateContext); given one; then return '£1.00'")
  void testGetTagText_givenOne_thenReturn100() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PriceTextDisplayProcessor priceTextDisplayProcessor = new PriceTextDisplayProcessor();
    HashMap<String, String> tagAttributes = new HashMap<>();
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.parseExpression(Mockito.<String>any())).thenReturn(1);

    // Act
    String actualTagText = priceTextDisplayProcessor.getTagText("Tag Name", tagAttributes, "Attribute Name", "42",
        context);

    // Assert
    verify(context).parseExpression(eq("42"));
    assertEquals("£1.00", actualTagText);
  }

  /**
   * Test
   * {@link PriceTextDisplayProcessor#getTagText(String, Map, String, String, BroadleafTemplateContext)}.
   * <ul>
   *   <li>Given {@code Parse Expression}.</li>
   *   <li>Then return {@code Not Available}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PriceTextDisplayProcessor#getTagText(String, Map, String, String, BroadleafTemplateContext)}
   */
  @Test
  @DisplayName("Test getTagText(String, Map, String, String, BroadleafTemplateContext); given 'Parse Expression'; then return 'Not Available'")
  void testGetTagText_givenParseExpression_thenReturnNotAvailable() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PriceTextDisplayProcessor priceTextDisplayProcessor = new PriceTextDisplayProcessor();
    HashMap<String, String> tagAttributes = new HashMap<>();
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.parseExpression(Mockito.<String>any())).thenReturn("Parse Expression");

    // Act
    String actualTagText = priceTextDisplayProcessor.getTagText("Tag Name", tagAttributes, "Attribute Name", "42",
        context);

    // Assert
    verify(context).parseExpression(eq("42"));
    assertEquals("Not Available", actualTagText);
  }
}
