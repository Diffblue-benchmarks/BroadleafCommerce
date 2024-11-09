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

public class EmailTrackingOpensImplDiffblueTest {
  /**
   * Test {@link EmailTrackingOpensImpl#setUserAgent(String)}.
   * <ul>
   *   <li>Given {@link EmailTrackingOpensImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link EmailTrackingOpensImpl#setUserAgent(String)}
   */
  @Test
  public void testSetUserAgent_givenEmailTrackingOpensImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EmailTrackingOpensImpl emailTrackingOpensImpl = new EmailTrackingOpensImpl();

    // Act
    emailTrackingOpensImpl.setUserAgent("User Agent");

    // Assert
    assertEquals("User Agent", emailTrackingOpensImpl.getUserAgent());
  }

  /**
   * Test {@link EmailTrackingOpensImpl#setUserAgent(String)}.
   * <ul>
   *   <li>Given {@link EmailTrackingOpensImpl} (default constructor) DateOpened is
   * {@link Date}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EmailTrackingOpensImpl#setUserAgent(String)}
   */
  @Test
  public void testSetUserAgent_givenEmailTrackingOpensImplDateOpenedIsDate() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EmailTrackingOpensImpl emailTrackingOpensImpl = new EmailTrackingOpensImpl();
    emailTrackingOpensImpl.setDateOpened(mock(java.sql.Date.class));

    // Act
    emailTrackingOpensImpl.setUserAgent("User Agent");

    // Assert
    assertEquals("User Agent", emailTrackingOpensImpl.getUserAgent());
  }

  /**
   * Test {@link EmailTrackingOpensImpl#equals(Object)}, and
   * {@link EmailTrackingOpensImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EmailTrackingOpensImpl#equals(Object)}
   *   <li>{@link EmailTrackingOpensImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    EmailTrackingOpensImpl emailTrackingOpensImpl = new EmailTrackingOpensImpl();
    emailTrackingOpensImpl
        .setDateOpened(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    emailTrackingOpensImpl.setEmailTracking(new EmailTrackingImpl());
    emailTrackingOpensImpl.setId(1L);
    emailTrackingOpensImpl.setUserAgent("User Agent");

    EmailTrackingOpensImpl emailTrackingOpensImpl2 = new EmailTrackingOpensImpl();
    emailTrackingOpensImpl2
        .setDateOpened(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    emailTrackingOpensImpl2.setEmailTracking(new EmailTrackingImpl());
    emailTrackingOpensImpl2.setId(1L);
    emailTrackingOpensImpl2.setUserAgent("User Agent");

    // Act and Assert
    assertEquals(emailTrackingOpensImpl, emailTrackingOpensImpl2);
    int expectedHashCodeResult = emailTrackingOpensImpl.hashCode();
    assertEquals(expectedHashCodeResult, emailTrackingOpensImpl2.hashCode());
  }

  /**
   * Test {@link EmailTrackingOpensImpl#equals(Object)}, and
   * {@link EmailTrackingOpensImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EmailTrackingOpensImpl#equals(Object)}
   *   <li>{@link EmailTrackingOpensImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    EmailTrackingOpensImpl emailTrackingOpensImpl = new EmailTrackingOpensImpl();
    emailTrackingOpensImpl.setDateOpened(null);
    emailTrackingOpensImpl.setEmailTracking(new EmailTrackingImpl());
    emailTrackingOpensImpl.setId(1L);
    emailTrackingOpensImpl.setUserAgent("User Agent");

    EmailTrackingOpensImpl emailTrackingOpensImpl2 = new EmailTrackingOpensImpl();
    emailTrackingOpensImpl2.setDateOpened(null);
    emailTrackingOpensImpl2.setEmailTracking(new EmailTrackingImpl());
    emailTrackingOpensImpl2.setId(1L);
    emailTrackingOpensImpl2.setUserAgent("User Agent");

    // Act and Assert
    assertEquals(emailTrackingOpensImpl, emailTrackingOpensImpl2);
    int expectedHashCodeResult = emailTrackingOpensImpl.hashCode();
    assertEquals(expectedHashCodeResult, emailTrackingOpensImpl2.hashCode());
  }

  /**
   * Test {@link EmailTrackingOpensImpl#equals(Object)}, and
   * {@link EmailTrackingOpensImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EmailTrackingOpensImpl#equals(Object)}
   *   <li>{@link EmailTrackingOpensImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    EmailTrackingOpensImpl emailTrackingOpensImpl = new EmailTrackingOpensImpl();
    emailTrackingOpensImpl
        .setDateOpened(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    emailTrackingOpensImpl.setEmailTracking(null);
    emailTrackingOpensImpl.setId(1L);
    emailTrackingOpensImpl.setUserAgent("User Agent");

    EmailTrackingOpensImpl emailTrackingOpensImpl2 = new EmailTrackingOpensImpl();
    emailTrackingOpensImpl2
        .setDateOpened(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    emailTrackingOpensImpl2.setEmailTracking(null);
    emailTrackingOpensImpl2.setId(1L);
    emailTrackingOpensImpl2.setUserAgent("User Agent");

    // Act and Assert
    assertEquals(emailTrackingOpensImpl, emailTrackingOpensImpl2);
    int expectedHashCodeResult = emailTrackingOpensImpl.hashCode();
    assertEquals(expectedHashCodeResult, emailTrackingOpensImpl2.hashCode());
  }

  /**
   * Test {@link EmailTrackingOpensImpl#equals(Object)}, and
   * {@link EmailTrackingOpensImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EmailTrackingOpensImpl#equals(Object)}
   *   <li>{@link EmailTrackingOpensImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    EmailTrackingOpensImpl emailTrackingOpensImpl = new EmailTrackingOpensImpl();
    emailTrackingOpensImpl
        .setDateOpened(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    emailTrackingOpensImpl.setEmailTracking(new EmailTrackingImpl());
    emailTrackingOpensImpl.setId(null);
    emailTrackingOpensImpl.setUserAgent("User Agent");

    EmailTrackingOpensImpl emailTrackingOpensImpl2 = new EmailTrackingOpensImpl();
    emailTrackingOpensImpl2
        .setDateOpened(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    emailTrackingOpensImpl2.setEmailTracking(new EmailTrackingImpl());
    emailTrackingOpensImpl2.setId(null);
    emailTrackingOpensImpl2.setUserAgent("User Agent");

    // Act and Assert
    assertEquals(emailTrackingOpensImpl, emailTrackingOpensImpl2);
    int expectedHashCodeResult = emailTrackingOpensImpl.hashCode();
    assertEquals(expectedHashCodeResult, emailTrackingOpensImpl2.hashCode());
  }

  /**
   * Test {@link EmailTrackingOpensImpl#equals(Object)}, and
   * {@link EmailTrackingOpensImpl#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EmailTrackingOpensImpl#equals(Object)}
   *   <li>{@link EmailTrackingOpensImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    EmailTrackingOpensImpl emailTrackingOpensImpl = new EmailTrackingOpensImpl();
    emailTrackingOpensImpl
        .setDateOpened(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    emailTrackingOpensImpl.setEmailTracking(new EmailTrackingImpl());
    emailTrackingOpensImpl.setId(1L);
    emailTrackingOpensImpl.setUserAgent("User Agent");

    // Act and Assert
    assertEquals(emailTrackingOpensImpl, emailTrackingOpensImpl);
    int expectedHashCodeResult = emailTrackingOpensImpl.hashCode();
    assertEquals(expectedHashCodeResult, emailTrackingOpensImpl.hashCode());
  }

  /**
   * Test {@link EmailTrackingOpensImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EmailTrackingOpensImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    EmailTrackingOpensImpl emailTrackingOpensImpl = new EmailTrackingOpensImpl();
    emailTrackingOpensImpl.setDateOpened(Date.from(LocalDate.now().atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    emailTrackingOpensImpl.setEmailTracking(new EmailTrackingImpl());
    emailTrackingOpensImpl.setId(1L);
    emailTrackingOpensImpl.setUserAgent("User Agent");

    EmailTrackingOpensImpl emailTrackingOpensImpl2 = new EmailTrackingOpensImpl();
    emailTrackingOpensImpl2
        .setDateOpened(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    emailTrackingOpensImpl2.setEmailTracking(new EmailTrackingImpl());
    emailTrackingOpensImpl2.setId(1L);
    emailTrackingOpensImpl2.setUserAgent("User Agent");

    // Act and Assert
    assertNotEquals(emailTrackingOpensImpl, emailTrackingOpensImpl2);
  }

  /**
   * Test {@link EmailTrackingOpensImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EmailTrackingOpensImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    EmailTrackingOpensImpl emailTrackingOpensImpl = new EmailTrackingOpensImpl();
    emailTrackingOpensImpl.setDateOpened(null);
    emailTrackingOpensImpl.setEmailTracking(new EmailTrackingImpl());
    emailTrackingOpensImpl.setId(1L);
    emailTrackingOpensImpl.setUserAgent("User Agent");

    EmailTrackingOpensImpl emailTrackingOpensImpl2 = new EmailTrackingOpensImpl();
    emailTrackingOpensImpl2
        .setDateOpened(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    emailTrackingOpensImpl2.setEmailTracking(new EmailTrackingImpl());
    emailTrackingOpensImpl2.setId(1L);
    emailTrackingOpensImpl2.setUserAgent("User Agent");

    // Act and Assert
    assertNotEquals(emailTrackingOpensImpl, emailTrackingOpensImpl2);
  }

  /**
   * Test {@link EmailTrackingOpensImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EmailTrackingOpensImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    EmailTrackingOpensImpl emailTrackingOpensImpl = new EmailTrackingOpensImpl();
    emailTrackingOpensImpl
        .setDateOpened(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    emailTrackingOpensImpl.setEmailTracking(null);
    emailTrackingOpensImpl.setId(1L);
    emailTrackingOpensImpl.setUserAgent("User Agent");

    EmailTrackingOpensImpl emailTrackingOpensImpl2 = new EmailTrackingOpensImpl();
    emailTrackingOpensImpl2
        .setDateOpened(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    emailTrackingOpensImpl2.setEmailTracking(new EmailTrackingImpl());
    emailTrackingOpensImpl2.setId(1L);
    emailTrackingOpensImpl2.setUserAgent("User Agent");

    // Act and Assert
    assertNotEquals(emailTrackingOpensImpl, emailTrackingOpensImpl2);
  }

  /**
   * Test {@link EmailTrackingOpensImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EmailTrackingOpensImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    EmailTrackingOpensImpl emailTrackingOpensImpl = new EmailTrackingOpensImpl();
    emailTrackingOpensImpl
        .setDateOpened(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    emailTrackingOpensImpl.setEmailTracking(mock(EmailTrackingImpl.class));
    emailTrackingOpensImpl.setId(1L);
    emailTrackingOpensImpl.setUserAgent("User Agent");

    EmailTrackingOpensImpl emailTrackingOpensImpl2 = new EmailTrackingOpensImpl();
    emailTrackingOpensImpl2
        .setDateOpened(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    emailTrackingOpensImpl2.setEmailTracking(new EmailTrackingImpl());
    emailTrackingOpensImpl2.setId(1L);
    emailTrackingOpensImpl2.setUserAgent("User Agent");

    // Act and Assert
    assertNotEquals(emailTrackingOpensImpl, emailTrackingOpensImpl2);
  }

  /**
   * Test {@link EmailTrackingOpensImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EmailTrackingOpensImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    EmailTrackingOpensImpl emailTrackingOpensImpl = new EmailTrackingOpensImpl();
    emailTrackingOpensImpl
        .setDateOpened(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    emailTrackingOpensImpl.setEmailTracking(new EmailTrackingImpl());
    emailTrackingOpensImpl.setId(2L);
    emailTrackingOpensImpl.setUserAgent("User Agent");

    EmailTrackingOpensImpl emailTrackingOpensImpl2 = new EmailTrackingOpensImpl();
    emailTrackingOpensImpl2
        .setDateOpened(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    emailTrackingOpensImpl2.setEmailTracking(new EmailTrackingImpl());
    emailTrackingOpensImpl2.setId(1L);
    emailTrackingOpensImpl2.setUserAgent("User Agent");

    // Act and Assert
    assertNotEquals(emailTrackingOpensImpl, emailTrackingOpensImpl2);
  }

  /**
   * Test {@link EmailTrackingOpensImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EmailTrackingOpensImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    EmailTrackingOpensImpl emailTrackingOpensImpl = new EmailTrackingOpensImpl();
    emailTrackingOpensImpl
        .setDateOpened(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    emailTrackingOpensImpl.setEmailTracking(new EmailTrackingImpl());
    emailTrackingOpensImpl.setId(null);
    emailTrackingOpensImpl.setUserAgent("User Agent");

    EmailTrackingOpensImpl emailTrackingOpensImpl2 = new EmailTrackingOpensImpl();
    emailTrackingOpensImpl2
        .setDateOpened(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    emailTrackingOpensImpl2.setEmailTracking(new EmailTrackingImpl());
    emailTrackingOpensImpl2.setId(1L);
    emailTrackingOpensImpl2.setUserAgent("User Agent");

    // Act and Assert
    assertNotEquals(emailTrackingOpensImpl, emailTrackingOpensImpl2);
  }

  /**
   * Test {@link EmailTrackingOpensImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EmailTrackingOpensImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    EmailTrackingOpensImpl emailTrackingOpensImpl = new EmailTrackingOpensImpl();
    emailTrackingOpensImpl
        .setDateOpened(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    emailTrackingOpensImpl.setEmailTracking(new EmailTrackingImpl());
    emailTrackingOpensImpl.setId(1L);
    emailTrackingOpensImpl.setUserAgent("42");

    EmailTrackingOpensImpl emailTrackingOpensImpl2 = new EmailTrackingOpensImpl();
    emailTrackingOpensImpl2
        .setDateOpened(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    emailTrackingOpensImpl2.setEmailTracking(new EmailTrackingImpl());
    emailTrackingOpensImpl2.setId(1L);
    emailTrackingOpensImpl2.setUserAgent("User Agent");

    // Act and Assert
    assertNotEquals(emailTrackingOpensImpl, emailTrackingOpensImpl2);
  }

  /**
   * Test {@link EmailTrackingOpensImpl#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EmailTrackingOpensImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    EmailTrackingOpensImpl emailTrackingOpensImpl = new EmailTrackingOpensImpl();
    emailTrackingOpensImpl
        .setDateOpened(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    emailTrackingOpensImpl.setEmailTracking(new EmailTrackingImpl());
    emailTrackingOpensImpl.setId(1L);
    emailTrackingOpensImpl.setUserAgent("User Agent");

    // Act and Assert
    assertNotEquals(emailTrackingOpensImpl, null);
  }

  /**
   * Test {@link EmailTrackingOpensImpl#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EmailTrackingOpensImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    EmailTrackingOpensImpl emailTrackingOpensImpl = new EmailTrackingOpensImpl();
    emailTrackingOpensImpl
        .setDateOpened(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    emailTrackingOpensImpl.setEmailTracking(new EmailTrackingImpl());
    emailTrackingOpensImpl.setId(1L);
    emailTrackingOpensImpl.setUserAgent("User Agent");

    // Act and Assert
    assertNotEquals(emailTrackingOpensImpl, "Different type to EmailTrackingOpensImpl");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link EmailTrackingOpensImpl}
   *   <li>{@link EmailTrackingOpensImpl#setDateOpened(Date)}
   *   <li>{@link EmailTrackingOpensImpl#setEmailTracking(EmailTracking)}
   *   <li>{@link EmailTrackingOpensImpl#setId(Long)}
   *   <li>{@link EmailTrackingOpensImpl#getDateOpened()}
   *   <li>{@link EmailTrackingOpensImpl#getEmailTracking()}
   *   <li>{@link EmailTrackingOpensImpl#getId()}
   *   <li>{@link EmailTrackingOpensImpl#getUserAgent()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    EmailTrackingOpensImpl actualEmailTrackingOpensImpl = new EmailTrackingOpensImpl();
    Date dateOpened = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    actualEmailTrackingOpensImpl.setDateOpened(dateOpened);
    EmailTrackingImpl emailTracking = new EmailTrackingImpl();
    actualEmailTrackingOpensImpl.setEmailTracking(emailTracking);
    actualEmailTrackingOpensImpl.setId(1L);
    Date actualDateOpened = actualEmailTrackingOpensImpl.getDateOpened();
    EmailTracking actualEmailTracking = actualEmailTrackingOpensImpl.getEmailTracking();
    Long actualId = actualEmailTrackingOpensImpl.getId();
    actualEmailTrackingOpensImpl.getUserAgent();

    // Assert that nothing has changed
    assertEquals(1L, actualId.longValue());
    assertSame(emailTracking, actualEmailTracking);
    assertSame(dateOpened, actualDateOpened);
  }
}
