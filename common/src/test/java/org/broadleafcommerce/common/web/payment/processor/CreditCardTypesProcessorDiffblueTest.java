/*-
 * #%L
 * BroadleafCommerce Common Libraries
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
package org.broadleafcommerce.common.web.payment.processor;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Map;
import org.broadleafcommerce.common.extension.ExtensionManager;
import org.broadleafcommerce.common.extension.ExtensionResultStatusType;
import org.broadleafcommerce.presentation.model.BroadleafTemplateContext;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CreditCardTypesProcessorDiffblueTest {
  @Mock
  private CreditCardTypesExtensionManager creditCardTypesExtensionManager;

  @InjectMocks
  private CreditCardTypesProcessor creditCardTypesProcessor;

  /**
   * Test {@link CreditCardTypesProcessor#getName()}.
   * <p>
   * Method under test: {@link CreditCardTypesProcessor#getName()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String CreditCardTypesProcessor.getName()"})
  public void testGetName() {
    // Arrange, Act and Assert
    assertEquals("credit_card_types", (new CreditCardTypesProcessor()).getName());
  }

  /**
   * Test {@link CreditCardTypesProcessor#getPrecedence()}.
   * <p>
   * Method under test: {@link CreditCardTypesProcessor#getPrecedence()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int CreditCardTypesProcessor.getPrecedence()"})
  public void testGetPrecedence() {
    // Arrange, Act and Assert
    assertEquals(100, creditCardTypesProcessor.getPrecedence());
  }

  /**
   * Test {@link CreditCardTypesProcessor#useGlobalScope()}.
   * <p>
   * Method under test: {@link CreditCardTypesProcessor#useGlobalScope()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean CreditCardTypesProcessor.useGlobalScope()"})
  public void testUseGlobalScope() {
    // Arrange, Act and Assert
    assertFalse(creditCardTypesProcessor.useGlobalScope());
  }

  /**
   * Test {@link CreditCardTypesProcessor#populateModelVariables(String, Map, BroadleafTemplateContext)}.
   * <ul>
   *   <li>Given {@link CreditCardTypesProcessor} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link CreditCardTypesProcessor#populateModelVariables(String, Map, BroadleafTemplateContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map CreditCardTypesProcessor.populateModelVariables(String, Map, BroadleafTemplateContext)"})
  public void testPopulateModelVariables_givenCreditCardTypesProcessor() {
    // Arrange
    CreditCardTypesProcessor creditCardTypesProcessor = new CreditCardTypesProcessor();

    // Act and Assert
    assertNull(creditCardTypesProcessor.populateModelVariables("Tag Name", new HashMap<>(),
        mock(BroadleafTemplateContext.class)));
  }

  /**
   * Test {@link CreditCardTypesProcessor#populateModelVariables(String, Map, BroadleafTemplateContext)}.
   * <ul>
   *   <li>Then calls {@link ExtensionManager#getProxy()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CreditCardTypesProcessor#populateModelVariables(String, Map, BroadleafTemplateContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map CreditCardTypesProcessor.populateModelVariables(String, Map, BroadleafTemplateContext)"})
  public void testPopulateModelVariables_thenCallsGetProxy() {
    // Arrange
    CreditCardTypesExtensionHandler creditCardTypesExtensionHandler = mock(CreditCardTypesExtensionHandler.class);
    when(creditCardTypesExtensionHandler.populateCreditCardMap(Mockito.<Map<String, String>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(creditCardTypesExtensionManager.getProxy()).thenReturn(creditCardTypesExtensionHandler);

    // Act
    Map<String, Object> actualPopulateModelVariablesResult = creditCardTypesProcessor.populateModelVariables("Tag Name",
        new HashMap<>(), mock(BroadleafTemplateContext.class));

    // Assert
    verify(creditCardTypesExtensionManager).getProxy();
    verify(creditCardTypesExtensionHandler).populateCreditCardMap(isA(Map.class));
    assertNull(actualPopulateModelVariablesResult);
  }
}
