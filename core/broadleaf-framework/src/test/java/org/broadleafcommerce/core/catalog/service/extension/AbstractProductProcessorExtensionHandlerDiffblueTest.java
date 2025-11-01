/*-
 * #%L
 * BroadleafCommerce Framework
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
package org.broadleafcommerce.core.catalog.service.extension;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.ArrayList;
import java.util.List;
import org.broadleafcommerce.common.extension.ExtensionResultStatusType;
import org.broadleafcommerce.core.catalog.domain.Product;
import org.broadleafcommerce.core.catalog.domain.ProductBundleImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {AbstractProductProcessorExtensionHandler.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class AbstractProductProcessorExtensionHandlerDiffblueTest {
  @Autowired
  private AbstractProductProcessorExtensionHandler abstractProductProcessorExtensionHandler;

  /**
   * Method under test:
   * {@link AbstractProductProcessorExtensionHandler#expandProduct(Product, List)}
   */
  @Test
  public void testExpandProduct() {
    // Arrange
    ProductBundleImpl product = new ProductBundleImpl();

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        abstractProductProcessorExtensionHandler.expandProduct(product, new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link AbstractProductProcessorExtensionHandler#expandProduct(Product, List)}
   */
  @Test
  public void testExpandProduct2() {
    // Arrange
    ProductBundleImpl product = mock(ProductBundleImpl.class);

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        abstractProductProcessorExtensionHandler.expandProduct(product, new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link AbstractProductProcessorExtensionHandler#expandProduct(Product, List)}
   */
  @Test
  public void testExpandProduct3() {
    // Arrange
    ProductBundleImpl product = new ProductBundleImpl();

    ArrayList<Long> returnList = new ArrayList<>();
    returnList.add(1L);

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        abstractProductProcessorExtensionHandler.expandProduct(product, returnList));
  }

  /**
   * Method under test:
   * {@link AbstractProductProcessorExtensionHandler#expandProduct(Product, List)}
   */
  @Test
  public void testExpandProduct4() {
    // Arrange
    ProductBundleImpl product = new ProductBundleImpl();

    ArrayList<Long> returnList = new ArrayList<>();
    returnList.add(0L);
    returnList.add(1L);

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        abstractProductProcessorExtensionHandler.expandProduct(product, returnList));
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link AbstractProductProcessorExtensionHandler}
   */
  @Test
  public void testNewAbstractProductProcessorExtensionHandler() {
    // Arrange and Act
    AbstractProductProcessorExtensionHandler actualAbstractProductProcessorExtensionHandler = new AbstractProductProcessorExtensionHandler();

    // Assert
    assertEquals(0, actualAbstractProductProcessorExtensionHandler.getPriority());
    assertTrue(actualAbstractProductProcessorExtensionHandler.isEnabled());
  }
}
