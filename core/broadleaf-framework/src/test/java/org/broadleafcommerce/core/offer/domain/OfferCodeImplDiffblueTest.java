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
package org.broadleafcommerce.core.offer.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.broadleafcommerce.common.copy.CreateResponse;
import org.broadleafcommerce.common.copy.MultiTenantCopyContext;
import org.broadleafcommerce.core.order.domain.Order;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml"})
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(SpringJUnit4ClassRunner.class)
public class OfferCodeImplDiffblueTest {
  @Autowired private OfferCodeImpl offerCodeImpl;

  /**
   * Test {@link OfferCodeImpl#getOffer()}.
   *
   * <p>Method under test: {@link OfferCodeImpl#getOffer()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"org.broadleafcommerce.core.offer.domain.Offer OfferCodeImpl.getOffer()"})
  public void testGetOffer() {
    // Arrange, Act and Assert
    assertNull(offerCodeImpl.getOffer());
  }

  /**
   * Test {@link OfferCodeImpl#getMaxUses()}.
   *
   * <ul>
   *   <li>Given {@link OfferCodeImpl} MaxUses is one.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link OfferCodeImpl#getMaxUses()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int OfferCodeImpl.getMaxUses()"})
  public void testGetMaxUses_givenOfferCodeImplMaxUsesIsOne_thenReturnOne() {
    // Arrange
    offerCodeImpl.setMaxUses(1);

    // Act and Assert
    assertEquals(1, offerCodeImpl.getMaxUses());
  }

  /**
   * Test {@link OfferCodeImpl#getMaxUses()}.
   *
   * <ul>
   *   <li>Given {@link OfferCodeImpl}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link OfferCodeImpl#getMaxUses()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int OfferCodeImpl.getMaxUses()"})
  public void testGetMaxUses_givenOfferCodeImpl_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, offerCodeImpl.getMaxUses());
  }

  /**
   * Test {@link OfferCodeImpl#setMaxUses(int)}.
   *
   * <p>Method under test: {@link OfferCodeImpl#setMaxUses(int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void OfferCodeImpl.setMaxUses(int)"})
  public void testSetMaxUses() {
    // Arrange and Act
    offerCodeImpl.setMaxUses(3);

    // Assert
    assertEquals(3, offerCodeImpl.maxUses.intValue());
    assertEquals(3, offerCodeImpl.getMaxUses());
    assertFalse(offerCodeImpl.isUnlimitedUse());
    assertTrue(offerCodeImpl.isLimitedUse());
  }

  /**
   * Test {@link OfferCodeImpl#isUnlimitedUse()}.
   *
   * <ul>
   *   <li>Given {@link OfferCodeImpl} MaxUses is one.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link OfferCodeImpl#isUnlimitedUse()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OfferCodeImpl.isUnlimitedUse()"})
  public void testIsUnlimitedUse_givenOfferCodeImplMaxUsesIsOne_thenReturnFalse() {
    // Arrange
    offerCodeImpl.setMaxUses(1);

    // Act and Assert
    assertFalse(offerCodeImpl.isUnlimitedUse());
  }

  /**
   * Test {@link OfferCodeImpl#isUnlimitedUse()}.
   *
   * <ul>
   *   <li>Given {@link OfferCodeImpl} MaxUses is zero.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link OfferCodeImpl#isUnlimitedUse()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OfferCodeImpl.isUnlimitedUse()"})
  public void testIsUnlimitedUse_givenOfferCodeImplMaxUsesIsZero_thenReturnTrue() {
    // Arrange
    offerCodeImpl.setMaxUses(0);

    // Act and Assert
    assertTrue(offerCodeImpl.isUnlimitedUse());
  }

  /**
   * Test {@link OfferCodeImpl#isUnlimitedUse()}.
   *
   * <ul>
   *   <li>Given {@link OfferCodeImpl}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link OfferCodeImpl#isUnlimitedUse()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OfferCodeImpl.isUnlimitedUse()"})
  public void testIsUnlimitedUse_givenOfferCodeImpl_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(offerCodeImpl.isUnlimitedUse());
  }

  /**
   * Test {@link OfferCodeImpl#isLimitedUse()}.
   *
   * <ul>
   *   <li>Given {@link OfferCodeImpl} MaxUses is one.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link OfferCodeImpl#isLimitedUse()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OfferCodeImpl.isLimitedUse()"})
  public void testIsLimitedUse_givenOfferCodeImplMaxUsesIsOne_thenReturnTrue() {
    // Arrange
    offerCodeImpl.setMaxUses(1);

    // Act and Assert
    assertTrue(offerCodeImpl.isLimitedUse());
  }

  /**
   * Test {@link OfferCodeImpl#isLimitedUse()}.
   *
   * <ul>
   *   <li>Given {@link OfferCodeImpl} MaxUses is zero.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link OfferCodeImpl#isLimitedUse()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OfferCodeImpl.isLimitedUse()"})
  public void testIsLimitedUse_givenOfferCodeImplMaxUsesIsZero_thenReturnFalse() {
    // Arrange
    offerCodeImpl.setMaxUses(0);

    // Act and Assert
    assertFalse(offerCodeImpl.isLimitedUse());
  }

  /**
   * Test {@link OfferCodeImpl#isLimitedUse()}.
   *
   * <ul>
   *   <li>Given {@link OfferCodeImpl}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link OfferCodeImpl#isLimitedUse()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OfferCodeImpl.isLimitedUse()"})
  public void testIsLimitedUse_givenOfferCodeImpl_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(offerCodeImpl.isLimitedUse());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OfferCodeImpl#setEmailAddress(String)}
   *   <li>{@link OfferCodeImpl#setEndDate(Date)}
   *   <li>{@link OfferCodeImpl#setId(Long)}
   *   <li>{@link OfferCodeImpl#setOfferCode(String)}
   *   <li>{@link OfferCodeImpl#setOrders(List)}
   *   <li>{@link OfferCodeImpl#setStartDate(Date)}
   *   <li>{@link OfferCodeImpl#setUses(int)}
   *   <li>{@link OfferCodeImpl#getEmailAddress()}
   *   <li>{@link OfferCodeImpl#getEndDate()}
   *   <li>{@link OfferCodeImpl#getId()}
   *   <li>{@link OfferCodeImpl#getOfferCode()}
   *   <li>{@link OfferCodeImpl#getOrders()}
   *   <li>{@link OfferCodeImpl#getStartDate()}
   *   <li>{@link OfferCodeImpl#getUses()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String OfferCodeImpl.getEmailAddress()",
    "Date OfferCodeImpl.getEndDate()",
    "Long OfferCodeImpl.getId()",
    "String OfferCodeImpl.getOfferCode()",
    "List OfferCodeImpl.getOrders()",
    "Date OfferCodeImpl.getStartDate()",
    "int OfferCodeImpl.getUses()",
    "void OfferCodeImpl.setEmailAddress(String)",
    "void OfferCodeImpl.setEndDate(Date)",
    "void OfferCodeImpl.setId(Long)",
    "void OfferCodeImpl.setOfferCode(String)",
    "void OfferCodeImpl.setOrders(List)",
    "void OfferCodeImpl.setStartDate(Date)",
    "void OfferCodeImpl.setUses(int)"
  })
  public void testGettersAndSetters() {
    // Arrange
    OfferCodeImpl offerCodeImpl = new OfferCodeImpl();

    // Act
    offerCodeImpl.setEmailAddress("42 Main St");
    Date endDate =
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    offerCodeImpl.setEndDate(endDate);
    offerCodeImpl.setId(OfferCodeImpl.serialVersionUID);
    offerCodeImpl.setOfferCode("Offer Code");
    ArrayList<Order> orders = new ArrayList<>();
    offerCodeImpl.setOrders(orders);
    Date startDate =
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    offerCodeImpl.setStartDate(startDate);
    offerCodeImpl.setUses(1);
    String actualEmailAddress = offerCodeImpl.getEmailAddress();
    Date actualEndDate = offerCodeImpl.getEndDate();
    Long actualId = offerCodeImpl.getId();
    String actualOfferCode = offerCodeImpl.getOfferCode();
    List<Order> actualOrders = offerCodeImpl.getOrders();
    Date actualStartDate = offerCodeImpl.getStartDate();

    // Assert
    assertEquals("42 Main St", actualEmailAddress);
    assertEquals("Offer Code", actualOfferCode);
    assertEquals(1, offerCodeImpl.getUses());
    assertTrue(actualOrders.isEmpty());
    assertEquals(OfferCodeImpl.serialVersionUID, actualId.longValue());
    assertSame(orders, actualOrders);
    assertSame(endDate, actualEndDate);
    assertSame(startDate, actualStartDate);
  }

  /**
   * Test {@link OfferCodeImpl#getArchived()}.
   *
   * <p>Method under test: {@link OfferCodeImpl#getArchived()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Character OfferCodeImpl.getArchived()"})
  public void testGetArchived() {
    // Arrange, Act and Assert
    assertEquals('N', offerCodeImpl.getArchived().charValue());
  }

  /**
   * Test {@link OfferCodeImpl#setArchived(Character)}.
   *
   * <p>Method under test: {@link OfferCodeImpl#setArchived(Character)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void OfferCodeImpl.setArchived(Character)"})
  public void testSetArchived() {
    // Arrange and Act
    offerCodeImpl.setArchived('A');

    // Assert
    assertEquals('A', offerCodeImpl.archiveStatus.getArchived().charValue());
    assertEquals('A', offerCodeImpl.getArchived().charValue());
  }

  /**
   * Test {@link OfferCodeImpl#isActive()}.
   *
   * <p>Method under test: {@link OfferCodeImpl#isActive()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OfferCodeImpl.isActive()"})
  public void testIsActive() {
    // Arrange
    OfferCodeImpl offerCodeImpl = new OfferCodeImpl();
    offerCodeImpl.setEmailAddress("42 Main St");
    offerCodeImpl.setEndDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerCodeImpl.setId(OfferCodeImpl.serialVersionUID);
    offerCodeImpl.setMaxUses(3);
    offerCodeImpl.setOfferCode("Offer Code");
    offerCodeImpl.setOrders(new ArrayList<>());
    offerCodeImpl.setStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerCodeImpl.setUses(1);

    // Act and Assert
    assertFalse(offerCodeImpl.isActive());
  }

  /**
   * Test {@link OfferCodeImpl#isActive()}.
   *
   * <ul>
   *   <li>Given {@link OfferCodeImpl} (default constructor) Archived is {@code Y}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link OfferCodeImpl#isActive()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OfferCodeImpl.isActive()"})
  public void testIsActive_givenOfferCodeImplArchivedIsY_thenReturnFalse() {
    // Arrange
    OfferCodeImpl offerCodeImpl = new OfferCodeImpl();
    offerCodeImpl.setArchived('Y');
    offerCodeImpl.setStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    // Act and Assert
    assertFalse(offerCodeImpl.isActive());
  }

  /**
   * Test {@link OfferCodeImpl#isActive()}.
   *
   * <ul>
   *   <li>Given {@link OfferCodeImpl} (default constructor) Archived is {@code Y}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link OfferCodeImpl#isActive()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OfferCodeImpl.isActive()"})
  public void testIsActive_givenOfferCodeImplArchivedIsY_thenReturnFalse2() {
    // Arrange
    OfferCodeImpl offerCodeImpl = new OfferCodeImpl();
    offerCodeImpl.setEndDate(new Date());
    offerCodeImpl.setArchived('Y');
    offerCodeImpl.setStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    // Act and Assert
    assertFalse(offerCodeImpl.isActive());
  }

  /**
   * Test {@link OfferCodeImpl#isActive()}.
   *
   * <ul>
   *   <li>Given {@link OfferCodeImpl} (default constructor) StartDate is {@link Date#Date()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link OfferCodeImpl#isActive()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OfferCodeImpl.isActive()"})
  public void testIsActive_givenOfferCodeImplStartDateIsDate_thenReturnFalse() {
    // Arrange
    OfferCodeImpl offerCodeImpl = new OfferCodeImpl();
    offerCodeImpl.setEmailAddress("42 Main St");
    offerCodeImpl.setEndDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerCodeImpl.setId(OfferCodeImpl.serialVersionUID);
    offerCodeImpl.setMaxUses(3);
    offerCodeImpl.setOfferCode("Offer Code");
    offerCodeImpl.setOrders(new ArrayList<>());
    offerCodeImpl.setStartDate(new Date());
    offerCodeImpl.setUses(1);

    // Act and Assert
    assertFalse(offerCodeImpl.isActive());
  }

  /**
   * Test {@link OfferCodeImpl#equals(Object)}, and {@link OfferCodeImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OfferCodeImpl#equals(Object)}
   *   <li>{@link OfferCodeImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OfferCodeImpl.equals(Object)", "int OfferCodeImpl.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    OfferCodeImpl offerCodeImpl = new OfferCodeImpl();
    offerCodeImpl.setEmailAddress("42 Main St");
    offerCodeImpl.setEndDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerCodeImpl.setId(OfferCodeImpl.serialVersionUID);
    offerCodeImpl.setMaxUses(3);
    offerCodeImpl.setOfferCode("Offer Code");
    offerCodeImpl.setOrders(new ArrayList<>());
    offerCodeImpl.setStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerCodeImpl.setUses(1);

    OfferCodeImpl offerCodeImpl2 = new OfferCodeImpl();
    offerCodeImpl2.setEmailAddress("42 Main St");
    offerCodeImpl2.setEndDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerCodeImpl2.setId(OfferCodeImpl.serialVersionUID);
    offerCodeImpl2.setMaxUses(3);
    offerCodeImpl2.setOfferCode("Offer Code");
    offerCodeImpl2.setOrders(new ArrayList<>());
    offerCodeImpl2.setStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerCodeImpl2.setUses(1);

    // Act and Assert
    assertEquals(offerCodeImpl, offerCodeImpl2);
    assertEquals(offerCodeImpl.hashCode(), offerCodeImpl2.hashCode());
  }

  /**
   * Test {@link OfferCodeImpl#equals(Object)}, and {@link OfferCodeImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OfferCodeImpl#equals(Object)}
   *   <li>{@link OfferCodeImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OfferCodeImpl.equals(Object)", "int OfferCodeImpl.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    OfferCodeImpl offerCodeImpl = new OfferCodeImpl();
    offerCodeImpl.setEmailAddress("42 Main St");
    offerCodeImpl.setEndDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerCodeImpl.setId(OfferCodeImpl.serialVersionUID);
    offerCodeImpl.setMaxUses(3);
    offerCodeImpl.setOfferCode("Offer Code");
    offerCodeImpl.setOrders(new ArrayList<>());
    offerCodeImpl.setStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerCodeImpl.setUses(1);

    // Act and Assert
    assertEquals(offerCodeImpl, offerCodeImpl);
    int expectedHashCodeResult = offerCodeImpl.hashCode();
    assertEquals(expectedHashCodeResult, offerCodeImpl.hashCode());
  }

  /**
   * Test {@link OfferCodeImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OfferCodeImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OfferCodeImpl.equals(Object)", "int OfferCodeImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    OfferCodeImpl offerCodeImpl = new OfferCodeImpl();
    offerCodeImpl.setEmailAddress("17 High St");
    offerCodeImpl.setEndDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerCodeImpl.setId(OfferCodeImpl.serialVersionUID);
    offerCodeImpl.setMaxUses(3);
    offerCodeImpl.setOfferCode("Offer Code");
    offerCodeImpl.setOrders(new ArrayList<>());
    offerCodeImpl.setStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerCodeImpl.setUses(1);

    OfferCodeImpl offerCodeImpl2 = new OfferCodeImpl();
    offerCodeImpl2.setEmailAddress("42 Main St");
    offerCodeImpl2.setEndDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerCodeImpl2.setId(OfferCodeImpl.serialVersionUID);
    offerCodeImpl2.setMaxUses(3);
    offerCodeImpl2.setOfferCode("Offer Code");
    offerCodeImpl2.setOrders(new ArrayList<>());
    offerCodeImpl2.setStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerCodeImpl2.setUses(1);

    // Act and Assert
    assertNotEquals(offerCodeImpl, offerCodeImpl2);
  }

  /**
   * Test {@link OfferCodeImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OfferCodeImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OfferCodeImpl.equals(Object)", "int OfferCodeImpl.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    OfferCodeImpl offerCodeImpl = new OfferCodeImpl();
    offerCodeImpl.setEmailAddress("42 Main St");
    offerCodeImpl.setEndDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerCodeImpl.setId(OfferCodeImpl.serialVersionUID);
    offerCodeImpl.setMaxUses(3);
    offerCodeImpl.setOfferCode("Offer Code");
    offerCodeImpl.setOrders(new ArrayList<>());
    offerCodeImpl.setStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerCodeImpl.setUses(1);

    // Act and Assert
    assertNotEquals(offerCodeImpl, null);
  }

  /**
   * Test {@link OfferCodeImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OfferCodeImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OfferCodeImpl.equals(Object)", "int OfferCodeImpl.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    OfferCodeImpl offerCodeImpl = new OfferCodeImpl();
    offerCodeImpl.setEmailAddress("42 Main St");
    offerCodeImpl.setEndDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerCodeImpl.setId(OfferCodeImpl.serialVersionUID);
    offerCodeImpl.setMaxUses(3);
    offerCodeImpl.setOfferCode("Offer Code");
    offerCodeImpl.setOrders(new ArrayList<>());
    offerCodeImpl.setStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerCodeImpl.setUses(1);

    // Act and Assert
    assertNotEquals(offerCodeImpl, "Different type to OfferCodeImpl");
  }

  /**
   * Test {@link OfferCodeImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   *
   * <p>Method under test: {@link
   * OfferCodeImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CreateResponse OfferCodeImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"
  })
  public void testCreateOrRetrieveCopyInstance() throws CloneNotSupportedException {
    // Arrange
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    CreateResponse<Object> createResponse = new CreateResponse<>(new OfferCodeImpl(), true);
    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<OfferCode> actualCreateOrRetrieveCopyInstanceResult =
        offerCodeImpl.createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Test {@link OfferCodeImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   *
   * <p>Method under test: {@link
   * OfferCodeImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CreateResponse OfferCodeImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"
  })
  public void testCreateOrRetrieveCopyInstance2() throws CloneNotSupportedException {
    // Arrange
    OfferCodeImpl offerCodeImpl = new OfferCodeImpl();
    offerCodeImpl.setMaxUses(3);

    OfferCodeImpl offerCodeImpl2 = new OfferCodeImpl();
    offerCodeImpl2.setEmailAddress("42 Main St");
    offerCodeImpl2.setEndDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerCodeImpl2.setId(OfferCodeImpl.serialVersionUID);
    offerCodeImpl2.setMaxUses(3);
    offerCodeImpl2.setOfferCode("Offer Code");
    offerCodeImpl2.setOrders(new ArrayList<>());
    offerCodeImpl2.setStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerCodeImpl2.setUses(1);
    CreateResponse<Object> createResponse = new CreateResponse<>(offerCodeImpl2, false);

    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<OfferCode> actualCreateOrRetrieveCopyInstanceResult =
        offerCodeImpl.createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Test new {@link OfferCodeImpl} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link OfferCodeImpl}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void OfferCodeImpl.<init>()"})
  public void testNewOfferCodeImpl() {
    // Arrange and Act
    OfferCodeImpl actualOfferCodeImpl = new OfferCodeImpl();

    // Assert
    assertEquals('N', actualOfferCodeImpl.getArchived().charValue());
    assertNull(actualOfferCodeImpl.maxUses);
    assertNull(actualOfferCodeImpl.getId());
    assertNull(actualOfferCodeImpl.getEmailAddress());
    assertNull(actualOfferCodeImpl.getOfferCode());
    assertNull(actualOfferCodeImpl.getEndDate());
    assertNull(actualOfferCodeImpl.getStartDate());
    assertNull(actualOfferCodeImpl.getOffer());
    assertNull(actualOfferCodeImpl.deproxiedOffer);
    assertNull(actualOfferCodeImpl.offer);
    assertNull(actualOfferCodeImpl.sbClonedOffer);
    assertEquals(0, actualOfferCodeImpl.getMaxUses());
    assertEquals(0, actualOfferCodeImpl.getUses());
    assertFalse(actualOfferCodeImpl.isLimitedUse());
    assertTrue(actualOfferCodeImpl.getOrders().isEmpty());
    assertTrue(actualOfferCodeImpl.isUnlimitedUse());
  }
}
