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
package org.broadleafcommerce.core.inventory.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.Date;
import org.broadleafcommerce.core.inventory.service.type.AvailabilityStatusType;
import org.junit.Test;

public class SkuAvailabilityImplDiffblueTest {
  /**
   * Test {@link SkuAvailabilityImpl#getAvailabilityStatus()}.
   * <ul>
   *   <li>Given {@link SkuAvailabilityImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuAvailabilityImpl#getAvailabilityStatus()}
   */
  @Test
  public void testGetAvailabilityStatus_givenSkuAvailabilityImpl() {
    // Arrange, Act and Assert
    assertNull((new SkuAvailabilityImpl()).getAvailabilityStatus());
  }

  /**
   * Test {@link SkuAvailabilityImpl#getAvailabilityStatus()}.
   * <ul>
   *   <li>Given {@link SkuAvailabilityImpl} (default constructor) AvailabilityDate
   * is {@link Date}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuAvailabilityImpl#getAvailabilityStatus()}
   */
  @Test
  public void testGetAvailabilityStatus_givenSkuAvailabilityImplAvailabilityDateIsDate() {
    // Arrange
    SkuAvailabilityImpl skuAvailabilityImpl = new SkuAvailabilityImpl();
    skuAvailabilityImpl.setAvailabilityDate(mock(java.sql.Date.class));

    // Act and Assert
    assertNull(skuAvailabilityImpl.getAvailabilityStatus());
  }

  /**
   * Test
   * {@link SkuAvailabilityImpl#setAvailabilityStatus(AvailabilityStatusType)}.
   * <p>
   * Method under test:
   * {@link SkuAvailabilityImpl#setAvailabilityStatus(AvailabilityStatusType)}
   */
  @Test
  public void testSetAvailabilityStatus() {
    // Arrange
    SkuAvailabilityImpl skuAvailabilityImpl = new SkuAvailabilityImpl();
    AvailabilityStatusType availabilityStatus = AvailabilityStatusType.AVAILABLE;

    // Act
    skuAvailabilityImpl.setAvailabilityStatus(availabilityStatus);

    // Assert
    assertEquals("AVAILABLE", skuAvailabilityImpl.availabilityStatus);
    AvailabilityStatusType expectedAvailabilityStatus = availabilityStatus.AVAILABLE;
    assertSame(expectedAvailabilityStatus, skuAvailabilityImpl.getAvailabilityStatus());
  }

  /**
   * Test
   * {@link SkuAvailabilityImpl#setAvailabilityStatus(AvailabilityStatusType)}.
   * <p>
   * Method under test:
   * {@link SkuAvailabilityImpl#setAvailabilityStatus(AvailabilityStatusType)}
   */
  @Test
  public void testSetAvailabilityStatus2() {
    // Arrange
    SkuAvailabilityImpl skuAvailabilityImpl = new SkuAvailabilityImpl();
    skuAvailabilityImpl
        .setAvailabilityDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    skuAvailabilityImpl.setAvailabilityStatus(AvailabilityStatusType.AVAILABLE);
    skuAvailabilityImpl.setId(1L);
    skuAvailabilityImpl.setLocationId(1L);
    skuAvailabilityImpl.setQuantityOnHand(1);
    skuAvailabilityImpl.setReserveQuantity(1);
    skuAvailabilityImpl.setSkuId(1L);

    // Act
    skuAvailabilityImpl.setAvailabilityStatus(null);

    // Assert that nothing has changed
    assertEquals("AVAILABLE", skuAvailabilityImpl.availabilityStatus);
  }

