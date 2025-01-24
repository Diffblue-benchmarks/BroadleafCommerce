package org.broadleafcommerce.openadmin.exception;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;

public class EntityNotFoundExceptionDiffblueTest {
  /**
   * Test {@link EntityNotFoundException#EntityNotFoundException()}.
   * <ul>
   *   <li>Then return Message is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityNotFoundException#EntityNotFoundException()}
   */
  @Test
  public void testNewEntityNotFoundException_thenReturnMessageIsNull() {
    // Arrange and Act
    EntityNotFoundException actualEntityNotFoundException = new EntityNotFoundException();

    // Assert
    assertNull(actualEntityNotFoundException.getMessage());
    assertNull(actualEntityNotFoundException.getCause());
    assertEquals(0, actualEntityNotFoundException.getSuppressed().length);
  }

  /**
   * Test {@link EntityNotFoundException#EntityNotFoundException(String)}.
   * <ul>
   *   <li>When {@code foo}.</li>
   *   <li>Then return Message is {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EntityNotFoundException#EntityNotFoundException(String)}
   */
  @Test
  public void testNewEntityNotFoundException_whenFoo_thenReturnMessageIsFoo() {
    // Arrange and Act
    EntityNotFoundException actualEntityNotFoundException = new EntityNotFoundException("foo");

    // Assert
    assertEquals("foo", actualEntityNotFoundException.getMessage());
    assertNull(actualEntityNotFoundException.getCause());
    assertEquals(0, actualEntityNotFoundException.getSuppressed().length);
  }
}
