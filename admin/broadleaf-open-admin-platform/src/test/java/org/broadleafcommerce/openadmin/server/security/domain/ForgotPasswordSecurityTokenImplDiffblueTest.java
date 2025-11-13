package org.broadleafcommerce.openadmin.server.security.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.Date;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class ForgotPasswordSecurityTokenImplDiffblueTest {
  /**
   * Test {@link ForgotPasswordSecurityTokenImpl#equals(Object)}, and {@link
   * ForgotPasswordSecurityTokenImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ForgotPasswordSecurityTokenImpl#equals(Object)}
   *   <li>{@link ForgotPasswordSecurityTokenImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ForgotPasswordSecurityTokenImpl.equals(Object)",
    "int ForgotPasswordSecurityTokenImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ForgotPasswordSecurityTokenImpl forgotPasswordSecurityTokenImpl =
        new ForgotPasswordSecurityTokenImpl();
    forgotPasswordSecurityTokenImpl.setAdminUserId(1L);
    forgotPasswordSecurityTokenImpl.setCreateDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    forgotPasswordSecurityTokenImpl.setToken("ABC123");
    forgotPasswordSecurityTokenImpl.setTokenUsedDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    forgotPasswordSecurityTokenImpl.setTokenUsedFlag(true);

    ForgotPasswordSecurityTokenImpl forgotPasswordSecurityTokenImpl2 =
        new ForgotPasswordSecurityTokenImpl();
    forgotPasswordSecurityTokenImpl2.setAdminUserId(1L);
    forgotPasswordSecurityTokenImpl2.setCreateDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    forgotPasswordSecurityTokenImpl2.setToken("ABC123");
    forgotPasswordSecurityTokenImpl2.setTokenUsedDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    forgotPasswordSecurityTokenImpl2.setTokenUsedFlag(true);

    // Act and Assert
    assertEquals(forgotPasswordSecurityTokenImpl, forgotPasswordSecurityTokenImpl2);
    assertEquals(
        forgotPasswordSecurityTokenImpl.hashCode(), forgotPasswordSecurityTokenImpl2.hashCode());
  }

  /**
   * Test {@link ForgotPasswordSecurityTokenImpl#equals(Object)}, and {@link
   * ForgotPasswordSecurityTokenImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ForgotPasswordSecurityTokenImpl#equals(Object)}
   *   <li>{@link ForgotPasswordSecurityTokenImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ForgotPasswordSecurityTokenImpl.equals(Object)",
    "int ForgotPasswordSecurityTokenImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    ForgotPasswordSecurityTokenImpl forgotPasswordSecurityTokenImpl =
        new ForgotPasswordSecurityTokenImpl();
    forgotPasswordSecurityTokenImpl.setAdminUserId(1L);
    forgotPasswordSecurityTokenImpl.setCreateDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    forgotPasswordSecurityTokenImpl.setToken(null);
    forgotPasswordSecurityTokenImpl.setTokenUsedDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    forgotPasswordSecurityTokenImpl.setTokenUsedFlag(true);

    ForgotPasswordSecurityTokenImpl forgotPasswordSecurityTokenImpl2 =
        new ForgotPasswordSecurityTokenImpl();
    forgotPasswordSecurityTokenImpl2.setAdminUserId(1L);
    forgotPasswordSecurityTokenImpl2.setCreateDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    forgotPasswordSecurityTokenImpl2.setToken(null);
    forgotPasswordSecurityTokenImpl2.setTokenUsedDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    forgotPasswordSecurityTokenImpl2.setTokenUsedFlag(true);

    // Act and Assert
    assertEquals(forgotPasswordSecurityTokenImpl, forgotPasswordSecurityTokenImpl2);
    assertEquals(
        forgotPasswordSecurityTokenImpl.hashCode(), forgotPasswordSecurityTokenImpl2.hashCode());
  }

  /**
   * Test {@link ForgotPasswordSecurityTokenImpl#equals(Object)}, and {@link
   * ForgotPasswordSecurityTokenImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ForgotPasswordSecurityTokenImpl#equals(Object)}
   *   <li>{@link ForgotPasswordSecurityTokenImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ForgotPasswordSecurityTokenImpl.equals(Object)",
    "int ForgotPasswordSecurityTokenImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ForgotPasswordSecurityTokenImpl forgotPasswordSecurityTokenImpl =
        new ForgotPasswordSecurityTokenImpl();
    forgotPasswordSecurityTokenImpl.setAdminUserId(1L);
    forgotPasswordSecurityTokenImpl.setCreateDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    forgotPasswordSecurityTokenImpl.setToken("ABC123");
    forgotPasswordSecurityTokenImpl.setTokenUsedDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    forgotPasswordSecurityTokenImpl.setTokenUsedFlag(true);

    // Act and Assert
    assertEquals(forgotPasswordSecurityTokenImpl, forgotPasswordSecurityTokenImpl);
    int expectedHashCodeResult = forgotPasswordSecurityTokenImpl.hashCode();
    assertEquals(expectedHashCodeResult, forgotPasswordSecurityTokenImpl.hashCode());
  }

  /**
   * Test {@link ForgotPasswordSecurityTokenImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ForgotPasswordSecurityTokenImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ForgotPasswordSecurityTokenImpl.equals(Object)",
    "int ForgotPasswordSecurityTokenImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ForgotPasswordSecurityTokenImpl forgotPasswordSecurityTokenImpl =
        new ForgotPasswordSecurityTokenImpl();
    forgotPasswordSecurityTokenImpl.setAdminUserId(1L);
    forgotPasswordSecurityTokenImpl.setCreateDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    forgotPasswordSecurityTokenImpl.setToken("Token");
    forgotPasswordSecurityTokenImpl.setTokenUsedDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    forgotPasswordSecurityTokenImpl.setTokenUsedFlag(true);

    ForgotPasswordSecurityTokenImpl forgotPasswordSecurityTokenImpl2 =
        new ForgotPasswordSecurityTokenImpl();
    forgotPasswordSecurityTokenImpl2.setAdminUserId(1L);
    forgotPasswordSecurityTokenImpl2.setCreateDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    forgotPasswordSecurityTokenImpl2.setToken("ABC123");
    forgotPasswordSecurityTokenImpl2.setTokenUsedDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    forgotPasswordSecurityTokenImpl2.setTokenUsedFlag(true);

    // Act and Assert
    assertNotEquals(forgotPasswordSecurityTokenImpl, forgotPasswordSecurityTokenImpl2);
  }

  /**
   * Test {@link ForgotPasswordSecurityTokenImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ForgotPasswordSecurityTokenImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ForgotPasswordSecurityTokenImpl.equals(Object)",
    "int ForgotPasswordSecurityTokenImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ForgotPasswordSecurityTokenImpl forgotPasswordSecurityTokenImpl =
        new ForgotPasswordSecurityTokenImpl();
    forgotPasswordSecurityTokenImpl.setAdminUserId(1L);
    forgotPasswordSecurityTokenImpl.setCreateDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    forgotPasswordSecurityTokenImpl.setToken(null);
    forgotPasswordSecurityTokenImpl.setTokenUsedDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    forgotPasswordSecurityTokenImpl.setTokenUsedFlag(true);

    ForgotPasswordSecurityTokenImpl forgotPasswordSecurityTokenImpl2 =
        new ForgotPasswordSecurityTokenImpl();
    forgotPasswordSecurityTokenImpl2.setAdminUserId(1L);
    forgotPasswordSecurityTokenImpl2.setCreateDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    forgotPasswordSecurityTokenImpl2.setToken("ABC123");
    forgotPasswordSecurityTokenImpl2.setTokenUsedDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    forgotPasswordSecurityTokenImpl2.setTokenUsedFlag(true);

    // Act and Assert
    assertNotEquals(forgotPasswordSecurityTokenImpl, forgotPasswordSecurityTokenImpl2);
  }

  /**
   * Test {@link ForgotPasswordSecurityTokenImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ForgotPasswordSecurityTokenImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ForgotPasswordSecurityTokenImpl.equals(Object)",
    "int ForgotPasswordSecurityTokenImpl.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    ForgotPasswordSecurityTokenImpl forgotPasswordSecurityTokenImpl =
        new ForgotPasswordSecurityTokenImpl();
    forgotPasswordSecurityTokenImpl.setAdminUserId(1L);
    forgotPasswordSecurityTokenImpl.setCreateDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    forgotPasswordSecurityTokenImpl.setToken("ABC123");
    forgotPasswordSecurityTokenImpl.setTokenUsedDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    forgotPasswordSecurityTokenImpl.setTokenUsedFlag(true);

    // Act and Assert
    assertNotEquals(forgotPasswordSecurityTokenImpl, null);
  }

  /**
   * Test {@link ForgotPasswordSecurityTokenImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ForgotPasswordSecurityTokenImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ForgotPasswordSecurityTokenImpl.equals(Object)",
    "int ForgotPasswordSecurityTokenImpl.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    ForgotPasswordSecurityTokenImpl forgotPasswordSecurityTokenImpl =
        new ForgotPasswordSecurityTokenImpl();
    forgotPasswordSecurityTokenImpl.setAdminUserId(1L);
    forgotPasswordSecurityTokenImpl.setCreateDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    forgotPasswordSecurityTokenImpl.setToken("ABC123");
    forgotPasswordSecurityTokenImpl.setTokenUsedDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    forgotPasswordSecurityTokenImpl.setTokenUsedFlag(true);

    // Act and Assert
    assertNotEquals(
        forgotPasswordSecurityTokenImpl, "Different type to ForgotPasswordSecurityTokenImpl");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link ForgotPasswordSecurityTokenImpl}
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ForgotPasswordSecurityTokenImpl.<init>()",
    "Long ForgotPasswordSecurityTokenImpl.getAdminUserId()",
    "Date ForgotPasswordSecurityTokenImpl.getCreateDate()",
    "String ForgotPasswordSecurityTokenImpl.getToken()",
    "Date ForgotPasswordSecurityTokenImpl.getTokenUsedDate()",
    "boolean ForgotPasswordSecurityTokenImpl.isTokenUsedFlag()",
    "void ForgotPasswordSecurityTokenImpl.setAdminUserId(Long)",
    "void ForgotPasswordSecurityTokenImpl.setCreateDate(Date)",
    "void ForgotPasswordSecurityTokenImpl.setToken(String)",
    "void ForgotPasswordSecurityTokenImpl.setTokenUsedDate(Date)",
    "void ForgotPasswordSecurityTokenImpl.setTokenUsedFlag(boolean)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    ForgotPasswordSecurityTokenImpl actualForgotPasswordSecurityTokenImpl =
        new ForgotPasswordSecurityTokenImpl();
    actualForgotPasswordSecurityTokenImpl.setAdminUserId(1L);
    Date createDate =
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    actualForgotPasswordSecurityTokenImpl.setCreateDate(createDate);
    actualForgotPasswordSecurityTokenImpl.setToken("ABC123");
    Date tokenUsedDate =
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    actualForgotPasswordSecurityTokenImpl.setTokenUsedDate(tokenUsedDate);
    actualForgotPasswordSecurityTokenImpl.setTokenUsedFlag(true);
    Long actualAdminUserId = actualForgotPasswordSecurityTokenImpl.getAdminUserId();
    Date actualCreateDate = actualForgotPasswordSecurityTokenImpl.getCreateDate();
    String actualToken = actualForgotPasswordSecurityTokenImpl.getToken();
    Date actualTokenUsedDate = actualForgotPasswordSecurityTokenImpl.getTokenUsedDate();
    boolean actualIsTokenUsedFlagResult = actualForgotPasswordSecurityTokenImpl.isTokenUsedFlag();

    // Assert
    assertEquals("ABC123", actualToken);
    assertEquals(1L, actualAdminUserId.longValue());
    assertTrue(actualIsTokenUsedFlagResult);
    assertSame(createDate, actualCreateDate);
    assertSame(tokenUsedDate, actualTokenUsedDate);
  }
}
