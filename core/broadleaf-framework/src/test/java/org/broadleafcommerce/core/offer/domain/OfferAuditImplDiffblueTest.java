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
package org.broadleafcommerce.core.offer.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.Date;
import org.junit.Test;

public class OfferAuditImplDiffblueTest {
  /**
   * Test {@link OfferAuditImpl#equals(Object)}, and
   * {@link OfferAuditImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OfferAuditImpl#equals(Object)}
   *   <li>{@link OfferAuditImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    OfferAuditImpl offerAuditImpl = new OfferAuditImpl();
    offerAuditImpl.setAccountId(OfferAuditImpl.serialVersionUID);
    offerAuditImpl.setCustomerId(OfferAuditImpl.serialVersionUID);
    offerAuditImpl.setId(OfferAuditImpl.serialVersionUID);
    offerAuditImpl.setOfferCodeId(OfferAuditImpl.serialVersionUID);
    offerAuditImpl.setOfferId(OfferAuditImpl.serialVersionUID);
    offerAuditImpl.setOrderId(OfferAuditImpl.serialVersionUID);
    offerAuditImpl
        .setRedeemedDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    OfferAuditImpl offerAuditImpl2 = new OfferAuditImpl();
    offerAuditImpl2.setAccountId(OfferAuditImpl.serialVersionUID);
    offerAuditImpl2.setCustomerId(OfferAuditImpl.serialVersionUID);
    offerAuditImpl2.setId(OfferAuditImpl.serialVersionUID);
    offerAuditImpl2.setOfferCodeId(OfferAuditImpl.serialVersionUID);
    offerAuditImpl2.setOfferId(OfferAuditImpl.serialVersionUID);
    offerAuditImpl2.setOrderId(OfferAuditImpl.serialVersionUID);
    offerAuditImpl2
        .setRedeemedDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    // Act and Assert
    assertEquals(offerAuditImpl, offerAuditImpl2);
    int expectedHashCodeResult = offerAuditImpl.hashCode();
    assertEquals(expectedHashCodeResult, offerAuditImpl2.hashCode());
  }

  /**
   * Test {@link OfferAuditImpl#equals(Object)}, and
   * {@link OfferAuditImpl#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OfferAuditImpl#equals(Object)}
   *   <li>{@link OfferAuditImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    OfferAuditImpl offerAuditImpl = new OfferAuditImpl();
    offerAuditImpl.setAccountId(OfferAuditImpl.serialVersionUID);
    offerAuditImpl.setCustomerId(OfferAuditImpl.serialVersionUID);
    offerAuditImpl.setId(OfferAuditImpl.serialVersionUID);
    offerAuditImpl.setOfferCodeId(OfferAuditImpl.serialVersionUID);
    offerAuditImpl.setOfferId(OfferAuditImpl.serialVersionUID);
    offerAuditImpl.setOrderId(OfferAuditImpl.serialVersionUID);
    offerAuditImpl
        .setRedeemedDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    // Act and Assert
    assertEquals(offerAuditImpl, offerAuditImpl);
    int expectedHashCodeResult = offerAuditImpl.hashCode();
    assertEquals(expectedHashCodeResult, offerAuditImpl.hashCode());
  }

  /**
   * Test {@link OfferAuditImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferAuditImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    OfferAuditImpl offerAuditImpl = new OfferAuditImpl();
    offerAuditImpl.setAccountId(2L);
    offerAuditImpl.setCustomerId(OfferAuditImpl.serialVersionUID);
    offerAuditImpl.setId(OfferAuditImpl.serialVersionUID);
    offerAuditImpl.setOfferCodeId(OfferAuditImpl.serialVersionUID);
    offerAuditImpl.setOfferId(OfferAuditImpl.serialVersionUID);
    offerAuditImpl.setOrderId(OfferAuditImpl.serialVersionUID);
    offerAuditImpl
        .setRedeemedDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    OfferAuditImpl offerAuditImpl2 = new OfferAuditImpl();
    offerAuditImpl2.setAccountId(OfferAuditImpl.serialVersionUID);
    offerAuditImpl2.setCustomerId(OfferAuditImpl.serialVersionUID);
    offerAuditImpl2.setId(OfferAuditImpl.serialVersionUID);
    offerAuditImpl2.setOfferCodeId(OfferAuditImpl.serialVersionUID);
    offerAuditImpl2.setOfferId(OfferAuditImpl.serialVersionUID);
    offerAuditImpl2.setOrderId(OfferAuditImpl.serialVersionUID);
    offerAuditImpl2
        .setRedeemedDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    // Act and Assert
    assertNotEquals(offerAuditImpl, offerAuditImpl2);
  }

  /**
   * Test {@link OfferAuditImpl#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferAuditImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    OfferAuditImpl offerAuditImpl = new OfferAuditImpl();
    offerAuditImpl.setAccountId(OfferAuditImpl.serialVersionUID);
    offerAuditImpl.setCustomerId(OfferAuditImpl.serialVersionUID);
    offerAuditImpl.setId(OfferAuditImpl.serialVersionUID);
    offerAuditImpl.setOfferCodeId(OfferAuditImpl.serialVersionUID);
    offerAuditImpl.setOfferId(OfferAuditImpl.serialVersionUID);
    offerAuditImpl.setOrderId(OfferAuditImpl.serialVersionUID);
    offerAuditImpl
        .setRedeemedDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    // Act and Assert
    assertNotEquals(offerAuditImpl, null);
  }

  /**
   * Test {@link OfferAuditImpl#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferAuditImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    OfferAuditImpl offerAuditImpl = new OfferAuditImpl();
    offerAuditImpl.setAccountId(OfferAuditImpl.serialVersionUID);
    offerAuditImpl.setCustomerId(OfferAuditImpl.serialVersionUID);
    offerAuditImpl.setId(OfferAuditImpl.serialVersionUID);
    offerAuditImpl.setOfferCodeId(OfferAuditImpl.serialVersionUID);
    offerAuditImpl.setOfferId(OfferAuditImpl.serialVersionUID);
    offerAuditImpl.setOrderId(OfferAuditImpl.serialVersionUID);
    offerAuditImpl
        .setRedeemedDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    // Act and Assert
    assertNotEquals(offerAuditImpl, "Different type to OfferAuditImpl");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link OfferAuditImpl}
   *   <li>{@link OfferAuditImpl#setAccountId(Long)}
   *   <li>{@link OfferAuditImpl#setCustomerId(Long)}
   *   <li>{@link OfferAuditImpl#setId(Long)}
   *   <li>{@link OfferAuditImpl#setOfferCodeId(Long)}
   *   <li>{@link OfferAuditImpl#setOfferId(Long)}
   *   <li>{@link OfferAuditImpl#setOrderId(Long)}
   *   <li>{@link OfferAuditImpl#setRedeemedDate(Date)}
   *   <li>{@link OfferAuditImpl#getAccountId()}
   *   <li>{@link OfferAuditImpl#getCustomerId()}
   *   <li>{@link OfferAuditImpl#getId()}
   *   <li>{@link OfferAuditImpl#getOfferCodeId()}
   *   <li>{@link OfferAuditImpl#getOfferId()}
   *   <li>{@link OfferAuditImpl#getOrderId()}
   *   <li>{@link OfferAuditImpl#getRedeemedDate()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    OfferAuditImpl actualOfferAuditImpl = new OfferAuditImpl();
    actualOfferAuditImpl.setAccountId(OfferAuditImpl.serialVersionUID);
    actualOfferAuditImpl.setCustomerId(OfferAuditImpl.serialVersionUID);
    actualOfferAuditImpl.setId(OfferAuditImpl.serialVersionUID);
    actualOfferAuditImpl.setOfferCodeId(OfferAuditImpl.serialVersionUID);
    actualOfferAuditImpl.setOfferId(OfferAuditImpl.serialVersionUID);
    actualOfferAuditImpl.setOrderId(OfferAuditImpl.serialVersionUID);
    Date redeemedDate = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    actualOfferAuditImpl.setRedeemedDate(redeemedDate);
    Long actualAccountId = actualOfferAuditImpl.getAccountId();
    Long actualCustomerId = actualOfferAuditImpl.getCustomerId();
    Long actualId = actualOfferAuditImpl.getId();
    Long actualOfferCodeId = actualOfferAuditImpl.getOfferCodeId();
    Long actualOfferId = actualOfferAuditImpl.getOfferId();
    Long actualOrderId = actualOfferAuditImpl.getOrderId();
    Date actualRedeemedDate = actualOfferAuditImpl.getRedeemedDate();

    // Assert that nothing has changed
    assertEquals(OfferAuditImpl.serialVersionUID, actualAccountId.longValue());
    assertEquals(OfferAuditImpl.serialVersionUID, actualCustomerId.longValue());
    assertEquals(OfferAuditImpl.serialVersionUID, actualId.longValue());
    assertEquals(OfferAuditImpl.serialVersionUID, actualOfferCodeId.longValue());
    assertEquals(OfferAuditImpl.serialVersionUID, actualOfferId.longValue());
    assertEquals(OfferAuditImpl.serialVersionUID, actualOrderId.longValue());
    assertSame(redeemedDate, actualRedeemedDate);
  }
}
