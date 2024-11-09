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
package org.broadleafcommerce.common.web.resource;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import org.broadleafcommerce.common.extension.ExtensionResultHolder;
import org.broadleafcommerce.common.extension.ExtensionResultStatusType;
import org.broadleafcommerce.common.util.BLCFieldUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {AbstractResourceRequestExtensionHandler.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class AbstractResourceRequestExtensionHandlerDiffblueTest {
  @Autowired
  private AbstractResourceRequestExtensionHandler abstractResourceRequestExtensionHandler;

  /**
   * Test
   * {@link AbstractResourceRequestExtensionHandler#getModifiedResource(String, ExtensionResultHolder)}.
   * <ul>
   *   <li>Then calls {@link ExtensionResultHolder#setResult(Object)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractResourceRequestExtensionHandler#getModifiedResource(String, ExtensionResultHolder)}
   */
  @Test
  public void testGetModifiedResource_thenCallsSetResult() {
    // Arrange
    AbstractResourceRequestExtensionHandler abstractResourceRequestExtensionHandler2 = new AbstractResourceRequestExtensionHandler();
    ExtensionResultHolder erh = mock(ExtensionResultHolder.class);
    doNothing().when(erh).setResult(Mockito.<Object>any());
    doNothing().when(erh).setThrowable(Mockito.<Throwable>any());
    erh.setResult(BLCFieldUtils.NULL_FIELD);
    erh.setThrowable(new Throwable());

    // Act
    ExtensionResultStatusType actualModifiedResource = abstractResourceRequestExtensionHandler2
        .getModifiedResource("Path", erh);

    // Assert
    verify(erh).setResult(isA(Object.class));
    verify(erh).setThrowable(isA(Throwable.class));
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, actualModifiedResource);
  }

  /**
   * Test
   * {@link AbstractResourceRequestExtensionHandler#getModifiedResource(String, ExtensionResultHolder)}.
   * <ul>
   *   <li>When {@link ExtensionResultHolder} (default constructor) Result is
   * {@link BLCFieldUtils#NULL_FIELD}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractResourceRequestExtensionHandler#getModifiedResource(String, ExtensionResultHolder)}
   */
  @Test
  public void testGetModifiedResource_whenExtensionResultHolderResultIsNull_field() {
    // Arrange
    AbstractResourceRequestExtensionHandler abstractResourceRequestExtensionHandler2 = new AbstractResourceRequestExtensionHandler();

    ExtensionResultHolder erh = new ExtensionResultHolder();
    erh.setResult(BLCFieldUtils.NULL_FIELD);
    erh.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        abstractResourceRequestExtensionHandler2.getModifiedResource("Path", erh));
  }

  /**
   * Test
   * {@link AbstractResourceRequestExtensionHandler#getOverrideResource(String, ExtensionResultHolder)}.
   * <ul>
   *   <li>Then calls {@link ExtensionResultHolder#setResult(Object)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractResourceRequestExtensionHandler#getOverrideResource(String, ExtensionResultHolder)}
   */
  @Test
  public void testGetOverrideResource_thenCallsSetResult() {
    // Arrange
    AbstractResourceRequestExtensionHandler abstractResourceRequestExtensionHandler2 = new AbstractResourceRequestExtensionHandler();
    ExtensionResultHolder erh = mock(ExtensionResultHolder.class);
    doNothing().when(erh).setResult(Mockito.<Object>any());
    doNothing().when(erh).setThrowable(Mockito.<Throwable>any());
    erh.setResult(BLCFieldUtils.NULL_FIELD);
    erh.setThrowable(new Throwable());

    // Act
    ExtensionResultStatusType actualOverrideResource = abstractResourceRequestExtensionHandler2
        .getOverrideResource("Path", erh);

    // Assert
    verify(erh).setResult(isA(Object.class));
    verify(erh).setThrowable(isA(Throwable.class));
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, actualOverrideResource);
  }

  /**
   * Test
   * {@link AbstractResourceRequestExtensionHandler#getOverrideResource(String, ExtensionResultHolder)}.
   * <ul>
   *   <li>When {@link ExtensionResultHolder} (default constructor) Result is
   * {@link BLCFieldUtils#NULL_FIELD}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractResourceRequestExtensionHandler#getOverrideResource(String, ExtensionResultHolder)}
   */
  @Test
  public void testGetOverrideResource_whenExtensionResultHolderResultIsNull_field() {
    // Arrange
    AbstractResourceRequestExtensionHandler abstractResourceRequestExtensionHandler2 = new AbstractResourceRequestExtensionHandler();

    ExtensionResultHolder erh = new ExtensionResultHolder();
    erh.setResult(BLCFieldUtils.NULL_FIELD);
    erh.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        abstractResourceRequestExtensionHandler2.getOverrideResource("Path", erh));
  }

  /**
   * Test new {@link AbstractResourceRequestExtensionHandler} (default
   * constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link AbstractResourceRequestExtensionHandler}
   */
  @Test
  public void testNewAbstractResourceRequestExtensionHandler() {
    // Arrange and Act
    AbstractResourceRequestExtensionHandler actualAbstractResourceRequestExtensionHandler = new AbstractResourceRequestExtensionHandler();

    // Assert
    assertEquals(0, actualAbstractResourceRequestExtensionHandler.getPriority());
    assertTrue(actualAbstractResourceRequestExtensionHandler.isEnabled());
  }
}
