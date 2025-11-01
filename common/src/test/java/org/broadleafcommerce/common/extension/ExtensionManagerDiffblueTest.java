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
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import org.broadleafcommerce.common.breadcrumbs.service.BreadcrumbServiceExtensionHandler;
import org.broadleafcommerce.common.breadcrumbs.service.BreadcrumbServiceExtensionManager;
import org.broadleafcommerce.common.copy.AbstractMultiTenantCopierExtensionHandler;
import org.broadleafcommerce.common.util.BLCFieldUtils;
import org.junit.Test;
import org.mockito.Mockito;

public class ExtensionManagerDiffblueTest {
  /**
   * Method under test: {@link ExtensionManager#getProxy()}
   */
  @Test
  public void testGetProxy() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BreadcrumbServiceExtensionManager breadcrumbServiceExtensionManager = new BreadcrumbServiceExtensionManager();

    // Act and Assert
    assertSame(breadcrumbServiceExtensionManager.extensionHandler, breadcrumbServiceExtensionManager.getProxy());
  }

  /**
   * Method under test: {@link ExtensionManager#getProxy()}
   */
  @Test
  public void testGetProxy2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BreadcrumbServiceExtensionManager breadcrumbServiceExtensionManager = new BreadcrumbServiceExtensionManager();
    breadcrumbServiceExtensionManager.registerHandler(mock(BreadcrumbServiceExtensionHandler.class));

    // Act and Assert
    assertSame(breadcrumbServiceExtensionManager.extensionHandler, breadcrumbServiceExtensionManager.getProxy());
  }

  /**
   * Method under test: {@link ExtensionManager#getHandlers()}
   */
  @Test
  public void testGetHandlers() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BreadcrumbServiceExtensionManager breadcrumbServiceExtensionManager = new BreadcrumbServiceExtensionManager();

    // Act
    List<BreadcrumbServiceExtensionHandler> actualHandlers = breadcrumbServiceExtensionManager.getHandlers();

    // Assert
    assertTrue(actualHandlers.isEmpty());
    assertSame(breadcrumbServiceExtensionManager.handlers, actualHandlers);
  }

  /**
   * Method under test: {@link ExtensionManager#getHandlers()}
   */
  @Test
  public void testGetHandlers2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BreadcrumbServiceExtensionManager breadcrumbServiceExtensionManager = new BreadcrumbServiceExtensionManager();
    breadcrumbServiceExtensionManager.registerHandler(mock(BreadcrumbServiceExtensionHandler.class));

    // Act
    List<BreadcrumbServiceExtensionHandler> actualHandlers = breadcrumbServiceExtensionManager.getHandlers();

    // Assert
    assertEquals(1, actualHandlers.size());
    assertSame(breadcrumbServiceExtensionManager.handlers, actualHandlers);
  }

  /**
   * Method under test: {@link ExtensionManager#registerHandler(ExtensionHandler)}
   */
  @Test
  public void testRegisterHandler() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BreadcrumbServiceExtensionManager breadcrumbServiceExtensionManager = new BreadcrumbServiceExtensionManager();
    BreadcrumbServiceExtensionHandler breadcrumbServiceExtensionHandler = mock(BreadcrumbServiceExtensionHandler.class);

    // Act
    boolean actualRegisterHandlerResult = breadcrumbServiceExtensionManager
        .registerHandler(breadcrumbServiceExtensionHandler);

    // Assert
    List<BreadcrumbServiceExtensionHandler> handlers = breadcrumbServiceExtensionManager.getHandlers();
    assertEquals(1, handlers.size());
    List<BreadcrumbServiceExtensionHandler> breadcrumbServiceExtensionHandlerList = breadcrumbServiceExtensionManager.handlers;
    assertEquals(1, breadcrumbServiceExtensionHandlerList.size());
    assertTrue(actualRegisterHandlerResult);
    assertSame(breadcrumbServiceExtensionManager.handlers, handlers);
    assertSame(breadcrumbServiceExtensionHandler, handlers.get(0));
    assertSame(breadcrumbServiceExtensionHandler, breadcrumbServiceExtensionHandlerList.get(0));
  }

  /**
   * Method under test: {@link ExtensionManager#registerHandler(ExtensionHandler)}
   */
  @Test
  public void testRegisterHandler2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ArrayList<BreadcrumbServiceExtensionHandler> handlers = new ArrayList<>();
    handlers.add(mock(BreadcrumbServiceExtensionHandler.class));

    BreadcrumbServiceExtensionManager breadcrumbServiceExtensionManager = new BreadcrumbServiceExtensionManager();
    breadcrumbServiceExtensionManager.setHandlers(handlers);

    // Act
    boolean actualRegisterHandlerResult = breadcrumbServiceExtensionManager
        .registerHandler(mock(BreadcrumbServiceExtensionHandler.class));

    // Assert
    List<BreadcrumbServiceExtensionHandler> handlers2 = breadcrumbServiceExtensionManager.getHandlers();
    assertEquals(1, handlers2.size());
    List<BreadcrumbServiceExtensionHandler> breadcrumbServiceExtensionHandlerList = breadcrumbServiceExtensionManager.handlers;
    assertEquals(1, breadcrumbServiceExtensionHandlerList.size());
    assertFalse(actualRegisterHandlerResult);
    assertSame(handlers, handlers2);
    assertSame(handlers2.get(0), breadcrumbServiceExtensionHandlerList.get(0));
  }

  /**
   * Method under test: {@link ExtensionManager#setHandlers(List)}
   */
  @Test
  public void testSetHandlers() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BreadcrumbServiceExtensionManager breadcrumbServiceExtensionManager = new BreadcrumbServiceExtensionManager();
    ArrayList<BreadcrumbServiceExtensionHandler> handlers = new ArrayList<>();

    // Act
    breadcrumbServiceExtensionManager.setHandlers(handlers);

    // Assert
    assertTrue(breadcrumbServiceExtensionManager.handlers.isEmpty());
    assertSame(handlers, breadcrumbServiceExtensionManager.getHandlers());
  }

  /**
   * Method under test: {@link ExtensionManager#setHandlers(List)}
   */
  @Test
  public void testSetHandlers2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BreadcrumbServiceExtensionManager breadcrumbServiceExtensionManager = new BreadcrumbServiceExtensionManager();

    ArrayList<BreadcrumbServiceExtensionHandler> handlers = new ArrayList<>();
    handlers.add(mock(BreadcrumbServiceExtensionHandler.class));

    // Act
    breadcrumbServiceExtensionManager.setHandlers(handlers);

    // Assert
    assertEquals(1, breadcrumbServiceExtensionManager.handlers.size());
    assertSame(handlers, breadcrumbServiceExtensionManager.getHandlers());
  }

  /**
   * Method under test: {@link ExtensionManager#setHandlers(List)}
   */
  @Test
  public void testSetHandlers3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BreadcrumbServiceExtensionManager breadcrumbServiceExtensionManager = new BreadcrumbServiceExtensionManager();

    ArrayList<BreadcrumbServiceExtensionHandler> handlers = new ArrayList<>();
    handlers.add(mock(BreadcrumbServiceExtensionHandler.class));
    handlers.add(mock(BreadcrumbServiceExtensionHandler.class));

    // Act
    breadcrumbServiceExtensionManager.setHandlers(handlers);

    // Assert
    assertEquals(2, breadcrumbServiceExtensionManager.handlers.size());
    assertSame(handlers, breadcrumbServiceExtensionManager.getHandlers());
  }

  /**
   * Method under test:
   * {@link ExtensionManager#shouldContinue(ExtensionResultStatusType, ExtensionHandler, Method, Object[])}
   */
  @Test
  public void testShouldContinue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BreadcrumbServiceExtensionManager breadcrumbServiceExtensionManager = new BreadcrumbServiceExtensionManager();

    // Act and Assert
    assertFalse(breadcrumbServiceExtensionManager.shouldContinue(ExtensionResultStatusType.HANDLED,
        new AbstractMultiTenantCopierExtensionHandler(), null, new Object[]{BLCFieldUtils.NULL_FIELD}));
  }

  /**
   * Method under test:
   * {@link ExtensionManager#shouldContinue(ExtensionResultStatusType, ExtensionHandler, Method, Object[])}
   */
  @Test
  public void testShouldContinue2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BreadcrumbServiceExtensionManager breadcrumbServiceExtensionManager = new BreadcrumbServiceExtensionManager();

    // Act and Assert
    assertTrue(breadcrumbServiceExtensionManager.shouldContinue(null, new AbstractMultiTenantCopierExtensionHandler(),
        null, new Object[]{BLCFieldUtils.NULL_FIELD}));
  }

  /**
   * Method under test:
   * {@link ExtensionManager#shouldContinue(ExtensionResultStatusType, ExtensionHandler, Method, Object[])}
   */
  @Test
  public void testShouldContinue3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BreadcrumbServiceExtensionManager breadcrumbServiceExtensionManager = new BreadcrumbServiceExtensionManager();

    // Act and Assert
    assertTrue(breadcrumbServiceExtensionManager.shouldContinue(ExtensionResultStatusType.HANDLED_CONTINUE,
        new AbstractMultiTenantCopierExtensionHandler(), null, new Object[]{BLCFieldUtils.NULL_FIELD}));
  }

  /**
   * Method under test:
   * {@link ExtensionManager#shouldContinue(ExtensionResultStatusType, ExtensionHandler, Method, Object[])}
   */
  @Test
  public void testShouldContinue4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BreadcrumbServiceExtensionManager breadcrumbServiceExtensionManager = new BreadcrumbServiceExtensionManager();

    // Act and Assert
    assertFalse(breadcrumbServiceExtensionManager.shouldContinue(ExtensionResultStatusType.HANDLED_STOP,
        new AbstractMultiTenantCopierExtensionHandler(), null, new Object[]{BLCFieldUtils.NULL_FIELD}));
  }

  /**
   * Method under test:
   * {@link ExtensionManager#shouldContinue(ExtensionResultStatusType, ExtensionHandler, Method, Object[])}
   */
  @Test
  public void testShouldContinue5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new BreadcrumbServiceExtensionManager()).shouldContinue(ExtensionResultStatusType.HANDLED,
        mock(TemplateCacheExtensionManager.class), null, new Object[]{BLCFieldUtils.NULL_FIELD}));
  }

  /**
   * Method under test: {@link ExtensionManager#continueOnHandled()}
   */
  @Test
  public void testContinueOnHandled() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new BreadcrumbServiceExtensionManager()).continueOnHandled());
  }

  /**
   * Method under test: {@link ExtensionManager#continueOnHandled()}
   */
  @Test
  public void testContinueOnHandled2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BreadcrumbServiceExtensionManager breadcrumbServiceExtensionManager = new BreadcrumbServiceExtensionManager();
    breadcrumbServiceExtensionManager.registerHandler(mock(BreadcrumbServiceExtensionHandler.class));

    // Act and Assert
    assertFalse(breadcrumbServiceExtensionManager.continueOnHandled());
  }

  /**
   * Method under test: {@link ExtensionManager#getPriority()}
   */
  @Test
  public void testGetPriority() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new BreadcrumbServiceExtensionManager()).getPriority());
  }

  /**
   * Method under test: {@link ExtensionManager#invoke(Object, Method, Object[])}
   */
  @Test
  public void testInvoke() throws Throwable {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    Object actualInvokeResult = (new BreadcrumbServiceExtensionManager()).invoke(BLCFieldUtils.NULL_FIELD, null,
        new Object[]{BLCFieldUtils.NULL_FIELD});

    // Assert
    assertTrue(actualInvokeResult instanceof ExtensionResultStatusType);
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, actualInvokeResult);
  }

  /**
   * Method under test: {@link ExtensionManager#invoke(Object, Method, Object[])}
   */
  @Test
  public void testInvoke2() throws Throwable {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BreadcrumbServiceExtensionHandler breadcrumbServiceExtensionHandler = mock(BreadcrumbServiceExtensionHandler.class);
    when(breadcrumbServiceExtensionHandler.isEnabled()).thenThrow(new UnsupportedOperationException("priority"));

    BreadcrumbServiceExtensionManager breadcrumbServiceExtensionManager = new BreadcrumbServiceExtensionManager();
    breadcrumbServiceExtensionManager.registerHandler(breadcrumbServiceExtensionHandler);

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> breadcrumbServiceExtensionManager
        .invoke(BLCFieldUtils.NULL_FIELD, null, new Object[]{BLCFieldUtils.NULL_FIELD}));
    verify(breadcrumbServiceExtensionHandler).isEnabled();
  }

  /**
   * Method under test: {@link ExtensionManager#invoke(Object, Method, Object[])}
   */
  @Test
  public void testInvoke3() throws Throwable {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BreadcrumbServiceExtensionHandler breadcrumbServiceExtensionHandler = mock(BreadcrumbServiceExtensionHandler.class);
    when(breadcrumbServiceExtensionHandler.isEnabled()).thenReturn(false);

    BreadcrumbServiceExtensionManager breadcrumbServiceExtensionManager = new BreadcrumbServiceExtensionManager();
    breadcrumbServiceExtensionManager.registerHandler(breadcrumbServiceExtensionHandler);

    // Act
    Object actualInvokeResult = breadcrumbServiceExtensionManager.invoke(BLCFieldUtils.NULL_FIELD, null,
        new Object[]{BLCFieldUtils.NULL_FIELD});

    // Assert
    verify(breadcrumbServiceExtensionHandler).isEnabled();
    assertTrue(actualInvokeResult instanceof ExtensionResultStatusType);
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, actualInvokeResult);
  }

  /**
   * Method under test:
   * {@link ExtensionManager#execute(ExtensionManagerOperation, Object[])}
   */
  @Test
  public void testExecute() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, (new BreadcrumbServiceExtensionManager())
        .execute(mock(ExtensionManagerOperation.class), BLCFieldUtils.NULL_FIELD));
  }

  /**
   * Method under test:
   * {@link ExtensionManager#execute(ExtensionManagerOperation, Object[])}
   */
  @Test
  public void testExecute2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BreadcrumbServiceExtensionHandler breadcrumbServiceExtensionHandler = mock(BreadcrumbServiceExtensionHandler.class);
    when(breadcrumbServiceExtensionHandler.isEnabled()).thenReturn(true);

    BreadcrumbServiceExtensionManager breadcrumbServiceExtensionManager = new BreadcrumbServiceExtensionManager();
    breadcrumbServiceExtensionManager.registerHandler(breadcrumbServiceExtensionHandler);
    ExtensionManagerOperation operation = mock(ExtensionManagerOperation.class);
    when(operation.execute(Mockito.<ExtensionHandler>any(), (Object[]) any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);

    // Act
    ExtensionResultStatusType actualExecuteResult = breadcrumbServiceExtensionManager.execute(operation,
        BLCFieldUtils.NULL_FIELD);

    // Assert
    verify(breadcrumbServiceExtensionHandler).isEnabled();
    verify(operation).execute(isA(ExtensionHandler.class), (Object[]) any());
    assertEquals(ExtensionResultStatusType.HANDLED, actualExecuteResult);
  }

  /**
   * Method under test:
   * {@link ExtensionManager#execute(ExtensionManagerOperation, Object[])}
   */
  @Test
  public void testExecute3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BreadcrumbServiceExtensionHandler breadcrumbServiceExtensionHandler = mock(BreadcrumbServiceExtensionHandler.class);
    when(breadcrumbServiceExtensionHandler.isEnabled()).thenReturn(true);

    BreadcrumbServiceExtensionManager breadcrumbServiceExtensionManager = new BreadcrumbServiceExtensionManager();
    breadcrumbServiceExtensionManager.registerHandler(breadcrumbServiceExtensionHandler);
    ExtensionManagerOperation operation = mock(ExtensionManagerOperation.class);
    when(operation.execute(Mockito.<ExtensionHandler>any(), (Object[]) any()))
        .thenThrow(new UnsupportedOperationException("priority"));

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> breadcrumbServiceExtensionManager.execute(operation, BLCFieldUtils.NULL_FIELD));
    verify(breadcrumbServiceExtensionHandler).isEnabled();
    verify(operation).execute(isA(ExtensionHandler.class), (Object[]) any());
  }

  /**
   * Method under test:
   * {@link ExtensionManager#execute(ExtensionManagerOperation, Object[])}
   */
  @Test
  public void testExecute4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BreadcrumbServiceExtensionHandler breadcrumbServiceExtensionHandler = mock(BreadcrumbServiceExtensionHandler.class);
    when(breadcrumbServiceExtensionHandler.isEnabled()).thenReturn(false);

    BreadcrumbServiceExtensionManager breadcrumbServiceExtensionManager = new BreadcrumbServiceExtensionManager();
    breadcrumbServiceExtensionManager.registerHandler(breadcrumbServiceExtensionHandler);

    // Act
    ExtensionResultStatusType actualExecuteResult = breadcrumbServiceExtensionManager
        .execute(mock(ExtensionManagerOperation.class), BLCFieldUtils.NULL_FIELD);

    // Assert
    verify(breadcrumbServiceExtensionHandler).isEnabled();
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, actualExecuteResult);
  }

  /**
   * Method under test:
   * {@link ExtensionManager#execute(ExtensionManagerOperation, Object[])}
   */
  @Test
  public void testExecute5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BreadcrumbServiceExtensionHandler breadcrumbServiceExtensionHandler = mock(BreadcrumbServiceExtensionHandler.class);
    when(breadcrumbServiceExtensionHandler.isEnabled()).thenReturn(true);

    BreadcrumbServiceExtensionManager breadcrumbServiceExtensionManager = new BreadcrumbServiceExtensionManager();
    breadcrumbServiceExtensionManager.registerHandler(breadcrumbServiceExtensionHandler);
    ExtensionManagerOperation operation = mock(ExtensionManagerOperation.class);
    when(operation.execute(Mockito.<ExtensionHandler>any(), (Object[]) any())).thenReturn(null);

    // Act
    ExtensionResultStatusType actualExecuteResult = breadcrumbServiceExtensionManager.execute(operation,
        BLCFieldUtils.NULL_FIELD);

    // Assert
    verify(breadcrumbServiceExtensionHandler).isEnabled();
    verify(operation).execute(isA(ExtensionHandler.class), (Object[]) any());
    assertEquals(ExtensionResultStatusType.HANDLED, actualExecuteResult);
  }

  /**
   * Method under test:
   * {@link ExtensionManager#execute(ExtensionManagerOperation, Object[])}
   */
  @Test
  public void testExecute6() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BreadcrumbServiceExtensionHandler breadcrumbServiceExtensionHandler = mock(BreadcrumbServiceExtensionHandler.class);
    when(breadcrumbServiceExtensionHandler.isEnabled()).thenReturn(true);

    BreadcrumbServiceExtensionManager breadcrumbServiceExtensionManager = new BreadcrumbServiceExtensionManager();
    breadcrumbServiceExtensionManager.registerHandler(breadcrumbServiceExtensionHandler);
    ExtensionManagerOperation operation = mock(ExtensionManagerOperation.class);
    when(operation.execute(Mockito.<ExtensionHandler>any(), (Object[]) any()))
        .thenReturn(ExtensionResultStatusType.HANDLED_CONTINUE);

    // Act
    ExtensionResultStatusType actualExecuteResult = breadcrumbServiceExtensionManager.execute(operation,
        BLCFieldUtils.NULL_FIELD);

    // Assert
    verify(breadcrumbServiceExtensionHandler).isEnabled();
    verify(operation).execute(isA(ExtensionHandler.class), (Object[]) any());
    assertEquals(ExtensionResultStatusType.HANDLED, actualExecuteResult);
  }

  /**
   * Method under test:
   * {@link ExtensionManager#execute(ExtensionManagerOperation, Object[])}
   */
  @Test
  public void testExecute7() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BreadcrumbServiceExtensionHandler breadcrumbServiceExtensionHandler = mock(BreadcrumbServiceExtensionHandler.class);
    when(breadcrumbServiceExtensionHandler.isEnabled()).thenReturn(true);

    BreadcrumbServiceExtensionManager breadcrumbServiceExtensionManager = new BreadcrumbServiceExtensionManager();
    breadcrumbServiceExtensionManager.registerHandler(breadcrumbServiceExtensionHandler);
    ExtensionManagerOperation operation = mock(ExtensionManagerOperation.class);
    when(operation.execute(Mockito.<ExtensionHandler>any(), (Object[]) any()))
        .thenReturn(ExtensionResultStatusType.HANDLED_STOP);

    // Act
    ExtensionResultStatusType actualExecuteResult = breadcrumbServiceExtensionManager.execute(operation,
        BLCFieldUtils.NULL_FIELD);

    // Assert
    verify(breadcrumbServiceExtensionHandler).isEnabled();
    verify(operation).execute(isA(ExtensionHandler.class), (Object[]) any());
    assertEquals(ExtensionResultStatusType.HANDLED, actualExecuteResult);
  }

  /**
   * Method under test:
   * {@link ExtensionManager#execute(ExtensionManagerOperation, Object[])}
   */
  @Test
  public void testExecute8() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BreadcrumbServiceExtensionHandler breadcrumbServiceExtensionHandler = mock(BreadcrumbServiceExtensionHandler.class);
    when(breadcrumbServiceExtensionHandler.isEnabled()).thenReturn(true);

    BreadcrumbServiceExtensionManager breadcrumbServiceExtensionManager = new BreadcrumbServiceExtensionManager();
    breadcrumbServiceExtensionManager.registerHandler(breadcrumbServiceExtensionHandler);
    ExtensionManagerOperation operation = mock(ExtensionManagerOperation.class);
    when(operation.execute(Mockito.<ExtensionHandler>any(), (Object[]) any()))
        .thenReturn(ExtensionResultStatusType.NOT_HANDLED);

    // Act
    ExtensionResultStatusType actualExecuteResult = breadcrumbServiceExtensionManager.execute(operation,
        BLCFieldUtils.NULL_FIELD);

    // Assert
    verify(breadcrumbServiceExtensionHandler).isEnabled();
    verify(operation).execute(isA(ExtensionHandler.class), (Object[]) any());
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, actualExecuteResult);
  }
}
