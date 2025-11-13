package org.broadleafcommerce.openadmin.server.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class JSCompatibilityHelperDiffblueTest {
  /**
   * Test {@link JSCompatibilityHelper#encode(String)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link JSCompatibilityHelper#encode(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String JSCompatibilityHelper.encode(String)"})
  public void testEncode_whenEmptyString_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", JSCompatibilityHelper.encode(""));
  }

  /**
   * Test {@link JSCompatibilityHelper#encode(String)}.
   *
   * <ul>
   *   <li>When {@code Name}.
   *   <li>Then return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link JSCompatibilityHelper#encode(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String JSCompatibilityHelper.encode(String)"})
  public void testEncode_whenName_thenReturnName() {
    // Arrange, Act and Assert
    assertEquals("Name", JSCompatibilityHelper.encode("Name"));
  }

  /**
   * Test {@link JSCompatibilityHelper#encode(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link JSCompatibilityHelper#encode(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String JSCompatibilityHelper.encode(String)"})
  public void testEncode_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(JSCompatibilityHelper.encode(null));
  }

  /**
   * Test {@link JSCompatibilityHelper#unencode(String)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link JSCompatibilityHelper#unencode(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String JSCompatibilityHelper.unencode(String)"})
  public void testUnencode_whenEmptyString_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", JSCompatibilityHelper.unencode(""));
  }

  /**
   * Test {@link JSCompatibilityHelper#unencode(String)}.
   *
   * <ul>
   *   <li>When {@code Name}.
   *   <li>Then return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link JSCompatibilityHelper#unencode(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String JSCompatibilityHelper.unencode(String)"})
  public void testUnencode_whenName_thenReturnName() {
    // Arrange, Act and Assert
    assertEquals("Name", JSCompatibilityHelper.unencode("Name"));
  }

  /**
   * Test {@link JSCompatibilityHelper#unencode(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link JSCompatibilityHelper#unencode(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String JSCompatibilityHelper.unencode(String)"})
  public void testUnencode_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(JSCompatibilityHelper.unencode(null));
  }
}
