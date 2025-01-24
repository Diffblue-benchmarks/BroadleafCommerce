package org.broadleafcommerce.core.catalog.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {RelatedProductTypeEnum.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class RelatedProductTypeEnumDiffblueTest {
  @Autowired
  private RelatedProductTypeEnum relatedProductTypeEnum;

  /**
   * Test {@link RelatedProductTypeEnum#getInstance(String)}.
   * <p>
   * Method under test: {@link RelatedProductTypeEnum#getInstance(String)}
   */
  @Test
  public void testGetInstance() {
    // Arrange and Act
    RelatedProductTypeEnum actualInstance = RelatedProductTypeEnum.getInstance("Type");

    // Assert
    assertEquals("Friendly Type", actualInstance.getFriendlyType());
    assertEquals("Type", actualInstance.getType());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link RelatedProductTypeEnum#RelatedProductTypeEnum()}
   *   <li>{@link RelatedProductTypeEnum#getFriendlyType()}
   *   <li>{@link RelatedProductTypeEnum#getType()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    RelatedProductTypeEnum actualRelatedProductTypeEnum = new RelatedProductTypeEnum();
    String actualFriendlyType = actualRelatedProductTypeEnum.getFriendlyType();

    // Assert
    assertNull(actualFriendlyType);
    assertNull(actualRelatedProductTypeEnum.getType());
  }

  /**
   * Test {@link RelatedProductTypeEnum#RelatedProductTypeEnum(String, String)}.
   * <ul>
   *   <li>When {@code Cannot add the type: (}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RelatedProductTypeEnum#RelatedProductTypeEnum(String, String)}
   */
  @Test
  public void testNewRelatedProductTypeEnum_whenCannotAddTheType() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> new RelatedProductTypeEnum("Cannot add the type: (", "Friendly Type"));

  }

  /**
   * Test {@link RelatedProductTypeEnum#RelatedProductTypeEnum(String, String)}.
   * <ul>
   *   <li>When {@code Type}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RelatedProductTypeEnum#RelatedProductTypeEnum(String, String)}
   */
  @Test
  public void testNewRelatedProductTypeEnum_whenType() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> new RelatedProductTypeEnum("Type", "Friendly Type"));

  }

  /**
   * Test {@link RelatedProductTypeEnum#equals(Object)}, and
   * {@link RelatedProductTypeEnum#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link RelatedProductTypeEnum#equals(Object)}
   *   <li>{@link RelatedProductTypeEnum#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    RelatedProductTypeEnum relatedProductTypeEnum = RelatedProductTypeEnum.CROSS_SALE;
    RelatedProductTypeEnum relatedProductTypeEnum2 = RelatedProductTypeEnum.CROSS_SALE;

    // Act and Assert
    assertEquals(relatedProductTypeEnum, relatedProductTypeEnum2);
    int expectedHashCodeResult = relatedProductTypeEnum.hashCode();
    assertEquals(expectedHashCodeResult, relatedProductTypeEnum2.hashCode());
  }

  /**
   * Test {@link RelatedProductTypeEnum#equals(Object)}, and
   * {@link RelatedProductTypeEnum#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link RelatedProductTypeEnum#equals(Object)}
   *   <li>{@link RelatedProductTypeEnum#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    RelatedProductTypeEnum relatedProductTypeEnum = new RelatedProductTypeEnum();
    RelatedProductTypeEnum relatedProductTypeEnum2 = new RelatedProductTypeEnum();

    // Act and Assert
    assertEquals(relatedProductTypeEnum, relatedProductTypeEnum2);
    int expectedHashCodeResult = relatedProductTypeEnum.hashCode();
    assertEquals(expectedHashCodeResult, relatedProductTypeEnum2.hashCode());
  }

  /**
   * Test {@link RelatedProductTypeEnum#equals(Object)}, and
   * {@link RelatedProductTypeEnum#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link RelatedProductTypeEnum#equals(Object)}
   *   <li>{@link RelatedProductTypeEnum#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    RelatedProductTypeEnum relatedProductTypeEnum = RelatedProductTypeEnum.CROSS_SALE;

    // Act and Assert
    assertEquals(relatedProductTypeEnum, relatedProductTypeEnum);
    int expectedHashCodeResult = relatedProductTypeEnum.hashCode();
    assertEquals(expectedHashCodeResult, relatedProductTypeEnum.hashCode());
  }

  /**
   * Test {@link RelatedProductTypeEnum#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RelatedProductTypeEnum#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(RelatedProductTypeEnum.FEATURED, RelatedProductTypeEnum.CROSS_SALE);
    assertNotEquals(new RelatedProductTypeEnum(), RelatedProductTypeEnum.CROSS_SALE);
  }

  /**
   * Test {@link RelatedProductTypeEnum#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RelatedProductTypeEnum#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(RelatedProductTypeEnum.CROSS_SALE, null);
  }

  /**
   * Test {@link RelatedProductTypeEnum#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RelatedProductTypeEnum#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(RelatedProductTypeEnum.CROSS_SALE, "Different type to RelatedProductTypeEnum");
  }
}
