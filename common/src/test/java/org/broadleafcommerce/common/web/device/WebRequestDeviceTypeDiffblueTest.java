package org.broadleafcommerce.common.web.device;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class WebRequestDeviceTypeDiffblueTest {
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
   *   <li>{@link WebRequestDeviceType#WebRequestDeviceType()}
   *   <li>{@link WebRequestDeviceType#toString()}
   *   <li>{@link WebRequestDeviceType#getFriendlyType()}
   *   <li>{@link WebRequestDeviceType#getType()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void WebRequestDeviceType.<init>()",
    "void WebRequestDeviceType.<init>(String, String)",
    "String WebRequestDeviceType.getFriendlyType()",
    "String WebRequestDeviceType.getType()",
    "String WebRequestDeviceType.toString()"
  })
  public void testGettersAndSetters_thenReturnFriendlyTypeIsNull() {
    // Arrange and Act
    WebRequestDeviceType actualWebRequestDeviceType = new WebRequestDeviceType();
    String actualToStringResult = actualWebRequestDeviceType.toString();
    String actualFriendlyType = actualWebRequestDeviceType.getFriendlyType();

    // Assert
    assertNull(actualFriendlyType);
    assertNull(actualWebRequestDeviceType.getType());
    assertNull(actualToStringResult);
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
   *   <li>{@link WebRequestDeviceType#WebRequestDeviceType(String, String)}
   *   <li>{@link WebRequestDeviceType#toString()}
   *   <li>{@link WebRequestDeviceType#getFriendlyType()}
   *   <li>{@link WebRequestDeviceType#getType()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void WebRequestDeviceType.<init>()",
    "void WebRequestDeviceType.<init>(String, String)",
    "String WebRequestDeviceType.getFriendlyType()",
    "String WebRequestDeviceType.getType()",
    "String WebRequestDeviceType.toString()"
  })
  public void testGettersAndSetters_whenType_thenReturnFriendlyType() {
    // Arrange and Act
    WebRequestDeviceType actualWebRequestDeviceType =
        new WebRequestDeviceType("Type", "Friendly Type");
    String actualToStringResult = actualWebRequestDeviceType.toString();
    String actualFriendlyType = actualWebRequestDeviceType.getFriendlyType();

    // Assert
    assertEquals("Friendly Type", actualFriendlyType);
    assertEquals("Friendly Type", actualToStringResult);
    assertEquals("Type", actualWebRequestDeviceType.getType());
  }

  /**
   * Test {@link WebRequestDeviceType#getInstance(String)}.
   *
   * <p>Method under test: {@link WebRequestDeviceType#getInstance(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"WebRequestDeviceType WebRequestDeviceType.getInstance(String)"})
  public void testGetInstance() {
    // Arrange and Act
    WebRequestDeviceType actualInstance = WebRequestDeviceType.getInstance("Type");

    // Assert
    assertEquals("Friendly Type", actualInstance.getFriendlyType());
    assertEquals("Type", actualInstance.getType());
  }

  /**
   * Test {@link WebRequestDeviceType#equals(Object)}, and {@link WebRequestDeviceType#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link WebRequestDeviceType#equals(Object)}
   *   <li>{@link WebRequestDeviceType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean WebRequestDeviceType.equals(Object)",
    "int WebRequestDeviceType.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    WebRequestDeviceType webRequestDeviceType = WebRequestDeviceType.MOBILE;
    WebRequestDeviceType webRequestDeviceType2 = WebRequestDeviceType.MOBILE;

    // Act and Assert
    assertEquals(webRequestDeviceType, webRequestDeviceType2);
    assertEquals(webRequestDeviceType.hashCode(), webRequestDeviceType2.hashCode());
  }

  /**
   * Test {@link WebRequestDeviceType#equals(Object)}, and {@link WebRequestDeviceType#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link WebRequestDeviceType#equals(Object)}
   *   <li>{@link WebRequestDeviceType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean WebRequestDeviceType.equals(Object)",
    "int WebRequestDeviceType.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    WebRequestDeviceType webRequestDeviceType = WebRequestDeviceType.MOBILE;

    // Act and Assert
    assertEquals(webRequestDeviceType, webRequestDeviceType);
    int expectedHashCodeResult = webRequestDeviceType.hashCode();
    assertEquals(expectedHashCodeResult, webRequestDeviceType.hashCode());
  }

  /**
   * Test {@link WebRequestDeviceType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link WebRequestDeviceType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean WebRequestDeviceType.equals(Object)",
    "int WebRequestDeviceType.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(WebRequestDeviceType.NORMAL, WebRequestDeviceType.MOBILE);
  }

  /**
   * Test {@link WebRequestDeviceType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link WebRequestDeviceType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean WebRequestDeviceType.equals(Object)",
    "int WebRequestDeviceType.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(WebRequestDeviceType.MOBILE, null);
  }

  /**
   * Test {@link WebRequestDeviceType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link WebRequestDeviceType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean WebRequestDeviceType.equals(Object)",
    "int WebRequestDeviceType.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(WebRequestDeviceType.MOBILE, "Different type to WebRequestDeviceType");
  }
}
