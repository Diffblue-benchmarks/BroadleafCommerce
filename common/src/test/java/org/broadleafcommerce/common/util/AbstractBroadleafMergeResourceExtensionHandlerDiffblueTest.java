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
package org.broadleafcommerce.common.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import java.util.Locale;
import org.broadleafcommerce.common.extension.ExtensionResultHolder;
import org.broadleafcommerce.common.extension.ExtensionResultStatusType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {AbstractBroadleafMergeResourceExtensionHandler.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class AbstractBroadleafMergeResourceExtensionHandlerDiffblueTest {
  @Autowired
  private AbstractBroadleafMergeResourceExtensionHandler abstractBroadleafMergeResourceExtensionHandler;

  /**
   * Method under test: default or parameterless constructor of
   * {@link AbstractBroadleafMergeResourceExtensionHandler}
   */
  @Test
  public void testNewAbstractBroadleafMergeResourceExtensionHandler() {
    // Arrange and Act
    AbstractBroadleafMergeResourceExtensionHandler actualAbstractBroadleafMergeResourceExtensionHandler = new AbstractBroadleafMergeResourceExtensionHandler();

    // Assert
    assertEquals(0, actualAbstractBroadleafMergeResourceExtensionHandler.getPriority());
    assertTrue(actualAbstractBroadleafMergeResourceExtensionHandler.isEnabled());
  }

  /**
   * Method under test:
   * {@link AbstractBroadleafMergeResourceExtensionHandler#resolveMessageSource(String, Locale, ExtensionResultHolder)}
   */
  @Test
  public void testResolveMessageSource() {
    // Arrange
    Locale locale = Locale.getDefault();

    ExtensionResultHolder<String> result = new ExtensionResultHolder<>();
    result.setResult("Result");
    result.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        abstractBroadleafMergeResourceExtensionHandler.resolveMessageSource("Code", locale, result));
  }

  /**
   * Method under test:
   * {@link AbstractBroadleafMergeResourceExtensionHandler#resolveMessageSource(String, Locale, ExtensionResultHolder)}
   */
  @Test
  public void testResolveMessageSource2() {
    // Arrange
    Locale locale = Locale.getDefault();
    ExtensionResultHolder<String> result = mock(ExtensionResultHolder.class);
    doNothing().when(result).setResult(Mockito.<String>any());
    doNothing().when(result).setThrowable(Mockito.<Throwable>any());
    result.setResult("Result");
    result.setThrowable(new Throwable());

    // Act
    ExtensionResultStatusType actualResolveMessageSourceResult = abstractBroadleafMergeResourceExtensionHandler
        .resolveMessageSource("Code", locale, result);

    // Assert
    verify(result).setResult(eq("Result"));
    verify(result).setThrowable(isA(Throwable.class));
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, actualResolveMessageSourceResult);
  }
}
