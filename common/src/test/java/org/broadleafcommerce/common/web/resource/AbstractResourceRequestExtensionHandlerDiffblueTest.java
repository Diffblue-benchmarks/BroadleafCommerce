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
package org.broadleafcommerce.common.web.resource;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.common.extension.ExtensionResultHolder;
import org.broadleafcommerce.common.extension.ExtensionResultStatusType;
import org.broadleafcommerce.common.util.BLCFieldUtils;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {AbstractResourceRequestExtensionHandler.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class AbstractResourceRequestExtensionHandlerDiffblueTest {
  @Autowired
  private AbstractResourceRequestExtensionHandler abstractResourceRequestExtensionHandler;

  /**
   * Test {@link AbstractResourceRequestExtensionHandler#getModifiedResource(String,
   * ExtensionResultHolder)}.
   *
   * <p>Method under test: {@link
   * AbstractResourceRequestExtensionHandler#getModifiedResource(String, ExtensionResultHolder)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType AbstractResourceRequestExtensionHandler.getModifiedResource(String, ExtensionResultHolder)"
  })
  public void testGetModifiedResource() {
    // Arrange
    ExtensionResultHolder erh = new ExtensionResultHolder();
    erh.setResult(BLCFieldUtils.NULL_FIELD);
    erh.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(
        ExtensionResultStatusType.NOT_HANDLED,
        abstractResourceRequestExtensionHandler.getModifiedResource("Path", erh));
  }

  /**
   * Test {@link AbstractResourceRequestExtensionHandler#getOverrideResource(String,
   * ExtensionResultHolder)}.
   *
   * <p>Method under test: {@link
   * AbstractResourceRequestExtensionHandler#getOverrideResource(String, ExtensionResultHolder)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType AbstractResourceRequestExtensionHandler.getOverrideResource(String, ExtensionResultHolder)"
  })
  public void testGetOverrideResource() {
    // Arrange
    ExtensionResultHolder erh = new ExtensionResultHolder();
    erh.setResult(BLCFieldUtils.NULL_FIELD);
    erh.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(
        ExtensionResultStatusType.NOT_HANDLED,
        abstractResourceRequestExtensionHandler.getOverrideResource("Path", erh));
  }

  /**
   * Test new {@link AbstractResourceRequestExtensionHandler} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link
   * AbstractResourceRequestExtensionHandler}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractResourceRequestExtensionHandler.<init>()"})
  public void testNewAbstractResourceRequestExtensionHandler() {
    // Arrange and Act
    AbstractResourceRequestExtensionHandler actualAbstractResourceRequestExtensionHandler =
        new AbstractResourceRequestExtensionHandler();

    // Assert
    assertEquals(0, actualAbstractResourceRequestExtensionHandler.getPriority());
    assertTrue(actualAbstractResourceRequestExtensionHandler.isEnabled());
  }
}
