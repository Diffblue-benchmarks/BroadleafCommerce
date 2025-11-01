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
   * Method under test: {@link TemplateOnlyQueryExtensionManager#setup(Class)}
   */
  @Test
  public void testSetup() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TemplateOnlyQueryExtensionManager templateOnlyQueryExtensionManager = new TemplateOnlyQueryExtensionManager();
    Class<Object> type = Object.class;

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, templateOnlyQueryExtensionManager.setup(type));
  }

  /**
   * Method under test: {@link TemplateOnlyQueryExtensionManager#setup(Class)}
   */
  @Test
  public void testSetup2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TemplateOnlyQueryExtensionManager templateOnlyQueryExtensionManager = new TemplateOnlyQueryExtensionManager();
    templateOnlyQueryExtensionManager.registerHandler(new TemplateOnlyQueryExtensionManager());
    Class<Object> type = Object.class;

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, templateOnlyQueryExtensionManager.setup(type));
  }

  /**
   * Method under test: {@link TemplateOnlyQueryExtensionManager#setup(Class)}
   */
  @Test
  public void testSetup3() {
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
   * Method under test: {@link TemplateOnlyQueryExtensionManager#setup(Class)}
   */
  @Test
  public void testSetup4() {
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
   * Method under test: {@link TemplateOnlyQueryExtensionManager#setup(Class)}
   */
  @Test
  public void testSetup5() {
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
   * Method under test: {@link TemplateOnlyQueryExtensionManager#isEnabled()}
   */
  @Test
  public void testIsEnabled() {
    // Arrange, Act and Assert
    assertTrue((new TemplateOnlyQueryExtensionManager()).isEnabled());
  }

  /**
   * Method under test: {@link TemplateOnlyQueryExtensionManager#breakdown(Class)}
   */
  @Test
  public void testBreakdown() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TemplateOnlyQueryExtensionManager templateOnlyQueryExtensionManager = new TemplateOnlyQueryExtensionManager();
    Class<Object> type = Object.class;

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, templateOnlyQueryExtensionManager.breakdown(type));
  }

  /**
   * Method under test: {@link TemplateOnlyQueryExtensionManager#breakdown(Class)}
   */
  @Test
  public void testBreakdown2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TemplateOnlyQueryExtensionManager templateOnlyQueryExtensionManager = new TemplateOnlyQueryExtensionManager();
    templateOnlyQueryExtensionManager.registerHandler(new TemplateOnlyQueryExtensionManager());
    Class<Object> type = Object.class;

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, templateOnlyQueryExtensionManager.breakdown(type));
  }

  /**
   * Method under test: {@link TemplateOnlyQueryExtensionManager#breakdown(Class)}
   */
  @Test
  public void testBreakdown3() {
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
   * Method under test: {@link TemplateOnlyQueryExtensionManager#breakdown(Class)}
   */
  @Test
  public void testBreakdown4() {
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
   * Method under test: {@link TemplateOnlyQueryExtensionManager#breakdown(Class)}
   */
  @Test
  public void testBreakdown5() {
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
   * Method under test:
   * {@link TemplateOnlyQueryExtensionManager#isValidState(ExtensionResultHolder)}
   */
  @Test
  public void testIsValidState() {
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
   * Method under test:
   * {@link TemplateOnlyQueryExtensionManager#isValidState(ExtensionResultHolder)}
   */
  @Test
  public void testIsValidState2() {
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
   * Method under test:
   * {@link TemplateOnlyQueryExtensionManager#isValidState(ExtensionResultHolder)}
   */
  @Test
  public void testIsValidState3() {
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
   * Method under test:
   * {@link TemplateOnlyQueryExtensionManager#isValidState(ExtensionResultHolder)}
   */
  @Test
  public void testIsValidState4() {
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
   * Method under test:
   * {@link TemplateOnlyQueryExtensionManager#isValidState(ExtensionResultHolder)}
   */
  @Test
  public void testIsValidState5() {
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
   * Method under test:
   * {@link TemplateOnlyQueryExtensionManager#isValidState(ExtensionResultHolder)}
   */
  @Test
  public void testIsValidState6() {
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
   * Method under test:
   * {@link TemplateOnlyQueryExtensionManager#buildStatus(Object, ExtensionResultHolder)}
   */
  @Test
  public void testBuildStatus() {
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
   * Method under test:
   * {@link TemplateOnlyQueryExtensionManager#buildStatus(Object, ExtensionResultHolder)}
   */
  @Test
  public void testBuildStatus2() {
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
   * Method under test:
   * {@link TemplateOnlyQueryExtensionManager#buildStatus(Object, ExtensionResultHolder)}
   */
  @Test
  public void testBuildStatus3() {
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
   * Method under test:
   * {@link TemplateOnlyQueryExtensionManager#buildStatus(Object, ExtensionResultHolder)}
   */
  @Test
  public void testBuildStatus4() {
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
   * Method under test:
   * {@link TemplateOnlyQueryExtensionManager#buildStatus(Object, ExtensionResultHolder)}
   */
  @Test
  public void testBuildStatus5() {
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
   * Method under test:
   * {@link TemplateOnlyQueryExtensionManager#buildStatus(Object, ExtensionResultHolder)}
   */
  @Test
  public void testBuildStatus6() {
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
   * Method under test:
   * {@link TemplateOnlyQueryExtensionManager#filterResults(Class, Object, List)}
   */
  @Test
  public void testFilterResults() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TemplateOnlyQueryExtensionManager templateOnlyQueryExtensionManager = new TemplateOnlyQueryExtensionManager();
    Class<Object> type = Object.class;

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        templateOnlyQueryExtensionManager.filterResults(type, BLCFieldUtils.NULL_FIELD, new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link TemplateOnlyQueryExtensionManager#filterResults(Class, Object, List)}
   */
  @Test
  public void testFilterResults2() {
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
   * Method under test:
   * {@link TemplateOnlyQueryExtensionManager#filterResults(Class, Object, List)}
   */
  @Test
  public void testFilterResults3() {
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
   * Method under test:
   * {@link TemplateOnlyQueryExtensionManager#filterResults(Class, Object, List)}
   */
  @Test
  public void testFilterResults4() {
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
   * Method under test:
   * {@link TemplateOnlyQueryExtensionManager#filterResults(Class, Object, List)}
   */
  @Test
  public void testFilterResults5() {
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
   * Method under test:
   * {@link TemplateOnlyQueryExtensionManager#filterResults(Class, Object, List)}
   */
  @Test
  public void testFilterResults6() {
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
   * Method under test:
   * {@link TemplateOnlyQueryExtensionManager#filterResults(Class, Object, List)}
   */
  @Test
  public void testFilterResults7() {
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
}
