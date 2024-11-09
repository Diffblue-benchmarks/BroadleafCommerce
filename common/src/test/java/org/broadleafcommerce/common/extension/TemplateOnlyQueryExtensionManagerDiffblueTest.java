/*-
 * #%L
 * BroadleafCommerce Common Libraries
 * %%
 * Copyright (C) 2009 - 2024 Broadleaf Commerce
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
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import org.broadleafcommerce.common.util.BLCFieldUtils;
import org.junit.Test;
import org.mockito.Mockito;

public class TemplateOnlyQueryExtensionManagerDiffblueTest {
  /**
   * Test {@link TemplateOnlyQueryExtensionManager#setup(Class)}.
   * <p>
   * Method under test: {@link TemplateOnlyQueryExtensionManager#setup(Class)}
   */
  @Test
  public void testSetup() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TemplateOnlyQueryExtensionManager templateOnlyQueryExtensionManager = new TemplateOnlyQueryExtensionManager();
    templateOnlyQueryExtensionManager.registerHandler(new TemplateOnlyQueryExtensionManager());
    Class<Object> type = Object.class;

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, templateOnlyQueryExtensionManager.setup(type));
  }

  /**
   * Test {@link TemplateOnlyQueryExtensionManager#setup(Class)}.
   * <ul>
   *   <li>Given {@link TemplateOnlyQueryExtensionHandler}
   * {@link ExtensionHandler#isEnabled()} return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TemplateOnlyQueryExtensionManager#setup(Class)}
   */
  @Test
  public void testSetup_givenTemplateOnlyQueryExtensionHandlerIsEnabledReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TemplateOnlyQueryExtensionHandler templateOnlyQueryExtensionHandler = mock(TemplateOnlyQueryExtensionHandler.class);
    when(templateOnlyQueryExtensionHandler.isEnabled()).thenReturn(false);

    TemplateOnlyQueryExtensionManager templateOnlyQueryExtensionManager = new TemplateOnlyQueryExtensionManager();
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
   * <ul>
   *   <li>Given {@link TemplateOnlyQueryExtensionHandler}
   * {@link TemplateOnlyQueryExtensionHandler#setup(Class)} return
   * {@code HANDLED_STOP}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TemplateOnlyQueryExtensionManager#setup(Class)}
   */
  @Test
  public void testSetup_givenTemplateOnlyQueryExtensionHandlerSetupReturnHandledStop() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TemplateOnlyQueryExtensionHandler templateOnlyQueryExtensionHandler = mock(TemplateOnlyQueryExtensionHandler.class);
    when(templateOnlyQueryExtensionHandler.setup(Mockito.<Class<Object>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED_STOP);
    when(templateOnlyQueryExtensionHandler.isEnabled()).thenReturn(true);

    TemplateOnlyQueryExtensionManager templateOnlyQueryExtensionManager = new TemplateOnlyQueryExtensionManager();
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
   * <ul>
   *   <li>Given {@link TemplateOnlyQueryExtensionManager} (default
   * constructor).</li>
   *   <li>Then return {@code NOT_HANDLED}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TemplateOnlyQueryExtensionManager#setup(Class)}
   */
  @Test
  public void testSetup_givenTemplateOnlyQueryExtensionManager_thenReturnNotHandled() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TemplateOnlyQueryExtensionManager templateOnlyQueryExtensionManager = new TemplateOnlyQueryExtensionManager();
    Class<Object> type = Object.class;

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, templateOnlyQueryExtensionManager.setup(type));
  }

  /**
   * Test {@link TemplateOnlyQueryExtensionManager#setup(Class)}.
   * <ul>
   *   <li>Then return {@code HANDLED}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TemplateOnlyQueryExtensionManager#setup(Class)}
   */
  @Test
  public void testSetup_thenReturnHandled() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TemplateOnlyQueryExtensionHandler templateOnlyQueryExtensionHandler = mock(TemplateOnlyQueryExtensionHandler.class);
    when(templateOnlyQueryExtensionHandler.setup(Mockito.<Class<Object>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(templateOnlyQueryExtensionHandler.isEnabled()).thenReturn(true);

    TemplateOnlyQueryExtensionManager templateOnlyQueryExtensionManager = new TemplateOnlyQueryExtensionManager();
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
   * Test {@link TemplateOnlyQueryExtensionManager#isEnabled()}.
   * <p>
   * Method under test: {@link TemplateOnlyQueryExtensionManager#isEnabled()}
   */
  @Test
  public void testIsEnabled() {
    // Arrange, Act and Assert
    assertTrue((new TemplateOnlyQueryExtensionManager()).isEnabled());
  }

  /**
   * Test {@link TemplateOnlyQueryExtensionManager#breakdown(Class)}.
   * <p>
   * Method under test: {@link TemplateOnlyQueryExtensionManager#breakdown(Class)}
   */
  @Test
  public void testBreakdown() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TemplateOnlyQueryExtensionManager templateOnlyQueryExtensionManager = new TemplateOnlyQueryExtensionManager();
    templateOnlyQueryExtensionManager.registerHandler(new TemplateOnlyQueryExtensionManager());
    Class<Object> type = Object.class;

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, templateOnlyQueryExtensionManager.breakdown(type));
  }

  /**
   * Test {@link TemplateOnlyQueryExtensionManager#breakdown(Class)}.
   * <ul>
   *   <li>Given {@link TemplateOnlyQueryExtensionHandler}
   * {@link TemplateOnlyQueryExtensionHandler#breakdown(Class)} return
   * {@code HANDLED_STOP}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TemplateOnlyQueryExtensionManager#breakdown(Class)}
   */
  @Test
  public void testBreakdown_givenTemplateOnlyQueryExtensionHandlerBreakdownReturnHandledStop() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TemplateOnlyQueryExtensionHandler templateOnlyQueryExtensionHandler = mock(TemplateOnlyQueryExtensionHandler.class);
    when(templateOnlyQueryExtensionHandler.breakdown(Mockito.<Class<Object>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED_STOP);
    when(templateOnlyQueryExtensionHandler.isEnabled()).thenReturn(true);

    TemplateOnlyQueryExtensionManager templateOnlyQueryExtensionManager = new TemplateOnlyQueryExtensionManager();
    templateOnlyQueryExtensionManager.registerHandler(templateOnlyQueryExtensionHandler);
    Class<Object> type = Object.class;

    // Act
    ExtensionResultStatusType actualBreakdownResult = templateOnlyQueryExtensionManager.breakdown(type);

    // Assert
    verify(templateOnlyQueryExtensionHandler).isEnabled();
    verify(templateOnlyQueryExtensionHandler).breakdown(isA(Class.class));
    assertEquals(ExtensionResultStatusType.HANDLED, actualBreakdownResult);
  }

  /**
   * Test {@link TemplateOnlyQueryExtensionManager#breakdown(Class)}.
   * <ul>
   *   <li>Given {@link TemplateOnlyQueryExtensionHandler}
   * {@link ExtensionHandler#isEnabled()} return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TemplateOnlyQueryExtensionManager#breakdown(Class)}
   */
  @Test
  public void testBreakdown_givenTemplateOnlyQueryExtensionHandlerIsEnabledReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TemplateOnlyQueryExtensionHandler templateOnlyQueryExtensionHandler = mock(TemplateOnlyQueryExtensionHandler.class);
    when(templateOnlyQueryExtensionHandler.isEnabled()).thenReturn(false);

    TemplateOnlyQueryExtensionManager templateOnlyQueryExtensionManager = new TemplateOnlyQueryExtensionManager();
    templateOnlyQueryExtensionManager.registerHandler(templateOnlyQueryExtensionHandler);
    Class<Object> type = Object.class;

    // Act
    ExtensionResultStatusType actualBreakdownResult = templateOnlyQueryExtensionManager.breakdown(type);

    // Assert
    verify(templateOnlyQueryExtensionHandler).isEnabled();
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, actualBreakdownResult);
  }

  /**
   * Test {@link TemplateOnlyQueryExtensionManager#breakdown(Class)}.
   * <ul>
   *   <li>Given {@link TemplateOnlyQueryExtensionManager} (default
   * constructor).</li>
   *   <li>Then return {@code NOT_HANDLED}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TemplateOnlyQueryExtensionManager#breakdown(Class)}
   */
  @Test
  public void testBreakdown_givenTemplateOnlyQueryExtensionManager_thenReturnNotHandled() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TemplateOnlyQueryExtensionManager templateOnlyQueryExtensionManager = new TemplateOnlyQueryExtensionManager();
    Class<Object> type = Object.class;

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, templateOnlyQueryExtensionManager.breakdown(type));
  }

  /**
   * Test {@link TemplateOnlyQueryExtensionManager#breakdown(Class)}.
   * <ul>
   *   <li>Then return {@code HANDLED}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TemplateOnlyQueryExtensionManager#breakdown(Class)}
   */
  @Test
  public void testBreakdown_thenReturnHandled() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TemplateOnlyQueryExtensionHandler templateOnlyQueryExtensionHandler = mock(TemplateOnlyQueryExtensionHandler.class);
    when(templateOnlyQueryExtensionHandler.breakdown(Mockito.<Class<Object>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(templateOnlyQueryExtensionHandler.isEnabled()).thenReturn(true);

    TemplateOnlyQueryExtensionManager templateOnlyQueryExtensionManager = new TemplateOnlyQueryExtensionManager();
    templateOnlyQueryExtensionManager.registerHandler(templateOnlyQueryExtensionHandler);
    Class<Object> type = Object.class;

    // Act
    ExtensionResultStatusType actualBreakdownResult = templateOnlyQueryExtensionManager.breakdown(type);

    // Assert
    verify(templateOnlyQueryExtensionHandler).isEnabled();
    verify(templateOnlyQueryExtensionHandler).breakdown(isA(Class.class));
    assertEquals(ExtensionResultStatusType.HANDLED, actualBreakdownResult);
  }

  /**
   * Test
   * {@link TemplateOnlyQueryExtensionManager#isValidState(ExtensionResultHolder)}.
   * <p>
   * Method under test:
   * {@link TemplateOnlyQueryExtensionManager#isValidState(ExtensionResultHolder)}
   */
  @Test
  public void testIsValidState() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TemplateOnlyQueryExtensionManager templateOnlyQueryExtensionManager = new TemplateOnlyQueryExtensionManager();
    templateOnlyQueryExtensionManager.registerHandler(new TemplateOnlyQueryExtensionManager());
    ExtensionResultHolder<Boolean> response = mock(ExtensionResultHolder.class);
    doNothing().when(response).setResult(Mockito.<Boolean>any());
    doNothing().when(response).setThrowable(Mockito.<Throwable>any());
    response.setResult(true);
    response.setThrowable(new Throwable());

    // Act
    ExtensionResultStatusType actualIsValidStateResult = templateOnlyQueryExtensionManager.isValidState(response);

    // Assert
    verify(response).setResult(eq(true));
    verify(response).setThrowable(isA(Throwable.class));
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, actualIsValidStateResult);
  }

  /**
   * Test
   * {@link TemplateOnlyQueryExtensionManager#isValidState(ExtensionResultHolder)}.
   * <p>
   * Method under test:
   * {@link TemplateOnlyQueryExtensionManager#isValidState(ExtensionResultHolder)}
   */
  @Test
  public void testIsValidState2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TemplateOnlyQueryExtensionHandler templateOnlyQueryExtensionHandler = mock(TemplateOnlyQueryExtensionHandler.class);
    when(templateOnlyQueryExtensionHandler.isValidState(Mockito.<ExtensionResultHolder<Boolean>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED_STOP);
    when(templateOnlyQueryExtensionHandler.isEnabled()).thenReturn(true);

    TemplateOnlyQueryExtensionManager templateOnlyQueryExtensionManager = new TemplateOnlyQueryExtensionManager();
    templateOnlyQueryExtensionManager.registerHandler(templateOnlyQueryExtensionHandler);
    ExtensionResultHolder<Boolean> response = mock(ExtensionResultHolder.class);
    doNothing().when(response).setResult(Mockito.<Boolean>any());
    doNothing().when(response).setThrowable(Mockito.<Throwable>any());
    response.setResult(true);
    response.setThrowable(new Throwable());

    // Act
    ExtensionResultStatusType actualIsValidStateResult = templateOnlyQueryExtensionManager.isValidState(response);

    // Assert
    verify(templateOnlyQueryExtensionHandler).isEnabled();
    verify(response).setResult(eq(true));
    verify(response).setThrowable(isA(Throwable.class));
    verify(templateOnlyQueryExtensionHandler).isValidState(isA(ExtensionResultHolder.class));
    assertEquals(ExtensionResultStatusType.HANDLED, actualIsValidStateResult);
  }

  /**
   * Test
   * {@link TemplateOnlyQueryExtensionManager#isValidState(ExtensionResultHolder)}.
   * <ul>
   *   <li>Given {@link TemplateOnlyQueryExtensionHandler}
   * {@link ExtensionHandler#isEnabled()} return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TemplateOnlyQueryExtensionManager#isValidState(ExtensionResultHolder)}
   */
  @Test
  public void testIsValidState_givenTemplateOnlyQueryExtensionHandlerIsEnabledReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TemplateOnlyQueryExtensionHandler templateOnlyQueryExtensionHandler = mock(TemplateOnlyQueryExtensionHandler.class);
    when(templateOnlyQueryExtensionHandler.isEnabled()).thenReturn(false);

    TemplateOnlyQueryExtensionManager templateOnlyQueryExtensionManager = new TemplateOnlyQueryExtensionManager();
    templateOnlyQueryExtensionManager.registerHandler(templateOnlyQueryExtensionHandler);
    ExtensionResultHolder<Boolean> response = mock(ExtensionResultHolder.class);
    doNothing().when(response).setResult(Mockito.<Boolean>any());
    doNothing().when(response).setThrowable(Mockito.<Throwable>any());
    response.setResult(true);
    response.setThrowable(new Throwable());

    // Act
    ExtensionResultStatusType actualIsValidStateResult = templateOnlyQueryExtensionManager.isValidState(response);

    // Assert
    verify(templateOnlyQueryExtensionHandler).isEnabled();
    verify(response).setResult(eq(true));
    verify(response).setThrowable(isA(Throwable.class));
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, actualIsValidStateResult);
  }

  /**
   * Test
   * {@link TemplateOnlyQueryExtensionManager#isValidState(ExtensionResultHolder)}.
   * <ul>
   *   <li>Given {@link TemplateOnlyQueryExtensionManager} (default
   * constructor).</li>
   *   <li>Then return {@code NOT_HANDLED}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TemplateOnlyQueryExtensionManager#isValidState(ExtensionResultHolder)}
   */
  @Test
  public void testIsValidState_givenTemplateOnlyQueryExtensionManager_thenReturnNotHandled() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TemplateOnlyQueryExtensionManager templateOnlyQueryExtensionManager = new TemplateOnlyQueryExtensionManager();
    ExtensionResultHolder<Boolean> response = mock(ExtensionResultHolder.class);
    doNothing().when(response).setResult(Mockito.<Boolean>any());
    doNothing().when(response).setThrowable(Mockito.<Throwable>any());
    response.setResult(true);
    response.setThrowable(new Throwable());

    // Act
    ExtensionResultStatusType actualIsValidStateResult = templateOnlyQueryExtensionManager.isValidState(response);

    // Assert
    verify(response).setResult(eq(true));
    verify(response).setThrowable(isA(Throwable.class));
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, actualIsValidStateResult);
  }

  /**
   * Test
   * {@link TemplateOnlyQueryExtensionManager#isValidState(ExtensionResultHolder)}.
   * <ul>
   *   <li>Then return {@code HANDLED}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TemplateOnlyQueryExtensionManager#isValidState(ExtensionResultHolder)}
   */
  @Test
  public void testIsValidState_thenReturnHandled() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TemplateOnlyQueryExtensionHandler templateOnlyQueryExtensionHandler = mock(TemplateOnlyQueryExtensionHandler.class);
    when(templateOnlyQueryExtensionHandler.isValidState(Mockito.<ExtensionResultHolder<Boolean>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(templateOnlyQueryExtensionHandler.isEnabled()).thenReturn(true);

    TemplateOnlyQueryExtensionManager templateOnlyQueryExtensionManager = new TemplateOnlyQueryExtensionManager();
    templateOnlyQueryExtensionManager.registerHandler(templateOnlyQueryExtensionHandler);
    ExtensionResultHolder<Boolean> response = mock(ExtensionResultHolder.class);
    doNothing().when(response).setResult(Mockito.<Boolean>any());
    doNothing().when(response).setThrowable(Mockito.<Throwable>any());
    response.setResult(true);
    response.setThrowable(new Throwable());

    // Act
    ExtensionResultStatusType actualIsValidStateResult = templateOnlyQueryExtensionManager.isValidState(response);

    // Assert
    verify(templateOnlyQueryExtensionHandler).isEnabled();
    verify(response).setResult(eq(true));
    verify(response).setThrowable(isA(Throwable.class));
    verify(templateOnlyQueryExtensionHandler).isValidState(isA(ExtensionResultHolder.class));
    assertEquals(ExtensionResultStatusType.HANDLED, actualIsValidStateResult);
  }

  /**
   * Test
   * {@link TemplateOnlyQueryExtensionManager#isValidState(ExtensionResultHolder)}.
   * <ul>
   *   <li>When {@link ExtensionResultHolder} (default constructor) Result is
   * {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TemplateOnlyQueryExtensionManager#isValidState(ExtensionResultHolder)}
   */
  @Test
  public void testIsValidState_whenExtensionResultHolderResultIsTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TemplateOnlyQueryExtensionManager templateOnlyQueryExtensionManager = new TemplateOnlyQueryExtensionManager();

    ExtensionResultHolder<Boolean> response = new ExtensionResultHolder<>();
    response.setResult(true);
    response.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, templateOnlyQueryExtensionManager.isValidState(response));
  }

  /**
   * Test
   * {@link TemplateOnlyQueryExtensionManager#buildStatus(Object, ExtensionResultHolder)}.
   * <p>
   * Method under test:
   * {@link TemplateOnlyQueryExtensionManager#buildStatus(Object, ExtensionResultHolder)}
   */
  @Test
  public void testBuildStatus() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TemplateOnlyQueryExtensionManager templateOnlyQueryExtensionManager = new TemplateOnlyQueryExtensionManager();
    templateOnlyQueryExtensionManager.registerHandler(new TemplateOnlyQueryExtensionManager());
    ExtensionResultHolder<ItemStatus> response = mock(ExtensionResultHolder.class);
    doNothing().when(response).setResult(Mockito.<ItemStatus>any());
    doNothing().when(response).setThrowable(Mockito.<Throwable>any());
    response.setResult(ItemStatus.DELETED);
    response.setThrowable(new Throwable());

    // Act
    ExtensionResultStatusType actualBuildStatusResult = templateOnlyQueryExtensionManager
        .buildStatus(BLCFieldUtils.NULL_FIELD, response);

    // Assert
    verify(response).setResult(eq(ItemStatus.DELETED));
    verify(response).setThrowable(isA(Throwable.class));
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, actualBuildStatusResult);
  }

  /**
   * Test
   * {@link TemplateOnlyQueryExtensionManager#buildStatus(Object, ExtensionResultHolder)}.
   * <p>
   * Method under test:
   * {@link TemplateOnlyQueryExtensionManager#buildStatus(Object, ExtensionResultHolder)}
   */
  @Test
  public void testBuildStatus2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TemplateOnlyQueryExtensionHandler templateOnlyQueryExtensionHandler = mock(TemplateOnlyQueryExtensionHandler.class);
    when(templateOnlyQueryExtensionHandler.buildStatus(Mockito.<Object>any(),
        Mockito.<ExtensionResultHolder<ItemStatus>>any())).thenReturn(ExtensionResultStatusType.HANDLED_STOP);
    when(templateOnlyQueryExtensionHandler.isEnabled()).thenReturn(true);

    TemplateOnlyQueryExtensionManager templateOnlyQueryExtensionManager = new TemplateOnlyQueryExtensionManager();
    templateOnlyQueryExtensionManager.registerHandler(templateOnlyQueryExtensionHandler);
    ExtensionResultHolder<ItemStatus> response = mock(ExtensionResultHolder.class);
    doNothing().when(response).setResult(Mockito.<ItemStatus>any());
    doNothing().when(response).setThrowable(Mockito.<Throwable>any());
    response.setResult(ItemStatus.DELETED);
    response.setThrowable(new Throwable());

    // Act
    ExtensionResultStatusType actualBuildStatusResult = templateOnlyQueryExtensionManager
        .buildStatus(BLCFieldUtils.NULL_FIELD, response);

    // Assert
    verify(templateOnlyQueryExtensionHandler).isEnabled();
    verify(response).setResult(eq(ItemStatus.DELETED));
    verify(response).setThrowable(isA(Throwable.class));
    verify(templateOnlyQueryExtensionHandler).buildStatus(isA(Object.class), isA(ExtensionResultHolder.class));
    assertEquals(ExtensionResultStatusType.HANDLED, actualBuildStatusResult);
  }

  /**
   * Test
   * {@link TemplateOnlyQueryExtensionManager#buildStatus(Object, ExtensionResultHolder)}.
   * <ul>
   *   <li>Given {@link TemplateOnlyQueryExtensionHandler}
   * {@link TemplateOnlyQueryExtensionHandler#buildStatus(Object, ExtensionResultHolder)}
   * return {@code HANDLED}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TemplateOnlyQueryExtensionManager#buildStatus(Object, ExtensionResultHolder)}
   */
  @Test
  public void testBuildStatus_givenTemplateOnlyQueryExtensionHandlerBuildStatusReturnHandled() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TemplateOnlyQueryExtensionHandler templateOnlyQueryExtensionHandler = mock(TemplateOnlyQueryExtensionHandler.class);
    when(templateOnlyQueryExtensionHandler.buildStatus(Mockito.<Object>any(),
        Mockito.<ExtensionResultHolder<ItemStatus>>any())).thenReturn(ExtensionResultStatusType.HANDLED);
    when(templateOnlyQueryExtensionHandler.isEnabled()).thenReturn(true);

    TemplateOnlyQueryExtensionManager templateOnlyQueryExtensionManager = new TemplateOnlyQueryExtensionManager();
    templateOnlyQueryExtensionManager.registerHandler(templateOnlyQueryExtensionHandler);
    ExtensionResultHolder<ItemStatus> response = mock(ExtensionResultHolder.class);
    doNothing().when(response).setResult(Mockito.<ItemStatus>any());
    doNothing().when(response).setThrowable(Mockito.<Throwable>any());
    response.setResult(ItemStatus.DELETED);
    response.setThrowable(new Throwable());

    // Act
    ExtensionResultStatusType actualBuildStatusResult = templateOnlyQueryExtensionManager
        .buildStatus(BLCFieldUtils.NULL_FIELD, response);

    // Assert
    verify(templateOnlyQueryExtensionHandler).isEnabled();
    verify(response).setResult(eq(ItemStatus.DELETED));
    verify(response).setThrowable(isA(Throwable.class));
    verify(templateOnlyQueryExtensionHandler).buildStatus(isA(Object.class), isA(ExtensionResultHolder.class));
    assertEquals(ExtensionResultStatusType.HANDLED, actualBuildStatusResult);
  }

  /**
   * Test
   * {@link TemplateOnlyQueryExtensionManager#buildStatus(Object, ExtensionResultHolder)}.
   * <ul>
   *   <li>Given {@link TemplateOnlyQueryExtensionHandler}
   * {@link ExtensionHandler#isEnabled()} return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TemplateOnlyQueryExtensionManager#buildStatus(Object, ExtensionResultHolder)}
   */
  @Test
  public void testBuildStatus_givenTemplateOnlyQueryExtensionHandlerIsEnabledReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TemplateOnlyQueryExtensionHandler templateOnlyQueryExtensionHandler = mock(TemplateOnlyQueryExtensionHandler.class);
    when(templateOnlyQueryExtensionHandler.isEnabled()).thenReturn(false);

    TemplateOnlyQueryExtensionManager templateOnlyQueryExtensionManager = new TemplateOnlyQueryExtensionManager();
    templateOnlyQueryExtensionManager.registerHandler(templateOnlyQueryExtensionHandler);
    ExtensionResultHolder<ItemStatus> response = mock(ExtensionResultHolder.class);
    doNothing().when(response).setResult(Mockito.<ItemStatus>any());
    doNothing().when(response).setThrowable(Mockito.<Throwable>any());
    response.setResult(ItemStatus.DELETED);
    response.setThrowable(new Throwable());

    // Act
    ExtensionResultStatusType actualBuildStatusResult = templateOnlyQueryExtensionManager
        .buildStatus(BLCFieldUtils.NULL_FIELD, response);

    // Assert
    verify(templateOnlyQueryExtensionHandler).isEnabled();
    verify(response).setResult(eq(ItemStatus.DELETED));
    verify(response).setThrowable(isA(Throwable.class));
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, actualBuildStatusResult);
  }

  /**
   * Test
   * {@link TemplateOnlyQueryExtensionManager#buildStatus(Object, ExtensionResultHolder)}.
   * <ul>
   *   <li>Given {@link TemplateOnlyQueryExtensionManager} (default
   * constructor).</li>
   *   <li>Then return {@code NOT_HANDLED}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TemplateOnlyQueryExtensionManager#buildStatus(Object, ExtensionResultHolder)}
   */
  @Test
  public void testBuildStatus_givenTemplateOnlyQueryExtensionManager_thenReturnNotHandled() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TemplateOnlyQueryExtensionManager templateOnlyQueryExtensionManager = new TemplateOnlyQueryExtensionManager();
    ExtensionResultHolder<ItemStatus> response = mock(ExtensionResultHolder.class);
    doNothing().when(response).setResult(Mockito.<ItemStatus>any());
    doNothing().when(response).setThrowable(Mockito.<Throwable>any());
    response.setResult(ItemStatus.DELETED);
    response.setThrowable(new Throwable());

    // Act
    ExtensionResultStatusType actualBuildStatusResult = templateOnlyQueryExtensionManager
        .buildStatus(BLCFieldUtils.NULL_FIELD, response);

    // Assert
    verify(response).setResult(eq(ItemStatus.DELETED));
    verify(response).setThrowable(isA(Throwable.class));
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, actualBuildStatusResult);
  }

  /**
   * Test
   * {@link TemplateOnlyQueryExtensionManager#buildStatus(Object, ExtensionResultHolder)}.
   * <ul>
   *   <li>When {@link ExtensionResultHolder} (default constructor) Result is
   * {@code DELETED}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TemplateOnlyQueryExtensionManager#buildStatus(Object, ExtensionResultHolder)}
   */
  @Test
  public void testBuildStatus_whenExtensionResultHolderResultIsDeleted() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TemplateOnlyQueryExtensionManager templateOnlyQueryExtensionManager = new TemplateOnlyQueryExtensionManager();

    ExtensionResultHolder<ItemStatus> response = new ExtensionResultHolder<>();
    response.setResult(ItemStatus.DELETED);
    response.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        templateOnlyQueryExtensionManager.buildStatus(BLCFieldUtils.NULL_FIELD, response));
  }

  /**
   * Test
   * {@link TemplateOnlyQueryExtensionManager#filterResults(Class, Object, List)}.
   * <p>
   * Method under test:
   * {@link TemplateOnlyQueryExtensionManager#filterResults(Class, Object, List)}
   */
  @Test
  public void testFilterResults() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TemplateOnlyQueryExtensionManager templateOnlyQueryExtensionManager = new TemplateOnlyQueryExtensionManager();
    templateOnlyQueryExtensionManager.registerHandler(new TemplateOnlyQueryExtensionManager());
    Class<Object> type = Object.class;

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        templateOnlyQueryExtensionManager.filterResults(type, BLCFieldUtils.NULL_FIELD, new ArrayList<>()));
  }

  /**
   * Test
   * {@link TemplateOnlyQueryExtensionManager#filterResults(Class, Object, List)}.
   * <p>
   * Method under test:
   * {@link TemplateOnlyQueryExtensionManager#filterResults(Class, Object, List)}
   */
  @Test
  public void testFilterResults2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TemplateOnlyQueryExtensionHandler templateOnlyQueryExtensionHandler = mock(TemplateOnlyQueryExtensionHandler.class);
    when(templateOnlyQueryExtensionHandler.filterResults(Mockito.<Class<Object>>any(), Mockito.<Object>any(),
        Mockito.<List<Object>>any())).thenReturn(ExtensionResultStatusType.HANDLED);
    when(templateOnlyQueryExtensionHandler.isEnabled()).thenReturn(true);

    TemplateOnlyQueryExtensionManager templateOnlyQueryExtensionManager = new TemplateOnlyQueryExtensionManager();
    templateOnlyQueryExtensionManager.registerHandler(templateOnlyQueryExtensionHandler);
    Class<Object> type = Object.class;

    // Act
    ExtensionResultStatusType actualFilterResultsResult = templateOnlyQueryExtensionManager.filterResults(type,
        BLCFieldUtils.NULL_FIELD, new ArrayList<>());

    // Assert
    verify(templateOnlyQueryExtensionHandler).isEnabled();
    verify(templateOnlyQueryExtensionHandler).filterResults(isA(Class.class), isA(Object.class), isA(List.class));
    assertEquals(ExtensionResultStatusType.HANDLED, actualFilterResultsResult);
  }

  /**
   * Test
   * {@link TemplateOnlyQueryExtensionManager#filterResults(Class, Object, List)}.
   * <p>
   * Method under test:
   * {@link TemplateOnlyQueryExtensionManager#filterResults(Class, Object, List)}
   */
  @Test
  public void testFilterResults3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TemplateOnlyQueryExtensionHandler templateOnlyQueryExtensionHandler = mock(TemplateOnlyQueryExtensionHandler.class);
    when(templateOnlyQueryExtensionHandler.filterResults(Mockito.<Class<Object>>any(), Mockito.<Object>any(),
        Mockito.<List<Object>>any())).thenReturn(ExtensionResultStatusType.HANDLED_STOP);
    when(templateOnlyQueryExtensionHandler.isEnabled()).thenReturn(true);

    TemplateOnlyQueryExtensionManager templateOnlyQueryExtensionManager = new TemplateOnlyQueryExtensionManager();
    templateOnlyQueryExtensionManager.registerHandler(templateOnlyQueryExtensionHandler);
    Class<Object> type = Object.class;

    // Act
    ExtensionResultStatusType actualFilterResultsResult = templateOnlyQueryExtensionManager.filterResults(type,
        BLCFieldUtils.NULL_FIELD, new ArrayList<>());

    // Assert
    verify(templateOnlyQueryExtensionHandler).isEnabled();
    verify(templateOnlyQueryExtensionHandler).filterResults(isA(Class.class), isA(Object.class), isA(List.class));
    assertEquals(ExtensionResultStatusType.HANDLED, actualFilterResultsResult);
  }

  /**
   * Test
   * {@link TemplateOnlyQueryExtensionManager#filterResults(Class, Object, List)}.
   * <ul>
   *   <li>Given {@link BLCFieldUtils#NULL_FIELD}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add
   * {@link BLCFieldUtils#NULL_FIELD}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TemplateOnlyQueryExtensionManager#filterResults(Class, Object, List)}
   */
  @Test
  public void testFilterResults_givenNull_field_whenArrayListAddNull_field() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TemplateOnlyQueryExtensionManager templateOnlyQueryExtensionManager = new TemplateOnlyQueryExtensionManager();
    Class<Object> type = Object.class;

    ArrayList<Object> results = new ArrayList<>();
    results.add(BLCFieldUtils.NULL_FIELD);

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        templateOnlyQueryExtensionManager.filterResults(type, BLCFieldUtils.NULL_FIELD, results));
  }

  /**
   * Test
   * {@link TemplateOnlyQueryExtensionManager#filterResults(Class, Object, List)}.
   * <ul>
   *   <li>Given {@link BLCFieldUtils#NULL_FIELD}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add
   * {@link BLCFieldUtils#NULL_FIELD}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TemplateOnlyQueryExtensionManager#filterResults(Class, Object, List)}
   */
  @Test
  public void testFilterResults_givenNull_field_whenArrayListAddNull_field2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TemplateOnlyQueryExtensionManager templateOnlyQueryExtensionManager = new TemplateOnlyQueryExtensionManager();
    Class<Object> type = Object.class;

    ArrayList<Object> results = new ArrayList<>();
    results.add(BLCFieldUtils.NULL_FIELD);
    results.add(BLCFieldUtils.NULL_FIELD);

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        templateOnlyQueryExtensionManager.filterResults(type, BLCFieldUtils.NULL_FIELD, results));
  }

  /**
   * Test
   * {@link TemplateOnlyQueryExtensionManager#filterResults(Class, Object, List)}.
   * <ul>
   *   <li>Given {@link TemplateOnlyQueryExtensionHandler}
   * {@link ExtensionHandler#isEnabled()} return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TemplateOnlyQueryExtensionManager#filterResults(Class, Object, List)}
   */
  @Test
  public void testFilterResults_givenTemplateOnlyQueryExtensionHandlerIsEnabledReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TemplateOnlyQueryExtensionHandler templateOnlyQueryExtensionHandler = mock(TemplateOnlyQueryExtensionHandler.class);
    when(templateOnlyQueryExtensionHandler.isEnabled()).thenReturn(false);

    TemplateOnlyQueryExtensionManager templateOnlyQueryExtensionManager = new TemplateOnlyQueryExtensionManager();
    templateOnlyQueryExtensionManager.registerHandler(templateOnlyQueryExtensionHandler);
    Class<Object> type = Object.class;

    // Act
    ExtensionResultStatusType actualFilterResultsResult = templateOnlyQueryExtensionManager.filterResults(type,
        BLCFieldUtils.NULL_FIELD, new ArrayList<>());

    // Assert
    verify(templateOnlyQueryExtensionHandler).isEnabled();
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, actualFilterResultsResult);
  }

  /**
   * Test
   * {@link TemplateOnlyQueryExtensionManager#filterResults(Class, Object, List)}.
   * <ul>
   *   <li>Given {@link TemplateOnlyQueryExtensionManager} (default
   * constructor).</li>
   *   <li>Then return {@code NOT_HANDLED}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TemplateOnlyQueryExtensionManager#filterResults(Class, Object, List)}
   */
  @Test
  public void testFilterResults_givenTemplateOnlyQueryExtensionManager_thenReturnNotHandled() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TemplateOnlyQueryExtensionManager templateOnlyQueryExtensionManager = new TemplateOnlyQueryExtensionManager();
    Class<Object> type = Object.class;

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        templateOnlyQueryExtensionManager.filterResults(type, BLCFieldUtils.NULL_FIELD, new ArrayList<>()));
  }
}
