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
import java.util.HashMap;
import java.util.Map;
import org.junit.Test;

public class StringUtilDiffblueTest {
  /**
   * Method under test: {@link StringUtil#getChecksum(String)}
   */
  @Test
  public void testGetChecksum() {
    // Arrange, Act and Assert
    assertEquals(64815521L, StringUtil.getChecksum("Test"));
  }

  /**
   * Method under test: {@link StringUtil#segmentInclusion(String, String)}
   */
  @Test
  public void testSegmentInclusion() {
    // Arrange, Act and Assert
    assertFalse(StringUtil.segmentInclusion("Bigger", "Included"));
    assertTrue(StringUtil.segmentInclusion("Included", "Included"));
    assertFalse(StringUtil.segmentInclusion("", "Included"));
    assertFalse(StringUtil.segmentInclusion("Bigger", ""));
  }

  /**
   * Method under test: {@link StringUtil#determineSimilarity(String, String)}
   */
  @Test
  public void testDetermineSimilarity() {
    // Arrange, Act and Assert
    assertEquals(32768.49999618536d, StringUtil.determineSimilarity("Test1", "Test2"), 0.0);
    assertEquals(4.771044099999999E7d, StringUtil.determineSimilarity(" ", "Test2"), 0.0);
    assertEquals(2.4985641500000006E8d, StringUtil.determineSimilarity("[ \\t\\n\\r\\f\\v\\/'-]", "Test2"), 0.0);
  }

  /**
   * Method under test: {@link StringUtil#cleanseUrlString(String)}
   */
  @Test
  public void testCleanseUrlString() {
    // Arrange, Act and Assert
    assertEquals("https://example.org/example", StringUtil.cleanseUrlString("https://example.org/example"));
    assertEquals("", StringUtil.cleanseUrlString(" "));
    assertEquals("[\\r\\n]", StringUtil.cleanseUrlString("[ \\r\\n]"));
    assertNull(StringUtil.cleanseUrlString(null));
    assertEquals("https://example.org/example", StringUtil.cleanseUrlString("https://example.org/example "));
    assertEquals("https://example.org/example[\\r\\n]",
        StringUtil.cleanseUrlString("https://example.org/example[ \\r\\n]"));
    assertEquals("https://example.org/example", StringUtil.cleanseUrlString(" https://example.org/example"));
    assertEquals("", StringUtil.cleanseUrlString("  "));
    assertEquals("UTF-8", StringUtil.cleanseUrlString(" UTF-8"));
    assertEquals("[\\r\\n]", StringUtil.cleanseUrlString(" [ \\r\\n]"));
    assertEquals("Input", StringUtil.cleanseUrlString(" Input"));
    assertEquals(".", StringUtil.cleanseUrlString(" ."));
    assertEquals("42", StringUtil.cleanseUrlString(" 42"));
    assertEquals("java.lang.Boolean", StringUtil.cleanseUrlString(" java.lang.Boolean"));
    assertEquals("java.util.Map$Entry", StringUtil.cleanseUrlString(" java.util.Map$Entry"));
    assertEquals("null", StringUtil.cleanseUrlString(" null"));
    assertEquals("org.broadleafcommerce.common.util.StringUtil",
        StringUtil.cleanseUrlString(" org.broadleafcommerce.common.util.StringUtil"));
    assertEquals("{", StringUtil.cleanseUrlString(" {"));
    assertEquals("UTF-8", StringUtil.cleanseUrlString("UTF-8 "));
    assertEquals("UTF-8[\\r\\n]", StringUtil.cleanseUrlString("UTF-8[ \\r\\n]"));
    assertEquals("[\\r\\n]https://example.org/example",
        StringUtil.cleanseUrlString("[ \\r\\n]https://example.org/example"));
    assertEquals("[\\r\\n]", StringUtil.cleanseUrlString("[ \\r\\n] "));
    assertEquals("[\\r\\n]UTF-8", StringUtil.cleanseUrlString("[ \\r\\n]UTF-8"));
    assertEquals("[\\r\\n][\\r\\n]", StringUtil.cleanseUrlString("[ \\r\\n][ \\r\\n]"));
    assertEquals("[\\r\\n]Input", StringUtil.cleanseUrlString("[ \\r\\n]Input"));
    assertEquals("[\\r\\n].", StringUtil.cleanseUrlString("[ \\r\\n]."));
    assertEquals("[\\r\\n]42", StringUtil.cleanseUrlString("[ \\r\\n]42"));
    assertEquals("[\\r\\n]java.lang.Boolean", StringUtil.cleanseUrlString("[ \\r\\n]java.lang.Boolean"));
    assertEquals("[\\r\\n]java.util.Map$Entry", StringUtil.cleanseUrlString("[ \\r\\n]java.util.Map$Entry"));
    assertEquals("[\\r\\n]null", StringUtil.cleanseUrlString("[ \\r\\n]null"));
    assertEquals("[\\r\\n]org.broadleafcommerce.common.util.StringUtil",
        StringUtil.cleanseUrlString("[ \\r\\n]org.broadleafcommerce.common.util.StringUtil"));
    assertEquals("[\\r\\n]{", StringUtil.cleanseUrlString("[ \\r\\n]{"));
    assertEquals("Input", StringUtil.cleanseUrlString("Input "));
    assertEquals("Input[\\r\\n]", StringUtil.cleanseUrlString("Input[ \\r\\n]"));
    assertEquals(".", StringUtil.cleanseUrlString(". "));
    assertEquals(".[\\r\\n]", StringUtil.cleanseUrlString(".[ \\r\\n]"));
    assertEquals("42", StringUtil.cleanseUrlString("42 "));
    assertEquals("42[\\r\\n]", StringUtil.cleanseUrlString("42[ \\r\\n]"));
    assertEquals("java.lang.Boolean", StringUtil.cleanseUrlString("java.lang.Boolean "));
    assertEquals("java.lang.Boolean[\\r\\n]", StringUtil.cleanseUrlString("java.lang.Boolean[ \\r\\n]"));
    assertEquals("java.util.Map$Entry", StringUtil.cleanseUrlString("java.util.Map$Entry "));
    assertEquals("java.util.Map$Entry[\\r\\n]", StringUtil.cleanseUrlString("java.util.Map$Entry[ \\r\\n]"));
    assertEquals("null", StringUtil.cleanseUrlString("null "));
    assertEquals("null[\\r\\n]", StringUtil.cleanseUrlString("null[ \\r\\n]"));
    assertEquals("org.broadleafcommerce.common.util.StringUtil",
        StringUtil.cleanseUrlString("org.broadleafcommerce.common.util.StringUtil "));
    assertEquals("org.broadleafcommerce.common.util.StringUtil[\\r\\n]",
        StringUtil.cleanseUrlString("org.broadleafcommerce.common.util.StringUtil[ \\r\\n]"));
    assertEquals("{", StringUtil.cleanseUrlString("{ "));
    assertEquals("{[\\r\\n]", StringUtil.cleanseUrlString("{[ \\r\\n]"));
    assertEquals("https://example.org/examplehttps://example.org/example",
        StringUtil.cleanseUrlString("https://example.org/examplehttps://example.org/example "));
    assertEquals("https://example.org/examplehttps://example.org/example[\\r\\n]",
        StringUtil.cleanseUrlString("https://example.org/examplehttps://example.org/example[ \\r\\n]"));
    assertEquals("https://example.org/examplehttps://example.org/example",
        StringUtil.cleanseUrlString("https://example.org/example https://example.org/example"));
    assertEquals("https://example.org/example", StringUtil.cleanseUrlString("https://example.org/example  "));
    assertEquals("https://example.org/exampleUTF-8", StringUtil.cleanseUrlString("https://example.org/example UTF-8"));
    assertEquals("https://example.org/example[\\r\\n]",
        StringUtil.cleanseUrlString("https://example.org/example [ \\r\\n]"));
    assertEquals("https://example.org/exampleInput", StringUtil.cleanseUrlString("https://example.org/example Input"));
    assertEquals("https://example.org/example.", StringUtil.cleanseUrlString("https://example.org/example ."));
    assertEquals("https://example.org/example42", StringUtil.cleanseUrlString("https://example.org/example 42"));
    assertEquals("https://example.org/examplejava.lang.Boolean",
        StringUtil.cleanseUrlString("https://example.org/example java.lang.Boolean"));
    assertEquals("https://example.org/examplejava.util.Map$Entry",
        StringUtil.cleanseUrlString("https://example.org/example java.util.Map$Entry"));
    assertEquals("https://example.org/examplenull", StringUtil.cleanseUrlString("https://example.org/example null"));
    assertEquals("https://example.org/exampleorg.broadleafcommerce.common.util.StringUtil",
        StringUtil.cleanseUrlString("https://example.org/example org.broadleafcommerce.common.util.StringUtil"));
    assertEquals("https://example.org/example{", StringUtil.cleanseUrlString("https://example.org/example {"));
    assertEquals("https://example.org/exampleUTF-8", StringUtil.cleanseUrlString("https://example.org/exampleUTF-8 "));
    assertEquals("https://example.org/exampleUTF-8[\\r\\n]",
        StringUtil.cleanseUrlString("https://example.org/exampleUTF-8[ \\r\\n]"));
    assertEquals("https://example.org/example[\\r\\n]https://example.org/example",
        StringUtil.cleanseUrlString("https://example.org/example[ \\r\\n]https://example.org/example"));
    assertEquals("https://example.org/example[\\r\\n]",
        StringUtil.cleanseUrlString("https://example.org/example[ \\r\\n] "));
    assertEquals("https://example.org/example[\\r\\n]UTF-8",
        StringUtil.cleanseUrlString("https://example.org/example[ \\r\\n]UTF-8"));
    assertEquals("https://example.org/example[\\r\\n][\\r\\n]",
        StringUtil.cleanseUrlString("https://example.org/example[ \\r\\n][ \\r\\n]"));
    assertEquals("https://example.org/example[\\r\\n]Input",
        StringUtil.cleanseUrlString("https://example.org/example[ \\r\\n]Input"));
    assertEquals("https://example.org/example[\\r\\n].",
        StringUtil.cleanseUrlString("https://example.org/example[ \\r\\n]."));
    assertEquals("https://example.org/example[\\r\\n]42",
        StringUtil.cleanseUrlString("https://example.org/example[ \\r\\n]42"));
    assertEquals("https://example.org/example[\\r\\n]java.lang.Boolean",
        StringUtil.cleanseUrlString("https://example.org/example[ \\r\\n]java.lang.Boolean"));
    assertEquals("https://example.org/example[\\r\\n]java.util.Map$Entry",
        StringUtil.cleanseUrlString("https://example.org/example[ \\r\\n]java.util.Map$Entry"));
    assertEquals("https://example.org/example[\\r\\n]null",
        StringUtil.cleanseUrlString("https://example.org/example[ \\r\\n]null"));
    assertEquals("https://example.org/example[\\r\\n]org.broadleafcommerce.common.util.StringUtil", StringUtil
        .cleanseUrlString("https://example.org/example[ \\r\\n]org.broadleafcommerce.common.util.StringUtil"));
    assertEquals("https://example.org/example[\\r\\n]{",
        StringUtil.cleanseUrlString("https://example.org/example[ \\r\\n]{"));
    assertEquals("https://example.org/exampleInput", StringUtil.cleanseUrlString("https://example.org/exampleInput "));
    assertEquals("https://example.org/exampleInput[\\r\\n]",
        StringUtil.cleanseUrlString("https://example.org/exampleInput[ \\r\\n]"));
    assertEquals("https://example.org/example.", StringUtil.cleanseUrlString("https://example.org/example. "));
    assertEquals("https://example.org/example.[\\r\\n]",
        StringUtil.cleanseUrlString("https://example.org/example.[ \\r\\n]"));
    assertEquals("https://example.org/example42", StringUtil.cleanseUrlString("https://example.org/example42 "));
    assertEquals("https://example.org/example42[\\r\\n]",
        StringUtil.cleanseUrlString("https://example.org/example42[ \\r\\n]"));
    assertEquals("https://example.org/examplejava.lang.Boolean",
        StringUtil.cleanseUrlString("https://example.org/examplejava.lang.Boolean "));
    assertEquals("https://example.org/examplejava.lang.Boolean[\\r\\n]",
        StringUtil.cleanseUrlString("https://example.org/examplejava.lang.Boolean[ \\r\\n]"));
    assertEquals("https://example.org/examplejava.util.Map$Entry",
        StringUtil.cleanseUrlString("https://example.org/examplejava.util.Map$Entry "));
    assertEquals("https://example.org/examplejava.util.Map$Entry[\\r\\n]",
        StringUtil.cleanseUrlString("https://example.org/examplejava.util.Map$Entry[ \\r\\n]"));
    assertEquals("https://example.org/examplenull", StringUtil.cleanseUrlString("https://example.org/examplenull "));
    assertEquals("https://example.org/examplenull[\\r\\n]",
        StringUtil.cleanseUrlString("https://example.org/examplenull[ \\r\\n]"));
    assertEquals("https://example.org/exampleorg.broadleafcommerce.common.util.StringUtil",
        StringUtil.cleanseUrlString("https://example.org/exampleorg.broadleafcommerce.common.util.StringUtil "));
    assertEquals("https://example.org/exampleorg.broadleafcommerce.common.util.StringUtil[\\r\\n]", StringUtil
        .cleanseUrlString("https://example.org/exampleorg.broadleafcommerce.common.util.StringUtil[ \\r\\n]"));
    assertEquals("https://example.org/example{", StringUtil.cleanseUrlString("https://example.org/example{ "));
    assertEquals("https://example.org/example{[\\r\\n]",
        StringUtil.cleanseUrlString("https://example.org/example{[ \\r\\n]"));
    assertEquals("https://example.org/examplehttps://example.org/example",
        StringUtil.cleanseUrlString(" https://example.org/examplehttps://example.org/example"));
    assertEquals("https://example.org/example", StringUtil.cleanseUrlString(" https://example.org/example "));
    assertEquals("https://example.org/exampleUTF-8", StringUtil.cleanseUrlString(" https://example.org/exampleUTF-8"));
    assertEquals("https://example.org/example[\\r\\n]",
        StringUtil.cleanseUrlString(" https://example.org/example[ \\r\\n]"));
    assertEquals("https://example.org/exampleInput", StringUtil.cleanseUrlString(" https://example.org/exampleInput"));
    assertEquals("https://example.org/example.", StringUtil.cleanseUrlString(" https://example.org/example."));
    assertEquals("https://example.org/example42", StringUtil.cleanseUrlString(" https://example.org/example42"));
    assertEquals("https://example.org/examplejava.lang.Boolean",
        StringUtil.cleanseUrlString(" https://example.org/examplejava.lang.Boolean"));
    assertEquals("https://example.org/examplejava.util.Map$Entry",
        StringUtil.cleanseUrlString(" https://example.org/examplejava.util.Map$Entry"));
    assertEquals("https://example.org/examplenull", StringUtil.cleanseUrlString(" https://example.org/examplenull"));
    assertEquals("https://example.org/exampleorg.broadleafcommerce.common.util.StringUtil",
        StringUtil.cleanseUrlString(" https://example.org/exampleorg.broadleafcommerce.common.util.StringUtil"));
    assertEquals("https://example.org/example{", StringUtil.cleanseUrlString(" https://example.org/example{"));
  }

