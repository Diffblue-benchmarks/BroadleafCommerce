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
public class FulfillmentGroupFieldServiceImplDiffblueTest {
  @InjectMocks
  private FulfillmentGroupFieldServiceImpl fulfillmentGroupFieldServiceImpl;

  /**
   * Test {@link FulfillmentGroupFieldServiceImpl#init()}.
   * <p>
   * Method under test: {@link FulfillmentGroupFieldServiceImpl#init()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FulfillmentGroupFieldServiceImpl.init()"})
  public void testInit() {
    // Arrange and Act
    fulfillmentGroupFieldServiceImpl.init();

    // Assert
    assertEquals(19, fulfillmentGroupFieldServiceImpl.getFields().size());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link FulfillmentGroupFieldServiceImpl#getDtoClassName()}
   *   <li>{@link FulfillmentGroupFieldServiceImpl#getName()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String FulfillmentGroupFieldServiceImpl.getDtoClassName()",
      "String FulfillmentGroupFieldServiceImpl.getName()"})
  public void testGettersAndSetters() {
    // Arrange
    FulfillmentGroupFieldServiceImpl fulfillmentGroupFieldServiceImpl = new FulfillmentGroupFieldServiceImpl();

    // Act
    String actualDtoClassName = fulfillmentGroupFieldServiceImpl.getDtoClassName();

    // Assert
    assertEquals("FULFILLMENT_GROUP_FIELDS", fulfillmentGroupFieldServiceImpl.getName());
    assertEquals("org.broadleafcommerce.core.order.domain.FulfillmentGroupImpl", actualDtoClassName);
  }
}
