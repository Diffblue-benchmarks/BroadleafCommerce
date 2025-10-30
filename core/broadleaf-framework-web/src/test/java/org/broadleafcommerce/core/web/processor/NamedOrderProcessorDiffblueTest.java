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
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Map;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.service.OrderService;
import org.broadleafcommerce.presentation.model.BroadleafTemplateContext;
import org.broadleafcommerce.profile.core.domain.Customer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class NamedOrderProcessorDiffblueTest {
  @InjectMocks
  private NamedOrderProcessor namedOrderProcessor;

  @Mock
  private OrderService orderService;

  /**
   * Test {@link NamedOrderProcessor#getName()}.
   * <p>
   * Method under test: {@link NamedOrderProcessor#getName()}
   */
  @Test
  @DisplayName("Test getName()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String NamedOrderProcessor.getName()"})
  void testGetName() {
    // Arrange, Act and Assert
    assertEquals("named_order", (new NamedOrderProcessor()).getName());
  }

  /**
   * Test {@link NamedOrderProcessor#getPrecedence()}.
   * <p>
   * Method under test: {@link NamedOrderProcessor#getPrecedence()}
   */
  @Test
  @DisplayName("Test getPrecedence()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int NamedOrderProcessor.getPrecedence()"})
  void testGetPrecedence() {
    // Arrange, Act and Assert
    assertEquals(10000, namedOrderProcessor.getPrecedence());
  }

  /**
   * Test {@link NamedOrderProcessor#populateModelVariables(String, Map, BroadleafTemplateContext)}.
   * <ul>
   *   <li>Given {@link OrderService} {@link OrderService#findNamedOrderForCustomer(String, Customer)} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link NamedOrderProcessor#populateModelVariables(String, Map, BroadleafTemplateContext)}
   */
  @Test
  @DisplayName("Test populateModelVariables(String, Map, BroadleafTemplateContext); given OrderService findNamedOrderForCustomer(String, Customer) return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map NamedOrderProcessor.populateModelVariables(String, Map, BroadleafTemplateContext)"})
  void testPopulateModelVariables_givenOrderServiceFindNamedOrderForCustomerReturnNull() {
    // Arrange
    when(orderService.findNamedOrderForCustomer(Mockito.<String>any(), Mockito.<Customer>any())).thenReturn(null);

    // Act
    Map<String, Object> actualPopulateModelVariablesResult = namedOrderProcessor.populateModelVariables("Tag Name",
        new HashMap<>(), mock(BroadleafTemplateContext.class));

    // Assert
    verify(orderService).findNamedOrderForCustomer(isNull(), isNull());
    assertEquals(1, actualPopulateModelVariablesResult.size());
    assertTrue(actualPopulateModelVariablesResult.get(null) instanceof NullOrderImpl);
  }

  /**
   * Test {@link NamedOrderProcessor#populateModelVariables(String, Map, BroadleafTemplateContext)}.
   * <ul>
   *   <li>Then return {@code null} is {@link NullOrderImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link NamedOrderProcessor#populateModelVariables(String, Map, BroadleafTemplateContext)}
   */
  @Test
  @DisplayName("Test populateModelVariables(String, Map, BroadleafTemplateContext); then return 'null' is NullOrderImpl (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map NamedOrderProcessor.populateModelVariables(String, Map, BroadleafTemplateContext)"})
  void testPopulateModelVariables_thenReturnNullIsNullOrderImpl() {
    // Arrange
    NullOrderImpl nullOrderImpl = new NullOrderImpl();
    when(orderService.findNamedOrderForCustomer(Mockito.<String>any(), Mockito.<Customer>any()))
        .thenReturn(nullOrderImpl);

    // Act
    Map<String, Object> actualPopulateModelVariablesResult = namedOrderProcessor.populateModelVariables("Tag Name",
        new HashMap<>(), mock(BroadleafTemplateContext.class));

    // Assert
    verify(orderService).findNamedOrderForCustomer(isNull(), isNull());
    assertEquals(1, actualPopulateModelVariablesResult.size());
    Object getResult = actualPopulateModelVariablesResult.get(null);
    assertTrue(getResult instanceof NullOrderImpl);
    assertSame(nullOrderImpl, getResult);
  }
}