  /**
   * Method under test: {@link StringUtil#decodeUrl(String)}
   */
  @Test
  public void testDecodeUrl() {
    // Arrange, Act and Assert
    assertEquals("https://example.org/example", StringUtil.decodeUrl("https://example.org/example"));
    assertNull(StringUtil.decodeUrl(null));
  }

  /**
   * Method under test: {@link StringUtil#removeSpecialCharacters(String)}
   */
  @Test
  public void testRemoveSpecialCharacters() {
    // Arrange, Act and Assert
    assertEquals("Input", StringUtil.removeSpecialCharacters("Input"));
    assertEquals("", StringUtil.removeSpecialCharacters(" "));
    assertEquals("[\\r\\n]", StringUtil.removeSpecialCharacters("[ \\r\\n]"));
    assertNull(StringUtil.removeSpecialCharacters(null));
    assertEquals("", StringUtil.removeSpecialCharacters("  "));
    assertEquals("[\\r\\n]", StringUtil.removeSpecialCharacters(" [ \\r\\n]"));
    assertEquals("Input", StringUtil.removeSpecialCharacters(" Input"));
    assertEquals(".", StringUtil.removeSpecialCharacters(" ."));
    assertEquals("42", StringUtil.removeSpecialCharacters(" 42"));
    assertEquals("java.lang.Boolean", StringUtil.removeSpecialCharacters(" java.lang.Boolean"));
    assertEquals("java.util.Map$Entry", StringUtil.removeSpecialCharacters(" java.util.Map$Entry"));
    assertEquals("null", StringUtil.removeSpecialCharacters(" null"));
    assertEquals("org.broadleafcommerce.common.util.StringUtil",
        StringUtil.removeSpecialCharacters(" org.broadleafcommerce.common.util.StringUtil"));
    assertEquals("{", StringUtil.removeSpecialCharacters(" {"));
    assertEquals("[\\r\\n]", StringUtil.removeSpecialCharacters("[ \\r\\n] "));
    assertEquals("[\\r\\n][\\r\\n]", StringUtil.removeSpecialCharacters("[ \\r\\n][ \\r\\n]"));
    assertEquals("[\\r\\n]Input", StringUtil.removeSpecialCharacters("[ \\r\\n]Input"));
    assertEquals("[\\r\\n].", StringUtil.removeSpecialCharacters("[ \\r\\n]."));
    assertEquals("[\\r\\n]42", StringUtil.removeSpecialCharacters("[ \\r\\n]42"));
    assertEquals("[\\r\\n]java.lang.Boolean", StringUtil.removeSpecialCharacters("[ \\r\\n]java.lang.Boolean"));
    assertEquals("[\\r\\n]java.util.Map$Entry", StringUtil.removeSpecialCharacters("[ \\r\\n]java.util.Map$Entry"));
    assertEquals("[\\r\\n]null", StringUtil.removeSpecialCharacters("[ \\r\\n]null"));
    assertEquals("[\\r\\n]org.broadleafcommerce.common.util.StringUtil",
        StringUtil.removeSpecialCharacters("[ \\r\\n]org.broadleafcommerce.common.util.StringUtil"));
    assertEquals("[\\r\\n]{", StringUtil.removeSpecialCharacters("[ \\r\\n]{"));
    assertEquals("Input", StringUtil.removeSpecialCharacters("Input "));
    assertEquals("Input[\\r\\n]", StringUtil.removeSpecialCharacters("Input[ \\r\\n]"));
    assertEquals(".", StringUtil.removeSpecialCharacters(". "));
    assertEquals(".[\\r\\n]", StringUtil.removeSpecialCharacters(".[ \\r\\n]"));
    assertEquals("42", StringUtil.removeSpecialCharacters("42 "));
    assertEquals("42[\\r\\n]", StringUtil.removeSpecialCharacters("42[ \\r\\n]"));
    assertEquals("java.lang.Boolean", StringUtil.removeSpecialCharacters("java.lang.Boolean "));
    assertEquals("java.lang.Boolean[\\r\\n]", StringUtil.removeSpecialCharacters("java.lang.Boolean[ \\r\\n]"));
    assertEquals("java.util.Map$Entry", StringUtil.removeSpecialCharacters("java.util.Map$Entry "));
    assertEquals("java.util.Map$Entry[\\r\\n]", StringUtil.removeSpecialCharacters("java.util.Map$Entry[ \\r\\n]"));
    assertEquals("null", StringUtil.removeSpecialCharacters("null "));
    assertEquals("null[\\r\\n]", StringUtil.removeSpecialCharacters("null[ \\r\\n]"));
    assertEquals("org.broadleafcommerce.common.util.StringUtil",
        StringUtil.removeSpecialCharacters("org.broadleafcommerce.common.util.StringUtil "));
    assertEquals("org.broadleafcommerce.common.util.StringUtil[\\r\\n]",
        StringUtil.removeSpecialCharacters("org.broadleafcommerce.common.util.StringUtil[ \\r\\n]"));
    assertEquals("{", StringUtil.removeSpecialCharacters("{ "));
    assertEquals("{[\\r\\n]", StringUtil.removeSpecialCharacters("{[ \\r\\n]"));
    assertEquals("", StringUtil.removeSpecialCharacters("   "));
    assertEquals("[\\r\\n]", StringUtil.removeSpecialCharacters("  [ \\r\\n]"));
    assertEquals("Input", StringUtil.removeSpecialCharacters("  Input"));
    assertEquals(".", StringUtil.removeSpecialCharacters("  ."));
    assertEquals("42", StringUtil.removeSpecialCharacters("  42"));
    assertEquals("java.lang.Boolean", StringUtil.removeSpecialCharacters("  java.lang.Boolean"));
    assertEquals("java.util.Map$Entry", StringUtil.removeSpecialCharacters("  java.util.Map$Entry"));
    assertEquals("null", StringUtil.removeSpecialCharacters("  null"));
    assertEquals("org.broadleafcommerce.common.util.StringUtil",
        StringUtil.removeSpecialCharacters("  org.broadleafcommerce.common.util.StringUtil"));
    assertEquals("{", StringUtil.removeSpecialCharacters("  {"));
    assertEquals("[\\r\\n]", StringUtil.removeSpecialCharacters(" [ \\r\\n] "));
    assertEquals("[\\r\\n][\\r\\n]", StringUtil.removeSpecialCharacters(" [ \\r\\n][ \\r\\n]"));
    assertEquals("[\\r\\n]Input", StringUtil.removeSpecialCharacters(" [ \\r\\n]Input"));
    assertEquals("[\\r\\n].", StringUtil.removeSpecialCharacters(" [ \\r\\n]."));
    assertEquals("[\\r\\n]42", StringUtil.removeSpecialCharacters(" [ \\r\\n]42"));
    assertEquals("[\\r\\n]java.lang.Boolean", StringUtil.removeSpecialCharacters(" [ \\r\\n]java.lang.Boolean"));
    assertEquals("[\\r\\n]java.util.Map$Entry", StringUtil.removeSpecialCharacters(" [ \\r\\n]java.util.Map$Entry"));
    assertEquals("[\\r\\n]null", StringUtil.removeSpecialCharacters(" [ \\r\\n]null"));
    assertEquals("[\\r\\n]org.broadleafcommerce.common.util.StringUtil",
        StringUtil.removeSpecialCharacters(" [ \\r\\n]org.broadleafcommerce.common.util.StringUtil"));
    assertEquals("[\\r\\n]{", StringUtil.removeSpecialCharacters(" [ \\r\\n]{"));
    assertEquals("Input", StringUtil.removeSpecialCharacters(" Input "));
    assertEquals("Input[\\r\\n]", StringUtil.removeSpecialCharacters(" Input[ \\r\\n]"));
    assertEquals("InputInput", StringUtil.removeSpecialCharacters(" InputInput"));
    assertEquals("Input.", StringUtil.removeSpecialCharacters(" Input."));
    assertEquals("Input42", StringUtil.removeSpecialCharacters(" Input42"));
    assertEquals("Inputjava.lang.Boolean", StringUtil.removeSpecialCharacters(" Inputjava.lang.Boolean"));
    assertEquals("Inputjava.util.Map$Entry", StringUtil.removeSpecialCharacters(" Inputjava.util.Map$Entry"));
    assertEquals("Inputnull", StringUtil.removeSpecialCharacters(" Inputnull"));
    assertEquals("Inputorg.broadleafcommerce.common.util.StringUtil",
        StringUtil.removeSpecialCharacters(" Inputorg.broadleafcommerce.common.util.StringUtil"));
    assertEquals("Input{", StringUtil.removeSpecialCharacters(" Input{"));
    assertEquals(".", StringUtil.removeSpecialCharacters(" . "));
    assertEquals(".[\\r\\n]", StringUtil.removeSpecialCharacters(" .[ \\r\\n]"));
    assertEquals(".Input", StringUtil.removeSpecialCharacters(" .Input"));
    assertEquals("..", StringUtil.removeSpecialCharacters(" .."));
    assertEquals(".42", StringUtil.removeSpecialCharacters(" .42"));
    assertEquals(".java.lang.Boolean", StringUtil.removeSpecialCharacters(" .java.lang.Boolean"));
    assertEquals(".java.util.Map$Entry", StringUtil.removeSpecialCharacters(" .java.util.Map$Entry"));
    assertEquals(".null", StringUtil.removeSpecialCharacters(" .null"));
    assertEquals(".org.broadleafcommerce.common.util.StringUtil",
        StringUtil.removeSpecialCharacters(" .org.broadleafcommerce.common.util.StringUtil"));
    assertEquals(".{", StringUtil.removeSpecialCharacters(" .{"));
    assertEquals("42", StringUtil.removeSpecialCharacters(" 42 "));
    assertEquals("42[\\r\\n]", StringUtil.removeSpecialCharacters(" 42[ \\r\\n]"));
    assertEquals("42Input", StringUtil.removeSpecialCharacters(" 42Input"));
    assertEquals("42.", StringUtil.removeSpecialCharacters(" 42."));
    assertEquals("4242", StringUtil.removeSpecialCharacters(" 4242"));
    assertEquals("42java.lang.Boolean", StringUtil.removeSpecialCharacters(" 42java.lang.Boolean"));
    assertEquals("42java.util.Map$Entry", StringUtil.removeSpecialCharacters(" 42java.util.Map$Entry"));
    assertEquals("42null", StringUtil.removeSpecialCharacters(" 42null"));
    assertEquals("42org.broadleafcommerce.common.util.StringUtil",
        StringUtil.removeSpecialCharacters(" 42org.broadleafcommerce.common.util.StringUtil"));
    assertEquals("42{", StringUtil.removeSpecialCharacters(" 42{"));
    assertEquals("java.lang.Boolean", StringUtil.removeSpecialCharacters(" java.lang.Boolean "));
    assertEquals("java.lang.Boolean[\\r\\n]", StringUtil.removeSpecialCharacters(" java.lang.Boolean[ \\r\\n]"));
    assertEquals("java.lang.BooleanInput", StringUtil.removeSpecialCharacters(" java.lang.BooleanInput"));
    assertEquals("java.lang.Boolean.", StringUtil.removeSpecialCharacters(" java.lang.Boolean."));
    assertEquals("java.lang.Boolean42", StringUtil.removeSpecialCharacters(" java.lang.Boolean42"));
    assertEquals("java.lang.Booleanjava.lang.Boolean",
        StringUtil.removeSpecialCharacters(" java.lang.Booleanjava.lang.Boolean"));
    assertEquals("java.lang.Booleanjava.util.Map$Entry",
        StringUtil.removeSpecialCharacters(" java.lang.Booleanjava.util.Map$Entry"));
    assertEquals("java.lang.Booleannull", StringUtil.removeSpecialCharacters(" java.lang.Booleannull"));
    assertEquals("java.lang.Booleanorg.broadleafcommerce.common.util.StringUtil",
        StringUtil.removeSpecialCharacters(" java.lang.Booleanorg.broadleafcommerce.common.util.StringUtil"));
    assertEquals("java.lang.Boolean{", StringUtil.removeSpecialCharacters(" java.lang.Boolean{"));
    assertEquals("java.util.Map$Entry", StringUtil.removeSpecialCharacters(" java.util.Map$Entry "));
    assertEquals("java.util.Map$Entry[\\r\\n]", StringUtil.removeSpecialCharacters(" java.util.Map$Entry[ \\r\\n]"));
    assertEquals("java.util.Map$EntryInput", StringUtil.removeSpecialCharacters(" java.util.Map$EntryInput"));
    assertEquals("java.util.Map$Entry.", StringUtil.removeSpecialCharacters(" java.util.Map$Entry."));
    assertEquals("java.util.Map$Entry42", StringUtil.removeSpecialCharacters(" java.util.Map$Entry42"));
    assertEquals("java.util.Map$Entryjava.lang.Boolean",
        StringUtil.removeSpecialCharacters(" java.util.Map$Entryjava.lang.Boolean"));
    assertEquals("java.util.Map$Entryjava.util.Map$Entry",
        StringUtil.removeSpecialCharacters(" java.util.Map$Entryjava.util.Map$Entry"));
    assertEquals("java.util.Map$Entrynull", StringUtil.removeSpecialCharacters(" java.util.Map$Entrynull"));
    assertEquals("java.util.Map$Entryorg.broadleafcommerce.common.util.StringUtil",
        StringUtil.removeSpecialCharacters(" java.util.Map$Entryorg.broadleafcommerce.common.util.StringUtil"));
    assertEquals("java.util.Map$Entry{", StringUtil.removeSpecialCharacters(" java.util.Map$Entry{"));
    assertEquals("null", StringUtil.removeSpecialCharacters(" null "));
    assertEquals("null[\\r\\n]", StringUtil.removeSpecialCharacters(" null[ \\r\\n]"));
    assertEquals("nullInput", StringUtil.removeSpecialCharacters(" nullInput"));
    assertEquals("null.", StringUtil.removeSpecialCharacters(" null."));
    assertEquals("null42", StringUtil.removeSpecialCharacters(" null42"));
    assertEquals("nulljava.lang.Boolean", StringUtil.removeSpecialCharacters(" nulljava.lang.Boolean"));
    assertEquals("nulljava.util.Map$Entry", StringUtil.removeSpecialCharacters(" nulljava.util.Map$Entry"));
    assertEquals("nullnull", StringUtil.removeSpecialCharacters(" nullnull"));
    assertEquals("nullorg.broadleafcommerce.common.util.StringUtil",
        StringUtil.removeSpecialCharacters(" nullorg.broadleafcommerce.common.util.StringUtil"));
    assertEquals("null{", StringUtil.removeSpecialCharacters(" null{"));
    assertEquals("org.broadleafcommerce.common.util.StringUtil",
        StringUtil.removeSpecialCharacters(" org.broadleafcommerce.common.util.StringUtil "));
    assertEquals("org.broadleafcommerce.common.util.StringUtil[\\r\\n]",
        StringUtil.removeSpecialCharacters(" org.broadleafcommerce.common.util.StringUtil[ \\r\\n]"));
    assertEquals("org.broadleafcommerce.common.util.StringUtilInput",
        StringUtil.removeSpecialCharacters(" org.broadleafcommerce.common.util.StringUtilInput"));
    assertEquals("org.broadleafcommerce.common.util.StringUtil.",
        StringUtil.removeSpecialCharacters(" org.broadleafcommerce.common.util.StringUtil."));
    assertEquals("org.broadleafcommerce.common.util.StringUtil42",
        StringUtil.removeSpecialCharacters(" org.broadleafcommerce.common.util.StringUtil42"));
    assertEquals("org.broadleafcommerce.common.util.StringUtiljava.lang.Boolean",
        StringUtil.removeSpecialCharacters(" org.broadleafcommerce.common.util.StringUtiljava.lang.Boolean"));
    assertEquals("org.broadleafcommerce.common.util.StringUtiljava.util.Map$Entry",
        StringUtil.removeSpecialCharacters(" org.broadleafcommerce.common.util.StringUtiljava.util.Map$Entry"));
    assertEquals("org.broadleafcommerce.common.util.StringUtilnull",
        StringUtil.removeSpecialCharacters(" org.broadleafcommerce.common.util.StringUtilnull"));
    assertEquals("org.broadleafcommerce.common.util.StringUtilorg.broadleafcommerce.common.util.StringUtil",
        StringUtil.removeSpecialCharacters(
            " org.broadleafcommerce.common.util.StringUtilorg.broadleafcommerce.common.util.StringUtil"));
    assertEquals("org.broadleafcommerce.common.util.StringUtil{",
        StringUtil.removeSpecialCharacters(" org.broadleafcommerce.common.util.StringUtil{"));
    assertEquals("{", StringUtil.removeSpecialCharacters(" { "));
    assertEquals("{[\\r\\n]", StringUtil.removeSpecialCharacters(" {[ \\r\\n]"));
    assertEquals("{Input", StringUtil.removeSpecialCharacters(" {Input"));
    assertEquals("{.", StringUtil.removeSpecialCharacters(" {."));
    assertEquals("{42", StringUtil.removeSpecialCharacters(" {42"));
    assertEquals("{java.lang.Boolean", StringUtil.removeSpecialCharacters(" {java.lang.Boolean"));
    assertEquals("{java.util.Map$Entry", StringUtil.removeSpecialCharacters(" {java.util.Map$Entry"));
    assertEquals("{null", StringUtil.removeSpecialCharacters(" {null"));
    assertEquals("{org.broadleafcommerce.common.util.StringUtil",
        StringUtil.removeSpecialCharacters(" {org.broadleafcommerce.common.util.StringUtil"));
    assertEquals("{{", StringUtil.removeSpecialCharacters(" {{"));
    assertEquals("[\\r\\n]", StringUtil.removeSpecialCharacters("[ \\r\\n]  "));
    assertEquals("[\\r\\n][\\r\\n]", StringUtil.removeSpecialCharacters("[ \\r\\n] [ \\r\\n]"));
    assertEquals("[\\r\\n]Input", StringUtil.removeSpecialCharacters("[ \\r\\n] Input"));
    assertEquals("[\\r\\n].", StringUtil.removeSpecialCharacters("[ \\r\\n] ."));
    assertEquals("[\\r\\n]42", StringUtil.removeSpecialCharacters("[ \\r\\n] 42"));
    assertEquals("[\\r\\n]java.lang.Boolean", StringUtil.removeSpecialCharacters("[ \\r\\n] java.lang.Boolean"));
    assertEquals("[\\r\\n]java.util.Map$Entry", StringUtil.removeSpecialCharacters("[ \\r\\n] java.util.Map$Entry"));
    assertEquals("[\\r\\n]null", StringUtil.removeSpecialCharacters("[ \\r\\n] null"));
    assertEquals("[\\r\\n]org.broadleafcommerce.common.util.StringUtil",
        StringUtil.removeSpecialCharacters("[ \\r\\n] org.broadleafcommerce.common.util.StringUtil"));
    assertEquals("[\\r\\n]{", StringUtil.removeSpecialCharacters("[ \\r\\n] {"));
    assertEquals("[\\r\\n][\\r\\n]", StringUtil.removeSpecialCharacters("[ \\r\\n][ \\r\\n] "));
    assertEquals("[\\r\\n][\\r\\n][\\r\\n]", StringUtil.removeSpecialCharacters("[ \\r\\n][ \\r\\n][ \\r\\n]"));
    assertEquals("[\\r\\n][\\r\\n]Input", StringUtil.removeSpecialCharacters("[ \\r\\n][ \\r\\n]Input"));
    assertEquals("[\\r\\n][\\r\\n].", StringUtil.removeSpecialCharacters("[ \\r\\n][ \\r\\n]."));
    assertEquals("[\\r\\n][\\r\\n]42", StringUtil.removeSpecialCharacters("[ \\r\\n][ \\r\\n]42"));
    assertEquals("[\\r\\n][\\r\\n]java.lang.Boolean",
        StringUtil.removeSpecialCharacters("[ \\r\\n][ \\r\\n]java.lang.Boolean"));
    assertEquals("[\\r\\n][\\r\\n]java.util.Map$Entry",
        StringUtil.removeSpecialCharacters("[ \\r\\n][ \\r\\n]java.util.Map$Entry"));
    assertEquals("[\\r\\n][\\r\\n]null", StringUtil.removeSpecialCharacters("[ \\r\\n][ \\r\\n]null"));
    assertEquals("[\\r\\n][\\r\\n]org.broadleafcommerce.common.util.StringUtil",
        StringUtil.removeSpecialCharacters("[ \\r\\n][ \\r\\n]org.broadleafcommerce.common.util.StringUtil"));
    assertEquals("[\\r\\n][\\r\\n]{", StringUtil.removeSpecialCharacters("[ \\r\\n][ \\r\\n]{"));
    assertEquals("[\\r\\n]Input", StringUtil.removeSpecialCharacters("[ \\r\\n]Input "));
    assertEquals("[\\r\\n]Input[\\r\\n]", StringUtil.removeSpecialCharacters("[ \\r\\n]Input[ \\r\\n]"));
    assertEquals("[\\r\\n]InputInput", StringUtil.removeSpecialCharacters("[ \\r\\n]InputInput"));
    assertEquals("[\\r\\n]Input.", StringUtil.removeSpecialCharacters("[ \\r\\n]Input."));
    assertEquals("[\\r\\n]Input42", StringUtil.removeSpecialCharacters("[ \\r\\n]Input42"));
    assertEquals("[\\r\\n]Inputjava.lang.Boolean",
        StringUtil.removeSpecialCharacters("[ \\r\\n]Inputjava.lang.Boolean"));
    assertEquals("[\\r\\n]Inputjava.util.Map$Entry",
        StringUtil.removeSpecialCharacters("[ \\r\\n]Inputjava.util.Map$Entry"));
    assertEquals("[\\r\\n]Inputnull", StringUtil.removeSpecialCharacters("[ \\r\\n]Inputnull"));
    assertEquals("[\\r\\n]Inputorg.broadleafcommerce.common.util.StringUtil",
        StringUtil.removeSpecialCharacters("[ \\r\\n]Inputorg.broadleafcommerce.common.util.StringUtil"));
    assertEquals("[\\r\\n]Input{", StringUtil.removeSpecialCharacters("[ \\r\\n]Input{"));
    assertEquals("[\\r\\n].", StringUtil.removeSpecialCharacters("[ \\r\\n]. "));
    assertEquals("[\\r\\n].[\\r\\n]", StringUtil.removeSpecialCharacters("[ \\r\\n].[ \\r\\n]"));
    assertEquals("[\\r\\n].Input", StringUtil.removeSpecialCharacters("[ \\r\\n].Input"));
    assertEquals("[\\r\\n]..", StringUtil.removeSpecialCharacters("[ \\r\\n].."));
    assertEquals("[\\r\\n].42", StringUtil.removeSpecialCharacters("[ \\r\\n].42"));
    assertEquals("[\\r\\n].java.lang.Boolean", StringUtil.removeSpecialCharacters("[ \\r\\n].java.lang.Boolean"));
    assertEquals("[\\r\\n].java.util.Map$Entry", StringUtil.removeSpecialCharacters("[ \\r\\n].java.util.Map$Entry"));
    assertEquals("[\\r\\n].null", StringUtil.removeSpecialCharacters("[ \\r\\n].null"));
    assertEquals("[\\r\\n].org.broadleafcommerce.common.util.StringUtil",
        StringUtil.removeSpecialCharacters("[ \\r\\n].org.broadleafcommerce.common.util.StringUtil"));
    assertEquals("[\\r\\n].{", StringUtil.removeSpecialCharacters("[ \\r\\n].{"));
    assertEquals("[\\r\\n]42", StringUtil.removeSpecialCharacters("[ \\r\\n]42 "));
    assertEquals("[\\r\\n]42[\\r\\n]", StringUtil.removeSpecialCharacters("[ \\r\\n]42[ \\r\\n]"));
    assertEquals("[\\r\\n]42Input", StringUtil.removeSpecialCharacters("[ \\r\\n]42Input"));
    assertEquals("[\\r\\n]42.", StringUtil.removeSpecialCharacters("[ \\r\\n]42."));
    assertEquals("[\\r\\n]4242", StringUtil.removeSpecialCharacters("[ \\r\\n]4242"));
    assertEquals("[\\r\\n]42java.lang.Boolean", StringUtil.removeSpecialCharacters("[ \\r\\n]42java.lang.Boolean"));
    assertEquals("[\\r\\n]42java.util.Map$Entry", StringUtil.removeSpecialCharacters("[ \\r\\n]42java.util.Map$Entry"));
    assertEquals("[\\r\\n]42null", StringUtil.removeSpecialCharacters("[ \\r\\n]42null"));
    assertEquals("[\\r\\n]42org.broadleafcommerce.common.util.StringUtil",
        StringUtil.removeSpecialCharacters("[ \\r\\n]42org.broadleafcommerce.common.util.StringUtil"));
    assertEquals("[\\r\\n]42{", StringUtil.removeSpecialCharacters("[ \\r\\n]42{"));
    assertEquals("[\\r\\n]java.lang.Boolean", StringUtil.removeSpecialCharacters("[ \\r\\n]java.lang.Boolean "));
    assertEquals("[\\r\\n]java.lang.Boolean[\\r\\n]",
        StringUtil.removeSpecialCharacters("[ \\r\\n]java.lang.Boolean[ \\r\\n]"));
    assertEquals("[\\r\\n]java.lang.BooleanInput",
        StringUtil.removeSpecialCharacters("[ \\r\\n]java.lang.BooleanInput"));
    assertEquals("[\\r\\n]java.lang.Boolean.", StringUtil.removeSpecialCharacters("[ \\r\\n]java.lang.Boolean."));
    assertEquals("[\\r\\n]java.lang.Boolean42", StringUtil.removeSpecialCharacters("[ \\r\\n]java.lang.Boolean42"));
    assertEquals("[\\r\\n]java.lang.Booleanjava.lang.Boolean",
        StringUtil.removeSpecialCharacters("[ \\r\\n]java.lang.Booleanjava.lang.Boolean"));
    assertEquals("[\\r\\n]java.lang.Booleanjava.util.Map$Entry",
        StringUtil.removeSpecialCharacters("[ \\r\\n]java.lang.Booleanjava.util.Map$Entry"));
    assertEquals("[\\r\\n]java.lang.Booleannull", StringUtil.removeSpecialCharacters("[ \\r\\n]java.lang.Booleannull"));
    assertEquals("[\\r\\n]java.lang.Booleanorg.broadleafcommerce.common.util.StringUtil",
        StringUtil.removeSpecialCharacters("[ \\r\\n]java.lang.Booleanorg.broadleafcommerce.common.util.StringUtil"));
    assertEquals("[\\r\\n]java.lang.Boolean{", StringUtil.removeSpecialCharacters("[ \\r\\n]java.lang.Boolean{"));
    assertEquals("[\\r\\n]java.util.Map$Entry", StringUtil.removeSpecialCharacters("[ \\r\\n]java.util.Map$Entry "));
    assertEquals("[\\r\\n]java.util.Map$Entry[\\r\\n]",
        StringUtil.removeSpecialCharacters("[ \\r\\n]java.util.Map$Entry[ \\r\\n]"));
    assertEquals("[\\r\\n]java.util.Map$EntryInput",
        StringUtil.removeSpecialCharacters("[ \\r\\n]java.util.Map$EntryInput"));
    assertEquals("[\\r\\n]java.util.Map$Entry.", StringUtil.removeSpecialCharacters("[ \\r\\n]java.util.Map$Entry."));
    assertEquals("[\\r\\n]java.util.Map$Entry42", StringUtil.removeSpecialCharacters("[ \\r\\n]java.util.Map$Entry42"));
    assertEquals("[\\r\\n]java.util.Map$Entryjava.lang.Boolean",
        StringUtil.removeSpecialCharacters("[ \\r\\n]java.util.Map$Entryjava.lang.Boolean"));
    assertEquals("[\\r\\n]java.util.Map$Entryjava.util.Map$Entry",
        StringUtil.removeSpecialCharacters("[ \\r\\n]java.util.Map$Entryjava.util.Map$Entry"));
    assertEquals("[\\r\\n]java.util.Map$Entrynull",
        StringUtil.removeSpecialCharacters("[ \\r\\n]java.util.Map$Entrynull"));
    assertEquals("[\\r\\n]java.util.Map$Entryorg.broadleafcommerce.common.util.StringUtil",
        StringUtil.removeSpecialCharacters("[ \\r\\n]java.util.Map$Entryorg.broadleafcommerce.common.util.StringUtil"));
    assertEquals("[\\r\\n]java.util.Map$Entry{", StringUtil.removeSpecialCharacters("[ \\r\\n]java.util.Map$Entry{"));
    assertEquals("[\\r\\n]null", StringUtil.removeSpecialCharacters("[ \\r\\n]null "));
    assertEquals("[\\r\\n]null[\\r\\n]", StringUtil.removeSpecialCharacters("[ \\r\\n]null[ \\r\\n]"));
    assertEquals("[\\r\\n]nullInput", StringUtil.removeSpecialCharacters("[ \\r\\n]nullInput"));
    assertEquals("[\\r\\n]null.", StringUtil.removeSpecialCharacters("[ \\r\\n]null."));
    assertEquals("[\\r\\n]null42", StringUtil.removeSpecialCharacters("[ \\r\\n]null42"));
    assertEquals("[\\r\\n]nulljava.lang.Boolean", StringUtil.removeSpecialCharacters("[ \\r\\n]nulljava.lang.Boolean"));
    assertEquals("[\\r\\n]nulljava.util.Map$Entry",
        StringUtil.removeSpecialCharacters("[ \\r\\n]nulljava.util.Map$Entry"));
    assertEquals("[\\r\\n]nullnull", StringUtil.removeSpecialCharacters("[ \\r\\n]nullnull"));
    assertEquals("[\\r\\n]nullorg.broadleafcommerce.common.util.StringUtil",
        StringUtil.removeSpecialCharacters("[ \\r\\n]nullorg.broadleafcommerce.common.util.StringUtil"));
    assertEquals("[\\r\\n]null{", StringUtil.removeSpecialCharacters("[ \\r\\n]null{"));
    assertEquals("[\\r\\n]org.broadleafcommerce.common.util.StringUtil",
        StringUtil.removeSpecialCharacters("[ \\r\\n]org.broadleafcommerce.common.util.StringUtil "));
    assertEquals("[\\r\\n]org.broadleafcommerce.common.util.StringUtil[\\r\\n]",
        StringUtil.removeSpecialCharacters("[ \\r\\n]org.broadleafcommerce.common.util.StringUtil[ \\r\\n]"));
    assertEquals("[\\r\\n]org.broadleafcommerce.common.util.StringUtilInput",
        StringUtil.removeSpecialCharacters("[ \\r\\n]org.broadleafcommerce.common.util.StringUtilInput"));
    assertEquals("[\\r\\n]org.broadleafcommerce.common.util.StringUtil.",
        StringUtil.removeSpecialCharacters("[ \\r\\n]org.broadleafcommerce.common.util.StringUtil."));
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
    assertEquals("[\\r\\n]org.broadleafcommerce.common.util.StringUtil{",
        StringUtil.removeSpecialCharacters("[ \\r\\n]org.broadleafcommerce.common.util.StringUtil{"));
    assertEquals("[\\r\\n]{", StringUtil.removeSpecialCharacters("[ \\r\\n]{ "));
    assertEquals("[\\r\\n]{[\\r\\n]", StringUtil.removeSpecialCharacters("[ \\r\\n]{[ \\r\\n]"));
    assertEquals("[\\r\\n]{Input", StringUtil.removeSpecialCharacters("[ \\r\\n]{Input"));
    assertEquals("[\\r\\n]{.", StringUtil.removeSpecialCharacters("[ \\r\\n]{."));
    assertEquals("[\\r\\n]{42", StringUtil.removeSpecialCharacters("[ \\r\\n]{42"));
    assertEquals("[\\r\\n]{java.lang.Boolean", StringUtil.removeSpecialCharacters("[ \\r\\n]{java.lang.Boolean"));
    assertEquals("[\\r\\n]{java.util.Map$Entry", StringUtil.removeSpecialCharacters("[ \\r\\n]{java.util.Map$Entry"));
    assertEquals("[\\r\\n]{null", StringUtil.removeSpecialCharacters("[ \\r\\n]{null"));
    assertEquals("[\\r\\n]{org.broadleafcommerce.common.util.StringUtil",
        StringUtil.removeSpecialCharacters("[ \\r\\n]{org.broadleafcommerce.common.util.StringUtil"));
    assertEquals("[\\r\\n]{{", StringUtil.removeSpecialCharacters("[ \\r\\n]{{"));
  }

