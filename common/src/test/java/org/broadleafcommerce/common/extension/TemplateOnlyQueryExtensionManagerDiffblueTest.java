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
package org.broadleafcommerce.common.extension;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.TypedQuery;
import org.broadleafcommerce.common.util.BLCFieldUtils;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {TemplateOnlyQueryExtensionManager.class})
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(SpringJUnit4ClassRunner.class)
public class TemplateOnlyQueryExtensionManagerDiffblueTest {
  @Autowired private TemplateOnlyQueryExtensionManager templateOnlyQueryExtensionManager;

  /**
   * Test {@link TemplateOnlyQueryExtensionManager#refineQuery(Class, Object, TypedQuery)}.
   *
   * <p>Method under test: {@link TemplateOnlyQueryExtensionManager#refineQuery(Class, Object,
   * TypedQuery)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType TemplateOnlyQueryExtensionManager.refineQuery(Class, Object, TypedQuery)"
  })
  public void testRefineQuery() {
    // Arrange
    TemplateOnlyQueryExtensionManager templateOnlyQueryExtensionManager =
        new TemplateOnlyQueryExtensionManager();
    templateOnlyQueryExtensionManager.registerHandler(new TemplateOnlyQueryExtensionManager());
    Class<Object> type = Object.class;

    // Act and Assert
    assertEquals(
        ExtensionResultStatusType.NOT_HANDLED,
        templateOnlyQueryExtensionManager.refineQuery(type, BLCFieldUtils.NULL_FIELD, null));
  }

  /**
   * Test {@link TemplateOnlyQueryExtensionManager#refineQuery(Class, Object, TypedQuery)}.
   *
   * <p>Method under test: {@link TemplateOnlyQueryExtensionManager#refineQuery(Class, Object,
   * TypedQuery)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType TemplateOnlyQueryExtensionManager.refineQuery(Class, Object, TypedQuery)"
  })
  public void testRefineQuery2() {
    // Arrange
    TemplateOnlyQueryExtensionHandler templateOnlyQueryExtensionHandler =
        mock(TemplateOnlyQueryExtensionHandler.class);
    when(templateOnlyQueryExtensionHandler.refineQuery(
            Mockito.<Class<?>>any(), Mockito.<Object>any(), Mockito.<TypedQuery<Object>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED_STOP);
    when(templateOnlyQueryExtensionHandler.isEnabled()).thenReturn(true);

    TemplateOnlyQueryExtensionManager templateOnlyQueryExtensionManager =
        new TemplateOnlyQueryExtensionManager();
    templateOnlyQueryExtensionManager.registerHandler(templateOnlyQueryExtensionHandler);
    Class<Object> type = Object.class;

    // Act
    ExtensionResultStatusType actualRefineQueryResult =
        templateOnlyQueryExtensionManager.refineQuery(type, BLCFieldUtils.NULL_FIELD, null);

    // Assert
    verify(templateOnlyQueryExtensionHandler).isEnabled();
    verify(templateOnlyQueryExtensionHandler)
        .refineQuery(isA(Class.class), isA(Object.class), isNull());
    assertEquals(ExtensionResultStatusType.HANDLED, actualRefineQueryResult);
  }

  /**
   * Test {@link TemplateOnlyQueryExtensionManager#refineQuery(Class, Object, TypedQuery)}.
   *
   * <ul>
   *   <li>Given {@link TemplateOnlyQueryExtensionHandler} {@link
   *       TemplateOnlyQueryExtensionHandler#isEnabled()} return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link TemplateOnlyQueryExtensionManager#refineQuery(Class, Object,
   * TypedQuery)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType TemplateOnlyQueryExtensionManager.refineQuery(Class, Object, TypedQuery)"
  })
  public void testRefineQuery_givenTemplateOnlyQueryExtensionHandlerIsEnabledReturnFalse() {
    // Arrange
    TemplateOnlyQueryExtensionHandler templateOnlyQueryExtensionHandler =
        mock(TemplateOnlyQueryExtensionHandler.class);
    when(templateOnlyQueryExtensionHandler.isEnabled()).thenReturn(false);

    TemplateOnlyQueryExtensionManager templateOnlyQueryExtensionManager =
        new TemplateOnlyQueryExtensionManager();
    templateOnlyQueryExtensionManager.registerHandler(templateOnlyQueryExtensionHandler);
    Class<Object> type = Object.class;

    // Act
    ExtensionResultStatusType actualRefineQueryResult =
        templateOnlyQueryExtensionManager.refineQuery(type, BLCFieldUtils.NULL_FIELD, null);

    // Assert
    verify(templateOnlyQueryExtensionHandler).isEnabled();
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, actualRefineQueryResult);
  }

  /**
   * Test {@link TemplateOnlyQueryExtensionManager#refineQuery(Class, Object, TypedQuery)}.
   *
   * <ul>
   *   <li>Given {@link TemplateOnlyQueryExtensionHandler} {@link
   *       TemplateOnlyQueryExtensionHandler#refineQuery(Class, Object, TypedQuery)} return {@code
   *       HANDLED}.
   * </ul>
   *
   * <p>Method under test: {@link TemplateOnlyQueryExtensionManager#refineQuery(Class, Object,
   * TypedQuery)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType TemplateOnlyQueryExtensionManager.refineQuery(Class, Object, TypedQuery)"
  })
  public void testRefineQuery_givenTemplateOnlyQueryExtensionHandlerRefineQueryReturnHandled() {
    // Arrange
    TemplateOnlyQueryExtensionHandler templateOnlyQueryExtensionHandler =
        mock(TemplateOnlyQueryExtensionHandler.class);
    when(templateOnlyQueryExtensionHandler.refineQuery(
            Mockito.<Class<?>>any(), Mockito.<Object>any(), Mockito.<TypedQuery<Object>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(templateOnlyQueryExtensionHandler.isEnabled()).thenReturn(true);

    TemplateOnlyQueryExtensionManager templateOnlyQueryExtensionManager =
        new TemplateOnlyQueryExtensionManager();
    templateOnlyQueryExtensionManager.registerHandler(templateOnlyQueryExtensionHandler);
    Class<Object> type = Object.class;

    // Act
    ExtensionResultStatusType actualRefineQueryResult =
        templateOnlyQueryExtensionManager.refineQuery(type, BLCFieldUtils.NULL_FIELD, null);

    // Assert
    verify(templateOnlyQueryExtensionHandler).isEnabled();
    verify(templateOnlyQueryExtensionHandler)
        .refineQuery(isA(Class.class), isA(Object.class), isNull());
    assertEquals(ExtensionResultStatusType.HANDLED, actualRefineQueryResult);
  }

  /**
   * Test {@link TemplateOnlyQueryExtensionManager#refineQuery(Class, Object, TypedQuery)}.
   *
   * <ul>
   *   <li>Given {@link TemplateOnlyQueryExtensionManager}.
   *   <li>Then return {@code NOT_HANDLED}.
   * </ul>
   *
   * <p>Method under test: {@link TemplateOnlyQueryExtensionManager#refineQuery(Class, Object,
   * TypedQuery)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType TemplateOnlyQueryExtensionManager.refineQuery(Class, Object, TypedQuery)"
  })
  public void testRefineQuery_givenTemplateOnlyQueryExtensionManager_thenReturnNotHandled() {
    // Arrange
    Class<Object> type = Object.class;

    // Act and Assert
    assertEquals(
        ExtensionResultStatusType.NOT_HANDLED,
        templateOnlyQueryExtensionManager.refineQuery(type, BLCFieldUtils.NULL_FIELD, null));
  }

  /**
   * Test {@link TemplateOnlyQueryExtensionManager#setup(Class)}.
   *
   * <p>Method under test: {@link TemplateOnlyQueryExtensionManager#setup(Class)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ExtensionResultStatusType TemplateOnlyQueryExtensionManager.setup(Class)"})
  public void testSetup() {
    // Arrange
    TemplateOnlyQueryExtensionManager templateOnlyQueryExtensionManager =
        new TemplateOnlyQueryExtensionManager();
    templateOnlyQueryExtensionManager.registerHandler(new TemplateOnlyQueryExtensionManager());
    Class<Object> type = Object.class;

    // Act and Assert
    assertEquals(
        ExtensionResultStatusType.NOT_HANDLED, templateOnlyQueryExtensionManager.setup(type));
  }

  /**
   * Test {@link TemplateOnlyQueryExtensionManager#setup(Class)}.
   *
   * <ul>
   *   <li>Given {@link TemplateOnlyQueryExtensionHandler} {@link
   *       TemplateOnlyQueryExtensionHandler#isEnabled()} return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link TemplateOnlyQueryExtensionManager#setup(Class)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ExtensionResultStatusType TemplateOnlyQueryExtensionManager.setup(Class)"})
  public void testSetup_givenTemplateOnlyQueryExtensionHandlerIsEnabledReturnFalse() {
    // Arrange
    TemplateOnlyQueryExtensionHandler templateOnlyQueryExtensionHandler =
        mock(TemplateOnlyQueryExtensionHandler.class);
    when(templateOnlyQueryExtensionHandler.isEnabled()).thenReturn(false);

    TemplateOnlyQueryExtensionManager templateOnlyQueryExtensionManager =
        new TemplateOnlyQueryExtensionManager();
    templateOnlyQueryExtensionManager.registerHandler(templateOnlyQueryExtensionHandler);
    Class<Object> type = Object.class;

    // Act
    ExtensionResultStatusType actualSetupResult = templateOnlyQueryExtensionManager.setup(type);

    // Assert
    verify(templateOnlyQueryExtensionHandler).isEnabled();
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, actualSetupResult);
  }

  /**
   * Test {@link TemplateOnlyQueryExtensionManager#setup(Class)}.
   *
   * <ul>
   *   <li>Given {@link TemplateOnlyQueryExtensionHandler} {@link
   *       TemplateOnlyQueryExtensionHandler#setup(Class)} return {@code HANDLED}.
   * </ul>
   *
   * <p>Method under test: {@link TemplateOnlyQueryExtensionManager#setup(Class)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ExtensionResultStatusType TemplateOnlyQueryExtensionManager.setup(Class)"})
  public void testSetup_givenTemplateOnlyQueryExtensionHandlerSetupReturnHandled() {
    // Arrange
    TemplateOnlyQueryExtensionHandler templateOnlyQueryExtensionHandler =
        mock(TemplateOnlyQueryExtensionHandler.class);
    when(templateOnlyQueryExtensionHandler.setup(Mockito.<Class<?>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(templateOnlyQueryExtensionHandler.isEnabled()).thenReturn(true);

    TemplateOnlyQueryExtensionManager templateOnlyQueryExtensionManager =
        new TemplateOnlyQueryExtensionManager();
    templateOnlyQueryExtensionManager.registerHandler(templateOnlyQueryExtensionHandler);
    Class<Object> type = Object.class;

    // Act
    ExtensionResultStatusType actualSetupResult = templateOnlyQueryExtensionManager.setup(type);

    // Assert
    verify(templateOnlyQueryExtensionHandler).isEnabled();
    verify(templateOnlyQueryExtensionHandler).setup(isA(Class.class));
    assertEquals(ExtensionResultStatusType.HANDLED, actualSetupResult);
  }

  /**
   * Test {@link TemplateOnlyQueryExtensionManager#setup(Class)}.
   *
   * <ul>
   *   <li>Given {@link TemplateOnlyQueryExtensionHandler} {@link
   *       TemplateOnlyQueryExtensionHandler#setup(Class)} return {@code HANDLED_STOP}.
   * </ul>
   *
   * <p>Method under test: {@link TemplateOnlyQueryExtensionManager#setup(Class)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ExtensionResultStatusType TemplateOnlyQueryExtensionManager.setup(Class)"})
  public void testSetup_givenTemplateOnlyQueryExtensionHandlerSetupReturnHandledStop() {
    // Arrange
    TemplateOnlyQueryExtensionHandler templateOnlyQueryExtensionHandler =
        mock(TemplateOnlyQueryExtensionHandler.class);
    when(templateOnlyQueryExtensionHandler.setup(Mockito.<Class<?>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED_STOP);
    when(templateOnlyQueryExtensionHandler.isEnabled()).thenReturn(true);

    TemplateOnlyQueryExtensionManager templateOnlyQueryExtensionManager =
        new TemplateOnlyQueryExtensionManager();
    templateOnlyQueryExtensionManager.registerHandler(templateOnlyQueryExtensionHandler);
    Class<Object> type = Object.class;

    // Act
    ExtensionResultStatusType actualSetupResult = templateOnlyQueryExtensionManager.setup(type);

    // Assert
    verify(templateOnlyQueryExtensionHandler).isEnabled();
    verify(templateOnlyQueryExtensionHandler).setup(isA(Class.class));
    assertEquals(ExtensionResultStatusType.HANDLED, actualSetupResult);
  }

  /**
   * Test {@link TemplateOnlyQueryExtensionManager#setup(Class)}.
   *
   * <ul>
   *   <li>Given {@link TemplateOnlyQueryExtensionManager}.
   *   <li>Then return {@code NOT_HANDLED}.
   * </ul>
   *
   * <p>Method under test: {@link TemplateOnlyQueryExtensionManager#setup(Class)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ExtensionResultStatusType TemplateOnlyQueryExtensionManager.setup(Class)"})
  public void testSetup_givenTemplateOnlyQueryExtensionManager_thenReturnNotHandled() {
    // Arrange
    Class<Object> type = Object.class;

    // Act and Assert
    assertEquals(
        ExtensionResultStatusType.NOT_HANDLED, templateOnlyQueryExtensionManager.setup(type));
  }

  /**
   * Test {@link TemplateOnlyQueryExtensionManager#isEnabled()}.
   *
   * <p>Method under test: {@link TemplateOnlyQueryExtensionManager#isEnabled()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TemplateOnlyQueryExtensionManager.isEnabled()"})
  public void testIsEnabled() {
    // Arrange, Act and Assert
    assertTrue(new TemplateOnlyQueryExtensionManager().isEnabled());
  }

  /**
   * Test {@link TemplateOnlyQueryExtensionManager#breakdown(Class)}.
   *
   * <p>Method under test: {@link TemplateOnlyQueryExtensionManager#breakdown(Class)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType TemplateOnlyQueryExtensionManager.breakdown(Class)"
  })
  public void testBreakdown() {
    // Arrange
    Class<TemplateOnlyQueryExtensionHandler> type = TemplateOnlyQueryExtensionHandler.class;

    // Act and Assert
    assertEquals(
        ExtensionResultStatusType.NOT_HANDLED, templateOnlyQueryExtensionManager.breakdown(type));
  }

  /**
   * Test {@link TemplateOnlyQueryExtensionManager#breakdown(Class)}.
   *
   * <p>Method under test: {@link TemplateOnlyQueryExtensionManager#breakdown(Class)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType TemplateOnlyQueryExtensionManager.breakdown(Class)"
  })
  public void testBreakdown2() {
    // Arrange
    TemplateOnlyQueryExtensionManager templateOnlyQueryExtensionManager =
        new TemplateOnlyQueryExtensionManager();
    templateOnlyQueryExtensionManager.registerHandler(new TemplateOnlyQueryExtensionManager());
    Class<Object> type = Object.class;

    // Act and Assert
    assertEquals(
        ExtensionResultStatusType.NOT_HANDLED, templateOnlyQueryExtensionManager.breakdown(type));
  }

  /**
   * Test {@link TemplateOnlyQueryExtensionManager#breakdown(Class)}.
   *
   * <ul>
   *   <li>Given {@link TemplateOnlyQueryExtensionHandler} {@link
   *       TemplateOnlyQueryExtensionHandler#breakdown(Class)} return {@code HANDLED}.
   * </ul>
   *
   * <p>Method under test: {@link TemplateOnlyQueryExtensionManager#breakdown(Class)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType TemplateOnlyQueryExtensionManager.breakdown(Class)"
  })
  public void testBreakdown_givenTemplateOnlyQueryExtensionHandlerBreakdownReturnHandled() {
    // Arrange
    TemplateOnlyQueryExtensionHandler templateOnlyQueryExtensionHandler =
        mock(TemplateOnlyQueryExtensionHandler.class);
    when(templateOnlyQueryExtensionHandler.breakdown(Mockito.<Class<?>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(templateOnlyQueryExtensionHandler.isEnabled()).thenReturn(true);

    TemplateOnlyQueryExtensionManager templateOnlyQueryExtensionManager =
        new TemplateOnlyQueryExtensionManager();
    templateOnlyQueryExtensionManager.registerHandler(templateOnlyQueryExtensionHandler);
    Class<Object> type = Object.class;

    // Act
    ExtensionResultStatusType actualBreakdownResult =
        templateOnlyQueryExtensionManager.breakdown(type);

    // Assert
    verify(templateOnlyQueryExtensionHandler).isEnabled();
    verify(templateOnlyQueryExtensionHandler).breakdown(isA(Class.class));
    assertEquals(ExtensionResultStatusType.HANDLED, actualBreakdownResult);
  }

  /**
   * Test {@link TemplateOnlyQueryExtensionManager#breakdown(Class)}.
   *
   * <ul>
   *   <li>Given {@link TemplateOnlyQueryExtensionHandler} {@link
   *       TemplateOnlyQueryExtensionHandler#breakdown(Class)} return {@code HANDLED_STOP}.
   * </ul>
   *
   * <p>Method under test: {@link TemplateOnlyQueryExtensionManager#breakdown(Class)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType TemplateOnlyQueryExtensionManager.breakdown(Class)"
  })
  public void testBreakdown_givenTemplateOnlyQueryExtensionHandlerBreakdownReturnHandledStop() {
    // Arrange
    TemplateOnlyQueryExtensionHandler templateOnlyQueryExtensionHandler =
        mock(TemplateOnlyQueryExtensionHandler.class);
    when(templateOnlyQueryExtensionHandler.breakdown(Mockito.<Class<?>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED_STOP);
    when(templateOnlyQueryExtensionHandler.isEnabled()).thenReturn(true);

    TemplateOnlyQueryExtensionManager templateOnlyQueryExtensionManager =
        new TemplateOnlyQueryExtensionManager();
    templateOnlyQueryExtensionManager.registerHandler(templateOnlyQueryExtensionHandler);
    Class<Object> type = Object.class;

    // Act
    ExtensionResultStatusType actualBreakdownResult =
        templateOnlyQueryExtensionManager.breakdown(type);

    // Assert
    verify(templateOnlyQueryExtensionHandler).isEnabled();
    verify(templateOnlyQueryExtensionHandler).breakdown(isA(Class.class));
    assertEquals(ExtensionResultStatusType.HANDLED, actualBreakdownResult);
  }

  /**
   * Test {@link TemplateOnlyQueryExtensionManager#breakdown(Class)}.
   *
   * <ul>
   *   <li>Given {@link TemplateOnlyQueryExtensionHandler} {@link
   *       TemplateOnlyQueryExtensionHandler#isEnabled()} return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link TemplateOnlyQueryExtensionManager#breakdown(Class)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType TemplateOnlyQueryExtensionManager.breakdown(Class)"
  })
  public void testBreakdown_givenTemplateOnlyQueryExtensionHandlerIsEnabledReturnFalse() {
    // Arrange
    TemplateOnlyQueryExtensionHandler templateOnlyQueryExtensionHandler =
        mock(TemplateOnlyQueryExtensionHandler.class);
    when(templateOnlyQueryExtensionHandler.isEnabled()).thenReturn(false);

    TemplateOnlyQueryExtensionManager templateOnlyQueryExtensionManager =
        new TemplateOnlyQueryExtensionManager();
    templateOnlyQueryExtensionManager.registerHandler(templateOnlyQueryExtensionHandler);
    Class<Object> type = Object.class;

    // Act
    ExtensionResultStatusType actualBreakdownResult =
        templateOnlyQueryExtensionManager.breakdown(type);

    // Assert
    verify(templateOnlyQueryExtensionHandler).isEnabled();
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, actualBreakdownResult);
  }

  /**
   * Test {@link TemplateOnlyQueryExtensionManager#breakdown(Class)}.
   *
   * <ul>
   *   <li>Given {@link TemplateOnlyQueryExtensionManager}.
   *   <li>Then return {@code NOT_HANDLED}.
   * </ul>
   *
   * <p>Method under test: {@link TemplateOnlyQueryExtensionManager#breakdown(Class)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType TemplateOnlyQueryExtensionManager.breakdown(Class)"
  })
  public void testBreakdown_givenTemplateOnlyQueryExtensionManager_thenReturnNotHandled() {
    // Arrange
    Class<Object> type = Object.class;

    // Act and Assert
    assertEquals(
        ExtensionResultStatusType.NOT_HANDLED, templateOnlyQueryExtensionManager.breakdown(type));
  }

  /**
   * Test {@link TemplateOnlyQueryExtensionManager#isValidState(ExtensionResultHolder)}.
   *
   * <p>Method under test: {@link
   * TemplateOnlyQueryExtensionManager#isValidState(ExtensionResultHolder)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType TemplateOnlyQueryExtensionManager.isValidState(ExtensionResultHolder)"
  })
  public void testIsValidState() {
    // Arrange
    TemplateOnlyQueryExtensionManager templateOnlyQueryExtensionManager =
        new TemplateOnlyQueryExtensionManager();
    templateOnlyQueryExtensionManager.registerHandler(new TemplateOnlyQueryExtensionManager());

    ExtensionResultHolder<Boolean> response = new ExtensionResultHolder<>();
    response.setResult(true);
    response.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(
        ExtensionResultStatusType.NOT_HANDLED,
        templateOnlyQueryExtensionManager.isValidState(response));
  }

  /**
   * Test {@link TemplateOnlyQueryExtensionManager#isValidState(ExtensionResultHolder)}.
   *
   * <p>Method under test: {@link
   * TemplateOnlyQueryExtensionManager#isValidState(ExtensionResultHolder)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType TemplateOnlyQueryExtensionManager.isValidState(ExtensionResultHolder)"
  })
  public void testIsValidState2() {
    // Arrange
    TemplateOnlyQueryExtensionHandler templateOnlyQueryExtensionHandler =
        mock(TemplateOnlyQueryExtensionHandler.class);
    when(templateOnlyQueryExtensionHandler.isValidState(
            Mockito.<ExtensionResultHolder<Boolean>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED_STOP);
    when(templateOnlyQueryExtensionHandler.isEnabled()).thenReturn(true);

    TemplateOnlyQueryExtensionManager templateOnlyQueryExtensionManager =
        new TemplateOnlyQueryExtensionManager();
    templateOnlyQueryExtensionManager.registerHandler(templateOnlyQueryExtensionHandler);

    ExtensionResultHolder<Boolean> response = new ExtensionResultHolder<>();
    response.setResult(true);
    response.setThrowable(new Throwable());

    // Act
    ExtensionResultStatusType actualIsValidStateResult =
        templateOnlyQueryExtensionManager.isValidState(response);

    // Assert
    verify(templateOnlyQueryExtensionHandler).isEnabled();
    verify(templateOnlyQueryExtensionHandler).isValidState(isA(ExtensionResultHolder.class));
    assertEquals(ExtensionResultStatusType.HANDLED, actualIsValidStateResult);
  }

  /**
   * Test {@link TemplateOnlyQueryExtensionManager#isValidState(ExtensionResultHolder)}.
   *
   * <ul>
   *   <li>Given {@link TemplateOnlyQueryExtensionHandler} {@link
   *       TemplateOnlyQueryExtensionHandler#isEnabled()} return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link
   * TemplateOnlyQueryExtensionManager#isValidState(ExtensionResultHolder)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType TemplateOnlyQueryExtensionManager.isValidState(ExtensionResultHolder)"
  })
  public void testIsValidState_givenTemplateOnlyQueryExtensionHandlerIsEnabledReturnFalse() {
    // Arrange
    TemplateOnlyQueryExtensionHandler templateOnlyQueryExtensionHandler =
        mock(TemplateOnlyQueryExtensionHandler.class);
    when(templateOnlyQueryExtensionHandler.isEnabled()).thenReturn(false);

    TemplateOnlyQueryExtensionManager templateOnlyQueryExtensionManager =
        new TemplateOnlyQueryExtensionManager();
    templateOnlyQueryExtensionManager.registerHandler(templateOnlyQueryExtensionHandler);

    ExtensionResultHolder<Boolean> response = new ExtensionResultHolder<>();
    response.setResult(true);
    response.setThrowable(new Throwable());

    // Act
    ExtensionResultStatusType actualIsValidStateResult =
        templateOnlyQueryExtensionManager.isValidState(response);

    // Assert
    verify(templateOnlyQueryExtensionHandler).isEnabled();
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, actualIsValidStateResult);
  }

  /**
   * Test {@link TemplateOnlyQueryExtensionManager#isValidState(ExtensionResultHolder)}.
   *
   * <ul>
   *   <li>Given {@link TemplateOnlyQueryExtensionHandler} {@link
   *       TemplateOnlyQueryExtensionHandler#isValidState(ExtensionResultHolder)} return {@code
   *       HANDLED}.
   * </ul>
   *
   * <p>Method under test: {@link
   * TemplateOnlyQueryExtensionManager#isValidState(ExtensionResultHolder)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType TemplateOnlyQueryExtensionManager.isValidState(ExtensionResultHolder)"
  })
  public void testIsValidState_givenTemplateOnlyQueryExtensionHandlerIsValidStateReturnHandled() {
    // Arrange
    TemplateOnlyQueryExtensionHandler templateOnlyQueryExtensionHandler =
        mock(TemplateOnlyQueryExtensionHandler.class);
    when(templateOnlyQueryExtensionHandler.isValidState(
            Mockito.<ExtensionResultHolder<Boolean>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(templateOnlyQueryExtensionHandler.isEnabled()).thenReturn(true);

    TemplateOnlyQueryExtensionManager templateOnlyQueryExtensionManager =
        new TemplateOnlyQueryExtensionManager();
    templateOnlyQueryExtensionManager.registerHandler(templateOnlyQueryExtensionHandler);

    ExtensionResultHolder<Boolean> response = new ExtensionResultHolder<>();
    response.setResult(true);
    response.setThrowable(new Throwable());

    // Act
    ExtensionResultStatusType actualIsValidStateResult =
        templateOnlyQueryExtensionManager.isValidState(response);

    // Assert
    verify(templateOnlyQueryExtensionHandler).isEnabled();
    verify(templateOnlyQueryExtensionHandler).isValidState(isA(ExtensionResultHolder.class));
    assertEquals(ExtensionResultStatusType.HANDLED, actualIsValidStateResult);
  }

  /**
   * Test {@link TemplateOnlyQueryExtensionManager#isValidState(ExtensionResultHolder)}.
   *
   * <ul>
   *   <li>Given {@link TemplateOnlyQueryExtensionManager}.
   *   <li>Then return {@code NOT_HANDLED}.
   * </ul>
   *
   * <p>Method under test: {@link
   * TemplateOnlyQueryExtensionManager#isValidState(ExtensionResultHolder)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType TemplateOnlyQueryExtensionManager.isValidState(ExtensionResultHolder)"
  })
  public void testIsValidState_givenTemplateOnlyQueryExtensionManager_thenReturnNotHandled() {
    // Arrange
    ExtensionResultHolder<Boolean> response = new ExtensionResultHolder<>();
    response.setResult(true);
    response.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(
        ExtensionResultStatusType.NOT_HANDLED,
        templateOnlyQueryExtensionManager.isValidState(response));
  }

  /**
   * Test {@link TemplateOnlyQueryExtensionManager#buildStatus(Object, ExtensionResultHolder)}.
   *
   * <p>Method under test: {@link TemplateOnlyQueryExtensionManager#buildStatus(Object,
   * ExtensionResultHolder)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType TemplateOnlyQueryExtensionManager.buildStatus(Object, ExtensionResultHolder)"
  })
  public void testBuildStatus() {
    // Arrange
    TemplateOnlyQueryExtensionManager templateOnlyQueryExtensionManager =
        new TemplateOnlyQueryExtensionManager();
    templateOnlyQueryExtensionManager.registerHandler(new TemplateOnlyQueryExtensionManager());

    ExtensionResultHolder<ItemStatus> response = new ExtensionResultHolder<>();
    response.setResult(ItemStatus.DELETED);
    response.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(
        ExtensionResultStatusType.NOT_HANDLED,
        templateOnlyQueryExtensionManager.buildStatus(BLCFieldUtils.NULL_FIELD, response));
  }

  /**
   * Test {@link TemplateOnlyQueryExtensionManager#buildStatus(Object, ExtensionResultHolder)}.
   *
   * <p>Method under test: {@link TemplateOnlyQueryExtensionManager#buildStatus(Object,
   * ExtensionResultHolder)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType TemplateOnlyQueryExtensionManager.buildStatus(Object, ExtensionResultHolder)"
  })
  public void testBuildStatus2() {
    // Arrange
    TemplateOnlyQueryExtensionHandler templateOnlyQueryExtensionHandler =
        mock(TemplateOnlyQueryExtensionHandler.class);
    when(templateOnlyQueryExtensionHandler.buildStatus(
            Mockito.<Object>any(), Mockito.<ExtensionResultHolder<ItemStatus>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED_STOP);
    when(templateOnlyQueryExtensionHandler.isEnabled()).thenReturn(true);

    TemplateOnlyQueryExtensionManager templateOnlyQueryExtensionManager =
        new TemplateOnlyQueryExtensionManager();
    templateOnlyQueryExtensionManager.registerHandler(templateOnlyQueryExtensionHandler);

    ExtensionResultHolder<ItemStatus> response = new ExtensionResultHolder<>();
    response.setResult(ItemStatus.DELETED);
    response.setThrowable(new Throwable());

    // Act
    ExtensionResultStatusType actualBuildStatusResult =
        templateOnlyQueryExtensionManager.buildStatus(BLCFieldUtils.NULL_FIELD, response);

    // Assert
    verify(templateOnlyQueryExtensionHandler).isEnabled();
    verify(templateOnlyQueryExtensionHandler)
        .buildStatus(isA(Object.class), isA(ExtensionResultHolder.class));
    assertEquals(ExtensionResultStatusType.HANDLED, actualBuildStatusResult);
  }

  /**
   * Test {@link TemplateOnlyQueryExtensionManager#buildStatus(Object, ExtensionResultHolder)}.
   *
   * <ul>
   *   <li>Given {@link TemplateOnlyQueryExtensionHandler} {@link
   *       TemplateOnlyQueryExtensionHandler#buildStatus(Object, ExtensionResultHolder)} return
   *       {@code HANDLED}.
   * </ul>
   *
   * <p>Method under test: {@link TemplateOnlyQueryExtensionManager#buildStatus(Object,
   * ExtensionResultHolder)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType TemplateOnlyQueryExtensionManager.buildStatus(Object, ExtensionResultHolder)"
  })
  public void testBuildStatus_givenTemplateOnlyQueryExtensionHandlerBuildStatusReturnHandled() {
    // Arrange
    TemplateOnlyQueryExtensionHandler templateOnlyQueryExtensionHandler =
        mock(TemplateOnlyQueryExtensionHandler.class);
    when(templateOnlyQueryExtensionHandler.buildStatus(
            Mockito.<Object>any(), Mockito.<ExtensionResultHolder<ItemStatus>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(templateOnlyQueryExtensionHandler.isEnabled()).thenReturn(true);

    TemplateOnlyQueryExtensionManager templateOnlyQueryExtensionManager =
        new TemplateOnlyQueryExtensionManager();
    templateOnlyQueryExtensionManager.registerHandler(templateOnlyQueryExtensionHandler);

    ExtensionResultHolder<ItemStatus> response = new ExtensionResultHolder<>();
    response.setResult(ItemStatus.DELETED);
    response.setThrowable(new Throwable());

    // Act
    ExtensionResultStatusType actualBuildStatusResult =
        templateOnlyQueryExtensionManager.buildStatus(BLCFieldUtils.NULL_FIELD, response);

    // Assert
    verify(templateOnlyQueryExtensionHandler).isEnabled();
    verify(templateOnlyQueryExtensionHandler)
        .buildStatus(isA(Object.class), isA(ExtensionResultHolder.class));
    assertEquals(ExtensionResultStatusType.HANDLED, actualBuildStatusResult);
  }

  /**
   * Test {@link TemplateOnlyQueryExtensionManager#buildStatus(Object, ExtensionResultHolder)}.
   *
   * <ul>
   *   <li>Given {@link TemplateOnlyQueryExtensionHandler} {@link
   *       TemplateOnlyQueryExtensionHandler#isEnabled()} return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link TemplateOnlyQueryExtensionManager#buildStatus(Object,
   * ExtensionResultHolder)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType TemplateOnlyQueryExtensionManager.buildStatus(Object, ExtensionResultHolder)"
  })
  public void testBuildStatus_givenTemplateOnlyQueryExtensionHandlerIsEnabledReturnFalse() {
    // Arrange
    TemplateOnlyQueryExtensionHandler templateOnlyQueryExtensionHandler =
        mock(TemplateOnlyQueryExtensionHandler.class);
    when(templateOnlyQueryExtensionHandler.isEnabled()).thenReturn(false);

    TemplateOnlyQueryExtensionManager templateOnlyQueryExtensionManager =
        new TemplateOnlyQueryExtensionManager();
    templateOnlyQueryExtensionManager.registerHandler(templateOnlyQueryExtensionHandler);

    ExtensionResultHolder<ItemStatus> response = new ExtensionResultHolder<>();
    response.setResult(ItemStatus.DELETED);
    response.setThrowable(new Throwable());

    // Act
    ExtensionResultStatusType actualBuildStatusResult =
        templateOnlyQueryExtensionManager.buildStatus(BLCFieldUtils.NULL_FIELD, response);

    // Assert
    verify(templateOnlyQueryExtensionHandler).isEnabled();
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, actualBuildStatusResult);
  }

  /**
   * Test {@link TemplateOnlyQueryExtensionManager#buildStatus(Object, ExtensionResultHolder)}.
   *
   * <ul>
   *   <li>Given {@link TemplateOnlyQueryExtensionManager}.
   *   <li>Then return {@code NOT_HANDLED}.
   * </ul>
   *
   * <p>Method under test: {@link TemplateOnlyQueryExtensionManager#buildStatus(Object,
   * ExtensionResultHolder)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType TemplateOnlyQueryExtensionManager.buildStatus(Object, ExtensionResultHolder)"
  })
  public void testBuildStatus_givenTemplateOnlyQueryExtensionManager_thenReturnNotHandled() {
    // Arrange
    ExtensionResultHolder<ItemStatus> response = new ExtensionResultHolder<>();
    response.setResult(ItemStatus.DELETED);
    response.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(
        ExtensionResultStatusType.NOT_HANDLED,
        templateOnlyQueryExtensionManager.buildStatus(BLCFieldUtils.NULL_FIELD, response));
  }

  /**
   * Test {@link TemplateOnlyQueryExtensionManager#filterResults(Class, Object, List)}.
   *
   * <p>Method under test: {@link TemplateOnlyQueryExtensionManager#filterResults(Class, Object,
   * List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType TemplateOnlyQueryExtensionManager.filterResults(Class, Object, List)"
  })
  public void testFilterResults() {
    // Arrange
    TemplateOnlyQueryExtensionManager templateOnlyQueryExtensionManager =
        new TemplateOnlyQueryExtensionManager();
    templateOnlyQueryExtensionManager.registerHandler(new TemplateOnlyQueryExtensionManager());
    Class<Object> type = Object.class;

    // Act and Assert
    assertEquals(
        ExtensionResultStatusType.NOT_HANDLED,
        templateOnlyQueryExtensionManager.filterResults(
            type, BLCFieldUtils.NULL_FIELD, new ArrayList<>()));
  }

  /**
   * Test {@link TemplateOnlyQueryExtensionManager#filterResults(Class, Object, List)}.
   *
   * <p>Method under test: {@link TemplateOnlyQueryExtensionManager#filterResults(Class, Object,
   * List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType TemplateOnlyQueryExtensionManager.filterResults(Class, Object, List)"
  })
  public void testFilterResults2() {
    // Arrange
    TemplateOnlyQueryExtensionHandler templateOnlyQueryExtensionHandler =
        mock(TemplateOnlyQueryExtensionHandler.class);
    when(templateOnlyQueryExtensionHandler.filterResults(
            Mockito.<Class<?>>any(), Mockito.<Object>any(), Mockito.<List<Object>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(templateOnlyQueryExtensionHandler.isEnabled()).thenReturn(true);

    TemplateOnlyQueryExtensionManager templateOnlyQueryExtensionManager =
        new TemplateOnlyQueryExtensionManager();
    templateOnlyQueryExtensionManager.registerHandler(templateOnlyQueryExtensionHandler);
    Class<Object> type = Object.class;

    // Act
    ExtensionResultStatusType actualFilterResultsResult =
        templateOnlyQueryExtensionManager.filterResults(
            type, BLCFieldUtils.NULL_FIELD, new ArrayList<>());

    // Assert
    verify(templateOnlyQueryExtensionHandler).isEnabled();
    verify(templateOnlyQueryExtensionHandler)
        .filterResults(isA(Class.class), isA(Object.class), isA(List.class));
    assertEquals(ExtensionResultStatusType.HANDLED, actualFilterResultsResult);
  }

  /**
   * Test {@link TemplateOnlyQueryExtensionManager#filterResults(Class, Object, List)}.
   *
   * <p>Method under test: {@link TemplateOnlyQueryExtensionManager#filterResults(Class, Object,
   * List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType TemplateOnlyQueryExtensionManager.filterResults(Class, Object, List)"
  })
  public void testFilterResults3() {
    // Arrange
    TemplateOnlyQueryExtensionHandler templateOnlyQueryExtensionHandler =
        mock(TemplateOnlyQueryExtensionHandler.class);
    when(templateOnlyQueryExtensionHandler.filterResults(
            Mockito.<Class<?>>any(), Mockito.<Object>any(), Mockito.<List<Object>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED_STOP);
    when(templateOnlyQueryExtensionHandler.isEnabled()).thenReturn(true);

    TemplateOnlyQueryExtensionManager templateOnlyQueryExtensionManager =
        new TemplateOnlyQueryExtensionManager();
    templateOnlyQueryExtensionManager.registerHandler(templateOnlyQueryExtensionHandler);
    Class<Object> type = Object.class;

    // Act
    ExtensionResultStatusType actualFilterResultsResult =
        templateOnlyQueryExtensionManager.filterResults(
            type, BLCFieldUtils.NULL_FIELD, new ArrayList<>());

    // Assert
    verify(templateOnlyQueryExtensionHandler).isEnabled();
    verify(templateOnlyQueryExtensionHandler)
        .filterResults(isA(Class.class), isA(Object.class), isA(List.class));
    assertEquals(ExtensionResultStatusType.HANDLED, actualFilterResultsResult);
  }

  /**
   * Test {@link TemplateOnlyQueryExtensionManager#filterResults(Class, Object, List)}.
   *
   * <ul>
   *   <li>Given {@link BLCFieldUtils#NULL_FIELD}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link BLCFieldUtils#NULL_FIELD}.
   * </ul>
   *
   * <p>Method under test: {@link TemplateOnlyQueryExtensionManager#filterResults(Class, Object,
   * List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType TemplateOnlyQueryExtensionManager.filterResults(Class, Object, List)"
  })
  public void testFilterResults_givenNull_field_whenArrayListAddNull_field() {
    // Arrange
    Class<Object> type = Object.class;

    ArrayList<Object> results = new ArrayList<>();
    results.add(BLCFieldUtils.NULL_FIELD);

    // Act and Assert
    assertEquals(
        ExtensionResultStatusType.NOT_HANDLED,
        templateOnlyQueryExtensionManager.filterResults(type, BLCFieldUtils.NULL_FIELD, results));
  }

  /**
   * Test {@link TemplateOnlyQueryExtensionManager#filterResults(Class, Object, List)}.
   *
   * <ul>
   *   <li>Given {@link BLCFieldUtils#NULL_FIELD}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link BLCFieldUtils#NULL_FIELD}.
   * </ul>
   *
   * <p>Method under test: {@link TemplateOnlyQueryExtensionManager#filterResults(Class, Object,
   * List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType TemplateOnlyQueryExtensionManager.filterResults(Class, Object, List)"
  })
  public void testFilterResults_givenNull_field_whenArrayListAddNull_field2() {
    // Arrange
    Class<Object> type = Object.class;

    ArrayList<Object> results = new ArrayList<>();
    results.add(BLCFieldUtils.NULL_FIELD);
    results.add(BLCFieldUtils.NULL_FIELD);

    // Act and Assert
    assertEquals(
        ExtensionResultStatusType.NOT_HANDLED,
        templateOnlyQueryExtensionManager.filterResults(type, BLCFieldUtils.NULL_FIELD, results));
  }

  /**
   * Test {@link TemplateOnlyQueryExtensionManager#filterResults(Class, Object, List)}.
   *
   * <ul>
   *   <li>Given {@link TemplateOnlyQueryExtensionHandler} {@link
   *       TemplateOnlyQueryExtensionHandler#isEnabled()} return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link TemplateOnlyQueryExtensionManager#filterResults(Class, Object,
   * List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType TemplateOnlyQueryExtensionManager.filterResults(Class, Object, List)"
  })
  public void testFilterResults_givenTemplateOnlyQueryExtensionHandlerIsEnabledReturnFalse() {
    // Arrange
    TemplateOnlyQueryExtensionHandler templateOnlyQueryExtensionHandler =
        mock(TemplateOnlyQueryExtensionHandler.class);
    when(templateOnlyQueryExtensionHandler.isEnabled()).thenReturn(false);

    TemplateOnlyQueryExtensionManager templateOnlyQueryExtensionManager =
        new TemplateOnlyQueryExtensionManager();
    templateOnlyQueryExtensionManager.registerHandler(templateOnlyQueryExtensionHandler);
    Class<Object> type = Object.class;

    // Act
    ExtensionResultStatusType actualFilterResultsResult =
        templateOnlyQueryExtensionManager.filterResults(
            type, BLCFieldUtils.NULL_FIELD, new ArrayList<>());

    // Assert
    verify(templateOnlyQueryExtensionHandler).isEnabled();
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, actualFilterResultsResult);
  }

  /**
   * Test {@link TemplateOnlyQueryExtensionManager#filterResults(Class, Object, List)}.
   *
   * <ul>
   *   <li>Given {@link TemplateOnlyQueryExtensionManager}.
   *   <li>Then return {@code NOT_HANDLED}.
   * </ul>
   *
   * <p>Method under test: {@link TemplateOnlyQueryExtensionManager#filterResults(Class, Object,
   * List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType TemplateOnlyQueryExtensionManager.filterResults(Class, Object, List)"
  })
  public void testFilterResults_givenTemplateOnlyQueryExtensionManager_thenReturnNotHandled() {
    // Arrange
    Class<Object> type = Object.class;

    // Act and Assert
    assertEquals(
        ExtensionResultStatusType.NOT_HANDLED,
        templateOnlyQueryExtensionManager.filterResults(
            type, BLCFieldUtils.NULL_FIELD, new ArrayList<>()));
  }
}
