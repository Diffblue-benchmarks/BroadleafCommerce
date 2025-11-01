/*-
 * #%L
 * BroadleafCommerce Open Admin Platform
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
package org.broadleafcommerce.openadmin.web.rulebuilder.statement;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import org.broadleafcommerce.openadmin.web.rulebuilder.BLCOperator;
import org.broadleafcommerce.openadmin.web.rulebuilder.MVELTranslationException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {PhraseTranslator.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class PhraseTranslatorDiffblueTest {
  @Autowired
  private PhraseTranslator phraseTranslator;

  /**
   * Method under test: {@link PhraseTranslator#createExpression(String)}
   */
  @Test
  public void testCreateExpression() throws MVELTranslationException {
    // Arrange, Act and Assert
    assertThrows(MVELTranslationException.class, () -> phraseTranslator.createExpression("Phrase"));
    assertThrows(MVELTranslationException.class, () -> phraseTranslator.createExpression("!="));
    assertThrows(MVELTranslationException.class, () -> phraseTranslator.createExpression(".contains"));
    assertThrows(MVELTranslationException.class, () -> phraseTranslator.createExpression(".size()<"));
    assertThrows(MVELTranslationException.class, () -> phraseTranslator.createExpression("!!="));
    assertThrows(MVELTranslationException.class,
        () -> phraseTranslator.createExpression("!=CollectionUtils.intersection"));
  }

  /**
   * Method under test: {@link PhraseTranslator#extractComponents(String)}
   */
  @Test
  public void testExtractComponents() throws MVELTranslationException {
    // Arrange, Act and Assert
    assertThrows(MVELTranslationException.class, () -> phraseTranslator.extractComponents("Phrase"));
    assertArrayEquals(new String[]{"", "!=", ""}, phraseTranslator.extractComponents("!="));
    assertThrows(MVELTranslationException.class, () -> phraseTranslator.extractComponents(".contains"));
  }

  /**
   * Method under test: {@link PhraseTranslator#convertMapAccessSyntax(String)}
   */
  @Test
  public void testConvertMapAccessSyntax() {
    // Arrange, Act and Assert
    assertEquals("Field", phraseTranslator.convertMapAccessSyntax("Field"));
    assertEquals("U---UUU", phraseTranslator.convertMapAccessSyntax("U[\"UU\"]U"));
    assertEquals("U[\"UU\"]UU---UUU", phraseTranslator.convertMapAccessSyntax("U[\"UU\"]UU[\"UU\"]U"));
    assertEquals("U---UUUU?get(\"UU\").?getValue()U",
        phraseTranslator.convertMapAccessSyntax("U[\"UU\"]UU?get(\"UU\").?getValue()U"));
    assertEquals("U---UUUU?get(\"UU\").?valueU",
        phraseTranslator.convertMapAccessSyntax("U[\"UU\"]UU?get(\"UU\").?valueU"));
    assertEquals("U[\"UU\"]U.*\\---.*?\".*", phraseTranslator.convertMapAccessSyntax("U[\"UU\"]U.*\\[\".*?\"\\].*"));
    assertEquals("U---UUU.*\\?get\\(\".*?\"\\)\\.\\?getValue\\(\\).*",
        phraseTranslator.convertMapAccessSyntax("U[\"UU\"]U.*\\?get\\(\".*?\"\\)\\.\\?getValue\\(\\).*"));
    assertEquals("U---UUU.*\\?get\\(\".*?\"\\)\\.\\?value.*",
        phraseTranslator.convertMapAccessSyntax("U[\"UU\"]U.*\\?get\\(\".*?\"\\)\\.\\?value.*"));
    assertEquals("U---UUUField", phraseTranslator.convertMapAccessSyntax("U[\"UU\"]UField"));
    assertEquals("U---UUU!", phraseTranslator.convertMapAccessSyntax("U[\"UU\"]U!"));
    assertEquals("U---UUU42", phraseTranslator.convertMapAccessSyntax("U[\"UU\"]U42"));
    assertEquals("U---UUU!=", phraseTranslator.convertMapAccessSyntax("U[\"UU\"]U!="));
    assertEquals("U---UUU\"", phraseTranslator.convertMapAccessSyntax("U[\"UU\"]U\""));
    assertEquals("U---UUU\")", phraseTranslator.convertMapAccessSyntax("U[\"UU\"]U\")"));
    assertEquals("U---UUU)", phraseTranslator.convertMapAccessSyntax("U[\"UU\"]U)"));
    assertEquals("U---UUU.", phraseTranslator.convertMapAccessSyntax("U[\"UU\"]U."));
    assertEquals("U---UUU.contains", phraseTranslator.convertMapAccessSyntax("U[\"UU\"]U.contains"));
    assertEquals("U---UUU.endsWith", phraseTranslator.convertMapAccessSyntax("U[\"UU\"]U.endsWith"));
    assertEquals("U---UUU.intValue()", phraseTranslator.convertMapAccessSyntax("U[\"UU\"]U.intValue()"));
    assertEquals("U---UUU.size()<", phraseTranslator.convertMapAccessSyntax("U[\"UU\"]U.size()<"));
    assertEquals("U---UUU.size()<=", phraseTranslator.convertMapAccessSyntax("U[\"UU\"]U.size()<="));
    assertEquals("U?get(\"UU\").?getValue()UU---UUU",
        phraseTranslator.convertMapAccessSyntax("U?get(\"UU\").?getValue()UU[\"UU\"]U"));
    assertEquals("U?get(\"UU\").?valueUU---UUU",
        phraseTranslator.convertMapAccessSyntax("U?get(\"UU\").?valueUU[\"UU\"]U"));
    assertEquals(".*\\[\".*?\"\\].*U---UUU", phraseTranslator.convertMapAccessSyntax(".*\\[\".*?\"\\].*U[\"UU\"]U"));
    assertEquals(".*\\?get\\(\".*?\"\\)\\.\\?getValue\\(\\).*U---UUU",
        phraseTranslator.convertMapAccessSyntax(".*\\?get\\(\".*?\"\\)\\.\\?getValue\\(\\).*U[\"UU\"]U"));
    assertEquals(".*\\?get\\(\".*?\"\\)\\.\\?value.*U---UUU",
        phraseTranslator.convertMapAccessSyntax(".*\\?get\\(\".*?\"\\)\\.\\?value.*U[\"UU\"]U"));
    assertEquals("FieldU---UUU", phraseTranslator.convertMapAccessSyntax("FieldU[\"UU\"]U"));
    assertEquals("!U---UUU", phraseTranslator.convertMapAccessSyntax("!U[\"UU\"]U"));
  }

  /**
   * Method under test: {@link PhraseTranslator#extractProjection(String[])}
   */
  @Test
  public void testExtractProjection() {
    // Arrange, Act and Assert
    assertArrayEquals(new String[]{"\"\\].*", "==", "[\".*?\"\\]"},
        (new PhraseTranslator()).extractProjection(new String[]{".*\\[\".*?\"\\].*"}));
  }

  /**
   * Method under test:
   * {@link PhraseTranslator#extractOldSpecialComponents(String, String)}
   */
  @Test
  public void testExtractOldSpecialComponents() {
    // Arrange, Act and Assert
    assertArrayEquals(new String[]{"", "", ""}, phraseTranslator.extractOldSpecialComponents("\")", ""));
  }

  /**
   * Method under test:
   * {@link PhraseTranslator#extractStandardComponents(String, String)}
   */
  @Test
  public void testExtractStandardComponents() {
    // Arrange, Act and Assert
    assertArrayEquals(new String[]{"", "", "Phrase"}, phraseTranslator.extractStandardComponents("Phrase", ""));
  }

  /**
   * Method under test:
   * {@link PhraseTranslator#getOperator(String, String, String, boolean, boolean, boolean)}
   */
  @Test
  public void testGetOperator() throws MVELTranslationException {
    // Arrange, Act and Assert
    assertThrows(MVELTranslationException.class,
        () -> phraseTranslator.getOperator("Field", "Operator", "42", true, true, true));
    assertEquals(BLCOperator.EQUALS_FIELD, phraseTranslator.getOperator("Field", "==", "42", true, true, true));
    assertEquals(BLCOperator.NOT_EQUAL_FIELD, phraseTranslator.getOperator("Field", "!=", "42", true, true, true));
    assertEquals(BLCOperator.GREATER_THAN_FIELD, phraseTranslator.getOperator("Field", ">", "42", true, true, true));
    assertEquals(BLCOperator.LESS_THAN_FIELD, phraseTranslator.getOperator("Field", "<", "42", true, true, true));
    assertEquals(BLCOperator.GREATER_OR_EQUAL_FIELD,
        phraseTranslator.getOperator("Field", ">=", "42", true, true, true));
    assertEquals(BLCOperator.LESS_OR_EQUAL_FIELD, phraseTranslator.getOperator("Field", "<=", "42", true, true, true));
    assertEquals(BLCOperator.INOT_CONTAINS,
        phraseTranslator.getOperator("Field", "org.apache.commons.lang3.StringUtils.contains", "42", true, true, true));
    assertEquals(BLCOperator.INOT_CONTAINS, phraseTranslator.getOperator("Field", ".contains", "42", true, true, true));
    assertThrows(MVELTranslationException.class,
        () -> phraseTranslator.getOperator("Field", "Operator", "42", false, true, true));
    assertEquals(BLCOperator.INOT_STARTS_WITH, phraseTranslator.getOperator("Field",
        "org.apache.commons.lang3.StringUtils.startsWith", "42", true, true, true));
    assertEquals(BLCOperator.IS_NULL, phraseTranslator.getOperator("Field", "==", "null", true, true, true));
    assertEquals(BLCOperator.IEQUALS, phraseTranslator.getOperator("Field", "==", "42", true, false, true));
    assertEquals(BLCOperator.NOT_NULL, phraseTranslator.getOperator("Field", "!=", "null", true, true, true));
    assertEquals(BLCOperator.INOT_EQUAL, phraseTranslator.getOperator("Field", "!=", "42", true, false, true));
    assertEquals(BLCOperator.GREATER_THAN, phraseTranslator.getOperator("Field", ">", "42", true, false, true));
    assertEquals(BLCOperator.LESS_THAN, phraseTranslator.getOperator("Field", "<", "42", true, false, true));
    assertEquals(BLCOperator.GREATER_OR_EQUAL, phraseTranslator.getOperator("Field", ">=", "42", true, false, true));
    assertEquals(BLCOperator.LESS_OR_EQUAL, phraseTranslator.getOperator("Field", "<=", "42", true, false, true));
    assertEquals(BLCOperator.ICONTAINS, phraseTranslator.getOperator("Field",
        "org.apache.commons.lang3.StringUtils.contains", "42", false, true, true));
    assertEquals(BLCOperator.NOT_CONTAINS, phraseTranslator.getOperator("Field",
        "org.apache.commons.lang3.StringUtils.contains", "42", true, true, false));
  }
}
