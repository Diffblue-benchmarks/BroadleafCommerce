package org.broadleafcommerce.core.catalog.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.common.media.domain.Media;
import org.junit.Test;

public class CategoryMediaXrefImplDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CategoryMediaXrefImpl#CategoryMediaXrefImpl()}
   *   <li>{@link CategoryMediaXrefImpl#setCategory(Category)}
   *   <li>{@link CategoryMediaXrefImpl#setId(Long)}
   *   <li>{@link CategoryMediaXrefImpl#setKey(String)}
   *   <li>{@link CategoryMediaXrefImpl#setMedia(Media)}
   *   <li>{@link CategoryMediaXrefImpl#getCategory()}
   *   <li>{@link CategoryMediaXrefImpl#getId()}
   *   <li>{@link CategoryMediaXrefImpl#getKey()}
   *   <li>{@link CategoryMediaXrefImpl#getMedia()}
   * </ul>
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CategoryMediaXrefImpl.<init>()",
    "void CategoryMediaXrefImpl.<init>(Category, Media, String)",
    "Category CategoryMediaXrefImpl.getCategory()",
    "Long CategoryMediaXrefImpl.getId()",
    "String CategoryMediaXrefImpl.getKey()",
    "Media CategoryMediaXrefImpl.getMedia()",
    "void CategoryMediaXrefImpl.setCategory(Category)",
    "void CategoryMediaXrefImpl.setId(Long)",
    "void CategoryMediaXrefImpl.setKey(String)",
    "void CategoryMediaXrefImpl.setMedia(Media)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    CategoryMediaXrefImpl actualCategoryMediaXrefImpl = new CategoryMediaXrefImpl();
    CategoryImpl category = new CategoryImpl();
    actualCategoryMediaXrefImpl.setCategory(category);
    actualCategoryMediaXrefImpl.setId(1L);
    actualCategoryMediaXrefImpl.setKey("Key");
    CategoryMediaXrefImpl media = new CategoryMediaXrefImpl();
    actualCategoryMediaXrefImpl.setMedia(media);
    Category actualCategory = actualCategoryMediaXrefImpl.getCategory();
    Long actualId = actualCategoryMediaXrefImpl.getId();
    String actualKey = actualCategoryMediaXrefImpl.getKey();
    Media actualMedia = actualCategoryMediaXrefImpl.getMedia();

    // Assert
    assertEquals("Key", actualKey);
    assertEquals(1L, actualId.longValue());
    assertSame(category, actualCategory);
    assertSame(media, actualMedia);
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@link CategoryImpl} (default constructor).
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CategoryMediaXrefImpl#CategoryMediaXrefImpl(Category, Media, String)}
   *   <li>{@link CategoryMediaXrefImpl#CategoryMediaXrefImpl()}
   *   <li>{@link CategoryMediaXrefImpl#setCategory(Category)}
   *   <li>{@link CategoryMediaXrefImpl#setId(Long)}
   *   <li>{@link CategoryMediaXrefImpl#setKey(String)}
   *   <li>{@link CategoryMediaXrefImpl#setMedia(Media)}
   *   <li>{@link CategoryMediaXrefImpl#getCategory()}
   *   <li>{@link CategoryMediaXrefImpl#getId()}
   *   <li>{@link CategoryMediaXrefImpl#getKey()}
   *   <li>{@link CategoryMediaXrefImpl#getMedia()}
   * </ul>
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CategoryMediaXrefImpl.<init>()",
    "void CategoryMediaXrefImpl.<init>(Category, Media, String)",
    "Category CategoryMediaXrefImpl.getCategory()",
    "Long CategoryMediaXrefImpl.getId()",
    "String CategoryMediaXrefImpl.getKey()",
    "Media CategoryMediaXrefImpl.getMedia()",
    "void CategoryMediaXrefImpl.setCategory(Category)",
    "void CategoryMediaXrefImpl.setId(Long)",
    "void CategoryMediaXrefImpl.setKey(String)",
    "void CategoryMediaXrefImpl.setMedia(Media)"
  })
  public void testGettersAndSetters_whenCategoryImpl() {
    // Arrange
    CategoryImpl category = new CategoryImpl();

    // Act
    CategoryMediaXrefImpl actualCategoryMediaXrefImpl =
        new CategoryMediaXrefImpl(category, new CategoryMediaXrefImpl(), "Key");
    CategoryImpl category2 = new CategoryImpl();
    actualCategoryMediaXrefImpl.setCategory(category2);
    actualCategoryMediaXrefImpl.setId(1L);
    actualCategoryMediaXrefImpl.setKey("Key");
    CategoryMediaXrefImpl media = new CategoryMediaXrefImpl();
    actualCategoryMediaXrefImpl.setMedia(media);
    Category actualCategory = actualCategoryMediaXrefImpl.getCategory();
    Long actualId = actualCategoryMediaXrefImpl.getId();
    String actualKey = actualCategoryMediaXrefImpl.getKey();
    Media actualMedia = actualCategoryMediaXrefImpl.getMedia();

    // Assert
    assertEquals("Key", actualKey);
    assertEquals(1L, actualId.longValue());
    assertSame(category2, actualCategory);
    assertSame(media, actualMedia);
  }

  /**
   * Test {@link CategoryMediaXrefImpl#equals(Object)}, and {@link
   * CategoryMediaXrefImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CategoryMediaXrefImpl#equals(Object)}
   *   <li>{@link CategoryMediaXrefImpl#hashCode()}
   * </ul>
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CategoryMediaXrefImpl.equals(Object)",
    "int CategoryMediaXrefImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    CategoryMediaXrefImpl categoryMediaXrefImpl = new CategoryMediaXrefImpl();
    categoryMediaXrefImpl.setCategory(new CategoryImpl());
    categoryMediaXrefImpl.setId(1L);
    categoryMediaXrefImpl.setKey("Key");
    categoryMediaXrefImpl.setMedia(new CategoryMediaXrefImpl());

    CategoryMediaXrefImpl categoryMediaXrefImpl2 = new CategoryMediaXrefImpl();
    categoryMediaXrefImpl2.setCategory(new CategoryImpl());
    categoryMediaXrefImpl2.setId(1L);
    categoryMediaXrefImpl2.setKey("Key");
    categoryMediaXrefImpl2.setMedia(new CategoryMediaXrefImpl());

    // Act and Assert
    assertEquals(categoryMediaXrefImpl, categoryMediaXrefImpl2);
    assertEquals(categoryMediaXrefImpl.hashCode(), categoryMediaXrefImpl2.hashCode());
  }

  /**
   * Test {@link CategoryMediaXrefImpl#equals(Object)}, and {@link
   * CategoryMediaXrefImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CategoryMediaXrefImpl#equals(Object)}
   *   <li>{@link CategoryMediaXrefImpl#hashCode()}
   * </ul>
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CategoryMediaXrefImpl.equals(Object)",
    "int CategoryMediaXrefImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    CategoryMediaXrefImpl categoryMediaXrefImpl = new CategoryMediaXrefImpl();
    categoryMediaXrefImpl.setCategory(new CategoryImpl());
    categoryMediaXrefImpl.setId(1L);
    categoryMediaXrefImpl.setKey("Key");
    categoryMediaXrefImpl.setMedia(new CategoryMediaXrefImpl());

    // Act and Assert
    assertEquals(categoryMediaXrefImpl, categoryMediaXrefImpl);
    int expectedHashCodeResult = categoryMediaXrefImpl.hashCode();
    assertEquals(expectedHashCodeResult, categoryMediaXrefImpl.hashCode());
  }

  /**
   * Test {@link CategoryMediaXrefImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CategoryMediaXrefImpl#equals(Object)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CategoryMediaXrefImpl.equals(Object)",
    "int CategoryMediaXrefImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    CategoryMediaXrefImpl categoryMediaXrefImpl = new CategoryMediaXrefImpl();
    categoryMediaXrefImpl.setCategory(null);
    categoryMediaXrefImpl.setId(1L);
    categoryMediaXrefImpl.setKey("Key");
    categoryMediaXrefImpl.setMedia(new CategoryMediaXrefImpl());

    CategoryMediaXrefImpl categoryMediaXrefImpl2 = new CategoryMediaXrefImpl();
    categoryMediaXrefImpl2.setCategory(new CategoryImpl());
    categoryMediaXrefImpl2.setId(1L);
    categoryMediaXrefImpl2.setKey("Key");
    categoryMediaXrefImpl2.setMedia(new CategoryMediaXrefImpl());

    // Act and Assert
    assertNotEquals(categoryMediaXrefImpl, categoryMediaXrefImpl2);
  }

  /**
   * Test {@link CategoryMediaXrefImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CategoryMediaXrefImpl#equals(Object)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CategoryMediaXrefImpl.equals(Object)",
    "int CategoryMediaXrefImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    CategoryMediaXrefImpl categoryMediaXrefImpl = new CategoryMediaXrefImpl();
    categoryMediaXrefImpl.setCategory(mock(CategoryImpl.class));
    categoryMediaXrefImpl.setId(1L);
    categoryMediaXrefImpl.setKey("Key");
    categoryMediaXrefImpl.setMedia(new CategoryMediaXrefImpl());

    CategoryMediaXrefImpl categoryMediaXrefImpl2 = new CategoryMediaXrefImpl();
    categoryMediaXrefImpl2.setCategory(new CategoryImpl());
    categoryMediaXrefImpl2.setId(1L);
    categoryMediaXrefImpl2.setKey("Key");
    categoryMediaXrefImpl2.setMedia(new CategoryMediaXrefImpl());

    // Act and Assert
    assertNotEquals(categoryMediaXrefImpl, categoryMediaXrefImpl2);
  }

  /**
   * Test {@link CategoryMediaXrefImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CategoryMediaXrefImpl#equals(Object)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CategoryMediaXrefImpl.equals(Object)",
    "int CategoryMediaXrefImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    CategoryMediaXrefImpl categoryMediaXrefImpl = new CategoryMediaXrefImpl();
    categoryMediaXrefImpl.setCategory(new CategoryImpl());
    categoryMediaXrefImpl.setId(1L);
    categoryMediaXrefImpl.setKey(null);
    categoryMediaXrefImpl.setMedia(new CategoryMediaXrefImpl());

    CategoryMediaXrefImpl categoryMediaXrefImpl2 = new CategoryMediaXrefImpl();
    categoryMediaXrefImpl2.setCategory(new CategoryImpl());
    categoryMediaXrefImpl2.setId(1L);
    categoryMediaXrefImpl2.setKey("Key");
    categoryMediaXrefImpl2.setMedia(new CategoryMediaXrefImpl());

    // Act and Assert
    assertNotEquals(categoryMediaXrefImpl, categoryMediaXrefImpl2);
  }

  /**
   * Test {@link CategoryMediaXrefImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CategoryMediaXrefImpl#equals(Object)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CategoryMediaXrefImpl.equals(Object)",
    "int CategoryMediaXrefImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    CategoryMediaXrefImpl categoryMediaXrefImpl = new CategoryMediaXrefImpl();
    categoryMediaXrefImpl.setCategory(new CategoryImpl());
    categoryMediaXrefImpl.setId(1L);
    categoryMediaXrefImpl.setKey("org.broadleafcommerce.common.media.domain.Media");
    categoryMediaXrefImpl.setMedia(new CategoryMediaXrefImpl());

    CategoryMediaXrefImpl categoryMediaXrefImpl2 = new CategoryMediaXrefImpl();
    categoryMediaXrefImpl2.setCategory(new CategoryImpl());
    categoryMediaXrefImpl2.setId(1L);
    categoryMediaXrefImpl2.setKey("Key");
    categoryMediaXrefImpl2.setMedia(new CategoryMediaXrefImpl());

    // Act and Assert
    assertNotEquals(categoryMediaXrefImpl, categoryMediaXrefImpl2);
  }

  /**
   * Test {@link CategoryMediaXrefImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CategoryMediaXrefImpl#equals(Object)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CategoryMediaXrefImpl.equals(Object)",
    "int CategoryMediaXrefImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    CategoryMediaXrefImpl categoryMediaXrefImpl = new CategoryMediaXrefImpl();
    categoryMediaXrefImpl.setCategory(new CategoryImpl());
    categoryMediaXrefImpl.setId(1L);
    categoryMediaXrefImpl.setKey("Key");
    categoryMediaXrefImpl.setMedia(null);

    CategoryMediaXrefImpl categoryMediaXrefImpl2 = new CategoryMediaXrefImpl();
    categoryMediaXrefImpl2.setCategory(new CategoryImpl());
    categoryMediaXrefImpl2.setId(1L);
    categoryMediaXrefImpl2.setKey("Key");
    categoryMediaXrefImpl2.setMedia(new CategoryMediaXrefImpl());

    // Act and Assert
    assertNotEquals(categoryMediaXrefImpl, categoryMediaXrefImpl2);
  }

  /**
   * Test {@link CategoryMediaXrefImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CategoryMediaXrefImpl#equals(Object)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CategoryMediaXrefImpl.equals(Object)",
    "int CategoryMediaXrefImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    CategoryMediaXrefImpl categoryMediaXrefImpl = new CategoryMediaXrefImpl();
    categoryMediaXrefImpl.setCategory(new CategoryImpl());
    categoryMediaXrefImpl.setId(1L);
    categoryMediaXrefImpl.setKey("Key");
    CategoryImpl category = new CategoryImpl();
    CategoryMediaXrefImpl media =
        new CategoryMediaXrefImpl(category, new CategoryMediaXrefImpl(), "Key");
    categoryMediaXrefImpl.setMedia(media);

    CategoryMediaXrefImpl categoryMediaXrefImpl2 = new CategoryMediaXrefImpl();
    categoryMediaXrefImpl2.setCategory(new CategoryImpl());
    categoryMediaXrefImpl2.setId(1L);
    categoryMediaXrefImpl2.setKey("Key");
    categoryMediaXrefImpl2.setMedia(new CategoryMediaXrefImpl());

    // Act and Assert
    assertNotEquals(categoryMediaXrefImpl, categoryMediaXrefImpl2);
  }

  /**
   * Test {@link CategoryMediaXrefImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CategoryMediaXrefImpl#equals(Object)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CategoryMediaXrefImpl.equals(Object)",
    "int CategoryMediaXrefImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    CategoryMediaXrefImpl categoryMediaXrefImpl = new CategoryMediaXrefImpl();
    categoryMediaXrefImpl.setCategory(new CategoryImpl());
    categoryMediaXrefImpl.setId(1L);
    categoryMediaXrefImpl.setKey("Key");
    categoryMediaXrefImpl.setMedia(new SkuMediaXrefImpl());

    CategoryMediaXrefImpl categoryMediaXrefImpl2 = new CategoryMediaXrefImpl();
    categoryMediaXrefImpl2.setCategory(new CategoryImpl());
    categoryMediaXrefImpl2.setId(1L);
    categoryMediaXrefImpl2.setKey("Key");
    categoryMediaXrefImpl2.setMedia(new CategoryMediaXrefImpl());

    // Act and Assert
    assertNotEquals(categoryMediaXrefImpl, categoryMediaXrefImpl2);
  }

  /**
   * Test {@link CategoryMediaXrefImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CategoryMediaXrefImpl#equals(Object)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CategoryMediaXrefImpl.equals(Object)",
    "int CategoryMediaXrefImpl.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    CategoryMediaXrefImpl categoryMediaXrefImpl = new CategoryMediaXrefImpl();
    categoryMediaXrefImpl.setCategory(new CategoryImpl());
    categoryMediaXrefImpl.setId(1L);
    categoryMediaXrefImpl.setKey("Key");
    categoryMediaXrefImpl.setMedia(new CategoryMediaXrefImpl());

    // Act and Assert
    assertNotEquals(categoryMediaXrefImpl, null);
  }

  /**
   * Test {@link CategoryMediaXrefImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CategoryMediaXrefImpl#equals(Object)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CategoryMediaXrefImpl.equals(Object)",
    "int CategoryMediaXrefImpl.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    CategoryMediaXrefImpl categoryMediaXrefImpl = new CategoryMediaXrefImpl();
    categoryMediaXrefImpl.setCategory(new CategoryImpl());
    categoryMediaXrefImpl.setId(1L);
    categoryMediaXrefImpl.setKey("Key");
    categoryMediaXrefImpl.setMedia(new CategoryMediaXrefImpl());

    // Act and Assert
    assertNotEquals(categoryMediaXrefImpl, "Different type to CategoryMediaXrefImpl");
  }
}
