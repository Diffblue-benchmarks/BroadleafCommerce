package org.broadleafcommerce.core.web.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Map;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class ProcessorUtilsDiffblueTest {
  /**
   * Test {@link ProcessorUtils#getUrl(String, Map)}.
   *
   * <ul>
   *   <li>Given empty array of {@link String}.
   *   <li>When {@link HashMap#HashMap()} {@code ?} is empty array of {@link String}.
   * </ul>
   *
   * <p>Method under test: {@link ProcessorUtils#getUrl(String, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ProcessorUtils.getUrl(String, Map)"})
  public void testGetUrl_givenEmptyArrayOfString_whenHashMapQuestionMarkIsEmptyArrayOfString() {
    // Arrange
    HashMap<String, String[]> parameters = new HashMap<>();
    parameters.put("?", new String[] {});

    // Act and Assert
    assertEquals(
        "https://example.org/example",
        ProcessorUtils.getUrl("https://example.org/example", parameters));
  }

  /**
   * Test {@link ProcessorUtils#getUrl(String, Map)}.
   *
   * <ul>
   *   <li>Then return {@code https://example.org/example?%3F=%3F}.
   * </ul>
   *
   * <p>Method under test: {@link ProcessorUtils#getUrl(String, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ProcessorUtils.getUrl(String, Map)"})
  public void testGetUrl_thenReturnHttpsExampleOrgExample3f3f() {
    // Arrange
    HashMap<String, String[]> parameters = new HashMap<>();
    parameters.put("?", new String[] {"?"});

    // Act and Assert
    assertEquals(
        "https://example.org/example?%3F=%3F",
        ProcessorUtils.getUrl("https://example.org/example", parameters));
  }

  /**
   * Test {@link ProcessorUtils#getUrl(String, Map)}.
   *
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.
   *   <li>Then return {@code https://example.org/example}.
   * </ul>
   *
   * <p>Method under test: {@link ProcessorUtils#getUrl(String, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ProcessorUtils.getUrl(String, Map)"})
  public void testGetUrl_whenHashMap_thenReturnHttpsExampleOrgExample() {
    // Arrange, Act and Assert
    assertEquals(
        "https://example.org/example",
        ProcessorUtils.getUrl("https://example.org/example", new HashMap<>()));
  }

  /**
   * Test {@link ProcessorUtils#getUrl(String, Map)}.
   *
   * <ul>
   *   <li>When {@code ?}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link ProcessorUtils#getUrl(String, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ProcessorUtils.getUrl(String, Map)"})
  public void testGetUrl_whenQuestionMark_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> ProcessorUtils.getUrl("?", new HashMap<>()));
  }
}
