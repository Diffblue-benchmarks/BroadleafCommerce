package org.broadleafcommerce.core.search.service.solr.indexer;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import org.junit.Test;

public class FullReindexCommandDiffblueTest {
  /**
   * Test new {@link FullReindexCommand} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link FullReindexCommand}
   */
  @Test
  public void testNewFullReindexCommand() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing observers.
    //   Diffblue Cover was unable to create an assertion.
    //   There are no fields that could be asserted on.

    // Arrange and Act
    new FullReindexCommand();
  }

  /**
   * Test {@link FullReindexCommand#equals(Object)}, and
   * {@link FullReindexCommand#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link FullReindexCommand#equals(Object)}
   *   <li>{@link FullReindexCommand#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    FullReindexCommand fullReindexCommand = FullReindexCommand.DEFAULT_INSTANCE;
    FullReindexCommand fullReindexCommand2 = FullReindexCommand.DEFAULT_INSTANCE;

    // Act and Assert
    assertEquals(fullReindexCommand, fullReindexCommand2);
    int expectedHashCodeResult = fullReindexCommand.hashCode();
    assertEquals(expectedHashCodeResult, fullReindexCommand2.hashCode());
  }

  /**
   * Test {@link FullReindexCommand#equals(Object)}, and
   * {@link FullReindexCommand#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link FullReindexCommand#equals(Object)}
   *   <li>{@link FullReindexCommand#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    FullReindexCommand fullReindexCommand = new FullReindexCommand();
    FullReindexCommand fullReindexCommand2 = FullReindexCommand.DEFAULT_INSTANCE;

    // Act and Assert
    assertEquals(fullReindexCommand, fullReindexCommand2);
    int expectedHashCodeResult = fullReindexCommand.hashCode();
    assertEquals(expectedHashCodeResult, fullReindexCommand2.hashCode());
  }

  /**
   * Test {@link FullReindexCommand#equals(Object)}, and
   * {@link FullReindexCommand#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link FullReindexCommand#equals(Object)}
   *   <li>{@link FullReindexCommand#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    FullReindexCommand fullReindexCommand = FullReindexCommand.DEFAULT_INSTANCE;

    // Act and Assert
    assertEquals(fullReindexCommand, fullReindexCommand);
    int expectedHashCodeResult = fullReindexCommand.hashCode();
    assertEquals(expectedHashCodeResult, fullReindexCommand.hashCode());
  }

  /**
   * Test {@link FullReindexCommand#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link FullReindexCommand#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(FullReindexCommand.DEFAULT_INSTANCE, 1);
  }

  /**
   * Test {@link FullReindexCommand#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link FullReindexCommand#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(FullReindexCommand.DEFAULT_INSTANCE, null);
  }

  /**
   * Test {@link FullReindexCommand#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link FullReindexCommand#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(FullReindexCommand.DEFAULT_INSTANCE, "Different type to FullReindexCommand");
  }
}