  /**
   * Method under test: {@link StringUtil#getMapAsJson(Map)}
   */
  @Test
  public void testGetMapAsJson() {
    // Arrange, Act and Assert
    assertEquals("{}", StringUtil.getMapAsJson(new HashMap<>()));
  }

  /**
   * Method under test: {@link StringUtil#getMapAsJson(Map)}
   */
  @Test
  public void testGetMapAsJson2() {
    // Arrange
    HashMap<String, Object> objectMap = new HashMap<>();
    objectMap.put("null", true);

    // Act and Assert
    assertEquals("{\"null\":true}", StringUtil.getMapAsJson(objectMap));
  }

  /**
   * Method under test: {@link StringUtil#getMapAsJson(Map)}
   */
  @Test
  public void testGetMapAsJson3() {
    // Arrange
    HashMap<String, Object> objectMap = new HashMap<>();
    objectMap.put("null", "null");

    // Act and Assert
    assertEquals("{\"null\":\"null\"}", StringUtil.getMapAsJson(objectMap));
  }

  /**
   * Method under test: {@link StringUtil#getMapAsJson(Map)}
   */
  @Test
  public void testGetMapAsJson4() {
    // Arrange
    HashMap<String, Object> objectMap = new HashMap<>();
    objectMap.put("null", null);

    // Act and Assert
    assertEquals("{\"null\":null}", StringUtil.getMapAsJson(objectMap));
  }

