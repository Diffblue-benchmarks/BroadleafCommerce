/*-
 * #%L
 * BroadleafCommerce Framework Web
 * %%
 * Copyright (C) 2009 - 2025 Broadleaf Commerce
 * %%
 * Licensed under the Broadleaf Fair Use License Agreement, Version 1.0
 * (the "Fair Use License" located  at http://license.broadleafcommerce.org/fair_use_license-1.0.txt)
 * unless the restrictions on use therein are violated and require payment to Broadleaf in which case
 * the Broadleaf End User License Agreement (EULA), Version 1.1
 * (the "Commercial License" located at http://license.broadleafcommerce.org/commercial_license-1.1.txt)
 * shall apply.
 * 
 * Alternatively, the Commercial License may be replaced with a mutually agreed upon license (the "Custom License")
 * between you and Broadleaf Commerce. You may not use this file except in compliance with the applicable license.
 * #L%
 */
package org.broadleafcommerce.core.web.processor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.broadleafcommerce.core.catalog.domain.Product;
import org.broadleafcommerce.core.catalog.domain.ProductBundleImpl;
import org.broadleafcommerce.core.catalog.domain.ProductOptionXref;
import org.broadleafcommerce.core.catalog.domain.ProductOptionXrefImpl;
import org.broadleafcommerce.core.order.domain.DiscreteOrderItemImpl;
import org.broadleafcommerce.presentation.model.BroadleafTemplateContext;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ProductOptionDisplayProcessorDiffblueTest {
  @InjectMocks private ProductOptionDisplayProcessor productOptionDisplayProcessor;

  /**
   * Test {@link ProductOptionDisplayProcessor#getName()}.
   *
   * <p>Method under test: {@link ProductOptionDisplayProcessor#getName()}
   */
  @Test
  @DisplayName("Test getName()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ProductOptionDisplayProcessor.getName()"})
  void testGetName() {
    // Arrange, Act and Assert
    assertEquals("product_option_display", new ProductOptionDisplayProcessor().getName());
  }

  /**
   * Test {@link ProductOptionDisplayProcessor#getPrecedence()}.
   *
   * <p>Method under test: {@link ProductOptionDisplayProcessor#getPrecedence()}
   */
  @Test
  @DisplayName("Test getPrecedence()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ProductOptionDisplayProcessor.getPrecedence()"})
  void testGetPrecedence() {
    // Arrange, Act and Assert
    assertEquals(100, productOptionDisplayProcessor.getPrecedence());
  }

  /**
   * Test {@link ProductOptionDisplayProcessor#useGlobalScope()}.
   *
   * <p>Method under test: {@link ProductOptionDisplayProcessor#useGlobalScope()}
   */
  @Test
  @DisplayName("Test useGlobalScope()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ProductOptionDisplayProcessor.useGlobalScope()"})
  void testUseGlobalScope() {
    // Arrange, Act and Assert
    assertFalse(productOptionDisplayProcessor.useGlobalScope());
  }

  /**
   * Test {@link ProductOptionDisplayProcessor#populateModelVariables(String, Map,
   * BroadleafTemplateContext)}.
   *
   * <p>Method under test: {@link ProductOptionDisplayProcessor#populateModelVariables(String, Map,
   * BroadleafTemplateContext)}
   */
  @Test
  @DisplayName("Test populateModelVariables(String, Map, BroadleafTemplateContext)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map ProductOptionDisplayProcessor.populateModelVariables(String, Map, BroadleafTemplateContext)"
  })
  void testPopulateModelVariables() {
    // Arrange
    HashMap<String, String> tagAttributes = new HashMap<>();

    DiscreteOrderItemImpl discreteOrderItemImpl = mock(DiscreteOrderItemImpl.class);
    when(discreteOrderItemImpl.getOrderItemAttributes()).thenReturn(new HashMap<>());
    when(discreteOrderItemImpl.getProduct()).thenReturn(new ProductBundleImpl());

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.parseExpression(Mockito.<String>any())).thenReturn(discreteOrderItemImpl);

    // Act
    Map<String, Object> actualPopulateModelVariablesResult =
        productOptionDisplayProcessor.populateModelVariables("Tag Name", tagAttributes, context);

    // Assert
    verify(discreteOrderItemImpl).getProduct();
    verify(discreteOrderItemImpl).getOrderItemAttributes();
    verify(context).parseExpression(null);
    assertEquals(1, actualPopulateModelVariablesResult.size());
    Object getResult = actualPopulateModelVariablesResult.get("productOptionDisplayValues");
    assertTrue(getResult instanceof Map);
    assertTrue(((Map<Object, Object>) getResult).isEmpty());
  }

  /**
   * Test {@link ProductOptionDisplayProcessor#populateModelVariables(String, Map,
   * BroadleafTemplateContext)}.
   *
   * <ul>
   *   <li>Given {@code Parse Expression}.
   * </ul>
   *
   * <p>Method under test: {@link ProductOptionDisplayProcessor#populateModelVariables(String, Map,
   * BroadleafTemplateContext)}
   */
  @Test
  @DisplayName(
      "Test populateModelVariables(String, Map, BroadleafTemplateContext); given 'Parse Expression'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map ProductOptionDisplayProcessor.populateModelVariables(String, Map, BroadleafTemplateContext)"
  })
  void testPopulateModelVariables_givenParseExpression() {
    // Arrange
    HashMap<String, String> tagAttributes = new HashMap<>();

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.parseExpression(Mockito.<String>any())).thenReturn("Parse Expression");

    // Act
    Map<String, Object> actualPopulateModelVariablesResult =
        productOptionDisplayProcessor.populateModelVariables("Tag Name", tagAttributes, context);

    // Assert
    verify(context).parseExpression(null);
    assertEquals(1, actualPopulateModelVariablesResult.size());
    Object getResult = actualPopulateModelVariablesResult.get("productOptionDisplayValues");
    assertTrue(getResult instanceof Map);
    assertTrue(((Map<Object, Object>) getResult).isEmpty());
  }

  /**
   * Test {@link ProductOptionDisplayProcessor#populateModelVariables(String, Map,
   * BroadleafTemplateContext)}.
   *
   * <ul>
   *   <li>Then calls {@link Product#getProductOptionXrefs()}.
   * </ul>
   *
   * <p>Method under test: {@link ProductOptionDisplayProcessor#populateModelVariables(String, Map,
   * BroadleafTemplateContext)}
   */
  @Test
  @DisplayName(
      "Test populateModelVariables(String, Map, BroadleafTemplateContext); then calls getProductOptionXrefs()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map ProductOptionDisplayProcessor.populateModelVariables(String, Map, BroadleafTemplateContext)"
  })
  void testPopulateModelVariables_thenCallsGetProductOptionXrefs() {
    // Arrange
    HashMap<String, String> tagAttributes = new HashMap<>();

    ArrayList<ProductOptionXref> productOptionXrefList = new ArrayList<>();
    productOptionXrefList.add(new ProductOptionXrefImpl());

    Product product = mock(Product.class);
    when(product.getProductOptionXrefs()).thenReturn(productOptionXrefList);

    DiscreteOrderItemImpl discreteOrderItemImpl = mock(DiscreteOrderItemImpl.class);
    when(discreteOrderItemImpl.getOrderItemAttributes()).thenReturn(new HashMap<>());
    when(discreteOrderItemImpl.getProduct()).thenReturn(product);

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.parseExpression(Mockito.<String>any())).thenReturn(discreteOrderItemImpl);

    // Act
    Map<String, Object> actualPopulateModelVariablesResult =
        productOptionDisplayProcessor.populateModelVariables("Tag Name", tagAttributes, context);

    // Assert
    verify(product).getProductOptionXrefs();
    verify(discreteOrderItemImpl).getProduct();
    verify(discreteOrderItemImpl).getOrderItemAttributes();
    verify(context).parseExpression(null);
    assertEquals(1, actualPopulateModelVariablesResult.size());
    Object getResult = actualPopulateModelVariablesResult.get("productOptionDisplayValues");
    assertTrue(getResult instanceof Map);
    assertTrue(((Map<Object, Object>) getResult).isEmpty());
  }
}
