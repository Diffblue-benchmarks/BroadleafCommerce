/*-
 * #%L
 * BroadleafCommerce Admin Module
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
package org.broadleafcommerce.admin.web.rulebuilder.service;

import static org.junit.Assert.assertEquals;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class SkuFieldServiceImplDiffblueTest {
  @InjectMocks
  private SkuFieldServiceImpl skuFieldServiceImpl;

  /**
   * Test {@link SkuFieldServiceImpl#init()}.
   * <p>
   * Method under test: {@link SkuFieldServiceImpl#init()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SkuFieldServiceImpl.init()"})
  public void testInit() {
    // Arrange and Act
    skuFieldServiceImpl.init();

    // Assert
    assertEquals(5, skuFieldServiceImpl.getFields().size());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link SkuFieldServiceImpl#getDtoClassName()}
   *   <li>{@link SkuFieldServiceImpl#getName()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String SkuFieldServiceImpl.getDtoClassName()", "String SkuFieldServiceImpl.getName()"})
  public void testGettersAndSetters() {
    // Arrange
    SkuFieldServiceImpl skuFieldServiceImpl = new SkuFieldServiceImpl();

    // Act
    String actualDtoClassName = skuFieldServiceImpl.getDtoClassName();

    // Assert
    assertEquals("SKU_FIELDS", skuFieldServiceImpl.getName());
    assertEquals("org.broadleafcommerce.core.catalog.domain.SkuImpl", actualDtoClassName);
  }
}
