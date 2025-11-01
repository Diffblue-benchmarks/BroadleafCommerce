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
import org.broadleafcommerce.common.util.BLCFieldUtils;
import org.junit.Test;
import org.mockito.Mockito;

public class TemplateCacheExtensionManagerDiffblueTest {
  /**
   * Method under test: {@link TemplateCacheExtensionManager#isEnabled()}
   */
  @Test
  public void testIsEnabled() {
    // Arrange, Act and Assert
    assertTrue((new TemplateCacheExtensionManager()).isEnabled());
  }

  /**
   * Method under test:
   * {@link TemplateCacheExtensionManager#getTemplateCacheKey(Object, String, ExtensionResultHolder)}
   */
  @Test
  public void testGetTemplateCacheKey() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TemplateCacheExtensionManager templateCacheExtensionManager = new TemplateCacheExtensionManager();

    ExtensionResultHolder<Object> resultHolder = new ExtensionResultHolder<>();
    resultHolder.setResult(BLCFieldUtils.NULL_FIELD);
    resultHolder.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        templateCacheExtensionManager.getTemplateCacheKey(BLCFieldUtils.NULL_FIELD, "Template", resultHolder));
  }

  /**
   * Method under test:
   * {@link TemplateCacheExtensionManager#getTemplateCacheKey(Object, String, ExtensionResultHolder)}
   */
  @Test
  public void testGetTemplateCacheKey2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TemplateCacheExtensionManager templateCacheExtensionManager = new TemplateCacheExtensionManager();
    ExtensionResultHolder<Object> resultHolder = mock(ExtensionResultHolder.class);
    doNothing().when(resultHolder).setResult(Mockito.<Object>any());
    doNothing().when(resultHolder).setThrowable(Mockito.<Throwable>any());
    resultHolder.setResult(BLCFieldUtils.NULL_FIELD);
    resultHolder.setThrowable(new Throwable());

    // Act
    ExtensionResultStatusType actualTemplateCacheKey = templateCacheExtensionManager
        .getTemplateCacheKey(BLCFieldUtils.NULL_FIELD, "Template", resultHolder);

    // Assert
    verify(resultHolder).setResult(isA(Object.class));
    verify(resultHolder).setThrowable(isA(Throwable.class));
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, actualTemplateCacheKey);
  }

  /**
   * Method under test:
   * {@link TemplateCacheExtensionManager#getTemplateCacheKey(Object, String, ExtensionResultHolder)}
   */
  @Test
  public void testGetTemplateCacheKey3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TemplateCacheExtensionManager templateCacheExtensionManager = new TemplateCacheExtensionManager();
    templateCacheExtensionManager.registerHandler(new TemplateCacheExtensionManager());
    ExtensionResultHolder<Object> resultHolder = mock(ExtensionResultHolder.class);
    doNothing().when(resultHolder).setResult(Mockito.<Object>any());
    doNothing().when(resultHolder).setThrowable(Mockito.<Throwable>any());
    resultHolder.setResult(BLCFieldUtils.NULL_FIELD);
    resultHolder.setThrowable(new Throwable());

    // Act
    ExtensionResultStatusType actualTemplateCacheKey = templateCacheExtensionManager
        .getTemplateCacheKey(BLCFieldUtils.NULL_FIELD, "Template", resultHolder);

    // Assert
    verify(resultHolder).setResult(isA(Object.class));
    verify(resultHolder).setThrowable(isA(Throwable.class));
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, actualTemplateCacheKey);
  }

  /**
   * Method under test:
   * {@link TemplateCacheExtensionManager#getTemplateCacheKey(Object, String, ExtensionResultHolder)}
   */
  @Test
  public void testGetTemplateCacheKey4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TemplateCacheExtensionHandler templateCacheExtensionHandler = mock(TemplateCacheExtensionHandler.class);
    when(templateCacheExtensionHandler.getTemplateCacheKey(Mockito.<Object>any(), Mockito.<String>any(),
        Mockito.<ExtensionResultHolder<Object>>any())).thenReturn(ExtensionResultStatusType.HANDLED);
    when(templateCacheExtensionHandler.isEnabled()).thenReturn(true);

    TemplateCacheExtensionManager templateCacheExtensionManager = new TemplateCacheExtensionManager();
    templateCacheExtensionManager.registerHandler(templateCacheExtensionHandler);
    ExtensionResultHolder<Object> resultHolder = mock(ExtensionResultHolder.class);
    doNothing().when(resultHolder).setResult(Mockito.<Object>any());
    doNothing().when(resultHolder).setThrowable(Mockito.<Throwable>any());
    resultHolder.setResult(BLCFieldUtils.NULL_FIELD);
    resultHolder.setThrowable(new Throwable());

    // Act
    ExtensionResultStatusType actualTemplateCacheKey = templateCacheExtensionManager
        .getTemplateCacheKey(BLCFieldUtils.NULL_FIELD, "Template", resultHolder);

    // Assert
    verify(templateCacheExtensionHandler).isEnabled();
    verify(resultHolder).setResult(isA(Object.class));
    verify(resultHolder).setThrowable(isA(Throwable.class));
    verify(templateCacheExtensionHandler).getTemplateCacheKey(isA(Object.class), eq("Template"),
        isA(ExtensionResultHolder.class));
    assertEquals(ExtensionResultStatusType.HANDLED, actualTemplateCacheKey);
  }

  /**
   * Method under test:
   * {@link TemplateCacheExtensionManager#getTemplateCacheKey(Object, String, ExtensionResultHolder)}
   */
  @Test
  public void testGetTemplateCacheKey5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TemplateCacheExtensionHandler templateCacheExtensionHandler = mock(TemplateCacheExtensionHandler.class);
    when(templateCacheExtensionHandler.getTemplateCacheKey(Mockito.<Object>any(), Mockito.<String>any(),
        Mockito.<ExtensionResultHolder<Object>>any())).thenReturn(ExtensionResultStatusType.HANDLED_STOP);
    when(templateCacheExtensionHandler.isEnabled()).thenReturn(true);

    TemplateCacheExtensionManager templateCacheExtensionManager = new TemplateCacheExtensionManager();
    templateCacheExtensionManager.registerHandler(templateCacheExtensionHandler);
    ExtensionResultHolder<Object> resultHolder = mock(ExtensionResultHolder.class);
    doNothing().when(resultHolder).setResult(Mockito.<Object>any());
    doNothing().when(resultHolder).setThrowable(Mockito.<Throwable>any());
    resultHolder.setResult(BLCFieldUtils.NULL_FIELD);
    resultHolder.setThrowable(new Throwable());

    // Act
    ExtensionResultStatusType actualTemplateCacheKey = templateCacheExtensionManager
        .getTemplateCacheKey(BLCFieldUtils.NULL_FIELD, "Template", resultHolder);

    // Assert
    verify(templateCacheExtensionHandler).isEnabled();
    verify(resultHolder).setResult(isA(Object.class));
    verify(resultHolder).setThrowable(isA(Throwable.class));
    verify(templateCacheExtensionHandler).getTemplateCacheKey(isA(Object.class), eq("Template"),
        isA(ExtensionResultHolder.class));
    assertEquals(ExtensionResultStatusType.HANDLED, actualTemplateCacheKey);
  }

  /**
   * Method under test:
   * {@link TemplateCacheExtensionManager#getTemplateCacheKey(Object, String, ExtensionResultHolder)}
   */
  @Test
  public void testGetTemplateCacheKey6() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TemplateCacheExtensionHandler templateCacheExtensionHandler = mock(TemplateCacheExtensionHandler.class);
    when(templateCacheExtensionHandler.isEnabled()).thenReturn(false);

    TemplateCacheExtensionManager templateCacheExtensionManager = new TemplateCacheExtensionManager();
    templateCacheExtensionManager.registerHandler(templateCacheExtensionHandler);
    ExtensionResultHolder<Object> resultHolder = mock(ExtensionResultHolder.class);
    doNothing().when(resultHolder).setResult(Mockito.<Object>any());
    doNothing().when(resultHolder).setThrowable(Mockito.<Throwable>any());
    resultHolder.setResult(BLCFieldUtils.NULL_FIELD);
    resultHolder.setThrowable(new Throwable());

    // Act
    ExtensionResultStatusType actualTemplateCacheKey = templateCacheExtensionManager
        .getTemplateCacheKey(BLCFieldUtils.NULL_FIELD, "Template", resultHolder);

    // Assert
    verify(templateCacheExtensionHandler).isEnabled();
    verify(resultHolder).setResult(isA(Object.class));
    verify(resultHolder).setThrowable(isA(Throwable.class));
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, actualTemplateCacheKey);
  }

  /**
   * Method under test:
   * {@link TemplateCacheExtensionManager#getTemplateName(Object, ExtensionResultHolder)}
   */
  @Test
  public void testGetTemplateName() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TemplateCacheExtensionManager templateCacheExtensionManager = new TemplateCacheExtensionManager();

    ExtensionResultHolder<Object> result = new ExtensionResultHolder<>();
    result.setResult(BLCFieldUtils.NULL_FIELD);
    result.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        templateCacheExtensionManager.getTemplateName(BLCFieldUtils.NULL_FIELD, result));
  }

  /**
   * Method under test:
   * {@link TemplateCacheExtensionManager#getTemplateName(Object, ExtensionResultHolder)}
   */
  @Test
  public void testGetTemplateName2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TemplateCacheExtensionManager templateCacheExtensionManager = new TemplateCacheExtensionManager();
    ExtensionResultHolder<Object> result = mock(ExtensionResultHolder.class);
    doNothing().when(result).setResult(Mockito.<Object>any());
    doNothing().when(result).setThrowable(Mockito.<Throwable>any());
    result.setResult(BLCFieldUtils.NULL_FIELD);
    result.setThrowable(new Throwable());

    // Act
    ExtensionResultStatusType actualTemplateName = templateCacheExtensionManager
        .getTemplateName(BLCFieldUtils.NULL_FIELD, result);

    // Assert
    verify(result).setResult(isA(Object.class));
    verify(result).setThrowable(isA(Throwable.class));
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, actualTemplateName);
  }

  /**
   * Method under test:
   * {@link TemplateCacheExtensionManager#getTemplateName(Object, ExtensionResultHolder)}
   */
  @Test
  public void testGetTemplateName3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TemplateCacheExtensionManager templateCacheExtensionManager = new TemplateCacheExtensionManager();
    templateCacheExtensionManager.registerHandler(new TemplateCacheExtensionManager());
    ExtensionResultHolder<Object> result = mock(ExtensionResultHolder.class);
    doNothing().when(result).setResult(Mockito.<Object>any());
    doNothing().when(result).setThrowable(Mockito.<Throwable>any());
    result.setResult(BLCFieldUtils.NULL_FIELD);
    result.setThrowable(new Throwable());

    // Act
    ExtensionResultStatusType actualTemplateName = templateCacheExtensionManager
        .getTemplateName(BLCFieldUtils.NULL_FIELD, result);

    // Assert
    verify(result).setResult(isA(Object.class));
    verify(result).setThrowable(isA(Throwable.class));
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, actualTemplateName);
  }

  /**
   * Method under test:
   * {@link TemplateCacheExtensionManager#getTemplateName(Object, ExtensionResultHolder)}
   */
  @Test
  public void testGetTemplateName4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TemplateCacheExtensionHandler templateCacheExtensionHandler = mock(TemplateCacheExtensionHandler.class);
    when(templateCacheExtensionHandler.getTemplateName(Mockito.<Object>any(),
        Mockito.<ExtensionResultHolder<Object>>any())).thenReturn(ExtensionResultStatusType.HANDLED);
    when(templateCacheExtensionHandler.isEnabled()).thenReturn(true);

    TemplateCacheExtensionManager templateCacheExtensionManager = new TemplateCacheExtensionManager();
    templateCacheExtensionManager.registerHandler(templateCacheExtensionHandler);
    ExtensionResultHolder<Object> result = mock(ExtensionResultHolder.class);
    doNothing().when(result).setResult(Mockito.<Object>any());
    doNothing().when(result).setThrowable(Mockito.<Throwable>any());
    result.setResult(BLCFieldUtils.NULL_FIELD);
    result.setThrowable(new Throwable());

    // Act
    ExtensionResultStatusType actualTemplateName = templateCacheExtensionManager
        .getTemplateName(BLCFieldUtils.NULL_FIELD, result);

    // Assert
    verify(templateCacheExtensionHandler).isEnabled();
    verify(result).setResult(isA(Object.class));
    verify(result).setThrowable(isA(Throwable.class));
    verify(templateCacheExtensionHandler).getTemplateName(isA(Object.class), isA(ExtensionResultHolder.class));
    assertEquals(ExtensionResultStatusType.HANDLED, actualTemplateName);
  }

  /**
   * Method under test:
   * {@link TemplateCacheExtensionManager#getTemplateName(Object, ExtensionResultHolder)}
   */
  @Test
  public void testGetTemplateName5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TemplateCacheExtensionHandler templateCacheExtensionHandler = mock(TemplateCacheExtensionHandler.class);
    when(templateCacheExtensionHandler.getTemplateName(Mockito.<Object>any(),
        Mockito.<ExtensionResultHolder<Object>>any())).thenReturn(ExtensionResultStatusType.HANDLED_STOP);
    when(templateCacheExtensionHandler.isEnabled()).thenReturn(true);

    TemplateCacheExtensionManager templateCacheExtensionManager = new TemplateCacheExtensionManager();
    templateCacheExtensionManager.registerHandler(templateCacheExtensionHandler);
    ExtensionResultHolder<Object> result = mock(ExtensionResultHolder.class);
    doNothing().when(result).setResult(Mockito.<Object>any());
    doNothing().when(result).setThrowable(Mockito.<Throwable>any());
    result.setResult(BLCFieldUtils.NULL_FIELD);
    result.setThrowable(new Throwable());

    // Act
    ExtensionResultStatusType actualTemplateName = templateCacheExtensionManager
        .getTemplateName(BLCFieldUtils.NULL_FIELD, result);

    // Assert
    verify(templateCacheExtensionHandler).isEnabled();
    verify(result).setResult(isA(Object.class));
    verify(result).setThrowable(isA(Throwable.class));
    verify(templateCacheExtensionHandler).getTemplateName(isA(Object.class), isA(ExtensionResultHolder.class));
    assertEquals(ExtensionResultStatusType.HANDLED, actualTemplateName);
  }

  /**
   * Method under test:
   * {@link TemplateCacheExtensionManager#getTemplateName(Object, ExtensionResultHolder)}
   */
  @Test
  public void testGetTemplateName6() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TemplateCacheExtensionHandler templateCacheExtensionHandler = mock(TemplateCacheExtensionHandler.class);
    when(templateCacheExtensionHandler.isEnabled()).thenReturn(false);

    TemplateCacheExtensionManager templateCacheExtensionManager = new TemplateCacheExtensionManager();
    templateCacheExtensionManager.registerHandler(templateCacheExtensionHandler);
    ExtensionResultHolder<Object> result = mock(ExtensionResultHolder.class);
    doNothing().when(result).setResult(Mockito.<Object>any());
    doNothing().when(result).setThrowable(Mockito.<Throwable>any());
    result.setResult(BLCFieldUtils.NULL_FIELD);
    result.setThrowable(new Throwable());

    // Act
    ExtensionResultStatusType actualTemplateName = templateCacheExtensionManager
        .getTemplateName(BLCFieldUtils.NULL_FIELD, result);

    // Assert
    verify(templateCacheExtensionHandler).isEnabled();
    verify(result).setResult(isA(Object.class));
    verify(result).setThrowable(isA(Throwable.class));
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, actualTemplateName);
  }
}
