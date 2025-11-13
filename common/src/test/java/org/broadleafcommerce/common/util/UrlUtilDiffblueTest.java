package org.broadleafcommerce.common.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class UrlUtilDiffblueTest {
  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey() {
    // Arrange, Act and Assert
    assertEquals(
        "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789-",
        UrlUtil.generateUrlKey(
            "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789+.-"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey2() {
    // Arrange, Act and Assert
    assertEquals(
        "httpsexampleorgexampleabcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789-",
        UrlUtil.generateUrlKey(
            "https://example.org/exampleabcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789+.-"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey3() {
    // Arrange, Act and Assert
    assertEquals(
        "to-ConvertabcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789-",
        UrlUtil.generateUrlKey(
            "To ConvertabcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789+.-"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey4() {
    // Arrange, Act and Assert
    assertEquals(
        "-abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789-",
        UrlUtil.generateUrlKey(
            " abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789+.-"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey5() {
    // Arrange, Act and Assert
    assertEquals(
        "42abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789-",
        UrlUtil.generateUrlKey(
            "42abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789+.-"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey6() {
    // Arrange, Act and Assert
    assertEquals(
        "xx-xxabcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789-",
        UrlUtil.generateUrlKey(
            "xx xxabcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789+.-"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey7() {
    // Arrange, Act and Assert
    assertEquals(
        "wabcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789-",
        UrlUtil.generateUrlKey(
            ".*?\\W.*?abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789+.-"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey8() {
    // Arrange, Act and Assert
    assertEquals(
        "---abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789-",
        UrlUtil.generateUrlKey(
            "   abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789+.-"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey9() {
    // Arrange, Act and Assert
    assertEquals(
        "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789-",
        UrlUtil.generateUrlKey(
            "/abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789+.-"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey10() {
    // Arrange, Act and Assert
    assertEquals(
        "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789-",
        UrlUtil.generateUrlKey(
            "//abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789+.-"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey11() {
    // Arrange, Act and Assert
    assertEquals(
        "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789-",
        UrlUtil.generateUrlKey(
            ":abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789+.-"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey12() {
    // Arrange, Act and Assert
    assertEquals(
        "redirectabcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789-",
        UrlUtil.generateUrlKey(
            "RedirectabcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789+.-"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey13() {
    // Arrange, Act and Assert
    assertEquals(
        "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789-httpsexampleorgexample",
        UrlUtil.generateUrlKey(
            "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789+.-https://example.org/example"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey14() {
    // Arrange, Act and Assert
    assertEquals(
        "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789-To-Convert",
        UrlUtil.generateUrlKey(
            "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789+.-To Convert"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey15() {
    // Arrange, Act and Assert
    assertEquals(
        "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789-42",
        UrlUtil.generateUrlKey(
            "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789+.-42"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey16() {
    // Arrange, Act and Assert
    assertEquals(
        "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789--",
        UrlUtil.generateUrlKey(
            "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789+.--"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey17() {
    // Arrange, Act and Assert
    assertEquals(
        "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789-W",
        UrlUtil.generateUrlKey(
            "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789+.-.*?\\W.*?"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey18() {
    // Arrange, Act and Assert
    assertEquals(
        "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789-",
        UrlUtil.generateUrlKey(
            "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789+.-/"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey19() {
    // Arrange, Act and Assert
    assertEquals(
        "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789-",
        UrlUtil.generateUrlKey(
            "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789+.-//"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey20() {
    // Arrange, Act and Assert
    assertEquals(
        "w-abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789-",
        UrlUtil.generateUrlKey(
            "[^\\w-]+abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789+.-"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey21() {
    // Arrange, Act and Assert
    assertEquals(
        "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789-",
        UrlUtil.generateUrlKey(
            "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789+.-:"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey22() {
    // Arrange, Act and Assert
    assertEquals(
        "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789-Redirect",
        UrlUtil.generateUrlKey(
            "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789+.-Redirect"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey23() {
    // Arrange, Act and Assert
    assertEquals(
        "httpsexampleorgexamplehttpsexampleorgexamplehttpsexampleorgexample",
        UrlUtil.generateUrlKey(
            "https://example.org/examplehttps://example.org/examplehttps://example.org/example"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey24() {
    // Arrange, Act and Assert
    assertEquals(
        "httpsexampleorgexamplehttpsexampleorgexampleTo-Convert",
        UrlUtil.generateUrlKey("https://example.org/examplehttps://example.org/exampleTo Convert"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey25() {
    // Arrange, Act and Assert
    assertEquals(
        "httpsexampleorgexamplehttpsexampleorgexampleRedirect",
        UrlUtil.generateUrlKey("https://example.org/examplehttps://example.org/exampleRedirect"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey26() {
    // Arrange, Act and Assert
    assertEquals(
        "httpsexampleorgexampleTo-Converthttpsexampleorgexample",
        UrlUtil.generateUrlKey("https://example.org/exampleTo Converthttps://example.org/example"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey27() {
    // Arrange, Act and Assert
    assertEquals(
        "httpsexampleorgexampleTo-ConvertabcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789-",
        UrlUtil.generateUrlKey(
            "https://example.org/exampleTo ConvertabcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789"
                + "+.-"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey28() {
    // Arrange, Act and Assert
    assertEquals(
        "httpsexampleorgexample42abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789-",
        UrlUtil.generateUrlKey(
            "https://example.org/example42abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789+.-"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey29() {
    // Arrange, Act and Assert
    assertEquals(
        "httpsexampleorgexample-abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789-",
        UrlUtil.generateUrlKey(
            "https://example.org/example-abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789+.-"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey30() {
    // Arrange, Act and Assert
    assertEquals(
        "httpsexampleorgexampleWabcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789-",
        UrlUtil.generateUrlKey(
            "https://example.org/example.*?\\W.*?abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789+.-"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey31() {
    // Arrange, Act and Assert
    assertEquals(
        "httpsexampleorgexampleabcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789-",
        UrlUtil.generateUrlKey(
            "https://example.org/example/abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789+.-"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey32() {
    // Arrange, Act and Assert
    assertEquals(
        "httpsexampleorgexampleabcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789-",
        UrlUtil.generateUrlKey(
            "https://example.org/example//abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789+.-"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey33() {
    // Arrange, Act and Assert
    assertEquals(
        "httpsexampleorgexampleabcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789-",
        UrlUtil.generateUrlKey(
            "https://example.org/example:abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789+.-"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey34() {
    // Arrange, Act and Assert
    assertEquals(
        "httpsexampleorgexampleRedirecthttpsexampleorgexample",
        UrlUtil.generateUrlKey("https://example.org/exampleRedirecthttps://example.org/example"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey35() {
    // Arrange, Act and Assert
    assertEquals(
        "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789--",
        UrlUtil.generateUrlKey(
            "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789+.- "));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey36() {
    // Arrange, Act and Assert
    assertEquals(
        "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789-xx-xx",
        UrlUtil.generateUrlKey(
            "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789+.-xx xx"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey37() {
    // Arrange, Act and Assert
    assertEquals(
        "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789----",
        UrlUtil.generateUrlKey(
            "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789+.-   "));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey38() {
    // Arrange, Act and Assert
    assertEquals(
        "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789-w-",
        UrlUtil.generateUrlKey(
            "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789+.-[^\\w-]+"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey39() {
    // Arrange, Act and Assert
    assertEquals(
        "httpsexampleorgexampleRedirectabcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789-",
        UrlUtil.generateUrlKey(
            "https://example.org/exampleRedirectabcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789+.-"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey40() {
    // Arrange, Act and Assert
    assertEquals(
        "httpsexampleorgexampleabcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789-To-Convert",
        UrlUtil.generateUrlKey(
            "https://example.org/exampleabcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789+.-To"
                + " Convert"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey41() {
    // Arrange, Act and Assert
    assertEquals(
        "httpsexampleorgexampleabcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789-42",
        UrlUtil.generateUrlKey(
            "https://example.org/exampleabcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789+.-42"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey42() {
    // Arrange, Act and Assert
    assertEquals(
        "httpsexampleorgexampleabcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789--",
        UrlUtil.generateUrlKey(
            "https://example.org/exampleabcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789+.--"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey43() {
    // Arrange, Act and Assert
    assertEquals(
        "httpsexampleorgexampleabcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789-W",
        UrlUtil.generateUrlKey(
            "https://example.org/exampleabcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789+.-.*?\\W.*?"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey44() {
    // Arrange, Act and Assert
    assertEquals(
        "httpsexampleorgexampleabcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789-",
        UrlUtil.generateUrlKey(
            "https://example.org/exampleabcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789+.-/"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey45() {
    // Arrange, Act and Assert
    assertEquals(
        "httpsexampleorgexampleabcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789-",
        UrlUtil.generateUrlKey(
            "https://example.org/exampleabcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789+.-//"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey46() {
    // Arrange, Act and Assert
    assertEquals(
        "httpsexampleorgexampleabcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789-",
        UrlUtil.generateUrlKey(
            "https://example.org/exampleabcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789+.-:"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey47() {
    // Arrange, Act and Assert
    assertEquals(
        "httpsexampleorgexampleabcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789-Redirect",
        UrlUtil.generateUrlKey(
            "https://example.org/exampleabcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789+.-Redirect"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey48() {
    // Arrange, Act and Assert
    assertEquals(
        "to-Converthttpsexampleorgexamplehttpsexampleorgexample",
        UrlUtil.generateUrlKey("To Converthttps://example.org/examplehttps://example.org/example"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey49() {
    // Arrange, Act and Assert
    assertEquals(
        "to-ConverthttpsexampleorgexampleabcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789-",
        UrlUtil.generateUrlKey(
            "To Converthttps://example.org/exampleabcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789"
                + "+.-"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey50() {
    // Arrange, Act and Assert
    assertEquals(
        "to-ConvertTo-ConvertabcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789-",
        UrlUtil.generateUrlKey(
            "To ConvertTo ConvertabcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789+.-"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey51() {
    // Arrange, Act and Assert
    assertEquals(
        "httpsexampleorgexample-abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789-",
        UrlUtil.generateUrlKey(
            "https://example.org/example abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789+.-"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey52() {
    // Arrange, Act and Assert
    assertEquals(
        "to-Convert42abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789-",
        UrlUtil.generateUrlKey(
            "To Convert42abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789+.-"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey53() {
    // Arrange, Act and Assert
    assertEquals(
        "httpsexampleorgexamplexx-xxabcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789-",
        UrlUtil.generateUrlKey(
            "https://example.org/examplexx xxabcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789+.-"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey54() {
    // Arrange, Act and Assert
    assertEquals(
        "to-Convert-abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789-",
        UrlUtil.generateUrlKey(
            "To Convert-abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789+.-"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey55() {
    // Arrange, Act and Assert
    assertEquals(
        "to-ConvertWabcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789-",
        UrlUtil.generateUrlKey(
            "To Convert.*?\\W.*?abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789+.-"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey56() {
    // Arrange, Act and Assert
    assertEquals(
        "httpsexampleorgexample---abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789-",
        UrlUtil.generateUrlKey(
            "https://example.org/example   abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789+.-"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey57() {
    // Arrange, Act and Assert
    assertEquals(
        "to-ConvertabcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789-",
        UrlUtil.generateUrlKey(
            "To Convert/abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789+.-"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey58() {
    // Arrange, Act and Assert
    assertEquals(
        "to-ConvertabcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789-",
        UrlUtil.generateUrlKey(
            "To Convert//abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789+.-"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey59() {
    // Arrange, Act and Assert
    assertEquals(
        "to-ConvertabcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789-",
        UrlUtil.generateUrlKey(
            "To Convert:abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789+.-"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey60() {
    // Arrange, Act and Assert
    assertEquals(
        "to-ConvertRedirectabcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789-",
        UrlUtil.generateUrlKey(
            "To ConvertRedirectabcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789+.-"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey61() {
    // Arrange, Act and Assert
    assertEquals(
        "to-ConvertabcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789-httpsexampleorgexample",
        UrlUtil.generateUrlKey(
            "To ConvertabcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789+.-https://example.org"
                + "/example"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey62() {
    // Arrange, Act and Assert
    assertEquals(
        "to-ConvertabcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789-To-Convert",
        UrlUtil.generateUrlKey(
            "To ConvertabcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789+.-To Convert"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey63() {
    // Arrange, Act and Assert
    assertEquals(
        "to-ConvertabcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789-42",
        UrlUtil.generateUrlKey(
            "To ConvertabcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789+.-42"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey64() {
    // Arrange, Act and Assert
    assertEquals(
        "httpsexampleorgexamplew-abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789-",
        UrlUtil.generateUrlKey(
            "https://example.org/example[^\\w-]+abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789+.-"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey65() {
    // Arrange, Act and Assert
    assertEquals(
        "to-ConvertabcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789--",
        UrlUtil.generateUrlKey(
            "To ConvertabcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789+.--"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey66() {
    // Arrange, Act and Assert
    assertEquals(
        "to-ConvertabcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789-W",
        UrlUtil.generateUrlKey(
            "To ConvertabcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789+.-.*?\\W.*?"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey67() {
    // Arrange, Act and Assert
    assertEquals(
        "to-ConvertabcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789-",
        UrlUtil.generateUrlKey(
            "To ConvertabcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789+.-/"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey68() {
    // Arrange, Act and Assert
    assertEquals(
        "to-ConvertabcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789-",
        UrlUtil.generateUrlKey(
            "To ConvertabcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789+.-//"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey69() {
    // Arrange, Act and Assert
    assertEquals(
        "to-ConvertabcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789-",
        UrlUtil.generateUrlKey(
            "To ConvertabcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789+.-:"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey70() {
    // Arrange, Act and Assert
    assertEquals(
        "to-ConvertabcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789-Redirect",
        UrlUtil.generateUrlKey(
            "To ConvertabcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789+.-Redirect"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>Then return {@code 42httpsexampleorgexample}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_thenReturn42httpsexampleorgexample() {
    // Arrange, Act and Assert
    assertEquals(
        "42httpsexampleorgexample", UrlUtil.generateUrlKey("42https://example.org/example"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>Then return {@code ------}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_thenReturnDashDashDashDashDashDash() {
    // Arrange, Act and Assert
    assertEquals("------", UrlUtil.generateUrlKey("      "));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>Then return {@code httpsexampleorgexample42-}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_thenReturnHttpsexampleorgexample42() {
    // Arrange, Act and Assert
    assertEquals(
        "httpsexampleorgexample42-", UrlUtil.generateUrlKey("https://example.org/example42-"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>Then return {@code httpsexampleorgexample42Redirect}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_thenReturnHttpsexampleorgexample42Redirect() {
    // Arrange, Act and Assert
    assertEquals(
        "httpsexampleorgexample42Redirect",
        UrlUtil.generateUrlKey("https://example.org/example42Redirect"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>Then return {@code httpsexampleorgexample42To-Convert}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_thenReturnHttpsexampleorgexample42ToConvert() {
    // Arrange, Act and Assert
    assertEquals(
        "httpsexampleorgexample42To-Convert",
        UrlUtil.generateUrlKey("https://example.org/example42To Convert"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>Then return {@code httpsexampleorgexample42W}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_thenReturnHttpsexampleorgexample42W() {
    // Arrange, Act and Assert
    assertEquals(
        "httpsexampleorgexample42W",
        UrlUtil.generateUrlKey("https://example.org/example42.*?\\W.*?"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>Then return {@code httpsexampleorgexample42httpsexampleorgexample}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_thenReturnHttpsexampleorgexample42httpsexampleorgexample() {
    // Arrange, Act and Assert
    assertEquals(
        "httpsexampleorgexample42httpsexampleorgexample",
        UrlUtil.generateUrlKey("https://example.org/example42https://example.org/example"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>Then return {@code httpsexampleorgexample-42}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_thenReturnHttpsexampleorgexample422() {
    // Arrange, Act and Assert
    assertEquals(
        "httpsexampleorgexample-42", UrlUtil.generateUrlKey("https://example.org/example 42"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>Then return {@code httpsexampleorgexample---42}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_thenReturnHttpsexampleorgexample423() {
    // Arrange, Act and Assert
    assertEquals(
        "httpsexampleorgexample---42", UrlUtil.generateUrlKey("https://example.org/example   42"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>Then return {@code httpsexampleorgexample4242}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_thenReturnHttpsexampleorgexample4242() {
    // Arrange, Act and Assert
    assertEquals(
        "httpsexampleorgexample4242", UrlUtil.generateUrlKey("https://example.org/example4242"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>Then return {@code httpsexampleorgexample-httpsexampleorgexample}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_thenReturnHttpsexampleorgexampleHttpsexampleorgexample() {
    // Arrange, Act and Assert
    assertEquals(
        "httpsexampleorgexample-httpsexampleorgexample",
        UrlUtil.generateUrlKey("https://example.org/example https://example.org/example"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>Then return {@code httpsexampleorgexample---httpsexampleorgexample}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_thenReturnHttpsexampleorgexampleHttpsexampleorgexample2() {
    // Arrange, Act and Assert
    assertEquals(
        "httpsexampleorgexample---httpsexampleorgexample",
        UrlUtil.generateUrlKey("https://example.org/example   https://example.org/example"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>Then return {@code httpsexampleorgexampleRedirect-}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_thenReturnHttpsexampleorgexampleRedirect() {
    // Arrange, Act and Assert
    assertEquals(
        "httpsexampleorgexampleRedirect-",
        UrlUtil.generateUrlKey("https://example.org/exampleRedirect-"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>Then return {@code httpsexampleorgexample-Redirect}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_thenReturnHttpsexampleorgexampleRedirect2() {
    // Arrange, Act and Assert
    assertEquals(
        "httpsexampleorgexample-Redirect",
        UrlUtil.generateUrlKey("https://example.org/example Redirect"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>Then return {@code httpsexampleorgexample---Redirect}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_thenReturnHttpsexampleorgexampleRedirect3() {
    // Arrange, Act and Assert
    assertEquals(
        "httpsexampleorgexample---Redirect",
        UrlUtil.generateUrlKey("https://example.org/example   Redirect"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>Then return {@code httpsexampleorgexampleRedirect42}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_thenReturnHttpsexampleorgexampleRedirect42() {
    // Arrange, Act and Assert
    assertEquals(
        "httpsexampleorgexampleRedirect42",
        UrlUtil.generateUrlKey("https://example.org/exampleRedirect42"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>Then return {@code httpsexampleorgexampleRedirectRedirect}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_thenReturnHttpsexampleorgexampleRedirectRedirect() {
    // Arrange, Act and Assert
    assertEquals(
        "httpsexampleorgexampleRedirectRedirect",
        UrlUtil.generateUrlKey("https://example.org/exampleRedirectRedirect"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>Then return {@code httpsexampleorgexampleRedirectTo-Convert}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_thenReturnHttpsexampleorgexampleRedirectToConvert() {
    // Arrange, Act and Assert
    assertEquals(
        "httpsexampleorgexampleRedirectTo-Convert",
        UrlUtil.generateUrlKey("https://example.org/exampleRedirectTo Convert"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>Then return {@code httpsexampleorgexampleRedirectW}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_thenReturnHttpsexampleorgexampleRedirectW() {
    // Arrange, Act and Assert
    assertEquals(
        "httpsexampleorgexampleRedirectW",
        UrlUtil.generateUrlKey("https://example.org/exampleRedirect.*?\\W.*?"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>Then return {@code httpsexampleorgexample-To-Convert}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_thenReturnHttpsexampleorgexampleToConvert() {
    // Arrange, Act and Assert
    assertEquals(
        "httpsexampleorgexample-To-Convert",
        UrlUtil.generateUrlKey("https://example.org/example To Convert"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>Then return {@code httpsexampleorgexample---To-Convert}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_thenReturnHttpsexampleorgexampleToConvert2() {
    // Arrange, Act and Assert
    assertEquals(
        "httpsexampleorgexample---To-Convert",
        UrlUtil.generateUrlKey("https://example.org/example   To Convert"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>Then return {@code httpsexampleorgexampleTo-Convert-}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_thenReturnHttpsexampleorgexampleToConvert3() {
    // Arrange, Act and Assert
    assertEquals(
        "httpsexampleorgexampleTo-Convert-",
        UrlUtil.generateUrlKey("https://example.org/exampleTo Convert "));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>Then return {@code httpsexampleorgexampleTo-Convert---}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_thenReturnHttpsexampleorgexampleToConvert4() {
    // Arrange, Act and Assert
    assertEquals(
        "httpsexampleorgexampleTo-Convert---",
        UrlUtil.generateUrlKey("https://example.org/exampleTo Convert   "));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>Then return {@code httpsexampleorgexampleTo-Convert42}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_thenReturnHttpsexampleorgexampleToConvert42() {
    // Arrange, Act and Assert
    assertEquals(
        "httpsexampleorgexampleTo-Convert42",
        UrlUtil.generateUrlKey("https://example.org/exampleTo Convert42"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>Then return {@code httpsexampleorgexampleTo-ConvertRedirect}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_thenReturnHttpsexampleorgexampleToConvertRedirect() {
    // Arrange, Act and Assert
    assertEquals(
        "httpsexampleorgexampleTo-ConvertRedirect",
        UrlUtil.generateUrlKey("https://example.org/exampleTo ConvertRedirect"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>Then return {@code httpsexampleorgexampleTo-ConvertTo-Convert}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_thenReturnHttpsexampleorgexampleToConvertToConvert() {
    // Arrange, Act and Assert
    assertEquals(
        "httpsexampleorgexampleTo-ConvertTo-Convert",
        UrlUtil.generateUrlKey("https://example.org/exampleTo ConvertTo Convert"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>Then return {@code httpsexampleorgexampleTo-ConvertW}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_thenReturnHttpsexampleorgexampleToConvertW() {
    // Arrange, Act and Assert
    assertEquals(
        "httpsexampleorgexampleTo-ConvertW",
        UrlUtil.generateUrlKey("https://example.org/exampleTo Convert.*?\\W.*?"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>Then return {@code httpsexampleorgexampleTo-Convertxx-xx}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_thenReturnHttpsexampleorgexampleToConvertxxXx() {
    // Arrange, Act and Assert
    assertEquals(
        "httpsexampleorgexampleTo-Convertxx-xx",
        UrlUtil.generateUrlKey("https://example.org/exampleTo Convertxx xx"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>Then return {@code httpsexampleorgexampleW42}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_thenReturnHttpsexampleorgexampleW42() {
    // Arrange, Act and Assert
    assertEquals(
        "httpsexampleorgexampleW42",
        UrlUtil.generateUrlKey("https://example.org/example.*?\\W.*?42"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>Then return {@code httpsexampleorgexampleWRedirect}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_thenReturnHttpsexampleorgexampleWRedirect() {
    // Arrange, Act and Assert
    assertEquals(
        "httpsexampleorgexampleWRedirect",
        UrlUtil.generateUrlKey("https://example.org/example.*?\\W.*?Redirect"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>Then return {@code httpsexampleorgexampleWTo-Convert}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_thenReturnHttpsexampleorgexampleWToConvert() {
    // Arrange, Act and Assert
    assertEquals(
        "httpsexampleorgexampleWTo-Convert",
        UrlUtil.generateUrlKey("https://example.org/example.*?\\W.*?To Convert"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>Then return {@code httpsexampleorgexampleWW}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_thenReturnHttpsexampleorgexampleWW() {
    // Arrange, Act and Assert
    assertEquals(
        "httpsexampleorgexampleWW",
        UrlUtil.generateUrlKey("https://example.org/example.*?\\W.*?.*?\\W.*?"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>Then return {@code httpsexampleorgexampleWhttpsexampleorgexample}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_thenReturnHttpsexampleorgexampleWhttpsexampleorgexample() {
    // Arrange, Act and Assert
    assertEquals(
        "httpsexampleorgexampleWhttpsexampleorgexample",
        UrlUtil.generateUrlKey("https://example.org/example.*?\\W.*?https://example.org/example"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>Then return {@code httpsexampleorgexampleWw-}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_thenReturnHttpsexampleorgexampleWw() {
    // Arrange, Act and Assert
    assertEquals(
        "httpsexampleorgexampleWw-",
        UrlUtil.generateUrlKey("https://example.org/example.*?\\W.*?[^\\w-]+"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>Then return {@code httpsexampleorgexampleWxx-xx}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_thenReturnHttpsexampleorgexampleWxxXx() {
    // Arrange, Act and Assert
    assertEquals(
        "httpsexampleorgexampleWxx-xx",
        UrlUtil.generateUrlKey("https://example.org/example.*?\\W.*?xx xx"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>Then return {@code httpsexampleorgexample-xx-xx}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_thenReturnHttpsexampleorgexampleXxXx() {
    // Arrange, Act and Assert
    assertEquals(
        "httpsexampleorgexample-xx-xx",
        UrlUtil.generateUrlKey("https://example.org/example xx xx"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>Then return {@code httpsexampleorgexample---xx-xx}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_thenReturnHttpsexampleorgexampleXxXx2() {
    // Arrange, Act and Assert
    assertEquals(
        "httpsexampleorgexample---xx-xx",
        UrlUtil.generateUrlKey("https://example.org/example   xx xx"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>Then return {@code httpsexampleorgexamplehttpsexampleorgexample-}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_thenReturnHttpsexampleorgexamplehttpsexampleorgexample() {
    // Arrange, Act and Assert
    assertEquals(
        "httpsexampleorgexamplehttpsexampleorgexample-",
        UrlUtil.generateUrlKey("https://example.org/examplehttps://example.org/example "));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>Then return {@code httpsexampleorgexamplehttpsexampleorgexample---}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_thenReturnHttpsexampleorgexamplehttpsexampleorgexample2() {
    // Arrange, Act and Assert
    assertEquals(
        "httpsexampleorgexamplehttpsexampleorgexample---",
        UrlUtil.generateUrlKey("https://example.org/examplehttps://example.org/example   "));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>Then return {@code httpsexampleorgexamplehttpsexampleorgexample42}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_thenReturnHttpsexampleorgexamplehttpsexampleorgexample42() {
    // Arrange, Act and Assert
    assertEquals(
        "httpsexampleorgexamplehttpsexampleorgexample42",
        UrlUtil.generateUrlKey("https://example.org/examplehttps://example.org/example42"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>Then return {@code httpsexampleorgexamplehttpsexampleorgexampleW}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_thenReturnHttpsexampleorgexamplehttpsexampleorgexampleW() {
    // Arrange, Act and Assert
    assertEquals(
        "httpsexampleorgexamplehttpsexampleorgexampleW",
        UrlUtil.generateUrlKey("https://example.org/examplehttps://example.org/example.*?\\W.*?"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>Then return {@code httpsexampleorgexamplehttpsexampleorgexamplew-}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_thenReturnHttpsexampleorgexamplehttpsexampleorgexamplew() {
    // Arrange, Act and Assert
    assertEquals(
        "httpsexampleorgexamplehttpsexampleorgexamplew-",
        UrlUtil.generateUrlKey("https://example.org/examplehttps://example.org/example[^\\w-]+"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>Then return {@code httpsexampleorgexamplehttpsexampleorgexamplexx-xx}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_thenReturnHttpsexampleorgexamplehttpsexampleorgexamplexxXx() {
    // Arrange, Act and Assert
    assertEquals(
        "httpsexampleorgexamplehttpsexampleorgexamplexx-xx",
        UrlUtil.generateUrlKey("https://example.org/examplehttps://example.org/examplexx xx"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>Then return {@code httpsexampleorgexamplew-42}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_thenReturnHttpsexampleorgexamplew42() {
    // Arrange, Act and Assert
    assertEquals(
        "httpsexampleorgexamplew-42",
        UrlUtil.generateUrlKey("https://example.org/example[^\\w-]+42"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>Then return {@code httpsexampleorgexamplew-httpsexampleorgexample}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_thenReturnHttpsexampleorgexamplewHttpsexampleorgexample() {
    // Arrange, Act and Assert
    assertEquals(
        "httpsexampleorgexamplew-httpsexampleorgexample",
        UrlUtil.generateUrlKey("https://example.org/example[^\\w-]+https://example.org/example"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>Then return {@code httpsexampleorgexamplew-Redirect}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_thenReturnHttpsexampleorgexamplewRedirect() {
    // Arrange, Act and Assert
    assertEquals(
        "httpsexampleorgexamplew-Redirect",
        UrlUtil.generateUrlKey("https://example.org/example[^\\w-]+Redirect"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>Then return {@code httpsexampleorgexamplew-To-Convert}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_thenReturnHttpsexampleorgexamplewToConvert() {
    // Arrange, Act and Assert
    assertEquals(
        "httpsexampleorgexamplew-To-Convert",
        UrlUtil.generateUrlKey("https://example.org/example[^\\w-]+To Convert"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>Then return {@code httpsexampleorgexamplew-W}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_thenReturnHttpsexampleorgexamplewW() {
    // Arrange, Act and Assert
    assertEquals(
        "httpsexampleorgexamplew-W",
        UrlUtil.generateUrlKey("https://example.org/example[^\\w-]+.*?\\W.*?"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>Then return {@code httpsexampleorgexamplew-w-}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_thenReturnHttpsexampleorgexamplewW2() {
    // Arrange, Act and Assert
    assertEquals(
        "httpsexampleorgexamplew-w-",
        UrlUtil.generateUrlKey("https://example.org/example[^\\w-]+[^\\w-]+"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>Then return {@code httpsexampleorgexamplew-xx-xx}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_thenReturnHttpsexampleorgexamplewXxXx() {
    // Arrange, Act and Assert
    assertEquals(
        "httpsexampleorgexamplew-xx-xx",
        UrlUtil.generateUrlKey("https://example.org/example[^\\w-]+xx xx"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>Then return {@code httpsexampleorgexamplexx-xx-}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_thenReturnHttpsexampleorgexamplexxXx() {
    // Arrange, Act and Assert
    assertEquals(
        "httpsexampleorgexamplexx-xx-",
        UrlUtil.generateUrlKey("https://example.org/examplexx xx "));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>Then return {@code httpsexampleorgexamplexx-xx---}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_thenReturnHttpsexampleorgexamplexxXx2() {
    // Arrange, Act and Assert
    assertEquals(
        "httpsexampleorgexamplexx-xx---",
        UrlUtil.generateUrlKey("https://example.org/examplexx xx   "));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>Then return {@code httpsexampleorgexamplexx-xx42}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_thenReturnHttpsexampleorgexamplexxXx42() {
    // Arrange, Act and Assert
    assertEquals(
        "httpsexampleorgexamplexx-xx42",
        UrlUtil.generateUrlKey("https://example.org/examplexx xx42"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>Then return {@code httpsexampleorgexamplexx-xxRedirect}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_thenReturnHttpsexampleorgexamplexxXxRedirect() {
    // Arrange, Act and Assert
    assertEquals(
        "httpsexampleorgexamplexx-xxRedirect",
        UrlUtil.generateUrlKey("https://example.org/examplexx xxRedirect"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>Then return {@code httpsexampleorgexamplexx-xxTo-Convert}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_thenReturnHttpsexampleorgexamplexxXxToConvert() {
    // Arrange, Act and Assert
    assertEquals(
        "httpsexampleorgexamplexx-xxTo-Convert",
        UrlUtil.generateUrlKey("https://example.org/examplexx xxTo Convert"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>Then return {@code httpsexampleorgexamplexx-xxW}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_thenReturnHttpsexampleorgexamplexxXxW() {
    // Arrange, Act and Assert
    assertEquals(
        "httpsexampleorgexamplexx-xxW",
        UrlUtil.generateUrlKey("https://example.org/examplexx xx.*?\\W.*?"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>Then return {@code httpsexampleorgexamplexx-xxhttpsexampleorgexample}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_thenReturnHttpsexampleorgexamplexxXxhttpsexampleorgexample() {
    // Arrange, Act and Assert
    assertEquals(
        "httpsexampleorgexamplexx-xxhttpsexampleorgexample",
        UrlUtil.generateUrlKey("https://example.org/examplexx xxhttps://example.org/example"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>Then return {@code httpsexampleorgexamplexx-xxw-}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_thenReturnHttpsexampleorgexamplexxXxw() {
    // Arrange, Act and Assert
    assertEquals(
        "httpsexampleorgexamplexx-xxw-",
        UrlUtil.generateUrlKey("https://example.org/examplexx xx[^\\w-]+"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>Then return {@code httpsexampleorgexamplexx-xxxx-xx}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_thenReturnHttpsexampleorgexamplexxXxxxXx() {
    // Arrange, Act and Assert
    assertEquals(
        "httpsexampleorgexamplexx-xxxx-xx",
        UrlUtil.generateUrlKey("https://example.org/examplexx xxxx xx"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>Then return {@code redirecthttpsexampleorgexample}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_thenReturnRedirecthttpsexampleorgexample() {
    // Arrange, Act and Assert
    assertEquals(
        "redirecthttpsexampleorgexample",
        UrlUtil.generateUrlKey("Redirecthttps://example.org/example"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>Then return {@code to-Convert42httpsexampleorgexample}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_thenReturnToConvert42httpsexampleorgexample() {
    // Arrange, Act and Assert
    assertEquals(
        "to-Convert42httpsexampleorgexample",
        UrlUtil.generateUrlKey("To Convert42https://example.org/example"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>Then return {@code to-Convert-httpsexampleorgexample}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_thenReturnToConvertHttpsexampleorgexample() {
    // Arrange, Act and Assert
    assertEquals(
        "to-Convert-httpsexampleorgexample",
        UrlUtil.generateUrlKey("To Convert-https://example.org/example"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>Then return {@code to-ConvertRedirectRedirect}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_thenReturnToConvertRedirectRedirect() {
    // Arrange, Act and Assert
    assertEquals(
        "to-ConvertRedirectRedirect", UrlUtil.generateUrlKey("To ConvertRedirectRedirect"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>Then return {@code to-ConvertRedirectTo-Convert}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_thenReturnToConvertRedirectToConvert() {
    // Arrange, Act and Assert
    assertEquals(
        "to-ConvertRedirectTo-Convert", UrlUtil.generateUrlKey("To ConvertRedirectTo Convert"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>Then return {@code to-ConvertRedirecthttpsexampleorgexample}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_thenReturnToConvertRedirecthttpsexampleorgexample() {
    // Arrange, Act and Assert
    assertEquals(
        "to-ConvertRedirecthttpsexampleorgexample",
        UrlUtil.generateUrlKey("To ConvertRedirecthttps://example.org/example"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>Then return {@code to-ConvertTo-ConvertRedirect}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_thenReturnToConvertToConvertRedirect() {
    // Arrange, Act and Assert
    assertEquals(
        "to-ConvertTo-ConvertRedirect", UrlUtil.generateUrlKey("To ConvertTo ConvertRedirect"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>Then return {@code to-ConvertTo-ConvertTo-Convert}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_thenReturnToConvertToConvertToConvert() {
    // Arrange, Act and Assert
    assertEquals(
        "to-ConvertTo-ConvertTo-Convert", UrlUtil.generateUrlKey("To ConvertTo ConvertTo Convert"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>Then return {@code to-ConvertTo-Converthttpsexampleorgexample}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_thenReturnToConvertToConverthttpsexampleorgexample() {
    // Arrange, Act and Assert
    assertEquals(
        "to-ConvertTo-Converthttpsexampleorgexample",
        UrlUtil.generateUrlKey("To ConvertTo Converthttps://example.org/example"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>Then return {@code to-ConvertWhttpsexampleorgexample}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_thenReturnToConvertWhttpsexampleorgexample() {
    // Arrange, Act and Assert
    assertEquals(
        "to-ConvertWhttpsexampleorgexample",
        UrlUtil.generateUrlKey("To Convert.*?\\W.*?https://example.org/example"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>Then return {@code to-Converthttpsexampleorgexample-}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_thenReturnToConverthttpsexampleorgexample() {
    // Arrange, Act and Assert
    assertEquals(
        "to-Converthttpsexampleorgexample-",
        UrlUtil.generateUrlKey("To Converthttps://example.org/example-"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>Then return {@code to-Converthttpsexampleorgexample42}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_thenReturnToConverthttpsexampleorgexample42() {
    // Arrange, Act and Assert
    assertEquals(
        "to-Converthttpsexampleorgexample42",
        UrlUtil.generateUrlKey("To Converthttps://example.org/example42"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>Then return {@code to-ConverthttpsexampleorgexampleRedirect}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_thenReturnToConverthttpsexampleorgexampleRedirect() {
    // Arrange, Act and Assert
    assertEquals(
        "to-ConverthttpsexampleorgexampleRedirect",
        UrlUtil.generateUrlKey("To Converthttps://example.org/exampleRedirect"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>Then return {@code to-ConverthttpsexampleorgexampleTo-Convert}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_thenReturnToConverthttpsexampleorgexampleToConvert() {
    // Arrange, Act and Assert
    assertEquals(
        "to-ConverthttpsexampleorgexampleTo-Convert",
        UrlUtil.generateUrlKey("To Converthttps://example.org/exampleTo Convert"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>Then return {@code to-ConverthttpsexampleorgexampleW}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_thenReturnToConverthttpsexampleorgexampleW() {
    // Arrange, Act and Assert
    assertEquals(
        "to-ConverthttpsexampleorgexampleW",
        UrlUtil.generateUrlKey("To Converthttps://example.org/example.*?\\W.*?"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>Then return {@code xx-xxhttpsexampleorgexample}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_thenReturnXxXxhttpsexampleorgexample() {
    // Arrange, Act and Assert
    assertEquals(
        "xx-xxhttpsexampleorgexample", UrlUtil.generateUrlKey("xx xxhttps://example.org/example"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code 42To Convert}.
   *   <li>Then return {@code 42To-Convert}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_when42ToConvert_thenReturn42ToConvert() {
    // Arrange, Act and Assert
    assertEquals("42To-Convert", UrlUtil.generateUrlKey("42To Convert"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code 42.*?\W.*?}.
   *   <li>Then return {@code 42W}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_when42W_thenReturn42w() {
    // Arrange, Act and Assert
    assertEquals("42W", UrlUtil.generateUrlKey("42.*?\\W.*?"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code 42[^\w-]+}.
   *   <li>Then return {@code 42w-}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_when42W_thenReturn42w2() {
    // Arrange, Act and Assert
    assertEquals("42w-", UrlUtil.generateUrlKey("42[^\\w-]+"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return {@code -42}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_when42_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("-42", UrlUtil.generateUrlKey(" 42"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code 42-}.
   *   <li>Then return {@code 42-}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_when42_thenReturn422() {
    // Arrange, Act and Assert
    assertEquals("42-", UrlUtil.generateUrlKey("42-"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code 42/}.
   *   <li>Then return {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_when42_thenReturn423() {
    // Arrange, Act and Assert
    assertEquals("42", UrlUtil.generateUrlKey("42/"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code 42//}.
   *   <li>Then return {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_when42_thenReturn424() {
    // Arrange, Act and Assert
    assertEquals("42", UrlUtil.generateUrlKey("42//"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code 42:}.
   *   <li>Then return {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_when42_thenReturn425() {
    // Arrange, Act and Assert
    assertEquals("42", UrlUtil.generateUrlKey("42:"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return {@code ---42}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_when42_thenReturn426() {
    // Arrange, Act and Assert
    assertEquals("---42", UrlUtil.generateUrlKey("   42"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code /42}.
   *   <li>Then return {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_when42_thenReturn427() {
    // Arrange, Act and Assert
    assertEquals("42", UrlUtil.generateUrlKey("/42"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code //42}.
   *   <li>Then return {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_when42_thenReturn428() {
    // Arrange, Act and Assert
    assertEquals("42", UrlUtil.generateUrlKey("//42"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code :42}.
   *   <li>Then return {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_when42_thenReturn429() {
    // Arrange, Act and Assert
    assertEquals("42", UrlUtil.generateUrlKey(":42"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return {@code 42-}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_when42_thenReturn4210() {
    // Arrange, Act and Assert
    assertEquals("42-", UrlUtil.generateUrlKey("42 "));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return {@code 42---}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_when42_thenReturn4211() {
    // Arrange, Act and Assert
    assertEquals("42---", UrlUtil.generateUrlKey("42   "));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code 42xx xx}.
   *   <li>Then return {@code 42xx-xx}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_when42xxXx_thenReturn42xxXx() {
    // Arrange, Act and Assert
    assertEquals("42xx-xx", UrlUtil.generateUrlKey("42xx xx"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When a string.
   *   <li>Then return a string.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenAString_thenReturnAString() {
    // Arrange, Act and Assert
    assertEquals(
        "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789-abcdefghijklmnopqrstuvwxyzABCDEFGHIJK"
            + "LMNOPQRSTUVWXYZ0123456789-",
        UrlUtil.generateUrlKey(
            "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789+.-abcdefghijklmnopqrstuvwxyzABCDEFGHI"
                + "JKLMNOPQRSTUVWXYZ0123456789+.-"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When a string.
   *   <li>Then return a string.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenAString_thenReturnAString2() {
    // Arrange, Act and Assert
    assertEquals(
        "httpsexampleorgexamplehttpsexampleorgexampleabcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789"
            + "-",
        UrlUtil.generateUrlKey(
            "https://example.org/examplehttps://example.org/exampleabcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRST"
                + "UVWXYZ0123456789+.-"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When a string.
   *   <li>Then return a string.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenAString_thenReturnAString3() {
    // Arrange, Act and Assert
    assertEquals(
        "httpsexampleorgexampleabcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789-httpsexample"
            + "orgexample",
        UrlUtil.generateUrlKey(
            "https://example.org/exampleabcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789+.-https:/"
                + "/example.org/example"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When a string.
   *   <li>Then return a string.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenAString_thenReturnAString4() {
    // Arrange, Act and Assert
    assertEquals(
        "httpsexampleorgexampleabcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789-abcdefghijklmno"
            + "pqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789-",
        UrlUtil.generateUrlKey(
            "https://example.org/exampleabcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789+."
                + "-abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789+.-"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When a string.
   *   <li>Then return a string.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenAString_thenReturnAString5() {
    // Arrange, Act and Assert
    assertEquals(
        "to-ConvertabcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789-abcdefghijklmnopqrstuvwxyzA"
            + "BCDEFGHIJKLMNOPQRSTUVWXYZ0123456789-",
        UrlUtil.generateUrlKey(
            "To ConvertabcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789+.-abcdefghijklmnopqrstuvwxy"
                + "zABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789+.-"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code ::}.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenColonColon_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", UrlUtil.generateUrlKey("::"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code :-}.
   *   <li>Then return {@code -}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenColonDash_thenReturnDash() {
    // Arrange, Act and Assert
    assertEquals("-", UrlUtil.generateUrlKey(":-"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code ://}.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenColonSlashSlash_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", UrlUtil.generateUrlKey("://"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code :/}.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenColonSlash_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", UrlUtil.generateUrlKey(":/"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code :}.
   *   <li>Then return {@code -}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenColon_thenReturnDash() {
    // Arrange, Act and Assert
    assertEquals("-", UrlUtil.generateUrlKey(" :"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code :}.
   *   <li>Then return {@code -}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenColon_thenReturnDash2() {
    // Arrange, Act and Assert
    assertEquals("-", UrlUtil.generateUrlKey(": "));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code :}.
   *   <li>Then return {@code ---}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenColon_thenReturnDashDashDash() {
    // Arrange, Act and Assert
    assertEquals("---", UrlUtil.generateUrlKey("   :"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code :}.
   *   <li>Then return {@code ---}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenColon_thenReturnDashDashDash2() {
    // Arrange, Act and Assert
    assertEquals("---", UrlUtil.generateUrlKey(":   "));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code :}.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenColon_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", UrlUtil.generateUrlKey(":"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code -}.
   *   <li>Then return {@code --}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenDash_thenReturnDashDash() {
    // Arrange, Act and Assert
    assertEquals("--", UrlUtil.generateUrlKey(" -"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code -}.
   *   <li>Then return {@code --}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenDash_thenReturnDashDash2() {
    // Arrange, Act and Assert
    assertEquals("--", UrlUtil.generateUrlKey("- "));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code -}.
   *   <li>Then return {@code ----}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenDash_thenReturnDashDashDashDash() {
    // Arrange, Act and Assert
    assertEquals("----", UrlUtil.generateUrlKey("   -"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code -}.
   *   <li>Then return {@code ----}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenDash_thenReturnDashDashDashDash2() {
    // Arrange, Act and Assert
    assertEquals("----", UrlUtil.generateUrlKey("-   "));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenEmptyString_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", UrlUtil.generateUrlKey(""));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code https://example.org/example42}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenHttpsExampleOrgExample42() {
    // Arrange, Act and Assert
    assertEquals(
        "httpsexampleorgexample42", UrlUtil.generateUrlKey("https://example.org/example42"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code https://example.org/example42/}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenHttpsExampleOrgExample422() {
    // Arrange, Act and Assert
    assertEquals(
        "httpsexampleorgexample42", UrlUtil.generateUrlKey("https://example.org/example42/"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code https://example.org/example42//}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenHttpsExampleOrgExample423() {
    // Arrange, Act and Assert
    assertEquals(
        "httpsexampleorgexample42", UrlUtil.generateUrlKey("https://example.org/example42//"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code https://example.org/example42:}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenHttpsExampleOrgExample424() {
    // Arrange, Act and Assert
    assertEquals(
        "httpsexampleorgexample42", UrlUtil.generateUrlKey("https://example.org/example42:"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code https://example.org/example-42}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenHttpsExampleOrgExample425() {
    // Arrange, Act and Assert
    assertEquals(
        "httpsexampleorgexample-42", UrlUtil.generateUrlKey("https://example.org/example-42"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code https://example.org/example/42}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenHttpsExampleOrgExample426() {
    // Arrange, Act and Assert
    assertEquals(
        "httpsexampleorgexample42", UrlUtil.generateUrlKey("https://example.org/example/42"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code https://example.org/example//42}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenHttpsExampleOrgExample427() {
    // Arrange, Act and Assert
    assertEquals(
        "httpsexampleorgexample42", UrlUtil.generateUrlKey("https://example.org/example//42"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code https://example.org/example:42}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenHttpsExampleOrgExample428() {
    // Arrange, Act and Assert
    assertEquals(
        "httpsexampleorgexample42", UrlUtil.generateUrlKey("https://example.org/example:42"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code https://example.org/example-https://example.org/example}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenHttpsExampleOrgExampleHttpsExampleOrgExample() {
    // Arrange, Act and Assert
    assertEquals(
        "httpsexampleorgexample-httpsexampleorgexample",
        UrlUtil.generateUrlKey("https://example.org/example-https://example.org/example"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code https://example.org/example/https://example.org/example}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenHttpsExampleOrgExampleHttpsExampleOrgExample2() {
    // Arrange, Act and Assert
    assertEquals(
        "httpsexampleorgexamplehttpsexampleorgexample",
        UrlUtil.generateUrlKey("https://example.org/example/https://example.org/example"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code https://example.org/example//https://example.org/example}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenHttpsExampleOrgExampleHttpsExampleOrgExample3() {
    // Arrange, Act and Assert
    assertEquals(
        "httpsexampleorgexamplehttpsexampleorgexample",
        UrlUtil.generateUrlKey("https://example.org/example//https://example.org/example"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code https://example.org/example:https://example.org/example}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenHttpsExampleOrgExampleHttpsExampleOrgExample4() {
    // Arrange, Act and Assert
    assertEquals(
        "httpsexampleorgexamplehttpsexampleorgexample",
        UrlUtil.generateUrlKey("https://example.org/example:https://example.org/example"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code https://example.org/exampleRedirect}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenHttpsExampleOrgExampleRedirect() {
    // Arrange, Act and Assert
    assertEquals(
        "httpsexampleorgexampleRedirect",
        UrlUtil.generateUrlKey("https://example.org/exampleRedirect"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code https://example.org/example-Redirect}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenHttpsExampleOrgExampleRedirect2() {
    // Arrange, Act and Assert
    assertEquals(
        "httpsexampleorgexample-Redirect",
        UrlUtil.generateUrlKey("https://example.org/example-Redirect"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code https://example.org/example/Redirect}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenHttpsExampleOrgExampleRedirect3() {
    // Arrange, Act and Assert
    assertEquals(
        "httpsexampleorgexampleRedirect",
        UrlUtil.generateUrlKey("https://example.org/example/Redirect"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code https://example.org/example//Redirect}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenHttpsExampleOrgExampleRedirect4() {
    // Arrange, Act and Assert
    assertEquals(
        "httpsexampleorgexampleRedirect",
        UrlUtil.generateUrlKey("https://example.org/example//Redirect"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code https://example.org/example:Redirect}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenHttpsExampleOrgExampleRedirect5() {
    // Arrange, Act and Assert
    assertEquals(
        "httpsexampleorgexampleRedirect",
        UrlUtil.generateUrlKey("https://example.org/example:Redirect"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code https://example.org/exampleRedirect/}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenHttpsExampleOrgExampleRedirect6() {
    // Arrange, Act and Assert
    assertEquals(
        "httpsexampleorgexampleRedirect",
        UrlUtil.generateUrlKey("https://example.org/exampleRedirect/"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code https://example.org/exampleRedirect//}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenHttpsExampleOrgExampleRedirect7() {
    // Arrange, Act and Assert
    assertEquals(
        "httpsexampleorgexampleRedirect",
        UrlUtil.generateUrlKey("https://example.org/exampleRedirect//"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code https://example.org/exampleRedirect:}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenHttpsExampleOrgExampleRedirect8() {
    // Arrange, Act and Assert
    assertEquals(
        "httpsexampleorgexampleRedirect",
        UrlUtil.generateUrlKey("https://example.org/exampleRedirect:"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code https://example.org/exampleTo Convert}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenHttpsExampleOrgExampleToConvert() {
    // Arrange, Act and Assert
    assertEquals(
        "httpsexampleorgexampleTo-Convert",
        UrlUtil.generateUrlKey("https://example.org/exampleTo Convert"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code https://example.org/exampleTo Convert-}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenHttpsExampleOrgExampleToConvert2() {
    // Arrange, Act and Assert
    assertEquals(
        "httpsexampleorgexampleTo-Convert-",
        UrlUtil.generateUrlKey("https://example.org/exampleTo Convert-"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code https://example.org/exampleTo Convert/}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenHttpsExampleOrgExampleToConvert3() {
    // Arrange, Act and Assert
    assertEquals(
        "httpsexampleorgexampleTo-Convert",
        UrlUtil.generateUrlKey("https://example.org/exampleTo Convert/"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code https://example.org/exampleTo Convert//}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenHttpsExampleOrgExampleToConvert4() {
    // Arrange, Act and Assert
    assertEquals(
        "httpsexampleorgexampleTo-Convert",
        UrlUtil.generateUrlKey("https://example.org/exampleTo Convert//"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code https://example.org/exampleTo Convert:}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenHttpsExampleOrgExampleToConvert5() {
    // Arrange, Act and Assert
    assertEquals(
        "httpsexampleorgexampleTo-Convert",
        UrlUtil.generateUrlKey("https://example.org/exampleTo Convert:"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code https://example.org/example-To Convert}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenHttpsExampleOrgExampleToConvert6() {
    // Arrange, Act and Assert
    assertEquals(
        "httpsexampleorgexample-To-Convert",
        UrlUtil.generateUrlKey("https://example.org/example-To Convert"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code https://example.org/example/To Convert}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenHttpsExampleOrgExampleToConvert7() {
    // Arrange, Act and Assert
    assertEquals(
        "httpsexampleorgexampleTo-Convert",
        UrlUtil.generateUrlKey("https://example.org/example/To Convert"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code https://example.org/example//To Convert}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenHttpsExampleOrgExampleToConvert8() {
    // Arrange, Act and Assert
    assertEquals(
        "httpsexampleorgexampleTo-Convert",
        UrlUtil.generateUrlKey("https://example.org/example//To Convert"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code https://example.org/example:To Convert}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenHttpsExampleOrgExampleToConvert9() {
    // Arrange, Act and Assert
    assertEquals(
        "httpsexampleorgexampleTo-Convert",
        UrlUtil.generateUrlKey("https://example.org/example:To Convert"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code https://example.org/example.*?\W.*?}.
   *   <li>Then return {@code httpsexampleorgexampleW}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenHttpsExampleOrgExampleW_thenReturnHttpsexampleorgexampleW() {
    // Arrange, Act and Assert
    assertEquals(
        "httpsexampleorgexampleW", UrlUtil.generateUrlKey("https://example.org/example.*?\\W.*?"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code https://example.org/example-.*?\W.*?}.
   *   <li>Then return {@code httpsexampleorgexample-W}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenHttpsExampleOrgExampleW_thenReturnHttpsexampleorgexampleW2() {
    // Arrange, Act and Assert
    assertEquals(
        "httpsexampleorgexample-W",
        UrlUtil.generateUrlKey("https://example.org/example-.*?\\W.*?"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code https://example.org/example.*?\W.*?-}.
   *   <li>Then return {@code httpsexampleorgexampleW-}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenHttpsExampleOrgExampleW_thenReturnHttpsexampleorgexampleW3() {
    // Arrange, Act and Assert
    assertEquals(
        "httpsexampleorgexampleW-",
        UrlUtil.generateUrlKey("https://example.org/example.*?\\W.*?-"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code https://example.org/example.*?\W.*?/}.
   *   <li>Then return {@code httpsexampleorgexampleW}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenHttpsExampleOrgExampleW_thenReturnHttpsexampleorgexampleW4() {
    // Arrange, Act and Assert
    assertEquals(
        "httpsexampleorgexampleW", UrlUtil.generateUrlKey("https://example.org/example.*?\\W.*?/"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code https://example.org/example.*?\W.*?//}.
   *   <li>Then return {@code httpsexampleorgexampleW}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenHttpsExampleOrgExampleW_thenReturnHttpsexampleorgexampleW5() {
    // Arrange, Act and Assert
    assertEquals(
        "httpsexampleorgexampleW",
        UrlUtil.generateUrlKey("https://example.org/example.*?\\W.*?//"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code https://example.org/example.*?\W.*?:}.
   *   <li>Then return {@code httpsexampleorgexampleW}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenHttpsExampleOrgExampleW_thenReturnHttpsexampleorgexampleW6() {
    // Arrange, Act and Assert
    assertEquals(
        "httpsexampleorgexampleW", UrlUtil.generateUrlKey("https://example.org/example.*?\\W.*?:"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code https://example.org/example/.*?\W.*?}.
   *   <li>Then return {@code httpsexampleorgexampleW}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenHttpsExampleOrgExampleW_thenReturnHttpsexampleorgexampleW7() {
    // Arrange, Act and Assert
    assertEquals(
        "httpsexampleorgexampleW", UrlUtil.generateUrlKey("https://example.org/example/.*?\\W.*?"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code https://example.org/example//.*?\W.*?}.
   *   <li>Then return {@code httpsexampleorgexampleW}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenHttpsExampleOrgExampleW_thenReturnHttpsexampleorgexampleW8() {
    // Arrange, Act and Assert
    assertEquals(
        "httpsexampleorgexampleW",
        UrlUtil.generateUrlKey("https://example.org/example//.*?\\W.*?"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code https://example.org/example:.*?\W.*?}.
   *   <li>Then return {@code httpsexampleorgexampleW}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenHttpsExampleOrgExampleW_thenReturnHttpsexampleorgexampleW9() {
    // Arrange, Act and Assert
    assertEquals(
        "httpsexampleorgexampleW", UrlUtil.generateUrlKey("https://example.org/example:.*?\\W.*?"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code https://example.org/example .*?\W.*?}.
   *   <li>Then return {@code httpsexampleorgexample-W}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenHttpsExampleOrgExampleW_thenReturnHttpsexampleorgexampleW10() {
    // Arrange, Act and Assert
    assertEquals(
        "httpsexampleorgexample-W",
        UrlUtil.generateUrlKey("https://example.org/example .*?\\W.*?"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code https://example.org/example [^\w-]+}.
   *   <li>Then return {@code httpsexampleorgexample-w-}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenHttpsExampleOrgExampleW_thenReturnHttpsexampleorgexampleW11() {
    // Arrange, Act and Assert
    assertEquals(
        "httpsexampleorgexample-w-",
        UrlUtil.generateUrlKey("https://example.org/example [^\\w-]+"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code https://example.org/example .*?\W.*?}.
   *   <li>Then return {@code httpsexampleorgexample---W}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenHttpsExampleOrgExampleW_thenReturnHttpsexampleorgexampleW12() {
    // Arrange, Act and Assert
    assertEquals(
        "httpsexampleorgexample---W",
        UrlUtil.generateUrlKey("https://example.org/example   .*?\\W.*?"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code https://example.org/example [^\w-]+}.
   *   <li>Then return {@code httpsexampleorgexample---w-}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenHttpsExampleOrgExampleW_thenReturnHttpsexampleorgexampleW13() {
    // Arrange, Act and Assert
    assertEquals(
        "httpsexampleorgexample---w-",
        UrlUtil.generateUrlKey("https://example.org/example   [^\\w-]+"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code https://example.org/example.*?\W.*?}.
   *   <li>Then return {@code httpsexampleorgexampleW-}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenHttpsExampleOrgExampleW_thenReturnHttpsexampleorgexampleW14() {
    // Arrange, Act and Assert
    assertEquals(
        "httpsexampleorgexampleW-",
        UrlUtil.generateUrlKey("https://example.org/example.*?\\W.*? "));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code https://example.org/example.*?\W.*?}.
   *   <li>Then return {@code httpsexampleorgexampleW---}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenHttpsExampleOrgExampleW_thenReturnHttpsexampleorgexampleW15() {
    // Arrange, Act and Assert
    assertEquals(
        "httpsexampleorgexampleW---",
        UrlUtil.generateUrlKey("https://example.org/example.*?\\W.*?   "));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code https://example.org/example[^\w-]+}.
   *   <li>Then return {@code httpsexampleorgexamplew-}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenHttpsExampleOrgExampleW_thenReturnHttpsexampleorgexamplew() {
    // Arrange, Act and Assert
    assertEquals(
        "httpsexampleorgexamplew-", UrlUtil.generateUrlKey("https://example.org/example[^\\w-]+"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code https://example.org/example[^\w-]+}.
   *   <li>Then return {@code httpsexampleorgexamplew--}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenHttpsExampleOrgExampleW_thenReturnHttpsexampleorgexamplew2() {
    // Arrange, Act and Assert
    assertEquals(
        "httpsexampleorgexamplew--",
        UrlUtil.generateUrlKey("https://example.org/example[^\\w-]+ "));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code https://example.org/example[^\w-]+}.
   *   <li>Then return {@code httpsexampleorgexamplew----}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenHttpsExampleOrgExampleW_thenReturnHttpsexampleorgexamplew3() {
    // Arrange, Act and Assert
    assertEquals(
        "httpsexampleorgexamplew----",
        UrlUtil.generateUrlKey("https://example.org/example[^\\w-]+   "));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code https://example.org/example[^\w-]+/}.
   *   <li>Then return {@code httpsexampleorgexamplew-}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenHttpsExampleOrgExampleW_thenReturnHttpsexampleorgexamplew4() {
    // Arrange, Act and Assert
    assertEquals(
        "httpsexampleorgexamplew-", UrlUtil.generateUrlKey("https://example.org/example[^\\w-]+/"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code https://example.org/example[^\w-]+//}.
   *   <li>Then return {@code httpsexampleorgexamplew-}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenHttpsExampleOrgExampleW_thenReturnHttpsexampleorgexamplew5() {
    // Arrange, Act and Assert
    assertEquals(
        "httpsexampleorgexamplew-",
        UrlUtil.generateUrlKey("https://example.org/example[^\\w-]+//"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code https://example.org/example[^\w-]+:}.
   *   <li>Then return {@code httpsexampleorgexamplew-}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenHttpsExampleOrgExampleW_thenReturnHttpsexampleorgexamplew6() {
    // Arrange, Act and Assert
    assertEquals(
        "httpsexampleorgexamplew-", UrlUtil.generateUrlKey("https://example.org/example[^\\w-]+:"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code https://example.org/example-xx xx}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenHttpsExampleOrgExampleXxXx() {
    // Arrange, Act and Assert
    assertEquals(
        "httpsexampleorgexample-xx-xx",
        UrlUtil.generateUrlKey("https://example.org/example-xx xx"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code https://example.org/example}.
   *   <li>Then return {@code httpsexampleorgexample}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenHttpsExampleOrgExample_thenReturnHttpsexampleorgexample() {
    // Arrange, Act and Assert
    assertEquals("httpsexampleorgexample", UrlUtil.generateUrlKey("https://example.org/example"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code https://example.org/example}.
   *   <li>Then return {@code httpsexampleorgexample-}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenHttpsExampleOrgExample_thenReturnHttpsexampleorgexample2() {
    // Arrange, Act and Assert
    assertEquals("httpsexampleorgexample-", UrlUtil.generateUrlKey("https://example.org/example "));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code https://example.org/example}.
   *   <li>Then return {@code httpsexampleorgexample---}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenHttpsExampleOrgExample_thenReturnHttpsexampleorgexample3() {
    // Arrange, Act and Assert
    assertEquals(
        "httpsexampleorgexample---", UrlUtil.generateUrlKey("https://example.org/example   "));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code https://example.org/example/}.
   *   <li>Then return {@code httpsexampleorgexample}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenHttpsExampleOrgExample_thenReturnHttpsexampleorgexample4() {
    // Arrange, Act and Assert
    assertEquals("httpsexampleorgexample", UrlUtil.generateUrlKey("https://example.org/example/"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code https://example.org/example//}.
   *   <li>Then return {@code httpsexampleorgexample}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenHttpsExampleOrgExample_thenReturnHttpsexampleorgexample5() {
    // Arrange, Act and Assert
    assertEquals("httpsexampleorgexample", UrlUtil.generateUrlKey("https://example.org/example//"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code https://example.org/example:}.
   *   <li>Then return {@code httpsexampleorgexample}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenHttpsExampleOrgExample_thenReturnHttpsexampleorgexample6() {
    // Arrange, Act and Assert
    assertEquals("httpsexampleorgexample", UrlUtil.generateUrlKey("https://example.org/example:"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code https://example.org/example}.
   *   <li>Then return {@code -httpsexampleorgexample}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenHttpsExampleOrgExample_thenReturnHttpsexampleorgexample7() {
    // Arrange, Act and Assert
    assertEquals("-httpsexampleorgexample", UrlUtil.generateUrlKey(" https://example.org/example"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code https://example.org/example}.
   *   <li>Then return {@code ---httpsexampleorgexample}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenHttpsExampleOrgExample_thenReturnHttpsexampleorgexample8() {
    // Arrange, Act and Assert
    assertEquals(
        "---httpsexampleorgexample", UrlUtil.generateUrlKey("   https://example.org/example"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code /https://example.org/example}.
   *   <li>Then return {@code httpsexampleorgexample}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenHttpsExampleOrgExample_thenReturnHttpsexampleorgexample9() {
    // Arrange, Act and Assert
    assertEquals("httpsexampleorgexample", UrlUtil.generateUrlKey("/https://example.org/example"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code //https://example.org/example}.
   *   <li>Then return {@code httpsexampleorgexample}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenHttpsExampleOrgExample_thenReturnHttpsexampleorgexample10() {
    // Arrange, Act and Assert
    assertEquals("httpsexampleorgexample", UrlUtil.generateUrlKey("//https://example.org/example"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code :https://example.org/example}.
   *   <li>Then return {@code httpsexampleorgexample}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenHttpsExampleOrgExample_thenReturnHttpsexampleorgexample11() {
    // Arrange, Act and Assert
    assertEquals("httpsexampleorgexample", UrlUtil.generateUrlKey(":https://example.org/example"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code https://example.org/example--}.
   *   <li>Then return {@code httpsexampleorgexample--}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenHttpsExampleOrgExample_thenReturnHttpsexampleorgexample12() {
    // Arrange, Act and Assert
    assertEquals(
        "httpsexampleorgexample--", UrlUtil.generateUrlKey("https://example.org/example--"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code https://example.org/example-/}.
   *   <li>Then return {@code httpsexampleorgexample-}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenHttpsExampleOrgExample_thenReturnHttpsexampleorgexample13() {
    // Arrange, Act and Assert
    assertEquals(
        "httpsexampleorgexample-", UrlUtil.generateUrlKey("https://example.org/example-/"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code https://example.org/example-//}.
   *   <li>Then return {@code httpsexampleorgexample-}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenHttpsExampleOrgExample_thenReturnHttpsexampleorgexample14() {
    // Arrange, Act and Assert
    assertEquals(
        "httpsexampleorgexample-", UrlUtil.generateUrlKey("https://example.org/example-//"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code https://example.org/example-:}.
   *   <li>Then return {@code httpsexampleorgexample-}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenHttpsExampleOrgExample_thenReturnHttpsexampleorgexample15() {
    // Arrange, Act and Assert
    assertEquals(
        "httpsexampleorgexample-", UrlUtil.generateUrlKey("https://example.org/example-:"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code https://example.org/example/-}.
   *   <li>Then return {@code httpsexampleorgexample-}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenHttpsExampleOrgExample_thenReturnHttpsexampleorgexample16() {
    // Arrange, Act and Assert
    assertEquals(
        "httpsexampleorgexample-", UrlUtil.generateUrlKey("https://example.org/example/-"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code https://example.org/example///}.
   *   <li>Then return {@code httpsexampleorgexample}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenHttpsExampleOrgExample_thenReturnHttpsexampleorgexample17() {
    // Arrange, Act and Assert
    assertEquals(
        "httpsexampleorgexample", UrlUtil.generateUrlKey("https://example.org/example///"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code https://example.org/example/:}.
   *   <li>Then return {@code httpsexampleorgexample}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenHttpsExampleOrgExample_thenReturnHttpsexampleorgexample18() {
    // Arrange, Act and Assert
    assertEquals("httpsexampleorgexample", UrlUtil.generateUrlKey("https://example.org/example/:"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code https://example.org/example//-}.
   *   <li>Then return {@code httpsexampleorgexample-}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenHttpsExampleOrgExample_thenReturnHttpsexampleorgexample19() {
    // Arrange, Act and Assert
    assertEquals(
        "httpsexampleorgexample-", UrlUtil.generateUrlKey("https://example.org/example//-"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code https://example.org/example////}.
   *   <li>Then return {@code httpsexampleorgexample}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenHttpsExampleOrgExample_thenReturnHttpsexampleorgexample20() {
    // Arrange, Act and Assert
    assertEquals(
        "httpsexampleorgexample", UrlUtil.generateUrlKey("https://example.org/example////"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code https://example.org/example//:}.
   *   <li>Then return {@code httpsexampleorgexample}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenHttpsExampleOrgExample_thenReturnHttpsexampleorgexample21() {
    // Arrange, Act and Assert
    assertEquals(
        "httpsexampleorgexample", UrlUtil.generateUrlKey("https://example.org/example//:"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code https://example.org/example:-}.
   *   <li>Then return {@code httpsexampleorgexample-}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenHttpsExampleOrgExample_thenReturnHttpsexampleorgexample22() {
    // Arrange, Act and Assert
    assertEquals(
        "httpsexampleorgexample-", UrlUtil.generateUrlKey("https://example.org/example:-"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code https://example.org/example:/}.
   *   <li>Then return {@code httpsexampleorgexample}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenHttpsExampleOrgExample_thenReturnHttpsexampleorgexample23() {
    // Arrange, Act and Assert
    assertEquals("httpsexampleorgexample", UrlUtil.generateUrlKey("https://example.org/example:/"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code https://example.org/example://}.
   *   <li>Then return {@code httpsexampleorgexample}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenHttpsExampleOrgExample_thenReturnHttpsexampleorgexample24() {
    // Arrange, Act and Assert
    assertEquals(
        "httpsexampleorgexample", UrlUtil.generateUrlKey("https://example.org/example://"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code https://example.org/example::}.
   *   <li>Then return {@code httpsexampleorgexample}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenHttpsExampleOrgExample_thenReturnHttpsexampleorgexample25() {
    // Arrange, Act and Assert
    assertEquals("httpsexampleorgexample", UrlUtil.generateUrlKey("https://example.org/example::"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code https://example.org/example}.
   *   <li>Then return {@code httpsexampleorgexample--}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenHttpsExampleOrgExample_thenReturnHttpsexampleorgexample26() {
    // Arrange, Act and Assert
    assertEquals(
        "httpsexampleorgexample--", UrlUtil.generateUrlKey("https://example.org/example  "));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code https://example.org/example}.
   *   <li>Then return {@code httpsexampleorgexample----}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenHttpsExampleOrgExample_thenReturnHttpsexampleorgexample27() {
    // Arrange, Act and Assert
    assertEquals(
        "httpsexampleorgexample----", UrlUtil.generateUrlKey("https://example.org/example    "));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code https://example.org/example -}.
   *   <li>Then return {@code httpsexampleorgexample--}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenHttpsExampleOrgExample_thenReturnHttpsexampleorgexample28() {
    // Arrange, Act and Assert
    assertEquals(
        "httpsexampleorgexample--", UrlUtil.generateUrlKey("https://example.org/example -"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code https://example.org/example /}.
   *   <li>Then return {@code httpsexampleorgexample-}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenHttpsExampleOrgExample_thenReturnHttpsexampleorgexample29() {
    // Arrange, Act and Assert
    assertEquals(
        "httpsexampleorgexample-", UrlUtil.generateUrlKey("https://example.org/example /"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code https://example.org/example //}.
   *   <li>Then return {@code httpsexampleorgexample-}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenHttpsExampleOrgExample_thenReturnHttpsexampleorgexample30() {
    // Arrange, Act and Assert
    assertEquals(
        "httpsexampleorgexample-", UrlUtil.generateUrlKey("https://example.org/example //"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code https://example.org/example :}.
   *   <li>Then return {@code httpsexampleorgexample-}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenHttpsExampleOrgExample_thenReturnHttpsexampleorgexample31() {
    // Arrange, Act and Assert
    assertEquals(
        "httpsexampleorgexample-", UrlUtil.generateUrlKey("https://example.org/example :"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code https://example.org/example}.
   *   <li>Then return {@code httpsexampleorgexample------}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenHttpsExampleOrgExample_thenReturnHttpsexampleorgexample32() {
    // Arrange, Act and Assert
    assertEquals(
        "httpsexampleorgexample------",
        UrlUtil.generateUrlKey("https://example.org/example      "));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code https://example.org/example -}.
   *   <li>Then return {@code httpsexampleorgexample----}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenHttpsExampleOrgExample_thenReturnHttpsexampleorgexample33() {
    // Arrange, Act and Assert
    assertEquals(
        "httpsexampleorgexample----", UrlUtil.generateUrlKey("https://example.org/example   -"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code https://example.org/example /}.
   *   <li>Then return {@code httpsexampleorgexample---}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenHttpsExampleOrgExample_thenReturnHttpsexampleorgexample34() {
    // Arrange, Act and Assert
    assertEquals(
        "httpsexampleorgexample---", UrlUtil.generateUrlKey("https://example.org/example   /"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code https://example.org/example //}.
   *   <li>Then return {@code httpsexampleorgexample---}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenHttpsExampleOrgExample_thenReturnHttpsexampleorgexample35() {
    // Arrange, Act and Assert
    assertEquals(
        "httpsexampleorgexample---", UrlUtil.generateUrlKey("https://example.org/example   //"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code https://example.org/example :}.
   *   <li>Then return {@code httpsexampleorgexample---}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenHttpsExampleOrgExample_thenReturnHttpsexampleorgexample36() {
    // Arrange, Act and Assert
    assertEquals(
        "httpsexampleorgexample---", UrlUtil.generateUrlKey("https://example.org/example   :"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code https://example.org/example-}.
   *   <li>Then return {@code httpsexampleorgexample--}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenHttpsExampleOrgExample_thenReturnHttpsexampleorgexample37() {
    // Arrange, Act and Assert
    assertEquals(
        "httpsexampleorgexample--", UrlUtil.generateUrlKey("https://example.org/example- "));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code https://example.org/example-}.
   *   <li>Then return {@code httpsexampleorgexample----}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenHttpsExampleOrgExample_thenReturnHttpsexampleorgexample38() {
    // Arrange, Act and Assert
    assertEquals(
        "httpsexampleorgexample----", UrlUtil.generateUrlKey("https://example.org/example-   "));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code https://example.org/examplehttps://example.org/example}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenHttpsExampleOrgExamplehttpsExampleOrgExample() {
    // Arrange, Act and Assert
    assertEquals(
        "httpsexampleorgexamplehttpsexampleorgexample",
        UrlUtil.generateUrlKey("https://example.org/examplehttps://example.org/example"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code https://example.org/examplehttps://example.org/example-}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenHttpsExampleOrgExamplehttpsExampleOrgExample2() {
    // Arrange, Act and Assert
    assertEquals(
        "httpsexampleorgexamplehttpsexampleorgexample-",
        UrlUtil.generateUrlKey("https://example.org/examplehttps://example.org/example-"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code https://example.org/examplehttps://example.org/example/}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenHttpsExampleOrgExamplehttpsExampleOrgExample3() {
    // Arrange, Act and Assert
    assertEquals(
        "httpsexampleorgexamplehttpsexampleorgexample",
        UrlUtil.generateUrlKey("https://example.org/examplehttps://example.org/example/"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code https://example.org/examplehttps://example.org/example//}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenHttpsExampleOrgExamplehttpsExampleOrgExample4() {
    // Arrange, Act and Assert
    assertEquals(
        "httpsexampleorgexamplehttpsexampleorgexample",
        UrlUtil.generateUrlKey("https://example.org/examplehttps://example.org/example//"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code https://example.org/examplehttps://example.org/example:}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenHttpsExampleOrgExamplehttpsExampleOrgExample5() {
    // Arrange, Act and Assert
    assertEquals(
        "httpsexampleorgexamplehttpsexampleorgexample",
        UrlUtil.generateUrlKey("https://example.org/examplehttps://example.org/example:"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code https://example.org/examplexx xx}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenHttpsExampleOrgExamplexxXx() {
    // Arrange, Act and Assert
    assertEquals(
        "httpsexampleorgexamplexx-xx", UrlUtil.generateUrlKey("https://example.org/examplexx xx"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code https://example.org/examplexx xx-}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenHttpsExampleOrgExamplexxXx2() {
    // Arrange, Act and Assert
    assertEquals(
        "httpsexampleorgexamplexx-xx-",
        UrlUtil.generateUrlKey("https://example.org/examplexx xx-"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code https://example.org/examplexx xx/}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenHttpsExampleOrgExamplexxXx3() {
    // Arrange, Act and Assert
    assertEquals(
        "httpsexampleorgexamplexx-xx", UrlUtil.generateUrlKey("https://example.org/examplexx xx/"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code https://example.org/examplexx xx//}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenHttpsExampleOrgExamplexxXx4() {
    // Arrange, Act and Assert
    assertEquals(
        "httpsexampleorgexamplexx-xx",
        UrlUtil.generateUrlKey("https://example.org/examplexx xx//"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code https://example.org/examplexx xx:}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenHttpsExampleOrgExamplexxXx5() {
    // Arrange, Act and Assert
    assertEquals(
        "httpsexampleorgexamplexx-xx", UrlUtil.generateUrlKey("https://example.org/examplexx xx:"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(UrlUtil.generateUrlKey(null));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code RedirectTo Convert}.
   *   <li>Then return {@code redirectTo-Convert}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenRedirectToConvert_thenReturnRedirectToConvert() {
    // Arrange, Act and Assert
    assertEquals("redirectTo-Convert", UrlUtil.generateUrlKey("RedirectTo Convert"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code Redirect.*?\W.*?}.
   *   <li>Then return {@code redirectW}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenRedirectW_thenReturnRedirectW() {
    // Arrange, Act and Assert
    assertEquals("redirectW", UrlUtil.generateUrlKey("Redirect.*?\\W.*?"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code Redirect[^\w-]+}.
   *   <li>Then return {@code redirectw-}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenRedirectW_thenReturnRedirectw() {
    // Arrange, Act and Assert
    assertEquals("redirectw-", UrlUtil.generateUrlKey("Redirect[^\\w-]+"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code Redirect}.
   *   <li>Then return {@code -Redirect}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenRedirect_thenReturnRedirect() {
    // Arrange, Act and Assert
    assertEquals("-Redirect", UrlUtil.generateUrlKey(" Redirect"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code Redirect}.
   *   <li>Then return {@code ---Redirect}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenRedirect_thenReturnRedirect2() {
    // Arrange, Act and Assert
    assertEquals("---Redirect", UrlUtil.generateUrlKey("   Redirect"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code /Redirect}.
   *   <li>Then return {@code redirect}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenRedirect_thenReturnRedirect3() {
    // Arrange, Act and Assert
    assertEquals("redirect", UrlUtil.generateUrlKey("/Redirect"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code //Redirect}.
   *   <li>Then return {@code redirect}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenRedirect_thenReturnRedirect4() {
    // Arrange, Act and Assert
    assertEquals("redirect", UrlUtil.generateUrlKey("//Redirect"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code :Redirect}.
   *   <li>Then return {@code redirect}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenRedirect_thenReturnRedirect5() {
    // Arrange, Act and Assert
    assertEquals("redirect", UrlUtil.generateUrlKey(":Redirect"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code Redirect-}.
   *   <li>Then return {@code redirect-}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenRedirect_thenReturnRedirect6() {
    // Arrange, Act and Assert
    assertEquals("redirect-", UrlUtil.generateUrlKey("Redirect-"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code Redirect/}.
   *   <li>Then return {@code redirect}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenRedirect_thenReturnRedirect7() {
    // Arrange, Act and Assert
    assertEquals("redirect", UrlUtil.generateUrlKey("Redirect/"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code Redirect//}.
   *   <li>Then return {@code redirect}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenRedirect_thenReturnRedirect8() {
    // Arrange, Act and Assert
    assertEquals("redirect", UrlUtil.generateUrlKey("Redirect//"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code Redirect:}.
   *   <li>Then return {@code redirect}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenRedirect_thenReturnRedirect9() {
    // Arrange, Act and Assert
    assertEquals("redirect", UrlUtil.generateUrlKey("Redirect:"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code Redirect}.
   *   <li>Then return {@code redirect-}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenRedirect_thenReturnRedirect10() {
    // Arrange, Act and Assert
    assertEquals("redirect-", UrlUtil.generateUrlKey("Redirect "));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code Redirect}.
   *   <li>Then return {@code redirect---}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenRedirect_thenReturnRedirect11() {
    // Arrange, Act and Assert
    assertEquals("redirect---", UrlUtil.generateUrlKey("Redirect   "));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code Redirectxx xx}.
   *   <li>Then return {@code redirectxx-xx}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenRedirectxxXx_thenReturnRedirectxxXx() {
    // Arrange, Act and Assert
    assertEquals("redirectxx-xx", UrlUtil.generateUrlKey("Redirectxx xx"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code /:}.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenSlashColon_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", UrlUtil.generateUrlKey("/:"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code /-}.
   *   <li>Then return {@code -}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenSlashDash_thenReturnDash() {
    // Arrange, Act and Assert
    assertEquals("-", UrlUtil.generateUrlKey("/-"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code //:}.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenSlashSlashColon_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", UrlUtil.generateUrlKey("//:"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code //-}.
   *   <li>Then return {@code -}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenSlashSlashDash_thenReturnDash() {
    // Arrange, Act and Assert
    assertEquals("-", UrlUtil.generateUrlKey("//-"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code ////}.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenSlashSlashSlashSlash_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", UrlUtil.generateUrlKey("////"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code ///}.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenSlashSlashSlash_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", UrlUtil.generateUrlKey("///"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code //}.
   *   <li>Then return {@code -}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenSlashSlash_thenReturnDash() {
    // Arrange, Act and Assert
    assertEquals("-", UrlUtil.generateUrlKey(" //"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code //}.
   *   <li>Then return {@code -}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenSlashSlash_thenReturnDash2() {
    // Arrange, Act and Assert
    assertEquals("-", UrlUtil.generateUrlKey("// "));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code //}.
   *   <li>Then return {@code ---}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenSlashSlash_thenReturnDashDashDash() {
    // Arrange, Act and Assert
    assertEquals("---", UrlUtil.generateUrlKey("   //"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code //}.
   *   <li>Then return {@code ---}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenSlashSlash_thenReturnDashDashDash2() {
    // Arrange, Act and Assert
    assertEquals("---", UrlUtil.generateUrlKey("//   "));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code //}.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenSlashSlash_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", UrlUtil.generateUrlKey("//"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code /}.
   *   <li>Then return {@code -}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenSlash_thenReturnDash() {
    // Arrange, Act and Assert
    assertEquals("-", UrlUtil.generateUrlKey(" /"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code /}.
   *   <li>Then return {@code -}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenSlash_thenReturnDash2() {
    // Arrange, Act and Assert
    assertEquals("-", UrlUtil.generateUrlKey("/ "));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code /}.
   *   <li>Then return {@code ---}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenSlash_thenReturnDashDashDash() {
    // Arrange, Act and Assert
    assertEquals("---", UrlUtil.generateUrlKey("   /"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code /}.
   *   <li>Then return {@code ---}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenSlash_thenReturnDashDashDash2() {
    // Arrange, Act and Assert
    assertEquals("---", UrlUtil.generateUrlKey("/   "));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code /}.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenSlash_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", UrlUtil.generateUrlKey("/"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When space space space space.
   *   <li>Then return {@code ----}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenSpaceSpaceSpaceSpace_thenReturnDashDashDashDash() {
    // Arrange, Act and Assert
    assertEquals("----", UrlUtil.generateUrlKey("    "));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When space space space.
   *   <li>Then return {@code ---}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenSpaceSpaceSpace_thenReturnDashDashDash() {
    // Arrange, Act and Assert
    assertEquals("---", UrlUtil.generateUrlKey("   "));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When space space.
   *   <li>Then return {@code --}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenSpaceSpace_thenReturnDashDash() {
    // Arrange, Act and Assert
    assertEquals("--", UrlUtil.generateUrlKey("  "));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When space.
   *   <li>Then return {@code -}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenSpace_thenReturnDash() {
    // Arrange, Act and Assert
    assertEquals("-", UrlUtil.generateUrlKey(" "));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code To Convert42Redirect}.
   *   <li>Then return {@code to-Convert42Redirect}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenToConvert42Redirect_thenReturnToConvert42Redirect() {
    // Arrange, Act and Assert
    assertEquals("to-Convert42Redirect", UrlUtil.generateUrlKey("To Convert42Redirect"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code To Convert42To Convert}.
   *   <li>Then return {@code to-Convert42To-Convert}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenToConvert42ToConvert_thenReturnToConvert42ToConvert() {
    // Arrange, Act and Assert
    assertEquals("to-Convert42To-Convert", UrlUtil.generateUrlKey("To Convert42To Convert"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code To Convert42.*?\W.*?}.
   *   <li>Then return {@code to-Convert42W}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenToConvert42W_thenReturnToConvert42W() {
    // Arrange, Act and Assert
    assertEquals("to-Convert42W", UrlUtil.generateUrlKey("To Convert42.*?\\W.*?"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code To Convert42}.
   *   <li>Then return {@code to-Convert42}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenToConvert42_thenReturnToConvert42() {
    // Arrange, Act and Assert
    assertEquals("to-Convert42", UrlUtil.generateUrlKey("To Convert42"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code To Convert42-}.
   *   <li>Then return {@code to-Convert42-}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenToConvert42_thenReturnToConvert422() {
    // Arrange, Act and Assert
    assertEquals("to-Convert42-", UrlUtil.generateUrlKey("To Convert42-"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code To Convert42/}.
   *   <li>Then return {@code to-Convert42}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenToConvert42_thenReturnToConvert423() {
    // Arrange, Act and Assert
    assertEquals("to-Convert42", UrlUtil.generateUrlKey("To Convert42/"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code To Convert42//}.
   *   <li>Then return {@code to-Convert42}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenToConvert42_thenReturnToConvert424() {
    // Arrange, Act and Assert
    assertEquals("to-Convert42", UrlUtil.generateUrlKey("To Convert42//"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code To Convert42:}.
   *   <li>Then return {@code to-Convert42}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenToConvert42_thenReturnToConvert425() {
    // Arrange, Act and Assert
    assertEquals("to-Convert42", UrlUtil.generateUrlKey("To Convert42:"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code To Convert-42}.
   *   <li>Then return {@code to-Convert-42}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenToConvert42_thenReturnToConvert426() {
    // Arrange, Act and Assert
    assertEquals("to-Convert-42", UrlUtil.generateUrlKey("To Convert-42"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code To Convert/42}.
   *   <li>Then return {@code to-Convert42}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenToConvert42_thenReturnToConvert427() {
    // Arrange, Act and Assert
    assertEquals("to-Convert42", UrlUtil.generateUrlKey("To Convert/42"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code To Convert//42}.
   *   <li>Then return {@code to-Convert42}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenToConvert42_thenReturnToConvert428() {
    // Arrange, Act and Assert
    assertEquals("to-Convert42", UrlUtil.generateUrlKey("To Convert//42"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code To Convert:42}.
   *   <li>Then return {@code to-Convert42}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenToConvert42_thenReturnToConvert429() {
    // Arrange, Act and Assert
    assertEquals("to-Convert42", UrlUtil.generateUrlKey("To Convert:42"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code To Convert4242}.
   *   <li>Then return {@code to-Convert4242}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenToConvert4242_thenReturnToConvert4242() {
    // Arrange, Act and Assert
    assertEquals("to-Convert4242", UrlUtil.generateUrlKey("To Convert4242"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code To Convert/https://example.org/example}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenToConvertHttpsExampleOrgExample() {
    // Arrange, Act and Assert
    assertEquals(
        "to-Converthttpsexampleorgexample",
        UrlUtil.generateUrlKey("To Convert/https://example.org/example"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code To Convert//https://example.org/example}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenToConvertHttpsExampleOrgExample2() {
    // Arrange, Act and Assert
    assertEquals(
        "to-Converthttpsexampleorgexample",
        UrlUtil.generateUrlKey("To Convert//https://example.org/example"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code To Convert:https://example.org/example}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenToConvertHttpsExampleOrgExample3() {
    // Arrange, Act and Assert
    assertEquals(
        "to-Converthttpsexampleorgexample",
        UrlUtil.generateUrlKey("To Convert:https://example.org/example"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code To ConvertRedirect42}.
   *   <li>Then return {@code to-ConvertRedirect42}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenToConvertRedirect42_thenReturnToConvertRedirect42() {
    // Arrange, Act and Assert
    assertEquals("to-ConvertRedirect42", UrlUtil.generateUrlKey("To ConvertRedirect42"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code To ConvertRedirect.*?\W.*?}.
   *   <li>Then return {@code to-ConvertRedirectW}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenToConvertRedirectW_thenReturnToConvertRedirectW() {
    // Arrange, Act and Assert
    assertEquals("to-ConvertRedirectW", UrlUtil.generateUrlKey("To ConvertRedirect.*?\\W.*?"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code To ConvertRedirect}.
   *   <li>Then return {@code to-ConvertRedirect}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenToConvertRedirect_thenReturnToConvertRedirect() {
    // Arrange, Act and Assert
    assertEquals("to-ConvertRedirect", UrlUtil.generateUrlKey("To ConvertRedirect"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code To Convert-Redirect}.
   *   <li>Then return {@code to-Convert-Redirect}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenToConvertRedirect_thenReturnToConvertRedirect2() {
    // Arrange, Act and Assert
    assertEquals("to-Convert-Redirect", UrlUtil.generateUrlKey("To Convert-Redirect"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code To Convert/Redirect}.
   *   <li>Then return {@code to-ConvertRedirect}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenToConvertRedirect_thenReturnToConvertRedirect3() {
    // Arrange, Act and Assert
    assertEquals("to-ConvertRedirect", UrlUtil.generateUrlKey("To Convert/Redirect"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code To Convert//Redirect}.
   *   <li>Then return {@code to-ConvertRedirect}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenToConvertRedirect_thenReturnToConvertRedirect4() {
    // Arrange, Act and Assert
    assertEquals("to-ConvertRedirect", UrlUtil.generateUrlKey("To Convert//Redirect"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code To Convert:Redirect}.
   *   <li>Then return {@code to-ConvertRedirect}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenToConvertRedirect_thenReturnToConvertRedirect5() {
    // Arrange, Act and Assert
    assertEquals("to-ConvertRedirect", UrlUtil.generateUrlKey("To Convert:Redirect"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code To ConvertRedirect-}.
   *   <li>Then return {@code to-ConvertRedirect-}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenToConvertRedirect_thenReturnToConvertRedirect6() {
    // Arrange, Act and Assert
    assertEquals("to-ConvertRedirect-", UrlUtil.generateUrlKey("To ConvertRedirect-"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code To ConvertRedirect/}.
   *   <li>Then return {@code to-ConvertRedirect}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenToConvertRedirect_thenReturnToConvertRedirect7() {
    // Arrange, Act and Assert
    assertEquals("to-ConvertRedirect", UrlUtil.generateUrlKey("To ConvertRedirect/"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code To ConvertRedirect//}.
   *   <li>Then return {@code to-ConvertRedirect}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenToConvertRedirect_thenReturnToConvertRedirect8() {
    // Arrange, Act and Assert
    assertEquals("to-ConvertRedirect", UrlUtil.generateUrlKey("To ConvertRedirect//"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code To ConvertRedirect:}.
   *   <li>Then return {@code to-ConvertRedirect}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenToConvertRedirect_thenReturnToConvertRedirect9() {
    // Arrange, Act and Assert
    assertEquals("to-ConvertRedirect", UrlUtil.generateUrlKey("To ConvertRedirect:"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code To ConvertTo Convert42}.
   *   <li>Then return {@code to-ConvertTo-Convert42}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenToConvertToConvert42_thenReturnToConvertToConvert42() {
    // Arrange, Act and Assert
    assertEquals("to-ConvertTo-Convert42", UrlUtil.generateUrlKey("To ConvertTo Convert42"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code To ConvertTo Convert.*?\W.*?}.
   *   <li>Then return {@code to-ConvertTo-ConvertW}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenToConvertToConvertW_thenReturnToConvertToConvertW() {
    // Arrange, Act and Assert
    assertEquals("to-ConvertTo-ConvertW", UrlUtil.generateUrlKey("To ConvertTo Convert.*?\\W.*?"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code To ConvertTo Convert}.
   *   <li>Then return {@code to-ConvertTo-Convert}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenToConvertToConvert_thenReturnToConvertToConvert() {
    // Arrange, Act and Assert
    assertEquals("to-ConvertTo-Convert", UrlUtil.generateUrlKey("To ConvertTo Convert"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code To ConvertTo Convert-}.
   *   <li>Then return {@code to-ConvertTo-Convert-}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenToConvertToConvert_thenReturnToConvertToConvert2() {
    // Arrange, Act and Assert
    assertEquals("to-ConvertTo-Convert-", UrlUtil.generateUrlKey("To ConvertTo Convert-"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code To ConvertTo Convert/}.
   *   <li>Then return {@code to-ConvertTo-Convert}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenToConvertToConvert_thenReturnToConvertToConvert3() {
    // Arrange, Act and Assert
    assertEquals("to-ConvertTo-Convert", UrlUtil.generateUrlKey("To ConvertTo Convert/"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code To ConvertTo Convert//}.
   *   <li>Then return {@code to-ConvertTo-Convert}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenToConvertToConvert_thenReturnToConvertToConvert4() {
    // Arrange, Act and Assert
    assertEquals("to-ConvertTo-Convert", UrlUtil.generateUrlKey("To ConvertTo Convert//"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code To ConvertTo Convert:}.
   *   <li>Then return {@code to-ConvertTo-Convert}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenToConvertToConvert_thenReturnToConvertToConvert5() {
    // Arrange, Act and Assert
    assertEquals("to-ConvertTo-Convert", UrlUtil.generateUrlKey("To ConvertTo Convert:"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code To Convert-To Convert}.
   *   <li>Then return {@code to-Convert-To-Convert}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenToConvertToConvert_thenReturnToConvertToConvert6() {
    // Arrange, Act and Assert
    assertEquals("to-Convert-To-Convert", UrlUtil.generateUrlKey("To Convert-To Convert"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code To Convert/To Convert}.
   *   <li>Then return {@code to-ConvertTo-Convert}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenToConvertToConvert_thenReturnToConvertToConvert7() {
    // Arrange, Act and Assert
    assertEquals("to-ConvertTo-Convert", UrlUtil.generateUrlKey("To Convert/To Convert"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code To Convert//To Convert}.
   *   <li>Then return {@code to-ConvertTo-Convert}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenToConvertToConvert_thenReturnToConvertToConvert8() {
    // Arrange, Act and Assert
    assertEquals("to-ConvertTo-Convert", UrlUtil.generateUrlKey("To Convert//To Convert"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code To Convert:To Convert}.
   *   <li>Then return {@code to-ConvertTo-Convert}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenToConvertToConvert_thenReturnToConvertToConvert9() {
    // Arrange, Act and Assert
    assertEquals("to-ConvertTo-Convert", UrlUtil.generateUrlKey("To Convert:To Convert"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code To Convert.*?\W.*?42}.
   *   <li>Then return {@code to-ConvertW42}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenToConvertW42_thenReturnToConvertW42() {
    // Arrange, Act and Assert
    assertEquals("to-ConvertW42", UrlUtil.generateUrlKey("To Convert.*?\\W.*?42"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code To Convert.*?\W.*?Redirect}.
   *   <li>Then return {@code to-ConvertWRedirect}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenToConvertWRedirect_thenReturnToConvertWRedirect() {
    // Arrange, Act and Assert
    assertEquals("to-ConvertWRedirect", UrlUtil.generateUrlKey("To Convert.*?\\W.*?Redirect"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code To Convert.*?\W.*?To Convert}.
   *   <li>Then return {@code to-ConvertWTo-Convert}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenToConvertWToConvert_thenReturnToConvertWToConvert() {
    // Arrange, Act and Assert
    assertEquals("to-ConvertWTo-Convert", UrlUtil.generateUrlKey("To Convert.*?\\W.*?To Convert"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code To Convert.*?\W.*?.*?\W.*?}.
   *   <li>Then return {@code to-ConvertWW}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenToConvertWW_thenReturnToConvertWW() {
    // Arrange, Act and Assert
    assertEquals("to-ConvertWW", UrlUtil.generateUrlKey("To Convert.*?\\W.*?.*?\\W.*?"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code To Convert.*?\W.*?}.
   *   <li>Then return {@code to-ConvertW}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenToConvertW_thenReturnToConvertW() {
    // Arrange, Act and Assert
    assertEquals("to-ConvertW", UrlUtil.generateUrlKey("To Convert.*?\\W.*?"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code To Convert-.*?\W.*?}.
   *   <li>Then return {@code to-Convert-W}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenToConvertW_thenReturnToConvertW2() {
    // Arrange, Act and Assert
    assertEquals("to-Convert-W", UrlUtil.generateUrlKey("To Convert-.*?\\W.*?"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code To Convert.*?\W.*?-}.
   *   <li>Then return {@code to-ConvertW-}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenToConvertW_thenReturnToConvertW3() {
    // Arrange, Act and Assert
    assertEquals("to-ConvertW-", UrlUtil.generateUrlKey("To Convert.*?\\W.*?-"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code To Convert.*?\W.*?/}.
   *   <li>Then return {@code to-ConvertW}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenToConvertW_thenReturnToConvertW4() {
    // Arrange, Act and Assert
    assertEquals("to-ConvertW", UrlUtil.generateUrlKey("To Convert.*?\\W.*?/"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code To Convert.*?\W.*?//}.
   *   <li>Then return {@code to-ConvertW}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenToConvertW_thenReturnToConvertW5() {
    // Arrange, Act and Assert
    assertEquals("to-ConvertW", UrlUtil.generateUrlKey("To Convert.*?\\W.*?//"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code To Convert.*?\W.*?:}.
   *   <li>Then return {@code to-ConvertW}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenToConvertW_thenReturnToConvertW6() {
    // Arrange, Act and Assert
    assertEquals("to-ConvertW", UrlUtil.generateUrlKey("To Convert.*?\\W.*?:"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code To Convert/.*?\W.*?}.
   *   <li>Then return {@code to-ConvertW}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenToConvertW_thenReturnToConvertW7() {
    // Arrange, Act and Assert
    assertEquals("to-ConvertW", UrlUtil.generateUrlKey("To Convert/.*?\\W.*?"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code To Convert//.*?\W.*?}.
   *   <li>Then return {@code to-ConvertW}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenToConvertW_thenReturnToConvertW8() {
    // Arrange, Act and Assert
    assertEquals("to-ConvertW", UrlUtil.generateUrlKey("To Convert//.*?\\W.*?"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code To Convert:.*?\W.*?}.
   *   <li>Then return {@code to-ConvertW}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenToConvertW_thenReturnToConvertW9() {
    // Arrange, Act and Assert
    assertEquals("to-ConvertW", UrlUtil.generateUrlKey("To Convert:.*?\\W.*?"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code To Convert[^\w-]+}.
   *   <li>Then return {@code to-Convertw-}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenToConvertW_thenReturnToConvertw() {
    // Arrange, Act and Assert
    assertEquals("to-Convertw-", UrlUtil.generateUrlKey("To Convert[^\\w-]+"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code To Convert}.
   *   <li>Then return {@code to-Convert}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenToConvert_thenReturnToConvert() {
    // Arrange, Act and Assert
    assertEquals("to-Convert", UrlUtil.generateUrlKey("To Convert"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code To Convert-}.
   *   <li>Then return {@code to-Convert-}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenToConvert_thenReturnToConvert2() {
    // Arrange, Act and Assert
    assertEquals("to-Convert-", UrlUtil.generateUrlKey("To Convert-"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code To Convert/}.
   *   <li>Then return {@code to-Convert}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenToConvert_thenReturnToConvert3() {
    // Arrange, Act and Assert
    assertEquals("to-Convert", UrlUtil.generateUrlKey("To Convert/"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code To Convert//}.
   *   <li>Then return {@code to-Convert}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenToConvert_thenReturnToConvert4() {
    // Arrange, Act and Assert
    assertEquals("to-Convert", UrlUtil.generateUrlKey("To Convert//"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code To Convert:}.
   *   <li>Then return {@code to-Convert}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenToConvert_thenReturnToConvert5() {
    // Arrange, Act and Assert
    assertEquals("to-Convert", UrlUtil.generateUrlKey("To Convert:"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code To Convert}.
   *   <li>Then return {@code -To-Convert}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenToConvert_thenReturnToConvert6() {
    // Arrange, Act and Assert
    assertEquals("-To-Convert", UrlUtil.generateUrlKey(" To Convert"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code -To Convert}.
   *   <li>Then return {@code -To-Convert}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenToConvert_thenReturnToConvert7() {
    // Arrange, Act and Assert
    assertEquals("-To-Convert", UrlUtil.generateUrlKey("-To Convert"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code To Convert}.
   *   <li>Then return {@code ---To-Convert}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenToConvert_thenReturnToConvert8() {
    // Arrange, Act and Assert
    assertEquals("---To-Convert", UrlUtil.generateUrlKey("   To Convert"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code /To Convert}.
   *   <li>Then return {@code to-Convert}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenToConvert_thenReturnToConvert9() {
    // Arrange, Act and Assert
    assertEquals("to-Convert", UrlUtil.generateUrlKey("/To Convert"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code //To Convert}.
   *   <li>Then return {@code to-Convert}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenToConvert_thenReturnToConvert10() {
    // Arrange, Act and Assert
    assertEquals("to-Convert", UrlUtil.generateUrlKey("//To Convert"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code :To Convert}.
   *   <li>Then return {@code to-Convert}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenToConvert_thenReturnToConvert11() {
    // Arrange, Act and Assert
    assertEquals("to-Convert", UrlUtil.generateUrlKey(":To Convert"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code To Convert}.
   *   <li>Then return {@code to-Convert-}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenToConvert_thenReturnToConvert12() {
    // Arrange, Act and Assert
    assertEquals("to-Convert-", UrlUtil.generateUrlKey("To Convert "));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code To Convert}.
   *   <li>Then return {@code to-Convert---}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenToConvert_thenReturnToConvert13() {
    // Arrange, Act and Assert
    assertEquals("to-Convert---", UrlUtil.generateUrlKey("To Convert   "));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code To Convert--}.
   *   <li>Then return {@code to-Convert--}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenToConvert_thenReturnToConvert14() {
    // Arrange, Act and Assert
    assertEquals("to-Convert--", UrlUtil.generateUrlKey("To Convert--"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code To Convert-/}.
   *   <li>Then return {@code to-Convert-}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenToConvert_thenReturnToConvert15() {
    // Arrange, Act and Assert
    assertEquals("to-Convert-", UrlUtil.generateUrlKey("To Convert-/"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code To Convert-//}.
   *   <li>Then return {@code to-Convert-}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenToConvert_thenReturnToConvert16() {
    // Arrange, Act and Assert
    assertEquals("to-Convert-", UrlUtil.generateUrlKey("To Convert-//"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code To Convert-:}.
   *   <li>Then return {@code to-Convert-}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenToConvert_thenReturnToConvert17() {
    // Arrange, Act and Assert
    assertEquals("to-Convert-", UrlUtil.generateUrlKey("To Convert-:"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code To Convert/-}.
   *   <li>Then return {@code to-Convert-}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenToConvert_thenReturnToConvert18() {
    // Arrange, Act and Assert
    assertEquals("to-Convert-", UrlUtil.generateUrlKey("To Convert/-"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code To Convert///}.
   *   <li>Then return {@code to-Convert}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenToConvert_thenReturnToConvert19() {
    // Arrange, Act and Assert
    assertEquals("to-Convert", UrlUtil.generateUrlKey("To Convert///"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code To Convert/:}.
   *   <li>Then return {@code to-Convert}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenToConvert_thenReturnToConvert20() {
    // Arrange, Act and Assert
    assertEquals("to-Convert", UrlUtil.generateUrlKey("To Convert/:"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code To Convert//-}.
   *   <li>Then return {@code to-Convert-}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenToConvert_thenReturnToConvert21() {
    // Arrange, Act and Assert
    assertEquals("to-Convert-", UrlUtil.generateUrlKey("To Convert//-"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code To Convert////}.
   *   <li>Then return {@code to-Convert}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenToConvert_thenReturnToConvert22() {
    // Arrange, Act and Assert
    assertEquals("to-Convert", UrlUtil.generateUrlKey("To Convert////"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code To Convert//:}.
   *   <li>Then return {@code to-Convert}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenToConvert_thenReturnToConvert23() {
    // Arrange, Act and Assert
    assertEquals("to-Convert", UrlUtil.generateUrlKey("To Convert//:"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code To Convert:-}.
   *   <li>Then return {@code to-Convert-}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenToConvert_thenReturnToConvert24() {
    // Arrange, Act and Assert
    assertEquals("to-Convert-", UrlUtil.generateUrlKey("To Convert:-"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code To Convert:/}.
   *   <li>Then return {@code to-Convert}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenToConvert_thenReturnToConvert25() {
    // Arrange, Act and Assert
    assertEquals("to-Convert", UrlUtil.generateUrlKey("To Convert:/"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code To Convert://}.
   *   <li>Then return {@code to-Convert}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenToConvert_thenReturnToConvert26() {
    // Arrange, Act and Assert
    assertEquals("to-Convert", UrlUtil.generateUrlKey("To Convert://"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code To Convert::}.
   *   <li>Then return {@code to-Convert}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenToConvert_thenReturnToConvert27() {
    // Arrange, Act and Assert
    assertEquals("to-Convert", UrlUtil.generateUrlKey("To Convert::"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code To Converthttps://example.org/example}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenToConverthttpsExampleOrgExample() {
    // Arrange, Act and Assert
    assertEquals(
        "to-Converthttpsexampleorgexample",
        UrlUtil.generateUrlKey("To Converthttps://example.org/example"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code To Converthttps://example.org/example/}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenToConverthttpsExampleOrgExample2() {
    // Arrange, Act and Assert
    assertEquals(
        "to-Converthttpsexampleorgexample",
        UrlUtil.generateUrlKey("To Converthttps://example.org/example/"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code To Converthttps://example.org/example//}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenToConverthttpsExampleOrgExample3() {
    // Arrange, Act and Assert
    assertEquals(
        "to-Converthttpsexampleorgexample",
        UrlUtil.generateUrlKey("To Converthttps://example.org/example//"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code To Converthttps://example.org/example:}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenToConverthttpsExampleOrgExample4() {
    // Arrange, Act and Assert
    assertEquals(
        "to-Converthttpsexampleorgexample",
        UrlUtil.generateUrlKey("To Converthttps://example.org/example:"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code To Convertxx xx}.
   *   <li>Then return {@code to-Convertxx-xx}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenToConvertxxXx_thenReturnToConvertxxXx() {
    // Arrange, Act and Assert
    assertEquals("to-Convertxx-xx", UrlUtil.generateUrlKey("To Convertxx xx"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code .*?\W.*?42}.
   *   <li>Then return {@code w42}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenW42_thenReturnW42() {
    // Arrange, Act and Assert
    assertEquals("w42", UrlUtil.generateUrlKey(".*?\\W.*?42"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code [^\w-]+42}.
   *   <li>Then return {@code w-42}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenW42_thenReturnW422() {
    // Arrange, Act and Assert
    assertEquals("w-42", UrlUtil.generateUrlKey("[^\\w-]+42"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code [^\w-]+https://example.org/example}.
   *   <li>Then return {@code w-httpsexampleorgexample}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenWHttpsExampleOrgExample_thenReturnWHttpsexampleorgexample() {
    // Arrange, Act and Assert
    assertEquals(
        "w-httpsexampleorgexample", UrlUtil.generateUrlKey("[^\\w-]+https://example.org/example"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code .*?\W.*?https://example.org/example}.
   *   <li>Then return {@code whttpsexampleorgexample}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenWHttpsExampleOrgExample_thenReturnWhttpsexampleorgexample() {
    // Arrange, Act and Assert
    assertEquals(
        "whttpsexampleorgexample", UrlUtil.generateUrlKey(".*?\\W.*?https://example.org/example"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code .*?\W.*?Redirect}.
   *   <li>Then return {@code wRedirect}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenWRedirect_thenReturnWRedirect() {
    // Arrange, Act and Assert
    assertEquals("wRedirect", UrlUtil.generateUrlKey(".*?\\W.*?Redirect"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code [^\w-]+Redirect}.
   *   <li>Then return {@code w-Redirect}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenWRedirect_thenReturnWRedirect2() {
    // Arrange, Act and Assert
    assertEquals("w-Redirect", UrlUtil.generateUrlKey("[^\\w-]+Redirect"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code .*?\W.*?To Convert}.
   *   <li>Then return {@code wTo-Convert}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenWToConvert_thenReturnWToConvert() {
    // Arrange, Act and Assert
    assertEquals("wTo-Convert", UrlUtil.generateUrlKey(".*?\\W.*?To Convert"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code [^\w-]+To Convert}.
   *   <li>Then return {@code w-To-Convert}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenWToConvert_thenReturnWToConvert2() {
    // Arrange, Act and Assert
    assertEquals("w-To-Convert", UrlUtil.generateUrlKey("[^\\w-]+To Convert"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code .*?\W.*?.*?\W.*?}.
   *   <li>Then return {@code wW}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenWW_thenReturnWW() {
    // Arrange, Act and Assert
    assertEquals("wW", UrlUtil.generateUrlKey(".*?\\W.*?.*?\\W.*?"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code [^\w-]+.*?\W.*?}.
   *   <li>Then return {@code w-W}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenWW_thenReturnWW2() {
    // Arrange, Act and Assert
    assertEquals("w-W", UrlUtil.generateUrlKey("[^\\w-]+.*?\\W.*?"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code [^\w-]+[^\w-]+}.
   *   <li>Then return {@code w-w-}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenWW_thenReturnWW3() {
    // Arrange, Act and Assert
    assertEquals("w-w-", UrlUtil.generateUrlKey("[^\\w-]+[^\\w-]+"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code .*?\W.*?[^\w-]+}.
   *   <li>Then return {@code ww-}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenWW_thenReturnWw() {
    // Arrange, Act and Assert
    assertEquals("ww-", UrlUtil.generateUrlKey(".*?\\W.*?[^\\w-]+"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code [^\w-]+xx xx}.
   *   <li>Then return {@code w-xx-xx}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenWXxXx_thenReturnWXxXx() {
    // Arrange, Act and Assert
    assertEquals("w-xx-xx", UrlUtil.generateUrlKey("[^\\w-]+xx xx"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code .*?\W.*?xx xx}.
   *   <li>Then return {@code wxx-xx}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenWXxXx_thenReturnWxxXx() {
    // Arrange, Act and Assert
    assertEquals("wxx-xx", UrlUtil.generateUrlKey(".*?\\W.*?xx xx"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code .*?\W.*?}.
   *   <li>Then return {@code w}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenW_thenReturnW() {
    // Arrange, Act and Assert
    assertEquals("w", UrlUtil.generateUrlKey(".*?\\W.*?"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code [^\w-]+}.
   *   <li>Then return {@code w-}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenW_thenReturnW2() {
    // Arrange, Act and Assert
    assertEquals("w-", UrlUtil.generateUrlKey("[^\\w-]+"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code .*?\W.*?}.
   *   <li>Then return {@code -W}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenW_thenReturnW3() {
    // Arrange, Act and Assert
    assertEquals("-W", UrlUtil.generateUrlKey(" .*?\\W.*?"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code [^\w-]+}.
   *   <li>Then return {@code -w-}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenW_thenReturnW4() {
    // Arrange, Act and Assert
    assertEquals("-w-", UrlUtil.generateUrlKey(" [^\\w-]+"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code .*?\W.*?-}.
   *   <li>Then return {@code w-}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenW_thenReturnW5() {
    // Arrange, Act and Assert
    assertEquals("w-", UrlUtil.generateUrlKey(".*?\\W.*?-"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code .*?\W.*?/}.
   *   <li>Then return {@code w}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenW_thenReturnW6() {
    // Arrange, Act and Assert
    assertEquals("w", UrlUtil.generateUrlKey(".*?\\W.*?/"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code .*?\W.*?//}.
   *   <li>Then return {@code w}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenW_thenReturnW7() {
    // Arrange, Act and Assert
    assertEquals("w", UrlUtil.generateUrlKey(".*?\\W.*?//"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code .*?\W.*?}.
   *   <li>Then return {@code ---W}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenW_thenReturnW8() {
    // Arrange, Act and Assert
    assertEquals("---W", UrlUtil.generateUrlKey("   .*?\\W.*?"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code .*?\W.*?:}.
   *   <li>Then return {@code w}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenW_thenReturnW9() {
    // Arrange, Act and Assert
    assertEquals("w", UrlUtil.generateUrlKey(".*?\\W.*?:"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code [^\w-]+}.
   *   <li>Then return {@code ---w-}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenW_thenReturnW10() {
    // Arrange, Act and Assert
    assertEquals("---w-", UrlUtil.generateUrlKey("   [^\\w-]+"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code /.*?\W.*?}.
   *   <li>Then return {@code w}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenW_thenReturnW11() {
    // Arrange, Act and Assert
    assertEquals("w", UrlUtil.generateUrlKey("/.*?\\W.*?"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code //.*?\W.*?}.
   *   <li>Then return {@code w}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenW_thenReturnW12() {
    // Arrange, Act and Assert
    assertEquals("w", UrlUtil.generateUrlKey("//.*?\\W.*?"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code .*?\W.*?}.
   *   <li>Then return {@code w-}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenW_thenReturnW13() {
    // Arrange, Act and Assert
    assertEquals("w-", UrlUtil.generateUrlKey(".*?\\W.*? "));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code .*?\W.*?}.
   *   <li>Then return {@code w---}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenW_thenReturnW14() {
    // Arrange, Act and Assert
    assertEquals("w---", UrlUtil.generateUrlKey(".*?\\W.*?   "));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code :.*?\W.*?}.
   *   <li>Then return {@code w}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenW_thenReturnW15() {
    // Arrange, Act and Assert
    assertEquals("w", UrlUtil.generateUrlKey(":.*?\\W.*?"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code [^\w-]+}.
   *   <li>Then return {@code w--}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenW_thenReturnW16() {
    // Arrange, Act and Assert
    assertEquals("w--", UrlUtil.generateUrlKey("[^\\w-]+ "));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code [^\w-]+}.
   *   <li>Then return {@code w----}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenW_thenReturnW17() {
    // Arrange, Act and Assert
    assertEquals("w----", UrlUtil.generateUrlKey("[^\\w-]+   "));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code [^\w-]+/}.
   *   <li>Then return {@code w-}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenW_thenReturnW18() {
    // Arrange, Act and Assert
    assertEquals("w-", UrlUtil.generateUrlKey("[^\\w-]+/"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code [^\w-]+//}.
   *   <li>Then return {@code w-}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenW_thenReturnW19() {
    // Arrange, Act and Assert
    assertEquals("w-", UrlUtil.generateUrlKey("[^\\w-]+//"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code [^\w-]+:}.
   *   <li>Then return {@code w-}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenW_thenReturnW20() {
    // Arrange, Act and Assert
    assertEquals("w-", UrlUtil.generateUrlKey("[^\\w-]+:"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code /[^\w-]+}.
   *   <li>Then return {@code w-}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenW_thenReturnW21() {
    // Arrange, Act and Assert
    assertEquals("w-", UrlUtil.generateUrlKey("/[^\\w-]+"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code //[^\w-]+}.
   *   <li>Then return {@code w-}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenW_thenReturnW22() {
    // Arrange, Act and Assert
    assertEquals("w-", UrlUtil.generateUrlKey("//[^\\w-]+"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code :[^\w-]+}.
   *   <li>Then return {@code w-}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenW_thenReturnW23() {
    // Arrange, Act and Assert
    assertEquals("w-", UrlUtil.generateUrlKey(":[^\\w-]+"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code xx xx42}.
   *   <li>Then return {@code xx-xx42}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenXxXx42_thenReturnXxXx42() {
    // Arrange, Act and Assert
    assertEquals("xx-xx42", UrlUtil.generateUrlKey("xx xx42"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code xx xxRedirect}.
   *   <li>Then return {@code xx-xxRedirect}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenXxXxRedirect_thenReturnXxXxRedirect() {
    // Arrange, Act and Assert
    assertEquals("xx-xxRedirect", UrlUtil.generateUrlKey("xx xxRedirect"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code xx xxTo Convert}.
   *   <li>Then return {@code xx-xxTo-Convert}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenXxXxToConvert_thenReturnXxXxToConvert() {
    // Arrange, Act and Assert
    assertEquals("xx-xxTo-Convert", UrlUtil.generateUrlKey("xx xxTo Convert"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code xx xx.*?\W.*?}.
   *   <li>Then return {@code xx-xxW}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenXxXxW_thenReturnXxXxW() {
    // Arrange, Act and Assert
    assertEquals("xx-xxW", UrlUtil.generateUrlKey("xx xx.*?\\W.*?"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code xx xx[^\w-]+}.
   *   <li>Then return {@code xx-xxw-}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenXxXxW_thenReturnXxXxw() {
    // Arrange, Act and Assert
    assertEquals("xx-xxw-", UrlUtil.generateUrlKey("xx xx[^\\w-]+"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code xx xx}.
   *   <li>Then return {@code xx-xx}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenXxXx_thenReturnXxXx() {
    // Arrange, Act and Assert
    assertEquals("xx-xx", UrlUtil.generateUrlKey("xx xx"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code xx xx}.
   *   <li>Then return {@code -xx-xx}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenXxXx_thenReturnXxXx2() {
    // Arrange, Act and Assert
    assertEquals("-xx-xx", UrlUtil.generateUrlKey(" xx xx"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code xx xx}.
   *   <li>Then return {@code xx-xx-}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenXxXx_thenReturnXxXx3() {
    // Arrange, Act and Assert
    assertEquals("xx-xx-", UrlUtil.generateUrlKey("xx xx "));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code xx xx}.
   *   <li>Then return {@code xx-xx---}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenXxXx_thenReturnXxXx4() {
    // Arrange, Act and Assert
    assertEquals("xx-xx---", UrlUtil.generateUrlKey("xx xx   "));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code xx xx-}.
   *   <li>Then return {@code xx-xx-}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenXxXx_thenReturnXxXx5() {
    // Arrange, Act and Assert
    assertEquals("xx-xx-", UrlUtil.generateUrlKey("xx xx-"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code xx xx/}.
   *   <li>Then return {@code xx-xx}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenXxXx_thenReturnXxXx6() {
    // Arrange, Act and Assert
    assertEquals("xx-xx", UrlUtil.generateUrlKey("xx xx/"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code xx xx//}.
   *   <li>Then return {@code xx-xx}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenXxXx_thenReturnXxXx7() {
    // Arrange, Act and Assert
    assertEquals("xx-xx", UrlUtil.generateUrlKey("xx xx//"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code xx xx:}.
   *   <li>Then return {@code xx-xx}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenXxXx_thenReturnXxXx8() {
    // Arrange, Act and Assert
    assertEquals("xx-xx", UrlUtil.generateUrlKey("xx xx:"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code xx xx}.
   *   <li>Then return {@code ---xx-xx}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenXxXx_thenReturnXxXx9() {
    // Arrange, Act and Assert
    assertEquals("---xx-xx", UrlUtil.generateUrlKey("   xx xx"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code -xx xx}.
   *   <li>Then return {@code -xx-xx}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenXxXx_thenReturnXxXx10() {
    // Arrange, Act and Assert
    assertEquals("-xx-xx", UrlUtil.generateUrlKey("-xx xx"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code /xx xx}.
   *   <li>Then return {@code xx-xx}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenXxXx_thenReturnXxXx11() {
    // Arrange, Act and Assert
    assertEquals("xx-xx", UrlUtil.generateUrlKey("/xx xx"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code //xx xx}.
   *   <li>Then return {@code xx-xx}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenXxXx_thenReturnXxXx12() {
    // Arrange, Act and Assert
    assertEquals("xx-xx", UrlUtil.generateUrlKey("//xx xx"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code :xx xx}.
   *   <li>Then return {@code xx-xx}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenXxXx_thenReturnXxXx13() {
    // Arrange, Act and Assert
    assertEquals("xx-xx", UrlUtil.generateUrlKey(":xx xx"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   *
   * <ul>
   *   <li>When {@code xx xxxx xx}.
   *   <li>Then return {@code xx-xxxx-xx}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenXxXxxxXx_thenReturnXxXxxxXx() {
    // Arrange, Act and Assert
    assertEquals("xx-xxxx-xx", UrlUtil.generateUrlKey("xx xxxx xx"));
  }

  /**
   * Test {@link UrlUtil#fixRedirectUrl(String, String)}.
   *
   * <ul>
   *   <li>Then return {@code https://example.org/example/Url}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#fixRedirectUrl(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.fixRedirectUrl(String, String)"})
  public void testFixRedirectUrl_thenReturnHttpsExampleOrgExampleUrl() {
    // Arrange, Act and Assert
    assertEquals(
        "https://example.org/example/Url",
        UrlUtil.fixRedirectUrl("https://example.org/example", "Url"));
  }

  /**
   * Test {@link UrlUtil#fixRedirectUrl(String, String)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return {@code /}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#fixRedirectUrl(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.fixRedirectUrl(String, String)"})
  public void testFixRedirectUrl_whenEmptyString_thenReturnSlash() {
    // Arrange, Act and Assert
    assertEquals("/", UrlUtil.fixRedirectUrl("", "/"));
  }

  /**
   * Test {@link UrlUtil#fixRedirectUrl(String, String)}.
   *
   * <ul>
   *   <li>When {@code https://example.org/example}.
   *   <li>Then return {@code https://example.org/example}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#fixRedirectUrl(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.fixRedirectUrl(String, String)"})
  public void testFixRedirectUrl_whenHttpsExampleOrgExample_thenReturnHttpsExampleOrgExample() {
    // Arrange, Act and Assert
    assertEquals(
        "https://example.org/example",
        UrlUtil.fixRedirectUrl("https://example.org/example", "https://example.org/example"));
  }

  /**
   * Test {@link UrlUtil#fixRedirectUrl(String, String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code /}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#fixRedirectUrl(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.fixRedirectUrl(String, String)"})
  public void testFixRedirectUrl_whenNull_thenReturnSlash() {
    // Arrange, Act and Assert
    assertEquals("/", UrlUtil.fixRedirectUrl(null, "/"));
  }

  /**
   * Test {@link UrlUtil#fixRedirectUrl(String, String)}.
   *
   * <ul>
   *   <li>When space space.
   *   <li>Then return {@code /}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#fixRedirectUrl(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.fixRedirectUrl(String, String)"})
  public void testFixRedirectUrl_whenSpaceSpace_thenReturnSlash() {
    // Arrange, Act and Assert
    assertEquals("  /", UrlUtil.fixRedirectUrl("  ", "/"));
  }

  /**
   * Test {@link UrlUtil#fixRedirectUrl(String, String)}.
   *
   * <ul>
   *   <li>When {@code Url}.
   *   <li>Then return {@code /Url}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#fixRedirectUrl(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtil.fixRedirectUrl(String, String)"})
  public void testFixRedirectUrl_whenUrl_thenReturnUrl() {
    // Arrange, Act and Assert
    assertEquals("/Url", UrlUtil.fixRedirectUrl("/", "Url"));
  }

  /**
   * Test {@link UrlUtil#isAbsoluteUrl(String)}.
   *
   * <p>Method under test: {@link UrlUtil#isAbsoluteUrl(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean UrlUtil.isAbsoluteUrl(String)"})
  public void testIsAbsoluteUrl() {
    // Arrange, Act and Assert
    assertFalse(
        UrlUtil.isAbsoluteUrl("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789+.-"));
  }

  /**
   * Test {@link UrlUtil#isAbsoluteUrl(String)}.
   *
   * <ul>
   *   <li>When {@code https://example.org/example}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#isAbsoluteUrl(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean UrlUtil.isAbsoluteUrl(String)"})
  public void testIsAbsoluteUrl_whenHttpsExampleOrgExample_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(UrlUtil.isAbsoluteUrl("https://example.org/example"));
  }

  /**
   * Test {@link UrlUtil#isAbsoluteUrl(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#isAbsoluteUrl(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean UrlUtil.isAbsoluteUrl(String)"})
  public void testIsAbsoluteUrl_whenNull_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(UrlUtil.isAbsoluteUrl(null));
  }

  /**
   * Test {@link UrlUtil#isAbsoluteUrl(String)}.
   *
   * <ul>
   *   <li>When {@code .*?\W.*?https://example.org/example}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtil#isAbsoluteUrl(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean UrlUtil.isAbsoluteUrl(String)"})
  public void testIsAbsoluteUrl_whenWHttpsExampleOrgExample_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(UrlUtil.isAbsoluteUrl(".*?\\W.*?https://example.org/example"));
  }
}
