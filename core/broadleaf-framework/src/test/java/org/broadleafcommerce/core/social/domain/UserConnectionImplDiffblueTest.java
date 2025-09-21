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
package org.broadleafcommerce.core.social.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.core.social.domain.UserConnectionImpl.UserConnectionPK;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class UserConnectionImplDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
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
   *   <li>{@link UserConnectionImpl#setUserConnectionPK(UserConnectionPK)}
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void UserConnectionImpl.<init>()",
    "String UserConnectionImpl.getAccessToken()",
    "String UserConnectionImpl.getDisplayName()",
    "Long UserConnectionImpl.getExpireTime()",
    "String UserConnectionImpl.getImageUrl()",
    "String UserConnectionImpl.getProfileUrl()",
    "Integer UserConnectionImpl.getRank()",
    "String UserConnectionImpl.getRefreshToken()",
    "String UserConnectionImpl.getSecret()",
    "UserConnectionPK UserConnectionImpl.getUserConnectionPK()",
    "void UserConnectionImpl.setAccessToken(String)",
    "void UserConnectionImpl.setDisplayName(String)",
    "void UserConnectionImpl.setExpireTime(Long)",
    "void UserConnectionImpl.setImageUrl(String)",
    "void UserConnectionImpl.setProfileUrl(String)",
    "void UserConnectionImpl.setRank(Integer)",
    "void UserConnectionImpl.setRefreshToken(String)",
    "void UserConnectionImpl.setSecret(String)",
    "void UserConnectionImpl.setUserConnectionPK(UserConnectionPK)"
  })
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
    UserConnectionPK userConnectionPK = new UserConnectionPK();
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
    UserConnectionPK actualUserConnectionPK = actualUserConnectionImpl.getUserConnectionPK();

    // Assert
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
   * Test UserConnectionPK {@link UserConnectionPK#equals(Object)}, and {@link
   * UserConnectionPK#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link UserConnectionPK#equals(Object)}
   *   <li>{@link UserConnectionPK#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean UserConnectionPK.equals(Object)", "int UserConnectionPK.hashCode()"})
  public void testUserConnectionPKEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    UserConnectionPK userConnectionPK = new UserConnectionPK();
    userConnectionPK.setProviderId("42");
    userConnectionPK.setProviderUserId("42");
    userConnectionPK.setUserId("42");

    UserConnectionPK userConnectionPK2 = new UserConnectionPK();
    userConnectionPK2.setProviderId("42");
    userConnectionPK2.setProviderUserId("42");
    userConnectionPK2.setUserId("42");

    // Act and Assert
    assertEquals(userConnectionPK, userConnectionPK2);
    assertEquals(userConnectionPK.hashCode(), userConnectionPK2.hashCode());
  }

  /**
   * Test UserConnectionPK {@link UserConnectionPK#equals(Object)}, and {@link
   * UserConnectionPK#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link UserConnectionPK#equals(Object)}
   *   <li>{@link UserConnectionPK#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean UserConnectionPK.equals(Object)", "int UserConnectionPK.hashCode()"})
  public void testUserConnectionPKEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    UserConnectionPK userConnectionPK = new UserConnectionPK();
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link UserConnectionPK#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean UserConnectionPK.equals(Object)", "int UserConnectionPK.hashCode()"})
  public void testUserConnectionPKEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    UserConnectionPK userConnectionPK = new UserConnectionPK();
    userConnectionPK.setProviderId("Provider Id");
    userConnectionPK.setProviderUserId("42");
    userConnectionPK.setUserId("42");

    UserConnectionPK userConnectionPK2 = new UserConnectionPK();
    userConnectionPK2.setProviderId("42");
    userConnectionPK2.setProviderUserId("42");
    userConnectionPK2.setUserId("42");

    // Act and Assert
    assertNotEquals(userConnectionPK, userConnectionPK2);
  }

  /**
   * Test UserConnectionPK {@link UserConnectionPK#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link UserConnectionPK#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean UserConnectionPK.equals(Object)", "int UserConnectionPK.hashCode()"})
  public void testUserConnectionPKEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    UserConnectionPK userConnectionPK = new UserConnectionPK();
    userConnectionPK.setProviderId("42");
    userConnectionPK.setProviderUserId("Provider User Id");
    userConnectionPK.setUserId("42");

    UserConnectionPK userConnectionPK2 = new UserConnectionPK();
    userConnectionPK2.setProviderId("42");
    userConnectionPK2.setProviderUserId("42");
    userConnectionPK2.setUserId("42");

    // Act and Assert
    assertNotEquals(userConnectionPK, userConnectionPK2);
  }

  /**
   * Test UserConnectionPK {@link UserConnectionPK#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link UserConnectionPK#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean UserConnectionPK.equals(Object)", "int UserConnectionPK.hashCode()"})
  public void testUserConnectionPKEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    UserConnectionPK userConnectionPK = new UserConnectionPK();
    userConnectionPK.setProviderId("42");
    userConnectionPK.setProviderUserId("42");
    userConnectionPK.setUserId("User Id");

    UserConnectionPK userConnectionPK2 = new UserConnectionPK();
    userConnectionPK2.setProviderId("42");
    userConnectionPK2.setProviderUserId("42");
    userConnectionPK2.setUserId("42");

    // Act and Assert
    assertNotEquals(userConnectionPK, userConnectionPK2);
  }

  /**
   * Test UserConnectionPK {@link UserConnectionPK#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link UserConnectionPK#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean UserConnectionPK.equals(Object)", "int UserConnectionPK.hashCode()"})
  public void testUserConnectionPKEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    UserConnectionPK userConnectionPK = new UserConnectionPK();
    userConnectionPK.setProviderId("42");
    userConnectionPK.setProviderUserId("42");
    userConnectionPK.setUserId("42");

    // Act and Assert
    assertNotEquals(userConnectionPK, null);
  }

  /**
   * Test UserConnectionPK {@link UserConnectionPK#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link UserConnectionPK#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean UserConnectionPK.equals(Object)", "int UserConnectionPK.hashCode()"})
  public void testUserConnectionPKEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    UserConnectionPK userConnectionPK = new UserConnectionPK();
    userConnectionPK.setProviderId("42");
    userConnectionPK.setProviderUserId("42");
    userConnectionPK.setUserId("42");

    // Act and Assert
    assertNotEquals(userConnectionPK, "Different type to UserConnectionPK");
  }

  /**
   * Test UserConnectionPK getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link UserConnectionPK}
   *   <li>{@link UserConnectionPK#setProviderId(String)}
   *   <li>{@link UserConnectionPK#setProviderUserId(String)}
   *   <li>{@link UserConnectionPK#setUserId(String)}
   *   <li>{@link UserConnectionPK#getProviderId()}
   *   <li>{@link UserConnectionPK#getProviderUserId()}
   *   <li>{@link UserConnectionPK#getUserId()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void UserConnectionPK.<init>()",
    "String UserConnectionPK.getProviderId()",
    "String UserConnectionPK.getProviderUserId()",
    "String UserConnectionPK.getUserId()",
    "void UserConnectionPK.setProviderId(String)",
    "void UserConnectionPK.setProviderUserId(String)",
    "void UserConnectionPK.setUserId(String)"
  })
  public void testUserConnectionPKGettersAndSetters() {
    // Arrange and Act
    UserConnectionPK actualUserConnectionPK = new UserConnectionPK();
    actualUserConnectionPK.setProviderId("42");
    actualUserConnectionPK.setProviderUserId("42");
    actualUserConnectionPK.setUserId("42");
    String actualProviderId = actualUserConnectionPK.getProviderId();
    String actualProviderUserId = actualUserConnectionPK.getProviderUserId();

    // Assert
    assertEquals("42", actualProviderId);
    assertEquals("42", actualProviderUserId);
    assertEquals("42", actualUserConnectionPK.getUserId());
  }
}
