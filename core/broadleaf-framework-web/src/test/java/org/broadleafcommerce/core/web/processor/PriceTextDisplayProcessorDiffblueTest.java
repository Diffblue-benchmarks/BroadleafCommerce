package org.broadleafcommerce.core.web.processor;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Map;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.presentation.model.BroadleafTemplateContext;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.Mockito;

public class PriceTextDisplayProcessorDiffblueTest {
  /**
   * Test {@link PriceTextDisplayProcessor#getName()}.
   *
   * <p>Method under test: {@link PriceTextDisplayProcessor#getName()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String PriceTextDisplayProcessor.getName()"})
  public void testGetName() {
    // Arrange, Act and Assert
    assertEquals("price", new PriceTextDisplayProcessor().getName());
  }

  /**
   * Test {@link PriceTextDisplayProcessor#getPrecedence()}.
   *
   * <p>Method under test: {@link PriceTextDisplayProcessor#getPrecedence()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int PriceTextDisplayProcessor.getPrecedence()"})
  public void testGetPrecedence() {
    // Arrange, Act and Assert
    assertEquals(1500, new PriceTextDisplayProcessor().getPrecedence());
  }

  /**
   * Test {@link PriceTextDisplayProcessor#getTagText(String, Map, String, String,
   * BroadleafTemplateContext)}.
   *
   * <ul>
   *   <li>Given {@link Money#Money()}.
   *   <li>Then return {@code USD0.00}.
   * </ul>
   *
   * <p>Method under test: {@link PriceTextDisplayProcessor#getTagText(String, Map, String, String,
   * BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String PriceTextDisplayProcessor.getTagText(String, Map, String, String, BroadleafTemplateContext)"
  })
  public void testGetTagText_givenMoney_thenReturnUsd000() {
    // Arrange
    PriceTextDisplayProcessor priceTextDisplayProcessor = new PriceTextDisplayProcessor();
    HashMap<String, String> tagAttributes = new HashMap<>();

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.parseExpression(Mockito.<String>any())).thenReturn(new Money());

    // Act
    String actualTagText =
        priceTextDisplayProcessor.getTagText(
            "Tag Name", tagAttributes, "Attribute Name", "42", context);

    // Assert
    verify(context).parseExpression("42");
    assertEquals("USD0.00", actualTagText);
  }

  /**
   * Test {@link PriceTextDisplayProcessor#getTagText(String, Map, String, String,
   * BroadleafTemplateContext)}.
   *
   * <ul>
   *   <li>Given {@code Parse Expression}.
   *   <li>Then return {@code Not Available}.
   * </ul>
   *
   * <p>Method under test: {@link PriceTextDisplayProcessor#getTagText(String, Map, String, String,
   * BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String PriceTextDisplayProcessor.getTagText(String, Map, String, String, BroadleafTemplateContext)"
  })
  public void testGetTagText_givenParseExpression_thenReturnNotAvailable() {
    // Arrange
    PriceTextDisplayProcessor priceTextDisplayProcessor = new PriceTextDisplayProcessor();
    HashMap<String, String> tagAttributes = new HashMap<>();

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.parseExpression(Mockito.<String>any())).thenReturn("Parse Expression");

    // Act
    String actualTagText =
        priceTextDisplayProcessor.getTagText(
            "Tag Name", tagAttributes, "Attribute Name", "42", context);

    // Assert
    verify(context).parseExpression("42");
    assertEquals("Not Available", actualTagText);
  }

  /**
   * Test {@link PriceTextDisplayProcessor#getTagText(String, Map, String, String,
   * BroadleafTemplateContext)}.
   *
   * <ul>
   *   <li>Given valueOf one.
   *   <li>Then return {@code USD1.00}.
   * </ul>
   *
   * <p>Method under test: {@link PriceTextDisplayProcessor#getTagText(String, Map, String, String,
   * BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String PriceTextDisplayProcessor.getTagText(String, Map, String, String, BroadleafTemplateContext)"
  })
  public void testGetTagText_givenValueOfOne_thenReturnUsd100() {
    // Arrange
    PriceTextDisplayProcessor priceTextDisplayProcessor = new PriceTextDisplayProcessor();
    HashMap<String, String> tagAttributes = new HashMap<>();

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.parseExpression(Mockito.<String>any())).thenReturn(Integer.valueOf(1));

    // Act
    String actualTagText =
        priceTextDisplayProcessor.getTagText(
            "Tag Name", tagAttributes, "Attribute Name", "42", context);

    // Assert
    verify(context).parseExpression("42");
    assertEquals("USD1.00", actualTagText);
  }
}
