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
package org.broadleafcommerce.core.social.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import org.broadleafcommerce.core.social.domain.UserConnectionImpl.UserConnectionPK;
import org.junit.Test;

public class UserConnectionImplDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link UserConnectionImpl}
   *   <li>{@link UserConnectionImpl#setAccessToken(String)}
   *   <li>{@link UserConnectionImpl#setDisplayName(String)}
   *   <li>{@link UserConnectionImpl#setExpireTime(Long)}
   *   <li>{@link UserConnectionImpl#setImageUrl(String)}
   *   <li>{@link UserConnectionImpl#setProfileUrl(String)}
   *   <li>{@link UserConnectionImpl#setRank(Integer)}
   *   <li>{@link UserConnectionImpl#setRefreshToken(String)}
   *   <li>{@link UserConnectionImpl#setSecret(String)}
   *   <li>
   * {@link UserConnectionImpl#setUserConnectionPK(UserConnectionImpl.UserConnectionPK)}
   *   <li>{@link UserConnectionImpl#getAccessToken()}
   *   <li>{@link UserConnectionImpl#getDisplayName()}
   *   <li>{@link UserConnectionImpl#getExpireTime()}
   *   <li>{@link UserConnectionImpl#getImageUrl()}
   *   <li>{@link UserConnectionImpl#getProfileUrl()}
   *   <li>{@link UserConnectionImpl#getRank()}
   *   <li>{@link UserConnectionImpl#getRefreshToken()}
   *   <li>{@link UserConnectionImpl#getSecret()}
   *   <li>{@link UserConnectionImpl#getUserConnectionPK()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    UserConnectionImpl actualUserConnectionImpl = new UserConnectionImpl();
    actualUserConnectionImpl.setAccessToken("ABC123");
    actualUserConnectionImpl.setDisplayName("Display Name");
    actualUserConnectionImpl.setExpireTime(1L);
    actualUserConnectionImpl.setImageUrl("https://example.org/example");
    actualUserConnectionImpl.setProfileUrl("https://example.org/example");
    actualUserConnectionImpl.setRank(1);
    actualUserConnectionImpl.setRefreshToken("ABC123");
    actualUserConnectionImpl.setSecret("Secret");
    UserConnectionImpl.UserConnectionPK userConnectionPK = new UserConnectionImpl.UserConnectionPK();
    userConnectionPK.setProviderId("42");
    userConnectionPK.setProviderUserId("42");
    userConnectionPK.setUserId("42");
    actualUserConnectionImpl.setUserConnectionPK(userConnectionPK);
    String actualAccessToken = actualUserConnectionImpl.getAccessToken();
    String actualDisplayName = actualUserConnectionImpl.getDisplayName();
    Long actualExpireTime = actualUserConnectionImpl.getExpireTime();
    String actualImageUrl = actualUserConnectionImpl.getImageUrl();
    String actualProfileUrl = actualUserConnectionImpl.getProfileUrl();
    Integer actualRank = actualUserConnectionImpl.getRank();
    String actualRefreshToken = actualUserConnectionImpl.getRefreshToken();
    String actualSecret = actualUserConnectionImpl.getSecret();
    UserConnectionImpl.UserConnectionPK actualUserConnectionPK = actualUserConnectionImpl.getUserConnectionPK();

    // Assert that nothing has changed
    assertEquals("ABC123", actualAccessToken);
    assertEquals("ABC123", actualRefreshToken);
    assertEquals("Display Name", actualDisplayName);
    assertEquals("Secret", actualSecret);
    assertEquals("https://example.org/example", actualImageUrl);
    assertEquals("https://example.org/example", actualProfileUrl);
    assertEquals(1, actualRank.intValue());
    assertEquals(1L, actualExpireTime.longValue());
    assertSame(userConnectionPK, actualUserConnectionPK);
  }

  /**
   * Test UserConnectionPK {@link UserConnectionPK#equals(Object)}, and
   * {@link UserConnectionPK#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link UserConnectionImpl.UserConnectionPK#equals(Object)}
   *   <li>{@link UserConnectionImpl.UserConnectionPK#hashCode()}
   * </ul>
   */
  @Test
  public void testUserConnectionPKEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    UserConnectionImpl.UserConnectionPK userConnectionPK = new UserConnectionImpl.UserConnectionPK();
    userConnectionPK.setProviderId("42");
    userConnectionPK.setProviderUserId("42");
    userConnectionPK.setUserId("42");

    UserConnectionImpl.UserConnectionPK userConnectionPK2 = new UserConnectionImpl.UserConnectionPK();
    userConnectionPK2.setProviderId("42");
    userConnectionPK2.setProviderUserId("42");
    userConnectionPK2.setUserId("42");

    // Act and Assert
    assertEquals(userConnectionPK, userConnectionPK2);
    int expectedHashCodeResult = userConnectionPK.hashCode();
    assertEquals(expectedHashCodeResult, userConnectionPK2.hashCode());
  }

  /**
   * Test UserConnectionPK {@link UserConnectionPK#equals(Object)}, and
   * {@link UserConnectionPK#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link UserConnectionImpl.UserConnectionPK#equals(Object)}
   *   <li>{@link UserConnectionImpl.UserConnectionPK#hashCode()}
   * </ul>
   */
  @Test
  public void testUserConnectionPKEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    UserConnectionImpl.UserConnectionPK userConnectionPK = new UserConnectionImpl.UserConnectionPK();
    userConnectionPK.setProviderId("42");
    userConnectionPK.setProviderUserId("42");
    userConnectionPK.setUserId("42");

    // Act and Assert
    assertEquals(userConnectionPK, userConnectionPK);
    int expectedHashCodeResult = userConnectionPK.hashCode();
    assertEquals(expectedHashCodeResult, userConnectionPK.hashCode());
  }

  /**
   * Test UserConnectionPK {@link UserConnectionPK#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link UserConnectionImpl.UserConnectionPK#equals(Object)}
   */
  @Test
  public void testUserConnectionPKEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    UserConnectionImpl.UserConnectionPK userConnectionPK = new UserConnectionImpl.UserConnectionPK();
    userConnectionPK.setProviderId("Provider Id");
    userConnectionPK.setProviderUserId("42");
    userConnectionPK.setUserId("42");

    UserConnectionImpl.UserConnectionPK userConnectionPK2 = new UserConnectionImpl.UserConnectionPK();
    userConnectionPK2.setProviderId("42");
    userConnectionPK2.setProviderUserId("42");
    userConnectionPK2.setUserId("42");

    // Act and Assert
    assertNotEquals(userConnectionPK, userConnectionPK2);
  }

  /**
   * Test UserConnectionPK {@link UserConnectionPK#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link UserConnectionImpl.UserConnectionPK#equals(Object)}
   */
  @Test
  public void testUserConnectionPKEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    UserConnectionImpl.UserConnectionPK userConnectionPK = new UserConnectionImpl.UserConnectionPK();
    userConnectionPK.setProviderId("42");
    userConnectionPK.setProviderUserId("Provider User Id");
    userConnectionPK.setUserId("42");

    UserConnectionImpl.UserConnectionPK userConnectionPK2 = new UserConnectionImpl.UserConnectionPK();
    userConnectionPK2.setProviderId("42");
    userConnectionPK2.setProviderUserId("42");
    userConnectionPK2.setUserId("42");

    // Act and Assert
    assertNotEquals(userConnectionPK, userConnectionPK2);
  }

  /**
   * Test UserConnectionPK {@link UserConnectionPK#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link UserConnectionImpl.UserConnectionPK#equals(Object)}
   */
  @Test
  public void testUserConnectionPKEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    UserConnectionImpl.UserConnectionPK userConnectionPK = new UserConnectionImpl.UserConnectionPK();
    userConnectionPK.setProviderId("42");
    userConnectionPK.setProviderUserId("42");
    userConnectionPK.setUserId("User Id");

    UserConnectionImpl.UserConnectionPK userConnectionPK2 = new UserConnectionImpl.UserConnectionPK();
    userConnectionPK2.setProviderId("42");
    userConnectionPK2.setProviderUserId("42");
    userConnectionPK2.setUserId("42");

    // Act and Assert
    assertNotEquals(userConnectionPK, userConnectionPK2);
  }

  /**
   * Test UserConnectionPK {@link UserConnectionPK#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link UserConnectionImpl.UserConnectionPK#equals(Object)}
   */
  @Test
  public void testUserConnectionPKEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    UserConnectionImpl.UserConnectionPK userConnectionPK = new UserConnectionImpl.UserConnectionPK();
    userConnectionPK.setProviderId("42");
    userConnectionPK.setProviderUserId("42");
    userConnectionPK.setUserId("42");

    // Act and Assert
    assertNotEquals(userConnectionPK, null);
  }

  /**
   * Test UserConnectionPK {@link UserConnectionPK#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link UserConnectionImpl.UserConnectionPK#equals(Object)}
   */
  @Test
  public void testUserConnectionPKEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    UserConnectionImpl.UserConnectionPK userConnectionPK = new UserConnectionImpl.UserConnectionPK();
    userConnectionPK.setProviderId("42");
    userConnectionPK.setProviderUserId("42");
    userConnectionPK.setUserId("42");

    // Act and Assert
    assertNotEquals(userConnectionPK, "Different type to UserConnectionPK");
  }

  /**
   * Test UserConnectionPK getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link UserConnectionImpl.UserConnectionPK}
   *   <li>{@link UserConnectionImpl.UserConnectionPK#setProviderId(String)}
   *   <li>{@link UserConnectionImpl.UserConnectionPK#setProviderUserId(String)}
   *   <li>{@link UserConnectionImpl.UserConnectionPK#setUserId(String)}
   *   <li>{@link UserConnectionImpl.UserConnectionPK#getProviderId()}
   *   <li>{@link UserConnectionImpl.UserConnectionPK#getProviderUserId()}
   *   <li>{@link UserConnectionImpl.UserConnectionPK#getUserId()}
   * </ul>
   */
  @Test
  public void testUserConnectionPKGettersAndSetters() {
    // Arrange and Act
    UserConnectionImpl.UserConnectionPK actualUserConnectionPK = new UserConnectionImpl.UserConnectionPK();
    actualUserConnectionPK.setProviderId("42");
    actualUserConnectionPK.setProviderUserId("42");
    actualUserConnectionPK.setUserId("42");
    String actualProviderId = actualUserConnectionPK.getProviderId();
    String actualProviderUserId = actualUserConnectionPK.getProviderUserId();

    // Assert that nothing has changed
    assertEquals("42", actualProviderId);
    assertEquals("42", actualProviderUserId);
    assertEquals("42", actualUserConnectionPK.getUserId());
  }
}
