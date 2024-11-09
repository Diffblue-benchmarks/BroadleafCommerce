/*-
 * #%L
 * BroadleafCommerce Common Libraries
 * %%
 * Copyright (C) 2009 - 2024 Broadleaf Commerce
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
import java.util.HashMap;
import java.util.Map;
import org.junit.Test;

public class StringUtilDiffblueTest {
  /**
   * Test {@link StringUtil#getChecksum(String)}.
   * <p>
   * Method under test: {@link StringUtil#getChecksum(String)}
   */
  @Test
  public void testGetChecksum() {
    // Arrange, Act and Assert
    assertEquals(64815521L, StringUtil.getChecksum("Test"));
  }

  /**
   * Test {@link StringUtil#segmentInclusion(String, String)}.
   * <ul>
   *   <li>When {@code Bigger}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#segmentInclusion(String, String)}
   */
  @Test
  public void testSegmentInclusion_whenBigger_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(StringUtil.segmentInclusion("Bigger", "Included"));
    assertFalse(StringUtil.segmentInclusion("Bigger", ""));
  }

  /**
   * Test {@link StringUtil#segmentInclusion(String, String)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#segmentInclusion(String, String)}
   */
  @Test
  public void testSegmentInclusion_whenEmptyString_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(StringUtil.segmentInclusion("", "Included"));
  }

  /**
   * Test {@link StringUtil#segmentInclusion(String, String)}.
   * <ul>
   *   <li>When {@code Included}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#segmentInclusion(String, String)}
   */
  @Test
  public void testSegmentInclusion_whenIncluded_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(StringUtil.segmentInclusion("Included", "Included"));
  }

  /**
   * Test {@link StringUtil#determineSimilarity(String, String)}.
   * <ul>
   *   <li>When space.</li>
   *   <li>Then return {@code 4.771044099999999E7}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#determineSimilarity(String, String)}
   */
  @Test
  public void testDetermineSimilarity_whenSpace_thenReturn4771044099999999e7() {
    // Arrange, Act and Assert
    assertEquals(4.771044099999999E7d, StringUtil.determineSimilarity(" ", "Test2"), 0.0);
  }

  /**
   * Test {@link StringUtil#determineSimilarity(String, String)}.
   * <ul>
   *   <li>When {@code [ \t\n\r\f\v\/'-]}.</li>
   *   <li>Then return {@code 2.4985641500000006E8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#determineSimilarity(String, String)}
   */
  @Test
  public void testDetermineSimilarity_whenTNRFV_thenReturn24985641500000006e8() {
    // Arrange, Act and Assert
    assertEquals(2.4985641500000006E8d, StringUtil.determineSimilarity("[ \\t\\n\\r\\f\\v\\/'-]", "Test2"), 0.0);
  }

  /**
   * Test {@link StringUtil#determineSimilarity(String, String)}.
   * <ul>
   *   <li>When {@code Test1}.</li>
   *   <li>Then return {@code 32768.49999618536}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#determineSimilarity(String, String)}
   */
  @Test
  public void testDetermineSimilarity_whenTest1_thenReturn3276849999618536() {
    // Arrange, Act and Assert
    assertEquals(32768.49999618536d, StringUtil.determineSimilarity("Test1", "Test2"), 0.0);
  }

  /**
   * Test {@link StringUtil#cleanseUrlString(String)}.
   * <p>
   * Method under test: {@link StringUtil#cleanseUrlString(String)}
   */
  @Test
  public void testCleanseUrlString() {
    // Arrange, Act and Assert
    assertEquals("https://example.org/exampleorg.broadleafcommerce.common.util.StringUtil",
        StringUtil.cleanseUrlString("https://example.org/example org.broadleafcommerce.common.util.StringUtil"));
    assertEquals("https://example.org/example[\\r\\n]org.broadleafcommerce.common.util.StringUtil", StringUtil
        .cleanseUrlString("https://example.org/example[ \\r\\n]org.broadleafcommerce.common.util.StringUtil"));
    assertEquals("https://example.org/exampleorg.broadleafcommerce.common.util.StringUtil",
        StringUtil.cleanseUrlString("https://example.org/exampleorg.broadleafcommerce.common.util.StringUtil "));
    assertEquals("https://example.org/exampleorg.broadleafcommerce.common.util.StringUtil[\\r\\n]", StringUtil
        .cleanseUrlString("https://example.org/exampleorg.broadleafcommerce.common.util.StringUtil[ \\r\\n]"));
    assertEquals("https://example.org/exampleorg.broadleafcommerce.common.util.StringUtil",
        StringUtil.cleanseUrlString(" https://example.org/exampleorg.broadleafcommerce.common.util.StringUtil"));
  }

  /**
   * Test {@link StringUtil#cleanseUrlString(String)}.
   * <ul>
   *   <li>Then return {@code https://example.org/example42[\r\n]}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#cleanseUrlString(String)}
   */
  @Test
  public void testCleanseUrlString_thenReturnHttpsExampleOrgExample42RN() {
    // Arrange, Act and Assert
    assertEquals("https://example.org/example42[\\r\\n]",
        StringUtil.cleanseUrlString("https://example.org/example42[ \\r\\n]"));
  }

  /**
   * Test {@link StringUtil#cleanseUrlString(String)}.
   * <ul>
   *   <li>Then return {@code https://example.org/exampleInput[\r\n]}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#cleanseUrlString(String)}
   */
  @Test
  public void testCleanseUrlString_thenReturnHttpsExampleOrgExampleInputRN() {
    // Arrange, Act and Assert
    assertEquals("https://example.org/exampleInput[\\r\\n]",
        StringUtil.cleanseUrlString("https://example.org/exampleInput[ \\r\\n]"));
  }

  /**
   * Test {@link StringUtil#cleanseUrlString(String)}.
   * <ul>
   *   <li>Then return {@code https://example.org/example[\r\n].}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#cleanseUrlString(String)}
   */
  @Test
  public void testCleanseUrlString_thenReturnHttpsExampleOrgExampleRN() {
    // Arrange, Act and Assert
    assertEquals("https://example.org/example[\\r\\n].",
        StringUtil.cleanseUrlString("https://example.org/example[ \\r\\n]."));
    assertEquals("https://example.org/example[\\r\\n]{",
        StringUtil.cleanseUrlString("https://example.org/example[ \\r\\n]{"));
    assertEquals("https://example.org/example.[\\r\\n]",
        StringUtil.cleanseUrlString("https://example.org/example.[ \\r\\n]"));
    assertEquals("https://example.org/example{[\\r\\n]",
        StringUtil.cleanseUrlString("https://example.org/example{[ \\r\\n]"));
  }

  /**
   * Test {@link StringUtil#cleanseUrlString(String)}.
   * <ul>
   *   <li>Then return {@code https://example.org/example[\r\n]42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#cleanseUrlString(String)}
   */
  @Test
  public void testCleanseUrlString_thenReturnHttpsExampleOrgExampleRN42() {
    // Arrange, Act and Assert
    assertEquals("https://example.org/example[\\r\\n]42",
        StringUtil.cleanseUrlString("https://example.org/example[ \\r\\n]42"));
  }

  /**
   * Test {@link StringUtil#cleanseUrlString(String)}.
   * <ul>
   *   <li>Then return
   * {@code https://example.org/example[\r\n]https://example.org/example}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#cleanseUrlString(String)}
   */
  @Test
  public void testCleanseUrlString_thenReturnHttpsExampleOrgExampleRNHttpsExampleOrgExample() {
    // Arrange, Act and Assert
    assertEquals("https://example.org/example[\\r\\n]https://example.org/example",
        StringUtil.cleanseUrlString("https://example.org/example[ \\r\\n]https://example.org/example"));
  }

  /**
   * Test {@link StringUtil#cleanseUrlString(String)}.
   * <ul>
   *   <li>Then return {@code https://example.org/example[\r\n]Input}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#cleanseUrlString(String)}
   */
  @Test
  public void testCleanseUrlString_thenReturnHttpsExampleOrgExampleRNInput() {
    // Arrange, Act and Assert
    assertEquals("https://example.org/example[\\r\\n]Input",
        StringUtil.cleanseUrlString("https://example.org/example[ \\r\\n]Input"));
  }

  /**
   * Test {@link StringUtil#cleanseUrlString(String)}.
   * <ul>
   *   <li>Then return
   * {@code https://example.org/example[\r\n]java.lang.Boolean}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#cleanseUrlString(String)}
   */
  @Test
  public void testCleanseUrlString_thenReturnHttpsExampleOrgExampleRNJavaLangBoolean() {
    // Arrange, Act and Assert
    assertEquals("https://example.org/example[\\r\\n]java.lang.Boolean",
        StringUtil.cleanseUrlString("https://example.org/example[ \\r\\n]java.lang.Boolean"));
  }

  /**
   * Test {@link StringUtil#cleanseUrlString(String)}.
   * <ul>
   *   <li>Then return
   * {@code https://example.org/example[\r\n]java.util.Map$Entry}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#cleanseUrlString(String)}
   */
  @Test
  public void testCleanseUrlString_thenReturnHttpsExampleOrgExampleRNJavaUtilMapEntry() {
    // Arrange, Act and Assert
    assertEquals("https://example.org/example[\\r\\n]java.util.Map$Entry",
        StringUtil.cleanseUrlString("https://example.org/example[ \\r\\n]java.util.Map$Entry"));
  }

  /**
   * Test {@link StringUtil#cleanseUrlString(String)}.
   * <ul>
   *   <li>Then return {@code https://example.org/example[\r\n]null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#cleanseUrlString(String)}
   */
  @Test
  public void testCleanseUrlString_thenReturnHttpsExampleOrgExampleRNNull() {
    // Arrange, Act and Assert
    assertEquals("https://example.org/example[\\r\\n]null",
        StringUtil.cleanseUrlString("https://example.org/example[ \\r\\n]null"));
  }

  /**
   * Test {@link StringUtil#cleanseUrlString(String)}.
   * <ul>
   *   <li>Then return {@code https://example.org/example[\r\n][\r\n]}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#cleanseUrlString(String)}
   */
  @Test
  public void testCleanseUrlString_thenReturnHttpsExampleOrgExampleRNRN() {
    // Arrange, Act and Assert
    assertEquals("https://example.org/example[\\r\\n][\\r\\n]",
        StringUtil.cleanseUrlString("https://example.org/example[ \\r\\n][ \\r\\n]"));
  }

  /**
   * Test {@link StringUtil#cleanseUrlString(String)}.
   * <ul>
   *   <li>Then return {@code https://example.org/example[\r\n]UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#cleanseUrlString(String)}
   */
  @Test
  public void testCleanseUrlString_thenReturnHttpsExampleOrgExampleRNUtf8() {
    // Arrange, Act and Assert
    assertEquals("https://example.org/example[\\r\\n]UTF-8",
        StringUtil.cleanseUrlString("https://example.org/example[ \\r\\n]UTF-8"));
  }

  /**
   * Test {@link StringUtil#cleanseUrlString(String)}.
   * <ul>
   *   <li>Then return {@code https://example.org/exampleUTF-8[\r\n]}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#cleanseUrlString(String)}
   */
  @Test
  public void testCleanseUrlString_thenReturnHttpsExampleOrgExampleUTF8RN() {
    // Arrange, Act and Assert
    assertEquals("https://example.org/exampleUTF-8[\\r\\n]",
        StringUtil.cleanseUrlString("https://example.org/exampleUTF-8[ \\r\\n]"));
  }

  /**
   * Test {@link StringUtil#cleanseUrlString(String)}.
   * <ul>
   *   <li>Then return
   * {@code https://example.org/examplehttps://example.org/example[\r\n]}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#cleanseUrlString(String)}
   */
  @Test
  public void testCleanseUrlString_thenReturnHttpsExampleOrgExamplehttpsExampleOrgExampleRN() {
    // Arrange, Act and Assert
    assertEquals("https://example.org/examplehttps://example.org/example[\\r\\n]",
        StringUtil.cleanseUrlString("https://example.org/examplehttps://example.org/example[ \\r\\n]"));
  }

  /**
   * Test {@link StringUtil#cleanseUrlString(String)}.
   * <ul>
   *   <li>Then return
   * {@code https://example.org/examplejava.lang.Boolean[\r\n]}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#cleanseUrlString(String)}
   */
  @Test
  public void testCleanseUrlString_thenReturnHttpsExampleOrgExamplejavaLangBooleanRN() {
    // Arrange, Act and Assert
    assertEquals("https://example.org/examplejava.lang.Boolean[\\r\\n]",
        StringUtil.cleanseUrlString("https://example.org/examplejava.lang.Boolean[ \\r\\n]"));
  }

  /**
   * Test {@link StringUtil#cleanseUrlString(String)}.
   * <ul>
   *   <li>Then return
   * {@code https://example.org/examplejava.util.Map$Entry[\r\n]}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#cleanseUrlString(String)}
   */
  @Test
  public void testCleanseUrlString_thenReturnHttpsExampleOrgExamplejavaUtilMapEntryRN() {
    // Arrange, Act and Assert
    assertEquals("https://example.org/examplejava.util.Map$Entry[\\r\\n]",
        StringUtil.cleanseUrlString("https://example.org/examplejava.util.Map$Entry[ \\r\\n]"));
  }

  /**
   * Test {@link StringUtil#cleanseUrlString(String)}.
   * <ul>
   *   <li>Then return {@code https://example.org/examplenull[\r\n]}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#cleanseUrlString(String)}
   */
  @Test
  public void testCleanseUrlString_thenReturnHttpsExampleOrgExamplenullRN() {
    // Arrange, Act and Assert
    assertEquals("https://example.org/examplenull[\\r\\n]",
        StringUtil.cleanseUrlString("https://example.org/examplenull[ \\r\\n]"));
  }

  /**
   * Test {@link StringUtil#cleanseUrlString(String)}.
   * <ul>
   *   <li>Then return {@code org.broadleafcommerce.common.util.StringUtil}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#cleanseUrlString(String)}
   */
  @Test
  public void testCleanseUrlString_thenReturnOrgBroadleafcommerceCommonUtilStringUtil() {
    // Arrange, Act and Assert
    assertEquals("org.broadleafcommerce.common.util.StringUtil",
        StringUtil.cleanseUrlString(" org.broadleafcommerce.common.util.StringUtil"));
    assertEquals("org.broadleafcommerce.common.util.StringUtil",
        StringUtil.cleanseUrlString("org.broadleafcommerce.common.util.StringUtil "));
  }

  /**
   * Test {@link StringUtil#cleanseUrlString(String)}.
   * <ul>
   *   <li>Then return
   * {@code org.broadleafcommerce.common.util.StringUtil[\r\n]}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#cleanseUrlString(String)}
   */
  @Test
  public void testCleanseUrlString_thenReturnOrgBroadleafcommerceCommonUtilStringUtilRN() {
    // Arrange, Act and Assert
    assertEquals("org.broadleafcommerce.common.util.StringUtil[\\r\\n]",
        StringUtil.cleanseUrlString("org.broadleafcommerce.common.util.StringUtil[ \\r\\n]"));
  }

  /**
   * Test {@link StringUtil#cleanseUrlString(String)}.
   * <ul>
   *   <li>Then return {@code [\r\n]https://example.org/example}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#cleanseUrlString(String)}
   */
  @Test
  public void testCleanseUrlString_thenReturnRNHttpsExampleOrgExample() {
    // Arrange, Act and Assert
    assertEquals("[\\r\\n]https://example.org/example",
        StringUtil.cleanseUrlString("[ \\r\\n]https://example.org/example"));
  }

  /**
   * Test {@link StringUtil#cleanseUrlString(String)}.
   * <ul>
   *   <li>Then return
   * {@code [\r\n]org.broadleafcommerce.common.util.StringUtil}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#cleanseUrlString(String)}
   */
  @Test
  public void testCleanseUrlString_thenReturnRNOrgBroadleafcommerceCommonUtilStringUtil() {
    // Arrange, Act and Assert
    assertEquals("[\\r\\n]org.broadleafcommerce.common.util.StringUtil",
        StringUtil.cleanseUrlString("[ \\r\\n]org.broadleafcommerce.common.util.StringUtil"));
  }

  /**
   * Test {@link StringUtil#cleanseUrlString(String)}.
   * <ul>
   *   <li>When {@code 42[ \r\n]}.</li>
   *   <li>Then return {@code 42[\r\n]}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#cleanseUrlString(String)}
   */
  @Test
  public void testCleanseUrlString_when42RN_thenReturn42RN() {
    // Arrange, Act and Assert
    assertEquals("42[\\r\\n]", StringUtil.cleanseUrlString("42[ \\r\\n]"));
  }

  /**
   * Test {@link StringUtil#cleanseUrlString(String)}.
   * <ul>
   *   <li>When {@code 42}.</li>
   *   <li>Then return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#cleanseUrlString(String)}
   */
  @Test
  public void testCleanseUrlString_when42_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("42", StringUtil.cleanseUrlString(" 42"));
    assertEquals("42", StringUtil.cleanseUrlString("42 "));
  }

  /**
   * Test {@link StringUtil#cleanseUrlString(String)}.
   * <ul>
   *   <li>When {@code .}.</li>
   *   <li>Then return {@code .}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#cleanseUrlString(String)}
   */
  @Test
  public void testCleanseUrlString_whenDot_thenReturnDot() {
    // Arrange, Act and Assert
    assertEquals(".", StringUtil.cleanseUrlString(" ."));
    assertEquals(".", StringUtil.cleanseUrlString(". "));
  }

  /**
   * Test {@link StringUtil#cleanseUrlString(String)}.
   * <ul>
   *   <li>When {@code https://example.org/example 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#cleanseUrlString(String)}
   */
  @Test
  public void testCleanseUrlString_whenHttpsExampleOrgExample42() {
    // Arrange, Act and Assert
    assertEquals("https://example.org/example42", StringUtil.cleanseUrlString("https://example.org/example 42"));
    assertEquals("https://example.org/example42", StringUtil.cleanseUrlString("https://example.org/example42 "));
    assertEquals("https://example.org/example42", StringUtil.cleanseUrlString(" https://example.org/example42"));
  }

  /**
   * Test {@link StringUtil#cleanseUrlString(String)}.
   * <ul>
   *   <li>When
   * {@code https://example.org/example https://example.org/example}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#cleanseUrlString(String)}
   */
  @Test
  public void testCleanseUrlString_whenHttpsExampleOrgExampleHttpsExampleOrgExample() {
    // Arrange, Act and Assert
    assertEquals("https://example.org/examplehttps://example.org/example",
        StringUtil.cleanseUrlString("https://example.org/example https://example.org/example"));
  }

  /**
   * Test {@link StringUtil#cleanseUrlString(String)}.
   * <ul>
   *   <li>When {@code https://example.org/example Input}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#cleanseUrlString(String)}
   */
  @Test
  public void testCleanseUrlString_whenHttpsExampleOrgExampleInput() {
    // Arrange, Act and Assert
    assertEquals("https://example.org/exampleInput", StringUtil.cleanseUrlString("https://example.org/example Input"));
    assertEquals("https://example.org/exampleInput", StringUtil.cleanseUrlString("https://example.org/exampleInput "));
    assertEquals("https://example.org/exampleInput", StringUtil.cleanseUrlString(" https://example.org/exampleInput"));
  }

  /**
   * Test {@link StringUtil#cleanseUrlString(String)}.
   * <ul>
   *   <li>When {@code https://example.org/example java.lang.Boolean}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#cleanseUrlString(String)}
   */
  @Test
  public void testCleanseUrlString_whenHttpsExampleOrgExampleJavaLangBoolean() {
    // Arrange, Act and Assert
    assertEquals("https://example.org/examplejava.lang.Boolean",
        StringUtil.cleanseUrlString("https://example.org/example java.lang.Boolean"));
  }

  /**
   * Test {@link StringUtil#cleanseUrlString(String)}.
   * <ul>
   *   <li>When {@code https://example.org/example java.util.Map$Entry}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#cleanseUrlString(String)}
   */
  @Test
  public void testCleanseUrlString_whenHttpsExampleOrgExampleJavaUtilMapEntry() {
    // Arrange, Act and Assert
    assertEquals("https://example.org/examplejava.util.Map$Entry",
        StringUtil.cleanseUrlString("https://example.org/example java.util.Map$Entry"));
  }

  /**
   * Test {@link StringUtil#cleanseUrlString(String)}.
   * <ul>
   *   <li>When {@code https://example.org/example null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#cleanseUrlString(String)}
   */
  @Test
  public void testCleanseUrlString_whenHttpsExampleOrgExampleNull() {
    // Arrange, Act and Assert
    assertEquals("https://example.org/examplenull", StringUtil.cleanseUrlString("https://example.org/example null"));
  }

  /**
   * Test {@link StringUtil#cleanseUrlString(String)}.
   * <ul>
   *   <li>When {@code https://example.org/example[ \r\n]}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#cleanseUrlString(String)}
   */
  @Test
  public void testCleanseUrlString_whenHttpsExampleOrgExampleRN() {
    // Arrange, Act and Assert
    assertEquals("https://example.org/example[\\r\\n]",
        StringUtil.cleanseUrlString("https://example.org/example[ \\r\\n]"));
    assertEquals("https://example.org/example[\\r\\n]",
        StringUtil.cleanseUrlString("https://example.org/example [ \\r\\n]"));
    assertEquals("https://example.org/example[\\r\\n]",
        StringUtil.cleanseUrlString("https://example.org/example[ \\r\\n] "));
    assertEquals("https://example.org/example[\\r\\n]",
        StringUtil.cleanseUrlString(" https://example.org/example[ \\r\\n]"));
  }

  /**
   * Test {@link StringUtil#cleanseUrlString(String)}.
   * <ul>
   *   <li>When {@code https://example.org/exampleUTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#cleanseUrlString(String)}
   */
  @Test
  public void testCleanseUrlString_whenHttpsExampleOrgExampleUTF8() {
    // Arrange, Act and Assert
    assertEquals("https://example.org/exampleUTF-8", StringUtil.cleanseUrlString("https://example.org/exampleUTF-8 "));
    assertEquals("https://example.org/exampleUTF-8", StringUtil.cleanseUrlString(" https://example.org/exampleUTF-8"));
  }

  /**
   * Test {@link StringUtil#cleanseUrlString(String)}.
   * <ul>
   *   <li>When {@code https://example.org/example UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#cleanseUrlString(String)}
   */
  @Test
  public void testCleanseUrlString_whenHttpsExampleOrgExampleUtf8() {
    // Arrange, Act and Assert
    assertEquals("https://example.org/exampleUTF-8", StringUtil.cleanseUrlString("https://example.org/example UTF-8"));
  }

  /**
   * Test {@link StringUtil#cleanseUrlString(String)}.
   * <ul>
   *   <li>When {@code https://example.org/example}.</li>
   *   <li>Then return {@code https://example.org/example}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#cleanseUrlString(String)}
   */
  @Test
  public void testCleanseUrlString_whenHttpsExampleOrgExample_thenReturnHttpsExampleOrgExample() {
    // Arrange, Act and Assert
    assertEquals("https://example.org/example", StringUtil.cleanseUrlString("https://example.org/example"));
    assertEquals("https://example.org/example", StringUtil.cleanseUrlString("https://example.org/example "));
    assertEquals("https://example.org/example", StringUtil.cleanseUrlString(" https://example.org/example"));
    assertEquals("https://example.org/example", StringUtil.cleanseUrlString("https://example.org/example  "));
    assertEquals("https://example.org/example.", StringUtil.cleanseUrlString("https://example.org/example ."));
    assertEquals("https://example.org/example{", StringUtil.cleanseUrlString("https://example.org/example {"));
    assertEquals("https://example.org/example.", StringUtil.cleanseUrlString("https://example.org/example. "));
    assertEquals("https://example.org/example{", StringUtil.cleanseUrlString("https://example.org/example{ "));
    assertEquals("https://example.org/example", StringUtil.cleanseUrlString(" https://example.org/example "));
    assertEquals("https://example.org/example.", StringUtil.cleanseUrlString(" https://example.org/example."));
    assertEquals("https://example.org/example{", StringUtil.cleanseUrlString(" https://example.org/example{"));
  }

  /**
   * Test {@link StringUtil#cleanseUrlString(String)}.
   * <ul>
   *   <li>When {@code https://example.org/examplehttps://example.org/example}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#cleanseUrlString(String)}
   */
  @Test
  public void testCleanseUrlString_whenHttpsExampleOrgExamplehttpsExampleOrgExample() {
    // Arrange, Act and Assert
    assertEquals("https://example.org/examplehttps://example.org/example",
        StringUtil.cleanseUrlString("https://example.org/examplehttps://example.org/example "));
    assertEquals("https://example.org/examplehttps://example.org/example",
        StringUtil.cleanseUrlString(" https://example.org/examplehttps://example.org/example"));
  }

  /**
   * Test {@link StringUtil#cleanseUrlString(String)}.
   * <ul>
   *   <li>When {@code https://example.org/examplejava.lang.Boolean}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#cleanseUrlString(String)}
   */
  @Test
  public void testCleanseUrlString_whenHttpsExampleOrgExamplejavaLangBoolean() {
    // Arrange, Act and Assert
    assertEquals("https://example.org/examplejava.lang.Boolean",
        StringUtil.cleanseUrlString("https://example.org/examplejava.lang.Boolean "));
    assertEquals("https://example.org/examplejava.lang.Boolean",
        StringUtil.cleanseUrlString(" https://example.org/examplejava.lang.Boolean"));
  }

  /**
   * Test {@link StringUtil#cleanseUrlString(String)}.
   * <ul>
   *   <li>When {@code https://example.org/examplejava.util.Map$Entry}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#cleanseUrlString(String)}
   */
  @Test
  public void testCleanseUrlString_whenHttpsExampleOrgExamplejavaUtilMapEntry() {
    // Arrange, Act and Assert
    assertEquals("https://example.org/examplejava.util.Map$Entry",
        StringUtil.cleanseUrlString("https://example.org/examplejava.util.Map$Entry "));
    assertEquals("https://example.org/examplejava.util.Map$Entry",
        StringUtil.cleanseUrlString(" https://example.org/examplejava.util.Map$Entry"));
  }

  /**
   * Test {@link StringUtil#cleanseUrlString(String)}.
   * <ul>
   *   <li>When {@code https://example.org/examplenull}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#cleanseUrlString(String)}
   */
  @Test
  public void testCleanseUrlString_whenHttpsExampleOrgExamplenull() {
    // Arrange, Act and Assert
    assertEquals("https://example.org/examplenull", StringUtil.cleanseUrlString("https://example.org/examplenull "));
    assertEquals("https://example.org/examplenull", StringUtil.cleanseUrlString(" https://example.org/examplenull"));
  }

  /**
   * Test {@link StringUtil#cleanseUrlString(String)}.
   * <ul>
   *   <li>When {@code Input[ \r\n]}.</li>
   *   <li>Then return {@code Input[\r\n]}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#cleanseUrlString(String)}
   */
  @Test
  public void testCleanseUrlString_whenInputRN_thenReturnInputRN() {
    // Arrange, Act and Assert
    assertEquals("Input[\\r\\n]", StringUtil.cleanseUrlString("Input[ \\r\\n]"));
  }

  /**
   * Test {@link StringUtil#cleanseUrlString(String)}.
   * <ul>
   *   <li>When {@code Input}.</li>
   *   <li>Then return {@code Input}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#cleanseUrlString(String)}
   */
  @Test
  public void testCleanseUrlString_whenInput_thenReturnInput() {
    // Arrange, Act and Assert
    assertEquals("Input", StringUtil.cleanseUrlString(" Input"));
    assertEquals("Input", StringUtil.cleanseUrlString("Input "));
  }

  /**
   * Test {@link StringUtil#cleanseUrlString(String)}.
   * <ul>
   *   <li>When {@code java.lang.Boolean[ \r\n]}.</li>
   *   <li>Then return {@code java.lang.Boolean[\r\n]}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#cleanseUrlString(String)}
   */
  @Test
  public void testCleanseUrlString_whenJavaLangBooleanRN_thenReturnJavaLangBooleanRN() {
    // Arrange, Act and Assert
    assertEquals("java.lang.Boolean[\\r\\n]", StringUtil.cleanseUrlString("java.lang.Boolean[ \\r\\n]"));
  }

  /**
   * Test {@link StringUtil#cleanseUrlString(String)}.
   * <ul>
   *   <li>When {@code java.lang.Boolean}.</li>
   *   <li>Then return {@code java.lang.Boolean}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#cleanseUrlString(String)}
   */
  @Test
  public void testCleanseUrlString_whenJavaLangBoolean_thenReturnJavaLangBoolean() {
    // Arrange, Act and Assert
    assertEquals("java.lang.Boolean", StringUtil.cleanseUrlString(" java.lang.Boolean"));
    assertEquals("java.lang.Boolean", StringUtil.cleanseUrlString("java.lang.Boolean "));
  }

  /**
   * Test {@link StringUtil#cleanseUrlString(String)}.
   * <ul>
   *   <li>When {@code java.util.Map$Entry[ \r\n]}.</li>
   *   <li>Then return {@code java.util.Map$Entry[\r\n]}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#cleanseUrlString(String)}
   */
  @Test
  public void testCleanseUrlString_whenJavaUtilMapEntryRN_thenReturnJavaUtilMapEntryRN() {
    // Arrange, Act and Assert
    assertEquals("java.util.Map$Entry[\\r\\n]", StringUtil.cleanseUrlString("java.util.Map$Entry[ \\r\\n]"));
  }

  /**
   * Test {@link StringUtil#cleanseUrlString(String)}.
   * <ul>
   *   <li>When {@code java.util.Map$Entry}.</li>
   *   <li>Then return {@code java.util.Map$Entry}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#cleanseUrlString(String)}
   */
  @Test
  public void testCleanseUrlString_whenJavaUtilMapEntry_thenReturnJavaUtilMapEntry() {
    // Arrange, Act and Assert
    assertEquals("java.util.Map$Entry", StringUtil.cleanseUrlString(" java.util.Map$Entry"));
    assertEquals("java.util.Map$Entry", StringUtil.cleanseUrlString("java.util.Map$Entry "));
  }

  /**
   * Test {@link StringUtil#cleanseUrlString(String)}.
   * <ul>
   *   <li>When {@code {}.</li>
   *   <li>Then return {@code {}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#cleanseUrlString(String)}
   */
  @Test
  public void testCleanseUrlString_whenLeftCurlyBracket_thenReturnLeftCurlyBracket() {
    // Arrange, Act and Assert
    assertEquals("{", StringUtil.cleanseUrlString(" {"));
    assertEquals("{", StringUtil.cleanseUrlString("{ "));
  }

  /**
   * Test {@link StringUtil#cleanseUrlString(String)}.
   * <ul>
   *   <li>When {@code null[ \r\n]}.</li>
   *   <li>Then return {@code null[\r\n]}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#cleanseUrlString(String)}
   */
  @Test
  public void testCleanseUrlString_whenNullRN_thenReturnNullRN() {
    // Arrange, Act and Assert
    assertEquals("null[\\r\\n]", StringUtil.cleanseUrlString("null[ \\r\\n]"));
  }

  /**
   * Test {@link StringUtil#cleanseUrlString(String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#cleanseUrlString(String)}
   */
  @Test
  public void testCleanseUrlString_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(StringUtil.cleanseUrlString(null));
    assertEquals("null", StringUtil.cleanseUrlString(" null"));
    assertEquals("null", StringUtil.cleanseUrlString("null "));
  }

  /**
   * Test {@link StringUtil#cleanseUrlString(String)}.
   * <ul>
   *   <li>When {@code [ \r\n]42}.</li>
   *   <li>Then return {@code [\r\n]42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#cleanseUrlString(String)}
   */
  @Test
  public void testCleanseUrlString_whenRN42_thenReturnRN42() {
    // Arrange, Act and Assert
    assertEquals("[\\r\\n]42", StringUtil.cleanseUrlString("[ \\r\\n]42"));
  }

  /**
   * Test {@link StringUtil#cleanseUrlString(String)}.
   * <ul>
   *   <li>When {@code [ \r\n]Input}.</li>
   *   <li>Then return {@code [\r\n]Input}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#cleanseUrlString(String)}
   */
  @Test
  public void testCleanseUrlString_whenRNInput_thenReturnRNInput() {
    // Arrange, Act and Assert
    assertEquals("[\\r\\n]Input", StringUtil.cleanseUrlString("[ \\r\\n]Input"));
  }

  /**
   * Test {@link StringUtil#cleanseUrlString(String)}.
   * <ul>
   *   <li>When {@code [ \r\n]java.lang.Boolean}.</li>
   *   <li>Then return {@code [\r\n]java.lang.Boolean}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#cleanseUrlString(String)}
   */
  @Test
  public void testCleanseUrlString_whenRNJavaLangBoolean_thenReturnRNJavaLangBoolean() {
    // Arrange, Act and Assert
    assertEquals("[\\r\\n]java.lang.Boolean", StringUtil.cleanseUrlString("[ \\r\\n]java.lang.Boolean"));
  }

  /**
   * Test {@link StringUtil#cleanseUrlString(String)}.
   * <ul>
   *   <li>When {@code [ \r\n]java.util.Map$Entry}.</li>
   *   <li>Then return {@code [\r\n]java.util.Map$Entry}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#cleanseUrlString(String)}
   */
  @Test
  public void testCleanseUrlString_whenRNJavaUtilMapEntry_thenReturnRNJavaUtilMapEntry() {
    // Arrange, Act and Assert
    assertEquals("[\\r\\n]java.util.Map$Entry", StringUtil.cleanseUrlString("[ \\r\\n]java.util.Map$Entry"));
  }

  /**
   * Test {@link StringUtil#cleanseUrlString(String)}.
   * <ul>
   *   <li>When {@code [ \r\n]null}.</li>
   *   <li>Then return {@code [\r\n]null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#cleanseUrlString(String)}
   */
  @Test
  public void testCleanseUrlString_whenRNNull_thenReturnRNNull() {
    // Arrange, Act and Assert
    assertEquals("[\\r\\n]null", StringUtil.cleanseUrlString("[ \\r\\n]null"));
  }

  /**
   * Test {@link StringUtil#cleanseUrlString(String)}.
   * <ul>
   *   <li>When {@code [ \r\n][ \r\n]}.</li>
   *   <li>Then return {@code [\r\n][\r\n]}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#cleanseUrlString(String)}
   */
  @Test
  public void testCleanseUrlString_whenRNRN_thenReturnRNRN() {
    // Arrange, Act and Assert
    assertEquals("[\\r\\n][\\r\\n]", StringUtil.cleanseUrlString("[ \\r\\n][ \\r\\n]"));
  }

  /**
   * Test {@link StringUtil#cleanseUrlString(String)}.
   * <ul>
   *   <li>When {@code [ \r\n]UTF-8}.</li>
   *   <li>Then return {@code [\r\n]UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#cleanseUrlString(String)}
   */
  @Test
  public void testCleanseUrlString_whenRNUtf8_thenReturnRNUtf8() {
    // Arrange, Act and Assert
    assertEquals("[\\r\\n]UTF-8", StringUtil.cleanseUrlString("[ \\r\\n]UTF-8"));
  }

  /**
   * Test {@link StringUtil#cleanseUrlString(String)}.
   * <ul>
   *   <li>When {@code [ \r\n]}.</li>
   *   <li>Then return {@code [\r\n]}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#cleanseUrlString(String)}
   */
  @Test
  public void testCleanseUrlString_whenRN_thenReturnRN() {
    // Arrange, Act and Assert
    assertEquals("[\\r\\n]", StringUtil.cleanseUrlString("[ \\r\\n]"));
    assertEquals("[\\r\\n]", StringUtil.cleanseUrlString(" [ \\r\\n]"));
    assertEquals("[\\r\\n]", StringUtil.cleanseUrlString("[ \\r\\n] "));
    assertEquals("[\\r\\n].", StringUtil.cleanseUrlString("[ \\r\\n]."));
    assertEquals("[\\r\\n]{", StringUtil.cleanseUrlString("[ \\r\\n]{"));
    assertEquals(".[\\r\\n]", StringUtil.cleanseUrlString(".[ \\r\\n]"));
    assertEquals("{[\\r\\n]", StringUtil.cleanseUrlString("{[ \\r\\n]"));
  }

  /**
   * Test {@link StringUtil#cleanseUrlString(String)}.
   * <ul>
   *   <li>When space space.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#cleanseUrlString(String)}
   */
  @Test
  public void testCleanseUrlString_whenSpaceSpace_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", StringUtil.cleanseUrlString("  "));
  }

  /**
   * Test {@link StringUtil#cleanseUrlString(String)}.
   * <ul>
   *   <li>When space.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#cleanseUrlString(String)}
   */
  @Test
  public void testCleanseUrlString_whenSpace_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", StringUtil.cleanseUrlString(" "));
  }

  /**
   * Test {@link StringUtil#cleanseUrlString(String)}.
   * <ul>
   *   <li>When {@code UTF-8[ \r\n]}.</li>
   *   <li>Then return {@code UTF-8[\r\n]}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#cleanseUrlString(String)}
   */
  @Test
  public void testCleanseUrlString_whenUtf8RN_thenReturnUtf8RN() {
    // Arrange, Act and Assert
    assertEquals("UTF-8[\\r\\n]", StringUtil.cleanseUrlString("UTF-8[ \\r\\n]"));
  }

  /**
   * Test {@link StringUtil#cleanseUrlString(String)}.
   * <ul>
   *   <li>When {@code UTF-8}.</li>
   *   <li>Then return {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#cleanseUrlString(String)}
   */
  @Test
  public void testCleanseUrlString_whenUtf8_thenReturnUtf8() {
    // Arrange, Act and Assert
    assertEquals("UTF-8", StringUtil.cleanseUrlString(" UTF-8"));
    assertEquals("UTF-8", StringUtil.cleanseUrlString("UTF-8 "));
  }

  /**
   * Test {@link StringUtil#decodeUrl(String)}.
   * <ul>
   *   <li>When {@code https://example.org/example}.</li>
   *   <li>Then return {@code https://example.org/example}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#decodeUrl(String)}
   */
  @Test
  public void testDecodeUrl_whenHttpsExampleOrgExample_thenReturnHttpsExampleOrgExample() {
    // Arrange, Act and Assert
    assertEquals("https://example.org/example", StringUtil.decodeUrl("https://example.org/example"));
  }

  /**
   * Test {@link StringUtil#decodeUrl(String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#decodeUrl(String)}
   */
  @Test
  public void testDecodeUrl_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(StringUtil.decodeUrl(null));
  }

  /**
   * Test {@link StringUtil#removeSpecialCharacters(String)}.
   * <p>
   * Method under test: {@link StringUtil#removeSpecialCharacters(String)}
   */
  @Test
  public void testRemoveSpecialCharacters() {
    // Arrange, Act and Assert
    assertEquals("Inputorg.broadleafcommerce.common.util.StringUtil",
        StringUtil.removeSpecialCharacters(" Inputorg.broadleafcommerce.common.util.StringUtil"));
    assertEquals("java.lang.Booleanorg.broadleafcommerce.common.util.StringUtil",
        StringUtil.removeSpecialCharacters(" java.lang.Booleanorg.broadleafcommerce.common.util.StringUtil"));
    assertEquals("java.util.Map$Entryorg.broadleafcommerce.common.util.StringUtil",
        StringUtil.removeSpecialCharacters(" java.util.Map$Entryorg.broadleafcommerce.common.util.StringUtil"));
    assertEquals("nullorg.broadleafcommerce.common.util.StringUtil",
        StringUtil.removeSpecialCharacters(" nullorg.broadleafcommerce.common.util.StringUtil"));
    assertEquals("org.broadleafcommerce.common.util.StringUtilInput",
        StringUtil.removeSpecialCharacters(" org.broadleafcommerce.common.util.StringUtilInput"));
    assertEquals("org.broadleafcommerce.common.util.StringUtiljava.lang.Boolean",
        StringUtil.removeSpecialCharacters(" org.broadleafcommerce.common.util.StringUtiljava.lang.Boolean"));
    assertEquals("org.broadleafcommerce.common.util.StringUtiljava.util.Map$Entry",
        StringUtil.removeSpecialCharacters(" org.broadleafcommerce.common.util.StringUtiljava.util.Map$Entry"));
    assertEquals("org.broadleafcommerce.common.util.StringUtilnull",
        StringUtil.removeSpecialCharacters(" org.broadleafcommerce.common.util.StringUtilnull"));
    assertEquals("org.broadleafcommerce.common.util.StringUtilorg.broadleafcommerce.common.util.StringUtil",
        StringUtil.removeSpecialCharacters(
            " org.broadleafcommerce.common.util.StringUtilorg.broadleafcommerce.common.util.StringUtil"));
    assertEquals("[\\r\\n][\\r\\n]org.broadleafcommerce.common.util.StringUtil",
        StringUtil.removeSpecialCharacters("[ \\r\\n][ \\r\\n]org.broadleafcommerce.common.util.StringUtil"));
    assertEquals("[\\r\\n]Inputorg.broadleafcommerce.common.util.StringUtil",
        StringUtil.removeSpecialCharacters("[ \\r\\n]Inputorg.broadleafcommerce.common.util.StringUtil"));
    assertEquals("[\\r\\n]42org.broadleafcommerce.common.util.StringUtil",
        StringUtil.removeSpecialCharacters("[ \\r\\n]42org.broadleafcommerce.common.util.StringUtil"));
    assertEquals("[\\r\\n]java.lang.Booleanorg.broadleafcommerce.common.util.StringUtil",
        StringUtil.removeSpecialCharacters("[ \\r\\n]java.lang.Booleanorg.broadleafcommerce.common.util.StringUtil"));
    assertEquals("[\\r\\n]java.util.Map$Entryorg.broadleafcommerce.common.util.StringUtil",
        StringUtil.removeSpecialCharacters("[ \\r\\n]java.util.Map$Entryorg.broadleafcommerce.common.util.StringUtil"));
    assertEquals("[\\r\\n]nullorg.broadleafcommerce.common.util.StringUtil",
        StringUtil.removeSpecialCharacters("[ \\r\\n]nullorg.broadleafcommerce.common.util.StringUtil"));
    assertEquals("[\\r\\n]org.broadleafcommerce.common.util.StringUtil[\\r\\n]",
        StringUtil.removeSpecialCharacters("[ \\r\\n]org.broadleafcommerce.common.util.StringUtil[ \\r\\n]"));
    assertEquals("[\\r\\n]org.broadleafcommerce.common.util.StringUtilInput",
        StringUtil.removeSpecialCharacters("[ \\r\\n]org.broadleafcommerce.common.util.StringUtilInput"));
    assertEquals("[\\r\\n]org.broadleafcommerce.common.util.StringUtil42",
        StringUtil.removeSpecialCharacters("[ \\r\\n]org.broadleafcommerce.common.util.StringUtil42"));
    assertEquals("[\\r\\n]org.broadleafcommerce.common.util.StringUtiljava.lang.Boolean",
        StringUtil.removeSpecialCharacters("[ \\r\\n]org.broadleafcommerce.common.util.StringUtiljava.lang.Boolean"));
    assertEquals("[\\r\\n]org.broadleafcommerce.common.util.StringUtiljava.util.Map$Entry",
        StringUtil.removeSpecialCharacters("[ \\r\\n]org.broadleafcommerce.common.util.StringUtiljava.util.Map$Entry"));
    assertEquals("[\\r\\n]org.broadleafcommerce.common.util.StringUtilnull",
        StringUtil.removeSpecialCharacters("[ \\r\\n]org.broadleafcommerce.common.util.StringUtilnull"));
    assertEquals("[\\r\\n]org.broadleafcommerce.common.util.StringUtilorg.broadleafcommerce.common.util.StringUtil",
        StringUtil.removeSpecialCharacters(
            "[ \\r\\n]org.broadleafcommerce.common.util.StringUtilorg.broadleafcommerce.common.util.StringUtil"));
  }

  /**
   * Test {@link StringUtil#removeSpecialCharacters(String)}.
   * <ul>
   *   <li>Then return {@code 42org.broadleafcommerce.common.util.StringUtil}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeSpecialCharacters(String)}
   */
  @Test
  public void testRemoveSpecialCharacters_thenReturn42orgBroadleafcommerceCommonUtilStringUtil() {
    // Arrange, Act and Assert
    assertEquals("42org.broadleafcommerce.common.util.StringUtil",
        StringUtil.removeSpecialCharacters(" 42org.broadleafcommerce.common.util.StringUtil"));
  }

  /**
   * Test {@link StringUtil#removeSpecialCharacters(String)}.
   * <ul>
   *   <li>Then return {@code .{}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeSpecialCharacters(String)}
   */
  @Test
  public void testRemoveSpecialCharacters_thenReturnDotLeftCurlyBracket() {
    // Arrange, Act and Assert
    assertEquals(".{", StringUtil.removeSpecialCharacters(" .{"));
  }

  /**
   * Test {@link StringUtil#removeSpecialCharacters(String)}.
   * <ul>
   *   <li>Then return {@code Inputjava.lang.Boolean}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeSpecialCharacters(String)}
   */
  @Test
  public void testRemoveSpecialCharacters_thenReturnInputjavaLangBoolean() {
    // Arrange, Act and Assert
    assertEquals("Inputjava.lang.Boolean", StringUtil.removeSpecialCharacters(" Inputjava.lang.Boolean"));
  }

  /**
   * Test {@link StringUtil#removeSpecialCharacters(String)}.
   * <ul>
   *   <li>Then return {@code Inputjava.util.Map$Entry}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeSpecialCharacters(String)}
   */
  @Test
  public void testRemoveSpecialCharacters_thenReturnInputjavaUtilMapEntry() {
    // Arrange, Act and Assert
    assertEquals("Inputjava.util.Map$Entry", StringUtil.removeSpecialCharacters(" Inputjava.util.Map$Entry"));
  }

  /**
   * Test {@link StringUtil#removeSpecialCharacters(String)}.
   * <ul>
   *   <li>Then return {@code java.lang.BooleanInput}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeSpecialCharacters(String)}
   */
  @Test
  public void testRemoveSpecialCharacters_thenReturnJavaLangBooleanInput() {
    // Arrange, Act and Assert
    assertEquals("java.lang.BooleanInput", StringUtil.removeSpecialCharacters(" java.lang.BooleanInput"));
  }

  /**
   * Test {@link StringUtil#removeSpecialCharacters(String)}.
   * <ul>
   *   <li>Then return {@code java.lang.Booleanjava.lang.Boolean}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeSpecialCharacters(String)}
   */
  @Test
  public void testRemoveSpecialCharacters_thenReturnJavaLangBooleanjavaLangBoolean() {
    // Arrange, Act and Assert
    assertEquals("java.lang.Booleanjava.lang.Boolean",
        StringUtil.removeSpecialCharacters(" java.lang.Booleanjava.lang.Boolean"));
  }

  /**
   * Test {@link StringUtil#removeSpecialCharacters(String)}.
   * <ul>
   *   <li>Then return {@code java.lang.Booleanjava.util.Map$Entry}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeSpecialCharacters(String)}
   */
  @Test
  public void testRemoveSpecialCharacters_thenReturnJavaLangBooleanjavaUtilMapEntry() {
    // Arrange, Act and Assert
    assertEquals("java.lang.Booleanjava.util.Map$Entry",
        StringUtil.removeSpecialCharacters(" java.lang.Booleanjava.util.Map$Entry"));
  }

  /**
   * Test {@link StringUtil#removeSpecialCharacters(String)}.
   * <ul>
   *   <li>Then return {@code java.lang.Booleannull}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeSpecialCharacters(String)}
   */
  @Test
  public void testRemoveSpecialCharacters_thenReturnJavaLangBooleannull() {
    // Arrange, Act and Assert
    assertEquals("java.lang.Booleannull", StringUtil.removeSpecialCharacters(" java.lang.Booleannull"));
  }

  /**
   * Test {@link StringUtil#removeSpecialCharacters(String)}.
   * <ul>
   *   <li>Then return {@code java.util.Map$EntryInput}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeSpecialCharacters(String)}
   */
  @Test
  public void testRemoveSpecialCharacters_thenReturnJavaUtilMapEntryInput() {
    // Arrange, Act and Assert
    assertEquals("java.util.Map$EntryInput", StringUtil.removeSpecialCharacters(" java.util.Map$EntryInput"));
  }

  /**
   * Test {@link StringUtil#removeSpecialCharacters(String)}.
   * <ul>
   *   <li>Then return {@code java.util.Map$Entryjava.lang.Boolean}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeSpecialCharacters(String)}
   */
  @Test
  public void testRemoveSpecialCharacters_thenReturnJavaUtilMapEntryjavaLangBoolean() {
    // Arrange, Act and Assert
    assertEquals("java.util.Map$Entryjava.lang.Boolean",
        StringUtil.removeSpecialCharacters(" java.util.Map$Entryjava.lang.Boolean"));
  }

  /**
   * Test {@link StringUtil#removeSpecialCharacters(String)}.
   * <ul>
   *   <li>Then return {@code java.util.Map$Entryjava.util.Map$Entry}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeSpecialCharacters(String)}
   */
  @Test
  public void testRemoveSpecialCharacters_thenReturnJavaUtilMapEntryjavaUtilMapEntry() {
    // Arrange, Act and Assert
    assertEquals("java.util.Map$Entryjava.util.Map$Entry",
        StringUtil.removeSpecialCharacters(" java.util.Map$Entryjava.util.Map$Entry"));
  }

  /**
   * Test {@link StringUtil#removeSpecialCharacters(String)}.
   * <ul>
   *   <li>Then return {@code java.util.Map$Entrynull}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeSpecialCharacters(String)}
   */
  @Test
  public void testRemoveSpecialCharacters_thenReturnJavaUtilMapEntrynull() {
    // Arrange, Act and Assert
    assertEquals("java.util.Map$Entrynull", StringUtil.removeSpecialCharacters(" java.util.Map$Entrynull"));
  }

  /**
   * Test {@link StringUtil#removeSpecialCharacters(String)}.
   * <ul>
   *   <li>Then return {@code {.}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeSpecialCharacters(String)}
   */
  @Test
  public void testRemoveSpecialCharacters_thenReturnLeftCurlyBracketDot() {
    // Arrange, Act and Assert
    assertEquals("{.", StringUtil.removeSpecialCharacters(" {."));
  }

  /**
   * Test {@link StringUtil#removeSpecialCharacters(String)}.
   * <ul>
   *   <li>Then return {@code {{}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeSpecialCharacters(String)}
   */
  @Test
  public void testRemoveSpecialCharacters_thenReturnLeftCurlyBracketLeftCurlyBracket() {
    // Arrange, Act and Assert
    assertEquals("{{", StringUtil.removeSpecialCharacters(" {{"));
  }

  /**
   * Test {@link StringUtil#removeSpecialCharacters(String)}.
   * <ul>
   *   <li>Then return {@code nulljava.lang.Boolean}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeSpecialCharacters(String)}
   */
  @Test
  public void testRemoveSpecialCharacters_thenReturnNulljavaLangBoolean() {
    // Arrange, Act and Assert
    assertEquals("nulljava.lang.Boolean", StringUtil.removeSpecialCharacters(" nulljava.lang.Boolean"));
  }

  /**
   * Test {@link StringUtil#removeSpecialCharacters(String)}.
   * <ul>
   *   <li>Then return {@code nulljava.util.Map$Entry}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeSpecialCharacters(String)}
   */
  @Test
  public void testRemoveSpecialCharacters_thenReturnNulljavaUtilMapEntry() {
    // Arrange, Act and Assert
    assertEquals("nulljava.util.Map$Entry", StringUtil.removeSpecialCharacters(" nulljava.util.Map$Entry"));
  }

  /**
   * Test {@link StringUtil#removeSpecialCharacters(String)}.
   * <ul>
   *   <li>Then return {@code org.broadleafcommerce.common.util.StringUtil}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeSpecialCharacters(String)}
   */
  @Test
  public void testRemoveSpecialCharacters_thenReturnOrgBroadleafcommerceCommonUtilStringUtil() {
    // Arrange, Act and Assert
    assertEquals("org.broadleafcommerce.common.util.StringUtil",
        StringUtil.removeSpecialCharacters(" org.broadleafcommerce.common.util.StringUtil"));
    assertEquals("org.broadleafcommerce.common.util.StringUtil",
        StringUtil.removeSpecialCharacters("org.broadleafcommerce.common.util.StringUtil "));
    assertEquals("org.broadleafcommerce.common.util.StringUtil",
        StringUtil.removeSpecialCharacters("  org.broadleafcommerce.common.util.StringUtil"));
    assertEquals(".org.broadleafcommerce.common.util.StringUtil",
        StringUtil.removeSpecialCharacters(" .org.broadleafcommerce.common.util.StringUtil"));
    assertEquals("org.broadleafcommerce.common.util.StringUtil",
        StringUtil.removeSpecialCharacters(" org.broadleafcommerce.common.util.StringUtil "));
    assertEquals("org.broadleafcommerce.common.util.StringUtil.",
        StringUtil.removeSpecialCharacters(" org.broadleafcommerce.common.util.StringUtil."));
    assertEquals("org.broadleafcommerce.common.util.StringUtil{",
        StringUtil.removeSpecialCharacters(" org.broadleafcommerce.common.util.StringUtil{"));
    assertEquals("{org.broadleafcommerce.common.util.StringUtil",
        StringUtil.removeSpecialCharacters(" {org.broadleafcommerce.common.util.StringUtil"));
  }

  /**
   * Test {@link StringUtil#removeSpecialCharacters(String)}.
   * <ul>
   *   <li>Then return {@code org.broadleafcommerce.common.util.StringUtil42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeSpecialCharacters(String)}
   */
  @Test
  public void testRemoveSpecialCharacters_thenReturnOrgBroadleafcommerceCommonUtilStringUtil42() {
    // Arrange, Act and Assert
    assertEquals("org.broadleafcommerce.common.util.StringUtil42",
        StringUtil.removeSpecialCharacters(" org.broadleafcommerce.common.util.StringUtil42"));
  }

  /**
   * Test {@link StringUtil#removeSpecialCharacters(String)}.
   * <ul>
   *   <li>Then return
   * {@code org.broadleafcommerce.common.util.StringUtil[\r\n]}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeSpecialCharacters(String)}
   */
  @Test
  public void testRemoveSpecialCharacters_thenReturnOrgBroadleafcommerceCommonUtilStringUtilRN() {
    // Arrange, Act and Assert
    assertEquals("org.broadleafcommerce.common.util.StringUtil[\\r\\n]",
        StringUtil.removeSpecialCharacters("org.broadleafcommerce.common.util.StringUtil[ \\r\\n]"));
    assertEquals("org.broadleafcommerce.common.util.StringUtil[\\r\\n]",
        StringUtil.removeSpecialCharacters(" org.broadleafcommerce.common.util.StringUtil[ \\r\\n]"));
  }

  /**
   * Test {@link StringUtil#removeSpecialCharacters(String)}.
   * <ul>
   *   <li>Then return {@code [\r\n]42java.lang.Boolean}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeSpecialCharacters(String)}
   */
  @Test
  public void testRemoveSpecialCharacters_thenReturnRN42javaLangBoolean() {
    // Arrange, Act and Assert
    assertEquals("[\\r\\n]42java.lang.Boolean", StringUtil.removeSpecialCharacters("[ \\r\\n]42java.lang.Boolean"));
  }

  /**
   * Test {@link StringUtil#removeSpecialCharacters(String)}.
   * <ul>
   *   <li>Then return {@code [\r\n]42java.util.Map$Entry}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeSpecialCharacters(String)}
   */
  @Test
  public void testRemoveSpecialCharacters_thenReturnRN42javaUtilMapEntry() {
    // Arrange, Act and Assert
    assertEquals("[\\r\\n]42java.util.Map$Entry", StringUtil.removeSpecialCharacters("[ \\r\\n]42java.util.Map$Entry"));
  }

  /**
   * Test {@link StringUtil#removeSpecialCharacters(String)}.
   * <ul>
   *   <li>Then return {@code [\r\n]Inputjava.lang.Boolean}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeSpecialCharacters(String)}
   */
  @Test
  public void testRemoveSpecialCharacters_thenReturnRNInputjavaLangBoolean() {
    // Arrange, Act and Assert
    assertEquals("[\\r\\n]Inputjava.lang.Boolean",
        StringUtil.removeSpecialCharacters("[ \\r\\n]Inputjava.lang.Boolean"));
  }

  /**
   * Test {@link StringUtil#removeSpecialCharacters(String)}.
   * <ul>
   *   <li>Then return {@code [\r\n]Inputjava.util.Map$Entry}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeSpecialCharacters(String)}
   */
  @Test
  public void testRemoveSpecialCharacters_thenReturnRNInputjavaUtilMapEntry() {
    // Arrange, Act and Assert
    assertEquals("[\\r\\n]Inputjava.util.Map$Entry",
        StringUtil.removeSpecialCharacters("[ \\r\\n]Inputjava.util.Map$Entry"));
  }

  /**
   * Test {@link StringUtil#removeSpecialCharacters(String)}.
   * <ul>
   *   <li>Then return {@code [\r\n]java.lang.Boolean42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeSpecialCharacters(String)}
   */
  @Test
  public void testRemoveSpecialCharacters_thenReturnRNJavaLangBoolean42() {
    // Arrange, Act and Assert
    assertEquals("[\\r\\n]java.lang.Boolean42", StringUtil.removeSpecialCharacters("[ \\r\\n]java.lang.Boolean42"));
  }

  /**
   * Test {@link StringUtil#removeSpecialCharacters(String)}.
   * <ul>
   *   <li>Then return {@code [\r\n]java.lang.BooleanInput}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeSpecialCharacters(String)}
   */
  @Test
  public void testRemoveSpecialCharacters_thenReturnRNJavaLangBooleanInput() {
    // Arrange, Act and Assert
    assertEquals("[\\r\\n]java.lang.BooleanInput",
        StringUtil.removeSpecialCharacters("[ \\r\\n]java.lang.BooleanInput"));
  }

  /**
   * Test {@link StringUtil#removeSpecialCharacters(String)}.
   * <ul>
   *   <li>Then return {@code [\r\n]java.lang.Boolean[\r\n]}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeSpecialCharacters(String)}
   */
  @Test
  public void testRemoveSpecialCharacters_thenReturnRNJavaLangBooleanRN() {
    // Arrange, Act and Assert
    assertEquals("[\\r\\n]java.lang.Boolean[\\r\\n]",
        StringUtil.removeSpecialCharacters("[ \\r\\n]java.lang.Boolean[ \\r\\n]"));
  }

  /**
   * Test {@link StringUtil#removeSpecialCharacters(String)}.
   * <ul>
   *   <li>Then return {@code [\r\n]java.lang.Booleanjava.lang.Boolean}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeSpecialCharacters(String)}
   */
  @Test
  public void testRemoveSpecialCharacters_thenReturnRNJavaLangBooleanjavaLangBoolean() {
    // Arrange, Act and Assert
    assertEquals("[\\r\\n]java.lang.Booleanjava.lang.Boolean",
        StringUtil.removeSpecialCharacters("[ \\r\\n]java.lang.Booleanjava.lang.Boolean"));
  }

  /**
   * Test {@link StringUtil#removeSpecialCharacters(String)}.
   * <ul>
   *   <li>Then return {@code [\r\n]java.lang.Booleanjava.util.Map$Entry}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeSpecialCharacters(String)}
   */
  @Test
  public void testRemoveSpecialCharacters_thenReturnRNJavaLangBooleanjavaUtilMapEntry() {
    // Arrange, Act and Assert
    assertEquals("[\\r\\n]java.lang.Booleanjava.util.Map$Entry",
        StringUtil.removeSpecialCharacters("[ \\r\\n]java.lang.Booleanjava.util.Map$Entry"));
  }

  /**
   * Test {@link StringUtil#removeSpecialCharacters(String)}.
   * <ul>
   *   <li>Then return {@code [\r\n]java.lang.Booleannull}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeSpecialCharacters(String)}
   */
  @Test
  public void testRemoveSpecialCharacters_thenReturnRNJavaLangBooleannull() {
    // Arrange, Act and Assert
    assertEquals("[\\r\\n]java.lang.Booleannull", StringUtil.removeSpecialCharacters("[ \\r\\n]java.lang.Booleannull"));
  }

  /**
   * Test {@link StringUtil#removeSpecialCharacters(String)}.
   * <ul>
   *   <li>Then return {@code [\r\n]java.util.Map$Entry42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeSpecialCharacters(String)}
   */
  @Test
  public void testRemoveSpecialCharacters_thenReturnRNJavaUtilMapEntry42() {
    // Arrange, Act and Assert
    assertEquals("[\\r\\n]java.util.Map$Entry42", StringUtil.removeSpecialCharacters("[ \\r\\n]java.util.Map$Entry42"));
  }

  /**
   * Test {@link StringUtil#removeSpecialCharacters(String)}.
   * <ul>
   *   <li>Then return {@code [\r\n]java.util.Map$EntryInput}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeSpecialCharacters(String)}
   */
  @Test
  public void testRemoveSpecialCharacters_thenReturnRNJavaUtilMapEntryInput() {
    // Arrange, Act and Assert
    assertEquals("[\\r\\n]java.util.Map$EntryInput",
        StringUtil.removeSpecialCharacters("[ \\r\\n]java.util.Map$EntryInput"));
  }

  /**
   * Test {@link StringUtil#removeSpecialCharacters(String)}.
   * <ul>
   *   <li>Then return {@code [\r\n]java.util.Map$Entry[\r\n]}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeSpecialCharacters(String)}
   */
  @Test
  public void testRemoveSpecialCharacters_thenReturnRNJavaUtilMapEntryRN() {
    // Arrange, Act and Assert
    assertEquals("[\\r\\n]java.util.Map$Entry[\\r\\n]",
        StringUtil.removeSpecialCharacters("[ \\r\\n]java.util.Map$Entry[ \\r\\n]"));
  }

  /**
   * Test {@link StringUtil#removeSpecialCharacters(String)}.
   * <ul>
   *   <li>Then return {@code [\r\n]java.util.Map$Entryjava.lang.Boolean}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeSpecialCharacters(String)}
   */
  @Test
  public void testRemoveSpecialCharacters_thenReturnRNJavaUtilMapEntryjavaLangBoolean() {
    // Arrange, Act and Assert
    assertEquals("[\\r\\n]java.util.Map$Entryjava.lang.Boolean",
        StringUtil.removeSpecialCharacters("[ \\r\\n]java.util.Map$Entryjava.lang.Boolean"));
  }

  /**
   * Test {@link StringUtil#removeSpecialCharacters(String)}.
   * <ul>
   *   <li>Then return {@code [\r\n]java.util.Map$Entryjava.util.Map$Entry}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeSpecialCharacters(String)}
   */
  @Test
  public void testRemoveSpecialCharacters_thenReturnRNJavaUtilMapEntryjavaUtilMapEntry() {
    // Arrange, Act and Assert
    assertEquals("[\\r\\n]java.util.Map$Entryjava.util.Map$Entry",
        StringUtil.removeSpecialCharacters("[ \\r\\n]java.util.Map$Entryjava.util.Map$Entry"));
  }

  /**
   * Test {@link StringUtil#removeSpecialCharacters(String)}.
   * <ul>
   *   <li>Then return {@code [\r\n]java.util.Map$Entrynull}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeSpecialCharacters(String)}
   */
  @Test
  public void testRemoveSpecialCharacters_thenReturnRNJavaUtilMapEntrynull() {
    // Arrange, Act and Assert
    assertEquals("[\\r\\n]java.util.Map$Entrynull",
        StringUtil.removeSpecialCharacters("[ \\r\\n]java.util.Map$Entrynull"));
  }

  /**
   * Test {@link StringUtil#removeSpecialCharacters(String)}.
   * <ul>
   *   <li>Then return {@code [\r\n]nulljava.lang.Boolean}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeSpecialCharacters(String)}
   */
  @Test
  public void testRemoveSpecialCharacters_thenReturnRNNulljavaLangBoolean() {
    // Arrange, Act and Assert
    assertEquals("[\\r\\n]nulljava.lang.Boolean", StringUtil.removeSpecialCharacters("[ \\r\\n]nulljava.lang.Boolean"));
  }

  /**
   * Test {@link StringUtil#removeSpecialCharacters(String)}.
   * <ul>
   *   <li>Then return {@code [\r\n]nulljava.util.Map$Entry}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeSpecialCharacters(String)}
   */
  @Test
  public void testRemoveSpecialCharacters_thenReturnRNNulljavaUtilMapEntry() {
    // Arrange, Act and Assert
    assertEquals("[\\r\\n]nulljava.util.Map$Entry",
        StringUtil.removeSpecialCharacters("[ \\r\\n]nulljava.util.Map$Entry"));
  }

  /**
   * Test {@link StringUtil#removeSpecialCharacters(String)}.
   * <ul>
   *   <li>Then return
   * {@code [\r\n].org.broadleafcommerce.common.util.StringUtil}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeSpecialCharacters(String)}
   */
  @Test
  public void testRemoveSpecialCharacters_thenReturnRNOrgBroadleafcommerceCommonUtilStringUtil() {
    // Arrange, Act and Assert
    assertEquals("[\\r\\n].org.broadleafcommerce.common.util.StringUtil",
        StringUtil.removeSpecialCharacters("[ \\r\\n].org.broadleafcommerce.common.util.StringUtil"));
    assertEquals("[\\r\\n]org.broadleafcommerce.common.util.StringUtil.",
        StringUtil.removeSpecialCharacters("[ \\r\\n]org.broadleafcommerce.common.util.StringUtil."));
    assertEquals("[\\r\\n]org.broadleafcommerce.common.util.StringUtil{",
        StringUtil.removeSpecialCharacters("[ \\r\\n]org.broadleafcommerce.common.util.StringUtil{"));
    assertEquals("[\\r\\n]{org.broadleafcommerce.common.util.StringUtil",
        StringUtil.removeSpecialCharacters("[ \\r\\n]{org.broadleafcommerce.common.util.StringUtil"));
  }

  /**
   * Test {@link StringUtil#removeSpecialCharacters(String)}.
   * <ul>
   *   <li>Then return {@code [\r\n][\r\n]java.lang.Boolean}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeSpecialCharacters(String)}
   */
  @Test
  public void testRemoveSpecialCharacters_thenReturnRNRNJavaLangBoolean() {
    // Arrange, Act and Assert
    assertEquals("[\\r\\n][\\r\\n]java.lang.Boolean",
        StringUtil.removeSpecialCharacters("[ \\r\\n][ \\r\\n]java.lang.Boolean"));
  }

  /**
   * Test {@link StringUtil#removeSpecialCharacters(String)}.
   * <ul>
   *   <li>Then return {@code [\r\n][\r\n]java.util.Map$Entry}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeSpecialCharacters(String)}
   */
  @Test
  public void testRemoveSpecialCharacters_thenReturnRNRNJavaUtilMapEntry() {
    // Arrange, Act and Assert
    assertEquals("[\\r\\n][\\r\\n]java.util.Map$Entry",
        StringUtil.removeSpecialCharacters("[ \\r\\n][ \\r\\n]java.util.Map$Entry"));
  }

  /**
   * Test {@link StringUtil#removeSpecialCharacters(String)}.
   * <ul>
   *   <li>When {@code 42Input}.</li>
   *   <li>Then return {@code 42Input}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeSpecialCharacters(String)}
   */
  @Test
  public void testRemoveSpecialCharacters_when42Input_thenReturn42Input() {
    // Arrange, Act and Assert
    assertEquals("42Input", StringUtil.removeSpecialCharacters(" 42Input"));
  }

  /**
   * Test {@link StringUtil#removeSpecialCharacters(String)}.
   * <ul>
   *   <li>When {@code 42[ \r\n]}.</li>
   *   <li>Then return {@code 42[\r\n]}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeSpecialCharacters(String)}
   */
  @Test
  public void testRemoveSpecialCharacters_when42RN_thenReturn42RN() {
    // Arrange, Act and Assert
    assertEquals("42[\\r\\n]", StringUtil.removeSpecialCharacters("42[ \\r\\n]"));
    assertEquals("42[\\r\\n]", StringUtil.removeSpecialCharacters(" 42[ \\r\\n]"));
  }

  /**
   * Test {@link StringUtil#removeSpecialCharacters(String)}.
   * <ul>
   *   <li>When {@code 42}.</li>
   *   <li>Then return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeSpecialCharacters(String)}
   */
  @Test
  public void testRemoveSpecialCharacters_when42_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("42", StringUtil.removeSpecialCharacters(" 42"));
    assertEquals("42", StringUtil.removeSpecialCharacters("42 "));
    assertEquals("42", StringUtil.removeSpecialCharacters("  42"));
    assertEquals(".42", StringUtil.removeSpecialCharacters(" .42"));
    assertEquals("42", StringUtil.removeSpecialCharacters(" 42 "));
    assertEquals("42.", StringUtil.removeSpecialCharacters(" 42."));
    assertEquals("42{", StringUtil.removeSpecialCharacters(" 42{"));
    assertEquals("{42", StringUtil.removeSpecialCharacters(" {42"));
  }

  /**
   * Test {@link StringUtil#removeSpecialCharacters(String)}.
   * <ul>
   *   <li>When {@code 42java.lang.Boolean}.</li>
   *   <li>Then return {@code 42java.lang.Boolean}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeSpecialCharacters(String)}
   */
  @Test
  public void testRemoveSpecialCharacters_when42javaLangBoolean_thenReturn42javaLangBoolean() {
    // Arrange, Act and Assert
    assertEquals("42java.lang.Boolean", StringUtil.removeSpecialCharacters(" 42java.lang.Boolean"));
  }

  /**
   * Test {@link StringUtil#removeSpecialCharacters(String)}.
   * <ul>
   *   <li>When {@code 42java.util.Map$Entry}.</li>
   *   <li>Then return {@code 42java.util.Map$Entry}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeSpecialCharacters(String)}
   */
  @Test
  public void testRemoveSpecialCharacters_when42javaUtilMapEntry_thenReturn42javaUtilMapEntry() {
    // Arrange, Act and Assert
    assertEquals("42java.util.Map$Entry", StringUtil.removeSpecialCharacters(" 42java.util.Map$Entry"));
  }

  /**
   * Test {@link StringUtil#removeSpecialCharacters(String)}.
   * <ul>
   *   <li>When {@code 42null}.</li>
   *   <li>Then return {@code 42null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeSpecialCharacters(String)}
   */
  @Test
  public void testRemoveSpecialCharacters_when42null_thenReturn42null() {
    // Arrange, Act and Assert
    assertEquals("42null", StringUtil.removeSpecialCharacters(" 42null"));
  }

  /**
   * Test {@link StringUtil#removeSpecialCharacters(String)}.
   * <ul>
   *   <li>When {@code 4242}.</li>
   *   <li>Then return {@code 4242}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeSpecialCharacters(String)}
   */
  @Test
  public void testRemoveSpecialCharacters_when4242_thenReturn4242() {
    // Arrange, Act and Assert
    assertEquals("4242", StringUtil.removeSpecialCharacters(" 4242"));
  }

  /**
   * Test {@link StringUtil#removeSpecialCharacters(String)}.
   * <ul>
   *   <li>When {@code ..}.</li>
   *   <li>Then return {@code ..}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeSpecialCharacters(String)}
   */
  @Test
  public void testRemoveSpecialCharacters_whenDotDot_thenReturnDotDot() {
    // Arrange, Act and Assert
    assertEquals("..", StringUtil.removeSpecialCharacters(" .."));
  }

  /**
   * Test {@link StringUtil#removeSpecialCharacters(String)}.
   * <ul>
   *   <li>When {@code .}.</li>
   *   <li>Then return {@code .}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeSpecialCharacters(String)}
   */
  @Test
  public void testRemoveSpecialCharacters_whenDot_thenReturnDot() {
    // Arrange, Act and Assert
    assertEquals(".", StringUtil.removeSpecialCharacters(" ."));
    assertEquals(".", StringUtil.removeSpecialCharacters(". "));
    assertEquals(".", StringUtil.removeSpecialCharacters("  ."));
    assertEquals(".", StringUtil.removeSpecialCharacters(" . "));
  }

  /**
   * Test {@link StringUtil#removeSpecialCharacters(String)}.
   * <ul>
   *   <li>When {@code Input42}.</li>
   *   <li>Then return {@code Input42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeSpecialCharacters(String)}
   */
  @Test
  public void testRemoveSpecialCharacters_whenInput42_thenReturnInput42() {
    // Arrange, Act and Assert
    assertEquals("Input42", StringUtil.removeSpecialCharacters(" Input42"));
  }

  /**
   * Test {@link StringUtil#removeSpecialCharacters(String)}.
   * <ul>
   *   <li>When {@code InputInput}.</li>
   *   <li>Then return {@code InputInput}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeSpecialCharacters(String)}
   */
  @Test
  public void testRemoveSpecialCharacters_whenInputInput_thenReturnInputInput() {
    // Arrange, Act and Assert
    assertEquals("InputInput", StringUtil.removeSpecialCharacters(" InputInput"));
  }

  /**
   * Test {@link StringUtil#removeSpecialCharacters(String)}.
   * <ul>
   *   <li>When {@code Input[ \r\n]}.</li>
   *   <li>Then return {@code Input[\r\n]}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeSpecialCharacters(String)}
   */
  @Test
  public void testRemoveSpecialCharacters_whenInputRN_thenReturnInputRN() {
    // Arrange, Act and Assert
    assertEquals("Input[\\r\\n]", StringUtil.removeSpecialCharacters("Input[ \\r\\n]"));
    assertEquals("Input[\\r\\n]", StringUtil.removeSpecialCharacters(" Input[ \\r\\n]"));
  }

  /**
   * Test {@link StringUtil#removeSpecialCharacters(String)}.
   * <ul>
   *   <li>When {@code Input}.</li>
   *   <li>Then return {@code Input}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeSpecialCharacters(String)}
   */
  @Test
  public void testRemoveSpecialCharacters_whenInput_thenReturnInput() {
    // Arrange, Act and Assert
    assertEquals("Input", StringUtil.removeSpecialCharacters("Input"));
    assertEquals("Input", StringUtil.removeSpecialCharacters(" Input"));
    assertEquals("Input", StringUtil.removeSpecialCharacters("Input "));
    assertEquals("Input", StringUtil.removeSpecialCharacters("  Input"));
    assertEquals("Input", StringUtil.removeSpecialCharacters(" Input "));
    assertEquals("Input.", StringUtil.removeSpecialCharacters(" Input."));
    assertEquals("Input{", StringUtil.removeSpecialCharacters(" Input{"));
    assertEquals(".Input", StringUtil.removeSpecialCharacters(" .Input"));
    assertEquals("{Input", StringUtil.removeSpecialCharacters(" {Input"));
  }

  /**
   * Test {@link StringUtil#removeSpecialCharacters(String)}.
   * <ul>
   *   <li>When {@code Inputnull}.</li>
   *   <li>Then return {@code Inputnull}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeSpecialCharacters(String)}
   */
  @Test
  public void testRemoveSpecialCharacters_whenInputnull_thenReturnInputnull() {
    // Arrange, Act and Assert
    assertEquals("Inputnull", StringUtil.removeSpecialCharacters(" Inputnull"));
  }

  /**
   * Test {@link StringUtil#removeSpecialCharacters(String)}.
   * <ul>
   *   <li>When {@code java.lang.Boolean42}.</li>
   *   <li>Then return {@code java.lang.Boolean42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeSpecialCharacters(String)}
   */
  @Test
  public void testRemoveSpecialCharacters_whenJavaLangBoolean42_thenReturnJavaLangBoolean42() {
    // Arrange, Act and Assert
    assertEquals("java.lang.Boolean42", StringUtil.removeSpecialCharacters(" java.lang.Boolean42"));
  }

  /**
   * Test {@link StringUtil#removeSpecialCharacters(String)}.
   * <ul>
   *   <li>When {@code java.lang.Boolean[ \r\n]}.</li>
   *   <li>Then return {@code java.lang.Boolean[\r\n]}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeSpecialCharacters(String)}
   */
  @Test
  public void testRemoveSpecialCharacters_whenJavaLangBooleanRN_thenReturnJavaLangBooleanRN() {
    // Arrange, Act and Assert
    assertEquals("java.lang.Boolean[\\r\\n]", StringUtil.removeSpecialCharacters("java.lang.Boolean[ \\r\\n]"));
    assertEquals("java.lang.Boolean[\\r\\n]", StringUtil.removeSpecialCharacters(" java.lang.Boolean[ \\r\\n]"));
  }

  /**
   * Test {@link StringUtil#removeSpecialCharacters(String)}.
   * <ul>
   *   <li>When {@code java.lang.Boolean}.</li>
   *   <li>Then return {@code java.lang.Boolean}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeSpecialCharacters(String)}
   */
  @Test
  public void testRemoveSpecialCharacters_whenJavaLangBoolean_thenReturnJavaLangBoolean() {
    // Arrange, Act and Assert
    assertEquals("java.lang.Boolean", StringUtil.removeSpecialCharacters(" java.lang.Boolean"));
    assertEquals("java.lang.Boolean", StringUtil.removeSpecialCharacters("java.lang.Boolean "));
    assertEquals("java.lang.Boolean", StringUtil.removeSpecialCharacters("  java.lang.Boolean"));
    assertEquals(".java.lang.Boolean", StringUtil.removeSpecialCharacters(" .java.lang.Boolean"));
    assertEquals("java.lang.Boolean", StringUtil.removeSpecialCharacters(" java.lang.Boolean "));
    assertEquals("java.lang.Boolean.", StringUtil.removeSpecialCharacters(" java.lang.Boolean."));
    assertEquals("java.lang.Boolean{", StringUtil.removeSpecialCharacters(" java.lang.Boolean{"));
    assertEquals("{java.lang.Boolean", StringUtil.removeSpecialCharacters(" {java.lang.Boolean"));
  }

  /**
   * Test {@link StringUtil#removeSpecialCharacters(String)}.
   * <ul>
   *   <li>When {@code java.util.Map$Entry42}.</li>
   *   <li>Then return {@code java.util.Map$Entry42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeSpecialCharacters(String)}
   */
  @Test
  public void testRemoveSpecialCharacters_whenJavaUtilMapEntry42_thenReturnJavaUtilMapEntry42() {
    // Arrange, Act and Assert
    assertEquals("java.util.Map$Entry42", StringUtil.removeSpecialCharacters(" java.util.Map$Entry42"));
  }

  /**
   * Test {@link StringUtil#removeSpecialCharacters(String)}.
   * <ul>
   *   <li>When {@code java.util.Map$Entry[ \r\n]}.</li>
   *   <li>Then return {@code java.util.Map$Entry[\r\n]}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeSpecialCharacters(String)}
   */
  @Test
  public void testRemoveSpecialCharacters_whenJavaUtilMapEntryRN_thenReturnJavaUtilMapEntryRN() {
    // Arrange, Act and Assert
    assertEquals("java.util.Map$Entry[\\r\\n]", StringUtil.removeSpecialCharacters("java.util.Map$Entry[ \\r\\n]"));
    assertEquals("java.util.Map$Entry[\\r\\n]", StringUtil.removeSpecialCharacters(" java.util.Map$Entry[ \\r\\n]"));
  }

  /**
   * Test {@link StringUtil#removeSpecialCharacters(String)}.
   * <ul>
   *   <li>When {@code java.util.Map$Entry}.</li>
   *   <li>Then return {@code java.util.Map$Entry}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeSpecialCharacters(String)}
   */
  @Test
  public void testRemoveSpecialCharacters_whenJavaUtilMapEntry_thenReturnJavaUtilMapEntry() {
    // Arrange, Act and Assert
    assertEquals("java.util.Map$Entry", StringUtil.removeSpecialCharacters(" java.util.Map$Entry"));
    assertEquals("java.util.Map$Entry", StringUtil.removeSpecialCharacters("java.util.Map$Entry "));
    assertEquals("java.util.Map$Entry", StringUtil.removeSpecialCharacters("  java.util.Map$Entry"));
    assertEquals(".java.util.Map$Entry", StringUtil.removeSpecialCharacters(" .java.util.Map$Entry"));
    assertEquals("java.util.Map$Entry", StringUtil.removeSpecialCharacters(" java.util.Map$Entry "));
    assertEquals("java.util.Map$Entry.", StringUtil.removeSpecialCharacters(" java.util.Map$Entry."));
    assertEquals("java.util.Map$Entry{", StringUtil.removeSpecialCharacters(" java.util.Map$Entry{"));
    assertEquals("{java.util.Map$Entry", StringUtil.removeSpecialCharacters(" {java.util.Map$Entry"));
  }

  /**
   * Test {@link StringUtil#removeSpecialCharacters(String)}.
   * <ul>
   *   <li>When {@code {}.</li>
   *   <li>Then return {@code {}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeSpecialCharacters(String)}
   */
  @Test
  public void testRemoveSpecialCharacters_whenLeftCurlyBracket_thenReturnLeftCurlyBracket() {
    // Arrange, Act and Assert
    assertEquals("{", StringUtil.removeSpecialCharacters(" {"));
    assertEquals("{", StringUtil.removeSpecialCharacters("{ "));
    assertEquals("{", StringUtil.removeSpecialCharacters("  {"));
    assertEquals("{", StringUtil.removeSpecialCharacters(" { "));
  }

  /**
   * Test {@link StringUtil#removeSpecialCharacters(String)}.
   * <ul>
   *   <li>When {@code null42}.</li>
   *   <li>Then return {@code null42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeSpecialCharacters(String)}
   */
  @Test
  public void testRemoveSpecialCharacters_whenNull42_thenReturnNull42() {
    // Arrange, Act and Assert
    assertEquals("null42", StringUtil.removeSpecialCharacters(" null42"));
  }

  /**
   * Test {@link StringUtil#removeSpecialCharacters(String)}.
   * <ul>
   *   <li>When {@code nullInput}.</li>
   *   <li>Then return {@code nullInput}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeSpecialCharacters(String)}
   */
  @Test
  public void testRemoveSpecialCharacters_whenNullInput_thenReturnNullInput() {
    // Arrange, Act and Assert
    assertEquals("nullInput", StringUtil.removeSpecialCharacters(" nullInput"));
  }

  /**
   * Test {@link StringUtil#removeSpecialCharacters(String)}.
   * <ul>
   *   <li>When {@code null[ \r\n]}.</li>
   *   <li>Then return {@code null[\r\n]}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeSpecialCharacters(String)}
   */
  @Test
  public void testRemoveSpecialCharacters_whenNullRN_thenReturnNullRN() {
    // Arrange, Act and Assert
    assertEquals("null[\\r\\n]", StringUtil.removeSpecialCharacters("null[ \\r\\n]"));
    assertEquals("null[\\r\\n]", StringUtil.removeSpecialCharacters(" null[ \\r\\n]"));
  }

  /**
   * Test {@link StringUtil#removeSpecialCharacters(String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeSpecialCharacters(String)}
   */
  @Test
  public void testRemoveSpecialCharacters_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(StringUtil.removeSpecialCharacters(null));
    assertEquals("null", StringUtil.removeSpecialCharacters(" null"));
    assertEquals("null", StringUtil.removeSpecialCharacters("null "));
    assertEquals("null", StringUtil.removeSpecialCharacters("  null"));
    assertEquals(".null", StringUtil.removeSpecialCharacters(" .null"));
    assertEquals("null", StringUtil.removeSpecialCharacters(" null "));
    assertEquals("null.", StringUtil.removeSpecialCharacters(" null."));
    assertEquals("null{", StringUtil.removeSpecialCharacters(" null{"));
    assertEquals("{null", StringUtil.removeSpecialCharacters(" {null"));
  }

  /**
   * Test {@link StringUtil#removeSpecialCharacters(String)}.
   * <ul>
   *   <li>When {@code nullnull}.</li>
   *   <li>Then return {@code nullnull}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeSpecialCharacters(String)}
   */
  @Test
  public void testRemoveSpecialCharacters_whenNullnull_thenReturnNullnull() {
    // Arrange, Act and Assert
    assertEquals("nullnull", StringUtil.removeSpecialCharacters(" nullnull"));
  }

  /**
   * Test {@link StringUtil#removeSpecialCharacters(String)}.
   * <ul>
   *   <li>When {@code [ \r\n]42Input}.</li>
   *   <li>Then return {@code [\r\n]42Input}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeSpecialCharacters(String)}
   */
  @Test
  public void testRemoveSpecialCharacters_whenRN42Input_thenReturnRN42Input() {
    // Arrange, Act and Assert
    assertEquals("[\\r\\n]42Input", StringUtil.removeSpecialCharacters("[ \\r\\n]42Input"));
  }

  /**
   * Test {@link StringUtil#removeSpecialCharacters(String)}.
   * <ul>
   *   <li>When {@code [ \r\n]42[ \r\n]}.</li>
   *   <li>Then return {@code [\r\n]42[\r\n]}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeSpecialCharacters(String)}
   */
  @Test
  public void testRemoveSpecialCharacters_whenRN42RN_thenReturnRN42RN() {
    // Arrange, Act and Assert
    assertEquals("[\\r\\n]42[\\r\\n]", StringUtil.removeSpecialCharacters("[ \\r\\n]42[ \\r\\n]"));
  }

  /**
   * Test {@link StringUtil#removeSpecialCharacters(String)}.
   * <ul>
   *   <li>When {@code [ \r\n]42}.</li>
   *   <li>Then return {@code [\r\n]42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeSpecialCharacters(String)}
   */
  @Test
  public void testRemoveSpecialCharacters_whenRN42_thenReturnRN42() {
    // Arrange, Act and Assert
    assertEquals("[\\r\\n]42", StringUtil.removeSpecialCharacters("[ \\r\\n]42"));
    assertEquals("[\\r\\n]42", StringUtil.removeSpecialCharacters(" [ \\r\\n]42"));
    assertEquals("[\\r\\n]42", StringUtil.removeSpecialCharacters("[ \\r\\n] 42"));
    assertEquals("[\\r\\n].42", StringUtil.removeSpecialCharacters("[ \\r\\n].42"));
    assertEquals("[\\r\\n]42", StringUtil.removeSpecialCharacters("[ \\r\\n]42 "));
    assertEquals("[\\r\\n]42.", StringUtil.removeSpecialCharacters("[ \\r\\n]42."));
    assertEquals("[\\r\\n]42{", StringUtil.removeSpecialCharacters("[ \\r\\n]42{"));
    assertEquals("[\\r\\n]{42", StringUtil.removeSpecialCharacters("[ \\r\\n]{42"));
  }

  /**
   * Test {@link StringUtil#removeSpecialCharacters(String)}.
   * <ul>
   *   <li>When {@code [ \r\n]42null}.</li>
   *   <li>Then return {@code [\r\n]42null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeSpecialCharacters(String)}
   */
  @Test
  public void testRemoveSpecialCharacters_whenRN42null_thenReturnRN42null() {
    // Arrange, Act and Assert
    assertEquals("[\\r\\n]42null", StringUtil.removeSpecialCharacters("[ \\r\\n]42null"));
  }

  /**
   * Test {@link StringUtil#removeSpecialCharacters(String)}.
   * <ul>
   *   <li>When {@code [ \r\n]4242}.</li>
   *   <li>Then return {@code [\r\n]4242}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeSpecialCharacters(String)}
   */
  @Test
  public void testRemoveSpecialCharacters_whenRN4242_thenReturnRN4242() {
    // Arrange, Act and Assert
    assertEquals("[\\r\\n]4242", StringUtil.removeSpecialCharacters("[ \\r\\n]4242"));
  }

  /**
   * Test {@link StringUtil#removeSpecialCharacters(String)}.
   * <ul>
   *   <li>When {@code [ \r\n]Input42}.</li>
   *   <li>Then return {@code [\r\n]Input42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeSpecialCharacters(String)}
   */
  @Test
  public void testRemoveSpecialCharacters_whenRNInput42_thenReturnRNInput42() {
    // Arrange, Act and Assert
    assertEquals("[\\r\\n]Input42", StringUtil.removeSpecialCharacters("[ \\r\\n]Input42"));
  }

  /**
   * Test {@link StringUtil#removeSpecialCharacters(String)}.
   * <ul>
   *   <li>When {@code [ \r\n]InputInput}.</li>
   *   <li>Then return {@code [\r\n]InputInput}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeSpecialCharacters(String)}
   */
  @Test
  public void testRemoveSpecialCharacters_whenRNInputInput_thenReturnRNInputInput() {
    // Arrange, Act and Assert
    assertEquals("[\\r\\n]InputInput", StringUtil.removeSpecialCharacters("[ \\r\\n]InputInput"));
  }

  /**
   * Test {@link StringUtil#removeSpecialCharacters(String)}.
   * <ul>
   *   <li>When {@code [ \r\n]Input[ \r\n]}.</li>
   *   <li>Then return {@code [\r\n]Input[\r\n]}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeSpecialCharacters(String)}
   */
  @Test
  public void testRemoveSpecialCharacters_whenRNInputRN_thenReturnRNInputRN() {
    // Arrange, Act and Assert
    assertEquals("[\\r\\n]Input[\\r\\n]", StringUtil.removeSpecialCharacters("[ \\r\\n]Input[ \\r\\n]"));
  }

  /**
   * Test {@link StringUtil#removeSpecialCharacters(String)}.
   * <ul>
   *   <li>When {@code [ \r\n]Input}.</li>
   *   <li>Then return {@code [\r\n]Input}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeSpecialCharacters(String)}
   */
  @Test
  public void testRemoveSpecialCharacters_whenRNInput_thenReturnRNInput() {
    // Arrange, Act and Assert
    assertEquals("[\\r\\n]Input", StringUtil.removeSpecialCharacters("[ \\r\\n]Input"));
    assertEquals("[\\r\\n]Input", StringUtil.removeSpecialCharacters(" [ \\r\\n]Input"));
    assertEquals("[\\r\\n]Input", StringUtil.removeSpecialCharacters("[ \\r\\n] Input"));
    assertEquals("[\\r\\n]Input", StringUtil.removeSpecialCharacters("[ \\r\\n]Input "));
    assertEquals("[\\r\\n]Input.", StringUtil.removeSpecialCharacters("[ \\r\\n]Input."));
    assertEquals("[\\r\\n]Input{", StringUtil.removeSpecialCharacters("[ \\r\\n]Input{"));
    assertEquals("[\\r\\n].Input", StringUtil.removeSpecialCharacters("[ \\r\\n].Input"));
    assertEquals("[\\r\\n]{Input", StringUtil.removeSpecialCharacters("[ \\r\\n]{Input"));
  }

  /**
   * Test {@link StringUtil#removeSpecialCharacters(String)}.
   * <ul>
   *   <li>When {@code [ \r\n]Inputnull}.</li>
   *   <li>Then return {@code [\r\n]Inputnull}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeSpecialCharacters(String)}
   */
  @Test
  public void testRemoveSpecialCharacters_whenRNInputnull_thenReturnRNInputnull() {
    // Arrange, Act and Assert
    assertEquals("[\\r\\n]Inputnull", StringUtil.removeSpecialCharacters("[ \\r\\n]Inputnull"));
  }

  /**
   * Test {@link StringUtil#removeSpecialCharacters(String)}.
   * <ul>
   *   <li>When {@code [ \r\n]java.lang.Boolean}.</li>
   *   <li>Then return {@code [\r\n]java.lang.Boolean}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeSpecialCharacters(String)}
   */
  @Test
  public void testRemoveSpecialCharacters_whenRNJavaLangBoolean_thenReturnRNJavaLangBoolean() {
    // Arrange, Act and Assert
    assertEquals("[\\r\\n]java.lang.Boolean", StringUtil.removeSpecialCharacters("[ \\r\\n]java.lang.Boolean"));
    assertEquals("[\\r\\n]java.lang.Boolean", StringUtil.removeSpecialCharacters(" [ \\r\\n]java.lang.Boolean"));
    assertEquals("[\\r\\n]java.lang.Boolean", StringUtil.removeSpecialCharacters("[ \\r\\n] java.lang.Boolean"));
    assertEquals("[\\r\\n].java.lang.Boolean", StringUtil.removeSpecialCharacters("[ \\r\\n].java.lang.Boolean"));
    assertEquals("[\\r\\n]java.lang.Boolean", StringUtil.removeSpecialCharacters("[ \\r\\n]java.lang.Boolean "));
    assertEquals("[\\r\\n]java.lang.Boolean.", StringUtil.removeSpecialCharacters("[ \\r\\n]java.lang.Boolean."));
    assertEquals("[\\r\\n]java.lang.Boolean{", StringUtil.removeSpecialCharacters("[ \\r\\n]java.lang.Boolean{"));
    assertEquals("[\\r\\n]{java.lang.Boolean", StringUtil.removeSpecialCharacters("[ \\r\\n]{java.lang.Boolean"));
  }

  /**
   * Test {@link StringUtil#removeSpecialCharacters(String)}.
   * <ul>
   *   <li>When {@code [ \r\n]java.util.Map$Entry}.</li>
   *   <li>Then return {@code [\r\n]java.util.Map$Entry}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeSpecialCharacters(String)}
   */
  @Test
  public void testRemoveSpecialCharacters_whenRNJavaUtilMapEntry_thenReturnRNJavaUtilMapEntry() {
    // Arrange, Act and Assert
    assertEquals("[\\r\\n]java.util.Map$Entry", StringUtil.removeSpecialCharacters("[ \\r\\n]java.util.Map$Entry"));
    assertEquals("[\\r\\n]java.util.Map$Entry", StringUtil.removeSpecialCharacters(" [ \\r\\n]java.util.Map$Entry"));
    assertEquals("[\\r\\n]java.util.Map$Entry", StringUtil.removeSpecialCharacters("[ \\r\\n] java.util.Map$Entry"));
    assertEquals("[\\r\\n].java.util.Map$Entry", StringUtil.removeSpecialCharacters("[ \\r\\n].java.util.Map$Entry"));
    assertEquals("[\\r\\n]java.util.Map$Entry", StringUtil.removeSpecialCharacters("[ \\r\\n]java.util.Map$Entry "));
    assertEquals("[\\r\\n]java.util.Map$Entry.", StringUtil.removeSpecialCharacters("[ \\r\\n]java.util.Map$Entry."));
    assertEquals("[\\r\\n]java.util.Map$Entry{", StringUtil.removeSpecialCharacters("[ \\r\\n]java.util.Map$Entry{"));
    assertEquals("[\\r\\n]{java.util.Map$Entry", StringUtil.removeSpecialCharacters("[ \\r\\n]{java.util.Map$Entry"));
  }

  /**
   * Test {@link StringUtil#removeSpecialCharacters(String)}.
   * <ul>
   *   <li>When {@code [ \r\n]null42}.</li>
   *   <li>Then return {@code [\r\n]null42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeSpecialCharacters(String)}
   */
  @Test
  public void testRemoveSpecialCharacters_whenRNNull42_thenReturnRNNull42() {
    // Arrange, Act and Assert
    assertEquals("[\\r\\n]null42", StringUtil.removeSpecialCharacters("[ \\r\\n]null42"));
  }

  /**
   * Test {@link StringUtil#removeSpecialCharacters(String)}.
   * <ul>
   *   <li>When {@code [ \r\n]nullInput}.</li>
   *   <li>Then return {@code [\r\n]nullInput}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeSpecialCharacters(String)}
   */
  @Test
  public void testRemoveSpecialCharacters_whenRNNullInput_thenReturnRNNullInput() {
    // Arrange, Act and Assert
    assertEquals("[\\r\\n]nullInput", StringUtil.removeSpecialCharacters("[ \\r\\n]nullInput"));
  }

  /**
   * Test {@link StringUtil#removeSpecialCharacters(String)}.
   * <ul>
   *   <li>When {@code [ \r\n]null[ \r\n]}.</li>
   *   <li>Then return {@code [\r\n]null[\r\n]}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeSpecialCharacters(String)}
   */
  @Test
  public void testRemoveSpecialCharacters_whenRNNullRN_thenReturnRNNullRN() {
    // Arrange, Act and Assert
    assertEquals("[\\r\\n]null[\\r\\n]", StringUtil.removeSpecialCharacters("[ \\r\\n]null[ \\r\\n]"));
  }

  /**
   * Test {@link StringUtil#removeSpecialCharacters(String)}.
   * <ul>
   *   <li>When {@code [ \r\n]null}.</li>
   *   <li>Then return {@code [\r\n]null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeSpecialCharacters(String)}
   */
  @Test
  public void testRemoveSpecialCharacters_whenRNNull_thenReturnRNNull() {
    // Arrange, Act and Assert
    assertEquals("[\\r\\n]null", StringUtil.removeSpecialCharacters("[ \\r\\n]null"));
    assertEquals("[\\r\\n]null", StringUtil.removeSpecialCharacters(" [ \\r\\n]null"));
    assertEquals("[\\r\\n]null", StringUtil.removeSpecialCharacters("[ \\r\\n] null"));
    assertEquals("[\\r\\n].null", StringUtil.removeSpecialCharacters("[ \\r\\n].null"));
    assertEquals("[\\r\\n]null", StringUtil.removeSpecialCharacters("[ \\r\\n]null "));
    assertEquals("[\\r\\n]null.", StringUtil.removeSpecialCharacters("[ \\r\\n]null."));
    assertEquals("[\\r\\n]null{", StringUtil.removeSpecialCharacters("[ \\r\\n]null{"));
    assertEquals("[\\r\\n]{null", StringUtil.removeSpecialCharacters("[ \\r\\n]{null"));
  }

  /**
   * Test {@link StringUtil#removeSpecialCharacters(String)}.
   * <ul>
   *   <li>When {@code [ \r\n]nullnull}.</li>
   *   <li>Then return {@code [\r\n]nullnull}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeSpecialCharacters(String)}
   */
  @Test
  public void testRemoveSpecialCharacters_whenRNNullnull_thenReturnRNNullnull() {
    // Arrange, Act and Assert
    assertEquals("[\\r\\n]nullnull", StringUtil.removeSpecialCharacters("[ \\r\\n]nullnull"));
  }

  /**
   * Test {@link StringUtil#removeSpecialCharacters(String)}.
   * <ul>
   *   <li>When {@code [ \r\n]org.broadleafcommerce.common.util.StringUtil}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeSpecialCharacters(String)}
   */
  @Test
  public void testRemoveSpecialCharacters_whenRNOrgBroadleafcommerceCommonUtilStringUtil() {
    // Arrange, Act and Assert
    assertEquals("[\\r\\n]org.broadleafcommerce.common.util.StringUtil",
        StringUtil.removeSpecialCharacters("[ \\r\\n]org.broadleafcommerce.common.util.StringUtil"));
    assertEquals("[\\r\\n]org.broadleafcommerce.common.util.StringUtil",
        StringUtil.removeSpecialCharacters(" [ \\r\\n]org.broadleafcommerce.common.util.StringUtil"));
    assertEquals("[\\r\\n]org.broadleafcommerce.common.util.StringUtil",
        StringUtil.removeSpecialCharacters("[ \\r\\n] org.broadleafcommerce.common.util.StringUtil"));
    assertEquals("[\\r\\n]org.broadleafcommerce.common.util.StringUtil",
        StringUtil.removeSpecialCharacters("[ \\r\\n]org.broadleafcommerce.common.util.StringUtil "));
  }

  /**
   * Test {@link StringUtil#removeSpecialCharacters(String)}.
   * <ul>
   *   <li>When {@code [ \r\n][ \r\n]42}.</li>
   *   <li>Then return {@code [\r\n][\r\n]42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeSpecialCharacters(String)}
   */
  @Test
  public void testRemoveSpecialCharacters_whenRNRN42_thenReturnRNRN42() {
    // Arrange, Act and Assert
    assertEquals("[\\r\\n][\\r\\n]42", StringUtil.removeSpecialCharacters("[ \\r\\n][ \\r\\n]42"));
  }

  /**
   * Test {@link StringUtil#removeSpecialCharacters(String)}.
   * <ul>
   *   <li>When {@code [ \r\n][ \r\n]Input}.</li>
   *   <li>Then return {@code [\r\n][\r\n]Input}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeSpecialCharacters(String)}
   */
  @Test
  public void testRemoveSpecialCharacters_whenRNRNInput_thenReturnRNRNInput() {
    // Arrange, Act and Assert
    assertEquals("[\\r\\n][\\r\\n]Input", StringUtil.removeSpecialCharacters("[ \\r\\n][ \\r\\n]Input"));
  }

  /**
   * Test {@link StringUtil#removeSpecialCharacters(String)}.
   * <ul>
   *   <li>When {@code [ \r\n][ \r\n]null}.</li>
   *   <li>Then return {@code [\r\n][\r\n]null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeSpecialCharacters(String)}
   */
  @Test
  public void testRemoveSpecialCharacters_whenRNRNNull_thenReturnRNRNNull() {
    // Arrange, Act and Assert
    assertEquals("[\\r\\n][\\r\\n]null", StringUtil.removeSpecialCharacters("[ \\r\\n][ \\r\\n]null"));
  }

  /**
   * Test {@link StringUtil#removeSpecialCharacters(String)}.
   * <ul>
   *   <li>When {@code [ \r\n][ \r\n][ \r\n]}.</li>
   *   <li>Then return {@code [\r\n][\r\n][\r\n]}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeSpecialCharacters(String)}
   */
  @Test
  public void testRemoveSpecialCharacters_whenRNRNRN_thenReturnRNRNRN() {
    // Arrange, Act and Assert
    assertEquals("[\\r\\n][\\r\\n][\\r\\n]", StringUtil.removeSpecialCharacters("[ \\r\\n][ \\r\\n][ \\r\\n]"));
  }

  /**
   * Test {@link StringUtil#removeSpecialCharacters(String)}.
   * <ul>
   *   <li>When {@code [ \r\n][ \r\n]}.</li>
   *   <li>Then return {@code [\r\n][\r\n]}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeSpecialCharacters(String)}
   */
  @Test
  public void testRemoveSpecialCharacters_whenRNRN_thenReturnRNRN() {
    // Arrange, Act and Assert
    assertEquals("[\\r\\n][\\r\\n]", StringUtil.removeSpecialCharacters("[ \\r\\n][ \\r\\n]"));
    assertEquals("[\\r\\n][\\r\\n]", StringUtil.removeSpecialCharacters(" [ \\r\\n][ \\r\\n]"));
    assertEquals("[\\r\\n][\\r\\n]", StringUtil.removeSpecialCharacters("[ \\r\\n] [ \\r\\n]"));
    assertEquals("[\\r\\n][\\r\\n]", StringUtil.removeSpecialCharacters("[ \\r\\n][ \\r\\n] "));
    assertEquals("[\\r\\n][\\r\\n].", StringUtil.removeSpecialCharacters("[ \\r\\n][ \\r\\n]."));
    assertEquals("[\\r\\n][\\r\\n]{", StringUtil.removeSpecialCharacters("[ \\r\\n][ \\r\\n]{"));
    assertEquals("[\\r\\n].[\\r\\n]", StringUtil.removeSpecialCharacters("[ \\r\\n].[ \\r\\n]"));
    assertEquals("[\\r\\n]{[\\r\\n]", StringUtil.removeSpecialCharacters("[ \\r\\n]{[ \\r\\n]"));
  }

  /**
   * Test {@link StringUtil#removeSpecialCharacters(String)}.
   * <ul>
   *   <li>When {@code [ \r\n]}.</li>
   *   <li>Then return {@code [\r\n]}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeSpecialCharacters(String)}
   */
  @Test
  public void testRemoveSpecialCharacters_whenRN_thenReturnRN() {
    // Arrange, Act and Assert
    assertEquals("[\\r\\n]", StringUtil.removeSpecialCharacters("[ \\r\\n]"));
    assertEquals("[\\r\\n]", StringUtil.removeSpecialCharacters(" [ \\r\\n]"));
    assertEquals("[\\r\\n]", StringUtil.removeSpecialCharacters("[ \\r\\n] "));
    assertEquals("[\\r\\n].", StringUtil.removeSpecialCharacters("[ \\r\\n]."));
    assertEquals("[\\r\\n]{", StringUtil.removeSpecialCharacters("[ \\r\\n]{"));
    assertEquals(".[\\r\\n]", StringUtil.removeSpecialCharacters(".[ \\r\\n]"));
    assertEquals("{[\\r\\n]", StringUtil.removeSpecialCharacters("{[ \\r\\n]"));
    assertEquals("[\\r\\n]", StringUtil.removeSpecialCharacters("  [ \\r\\n]"));
    assertEquals("[\\r\\n]", StringUtil.removeSpecialCharacters(" [ \\r\\n] "));
    assertEquals("[\\r\\n].", StringUtil.removeSpecialCharacters(" [ \\r\\n]."));
    assertEquals("[\\r\\n]{", StringUtil.removeSpecialCharacters(" [ \\r\\n]{"));
    assertEquals(".[\\r\\n]", StringUtil.removeSpecialCharacters(" .[ \\r\\n]"));
    assertEquals("{[\\r\\n]", StringUtil.removeSpecialCharacters(" {[ \\r\\n]"));
    assertEquals("[\\r\\n]", StringUtil.removeSpecialCharacters("[ \\r\\n]  "));
    assertEquals("[\\r\\n].", StringUtil.removeSpecialCharacters("[ \\r\\n] ."));
    assertEquals("[\\r\\n]{", StringUtil.removeSpecialCharacters("[ \\r\\n] {"));
    assertEquals("[\\r\\n].", StringUtil.removeSpecialCharacters("[ \\r\\n]. "));
    assertEquals("[\\r\\n]..", StringUtil.removeSpecialCharacters("[ \\r\\n].."));
    assertEquals("[\\r\\n].{", StringUtil.removeSpecialCharacters("[ \\r\\n].{"));
    assertEquals("[\\r\\n]{", StringUtil.removeSpecialCharacters("[ \\r\\n]{ "));
    assertEquals("[\\r\\n]{.", StringUtil.removeSpecialCharacters("[ \\r\\n]{."));
    assertEquals("[\\r\\n]{{", StringUtil.removeSpecialCharacters("[ \\r\\n]{{"));
  }

  /**
   * Test {@link StringUtil#removeSpecialCharacters(String)}.
   * <ul>
   *   <li>When space space space.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeSpecialCharacters(String)}
   */
  @Test
  public void testRemoveSpecialCharacters_whenSpaceSpaceSpace_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", StringUtil.removeSpecialCharacters("   "));
  }

  /**
   * Test {@link StringUtil#removeSpecialCharacters(String)}.
   * <ul>
   *   <li>When space space.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeSpecialCharacters(String)}
   */
  @Test
  public void testRemoveSpecialCharacters_whenSpaceSpace_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", StringUtil.removeSpecialCharacters("  "));
  }

  /**
   * Test {@link StringUtil#removeSpecialCharacters(String)}.
   * <ul>
   *   <li>When space.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeSpecialCharacters(String)}
   */
  @Test
  public void testRemoveSpecialCharacters_whenSpace_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", StringUtil.removeSpecialCharacters(" "));
  }

  /**
   * Test {@link StringUtil#getMapAsJson(Map)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link HashMap#HashMap()} {@code null} is {@code null}.</li>
   *   <li>Then return {@code {"null":"null"}}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#getMapAsJson(Map)}
   */
  @Test
  public void testGetMapAsJson_givenNull_whenHashMapNullIsNull_thenReturnNullNull() {
    // Arrange
    HashMap<String, Object> objectMap = new HashMap<>();
    objectMap.put("null", "null");

    // Act and Assert
    assertEquals("{\"null\":\"null\"}", StringUtil.getMapAsJson(objectMap));
  }

  /**
   * Test {@link StringUtil#getMapAsJson(Map)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link HashMap#HashMap()} {@code null} is {@code null}.</li>
   *   <li>Then return {@code {"null":null}}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#getMapAsJson(Map)}
   */
  @Test
  public void testGetMapAsJson_givenNull_whenHashMapNullIsNull_thenReturnNullNull2() {
    // Arrange
    HashMap<String, Object> objectMap = new HashMap<>();
    objectMap.put("null", null);

    // Act and Assert
    assertEquals("{\"null\":null}", StringUtil.getMapAsJson(objectMap));
  }

  /**
   * Test {@link StringUtil#getMapAsJson(Map)}.
   * <ul>
   *   <li>Given {@code true}.</li>
   *   <li>When {@link HashMap#HashMap()} {@code null} is {@code true}.</li>
   *   <li>Then return {@code {"null":true}}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#getMapAsJson(Map)}
   */
  @Test
  public void testGetMapAsJson_givenTrue_whenHashMapNullIsTrue_thenReturnNullTrue() {
    // Arrange
    HashMap<String, Object> objectMap = new HashMap<>();
    objectMap.put("null", true);

    // Act and Assert
    assertEquals("{\"null\":true}", StringUtil.getMapAsJson(objectMap));
  }

  /**
   * Test {@link StringUtil#getMapAsJson(Map)}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.</li>
   *   <li>Then return {@code {}}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#getMapAsJson(Map)}
   */
  @Test
  public void testGetMapAsJson_whenHashMap_thenReturnLeftCurlyBracketRightCurlyBracket() {
    // Arrange, Act and Assert
    assertEquals("{}", StringUtil.getMapAsJson(new HashMap<>()));
  }

  /**
   * Test {@link StringUtil#removeNonNumerics(String)}.
   * <p>
   * Method under test: {@link StringUtil#removeNonNumerics(String)}
   */
  @Test
  public void testRemoveNonNumerics() {
    // Arrange, Act and Assert
    assertEquals("......",
        StringUtil.removeNonNumerics("java.lang.Booleanorg.broadleafcommerce.common.util.StringUtil"));
    assertEquals("......",
        StringUtil.removeNonNumerics("java.util.Map$Entryorg.broadleafcommerce.common.util.StringUtil"));
    assertEquals("......",
        StringUtil.removeNonNumerics("org.broadleafcommerce.common.util.StringUtiljava.lang.Boolean"));
    assertEquals("......",
        StringUtil.removeNonNumerics("org.broadleafcommerce.common.util.StringUtiljava.util.Map$Entry"));
    assertEquals("........", StringUtil
        .removeNonNumerics("org.broadleafcommerce.common.util.StringUtilorg.broadleafcommerce.common.util.StringUtil"));
    assertEquals("42......",
        StringUtil.removeNonNumerics("42java.lang.Booleanorg.broadleafcommerce.common.util.StringUtil"));
    assertEquals("42......",
        StringUtil.removeNonNumerics("42java.util.Map$Entryorg.broadleafcommerce.common.util.StringUtil"));
    assertEquals("42......",
        StringUtil.removeNonNumerics("42org.broadleafcommerce.common.util.StringUtiljava.lang.Boolean"));
    assertEquals("42......",
        StringUtil.removeNonNumerics("42org.broadleafcommerce.common.util.StringUtiljava.util.Map$Entry"));
    assertEquals("......",
        StringUtil.removeNonNumerics("Ujava.lang.Booleanorg.broadleafcommerce.common.util.StringUtil"));
    assertEquals("......",
        StringUtil.removeNonNumerics("Ujava.util.Map$Entryorg.broadleafcommerce.common.util.StringUtil"));
    assertEquals("......",
        StringUtil.removeNonNumerics("Uorg.broadleafcommerce.common.util.StringUtiljava.lang.Boolean"));
    assertEquals("......",
        StringUtil.removeNonNumerics("Uorg.broadleafcommerce.common.util.StringUtiljava.util.Map$Entry"));
    assertEquals("........", StringUtil.removeNonNumerics(
        "Uorg.broadleafcommerce.common.util.StringUtilorg.broadleafcommerce.common.util.StringUtil"));
  }

  /**
   * Test {@link StringUtil#removeNonNumerics(String)}.
   * <ul>
   *   <li>Then return {@code 42........}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeNonNumerics(String)}
   */
  @Test
  public void testRemoveNonNumerics_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("42........", StringUtil.removeNonNumerics(
        "42org.broadleafcommerce.common.util.StringUtilorg.broadleafcommerce.common.util.StringUtil"));
  }

  /**
   * Test {@link StringUtil#removeNonNumerics(String)}.
   * <ul>
   *   <li>Then return {@code 4242....}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeNonNumerics(String)}
   */
  @Test
  public void testRemoveNonNumerics_thenReturn4242() {
    // Arrange, Act and Assert
    assertEquals("4242....", StringUtil.removeNonNumerics("4242org.broadleafcommerce.common.util.StringUtil"));
    assertEquals("42....42", StringUtil.removeNonNumerics("42org.broadleafcommerce.common.util.StringUtil42"));
  }

  /**
   * Test {@link StringUtil#removeNonNumerics(String)}.
   * <ul>
   *   <li>When {@code 42[^\d.]+42}.</li>
   *   <li>Then return {@code 42.42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeNonNumerics(String)}
   */
  @Test
  public void testRemoveNonNumerics_when42D42_thenReturn4242() {
    // Arrange, Act and Assert
    assertEquals("42.42", StringUtil.removeNonNumerics("42[^\\d.]+42"));
  }

  /**
   * Test {@link StringUtil#removeNonNumerics(String)}.
   * <ul>
   *   <li>When {@code 42[^\d.]+[^\d.]+}.</li>
   *   <li>Then return {@code 42..}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeNonNumerics(String)}
   */
  @Test
  public void testRemoveNonNumerics_when42DD_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("42..", StringUtil.removeNonNumerics("42[^\\d.]+[^\\d.]+"));
  }

  /**
   * Test {@link StringUtil#removeNonNumerics(String)}.
   * <ul>
   *   <li>When {@code 42[^\d.]+java.lang.Boolean}.</li>
   *   <li>Then return {@code 42...}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeNonNumerics(String)}
   */
  @Test
  public void testRemoveNonNumerics_when42DJavaLangBoolean_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("42...", StringUtil.removeNonNumerics("42[^\\d.]+java.lang.Boolean"));
  }

  /**
   * Test {@link StringUtil#removeNonNumerics(String)}.
   * <ul>
   *   <li>When {@code 42[^\d.]+java.util.Map$Entry}.</li>
   *   <li>Then return {@code 42...}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeNonNumerics(String)}
   */
  @Test
  public void testRemoveNonNumerics_when42DJavaUtilMapEntry_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("42...", StringUtil.removeNonNumerics("42[^\\d.]+java.util.Map$Entry"));
  }

  /**
   * Test {@link StringUtil#removeNonNumerics(String)}.
   * <ul>
   *   <li>When {@code 42[^\d.]+null}.</li>
   *   <li>Then return {@code 42.}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeNonNumerics(String)}
   */
  @Test
  public void testRemoveNonNumerics_when42DNull_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("42.", StringUtil.removeNonNumerics("42[^\\d.]+null"));
  }

  /**
   * Test {@link StringUtil#removeNonNumerics(String)}.
   * <ul>
   *   <li>When {@code 42[^\d.]+org.broadleafcommerce.common.util.StringUtil}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeNonNumerics(String)}
   */
  @Test
  public void testRemoveNonNumerics_when42DOrgBroadleafcommerceCommonUtilStringUtil() {
    // Arrange, Act and Assert
    assertEquals("42.....", StringUtil.removeNonNumerics("42[^\\d.]+org.broadleafcommerce.common.util.StringUtil"));
  }

  /**
   * Test {@link StringUtil#removeNonNumerics(String)}.
   * <ul>
   *   <li>When {@code 42[^\d.]+U}.</li>
   *   <li>Then return {@code 42.}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeNonNumerics(String)}
   */
  @Test
  public void testRemoveNonNumerics_when42DU_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("42.", StringUtil.removeNonNumerics("42[^\\d.]+U"));
  }

  /**
   * Test {@link StringUtil#removeNonNumerics(String)}.
   * <ul>
   *   <li>When {@code 42[^\d.]+Value}.</li>
   *   <li>Then return {@code 42.}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeNonNumerics(String)}
   */
  @Test
  public void testRemoveNonNumerics_when42DValue_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("42.", StringUtil.removeNonNumerics("42[^\\d.]+Value"));
  }

  /**
   * Test {@link StringUtil#removeNonNumerics(String)}.
   * <ul>
   *   <li>When {@code 42[^\d.]+}.</li>
   *   <li>Then return {@code 42.}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeNonNumerics(String)}
   */
  @Test
  public void testRemoveNonNumerics_when42D_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("42.", StringUtil.removeNonNumerics("42[^\\d.]+"));
    assertEquals("42..", StringUtil.removeNonNumerics("42[^\\d.]+."));
    assertEquals("42.", StringUtil.removeNonNumerics("42[^\\d.]+{"));
    assertEquals("42..", StringUtil.removeNonNumerics("42.[^\\d.]+"));
    assertEquals("42.", StringUtil.removeNonNumerics("42{[^\\d.]+"));
  }

  /**
   * Test {@link StringUtil#removeNonNumerics(String)}.
   * <ul>
   *   <li>When {@code 42.java.lang.Boolean}.</li>
   *   <li>Then return {@code 42...}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeNonNumerics(String)}
   */
  @Test
  public void testRemoveNonNumerics_when42JavaLangBoolean_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("42...", StringUtil.removeNonNumerics("42.java.lang.Boolean"));
    assertEquals("42..", StringUtil.removeNonNumerics("42{java.lang.Boolean"));
  }

  /**
   * Test {@link StringUtil#removeNonNumerics(String)}.
   * <ul>
   *   <li>When {@code 42.java.util.Map$Entry}.</li>
   *   <li>Then return {@code 42...}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeNonNumerics(String)}
   */
  @Test
  public void testRemoveNonNumerics_when42JavaUtilMapEntry_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("42...", StringUtil.removeNonNumerics("42.java.util.Map$Entry"));
    assertEquals("42..", StringUtil.removeNonNumerics("42{java.util.Map$Entry"));
  }

  /**
   * Test {@link StringUtil#removeNonNumerics(String)}.
   * <ul>
   *   <li>When {@code 42.null}.</li>
   *   <li>Then return {@code 42.}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeNonNumerics(String)}
   */
  @Test
  public void testRemoveNonNumerics_when42Null_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("42.", StringUtil.removeNonNumerics("42.null"));
    assertEquals("42", StringUtil.removeNonNumerics("42{null"));
  }

  /**
   * Test {@link StringUtil#removeNonNumerics(String)}.
   * <ul>
   *   <li>When {@code 42.org.broadleafcommerce.common.util.StringUtil}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeNonNumerics(String)}
   */
  @Test
  public void testRemoveNonNumerics_when42OrgBroadleafcommerceCommonUtilStringUtil() {
    // Arrange, Act and Assert
    assertEquals("42.....", StringUtil.removeNonNumerics("42.org.broadleafcommerce.common.util.StringUtil"));
    assertEquals("42....", StringUtil.removeNonNumerics("42{org.broadleafcommerce.common.util.StringUtil"));
  }

  /**
   * Test {@link StringUtil#removeNonNumerics(String)}.
   * <ul>
   *   <li>When {@code 42UValue}.</li>
   *   <li>Then return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeNonNumerics(String)}
   */
  @Test
  public void testRemoveNonNumerics_when42UValue_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("42", StringUtil.removeNonNumerics("42UValue"));
  }

  /**
   * Test {@link StringUtil#removeNonNumerics(String)}.
   * <ul>
   *   <li>When {@code 42.U}.</li>
   *   <li>Then return {@code 42.}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeNonNumerics(String)}
   */
  @Test
  public void testRemoveNonNumerics_when42U_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("42.", StringUtil.removeNonNumerics("42.U"));
    assertEquals("42", StringUtil.removeNonNumerics("42{U"));
  }

  /**
   * Test {@link StringUtil#removeNonNumerics(String)}.
   * <ul>
   *   <li>When {@code 42Ujava.lang.Boolean}.</li>
   *   <li>Then return {@code 42..}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeNonNumerics(String)}
   */
  @Test
  public void testRemoveNonNumerics_when42UjavaLangBoolean_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("42..", StringUtil.removeNonNumerics("42Ujava.lang.Boolean"));
  }

  /**
   * Test {@link StringUtil#removeNonNumerics(String)}.
   * <ul>
   *   <li>When {@code 42Ujava.util.Map$Entry}.</li>
   *   <li>Then return {@code 42..}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeNonNumerics(String)}
   */
  @Test
  public void testRemoveNonNumerics_when42UjavaUtilMapEntry_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("42..", StringUtil.removeNonNumerics("42Ujava.util.Map$Entry"));
  }

  /**
   * Test {@link StringUtil#removeNonNumerics(String)}.
   * <ul>
   *   <li>When {@code 42Unull}.</li>
   *   <li>Then return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeNonNumerics(String)}
   */
  @Test
  public void testRemoveNonNumerics_when42Unull_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("42", StringUtil.removeNonNumerics("42Unull"));
  }

  /**
   * Test {@link StringUtil#removeNonNumerics(String)}.
   * <ul>
   *   <li>When {@code 42Uorg.broadleafcommerce.common.util.StringUtil}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeNonNumerics(String)}
   */
  @Test
  public void testRemoveNonNumerics_when42UorgBroadleafcommerceCommonUtilStringUtil() {
    // Arrange, Act and Assert
    assertEquals("42....", StringUtil.removeNonNumerics("42Uorg.broadleafcommerce.common.util.StringUtil"));
  }

  /**
   * Test {@link StringUtil#removeNonNumerics(String)}.
   * <ul>
   *   <li>When {@code 42Value42}.</li>
   *   <li>Then return {@code 4242}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeNonNumerics(String)}
   */
  @Test
  public void testRemoveNonNumerics_when42Value42_thenReturn4242() {
    // Arrange, Act and Assert
    assertEquals("4242", StringUtil.removeNonNumerics("42Value42"));
  }

  /**
   * Test {@link StringUtil#removeNonNumerics(String)}.
   * <ul>
   *   <li>When {@code 42Value[^\d.]+}.</li>
   *   <li>Then return {@code 42.}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeNonNumerics(String)}
   */
  @Test
  public void testRemoveNonNumerics_when42ValueD_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("42.", StringUtil.removeNonNumerics("42Value[^\\d.]+"));
  }

  /**
   * Test {@link StringUtil#removeNonNumerics(String)}.
   * <ul>
   *   <li>When {@code 42ValueU}.</li>
   *   <li>Then return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeNonNumerics(String)}
   */
  @Test
  public void testRemoveNonNumerics_when42ValueU_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("42", StringUtil.removeNonNumerics("42ValueU"));
  }

  /**
   * Test {@link StringUtil#removeNonNumerics(String)}.
   * <ul>
   *   <li>When {@code 42ValueValue}.</li>
   *   <li>Then return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeNonNumerics(String)}
   */
  @Test
  public void testRemoveNonNumerics_when42ValueValue_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("42", StringUtil.removeNonNumerics("42ValueValue"));
  }

  /**
   * Test {@link StringUtil#removeNonNumerics(String)}.
   * <ul>
   *   <li>When {@code 42Value}.</li>
   *   <li>Then return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeNonNumerics(String)}
   */
  @Test
  public void testRemoveNonNumerics_when42Value_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("42", StringUtil.removeNonNumerics("42Value"));
    assertEquals("42.", StringUtil.removeNonNumerics("42Value."));
    assertEquals("42", StringUtil.removeNonNumerics("42Value{"));
    assertEquals("42.", StringUtil.removeNonNumerics("42.Value"));
    assertEquals("42", StringUtil.removeNonNumerics("42{Value"));
  }

  /**
   * Test {@link StringUtil#removeNonNumerics(String)}.
   * <ul>
   *   <li>When {@code 42Valuejava.lang.Boolean}.</li>
   *   <li>Then return {@code 42..}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeNonNumerics(String)}
   */
  @Test
  public void testRemoveNonNumerics_when42ValuejavaLangBoolean_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("42..", StringUtil.removeNonNumerics("42Valuejava.lang.Boolean"));
  }

  /**
   * Test {@link StringUtil#removeNonNumerics(String)}.
   * <ul>
   *   <li>When {@code 42Valuejava.util.Map$Entry}.</li>
   *   <li>Then return {@code 42..}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeNonNumerics(String)}
   */
  @Test
  public void testRemoveNonNumerics_when42ValuejavaUtilMapEntry_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("42..", StringUtil.removeNonNumerics("42Valuejava.util.Map$Entry"));
  }

  /**
   * Test {@link StringUtil#removeNonNumerics(String)}.
   * <ul>
   *   <li>When {@code 42Valuenull}.</li>
   *   <li>Then return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeNonNumerics(String)}
   */
  @Test
  public void testRemoveNonNumerics_when42Valuenull_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("42", StringUtil.removeNonNumerics("42Valuenull"));
  }

  /**
   * Test {@link StringUtil#removeNonNumerics(String)}.
   * <ul>
   *   <li>When {@code 42Valueorg.broadleafcommerce.common.util.StringUtil}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeNonNumerics(String)}
   */
  @Test
  public void testRemoveNonNumerics_when42ValueorgBroadleafcommerceCommonUtilStringUtil() {
    // Arrange, Act and Assert
    assertEquals("42....", StringUtil.removeNonNumerics("42Valueorg.broadleafcommerce.common.util.StringUtil"));
  }

  /**
   * Test {@link StringUtil#removeNonNumerics(String)}.
   * <ul>
   *   <li>When {@code 42}.</li>
   *   <li>Then return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeNonNumerics(String)}
   */
  @Test
  public void testRemoveNonNumerics_when42_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("42", StringUtil.removeNonNumerics("42"));
    assertEquals("42", StringUtil.removeNonNumerics("42{"));
    assertEquals("42", StringUtil.removeNonNumerics("{42"));
    assertEquals("42.", StringUtil.removeNonNumerics("42.{"));
    assertEquals("42.", StringUtil.removeNonNumerics("42{."));
    assertEquals("42", StringUtil.removeNonNumerics("42{{"));
  }

  /**
   * Test {@link StringUtil#removeNonNumerics(String)}.
   * <ul>
   *   <li>When {@code 42java.lang.Boolean42}.</li>
   *   <li>Then return {@code 42..42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeNonNumerics(String)}
   */
  @Test
  public void testRemoveNonNumerics_when42javaLangBoolean42_thenReturn4242() {
    // Arrange, Act and Assert
    assertEquals("42..42", StringUtil.removeNonNumerics("42java.lang.Boolean42"));
  }

  /**
   * Test {@link StringUtil#removeNonNumerics(String)}.
   * <ul>
   *   <li>When {@code 42java.lang.Boolean[^\d.]+}.</li>
   *   <li>Then return {@code 42...}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeNonNumerics(String)}
   */
  @Test
  public void testRemoveNonNumerics_when42javaLangBooleanD_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("42...", StringUtil.removeNonNumerics("42java.lang.Boolean[^\\d.]+"));
  }

  /**
   * Test {@link StringUtil#removeNonNumerics(String)}.
   * <ul>
   *   <li>When {@code 42java.lang.BooleanU}.</li>
   *   <li>Then return {@code 42..}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeNonNumerics(String)}
   */
  @Test
  public void testRemoveNonNumerics_when42javaLangBooleanU_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("42..", StringUtil.removeNonNumerics("42java.lang.BooleanU"));
  }

  /**
   * Test {@link StringUtil#removeNonNumerics(String)}.
   * <ul>
   *   <li>When {@code 42java.lang.BooleanValue}.</li>
   *   <li>Then return {@code 42..}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeNonNumerics(String)}
   */
  @Test
  public void testRemoveNonNumerics_when42javaLangBooleanValue_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("42..", StringUtil.removeNonNumerics("42java.lang.BooleanValue"));
  }

  /**
   * Test {@link StringUtil#removeNonNumerics(String)}.
   * <ul>
   *   <li>When {@code 42java.lang.Boolean}.</li>
   *   <li>Then return {@code 42..}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeNonNumerics(String)}
   */
  @Test
  public void testRemoveNonNumerics_when42javaLangBoolean_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("42..", StringUtil.removeNonNumerics("42java.lang.Boolean"));
    assertEquals("42...", StringUtil.removeNonNumerics("42java.lang.Boolean."));
    assertEquals("42..", StringUtil.removeNonNumerics("42java.lang.Boolean{"));
  }

  /**
   * Test {@link StringUtil#removeNonNumerics(String)}.
   * <ul>
   *   <li>When {@code 42java.lang.Booleanjava.lang.Boolean}.</li>
   *   <li>Then return {@code 42....}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeNonNumerics(String)}
   */
  @Test
  public void testRemoveNonNumerics_when42javaLangBooleanjavaLangBoolean_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("42....", StringUtil.removeNonNumerics("42java.lang.Booleanjava.lang.Boolean"));
  }

  /**
   * Test {@link StringUtil#removeNonNumerics(String)}.
   * <ul>
   *   <li>When {@code 42java.lang.Booleanjava.util.Map$Entry}.</li>
   *   <li>Then return {@code 42....}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeNonNumerics(String)}
   */
  @Test
  public void testRemoveNonNumerics_when42javaLangBooleanjavaUtilMapEntry_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("42....", StringUtil.removeNonNumerics("42java.lang.Booleanjava.util.Map$Entry"));
  }

  /**
   * Test {@link StringUtil#removeNonNumerics(String)}.
   * <ul>
   *   <li>When {@code 42java.lang.Booleannull}.</li>
   *   <li>Then return {@code 42..}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeNonNumerics(String)}
   */
  @Test
  public void testRemoveNonNumerics_when42javaLangBooleannull_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("42..", StringUtil.removeNonNumerics("42java.lang.Booleannull"));
  }

  /**
   * Test {@link StringUtil#removeNonNumerics(String)}.
   * <ul>
   *   <li>When {@code 42java.util.Map$Entry42}.</li>
   *   <li>Then return {@code 42..42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeNonNumerics(String)}
   */
  @Test
  public void testRemoveNonNumerics_when42javaUtilMapEntry42_thenReturn4242() {
    // Arrange, Act and Assert
    assertEquals("42..42", StringUtil.removeNonNumerics("42java.util.Map$Entry42"));
  }

  /**
   * Test {@link StringUtil#removeNonNumerics(String)}.
   * <ul>
   *   <li>When {@code 42java.util.Map$Entry[^\d.]+}.</li>
   *   <li>Then return {@code 42...}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeNonNumerics(String)}
   */
  @Test
  public void testRemoveNonNumerics_when42javaUtilMapEntryD_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("42...", StringUtil.removeNonNumerics("42java.util.Map$Entry[^\\d.]+"));
  }

  /**
   * Test {@link StringUtil#removeNonNumerics(String)}.
   * <ul>
   *   <li>When {@code 42java.util.Map$EntryU}.</li>
   *   <li>Then return {@code 42..}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeNonNumerics(String)}
   */
  @Test
  public void testRemoveNonNumerics_when42javaUtilMapEntryU_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("42..", StringUtil.removeNonNumerics("42java.util.Map$EntryU"));
  }

  /**
   * Test {@link StringUtil#removeNonNumerics(String)}.
   * <ul>
   *   <li>When {@code 42java.util.Map$EntryValue}.</li>
   *   <li>Then return {@code 42..}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeNonNumerics(String)}
   */
  @Test
  public void testRemoveNonNumerics_when42javaUtilMapEntryValue_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("42..", StringUtil.removeNonNumerics("42java.util.Map$EntryValue"));
  }

  /**
   * Test {@link StringUtil#removeNonNumerics(String)}.
   * <ul>
   *   <li>When {@code 42java.util.Map$Entry}.</li>
   *   <li>Then return {@code 42..}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeNonNumerics(String)}
   */
  @Test
  public void testRemoveNonNumerics_when42javaUtilMapEntry_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("42..", StringUtil.removeNonNumerics("42java.util.Map$Entry"));
    assertEquals("42...", StringUtil.removeNonNumerics("42java.util.Map$Entry."));
    assertEquals("42..", StringUtil.removeNonNumerics("42java.util.Map$Entry{"));
  }

  /**
   * Test {@link StringUtil#removeNonNumerics(String)}.
   * <ul>
   *   <li>When {@code 42java.util.Map$Entryjava.lang.Boolean}.</li>
   *   <li>Then return {@code 42....}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeNonNumerics(String)}
   */
  @Test
  public void testRemoveNonNumerics_when42javaUtilMapEntryjavaLangBoolean_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("42....", StringUtil.removeNonNumerics("42java.util.Map$Entryjava.lang.Boolean"));
  }

  /**
   * Test {@link StringUtil#removeNonNumerics(String)}.
   * <ul>
   *   <li>When {@code 42java.util.Map$Entryjava.util.Map$Entry}.</li>
   *   <li>Then return {@code 42....}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeNonNumerics(String)}
   */
  @Test
  public void testRemoveNonNumerics_when42javaUtilMapEntryjavaUtilMapEntry_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("42....", StringUtil.removeNonNumerics("42java.util.Map$Entryjava.util.Map$Entry"));
  }

  /**
   * Test {@link StringUtil#removeNonNumerics(String)}.
   * <ul>
   *   <li>When {@code 42java.util.Map$Entrynull}.</li>
   *   <li>Then return {@code 42..}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeNonNumerics(String)}
   */
  @Test
  public void testRemoveNonNumerics_when42javaUtilMapEntrynull_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("42..", StringUtil.removeNonNumerics("42java.util.Map$Entrynull"));
  }

  /**
   * Test {@link StringUtil#removeNonNumerics(String)}.
   * <ul>
   *   <li>When {@code 42null42}.</li>
   *   <li>Then return {@code 4242}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeNonNumerics(String)}
   */
  @Test
  public void testRemoveNonNumerics_when42null42_thenReturn4242() {
    // Arrange, Act and Assert
    assertEquals("4242", StringUtil.removeNonNumerics("42null42"));
  }

  /**
   * Test {@link StringUtil#removeNonNumerics(String)}.
   * <ul>
   *   <li>When {@code 42null[^\d.]+}.</li>
   *   <li>Then return {@code 42.}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeNonNumerics(String)}
   */
  @Test
  public void testRemoveNonNumerics_when42nullD_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("42.", StringUtil.removeNonNumerics("42null[^\\d.]+"));
  }

  /**
   * Test {@link StringUtil#removeNonNumerics(String)}.
   * <ul>
   *   <li>When {@code 42nullU}.</li>
   *   <li>Then return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeNonNumerics(String)}
   */
  @Test
  public void testRemoveNonNumerics_when42nullU_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("42", StringUtil.removeNonNumerics("42nullU"));
  }

  /**
   * Test {@link StringUtil#removeNonNumerics(String)}.
   * <ul>
   *   <li>When {@code 42nullValue}.</li>
   *   <li>Then return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeNonNumerics(String)}
   */
  @Test
  public void testRemoveNonNumerics_when42nullValue_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("42", StringUtil.removeNonNumerics("42nullValue"));
  }

  /**
   * Test {@link StringUtil#removeNonNumerics(String)}.
   * <ul>
   *   <li>When {@code 42null}.</li>
   *   <li>Then return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeNonNumerics(String)}
   */
  @Test
  public void testRemoveNonNumerics_when42null_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("42", StringUtil.removeNonNumerics("42null"));
    assertEquals("42.", StringUtil.removeNonNumerics("42null."));
    assertEquals("42", StringUtil.removeNonNumerics("42null{"));
  }

  /**
   * Test {@link StringUtil#removeNonNumerics(String)}.
   * <ul>
   *   <li>When {@code 42nulljava.lang.Boolean}.</li>
   *   <li>Then return {@code 42..}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeNonNumerics(String)}
   */
  @Test
  public void testRemoveNonNumerics_when42nulljavaLangBoolean_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("42..", StringUtil.removeNonNumerics("42nulljava.lang.Boolean"));
  }

  /**
   * Test {@link StringUtil#removeNonNumerics(String)}.
   * <ul>
   *   <li>When {@code 42nulljava.util.Map$Entry}.</li>
   *   <li>Then return {@code 42..}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeNonNumerics(String)}
   */
  @Test
  public void testRemoveNonNumerics_when42nulljavaUtilMapEntry_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("42..", StringUtil.removeNonNumerics("42nulljava.util.Map$Entry"));
  }

  /**
   * Test {@link StringUtil#removeNonNumerics(String)}.
   * <ul>
   *   <li>When {@code 42nullnull}.</li>
   *   <li>Then return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeNonNumerics(String)}
   */
  @Test
  public void testRemoveNonNumerics_when42nullnull_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("42", StringUtil.removeNonNumerics("42nullnull"));
  }

  /**
   * Test {@link StringUtil#removeNonNumerics(String)}.
   * <ul>
   *   <li>When {@code 42nullorg.broadleafcommerce.common.util.StringUtil}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeNonNumerics(String)}
   */
  @Test
  public void testRemoveNonNumerics_when42nullorgBroadleafcommerceCommonUtilStringUtil() {
    // Arrange, Act and Assert
    assertEquals("42....", StringUtil.removeNonNumerics("42nullorg.broadleafcommerce.common.util.StringUtil"));
  }

  /**
   * Test {@link StringUtil#removeNonNumerics(String)}.
   * <ul>
   *   <li>When {@code 42org.broadleafcommerce.common.util.StringUtil}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeNonNumerics(String)}
   */
  @Test
  public void testRemoveNonNumerics_when42orgBroadleafcommerceCommonUtilStringUtil() {
    // Arrange, Act and Assert
    assertEquals("42....", StringUtil.removeNonNumerics("42org.broadleafcommerce.common.util.StringUtil"));
    assertEquals("42.....", StringUtil.removeNonNumerics("42org.broadleafcommerce.common.util.StringUtil."));
    assertEquals("42....", StringUtil.removeNonNumerics("42org.broadleafcommerce.common.util.StringUtil{"));
  }

  /**
   * Test {@link StringUtil#removeNonNumerics(String)}.
   * <ul>
   *   <li>When {@code 42org.broadleafcommerce.common.util.StringUtil[^\d.]+}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeNonNumerics(String)}
   */
  @Test
  public void testRemoveNonNumerics_when42orgBroadleafcommerceCommonUtilStringUtilD() {
    // Arrange, Act and Assert
    assertEquals("42.....", StringUtil.removeNonNumerics("42org.broadleafcommerce.common.util.StringUtil[^\\d.]+"));
  }

  /**
   * Test {@link StringUtil#removeNonNumerics(String)}.
   * <ul>
   *   <li>When {@code 42org.broadleafcommerce.common.util.StringUtilU}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeNonNumerics(String)}
   */
  @Test
  public void testRemoveNonNumerics_when42orgBroadleafcommerceCommonUtilStringUtilU() {
    // Arrange, Act and Assert
    assertEquals("42....", StringUtil.removeNonNumerics("42org.broadleafcommerce.common.util.StringUtilU"));
  }

  /**
   * Test {@link StringUtil#removeNonNumerics(String)}.
   * <ul>
   *   <li>When {@code 42org.broadleafcommerce.common.util.StringUtilValue}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeNonNumerics(String)}
   */
  @Test
  public void testRemoveNonNumerics_when42orgBroadleafcommerceCommonUtilStringUtilValue() {
    // Arrange, Act and Assert
    assertEquals("42....", StringUtil.removeNonNumerics("42org.broadleafcommerce.common.util.StringUtilValue"));
  }

  /**
   * Test {@link StringUtil#removeNonNumerics(String)}.
   * <ul>
   *   <li>When {@code 42org.broadleafcommerce.common.util.StringUtilnull}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeNonNumerics(String)}
   */
  @Test
  public void testRemoveNonNumerics_when42orgBroadleafcommerceCommonUtilStringUtilnull() {
    // Arrange, Act and Assert
    assertEquals("42....", StringUtil.removeNonNumerics("42org.broadleafcommerce.common.util.StringUtilnull"));
  }

  /**
   * Test {@link StringUtil#removeNonNumerics(String)}.
   * <ul>
   *   <li>When {@code 42U42}.</li>
   *   <li>Then return {@code 4242}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeNonNumerics(String)}
   */
  @Test
  public void testRemoveNonNumerics_when42u42_thenReturn4242() {
    // Arrange, Act and Assert
    assertEquals("4242", StringUtil.removeNonNumerics("42U42"));
  }

  /**
   * Test {@link StringUtil#removeNonNumerics(String)}.
   * <ul>
   *   <li>When {@code 42U[^\d.]+}.</li>
   *   <li>Then return {@code 42.}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeNonNumerics(String)}
   */
  @Test
  public void testRemoveNonNumerics_when42uD_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("42.", StringUtil.removeNonNumerics("42U[^\\d.]+"));
  }

  /**
   * Test {@link StringUtil#removeNonNumerics(String)}.
   * <ul>
   *   <li>When {@code 42U}.</li>
   *   <li>Then return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeNonNumerics(String)}
   */
  @Test
  public void testRemoveNonNumerics_when42u_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("42", StringUtil.removeNonNumerics("42U"));
    assertEquals("42.", StringUtil.removeNonNumerics("42U."));
    assertEquals("42", StringUtil.removeNonNumerics("42U{"));
  }

  /**
   * Test {@link StringUtil#removeNonNumerics(String)}.
   * <ul>
   *   <li>When {@code 42UU}.</li>
   *   <li>Then return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeNonNumerics(String)}
   */
  @Test
  public void testRemoveNonNumerics_when42uu_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("42", StringUtil.removeNonNumerics("42UU"));
  }

  /**
   * Test {@link StringUtil#removeNonNumerics(String)}.
   * <ul>
   *   <li>When {@code 4242[^\d.]+}.</li>
   *   <li>Then return {@code 4242.}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeNonNumerics(String)}
   */
  @Test
  public void testRemoveNonNumerics_when4242D_thenReturn4242() {
    // Arrange, Act and Assert
    assertEquals("4242.", StringUtil.removeNonNumerics("4242[^\\d.]+"));
  }

  /**
   * Test {@link StringUtil#removeNonNumerics(String)}.
   * <ul>
   *   <li>When {@code 4242Value}.</li>
   *   <li>Then return {@code 4242}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeNonNumerics(String)}
   */
  @Test
  public void testRemoveNonNumerics_when4242Value_thenReturn4242() {
    // Arrange, Act and Assert
    assertEquals("4242", StringUtil.removeNonNumerics("4242Value"));
  }

  /**
   * Test {@link StringUtil#removeNonNumerics(String)}.
   * <ul>
   *   <li>When {@code 4242{}.</li>
   *   <li>Then return {@code 4242}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeNonNumerics(String)}
   */
  @Test
  public void testRemoveNonNumerics_when4242_thenReturn4242() {
    // Arrange, Act and Assert
    assertEquals("4242", StringUtil.removeNonNumerics("4242{"));
    assertEquals("4242", StringUtil.removeNonNumerics("42{42"));
  }

  /**
   * Test {@link StringUtil#removeNonNumerics(String)}.
   * <ul>
   *   <li>When {@code 4242java.lang.Boolean}.</li>
   *   <li>Then return {@code 4242..}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeNonNumerics(String)}
   */
  @Test
  public void testRemoveNonNumerics_when4242javaLangBoolean_thenReturn4242() {
    // Arrange, Act and Assert
    assertEquals("4242..", StringUtil.removeNonNumerics("4242java.lang.Boolean"));
  }

  /**
   * Test {@link StringUtil#removeNonNumerics(String)}.
   * <ul>
   *   <li>When {@code 4242java.util.Map$Entry}.</li>
   *   <li>Then return {@code 4242..}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeNonNumerics(String)}
   */
  @Test
  public void testRemoveNonNumerics_when4242javaUtilMapEntry_thenReturn4242() {
    // Arrange, Act and Assert
    assertEquals("4242..", StringUtil.removeNonNumerics("4242java.util.Map$Entry"));
  }

  /**
   * Test {@link StringUtil#removeNonNumerics(String)}.
   * <ul>
   *   <li>When {@code 4242null}.</li>
   *   <li>Then return {@code 4242}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeNonNumerics(String)}
   */
  @Test
  public void testRemoveNonNumerics_when4242null_thenReturn4242() {
    // Arrange, Act and Assert
    assertEquals("4242", StringUtil.removeNonNumerics("4242null"));
  }

  /**
   * Test {@link StringUtil#removeNonNumerics(String)}.
   * <ul>
   *   <li>When {@code 4242U}.</li>
   *   <li>Then return {@code 4242}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeNonNumerics(String)}
   */
  @Test
  public void testRemoveNonNumerics_when4242u_thenReturn4242() {
    // Arrange, Act and Assert
    assertEquals("4242", StringUtil.removeNonNumerics("4242U"));
  }

  /**
   * Test {@link StringUtil#removeNonNumerics(String)}.
   * <ul>
   *   <li>When {@code [^\d.]+42}.</li>
   *   <li>Then return {@code .42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeNonNumerics(String)}
   */
  @Test
  public void testRemoveNonNumerics_whenD42_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals(".42", StringUtil.removeNonNumerics("[^\\d.]+42"));
  }

  /**
   * Test {@link StringUtil#removeNonNumerics(String)}.
   * <ul>
   *   <li>When {@code [^\d.]+[^\d.]+}.</li>
   *   <li>Then return {@code ..}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeNonNumerics(String)}
   */
  @Test
  public void testRemoveNonNumerics_whenDD_thenReturnDotDot() {
    // Arrange, Act and Assert
    assertEquals("..", StringUtil.removeNonNumerics("[^\\d.]+[^\\d.]+"));
  }

  /**
   * Test {@link StringUtil#removeNonNumerics(String)}.
   * <ul>
   *   <li>When {@code [^\d.]+java.lang.Boolean}.</li>
   *   <li>Then return {@code ...}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeNonNumerics(String)}
   */
  @Test
  public void testRemoveNonNumerics_whenDJavaLangBoolean_thenReturnDotDotDot() {
    // Arrange, Act and Assert
    assertEquals("...", StringUtil.removeNonNumerics("[^\\d.]+java.lang.Boolean"));
  }

  /**
   * Test {@link StringUtil#removeNonNumerics(String)}.
   * <ul>
   *   <li>When {@code [^\d.]+java.util.Map$Entry}.</li>
   *   <li>Then return {@code ...}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeNonNumerics(String)}
   */
  @Test
  public void testRemoveNonNumerics_whenDJavaUtilMapEntry_thenReturnDotDotDot() {
    // Arrange, Act and Assert
    assertEquals("...", StringUtil.removeNonNumerics("[^\\d.]+java.util.Map$Entry"));
  }

  /**
   * Test {@link StringUtil#removeNonNumerics(String)}.
   * <ul>
   *   <li>When {@code [^\d.]+null}.</li>
   *   <li>Then return {@code .}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeNonNumerics(String)}
   */
  @Test
  public void testRemoveNonNumerics_whenDNull_thenReturnDot() {
    // Arrange, Act and Assert
    assertEquals(".", StringUtil.removeNonNumerics("[^\\d.]+null"));
  }

  /**
   * Test {@link StringUtil#removeNonNumerics(String)}.
   * <ul>
   *   <li>When {@code [^\d.]+org.broadleafcommerce.common.util.StringUtil}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeNonNumerics(String)}
   */
  @Test
  public void testRemoveNonNumerics_whenDOrgBroadleafcommerceCommonUtilStringUtil() {
    // Arrange, Act and Assert
    assertEquals(".....", StringUtil.removeNonNumerics("[^\\d.]+org.broadleafcommerce.common.util.StringUtil"));
  }

  /**
   * Test {@link StringUtil#removeNonNumerics(String)}.
   * <ul>
   *   <li>When {@code [^\d.]+U}.</li>
   *   <li>Then return {@code .}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeNonNumerics(String)}
   */
  @Test
  public void testRemoveNonNumerics_whenDU_thenReturnDot() {
    // Arrange, Act and Assert
    assertEquals(".", StringUtil.removeNonNumerics("[^\\d.]+U"));
  }

  /**
   * Test {@link StringUtil#removeNonNumerics(String)}.
   * <ul>
   *   <li>When {@code [^\d.]+Value}.</li>
   *   <li>Then return {@code .}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeNonNumerics(String)}
   */
  @Test
  public void testRemoveNonNumerics_whenDValue_thenReturnDot() {
    // Arrange, Act and Assert
    assertEquals(".", StringUtil.removeNonNumerics("[^\\d.]+Value"));
  }

  /**
   * Test {@link StringUtil#removeNonNumerics(String)}.
   * <ul>
   *   <li>When {@code [^\d.]+}.</li>
   *   <li>Then return {@code .}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeNonNumerics(String)}
   */
  @Test
  public void testRemoveNonNumerics_whenD_thenReturnDot() {
    // Arrange, Act and Assert
    assertEquals(".", StringUtil.removeNonNumerics("[^\\d.]+"));
    assertEquals(".", StringUtil.removeNonNumerics("[^\\d.]+{"));
    assertEquals(".", StringUtil.removeNonNumerics("{[^\\d.]+"));
  }

  /**
   * Test {@link StringUtil#removeNonNumerics(String)}.
   * <ul>
   *   <li>When {@code [^\d.]+.}.</li>
   *   <li>Then return {@code ..}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeNonNumerics(String)}
   */
  @Test
  public void testRemoveNonNumerics_whenD_thenReturnDotDot() {
    // Arrange, Act and Assert
    assertEquals("..", StringUtil.removeNonNumerics("[^\\d.]+."));
    assertEquals("..", StringUtil.removeNonNumerics(".[^\\d.]+"));
  }

  /**
   * Test {@link StringUtil#removeNonNumerics(String)}.
   * <ul>
   *   <li>When {@code .{}.</li>
   *   <li>Then return {@code .}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeNonNumerics(String)}
   */
  @Test
  public void testRemoveNonNumerics_whenDotLeftCurlyBracket_thenReturnDot() {
    // Arrange, Act and Assert
    assertEquals(".", StringUtil.removeNonNumerics(".{"));
  }

  /**
   * Test {@link StringUtil#removeNonNumerics(String)}.
   * <ul>
   *   <li>When {@code java.lang.Boolean42}.</li>
   *   <li>Then return {@code ..42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeNonNumerics(String)}
   */
  @Test
  public void testRemoveNonNumerics_whenJavaLangBoolean42_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("..42", StringUtil.removeNonNumerics("java.lang.Boolean42"));
  }

  /**
   * Test {@link StringUtil#removeNonNumerics(String)}.
   * <ul>
   *   <li>When {@code java.lang.Boolean[^\d.]+}.</li>
   *   <li>Then return {@code ...}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeNonNumerics(String)}
   */
  @Test
  public void testRemoveNonNumerics_whenJavaLangBooleanD_thenReturnDotDotDot() {
    // Arrange, Act and Assert
    assertEquals("...", StringUtil.removeNonNumerics("java.lang.Boolean[^\\d.]+"));
  }

  /**
   * Test {@link StringUtil#removeNonNumerics(String)}.
   * <ul>
   *   <li>When {@code java.lang.BooleanU}.</li>
   *   <li>Then return {@code ..}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeNonNumerics(String)}
   */
  @Test
  public void testRemoveNonNumerics_whenJavaLangBooleanU_thenReturnDotDot() {
    // Arrange, Act and Assert
    assertEquals("..", StringUtil.removeNonNumerics("java.lang.BooleanU"));
  }

  /**
   * Test {@link StringUtil#removeNonNumerics(String)}.
   * <ul>
   *   <li>When {@code java.lang.BooleanValue}.</li>
   *   <li>Then return {@code ..}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeNonNumerics(String)}
   */
  @Test
  public void testRemoveNonNumerics_whenJavaLangBooleanValue_thenReturnDotDot() {
    // Arrange, Act and Assert
    assertEquals("..", StringUtil.removeNonNumerics("java.lang.BooleanValue"));
  }

  /**
   * Test {@link StringUtil#removeNonNumerics(String)}.
   * <ul>
   *   <li>When {@code java.lang.Boolean}.</li>
   *   <li>Then return {@code ..}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeNonNumerics(String)}
   */
  @Test
  public void testRemoveNonNumerics_whenJavaLangBoolean_thenReturnDotDot() {
    // Arrange, Act and Assert
    assertEquals("..", StringUtil.removeNonNumerics("java.lang.Boolean"));
    assertEquals("..", StringUtil.removeNonNumerics("java.lang.Boolean{"));
    assertEquals("..", StringUtil.removeNonNumerics("{java.lang.Boolean"));
  }

  /**
   * Test {@link StringUtil#removeNonNumerics(String)}.
   * <ul>
   *   <li>When {@code .java.lang.Boolean}.</li>
   *   <li>Then return {@code ...}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeNonNumerics(String)}
   */
  @Test
  public void testRemoveNonNumerics_whenJavaLangBoolean_thenReturnDotDotDot() {
    // Arrange, Act and Assert
    assertEquals("...", StringUtil.removeNonNumerics(".java.lang.Boolean"));
    assertEquals("...", StringUtil.removeNonNumerics("java.lang.Boolean."));
  }

  /**
   * Test {@link StringUtil#removeNonNumerics(String)}.
   * <ul>
   *   <li>When {@code java.lang.Booleanjava.lang.Boolean}.</li>
   *   <li>Then return {@code ....}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeNonNumerics(String)}
   */
  @Test
  public void testRemoveNonNumerics_whenJavaLangBooleanjavaLangBoolean_thenReturnDotDotDotDot() {
    // Arrange, Act and Assert
    assertEquals("....", StringUtil.removeNonNumerics("java.lang.Booleanjava.lang.Boolean"));
  }

  /**
   * Test {@link StringUtil#removeNonNumerics(String)}.
   * <ul>
   *   <li>When {@code java.lang.Booleanjava.util.Map$Entry}.</li>
   *   <li>Then return {@code ....}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeNonNumerics(String)}
   */
  @Test
  public void testRemoveNonNumerics_whenJavaLangBooleanjavaUtilMapEntry_thenReturnDotDotDotDot() {
    // Arrange, Act and Assert
    assertEquals("....", StringUtil.removeNonNumerics("java.lang.Booleanjava.util.Map$Entry"));
  }

  /**
   * Test {@link StringUtil#removeNonNumerics(String)}.
   * <ul>
   *   <li>When {@code java.lang.Booleannull}.</li>
   *   <li>Then return {@code ..}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeNonNumerics(String)}
   */
  @Test
  public void testRemoveNonNumerics_whenJavaLangBooleannull_thenReturnDotDot() {
    // Arrange, Act and Assert
    assertEquals("..", StringUtil.removeNonNumerics("java.lang.Booleannull"));
  }

  /**
   * Test {@link StringUtil#removeNonNumerics(String)}.
   * <ul>
   *   <li>When {@code java.util.Map$Entry42}.</li>
   *   <li>Then return {@code ..42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeNonNumerics(String)}
   */
  @Test
  public void testRemoveNonNumerics_whenJavaUtilMapEntry42_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("..42", StringUtil.removeNonNumerics("java.util.Map$Entry42"));
  }

  /**
   * Test {@link StringUtil#removeNonNumerics(String)}.
   * <ul>
   *   <li>When {@code java.util.Map$Entry[^\d.]+}.</li>
   *   <li>Then return {@code ...}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeNonNumerics(String)}
   */
  @Test
  public void testRemoveNonNumerics_whenJavaUtilMapEntryD_thenReturnDotDotDot() {
    // Arrange, Act and Assert
    assertEquals("...", StringUtil.removeNonNumerics("java.util.Map$Entry[^\\d.]+"));
  }

  /**
   * Test {@link StringUtil#removeNonNumerics(String)}.
   * <ul>
   *   <li>When {@code java.util.Map$EntryU}.</li>
   *   <li>Then return {@code ..}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeNonNumerics(String)}
   */
  @Test
  public void testRemoveNonNumerics_whenJavaUtilMapEntryU_thenReturnDotDot() {
    // Arrange, Act and Assert
    assertEquals("..", StringUtil.removeNonNumerics("java.util.Map$EntryU"));
  }

  /**
   * Test {@link StringUtil#removeNonNumerics(String)}.
   * <ul>
   *   <li>When {@code java.util.Map$EntryValue}.</li>
   *   <li>Then return {@code ..}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeNonNumerics(String)}
   */
  @Test
  public void testRemoveNonNumerics_whenJavaUtilMapEntryValue_thenReturnDotDot() {
    // Arrange, Act and Assert
    assertEquals("..", StringUtil.removeNonNumerics("java.util.Map$EntryValue"));
  }

  /**
   * Test {@link StringUtil#removeNonNumerics(String)}.
   * <ul>
   *   <li>When {@code java.util.Map$Entry}.</li>
   *   <li>Then return {@code ..}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeNonNumerics(String)}
   */
  @Test
  public void testRemoveNonNumerics_whenJavaUtilMapEntry_thenReturnDotDot() {
    // Arrange, Act and Assert
    assertEquals("..", StringUtil.removeNonNumerics("java.util.Map$Entry"));
    assertEquals("..", StringUtil.removeNonNumerics("java.util.Map$Entry{"));
    assertEquals("..", StringUtil.removeNonNumerics("{java.util.Map$Entry"));
  }

  /**
   * Test {@link StringUtil#removeNonNumerics(String)}.
   * <ul>
   *   <li>When {@code .java.util.Map$Entry}.</li>
   *   <li>Then return {@code ...}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeNonNumerics(String)}
   */
  @Test
  public void testRemoveNonNumerics_whenJavaUtilMapEntry_thenReturnDotDotDot() {
    // Arrange, Act and Assert
    assertEquals("...", StringUtil.removeNonNumerics(".java.util.Map$Entry"));
    assertEquals("...", StringUtil.removeNonNumerics("java.util.Map$Entry."));
  }

  /**
   * Test {@link StringUtil#removeNonNumerics(String)}.
   * <ul>
   *   <li>When {@code java.util.Map$Entryjava.lang.Boolean}.</li>
   *   <li>Then return {@code ....}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeNonNumerics(String)}
   */
  @Test
  public void testRemoveNonNumerics_whenJavaUtilMapEntryjavaLangBoolean_thenReturnDotDotDotDot() {
    // Arrange, Act and Assert
    assertEquals("....", StringUtil.removeNonNumerics("java.util.Map$Entryjava.lang.Boolean"));
  }

  /**
   * Test {@link StringUtil#removeNonNumerics(String)}.
   * <ul>
   *   <li>When {@code java.util.Map$Entryjava.util.Map$Entry}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeNonNumerics(String)}
   */
  @Test
  public void testRemoveNonNumerics_whenJavaUtilMapEntryjavaUtilMapEntry() {
    // Arrange, Act and Assert
    assertEquals("....", StringUtil.removeNonNumerics("java.util.Map$Entryjava.util.Map$Entry"));
  }

  /**
   * Test {@link StringUtil#removeNonNumerics(String)}.
   * <ul>
   *   <li>When {@code java.util.Map$Entrynull}.</li>
   *   <li>Then return {@code ..}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeNonNumerics(String)}
   */
  @Test
  public void testRemoveNonNumerics_whenJavaUtilMapEntrynull_thenReturnDotDot() {
    // Arrange, Act and Assert
    assertEquals("..", StringUtil.removeNonNumerics("java.util.Map$Entrynull"));
  }

  /**
   * Test {@link StringUtil#removeNonNumerics(String)}.
   * <ul>
   *   <li>When {@code {.}.</li>
   *   <li>Then return {@code .}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeNonNumerics(String)}
   */
  @Test
  public void testRemoveNonNumerics_whenLeftCurlyBracketDot_thenReturnDot() {
    // Arrange, Act and Assert
    assertEquals(".", StringUtil.removeNonNumerics("{."));
  }

  /**
   * Test {@link StringUtil#removeNonNumerics(String)}.
   * <ul>
   *   <li>When {@code {{}.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeNonNumerics(String)}
   */
  @Test
  public void testRemoveNonNumerics_whenLeftCurlyBracketLeftCurlyBracket_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", StringUtil.removeNonNumerics("{{"));
  }

  /**
   * Test {@link StringUtil#removeNonNumerics(String)}.
   * <ul>
   *   <li>When {@code {}.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeNonNumerics(String)}
   */
  @Test
  public void testRemoveNonNumerics_whenLeftCurlyBracket_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", StringUtil.removeNonNumerics("{"));
  }

  /**
   * Test {@link StringUtil#removeNonNumerics(String)}.
   * <ul>
   *   <li>When {@code null42}.</li>
   *   <li>Then return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeNonNumerics(String)}
   */
  @Test
  public void testRemoveNonNumerics_whenNull42_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("42", StringUtil.removeNonNumerics("null42"));
  }

  /**
   * Test {@link StringUtil#removeNonNumerics(String)}.
   * <ul>
   *   <li>When {@code null[^\d.]+}.</li>
   *   <li>Then return {@code .}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeNonNumerics(String)}
   */
  @Test
  public void testRemoveNonNumerics_whenNullD_thenReturnDot() {
    // Arrange, Act and Assert
    assertEquals(".", StringUtil.removeNonNumerics("null[^\\d.]+"));
  }

  /**
   * Test {@link StringUtil#removeNonNumerics(String)}.
   * <ul>
   *   <li>When {@code nullU}.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeNonNumerics(String)}
   */
  @Test
  public void testRemoveNonNumerics_whenNullU_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", StringUtil.removeNonNumerics("nullU"));
  }

  /**
   * Test {@link StringUtil#removeNonNumerics(String)}.
   * <ul>
   *   <li>When {@code nullValue}.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeNonNumerics(String)}
   */
  @Test
  public void testRemoveNonNumerics_whenNullValue_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", StringUtil.removeNonNumerics("nullValue"));
  }

  /**
   * Test {@link StringUtil#removeNonNumerics(String)}.
   * <ul>
   *   <li>When {@code .null}.</li>
   *   <li>Then return {@code .}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeNonNumerics(String)}
   */
  @Test
  public void testRemoveNonNumerics_whenNull_thenReturnDot() {
    // Arrange, Act and Assert
    assertEquals(".", StringUtil.removeNonNumerics(".null"));
    assertEquals(".", StringUtil.removeNonNumerics("null."));
  }

  /**
   * Test {@link StringUtil#removeNonNumerics(String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeNonNumerics(String)}
   */
  @Test
  public void testRemoveNonNumerics_whenNull_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", StringUtil.removeNonNumerics("null"));
    assertEquals("", StringUtil.removeNonNumerics("null{"));
    assertEquals("", StringUtil.removeNonNumerics("{null"));
  }

  /**
   * Test {@link StringUtil#removeNonNumerics(String)}.
   * <ul>
   *   <li>When {@code nulljava.lang.Boolean}.</li>
   *   <li>Then return {@code ..}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeNonNumerics(String)}
   */
  @Test
  public void testRemoveNonNumerics_whenNulljavaLangBoolean_thenReturnDotDot() {
    // Arrange, Act and Assert
    assertEquals("..", StringUtil.removeNonNumerics("nulljava.lang.Boolean"));
  }

  /**
   * Test {@link StringUtil#removeNonNumerics(String)}.
   * <ul>
   *   <li>When {@code nulljava.util.Map$Entry}.</li>
   *   <li>Then return {@code ..}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeNonNumerics(String)}
   */
  @Test
  public void testRemoveNonNumerics_whenNulljavaUtilMapEntry_thenReturnDotDot() {
    // Arrange, Act and Assert
    assertEquals("..", StringUtil.removeNonNumerics("nulljava.util.Map$Entry"));
  }

  /**
   * Test {@link StringUtil#removeNonNumerics(String)}.
   * <ul>
   *   <li>When {@code nullnull}.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeNonNumerics(String)}
   */
  @Test
  public void testRemoveNonNumerics_whenNullnull_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", StringUtil.removeNonNumerics("nullnull"));
  }

  /**
   * Test {@link StringUtil#removeNonNumerics(String)}.
   * <ul>
   *   <li>When {@code nullorg.broadleafcommerce.common.util.StringUtil}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeNonNumerics(String)}
   */
  @Test
  public void testRemoveNonNumerics_whenNullorgBroadleafcommerceCommonUtilStringUtil() {
    // Arrange, Act and Assert
    assertEquals("....", StringUtil.removeNonNumerics("nullorg.broadleafcommerce.common.util.StringUtil"));
  }

  /**
   * Test {@link StringUtil#removeNonNumerics(String)}.
   * <ul>
   *   <li>When {@code org.broadleafcommerce.common.util.StringUtil}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeNonNumerics(String)}
   */
  @Test
  public void testRemoveNonNumerics_whenOrgBroadleafcommerceCommonUtilStringUtil() {
    // Arrange, Act and Assert
    assertEquals("....", StringUtil.removeNonNumerics("org.broadleafcommerce.common.util.StringUtil"));
    assertEquals(".....", StringUtil.removeNonNumerics(".org.broadleafcommerce.common.util.StringUtil"));
    assertEquals(".....", StringUtil.removeNonNumerics("org.broadleafcommerce.common.util.StringUtil."));
    assertEquals("....", StringUtil.removeNonNumerics("org.broadleafcommerce.common.util.StringUtil{"));
    assertEquals("....", StringUtil.removeNonNumerics("{org.broadleafcommerce.common.util.StringUtil"));
  }

  /**
   * Test {@link StringUtil#removeNonNumerics(String)}.
   * <ul>
   *   <li>When {@code org.broadleafcommerce.common.util.StringUtil42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeNonNumerics(String)}
   */
  @Test
  public void testRemoveNonNumerics_whenOrgBroadleafcommerceCommonUtilStringUtil42() {
    // Arrange, Act and Assert
    assertEquals("....42", StringUtil.removeNonNumerics("org.broadleafcommerce.common.util.StringUtil42"));
  }

  /**
   * Test {@link StringUtil#removeNonNumerics(String)}.
   * <ul>
   *   <li>When {@code org.broadleafcommerce.common.util.StringUtil[^\d.]+}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeNonNumerics(String)}
   */
  @Test
  public void testRemoveNonNumerics_whenOrgBroadleafcommerceCommonUtilStringUtilD() {
    // Arrange, Act and Assert
    assertEquals(".....", StringUtil.removeNonNumerics("org.broadleafcommerce.common.util.StringUtil[^\\d.]+"));
  }

  /**
   * Test {@link StringUtil#removeNonNumerics(String)}.
   * <ul>
   *   <li>When {@code org.broadleafcommerce.common.util.StringUtilU}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeNonNumerics(String)}
   */
  @Test
  public void testRemoveNonNumerics_whenOrgBroadleafcommerceCommonUtilStringUtilU() {
    // Arrange, Act and Assert
    assertEquals("....", StringUtil.removeNonNumerics("org.broadleafcommerce.common.util.StringUtilU"));
  }

  /**
   * Test {@link StringUtil#removeNonNumerics(String)}.
   * <ul>
   *   <li>When {@code org.broadleafcommerce.common.util.StringUtilValue}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeNonNumerics(String)}
   */
  @Test
  public void testRemoveNonNumerics_whenOrgBroadleafcommerceCommonUtilStringUtilValue() {
    // Arrange, Act and Assert
    assertEquals("....", StringUtil.removeNonNumerics("org.broadleafcommerce.common.util.StringUtilValue"));
  }

  /**
   * Test {@link StringUtil#removeNonNumerics(String)}.
   * <ul>
   *   <li>When {@code org.broadleafcommerce.common.util.StringUtilnull}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeNonNumerics(String)}
   */
  @Test
  public void testRemoveNonNumerics_whenOrgBroadleafcommerceCommonUtilStringUtilnull() {
    // Arrange, Act and Assert
    assertEquals("....", StringUtil.removeNonNumerics("org.broadleafcommerce.common.util.StringUtilnull"));
  }

  /**
   * Test {@link StringUtil#removeNonNumerics(String)}.
   * <ul>
   *   <li>When {@code U42[^\d.]+}.</li>
   *   <li>Then return {@code 42.}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeNonNumerics(String)}
   */
  @Test
  public void testRemoveNonNumerics_whenU42D_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("42.", StringUtil.removeNonNumerics("U42[^\\d.]+"));
  }

  /**
   * Test {@link StringUtil#removeNonNumerics(String)}.
   * <ul>
   *   <li>When {@code U42Value}.</li>
   *   <li>Then return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeNonNumerics(String)}
   */
  @Test
  public void testRemoveNonNumerics_whenU42Value_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("42", StringUtil.removeNonNumerics("U42Value"));
  }

  /**
   * Test {@link StringUtil#removeNonNumerics(String)}.
   * <ul>
   *   <li>When {@code U42}.</li>
   *   <li>Then return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeNonNumerics(String)}
   */
  @Test
  public void testRemoveNonNumerics_whenU42_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("42", StringUtil.removeNonNumerics("U42"));
    assertEquals("42.", StringUtil.removeNonNumerics("U42."));
    assertEquals("42", StringUtil.removeNonNumerics("U42{"));
    assertEquals(".42", StringUtil.removeNonNumerics("U.42"));
    assertEquals("42", StringUtil.removeNonNumerics("U{42"));
  }

  /**
   * Test {@link StringUtil#removeNonNumerics(String)}.
   * <ul>
   *   <li>When {@code U42java.lang.Boolean}.</li>
   *   <li>Then return {@code 42..}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeNonNumerics(String)}
   */
  @Test
  public void testRemoveNonNumerics_whenU42javaLangBoolean_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("42..", StringUtil.removeNonNumerics("U42java.lang.Boolean"));
  }

  /**
   * Test {@link StringUtil#removeNonNumerics(String)}.
   * <ul>
   *   <li>When {@code U42java.util.Map$Entry}.</li>
   *   <li>Then return {@code 42..}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeNonNumerics(String)}
   */
  @Test
  public void testRemoveNonNumerics_whenU42javaUtilMapEntry_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("42..", StringUtil.removeNonNumerics("U42java.util.Map$Entry"));
  }

  /**
   * Test {@link StringUtil#removeNonNumerics(String)}.
   * <ul>
   *   <li>When {@code U42null}.</li>
   *   <li>Then return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeNonNumerics(String)}
   */
  @Test
  public void testRemoveNonNumerics_whenU42null_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("42", StringUtil.removeNonNumerics("U42null"));
  }

  /**
   * Test {@link StringUtil#removeNonNumerics(String)}.
   * <ul>
   *   <li>When {@code U42org.broadleafcommerce.common.util.StringUtil}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeNonNumerics(String)}
   */
  @Test
  public void testRemoveNonNumerics_whenU42orgBroadleafcommerceCommonUtilStringUtil() {
    // Arrange, Act and Assert
    assertEquals("42....", StringUtil.removeNonNumerics("U42org.broadleafcommerce.common.util.StringUtil"));
  }

  /**
   * Test {@link StringUtil#removeNonNumerics(String)}.
   * <ul>
   *   <li>When {@code U42U}.</li>
   *   <li>Then return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeNonNumerics(String)}
   */
  @Test
  public void testRemoveNonNumerics_whenU42u_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("42", StringUtil.removeNonNumerics("U42U"));
  }

  /**
   * Test {@link StringUtil#removeNonNumerics(String)}.
   * <ul>
   *   <li>When {@code U4242}.</li>
   *   <li>Then return {@code 4242}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeNonNumerics(String)}
   */
  @Test
  public void testRemoveNonNumerics_whenU4242_thenReturn4242() {
    // Arrange, Act and Assert
    assertEquals("4242", StringUtil.removeNonNumerics("U4242"));
  }

  /**
   * Test {@link StringUtil#removeNonNumerics(String)}.
   * <ul>
   *   <li>When {@code U[^\d.]+42}.</li>
   *   <li>Then return {@code .42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeNonNumerics(String)}
   */
  @Test
  public void testRemoveNonNumerics_whenUD42_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals(".42", StringUtil.removeNonNumerics("U[^\\d.]+42"));
  }

  /**
   * Test {@link StringUtil#removeNonNumerics(String)}.
   * <ul>
   *   <li>When {@code U[^\d.]+[^\d.]+}.</li>
   *   <li>Then return {@code ..}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeNonNumerics(String)}
   */
  @Test
  public void testRemoveNonNumerics_whenUDD_thenReturnDotDot() {
    // Arrange, Act and Assert
    assertEquals("..", StringUtil.removeNonNumerics("U[^\\d.]+[^\\d.]+"));
  }

  /**
   * Test {@link StringUtil#removeNonNumerics(String)}.
   * <ul>
   *   <li>When {@code U[^\d.]+java.lang.Boolean}.</li>
   *   <li>Then return {@code ...}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeNonNumerics(String)}
   */
  @Test
  public void testRemoveNonNumerics_whenUDJavaLangBoolean_thenReturnDotDotDot() {
    // Arrange, Act and Assert
    assertEquals("...", StringUtil.removeNonNumerics("U[^\\d.]+java.lang.Boolean"));
  }

  /**
   * Test {@link StringUtil#removeNonNumerics(String)}.
   * <ul>
   *   <li>When {@code U[^\d.]+java.util.Map$Entry}.</li>
   *   <li>Then return {@code ...}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeNonNumerics(String)}
   */
  @Test
  public void testRemoveNonNumerics_whenUDJavaUtilMapEntry_thenReturnDotDotDot() {
    // Arrange, Act and Assert
    assertEquals("...", StringUtil.removeNonNumerics("U[^\\d.]+java.util.Map$Entry"));
  }

  /**
   * Test {@link StringUtil#removeNonNumerics(String)}.
   * <ul>
   *   <li>When {@code U[^\d.]+null}.</li>
   *   <li>Then return {@code .}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeNonNumerics(String)}
   */
  @Test
  public void testRemoveNonNumerics_whenUDNull_thenReturnDot() {
    // Arrange, Act and Assert
    assertEquals(".", StringUtil.removeNonNumerics("U[^\\d.]+null"));
  }

  /**
   * Test {@link StringUtil#removeNonNumerics(String)}.
   * <ul>
   *   <li>When {@code U[^\d.]+org.broadleafcommerce.common.util.StringUtil}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeNonNumerics(String)}
   */
  @Test
  public void testRemoveNonNumerics_whenUDOrgBroadleafcommerceCommonUtilStringUtil() {
    // Arrange, Act and Assert
    assertEquals(".....", StringUtil.removeNonNumerics("U[^\\d.]+org.broadleafcommerce.common.util.StringUtil"));
  }

  /**
   * Test {@link StringUtil#removeNonNumerics(String)}.
   * <ul>
   *   <li>When {@code U[^\d.]+U}.</li>
   *   <li>Then return {@code .}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeNonNumerics(String)}
   */
  @Test
  public void testRemoveNonNumerics_whenUDU_thenReturnDot() {
    // Arrange, Act and Assert
    assertEquals(".", StringUtil.removeNonNumerics("U[^\\d.]+U"));
  }

  /**
   * Test {@link StringUtil#removeNonNumerics(String)}.
   * <ul>
   *   <li>When {@code U[^\d.]+Value}.</li>
   *   <li>Then return {@code .}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeNonNumerics(String)}
   */
  @Test
  public void testRemoveNonNumerics_whenUDValue_thenReturnDot() {
    // Arrange, Act and Assert
    assertEquals(".", StringUtil.removeNonNumerics("U[^\\d.]+Value"));
  }

  /**
   * Test {@link StringUtil#removeNonNumerics(String)}.
   * <ul>
   *   <li>When {@code U[^\d.]+}.</li>
   *   <li>Then return {@code .}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeNonNumerics(String)}
   */
  @Test
  public void testRemoveNonNumerics_whenUD_thenReturnDot() {
    // Arrange, Act and Assert
    assertEquals(".", StringUtil.removeNonNumerics("U[^\\d.]+"));
    assertEquals(".", StringUtil.removeNonNumerics("U[^\\d.]+{"));
    assertEquals(".", StringUtil.removeNonNumerics("U{[^\\d.]+"));
  }

  /**
   * Test {@link StringUtil#removeNonNumerics(String)}.
   * <ul>
   *   <li>When {@code U[^\d.]+.}.</li>
   *   <li>Then return {@code ..}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeNonNumerics(String)}
   */
  @Test
  public void testRemoveNonNumerics_whenUD_thenReturnDotDot() {
    // Arrange, Act and Assert
    assertEquals("..", StringUtil.removeNonNumerics("U[^\\d.]+."));
    assertEquals("..", StringUtil.removeNonNumerics("U.[^\\d.]+"));
  }

  /**
   * Test {@link StringUtil#removeNonNumerics(String)}.
   * <ul>
   *   <li>When {@code U{java.lang.Boolean}.</li>
   *   <li>Then return {@code ..}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeNonNumerics(String)}
   */
  @Test
  public void testRemoveNonNumerics_whenUJavaLangBoolean_thenReturnDotDot() {
    // Arrange, Act and Assert
    assertEquals("..", StringUtil.removeNonNumerics("U{java.lang.Boolean"));
  }

  /**
   * Test {@link StringUtil#removeNonNumerics(String)}.
   * <ul>
   *   <li>When {@code U.java.lang.Boolean}.</li>
   *   <li>Then return {@code ...}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeNonNumerics(String)}
   */
  @Test
  public void testRemoveNonNumerics_whenUJavaLangBoolean_thenReturnDotDotDot() {
    // Arrange, Act and Assert
    assertEquals("...", StringUtil.removeNonNumerics("U.java.lang.Boolean"));
  }

  /**
   * Test {@link StringUtil#removeNonNumerics(String)}.
   * <ul>
   *   <li>When {@code U{java.util.Map$Entry}.</li>
   *   <li>Then return {@code ..}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeNonNumerics(String)}
   */
  @Test
  public void testRemoveNonNumerics_whenUJavaUtilMapEntry_thenReturnDotDot() {
    // Arrange, Act and Assert
    assertEquals("..", StringUtil.removeNonNumerics("U{java.util.Map$Entry"));
  }

  /**
   * Test {@link StringUtil#removeNonNumerics(String)}.
   * <ul>
   *   <li>When {@code U.java.util.Map$Entry}.</li>
   *   <li>Then return {@code ...}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeNonNumerics(String)}
   */
  @Test
  public void testRemoveNonNumerics_whenUJavaUtilMapEntry_thenReturnDotDotDot() {
    // Arrange, Act and Assert
    assertEquals("...", StringUtil.removeNonNumerics("U.java.util.Map$Entry"));
  }

  /**
   * Test {@link StringUtil#removeNonNumerics(String)}.
   * <ul>
   *   <li>When {@code U.null}.</li>
   *   <li>Then return {@code .}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeNonNumerics(String)}
   */
  @Test
  public void testRemoveNonNumerics_whenUNull_thenReturnDot() {
    // Arrange, Act and Assert
    assertEquals(".", StringUtil.removeNonNumerics("U.null"));
  }

  /**
   * Test {@link StringUtil#removeNonNumerics(String)}.
   * <ul>
   *   <li>When {@code U{null}.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeNonNumerics(String)}
   */
  @Test
  public void testRemoveNonNumerics_whenUNull_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", StringUtil.removeNonNumerics("U{null"));
  }

  /**
   * Test {@link StringUtil#removeNonNumerics(String)}.
   * <ul>
   *   <li>When {@code U.org.broadleafcommerce.common.util.StringUtil}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeNonNumerics(String)}
   */
  @Test
  public void testRemoveNonNumerics_whenUOrgBroadleafcommerceCommonUtilStringUtil() {
    // Arrange, Act and Assert
    assertEquals(".....", StringUtil.removeNonNumerics("U.org.broadleafcommerce.common.util.StringUtil"));
    assertEquals("....", StringUtil.removeNonNumerics("U{org.broadleafcommerce.common.util.StringUtil"));
  }

  /**
   * Test {@link StringUtil#removeNonNumerics(String)}.
   * <ul>
   *   <li>When {@code UUValue}.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeNonNumerics(String)}
   */
  @Test
  public void testRemoveNonNumerics_whenUUValue_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", StringUtil.removeNonNumerics("UUValue"));
  }

  /**
   * Test {@link StringUtil#removeNonNumerics(String)}.
   * <ul>
   *   <li>When {@code U.U}.</li>
   *   <li>Then return {@code .}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeNonNumerics(String)}
   */
  @Test
  public void testRemoveNonNumerics_whenUU_thenReturnDot() {
    // Arrange, Act and Assert
    assertEquals(".", StringUtil.removeNonNumerics("U.U"));
  }

  /**
   * Test {@link StringUtil#removeNonNumerics(String)}.
   * <ul>
   *   <li>When {@code U{U}.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeNonNumerics(String)}
   */
  @Test
  public void testRemoveNonNumerics_whenUU_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", StringUtil.removeNonNumerics("U{U"));
  }

  /**
   * Test {@link StringUtil#removeNonNumerics(String)}.
   * <ul>
   *   <li>When {@code UUjava.lang.Boolean}.</li>
   *   <li>Then return {@code ..}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeNonNumerics(String)}
   */
  @Test
  public void testRemoveNonNumerics_whenUUjavaLangBoolean_thenReturnDotDot() {
    // Arrange, Act and Assert
    assertEquals("..", StringUtil.removeNonNumerics("UUjava.lang.Boolean"));
  }

  /**
   * Test {@link StringUtil#removeNonNumerics(String)}.
   * <ul>
   *   <li>When {@code UUjava.util.Map$Entry}.</li>
   *   <li>Then return {@code ..}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeNonNumerics(String)}
   */
  @Test
  public void testRemoveNonNumerics_whenUUjavaUtilMapEntry_thenReturnDotDot() {
    // Arrange, Act and Assert
    assertEquals("..", StringUtil.removeNonNumerics("UUjava.util.Map$Entry"));
  }

  /**
   * Test {@link StringUtil#removeNonNumerics(String)}.
   * <ul>
   *   <li>When {@code UUnull}.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeNonNumerics(String)}
   */
  @Test
  public void testRemoveNonNumerics_whenUUnull_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", StringUtil.removeNonNumerics("UUnull"));
  }

  /**
   * Test {@link StringUtil#removeNonNumerics(String)}.
   * <ul>
   *   <li>When {@code UUorg.broadleafcommerce.common.util.StringUtil}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeNonNumerics(String)}
   */
  @Test
  public void testRemoveNonNumerics_whenUUorgBroadleafcommerceCommonUtilStringUtil() {
    // Arrange, Act and Assert
    assertEquals("....", StringUtil.removeNonNumerics("UUorg.broadleafcommerce.common.util.StringUtil"));
  }

  /**
   * Test {@link StringUtil#removeNonNumerics(String)}.
   * <ul>
   *   <li>When {@code UValue42}.</li>
   *   <li>Then return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeNonNumerics(String)}
   */
  @Test
  public void testRemoveNonNumerics_whenUValue42_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("42", StringUtil.removeNonNumerics("UValue42"));
  }

  /**
   * Test {@link StringUtil#removeNonNumerics(String)}.
   * <ul>
   *   <li>When {@code UValue[^\d.]+}.</li>
   *   <li>Then return {@code .}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeNonNumerics(String)}
   */
  @Test
  public void testRemoveNonNumerics_whenUValueD_thenReturnDot() {
    // Arrange, Act and Assert
    assertEquals(".", StringUtil.removeNonNumerics("UValue[^\\d.]+"));
  }

  /**
   * Test {@link StringUtil#removeNonNumerics(String)}.
   * <ul>
   *   <li>When {@code UValueU}.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeNonNumerics(String)}
   */
  @Test
  public void testRemoveNonNumerics_whenUValueU_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", StringUtil.removeNonNumerics("UValueU"));
  }

  /**
   * Test {@link StringUtil#removeNonNumerics(String)}.
   * <ul>
   *   <li>When {@code UValueValue}.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeNonNumerics(String)}
   */
  @Test
  public void testRemoveNonNumerics_whenUValueValue_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", StringUtil.removeNonNumerics("UValueValue"));
  }

  /**
   * Test {@link StringUtil#removeNonNumerics(String)}.
   * <ul>
   *   <li>When {@code UValue.}.</li>
   *   <li>Then return {@code .}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeNonNumerics(String)}
   */
  @Test
  public void testRemoveNonNumerics_whenUValue_thenReturnDot() {
    // Arrange, Act and Assert
    assertEquals(".", StringUtil.removeNonNumerics("UValue."));
    assertEquals(".", StringUtil.removeNonNumerics("U.Value"));
  }

  /**
   * Test {@link StringUtil#removeNonNumerics(String)}.
   * <ul>
   *   <li>When {@code UValue}.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeNonNumerics(String)}
   */
  @Test
  public void testRemoveNonNumerics_whenUValue_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", StringUtil.removeNonNumerics("UValue"));
    assertEquals("", StringUtil.removeNonNumerics("UValue{"));
    assertEquals("", StringUtil.removeNonNumerics("U{Value"));
  }

  /**
   * Test {@link StringUtil#removeNonNumerics(String)}.
   * <ul>
   *   <li>When {@code UValuejava.lang.Boolean}.</li>
   *   <li>Then return {@code ..}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeNonNumerics(String)}
   */
  @Test
  public void testRemoveNonNumerics_whenUValuejavaLangBoolean_thenReturnDotDot() {
    // Arrange, Act and Assert
    assertEquals("..", StringUtil.removeNonNumerics("UValuejava.lang.Boolean"));
  }

  /**
   * Test {@link StringUtil#removeNonNumerics(String)}.
   * <ul>
   *   <li>When {@code UValuejava.util.Map$Entry}.</li>
   *   <li>Then return {@code ..}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeNonNumerics(String)}
   */
  @Test
  public void testRemoveNonNumerics_whenUValuejavaUtilMapEntry_thenReturnDotDot() {
    // Arrange, Act and Assert
    assertEquals("..", StringUtil.removeNonNumerics("UValuejava.util.Map$Entry"));
  }

  /**
   * Test {@link StringUtil#removeNonNumerics(String)}.
   * <ul>
   *   <li>When {@code UValuenull}.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeNonNumerics(String)}
   */
  @Test
  public void testRemoveNonNumerics_whenUValuenull_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", StringUtil.removeNonNumerics("UValuenull"));
  }

  /**
   * Test {@link StringUtil#removeNonNumerics(String)}.
   * <ul>
   *   <li>When {@code UValueorg.broadleafcommerce.common.util.StringUtil}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeNonNumerics(String)}
   */
  @Test
  public void testRemoveNonNumerics_whenUValueorgBroadleafcommerceCommonUtilStringUtil() {
    // Arrange, Act and Assert
    assertEquals("....", StringUtil.removeNonNumerics("UValueorg.broadleafcommerce.common.util.StringUtil"));
  }

  /**
   * Test {@link StringUtil#removeNonNumerics(String)}.
   * <ul>
   *   <li>When {@code U.}.</li>
   *   <li>Then return {@code .}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeNonNumerics(String)}
   */
  @Test
  public void testRemoveNonNumerics_whenU_thenReturnDot() {
    // Arrange, Act and Assert
    assertEquals(".", StringUtil.removeNonNumerics("U."));
    assertEquals(".", StringUtil.removeNonNumerics(".U"));
    assertEquals(".", StringUtil.removeNonNumerics("U.{"));
    assertEquals(".", StringUtil.removeNonNumerics("U{."));
  }

  /**
   * Test {@link StringUtil#removeNonNumerics(String)}.
   * <ul>
   *   <li>When {@code U..}.</li>
   *   <li>Then return {@code ..}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeNonNumerics(String)}
   */
  @Test
  public void testRemoveNonNumerics_whenU_thenReturnDotDot() {
    // Arrange, Act and Assert
    assertEquals("..", StringUtil.removeNonNumerics("U.."));
  }

  /**
   * Test {@link StringUtil#removeNonNumerics(String)}.
   * <ul>
   *   <li>When {@code U}.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeNonNumerics(String)}
   */
  @Test
  public void testRemoveNonNumerics_whenU_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", StringUtil.removeNonNumerics("U"));
    assertEquals("", StringUtil.removeNonNumerics("U{"));
    assertEquals("", StringUtil.removeNonNumerics("{U"));
    assertEquals("", StringUtil.removeNonNumerics("U{{"));
  }

  /**
   * Test {@link StringUtil#removeNonNumerics(String)}.
   * <ul>
   *   <li>When {@code Ujava.lang.Boolean42}.</li>
   *   <li>Then return {@code ..42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeNonNumerics(String)}
   */
  @Test
  public void testRemoveNonNumerics_whenUjavaLangBoolean42_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("..42", StringUtil.removeNonNumerics("Ujava.lang.Boolean42"));
  }

  /**
   * Test {@link StringUtil#removeNonNumerics(String)}.
   * <ul>
   *   <li>When {@code Ujava.lang.Boolean[^\d.]+}.</li>
   *   <li>Then return {@code ...}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeNonNumerics(String)}
   */
  @Test
  public void testRemoveNonNumerics_whenUjavaLangBooleanD_thenReturnDotDotDot() {
    // Arrange, Act and Assert
    assertEquals("...", StringUtil.removeNonNumerics("Ujava.lang.Boolean[^\\d.]+"));
  }

  /**
   * Test {@link StringUtil#removeNonNumerics(String)}.
   * <ul>
   *   <li>When {@code Ujava.lang.BooleanU}.</li>
   *   <li>Then return {@code ..}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeNonNumerics(String)}
   */
  @Test
  public void testRemoveNonNumerics_whenUjavaLangBooleanU_thenReturnDotDot() {
    // Arrange, Act and Assert
    assertEquals("..", StringUtil.removeNonNumerics("Ujava.lang.BooleanU"));
  }

  /**
   * Test {@link StringUtil#removeNonNumerics(String)}.
   * <ul>
   *   <li>When {@code Ujava.lang.BooleanValue}.</li>
   *   <li>Then return {@code ..}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeNonNumerics(String)}
   */
  @Test
  public void testRemoveNonNumerics_whenUjavaLangBooleanValue_thenReturnDotDot() {
    // Arrange, Act and Assert
    assertEquals("..", StringUtil.removeNonNumerics("Ujava.lang.BooleanValue"));
  }

  /**
   * Test {@link StringUtil#removeNonNumerics(String)}.
   * <ul>
   *   <li>When {@code Ujava.lang.Boolean}.</li>
   *   <li>Then return {@code ..}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeNonNumerics(String)}
   */
  @Test
  public void testRemoveNonNumerics_whenUjavaLangBoolean_thenReturnDotDot() {
    // Arrange, Act and Assert
    assertEquals("..", StringUtil.removeNonNumerics("Ujava.lang.Boolean"));
    assertEquals("..", StringUtil.removeNonNumerics("Ujava.lang.Boolean{"));
  }

  /**
   * Test {@link StringUtil#removeNonNumerics(String)}.
   * <ul>
   *   <li>When {@code Ujava.lang.Boolean.}.</li>
   *   <li>Then return {@code ...}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeNonNumerics(String)}
   */
  @Test
  public void testRemoveNonNumerics_whenUjavaLangBoolean_thenReturnDotDotDot() {
    // Arrange, Act and Assert
    assertEquals("...", StringUtil.removeNonNumerics("Ujava.lang.Boolean."));
  }

  /**
   * Test {@link StringUtil#removeNonNumerics(String)}.
   * <ul>
   *   <li>When {@code Ujava.lang.Booleanjava.lang.Boolean}.</li>
   *   <li>Then return {@code ....}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeNonNumerics(String)}
   */
  @Test
  public void testRemoveNonNumerics_whenUjavaLangBooleanjavaLangBoolean_thenReturnDotDotDotDot() {
    // Arrange, Act and Assert
    assertEquals("....", StringUtil.removeNonNumerics("Ujava.lang.Booleanjava.lang.Boolean"));
  }

  /**
   * Test {@link StringUtil#removeNonNumerics(String)}.
   * <ul>
   *   <li>When {@code Ujava.lang.Booleanjava.util.Map$Entry}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeNonNumerics(String)}
   */
  @Test
  public void testRemoveNonNumerics_whenUjavaLangBooleanjavaUtilMapEntry() {
    // Arrange, Act and Assert
    assertEquals("....", StringUtil.removeNonNumerics("Ujava.lang.Booleanjava.util.Map$Entry"));
  }

  /**
   * Test {@link StringUtil#removeNonNumerics(String)}.
   * <ul>
   *   <li>When {@code Ujava.lang.Booleannull}.</li>
   *   <li>Then return {@code ..}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeNonNumerics(String)}
   */
  @Test
  public void testRemoveNonNumerics_whenUjavaLangBooleannull_thenReturnDotDot() {
    // Arrange, Act and Assert
    assertEquals("..", StringUtil.removeNonNumerics("Ujava.lang.Booleannull"));
  }

  /**
   * Test {@link StringUtil#removeNonNumerics(String)}.
   * <ul>
   *   <li>When {@code Ujava.util.Map$Entry42}.</li>
   *   <li>Then return {@code ..42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeNonNumerics(String)}
   */
  @Test
  public void testRemoveNonNumerics_whenUjavaUtilMapEntry42_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("..42", StringUtil.removeNonNumerics("Ujava.util.Map$Entry42"));
  }

  /**
   * Test {@link StringUtil#removeNonNumerics(String)}.
   * <ul>
   *   <li>When {@code Ujava.util.Map$Entry[^\d.]+}.</li>
   *   <li>Then return {@code ...}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeNonNumerics(String)}
   */
  @Test
  public void testRemoveNonNumerics_whenUjavaUtilMapEntryD_thenReturnDotDotDot() {
    // Arrange, Act and Assert
    assertEquals("...", StringUtil.removeNonNumerics("Ujava.util.Map$Entry[^\\d.]+"));
  }

  /**
   * Test {@link StringUtil#removeNonNumerics(String)}.
   * <ul>
   *   <li>When {@code Ujava.util.Map$EntryU}.</li>
   *   <li>Then return {@code ..}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeNonNumerics(String)}
   */
  @Test
  public void testRemoveNonNumerics_whenUjavaUtilMapEntryU_thenReturnDotDot() {
    // Arrange, Act and Assert
    assertEquals("..", StringUtil.removeNonNumerics("Ujava.util.Map$EntryU"));
  }

  /**
   * Test {@link StringUtil#removeNonNumerics(String)}.
   * <ul>
   *   <li>When {@code Ujava.util.Map$EntryValue}.</li>
   *   <li>Then return {@code ..}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeNonNumerics(String)}
   */
  @Test
  public void testRemoveNonNumerics_whenUjavaUtilMapEntryValue_thenReturnDotDot() {
    // Arrange, Act and Assert
    assertEquals("..", StringUtil.removeNonNumerics("Ujava.util.Map$EntryValue"));
  }

  /**
   * Test {@link StringUtil#removeNonNumerics(String)}.
   * <ul>
   *   <li>When {@code Ujava.util.Map$Entry}.</li>
   *   <li>Then return {@code ..}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeNonNumerics(String)}
   */
  @Test
  public void testRemoveNonNumerics_whenUjavaUtilMapEntry_thenReturnDotDot() {
    // Arrange, Act and Assert
    assertEquals("..", StringUtil.removeNonNumerics("Ujava.util.Map$Entry"));
    assertEquals("..", StringUtil.removeNonNumerics("Ujava.util.Map$Entry{"));
  }

  /**
   * Test {@link StringUtil#removeNonNumerics(String)}.
   * <ul>
   *   <li>When {@code Ujava.util.Map$Entry.}.</li>
   *   <li>Then return {@code ...}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeNonNumerics(String)}
   */
  @Test
  public void testRemoveNonNumerics_whenUjavaUtilMapEntry_thenReturnDotDotDot() {
    // Arrange, Act and Assert
    assertEquals("...", StringUtil.removeNonNumerics("Ujava.util.Map$Entry."));
  }

  /**
   * Test {@link StringUtil#removeNonNumerics(String)}.
   * <ul>
   *   <li>When {@code Ujava.util.Map$Entryjava.lang.Boolean}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeNonNumerics(String)}
   */
  @Test
  public void testRemoveNonNumerics_whenUjavaUtilMapEntryjavaLangBoolean() {
    // Arrange, Act and Assert
    assertEquals("....", StringUtil.removeNonNumerics("Ujava.util.Map$Entryjava.lang.Boolean"));
  }

  /**
   * Test {@link StringUtil#removeNonNumerics(String)}.
   * <ul>
   *   <li>When {@code Ujava.util.Map$Entryjava.util.Map$Entry}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeNonNumerics(String)}
   */
  @Test
  public void testRemoveNonNumerics_whenUjavaUtilMapEntryjavaUtilMapEntry() {
    // Arrange, Act and Assert
    assertEquals("....", StringUtil.removeNonNumerics("Ujava.util.Map$Entryjava.util.Map$Entry"));
  }

  /**
   * Test {@link StringUtil#removeNonNumerics(String)}.
   * <ul>
   *   <li>When {@code Ujava.util.Map$Entrynull}.</li>
   *   <li>Then return {@code ..}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeNonNumerics(String)}
   */
  @Test
  public void testRemoveNonNumerics_whenUjavaUtilMapEntrynull_thenReturnDotDot() {
    // Arrange, Act and Assert
    assertEquals("..", StringUtil.removeNonNumerics("Ujava.util.Map$Entrynull"));
  }

  /**
   * Test {@link StringUtil#removeNonNumerics(String)}.
   * <ul>
   *   <li>When {@code Unull42}.</li>
   *   <li>Then return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeNonNumerics(String)}
   */
  @Test
  public void testRemoveNonNumerics_whenUnull42_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("42", StringUtil.removeNonNumerics("Unull42"));
  }

  /**
   * Test {@link StringUtil#removeNonNumerics(String)}.
   * <ul>
   *   <li>When {@code Unull[^\d.]+}.</li>
   *   <li>Then return {@code .}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeNonNumerics(String)}
   */
  @Test
  public void testRemoveNonNumerics_whenUnullD_thenReturnDot() {
    // Arrange, Act and Assert
    assertEquals(".", StringUtil.removeNonNumerics("Unull[^\\d.]+"));
  }

  /**
   * Test {@link StringUtil#removeNonNumerics(String)}.
   * <ul>
   *   <li>When {@code UnullU}.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeNonNumerics(String)}
   */
  @Test
  public void testRemoveNonNumerics_whenUnullU_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", StringUtil.removeNonNumerics("UnullU"));
  }

  /**
   * Test {@link StringUtil#removeNonNumerics(String)}.
   * <ul>
   *   <li>When {@code UnullValue}.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeNonNumerics(String)}
   */
  @Test
  public void testRemoveNonNumerics_whenUnullValue_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", StringUtil.removeNonNumerics("UnullValue"));
  }

  /**
   * Test {@link StringUtil#removeNonNumerics(String)}.
   * <ul>
   *   <li>When {@code Unull.}.</li>
   *   <li>Then return {@code .}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeNonNumerics(String)}
   */
  @Test
  public void testRemoveNonNumerics_whenUnull_thenReturnDot() {
    // Arrange, Act and Assert
    assertEquals(".", StringUtil.removeNonNumerics("Unull."));
  }

  /**
   * Test {@link StringUtil#removeNonNumerics(String)}.
   * <ul>
   *   <li>When {@code Unull}.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeNonNumerics(String)}
   */
  @Test
  public void testRemoveNonNumerics_whenUnull_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", StringUtil.removeNonNumerics("Unull"));
    assertEquals("", StringUtil.removeNonNumerics("Unull{"));
  }

  /**
   * Test {@link StringUtil#removeNonNumerics(String)}.
   * <ul>
   *   <li>When {@code Unulljava.lang.Boolean}.</li>
   *   <li>Then return {@code ..}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeNonNumerics(String)}
   */
  @Test
  public void testRemoveNonNumerics_whenUnulljavaLangBoolean_thenReturnDotDot() {
    // Arrange, Act and Assert
    assertEquals("..", StringUtil.removeNonNumerics("Unulljava.lang.Boolean"));
  }

  /**
   * Test {@link StringUtil#removeNonNumerics(String)}.
   * <ul>
   *   <li>When {@code Unulljava.util.Map$Entry}.</li>
   *   <li>Then return {@code ..}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeNonNumerics(String)}
   */
  @Test
  public void testRemoveNonNumerics_whenUnulljavaUtilMapEntry_thenReturnDotDot() {
    // Arrange, Act and Assert
    assertEquals("..", StringUtil.removeNonNumerics("Unulljava.util.Map$Entry"));
  }

  /**
   * Test {@link StringUtil#removeNonNumerics(String)}.
   * <ul>
   *   <li>When {@code Unullnull}.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeNonNumerics(String)}
   */
  @Test
  public void testRemoveNonNumerics_whenUnullnull_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", StringUtil.removeNonNumerics("Unullnull"));
  }

  /**
   * Test {@link StringUtil#removeNonNumerics(String)}.
   * <ul>
   *   <li>When {@code Unullorg.broadleafcommerce.common.util.StringUtil}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeNonNumerics(String)}
   */
  @Test
  public void testRemoveNonNumerics_whenUnullorgBroadleafcommerceCommonUtilStringUtil() {
    // Arrange, Act and Assert
    assertEquals("....", StringUtil.removeNonNumerics("Unullorg.broadleafcommerce.common.util.StringUtil"));
  }

  /**
   * Test {@link StringUtil#removeNonNumerics(String)}.
   * <ul>
   *   <li>When {@code Uorg.broadleafcommerce.common.util.StringUtil}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeNonNumerics(String)}
   */
  @Test
  public void testRemoveNonNumerics_whenUorgBroadleafcommerceCommonUtilStringUtil() {
    // Arrange, Act and Assert
    assertEquals("....", StringUtil.removeNonNumerics("Uorg.broadleafcommerce.common.util.StringUtil"));
    assertEquals(".....", StringUtil.removeNonNumerics("Uorg.broadleafcommerce.common.util.StringUtil."));
    assertEquals("....", StringUtil.removeNonNumerics("Uorg.broadleafcommerce.common.util.StringUtil{"));
  }

  /**
   * Test {@link StringUtil#removeNonNumerics(String)}.
   * <ul>
   *   <li>When {@code Uorg.broadleafcommerce.common.util.StringUtil42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeNonNumerics(String)}
   */
  @Test
  public void testRemoveNonNumerics_whenUorgBroadleafcommerceCommonUtilStringUtil42() {
    // Arrange, Act and Assert
    assertEquals("....42", StringUtil.removeNonNumerics("Uorg.broadleafcommerce.common.util.StringUtil42"));
  }

  /**
   * Test {@link StringUtil#removeNonNumerics(String)}.
   * <ul>
   *   <li>When {@code Uorg.broadleafcommerce.common.util.StringUtil[^\d.]+}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeNonNumerics(String)}
   */
  @Test
  public void testRemoveNonNumerics_whenUorgBroadleafcommerceCommonUtilStringUtilD() {
    // Arrange, Act and Assert
    assertEquals(".....", StringUtil.removeNonNumerics("Uorg.broadleafcommerce.common.util.StringUtil[^\\d.]+"));
  }

  /**
   * Test {@link StringUtil#removeNonNumerics(String)}.
   * <ul>
   *   <li>When {@code Uorg.broadleafcommerce.common.util.StringUtilU}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeNonNumerics(String)}
   */
  @Test
  public void testRemoveNonNumerics_whenUorgBroadleafcommerceCommonUtilStringUtilU() {
    // Arrange, Act and Assert
    assertEquals("....", StringUtil.removeNonNumerics("Uorg.broadleafcommerce.common.util.StringUtilU"));
  }

  /**
   * Test {@link StringUtil#removeNonNumerics(String)}.
   * <ul>
   *   <li>When {@code Uorg.broadleafcommerce.common.util.StringUtilValue}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeNonNumerics(String)}
   */
  @Test
  public void testRemoveNonNumerics_whenUorgBroadleafcommerceCommonUtilStringUtilValue() {
    // Arrange, Act and Assert
    assertEquals("....", StringUtil.removeNonNumerics("Uorg.broadleafcommerce.common.util.StringUtilValue"));
  }

  /**
   * Test {@link StringUtil#removeNonNumerics(String)}.
   * <ul>
   *   <li>When {@code Uorg.broadleafcommerce.common.util.StringUtilnull}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeNonNumerics(String)}
   */
  @Test
  public void testRemoveNonNumerics_whenUorgBroadleafcommerceCommonUtilStringUtilnull() {
    // Arrange, Act and Assert
    assertEquals("....", StringUtil.removeNonNumerics("Uorg.broadleafcommerce.common.util.StringUtilnull"));
  }

  /**
   * Test {@link StringUtil#removeNonNumerics(String)}.
   * <ul>
   *   <li>When {@code UU42}.</li>
   *   <li>Then return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeNonNumerics(String)}
   */
  @Test
  public void testRemoveNonNumerics_whenUu42_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("42", StringUtil.removeNonNumerics("UU42"));
  }

  /**
   * Test {@link StringUtil#removeNonNumerics(String)}.
   * <ul>
   *   <li>When {@code UU[^\d.]+}.</li>
   *   <li>Then return {@code .}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeNonNumerics(String)}
   */
  @Test
  public void testRemoveNonNumerics_whenUuD_thenReturnDot() {
    // Arrange, Act and Assert
    assertEquals(".", StringUtil.removeNonNumerics("UU[^\\d.]+"));
  }

  /**
   * Test {@link StringUtil#removeNonNumerics(String)}.
   * <ul>
   *   <li>When {@code UU.}.</li>
   *   <li>Then return {@code .}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeNonNumerics(String)}
   */
  @Test
  public void testRemoveNonNumerics_whenUu_thenReturnDot() {
    // Arrange, Act and Assert
    assertEquals(".", StringUtil.removeNonNumerics("UU."));
  }

  /**
   * Test {@link StringUtil#removeNonNumerics(String)}.
   * <ul>
   *   <li>When {@code UU}.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeNonNumerics(String)}
   */
  @Test
  public void testRemoveNonNumerics_whenUu_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", StringUtil.removeNonNumerics("UU"));
    assertEquals("", StringUtil.removeNonNumerics("UU{"));
  }

  /**
   * Test {@link StringUtil#removeNonNumerics(String)}.
   * <ul>
   *   <li>When {@code UUU}.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeNonNumerics(String)}
   */
  @Test
  public void testRemoveNonNumerics_whenUuu_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", StringUtil.removeNonNumerics("UUU"));
  }

  /**
   * Test {@link StringUtil#removeNonNumerics(String)}.
   * <ul>
   *   <li>When {@code Value42}.</li>
   *   <li>Then return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeNonNumerics(String)}
   */
  @Test
  public void testRemoveNonNumerics_whenValue42_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("42", StringUtil.removeNonNumerics("Value42"));
  }

  /**
   * Test {@link StringUtil#removeNonNumerics(String)}.
   * <ul>
   *   <li>When {@code Value[^\d.]+}.</li>
   *   <li>Then return {@code .}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeNonNumerics(String)}
   */
  @Test
  public void testRemoveNonNumerics_whenValueD_thenReturnDot() {
    // Arrange, Act and Assert
    assertEquals(".", StringUtil.removeNonNumerics("Value[^\\d.]+"));
  }

  /**
   * Test {@link StringUtil#removeNonNumerics(String)}.
   * <ul>
   *   <li>When {@code ValueU}.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeNonNumerics(String)}
   */
  @Test
  public void testRemoveNonNumerics_whenValueU_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", StringUtil.removeNonNumerics("ValueU"));
  }

  /**
   * Test {@link StringUtil#removeNonNumerics(String)}.
   * <ul>
   *   <li>When {@code ValueValue}.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeNonNumerics(String)}
   */
  @Test
  public void testRemoveNonNumerics_whenValueValue_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", StringUtil.removeNonNumerics("ValueValue"));
  }

  /**
   * Test {@link StringUtil#removeNonNumerics(String)}.
   * <ul>
   *   <li>When {@code Value.}.</li>
   *   <li>Then return {@code .}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeNonNumerics(String)}
   */
  @Test
  public void testRemoveNonNumerics_whenValue_thenReturnDot() {
    // Arrange, Act and Assert
    assertEquals(".", StringUtil.removeNonNumerics("Value."));
    assertEquals(".", StringUtil.removeNonNumerics(".Value"));
  }

  /**
   * Test {@link StringUtil#removeNonNumerics(String)}.
   * <ul>
   *   <li>When {@code Value}.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeNonNumerics(String)}
   */
  @Test
  public void testRemoveNonNumerics_whenValue_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", StringUtil.removeNonNumerics("Value"));
    assertEquals("", StringUtil.removeNonNumerics("Value{"));
    assertEquals("", StringUtil.removeNonNumerics("{Value"));
  }

  /**
   * Test {@link StringUtil#removeNonNumerics(String)}.
   * <ul>
   *   <li>When {@code Valuejava.lang.Boolean}.</li>
   *   <li>Then return {@code ..}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeNonNumerics(String)}
   */
  @Test
  public void testRemoveNonNumerics_whenValuejavaLangBoolean_thenReturnDotDot() {
    // Arrange, Act and Assert
    assertEquals("..", StringUtil.removeNonNumerics("Valuejava.lang.Boolean"));
  }

  /**
   * Test {@link StringUtil#removeNonNumerics(String)}.
   * <ul>
   *   <li>When {@code Valuejava.util.Map$Entry}.</li>
   *   <li>Then return {@code ..}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeNonNumerics(String)}
   */
  @Test
  public void testRemoveNonNumerics_whenValuejavaUtilMapEntry_thenReturnDotDot() {
    // Arrange, Act and Assert
    assertEquals("..", StringUtil.removeNonNumerics("Valuejava.util.Map$Entry"));
  }

  /**
   * Test {@link StringUtil#removeNonNumerics(String)}.
   * <ul>
   *   <li>When {@code Valuenull}.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeNonNumerics(String)}
   */
  @Test
  public void testRemoveNonNumerics_whenValuenull_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", StringUtil.removeNonNumerics("Valuenull"));
  }

  /**
   * Test {@link StringUtil#removeNonNumerics(String)}.
   * <ul>
   *   <li>When {@code Valueorg.broadleafcommerce.common.util.StringUtil}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#removeNonNumerics(String)}
   */
  @Test
  public void testRemoveNonNumerics_whenValueorgBroadleafcommerceCommonUtilStringUtil() {
    // Arrange, Act and Assert
    assertEquals("....", StringUtil.removeNonNumerics("Valueorg.broadleafcommerce.common.util.StringUtil"));
  }

  /**
   * Test {@link StringUtil#sanitize(String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code NULL}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#sanitize(String)}
   */
  @Test
  public void testSanitize_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertEquals("NULL", StringUtil.sanitize(null));
  }

  /**
   * Test {@link StringUtil#sanitize(String)}.
   * <ul>
   *   <li>When {@code String}.</li>
   *   <li>Then return {@code String}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#sanitize(String)}
   */
  @Test
  public void testSanitize_whenString_thenReturnString() {
    // Arrange, Act and Assert
    assertEquals("String", StringUtil.sanitize("String"));
  }
}
