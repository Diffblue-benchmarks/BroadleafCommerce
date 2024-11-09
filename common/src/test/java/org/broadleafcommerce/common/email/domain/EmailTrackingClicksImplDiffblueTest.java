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
import static org.mockito.Mockito.mock;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.Date;
import org.junit.Test;

public class EmailTrackingClicksImplDiffblueTest {
  /**
   * Test {@link EmailTrackingClicksImpl#equals(Object)}, and
   * {@link EmailTrackingClicksImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EmailTrackingClicksImpl#equals(Object)}
   *   <li>{@link EmailTrackingClicksImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    EmailTrackingClicksImpl emailTrackingClicksImpl = new EmailTrackingClicksImpl();
    emailTrackingClicksImpl.setCustomerId("42");
    emailTrackingClicksImpl
        .setDateClicked(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    emailTrackingClicksImpl.setDestinationUri("Destination Uri");
    emailTrackingClicksImpl.setEmailTracking(new EmailTrackingImpl());
    emailTrackingClicksImpl.setId(1L);
    emailTrackingClicksImpl.setQueryString("Query String");

    EmailTrackingClicksImpl emailTrackingClicksImpl2 = new EmailTrackingClicksImpl();
    emailTrackingClicksImpl2.setCustomerId("42");
    emailTrackingClicksImpl2
        .setDateClicked(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    emailTrackingClicksImpl2.setDestinationUri("Destination Uri");
    emailTrackingClicksImpl2.setEmailTracking(new EmailTrackingImpl());
    emailTrackingClicksImpl2.setId(1L);
    emailTrackingClicksImpl2.setQueryString("Query String");

    // Act and Assert
    assertEquals(emailTrackingClicksImpl, emailTrackingClicksImpl2);
    int expectedHashCodeResult = emailTrackingClicksImpl.hashCode();
    assertEquals(expectedHashCodeResult, emailTrackingClicksImpl2.hashCode());
  }

  /**
   * Test {@link EmailTrackingClicksImpl#equals(Object)}, and
   * {@link EmailTrackingClicksImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EmailTrackingClicksImpl#equals(Object)}
   *   <li>{@link EmailTrackingClicksImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    EmailTrackingClicksImpl emailTrackingClicksImpl = new EmailTrackingClicksImpl();
    emailTrackingClicksImpl.setCustomerId("42");
    emailTrackingClicksImpl
        .setDateClicked(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    emailTrackingClicksImpl.setDestinationUri("Destination Uri");
    emailTrackingClicksImpl.setEmailTracking(mock(EmailTracking.class));
    emailTrackingClicksImpl.setId(1L);
    emailTrackingClicksImpl.setQueryString("Query String");

    EmailTrackingClicksImpl emailTrackingClicksImpl2 = new EmailTrackingClicksImpl();
    emailTrackingClicksImpl2.setCustomerId("42");
    emailTrackingClicksImpl2
        .setDateClicked(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    emailTrackingClicksImpl2.setDestinationUri("Destination Uri");
    emailTrackingClicksImpl2.setEmailTracking(new EmailTrackingImpl());
    emailTrackingClicksImpl2.setId(1L);
    emailTrackingClicksImpl2.setQueryString("Query String");

    // Act and Assert
    assertEquals(emailTrackingClicksImpl, emailTrackingClicksImpl2);
    int notExpectedHashCodeResult = emailTrackingClicksImpl.hashCode();
    assertNotEquals(notExpectedHashCodeResult, emailTrackingClicksImpl2.hashCode());
  }

  /**
   * Test {@link EmailTrackingClicksImpl#equals(Object)}, and
   * {@link EmailTrackingClicksImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EmailTrackingClicksImpl#equals(Object)}
   *   <li>{@link EmailTrackingClicksImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    EmailTrackingClicksImpl emailTrackingClicksImpl = new EmailTrackingClicksImpl();
    emailTrackingClicksImpl.setCustomerId("42");
    emailTrackingClicksImpl
        .setDateClicked(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    emailTrackingClicksImpl.setDestinationUri("Destination Uri");
    emailTrackingClicksImpl.setEmailTracking(new EmailTrackingImpl());
    emailTrackingClicksImpl.setId(null);
    emailTrackingClicksImpl.setQueryString("Query String");

    EmailTrackingClicksImpl emailTrackingClicksImpl2 = new EmailTrackingClicksImpl();
    emailTrackingClicksImpl2.setCustomerId("42");
    emailTrackingClicksImpl2
        .setDateClicked(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    emailTrackingClicksImpl2.setDestinationUri("Destination Uri");
    emailTrackingClicksImpl2.setEmailTracking(new EmailTrackingImpl());
    emailTrackingClicksImpl2.setId(1L);
    emailTrackingClicksImpl2.setQueryString("Query String");

    // Act and Assert
    assertEquals(emailTrackingClicksImpl, emailTrackingClicksImpl2);
    int expectedHashCodeResult = emailTrackingClicksImpl.hashCode();
    assertEquals(expectedHashCodeResult, emailTrackingClicksImpl2.hashCode());
  }

  /**
   * Test {@link EmailTrackingClicksImpl#equals(Object)}, and
   * {@link EmailTrackingClicksImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EmailTrackingClicksImpl#equals(Object)}
   *   <li>{@link EmailTrackingClicksImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    EmailTrackingClicksImpl emailTrackingClicksImpl = new EmailTrackingClicksImpl();
    emailTrackingClicksImpl.setCustomerId("42");
    emailTrackingClicksImpl
        .setDateClicked(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    emailTrackingClicksImpl.setDestinationUri("Destination Uri");
    emailTrackingClicksImpl.setEmailTracking(new EmailTrackingImpl());
    emailTrackingClicksImpl.setId(1L);
    emailTrackingClicksImpl.setQueryString("Query String");

    EmailTrackingClicksImpl emailTrackingClicksImpl2 = new EmailTrackingClicksImpl();
    emailTrackingClicksImpl2.setCustomerId("42");
    emailTrackingClicksImpl2
        .setDateClicked(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    emailTrackingClicksImpl2.setDestinationUri("Destination Uri");
    emailTrackingClicksImpl2.setEmailTracking(new EmailTrackingImpl());
    emailTrackingClicksImpl2.setId(null);
    emailTrackingClicksImpl2.setQueryString("Query String");

    // Act and Assert
    assertEquals(emailTrackingClicksImpl, emailTrackingClicksImpl2);
    int expectedHashCodeResult = emailTrackingClicksImpl.hashCode();
    assertEquals(expectedHashCodeResult, emailTrackingClicksImpl2.hashCode());
  }

  /**
   * Test {@link EmailTrackingClicksImpl#equals(Object)}, and
   * {@link EmailTrackingClicksImpl#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EmailTrackingClicksImpl#equals(Object)}
   *   <li>{@link EmailTrackingClicksImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    EmailTrackingClicksImpl emailTrackingClicksImpl = new EmailTrackingClicksImpl();
    emailTrackingClicksImpl.setCustomerId("42");
    emailTrackingClicksImpl
        .setDateClicked(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    emailTrackingClicksImpl.setDestinationUri("Destination Uri");
    emailTrackingClicksImpl.setEmailTracking(new EmailTrackingImpl());
    emailTrackingClicksImpl.setId(1L);
    emailTrackingClicksImpl.setQueryString("Query String");

    // Act and Assert
    assertEquals(emailTrackingClicksImpl, emailTrackingClicksImpl);
    int expectedHashCodeResult = emailTrackingClicksImpl.hashCode();
    assertEquals(expectedHashCodeResult, emailTrackingClicksImpl.hashCode());
  }

  /**
   * Test {@link EmailTrackingClicksImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EmailTrackingClicksImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    EmailTrackingClicksImpl emailTrackingClicksImpl = new EmailTrackingClicksImpl();
    emailTrackingClicksImpl.setCustomerId("42");
    emailTrackingClicksImpl
        .setDateClicked(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    emailTrackingClicksImpl.setDestinationUri("Destination Uri");
    emailTrackingClicksImpl.setEmailTracking(new EmailTrackingImpl());
    emailTrackingClicksImpl.setId(2L);
    emailTrackingClicksImpl.setQueryString("Query String");

    EmailTrackingClicksImpl emailTrackingClicksImpl2 = new EmailTrackingClicksImpl();
    emailTrackingClicksImpl2.setCustomerId("42");
    emailTrackingClicksImpl2
        .setDateClicked(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    emailTrackingClicksImpl2.setDestinationUri("Destination Uri");
    emailTrackingClicksImpl2.setEmailTracking(new EmailTrackingImpl());
    emailTrackingClicksImpl2.setId(1L);
    emailTrackingClicksImpl2.setQueryString("Query String");

    // Act and Assert
    assertNotEquals(emailTrackingClicksImpl, emailTrackingClicksImpl2);
  }

  /**
   * Test {@link EmailTrackingClicksImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EmailTrackingClicksImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    EmailTrackingClicksImpl emailTrackingClicksImpl = new EmailTrackingClicksImpl();
    emailTrackingClicksImpl.setCustomerId("42");
    emailTrackingClicksImpl
        .setDateClicked(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    emailTrackingClicksImpl.setDestinationUri("Destination Uri");
    emailTrackingClicksImpl.setEmailTracking(mock(EmailTracking.class));
    emailTrackingClicksImpl.setId(null);
    emailTrackingClicksImpl.setQueryString("Query String");

    EmailTrackingClicksImpl emailTrackingClicksImpl2 = new EmailTrackingClicksImpl();
    emailTrackingClicksImpl2.setCustomerId("42");
    emailTrackingClicksImpl2
        .setDateClicked(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    emailTrackingClicksImpl2.setDestinationUri("Destination Uri");
    emailTrackingClicksImpl2.setEmailTracking(new EmailTrackingImpl());
    emailTrackingClicksImpl2.setId(1L);
    emailTrackingClicksImpl2.setQueryString("Query String");

    // Act and Assert
    assertNotEquals(emailTrackingClicksImpl, emailTrackingClicksImpl2);
  }

  /**
   * Test {@link EmailTrackingClicksImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EmailTrackingClicksImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    EmailTrackingClicksImpl emailTrackingClicksImpl = new EmailTrackingClicksImpl();
    emailTrackingClicksImpl.setCustomerId("Destination Uri");
    emailTrackingClicksImpl
        .setDateClicked(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    emailTrackingClicksImpl.setDestinationUri("Destination Uri");
    emailTrackingClicksImpl.setEmailTracking(new EmailTrackingImpl());
    emailTrackingClicksImpl.setId(null);
    emailTrackingClicksImpl.setQueryString("Query String");

    EmailTrackingClicksImpl emailTrackingClicksImpl2 = new EmailTrackingClicksImpl();
    emailTrackingClicksImpl2.setCustomerId("42");
    emailTrackingClicksImpl2
        .setDateClicked(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    emailTrackingClicksImpl2.setDestinationUri("Destination Uri");
    emailTrackingClicksImpl2.setEmailTracking(new EmailTrackingImpl());
    emailTrackingClicksImpl2.setId(1L);
    emailTrackingClicksImpl2.setQueryString("Query String");

    // Act and Assert
    assertNotEquals(emailTrackingClicksImpl, emailTrackingClicksImpl2);
  }

  /**
   * Test {@link EmailTrackingClicksImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EmailTrackingClicksImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    EmailTrackingClicksImpl emailTrackingClicksImpl = new EmailTrackingClicksImpl();
    emailTrackingClicksImpl.setCustomerId(null);
    emailTrackingClicksImpl
        .setDateClicked(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    emailTrackingClicksImpl.setDestinationUri("Destination Uri");
    emailTrackingClicksImpl.setEmailTracking(new EmailTrackingImpl());
    emailTrackingClicksImpl.setId(null);
    emailTrackingClicksImpl.setQueryString("Query String");

    EmailTrackingClicksImpl emailTrackingClicksImpl2 = new EmailTrackingClicksImpl();
    emailTrackingClicksImpl2.setCustomerId("42");
    emailTrackingClicksImpl2
        .setDateClicked(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    emailTrackingClicksImpl2.setDestinationUri("Destination Uri");
    emailTrackingClicksImpl2.setEmailTracking(new EmailTrackingImpl());
    emailTrackingClicksImpl2.setId(1L);
    emailTrackingClicksImpl2.setQueryString("Query String");

    // Act and Assert
    assertNotEquals(emailTrackingClicksImpl, emailTrackingClicksImpl2);
  }

  /**
   * Test {@link EmailTrackingClicksImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EmailTrackingClicksImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    EmailTrackingClicksImpl emailTrackingClicksImpl = new EmailTrackingClicksImpl();
    emailTrackingClicksImpl.setCustomerId("42");
    emailTrackingClicksImpl
        .setDateClicked(Date.from(LocalDate.now().atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    emailTrackingClicksImpl.setDestinationUri("Destination Uri");
    emailTrackingClicksImpl.setEmailTracking(new EmailTrackingImpl());
    emailTrackingClicksImpl.setId(null);
    emailTrackingClicksImpl.setQueryString("Query String");

    EmailTrackingClicksImpl emailTrackingClicksImpl2 = new EmailTrackingClicksImpl();
    emailTrackingClicksImpl2.setCustomerId("42");
    emailTrackingClicksImpl2
        .setDateClicked(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    emailTrackingClicksImpl2.setDestinationUri("Destination Uri");
    emailTrackingClicksImpl2.setEmailTracking(new EmailTrackingImpl());
    emailTrackingClicksImpl2.setId(1L);
    emailTrackingClicksImpl2.setQueryString("Query String");

    // Act and Assert
    assertNotEquals(emailTrackingClicksImpl, emailTrackingClicksImpl2);
  }

  /**
   * Test {@link EmailTrackingClicksImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EmailTrackingClicksImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    EmailTrackingClicksImpl emailTrackingClicksImpl = new EmailTrackingClicksImpl();
    emailTrackingClicksImpl.setCustomerId("42");
    emailTrackingClicksImpl.setDateClicked(null);
    emailTrackingClicksImpl.setDestinationUri("Destination Uri");
    emailTrackingClicksImpl.setEmailTracking(new EmailTrackingImpl());
    emailTrackingClicksImpl.setId(null);
    emailTrackingClicksImpl.setQueryString("Query String");

    EmailTrackingClicksImpl emailTrackingClicksImpl2 = new EmailTrackingClicksImpl();
    emailTrackingClicksImpl2.setCustomerId("42");
    emailTrackingClicksImpl2
        .setDateClicked(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    emailTrackingClicksImpl2.setDestinationUri("Destination Uri");
    emailTrackingClicksImpl2.setEmailTracking(new EmailTrackingImpl());
    emailTrackingClicksImpl2.setId(1L);
    emailTrackingClicksImpl2.setQueryString("Query String");

    // Act and Assert
    assertNotEquals(emailTrackingClicksImpl, emailTrackingClicksImpl2);
  }

  /**
   * Test {@link EmailTrackingClicksImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EmailTrackingClicksImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    EmailTrackingClicksImpl emailTrackingClicksImpl = new EmailTrackingClicksImpl();
    emailTrackingClicksImpl.setCustomerId("42");
    emailTrackingClicksImpl
        .setDateClicked(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    emailTrackingClicksImpl.setDestinationUri("42");
    emailTrackingClicksImpl.setEmailTracking(new EmailTrackingImpl());
    emailTrackingClicksImpl.setId(null);
    emailTrackingClicksImpl.setQueryString("Query String");

    EmailTrackingClicksImpl emailTrackingClicksImpl2 = new EmailTrackingClicksImpl();
    emailTrackingClicksImpl2.setCustomerId("42");
    emailTrackingClicksImpl2
        .setDateClicked(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    emailTrackingClicksImpl2.setDestinationUri("Destination Uri");
    emailTrackingClicksImpl2.setEmailTracking(new EmailTrackingImpl());
    emailTrackingClicksImpl2.setId(1L);
    emailTrackingClicksImpl2.setQueryString("Query String");

    // Act and Assert
    assertNotEquals(emailTrackingClicksImpl, emailTrackingClicksImpl2);
  }

  /**
   * Test {@link EmailTrackingClicksImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EmailTrackingClicksImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    EmailTrackingClicksImpl emailTrackingClicksImpl = new EmailTrackingClicksImpl();
    emailTrackingClicksImpl.setCustomerId("42");
    emailTrackingClicksImpl
        .setDateClicked(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    emailTrackingClicksImpl.setDestinationUri(null);
    emailTrackingClicksImpl.setEmailTracking(new EmailTrackingImpl());
    emailTrackingClicksImpl.setId(null);
    emailTrackingClicksImpl.setQueryString("Query String");

    EmailTrackingClicksImpl emailTrackingClicksImpl2 = new EmailTrackingClicksImpl();
    emailTrackingClicksImpl2.setCustomerId("42");
    emailTrackingClicksImpl2
        .setDateClicked(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    emailTrackingClicksImpl2.setDestinationUri("Destination Uri");
    emailTrackingClicksImpl2.setEmailTracking(new EmailTrackingImpl());
    emailTrackingClicksImpl2.setId(1L);
    emailTrackingClicksImpl2.setQueryString("Query String");

    // Act and Assert
    assertNotEquals(emailTrackingClicksImpl, emailTrackingClicksImpl2);
  }

  /**
   * Test {@link EmailTrackingClicksImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EmailTrackingClicksImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    EmailTrackingClicksImpl emailTrackingClicksImpl = new EmailTrackingClicksImpl();
    emailTrackingClicksImpl.setCustomerId("42");
    emailTrackingClicksImpl
        .setDateClicked(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    emailTrackingClicksImpl.setDestinationUri("Destination Uri");
    emailTrackingClicksImpl.setEmailTracking(null);
    emailTrackingClicksImpl.setId(null);
    emailTrackingClicksImpl.setQueryString("Query String");

    EmailTrackingClicksImpl emailTrackingClicksImpl2 = new EmailTrackingClicksImpl();
    emailTrackingClicksImpl2.setCustomerId("42");
    emailTrackingClicksImpl2
        .setDateClicked(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    emailTrackingClicksImpl2.setDestinationUri("Destination Uri");
    emailTrackingClicksImpl2.setEmailTracking(new EmailTrackingImpl());
    emailTrackingClicksImpl2.setId(1L);
    emailTrackingClicksImpl2.setQueryString("Query String");

    // Act and Assert
    assertNotEquals(emailTrackingClicksImpl, emailTrackingClicksImpl2);
  }

  /**
   * Test {@link EmailTrackingClicksImpl#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EmailTrackingClicksImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    EmailTrackingClicksImpl emailTrackingClicksImpl = new EmailTrackingClicksImpl();
    emailTrackingClicksImpl.setCustomerId("42");
    emailTrackingClicksImpl
        .setDateClicked(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    emailTrackingClicksImpl.setDestinationUri("Destination Uri");
    emailTrackingClicksImpl.setEmailTracking(new EmailTrackingImpl());
    emailTrackingClicksImpl.setId(1L);
    emailTrackingClicksImpl.setQueryString("Query String");

    // Act and Assert
    assertNotEquals(emailTrackingClicksImpl, null);
  }

  /**
   * Test {@link EmailTrackingClicksImpl#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EmailTrackingClicksImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    EmailTrackingClicksImpl emailTrackingClicksImpl = new EmailTrackingClicksImpl();
    emailTrackingClicksImpl.setCustomerId("42");
    emailTrackingClicksImpl
        .setDateClicked(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    emailTrackingClicksImpl.setDestinationUri("Destination Uri");
    emailTrackingClicksImpl.setEmailTracking(new EmailTrackingImpl());
    emailTrackingClicksImpl.setId(1L);
    emailTrackingClicksImpl.setQueryString("Query String");

    // Act and Assert
    assertNotEquals(emailTrackingClicksImpl, "Different type to EmailTrackingClicksImpl");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link EmailTrackingClicksImpl}
   *   <li>{@link EmailTrackingClicksImpl#setCustomerId(String)}
   *   <li>{@link EmailTrackingClicksImpl#setDateClicked(Date)}
   *   <li>{@link EmailTrackingClicksImpl#setDestinationUri(String)}
   *   <li>{@link EmailTrackingClicksImpl#setEmailTracking(EmailTracking)}
   *   <li>{@link EmailTrackingClicksImpl#setId(Long)}
   *   <li>{@link EmailTrackingClicksImpl#setQueryString(String)}
   *   <li>{@link EmailTrackingClicksImpl#getCustomerId()}
   *   <li>{@link EmailTrackingClicksImpl#getDateClicked()}
   *   <li>{@link EmailTrackingClicksImpl#getDestinationUri()}
   *   <li>{@link EmailTrackingClicksImpl#getEmailTracking()}
   *   <li>{@link EmailTrackingClicksImpl#getId()}
   *   <li>{@link EmailTrackingClicksImpl#getQueryString()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    EmailTrackingClicksImpl actualEmailTrackingClicksImpl = new EmailTrackingClicksImpl();
    actualEmailTrackingClicksImpl.setCustomerId("42");
    Date dateClicked = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    actualEmailTrackingClicksImpl.setDateClicked(dateClicked);
    actualEmailTrackingClicksImpl.setDestinationUri("Destination Uri");
    EmailTrackingImpl emailTracking = new EmailTrackingImpl();
    actualEmailTrackingClicksImpl.setEmailTracking(emailTracking);
    actualEmailTrackingClicksImpl.setId(1L);
    actualEmailTrackingClicksImpl.setQueryString("Query String");
    String actualCustomerId = actualEmailTrackingClicksImpl.getCustomerId();
    Date actualDateClicked = actualEmailTrackingClicksImpl.getDateClicked();
    String actualDestinationUri = actualEmailTrackingClicksImpl.getDestinationUri();
    EmailTracking actualEmailTracking = actualEmailTrackingClicksImpl.getEmailTracking();
    Long actualId = actualEmailTrackingClicksImpl.getId();

    // Assert that nothing has changed
    assertEquals("42", actualCustomerId);
    assertEquals("Destination Uri", actualDestinationUri);
    assertEquals("Query String", actualEmailTrackingClicksImpl.getQueryString());
    assertEquals(1L, actualId.longValue());
    assertSame(emailTracking, actualEmailTracking);
    assertSame(dateClicked, actualDateClicked);
  }
}