  /**
   * Test
   * {@link SkuAvailabilityImpl#setAvailabilityStatus(AvailabilityStatusType)}.
   * <ul>
   *   <li>Given {@link SkuAvailabilityImpl} (default constructor) AvailabilityDate
   * is {@link Date}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SkuAvailabilityImpl#setAvailabilityStatus(AvailabilityStatusType)}
   */
  @Test
  public void testSetAvailabilityStatus_givenSkuAvailabilityImplAvailabilityDateIsDate() {
    // Arrange
    SkuAvailabilityImpl skuAvailabilityImpl = new SkuAvailabilityImpl();
    skuAvailabilityImpl.setAvailabilityDate(mock(java.sql.Date.class));
    skuAvailabilityImpl.setAvailabilityStatus(AvailabilityStatusType.AVAILABLE);
    skuAvailabilityImpl.setId(1L);
    skuAvailabilityImpl.setLocationId(1L);
    skuAvailabilityImpl.setQuantityOnHand(1);
    skuAvailabilityImpl.setReserveQuantity(1);
    skuAvailabilityImpl.setSkuId(1L);

    // Act
    skuAvailabilityImpl.setAvailabilityStatus(null);

    // Assert that nothing has changed
    assertEquals("AVAILABLE", skuAvailabilityImpl.availabilityStatus);
  }

  /**
   * Test {@link SkuAvailabilityImpl#getAvailableQuantity()}.
   * <ul>
   *   <li>Given {@link SkuAvailabilityImpl} (default constructor) AvailabilityDate
   * is {@link Date}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuAvailabilityImpl#getAvailableQuantity()}
   */
  @Test
  public void testGetAvailableQuantity_givenSkuAvailabilityImplAvailabilityDateIsDate() {
    // Arrange
    SkuAvailabilityImpl skuAvailabilityImpl = new SkuAvailabilityImpl();
    skuAvailabilityImpl.setAvailabilityDate(mock(java.sql.Date.class));
    skuAvailabilityImpl.setAvailabilityStatus(AvailabilityStatusType.AVAILABLE);
    skuAvailabilityImpl.setId(1L);
    skuAvailabilityImpl.setLocationId(1L);
    skuAvailabilityImpl.setSkuId(1L);
    skuAvailabilityImpl.setQuantityOnHand(1);
    skuAvailabilityImpl.setReserveQuantity(null);

    // Act and Assert
    assertEquals(1, skuAvailabilityImpl.getAvailableQuantity().intValue());
  }

