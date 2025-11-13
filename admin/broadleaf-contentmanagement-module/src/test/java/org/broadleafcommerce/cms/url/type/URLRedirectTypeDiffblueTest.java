package org.broadleafcommerce.cms.url.type;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {URLRedirectType.class})
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(SpringJUnit4ClassRunner.class)
public class URLRedirectTypeDiffblueTest {
  @Autowired private URLRedirectType uRLRedirectType;

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link URLRedirectType#URLRedirectType()}
   *   <li>{@link URLRedirectType#getFriendlyType()}
   *   <li>{@link URLRedirectType#getType()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void URLRedirectType.<init>()",
    "String URLRedirectType.getFriendlyType()",
    "String URLRedirectType.getType()"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    URLRedirectType actualUrlRedirectType = new URLRedirectType();
    String actualFriendlyType = actualUrlRedirectType.getFriendlyType();

    // Assert
    assertNull(actualFriendlyType);
    assertNull(actualUrlRedirectType.getType());
  }

  /**
   * Test {@link URLRedirectType#URLRedirectType(String, String)}.
   *
   * <p>Method under test: {@link URLRedirectType#URLRedirectType(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void URLRedirectType.<init>(String, String)"})
  public void testNewURLRedirectType() {
    // Arrange and Act
    URLRedirectType actualUrlRedirectType =
        new URLRedirectType("https://example.org/example", "https://example.org/example");

    // Assert
    assertEquals("https://example.org/example", actualUrlRedirectType.getFriendlyType());
    assertEquals("https://example.org/example", actualUrlRedirectType.getType());
  }

  /**
   * Test {@link URLRedirectType#setType(String)}.
   *
   * <p>Method under test: {@link URLRedirectType#setType(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void URLRedirectType.setType(String)"})
  public void testSetType() {
    // Arrange and Act
    uRLRedirectType.setType("https://example.org/examplehttps://example.org/example");

    // Assert
    assertEquals(
        "https://example.org/examplehttps://example.org/example", uRLRedirectType.getType());
  }

  /**
   * Test {@link URLRedirectType#setType(String)}.
   *
   * <ul>
   *   <li>Then {@link URLRedirectType} Type is {@code https://example.org/example}.
   * </ul>
   *
   * <p>Method under test: {@link URLRedirectType#setType(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void URLRedirectType.setType(String)"})
  public void testSetType_thenURLRedirectTypeTypeIsHttpsExampleOrgExample() {
    // Arrange and Act
    uRLRedirectType.setType("https://example.org/example");

    // Assert
    assertEquals("https://example.org/example", uRLRedirectType.getType());
  }

  /**
   * Test {@link URLRedirectType#equals(Object)}, and {@link URLRedirectType#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link URLRedirectType#equals(Object)}
   *   <li>{@link URLRedirectType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean URLRedirectType.equals(Object)", "int URLRedirectType.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    URLRedirectType urlRedirectType = URLRedirectType.FORWARD;
    URLRedirectType urlRedirectType2 = URLRedirectType.FORWARD;

    // Act and Assert
    assertEquals(urlRedirectType, urlRedirectType2);
    assertEquals(urlRedirectType.hashCode(), urlRedirectType2.hashCode());
  }

  /**
   * Test {@link URLRedirectType#equals(Object)}, and {@link URLRedirectType#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link URLRedirectType#equals(Object)}
   *   <li>{@link URLRedirectType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean URLRedirectType.equals(Object)", "int URLRedirectType.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    URLRedirectType urlRedirectType = new URLRedirectType();
    URLRedirectType urlRedirectType2 = new URLRedirectType();

    // Act and Assert
    assertEquals(urlRedirectType, urlRedirectType2);
    assertEquals(urlRedirectType.hashCode(), urlRedirectType2.hashCode());
  }

  /**
   * Test {@link URLRedirectType#equals(Object)}, and {@link URLRedirectType#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link URLRedirectType#equals(Object)}
   *   <li>{@link URLRedirectType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean URLRedirectType.equals(Object)", "int URLRedirectType.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    URLRedirectType urlRedirectType =
        new URLRedirectType("https://example.org/example", "https://example.org/example");
    URLRedirectType urlRedirectType2 =
        new URLRedirectType("https://example.org/example", "https://example.org/example");

    // Act and Assert
    assertEquals(urlRedirectType, urlRedirectType2);
    assertEquals(urlRedirectType.hashCode(), urlRedirectType2.hashCode());
  }

  /**
   * Test {@link URLRedirectType#equals(Object)}, and {@link URLRedirectType#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link URLRedirectType#equals(Object)}
   *   <li>{@link URLRedirectType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean URLRedirectType.equals(Object)", "int URLRedirectType.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    URLRedirectType urlRedirectType = URLRedirectType.FORWARD;

    // Act and Assert
    assertEquals(urlRedirectType, urlRedirectType);
    int expectedHashCodeResult = urlRedirectType.hashCode();
    assertEquals(expectedHashCodeResult, urlRedirectType.hashCode());
  }

  /**
   * Test {@link URLRedirectType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link URLRedirectType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean URLRedirectType.equals(Object)", "int URLRedirectType.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(URLRedirectType.REDIRECT_PERM, URLRedirectType.FORWARD);
  }

  /**
   * Test {@link URLRedirectType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link URLRedirectType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean URLRedirectType.equals(Object)", "int URLRedirectType.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange, Act and Assert
    assertNotEquals(new URLRedirectType(), URLRedirectType.FORWARD);
  }

  /**
   * Test {@link URLRedirectType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link URLRedirectType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean URLRedirectType.equals(Object)", "int URLRedirectType.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(URLRedirectType.FORWARD, null);
  }

  /**
   * Test {@link URLRedirectType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link URLRedirectType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean URLRedirectType.equals(Object)", "int URLRedirectType.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(URLRedirectType.FORWARD, "Different type to URLRedirectType");
  }
}
