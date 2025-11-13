package org.broadleafcommerce.common.media.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class MediaImplDiffblueTest {
  /**
   * Test {@link MediaImpl#equals(Object)}, and {@link MediaImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link MediaImpl#equals(Object)}
   *   <li>{@link MediaImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MediaImpl.equals(Object)", "int MediaImpl.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    MediaImpl mediaImpl = new MediaImpl();
    mediaImpl.setAltText("Alt Text");
    mediaImpl.setId(1L);
    mediaImpl.setTags("Tags");
    mediaImpl.setTitle("Dr");
    mediaImpl.setUrl("https://example.org/example");

    MediaImpl mediaImpl2 = new MediaImpl();
    mediaImpl2.setAltText("Alt Text");
    mediaImpl2.setId(1L);
    mediaImpl2.setTags("Tags");
    mediaImpl2.setTitle("Dr");
    mediaImpl2.setUrl("https://example.org/example");

    // Act and Assert
    assertEquals(mediaImpl, mediaImpl2);
    assertEquals(mediaImpl.hashCode(), mediaImpl2.hashCode());
  }

  /**
   * Test {@link MediaImpl#equals(Object)}, and {@link MediaImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link MediaImpl#equals(Object)}
   *   <li>{@link MediaImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MediaImpl.equals(Object)", "int MediaImpl.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    MediaImpl mediaImpl = new MediaImpl();
    mediaImpl.setAltText("Alt Text");
    mediaImpl.setId(null);
    mediaImpl.setTags("Tags");
    mediaImpl.setTitle("Dr");
    mediaImpl.setUrl("https://example.org/example");

    MediaImpl mediaImpl2 = new MediaImpl();
    mediaImpl2.setAltText("Alt Text");
    mediaImpl2.setId(1L);
    mediaImpl2.setTags("Tags");
    mediaImpl2.setTitle("Dr");
    mediaImpl2.setUrl("https://example.org/example");

    // Act and Assert
    assertEquals(mediaImpl, mediaImpl2);
    assertEquals(mediaImpl.hashCode(), mediaImpl2.hashCode());
  }

  /**
   * Test {@link MediaImpl#equals(Object)}, and {@link MediaImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link MediaImpl#equals(Object)}
   *   <li>{@link MediaImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MediaImpl.equals(Object)", "int MediaImpl.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    MediaImpl mediaImpl = new MediaImpl();
    mediaImpl.setAltText("Alt Text");
    mediaImpl.setId(1L);
    mediaImpl.setTags("Tags");
    mediaImpl.setTitle("Dr");
    mediaImpl.setUrl("https://example.org/example");

    MediaImpl mediaImpl2 = new MediaImpl();
    mediaImpl2.setAltText("Alt Text");
    mediaImpl2.setId(null);
    mediaImpl2.setTags("Tags");
    mediaImpl2.setTitle("Dr");
    mediaImpl2.setUrl("https://example.org/example");

    // Act and Assert
    assertEquals(mediaImpl, mediaImpl2);
    assertEquals(mediaImpl.hashCode(), mediaImpl2.hashCode());
  }

  /**
   * Test {@link MediaImpl#equals(Object)}, and {@link MediaImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link MediaImpl#equals(Object)}
   *   <li>{@link MediaImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MediaImpl.equals(Object)", "int MediaImpl.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    MediaImpl mediaImpl = new MediaImpl();
    mediaImpl.setAltText(null);
    mediaImpl.setId(null);
    mediaImpl.setTags("Tags");
    mediaImpl.setTitle("Dr");
    mediaImpl.setUrl("https://example.org/example");

    MediaImpl mediaImpl2 = new MediaImpl();
    mediaImpl2.setAltText(null);
    mediaImpl2.setId(1L);
    mediaImpl2.setTags("Tags");
    mediaImpl2.setTitle("Dr");
    mediaImpl2.setUrl("https://example.org/example");

    // Act and Assert
    assertEquals(mediaImpl, mediaImpl2);
    assertEquals(mediaImpl.hashCode(), mediaImpl2.hashCode());
  }

  /**
   * Test {@link MediaImpl#equals(Object)}, and {@link MediaImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link MediaImpl#equals(Object)}
   *   <li>{@link MediaImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MediaImpl.equals(Object)", "int MediaImpl.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual5() {
    // Arrange
    MediaImpl mediaImpl = new MediaImpl();
    mediaImpl.setAltText("Alt Text");
    mediaImpl.setId(null);
    mediaImpl.setTags(null);
    mediaImpl.setTitle("Dr");
    mediaImpl.setUrl("https://example.org/example");

    MediaImpl mediaImpl2 = new MediaImpl();
    mediaImpl2.setAltText("Alt Text");
    mediaImpl2.setId(1L);
    mediaImpl2.setTags(null);
    mediaImpl2.setTitle("Dr");
    mediaImpl2.setUrl("https://example.org/example");

    // Act and Assert
    assertEquals(mediaImpl, mediaImpl2);
    assertEquals(mediaImpl.hashCode(), mediaImpl2.hashCode());
  }

  /**
   * Test {@link MediaImpl#equals(Object)}, and {@link MediaImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link MediaImpl#equals(Object)}
   *   <li>{@link MediaImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MediaImpl.equals(Object)", "int MediaImpl.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual6() {
    // Arrange
    MediaImpl mediaImpl = new MediaImpl();
    mediaImpl.setAltText("Alt Text");
    mediaImpl.setId(null);
    mediaImpl.setTags("Tags");
    mediaImpl.setTitle(null);
    mediaImpl.setUrl("https://example.org/example");

    MediaImpl mediaImpl2 = new MediaImpl();
    mediaImpl2.setAltText("Alt Text");
    mediaImpl2.setId(1L);
    mediaImpl2.setTags("Tags");
    mediaImpl2.setTitle(null);
    mediaImpl2.setUrl("https://example.org/example");

    // Act and Assert
    assertEquals(mediaImpl, mediaImpl2);
    assertEquals(mediaImpl.hashCode(), mediaImpl2.hashCode());
  }

  /**
   * Test {@link MediaImpl#equals(Object)}, and {@link MediaImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link MediaImpl#equals(Object)}
   *   <li>{@link MediaImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MediaImpl.equals(Object)", "int MediaImpl.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual7() {
    // Arrange
    MediaImpl mediaImpl = new MediaImpl();
    mediaImpl.setAltText("Alt Text");
    mediaImpl.setId(null);
    mediaImpl.setTags("Tags");
    mediaImpl.setTitle("Dr");
    mediaImpl.setUrl(null);

    MediaImpl mediaImpl2 = new MediaImpl();
    mediaImpl2.setAltText("Alt Text");
    mediaImpl2.setId(1L);
    mediaImpl2.setTags("Tags");
    mediaImpl2.setTitle("Dr");
    mediaImpl2.setUrl(null);

    // Act and Assert
    assertEquals(mediaImpl, mediaImpl2);
    assertEquals(mediaImpl.hashCode(), mediaImpl2.hashCode());
  }

  /**
   * Test {@link MediaImpl#equals(Object)}, and {@link MediaImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link MediaImpl#equals(Object)}
   *   <li>{@link MediaImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MediaImpl.equals(Object)", "int MediaImpl.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    MediaImpl mediaImpl = new MediaImpl();
    mediaImpl.setAltText("Alt Text");
    mediaImpl.setId(1L);
    mediaImpl.setTags("Tags");
    mediaImpl.setTitle("Dr");
    mediaImpl.setUrl("https://example.org/example");

    // Act and Assert
    assertEquals(mediaImpl, mediaImpl);
    int expectedHashCodeResult = mediaImpl.hashCode();
    assertEquals(expectedHashCodeResult, mediaImpl.hashCode());
  }

  /**
   * Test {@link MediaImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MediaImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MediaImpl.equals(Object)", "int MediaImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    MediaImpl mediaImpl = new MediaImpl();
    mediaImpl.setAltText("Alt Text");
    mediaImpl.setId(2L);
    mediaImpl.setTags("Tags");
    mediaImpl.setTitle("Dr");
    mediaImpl.setUrl("https://example.org/example");

    MediaImpl mediaImpl2 = new MediaImpl();
    mediaImpl2.setAltText("Alt Text");
    mediaImpl2.setId(1L);
    mediaImpl2.setTags("Tags");
    mediaImpl2.setTitle("Dr");
    mediaImpl2.setUrl("https://example.org/example");

    // Act and Assert
    assertNotEquals(mediaImpl, mediaImpl2);
  }

  /**
   * Test {@link MediaImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MediaImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MediaImpl.equals(Object)", "int MediaImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    MediaImpl mediaImpl = new MediaImpl();
    mediaImpl.setAltText("Dr");
    mediaImpl.setId(null);
    mediaImpl.setTags("Tags");
    mediaImpl.setTitle("Dr");
    mediaImpl.setUrl("https://example.org/example");

    MediaImpl mediaImpl2 = new MediaImpl();
    mediaImpl2.setAltText("Alt Text");
    mediaImpl2.setId(1L);
    mediaImpl2.setTags("Tags");
    mediaImpl2.setTitle("Dr");
    mediaImpl2.setUrl("https://example.org/example");

    // Act and Assert
    assertNotEquals(mediaImpl, mediaImpl2);
  }

  /**
   * Test {@link MediaImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MediaImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MediaImpl.equals(Object)", "int MediaImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    MediaImpl mediaImpl = new MediaImpl();
    mediaImpl.setAltText(null);
    mediaImpl.setId(null);
    mediaImpl.setTags("Tags");
    mediaImpl.setTitle("Dr");
    mediaImpl.setUrl("https://example.org/example");

    MediaImpl mediaImpl2 = new MediaImpl();
    mediaImpl2.setAltText("Alt Text");
    mediaImpl2.setId(1L);
    mediaImpl2.setTags("Tags");
    mediaImpl2.setTitle("Dr");
    mediaImpl2.setUrl("https://example.org/example");

    // Act and Assert
    assertNotEquals(mediaImpl, mediaImpl2);
  }

  /**
   * Test {@link MediaImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MediaImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MediaImpl.equals(Object)", "int MediaImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    MediaImpl mediaImpl = new MediaImpl();
    mediaImpl.setAltText("Alt Text");
    mediaImpl.setId(null);
    mediaImpl.setTags("Dr");
    mediaImpl.setTitle("Dr");
    mediaImpl.setUrl("https://example.org/example");

    MediaImpl mediaImpl2 = new MediaImpl();
    mediaImpl2.setAltText("Alt Text");
    mediaImpl2.setId(1L);
    mediaImpl2.setTags("Tags");
    mediaImpl2.setTitle("Dr");
    mediaImpl2.setUrl("https://example.org/example");

    // Act and Assert
    assertNotEquals(mediaImpl, mediaImpl2);
  }

  /**
   * Test {@link MediaImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MediaImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MediaImpl.equals(Object)", "int MediaImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    MediaImpl mediaImpl = new MediaImpl();
    mediaImpl.setAltText("Alt Text");
    mediaImpl.setId(null);
    mediaImpl.setTags(null);
    mediaImpl.setTitle("Dr");
    mediaImpl.setUrl("https://example.org/example");

    MediaImpl mediaImpl2 = new MediaImpl();
    mediaImpl2.setAltText("Alt Text");
    mediaImpl2.setId(1L);
    mediaImpl2.setTags("Tags");
    mediaImpl2.setTitle("Dr");
    mediaImpl2.setUrl("https://example.org/example");

    // Act and Assert
    assertNotEquals(mediaImpl, mediaImpl2);
  }

  /**
   * Test {@link MediaImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MediaImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MediaImpl.equals(Object)", "int MediaImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    MediaImpl mediaImpl = new MediaImpl();
    mediaImpl.setAltText("Alt Text");
    mediaImpl.setId(null);
    mediaImpl.setTags("Tags");
    mediaImpl.setTitle("Mr");
    mediaImpl.setUrl("https://example.org/example");

    MediaImpl mediaImpl2 = new MediaImpl();
    mediaImpl2.setAltText("Alt Text");
    mediaImpl2.setId(1L);
    mediaImpl2.setTags("Tags");
    mediaImpl2.setTitle("Dr");
    mediaImpl2.setUrl("https://example.org/example");

    // Act and Assert
    assertNotEquals(mediaImpl, mediaImpl2);
  }

  /**
   * Test {@link MediaImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MediaImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MediaImpl.equals(Object)", "int MediaImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    MediaImpl mediaImpl = new MediaImpl();
    mediaImpl.setAltText("Alt Text");
    mediaImpl.setId(null);
    mediaImpl.setTags("Tags");
    mediaImpl.setTitle(null);
    mediaImpl.setUrl("https://example.org/example");

    MediaImpl mediaImpl2 = new MediaImpl();
    mediaImpl2.setAltText("Alt Text");
    mediaImpl2.setId(1L);
    mediaImpl2.setTags("Tags");
    mediaImpl2.setTitle("Dr");
    mediaImpl2.setUrl("https://example.org/example");

    // Act and Assert
    assertNotEquals(mediaImpl, mediaImpl2);
  }

  /**
   * Test {@link MediaImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MediaImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MediaImpl.equals(Object)", "int MediaImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    MediaImpl mediaImpl = new MediaImpl();
    mediaImpl.setAltText("Alt Text");
    mediaImpl.setId(null);
    mediaImpl.setTags("Tags");
    mediaImpl.setTitle("Dr");
    mediaImpl.setUrl("Dr");

    MediaImpl mediaImpl2 = new MediaImpl();
    mediaImpl2.setAltText("Alt Text");
    mediaImpl2.setId(1L);
    mediaImpl2.setTags("Tags");
    mediaImpl2.setTitle("Dr");
    mediaImpl2.setUrl("https://example.org/example");

    // Act and Assert
    assertNotEquals(mediaImpl, mediaImpl2);
  }

  /**
   * Test {@link MediaImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MediaImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MediaImpl.equals(Object)", "int MediaImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    MediaImpl mediaImpl = new MediaImpl();
    mediaImpl.setAltText("Alt Text");
    mediaImpl.setId(null);
    mediaImpl.setTags("Tags");
    mediaImpl.setTitle("Dr");
    mediaImpl.setUrl(null);

    MediaImpl mediaImpl2 = new MediaImpl();
    mediaImpl2.setAltText("Alt Text");
    mediaImpl2.setId(1L);
    mediaImpl2.setTags("Tags");
    mediaImpl2.setTitle("Dr");
    mediaImpl2.setUrl("https://example.org/example");

    // Act and Assert
    assertNotEquals(mediaImpl, mediaImpl2);
  }

  /**
   * Test {@link MediaImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MediaImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MediaImpl.equals(Object)", "int MediaImpl.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    MediaImpl mediaImpl = new MediaImpl();
    mediaImpl.setAltText("Alt Text");
    mediaImpl.setId(1L);
    mediaImpl.setTags("Tags");
    mediaImpl.setTitle("Dr");
    mediaImpl.setUrl("https://example.org/example");

    // Act and Assert
    assertNotEquals(mediaImpl, null);
  }

  /**
   * Test {@link MediaImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MediaImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MediaImpl.equals(Object)", "int MediaImpl.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    MediaImpl mediaImpl = new MediaImpl();
    mediaImpl.setAltText("Alt Text");
    mediaImpl.setId(1L);
    mediaImpl.setTags("Tags");
    mediaImpl.setTitle("Dr");
    mediaImpl.setUrl("https://example.org/example");

    // Act and Assert
    assertNotEquals(mediaImpl, "Different type to MediaImpl");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link MediaImpl}
   *   <li>{@link MediaImpl#setAltText(String)}
   *   <li>{@link MediaImpl#setId(Long)}
   *   <li>{@link MediaImpl#setTags(String)}
   *   <li>{@link MediaImpl#setTitle(String)}
   *   <li>{@link MediaImpl#setUrl(String)}
   *   <li>{@link MediaImpl#getId()}
   *   <li>{@link MediaImpl#getTags()}
   *   <li>{@link MediaImpl#getUrl()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void MediaImpl.<init>()",
    "Long MediaImpl.getId()",
    "String MediaImpl.getTags()",
    "String MediaImpl.getUrl()",
    "void MediaImpl.setAltText(String)",
    "void MediaImpl.setId(Long)",
    "void MediaImpl.setTags(String)",
    "void MediaImpl.setTitle(String)",
    "void MediaImpl.setUrl(String)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    MediaImpl actualMediaImpl = new MediaImpl();
    actualMediaImpl.setAltText("Alt Text");
    actualMediaImpl.setId(1L);
    actualMediaImpl.setTags("Tags");
    actualMediaImpl.setTitle("Dr");
    actualMediaImpl.setUrl("https://example.org/example");
    Long actualId = actualMediaImpl.getId();
    String actualTags = actualMediaImpl.getTags();

    // Assert
    assertEquals("Tags", actualTags);
    assertEquals("https://example.org/example", actualMediaImpl.getUrl());
    assertEquals(1L, actualId.longValue());
  }
}
