/*-
 * #%L
 * BroadleafCommerce Open Admin Platform
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
   * Test {@link PhraseTranslator#createExpression(String)}.
   * <ul>
   *   <li>When {@code !=CollectionUtils.intersection}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PhraseTranslator#createExpression(String)}
   */
  @Test
  public void testCreateExpression_whenCollectionUtilsIntersection() throws MVELTranslationException {
    // Arrange, Act and Assert
    assertThrows(MVELTranslationException.class,
        () -> phraseTranslator.createExpression("!=CollectionUtils.intersection"));
  }

  /**
   * Test {@link PhraseTranslator#createExpression(String)}.
   * <ul>
   *   <li>When {@code .contains}.</li>
   *   <li>Then throw {@link MVELTranslationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PhraseTranslator#createExpression(String)}
   */
  @Test
  public void testCreateExpression_whenContains_thenThrowMVELTranslationException() throws MVELTranslationException {
    // Arrange, Act and Assert
    assertThrows(MVELTranslationException.class, () -> phraseTranslator.createExpression(".contains"));
  }

  /**
   * Test {@link PhraseTranslator#createExpression(String)}.
   * <ul>
   *   <li>When {@code !=}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PhraseTranslator#createExpression(String)}
   */
  @Test
  public void testCreateExpression_whenExclamationMarkEqualsSign() throws MVELTranslationException {
    // Arrange, Act and Assert
    assertThrows(MVELTranslationException.class, () -> phraseTranslator.createExpression("!="));
  }

  /**
   * Test {@link PhraseTranslator#createExpression(String)}.
   * <ul>
   *   <li>When {@code !!=}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PhraseTranslator#createExpression(String)}
   */
  @Test
  public void testCreateExpression_whenExclamationMarkExclamationMarkEqualsSign() throws MVELTranslationException {
    // Arrange, Act and Assert
    assertThrows(MVELTranslationException.class, () -> phraseTranslator.createExpression("!!="));
  }

  /**
   * Test {@link PhraseTranslator#createExpression(String)}.
   * <ul>
   *   <li>When {@code Phrase}.</li>
   *   <li>Then throw {@link MVELTranslationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PhraseTranslator#createExpression(String)}
   */
  @Test
  public void testCreateExpression_whenPhrase_thenThrowMVELTranslationException() throws MVELTranslationException {
    // Arrange, Act and Assert
    assertThrows(MVELTranslationException.class, () -> phraseTranslator.createExpression("Phrase"));
  }

  /**
   * Test {@link PhraseTranslator#createExpression(String)}.
   * <ul>
   *   <li>When {@code .size()<}.</li>
   *   <li>Then throw {@link MVELTranslationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PhraseTranslator#createExpression(String)}
   */
  @Test
  public void testCreateExpression_whenSize_thenThrowMVELTranslationException() throws MVELTranslationException {
    // Arrange, Act and Assert
    assertThrows(MVELTranslationException.class, () -> phraseTranslator.createExpression(".size()<"));
  }

  /**
   * Test {@link PhraseTranslator#extractComponents(String)}.
   * <p>
   * Method under test: {@link PhraseTranslator#extractComponents(String)}
   */
  @Test
  public void testExtractComponents() throws MVELTranslationException {
    // Arrange, Act and Assert
    assertArrayEquals(new String[]{"", "!=", ""}, phraseTranslator.extractComponents("!="));
  }

  /**
   * Test {@link PhraseTranslator#extractComponents(String)}.
   * <ul>
   *   <li>When {@code .contains}.</li>
   *   <li>Then throw {@link MVELTranslationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PhraseTranslator#extractComponents(String)}
   */
  @Test
  public void testExtractComponents_whenContains_thenThrowMVELTranslationException() throws MVELTranslationException {
    // Arrange, Act and Assert
    assertThrows(MVELTranslationException.class, () -> phraseTranslator.extractComponents(".contains"));
  }

  /**
   * Test {@link PhraseTranslator#extractComponents(String)}.
   * <ul>
   *   <li>When {@code Phrase}.</li>
   *   <li>Then throw {@link MVELTranslationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PhraseTranslator#extractComponents(String)}
   */
  @Test
  public void testExtractComponents_whenPhrase_thenThrowMVELTranslationException() throws MVELTranslationException {
    // Arrange, Act and Assert
    assertThrows(MVELTranslationException.class, () -> phraseTranslator.extractComponents("Phrase"));
  }

  /**
   * Test {@link PhraseTranslator#convertMapAccessSyntax(String)}.
   * <ul>
   *   <li>When {@code FieldU["UU"]U}.</li>
   *   <li>Then return {@code FieldU---UUU}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PhraseTranslator#convertMapAccessSyntax(String)}
   */
  @Test
  public void testConvertMapAccessSyntax_whenFieldUUuU_thenReturnFieldUUuu() {
    // Arrange, Act and Assert
    assertEquals("FieldU---UUU", phraseTranslator.convertMapAccessSyntax("FieldU[\"UU\"]U"));
  }

  /**
   * Test {@link PhraseTranslator#convertMapAccessSyntax(String)}.
   * <ul>
   *   <li>When {@code Field}.</li>
   *   <li>Then return {@code Field}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PhraseTranslator#convertMapAccessSyntax(String)}
   */
  @Test
  public void testConvertMapAccessSyntax_whenField_thenReturnField() {
    // Arrange, Act and Assert
    assertEquals("Field", phraseTranslator.convertMapAccessSyntax("Field"));
  }

  /**
   * Test {@link PhraseTranslator#convertMapAccessSyntax(String)}.
   * <ul>
   *   <li>When {@code .*\?get\(".*?"\)\.\?getValue\(\).*U["UU"]U}.</li>
   *   <li>Then return {@code .*\?get\(".*?"\)\.\?getValue\(\).*U---UUU}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PhraseTranslator#convertMapAccessSyntax(String)}
   */
  @Test
  public void testConvertMapAccessSyntax_whenGetGetValueUUuU_thenReturnGetGetValueUUuu() {
    // Arrange, Act and Assert
    assertEquals(".*\\?get\\(\".*?\"\\)\\.\\?getValue\\(\\).*U---UUU",
        phraseTranslator.convertMapAccessSyntax(".*\\?get\\(\".*?\"\\)\\.\\?getValue\\(\\).*U[\"UU\"]U"));
  }

  /**
   * Test {@link PhraseTranslator#convertMapAccessSyntax(String)}.
   * <ul>
   *   <li>When {@code .*\?get\(".*?"\)\.\?value.*U["UU"]U}.</li>
   *   <li>Then return {@code .*\?get\(".*?"\)\.\?value.*U---UUU}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PhraseTranslator#convertMapAccessSyntax(String)}
   */
  @Test
  public void testConvertMapAccessSyntax_whenGetValueUUuU_thenReturnGetValueUUuu() {
    // Arrange, Act and Assert
    assertEquals(".*\\?get\\(\".*?\"\\)\\.\\?value.*U---UUU",
        phraseTranslator.convertMapAccessSyntax(".*\\?get\\(\".*?\"\\)\\.\\?value.*U[\"UU\"]U"));
  }

  /**
   * Test {@link PhraseTranslator#convertMapAccessSyntax(String)}.
   * <ul>
   *   <li>When {@code U?get("UU").?getValue()UU["UU"]U}.</li>
   *   <li>Then return {@code U?get("UU").?getValue()UU---UUU}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PhraseTranslator#convertMapAccessSyntax(String)}
   */
  @Test
  public void testConvertMapAccessSyntax_whenUGetUuGetValueUuUuU_thenReturnUGetUuGetValueUuUuu() {
    // Arrange, Act and Assert
    assertEquals("U?get(\"UU\").?getValue()UU---UUU",
        phraseTranslator.convertMapAccessSyntax("U?get(\"UU\").?getValue()UU[\"UU\"]U"));
  }

  /**
   * Test {@link PhraseTranslator#convertMapAccessSyntax(String)}.
   * <ul>
   *   <li>When {@code U?get("UU").?valueUU["UU"]U}.</li>
   *   <li>Then return {@code U?get("UU").?valueUU---UUU}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PhraseTranslator#convertMapAccessSyntax(String)}
   */
  @Test
  public void testConvertMapAccessSyntax_whenUGetUuValueUUUuU_thenReturnUGetUuValueUUUuu() {
    // Arrange, Act and Assert
    assertEquals("U?get(\"UU\").?valueUU---UUU",
        phraseTranslator.convertMapAccessSyntax("U?get(\"UU\").?valueUU[\"UU\"]U"));
  }

  /**
   * Test {@link PhraseTranslator#convertMapAccessSyntax(String)}.
   * <ul>
   *   <li>When {@code U["UU"]U42}.</li>
   *   <li>Then return {@code U---UUU42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PhraseTranslator#convertMapAccessSyntax(String)}
   */
  @Test
  public void testConvertMapAccessSyntax_whenUUuU42_thenReturnUUuu42() {
    // Arrange, Act and Assert
    assertEquals("U---UUU42", phraseTranslator.convertMapAccessSyntax("U[\"UU\"]U42"));
  }

  /**
   * Test {@link PhraseTranslator#convertMapAccessSyntax(String)}.
   * <ul>
   *   <li>When {@code U["UU"]U.contains}.</li>
   *   <li>Then return {@code U---UUU.contains}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PhraseTranslator#convertMapAccessSyntax(String)}
   */
  @Test
  public void testConvertMapAccessSyntax_whenUUuUContains_thenReturnUUuuContains() {
    // Arrange, Act and Assert
    assertEquals("U---UUU.contains", phraseTranslator.convertMapAccessSyntax("U[\"UU\"]U.contains"));
  }

  /**
   * Test {@link PhraseTranslator#convertMapAccessSyntax(String)}.
   * <ul>
   *   <li>When {@code U["UU"]U.endsWith}.</li>
   *   <li>Then return {@code U---UUU.endsWith}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PhraseTranslator#convertMapAccessSyntax(String)}
   */
  @Test
  public void testConvertMapAccessSyntax_whenUUuUEndsWith_thenReturnUUuuEndsWith() {
    // Arrange, Act and Assert
    assertEquals("U---UUU.endsWith", phraseTranslator.convertMapAccessSyntax("U[\"UU\"]U.endsWith"));
  }

  /**
   * Test {@link PhraseTranslator#convertMapAccessSyntax(String)}.
   * <ul>
   *   <li>When {@code U["UU"]UField}.</li>
   *   <li>Then return {@code U---UUUField}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PhraseTranslator#convertMapAccessSyntax(String)}
   */
  @Test
  public void testConvertMapAccessSyntax_whenUUuUField_thenReturnUUUUField() {
    // Arrange, Act and Assert
    assertEquals("U---UUUField", phraseTranslator.convertMapAccessSyntax("U[\"UU\"]UField"));
  }

  /**
   * Test {@link PhraseTranslator#convertMapAccessSyntax(String)}.
   * <ul>
   *   <li>When {@code U["UU"]U.*\?get\(".*?"\)\.\?getValue\(\).*}.</li>
   *   <li>Then return {@code U---UUU.*\?get\(".*?"\)\.\?getValue\(\).*}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PhraseTranslator#convertMapAccessSyntax(String)}
   */
  @Test
  public void testConvertMapAccessSyntax_whenUUuUGetGetValue_thenReturnUUuuGetGetValue() {
    // Arrange, Act and Assert
    assertEquals("U---UUU.*\\?get\\(\".*?\"\\)\\.\\?getValue\\(\\).*",
        phraseTranslator.convertMapAccessSyntax("U[\"UU\"]U.*\\?get\\(\".*?\"\\)\\.\\?getValue\\(\\).*"));
  }

  /**
   * Test {@link PhraseTranslator#convertMapAccessSyntax(String)}.
   * <ul>
   *   <li>When {@code U["UU"]U.*\?get\(".*?"\)\.\?value.*}.</li>
   *   <li>Then return {@code U---UUU.*\?get\(".*?"\)\.\?value.*}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PhraseTranslator#convertMapAccessSyntax(String)}
   */
  @Test
  public void testConvertMapAccessSyntax_whenUUuUGetValue_thenReturnUUuuGetValue() {
    // Arrange, Act and Assert
    assertEquals("U---UUU.*\\?get\\(\".*?\"\\)\\.\\?value.*",
        phraseTranslator.convertMapAccessSyntax("U[\"UU\"]U.*\\?get\\(\".*?\"\\)\\.\\?value.*"));
  }

  /**
   * Test {@link PhraseTranslator#convertMapAccessSyntax(String)}.
   * <ul>
   *   <li>When {@code U["UU"]U.intValue()}.</li>
   *   <li>Then return {@code U---UUU.intValue()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PhraseTranslator#convertMapAccessSyntax(String)}
   */
  @Test
  public void testConvertMapAccessSyntax_whenUUuUIntValue_thenReturnUUuuIntValue() {
    // Arrange, Act and Assert
    assertEquals("U---UUU.intValue()", phraseTranslator.convertMapAccessSyntax("U[\"UU\"]U.intValue()"));
  }

  /**
   * Test {@link PhraseTranslator#convertMapAccessSyntax(String)}.
   * <ul>
   *   <li>When {@code U["UU"]U.size()<}.</li>
   *   <li>Then return {@code U---UUU.size()<}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PhraseTranslator#convertMapAccessSyntax(String)}
   */
  @Test
  public void testConvertMapAccessSyntax_whenUUuUSize_thenReturnUUuuSize() {
    // Arrange, Act and Assert
    assertEquals("U---UUU.size()<", phraseTranslator.convertMapAccessSyntax("U[\"UU\"]U.size()<"));
    assertEquals("U---UUU.size()<=", phraseTranslator.convertMapAccessSyntax("U[\"UU\"]U.size()<="));
  }

  /**
   * Test {@link PhraseTranslator#convertMapAccessSyntax(String)}.
   * <ul>
   *   <li>When {@code U["UU"]U.*\[".*?"\].*}.</li>
   *   <li>Then return {@code U["UU"]U.*\---.*?".*}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PhraseTranslator#convertMapAccessSyntax(String)}
   */
  @Test
  public void testConvertMapAccessSyntax_whenUUuU_thenReturnUUuU() {
    // Arrange, Act and Assert
    assertEquals("U[\"UU\"]U.*\\---.*?\".*", phraseTranslator.convertMapAccessSyntax("U[\"UU\"]U.*\\[\".*?\"\\].*"));
  }

  /**
   * Test {@link PhraseTranslator#convertMapAccessSyntax(String)}.
   * <ul>
   *   <li>When {@code U["UU"]U}.</li>
   *   <li>Then return {@code U---UUU}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PhraseTranslator#convertMapAccessSyntax(String)}
   */
  @Test
  public void testConvertMapAccessSyntax_whenUUuU_thenReturnUUuu() {
    // Arrange, Act and Assert
    assertEquals("U---UUU", phraseTranslator.convertMapAccessSyntax("U[\"UU\"]U"));
    assertEquals("U---UUU!", phraseTranslator.convertMapAccessSyntax("U[\"UU\"]U!"));
    assertEquals("U---UUU!=", phraseTranslator.convertMapAccessSyntax("U[\"UU\"]U!="));
    assertEquals("U---UUU\"", phraseTranslator.convertMapAccessSyntax("U[\"UU\"]U\""));
    assertEquals("U---UUU\")", phraseTranslator.convertMapAccessSyntax("U[\"UU\"]U\")"));
    assertEquals("U---UUU)", phraseTranslator.convertMapAccessSyntax("U[\"UU\"]U)"));
    assertEquals("U---UUU.", phraseTranslator.convertMapAccessSyntax("U[\"UU\"]U."));
    assertEquals(".*\\[\".*?\"\\].*U---UUU", phraseTranslator.convertMapAccessSyntax(".*\\[\".*?\"\\].*U[\"UU\"]U"));
    assertEquals("!U---UUU", phraseTranslator.convertMapAccessSyntax("!U[\"UU\"]U"));
  }

  /**
   * Test {@link PhraseTranslator#convertMapAccessSyntax(String)}.
   * <ul>
   *   <li>When {@code U["UU"]UU?get("UU").?getValue()U}.</li>
   *   <li>Then return {@code U---UUUU?get("UU").?getValue()U}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PhraseTranslator#convertMapAccessSyntax(String)}
   */
  @Test
  public void testConvertMapAccessSyntax_whenUUuUuGetUuGetValueU_thenReturnUUuuuGetUuGetValueU() {
    // Arrange, Act and Assert
    assertEquals("U---UUUU?get(\"UU\").?getValue()U",
        phraseTranslator.convertMapAccessSyntax("U[\"UU\"]UU?get(\"UU\").?getValue()U"));
  }

  /**
   * Test {@link PhraseTranslator#convertMapAccessSyntax(String)}.
   * <ul>
   *   <li>When {@code U["UU"]UU?get("UU").?valueU}.</li>
   *   <li>Then return {@code U---UUUU?get("UU").?valueU}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PhraseTranslator#convertMapAccessSyntax(String)}
   */
  @Test
  public void testConvertMapAccessSyntax_whenUUuUuGetUuValueU_thenReturnUUuuuGetUuValueU() {
    // Arrange, Act and Assert
    assertEquals("U---UUUU?get(\"UU\").?valueU",
        phraseTranslator.convertMapAccessSyntax("U[\"UU\"]UU?get(\"UU\").?valueU"));
  }

  /**
   * Test {@link PhraseTranslator#convertMapAccessSyntax(String)}.
   * <ul>
   *   <li>When {@code U["UU"]UU["UU"]U}.</li>
   *   <li>Then return {@code U["UU"]UU---UUU}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PhraseTranslator#convertMapAccessSyntax(String)}
   */
  @Test
  public void testConvertMapAccessSyntax_whenUUuUuUuU_thenReturnUUuUuUuu() {
    // Arrange, Act and Assert
    assertEquals("U[\"UU\"]UU---UUU", phraseTranslator.convertMapAccessSyntax("U[\"UU\"]UU[\"UU\"]U"));
  }

  /**
   * Test {@link PhraseTranslator#extractProjection(String[])}.
   * <p>
   * Method under test: {@link PhraseTranslator#extractProjection(String[])}
   */
  @Test
  public void testExtractProjection() {
    // Arrange, Act and Assert
    assertArrayEquals(new String[]{"\"\\].*", "==", "[\".*?\"\\]"},
        (new PhraseTranslator()).extractProjection(new String[]{".*\\[\".*?\"\\].*"}));
  }

  /**
   * Test {@link PhraseTranslator#extractOldSpecialComponents(String, String)}.
   * <p>
   * Method under test:
   * {@link PhraseTranslator#extractOldSpecialComponents(String, String)}
   */
  @Test
  public void testExtractOldSpecialComponents() {
    // Arrange, Act and Assert
    assertArrayEquals(new String[]{"", "", ""}, phraseTranslator.extractOldSpecialComponents("\")", ""));
  }

  /**
   * Test {@link PhraseTranslator#extractStandardComponents(String, String)}.
   * <p>
   * Method under test:
   * {@link PhraseTranslator#extractStandardComponents(String, String)}
   */
  @Test
  public void testExtractStandardComponents() {
    // Arrange, Act and Assert
    assertArrayEquals(new String[]{"", "", "Phrase"}, phraseTranslator.extractStandardComponents("Phrase", ""));
  }

  /**
   * Test
   * {@link PhraseTranslator#getOperator(String, String, String, boolean, boolean, boolean)}.
   * <ul>
   *   <li>Then return {@code INOT_CONTAINS}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PhraseTranslator#getOperator(String, String, String, boolean, boolean, boolean)}
   */
  @Test
  public void testGetOperator_thenReturnInotContains() throws MVELTranslationException {
    // Arrange, Act and Assert
    assertEquals(BLCOperator.INOT_CONTAINS,
        phraseTranslator.getOperator("Field", "org.apache.commons.lang3.StringUtils.contains", "42", true, true, true));
  }

  /**
   * Test
   * {@link PhraseTranslator#getOperator(String, String, String, boolean, boolean, boolean)}.
   * <ul>
   *   <li>Then return {@code INOT_STARTS_WITH}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PhraseTranslator#getOperator(String, String, String, boolean, boolean, boolean)}
   */
  @Test
  public void testGetOperator_thenReturnInotStartsWith() throws MVELTranslationException {
    // Arrange, Act and Assert
    assertEquals(BLCOperator.INOT_STARTS_WITH, phraseTranslator.getOperator("Field",
        "org.apache.commons.lang3.StringUtils.startsWith", "42", true, true, true));
  }

  /**
   * Test
   * {@link PhraseTranslator#getOperator(String, String, String, boolean, boolean, boolean)}.
   * <ul>
   *   <li>Then return {@code NOT_CONTAINS}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PhraseTranslator#getOperator(String, String, String, boolean, boolean, boolean)}
   */
  @Test
  public void testGetOperator_thenReturnNotContains() throws MVELTranslationException {
    // Arrange, Act and Assert
    assertEquals(BLCOperator.NOT_CONTAINS, phraseTranslator.getOperator("Field",
        "org.apache.commons.lang3.StringUtils.contains", "42", true, true, false));
  }

  /**
   * Test
   * {@link PhraseTranslator#getOperator(String, String, String, boolean, boolean, boolean)}.
   * <ul>
   *   <li>When {@code .contains}.</li>
   *   <li>Then return {@code INOT_CONTAINS}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PhraseTranslator#getOperator(String, String, String, boolean, boolean, boolean)}
   */
  @Test
  public void testGetOperator_whenContains_thenReturnInotContains() throws MVELTranslationException {
    // Arrange, Act and Assert
    assertEquals(BLCOperator.INOT_CONTAINS, phraseTranslator.getOperator("Field", ".contains", "42", true, true, true));
  }

  /**
   * Test
   * {@link PhraseTranslator#getOperator(String, String, String, boolean, boolean, boolean)}.
   * <ul>
   *   <li>When {@code ==}.</li>
   *   <li>Then return {@code EQUALS_FIELD}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PhraseTranslator#getOperator(String, String, String, boolean, boolean, boolean)}
   */
  @Test
  public void testGetOperator_whenEqualsSignEqualsSign_thenReturnEqualsField() throws MVELTranslationException {
    // Arrange, Act and Assert
    assertEquals(BLCOperator.EQUALS_FIELD, phraseTranslator.getOperator("Field", "==", "42", true, true, true));
  }

  /**
   * Test
   * {@link PhraseTranslator#getOperator(String, String, String, boolean, boolean, boolean)}.
   * <ul>
   *   <li>When {@code ==}.</li>
   *   <li>Then return {@code IEQUALS}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PhraseTranslator#getOperator(String, String, String, boolean, boolean, boolean)}
   */
  @Test
  public void testGetOperator_whenEqualsSignEqualsSign_thenReturnIequals() throws MVELTranslationException {
    // Arrange, Act and Assert
    assertEquals(BLCOperator.IEQUALS, phraseTranslator.getOperator("Field", "==", "42", true, false, true));
  }

  /**
   * Test
   * {@link PhraseTranslator#getOperator(String, String, String, boolean, boolean, boolean)}.
   * <ul>
   *   <li>When {@code !=}.</li>
   *   <li>Then return {@code INOT_EQUAL}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PhraseTranslator#getOperator(String, String, String, boolean, boolean, boolean)}
   */
  @Test
  public void testGetOperator_whenExclamationMarkEqualsSign_thenReturnInotEqual() throws MVELTranslationException {
    // Arrange, Act and Assert
    assertEquals(BLCOperator.INOT_EQUAL, phraseTranslator.getOperator("Field", "!=", "42", true, false, true));
  }

  /**
   * Test
   * {@link PhraseTranslator#getOperator(String, String, String, boolean, boolean, boolean)}.
   * <ul>
   *   <li>When {@code !=}.</li>
   *   <li>Then return {@code NOT_EQUAL_FIELD}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PhraseTranslator#getOperator(String, String, String, boolean, boolean, boolean)}
   */
  @Test
  public void testGetOperator_whenExclamationMarkEqualsSign_thenReturnNotEqualField() throws MVELTranslationException {
    // Arrange, Act and Assert
    assertEquals(BLCOperator.NOT_EQUAL_FIELD, phraseTranslator.getOperator("Field", "!=", "42", true, true, true));
  }

  /**
   * Test
   * {@link PhraseTranslator#getOperator(String, String, String, boolean, boolean, boolean)}.
   * <ul>
   *   <li>When {@code >=}.</li>
   *   <li>Then return {@code GREATER_OR_EQUAL}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PhraseTranslator#getOperator(String, String, String, boolean, boolean, boolean)}
   */
  @Test
  public void testGetOperator_whenGreaterThanSignEqualsSign_thenReturnGreaterOrEqual() throws MVELTranslationException {
    // Arrange, Act and Assert
    assertEquals(BLCOperator.GREATER_OR_EQUAL, phraseTranslator.getOperator("Field", ">=", "42", true, false, true));
  }

  /**
   * Test
   * {@link PhraseTranslator#getOperator(String, String, String, boolean, boolean, boolean)}.
   * <ul>
   *   <li>When {@code >=}.</li>
   *   <li>Then return {@code GREATER_OR_EQUAL_FIELD}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PhraseTranslator#getOperator(String, String, String, boolean, boolean, boolean)}
   */
  @Test
  public void testGetOperator_whenGreaterThanSignEqualsSign_thenReturnGreaterOrEqualField()
      throws MVELTranslationException {
    // Arrange, Act and Assert
    assertEquals(BLCOperator.GREATER_OR_EQUAL_FIELD,
        phraseTranslator.getOperator("Field", ">=", "42", true, true, true));
  }

  /**
   * Test
   * {@link PhraseTranslator#getOperator(String, String, String, boolean, boolean, boolean)}.
   * <ul>
   *   <li>When {@code >}.</li>
   *   <li>Then return {@code GREATER_THAN}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PhraseTranslator#getOperator(String, String, String, boolean, boolean, boolean)}
   */
  @Test
  public void testGetOperator_whenGreaterThanSign_thenReturnGreaterThan() throws MVELTranslationException {
    // Arrange, Act and Assert
    assertEquals(BLCOperator.GREATER_THAN, phraseTranslator.getOperator("Field", ">", "42", true, false, true));
  }

  /**
   * Test
   * {@link PhraseTranslator#getOperator(String, String, String, boolean, boolean, boolean)}.
   * <ul>
   *   <li>When {@code >}.</li>
   *   <li>Then return {@code GREATER_THAN_FIELD}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PhraseTranslator#getOperator(String, String, String, boolean, boolean, boolean)}
   */
  @Test
  public void testGetOperator_whenGreaterThanSign_thenReturnGreaterThanField() throws MVELTranslationException {
    // Arrange, Act and Assert
    assertEquals(BLCOperator.GREATER_THAN_FIELD, phraseTranslator.getOperator("Field", ">", "42", true, true, true));
  }

  /**
   * Test
   * {@link PhraseTranslator#getOperator(String, String, String, boolean, boolean, boolean)}.
   * <ul>
   *   <li>When {@code <=}.</li>
   *   <li>Then return {@code LESS_OR_EQUAL}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PhraseTranslator#getOperator(String, String, String, boolean, boolean, boolean)}
   */
  @Test
  public void testGetOperator_whenLessThanSignEqualsSign_thenReturnLessOrEqual() throws MVELTranslationException {
    // Arrange, Act and Assert
    assertEquals(BLCOperator.LESS_OR_EQUAL, phraseTranslator.getOperator("Field", "<=", "42", true, false, true));
  }

  /**
   * Test
   * {@link PhraseTranslator#getOperator(String, String, String, boolean, boolean, boolean)}.
   * <ul>
   *   <li>When {@code <=}.</li>
   *   <li>Then return {@code LESS_OR_EQUAL_FIELD}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PhraseTranslator#getOperator(String, String, String, boolean, boolean, boolean)}
   */
  @Test
  public void testGetOperator_whenLessThanSignEqualsSign_thenReturnLessOrEqualField() throws MVELTranslationException {
    // Arrange, Act and Assert
    assertEquals(BLCOperator.LESS_OR_EQUAL_FIELD, phraseTranslator.getOperator("Field", "<=", "42", true, true, true));
  }

  /**
   * Test
   * {@link PhraseTranslator#getOperator(String, String, String, boolean, boolean, boolean)}.
   * <ul>
   *   <li>When {@code <}.</li>
   *   <li>Then return {@code LESS_THAN}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PhraseTranslator#getOperator(String, String, String, boolean, boolean, boolean)}
   */
  @Test
  public void testGetOperator_whenLessThanSign_thenReturnLessThan() throws MVELTranslationException {
    // Arrange, Act and Assert
    assertEquals(BLCOperator.LESS_THAN, phraseTranslator.getOperator("Field", "<", "42", true, false, true));
  }

  /**
   * Test
   * {@link PhraseTranslator#getOperator(String, String, String, boolean, boolean, boolean)}.
   * <ul>
   *   <li>When {@code <}.</li>
   *   <li>Then return {@code LESS_THAN_FIELD}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PhraseTranslator#getOperator(String, String, String, boolean, boolean, boolean)}
   */
  @Test
  public void testGetOperator_whenLessThanSign_thenReturnLessThanField() throws MVELTranslationException {
    // Arrange, Act and Assert
    assertEquals(BLCOperator.LESS_THAN_FIELD, phraseTranslator.getOperator("Field", "<", "42", true, true, true));
  }

  /**
   * Test
   * {@link PhraseTranslator#getOperator(String, String, String, boolean, boolean, boolean)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code IS_NULL}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PhraseTranslator#getOperator(String, String, String, boolean, boolean, boolean)}
   */
  @Test
  public void testGetOperator_whenNull_thenReturnIsNull() throws MVELTranslationException {
    // Arrange, Act and Assert
    assertEquals(BLCOperator.IS_NULL, phraseTranslator.getOperator("Field", "==", "null", true, true, true));
  }

  /**
   * Test
   * {@link PhraseTranslator#getOperator(String, String, String, boolean, boolean, boolean)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code NOT_NULL}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PhraseTranslator#getOperator(String, String, String, boolean, boolean, boolean)}
   */
  @Test
  public void testGetOperator_whenNull_thenReturnNotNull() throws MVELTranslationException {
    // Arrange, Act and Assert
    assertEquals(BLCOperator.NOT_NULL, phraseTranslator.getOperator("Field", "!=", "null", true, true, true));
  }

  /**
   * Test
   * {@link PhraseTranslator#getOperator(String, String, String, boolean, boolean, boolean)}.
   * <ul>
   *   <li>When {@code Operator}.</li>
   *   <li>Then throw {@link MVELTranslationException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PhraseTranslator#getOperator(String, String, String, boolean, boolean, boolean)}
   */
  @Test
  public void testGetOperator_whenOperator_thenThrowMVELTranslationException() throws MVELTranslationException {
    // Arrange, Act and Assert
    assertThrows(MVELTranslationException.class,
        () -> phraseTranslator.getOperator("Field", "Operator", "42", true, true, true));
    assertThrows(MVELTranslationException.class,
        () -> phraseTranslator.getOperator("Field", "Operator", "42", false, true, true));
  }

  /**
   * Test
   * {@link PhraseTranslator#getOperator(String, String, String, boolean, boolean, boolean)}.
   * <ul>
   *   <li>When {@code org.apache.commons.lang3.StringUtils.contains}.</li>
   *   <li>Then return {@code ICONTAINS}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PhraseTranslator#getOperator(String, String, String, boolean, boolean, boolean)}
   */
  @Test
  public void testGetOperator_whenOrgApacheCommonsLang3StringUtilsContains_thenReturnIcontains()
      throws MVELTranslationException {
    // Arrange, Act and Assert
    assertEquals(BLCOperator.ICONTAINS, phraseTranslator.getOperator("Field",
        "org.apache.commons.lang3.StringUtils.contains", "42", false, true, true));
  }
}
