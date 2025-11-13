package org.broadleafcommerce.core.workflow;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class DefaultErrorHandlerDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DefaultErrorHandler#setBeanName(String)}
   *   <li>{@link DefaultErrorHandler#setUnloggedExceptionClasses(List)}
   *   <li>{@link DefaultErrorHandler#getUnloggedExceptionClasses()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List DefaultErrorHandler.getUnloggedExceptionClasses()",
    "void DefaultErrorHandler.setBeanName(String)",
    "void DefaultErrorHandler.setUnloggedExceptionClasses(List)"
  })
  public void testGettersAndSetters() {
    // Arrange
    DefaultErrorHandler defaultErrorHandler = new DefaultErrorHandler();

    // Act
    defaultErrorHandler.setBeanName("Name");
    ArrayList<String> unloggedExceptionClasses = new ArrayList<>();
    defaultErrorHandler.setUnloggedExceptionClasses(unloggedExceptionClasses);
    List<String> actualUnloggedExceptionClasses = defaultErrorHandler.getUnloggedExceptionClasses();

    // Assert
    assertTrue(actualUnloggedExceptionClasses.isEmpty());
    assertSame(unloggedExceptionClasses, actualUnloggedExceptionClasses);
  }
}
