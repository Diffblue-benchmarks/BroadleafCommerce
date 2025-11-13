package org.broadleafcommerce.common.extensibility.context.merge.handlers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class CommaDelimitedNodeValueMergeDiffblueTest {
  /**
   * Test {@link CommaDelimitedNodeValueMerge#getDelimiter()}.
   *
   * <p>Method under test: {@link CommaDelimitedNodeValueMerge#getDelimiter()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String CommaDelimitedNodeValueMerge.getDelimiter()"})
  public void testGetDelimiter() {
    // Arrange, Act and Assert
    assertEquals(",", new CommaDelimitedNodeValueMerge().getDelimiter());
  }

  /**
   * Test {@link CommaDelimitedNodeValueMerge#getRegEx()}.
   *
   * <p>Method under test: {@link CommaDelimitedNodeValueMerge#getRegEx()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String CommaDelimitedNodeValueMerge.getRegEx()"})
  public void testGetRegEx() {
    // Arrange, Act and Assert
    assertEquals(",", new CommaDelimitedNodeValueMerge().getRegEx());
  }

  /**
   * Test new {@link CommaDelimitedNodeValueMerge} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link
   * CommaDelimitedNodeValueMerge}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CommaDelimitedNodeValueMerge.<init>()"})
  public void testNewCommaDelimitedNodeValueMerge() {
    // Arrange and Act
    CommaDelimitedNodeValueMerge actualCommaDelimitedNodeValueMerge =
        new CommaDelimitedNodeValueMerge();

    // Assert
    assertEquals(" ", actualCommaDelimitedNodeValueMerge.delimiter);
    assertEquals(",", actualCommaDelimitedNodeValueMerge.getDelimiter());
    assertEquals(",", actualCommaDelimitedNodeValueMerge.getRegEx());
    assertEquals("[\\s\\n\\r]+", actualCommaDelimitedNodeValueMerge.regex);
    assertNull(actualCommaDelimitedNodeValueMerge.getName());
    assertNull(actualCommaDelimitedNodeValueMerge.getXPath());
    assertEquals(0, actualCommaDelimitedNodeValueMerge.getPriority());
    assertEquals(0, actualCommaDelimitedNodeValueMerge.getChildren().length);
  }
}
