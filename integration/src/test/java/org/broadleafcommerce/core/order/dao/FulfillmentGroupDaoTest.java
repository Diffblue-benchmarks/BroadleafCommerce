/*-
 * #%L
 * BroadleafCommerce Integration
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
package org.broadleafcommerce.core.order.dao;

import org.broadleafcommerce.core.order.domain.FulfillmentGroup;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.test.CommonSetupBaseTest;
import org.springframework.transaction.annotation.Transactional;
import org.testng.annotations.Test;
import javax.annotation.Resource;

public class FulfillmentGroupDaoTest extends CommonSetupBaseTest {
  private Long defaultFulfillmentGroupOrderId;

  private Long defaultFulfillmentGroupId;

  private Long fulfillmentGroupId;

  @Resource private FulfillmentGroupDao fulfillmentGroupDao;

  @Resource private OrderDao orderDao;

  @Test(
      groups = {"readDefaultFulfillmentGroupForOrder"},
      dependsOnGroups = {"createDefaultFulfillmentGroup"})
  @Transactional
  public void readDefaultFulfillmentGroupForOrder() {
    Order order = orderDao.readOrderById(defaultFulfillmentGroupOrderId);
    assert order != null;
    assert order.getId() == defaultFulfillmentGroupOrderId;
    FulfillmentGroup fg = fulfillmentGroupDao.readDefaultFulfillmentGroupForOrder(order);
    assert fg.getId() != null;
    assert fg.getId().equals(defaultFulfillmentGroupId);
  }

  @Test(
      groups = {"readDefaultFulfillmentGroupForId"},
      dependsOnGroups = {"createDefaultFulfillmentGroup"})
  @Transactional
  public void readDefaultFulfillmentGroupForId() {
    FulfillmentGroup fg = fulfillmentGroupDao.readFulfillmentGroupById(defaultFulfillmentGroupId);
    assert fg != null;
    assert fg.getId() != null;
    assert fg.getId().equals(defaultFulfillmentGroupId);
  }

  @Test(
      groups = {"readFulfillmentGroupsForId"},
      dependsOnGroups = {"createFulfillmentGroup"})
  @Transactional
  public void readFulfillmentGroupsForId() {
    FulfillmentGroup fg = fulfillmentGroupDao.readFulfillmentGroupById(fulfillmentGroupId);
    assert fg != null;
    assert fg.getId() != null;
  }
}
