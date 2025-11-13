package org.broadleafcommerce.cms.url.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.cms.url.type.URLRedirectType;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class URLHandlerImplDiffblueTest {
  /**
   * Test {@link URLHandlerImpl#equals(Object)}, and {@link URLHandlerImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link URLHandlerImpl#equals(Object)}
   *   <li>{@link URLHandlerImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean URLHandlerImpl.equals(Object)", "int URLHandlerImpl.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    URLHandlerImpl urlHandlerImpl = new URLHandlerImpl();
    urlHandlerImpl.setId(1L);
    urlHandlerImpl.setIncomingURL("https://example.org/example");
    urlHandlerImpl.setNewURL("https://example.org/example");
    urlHandlerImpl.setRegexHandler(true);
    urlHandlerImpl.setUrlRedirectType(URLRedirectType.FORWARD);

    URLHandlerImpl urlHandlerImpl2 = new URLHandlerImpl();
    urlHandlerImpl2.setId(1L);
    urlHandlerImpl2.setIncomingURL("https://example.org/example");
    urlHandlerImpl2.setNewURL("https://example.org/example");
    urlHandlerImpl2.setRegexHandler(true);
    urlHandlerImpl2.setUrlRedirectType(URLRedirectType.FORWARD);

    // Act and Assert
    assertEquals(urlHandlerImpl, urlHandlerImpl2);
    assertEquals(urlHandlerImpl.hashCode(), urlHandlerImpl2.hashCode());
  }

  /**
   * Test {@link URLHandlerImpl#equals(Object)}, and {@link URLHandlerImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link URLHandlerImpl#equals(Object)}
   *   <li>{@link URLHandlerImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean URLHandlerImpl.equals(Object)", "int URLHandlerImpl.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    URLHandlerImpl urlHandlerImpl = new URLHandlerImpl();
    urlHandlerImpl.setId(1L);
    urlHandlerImpl.setIncomingURL("https://example.org/example");
    urlHandlerImpl.setNewURL("https://example.org/example");
    urlHandlerImpl.setRegexHandler(true);
    urlHandlerImpl.setUrlRedirectType(URLRedirectType.FORWARD);

    // Act and Assert
    assertEquals(urlHandlerImpl, urlHandlerImpl);
    int expectedHashCodeResult = urlHandlerImpl.hashCode();
    assertEquals(expectedHashCodeResult, urlHandlerImpl.hashCode());
  }

  /**
   * Test {@link URLHandlerImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link URLHandlerImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean URLHandlerImpl.equals(Object)", "int URLHandlerImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    URLHandlerImpl urlHandlerImpl = new URLHandlerImpl();
    urlHandlerImpl.setId(2L);
    urlHandlerImpl.setIncomingURL("https://example.org/example");
    urlHandlerImpl.setNewURL("https://example.org/example");
    urlHandlerImpl.setRegexHandler(true);
    urlHandlerImpl.setUrlRedirectType(URLRedirectType.FORWARD);

    URLHandlerImpl urlHandlerImpl2 = new URLHandlerImpl();
    urlHandlerImpl2.setId(1L);
    urlHandlerImpl2.setIncomingURL("https://example.org/example");
    urlHandlerImpl2.setNewURL("https://example.org/example");
    urlHandlerImpl2.setRegexHandler(true);
    urlHandlerImpl2.setUrlRedirectType(URLRedirectType.FORWARD);

    // Act and Assert
    assertNotEquals(urlHandlerImpl, urlHandlerImpl2);
  }

  /**
   * Test {@link URLHandlerImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link URLHandlerImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean URLHandlerImpl.equals(Object)", "int URLHandlerImpl.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    URLHandlerImpl urlHandlerImpl = new URLHandlerImpl();
    urlHandlerImpl.setId(1L);
    urlHandlerImpl.setIncomingURL("https://example.org/example");
    urlHandlerImpl.setNewURL("https://example.org/example");
    urlHandlerImpl.setRegexHandler(true);
    urlHandlerImpl.setUrlRedirectType(URLRedirectType.FORWARD);

    // Act and Assert
    assertNotEquals(urlHandlerImpl, null);
  }

  /**
   * Test {@link URLHandlerImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link URLHandlerImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean URLHandlerImpl.equals(Object)", "int URLHandlerImpl.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    URLHandlerImpl urlHandlerImpl = new URLHandlerImpl();
    urlHandlerImpl.setId(1L);
    urlHandlerImpl.setIncomingURL("https://example.org/example");
    urlHandlerImpl.setNewURL("https://example.org/example");
    urlHandlerImpl.setRegexHandler(true);
    urlHandlerImpl.setUrlRedirectType(URLRedirectType.FORWARD);

    // Act and Assert
    assertNotEquals(urlHandlerImpl, "Different type to URLHandlerImpl");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link URLHandlerImpl}
   *   <li>{@link URLHandlerImpl#setId(Long)}
   *   <li>{@link URLHandlerImpl#setIncomingURL(String)}
   *   <li>{@link URLHandlerImpl#setNewURL(String)}
   *   <li>{@link URLHandlerImpl#getId()}
   *   <li>{@link URLHandlerImpl#getIncomingURL()}
   *   <li>{@link URLHandlerImpl#getNewURL()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void URLHandlerImpl.<init>()",
    "Long URLHandlerImpl.getId()",
    "String URLHandlerImpl.getIncomingURL()",
    "String URLHandlerImpl.getNewURL()",
    "void URLHandlerImpl.setId(Long)",
    "void URLHandlerImpl.setIncomingURL(String)",
    "void URLHandlerImpl.setNewURL(String)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    URLHandlerImpl actualUrlHandlerImpl = new URLHandlerImpl();
    actualUrlHandlerImpl.setId(1L);
    actualUrlHandlerImpl.setIncomingURL("https://example.org/example");
    actualUrlHandlerImpl.setNewURL("https://example.org/example");
    Long actualId = actualUrlHandlerImpl.getId();
    String actualIncomingURL = actualUrlHandlerImpl.getIncomingURL();

    // Assert
    assertEquals("https://example.org/example", actualIncomingURL);
    assertEquals("https://example.org/example", actualUrlHandlerImpl.getNewURL());
    assertEquals(1L, actualId.longValue());
  }
}
