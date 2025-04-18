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
package org.broadleafcommerce.common.event;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.common.util.BLCFieldUtils;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class OrderSubmittedEventDiffblueTest {
  /**
   * Test {@link OrderSubmittedEvent#OrderSubmittedEvent(Object, Long, String)}.
   * <ul>
   *   <li>When {@link BLCFieldUtils#NULL_FIELD}.</li>
   *   <li>Then return OrderNumber is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderSubmittedEvent#OrderSubmittedEvent(Object, Long, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OrderSubmittedEvent.<init>(Object, Long, String)"})
  public void testNewOrderSubmittedEvent_whenNull_field_thenReturnOrderNumberIs42() {
    // Arrange
    Object object = BLCFieldUtils.NULL_FIELD;

    // Act
    OrderSubmittedEvent actualOrderSubmittedEvent = new OrderSubmittedEvent(object, 1L, "42");

    // Assert
    assertEquals("42", actualOrderSubmittedEvent.getOrderNumber());
    assertNull(actualOrderSubmittedEvent.getCatalogId());
    assertNull(actualOrderSubmittedEvent.getProfileId());
    assertNull(actualOrderSubmittedEvent.getSiteId());
    assertNull(actualOrderSubmittedEvent.getCurrencyCode());
    assertNull(actualOrderSubmittedEvent.getLocaleCode());
    assertNull(actualOrderSubmittedEvent.getTimeZoneId());
    assertEquals(1L, actualOrderSubmittedEvent.getOrderId().longValue());
    assertSame(object, actualOrderSubmittedEvent.getSource());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OrderSubmittedEvent#getOrderId()}
   *   <li>{@link OrderSubmittedEvent#getOrderNumber()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Long OrderSubmittedEvent.getOrderId()", "String OrderSubmittedEvent.getOrderNumber()"})
  public void testGettersAndSetters() {
    // Arrange
    OrderSubmittedEvent orderSubmittedEvent = new OrderSubmittedEvent(BLCFieldUtils.NULL_FIELD, 1L, "42");

    // Act
    Long actualOrderId = orderSubmittedEvent.getOrderId();

    // Assert
    assertEquals("42", orderSubmittedEvent.getOrderNumber());
    assertEquals(1L, actualOrderId.longValue());
  }
}
