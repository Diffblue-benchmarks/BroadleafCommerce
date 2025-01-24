package org.broadleafcommerce.openadmin.server.service.persistence.module.criteria;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {RestrictionType.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class RestrictionTypeDiffblueTest {
  @Autowired
  private RestrictionType restrictionType;

  /**
   * Test {@link RestrictionType#getInstance(String)}.
   * <p>
   * Method under test: {@link RestrictionType#getInstance(String)}
   */
  @Test
  public void testGetInstance() {
    // Arrange and Act
    RestrictionType actualInstance = RestrictionType.getInstance("Type");

    // Assert
    assertEquals("Friendly Type", actualInstance.getFriendlyType());
    assertEquals("Type", actualInstance.getType());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link RestrictionType#RestrictionType()}
   *   <li>{@link RestrictionType#getFriendlyType()}
   *   <li>{@link RestrictionType#getType()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    RestrictionType actualRestrictionType = new RestrictionType();
    String actualFriendlyType = actualRestrictionType.getFriendlyType();

    // Assert
    assertNull(actualFriendlyType);
    assertNull(actualRestrictionType.getType());
  }

  /**
   * Test {@link RestrictionType#RestrictionType(String, String)}.
   * <ul>
   *   <li>When {@code Cannot add the type: (}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RestrictionType#RestrictionType(String, String)}
   */
  @Test
  public void testNewRestrictionType_whenCannotAddTheType() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> new RestrictionType("Cannot add the type: (", "Friendly Type"));

  }

  /**
   * Test {@link RestrictionType#RestrictionType(String, String)}.
   * <ul>
   *   <li>When {@code Type}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RestrictionType#RestrictionType(String, String)}
   */
  @Test
  public void testNewRestrictionType_whenType() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> new RestrictionType("Type", "Friendly Type"));

  }

  /**
   * Test {@link RestrictionType#equals(Object)}, and
   * {@link RestrictionType#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link RestrictionType#equals(Object)}
   *   <li>{@link RestrictionType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    RestrictionType restrictionType = RestrictionType.BOOLEAN;
    RestrictionType restrictionType2 = RestrictionType.BOOLEAN;

    // Act and Assert
    assertEquals(restrictionType, restrictionType2);
    int expectedHashCodeResult = restrictionType.hashCode();
    assertEquals(expectedHashCodeResult, restrictionType2.hashCode());
  }

  /**
   * Test {@link RestrictionType#equals(Object)}, and
   * {@link RestrictionType#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link RestrictionType#equals(Object)}
   *   <li>{@link RestrictionType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    RestrictionType restrictionType = new RestrictionType();
    RestrictionType restrictionType2 = new RestrictionType();

    // Act and Assert
    assertEquals(restrictionType, restrictionType2);
    int expectedHashCodeResult = restrictionType.hashCode();
    assertEquals(expectedHashCodeResult, restrictionType2.hashCode());
  }

  /**
   * Test {@link RestrictionType#equals(Object)}, and
   * {@link RestrictionType#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link RestrictionType#equals(Object)}
   *   <li>{@link RestrictionType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    RestrictionType restrictionType = RestrictionType.BOOLEAN;

    // Act and Assert
    assertEquals(restrictionType, restrictionType);
    int expectedHashCodeResult = restrictionType.hashCode();
    assertEquals(expectedHashCodeResult, restrictionType.hashCode());
  }

  /**
   * Test {@link RestrictionType#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RestrictionType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(RestrictionType.CHARACTER, RestrictionType.BOOLEAN);
    assertNotEquals(new RestrictionType(), RestrictionType.BOOLEAN);
  }

  /**
   * Test {@link RestrictionType#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RestrictionType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(RestrictionType.BOOLEAN, null);
  }

  /**
   * Test {@link RestrictionType#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RestrictionType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(RestrictionType.BOOLEAN, "Different type to RestrictionType");
  }
}
