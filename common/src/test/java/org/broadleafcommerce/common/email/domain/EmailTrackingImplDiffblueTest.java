/*-
 * #%L
 * BroadleafCommerce Common Libraries
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
package org.broadleafcommerce.common.email.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import org.junit.Test;

public class EmailTrackingImplDiffblueTest {
  /**
   * Test {@link EmailTrackingImpl#equals(Object)}, and
   * {@link EmailTrackingImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EmailTrackingImpl#equals(Object)}
   *   <li>{@link EmailTrackingImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    EmailTrackingImpl emailTrackingImpl = new EmailTrackingImpl();
    emailTrackingImpl
        .setDateSent(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    emailTrackingImpl.setEmailAddress("42 Main St");
    emailTrackingImpl.setEmailTrackingClicks(new HashSet<>());
    emailTrackingImpl.setEmailTrackingOpens(new HashSet<>());
    emailTrackingImpl.setId(1L);
    emailTrackingImpl.setType("Type");

    EmailTrackingImpl emailTrackingImpl2 = new EmailTrackingImpl();
    emailTrackingImpl2
        .setDateSent(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    emailTrackingImpl2.setEmailAddress("42 Main St");
    emailTrackingImpl2.setEmailTrackingClicks(new HashSet<>());
    emailTrackingImpl2.setEmailTrackingOpens(new HashSet<>());
    emailTrackingImpl2.setId(1L);
    emailTrackingImpl2.setType("Type");

    // Act and Assert
    assertEquals(emailTrackingImpl, emailTrackingImpl2);
    int expectedHashCodeResult = emailTrackingImpl.hashCode();
    assertEquals(expectedHashCodeResult, emailTrackingImpl2.hashCode());
  }

  /**
   * Test {@link EmailTrackingImpl#equals(Object)}, and
   * {@link EmailTrackingImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EmailTrackingImpl#equals(Object)}
   *   <li>{@link EmailTrackingImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    EmailTrackingImpl emailTrackingImpl = new EmailTrackingImpl();
    emailTrackingImpl
        .setDateSent(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    emailTrackingImpl.setEmailAddress("42 Main St");
    emailTrackingImpl.setEmailTrackingClicks(new HashSet<>());
    emailTrackingImpl.setEmailTrackingOpens(new HashSet<>());
    emailTrackingImpl.setId(null);
    emailTrackingImpl.setType("Type");

    EmailTrackingImpl emailTrackingImpl2 = new EmailTrackingImpl();
    emailTrackingImpl2
        .setDateSent(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    emailTrackingImpl2.setEmailAddress("42 Main St");
    emailTrackingImpl2.setEmailTrackingClicks(new HashSet<>());
    emailTrackingImpl2.setEmailTrackingOpens(new HashSet<>());
    emailTrackingImpl2.setId(1L);
    emailTrackingImpl2.setType("Type");

    // Act and Assert
    assertEquals(emailTrackingImpl, emailTrackingImpl2);
    int expectedHashCodeResult = emailTrackingImpl.hashCode();
    assertEquals(expectedHashCodeResult, emailTrackingImpl2.hashCode());
  }

  /**
   * Test {@link EmailTrackingImpl#equals(Object)}, and
   * {@link EmailTrackingImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EmailTrackingImpl#equals(Object)}
   *   <li>{@link EmailTrackingImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    EmailTrackingImpl emailTrackingImpl = new EmailTrackingImpl();
    emailTrackingImpl
        .setDateSent(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    emailTrackingImpl.setEmailAddress("42 Main St");
    emailTrackingImpl.setEmailTrackingClicks(new HashSet<>());
    emailTrackingImpl.setEmailTrackingOpens(new HashSet<>());
    emailTrackingImpl.setId(1L);
    emailTrackingImpl.setType("Type");

    EmailTrackingImpl emailTrackingImpl2 = new EmailTrackingImpl();
    emailTrackingImpl2
        .setDateSent(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    emailTrackingImpl2.setEmailAddress("42 Main St");
    emailTrackingImpl2.setEmailTrackingClicks(new HashSet<>());
    emailTrackingImpl2.setEmailTrackingOpens(new HashSet<>());
    emailTrackingImpl2.setId(null);
    emailTrackingImpl2.setType("Type");

    // Act and Assert
    assertEquals(emailTrackingImpl, emailTrackingImpl2);
    int expectedHashCodeResult = emailTrackingImpl.hashCode();
    assertEquals(expectedHashCodeResult, emailTrackingImpl2.hashCode());
  }

  /**
   * Test {@link EmailTrackingImpl#equals(Object)}, and
   * {@link EmailTrackingImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EmailTrackingImpl#equals(Object)}
   *   <li>{@link EmailTrackingImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    EmailTrackingImpl emailTrackingImpl = new EmailTrackingImpl();
    emailTrackingImpl.setDateSent(null);
    emailTrackingImpl.setEmailAddress("42 Main St");
    emailTrackingImpl.setEmailTrackingClicks(new HashSet<>());
    emailTrackingImpl.setEmailTrackingOpens(new HashSet<>());
    emailTrackingImpl.setId(null);
    emailTrackingImpl.setType("Type");

    EmailTrackingImpl emailTrackingImpl2 = new EmailTrackingImpl();
    emailTrackingImpl2.setDateSent(null);
    emailTrackingImpl2.setEmailAddress("42 Main St");
    emailTrackingImpl2.setEmailTrackingClicks(new HashSet<>());
    emailTrackingImpl2.setEmailTrackingOpens(new HashSet<>());
    emailTrackingImpl2.setId(1L);
    emailTrackingImpl2.setType("Type");

    // Act and Assert
    assertEquals(emailTrackingImpl, emailTrackingImpl2);
    int expectedHashCodeResult = emailTrackingImpl.hashCode();
    assertEquals(expectedHashCodeResult, emailTrackingImpl2.hashCode());
  }

  /**
   * Test {@link EmailTrackingImpl#equals(Object)}, and
   * {@link EmailTrackingImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EmailTrackingImpl#equals(Object)}
   *   <li>{@link EmailTrackingImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual5() {
    // Arrange
    EmailTrackingImpl emailTrackingImpl = new EmailTrackingImpl();
    emailTrackingImpl
        .setDateSent(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    emailTrackingImpl.setEmailAddress(null);
    emailTrackingImpl.setEmailTrackingClicks(new HashSet<>());
    emailTrackingImpl.setEmailTrackingOpens(new HashSet<>());
    emailTrackingImpl.setId(null);
    emailTrackingImpl.setType("Type");

    EmailTrackingImpl emailTrackingImpl2 = new EmailTrackingImpl();
    emailTrackingImpl2
        .setDateSent(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    emailTrackingImpl2.setEmailAddress(null);
    emailTrackingImpl2.setEmailTrackingClicks(new HashSet<>());
    emailTrackingImpl2.setEmailTrackingOpens(new HashSet<>());
    emailTrackingImpl2.setId(1L);
    emailTrackingImpl2.setType("Type");

    // Act and Assert
    assertEquals(emailTrackingImpl, emailTrackingImpl2);
    int expectedHashCodeResult = emailTrackingImpl.hashCode();
    assertEquals(expectedHashCodeResult, emailTrackingImpl2.hashCode());
  }

  /**
   * Test {@link EmailTrackingImpl#equals(Object)}, and
   * {@link EmailTrackingImpl#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EmailTrackingImpl#equals(Object)}
   *   <li>{@link EmailTrackingImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    EmailTrackingImpl emailTrackingImpl = new EmailTrackingImpl();
    emailTrackingImpl
        .setDateSent(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    emailTrackingImpl.setEmailAddress("42 Main St");
    emailTrackingImpl.setEmailTrackingClicks(new HashSet<>());
    emailTrackingImpl.setEmailTrackingOpens(new HashSet<>());
    emailTrackingImpl.setId(1L);
    emailTrackingImpl.setType("Type");

    // Act and Assert
    assertEquals(emailTrackingImpl, emailTrackingImpl);
    int expectedHashCodeResult = emailTrackingImpl.hashCode();
    assertEquals(expectedHashCodeResult, emailTrackingImpl.hashCode());
  }

  /**
   * Test {@link EmailTrackingImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EmailTrackingImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    EmailTrackingImpl emailTrackingImpl = new EmailTrackingImpl();
    emailTrackingImpl
        .setDateSent(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    emailTrackingImpl.setEmailAddress("42 Main St");
    emailTrackingImpl.setEmailTrackingClicks(new HashSet<>());
    emailTrackingImpl.setEmailTrackingOpens(new HashSet<>());
    emailTrackingImpl.setId(2L);
    emailTrackingImpl.setType("Type");

    EmailTrackingImpl emailTrackingImpl2 = new EmailTrackingImpl();
    emailTrackingImpl2
        .setDateSent(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    emailTrackingImpl2.setEmailAddress("42 Main St");
    emailTrackingImpl2.setEmailTrackingClicks(new HashSet<>());
    emailTrackingImpl2.setEmailTrackingOpens(new HashSet<>());
    emailTrackingImpl2.setId(1L);
    emailTrackingImpl2.setType("Type");

    // Act and Assert
    assertNotEquals(emailTrackingImpl, emailTrackingImpl2);
  }

  /**
   * Test {@link EmailTrackingImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EmailTrackingImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    EmailTrackingImpl emailTrackingImpl = new EmailTrackingImpl();
    emailTrackingImpl.setDateSent(Date.from(LocalDate.now().atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    emailTrackingImpl.setEmailAddress("42 Main St");
    emailTrackingImpl.setEmailTrackingClicks(new HashSet<>());
    emailTrackingImpl.setEmailTrackingOpens(new HashSet<>());
    emailTrackingImpl.setId(null);
    emailTrackingImpl.setType("Type");

    EmailTrackingImpl emailTrackingImpl2 = new EmailTrackingImpl();
    emailTrackingImpl2
        .setDateSent(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    emailTrackingImpl2.setEmailAddress("42 Main St");
    emailTrackingImpl2.setEmailTrackingClicks(new HashSet<>());
    emailTrackingImpl2.setEmailTrackingOpens(new HashSet<>());
    emailTrackingImpl2.setId(1L);
    emailTrackingImpl2.setType("Type");

    // Act and Assert
    assertNotEquals(emailTrackingImpl, emailTrackingImpl2);
  }

  /**
   * Test {@link EmailTrackingImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EmailTrackingImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    EmailTrackingImpl emailTrackingImpl = new EmailTrackingImpl();
    emailTrackingImpl.setDateSent(null);
    emailTrackingImpl.setEmailAddress("42 Main St");
    emailTrackingImpl.setEmailTrackingClicks(new HashSet<>());
    emailTrackingImpl.setEmailTrackingOpens(new HashSet<>());
    emailTrackingImpl.setId(null);
    emailTrackingImpl.setType("Type");

    EmailTrackingImpl emailTrackingImpl2 = new EmailTrackingImpl();
    emailTrackingImpl2
        .setDateSent(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    emailTrackingImpl2.setEmailAddress("42 Main St");
    emailTrackingImpl2.setEmailTrackingClicks(new HashSet<>());
    emailTrackingImpl2.setEmailTrackingOpens(new HashSet<>());
    emailTrackingImpl2.setId(1L);
    emailTrackingImpl2.setType("Type");

    // Act and Assert
    assertNotEquals(emailTrackingImpl, emailTrackingImpl2);
  }

  /**
   * Test {@link EmailTrackingImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EmailTrackingImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    EmailTrackingImpl emailTrackingImpl = new EmailTrackingImpl();
    emailTrackingImpl
        .setDateSent(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    emailTrackingImpl.setEmailAddress("17 High St");
    emailTrackingImpl.setEmailTrackingClicks(new HashSet<>());
    emailTrackingImpl.setEmailTrackingOpens(new HashSet<>());
    emailTrackingImpl.setId(null);
    emailTrackingImpl.setType("Type");

    EmailTrackingImpl emailTrackingImpl2 = new EmailTrackingImpl();
    emailTrackingImpl2
        .setDateSent(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    emailTrackingImpl2.setEmailAddress("42 Main St");
    emailTrackingImpl2.setEmailTrackingClicks(new HashSet<>());
    emailTrackingImpl2.setEmailTrackingOpens(new HashSet<>());
    emailTrackingImpl2.setId(1L);
    emailTrackingImpl2.setType("Type");

    // Act and Assert
    assertNotEquals(emailTrackingImpl, emailTrackingImpl2);
  }

  /**
   * Test {@link EmailTrackingImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EmailTrackingImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    EmailTrackingImpl emailTrackingImpl = new EmailTrackingImpl();
    emailTrackingImpl
        .setDateSent(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    emailTrackingImpl.setEmailAddress(null);
    emailTrackingImpl.setEmailTrackingClicks(new HashSet<>());
    emailTrackingImpl.setEmailTrackingOpens(new HashSet<>());
    emailTrackingImpl.setId(null);
    emailTrackingImpl.setType("Type");

    EmailTrackingImpl emailTrackingImpl2 = new EmailTrackingImpl();
    emailTrackingImpl2
        .setDateSent(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    emailTrackingImpl2.setEmailAddress("42 Main St");
    emailTrackingImpl2.setEmailTrackingClicks(new HashSet<>());
    emailTrackingImpl2.setEmailTrackingOpens(new HashSet<>());
    emailTrackingImpl2.setId(1L);
    emailTrackingImpl2.setType("Type");

    // Act and Assert
    assertNotEquals(emailTrackingImpl, emailTrackingImpl2);
  }

  /**
   * Test {@link EmailTrackingImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EmailTrackingImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    HashSet<EmailTrackingClicks> emailTrackingClicks = new HashSet<>();
    emailTrackingClicks.add(new EmailTrackingClicksImpl());

    EmailTrackingImpl emailTrackingImpl = new EmailTrackingImpl();
    emailTrackingImpl
        .setDateSent(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    emailTrackingImpl.setEmailAddress("42 Main St");
    emailTrackingImpl.setEmailTrackingClicks(emailTrackingClicks);
    emailTrackingImpl.setEmailTrackingOpens(new HashSet<>());
    emailTrackingImpl.setId(null);
    emailTrackingImpl.setType("Type");

    EmailTrackingImpl emailTrackingImpl2 = new EmailTrackingImpl();
    emailTrackingImpl2
        .setDateSent(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    emailTrackingImpl2.setEmailAddress("42 Main St");
    emailTrackingImpl2.setEmailTrackingClicks(new HashSet<>());
    emailTrackingImpl2.setEmailTrackingOpens(new HashSet<>());
    emailTrackingImpl2.setId(1L);
    emailTrackingImpl2.setType("Type");

    // Act and Assert
    assertNotEquals(emailTrackingImpl, emailTrackingImpl2);
  }

  /**
   * Test {@link EmailTrackingImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EmailTrackingImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    HashSet<EmailTrackingOpens> emailTrackingOpens = new HashSet<>();
    emailTrackingOpens.add(new EmailTrackingOpensImpl());

    EmailTrackingImpl emailTrackingImpl = new EmailTrackingImpl();
    emailTrackingImpl
        .setDateSent(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    emailTrackingImpl.setEmailAddress("42 Main St");
    emailTrackingImpl.setEmailTrackingClicks(new HashSet<>());
    emailTrackingImpl.setEmailTrackingOpens(emailTrackingOpens);
    emailTrackingImpl.setId(null);
    emailTrackingImpl.setType("Type");

    EmailTrackingImpl emailTrackingImpl2 = new EmailTrackingImpl();
    emailTrackingImpl2
        .setDateSent(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    emailTrackingImpl2.setEmailAddress("42 Main St");
    emailTrackingImpl2.setEmailTrackingClicks(new HashSet<>());
    emailTrackingImpl2.setEmailTrackingOpens(new HashSet<>());
    emailTrackingImpl2.setId(1L);
    emailTrackingImpl2.setType("Type");

    // Act and Assert
    assertNotEquals(emailTrackingImpl, emailTrackingImpl2);
  }

  /**
   * Test {@link EmailTrackingImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EmailTrackingImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    EmailTrackingImpl emailTrackingImpl = new EmailTrackingImpl();
    emailTrackingImpl
        .setDateSent(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    emailTrackingImpl.setEmailAddress("42 Main St");
    emailTrackingImpl.setEmailTrackingClicks(new HashSet<>());
    emailTrackingImpl.setEmailTrackingOpens(new HashSet<>());
    emailTrackingImpl.setId(null);
    emailTrackingImpl.setType("42 Main St");

    EmailTrackingImpl emailTrackingImpl2 = new EmailTrackingImpl();
    emailTrackingImpl2
        .setDateSent(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    emailTrackingImpl2.setEmailAddress("42 Main St");
    emailTrackingImpl2.setEmailTrackingClicks(new HashSet<>());
    emailTrackingImpl2.setEmailTrackingOpens(new HashSet<>());
    emailTrackingImpl2.setId(1L);
    emailTrackingImpl2.setType("Type");

    // Act and Assert
    assertNotEquals(emailTrackingImpl, emailTrackingImpl2);
  }

  /**
   * Test {@link EmailTrackingImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EmailTrackingImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    EmailTrackingImpl emailTrackingImpl = new EmailTrackingImpl();
    emailTrackingImpl
        .setDateSent(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    emailTrackingImpl.setEmailAddress("42 Main St");
    emailTrackingImpl.setEmailTrackingClicks(new HashSet<>());
    emailTrackingImpl.setEmailTrackingOpens(new HashSet<>());
    emailTrackingImpl.setId(null);
    emailTrackingImpl.setType(null);

    EmailTrackingImpl emailTrackingImpl2 = new EmailTrackingImpl();
    emailTrackingImpl2
        .setDateSent(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    emailTrackingImpl2.setEmailAddress("42 Main St");
    emailTrackingImpl2.setEmailTrackingClicks(new HashSet<>());
    emailTrackingImpl2.setEmailTrackingOpens(new HashSet<>());
    emailTrackingImpl2.setId(1L);
    emailTrackingImpl2.setType("Type");

    // Act and Assert
    assertNotEquals(emailTrackingImpl, emailTrackingImpl2);
  }

  /**
   * Test {@link EmailTrackingImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EmailTrackingImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    HashSet<EmailTrackingClicks> emailTrackingClicks = new HashSet<>();
    emailTrackingClicks.add(mock(EmailTrackingClicks.class));

    EmailTrackingImpl emailTrackingImpl = new EmailTrackingImpl();
    emailTrackingImpl
        .setDateSent(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    emailTrackingImpl.setEmailAddress("42 Main St");
    emailTrackingImpl.setEmailTrackingClicks(emailTrackingClicks);
    emailTrackingImpl.setEmailTrackingOpens(new HashSet<>());
    emailTrackingImpl.setId(null);
    emailTrackingImpl.setType("Type");

    EmailTrackingImpl emailTrackingImpl2 = new EmailTrackingImpl();
    emailTrackingImpl2
        .setDateSent(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    emailTrackingImpl2.setEmailAddress("42 Main St");
    emailTrackingImpl2.setEmailTrackingClicks(new HashSet<>());
    emailTrackingImpl2.setEmailTrackingOpens(new HashSet<>());
    emailTrackingImpl2.setId(1L);
    emailTrackingImpl2.setType("Type");

    // Act and Assert
    assertNotEquals(emailTrackingImpl, emailTrackingImpl2);
  }

  /**
   * Test {@link EmailTrackingImpl#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EmailTrackingImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    EmailTrackingImpl emailTrackingImpl = new EmailTrackingImpl();
    emailTrackingImpl
        .setDateSent(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    emailTrackingImpl.setEmailAddress("42 Main St");
    emailTrackingImpl.setEmailTrackingClicks(new HashSet<>());
    emailTrackingImpl.setEmailTrackingOpens(new HashSet<>());
    emailTrackingImpl.setId(1L);
    emailTrackingImpl.setType("Type");

    // Act and Assert
    assertNotEquals(emailTrackingImpl, null);
  }

  /**
   * Test {@link EmailTrackingImpl#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EmailTrackingImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    EmailTrackingImpl emailTrackingImpl = new EmailTrackingImpl();
    emailTrackingImpl
        .setDateSent(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    emailTrackingImpl.setEmailAddress("42 Main St");
    emailTrackingImpl.setEmailTrackingClicks(new HashSet<>());
    emailTrackingImpl.setEmailTrackingOpens(new HashSet<>());
    emailTrackingImpl.setId(1L);
    emailTrackingImpl.setType("Type");

    // Act and Assert
    assertNotEquals(emailTrackingImpl, "Different type to EmailTrackingImpl");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link EmailTrackingImpl}
   *   <li>{@link EmailTrackingImpl#setDateSent(Date)}
   *   <li>{@link EmailTrackingImpl#setEmailAddress(String)}
   *   <li>{@link EmailTrackingImpl#setEmailTrackingClicks(Set)}
   *   <li>{@link EmailTrackingImpl#setEmailTrackingOpens(Set)}
   *   <li>{@link EmailTrackingImpl#setId(Long)}
   *   <li>{@link EmailTrackingImpl#setType(String)}
   *   <li>{@link EmailTrackingImpl#getDateSent()}
   *   <li>{@link EmailTrackingImpl#getEmailAddress()}
   *   <li>{@link EmailTrackingImpl#getEmailTrackingClicks()}
   *   <li>{@link EmailTrackingImpl#getEmailTrackingOpens()}
   *   <li>{@link EmailTrackingImpl#getId()}
   *   <li>{@link EmailTrackingImpl#getType()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    EmailTrackingImpl actualEmailTrackingImpl = new EmailTrackingImpl();
    Date dateSent = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    actualEmailTrackingImpl.setDateSent(dateSent);
    actualEmailTrackingImpl.setEmailAddress("42 Main St");
    HashSet<EmailTrackingClicks> emailTrackingClicks = new HashSet<>();
    actualEmailTrackingImpl.setEmailTrackingClicks(emailTrackingClicks);
    HashSet<EmailTrackingOpens> emailTrackingOpens = new HashSet<>();
    actualEmailTrackingImpl.setEmailTrackingOpens(emailTrackingOpens);
    actualEmailTrackingImpl.setId(1L);
    actualEmailTrackingImpl.setType("Type");
    Date actualDateSent = actualEmailTrackingImpl.getDateSent();
    String actualEmailAddress = actualEmailTrackingImpl.getEmailAddress();
    Set<EmailTrackingClicks> actualEmailTrackingClicks = actualEmailTrackingImpl.getEmailTrackingClicks();
    Set<EmailTrackingOpens> actualEmailTrackingOpens = actualEmailTrackingImpl.getEmailTrackingOpens();
    Long actualId = actualEmailTrackingImpl.getId();

    // Assert that nothing has changed
    assertEquals("42 Main St", actualEmailAddress);
    assertEquals("Type", actualEmailTrackingImpl.getType());
    assertEquals(1L, actualId.longValue());
    assertTrue(actualEmailTrackingClicks.isEmpty());
    assertTrue(actualEmailTrackingOpens.isEmpty());
    assertSame(emailTrackingClicks, actualEmailTrackingClicks);
    assertSame(emailTrackingOpens, actualEmailTrackingOpens);
    assertSame(dateSent, actualDateSent);
  }
}
