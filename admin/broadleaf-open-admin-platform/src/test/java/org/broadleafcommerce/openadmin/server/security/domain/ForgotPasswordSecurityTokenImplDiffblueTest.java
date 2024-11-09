/*-
 * #%L
 * BroadleafCommerce Open Admin Platform
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
package org.broadleafcommerce.openadmin.server.security.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.Date;
import org.junit.Test;

public class ForgotPasswordSecurityTokenImplDiffblueTest {
  /**
   * Test {@link ForgotPasswordSecurityTokenImpl#equals(Object)}, and
   * {@link ForgotPasswordSecurityTokenImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ForgotPasswordSecurityTokenImpl#equals(Object)}
   *   <li>{@link ForgotPasswordSecurityTokenImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ForgotPasswordSecurityTokenImpl forgotPasswordSecurityTokenImpl = new ForgotPasswordSecurityTokenImpl();
    forgotPasswordSecurityTokenImpl.setAdminUserId(1L);
    forgotPasswordSecurityTokenImpl
        .setCreateDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    forgotPasswordSecurityTokenImpl.setToken("ABC123");
    forgotPasswordSecurityTokenImpl
        .setTokenUsedDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    forgotPasswordSecurityTokenImpl.setTokenUsedFlag(true);

    ForgotPasswordSecurityTokenImpl forgotPasswordSecurityTokenImpl2 = new ForgotPasswordSecurityTokenImpl();
    forgotPasswordSecurityTokenImpl2.setAdminUserId(1L);
    forgotPasswordSecurityTokenImpl2
        .setCreateDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    forgotPasswordSecurityTokenImpl2.setToken("ABC123");
    forgotPasswordSecurityTokenImpl2
        .setTokenUsedDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    forgotPasswordSecurityTokenImpl2.setTokenUsedFlag(true);

    // Act and Assert
    assertEquals(forgotPasswordSecurityTokenImpl, forgotPasswordSecurityTokenImpl2);
    int expectedHashCodeResult = forgotPasswordSecurityTokenImpl.hashCode();
    assertEquals(expectedHashCodeResult, forgotPasswordSecurityTokenImpl2.hashCode());
  }

  /**
   * Test {@link ForgotPasswordSecurityTokenImpl#equals(Object)}, and
   * {@link ForgotPasswordSecurityTokenImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ForgotPasswordSecurityTokenImpl#equals(Object)}
   *   <li>{@link ForgotPasswordSecurityTokenImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    ForgotPasswordSecurityTokenImpl forgotPasswordSecurityTokenImpl = new ForgotPasswordSecurityTokenImpl();
    forgotPasswordSecurityTokenImpl.setAdminUserId(1L);
    forgotPasswordSecurityTokenImpl
        .setCreateDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    forgotPasswordSecurityTokenImpl.setToken(null);
    forgotPasswordSecurityTokenImpl
        .setTokenUsedDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    forgotPasswordSecurityTokenImpl.setTokenUsedFlag(true);

    ForgotPasswordSecurityTokenImpl forgotPasswordSecurityTokenImpl2 = new ForgotPasswordSecurityTokenImpl();
    forgotPasswordSecurityTokenImpl2.setAdminUserId(1L);
    forgotPasswordSecurityTokenImpl2
        .setCreateDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    forgotPasswordSecurityTokenImpl2.setToken(null);
    forgotPasswordSecurityTokenImpl2
        .setTokenUsedDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    forgotPasswordSecurityTokenImpl2.setTokenUsedFlag(true);

    // Act and Assert
    assertEquals(forgotPasswordSecurityTokenImpl, forgotPasswordSecurityTokenImpl2);
    int expectedHashCodeResult = forgotPasswordSecurityTokenImpl.hashCode();
    assertEquals(expectedHashCodeResult, forgotPasswordSecurityTokenImpl2.hashCode());
  }

  /**
   * Test {@link ForgotPasswordSecurityTokenImpl#equals(Object)}, and
   * {@link ForgotPasswordSecurityTokenImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ForgotPasswordSecurityTokenImpl#equals(Object)}
   *   <li>{@link ForgotPasswordSecurityTokenImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    ForgotPasswordSecurityTokenImpl forgotPasswordSecurityTokenImpl = new ForgotPasswordSecurityTokenImpl();
    forgotPasswordSecurityTokenImpl.setAdminUserId(1L);
    forgotPasswordSecurityTokenImpl
        .setCreateDate(java.util.Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    forgotPasswordSecurityTokenImpl.setToken("ABC123");
    forgotPasswordSecurityTokenImpl.setTokenUsedDate(
        java.util.Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    forgotPasswordSecurityTokenImpl.setTokenUsedFlag(true);
    forgotPasswordSecurityTokenImpl.setAdminUserId(1L);
    forgotPasswordSecurityTokenImpl.setCreateDate(mock(java.sql.Date.class));
    forgotPasswordSecurityTokenImpl.setToken("ABC123");
    forgotPasswordSecurityTokenImpl.setTokenUsedDate(
        java.util.Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    forgotPasswordSecurityTokenImpl.setTokenUsedFlag(true);

    ForgotPasswordSecurityTokenImpl forgotPasswordSecurityTokenImpl2 = new ForgotPasswordSecurityTokenImpl();
    forgotPasswordSecurityTokenImpl2.setAdminUserId(1L);
    forgotPasswordSecurityTokenImpl2
        .setCreateDate(java.util.Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    forgotPasswordSecurityTokenImpl2.setToken("ABC123");
    forgotPasswordSecurityTokenImpl2.setTokenUsedDate(
        java.util.Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    forgotPasswordSecurityTokenImpl2.setTokenUsedFlag(true);

    // Act and Assert
    assertEquals(forgotPasswordSecurityTokenImpl, forgotPasswordSecurityTokenImpl2);
    int expectedHashCodeResult = forgotPasswordSecurityTokenImpl.hashCode();
    assertEquals(expectedHashCodeResult, forgotPasswordSecurityTokenImpl2.hashCode());
  }

  /**
   * Test {@link ForgotPasswordSecurityTokenImpl#equals(Object)}, and
   * {@link ForgotPasswordSecurityTokenImpl#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ForgotPasswordSecurityTokenImpl#equals(Object)}
   *   <li>{@link ForgotPasswordSecurityTokenImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ForgotPasswordSecurityTokenImpl forgotPasswordSecurityTokenImpl = new ForgotPasswordSecurityTokenImpl();
    forgotPasswordSecurityTokenImpl.setAdminUserId(1L);
    forgotPasswordSecurityTokenImpl
        .setCreateDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    forgotPasswordSecurityTokenImpl.setToken("ABC123");
    forgotPasswordSecurityTokenImpl
        .setTokenUsedDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    forgotPasswordSecurityTokenImpl.setTokenUsedFlag(true);

    // Act and Assert
    assertEquals(forgotPasswordSecurityTokenImpl, forgotPasswordSecurityTokenImpl);
    int expectedHashCodeResult = forgotPasswordSecurityTokenImpl.hashCode();
    assertEquals(expectedHashCodeResult, forgotPasswordSecurityTokenImpl.hashCode());
  }

  /**
   * Test {@link ForgotPasswordSecurityTokenImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ForgotPasswordSecurityTokenImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ForgotPasswordSecurityTokenImpl forgotPasswordSecurityTokenImpl = new ForgotPasswordSecurityTokenImpl();
    forgotPasswordSecurityTokenImpl.setAdminUserId(1L);
    forgotPasswordSecurityTokenImpl
        .setCreateDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    forgotPasswordSecurityTokenImpl.setToken("Token");
    forgotPasswordSecurityTokenImpl
        .setTokenUsedDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    forgotPasswordSecurityTokenImpl.setTokenUsedFlag(true);

    ForgotPasswordSecurityTokenImpl forgotPasswordSecurityTokenImpl2 = new ForgotPasswordSecurityTokenImpl();
    forgotPasswordSecurityTokenImpl2.setAdminUserId(1L);
    forgotPasswordSecurityTokenImpl2
        .setCreateDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    forgotPasswordSecurityTokenImpl2.setToken("ABC123");
    forgotPasswordSecurityTokenImpl2
        .setTokenUsedDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    forgotPasswordSecurityTokenImpl2.setTokenUsedFlag(true);

    // Act and Assert
    assertNotEquals(forgotPasswordSecurityTokenImpl, forgotPasswordSecurityTokenImpl2);
  }

  /**
   * Test {@link ForgotPasswordSecurityTokenImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ForgotPasswordSecurityTokenImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ForgotPasswordSecurityTokenImpl forgotPasswordSecurityTokenImpl = new ForgotPasswordSecurityTokenImpl();
    forgotPasswordSecurityTokenImpl.setAdminUserId(1L);
    forgotPasswordSecurityTokenImpl
        .setCreateDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    forgotPasswordSecurityTokenImpl.setToken(null);
    forgotPasswordSecurityTokenImpl
        .setTokenUsedDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    forgotPasswordSecurityTokenImpl.setTokenUsedFlag(true);

    ForgotPasswordSecurityTokenImpl forgotPasswordSecurityTokenImpl2 = new ForgotPasswordSecurityTokenImpl();
    forgotPasswordSecurityTokenImpl2.setAdminUserId(1L);
    forgotPasswordSecurityTokenImpl2
        .setCreateDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    forgotPasswordSecurityTokenImpl2.setToken("ABC123");
    forgotPasswordSecurityTokenImpl2
        .setTokenUsedDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    forgotPasswordSecurityTokenImpl2.setTokenUsedFlag(true);

    // Act and Assert
    assertNotEquals(forgotPasswordSecurityTokenImpl, forgotPasswordSecurityTokenImpl2);
  }

  /**
   * Test {@link ForgotPasswordSecurityTokenImpl#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ForgotPasswordSecurityTokenImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    ForgotPasswordSecurityTokenImpl forgotPasswordSecurityTokenImpl = new ForgotPasswordSecurityTokenImpl();
    forgotPasswordSecurityTokenImpl.setAdminUserId(1L);
    forgotPasswordSecurityTokenImpl
        .setCreateDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    forgotPasswordSecurityTokenImpl.setToken("ABC123");
    forgotPasswordSecurityTokenImpl
        .setTokenUsedDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    forgotPasswordSecurityTokenImpl.setTokenUsedFlag(true);

    // Act and Assert
    assertNotEquals(forgotPasswordSecurityTokenImpl, null);
  }

  /**
   * Test {@link ForgotPasswordSecurityTokenImpl#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ForgotPasswordSecurityTokenImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    ForgotPasswordSecurityTokenImpl forgotPasswordSecurityTokenImpl = new ForgotPasswordSecurityTokenImpl();
    forgotPasswordSecurityTokenImpl.setAdminUserId(1L);
    forgotPasswordSecurityTokenImpl
        .setCreateDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    forgotPasswordSecurityTokenImpl.setToken("ABC123");
    forgotPasswordSecurityTokenImpl
        .setTokenUsedDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    forgotPasswordSecurityTokenImpl.setTokenUsedFlag(true);

    // Act and Assert
    assertNotEquals(forgotPasswordSecurityTokenImpl, "Different type to ForgotPasswordSecurityTokenImpl");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link ForgotPasswordSecurityTokenImpl}
   *   <li>{@link ForgotPasswordSecurityTokenImpl#setAdminUserId(Long)}
   *   <li>{@link ForgotPasswordSecurityTokenImpl#setCreateDate(Date)}
   *   <li>{@link ForgotPasswordSecurityTokenImpl#setToken(String)}
   *   <li>{@link ForgotPasswordSecurityTokenImpl#setTokenUsedDate(Date)}
   *   <li>{@link ForgotPasswordSecurityTokenImpl#setTokenUsedFlag(boolean)}
   *   <li>{@link ForgotPasswordSecurityTokenImpl#getAdminUserId()}
   *   <li>{@link ForgotPasswordSecurityTokenImpl#getCreateDate()}
   *   <li>{@link ForgotPasswordSecurityTokenImpl#getToken()}
   *   <li>{@link ForgotPasswordSecurityTokenImpl#getTokenUsedDate()}
   *   <li>{@link ForgotPasswordSecurityTokenImpl#isTokenUsedFlag()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    ForgotPasswordSecurityTokenImpl actualForgotPasswordSecurityTokenImpl = new ForgotPasswordSecurityTokenImpl();
    actualForgotPasswordSecurityTokenImpl.setAdminUserId(1L);
    Date createDate = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    actualForgotPasswordSecurityTokenImpl.setCreateDate(createDate);
    actualForgotPasswordSecurityTokenImpl.setToken("ABC123");
    Date tokenUsedDate = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    actualForgotPasswordSecurityTokenImpl.setTokenUsedDate(tokenUsedDate);
    actualForgotPasswordSecurityTokenImpl.setTokenUsedFlag(true);
    Long actualAdminUserId = actualForgotPasswordSecurityTokenImpl.getAdminUserId();
    Date actualCreateDate = actualForgotPasswordSecurityTokenImpl.getCreateDate();
    String actualToken = actualForgotPasswordSecurityTokenImpl.getToken();
    Date actualTokenUsedDate = actualForgotPasswordSecurityTokenImpl.getTokenUsedDate();
    boolean actualIsTokenUsedFlagResult = actualForgotPasswordSecurityTokenImpl.isTokenUsedFlag();

    // Assert that nothing has changed
    assertEquals("ABC123", actualToken);
    assertEquals(1L, actualAdminUserId.longValue());
    assertTrue(actualIsTokenUsedFlagResult);
    assertSame(createDate, actualCreateDate);
    assertSame(tokenUsedDate, actualTokenUsedDate);
  }
}
