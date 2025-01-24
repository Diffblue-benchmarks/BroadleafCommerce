package org.broadleafcommerce.openadmin.server.service;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class JSCompatibilityHelperDiffblueTest {
  /**
   * Test {@link JSCompatibilityHelper#encode(String)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link JSCompatibilityHelper#encode(String)}
   */
  @Test
  public void testEncode_whenEmptyString_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", JSCompatibilityHelper.encode(""));
  }

  /**
   * Test {@link JSCompatibilityHelper#encode(String)}.
   * <ul>
   *   <li>When {@code Name}.</li>
   *   <li>Then return {@code Name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JSCompatibilityHelper#encode(String)}
   */
  @Test
  public void testEncode_whenName_thenReturnName() {
    // Arrange, Act and Assert
    assertEquals("Name", JSCompatibilityHelper.encode("Name"));
  }

  /**
   * Test {@link JSCompatibilityHelper#unencode(String)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link JSCompatibilityHelper#unencode(String)}
   */
  @Test
  public void testUnencode_whenEmptyString_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", JSCompatibilityHelper.unencode(""));
  }

  /**
   * Test {@link JSCompatibilityHelper#unencode(String)}.
   * <ul>
   *   <li>When {@code Name}.</li>
   *   <li>Then return {@code Name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JSCompatibilityHelper#unencode(String)}
   */
  @Test
  public void testUnencode_whenName_thenReturnName() {
    // Arrange, Act and Assert
    assertEquals("Name", JSCompatibilityHelper.unencode("Name"));
  }
}
