package org.broadleafcommerce.core.web.processor;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.core.catalog.domain.ProductOptionImpl;
import org.broadleafcommerce.core.catalog.domain.ProductOptionValueImpl;
import org.broadleafcommerce.core.web.processor.ProductOptionValueProcessor.ProductOptionValueDTO;
import org.broadleafcommerce.presentation.model.BroadleafAttributeModifier;
import org.broadleafcommerce.presentation.model.BroadleafTemplateContext;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.Mockito;

public class ProductOptionValueProcessorDiffblueTest {
  /**
   * Test {@link ProductOptionValueProcessor#getName()}.
   *
   * <p>Method under test: {@link ProductOptionValueProcessor#getName()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ProductOptionValueProcessor.getName()"})
  public void testGetName() {
    // Arrange, Act and Assert
    assertEquals("product_option_value", new ProductOptionValueProcessor().getName());
  }

  /**
   * Test {@link ProductOptionValueProcessor#getPrecedence()}.
   *
   * <p>Method under test: {@link ProductOptionValueProcessor#getPrecedence()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int ProductOptionValueProcessor.getPrecedence()"})
  public void testGetPrecedence() {
    // Arrange, Act and Assert
    assertEquals(10000, new ProductOptionValueProcessor().getPrecedence());
  }

  /**
   * Test {@link ProductOptionValueProcessor#getModifiedAttributes(String, Map, String, String,
   * BroadleafTemplateContext)}.
   *
   * <p>Method under test: {@link ProductOptionValueProcessor#getModifiedAttributes(String, Map,
   * String, String, BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BroadleafAttributeModifier ProductOptionValueProcessor.getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)"
  })
  public void testGetModifiedAttributes() {
    // Arrange
    ProductOptionValueProcessor productOptionValueProcessor = new ProductOptionValueProcessor();
    HashMap<String, String> tagAttributes = new HashMap<>();

    ProductOptionValueImpl productOptionValueImpl = new ProductOptionValueImpl();
    productOptionValueImpl.setDisplayOrder(1L);
    productOptionValueImpl.setId(1L);
    productOptionValueImpl.setPriceAdjustment(new Money());
    productOptionValueImpl.setProductOption(new ProductOptionImpl());
    productOptionValueImpl.setAttributeValue(null);

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.parseExpression(Mockito.<String>any())).thenReturn(productOptionValueImpl);

    // Act
    BroadleafAttributeModifier actualModifiedAttributes =
        productOptionValueProcessor.getModifiedAttributes(
            "Tag Name", tagAttributes, "Attribute Name", "42", context);

    // Assert
    verify(context).parseExpression("42");
    Map<String, String> added = actualModifiedAttributes.getAdded();
    assertEquals(1, added.size());
    assertEquals(
        "{\"optionId\":null,\"valueId\":1,\"valueName\":null,\"rawValue\":null,\"priceAdjustment\":0.00}",
        added.get("data-product-option-value"));
    assertTrue(actualModifiedAttributes.getRemoved().isEmpty());
  }

  /**
   * Test {@link ProductOptionValueProcessor#getModifiedAttributes(String, Map, String, String,
   * BroadleafTemplateContext)}.
   *
   * <p>Method under test: {@link ProductOptionValueProcessor#getModifiedAttributes(String, Map,
   * String, String, BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BroadleafAttributeModifier ProductOptionValueProcessor.getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)"
  })
  public void testGetModifiedAttributes2() {
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
    BroadleafAttributeModifier actualModifiedAttributes =
        productOptionValueProcessor.getModifiedAttributes(
            "Tag Name", tagAttributes, "Attribute Name", "42", context);

    // Assert
    verify(productOptionValueImpl).getAttributeValue();
    verify(productOptionValueImpl).getId();
    verify(productOptionValueImpl).getPriceAdjustment();
    verify(productOptionValueImpl).getProductOption();
    verify(productOptionValueImpl).getRawAttributeValue();
    verify(context).parseExpression("42");
    Map<String, String> added = actualModifiedAttributes.getAdded();
    assertEquals(1, added.size());
    assertEquals(
        "{\"optionId\":null,\"valueId\":1,\"valueName\":\"42\",\"rawValue\":\"42\",\"priceAdjustment\":null}",
        added.get("data-product-option-value"));
    assertTrue(actualModifiedAttributes.getRemoved().isEmpty());
  }

  /**
   * Test {@link ProductOptionValueProcessor#getModifiedAttributes(String, Map, String, String,
   * BroadleafTemplateContext)}.
   *
   * <ul>
   *   <li>Given {@link ProductOptionValueImpl} {@link ProductOptionValueImpl#getId()} throw {@link
   *       RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link ProductOptionValueProcessor#getModifiedAttributes(String, Map,
   * String, String, BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BroadleafAttributeModifier ProductOptionValueProcessor.getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)"
  })
  public void testGetModifiedAttributes_givenProductOptionValueImplGetIdThrowRuntimeException() {
    // Arrange
    ProductOptionValueProcessor productOptionValueProcessor = new ProductOptionValueProcessor();
    HashMap<String, String> tagAttributes = new HashMap<>();

    ProductOptionValueImpl productOptionValueImpl = mock(ProductOptionValueImpl.class);
    when(productOptionValueImpl.getId()).thenThrow(new RuntimeException());
    when(productOptionValueImpl.getProductOption()).thenReturn(new ProductOptionImpl());

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.parseExpression(Mockito.<String>any())).thenReturn(productOptionValueImpl);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            productOptionValueProcessor.getModifiedAttributes(
                "Tag Name", tagAttributes, "Attribute Name", "42", context));
    verify(productOptionValueImpl).getId();
    verify(productOptionValueImpl).getProductOption();
    verify(context).parseExpression("42");
  }

  /**
   * Test {@link ProductOptionValueProcessor#getModifiedAttributes(String, Map, String, String,
   * BroadleafTemplateContext)}.
   *
   * <ul>
   *   <li>Given {@link RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link ProductOptionValueProcessor#getModifiedAttributes(String, Map,
   * String, String, BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BroadleafAttributeModifier ProductOptionValueProcessor.getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)"
  })
  public void testGetModifiedAttributes_givenRuntimeException() {
    // Arrange
    ProductOptionValueProcessor productOptionValueProcessor = new ProductOptionValueProcessor();
    HashMap<String, String> tagAttributes = new HashMap<>();

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.parseExpression(Mockito.<String>any())).thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            productOptionValueProcessor.getModifiedAttributes(
                "Tag Name", tagAttributes, "Attribute Name", "42", context));
    verify(context).parseExpression("42");
  }

  /**
   * Test {@link ProductOptionValueProcessor#getModifiedAttributes(String, Map, String, String,
   * BroadleafTemplateContext)}.
   *
   * <ul>
   *   <li>Then return Added {@code data-product-option-value} is a string.
   * </ul>
   *
   * <p>Method under test: {@link ProductOptionValueProcessor#getModifiedAttributes(String, Map,
   * String, String, BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BroadleafAttributeModifier ProductOptionValueProcessor.getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)"
  })
  public void testGetModifiedAttributes_thenReturnAddedDataProductOptionValueIsAString() {
    // Arrange
    ProductOptionValueProcessor productOptionValueProcessor = new ProductOptionValueProcessor();
    HashMap<String, String> tagAttributes = new HashMap<>();

    ProductOptionValueImpl productOptionValueImpl = new ProductOptionValueImpl();
    productOptionValueImpl.setDisplayOrder(1L);
    productOptionValueImpl.setId(1L);
    productOptionValueImpl.setPriceAdjustment(new Money());
    productOptionValueImpl.setProductOption(new ProductOptionImpl());
    productOptionValueImpl.setAttributeValue("Parse Expression");

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.parseExpression(Mockito.<String>any())).thenReturn(productOptionValueImpl);

    // Act
    BroadleafAttributeModifier actualModifiedAttributes =
        productOptionValueProcessor.getModifiedAttributes(
            "Tag Name", tagAttributes, "Attribute Name", "42", context);

    // Assert
    verify(context).parseExpression("42");
    Map<String, String> added = actualModifiedAttributes.getAdded();
    assertEquals(1, added.size());
    assertEquals(
        "{\"optionId\":null,\"valueId\":1,\"valueName\":\"Parse Expression\",\"rawValue\":\"Parse Expression\",\"priceAdjustment"
            + "\":0.00}",
        added.get("data-product-option-value"));
    assertTrue(actualModifiedAttributes.getRemoved().isEmpty());
  }

  /**
   * Test ProductOptionValueDTO getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ProductOptionValueDTO#ProductOptionValueDTO(ProductOptionValueProcessor)}
   *   <li>{@link ProductOptionValueDTO#setOptionId(Long)}
   *   <li>{@link ProductOptionValueDTO#setPriceAdjustment(BigDecimal)}
   *   <li>{@link ProductOptionValueDTO#setRawValue(String)}
   *   <li>{@link ProductOptionValueDTO#setValueId(Long)}
   *   <li>{@link ProductOptionValueDTO#setValueName(String)}
   *   <li>{@link ProductOptionValueDTO#getOptionId()}
   *   <li>{@link ProductOptionValueDTO#getPriceAdjustment()}
   *   <li>{@link ProductOptionValueDTO#getRawValue()}
   *   <li>{@link ProductOptionValueDTO#getValueId()}
   *   <li>{@link ProductOptionValueDTO#getValueName()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ProductOptionValueDTO.<init>(ProductOptionValueProcessor)",
    "Long ProductOptionValueDTO.getOptionId()",
    "BigDecimal ProductOptionValueDTO.getPriceAdjustment()",
    "String ProductOptionValueDTO.getRawValue()",
    "Long ProductOptionValueDTO.getValueId()",
    "String ProductOptionValueDTO.getValueName()",
    "void ProductOptionValueDTO.setOptionId(Long)",
    "void ProductOptionValueDTO.setPriceAdjustment(BigDecimal)",
    "void ProductOptionValueDTO.setRawValue(String)",
    "void ProductOptionValueDTO.setValueId(Long)",
    "void ProductOptionValueDTO.setValueName(String)"
  })
  public void testProductOptionValueDTOGettersAndSetters() {
    // Arrange and Act
    ProductOptionValueDTO actualProductOptionValueDTO =
        new ProductOptionValueProcessor().new ProductOptionValueDTO();
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

    // Assert
    assertEquals("42", actualRawValue);
    assertEquals("42", actualProductOptionValueDTO.getValueName());
    assertEquals(1L, actualOptionId.longValue());
    assertEquals(1L, actualValueId.longValue());
    assertEquals(new BigDecimal("2.3"), actualPriceAdjustment);
    assertSame(priceAdjustment, actualPriceAdjustment);
  }

  /**
   * Test {@link ProductOptionValueProcessor#useSingleQuotes()}.
   *
   * <p>Method under test: {@link ProductOptionValueProcessor#useSingleQuotes()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ProductOptionValueProcessor.useSingleQuotes()"})
  public void testUseSingleQuotes() {
    // Arrange, Act and Assert
    assertTrue(new ProductOptionValueProcessor().useSingleQuotes());
  }
}
