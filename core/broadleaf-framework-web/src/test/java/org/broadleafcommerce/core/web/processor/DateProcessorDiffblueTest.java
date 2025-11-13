package org.broadleafcommerce.core.web.processor;

import static org.junit.Assert.assertEquals;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Date;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class DateProcessorDiffblueTest {
  /**
   * Test {@link DateProcessor#getName()}.
   *
   * <p>Method under test: {@link DateProcessor#getName()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String DateProcessor.getName()"})
  public void testGetName() {
    // Arrange, Act and Assert
    assertEquals("date", new DateProcessor().getName());
  }

  /**
   * Test {@link DateProcessor#getPrecedence()}.
   *
   * <p>Method under test: {@link DateProcessor#getPrecedence()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int DateProcessor.getPrecedence()"})
  public void testGetPrecedence() {
    // Arrange, Act and Assert
    assertEquals(10000, new DateProcessor().getPrecedence());
  }

  /**
   * Test {@link DateProcessor#renderWithContextTimeZone(Date)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link DateProcessor#renderWithContextTimeZone(Date)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String DateProcessor.renderWithContextTimeZone(Date)"})
  public void testRenderWithContextTimeZone_whenNull_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", new DateProcessor().renderWithContextTimeZone(null));
  }
}
