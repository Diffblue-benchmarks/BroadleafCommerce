package org.broadleafcommerce.common.email.service.message;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class EmailPropertyTypeDiffblueTest {
  /**
   * Test {@link EmailPropertyType#getInstance(String)}.
   *
   * <p>Method under test: {@link EmailPropertyType#getInstance(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"EmailPropertyType EmailPropertyType.getInstance(String)"})
  public void testGetInstance() {
    // Arrange and Act
    EmailPropertyType actualInstance = EmailPropertyType.getInstance("Type");

    // Assert
    assertEquals("Friendly Type", actualInstance.getFriendlyType());
    assertEquals("Type", actualInstance.getType());
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>Then return FriendlyType is {@code null}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EmailPropertyType#EmailPropertyType()}
   *   <li>{@link EmailPropertyType#getFriendlyType()}
   *   <li>{@link EmailPropertyType#getType()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void EmailPropertyType.<init>()",
    "void EmailPropertyType.<init>(String, String)",
    "String EmailPropertyType.getFriendlyType()",
    "String EmailPropertyType.getType()"
  })
  public void testGettersAndSetters_thenReturnFriendlyTypeIsNull() {
    // Arrange and Act
    EmailPropertyType actualEmailPropertyType = new EmailPropertyType();
    String actualFriendlyType = actualEmailPropertyType.getFriendlyType();

    // Assert
    assertNull(actualFriendlyType);
    assertNull(actualEmailPropertyType.getType());
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@code Type}.
   *   <li>Then return {@code Friendly Type}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EmailPropertyType#EmailPropertyType(String, String)}
   *   <li>{@link EmailPropertyType#getFriendlyType()}
   *   <li>{@link EmailPropertyType#getType()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void EmailPropertyType.<init>()",
    "void EmailPropertyType.<init>(String, String)",
    "String EmailPropertyType.getFriendlyType()",
    "String EmailPropertyType.getType()"
  })
  public void testGettersAndSetters_whenType_thenReturnFriendlyType() {
    // Arrange and Act
    EmailPropertyType actualEmailPropertyType = new EmailPropertyType("Type", "Friendly Type");
    String actualFriendlyType = actualEmailPropertyType.getFriendlyType();

    // Assert
    assertEquals("Friendly Type", actualFriendlyType);
    assertEquals("Type", actualEmailPropertyType.getType());
  }

  /**
   * Test {@link EmailPropertyType#equals(Object)}, and {@link EmailPropertyType#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EmailPropertyType#equals(Object)}
   *   <li>{@link EmailPropertyType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EmailPropertyType.equals(Object)",
    "int EmailPropertyType.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    EmailPropertyType emailPropertyType = EmailPropertyType.INFO;
    EmailPropertyType emailPropertyType2 = EmailPropertyType.INFO;

    // Act and Assert
    assertEquals(emailPropertyType, emailPropertyType2);
    assertEquals(emailPropertyType.hashCode(), emailPropertyType2.hashCode());
  }

  /**
   * Test {@link EmailPropertyType#equals(Object)}, and {@link EmailPropertyType#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EmailPropertyType#equals(Object)}
   *   <li>{@link EmailPropertyType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EmailPropertyType.equals(Object)",
    "int EmailPropertyType.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    EmailPropertyType emailPropertyType = EmailPropertyType.SERVERINFO;
    EmailPropertyType emailPropertyType2 = new EmailPropertyType("serverInfo", "serverInfo");

    // Act and Assert
    assertEquals(emailPropertyType, emailPropertyType2);
    assertEquals(emailPropertyType.hashCode(), emailPropertyType2.hashCode());
  }

  /**
   * Test {@link EmailPropertyType#equals(Object)}, and {@link EmailPropertyType#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EmailPropertyType#equals(Object)}
   *   <li>{@link EmailPropertyType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EmailPropertyType.equals(Object)",
    "int EmailPropertyType.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    EmailPropertyType emailPropertyType = new EmailPropertyType();
    EmailPropertyType emailPropertyType2 = new EmailPropertyType();

    // Act and Assert
    assertEquals(emailPropertyType, emailPropertyType2);
    assertEquals(emailPropertyType.hashCode(), emailPropertyType2.hashCode());
  }

  /**
   * Test {@link EmailPropertyType#equals(Object)}, and {@link EmailPropertyType#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EmailPropertyType#equals(Object)}
   *   <li>{@link EmailPropertyType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EmailPropertyType.equals(Object)",
    "int EmailPropertyType.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    EmailPropertyType emailPropertyType = EmailPropertyType.INFO;

    // Act and Assert
    assertEquals(emailPropertyType, emailPropertyType);
    int expectedHashCodeResult = emailPropertyType.hashCode();
    assertEquals(expectedHashCodeResult, emailPropertyType.hashCode());
  }

  /**
   * Test {@link EmailPropertyType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EmailPropertyType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EmailPropertyType.equals(Object)",
    "int EmailPropertyType.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(EmailPropertyType.SERVERINFO, EmailPropertyType.INFO);
  }

  /**
   * Test {@link EmailPropertyType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EmailPropertyType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EmailPropertyType.equals(Object)",
    "int EmailPropertyType.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange, Act and Assert
    assertNotEquals(new EmailPropertyType(), EmailPropertyType.INFO);
  }

  /**
   * Test {@link EmailPropertyType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EmailPropertyType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EmailPropertyType.equals(Object)",
    "int EmailPropertyType.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(EmailPropertyType.INFO, null);
  }

  /**
   * Test {@link EmailPropertyType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EmailPropertyType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EmailPropertyType.equals(Object)",
    "int EmailPropertyType.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(EmailPropertyType.INFO, "Different type to EmailPropertyType");
  }
}
