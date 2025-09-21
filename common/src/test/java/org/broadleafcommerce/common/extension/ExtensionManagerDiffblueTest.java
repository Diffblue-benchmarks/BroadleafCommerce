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
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import org.broadleafcommerce.common.breadcrumbs.service.BreadcrumbServiceExtensionHandler;
import org.broadleafcommerce.common.breadcrumbs.service.BreadcrumbServiceExtensionManager;
import org.broadleafcommerce.common.copy.AbstractMultiTenantCopierExtensionHandler;
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

@ContextConfiguration(classes = {BreadcrumbServiceExtensionManager.class})
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(SpringJUnit4ClassRunner.class)
public class ExtensionManagerDiffblueTest {
  @Autowired private ExtensionManager<BreadcrumbServiceExtensionHandler> extensionManager;

  /**
   * Test {@link ExtensionManager#getProxy()}.
   *
   * <p>Method under test: {@link ExtensionManager#getProxy()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ExtensionHandler ExtensionManager.getProxy()"})
  public void testGetProxy() {
    // Arrange and Act
    BreadcrumbServiceExtensionHandler actualProxy = extensionManager.getProxy();

    // Assert
    assertSame(extensionManager.extensionHandler, actualProxy);
  }

  /**
   * Test {@link ExtensionManager#getHandlers()}.
   *
   * <p>Method under test: {@link ExtensionManager#getHandlers()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List ExtensionManager.getHandlers()"})
  public void testGetHandlers() {
    // Arrange, Act and Assert
    assertTrue(extensionManager.getHandlers().isEmpty());
  }

  /**
   * Test {@link ExtensionManager#registerHandler(ExtensionHandler)}.
   *
   * <ul>
   *   <li>Given {@link ExtensionManager}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ExtensionManager#registerHandler(ExtensionHandler)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ExtensionManager.registerHandler(ExtensionHandler)"})
  public void testRegisterHandler_givenExtensionManager_thenReturnTrue() {
    // Arrange
    BreadcrumbServiceExtensionHandler breadcrumbServiceExtensionHandler =
        mock(BreadcrumbServiceExtensionHandler.class);

    // Act
    boolean actualRegisterHandlerResult =
        extensionManager.registerHandler(breadcrumbServiceExtensionHandler);

    // Assert
    assertTrue(extensionManager instanceof BreadcrumbServiceExtensionManager);
    List<BreadcrumbServiceExtensionHandler> handlers = extensionManager.getHandlers();
    assertEquals(1, handlers.size());
    List<BreadcrumbServiceExtensionHandler> breadcrumbServiceExtensionHandlerList =
        ((BreadcrumbServiceExtensionManager) extensionManager).handlers;
    assertEquals(1, breadcrumbServiceExtensionHandlerList.size());
    assertTrue(actualRegisterHandlerResult);
    assertSame(extensionManager.handlers, handlers);
    assertSame(breadcrumbServiceExtensionHandler, handlers.get(0));
    assertSame(breadcrumbServiceExtensionHandler, breadcrumbServiceExtensionHandlerList.get(0));
  }

  /**
   * Test {@link ExtensionManager#registerHandler(ExtensionHandler)}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ExtensionManager#registerHandler(ExtensionHandler)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ExtensionManager.registerHandler(ExtensionHandler)"})
  public void testRegisterHandler_thenReturnFalse() {
    // Arrange
    ArrayList<BreadcrumbServiceExtensionHandler> handlers = new ArrayList<>();
    handlers.add(mock(BreadcrumbServiceExtensionHandler.class));
    extensionManager.setHandlers(handlers);

    // Act
    boolean actualRegisterHandlerResult =
        extensionManager.registerHandler(mock(BreadcrumbServiceExtensionHandler.class));

    // Assert
    assertTrue(extensionManager instanceof BreadcrumbServiceExtensionManager);
    List<BreadcrumbServiceExtensionHandler> handlers2 = extensionManager.getHandlers();
    assertEquals(1, handlers2.size());
    List<BreadcrumbServiceExtensionHandler> breadcrumbServiceExtensionHandlerList =
        ((BreadcrumbServiceExtensionManager) extensionManager).handlers;
    assertEquals(1, breadcrumbServiceExtensionHandlerList.size());
    assertFalse(actualRegisterHandlerResult);
    assertSame(handlers, handlers2);
    assertSame(handlers2.get(0), breadcrumbServiceExtensionHandlerList.get(0));
  }

  /**
   * Test {@link ExtensionManager#setHandlers(List)}.
   *
   * <ul>
   *   <li>Then {@link ExtensionManager} {@link ExtensionManager#handlers} size is one.
   * </ul>
   *
   * <p>Method under test: {@link ExtensionManager#setHandlers(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ExtensionManager.setHandlers(List)"})
  public void testSetHandlers_thenExtensionManagerHandlersSizeIsOne() {
    // Arrange
    ArrayList<BreadcrumbServiceExtensionHandler> handlers = new ArrayList<>();
    handlers.add(mock(BreadcrumbServiceExtensionHandler.class));

    // Act
    extensionManager.setHandlers(handlers);

    // Assert
    assertTrue(extensionManager instanceof BreadcrumbServiceExtensionManager);
    assertEquals(1, ((BreadcrumbServiceExtensionManager) extensionManager).handlers.size());
    assertSame(handlers, extensionManager.getHandlers());
  }

  /**
   * Test {@link ExtensionManager#setHandlers(List)}.
   *
   * <ul>
   *   <li>Then {@link ExtensionManager} {@link ExtensionManager#handlers} size is two.
   * </ul>
   *
   * <p>Method under test: {@link ExtensionManager#setHandlers(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ExtensionManager.setHandlers(List)"})
  public void testSetHandlers_thenExtensionManagerHandlersSizeIsTwo() {
    // Arrange
    ArrayList<BreadcrumbServiceExtensionHandler> handlers = new ArrayList<>();
    handlers.add(mock(BreadcrumbServiceExtensionHandler.class));
    handlers.add(mock(BreadcrumbServiceExtensionHandler.class));

    // Act
    extensionManager.setHandlers(handlers);

    // Assert
    assertTrue(extensionManager instanceof BreadcrumbServiceExtensionManager);
    assertEquals(2, ((BreadcrumbServiceExtensionManager) extensionManager).handlers.size());
    assertSame(handlers, extensionManager.getHandlers());
  }

  /**
   * Test {@link ExtensionManager#setHandlers(List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then {@link ExtensionManager} {@link ExtensionManager#handlers} Empty.
   * </ul>
   *
   * <p>Method under test: {@link ExtensionManager#setHandlers(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ExtensionManager.setHandlers(List)"})
  public void testSetHandlers_whenArrayList_thenExtensionManagerHandlersEmpty() {
    // Arrange
    ArrayList<BreadcrumbServiceExtensionHandler> handlers = new ArrayList<>();

    // Act
    extensionManager.setHandlers(handlers);

    // Assert
    assertTrue(extensionManager instanceof BreadcrumbServiceExtensionManager);
    assertTrue(((BreadcrumbServiceExtensionManager) extensionManager).handlers.isEmpty());
    assertSame(handlers, extensionManager.getHandlers());
  }

  /**
   * Test {@link ExtensionManager#shouldContinue(ExtensionResultStatusType, ExtensionHandler,
   * Method, Object[])}.
   *
   * <ul>
   *   <li>When {@link AbstractMultiTenantCopierExtensionHandler} (default constructor).
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ExtensionManager#shouldContinue(ExtensionResultStatusType,
   * ExtensionHandler, Method, Object[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ExtensionManager.shouldContinue(ExtensionResultStatusType, ExtensionHandler, Method, Object[])"
  })
  public void testShouldContinue_whenAbstractMultiTenantCopierExtensionHandler_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(
        extensionManager.shouldContinue(
            null,
            new AbstractMultiTenantCopierExtensionHandler(),
            null,
            new Object[] {BLCFieldUtils.NULL_FIELD}));
  }

  /**
   * Test {@link ExtensionManager#shouldContinue(ExtensionResultStatusType, ExtensionHandler,
   * Method, Object[])}.
   *
   * <ul>
   *   <li>When {@code HANDLED_CONTINUE}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ExtensionManager#shouldContinue(ExtensionResultStatusType,
   * ExtensionHandler, Method, Object[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ExtensionManager.shouldContinue(ExtensionResultStatusType, ExtensionHandler, Method, Object[])"
  })
  public void testShouldContinue_whenHandledContinue_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(
        extensionManager.shouldContinue(
            ExtensionResultStatusType.HANDLED_CONTINUE,
            new AbstractMultiTenantCopierExtensionHandler(),
            null,
            new Object[] {BLCFieldUtils.NULL_FIELD}));
  }

  /**
   * Test {@link ExtensionManager#shouldContinue(ExtensionResultStatusType, ExtensionHandler,
   * Method, Object[])}.
   *
   * <ul>
   *   <li>When {@code HANDLED_STOP}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ExtensionManager#shouldContinue(ExtensionResultStatusType,
   * ExtensionHandler, Method, Object[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ExtensionManager.shouldContinue(ExtensionResultStatusType, ExtensionHandler, Method, Object[])"
  })
  public void testShouldContinue_whenHandledStop_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(
        extensionManager.shouldContinue(
            ExtensionResultStatusType.HANDLED_STOP,
            new AbstractMultiTenantCopierExtensionHandler(),
            null,
            new Object[] {BLCFieldUtils.NULL_FIELD}));
  }

  /**
   * Test {@link ExtensionManager#shouldContinue(ExtensionResultStatusType, ExtensionHandler,
   * Method, Object[])}.
   *
   * <ul>
   *   <li>When {@code HANDLED}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ExtensionManager#shouldContinue(ExtensionResultStatusType,
   * ExtensionHandler, Method, Object[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ExtensionManager.shouldContinue(ExtensionResultStatusType, ExtensionHandler, Method, Object[])"
  })
  public void testShouldContinue_whenHandled_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(
        extensionManager.shouldContinue(
            ExtensionResultStatusType.HANDLED,
            new AbstractMultiTenantCopierExtensionHandler(),
            null,
            new Object[] {BLCFieldUtils.NULL_FIELD}));
  }

  /**
   * Test {@link ExtensionManager#continueOnHandled()}.
   *
   * <p>Method under test: {@link ExtensionManager#continueOnHandled()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ExtensionManager.continueOnHandled()"})
  public void testContinueOnHandled() {
    // Arrange, Act and Assert
    assertFalse(extensionManager.continueOnHandled());
  }

  /**
   * Test {@link ExtensionManager#getPriority()}.
   *
   * <p>Method under test: {@link ExtensionManager#getPriority()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int ExtensionManager.getPriority()"})
  public void testGetPriority() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> extensionManager.getPriority());
  }

  /**
   * Test {@link ExtensionManager#invoke(Object, Method, Object[])}.
   *
   * <ul>
   *   <li>Given {@link BreadcrumbServiceExtensionHandler} {@link
   *       BreadcrumbServiceExtensionHandler#isEnabled()} return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ExtensionManager#invoke(Object, Method, Object[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Object ExtensionManager.invoke(Object, Method, Object[])"})
  public void testInvoke_givenBreadcrumbServiceExtensionHandlerIsEnabledReturnFalse()
      throws Throwable {
    // Arrange
    BreadcrumbServiceExtensionHandler breadcrumbServiceExtensionHandler =
        mock(BreadcrumbServiceExtensionHandler.class);
    when(breadcrumbServiceExtensionHandler.isEnabled()).thenReturn(false);

    BreadcrumbServiceExtensionManager breadcrumbServiceExtensionManager =
        new BreadcrumbServiceExtensionManager();
    breadcrumbServiceExtensionManager.registerHandler(breadcrumbServiceExtensionHandler);

    // Act
    Object actualInvokeResult =
        breadcrumbServiceExtensionManager.invoke(
            BLCFieldUtils.NULL_FIELD, null, new Object[] {BLCFieldUtils.NULL_FIELD});

    // Assert
    verify(breadcrumbServiceExtensionHandler).isEnabled();
    assertTrue(actualInvokeResult instanceof ExtensionResultStatusType);
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, actualInvokeResult);
  }

  /**
   * Test {@link ExtensionManager#invoke(Object, Method, Object[])}.
   *
   * <ul>
   *   <li>Given {@link ExtensionManager}.
   *   <li>Then return {@link ExtensionResultStatusType}.
   * </ul>
   *
   * <p>Method under test: {@link ExtensionManager#invoke(Object, Method, Object[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Object ExtensionManager.invoke(Object, Method, Object[])"})
  public void testInvoke_givenExtensionManager_thenReturnExtensionResultStatusType()
      throws Throwable {
    // Arrange and Act
    Object actualInvokeResult =
        extensionManager.invoke(
            BLCFieldUtils.NULL_FIELD, null, new Object[] {BLCFieldUtils.NULL_FIELD});

    // Assert
    assertTrue(actualInvokeResult instanceof ExtensionResultStatusType);
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, actualInvokeResult);
  }

  /**
   * Test {@link ExtensionManager#invoke(Object, Method, Object[])}.
   *
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link ExtensionManager#invoke(Object, Method, Object[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Object ExtensionManager.invoke(Object, Method, Object[])"})
  public void testInvoke_thenThrowUnsupportedOperationException() throws Throwable {
    // Arrange
    BreadcrumbServiceExtensionHandler breadcrumbServiceExtensionHandler =
        mock(BreadcrumbServiceExtensionHandler.class);
    when(breadcrumbServiceExtensionHandler.isEnabled())
        .thenThrow(new UnsupportedOperationException());

    BreadcrumbServiceExtensionManager breadcrumbServiceExtensionManager =
        new BreadcrumbServiceExtensionManager();
    breadcrumbServiceExtensionManager.registerHandler(breadcrumbServiceExtensionHandler);

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () ->
            breadcrumbServiceExtensionManager.invoke(
                BLCFieldUtils.NULL_FIELD, null, new Object[] {BLCFieldUtils.NULL_FIELD}));
    verify(breadcrumbServiceExtensionHandler).isEnabled();
  }

  /**
   * Test {@link ExtensionManager#execute(ExtensionManagerOperation, Object[])}.
   *
   * <p>Method under test: {@link ExtensionManager#execute(ExtensionManagerOperation, Object[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType ExtensionManager.execute(ExtensionManagerOperation, Object[])"
  })
  public void testExecute() {
    // Arrange
    BreadcrumbServiceExtensionHandler breadcrumbServiceExtensionHandler =
        mock(BreadcrumbServiceExtensionHandler.class);
    when(breadcrumbServiceExtensionHandler.isEnabled())
        .thenThrow(new UnsupportedOperationException());

    BreadcrumbServiceExtensionManager breadcrumbServiceExtensionManager =
        new BreadcrumbServiceExtensionManager();
    breadcrumbServiceExtensionManager.registerHandler(breadcrumbServiceExtensionHandler);

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () ->
            breadcrumbServiceExtensionManager.execute(
                mock(ExtensionManagerOperation.class), BLCFieldUtils.NULL_FIELD));
    verify(breadcrumbServiceExtensionHandler).isEnabled();
  }

  /**
   * Test {@link ExtensionManager#execute(ExtensionManagerOperation, Object[])}.
   *
   * <ul>
   *   <li>Given {@link BreadcrumbServiceExtensionHandler} {@link
   *       BreadcrumbServiceExtensionHandler#isEnabled()} return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ExtensionManager#execute(ExtensionManagerOperation, Object[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType ExtensionManager.execute(ExtensionManagerOperation, Object[])"
  })
  public void testExecute_givenBreadcrumbServiceExtensionHandlerIsEnabledReturnFalse() {
    // Arrange
    BreadcrumbServiceExtensionHandler breadcrumbServiceExtensionHandler =
        mock(BreadcrumbServiceExtensionHandler.class);
    when(breadcrumbServiceExtensionHandler.isEnabled()).thenReturn(false);

    BreadcrumbServiceExtensionManager breadcrumbServiceExtensionManager =
        new BreadcrumbServiceExtensionManager();
    breadcrumbServiceExtensionManager.registerHandler(breadcrumbServiceExtensionHandler);

    // Act
    ExtensionResultStatusType actualExecuteResult =
        breadcrumbServiceExtensionManager.execute(
            mock(ExtensionManagerOperation.class), BLCFieldUtils.NULL_FIELD);

    // Assert
    verify(breadcrumbServiceExtensionHandler).isEnabled();
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, actualExecuteResult);
  }

  /**
   * Test {@link ExtensionManager#execute(ExtensionManagerOperation, Object[])}.
   *
   * <ul>
   *   <li>Given {@link ExtensionManager}.
   *   <li>Then return {@code NOT_HANDLED}.
   * </ul>
   *
   * <p>Method under test: {@link ExtensionManager#execute(ExtensionManagerOperation, Object[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType ExtensionManager.execute(ExtensionManagerOperation, Object[])"
  })
  public void testExecute_givenExtensionManager_thenReturnNotHandled() {
    // Arrange, Act and Assert
    assertEquals(
        ExtensionResultStatusType.NOT_HANDLED,
        extensionManager.execute(mock(ExtensionManagerOperation.class), BLCFieldUtils.NULL_FIELD));
  }

  /**
   * Test {@link ExtensionManager#execute(ExtensionManagerOperation, Object[])}.
   *
   * <ul>
   *   <li>Given {@code HANDLED_CONTINUE}.
   * </ul>
   *
   * <p>Method under test: {@link ExtensionManager#execute(ExtensionManagerOperation, Object[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType ExtensionManager.execute(ExtensionManagerOperation, Object[])"
  })
  public void testExecute_givenHandledContinue() {
    // Arrange
    BreadcrumbServiceExtensionHandler breadcrumbServiceExtensionHandler =
        mock(BreadcrumbServiceExtensionHandler.class);
    when(breadcrumbServiceExtensionHandler.isEnabled()).thenReturn(true);

    BreadcrumbServiceExtensionManager breadcrumbServiceExtensionManager =
        new BreadcrumbServiceExtensionManager();
    breadcrumbServiceExtensionManager.registerHandler(breadcrumbServiceExtensionHandler);

    ExtensionManagerOperation operation = mock(ExtensionManagerOperation.class);
    when(operation.execute(Mockito.<ExtensionHandler>any(), (Object[]) Mockito.any()))
        .thenReturn(ExtensionResultStatusType.HANDLED_CONTINUE);

    // Act
    ExtensionResultStatusType actualExecuteResult =
        breadcrumbServiceExtensionManager.execute(operation, BLCFieldUtils.NULL_FIELD);

    // Assert
    verify(breadcrumbServiceExtensionHandler).isEnabled();
    verify(operation).execute(isA(ExtensionHandler.class), (Object[]) Mockito.any());
    assertEquals(ExtensionResultStatusType.HANDLED, actualExecuteResult);
  }

  /**
   * Test {@link ExtensionManager#execute(ExtensionManagerOperation, Object[])}.
   *
   * <ul>
   *   <li>Given {@code HANDLED_STOP}.
   * </ul>
   *
   * <p>Method under test: {@link ExtensionManager#execute(ExtensionManagerOperation, Object[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType ExtensionManager.execute(ExtensionManagerOperation, Object[])"
  })
  public void testExecute_givenHandledStop() {
    // Arrange
    BreadcrumbServiceExtensionHandler breadcrumbServiceExtensionHandler =
        mock(BreadcrumbServiceExtensionHandler.class);
    when(breadcrumbServiceExtensionHandler.isEnabled()).thenReturn(true);

    BreadcrumbServiceExtensionManager breadcrumbServiceExtensionManager =
        new BreadcrumbServiceExtensionManager();
    breadcrumbServiceExtensionManager.registerHandler(breadcrumbServiceExtensionHandler);

    ExtensionManagerOperation operation = mock(ExtensionManagerOperation.class);
    when(operation.execute(Mockito.<ExtensionHandler>any(), (Object[]) Mockito.any()))
        .thenReturn(ExtensionResultStatusType.HANDLED_STOP);

    // Act
    ExtensionResultStatusType actualExecuteResult =
        breadcrumbServiceExtensionManager.execute(operation, BLCFieldUtils.NULL_FIELD);

    // Assert
    verify(breadcrumbServiceExtensionHandler).isEnabled();
    verify(operation).execute(isA(ExtensionHandler.class), (Object[]) Mockito.any());
    assertEquals(ExtensionResultStatusType.HANDLED, actualExecuteResult);
  }

  /**
   * Test {@link ExtensionManager#execute(ExtensionManagerOperation, Object[])}.
   *
   * <ul>
   *   <li>Given {@code HANDLED}.
   *   <li>When {@link ExtensionManagerOperation} {@link
   *       ExtensionManagerOperation#execute(ExtensionHandler, Object[])} return {@code HANDLED}.
   * </ul>
   *
   * <p>Method under test: {@link ExtensionManager#execute(ExtensionManagerOperation, Object[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType ExtensionManager.execute(ExtensionManagerOperation, Object[])"
  })
  public void testExecute_givenHandled_whenExtensionManagerOperationExecuteReturnHandled() {
    // Arrange
    BreadcrumbServiceExtensionHandler breadcrumbServiceExtensionHandler =
        mock(BreadcrumbServiceExtensionHandler.class);
    when(breadcrumbServiceExtensionHandler.isEnabled()).thenReturn(true);

    BreadcrumbServiceExtensionManager breadcrumbServiceExtensionManager =
        new BreadcrumbServiceExtensionManager();
    breadcrumbServiceExtensionManager.registerHandler(breadcrumbServiceExtensionHandler);

    ExtensionManagerOperation operation = mock(ExtensionManagerOperation.class);
    when(operation.execute(Mockito.<ExtensionHandler>any(), (Object[]) Mockito.any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);

    // Act
    ExtensionResultStatusType actualExecuteResult =
        breadcrumbServiceExtensionManager.execute(operation, BLCFieldUtils.NULL_FIELD);

    // Assert
    verify(breadcrumbServiceExtensionHandler).isEnabled();
    verify(operation).execute(isA(ExtensionHandler.class), (Object[]) Mockito.any());
    assertEquals(ExtensionResultStatusType.HANDLED, actualExecuteResult);
  }

  /**
   * Test {@link ExtensionManager#execute(ExtensionManagerOperation, Object[])}.
   *
   * <ul>
   *   <li>Given {@code NOT_HANDLED}.
   *   <li>When {@link ExtensionManagerOperation} {@link
   *       ExtensionManagerOperation#execute(ExtensionHandler, Object[])} return {@code
   *       NOT_HANDLED}.
   * </ul>
   *
   * <p>Method under test: {@link ExtensionManager#execute(ExtensionManagerOperation, Object[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType ExtensionManager.execute(ExtensionManagerOperation, Object[])"
  })
  public void testExecute_givenNotHandled_whenExtensionManagerOperationExecuteReturnNotHandled() {
    // Arrange
    BreadcrumbServiceExtensionHandler breadcrumbServiceExtensionHandler =
        mock(BreadcrumbServiceExtensionHandler.class);
    when(breadcrumbServiceExtensionHandler.isEnabled()).thenReturn(true);

    BreadcrumbServiceExtensionManager breadcrumbServiceExtensionManager =
        new BreadcrumbServiceExtensionManager();
    breadcrumbServiceExtensionManager.registerHandler(breadcrumbServiceExtensionHandler);

    ExtensionManagerOperation operation = mock(ExtensionManagerOperation.class);
    when(operation.execute(Mockito.<ExtensionHandler>any(), (Object[]) Mockito.any()))
        .thenReturn(ExtensionResultStatusType.NOT_HANDLED);

    // Act
    ExtensionResultStatusType actualExecuteResult =
        breadcrumbServiceExtensionManager.execute(operation, BLCFieldUtils.NULL_FIELD);

    // Assert
    verify(breadcrumbServiceExtensionHandler).isEnabled();
    verify(operation).execute(isA(ExtensionHandler.class), (Object[]) Mockito.any());
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, actualExecuteResult);
  }

  /**
   * Test {@link ExtensionManager#execute(ExtensionManagerOperation, Object[])}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link ExtensionManagerOperation} {@link
   *       ExtensionManagerOperation#execute(ExtensionHandler, Object[])} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ExtensionManager#execute(ExtensionManagerOperation, Object[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType ExtensionManager.execute(ExtensionManagerOperation, Object[])"
  })
  public void testExecute_givenNull_whenExtensionManagerOperationExecuteReturnNull() {
    // Arrange
    BreadcrumbServiceExtensionHandler breadcrumbServiceExtensionHandler =
        mock(BreadcrumbServiceExtensionHandler.class);
    when(breadcrumbServiceExtensionHandler.isEnabled()).thenReturn(true);

    BreadcrumbServiceExtensionManager breadcrumbServiceExtensionManager =
        new BreadcrumbServiceExtensionManager();
    breadcrumbServiceExtensionManager.registerHandler(breadcrumbServiceExtensionHandler);

    ExtensionManagerOperation operation = mock(ExtensionManagerOperation.class);
    when(operation.execute(Mockito.<ExtensionHandler>any(), (Object[]) Mockito.any()))
        .thenReturn(null);

    // Act
    ExtensionResultStatusType actualExecuteResult =
        breadcrumbServiceExtensionManager.execute(operation, BLCFieldUtils.NULL_FIELD);

    // Assert
    verify(breadcrumbServiceExtensionHandler).isEnabled();
    verify(operation).execute(isA(ExtensionHandler.class), (Object[]) Mockito.any());
    assertEquals(ExtensionResultStatusType.HANDLED, actualExecuteResult);
  }

  /**
   * Test {@link ExtensionManager#execute(ExtensionManagerOperation, Object[])}.
   *
   * <ul>
   *   <li>Given {@link UnsupportedOperationException#UnsupportedOperationException()}.
   * </ul>
   *
   * <p>Method under test: {@link ExtensionManager#execute(ExtensionManagerOperation, Object[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType ExtensionManager.execute(ExtensionManagerOperation, Object[])"
  })
  public void testExecute_givenUnsupportedOperationException() {
    // Arrange
    BreadcrumbServiceExtensionHandler breadcrumbServiceExtensionHandler =
        mock(BreadcrumbServiceExtensionHandler.class);
    when(breadcrumbServiceExtensionHandler.isEnabled()).thenReturn(true);

    BreadcrumbServiceExtensionManager breadcrumbServiceExtensionManager =
        new BreadcrumbServiceExtensionManager();
    breadcrumbServiceExtensionManager.registerHandler(breadcrumbServiceExtensionHandler);

    ExtensionManagerOperation operation = mock(ExtensionManagerOperation.class);
    when(operation.execute(Mockito.<ExtensionHandler>any(), (Object[]) Mockito.any()))
        .thenThrow(new UnsupportedOperationException());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> breadcrumbServiceExtensionManager.execute(operation, BLCFieldUtils.NULL_FIELD));
    verify(breadcrumbServiceExtensionHandler).isEnabled();
    verify(operation).execute(isA(ExtensionHandler.class), (Object[]) Mockito.any());
  }
}
