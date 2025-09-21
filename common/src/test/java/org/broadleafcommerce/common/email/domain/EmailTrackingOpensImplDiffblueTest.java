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
package org.broadleafcommerce.common.email.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.Date;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"/bl-common-applicationContext-entity.xml"})
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(SpringJUnit4ClassRunner.class)
public class EmailTrackingOpensImplDiffblueTest {
  @Autowired private EmailTrackingOpensImpl emailTrackingOpensImpl;

  /**
   * Test {@link EmailTrackingOpensImpl#setUserAgent(String)}.
   *
   * <ul>
   *   <li>When {@code User Agent}.
   *   <li>Then {@link EmailTrackingOpensImpl} UserAgent is {@code User Agent}.
   * </ul>
   *
   * <p>Method under test: {@link EmailTrackingOpensImpl#setUserAgent(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void EmailTrackingOpensImpl.setUserAgent(String)"})
  public void testSetUserAgent_whenUserAgent_thenEmailTrackingOpensImplUserAgentIsUserAgent() {
    // Arrange and Act
    emailTrackingOpensImpl.setUserAgent("User Agent");

    // Assert
    assertEquals("User Agent", emailTrackingOpensImpl.getUserAgent());
  }

  /**
   * Test {@link EmailTrackingOpensImpl#equals(Object)}, and {@link
   * EmailTrackingOpensImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EmailTrackingOpensImpl#equals(Object)}
   *   <li>{@link EmailTrackingOpensImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EmailTrackingOpensImpl.equals(Object)",
    "int EmailTrackingOpensImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    EmailTrackingOpensImpl emailTrackingOpensImpl = new EmailTrackingOpensImpl();
    emailTrackingOpensImpl.setDateOpened(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    emailTrackingOpensImpl.setEmailTracking(new EmailTrackingImpl());
    emailTrackingOpensImpl.setId(1L);
    emailTrackingOpensImpl.setUserAgent("User Agent");

    EmailTrackingOpensImpl emailTrackingOpensImpl2 = new EmailTrackingOpensImpl();
    emailTrackingOpensImpl2.setDateOpened(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    emailTrackingOpensImpl2.setEmailTracking(new EmailTrackingImpl());
    emailTrackingOpensImpl2.setId(1L);
    emailTrackingOpensImpl2.setUserAgent("User Agent");

    // Act and Assert
    assertEquals(emailTrackingOpensImpl, emailTrackingOpensImpl2);
    assertEquals(emailTrackingOpensImpl.hashCode(), emailTrackingOpensImpl2.hashCode());
  }

  /**
   * Test {@link EmailTrackingOpensImpl#equals(Object)}, and {@link
   * EmailTrackingOpensImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EmailTrackingOpensImpl#equals(Object)}
   *   <li>{@link EmailTrackingOpensImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EmailTrackingOpensImpl.equals(Object)",
    "int EmailTrackingOpensImpl.hashCode()"
  })
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
    assertEquals(emailTrackingOpensImpl.hashCode(), emailTrackingOpensImpl2.hashCode());
  }

  /**
   * Test {@link EmailTrackingOpensImpl#equals(Object)}, and {@link
   * EmailTrackingOpensImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EmailTrackingOpensImpl#equals(Object)}
   *   <li>{@link EmailTrackingOpensImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EmailTrackingOpensImpl.equals(Object)",
    "int EmailTrackingOpensImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    EmailTrackingOpensImpl emailTrackingOpensImpl = new EmailTrackingOpensImpl();
    emailTrackingOpensImpl.setDateOpened(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    emailTrackingOpensImpl.setEmailTracking(null);
    emailTrackingOpensImpl.setId(1L);
    emailTrackingOpensImpl.setUserAgent("User Agent");

    EmailTrackingOpensImpl emailTrackingOpensImpl2 = new EmailTrackingOpensImpl();
    emailTrackingOpensImpl2.setDateOpened(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    emailTrackingOpensImpl2.setEmailTracking(null);
    emailTrackingOpensImpl2.setId(1L);
    emailTrackingOpensImpl2.setUserAgent("User Agent");

    // Act and Assert
    assertEquals(emailTrackingOpensImpl, emailTrackingOpensImpl2);
    assertEquals(emailTrackingOpensImpl.hashCode(), emailTrackingOpensImpl2.hashCode());
  }

  /**
   * Test {@link EmailTrackingOpensImpl#equals(Object)}, and {@link
   * EmailTrackingOpensImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EmailTrackingOpensImpl#equals(Object)}
   *   <li>{@link EmailTrackingOpensImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EmailTrackingOpensImpl.equals(Object)",
    "int EmailTrackingOpensImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    EmailTrackingOpensImpl emailTrackingOpensImpl = new EmailTrackingOpensImpl();
    emailTrackingOpensImpl.setDateOpened(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    emailTrackingOpensImpl.setEmailTracking(new EmailTrackingImpl());
    emailTrackingOpensImpl.setId(null);
    emailTrackingOpensImpl.setUserAgent("User Agent");

    EmailTrackingOpensImpl emailTrackingOpensImpl2 = new EmailTrackingOpensImpl();
    emailTrackingOpensImpl2.setDateOpened(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    emailTrackingOpensImpl2.setEmailTracking(new EmailTrackingImpl());
    emailTrackingOpensImpl2.setId(null);
    emailTrackingOpensImpl2.setUserAgent("User Agent");

    // Act and Assert
    assertEquals(emailTrackingOpensImpl, emailTrackingOpensImpl2);
    assertEquals(emailTrackingOpensImpl.hashCode(), emailTrackingOpensImpl2.hashCode());
  }

  /**
   * Test {@link EmailTrackingOpensImpl#equals(Object)}, and {@link
   * EmailTrackingOpensImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EmailTrackingOpensImpl#equals(Object)}
   *   <li>{@link EmailTrackingOpensImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EmailTrackingOpensImpl.equals(Object)",
    "int EmailTrackingOpensImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    EmailTrackingOpensImpl emailTrackingOpensImpl = new EmailTrackingOpensImpl();
    emailTrackingOpensImpl.setDateOpened(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EmailTrackingOpensImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EmailTrackingOpensImpl.equals(Object)",
    "int EmailTrackingOpensImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    EmailTrackingOpensImpl emailTrackingOpensImpl = new EmailTrackingOpensImpl();
    emailTrackingOpensImpl.setDateOpened(new Date());
    emailTrackingOpensImpl.setEmailTracking(new EmailTrackingImpl());
    emailTrackingOpensImpl.setId(1L);
    emailTrackingOpensImpl.setUserAgent("User Agent");

    EmailTrackingOpensImpl emailTrackingOpensImpl2 = new EmailTrackingOpensImpl();
    emailTrackingOpensImpl2.setDateOpened(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    emailTrackingOpensImpl2.setEmailTracking(new EmailTrackingImpl());
    emailTrackingOpensImpl2.setId(1L);
    emailTrackingOpensImpl2.setUserAgent("User Agent");

    // Act and Assert
    assertNotEquals(emailTrackingOpensImpl, emailTrackingOpensImpl2);
  }

  /**
   * Test {@link EmailTrackingOpensImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EmailTrackingOpensImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EmailTrackingOpensImpl.equals(Object)",
    "int EmailTrackingOpensImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    EmailTrackingOpensImpl emailTrackingOpensImpl = new EmailTrackingOpensImpl();
    emailTrackingOpensImpl.setDateOpened(null);
    emailTrackingOpensImpl.setEmailTracking(new EmailTrackingImpl());
    emailTrackingOpensImpl.setId(1L);
    emailTrackingOpensImpl.setUserAgent("User Agent");

    EmailTrackingOpensImpl emailTrackingOpensImpl2 = new EmailTrackingOpensImpl();
    emailTrackingOpensImpl2.setDateOpened(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    emailTrackingOpensImpl2.setEmailTracking(new EmailTrackingImpl());
    emailTrackingOpensImpl2.setId(1L);
    emailTrackingOpensImpl2.setUserAgent("User Agent");

    // Act and Assert
    assertNotEquals(emailTrackingOpensImpl, emailTrackingOpensImpl2);
  }

  /**
   * Test {@link EmailTrackingOpensImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EmailTrackingOpensImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EmailTrackingOpensImpl.equals(Object)",
    "int EmailTrackingOpensImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    EmailTrackingOpensImpl emailTrackingOpensImpl = new EmailTrackingOpensImpl();
    emailTrackingOpensImpl.setDateOpened(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    emailTrackingOpensImpl.setEmailTracking(null);
    emailTrackingOpensImpl.setId(1L);
    emailTrackingOpensImpl.setUserAgent("User Agent");

    EmailTrackingOpensImpl emailTrackingOpensImpl2 = new EmailTrackingOpensImpl();
    emailTrackingOpensImpl2.setDateOpened(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    emailTrackingOpensImpl2.setEmailTracking(new EmailTrackingImpl());
    emailTrackingOpensImpl2.setId(1L);
    emailTrackingOpensImpl2.setUserAgent("User Agent");

    // Act and Assert
    assertNotEquals(emailTrackingOpensImpl, emailTrackingOpensImpl2);
  }

  /**
   * Test {@link EmailTrackingOpensImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EmailTrackingOpensImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EmailTrackingOpensImpl.equals(Object)",
    "int EmailTrackingOpensImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    EmailTrackingOpensImpl emailTrackingOpensImpl = new EmailTrackingOpensImpl();
    emailTrackingOpensImpl.setDateOpened(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    emailTrackingOpensImpl.setEmailTracking(mock(EmailTracking.class));
    emailTrackingOpensImpl.setId(1L);
    emailTrackingOpensImpl.setUserAgent("User Agent");

    EmailTrackingOpensImpl emailTrackingOpensImpl2 = new EmailTrackingOpensImpl();
    emailTrackingOpensImpl2.setDateOpened(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    emailTrackingOpensImpl2.setEmailTracking(new EmailTrackingImpl());
    emailTrackingOpensImpl2.setId(1L);
    emailTrackingOpensImpl2.setUserAgent("User Agent");

    // Act and Assert
    assertNotEquals(emailTrackingOpensImpl, emailTrackingOpensImpl2);
  }

  /**
   * Test {@link EmailTrackingOpensImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EmailTrackingOpensImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EmailTrackingOpensImpl.equals(Object)",
    "int EmailTrackingOpensImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    EmailTrackingOpensImpl emailTrackingOpensImpl = new EmailTrackingOpensImpl();
    emailTrackingOpensImpl.setDateOpened(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    emailTrackingOpensImpl.setEmailTracking(new EmailTrackingImpl());
    emailTrackingOpensImpl.setId(2L);
    emailTrackingOpensImpl.setUserAgent("User Agent");

    EmailTrackingOpensImpl emailTrackingOpensImpl2 = new EmailTrackingOpensImpl();
    emailTrackingOpensImpl2.setDateOpened(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    emailTrackingOpensImpl2.setEmailTracking(new EmailTrackingImpl());
    emailTrackingOpensImpl2.setId(1L);
    emailTrackingOpensImpl2.setUserAgent("User Agent");

    // Act and Assert
    assertNotEquals(emailTrackingOpensImpl, emailTrackingOpensImpl2);
  }

  /**
   * Test {@link EmailTrackingOpensImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EmailTrackingOpensImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EmailTrackingOpensImpl.equals(Object)",
    "int EmailTrackingOpensImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    EmailTrackingOpensImpl emailTrackingOpensImpl = new EmailTrackingOpensImpl();
    emailTrackingOpensImpl.setDateOpened(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    emailTrackingOpensImpl.setEmailTracking(new EmailTrackingImpl());
    emailTrackingOpensImpl.setId(null);
    emailTrackingOpensImpl.setUserAgent("User Agent");

    EmailTrackingOpensImpl emailTrackingOpensImpl2 = new EmailTrackingOpensImpl();
    emailTrackingOpensImpl2.setDateOpened(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    emailTrackingOpensImpl2.setEmailTracking(new EmailTrackingImpl());
    emailTrackingOpensImpl2.setId(1L);
    emailTrackingOpensImpl2.setUserAgent("User Agent");

    // Act and Assert
    assertNotEquals(emailTrackingOpensImpl, emailTrackingOpensImpl2);
  }

  /**
   * Test {@link EmailTrackingOpensImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EmailTrackingOpensImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EmailTrackingOpensImpl.equals(Object)",
    "int EmailTrackingOpensImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    EmailTrackingOpensImpl emailTrackingOpensImpl = new EmailTrackingOpensImpl();
    emailTrackingOpensImpl.setDateOpened(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    emailTrackingOpensImpl.setEmailTracking(new EmailTrackingImpl());
    emailTrackingOpensImpl.setId(1L);
    emailTrackingOpensImpl.setUserAgent("42");

    EmailTrackingOpensImpl emailTrackingOpensImpl2 = new EmailTrackingOpensImpl();
    emailTrackingOpensImpl2.setDateOpened(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    emailTrackingOpensImpl2.setEmailTracking(new EmailTrackingImpl());
    emailTrackingOpensImpl2.setId(1L);
    emailTrackingOpensImpl2.setUserAgent("User Agent");

    // Act and Assert
    assertNotEquals(emailTrackingOpensImpl, emailTrackingOpensImpl2);
  }

  /**
   * Test {@link EmailTrackingOpensImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EmailTrackingOpensImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EmailTrackingOpensImpl.equals(Object)",
    "int EmailTrackingOpensImpl.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    EmailTrackingOpensImpl emailTrackingOpensImpl = new EmailTrackingOpensImpl();
    emailTrackingOpensImpl.setDateOpened(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    emailTrackingOpensImpl.setEmailTracking(new EmailTrackingImpl());
    emailTrackingOpensImpl.setId(1L);
    emailTrackingOpensImpl.setUserAgent("User Agent");

    // Act and Assert
    assertNotEquals(emailTrackingOpensImpl, null);
  }

  /**
   * Test {@link EmailTrackingOpensImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EmailTrackingOpensImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EmailTrackingOpensImpl.equals(Object)",
    "int EmailTrackingOpensImpl.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    EmailTrackingOpensImpl emailTrackingOpensImpl = new EmailTrackingOpensImpl();
    emailTrackingOpensImpl.setDateOpened(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    emailTrackingOpensImpl.setEmailTracking(new EmailTrackingImpl());
    emailTrackingOpensImpl.setId(1L);
    emailTrackingOpensImpl.setUserAgent("User Agent");

    // Act and Assert
    assertNotEquals(emailTrackingOpensImpl, "Different type to EmailTrackingOpensImpl");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void EmailTrackingOpensImpl.<init>()",
    "Date EmailTrackingOpensImpl.getDateOpened()",
    "EmailTracking EmailTrackingOpensImpl.getEmailTracking()",
    "Long EmailTrackingOpensImpl.getId()",
    "String EmailTrackingOpensImpl.getUserAgent()",
    "void EmailTrackingOpensImpl.setDateOpened(Date)",
    "void EmailTrackingOpensImpl.setEmailTracking(EmailTracking)",
    "void EmailTrackingOpensImpl.setId(Long)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    EmailTrackingOpensImpl actualEmailTrackingOpensImpl = new EmailTrackingOpensImpl();
    Date dateOpened =
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    actualEmailTrackingOpensImpl.setDateOpened(dateOpened);
    EmailTrackingImpl emailTracking = new EmailTrackingImpl();
    actualEmailTrackingOpensImpl.setEmailTracking(emailTracking);
    actualEmailTrackingOpensImpl.setId(1L);
    Date actualDateOpened = actualEmailTrackingOpensImpl.getDateOpened();
    EmailTracking actualEmailTracking = actualEmailTrackingOpensImpl.getEmailTracking();
    Long actualId = actualEmailTrackingOpensImpl.getId();

    // Assert
    assertNull(actualEmailTrackingOpensImpl.getUserAgent());
    assertEquals(1L, actualId.longValue());
    assertSame(emailTracking, actualEmailTracking);
    assertSame(dateOpened, actualDateOpened);
  }
}
