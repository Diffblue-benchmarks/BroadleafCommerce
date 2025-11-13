package org.broadleafcommerce.common.util.dao;

import static org.junit.Assert.assertEquals;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class TQJoinDiffblueTest {
  /**
   * Test {@link TQJoin#TQJoin(String, String)}.
   *
   * <p>Method under test: {@link TQJoin#TQJoin(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TQJoin.<init>(String, String)"})
  public void testNewTQJoin() {
    // Arrange and Act
    TQJoin actualTqJoin = new TQJoin("Expression", "Alias");

    // Assert
    assertEquals("Alias", actualTqJoin.alias);
    assertEquals("Expression Alias", actualTqJoin.toQl());
    assertEquals("Expression", actualTqJoin.expression);
  }

  /**
   * Test {@link TQJoin#toQl()}.
   *
   * <p>Method under test: {@link TQJoin#toQl()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String TQJoin.toQl()"})
  public void testToQl() {
    // Arrange, Act and Assert
    assertEquals("Expression Alias", new TQJoin("Expression", "Alias").toQl());
  }
}
