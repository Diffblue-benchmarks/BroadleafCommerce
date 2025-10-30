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
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {BreadcrumbServiceExtensionManager.class})
@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class ExtensionManagerDiffblueTest {
  @Autowired
  private ExtensionManager<BreadcrumbServiceExtensionHandler> extensionManager;

  /**
   * Test {@link ExtensionManager#getProxy()}.
   * <p>
   * Method under test: {@link ExtensionManager#getProxy()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ExtensionHandler ExtensionManager.getProxy()"})
  public void testGetProxy() {
    // Arrange, Act and Assert
    assertSame(extensionManager.extensionHandler, extensionManager.getProxy());
  }

  /**
   * Test {@link ExtensionManager#getHandlers()}.
   * <p>
   * Method under test: {@link ExtensionManager#getHandlers()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List ExtensionManager.getHandlers()"})
  public void testGetHandlers() {
    // Arrange, Act and Assert
    assertTrue(extensionManager.getHandlers().isEmpty());
  }

  /**
   * Test {@link ExtensionManager#registerHandler(ExtensionHandler)}.
   * <p>
   * Method under test: {@link ExtensionManager#registerHandler(ExtensionHandler)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ExtensionManager.registerHandler(ExtensionHandler)"})
  public void testRegisterHandler() {
    // Arrange
    BreadcrumbServiceExtensionHandler breadcrumbServiceExtensionHandler = mock(BreadcrumbServiceExtensionHandler.class);

    // Act
    boolean actualRegisterHandlerResult = extensionManager.registerHandler(breadcrumbServiceExtensionHandler);

    // Assert
    assertTrue(extensionManager instanceof BreadcrumbServiceExtensionManager);
    List<BreadcrumbServiceExtensionHandler> handlers = extensionManager.getHandlers();
    assertEquals(1, handlers.size());
    List<BreadcrumbServiceExtensionHandler> breadcrumbServiceExtensionHandlerList = ((BreadcrumbServiceExtensionManager) extensionManager).handlers;
    assertEquals(1, breadcrumbServiceExtensionHandlerList.size());
    assertTrue(actualRegisterHandlerResult);
    assertSame(extensionManager.handlers, handlers);
    assertSame(breadcrumbServiceExtensionHandler, handlers.get(0));
    assertSame(breadcrumbServiceExtensionHandler, breadcrumbServiceExtensionHandlerList.get(0));
  }

  /**
   * Test {@link ExtensionManager#setHandlers(List)}.
   * <ul>
   *   <li>Then {@link ExtensionManager} {@link ExtensionManager#handlers} size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExtensionManager#setHandlers(List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
   * <ul>
   *   <li>Then {@link ExtensionManager} {@link ExtensionManager#handlers} size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExtensionManager#setHandlers(List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then {@link ExtensionManager} {@link ExtensionManager#handlers} Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExtensionManager#setHandlers(List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
   * Test {@link ExtensionManager#shouldContinue(ExtensionResultStatusType, ExtensionHandler, Method, Object[])}.
   * <ul>
   *   <li>When {@link AbstractMultiTenantCopierExtensionHandler} (default constructor).</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExtensionManager#shouldContinue(ExtensionResultStatusType, ExtensionHandler, Method, Object[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "boolean ExtensionManager.shouldContinue(ExtensionResultStatusType, ExtensionHandler, Method, Object[])"})
  public void testShouldContinue_whenAbstractMultiTenantCopierExtensionHandler_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(extensionManager.shouldContinue(null, new AbstractMultiTenantCopierExtensionHandler(), null,
        new Object[]{BLCFieldUtils.NULL_FIELD}));
  }

  /**
   * Test {@link ExtensionManager#shouldContinue(ExtensionResultStatusType, ExtensionHandler, Method, Object[])}.
   * <ul>
   *   <li>When {@code HANDLED_CONTINUE}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExtensionManager#shouldContinue(ExtensionResultStatusType, ExtensionHandler, Method, Object[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "boolean ExtensionManager.shouldContinue(ExtensionResultStatusType, ExtensionHandler, Method, Object[])"})
  public void testShouldContinue_whenHandledContinue_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(extensionManager.shouldContinue(ExtensionResultStatusType.HANDLED_CONTINUE,
        new AbstractMultiTenantCopierExtensionHandler(), null, new Object[]{BLCFieldUtils.NULL_FIELD}));
  }

  /**
   * Test {@link ExtensionManager#shouldContinue(ExtensionResultStatusType, ExtensionHandler, Method, Object[])}.
   * <ul>
   *   <li>When {@code HANDLED_STOP}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExtensionManager#shouldContinue(ExtensionResultStatusType, ExtensionHandler, Method, Object[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "boolean ExtensionManager.shouldContinue(ExtensionResultStatusType, ExtensionHandler, Method, Object[])"})
  public void testShouldContinue_whenHandledStop_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(extensionManager.shouldContinue(ExtensionResultStatusType.HANDLED_STOP,
        new AbstractMultiTenantCopierExtensionHandler(), null, new Object[]{BLCFieldUtils.NULL_FIELD}));
  }

  /**
   * Test {@link ExtensionManager#shouldContinue(ExtensionResultStatusType, ExtensionHandler, Method, Object[])}.
   * <ul>
   *   <li>When {@code HANDLED}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExtensionManager#shouldContinue(ExtensionResultStatusType, ExtensionHandler, Method, Object[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "boolean ExtensionManager.shouldContinue(ExtensionResultStatusType, ExtensionHandler, Method, Object[])"})
  public void testShouldContinue_whenHandled_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(extensionManager.shouldContinue(ExtensionResultStatusType.HANDLED,
        new AbstractMultiTenantCopierExtensionHandler(), null, new Object[]{BLCFieldUtils.NULL_FIELD}));
  }

  /**
   * Test {@link ExtensionManager#continueOnHandled()}.
   * <p>
   * Method under test: {@link ExtensionManager#continueOnHandled()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ExtensionManager.continueOnHandled()"})
  public void testContinueOnHandled() {
    // Arrange, Act and Assert
    assertFalse(extensionManager.continueOnHandled());
  }

  /**
   * Test {@link ExtensionManager#getPriority()}.
   * <p>
   * Method under test: {@link ExtensionManager#getPriority()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int ExtensionManager.getPriority()"})
  public void testGetPriority() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> extensionManager.getPriority());
  }

  /**
   * Test {@link ExtensionManager#invoke(Object, Method, Object[])}.
   * <p>
   * Method under test: {@link ExtensionManager#invoke(Object, Method, Object[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Object ExtensionManager.invoke(Object, Method, Object[])"})
  public void testInvoke() throws Throwable {
    // Arrange and Act
    Object actualInvokeResult = extensionManager.invoke(BLCFieldUtils.NULL_FIELD, null,
        new Object[]{BLCFieldUtils.NULL_FIELD});

    // Assert
    assertTrue(actualInvokeResult instanceof ExtensionResultStatusType);
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, actualInvokeResult);
  }

  /**
   * Test {@link ExtensionManager#execute(ExtensionManagerOperation, Object[])}.
   * <p>
   * Method under test: {@link ExtensionManager#execute(ExtensionManagerOperation, Object[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ExtensionResultStatusType ExtensionManager.execute(ExtensionManagerOperation, Object[])"})
  public void testExecute() {
    // Arrange, Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        extensionManager.execute(mock(ExtensionManagerOperation.class), BLCFieldUtils.NULL_FIELD));
  }
}
