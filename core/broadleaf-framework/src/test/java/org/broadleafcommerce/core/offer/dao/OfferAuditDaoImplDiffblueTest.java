/*-
 * #%L
 * BroadleafCommerce Framework
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
package org.broadleafcommerce.core.offer.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.junit.Test;

public class OfferAuditDaoImplDiffblueTest {
  /**
   * Test {@link OfferAuditDaoImpl#getOrderId(Order)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>When {@link NullOrderImpl} {@link NullOrderImpl#getId()} return one.</li>
   *   <li>Then return longValue is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferAuditDaoImpl#getOrderId(Order)}
   */
  @Test
  public void testGetOrderId_givenOne_whenNullOrderImplGetIdReturnOne_thenReturnLongValueIsOne() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferAuditDaoImpl offerAuditDaoImpl = new OfferAuditDaoImpl();
    NullOrderImpl order = mock(NullOrderImpl.class);
    when(order.getId()).thenReturn(1L);

    // Act
    Long actualOrderId = offerAuditDaoImpl.getOrderId(order);

    // Assert
    verify(order).getId();
    assertEquals(1L, actualOrderId.longValue());
  }

  /**
   * Test {@link OfferAuditDaoImpl#getOrderId(Order)}.
   * <ul>
   *   <li>When {@link NullOrderImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferAuditDaoImpl#getOrderId(Order)}
   */
  @Test
  public void testGetOrderId_whenNullOrderImpl_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferAuditDaoImpl offerAuditDaoImpl = new OfferAuditDaoImpl();

    // Act and Assert
    assertNull(offerAuditDaoImpl.getOrderId(new NullOrderImpl()));
  }

  /**
   * Test {@link OfferAuditDaoImpl#countOfferCodeUses(Order, Long)} with
   * {@code order}, {@code offerCodeId}.
   * <ul>
   *   <li>When {@link NullOrderImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferAuditDaoImpl#countOfferCodeUses(Order, Long)}
   */
  @Test
  public void testCountOfferCodeUsesWithOrderOfferCodeId_whenNullOrderImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferAuditDaoImpl offerAuditDaoImpl = new OfferAuditDaoImpl();

    // Act and Assert
    assertNull(offerAuditDaoImpl.countOfferCodeUses(new NullOrderImpl(), 1L));
  }

  /**
   * Test {@link OfferAuditDaoImpl#countOfferCodeUses(Order, Long)} with
   * {@code order}, {@code offerCodeId}.
   * <ul>
   *   <li>When {@link Order}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferAuditDaoImpl#countOfferCodeUses(Order, Long)}
   */
  @Test
  public void testCountOfferCodeUsesWithOrderOfferCodeId_whenOrder() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new OfferAuditDaoImpl()).countOfferCodeUses(mock(Order.class), 1L));
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OfferAuditDaoImpl#setCurrentDateResolution(Long)}
   *   <li>{@link OfferAuditDaoImpl#getCurrentDateResolution()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    OfferAuditDaoImpl offerAuditDaoImpl = new OfferAuditDaoImpl();

    // Act
    offerAuditDaoImpl.setCurrentDateResolution(1L);

    // Assert that nothing has changed
    assertEquals(1L, offerAuditDaoImpl.getCurrentDateResolution().longValue());
  }
}