  /**
   * Test {@link SkuAvailabilityImpl#getAvailableQuantity()}.
   * <ul>
   *   <li>Given {@link SkuAvailabilityImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuAvailabilityImpl#getAvailableQuantity()}
   */
  @Test
  public void testGetAvailableQuantity_givenSkuAvailabilityImpl_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new SkuAvailabilityImpl()).getAvailableQuantity());
  }

  /**
   * Test {@link SkuAvailabilityImpl#getAvailableQuantity()}.
   * <ul>
   *   <li>Then return intValue is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuAvailabilityImpl#getAvailableQuantity()}
   */
  @Test
  public void testGetAvailableQuantity_thenReturnIntValueIsOne() {
    // Arrange
    SkuAvailabilityImpl skuAvailabilityImpl = new SkuAvailabilityImpl();
    skuAvailabilityImpl
        .setAvailabilityDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    skuAvailabilityImpl.setAvailabilityStatus(AvailabilityStatusType.AVAILABLE);
    skuAvailabilityImpl.setId(1L);
    skuAvailabilityImpl.setLocationId(1L);
    skuAvailabilityImpl.setSkuId(1L);
    skuAvailabilityImpl.setQuantityOnHand(1);
    skuAvailabilityImpl.setReserveQuantity(null);

    // Act and Assert
    assertEquals(1, skuAvailabilityImpl.getAvailableQuantity().intValue());
  }

  /**
   * Test {@link SkuAvailabilityImpl#getAvailableQuantity()}.
   * <ul>
   *   <li>Then return intValue is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuAvailabilityImpl#getAvailableQuantity()}
   */
  @Test
  public void testGetAvailableQuantity_thenReturnIntValueIsZero() {
    // Arrange
    SkuAvailabilityImpl skuAvailabilityImpl = new SkuAvailabilityImpl();
    skuAvailabilityImpl
        .setAvailabilityDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    skuAvailabilityImpl.setAvailabilityStatus(AvailabilityStatusType.AVAILABLE);
    skuAvailabilityImpl.setId(1L);
    skuAvailabilityImpl.setLocationId(1L);
    skuAvailabilityImpl.setSkuId(1L);
    skuAvailabilityImpl.setQuantityOnHand(1);
    skuAvailabilityImpl.setReserveQuantity(1);

    // Act and Assert
    assertEquals(0, skuAvailabilityImpl.getAvailableQuantity().intValue());
  }

  /**
   * Test {@link SkuAvailabilityImpl#equals(Object)}, and
   * {@link SkuAvailabilityImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link SkuAvailabilityImpl#equals(Object)}
   *   <li>{@link SkuAvailabilityImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    SkuAvailabilityImpl skuAvailabilityImpl = new SkuAvailabilityImpl();
    skuAvailabilityImpl
        .setAvailabilityDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    skuAvailabilityImpl.setAvailabilityStatus(AvailabilityStatusType.AVAILABLE);
    skuAvailabilityImpl.setId(1L);
    skuAvailabilityImpl.setLocationId(1L);
    skuAvailabilityImpl.setQuantityOnHand(1);
    skuAvailabilityImpl.setReserveQuantity(1);
    skuAvailabilityImpl.setSkuId(1L);

    SkuAvailabilityImpl skuAvailabilityImpl2 = new SkuAvailabilityImpl();
    skuAvailabilityImpl2
        .setAvailabilityDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    skuAvailabilityImpl2.setAvailabilityStatus(AvailabilityStatusType.AVAILABLE);
    skuAvailabilityImpl2.setId(1L);
    skuAvailabilityImpl2.setLocationId(1L);
    skuAvailabilityImpl2.setQuantityOnHand(1);
    skuAvailabilityImpl2.setReserveQuantity(1);
    skuAvailabilityImpl2.setSkuId(1L);

    // Act and Assert
    assertEquals(skuAvailabilityImpl, skuAvailabilityImpl2);
    int expectedHashCodeResult = skuAvailabilityImpl.hashCode();
    assertEquals(expectedHashCodeResult, skuAvailabilityImpl2.hashCode());
  }

  /**
   * Test {@link SkuAvailabilityImpl#equals(Object)}, and
   * {@link SkuAvailabilityImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link SkuAvailabilityImpl#equals(Object)}
   *   <li>{@link SkuAvailabilityImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    AvailabilityStatusType availabilityStatus = mock(AvailabilityStatusType.class);
    when(availabilityStatus.getType()).thenReturn("Type");

    SkuAvailabilityImpl skuAvailabilityImpl = new SkuAvailabilityImpl();
    skuAvailabilityImpl
        .setAvailabilityDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    skuAvailabilityImpl.setAvailabilityStatus(availabilityStatus);
    skuAvailabilityImpl.setId(1L);
    skuAvailabilityImpl.setLocationId(1L);
    skuAvailabilityImpl.setQuantityOnHand(1);
    skuAvailabilityImpl.setReserveQuantity(1);
    skuAvailabilityImpl.setSkuId(1L);

    SkuAvailabilityImpl skuAvailabilityImpl2 = new SkuAvailabilityImpl();
    skuAvailabilityImpl2
        .setAvailabilityDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    skuAvailabilityImpl2.setAvailabilityStatus(AvailabilityStatusType.AVAILABLE);
    skuAvailabilityImpl2.setId(1L);
    skuAvailabilityImpl2.setLocationId(1L);
    skuAvailabilityImpl2.setQuantityOnHand(1);
    skuAvailabilityImpl2.setReserveQuantity(1);
    skuAvailabilityImpl2.setSkuId(1L);

    // Act and Assert
    assertEquals(skuAvailabilityImpl, skuAvailabilityImpl2);
    int expectedHashCodeResult = skuAvailabilityImpl.hashCode();
    assertEquals(expectedHashCodeResult, skuAvailabilityImpl2.hashCode());
  }

  /**
   * Test {@link SkuAvailabilityImpl#equals(Object)}, and
   * {@link SkuAvailabilityImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link SkuAvailabilityImpl#equals(Object)}
   *   <li>{@link SkuAvailabilityImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    AvailabilityStatusType availabilityStatus = mock(AvailabilityStatusType.class);
    when(availabilityStatus.getType()).thenReturn("Type");

    SkuAvailabilityImpl skuAvailabilityImpl = new SkuAvailabilityImpl();
    skuAvailabilityImpl
        .setAvailabilityDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    skuAvailabilityImpl.setAvailabilityStatus(availabilityStatus);
    skuAvailabilityImpl.setId(null);
    skuAvailabilityImpl.setLocationId(1L);
    skuAvailabilityImpl.setQuantityOnHand(1);
    skuAvailabilityImpl.setReserveQuantity(1);
    skuAvailabilityImpl.setSkuId(1L);

    SkuAvailabilityImpl skuAvailabilityImpl2 = new SkuAvailabilityImpl();
    skuAvailabilityImpl2
        .setAvailabilityDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    skuAvailabilityImpl2.setAvailabilityStatus(AvailabilityStatusType.AVAILABLE);
    skuAvailabilityImpl2.setId(1L);
    skuAvailabilityImpl2.setLocationId(1L);
    skuAvailabilityImpl2.setQuantityOnHand(1);
    skuAvailabilityImpl2.setReserveQuantity(1);
    skuAvailabilityImpl2.setSkuId(1L);

    // Act and Assert
    assertEquals(skuAvailabilityImpl, skuAvailabilityImpl2);
    int expectedHashCodeResult = skuAvailabilityImpl.hashCode();
    assertEquals(expectedHashCodeResult, skuAvailabilityImpl2.hashCode());
  }

  /**
   * Test {@link SkuAvailabilityImpl#equals(Object)}, and
   * {@link SkuAvailabilityImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link SkuAvailabilityImpl#equals(Object)}
   *   <li>{@link SkuAvailabilityImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    AvailabilityStatusType availabilityStatus = mock(AvailabilityStatusType.class);
    when(availabilityStatus.getType()).thenReturn("Type");

    SkuAvailabilityImpl skuAvailabilityImpl = new SkuAvailabilityImpl();
    skuAvailabilityImpl
        .setAvailabilityDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    skuAvailabilityImpl.setAvailabilityStatus(availabilityStatus);
    skuAvailabilityImpl.setId(1L);
    skuAvailabilityImpl.setLocationId(1L);
    skuAvailabilityImpl.setQuantityOnHand(1);
    skuAvailabilityImpl.setReserveQuantity(1);
    skuAvailabilityImpl.setSkuId(1L);

    SkuAvailabilityImpl skuAvailabilityImpl2 = new SkuAvailabilityImpl();
    skuAvailabilityImpl2
        .setAvailabilityDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    skuAvailabilityImpl2.setAvailabilityStatus(AvailabilityStatusType.AVAILABLE);
    skuAvailabilityImpl2.setId(null);
    skuAvailabilityImpl2.setLocationId(1L);
    skuAvailabilityImpl2.setQuantityOnHand(1);
    skuAvailabilityImpl2.setReserveQuantity(1);
    skuAvailabilityImpl2.setSkuId(1L);

    // Act and Assert
    assertEquals(skuAvailabilityImpl, skuAvailabilityImpl2);
    int expectedHashCodeResult = skuAvailabilityImpl.hashCode();
    assertEquals(expectedHashCodeResult, skuAvailabilityImpl2.hashCode());
  }

  /**
   * Test {@link SkuAvailabilityImpl#equals(Object)}, and
   * {@link SkuAvailabilityImpl#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link SkuAvailabilityImpl#equals(Object)}
   *   <li>{@link SkuAvailabilityImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    SkuAvailabilityImpl skuAvailabilityImpl = new SkuAvailabilityImpl();
    skuAvailabilityImpl
        .setAvailabilityDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    skuAvailabilityImpl.setAvailabilityStatus(AvailabilityStatusType.AVAILABLE);
    skuAvailabilityImpl.setId(1L);
    skuAvailabilityImpl.setLocationId(1L);
    skuAvailabilityImpl.setQuantityOnHand(1);
    skuAvailabilityImpl.setReserveQuantity(1);
    skuAvailabilityImpl.setSkuId(1L);

    // Act and Assert
    assertEquals(skuAvailabilityImpl, skuAvailabilityImpl);
    int expectedHashCodeResult = skuAvailabilityImpl.hashCode();
    assertEquals(expectedHashCodeResult, skuAvailabilityImpl.hashCode());
  }

  /**
   * Test {@link SkuAvailabilityImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuAvailabilityImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    AvailabilityStatusType availabilityStatus = mock(AvailabilityStatusType.class);
    when(availabilityStatus.getType()).thenReturn("Type");

    SkuAvailabilityImpl skuAvailabilityImpl = new SkuAvailabilityImpl();
    skuAvailabilityImpl
        .setAvailabilityDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    skuAvailabilityImpl.setAvailabilityStatus(availabilityStatus);
    skuAvailabilityImpl.setId(2L);
    skuAvailabilityImpl.setLocationId(1L);
    skuAvailabilityImpl.setQuantityOnHand(1);
    skuAvailabilityImpl.setReserveQuantity(1);
    skuAvailabilityImpl.setSkuId(1L);

    SkuAvailabilityImpl skuAvailabilityImpl2 = new SkuAvailabilityImpl();
    skuAvailabilityImpl2
        .setAvailabilityDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    skuAvailabilityImpl2.setAvailabilityStatus(AvailabilityStatusType.AVAILABLE);
    skuAvailabilityImpl2.setId(1L);
    skuAvailabilityImpl2.setLocationId(1L);
    skuAvailabilityImpl2.setQuantityOnHand(1);
    skuAvailabilityImpl2.setReserveQuantity(1);
    skuAvailabilityImpl2.setSkuId(1L);

    // Act and Assert
    assertNotEquals(skuAvailabilityImpl, skuAvailabilityImpl2);
  }

  /**
   * Test {@link SkuAvailabilityImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuAvailabilityImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    AvailabilityStatusType availabilityStatus = mock(AvailabilityStatusType.class);
    when(availabilityStatus.getType()).thenReturn("Type");

    SkuAvailabilityImpl skuAvailabilityImpl = new SkuAvailabilityImpl();
    skuAvailabilityImpl
        .setAvailabilityDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    skuAvailabilityImpl.setAvailabilityStatus(availabilityStatus);
    skuAvailabilityImpl.setId(null);
    skuAvailabilityImpl.setLocationId(2L);
    skuAvailabilityImpl.setQuantityOnHand(1);
    skuAvailabilityImpl.setReserveQuantity(1);
    skuAvailabilityImpl.setSkuId(1L);

    SkuAvailabilityImpl skuAvailabilityImpl2 = new SkuAvailabilityImpl();
    skuAvailabilityImpl2
        .setAvailabilityDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    skuAvailabilityImpl2.setAvailabilityStatus(AvailabilityStatusType.AVAILABLE);
    skuAvailabilityImpl2.setId(1L);
    skuAvailabilityImpl2.setLocationId(1L);
    skuAvailabilityImpl2.setQuantityOnHand(1);
    skuAvailabilityImpl2.setReserveQuantity(1);
    skuAvailabilityImpl2.setSkuId(1L);

    // Act and Assert
    assertNotEquals(skuAvailabilityImpl, skuAvailabilityImpl2);
  }

  /**
   * Test {@link SkuAvailabilityImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuAvailabilityImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    AvailabilityStatusType availabilityStatus = mock(AvailabilityStatusType.class);
    when(availabilityStatus.getType()).thenReturn("Type");

    SkuAvailabilityImpl skuAvailabilityImpl = new SkuAvailabilityImpl();
    skuAvailabilityImpl
        .setAvailabilityDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    skuAvailabilityImpl.setAvailabilityStatus(availabilityStatus);
    skuAvailabilityImpl.setId(null);
    skuAvailabilityImpl.setLocationId(null);
    skuAvailabilityImpl.setQuantityOnHand(1);
    skuAvailabilityImpl.setReserveQuantity(1);
    skuAvailabilityImpl.setSkuId(1L);

    SkuAvailabilityImpl skuAvailabilityImpl2 = new SkuAvailabilityImpl();
    skuAvailabilityImpl2
        .setAvailabilityDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    skuAvailabilityImpl2.setAvailabilityStatus(AvailabilityStatusType.AVAILABLE);
    skuAvailabilityImpl2.setId(1L);
    skuAvailabilityImpl2.setLocationId(1L);
    skuAvailabilityImpl2.setQuantityOnHand(1);
    skuAvailabilityImpl2.setReserveQuantity(1);
    skuAvailabilityImpl2.setSkuId(1L);

    // Act and Assert
    assertNotEquals(skuAvailabilityImpl, skuAvailabilityImpl2);
  }

  /**
   * Test {@link SkuAvailabilityImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuAvailabilityImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    AvailabilityStatusType availabilityStatus = mock(AvailabilityStatusType.class);
    when(availabilityStatus.getType()).thenReturn("Type");

    SkuAvailabilityImpl skuAvailabilityImpl = new SkuAvailabilityImpl();
    skuAvailabilityImpl
        .setAvailabilityDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    skuAvailabilityImpl.setAvailabilityStatus(availabilityStatus);
    skuAvailabilityImpl.setId(null);
    skuAvailabilityImpl.setLocationId(1L);
    skuAvailabilityImpl.setQuantityOnHand(1);
    skuAvailabilityImpl.setReserveQuantity(1);
    skuAvailabilityImpl.setSkuId(2L);

    SkuAvailabilityImpl skuAvailabilityImpl2 = new SkuAvailabilityImpl();
    skuAvailabilityImpl2
        .setAvailabilityDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    skuAvailabilityImpl2.setAvailabilityStatus(AvailabilityStatusType.AVAILABLE);
    skuAvailabilityImpl2.setId(1L);
    skuAvailabilityImpl2.setLocationId(1L);
    skuAvailabilityImpl2.setQuantityOnHand(1);
    skuAvailabilityImpl2.setReserveQuantity(1);
    skuAvailabilityImpl2.setSkuId(1L);

    // Act and Assert
    assertNotEquals(skuAvailabilityImpl, skuAvailabilityImpl2);
  }

  /**
   * Test {@link SkuAvailabilityImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuAvailabilityImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    AvailabilityStatusType availabilityStatus = mock(AvailabilityStatusType.class);
    when(availabilityStatus.getType()).thenReturn("Type");

    SkuAvailabilityImpl skuAvailabilityImpl = new SkuAvailabilityImpl();
    skuAvailabilityImpl
        .setAvailabilityDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    skuAvailabilityImpl.setAvailabilityStatus(availabilityStatus);
    skuAvailabilityImpl.setId(null);
    skuAvailabilityImpl.setLocationId(1L);
    skuAvailabilityImpl.setQuantityOnHand(1);
    skuAvailabilityImpl.setReserveQuantity(1);
    skuAvailabilityImpl.setSkuId(null);

    SkuAvailabilityImpl skuAvailabilityImpl2 = new SkuAvailabilityImpl();
    skuAvailabilityImpl2
        .setAvailabilityDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    skuAvailabilityImpl2.setAvailabilityStatus(AvailabilityStatusType.AVAILABLE);
    skuAvailabilityImpl2.setId(1L);
    skuAvailabilityImpl2.setLocationId(1L);
    skuAvailabilityImpl2.setQuantityOnHand(1);
    skuAvailabilityImpl2.setReserveQuantity(1);
    skuAvailabilityImpl2.setSkuId(1L);

    // Act and Assert
    assertNotEquals(skuAvailabilityImpl, skuAvailabilityImpl2);
  }

  /**
   * Test {@link SkuAvailabilityImpl#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuAvailabilityImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    SkuAvailabilityImpl skuAvailabilityImpl = new SkuAvailabilityImpl();
    skuAvailabilityImpl
        .setAvailabilityDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    skuAvailabilityImpl.setAvailabilityStatus(AvailabilityStatusType.AVAILABLE);
    skuAvailabilityImpl.setId(1L);
    skuAvailabilityImpl.setLocationId(1L);
    skuAvailabilityImpl.setQuantityOnHand(1);
    skuAvailabilityImpl.setReserveQuantity(1);
    skuAvailabilityImpl.setSkuId(1L);

    // Act and Assert
    assertNotEquals(skuAvailabilityImpl, null);
  }

  /**
   * Test {@link SkuAvailabilityImpl#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuAvailabilityImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    SkuAvailabilityImpl skuAvailabilityImpl = new SkuAvailabilityImpl();
    skuAvailabilityImpl
        .setAvailabilityDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    skuAvailabilityImpl.setAvailabilityStatus(AvailabilityStatusType.AVAILABLE);
    skuAvailabilityImpl.setId(1L);
    skuAvailabilityImpl.setLocationId(1L);
    skuAvailabilityImpl.setQuantityOnHand(1);
    skuAvailabilityImpl.setReserveQuantity(1);
    skuAvailabilityImpl.setSkuId(1L);

    // Act and Assert
    assertNotEquals(skuAvailabilityImpl, "Different type to SkuAvailabilityImpl");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link SkuAvailabilityImpl}
   *   <li>{@link SkuAvailabilityImpl#setAvailabilityDate(Date)}
   *   <li>{@link SkuAvailabilityImpl#setId(Long)}
   *   <li>{@link SkuAvailabilityImpl#setLocationId(Long)}
   *   <li>{@link SkuAvailabilityImpl#setQuantityOnHand(Integer)}
   *   <li>{@link SkuAvailabilityImpl#setReserveQuantity(Integer)}
   *   <li>{@link SkuAvailabilityImpl#setSkuId(Long)}
   *   <li>{@link SkuAvailabilityImpl#getAvailabilityDate()}
   *   <li>{@link SkuAvailabilityImpl#getId()}
   *   <li>{@link SkuAvailabilityImpl#getLocationId()}
   *   <li>{@link SkuAvailabilityImpl#getQuantityOnHand()}
   *   <li>{@link SkuAvailabilityImpl#getReserveQuantity()}
   *   <li>{@link SkuAvailabilityImpl#getSkuId()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    SkuAvailabilityImpl actualSkuAvailabilityImpl = new SkuAvailabilityImpl();
    Date availabilityDate = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    actualSkuAvailabilityImpl.setAvailabilityDate(availabilityDate);
    actualSkuAvailabilityImpl.setId(1L);
    actualSkuAvailabilityImpl.setLocationId(1L);
    actualSkuAvailabilityImpl.setQuantityOnHand(1);
    actualSkuAvailabilityImpl.setReserveQuantity(1);
    actualSkuAvailabilityImpl.setSkuId(1L);
    Date actualAvailabilityDate = actualSkuAvailabilityImpl.getAvailabilityDate();
    Long actualId = actualSkuAvailabilityImpl.getId();
    Long actualLocationId = actualSkuAvailabilityImpl.getLocationId();
    Integer actualQuantityOnHand = actualSkuAvailabilityImpl.getQuantityOnHand();
    Integer actualReserveQuantity = actualSkuAvailabilityImpl.getReserveQuantity();
    Long actualSkuId = actualSkuAvailabilityImpl.getSkuId();

    // Assert that nothing has changed
    assertEquals(1, actualQuantityOnHand.intValue());
    assertEquals(1, actualReserveQuantity.intValue());
    assertEquals(1L, actualId.longValue());
    assertEquals(1L, actualLocationId.longValue());
    assertEquals(1L, actualSkuId.longValue());
    assertSame(availabilityDate, actualAvailabilityDate);
  }
}