  /**
   * Method under test: {@link StringUtil#removeNonNumerics(String)}
   */
  @Test
  public void testRemoveNonNumerics() {
    // Arrange, Act and Assert
    assertEquals("42", StringUtil.removeNonNumerics("42"));
    assertEquals("", StringUtil.removeNonNumerics("U"));
    assertEquals(".", StringUtil.removeNonNumerics("[^\\d.]+"));
    assertEquals("", StringUtil.removeNonNumerics("Value"));
    assertEquals("..", StringUtil.removeNonNumerics("java.lang.Boolean"));
    assertEquals("..", StringUtil.removeNonNumerics("java.util.Map$Entry"));
    assertEquals("", StringUtil.removeNonNumerics("null"));
    assertEquals("....", StringUtil.removeNonNumerics("org.broadleafcommerce.common.util.StringUtil"));
    assertEquals("", StringUtil.removeNonNumerics("{"));
    assertEquals("42", StringUtil.removeNonNumerics("42U"));
    assertEquals("42.", StringUtil.removeNonNumerics("42[^\\d.]+"));
    assertEquals("42", StringUtil.removeNonNumerics("42Value"));
    assertEquals("42..", StringUtil.removeNonNumerics("42java.lang.Boolean"));
    assertEquals("42..", StringUtil.removeNonNumerics("42java.util.Map$Entry"));
    assertEquals("42", StringUtil.removeNonNumerics("42null"));
    assertEquals("42....", StringUtil.removeNonNumerics("42org.broadleafcommerce.common.util.StringUtil"));
    assertEquals("42", StringUtil.removeNonNumerics("42{"));
    assertEquals("42", StringUtil.removeNonNumerics("U42"));
    assertEquals("", StringUtil.removeNonNumerics("UU"));
    assertEquals(".", StringUtil.removeNonNumerics("U[^\\d.]+"));
    assertEquals("", StringUtil.removeNonNumerics("UValue"));
    assertEquals(".", StringUtil.removeNonNumerics("U."));
    assertEquals("..", StringUtil.removeNonNumerics("Ujava.lang.Boolean"));
    assertEquals("..", StringUtil.removeNonNumerics("Ujava.util.Map$Entry"));
    assertEquals("", StringUtil.removeNonNumerics("Unull"));
    assertEquals("....", StringUtil.removeNonNumerics("Uorg.broadleafcommerce.common.util.StringUtil"));
    assertEquals("", StringUtil.removeNonNumerics("U{"));
    assertEquals(".42", StringUtil.removeNonNumerics("[^\\d.]+42"));
    assertEquals(".", StringUtil.removeNonNumerics("[^\\d.]+U"));
    assertEquals("..", StringUtil.removeNonNumerics("[^\\d.]+[^\\d.]+"));
    assertEquals(".", StringUtil.removeNonNumerics("[^\\d.]+Value"));
    assertEquals("..", StringUtil.removeNonNumerics("[^\\d.]+."));
    assertEquals("...", StringUtil.removeNonNumerics("[^\\d.]+java.lang.Boolean"));
    assertEquals("...", StringUtil.removeNonNumerics("[^\\d.]+java.util.Map$Entry"));
    assertEquals(".", StringUtil.removeNonNumerics("[^\\d.]+null"));
    assertEquals(".....", StringUtil.removeNonNumerics("[^\\d.]+org.broadleafcommerce.common.util.StringUtil"));
    assertEquals(".", StringUtil.removeNonNumerics("[^\\d.]+{"));
    assertEquals("42", StringUtil.removeNonNumerics("Value42"));
    assertEquals("", StringUtil.removeNonNumerics("ValueU"));
    assertEquals(".", StringUtil.removeNonNumerics("Value[^\\d.]+"));
    assertEquals("", StringUtil.removeNonNumerics("ValueValue"));
    assertEquals(".", StringUtil.removeNonNumerics("Value."));
    assertEquals("..", StringUtil.removeNonNumerics("Valuejava.lang.Boolean"));
    assertEquals("..", StringUtil.removeNonNumerics("Valuejava.util.Map$Entry"));
    assertEquals("", StringUtil.removeNonNumerics("Valuenull"));
    assertEquals("....", StringUtil.removeNonNumerics("Valueorg.broadleafcommerce.common.util.StringUtil"));
    assertEquals("", StringUtil.removeNonNumerics("Value{"));
    assertEquals(".", StringUtil.removeNonNumerics(".U"));
    assertEquals("..", StringUtil.removeNonNumerics(".[^\\d.]+"));
    assertEquals(".", StringUtil.removeNonNumerics(".Value"));
    assertEquals("...", StringUtil.removeNonNumerics(".java.lang.Boolean"));
    assertEquals("...", StringUtil.removeNonNumerics(".java.util.Map$Entry"));
    assertEquals(".", StringUtil.removeNonNumerics(".null"));
    assertEquals(".....", StringUtil.removeNonNumerics(".org.broadleafcommerce.common.util.StringUtil"));
    assertEquals(".", StringUtil.removeNonNumerics(".{"));
    assertEquals("..42", StringUtil.removeNonNumerics("java.lang.Boolean42"));
    assertEquals("..", StringUtil.removeNonNumerics("java.lang.BooleanU"));
    assertEquals("...", StringUtil.removeNonNumerics("java.lang.Boolean[^\\d.]+"));
    assertEquals("..", StringUtil.removeNonNumerics("java.lang.BooleanValue"));
    assertEquals("...", StringUtil.removeNonNumerics("java.lang.Boolean."));
    assertEquals("....", StringUtil.removeNonNumerics("java.lang.Booleanjava.lang.Boolean"));
    assertEquals("....", StringUtil.removeNonNumerics("java.lang.Booleanjava.util.Map$Entry"));
    assertEquals("..", StringUtil.removeNonNumerics("java.lang.Booleannull"));
    assertEquals("......",
        StringUtil.removeNonNumerics("java.lang.Booleanorg.broadleafcommerce.common.util.StringUtil"));
    assertEquals("..", StringUtil.removeNonNumerics("java.lang.Boolean{"));
    assertEquals("..42", StringUtil.removeNonNumerics("java.util.Map$Entry42"));
    assertEquals("..", StringUtil.removeNonNumerics("java.util.Map$EntryU"));
    assertEquals("...", StringUtil.removeNonNumerics("java.util.Map$Entry[^\\d.]+"));
    assertEquals("..", StringUtil.removeNonNumerics("java.util.Map$EntryValue"));
    assertEquals("...", StringUtil.removeNonNumerics("java.util.Map$Entry."));
    assertEquals("....", StringUtil.removeNonNumerics("java.util.Map$Entryjava.lang.Boolean"));
    assertEquals("....", StringUtil.removeNonNumerics("java.util.Map$Entryjava.util.Map$Entry"));
    assertEquals("..", StringUtil.removeNonNumerics("java.util.Map$Entrynull"));
    assertEquals("......",
        StringUtil.removeNonNumerics("java.util.Map$Entryorg.broadleafcommerce.common.util.StringUtil"));
    assertEquals("..", StringUtil.removeNonNumerics("java.util.Map$Entry{"));
    assertEquals("42", StringUtil.removeNonNumerics("null42"));
    assertEquals("", StringUtil.removeNonNumerics("nullU"));
    assertEquals(".", StringUtil.removeNonNumerics("null[^\\d.]+"));
    assertEquals("", StringUtil.removeNonNumerics("nullValue"));
    assertEquals(".", StringUtil.removeNonNumerics("null."));
    assertEquals("..", StringUtil.removeNonNumerics("nulljava.lang.Boolean"));
    assertEquals("..", StringUtil.removeNonNumerics("nulljava.util.Map$Entry"));
    assertEquals("", StringUtil.removeNonNumerics("nullnull"));
    assertEquals("....", StringUtil.removeNonNumerics("nullorg.broadleafcommerce.common.util.StringUtil"));
    assertEquals("", StringUtil.removeNonNumerics("null{"));
    assertEquals("....42", StringUtil.removeNonNumerics("org.broadleafcommerce.common.util.StringUtil42"));
    assertEquals("....", StringUtil.removeNonNumerics("org.broadleafcommerce.common.util.StringUtilU"));
    assertEquals(".....", StringUtil.removeNonNumerics("org.broadleafcommerce.common.util.StringUtil[^\\d.]+"));
    assertEquals("....", StringUtil.removeNonNumerics("org.broadleafcommerce.common.util.StringUtilValue"));
    assertEquals(".....", StringUtil.removeNonNumerics("org.broadleafcommerce.common.util.StringUtil."));
    assertEquals("......",
        StringUtil.removeNonNumerics("org.broadleafcommerce.common.util.StringUtiljava.lang.Boolean"));
    assertEquals("......",
        StringUtil.removeNonNumerics("org.broadleafcommerce.common.util.StringUtiljava.util.Map$Entry"));
    assertEquals("....", StringUtil.removeNonNumerics("org.broadleafcommerce.common.util.StringUtilnull"));
    assertEquals("........", StringUtil
        .removeNonNumerics("org.broadleafcommerce.common.util.StringUtilorg.broadleafcommerce.common.util.StringUtil"));
    assertEquals("....", StringUtil.removeNonNumerics("org.broadleafcommerce.common.util.StringUtil{"));
    assertEquals("42", StringUtil.removeNonNumerics("{42"));
    assertEquals("", StringUtil.removeNonNumerics("{U"));
    assertEquals(".", StringUtil.removeNonNumerics("{[^\\d.]+"));
    assertEquals("", StringUtil.removeNonNumerics("{Value"));
    assertEquals(".", StringUtil.removeNonNumerics("{."));
    assertEquals("..", StringUtil.removeNonNumerics("{java.lang.Boolean"));
    assertEquals("..", StringUtil.removeNonNumerics("{java.util.Map$Entry"));
    assertEquals("", StringUtil.removeNonNumerics("{null"));
    assertEquals("....", StringUtil.removeNonNumerics("{org.broadleafcommerce.common.util.StringUtil"));
    assertEquals("", StringUtil.removeNonNumerics("{{"));
    assertEquals("4242", StringUtil.removeNonNumerics("4242U"));
    assertEquals("4242.", StringUtil.removeNonNumerics("4242[^\\d.]+"));
    assertEquals("4242", StringUtil.removeNonNumerics("4242Value"));
    assertEquals("4242..", StringUtil.removeNonNumerics("4242java.lang.Boolean"));
    assertEquals("4242..", StringUtil.removeNonNumerics("4242java.util.Map$Entry"));
    assertEquals("4242", StringUtil.removeNonNumerics("4242null"));
    assertEquals("4242....", StringUtil.removeNonNumerics("4242org.broadleafcommerce.common.util.StringUtil"));
    assertEquals("4242", StringUtil.removeNonNumerics("4242{"));
    assertEquals("4242", StringUtil.removeNonNumerics("42U42"));
    assertEquals("42", StringUtil.removeNonNumerics("42UU"));
    assertEquals("42.", StringUtil.removeNonNumerics("42U[^\\d.]+"));
    assertEquals("42", StringUtil.removeNonNumerics("42UValue"));
    assertEquals("42.", StringUtil.removeNonNumerics("42U."));
    assertEquals("42..", StringUtil.removeNonNumerics("42Ujava.lang.Boolean"));
    assertEquals("42..", StringUtil.removeNonNumerics("42Ujava.util.Map$Entry"));
    assertEquals("42", StringUtil.removeNonNumerics("42Unull"));
    assertEquals("42....", StringUtil.removeNonNumerics("42Uorg.broadleafcommerce.common.util.StringUtil"));
    assertEquals("42", StringUtil.removeNonNumerics("42U{"));
    assertEquals("42.42", StringUtil.removeNonNumerics("42[^\\d.]+42"));
    assertEquals("42.", StringUtil.removeNonNumerics("42[^\\d.]+U"));
    assertEquals("42..", StringUtil.removeNonNumerics("42[^\\d.]+[^\\d.]+"));
    assertEquals("42.", StringUtil.removeNonNumerics("42[^\\d.]+Value"));
    assertEquals("42..", StringUtil.removeNonNumerics("42[^\\d.]+."));
    assertEquals("42...", StringUtil.removeNonNumerics("42[^\\d.]+java.lang.Boolean"));
    assertEquals("42...", StringUtil.removeNonNumerics("42[^\\d.]+java.util.Map$Entry"));
    assertEquals("42.", StringUtil.removeNonNumerics("42[^\\d.]+null"));
    assertEquals("42.....", StringUtil.removeNonNumerics("42[^\\d.]+org.broadleafcommerce.common.util.StringUtil"));
    assertEquals("42.", StringUtil.removeNonNumerics("42[^\\d.]+{"));
    assertEquals("4242", StringUtil.removeNonNumerics("42Value42"));
    assertEquals("42", StringUtil.removeNonNumerics("42ValueU"));
    assertEquals("42.", StringUtil.removeNonNumerics("42Value[^\\d.]+"));
    assertEquals("42", StringUtil.removeNonNumerics("42ValueValue"));
    assertEquals("42.", StringUtil.removeNonNumerics("42Value."));
    assertEquals("42..", StringUtil.removeNonNumerics("42Valuejava.lang.Boolean"));
    assertEquals("42..", StringUtil.removeNonNumerics("42Valuejava.util.Map$Entry"));
    assertEquals("42", StringUtil.removeNonNumerics("42Valuenull"));
    assertEquals("42....", StringUtil.removeNonNumerics("42Valueorg.broadleafcommerce.common.util.StringUtil"));
    assertEquals("42", StringUtil.removeNonNumerics("42Value{"));
    assertEquals("42.", StringUtil.removeNonNumerics("42.U"));
    assertEquals("42..", StringUtil.removeNonNumerics("42.[^\\d.]+"));
    assertEquals("42.", StringUtil.removeNonNumerics("42.Value"));
    assertEquals("42...", StringUtil.removeNonNumerics("42.java.lang.Boolean"));
    assertEquals("42...", StringUtil.removeNonNumerics("42.java.util.Map$Entry"));
    assertEquals("42.", StringUtil.removeNonNumerics("42.null"));
    assertEquals("42.....", StringUtil.removeNonNumerics("42.org.broadleafcommerce.common.util.StringUtil"));
    assertEquals("42.", StringUtil.removeNonNumerics("42.{"));
    assertEquals("42..42", StringUtil.removeNonNumerics("42java.lang.Boolean42"));
    assertEquals("42..", StringUtil.removeNonNumerics("42java.lang.BooleanU"));
    assertEquals("42...", StringUtil.removeNonNumerics("42java.lang.Boolean[^\\d.]+"));
    assertEquals("42..", StringUtil.removeNonNumerics("42java.lang.BooleanValue"));
    assertEquals("42...", StringUtil.removeNonNumerics("42java.lang.Boolean."));
    assertEquals("42....", StringUtil.removeNonNumerics("42java.lang.Booleanjava.lang.Boolean"));
    assertEquals("42....", StringUtil.removeNonNumerics("42java.lang.Booleanjava.util.Map$Entry"));
    assertEquals("42..", StringUtil.removeNonNumerics("42java.lang.Booleannull"));
    assertEquals("42......",
        StringUtil.removeNonNumerics("42java.lang.Booleanorg.broadleafcommerce.common.util.StringUtil"));
    assertEquals("42..", StringUtil.removeNonNumerics("42java.lang.Boolean{"));
    assertEquals("42..42", StringUtil.removeNonNumerics("42java.util.Map$Entry42"));
    assertEquals("42..", StringUtil.removeNonNumerics("42java.util.Map$EntryU"));
    assertEquals("42...", StringUtil.removeNonNumerics("42java.util.Map$Entry[^\\d.]+"));
    assertEquals("42..", StringUtil.removeNonNumerics("42java.util.Map$EntryValue"));
    assertEquals("42...", StringUtil.removeNonNumerics("42java.util.Map$Entry."));
    assertEquals("42....", StringUtil.removeNonNumerics("42java.util.Map$Entryjava.lang.Boolean"));
    assertEquals("42....", StringUtil.removeNonNumerics("42java.util.Map$Entryjava.util.Map$Entry"));
    assertEquals("42..", StringUtil.removeNonNumerics("42java.util.Map$Entrynull"));
    assertEquals("42......",
        StringUtil.removeNonNumerics("42java.util.Map$Entryorg.broadleafcommerce.common.util.StringUtil"));
    assertEquals("42..", StringUtil.removeNonNumerics("42java.util.Map$Entry{"));
    assertEquals("4242", StringUtil.removeNonNumerics("42null42"));
    assertEquals("42", StringUtil.removeNonNumerics("42nullU"));
    assertEquals("42.", StringUtil.removeNonNumerics("42null[^\\d.]+"));
    assertEquals("42", StringUtil.removeNonNumerics("42nullValue"));
    assertEquals("42.", StringUtil.removeNonNumerics("42null."));
    assertEquals("42..", StringUtil.removeNonNumerics("42nulljava.lang.Boolean"));
    assertEquals("42..", StringUtil.removeNonNumerics("42nulljava.util.Map$Entry"));
    assertEquals("42", StringUtil.removeNonNumerics("42nullnull"));
    assertEquals("42....", StringUtil.removeNonNumerics("42nullorg.broadleafcommerce.common.util.StringUtil"));
    assertEquals("42", StringUtil.removeNonNumerics("42null{"));
    assertEquals("42....42", StringUtil.removeNonNumerics("42org.broadleafcommerce.common.util.StringUtil42"));
    assertEquals("42....", StringUtil.removeNonNumerics("42org.broadleafcommerce.common.util.StringUtilU"));
    assertEquals("42.....", StringUtil.removeNonNumerics("42org.broadleafcommerce.common.util.StringUtil[^\\d.]+"));
    assertEquals("42....", StringUtil.removeNonNumerics("42org.broadleafcommerce.common.util.StringUtilValue"));
    assertEquals("42.....", StringUtil.removeNonNumerics("42org.broadleafcommerce.common.util.StringUtil."));
    assertEquals("42......",
        StringUtil.removeNonNumerics("42org.broadleafcommerce.common.util.StringUtiljava.lang.Boolean"));
    assertEquals("42......",
        StringUtil.removeNonNumerics("42org.broadleafcommerce.common.util.StringUtiljava.util.Map$Entry"));
    assertEquals("42....", StringUtil.removeNonNumerics("42org.broadleafcommerce.common.util.StringUtilnull"));
    assertEquals("42........", StringUtil.removeNonNumerics(
        "42org.broadleafcommerce.common.util.StringUtilorg.broadleafcommerce.common.util.StringUtil"));
    assertEquals("42....", StringUtil.removeNonNumerics("42org.broadleafcommerce.common.util.StringUtil{"));
    assertEquals("4242", StringUtil.removeNonNumerics("42{42"));
    assertEquals("42", StringUtil.removeNonNumerics("42{U"));
    assertEquals("42.", StringUtil.removeNonNumerics("42{[^\\d.]+"));
    assertEquals("42", StringUtil.removeNonNumerics("42{Value"));
    assertEquals("42.", StringUtil.removeNonNumerics("42{."));
    assertEquals("42..", StringUtil.removeNonNumerics("42{java.lang.Boolean"));
    assertEquals("42..", StringUtil.removeNonNumerics("42{java.util.Map$Entry"));
    assertEquals("42", StringUtil.removeNonNumerics("42{null"));
    assertEquals("42....", StringUtil.removeNonNumerics("42{org.broadleafcommerce.common.util.StringUtil"));
    assertEquals("42", StringUtil.removeNonNumerics("42{{"));
    assertEquals("4242", StringUtil.removeNonNumerics("U4242"));
    assertEquals("42", StringUtil.removeNonNumerics("U42U"));
    assertEquals("42.", StringUtil.removeNonNumerics("U42[^\\d.]+"));
    assertEquals("42", StringUtil.removeNonNumerics("U42Value"));
    assertEquals("42.", StringUtil.removeNonNumerics("U42."));
    assertEquals("42..", StringUtil.removeNonNumerics("U42java.lang.Boolean"));
    assertEquals("42..", StringUtil.removeNonNumerics("U42java.util.Map$Entry"));
    assertEquals("42", StringUtil.removeNonNumerics("U42null"));
    assertEquals("42....", StringUtil.removeNonNumerics("U42org.broadleafcommerce.common.util.StringUtil"));
    assertEquals("42", StringUtil.removeNonNumerics("U42{"));
    assertEquals("42", StringUtil.removeNonNumerics("UU42"));
    assertEquals("", StringUtil.removeNonNumerics("UUU"));
    assertEquals(".", StringUtil.removeNonNumerics("UU[^\\d.]+"));
    assertEquals("", StringUtil.removeNonNumerics("UUValue"));
    assertEquals(".", StringUtil.removeNonNumerics("UU."));
    assertEquals("..", StringUtil.removeNonNumerics("UUjava.lang.Boolean"));
    assertEquals("..", StringUtil.removeNonNumerics("UUjava.util.Map$Entry"));
    assertEquals("", StringUtil.removeNonNumerics("UUnull"));
    assertEquals("....", StringUtil.removeNonNumerics("UUorg.broadleafcommerce.common.util.StringUtil"));
    assertEquals("", StringUtil.removeNonNumerics("UU{"));
    assertEquals(".42", StringUtil.removeNonNumerics("U[^\\d.]+42"));
    assertEquals(".", StringUtil.removeNonNumerics("U[^\\d.]+U"));
    assertEquals("..", StringUtil.removeNonNumerics("U[^\\d.]+[^\\d.]+"));
    assertEquals(".", StringUtil.removeNonNumerics("U[^\\d.]+Value"));
    assertEquals("..", StringUtil.removeNonNumerics("U[^\\d.]+."));
    assertEquals("...", StringUtil.removeNonNumerics("U[^\\d.]+java.lang.Boolean"));
    assertEquals("...", StringUtil.removeNonNumerics("U[^\\d.]+java.util.Map$Entry"));
    assertEquals(".", StringUtil.removeNonNumerics("U[^\\d.]+null"));
    assertEquals(".....", StringUtil.removeNonNumerics("U[^\\d.]+org.broadleafcommerce.common.util.StringUtil"));
    assertEquals(".", StringUtil.removeNonNumerics("U[^\\d.]+{"));
    assertEquals("42", StringUtil.removeNonNumerics("UValue42"));
    assertEquals("", StringUtil.removeNonNumerics("UValueU"));
    assertEquals(".", StringUtil.removeNonNumerics("UValue[^\\d.]+"));
    assertEquals("", StringUtil.removeNonNumerics("UValueValue"));
    assertEquals(".", StringUtil.removeNonNumerics("UValue."));
    assertEquals("..", StringUtil.removeNonNumerics("UValuejava.lang.Boolean"));
    assertEquals("..", StringUtil.removeNonNumerics("UValuejava.util.Map$Entry"));
    assertEquals("", StringUtil.removeNonNumerics("UValuenull"));
    assertEquals("....", StringUtil.removeNonNumerics("UValueorg.broadleafcommerce.common.util.StringUtil"));
    assertEquals("", StringUtil.removeNonNumerics("UValue{"));
    assertEquals(".42", StringUtil.removeNonNumerics("U.42"));
    assertEquals(".", StringUtil.removeNonNumerics("U.U"));
    assertEquals("..", StringUtil.removeNonNumerics("U.[^\\d.]+"));
    assertEquals(".", StringUtil.removeNonNumerics("U.Value"));
    assertEquals("..", StringUtil.removeNonNumerics("U.."));
    assertEquals("...", StringUtil.removeNonNumerics("U.java.lang.Boolean"));
    assertEquals("...", StringUtil.removeNonNumerics("U.java.util.Map$Entry"));
    assertEquals(".", StringUtil.removeNonNumerics("U.null"));
    assertEquals(".....", StringUtil.removeNonNumerics("U.org.broadleafcommerce.common.util.StringUtil"));
    assertEquals(".", StringUtil.removeNonNumerics("U.{"));
    assertEquals("..42", StringUtil.removeNonNumerics("Ujava.lang.Boolean42"));
    assertEquals("..", StringUtil.removeNonNumerics("Ujava.lang.BooleanU"));
    assertEquals("...", StringUtil.removeNonNumerics("Ujava.lang.Boolean[^\\d.]+"));
    assertEquals("..", StringUtil.removeNonNumerics("Ujava.lang.BooleanValue"));
    assertEquals("...", StringUtil.removeNonNumerics("Ujava.lang.Boolean."));
    assertEquals("....", StringUtil.removeNonNumerics("Ujava.lang.Booleanjava.lang.Boolean"));
    assertEquals("....", StringUtil.removeNonNumerics("Ujava.lang.Booleanjava.util.Map$Entry"));
    assertEquals("..", StringUtil.removeNonNumerics("Ujava.lang.Booleannull"));
    assertEquals("......",
        StringUtil.removeNonNumerics("Ujava.lang.Booleanorg.broadleafcommerce.common.util.StringUtil"));
    assertEquals("..", StringUtil.removeNonNumerics("Ujava.lang.Boolean{"));
    assertEquals("..42", StringUtil.removeNonNumerics("Ujava.util.Map$Entry42"));
    assertEquals("..", StringUtil.removeNonNumerics("Ujava.util.Map$EntryU"));
    assertEquals("...", StringUtil.removeNonNumerics("Ujava.util.Map$Entry[^\\d.]+"));
    assertEquals("..", StringUtil.removeNonNumerics("Ujava.util.Map$EntryValue"));
    assertEquals("...", StringUtil.removeNonNumerics("Ujava.util.Map$Entry."));
    assertEquals("....", StringUtil.removeNonNumerics("Ujava.util.Map$Entryjava.lang.Boolean"));
    assertEquals("....", StringUtil.removeNonNumerics("Ujava.util.Map$Entryjava.util.Map$Entry"));
    assertEquals("..", StringUtil.removeNonNumerics("Ujava.util.Map$Entrynull"));
    assertEquals("......",
        StringUtil.removeNonNumerics("Ujava.util.Map$Entryorg.broadleafcommerce.common.util.StringUtil"));
    assertEquals("..", StringUtil.removeNonNumerics("Ujava.util.Map$Entry{"));
    assertEquals("42", StringUtil.removeNonNumerics("Unull42"));
    assertEquals("", StringUtil.removeNonNumerics("UnullU"));
    assertEquals(".", StringUtil.removeNonNumerics("Unull[^\\d.]+"));
    assertEquals("", StringUtil.removeNonNumerics("UnullValue"));
    assertEquals(".", StringUtil.removeNonNumerics("Unull."));
    assertEquals("..", StringUtil.removeNonNumerics("Unulljava.lang.Boolean"));
    assertEquals("..", StringUtil.removeNonNumerics("Unulljava.util.Map$Entry"));
    assertEquals("", StringUtil.removeNonNumerics("Unullnull"));
    assertEquals("....", StringUtil.removeNonNumerics("Unullorg.broadleafcommerce.common.util.StringUtil"));
    assertEquals("", StringUtil.removeNonNumerics("Unull{"));
    assertEquals("....42", StringUtil.removeNonNumerics("Uorg.broadleafcommerce.common.util.StringUtil42"));
    assertEquals("....", StringUtil.removeNonNumerics("Uorg.broadleafcommerce.common.util.StringUtilU"));
    assertEquals(".....", StringUtil.removeNonNumerics("Uorg.broadleafcommerce.common.util.StringUtil[^\\d.]+"));
    assertEquals("....", StringUtil.removeNonNumerics("Uorg.broadleafcommerce.common.util.StringUtilValue"));
    assertEquals(".....", StringUtil.removeNonNumerics("Uorg.broadleafcommerce.common.util.StringUtil."));
    assertEquals("......",
        StringUtil.removeNonNumerics("Uorg.broadleafcommerce.common.util.StringUtiljava.lang.Boolean"));
    assertEquals("......",
        StringUtil.removeNonNumerics("Uorg.broadleafcommerce.common.util.StringUtiljava.util.Map$Entry"));
    assertEquals("....", StringUtil.removeNonNumerics("Uorg.broadleafcommerce.common.util.StringUtilnull"));
    assertEquals("........", StringUtil.removeNonNumerics(
        "Uorg.broadleafcommerce.common.util.StringUtilorg.broadleafcommerce.common.util.StringUtil"));
    assertEquals("....", StringUtil.removeNonNumerics("Uorg.broadleafcommerce.common.util.StringUtil{"));
    assertEquals("42", StringUtil.removeNonNumerics("U{42"));
    assertEquals("", StringUtil.removeNonNumerics("U{U"));
    assertEquals(".", StringUtil.removeNonNumerics("U{[^\\d.]+"));
    assertEquals("", StringUtil.removeNonNumerics("U{Value"));
    assertEquals(".", StringUtil.removeNonNumerics("U{."));
    assertEquals("..", StringUtil.removeNonNumerics("U{java.lang.Boolean"));
    assertEquals("..", StringUtil.removeNonNumerics("U{java.util.Map$Entry"));
    assertEquals("", StringUtil.removeNonNumerics("U{null"));
    assertEquals("....", StringUtil.removeNonNumerics("U{org.broadleafcommerce.common.util.StringUtil"));
    assertEquals("", StringUtil.removeNonNumerics("U{{"));
  }

  /**
   * Method under test: {@link StringUtil#sanitize(String)}
   */
  @Test
  public void testSanitize() {
    // Arrange, Act and Assert
    assertEquals("String", StringUtil.sanitize("String"));
    assertEquals("NULL", StringUtil.sanitize(null));
  }
}
