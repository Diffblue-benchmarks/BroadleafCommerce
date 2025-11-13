package org.broadleafcommerce.common.extension;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.common.util.BLCFieldUtils;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class StandardCacheItemDiffblueTest {
  /**
   * Test {@link StandardCacheItem#equals(Object)}, and {@link StandardCacheItem#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link StandardCacheItem#equals(Object)}
   *   <li>{@link StandardCacheItem#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean StandardCacheItem.equals(Object)",
    "int StandardCacheItem.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    StandardCacheItem standardCacheItem = new StandardCacheItem();
    standardCacheItem.setCacheItem(BLCFieldUtils.NULL_FIELD);
    standardCacheItem.setItemStatus(ItemStatus.DELETED);
    standardCacheItem.setKey("Key");

    StandardCacheItem standardCacheItem2 = new StandardCacheItem();
    standardCacheItem2.setCacheItem(BLCFieldUtils.NULL_FIELD);
    standardCacheItem2.setItemStatus(ItemStatus.DELETED);
    standardCacheItem2.setKey("Key");

    // Act and Assert
    assertEquals(standardCacheItem, standardCacheItem2);
    assertEquals(standardCacheItem.hashCode(), standardCacheItem2.hashCode());
  }

  /**
   * Test {@link StandardCacheItem#equals(Object)}, and {@link StandardCacheItem#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link StandardCacheItem#equals(Object)}
   *   <li>{@link StandardCacheItem#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean StandardCacheItem.equals(Object)",
    "int StandardCacheItem.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    StandardCacheItem standardCacheItem = new StandardCacheItem();
    standardCacheItem.setCacheItem(BLCFieldUtils.NULL_FIELD);
    standardCacheItem.setItemStatus(ItemStatus.DELETED);
    standardCacheItem.setKey("Key");

    // Act and Assert
    assertEquals(standardCacheItem, standardCacheItem);
    int expectedHashCodeResult = standardCacheItem.hashCode();
    assertEquals(expectedHashCodeResult, standardCacheItem.hashCode());
  }

  /**
   * Test {@link StandardCacheItem#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link StandardCacheItem#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean StandardCacheItem.equals(Object)",
    "int StandardCacheItem.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    StandardCacheItem standardCacheItem = new StandardCacheItem();
    standardCacheItem.setCacheItem(BLCFieldUtils.NULL_FIELD);
    standardCacheItem.setItemStatus(ItemStatus.DELETED);
    standardCacheItem.setKey("Key");

    StandardCacheItem standardCacheItem2 = new StandardCacheItem();
    standardCacheItem2.setCacheItem(standardCacheItem);
    standardCacheItem2.setItemStatus(ItemStatus.DELETED);
    standardCacheItem2.setKey("Key");

    StandardCacheItem standardCacheItem3 = new StandardCacheItem();
    standardCacheItem3.setCacheItem(BLCFieldUtils.NULL_FIELD);
    standardCacheItem3.setItemStatus(ItemStatus.DELETED);
    standardCacheItem3.setKey("Key");

    // Act and Assert
    assertNotEquals(standardCacheItem2, standardCacheItem3);
  }

  /**
   * Test {@link StandardCacheItem#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link StandardCacheItem#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean StandardCacheItem.equals(Object)",
    "int StandardCacheItem.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    StandardCacheItem standardCacheItem = new StandardCacheItem();
    standardCacheItem.setCacheItem(BLCFieldUtils.NULL_FIELD);
    standardCacheItem.setItemStatus(ItemStatus.DELETED);
    standardCacheItem.setKey("Key");

    // Act and Assert
    assertNotEquals(standardCacheItem, null);
  }

  /**
   * Test {@link StandardCacheItem#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link StandardCacheItem#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean StandardCacheItem.equals(Object)",
    "int StandardCacheItem.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    StandardCacheItem standardCacheItem = new StandardCacheItem();
    standardCacheItem.setCacheItem(BLCFieldUtils.NULL_FIELD);
    standardCacheItem.setItemStatus(ItemStatus.DELETED);
    standardCacheItem.setKey("Key");

    // Act and Assert
    assertNotEquals(standardCacheItem, "Different type to StandardCacheItem");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link StandardCacheItem}
   *   <li>{@link StandardCacheItem#setCacheItem(Object)}
   *   <li>{@link StandardCacheItem#setItemStatus(ItemStatus)}
   *   <li>{@link StandardCacheItem#setKey(String)}
   *   <li>{@link StandardCacheItem#getCacheItem()}
   *   <li>{@link StandardCacheItem#getItemStatus()}
   *   <li>{@link StandardCacheItem#getKey()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void StandardCacheItem.<init>()",
    "Object StandardCacheItem.getCacheItem()",
    "ItemStatus StandardCacheItem.getItemStatus()",
    "String StandardCacheItem.getKey()",
    "void StandardCacheItem.setCacheItem(Object)",
    "void StandardCacheItem.setItemStatus(ItemStatus)",
    "void StandardCacheItem.setKey(String)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    StandardCacheItem actualStandardCacheItem = new StandardCacheItem();
    Object object = BLCFieldUtils.NULL_FIELD;
    actualStandardCacheItem.setCacheItem(object);
    actualStandardCacheItem.setItemStatus(ItemStatus.DELETED);
    actualStandardCacheItem.setKey("Key");
    Object actualCacheItem = actualStandardCacheItem.getCacheItem();
    ItemStatus actualItemStatus = actualStandardCacheItem.getItemStatus();

    // Assert
    assertEquals("Key", actualStandardCacheItem.getKey());
    assertEquals(ItemStatus.DELETED, actualItemStatus);
    assertSame(object, actualCacheItem);
  }
}
