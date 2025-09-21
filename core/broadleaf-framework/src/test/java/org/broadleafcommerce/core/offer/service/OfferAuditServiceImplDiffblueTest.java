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
package org.broadleafcommerce.core.offer.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.broadleafcommerce.core.offer.dao.OfferAuditDao;
import org.broadleafcommerce.core.offer.domain.OfferAudit;
import org.broadleafcommerce.core.offer.domain.OfferAuditImpl;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class OfferAuditServiceImplDiffblueTest {
  @Mock private OfferAuditDao offerAuditDao;

  @InjectMocks private OfferAuditServiceImpl offerAuditServiceImpl;

  /**
   * Test {@link OfferAuditServiceImpl#readAuditById(Long)}.
   *
   * <p>Method under test: {@link OfferAuditServiceImpl#readAuditById(Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"OfferAudit OfferAuditServiceImpl.readAuditById(Long)"})
  public void testReadAuditById() {
    // Arrange
    OfferAuditImpl offerAuditImpl = new OfferAuditImpl();
    when(offerAuditDao.readAuditById(Mockito.<Long>any())).thenReturn(offerAuditImpl);

    // Act
    OfferAudit actualReadAuditByIdResult = offerAuditServiceImpl.readAuditById(1L);

    // Assert
    verify(offerAuditDao).readAuditById(1L);
    assertSame(offerAuditImpl, actualReadAuditByIdResult);
  }

  /**
   * Test {@link OfferAuditServiceImpl#save(OfferAudit)}.
   *
   * <p>Method under test: {@link OfferAuditServiceImpl#save(OfferAudit)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"OfferAudit OfferAuditServiceImpl.save(OfferAudit)"})
  public void testSave() {
    // Arrange
    OfferAuditImpl offerAuditImpl = new OfferAuditImpl();
    when(offerAuditDao.save(Mockito.<OfferAudit>any())).thenReturn(offerAuditImpl);

    // Act
    OfferAudit actualSaveResult = offerAuditServiceImpl.save(new OfferAuditImpl());

    // Assert
    verify(offerAuditDao).save(isA(OfferAudit.class));
    assertSame(offerAuditImpl, actualSaveResult);
  }

  /**
   * Test {@link OfferAuditServiceImpl#delete(OfferAudit)}.
   *
   * <p>Method under test: {@link OfferAuditServiceImpl#delete(OfferAudit)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void OfferAuditServiceImpl.delete(OfferAudit)"})
  public void testDelete() {
    // Arrange
    doNothing().when(offerAuditDao).delete(Mockito.<OfferAudit>any());

    // Act
    offerAuditServiceImpl.delete(new OfferAuditImpl());

    // Assert
    verify(offerAuditDao).delete(isA(OfferAudit.class));
  }

  /**
   * Test {@link OfferAuditServiceImpl#create()}.
   *
   * <p>Method under test: {@link OfferAuditServiceImpl#create()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"OfferAudit OfferAuditServiceImpl.create()"})
  public void testCreate() {
    // Arrange
    OfferAuditImpl offerAuditImpl = new OfferAuditImpl();
    when(offerAuditDao.create()).thenReturn(offerAuditImpl);

    // Act
    OfferAudit actualCreateResult = offerAuditServiceImpl.create();

    // Assert
    verify(offerAuditDao).create();
    assertSame(offerAuditImpl, actualCreateResult);
  }

  /**
   * Test {@link OfferAuditServiceImpl#countUsesByCustomer(Long, Long)} with {@code customerId},
   * {@code offerId}.
   *
   * <ul>
   *   <li>When four.
   * </ul>
   *
   * <p>Method under test: {@link OfferAuditServiceImpl#countUsesByCustomer(Long, Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Long OfferAuditServiceImpl.countUsesByCustomer(Long, Long)"})
  public void testCountUsesByCustomerWithCustomerIdOfferId_whenFour() {
    // Arrange
    when(offerAuditDao.countUsesByCustomer(Mockito.<Long>any(), Mockito.<Long>any()))
        .thenReturn(3L);

    // Act
    Long actualCountUsesByCustomerResult = offerAuditServiceImpl.countUsesByCustomer(4L, 1L);

    // Assert
    verify(offerAuditDao).countUsesByCustomer(4L, 1L);
    assertEquals(3L, actualCountUsesByCustomerResult.longValue());
  }

  /**
   * Test {@link OfferAuditServiceImpl#countUsesByCustomer(Long, Long)} with {@code customerId},
   * {@code offerId}.
   *
   * <ul>
   *   <li>When one.
   * </ul>
   *
   * <p>Method under test: {@link OfferAuditServiceImpl#countUsesByCustomer(Long, Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Long OfferAuditServiceImpl.countUsesByCustomer(Long, Long)"})
  public void testCountUsesByCustomerWithCustomerIdOfferId_whenOne() {
    // Arrange
    when(offerAuditDao.countUsesByCustomer(Mockito.<Long>any(), Mockito.<Long>any()))
        .thenReturn(3L);

    // Act
    Long actualCountUsesByCustomerResult = offerAuditServiceImpl.countUsesByCustomer(1L, 1L);

    // Assert
    verify(offerAuditDao).countUsesByCustomer(1L, 1L);
    assertEquals(3L, actualCountUsesByCustomerResult.longValue());
  }

  /**
   * Test {@link OfferAuditServiceImpl#countUsesByCustomer(Long, Long)} with {@code customerId},
   * {@code offerId}.
   *
   * <ul>
   *   <li>When three.
   * </ul>
   *
   * <p>Method under test: {@link OfferAuditServiceImpl#countUsesByCustomer(Long, Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Long OfferAuditServiceImpl.countUsesByCustomer(Long, Long)"})
  public void testCountUsesByCustomerWithCustomerIdOfferId_whenThree() {
    // Arrange
    when(offerAuditDao.countUsesByCustomer(Mockito.<Long>any(), Mockito.<Long>any()))
        .thenReturn(3L);

    // Act
    Long actualCountUsesByCustomerResult = offerAuditServiceImpl.countUsesByCustomer(3L, 1L);

    // Assert
    verify(offerAuditDao).countUsesByCustomer(3L, 1L);
    assertEquals(3L, actualCountUsesByCustomerResult.longValue());
  }

  /**
   * Test {@link OfferAuditServiceImpl#countUsesByCustomer(Long, Long)} with {@code customerId},
   * {@code offerId}.
   *
   * <ul>
   *   <li>When two.
   * </ul>
   *
   * <p>Method under test: {@link OfferAuditServiceImpl#countUsesByCustomer(Long, Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Long OfferAuditServiceImpl.countUsesByCustomer(Long, Long)"})
  public void testCountUsesByCustomerWithCustomerIdOfferId_whenTwo() {
    // Arrange
    when(offerAuditDao.countUsesByCustomer(Mockito.<Long>any(), Mockito.<Long>any()))
        .thenReturn(3L);

    // Act
    Long actualCountUsesByCustomerResult = offerAuditServiceImpl.countUsesByCustomer(2L, 1L);

    // Assert
    verify(offerAuditDao).countUsesByCustomer(2L, 1L);
    assertEquals(3L, actualCountUsesByCustomerResult.longValue());
  }

  /**
   * Test {@link OfferAuditServiceImpl#countUsesByCustomer(Order, Long, Long)} with {@code order},
   * {@code customerId}, {@code offerId}.
   *
   * <p>Method under test: {@link OfferAuditServiceImpl#countUsesByCustomer(Order, Long, Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Long OfferAuditServiceImpl.countUsesByCustomer(Order, Long, Long)"})
  public void testCountUsesByCustomerWithOrderCustomerIdOfferId() {
    // Arrange
    when(offerAuditDao.countUsesByCustomer(
            Mockito.<Order>any(), Mockito.<Long>any(), Mockito.<Long>any()))
        .thenReturn(3L);

    // Act
    Long actualCountUsesByCustomerResult =
        offerAuditServiceImpl.countUsesByCustomer(new NullOrderImpl(), 1L, 1L);

    // Assert
    verify(offerAuditDao).countUsesByCustomer(isA(Order.class), eq(1L), eq(1L));
    assertEquals(3L, actualCountUsesByCustomerResult.longValue());
  }

  /**
   * Test {@link OfferAuditServiceImpl#countUsesByCustomer(Order, Long, Long, Long)} with {@code
   * order}, {@code customerId}, {@code offerId}, {@code minimumDaysPerUsage}.
   *
   * <p>Method under test: {@link OfferAuditServiceImpl#countUsesByCustomer(Order, Long, Long,
   * Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Long OfferAuditServiceImpl.countUsesByCustomer(Order, Long, Long, Long)"})
  public void testCountUsesByCustomerWithOrderCustomerIdOfferIdMinimumDaysPerUsage() {
    // Arrange
    when(offerAuditDao.countUsesByCustomer(
            Mockito.<Order>any(), Mockito.<Long>any(), Mockito.<Long>any(), Mockito.<Long>any()))
        .thenReturn(3L);

    // Act
    Long actualCountUsesByCustomerResult =
        offerAuditServiceImpl.countUsesByCustomer(new NullOrderImpl(), 1L, 1L, 3L);

    // Assert
    verify(offerAuditDao).countUsesByCustomer(isA(Order.class), eq(1L), eq(1L), eq(3L));
    assertEquals(3L, actualCountUsesByCustomerResult.longValue());
  }

  /**
   * Test {@link OfferAuditServiceImpl#countUsesByAccount(Order, Long, Long, Long)}.
   *
   * <p>Method under test: {@link OfferAuditServiceImpl#countUsesByAccount(Order, Long, Long, Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Long OfferAuditServiceImpl.countUsesByAccount(Order, Long, Long, Long)"})
  public void testCountUsesByAccount() {
    // Arrange
    when(offerAuditDao.countUsesByAccount(
            Mockito.<Order>any(), Mockito.<Long>any(), Mockito.<Long>any(), Mockito.<Long>any()))
        .thenReturn(3L);

    // Act
    Long actualCountUsesByAccountResult =
        offerAuditServiceImpl.countUsesByAccount(new NullOrderImpl(), 1L, 1L, 3L);

    // Assert
    verify(offerAuditDao).countUsesByAccount(isA(Order.class), eq(1L), eq(1L), eq(3L));
    assertEquals(3L, actualCountUsesByAccountResult.longValue());
  }

  /**
   * Test {@link OfferAuditServiceImpl#countOfferCodeUses(Long)} with {@code offerCodeId}.
   *
   * <p>Method under test: {@link OfferAuditServiceImpl#countOfferCodeUses(Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Long OfferAuditServiceImpl.countOfferCodeUses(Long)"})
  public void testCountOfferCodeUsesWithOfferCodeId() {
    // Arrange
    when(offerAuditDao.countOfferCodeUses(Mockito.<Long>any())).thenReturn(3L);

    // Act
    Long actualCountOfferCodeUsesResult = offerAuditServiceImpl.countOfferCodeUses(1L);

    // Assert
    verify(offerAuditDao).countOfferCodeUses(1L);
    assertEquals(3L, actualCountOfferCodeUsesResult.longValue());
  }

  /**
   * Test {@link OfferAuditServiceImpl#countOfferCodeUses(Order, Long)} with {@code order}, {@code
   * offerCodeId}.
   *
   * <p>Method under test: {@link OfferAuditServiceImpl#countOfferCodeUses(Order, Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Long OfferAuditServiceImpl.countOfferCodeUses(Order, Long)"})
  public void testCountOfferCodeUsesWithOrderOfferCodeId() {
    // Arrange
    when(offerAuditDao.countOfferCodeUses(Mockito.<Order>any(), Mockito.<Long>any()))
        .thenReturn(3L);

    // Act
    Long actualCountOfferCodeUsesResult =
        offerAuditServiceImpl.countOfferCodeUses(new NullOrderImpl(), 1L);

    // Assert
    verify(offerAuditDao).countOfferCodeUses(isA(Order.class), eq(1L));
    assertEquals(3L, actualCountOfferCodeUsesResult.longValue());
  }

  /**
   * Test {@link OfferAuditServiceImpl#readOfferAuditsByOrderId(Long)}.
   *
   * <p>Method under test: {@link OfferAuditServiceImpl#readOfferAuditsByOrderId(Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List OfferAuditServiceImpl.readOfferAuditsByOrderId(Long)"})
  public void testReadOfferAuditsByOrderId() {
    // Arrange
    when(offerAuditDao.readOfferAuditsByOrderId(Mockito.<Long>any())).thenReturn(new ArrayList<>());

    // Act
    List<OfferAudit> actualReadOfferAuditsByOrderIdResult =
        offerAuditServiceImpl.readOfferAuditsByOrderId(1L);

    // Assert
    verify(offerAuditDao).readOfferAuditsByOrderId(1L);
    assertTrue(actualReadOfferAuditsByOrderIdResult.isEmpty());
  }
}
