/*-
 * #%L
 * BroadleafCommerce Common Libraries
 * %%
 * Copyright (C) 2009 - 2025 Broadleaf Commerce
 * %%
 * Licensed under the Broadleaf Fair Use License Agreement, Version 1.0
 * (the "Fair Use License" located  at http://license.broadleafcommerce.org/fair_use_license-1.0.txt)
 * unless the restrictions on use therein are violated and require payment to Broadleaf in which case
 * the Broadleaf End User License Agreement (EULA), Version 1.1
 * (the "Commercial License" located at http://license.broadleafcommerce.org/commercial_license-1.1.txt)
 * shall apply.
 * 
 * Alternatively, the Commercial License may be replaced with a mutually agreed upon license (the "Custom License")
 * between you and Broadleaf Commerce. You may not use this file except in compliance with the applicable license.
 * #L%
 */
package org.broadleafcommerce.common.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class UrlUtilDiffblueTest {
  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   * <p>
   * Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey() {
    // Arrange, Act and Assert
    assertEquals("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789-",
        UrlUtil.generateUrlKey("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789+.-"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   * <p>
   * Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey2() {
    // Arrange, Act and Assert
    assertEquals("httpsexampleorgexampleabcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789-",
        UrlUtil.generateUrlKey(
            "https://example.org/exampleabcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789+.-"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   * <p>
   * Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey3() {
    // Arrange, Act and Assert
    assertEquals("to-ConvertabcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789-",
        UrlUtil.generateUrlKey("To ConvertabcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789+.-"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   * <p>
   * Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey4() {
    // Arrange, Act and Assert
    assertEquals("-abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789-",
        UrlUtil.generateUrlKey(" abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789+.-"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   * <p>
   * Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey5() {
    // Arrange, Act and Assert
    assertEquals("42abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789-",
        UrlUtil.generateUrlKey("42abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789+.-"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   * <p>
   * Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey6() {
    // Arrange, Act and Assert
    assertEquals("uU-UUabcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789-",
        UrlUtil.generateUrlKey("UU UUabcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789+.-"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   * <p>
   * Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey7() {
    // Arrange, Act and Assert
    assertEquals("wabcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789-",
        UrlUtil.generateUrlKey(".*?\\W.*?abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789+.-"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   * <p>
   * Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey8() {
    // Arrange, Act and Assert
    assertEquals("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789-",
        UrlUtil.generateUrlKey("/abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789+.-"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   * <p>
   * Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey9() {
    // Arrange, Act and Assert
    assertEquals("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789-",
        UrlUtil.generateUrlKey("//abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789+.-"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   * <p>
   * Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey10() {
    // Arrange, Act and Assert
    assertEquals("w-abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789-",
        UrlUtil.generateUrlKey("[^\\w-]+abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789+.-"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   * <p>
   * Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey11() {
    // Arrange, Act and Assert
    assertEquals("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789-",
        UrlUtil.generateUrlKey(":abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789+.-"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   * <p>
   * Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey12() {
    // Arrange, Act and Assert
    assertEquals("redirectabcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789-",
        UrlUtil.generateUrlKey("RedirectabcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789+.-"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   * <p>
   * Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey13() {
    // Arrange, Act and Assert
    assertEquals("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789-httpsexampleorgexample",
        UrlUtil.generateUrlKey(
            "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789+.-https://example.org/example"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   * <p>
   * Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey14() {
    // Arrange, Act and Assert
    assertEquals("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789-To-Convert",
        UrlUtil.generateUrlKey("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789+.-To Convert"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   * <p>
   * Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey15() {
    // Arrange, Act and Assert
    assertEquals("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789-42",
        UrlUtil.generateUrlKey("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789+.-42"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   * <p>
   * Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey16() {
    // Arrange, Act and Assert
    assertEquals("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789--",
        UrlUtil.generateUrlKey("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789+.--"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   * <p>
   * Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey17() {
    // Arrange, Act and Assert
    assertEquals("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789-W",
        UrlUtil.generateUrlKey("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789+.-.*?\\W.*?"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   * <p>
   * Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey18() {
    // Arrange, Act and Assert
    assertEquals("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789-",
        UrlUtil.generateUrlKey("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789+.-/"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   * <p>
   * Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey19() {
    // Arrange, Act and Assert
    assertEquals("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789-",
        UrlUtil.generateUrlKey("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789+.-//"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   * <p>
   * Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey20() {
    // Arrange, Act and Assert
    assertEquals("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789-",
        UrlUtil.generateUrlKey("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789+.-:"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   * <p>
   * Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey21() {
    // Arrange, Act and Assert
    assertEquals("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789-Redirect",
        UrlUtil.generateUrlKey("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789+.-Redirect"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   * <p>
   * Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey22() {
    // Arrange, Act and Assert
    assertEquals("httpsexampleorgexamplehttpsexampleorgexamplehttpsexampleorgexample",
        UrlUtil.generateUrlKey("https://example.org/examplehttps://example.org/examplehttps://example.org/example"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   * <p>
   * Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey23() {
    // Arrange, Act and Assert
    assertEquals("httpsexampleorgexamplehttpsexampleorgexampleTo-Convert",
        UrlUtil.generateUrlKey("https://example.org/examplehttps://example.org/exampleTo Convert"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   * <p>
   * Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey24() {
    // Arrange, Act and Assert
    assertEquals("httpsexampleorgexamplehttpsexampleorgexampleRedirect",
        UrlUtil.generateUrlKey("https://example.org/examplehttps://example.org/exampleRedirect"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   * <p>
   * Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey25() {
    // Arrange, Act and Assert
    assertEquals("httpsexampleorgexampleTo-Converthttpsexampleorgexample",
        UrlUtil.generateUrlKey("https://example.org/exampleTo Converthttps://example.org/example"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   * <p>
   * Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey26() {
    // Arrange, Act and Assert
    assertEquals("httpsexampleorgexampleTo-ConvertabcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789-",
        UrlUtil.generateUrlKey(
            "https://example.org/exampleTo ConvertabcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789"
                + "+.-"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   * <p>
   * Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey27() {
    // Arrange, Act and Assert
    assertEquals("httpsexampleorgexample42abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789-",
        UrlUtil.generateUrlKey(
            "https://example.org/example42abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789+.-"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   * <p>
   * Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey28() {
    // Arrange, Act and Assert
    assertEquals("httpsexampleorgexample-abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789-",
        UrlUtil.generateUrlKey(
            "https://example.org/example-abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789+.-"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   * <p>
   * Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey29() {
    // Arrange, Act and Assert
    assertEquals("httpsexampleorgexampleWabcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789-",
        UrlUtil.generateUrlKey(
            "https://example.org/example.*?\\W.*?abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789+.-"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   * <ul>
   *   <li>Then return {@code 42httpsexampleorgexample}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_thenReturn42httpsexampleorgexample() {
    // Arrange, Act and Assert
    assertEquals("42httpsexampleorgexample", UrlUtil.generateUrlKey("42https://example.org/example"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   * <ul>
   *   <li>Then return {@code httpsexampleorgexample42-}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_thenReturnHttpsexampleorgexample42() {
    // Arrange, Act and Assert
    assertEquals("httpsexampleorgexample42-", UrlUtil.generateUrlKey("https://example.org/example42-"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   * <ul>
   *   <li>Then return {@code httpsexampleorgexample42Redirect}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_thenReturnHttpsexampleorgexample42Redirect() {
    // Arrange, Act and Assert
    assertEquals("httpsexampleorgexample42Redirect", UrlUtil.generateUrlKey("https://example.org/example42Redirect"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   * <ul>
   *   <li>Then return {@code httpsexampleorgexample42To-Convert}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_thenReturnHttpsexampleorgexample42ToConvert() {
    // Arrange, Act and Assert
    assertEquals("httpsexampleorgexample42To-Convert",
        UrlUtil.generateUrlKey("https://example.org/example42To Convert"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   * <ul>
   *   <li>Then return {@code httpsexampleorgexample42W}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_thenReturnHttpsexampleorgexample42W() {
    // Arrange, Act and Assert
    assertEquals("httpsexampleorgexample42W", UrlUtil.generateUrlKey("https://example.org/example42.*?\\W.*?"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   * <ul>
   *   <li>Then return {@code httpsexampleorgexample42httpsexampleorgexample}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_thenReturnHttpsexampleorgexample42httpsexampleorgexample() {
    // Arrange, Act and Assert
    assertEquals("httpsexampleorgexample42httpsexampleorgexample",
        UrlUtil.generateUrlKey("https://example.org/example42https://example.org/example"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   * <ul>
   *   <li>Then return {@code httpsexampleorgexample-42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_thenReturnHttpsexampleorgexample422() {
    // Arrange, Act and Assert
    assertEquals("httpsexampleorgexample-42", UrlUtil.generateUrlKey("https://example.org/example-42"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   * <ul>
   *   <li>Then return {@code httpsexampleorgexample4242}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_thenReturnHttpsexampleorgexample4242() {
    // Arrange, Act and Assert
    assertEquals("httpsexampleorgexample4242", UrlUtil.generateUrlKey("https://example.org/example4242"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   * <ul>
   *   <li>Then return {@code httpsexampleorgexample-httpsexampleorgexample}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_thenReturnHttpsexampleorgexampleHttpsexampleorgexample() {
    // Arrange, Act and Assert
    assertEquals("httpsexampleorgexample-httpsexampleorgexample",
        UrlUtil.generateUrlKey("https://example.org/example-https://example.org/example"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   * <ul>
   *   <li>Then return {@code httpsexampleorgexampleRedirect}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_thenReturnHttpsexampleorgexampleRedirect() {
    // Arrange, Act and Assert
    assertEquals("httpsexampleorgexampleRedirect", UrlUtil.generateUrlKey("https://example.org/exampleRedirect"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   * <ul>
   *   <li>Then return {@code httpsexampleorgexample-Redirect}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_thenReturnHttpsexampleorgexampleRedirect2() {
    // Arrange, Act and Assert
    assertEquals("httpsexampleorgexample-Redirect", UrlUtil.generateUrlKey("https://example.org/example-Redirect"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   * <ul>
   *   <li>Then return {@code httpsexampleorgexampleTo-Convert-}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_thenReturnHttpsexampleorgexampleToConvert() {
    // Arrange, Act and Assert
    assertEquals("httpsexampleorgexampleTo-Convert-", UrlUtil.generateUrlKey("https://example.org/exampleTo Convert-"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   * <ul>
   *   <li>Then return {@code httpsexampleorgexample-To-Convert}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_thenReturnHttpsexampleorgexampleToConvert2() {
    // Arrange, Act and Assert
    assertEquals("httpsexampleorgexample-To-Convert", UrlUtil.generateUrlKey("https://example.org/example-To Convert"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   * <ul>
   *   <li>Then return {@code httpsexampleorgexampleTo-Convert42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_thenReturnHttpsexampleorgexampleToConvert42() {
    // Arrange, Act and Assert
    assertEquals("httpsexampleorgexampleTo-Convert42",
        UrlUtil.generateUrlKey("https://example.org/exampleTo Convert42"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   * <ul>
   *   <li>Then return {@code httpsexampleorgexampleTo-ConvertRedirect}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_thenReturnHttpsexampleorgexampleToConvertRedirect() {
    // Arrange, Act and Assert
    assertEquals("httpsexampleorgexampleTo-ConvertRedirect",
        UrlUtil.generateUrlKey("https://example.org/exampleTo ConvertRedirect"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   * <ul>
   *   <li>Then return {@code httpsexampleorgexampleTo-ConvertTo-Convert}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_thenReturnHttpsexampleorgexampleToConvertToConvert() {
    // Arrange, Act and Assert
    assertEquals("httpsexampleorgexampleTo-ConvertTo-Convert",
        UrlUtil.generateUrlKey("https://example.org/exampleTo ConvertTo Convert"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   * <ul>
   *   <li>Then return {@code httpsexampleorgexampleTo-ConvertW}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_thenReturnHttpsexampleorgexampleToConvertW() {
    // Arrange, Act and Assert
    assertEquals("httpsexampleorgexampleTo-ConvertW",
        UrlUtil.generateUrlKey("https://example.org/exampleTo Convert.*?\\W.*?"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   * <ul>
   *   <li>Then return {@code httpsexampleorgexampleUU-UU}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_thenReturnHttpsexampleorgexampleUUUu() {
    // Arrange, Act and Assert
    assertEquals("httpsexampleorgexampleUU-UU", UrlUtil.generateUrlKey("https://example.org/exampleUU UU"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   * <ul>
   *   <li>Then return {@code httpsexampleorgexampleW42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_thenReturnHttpsexampleorgexampleW42() {
    // Arrange, Act and Assert
    assertEquals("httpsexampleorgexampleW42", UrlUtil.generateUrlKey("https://example.org/example.*?\\W.*?42"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   * <ul>
   *   <li>Then return {@code httpsexampleorgexampleWRedirect}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_thenReturnHttpsexampleorgexampleWRedirect() {
    // Arrange, Act and Assert
    assertEquals("httpsexampleorgexampleWRedirect",
        UrlUtil.generateUrlKey("https://example.org/example.*?\\W.*?Redirect"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   * <ul>
   *   <li>Then return {@code httpsexampleorgexampleWTo-Convert}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_thenReturnHttpsexampleorgexampleWToConvert() {
    // Arrange, Act and Assert
    assertEquals("httpsexampleorgexampleWTo-Convert",
        UrlUtil.generateUrlKey("https://example.org/example.*?\\W.*?To Convert"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   * <ul>
   *   <li>Then return {@code httpsexampleorgexampleWW}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_thenReturnHttpsexampleorgexampleWW() {
    // Arrange, Act and Assert
    assertEquals("httpsexampleorgexampleWW", UrlUtil.generateUrlKey("https://example.org/example.*?\\W.*?.*?\\W.*?"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   * <ul>
   *   <li>Then return {@code httpsexampleorgexampleWhttpsexampleorgexample}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_thenReturnHttpsexampleorgexampleWhttpsexampleorgexample() {
    // Arrange, Act and Assert
    assertEquals("httpsexampleorgexampleWhttpsexampleorgexample",
        UrlUtil.generateUrlKey("https://example.org/example.*?\\W.*?https://example.org/example"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   * <ul>
   *   <li>Then return {@code httpsexampleorgexamplehttpsexampleorgexample-}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_thenReturnHttpsexampleorgexamplehttpsexampleorgexample() {
    // Arrange, Act and Assert
    assertEquals("httpsexampleorgexamplehttpsexampleorgexample-",
        UrlUtil.generateUrlKey("https://example.org/examplehttps://example.org/example-"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   * <ul>
   *   <li>Then return {@code httpsexampleorgexamplehttpsexampleorgexample42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_thenReturnHttpsexampleorgexamplehttpsexampleorgexample42() {
    // Arrange, Act and Assert
    assertEquals("httpsexampleorgexamplehttpsexampleorgexample42",
        UrlUtil.generateUrlKey("https://example.org/examplehttps://example.org/example42"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   * <ul>
   *   <li>Then return {@code httpsexampleorgexamplehttpsexampleorgexampleW}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_thenReturnHttpsexampleorgexamplehttpsexampleorgexampleW() {
    // Arrange, Act and Assert
    assertEquals("httpsexampleorgexamplehttpsexampleorgexampleW",
        UrlUtil.generateUrlKey("https://example.org/examplehttps://example.org/example.*?\\W.*?"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   * <ul>
   *   <li>Then return {@code redirecthttpsexampleorgexample}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_thenReturnRedirecthttpsexampleorgexample() {
    // Arrange, Act and Assert
    assertEquals("redirecthttpsexampleorgexample", UrlUtil.generateUrlKey("Redirecthttps://example.org/example"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   * <ul>
   *   <li>Then return {@code to-Converthttpsexampleorgexample}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_thenReturnToConverthttpsexampleorgexample() {
    // Arrange, Act and Assert
    assertEquals("to-Converthttpsexampleorgexample", UrlUtil.generateUrlKey("To Converthttps://example.org/example"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   * <ul>
   *   <li>Then return {@code uU-UUhttpsexampleorgexample}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_thenReturnUUUUhttpsexampleorgexample() {
    // Arrange, Act and Assert
    assertEquals("uU-UUhttpsexampleorgexample", UrlUtil.generateUrlKey("UU UUhttps://example.org/example"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   * <ul>
   *   <li>When {@code 42To Convert}.</li>
   *   <li>Then return {@code 42To-Convert}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_when42ToConvert_thenReturn42ToConvert() {
    // Arrange, Act and Assert
    assertEquals("42To-Convert", UrlUtil.generateUrlKey("42To Convert"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   * <ul>
   *   <li>When {@code 42.*?\W.*?}.</li>
   *   <li>Then return {@code 42W}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_when42W_thenReturn42w() {
    // Arrange, Act and Assert
    assertEquals("42W", UrlUtil.generateUrlKey("42.*?\\W.*?"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   * <ul>
   *   <li>When {@code 42[^\w-]+}.</li>
   *   <li>Then return {@code 42w-}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_when42W_thenReturn42w2() {
    // Arrange, Act and Assert
    assertEquals("42w-", UrlUtil.generateUrlKey("42[^\\w-]+"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   * <ul>
   *   <li>When {@code 42}.</li>
   *   <li>Then return {@code -42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_when42_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("-42", UrlUtil.generateUrlKey(" 42"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   * <ul>
   *   <li>When {@code 42-}.</li>
   *   <li>Then return {@code 42-}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_when42_thenReturn422() {
    // Arrange, Act and Assert
    assertEquals("42-", UrlUtil.generateUrlKey("42-"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   * <ul>
   *   <li>When {@code 42/}.</li>
   *   <li>Then return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_when42_thenReturn423() {
    // Arrange, Act and Assert
    assertEquals("42", UrlUtil.generateUrlKey("42/"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   * <ul>
   *   <li>When {@code 42//}.</li>
   *   <li>Then return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_when42_thenReturn424() {
    // Arrange, Act and Assert
    assertEquals("42", UrlUtil.generateUrlKey("42//"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   * <ul>
   *   <li>When {@code 42:}.</li>
   *   <li>Then return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_when42_thenReturn425() {
    // Arrange, Act and Assert
    assertEquals("42", UrlUtil.generateUrlKey("42:"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   * <ul>
   *   <li>When {@code /42}.</li>
   *   <li>Then return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_when42_thenReturn426() {
    // Arrange, Act and Assert
    assertEquals("42", UrlUtil.generateUrlKey("/42"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   * <ul>
   *   <li>When {@code //42}.</li>
   *   <li>Then return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_when42_thenReturn427() {
    // Arrange, Act and Assert
    assertEquals("42", UrlUtil.generateUrlKey("//42"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   * <ul>
   *   <li>When {@code :42}.</li>
   *   <li>Then return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_when42_thenReturn428() {
    // Arrange, Act and Assert
    assertEquals("42", UrlUtil.generateUrlKey(":42"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   * <ul>
   *   <li>When {@code 42}.</li>
   *   <li>Then return {@code 42-}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_when42_thenReturn429() {
    // Arrange, Act and Assert
    assertEquals("42-", UrlUtil.generateUrlKey("42 "));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   * <ul>
   *   <li>When {@code 42UU UU}.</li>
   *   <li>Then return {@code 42UU-UU}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_when42uuUu_thenReturn42uuUu() {
    // Arrange, Act and Assert
    assertEquals("42UU-UU", UrlUtil.generateUrlKey("42UU UU"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   * <ul>
   *   <li>When a string.</li>
   *   <li>Then return a string.</li>
   * </ul>
   * <p>
   * Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
   * <ul>
   *   <li>When a string.</li>
   *   <li>Then return a string.</li>
   * </ul>
   * <p>
   * Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
   * <ul>
   *   <li>When {@code ::}.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenColonColon_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", UrlUtil.generateUrlKey("::"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   * <ul>
   *   <li>When {@code :-}.</li>
   *   <li>Then return {@code -}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenColonDash_thenReturnDash() {
    // Arrange, Act and Assert
    assertEquals("-", UrlUtil.generateUrlKey(":-"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   * <ul>
   *   <li>When {@code ://}.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenColonSlashSlash_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", UrlUtil.generateUrlKey("://"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   * <ul>
   *   <li>When {@code :/}.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenColonSlash_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", UrlUtil.generateUrlKey(":/"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   * <ul>
   *   <li>When {@code :}.</li>
   *   <li>Then return {@code -}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenColon_thenReturnDash() {
    // Arrange, Act and Assert
    assertEquals("-", UrlUtil.generateUrlKey(" :"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   * <ul>
   *   <li>When {@code :}.</li>
   *   <li>Then return {@code -}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenColon_thenReturnDash2() {
    // Arrange, Act and Assert
    assertEquals("-", UrlUtil.generateUrlKey(": "));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   * <ul>
   *   <li>When {@code :}.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenColon_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", UrlUtil.generateUrlKey(":"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   * <ul>
   *   <li>When {@code -}.</li>
   *   <li>Then return {@code --}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenDash_thenReturnDashDash() {
    // Arrange, Act and Assert
    assertEquals("--", UrlUtil.generateUrlKey(" -"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   * <ul>
   *   <li>When {@code -}.</li>
   *   <li>Then return {@code --}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenDash_thenReturnDashDash2() {
    // Arrange, Act and Assert
    assertEquals("--", UrlUtil.generateUrlKey("- "));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenEmptyString_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", UrlUtil.generateUrlKey(""));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   * <ul>
   *   <li>When {@code https://example.org/example42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenHttpsExampleOrgExample42() {
    // Arrange, Act and Assert
    assertEquals("httpsexampleorgexample42", UrlUtil.generateUrlKey("https://example.org/example42"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   * <ul>
   *   <li>When {@code https://example.org/example42/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenHttpsExampleOrgExample422() {
    // Arrange, Act and Assert
    assertEquals("httpsexampleorgexample42", UrlUtil.generateUrlKey("https://example.org/example42/"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   * <ul>
   *   <li>When {@code https://example.org/example42//}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenHttpsExampleOrgExample423() {
    // Arrange, Act and Assert
    assertEquals("httpsexampleorgexample42", UrlUtil.generateUrlKey("https://example.org/example42//"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   * <ul>
   *   <li>When {@code https://example.org/example42:}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenHttpsExampleOrgExample424() {
    // Arrange, Act and Assert
    assertEquals("httpsexampleorgexample42", UrlUtil.generateUrlKey("https://example.org/example42:"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   * <ul>
   *   <li>When {@code https://example.org/example/https://example.org/example}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenHttpsExampleOrgExampleHttpsExampleOrgExample() {
    // Arrange, Act and Assert
    assertEquals("httpsexampleorgexamplehttpsexampleorgexample",
        UrlUtil.generateUrlKey("https://example.org/example/https://example.org/example"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   * <ul>
   *   <li>When {@code https://example.org/exampleTo Convert}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenHttpsExampleOrgExampleToConvert() {
    // Arrange, Act and Assert
    assertEquals("httpsexampleorgexampleTo-Convert", UrlUtil.generateUrlKey("https://example.org/exampleTo Convert"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   * <ul>
   *   <li>When {@code https://example.org/exampleTo Convert/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenHttpsExampleOrgExampleToConvert2() {
    // Arrange, Act and Assert
    assertEquals("httpsexampleorgexampleTo-Convert", UrlUtil.generateUrlKey("https://example.org/exampleTo Convert/"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   * <ul>
   *   <li>When {@code https://example.org/exampleTo Convert//}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenHttpsExampleOrgExampleToConvert3() {
    // Arrange, Act and Assert
    assertEquals("httpsexampleorgexampleTo-Convert", UrlUtil.generateUrlKey("https://example.org/exampleTo Convert//"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   * <ul>
   *   <li>When {@code https://example.org/exampleTo Convert:}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenHttpsExampleOrgExampleToConvert4() {
    // Arrange, Act and Assert
    assertEquals("httpsexampleorgexampleTo-Convert", UrlUtil.generateUrlKey("https://example.org/exampleTo Convert:"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   * <ul>
   *   <li>When {@code https://example.org/example/To Convert}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenHttpsExampleOrgExampleToConvert5() {
    // Arrange, Act and Assert
    assertEquals("httpsexampleorgexampleTo-Convert", UrlUtil.generateUrlKey("https://example.org/example/To Convert"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   * <ul>
   *   <li>When {@code https://example.org/example.*?\W.*?}.</li>
   *   <li>Then return {@code httpsexampleorgexampleW}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenHttpsExampleOrgExampleW_thenReturnHttpsexampleorgexampleW() {
    // Arrange, Act and Assert
    assertEquals("httpsexampleorgexampleW", UrlUtil.generateUrlKey("https://example.org/example.*?\\W.*?"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   * <ul>
   *   <li>When {@code https://example.org/example-.*?\W.*?}.</li>
   *   <li>Then return {@code httpsexampleorgexample-W}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenHttpsExampleOrgExampleW_thenReturnHttpsexampleorgexampleW2() {
    // Arrange, Act and Assert
    assertEquals("httpsexampleorgexample-W", UrlUtil.generateUrlKey("https://example.org/example-.*?\\W.*?"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   * <ul>
   *   <li>When {@code https://example.org/example.*?\W.*?-}.</li>
   *   <li>Then return {@code httpsexampleorgexampleW-}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenHttpsExampleOrgExampleW_thenReturnHttpsexampleorgexampleW3() {
    // Arrange, Act and Assert
    assertEquals("httpsexampleorgexampleW-", UrlUtil.generateUrlKey("https://example.org/example.*?\\W.*?-"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   * <ul>
   *   <li>When {@code https://example.org/example.*?\W.*?/}.</li>
   *   <li>Then return {@code httpsexampleorgexampleW}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenHttpsExampleOrgExampleW_thenReturnHttpsexampleorgexampleW4() {
    // Arrange, Act and Assert
    assertEquals("httpsexampleorgexampleW", UrlUtil.generateUrlKey("https://example.org/example.*?\\W.*?/"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   * <ul>
   *   <li>When {@code https://example.org/example.*?\W.*?//}.</li>
   *   <li>Then return {@code httpsexampleorgexampleW}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenHttpsExampleOrgExampleW_thenReturnHttpsexampleorgexampleW5() {
    // Arrange, Act and Assert
    assertEquals("httpsexampleorgexampleW", UrlUtil.generateUrlKey("https://example.org/example.*?\\W.*?//"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   * <ul>
   *   <li>When {@code https://example.org/example.*?\W.*?:}.</li>
   *   <li>Then return {@code httpsexampleorgexampleW}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenHttpsExampleOrgExampleW_thenReturnHttpsexampleorgexampleW6() {
    // Arrange, Act and Assert
    assertEquals("httpsexampleorgexampleW", UrlUtil.generateUrlKey("https://example.org/example.*?\\W.*?:"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   * <ul>
   *   <li>When {@code https://example.org/example[^\w-]+}.</li>
   *   <li>Then return {@code httpsexampleorgexamplew-}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenHttpsExampleOrgExampleW_thenReturnHttpsexampleorgexamplew() {
    // Arrange, Act and Assert
    assertEquals("httpsexampleorgexamplew-", UrlUtil.generateUrlKey("https://example.org/example[^\\w-]+"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   * <ul>
   *   <li>When {@code https://example.org/example}.</li>
   *   <li>Then return {@code httpsexampleorgexample}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenHttpsExampleOrgExample_thenReturnHttpsexampleorgexample() {
    // Arrange, Act and Assert
    assertEquals("httpsexampleorgexample", UrlUtil.generateUrlKey("https://example.org/example"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   * <ul>
   *   <li>When {@code https://example.org/example}.</li>
   *   <li>Then return {@code httpsexampleorgexample-}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenHttpsExampleOrgExample_thenReturnHttpsexampleorgexample2() {
    // Arrange, Act and Assert
    assertEquals("httpsexampleorgexample-", UrlUtil.generateUrlKey("https://example.org/example "));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   * <ul>
   *   <li>When {@code https://example.org/example/}.</li>
   *   <li>Then return {@code httpsexampleorgexample}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenHttpsExampleOrgExample_thenReturnHttpsexampleorgexample3() {
    // Arrange, Act and Assert
    assertEquals("httpsexampleorgexample", UrlUtil.generateUrlKey("https://example.org/example/"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   * <ul>
   *   <li>When {@code https://example.org/example//}.</li>
   *   <li>Then return {@code httpsexampleorgexample}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenHttpsExampleOrgExample_thenReturnHttpsexampleorgexample4() {
    // Arrange, Act and Assert
    assertEquals("httpsexampleorgexample", UrlUtil.generateUrlKey("https://example.org/example//"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   * <ul>
   *   <li>When {@code https://example.org/example:}.</li>
   *   <li>Then return {@code httpsexampleorgexample}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenHttpsExampleOrgExample_thenReturnHttpsexampleorgexample5() {
    // Arrange, Act and Assert
    assertEquals("httpsexampleorgexample", UrlUtil.generateUrlKey("https://example.org/example:"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   * <ul>
   *   <li>When {@code https://example.org/example}.</li>
   *   <li>Then return {@code -httpsexampleorgexample}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenHttpsExampleOrgExample_thenReturnHttpsexampleorgexample6() {
    // Arrange, Act and Assert
    assertEquals("-httpsexampleorgexample", UrlUtil.generateUrlKey(" https://example.org/example"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   * <ul>
   *   <li>When {@code /https://example.org/example}.</li>
   *   <li>Then return {@code httpsexampleorgexample}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenHttpsExampleOrgExample_thenReturnHttpsexampleorgexample7() {
    // Arrange, Act and Assert
    assertEquals("httpsexampleorgexample", UrlUtil.generateUrlKey("/https://example.org/example"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   * <ul>
   *   <li>When {@code //https://example.org/example}.</li>
   *   <li>Then return {@code httpsexampleorgexample}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenHttpsExampleOrgExample_thenReturnHttpsexampleorgexample8() {
    // Arrange, Act and Assert
    assertEquals("httpsexampleorgexample", UrlUtil.generateUrlKey("//https://example.org/example"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   * <ul>
   *   <li>When {@code :https://example.org/example}.</li>
   *   <li>Then return {@code httpsexampleorgexample}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenHttpsExampleOrgExample_thenReturnHttpsexampleorgexample9() {
    // Arrange, Act and Assert
    assertEquals("httpsexampleorgexample", UrlUtil.generateUrlKey(":https://example.org/example"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   * <ul>
   *   <li>When {@code https://example.org/example--}.</li>
   *   <li>Then return {@code httpsexampleorgexample--}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenHttpsExampleOrgExample_thenReturnHttpsexampleorgexample10() {
    // Arrange, Act and Assert
    assertEquals("httpsexampleorgexample--", UrlUtil.generateUrlKey("https://example.org/example--"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   * <ul>
   *   <li>When {@code https://example.org/example-/}.</li>
   *   <li>Then return {@code httpsexampleorgexample-}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenHttpsExampleOrgExample_thenReturnHttpsexampleorgexample11() {
    // Arrange, Act and Assert
    assertEquals("httpsexampleorgexample-", UrlUtil.generateUrlKey("https://example.org/example-/"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   * <ul>
   *   <li>When {@code https://example.org/example-//}.</li>
   *   <li>Then return {@code httpsexampleorgexample-}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenHttpsExampleOrgExample_thenReturnHttpsexampleorgexample12() {
    // Arrange, Act and Assert
    assertEquals("httpsexampleorgexample-", UrlUtil.generateUrlKey("https://example.org/example-//"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   * <ul>
   *   <li>When {@code https://example.org/example-:}.</li>
   *   <li>Then return {@code httpsexampleorgexample-}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenHttpsExampleOrgExample_thenReturnHttpsexampleorgexample13() {
    // Arrange, Act and Assert
    assertEquals("httpsexampleorgexample-", UrlUtil.generateUrlKey("https://example.org/example-:"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   * <ul>
   *   <li>When {@code https://example.org/examplehttps://example.org/example}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenHttpsExampleOrgExamplehttpsExampleOrgExample() {
    // Arrange, Act and Assert
    assertEquals("httpsexampleorgexamplehttpsexampleorgexample",
        UrlUtil.generateUrlKey("https://example.org/examplehttps://example.org/example"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   * <ul>
   *   <li>When {@code https://example.org/examplehttps://example.org/example/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenHttpsExampleOrgExamplehttpsExampleOrgExample2() {
    // Arrange, Act and Assert
    assertEquals("httpsexampleorgexamplehttpsexampleorgexample",
        UrlUtil.generateUrlKey("https://example.org/examplehttps://example.org/example/"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   * <ul>
   *   <li>When {@code https://example.org/examplehttps://example.org/example//}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenHttpsExampleOrgExamplehttpsExampleOrgExample3() {
    // Arrange, Act and Assert
    assertEquals("httpsexampleorgexamplehttpsexampleorgexample",
        UrlUtil.generateUrlKey("https://example.org/examplehttps://example.org/example//"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   * <ul>
   *   <li>When {@code https://example.org/examplehttps://example.org/example:}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenHttpsExampleOrgExamplehttpsExampleOrgExample4() {
    // Arrange, Act and Assert
    assertEquals("httpsexampleorgexamplehttpsexampleorgexample",
        UrlUtil.generateUrlKey("https://example.org/examplehttps://example.org/example:"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(UrlUtil.generateUrlKey(null));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   * <ul>
   *   <li>When {@code RedirectTo Convert}.</li>
   *   <li>Then return {@code redirectTo-Convert}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenRedirectToConvert_thenReturnRedirectToConvert() {
    // Arrange, Act and Assert
    assertEquals("redirectTo-Convert", UrlUtil.generateUrlKey("RedirectTo Convert"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   * <ul>
   *   <li>When {@code RedirectUU UU}.</li>
   *   <li>Then return {@code redirectUU-UU}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenRedirectUUUu_thenReturnRedirectUUUu() {
    // Arrange, Act and Assert
    assertEquals("redirectUU-UU", UrlUtil.generateUrlKey("RedirectUU UU"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   * <ul>
   *   <li>When {@code Redirect.*?\W.*?}.</li>
   *   <li>Then return {@code redirectW}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenRedirectW_thenReturnRedirectW() {
    // Arrange, Act and Assert
    assertEquals("redirectW", UrlUtil.generateUrlKey("Redirect.*?\\W.*?"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   * <ul>
   *   <li>When {@code Redirect[^\w-]+}.</li>
   *   <li>Then return {@code redirectw-}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenRedirectW_thenReturnRedirectw() {
    // Arrange, Act and Assert
    assertEquals("redirectw-", UrlUtil.generateUrlKey("Redirect[^\\w-]+"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   * <ul>
   *   <li>When {@code Redirect}.</li>
   *   <li>Then return {@code -Redirect}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenRedirect_thenReturnRedirect() {
    // Arrange, Act and Assert
    assertEquals("-Redirect", UrlUtil.generateUrlKey(" Redirect"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   * <ul>
   *   <li>When {@code /Redirect}.</li>
   *   <li>Then return {@code redirect}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenRedirect_thenReturnRedirect2() {
    // Arrange, Act and Assert
    assertEquals("redirect", UrlUtil.generateUrlKey("/Redirect"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   * <ul>
   *   <li>When {@code //Redirect}.</li>
   *   <li>Then return {@code redirect}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenRedirect_thenReturnRedirect3() {
    // Arrange, Act and Assert
    assertEquals("redirect", UrlUtil.generateUrlKey("//Redirect"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   * <ul>
   *   <li>When {@code :Redirect}.</li>
   *   <li>Then return {@code redirect}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenRedirect_thenReturnRedirect4() {
    // Arrange, Act and Assert
    assertEquals("redirect", UrlUtil.generateUrlKey(":Redirect"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   * <ul>
   *   <li>When {@code Redirect-}.</li>
   *   <li>Then return {@code redirect-}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenRedirect_thenReturnRedirect5() {
    // Arrange, Act and Assert
    assertEquals("redirect-", UrlUtil.generateUrlKey("Redirect-"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   * <ul>
   *   <li>When {@code Redirect/}.</li>
   *   <li>Then return {@code redirect}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenRedirect_thenReturnRedirect6() {
    // Arrange, Act and Assert
    assertEquals("redirect", UrlUtil.generateUrlKey("Redirect/"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   * <ul>
   *   <li>When {@code Redirect//}.</li>
   *   <li>Then return {@code redirect}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenRedirect_thenReturnRedirect7() {
    // Arrange, Act and Assert
    assertEquals("redirect", UrlUtil.generateUrlKey("Redirect//"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   * <ul>
   *   <li>When {@code Redirect:}.</li>
   *   <li>Then return {@code redirect}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenRedirect_thenReturnRedirect8() {
    // Arrange, Act and Assert
    assertEquals("redirect", UrlUtil.generateUrlKey("Redirect:"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   * <ul>
   *   <li>When {@code Redirect}.</li>
   *   <li>Then return {@code redirect-}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenRedirect_thenReturnRedirect9() {
    // Arrange, Act and Assert
    assertEquals("redirect-", UrlUtil.generateUrlKey("Redirect "));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   * <ul>
   *   <li>When {@code /:}.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenSlashColon_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", UrlUtil.generateUrlKey("/:"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   * <ul>
   *   <li>When {@code /-}.</li>
   *   <li>Then return {@code -}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenSlashDash_thenReturnDash() {
    // Arrange, Act and Assert
    assertEquals("-", UrlUtil.generateUrlKey("/-"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   * <ul>
   *   <li>When {@code //:}.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenSlashSlashColon_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", UrlUtil.generateUrlKey("//:"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   * <ul>
   *   <li>When {@code //-}.</li>
   *   <li>Then return {@code -}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenSlashSlashDash_thenReturnDash() {
    // Arrange, Act and Assert
    assertEquals("-", UrlUtil.generateUrlKey("//-"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   * <ul>
   *   <li>When {@code ////}.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenSlashSlashSlashSlash_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", UrlUtil.generateUrlKey("////"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   * <ul>
   *   <li>When {@code ///}.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenSlashSlashSlash_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", UrlUtil.generateUrlKey("///"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   * <ul>
   *   <li>When {@code //}.</li>
   *   <li>Then return {@code -}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenSlashSlash_thenReturnDash() {
    // Arrange, Act and Assert
    assertEquals("-", UrlUtil.generateUrlKey(" //"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   * <ul>
   *   <li>When {@code //}.</li>
   *   <li>Then return {@code -}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenSlashSlash_thenReturnDash2() {
    // Arrange, Act and Assert
    assertEquals("-", UrlUtil.generateUrlKey("// "));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   * <ul>
   *   <li>When {@code //}.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenSlashSlash_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", UrlUtil.generateUrlKey("//"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   * <ul>
   *   <li>When {@code /}.</li>
   *   <li>Then return {@code -}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenSlash_thenReturnDash() {
    // Arrange, Act and Assert
    assertEquals("-", UrlUtil.generateUrlKey(" /"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   * <ul>
   *   <li>When {@code /}.</li>
   *   <li>Then return {@code -}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenSlash_thenReturnDash2() {
    // Arrange, Act and Assert
    assertEquals("-", UrlUtil.generateUrlKey("/ "));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   * <ul>
   *   <li>When {@code /}.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenSlash_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", UrlUtil.generateUrlKey("/"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   * <ul>
   *   <li>When space space.</li>
   *   <li>Then return {@code --}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenSpaceSpace_thenReturnDashDash() {
    // Arrange, Act and Assert
    assertEquals("--", UrlUtil.generateUrlKey("  "));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   * <ul>
   *   <li>When space.</li>
   *   <li>Then return {@code -}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenSpace_thenReturnDash() {
    // Arrange, Act and Assert
    assertEquals("-", UrlUtil.generateUrlKey(" "));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   * <ul>
   *   <li>When {@code To Convert42}.</li>
   *   <li>Then return {@code to-Convert42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenToConvert42_thenReturnToConvert42() {
    // Arrange, Act and Assert
    assertEquals("to-Convert42", UrlUtil.generateUrlKey("To Convert42"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   * <ul>
   *   <li>When {@code To ConvertRedirect}.</li>
   *   <li>Then return {@code to-ConvertRedirect}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenToConvertRedirect_thenReturnToConvertRedirect() {
    // Arrange, Act and Assert
    assertEquals("to-ConvertRedirect", UrlUtil.generateUrlKey("To ConvertRedirect"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   * <ul>
   *   <li>When {@code To ConvertTo Convert}.</li>
   *   <li>Then return {@code to-ConvertTo-Convert}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenToConvertToConvert_thenReturnToConvertToConvert() {
    // Arrange, Act and Assert
    assertEquals("to-ConvertTo-Convert", UrlUtil.generateUrlKey("To ConvertTo Convert"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   * <ul>
   *   <li>When {@code To ConvertUU UU}.</li>
   *   <li>Then return {@code to-ConvertUU-UU}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenToConvertUUUu_thenReturnToConvertUUUu() {
    // Arrange, Act and Assert
    assertEquals("to-ConvertUU-UU", UrlUtil.generateUrlKey("To ConvertUU UU"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   * <ul>
   *   <li>When {@code To Convert.*?\W.*?}.</li>
   *   <li>Then return {@code to-ConvertW}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenToConvertW_thenReturnToConvertW() {
    // Arrange, Act and Assert
    assertEquals("to-ConvertW", UrlUtil.generateUrlKey("To Convert.*?\\W.*?"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   * <ul>
   *   <li>When {@code To Convert[^\w-]+}.</li>
   *   <li>Then return {@code to-Convertw-}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenToConvertW_thenReturnToConvertw() {
    // Arrange, Act and Assert
    assertEquals("to-Convertw-", UrlUtil.generateUrlKey("To Convert[^\\w-]+"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   * <ul>
   *   <li>When {@code To Convert}.</li>
   *   <li>Then return {@code to-Convert}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenToConvert_thenReturnToConvert() {
    // Arrange, Act and Assert
    assertEquals("to-Convert", UrlUtil.generateUrlKey("To Convert"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   * <ul>
   *   <li>When {@code To Convert-}.</li>
   *   <li>Then return {@code to-Convert-}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenToConvert_thenReturnToConvert2() {
    // Arrange, Act and Assert
    assertEquals("to-Convert-", UrlUtil.generateUrlKey("To Convert-"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   * <ul>
   *   <li>When {@code To Convert/}.</li>
   *   <li>Then return {@code to-Convert}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenToConvert_thenReturnToConvert3() {
    // Arrange, Act and Assert
    assertEquals("to-Convert", UrlUtil.generateUrlKey("To Convert/"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   * <ul>
   *   <li>When {@code To Convert//}.</li>
   *   <li>Then return {@code to-Convert}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenToConvert_thenReturnToConvert4() {
    // Arrange, Act and Assert
    assertEquals("to-Convert", UrlUtil.generateUrlKey("To Convert//"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   * <ul>
   *   <li>When {@code To Convert:}.</li>
   *   <li>Then return {@code to-Convert}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenToConvert_thenReturnToConvert5() {
    // Arrange, Act and Assert
    assertEquals("to-Convert", UrlUtil.generateUrlKey("To Convert:"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   * <ul>
   *   <li>When {@code To Convert}.</li>
   *   <li>Then return {@code -To-Convert}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenToConvert_thenReturnToConvert6() {
    // Arrange, Act and Assert
    assertEquals("-To-Convert", UrlUtil.generateUrlKey(" To Convert"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   * <ul>
   *   <li>When {@code -To Convert}.</li>
   *   <li>Then return {@code -To-Convert}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenToConvert_thenReturnToConvert7() {
    // Arrange, Act and Assert
    assertEquals("-To-Convert", UrlUtil.generateUrlKey("-To Convert"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   * <ul>
   *   <li>When {@code /To Convert}.</li>
   *   <li>Then return {@code to-Convert}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenToConvert_thenReturnToConvert8() {
    // Arrange, Act and Assert
    assertEquals("to-Convert", UrlUtil.generateUrlKey("/To Convert"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   * <ul>
   *   <li>When {@code //To Convert}.</li>
   *   <li>Then return {@code to-Convert}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenToConvert_thenReturnToConvert9() {
    // Arrange, Act and Assert
    assertEquals("to-Convert", UrlUtil.generateUrlKey("//To Convert"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   * <ul>
   *   <li>When {@code :To Convert}.</li>
   *   <li>Then return {@code to-Convert}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenToConvert_thenReturnToConvert10() {
    // Arrange, Act and Assert
    assertEquals("to-Convert", UrlUtil.generateUrlKey(":To Convert"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   * <ul>
   *   <li>When {@code To Convert}.</li>
   *   <li>Then return {@code to-Convert-}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenToConvert_thenReturnToConvert11() {
    // Arrange, Act and Assert
    assertEquals("to-Convert-", UrlUtil.generateUrlKey("To Convert "));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   * <ul>
   *   <li>When {@code UU UURedirect}.</li>
   *   <li>Then return {@code uU-UURedirect}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenUuUURedirect_thenReturnUUUURedirect() {
    // Arrange, Act and Assert
    assertEquals("uU-UURedirect", UrlUtil.generateUrlKey("UU UURedirect"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   * <ul>
   *   <li>When {@code UU UUTo Convert}.</li>
   *   <li>Then return {@code uU-UUTo-Convert}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenUuUUToConvert_thenReturnUUUUToConvert() {
    // Arrange, Act and Assert
    assertEquals("uU-UUTo-Convert", UrlUtil.generateUrlKey("UU UUTo Convert"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   * <ul>
   *   <li>When {@code UU UU42}.</li>
   *   <li>Then return {@code uU-UU42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenUuUu42_thenReturnUUUu42() {
    // Arrange, Act and Assert
    assertEquals("uU-UU42", UrlUtil.generateUrlKey("UU UU42"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   * <ul>
   *   <li>When {@code UU UU[^\w-]+}.</li>
   *   <li>Then return {@code uU-UUw-}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenUuUuW_thenReturnUUUUw() {
    // Arrange, Act and Assert
    assertEquals("uU-UUw-", UrlUtil.generateUrlKey("UU UU[^\\w-]+"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   * <ul>
   *   <li>When {@code UU UU.*?\W.*?}.</li>
   *   <li>Then return {@code uU-UUW}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenUuUuW_thenReturnUUUuw() {
    // Arrange, Act and Assert
    assertEquals("uU-UUW", UrlUtil.generateUrlKey("UU UU.*?\\W.*?"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   * <ul>
   *   <li>When {@code UU UU}.</li>
   *   <li>Then return {@code uU-UU}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenUuUu_thenReturnUUUu() {
    // Arrange, Act and Assert
    assertEquals("uU-UU", UrlUtil.generateUrlKey("UU UU"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   * <ul>
   *   <li>When {@code UU UU}.</li>
   *   <li>Then return {@code uU-UU-}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenUuUu_thenReturnUUUu2() {
    // Arrange, Act and Assert
    assertEquals("uU-UU-", UrlUtil.generateUrlKey("UU UU "));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   * <ul>
   *   <li>When {@code UU UU-}.</li>
   *   <li>Then return {@code uU-UU-}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenUuUu_thenReturnUUUu3() {
    // Arrange, Act and Assert
    assertEquals("uU-UU-", UrlUtil.generateUrlKey("UU UU-"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   * <ul>
   *   <li>When {@code UU UU/}.</li>
   *   <li>Then return {@code uU-UU}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenUuUu_thenReturnUUUu4() {
    // Arrange, Act and Assert
    assertEquals("uU-UU", UrlUtil.generateUrlKey("UU UU/"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   * <ul>
   *   <li>When {@code UU UU//}.</li>
   *   <li>Then return {@code uU-UU}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenUuUu_thenReturnUUUu5() {
    // Arrange, Act and Assert
    assertEquals("uU-UU", UrlUtil.generateUrlKey("UU UU//"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   * <ul>
   *   <li>When {@code UU UU:}.</li>
   *   <li>Then return {@code uU-UU}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenUuUu_thenReturnUUUu6() {
    // Arrange, Act and Assert
    assertEquals("uU-UU", UrlUtil.generateUrlKey("UU UU:"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   * <ul>
   *   <li>When {@code /UU UU}.</li>
   *   <li>Then return {@code uU-UU}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenUuUu_thenReturnUUUu7() {
    // Arrange, Act and Assert
    assertEquals("uU-UU", UrlUtil.generateUrlKey("/UU UU"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   * <ul>
   *   <li>When {@code //UU UU}.</li>
   *   <li>Then return {@code uU-UU}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenUuUu_thenReturnUUUu8() {
    // Arrange, Act and Assert
    assertEquals("uU-UU", UrlUtil.generateUrlKey("//UU UU"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   * <ul>
   *   <li>When {@code :UU UU}.</li>
   *   <li>Then return {@code uU-UU}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenUuUu_thenReturnUUUu9() {
    // Arrange, Act and Assert
    assertEquals("uU-UU", UrlUtil.generateUrlKey(":UU UU"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   * <ul>
   *   <li>When {@code UU UU}.</li>
   *   <li>Then return {@code -UU-UU}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenUuUu_thenReturnUuUu() {
    // Arrange, Act and Assert
    assertEquals("-UU-UU", UrlUtil.generateUrlKey(" UU UU"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   * <ul>
   *   <li>When {@code -UU UU}.</li>
   *   <li>Then return {@code -UU-UU}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenUuUu_thenReturnUuUu2() {
    // Arrange, Act and Assert
    assertEquals("-UU-UU", UrlUtil.generateUrlKey("-UU UU"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   * <ul>
   *   <li>When {@code UU UUUU UU}.</li>
   *   <li>Then return {@code uU-UUUU-UU}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenUuUuuuUu_thenReturnUUUuuuUu() {
    // Arrange, Act and Assert
    assertEquals("uU-UUUU-UU", UrlUtil.generateUrlKey("UU UUUU UU"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   * <ul>
   *   <li>When {@code .*?\W.*?42}.</li>
   *   <li>Then return {@code w42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenW42_thenReturnW42() {
    // Arrange, Act and Assert
    assertEquals("w42", UrlUtil.generateUrlKey(".*?\\W.*?42"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   * <ul>
   *   <li>When {@code [^\w-]+42}.</li>
   *   <li>Then return {@code w-42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenW42_thenReturnW422() {
    // Arrange, Act and Assert
    assertEquals("w-42", UrlUtil.generateUrlKey("[^\\w-]+42"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   * <ul>
   *   <li>When {@code [^\w-]+https://example.org/example}.</li>
   *   <li>Then return {@code w-httpsexampleorgexample}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenWHttpsExampleOrgExample_thenReturnWHttpsexampleorgexample() {
    // Arrange, Act and Assert
    assertEquals("w-httpsexampleorgexample", UrlUtil.generateUrlKey("[^\\w-]+https://example.org/example"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   * <ul>
   *   <li>When {@code .*?\W.*?https://example.org/example}.</li>
   *   <li>Then return {@code whttpsexampleorgexample}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenWHttpsExampleOrgExample_thenReturnWhttpsexampleorgexample() {
    // Arrange, Act and Assert
    assertEquals("whttpsexampleorgexample", UrlUtil.generateUrlKey(".*?\\W.*?https://example.org/example"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   * <ul>
   *   <li>When {@code .*?\W.*?Redirect}.</li>
   *   <li>Then return {@code wRedirect}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenWRedirect_thenReturnWRedirect() {
    // Arrange, Act and Assert
    assertEquals("wRedirect", UrlUtil.generateUrlKey(".*?\\W.*?Redirect"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   * <ul>
   *   <li>When {@code [^\w-]+Redirect}.</li>
   *   <li>Then return {@code w-Redirect}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenWRedirect_thenReturnWRedirect2() {
    // Arrange, Act and Assert
    assertEquals("w-Redirect", UrlUtil.generateUrlKey("[^\\w-]+Redirect"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   * <ul>
   *   <li>When {@code .*?\W.*?To Convert}.</li>
   *   <li>Then return {@code wTo-Convert}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenWToConvert_thenReturnWToConvert() {
    // Arrange, Act and Assert
    assertEquals("wTo-Convert", UrlUtil.generateUrlKey(".*?\\W.*?To Convert"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   * <ul>
   *   <li>When {@code [^\w-]+To Convert}.</li>
   *   <li>Then return {@code w-To-Convert}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenWToConvert_thenReturnWToConvert2() {
    // Arrange, Act and Assert
    assertEquals("w-To-Convert", UrlUtil.generateUrlKey("[^\\w-]+To Convert"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   * <ul>
   *   <li>When {@code .*?\W.*?UU UU}.</li>
   *   <li>Then return {@code wUU-UU}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenWUuUu_thenReturnWUUUu() {
    // Arrange, Act and Assert
    assertEquals("wUU-UU", UrlUtil.generateUrlKey(".*?\\W.*?UU UU"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   * <ul>
   *   <li>When {@code [^\w-]+UU UU}.</li>
   *   <li>Then return {@code w-UU-UU}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenWUuUu_thenReturnWUuUu() {
    // Arrange, Act and Assert
    assertEquals("w-UU-UU", UrlUtil.generateUrlKey("[^\\w-]+UU UU"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   * <ul>
   *   <li>When {@code .*?\W.*?.*?\W.*?}.</li>
   *   <li>Then return {@code wW}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenWW_thenReturnWW() {
    // Arrange, Act and Assert
    assertEquals("wW", UrlUtil.generateUrlKey(".*?\\W.*?.*?\\W.*?"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   * <ul>
   *   <li>When {@code [^\w-]+.*?\W.*?}.</li>
   *   <li>Then return {@code w-W}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenWW_thenReturnWW2() {
    // Arrange, Act and Assert
    assertEquals("w-W", UrlUtil.generateUrlKey("[^\\w-]+.*?\\W.*?"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   * <ul>
   *   <li>When {@code [^\w-]+[^\w-]+}.</li>
   *   <li>Then return {@code w-w-}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenWW_thenReturnWW3() {
    // Arrange, Act and Assert
    assertEquals("w-w-", UrlUtil.generateUrlKey("[^\\w-]+[^\\w-]+"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   * <ul>
   *   <li>When {@code .*?\W.*?[^\w-]+}.</li>
   *   <li>Then return {@code ww-}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenWW_thenReturnWw() {
    // Arrange, Act and Assert
    assertEquals("ww-", UrlUtil.generateUrlKey(".*?\\W.*?[^\\w-]+"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   * <ul>
   *   <li>When {@code .*?\W.*?}.</li>
   *   <li>Then return {@code w}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenW_thenReturnW() {
    // Arrange, Act and Assert
    assertEquals("w", UrlUtil.generateUrlKey(".*?\\W.*?"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   * <ul>
   *   <li>When {@code [^\w-]+}.</li>
   *   <li>Then return {@code w-}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenW_thenReturnW2() {
    // Arrange, Act and Assert
    assertEquals("w-", UrlUtil.generateUrlKey("[^\\w-]+"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   * <ul>
   *   <li>When {@code .*?\W.*?}.</li>
   *   <li>Then return {@code -W}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenW_thenReturnW3() {
    // Arrange, Act and Assert
    assertEquals("-W", UrlUtil.generateUrlKey(" .*?\\W.*?"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   * <ul>
   *   <li>When {@code [^\w-]+}.</li>
   *   <li>Then return {@code -w-}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenW_thenReturnW4() {
    // Arrange, Act and Assert
    assertEquals("-w-", UrlUtil.generateUrlKey(" [^\\w-]+"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   * <ul>
   *   <li>When {@code .*?\W.*?-}.</li>
   *   <li>Then return {@code w-}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenW_thenReturnW5() {
    // Arrange, Act and Assert
    assertEquals("w-", UrlUtil.generateUrlKey(".*?\\W.*?-"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   * <ul>
   *   <li>When {@code .*?\W.*?/}.</li>
   *   <li>Then return {@code w}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenW_thenReturnW6() {
    // Arrange, Act and Assert
    assertEquals("w", UrlUtil.generateUrlKey(".*?\\W.*?/"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   * <ul>
   *   <li>When {@code .*?\W.*?//}.</li>
   *   <li>Then return {@code w}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenW_thenReturnW7() {
    // Arrange, Act and Assert
    assertEquals("w", UrlUtil.generateUrlKey(".*?\\W.*?//"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   * <ul>
   *   <li>When {@code .*?\W.*?:}.</li>
   *   <li>Then return {@code w}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenW_thenReturnW8() {
    // Arrange, Act and Assert
    assertEquals("w", UrlUtil.generateUrlKey(".*?\\W.*?:"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   * <ul>
   *   <li>When {@code .*?\W.*?}.</li>
   *   <li>Then return {@code w-}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenW_thenReturnW9() {
    // Arrange, Act and Assert
    assertEquals("w-", UrlUtil.generateUrlKey(".*?\\W.*? "));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   * <ul>
   *   <li>When {@code /.*?\W.*?}.</li>
   *   <li>Then return {@code w}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenW_thenReturnW10() {
    // Arrange, Act and Assert
    assertEquals("w", UrlUtil.generateUrlKey("/.*?\\W.*?"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   * <ul>
   *   <li>When {@code //.*?\W.*?}.</li>
   *   <li>Then return {@code w}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenW_thenReturnW11() {
    // Arrange, Act and Assert
    assertEquals("w", UrlUtil.generateUrlKey("//.*?\\W.*?"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   * <ul>
   *   <li>When {@code [^\w-]+}.</li>
   *   <li>Then return {@code w--}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenW_thenReturnW12() {
    // Arrange, Act and Assert
    assertEquals("w--", UrlUtil.generateUrlKey("[^\\w-]+ "));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   * <ul>
   *   <li>When {@code [^\w-]+/}.</li>
   *   <li>Then return {@code w-}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenW_thenReturnW13() {
    // Arrange, Act and Assert
    assertEquals("w-", UrlUtil.generateUrlKey("[^\\w-]+/"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   * <ul>
   *   <li>When {@code [^\w-]+//}.</li>
   *   <li>Then return {@code w-}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenW_thenReturnW14() {
    // Arrange, Act and Assert
    assertEquals("w-", UrlUtil.generateUrlKey("[^\\w-]+//"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   * <ul>
   *   <li>When {@code :.*?\W.*?}.</li>
   *   <li>Then return {@code w}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenW_thenReturnW15() {
    // Arrange, Act and Assert
    assertEquals("w", UrlUtil.generateUrlKey(":.*?\\W.*?"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   * <ul>
   *   <li>When {@code [^\w-]+:}.</li>
   *   <li>Then return {@code w-}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenW_thenReturnW16() {
    // Arrange, Act and Assert
    assertEquals("w-", UrlUtil.generateUrlKey("[^\\w-]+:"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   * <ul>
   *   <li>When {@code /[^\w-]+}.</li>
   *   <li>Then return {@code w-}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenW_thenReturnW17() {
    // Arrange, Act and Assert
    assertEquals("w-", UrlUtil.generateUrlKey("/[^\\w-]+"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   * <ul>
   *   <li>When {@code //[^\w-]+}.</li>
   *   <li>Then return {@code w-}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenW_thenReturnW18() {
    // Arrange, Act and Assert
    assertEquals("w-", UrlUtil.generateUrlKey("//[^\\w-]+"));
  }

  /**
   * Test {@link UrlUtil#generateUrlKey(String)}.
   * <ul>
   *   <li>When {@code :[^\w-]+}.</li>
   *   <li>Then return {@code w-}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlUtil.generateUrlKey(String)"})
  public void testGenerateUrlKey_whenW_thenReturnW19() {
    // Arrange, Act and Assert
    assertEquals("w-", UrlUtil.generateUrlKey(":[^\\w-]+"));
  }

  /**
   * Test {@link UrlUtil#fixRedirectUrl(String, String)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return {@code /}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UrlUtil#fixRedirectUrl(String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlUtil.fixRedirectUrl(String, String)"})
  public void testFixRedirectUrl_whenEmptyString_thenReturnSlash() {
    // Arrange, Act and Assert
    assertEquals("/", UrlUtil.fixRedirectUrl("", "/"));
  }

  /**
   * Test {@link UrlUtil#fixRedirectUrl(String, String)}.
   * <ul>
   *   <li>When {@code https://example.org/example}.</li>
   *   <li>Then return {@code https://example.org/example}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UrlUtil#fixRedirectUrl(String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlUtil.fixRedirectUrl(String, String)"})
  public void testFixRedirectUrl_whenHttpsExampleOrgExample_thenReturnHttpsExampleOrgExample() {
    // Arrange, Act and Assert
    assertEquals("https://example.org/example",
        UrlUtil.fixRedirectUrl("https://example.org/example", "https://example.org/example"));
  }

  /**
   * Test {@link UrlUtil#fixRedirectUrl(String, String)}.
   * <ul>
   *   <li>When {@code https://example.org/example}.</li>
   *   <li>Then return {@code https://example.org/example/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UrlUtil#fixRedirectUrl(String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlUtil.fixRedirectUrl(String, String)"})
  public void testFixRedirectUrl_whenHttpsExampleOrgExample_thenReturnHttpsExampleOrgExample2() {
    // Arrange, Act and Assert
    assertEquals("https://example.org/example/", UrlUtil.fixRedirectUrl("https://example.org/example", "/"));
  }

  /**
   * Test {@link UrlUtil#fixRedirectUrl(String, String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code /}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UrlUtil#fixRedirectUrl(String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlUtil.fixRedirectUrl(String, String)"})
  public void testFixRedirectUrl_whenNull_thenReturnSlash() {
    // Arrange, Act and Assert
    assertEquals("/", UrlUtil.fixRedirectUrl(null, "/"));
  }

  /**
   * Test {@link UrlUtil#fixRedirectUrl(String, String)}.
   * <ul>
   *   <li>When {@code Url}.</li>
   *   <li>Then return {@code https://example.org/example/Url}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UrlUtil#fixRedirectUrl(String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlUtil.fixRedirectUrl(String, String)"})
  public void testFixRedirectUrl_whenUrl_thenReturnHttpsExampleOrgExampleUrl() {
    // Arrange, Act and Assert
    assertEquals("https://example.org/example/Url", UrlUtil.fixRedirectUrl("https://example.org/example", "Url"));
  }

  /**
   * Test {@link UrlUtil#fixRedirectUrl(String, String)}.
   * <ul>
   *   <li>When {@code Url}.</li>
   *   <li>Then return {@code /Url}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UrlUtil#fixRedirectUrl(String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlUtil.fixRedirectUrl(String, String)"})
  public void testFixRedirectUrl_whenUrl_thenReturnUrl() {
    // Arrange, Act and Assert
    assertEquals("/Url", UrlUtil.fixRedirectUrl("/", "Url"));
  }

  /**
   * Test {@link UrlUtil#isAbsoluteUrl(String)}.
   * <p>
   * Method under test: {@link UrlUtil#isAbsoluteUrl(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean UrlUtil.isAbsoluteUrl(String)"})
  public void testIsAbsoluteUrl() {
    // Arrange, Act and Assert
    assertFalse(UrlUtil.isAbsoluteUrl("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789+.-"));
  }

  /**
   * Test {@link UrlUtil#isAbsoluteUrl(String)}.
   * <ul>
   *   <li>When {@code https://example.org/example}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UrlUtil#isAbsoluteUrl(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean UrlUtil.isAbsoluteUrl(String)"})
  public void testIsAbsoluteUrl_whenHttpsExampleOrgExample_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(UrlUtil.isAbsoluteUrl("https://example.org/example"));
  }

  /**
   * Test {@link UrlUtil#isAbsoluteUrl(String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UrlUtil#isAbsoluteUrl(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean UrlUtil.isAbsoluteUrl(String)"})
  public void testIsAbsoluteUrl_whenNull_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(UrlUtil.isAbsoluteUrl(null));
  }

  /**
   * Test {@link UrlUtil#isAbsoluteUrl(String)}.
   * <ul>
   *   <li>When {@code .*?\W.*?https://example.org/example}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UrlUtil#isAbsoluteUrl(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean UrlUtil.isAbsoluteUrl(String)"})
  public void testIsAbsoluteUrl_whenWHttpsExampleOrgExample_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(UrlUtil.isAbsoluteUrl(".*?\\W.*?https://example.org/example"));
  }
}
