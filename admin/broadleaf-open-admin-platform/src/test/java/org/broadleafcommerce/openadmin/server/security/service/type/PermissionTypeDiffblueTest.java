package org.broadleafcommerce.openadmin.server.security.service.type;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {PermissionType.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class PermissionTypeDiffblueTest {
  @Autowired
  private PermissionType permissionType;

  /**
   * Test {@link PermissionType#getInstance(String)}.
   * <p>
   * Method under test: {@link PermissionType#getInstance(String)}
   */
  @Test
  public void testGetInstance() {
    // Arrange and Act
    PermissionType actualInstance = PermissionType.getInstance("Type");

    // Assert
    assertEquals("Friendly Type", actualInstance.getFriendlyType());
    assertEquals("Type", actualInstance.getType());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PermissionType#PermissionType()}
   *   <li>{@link PermissionType#getFriendlyType()}
   *   <li>{@link PermissionType#getType()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    PermissionType actualPermissionType = new PermissionType();
    String actualFriendlyType = actualPermissionType.getFriendlyType();

    // Assert
    assertNull(actualFriendlyType);
    assertNull(actualPermissionType.getType());
  }

  /**
   * Test {@link PermissionType#PermissionType(String, String)}.
   * <ul>
   *   <li>When {@code Cannot add the type: (}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PermissionType#PermissionType(String, String)}
   */
  @Test
  public void testNewPermissionType_whenCannotAddTheType() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> new PermissionType("Cannot add the type: (", "Friendly Type"));

  }

  /**
   * Test {@link PermissionType#PermissionType(String, String)}.
   * <ul>
   *   <li>When {@code Type}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PermissionType#PermissionType(String, String)}
   */
  @Test
  public void testNewPermissionType_whenType() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> new PermissionType("Type", "Friendly Type"));

  }

  /**
   * Test {@link PermissionType#equals(Object)}, and
   * {@link PermissionType#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PermissionType#equals(Object)}
   *   <li>{@link PermissionType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    PermissionType permissionType = PermissionType.ALL;
    PermissionType permissionType2 = PermissionType.ALL;

    // Act and Assert
    assertEquals(permissionType, permissionType2);
    int expectedHashCodeResult = permissionType.hashCode();
    assertEquals(expectedHashCodeResult, permissionType2.hashCode());
  }

  /**
   * Test {@link PermissionType#equals(Object)}, and
   * {@link PermissionType#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PermissionType#equals(Object)}
   *   <li>{@link PermissionType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    PermissionType permissionType = new PermissionType();
    PermissionType permissionType2 = new PermissionType();

    // Act and Assert
    assertEquals(permissionType, permissionType2);
    int expectedHashCodeResult = permissionType.hashCode();
    assertEquals(expectedHashCodeResult, permissionType2.hashCode());
  }

  /**
   * Test {@link PermissionType#equals(Object)}, and
   * {@link PermissionType#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PermissionType#equals(Object)}
   *   <li>{@link PermissionType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    PermissionType permissionType = PermissionType.ALL;

    // Act and Assert
    assertEquals(permissionType, permissionType);
    int expectedHashCodeResult = permissionType.hashCode();
    assertEquals(expectedHashCodeResult, permissionType.hashCode());
  }

  /**
   * Test {@link PermissionType#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PermissionType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(PermissionType.CREATE, PermissionType.ALL);
    assertNotEquals(new PermissionType(), PermissionType.ALL);
  }

  /**
   * Test {@link PermissionType#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PermissionType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(PermissionType.ALL, null);
  }

  /**
   * Test {@link PermissionType#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PermissionType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(PermissionType.ALL, "Different type to PermissionType");
  }
}
