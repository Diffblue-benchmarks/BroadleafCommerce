package org.broadleafcommerce.openadmin.exception;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class EntityNotFoundExceptionDiffblueTest {
  /**
   * Test {@link EntityNotFoundException#EntityNotFoundException()}.
   *
   * <ul>
   *   <li>Then return Message is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link EntityNotFoundException#EntityNotFoundException()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void EntityNotFoundException.<init>()",
    "void EntityNotFoundException.<init>(String)"
  })
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
   *
   * <ul>
   *   <li>When {@code foo}.
   *   <li>Then return Message is {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link EntityNotFoundException#EntityNotFoundException(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void EntityNotFoundException.<init>()",
    "void EntityNotFoundException.<init>(String)"
  })
  public void testNewEntityNotFoundException_whenFoo_thenReturnMessageIsFoo() {
    // Arrange and Act
    EntityNotFoundException actualEntityNotFoundException = new EntityNotFoundException("foo");

    // Assert
    assertEquals("foo", actualEntityNotFoundException.getMessage());
    assertNull(actualEntityNotFoundException.getCause());
    assertEquals(0, actualEntityNotFoundException.getSuppressed().length);
  }
}
