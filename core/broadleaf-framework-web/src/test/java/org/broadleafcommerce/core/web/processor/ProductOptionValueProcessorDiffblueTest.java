package org.broadleafcommerce.core.web.processor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.core.catalog.domain.ProductOptionImpl;
import org.broadleafcommerce.core.catalog.domain.ProductOptionValueImpl;
import org.broadleafcommerce.presentation.model.BroadleafAttributeModifier;
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
class ProductOptionValueProcessorDiffblueTest {
  @Autowired
  private ProductOptionValueProcessor productOptionValueProcessor;

  /**
   * Test {@link ProductOptionValueProcessor#getName()}.
   * <p>
   * Method under test: {@link ProductOptionValueProcessor#getName()}
   */
  @Test
  @DisplayName("Test getName()")
  void testGetName() {
    // Arrange, Act and Assert
    assertEquals("product_option_value", (new ProductOptionValueProcessor()).getName());
  }

  /**
   * Test {@link ProductOptionValueProcessor#getPrecedence()}.
   * <p>
   * Method under test: {@link ProductOptionValueProcessor#getPrecedence()}
   */
  @Test
  @DisplayName("Test getPrecedence()")
  void testGetPrecedence() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals(10000, (new ProductOptionValueProcessor()).getPrecedence());
  }

  /**
   * Test {@link ProductOptionValueProcessor#getPrecedence()}.
   * <p>
   * Method under test: {@link ProductOptionValueProcessor#getPrecedence()}
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
    //   public class DiffblueFakeClass11377 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.processor.ProductOptionValueProcessor productOptionValueProcessor;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new ProductOptionValueProcessor()).getPrecedence();
  }

  /**
   * Test
   * {@link ProductOptionValueProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}.
   * <p>
   * Method under test:
   * {@link ProductOptionValueProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}
   */
  @Test
  @DisplayName("Test getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)")
  void testGetModifiedAttributes() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductOptionValueProcessor productOptionValueProcessor = new ProductOptionValueProcessor();
    HashMap<String, String> tagAttributes = new HashMap<>();
    ProductOptionValueImpl productOptionValueImpl = mock(ProductOptionValueImpl.class);
    when(productOptionValueImpl.getId()).thenReturn(1L);
    when(productOptionValueImpl.getAttributeValue()).thenReturn("42");
    when(productOptionValueImpl.getRawAttributeValue()).thenReturn("42");
    when(productOptionValueImpl.getPriceAdjustment()).thenReturn(new Money());
    when(productOptionValueImpl.getProductOption()).thenReturn(new ProductOptionImpl());
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.parseExpression(Mockito.<String>any())).thenReturn(productOptionValueImpl);

    // Act
    BroadleafAttributeModifier actualModifiedAttributes = productOptionValueProcessor.getModifiedAttributes("Tag Name",
        tagAttributes, "Attribute Name", "42", context);

    // Assert
    verify(productOptionValueImpl).getAttributeValue();
    verify(productOptionValueImpl).getId();
    verify(productOptionValueImpl, atLeast(1)).getPriceAdjustment();
    verify(productOptionValueImpl).getProductOption();
    verify(productOptionValueImpl).getRawAttributeValue();
    verify(context).parseExpression(eq("42"));
    Map<String, String> added = actualModifiedAttributes.getAdded();
    assertEquals(1, added.size());
    assertEquals("{\"optionId\":null,\"valueId\":1,\"valueName\":\"42\",\"rawValue\":\"42\",\"priceAdjustment\":0.00}",
        added.get("data-product-option-value"));
    assertTrue(actualModifiedAttributes.getRemoved().isEmpty());
  }

  /**
   * Test
   * {@link ProductOptionValueProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}.
   * <p>
   * Method under test:
   * {@link ProductOptionValueProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}
   */
  @Test
  @DisplayName("Test getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)")
  void testGetModifiedAttributes2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductOptionValueProcessor productOptionValueProcessor = new ProductOptionValueProcessor();
    HashMap<String, String> tagAttributes = new HashMap<>();
    ProductOptionValueImpl productOptionValueImpl = mock(ProductOptionValueImpl.class);
    when(productOptionValueImpl.getId()).thenReturn(1L);
    when(productOptionValueImpl.getAttributeValue()).thenReturn(null);
    when(productOptionValueImpl.getRawAttributeValue()).thenReturn("42");
    when(productOptionValueImpl.getPriceAdjustment()).thenReturn(new Money());
    when(productOptionValueImpl.getProductOption()).thenReturn(new ProductOptionImpl());
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.parseExpression(Mockito.<String>any())).thenReturn(productOptionValueImpl);

    // Act
    BroadleafAttributeModifier actualModifiedAttributes = productOptionValueProcessor.getModifiedAttributes("Tag Name",
        tagAttributes, "Attribute Name", "42", context);

    // Assert
    verify(productOptionValueImpl).getAttributeValue();
    verify(productOptionValueImpl).getId();
    verify(productOptionValueImpl, atLeast(1)).getPriceAdjustment();
    verify(productOptionValueImpl).getProductOption();
    verify(productOptionValueImpl).getRawAttributeValue();
    verify(context).parseExpression(eq("42"));
    Map<String, String> added = actualModifiedAttributes.getAdded();
    assertEquals(1, added.size());
    assertEquals("{\"optionId\":null,\"valueId\":1,\"valueName\":null,\"rawValue\":\"42\",\"priceAdjustment\":0.00}",
        added.get("data-product-option-value"));
    assertTrue(actualModifiedAttributes.getRemoved().isEmpty());
  }

  /**
   * Test
   * {@link ProductOptionValueProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}.
   * <p>
   * Method under test:
   * {@link ProductOptionValueProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}
   */
  @Test
  @DisplayName("Test getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)")
  void testGetModifiedAttributes3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductOptionValueProcessor productOptionValueProcessor = new ProductOptionValueProcessor();
    HashMap<String, String> tagAttributes = new HashMap<>();
    ProductOptionValueImpl productOptionValueImpl = mock(ProductOptionValueImpl.class);
    when(productOptionValueImpl.getId()).thenReturn(1L);
    when(productOptionValueImpl.getAttributeValue()).thenReturn("42");
    when(productOptionValueImpl.getRawAttributeValue()).thenReturn("42");
    when(productOptionValueImpl.getPriceAdjustment()).thenReturn(null);
    when(productOptionValueImpl.getProductOption()).thenReturn(new ProductOptionImpl());
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.parseExpression(Mockito.<String>any())).thenReturn(productOptionValueImpl);

    // Act
    BroadleafAttributeModifier actualModifiedAttributes = productOptionValueProcessor.getModifiedAttributes("Tag Name",
        tagAttributes, "Attribute Name", "42", context);

    // Assert
    verify(productOptionValueImpl).getAttributeValue();
    verify(productOptionValueImpl).getId();
    verify(productOptionValueImpl).getPriceAdjustment();
    verify(productOptionValueImpl).getProductOption();
    verify(productOptionValueImpl).getRawAttributeValue();
    verify(context).parseExpression(eq("42"));
    Map<String, String> added = actualModifiedAttributes.getAdded();
    assertEquals(1, added.size());
    assertEquals("{\"optionId\":null,\"valueId\":1,\"valueName\":\"42\",\"rawValue\":\"42\",\"priceAdjustment\":null}",
        added.get("data-product-option-value"));
    assertTrue(actualModifiedAttributes.getRemoved().isEmpty());
  }

  /**
   * Test
   * {@link ProductOptionValueProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}.
   * <p>
   * Method under test:
   * {@link ProductOptionValueProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}
   */
  @Test
  @DisplayName("Test getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)")
  @Disabled("TODO: Complete this test")
  void testGetModifiedAttributes4() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.processor;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass11357 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.processor.ProductOptionValueProcessor productOptionValueProcessor;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    ProductOptionValueProcessor productOptionValueProcessor2 = new ProductOptionValueProcessor();

    // Act
    productOptionValueProcessor2.getModifiedAttributes("Tag Name", new HashMap<>(), "Attribute Name", "42",
        mock(BroadleafTemplateContext.class));
  }

  /**
   * Test
   * {@link ProductOptionValueProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}.
   * <ul>
   *   <li>Given {@link ProductOptionValueImpl} (default constructor) AttributeValue
   * is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProductOptionValueProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}
   */
  @Test
  @DisplayName("Test getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext); given ProductOptionValueImpl (default constructor) AttributeValue is '42'")
  void testGetModifiedAttributes_givenProductOptionValueImplAttributeValueIs42() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductOptionValueProcessor productOptionValueProcessor = new ProductOptionValueProcessor();
    HashMap<String, String> tagAttributes = new HashMap<>();

    ProductOptionValueImpl productOptionValueImpl = new ProductOptionValueImpl();
    productOptionValueImpl.setAttributeValue("42");
    productOptionValueImpl.setDisplayOrder(1L);
    productOptionValueImpl.setId(1L);
    productOptionValueImpl.setPriceAdjustment(new Money());
    productOptionValueImpl.setProductOption(new ProductOptionImpl());
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.parseExpression(Mockito.<String>any())).thenReturn(productOptionValueImpl);

    // Act
    BroadleafAttributeModifier actualModifiedAttributes = productOptionValueProcessor.getModifiedAttributes("Tag Name",
        tagAttributes, "Attribute Name", "42", context);

    // Assert
    verify(context).parseExpression(eq("42"));
    Map<String, String> added = actualModifiedAttributes.getAdded();
    assertEquals(1, added.size());
    assertEquals("{\"optionId\":null,\"valueId\":1,\"valueName\":\"42\",\"rawValue\":\"42\",\"priceAdjustment\":0.00}",
        added.get("data-product-option-value"));
    assertTrue(actualModifiedAttributes.getRemoved().isEmpty());
  }

  /**
   * Test ProductOptionValueDTO getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>
   * {@link ProductOptionValueProcessor.ProductOptionValueDTO#ProductOptionValueDTO(ProductOptionValueProcessor)}
   *   <li>
   * {@link ProductOptionValueProcessor.ProductOptionValueDTO#setOptionId(Long)}
   *   <li>
   * {@link ProductOptionValueProcessor.ProductOptionValueDTO#setPriceAdjustment(BigDecimal)}
   *   <li>
   * {@link ProductOptionValueProcessor.ProductOptionValueDTO#setRawValue(String)}
   *   <li>
   * {@link ProductOptionValueProcessor.ProductOptionValueDTO#setValueId(Long)}
   *   <li>
   * {@link ProductOptionValueProcessor.ProductOptionValueDTO#setValueName(String)}
   *   <li>{@link ProductOptionValueProcessor.ProductOptionValueDTO#getOptionId()}
   *   <li>
   * {@link ProductOptionValueProcessor.ProductOptionValueDTO#getPriceAdjustment()}
   *   <li>{@link ProductOptionValueProcessor.ProductOptionValueDTO#getRawValue()}
   *   <li>{@link ProductOptionValueProcessor.ProductOptionValueDTO#getValueId()}
   *   <li>{@link ProductOptionValueProcessor.ProductOptionValueDTO#getValueName()}
   * </ul>
   */
  @Test
  @DisplayName("Test ProductOptionValueDTO getters and setters")
  void testProductOptionValueDTOGettersAndSetters() {
    // Arrange and Act
    ProductOptionValueProcessor.ProductOptionValueDTO actualProductOptionValueDTO = (new ProductOptionValueProcessor()).new ProductOptionValueDTO();
    actualProductOptionValueDTO.setOptionId(1L);
    BigDecimal priceAdjustment = new BigDecimal("2.3");
    actualProductOptionValueDTO.setPriceAdjustment(priceAdjustment);
    actualProductOptionValueDTO.setRawValue("42");
    actualProductOptionValueDTO.setValueId(1L);
    actualProductOptionValueDTO.setValueName("42");
    Long actualOptionId = actualProductOptionValueDTO.getOptionId();
    BigDecimal actualPriceAdjustment = actualProductOptionValueDTO.getPriceAdjustment();
    String actualRawValue = actualProductOptionValueDTO.getRawValue();
    Long actualValueId = actualProductOptionValueDTO.getValueId();

    // Assert that nothing has changed
    assertEquals("42", actualRawValue);
    assertEquals("42", actualProductOptionValueDTO.getValueName());
    assertEquals(1L, actualOptionId.longValue());
    assertEquals(1L, actualValueId.longValue());
    assertEquals(new BigDecimal("2.3"), actualPriceAdjustment);
    assertSame(priceAdjustment, actualPriceAdjustment);
  }

  /**
   * Test {@link ProductOptionValueProcessor#useSingleQuotes()}.
   * <p>
   * Method under test: {@link ProductOptionValueProcessor#useSingleQuotes()}
   */
  @Test
  @DisplayName("Test useSingleQuotes()")
  void testUseSingleQuotes() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new ProductOptionValueProcessor()).useSingleQuotes());
  }

  /**
   * Test {@link ProductOptionValueProcessor#useSingleQuotes()}.
   * <p>
   * Method under test: {@link ProductOptionValueProcessor#useSingleQuotes()}
   */
  @Test
  @DisplayName("Test useSingleQuotes()")
  @Disabled("TODO: Complete this test")
  void testUseSingleQuotes2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.processor;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass11378 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.processor.ProductOptionValueProcessor productOptionValueProcessor;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new ProductOptionValueProcessor()).useSingleQuotes();
  }
}
