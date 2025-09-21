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
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Map;
import org.broadleafcommerce.common.extension.ExtensionResultStatusType;
import org.broadleafcommerce.common.payment.dto.PaymentRequestDTO;
import org.broadleafcommerce.common.vendor.service.exception.PaymentException;
import org.broadleafcommerce.presentation.model.BroadleafTemplateContext;
import org.broadleafcommerce.presentation.model.BroadleafTemplateModel;
import org.broadleafcommerce.presentation.model.BroadleafTemplateModelModifierDTO;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;

@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(MockitoJUnitRunner.class)
public class TransparentRedirectCreditCardFormProcessorDiffblueTest {
  @Mock private TRCreditCardExtensionManager tRCreditCardExtensionManager;

  @InjectMocks
  private TransparentRedirectCreditCardFormProcessor transparentRedirectCreditCardFormProcessor;

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link
   *       TransparentRedirectCreditCardFormProcessor#setExtensionManager(TRCreditCardExtensionManager)}
   *   <li>{@link TransparentRedirectCreditCardFormProcessor#getExtensionManager()}
   *   <li>{@link TransparentRedirectCreditCardFormProcessor#getName()}
   *   <li>{@link TransparentRedirectCreditCardFormProcessor#getPrecedence()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TRCreditCardExtensionManager TransparentRedirectCreditCardFormProcessor.getExtensionManager()",
    "String TransparentRedirectCreditCardFormProcessor.getName()",
    "int TransparentRedirectCreditCardFormProcessor.getPrecedence()",
    "void TransparentRedirectCreditCardFormProcessor.setExtensionManager(TRCreditCardExtensionManager)"
  })
  public void testGettersAndSetters() {
    // Arrange
    TransparentRedirectCreditCardFormProcessor transparentRedirectCreditCardFormProcessor =
        new TransparentRedirectCreditCardFormProcessor();
    TRCreditCardExtensionManager extensionManager = new TRCreditCardExtensionManager();

    // Act
    transparentRedirectCreditCardFormProcessor.setExtensionManager(extensionManager);
    TRCreditCardExtensionManager actualExtensionManager =
        transparentRedirectCreditCardFormProcessor.getExtensionManager();
    String actualName = transparentRedirectCreditCardFormProcessor.getName();

    // Assert
    assertEquals("transparent_credit_card_form", actualName);
    assertEquals(1, transparentRedirectCreditCardFormProcessor.getPrecedence());
    assertSame(extensionManager, actualExtensionManager);
  }

  /**
   * Test {@link TransparentRedirectCreditCardFormProcessor#getInjectedModelAndTagAttributes(String,
   * Map, BroadleafTemplateContext)}.
   *
   * <p>Method under test: {@link
   * TransparentRedirectCreditCardFormProcessor#getInjectedModelAndTagAttributes(String, Map,
   * BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BroadleafTemplateModelModifierDTO TransparentRedirectCreditCardFormProcessor.getInjectedModelAndTagAttributes(String, Map, BroadleafTemplateContext)"
  })
  public void testGetInjectedModelAndTagAttributes() {
    // Arrange
    HashMap<String, String> rootTagAttributes = new HashMap<>();

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.parseExpression(Mockito.<String>any())).thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            transparentRedirectCreditCardFormProcessor.getInjectedModelAndTagAttributes(
                "Root Tag Name", rootTagAttributes, context));
    verify(context).parseExpression(null);
  }

  /**
   * Test {@link TransparentRedirectCreditCardFormProcessor#getInjectedModelAndTagAttributes(String,
   * Map, BroadleafTemplateContext)}.
   *
   * <p>Method under test: {@link
   * TransparentRedirectCreditCardFormProcessor#getInjectedModelAndTagAttributes(String, Map,
   * BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BroadleafTemplateModelModifierDTO TransparentRedirectCreditCardFormProcessor.getInjectedModelAndTagAttributes(String, Map, BroadleafTemplateContext)"
  })
  public void testGetInjectedModelAndTagAttributes2() throws PaymentException {
    // Arrange
    TRCreditCardExtensionHandler trCreditCardExtensionHandler =
        mock(TRCreditCardExtensionHandler.class);
    when(trCreditCardExtensionHandler.createTransparentRedirectForm(
            Mockito.<Map<String, Map<String, String>>>any(),
            Mockito.<PaymentRequestDTO>any(),
            Mockito.<Map<String, String>>any()))
        .thenThrow(new PaymentException("An error occurred"));
    when(tRCreditCardExtensionManager.getProxy()).thenReturn(trCreditCardExtensionHandler);
    HashMap<String, String> rootTagAttributes = new HashMap<>();

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.parseExpression(Mockito.<String>any())).thenReturn(new PaymentRequestDTO());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            transparentRedirectCreditCardFormProcessor.getInjectedModelAndTagAttributes(
                "Root Tag Name", rootTagAttributes, context));
    verify(tRCreditCardExtensionManager).getProxy();
    verify(trCreditCardExtensionHandler)
        .createTransparentRedirectForm(
            isA(Map.class), isA(PaymentRequestDTO.class), isA(Map.class));
    verify(context).parseExpression(null);
  }

  /**
   * Test {@link TransparentRedirectCreditCardFormProcessor#getInjectedModelAndTagAttributes(String,
   * Map, BroadleafTemplateContext)}.
   *
   * <p>Method under test: {@link
   * TransparentRedirectCreditCardFormProcessor#getInjectedModelAndTagAttributes(String, Map,
   * BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BroadleafTemplateModelModifierDTO TransparentRedirectCreditCardFormProcessor.getInjectedModelAndTagAttributes(String, Map, BroadleafTemplateContext)"
  })
  public void testGetInjectedModelAndTagAttributes3() throws PaymentException {
    // Arrange
    TRCreditCardExtensionHandler trCreditCardExtensionHandler =
        mock(TRCreditCardExtensionHandler.class);
    when(trCreditCardExtensionHandler.createTransparentRedirectForm(
            Mockito.<Map<String, Map<String, String>>>any(),
            Mockito.<PaymentRequestDTO>any(),
            Mockito.<Map<String, String>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(trCreditCardExtensionHandler.setFormActionKey(Mockito.<StringBuilder>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(trCreditCardExtensionHandler.setFormHiddenParamsKey(Mockito.<StringBuilder>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(tRCreditCardExtensionManager.getProxy()).thenReturn(trCreditCardExtensionHandler);

    HashMap<String, String> rootTagAttributes = new HashMap<>();
    rootTagAttributes.put("paymentRequestDTO", "paymentRequestDTO");

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.parseExpression(Mockito.<String>any())).thenReturn(new PaymentRequestDTO());
    when(context.createModel()).thenReturn(mock(BroadleafTemplateModel.class));

    // Act
    BroadleafTemplateModelModifierDTO actualInjectedModelAndTagAttributes =
        transparentRedirectCreditCardFormProcessor.getInjectedModelAndTagAttributes(
            "Root Tag Name", rootTagAttributes, context);

    // Assert
    verify(tRCreditCardExtensionManager, atLeast(1)).getProxy();
    verify(trCreditCardExtensionHandler)
        .createTransparentRedirectForm(
            isA(Map.class), isA(PaymentRequestDTO.class), isA(Map.class));
    verify(trCreditCardExtensionHandler).setFormActionKey(isA(StringBuilder.class));
    verify(trCreditCardExtensionHandler).setFormHiddenParamsKey(isA(StringBuilder.class));
    verify(context).createModel();
    verify(context).parseExpression("paymentRequestDTO");
    Map<String, String> formParameters = actualInjectedModelAndTagAttributes.getFormParameters();
    assertEquals(1, formParameters.size());
    assertEquals("", formParameters.get("action"));
    assertEquals("form", actualInjectedModelAndTagAttributes.getReplacementTagName());
    assertTrue(actualInjectedModelAndTagAttributes.getFormLocalVariables().isEmpty());
  }

  /**
   * Test {@link TransparentRedirectCreditCardFormProcessor#getInjectedModelAndTagAttributes(String,
   * Map, BroadleafTemplateContext)}.
   *
   * <p>Method under test: {@link
   * TransparentRedirectCreditCardFormProcessor#getInjectedModelAndTagAttributes(String, Map,
   * BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BroadleafTemplateModelModifierDTO TransparentRedirectCreditCardFormProcessor.getInjectedModelAndTagAttributes(String, Map, BroadleafTemplateContext)"
  })
  public void testGetInjectedModelAndTagAttributes4() {
    // Arrange
    when(tRCreditCardExtensionManager.getProxy()).thenThrow(new RuntimeException());

    HashMap<String, String> rootTagAttributes = new HashMap<>();
    rootTagAttributes.put("paymentRequestDTO", "Root Tag Attributes");

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.parseExpression(Mockito.<String>any())).thenReturn(new PaymentRequestDTO());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            transparentRedirectCreditCardFormProcessor.getInjectedModelAndTagAttributes(
                "Root Tag Name", rootTagAttributes, context));
    verify(tRCreditCardExtensionManager).getProxy();
    verify(context).parseExpression("Root Tag Attributes");
  }

  /**
   * Test {@link TransparentRedirectCreditCardFormProcessor#getInjectedModelAndTagAttributes(String,
   * Map, BroadleafTemplateContext)}.
   *
   * <p>Method under test: {@link
   * TransparentRedirectCreditCardFormProcessor#getInjectedModelAndTagAttributes(String, Map,
   * BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BroadleafTemplateModelModifierDTO TransparentRedirectCreditCardFormProcessor.getInjectedModelAndTagAttributes(String, Map, BroadleafTemplateContext)"
  })
  public void testGetInjectedModelAndTagAttributes5() {
    // Arrange
    TransparentRedirectCreditCardFormProcessor transparentRedirectCreditCardFormProcessor =
        new TransparentRedirectCreditCardFormProcessor();
    transparentRedirectCreditCardFormProcessor.setExtensionManager(
        new TRCreditCardExtensionManager());
    HashMap<String, String> rootTagAttributes = new HashMap<>();

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.createModel()).thenThrow(new RuntimeException());
    when(context.parseExpression(Mockito.<String>any())).thenReturn(new PaymentRequestDTO());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            transparentRedirectCreditCardFormProcessor.getInjectedModelAndTagAttributes(
                "Root Tag Name", rootTagAttributes, context));
    verify(context).createModel();
    verify(context).parseExpression(null);
  }

  /**
   * Test {@link TransparentRedirectCreditCardFormProcessor#getInjectedModelAndTagAttributes(String,
   * Map, BroadleafTemplateContext)}.
   *
   * <ul>
   *   <li>Given {@code config-}.
   *   <li>When {@link HashMap#HashMap()} {@code config-} is {@code config-}.
   * </ul>
   *
   * <p>Method under test: {@link
   * TransparentRedirectCreditCardFormProcessor#getInjectedModelAndTagAttributes(String, Map,
   * BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BroadleafTemplateModelModifierDTO TransparentRedirectCreditCardFormProcessor.getInjectedModelAndTagAttributes(String, Map, BroadleafTemplateContext)"
  })
  public void testGetInjectedModelAndTagAttributes_givenConfig_whenHashMapConfigIsConfig()
      throws PaymentException {
    // Arrange
    TRCreditCardExtensionHandler trCreditCardExtensionHandler =
        mock(TRCreditCardExtensionHandler.class);
    when(trCreditCardExtensionHandler.createTransparentRedirectForm(
            Mockito.<Map<String, Map<String, String>>>any(),
            Mockito.<PaymentRequestDTO>any(),
            Mockito.<Map<String, String>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(trCreditCardExtensionHandler.setFormActionKey(Mockito.<StringBuilder>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(trCreditCardExtensionHandler.setFormHiddenParamsKey(Mockito.<StringBuilder>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(tRCreditCardExtensionManager.getProxy()).thenReturn(trCreditCardExtensionHandler);

    HashMap<String, String> rootTagAttributes = new HashMap<>();
    rootTagAttributes.put("config-", "config-");
    rootTagAttributes.put("paymentRequestDTO", "paymentRequestDTO");

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.parseExpression(Mockito.<String>any())).thenReturn(new PaymentRequestDTO());
    when(context.createModel()).thenReturn(mock(BroadleafTemplateModel.class));

    // Act
    BroadleafTemplateModelModifierDTO actualInjectedModelAndTagAttributes =
        transparentRedirectCreditCardFormProcessor.getInjectedModelAndTagAttributes(
            "Root Tag Name", rootTagAttributes, context);

    // Assert
    verify(tRCreditCardExtensionManager, atLeast(1)).getProxy();
    verify(trCreditCardExtensionHandler)
        .createTransparentRedirectForm(
            isA(Map.class), isA(PaymentRequestDTO.class), isA(Map.class));
    verify(trCreditCardExtensionHandler).setFormActionKey(isA(StringBuilder.class));
    verify(trCreditCardExtensionHandler).setFormHiddenParamsKey(isA(StringBuilder.class));
    verify(context).createModel();
    verify(context).parseExpression("paymentRequestDTO");
    Map<String, String> formParameters = actualInjectedModelAndTagAttributes.getFormParameters();
    assertEquals(1, formParameters.size());
    assertEquals("", formParameters.get("action"));
    assertEquals("form", actualInjectedModelAndTagAttributes.getReplacementTagName());
    assertTrue(actualInjectedModelAndTagAttributes.getFormLocalVariables().isEmpty());
  }

  /**
   * Test {@link TransparentRedirectCreditCardFormProcessor#getInjectedModelAndTagAttributes(String,
   * Map, BroadleafTemplateContext)}.
   *
   * <ul>
   *   <li>Then return FormParameters size is one.
   * </ul>
   *
   * <p>Method under test: {@link
   * TransparentRedirectCreditCardFormProcessor#getInjectedModelAndTagAttributes(String, Map,
   * BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BroadleafTemplateModelModifierDTO TransparentRedirectCreditCardFormProcessor.getInjectedModelAndTagAttributes(String, Map, BroadleafTemplateContext)"
  })
  public void testGetInjectedModelAndTagAttributes_thenReturnFormParametersSizeIsOne()
      throws PaymentException {
    // Arrange
    TRCreditCardExtensionHandler trCreditCardExtensionHandler =
        mock(TRCreditCardExtensionHandler.class);
    when(trCreditCardExtensionHandler.createTransparentRedirectForm(
            Mockito.<Map<String, Map<String, String>>>any(),
            Mockito.<PaymentRequestDTO>any(),
            Mockito.<Map<String, String>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(trCreditCardExtensionHandler.setFormActionKey(Mockito.<StringBuilder>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(trCreditCardExtensionHandler.setFormHiddenParamsKey(Mockito.<StringBuilder>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(tRCreditCardExtensionManager.getProxy()).thenReturn(trCreditCardExtensionHandler);
    HashMap<String, String> rootTagAttributes = new HashMap<>();

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.parseExpression(Mockito.<String>any())).thenReturn(new PaymentRequestDTO());
    when(context.createModel()).thenReturn(mock(BroadleafTemplateModel.class));

    // Act
    BroadleafTemplateModelModifierDTO actualInjectedModelAndTagAttributes =
        transparentRedirectCreditCardFormProcessor.getInjectedModelAndTagAttributes(
            "Root Tag Name", rootTagAttributes, context);

    // Assert
    verify(tRCreditCardExtensionManager, atLeast(1)).getProxy();
    verify(trCreditCardExtensionHandler)
        .createTransparentRedirectForm(
            isA(Map.class), isA(PaymentRequestDTO.class), isA(Map.class));
    verify(trCreditCardExtensionHandler).setFormActionKey(isA(StringBuilder.class));
    verify(trCreditCardExtensionHandler).setFormHiddenParamsKey(isA(StringBuilder.class));
    verify(context).createModel();
    verify(context).parseExpression(null);
    Map<String, String> formParameters = actualInjectedModelAndTagAttributes.getFormParameters();
    assertEquals(1, formParameters.size());
    assertEquals("", formParameters.get("action"));
    assertEquals("form", actualInjectedModelAndTagAttributes.getReplacementTagName());
    assertTrue(actualInjectedModelAndTagAttributes.getFormLocalVariables().isEmpty());
  }

  /**
   * Test {@link TransparentRedirectCreditCardFormProcessor#reprocessModel()}.
   *
   * <p>Method under test: {@link TransparentRedirectCreditCardFormProcessor#reprocessModel()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TransparentRedirectCreditCardFormProcessor.reprocessModel()"})
  public void testReprocessModel() {
    // Arrange, Act and Assert
    assertTrue(transparentRedirectCreditCardFormProcessor.reprocessModel());
  }
}
