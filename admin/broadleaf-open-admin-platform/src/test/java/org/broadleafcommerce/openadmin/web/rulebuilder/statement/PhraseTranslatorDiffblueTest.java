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
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.openadmin.web.rulebuilder.BLCOperator;
import org.broadleafcommerce.openadmin.web.rulebuilder.MVELTranslationException;
import org.junit.Test;
import org.junit.experimental.categories.Category;
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "org.broadleafcommerce.openadmin.web.rulebuilder.statement.Expression PhraseTranslator.createExpression(String)"})
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "org.broadleafcommerce.openadmin.web.rulebuilder.statement.Expression PhraseTranslator.createExpression(String)"})
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "org.broadleafcommerce.openadmin.web.rulebuilder.statement.Expression PhraseTranslator.createExpression(String)"})
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "org.broadleafcommerce.openadmin.web.rulebuilder.statement.Expression PhraseTranslator.createExpression(String)"})
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "org.broadleafcommerce.openadmin.web.rulebuilder.statement.Expression PhraseTranslator.createExpression(String)"})
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "org.broadleafcommerce.openadmin.web.rulebuilder.statement.Expression PhraseTranslator.createExpression(String)"})
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String[] PhraseTranslator.extractComponents(String)"})
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String[] PhraseTranslator.extractComponents(String)"})
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String[] PhraseTranslator.extractComponents(String)"})
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String PhraseTranslator.convertMapAccessSyntax(String)"})
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String PhraseTranslator.convertMapAccessSyntax(String)"})
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String PhraseTranslator.convertMapAccessSyntax(String)"})
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String PhraseTranslator.convertMapAccessSyntax(String)"})
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String PhraseTranslator.convertMapAccessSyntax(String)"})
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String PhraseTranslator.convertMapAccessSyntax(String)"})
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String PhraseTranslator.convertMapAccessSyntax(String)"})
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String PhraseTranslator.convertMapAccessSyntax(String)"})
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String PhraseTranslator.convertMapAccessSyntax(String)"})
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String PhraseTranslator.convertMapAccessSyntax(String)"})
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String PhraseTranslator.convertMapAccessSyntax(String)"})
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String PhraseTranslator.convertMapAccessSyntax(String)"})
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String PhraseTranslator.convertMapAccessSyntax(String)"})
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String PhraseTranslator.convertMapAccessSyntax(String)"})
  public void testConvertMapAccessSyntax_whenUUuUSize_thenReturnUUuuSize() {
    // Arrange, Act and Assert
    assertEquals("U---UUU.size()<", phraseTranslator.convertMapAccessSyntax("U[\"UU\"]U.size()<"));
  }

  /**
   * Test {@link PhraseTranslator#convertMapAccessSyntax(String)}.
   * <ul>
   *   <li>When {@code U["UU"]U.size()<=}.</li>
   *   <li>Then return {@code U---UUU.size()<=}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PhraseTranslator#convertMapAccessSyntax(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String PhraseTranslator.convertMapAccessSyntax(String)"})
  public void testConvertMapAccessSyntax_whenUUuUSize_thenReturnUUuuSize2() {
    // Arrange, Act and Assert
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String PhraseTranslator.convertMapAccessSyntax(String)"})
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String PhraseTranslator.convertMapAccessSyntax(String)"})
  public void testConvertMapAccessSyntax_whenUUuU_thenReturnUUuu() {
    // Arrange, Act and Assert
    assertEquals("U---UUU", phraseTranslator.convertMapAccessSyntax("U[\"UU\"]U"));
  }

  /**
   * Test {@link PhraseTranslator#convertMapAccessSyntax(String)}.
   * <ul>
   *   <li>When {@code U["UU"]U!}.</li>
   *   <li>Then return {@code U---UUU!}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PhraseTranslator#convertMapAccessSyntax(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String PhraseTranslator.convertMapAccessSyntax(String)"})
  public void testConvertMapAccessSyntax_whenUUuU_thenReturnUUuu2() {
    // Arrange, Act and Assert
    assertEquals("U---UUU!", phraseTranslator.convertMapAccessSyntax("U[\"UU\"]U!"));
  }

  /**
   * Test {@link PhraseTranslator#convertMapAccessSyntax(String)}.
   * <ul>
   *   <li>When {@code U["UU"]U!=}.</li>
   *   <li>Then return {@code U---UUU!=}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PhraseTranslator#convertMapAccessSyntax(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String PhraseTranslator.convertMapAccessSyntax(String)"})
  public void testConvertMapAccessSyntax_whenUUuU_thenReturnUUuu3() {
    // Arrange, Act and Assert
    assertEquals("U---UUU!=", phraseTranslator.convertMapAccessSyntax("U[\"UU\"]U!="));
  }

  /**
   * Test {@link PhraseTranslator#convertMapAccessSyntax(String)}.
   * <ul>
   *   <li>When {@code U["UU"]U"}.</li>
   *   <li>Then return {@code U---UUU"}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PhraseTranslator#convertMapAccessSyntax(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String PhraseTranslator.convertMapAccessSyntax(String)"})
  public void testConvertMapAccessSyntax_whenUUuU_thenReturnUUuu4() {
    // Arrange, Act and Assert
    assertEquals("U---UUU\"", phraseTranslator.convertMapAccessSyntax("U[\"UU\"]U\""));
  }

  /**
   * Test {@link PhraseTranslator#convertMapAccessSyntax(String)}.
   * <ul>
   *   <li>When {@code U["UU"]U")}.</li>
   *   <li>Then return {@code U---UUU")}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PhraseTranslator#convertMapAccessSyntax(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String PhraseTranslator.convertMapAccessSyntax(String)"})
  public void testConvertMapAccessSyntax_whenUUuU_thenReturnUUuu5() {
    // Arrange, Act and Assert
    assertEquals("U---UUU\")", phraseTranslator.convertMapAccessSyntax("U[\"UU\"]U\")"));
  }

  /**
   * Test {@link PhraseTranslator#convertMapAccessSyntax(String)}.
   * <ul>
   *   <li>When {@code U["UU"]U)}.</li>
   *   <li>Then return {@code U---UUU)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PhraseTranslator#convertMapAccessSyntax(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String PhraseTranslator.convertMapAccessSyntax(String)"})
  public void testConvertMapAccessSyntax_whenUUuU_thenReturnUUuu6() {
    // Arrange, Act and Assert
    assertEquals("U---UUU)", phraseTranslator.convertMapAccessSyntax("U[\"UU\"]U)"));
  }

  /**
   * Test {@link PhraseTranslator#convertMapAccessSyntax(String)}.
   * <ul>
   *   <li>When {@code U["UU"]U.}.</li>
   *   <li>Then return {@code U---UUU.}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PhraseTranslator#convertMapAccessSyntax(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String PhraseTranslator.convertMapAccessSyntax(String)"})
  public void testConvertMapAccessSyntax_whenUUuU_thenReturnUUuu7() {
    // Arrange, Act and Assert
    assertEquals("U---UUU.", phraseTranslator.convertMapAccessSyntax("U[\"UU\"]U."));
  }

  /**
   * Test {@link PhraseTranslator#convertMapAccessSyntax(String)}.
   * <ul>
   *   <li>When {@code .*\[".*?"\].*U["UU"]U}.</li>
   *   <li>Then return {@code .*\[".*?"\].*U---UUU}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PhraseTranslator#convertMapAccessSyntax(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String PhraseTranslator.convertMapAccessSyntax(String)"})
  public void testConvertMapAccessSyntax_whenUUuU_thenReturnUUuu8() {
    // Arrange, Act and Assert
    assertEquals(".*\\[\".*?\"\\].*U---UUU", phraseTranslator.convertMapAccessSyntax(".*\\[\".*?\"\\].*U[\"UU\"]U"));
  }

  /**
   * Test {@link PhraseTranslator#convertMapAccessSyntax(String)}.
   * <ul>
   *   <li>When {@code !U["UU"]U}.</li>
   *   <li>Then return {@code !U---UUU}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PhraseTranslator#convertMapAccessSyntax(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String PhraseTranslator.convertMapAccessSyntax(String)"})
  public void testConvertMapAccessSyntax_whenUUuU_thenReturnUUuu9() {
    // Arrange, Act and Assert
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String PhraseTranslator.convertMapAccessSyntax(String)"})
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String PhraseTranslator.convertMapAccessSyntax(String)"})
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String PhraseTranslator.convertMapAccessSyntax(String)"})
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String[] PhraseTranslator.extractProjection(String[])"})
  public void testExtractProjection() {
    // Arrange, Act and Assert
    assertArrayEquals(new String[]{"\"\\].*", "==", "[\".*?\"\\]"},
        (new PhraseTranslator()).extractProjection(new String[]{".*\\[\".*?\"\\].*"}));
  }

  /**
   * Test {@link PhraseTranslator#extractOldSpecialComponents(String, String)}.
   * <p>
   * Method under test: {@link PhraseTranslator#extractOldSpecialComponents(String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String[] PhraseTranslator.extractOldSpecialComponents(String, String)"})
  public void testExtractOldSpecialComponents() {
    // Arrange, Act and Assert
    assertArrayEquals(new String[]{"", "", ""}, phraseTranslator.extractOldSpecialComponents("\")", ""));
  }

  /**
   * Test {@link PhraseTranslator#extractStandardComponents(String, String)}.
   * <p>
   * Method under test: {@link PhraseTranslator#extractStandardComponents(String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String[] PhraseTranslator.extractStandardComponents(String, String)"})
  public void testExtractStandardComponents() {
    // Arrange, Act and Assert
    assertArrayEquals(new String[]{"", "", "Phrase"}, phraseTranslator.extractStandardComponents("Phrase", ""));
  }

  /**
   * Test {@link PhraseTranslator#getOperator(String, String, String, boolean, boolean, boolean)}.
   * <ul>
   *   <li>Then return {@code INOT_CONTAINS}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PhraseTranslator#getOperator(String, String, String, boolean, boolean, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"BLCOperator PhraseTranslator.getOperator(String, String, String, boolean, boolean, boolean)"})
  public void testGetOperator_thenReturnInotContains() throws MVELTranslationException {
    // Arrange, Act and Assert
    assertEquals(BLCOperator.INOT_CONTAINS,
        phraseTranslator.getOperator("Field", "org.apache.commons.lang3.StringUtils.contains", "42", true, true, true));
  }

  /**
   * Test {@link PhraseTranslator#getOperator(String, String, String, boolean, boolean, boolean)}.
   * <ul>
   *   <li>Then return {@code INOT_STARTS_WITH}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PhraseTranslator#getOperator(String, String, String, boolean, boolean, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"BLCOperator PhraseTranslator.getOperator(String, String, String, boolean, boolean, boolean)"})
  public void testGetOperator_thenReturnInotStartsWith() throws MVELTranslationException {
    // Arrange, Act and Assert
    assertEquals(BLCOperator.INOT_STARTS_WITH, phraseTranslator.getOperator("Field",
        "org.apache.commons.lang3.StringUtils.startsWith", "42", true, true, true));
  }

  /**
   * Test {@link PhraseTranslator#getOperator(String, String, String, boolean, boolean, boolean)}.
   * <ul>
   *   <li>Then return {@code STARTS_WITH}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PhraseTranslator#getOperator(String, String, String, boolean, boolean, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"BLCOperator PhraseTranslator.getOperator(String, String, String, boolean, boolean, boolean)"})
  public void testGetOperator_thenReturnStartsWith() throws MVELTranslationException {
    // Arrange, Act and Assert
    assertEquals(BLCOperator.STARTS_WITH, phraseTranslator.getOperator("Field",
        "org.apache.commons.lang3.StringUtils.startsWith", "null", false, false, false));
  }

  /**
   * Test {@link PhraseTranslator#getOperator(String, String, String, boolean, boolean, boolean)}.
   * <ul>
   *   <li>When {@code .contains}.</li>
   *   <li>Then return {@code CONTAINS}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PhraseTranslator#getOperator(String, String, String, boolean, boolean, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"BLCOperator PhraseTranslator.getOperator(String, String, String, boolean, boolean, boolean)"})
  public void testGetOperator_whenContains_thenReturnContains() throws MVELTranslationException {
    // Arrange, Act and Assert
    assertEquals(BLCOperator.CONTAINS, phraseTranslator.getOperator("Field", ".contains", "null", false, false, false));
  }

  /**
   * Test {@link PhraseTranslator#getOperator(String, String, String, boolean, boolean, boolean)}.
   * <ul>
   *   <li>When {@code .endsWith}.</li>
   *   <li>Then return {@code ENDS_WITH}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PhraseTranslator#getOperator(String, String, String, boolean, boolean, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"BLCOperator PhraseTranslator.getOperator(String, String, String, boolean, boolean, boolean)"})
  public void testGetOperator_whenEndsWith_thenReturnEndsWith() throws MVELTranslationException {
    // Arrange, Act and Assert
    assertEquals(BLCOperator.ENDS_WITH,
        phraseTranslator.getOperator("Field", ".endsWith", "null", false, false, false));
  }

  /**
   * Test {@link PhraseTranslator#getOperator(String, String, String, boolean, boolean, boolean)}.
   * <ul>
   *   <li>When {@code ==}.</li>
   *   <li>Then return {@code EQUALS_FIELD}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PhraseTranslator#getOperator(String, String, String, boolean, boolean, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"BLCOperator PhraseTranslator.getOperator(String, String, String, boolean, boolean, boolean)"})
  public void testGetOperator_whenEqualsSignEqualsSign_thenReturnEqualsField() throws MVELTranslationException {
    // Arrange, Act and Assert
    assertEquals(BLCOperator.EQUALS_FIELD, phraseTranslator.getOperator("Field", "==", "42", true, true, true));
  }

  /**
   * Test {@link PhraseTranslator#getOperator(String, String, String, boolean, boolean, boolean)}.
   * <ul>
   *   <li>When {@code ==}.</li>
   *   <li>Then return {@code IEQUALS}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PhraseTranslator#getOperator(String, String, String, boolean, boolean, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"BLCOperator PhraseTranslator.getOperator(String, String, String, boolean, boolean, boolean)"})
  public void testGetOperator_whenEqualsSignEqualsSign_thenReturnIequals() throws MVELTranslationException {
    // Arrange, Act and Assert
    assertEquals(BLCOperator.IEQUALS, phraseTranslator.getOperator("Field", "==", "42", true, false, true));
  }

  /**
   * Test {@link PhraseTranslator#getOperator(String, String, String, boolean, boolean, boolean)}.
   * <ul>
   *   <li>When {@code ==}.</li>
   *   <li>Then return {@code IS_NULL}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PhraseTranslator#getOperator(String, String, String, boolean, boolean, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"BLCOperator PhraseTranslator.getOperator(String, String, String, boolean, boolean, boolean)"})
  public void testGetOperator_whenEqualsSignEqualsSign_thenReturnIsNull() throws MVELTranslationException {
    // Arrange, Act and Assert
    assertEquals(BLCOperator.IS_NULL, phraseTranslator.getOperator("Field", "==", "null", false, false, false));
  }

  /**
   * Test {@link PhraseTranslator#getOperator(String, String, String, boolean, boolean, boolean)}.
   * <ul>
   *   <li>When {@code !=}.</li>
   *   <li>Then return {@code INOT_EQUAL}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PhraseTranslator#getOperator(String, String, String, boolean, boolean, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"BLCOperator PhraseTranslator.getOperator(String, String, String, boolean, boolean, boolean)"})
  public void testGetOperator_whenExclamationMarkEqualsSign_thenReturnInotEqual() throws MVELTranslationException {
    // Arrange, Act and Assert
    assertEquals(BLCOperator.INOT_EQUAL, phraseTranslator.getOperator("Field", "!=", "42", true, false, true));
  }

  /**
   * Test {@link PhraseTranslator#getOperator(String, String, String, boolean, boolean, boolean)}.
   * <ul>
   *   <li>When {@code !=}.</li>
   *   <li>Then return {@code NOT_EQUAL_FIELD}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PhraseTranslator#getOperator(String, String, String, boolean, boolean, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"BLCOperator PhraseTranslator.getOperator(String, String, String, boolean, boolean, boolean)"})
  public void testGetOperator_whenExclamationMarkEqualsSign_thenReturnNotEqualField() throws MVELTranslationException {
    // Arrange, Act and Assert
    assertEquals(BLCOperator.NOT_EQUAL_FIELD, phraseTranslator.getOperator("Field", "!=", "42", true, true, true));
  }

  /**
   * Test {@link PhraseTranslator#getOperator(String, String, String, boolean, boolean, boolean)}.
   * <ul>
   *   <li>When {@code !=}.</li>
   *   <li>Then return {@code NOT_NULL}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PhraseTranslator#getOperator(String, String, String, boolean, boolean, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"BLCOperator PhraseTranslator.getOperator(String, String, String, boolean, boolean, boolean)"})
  public void testGetOperator_whenExclamationMarkEqualsSign_thenReturnNotNull() throws MVELTranslationException {
    // Arrange, Act and Assert
    assertEquals(BLCOperator.NOT_NULL, phraseTranslator.getOperator("Field", "!=", "null", false, false, false));
  }

  /**
   * Test {@link PhraseTranslator#getOperator(String, String, String, boolean, boolean, boolean)}.
   * <ul>
   *   <li>When {@code >=}.</li>
   *   <li>Then return {@code GREATER_OR_EQUAL}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PhraseTranslator#getOperator(String, String, String, boolean, boolean, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"BLCOperator PhraseTranslator.getOperator(String, String, String, boolean, boolean, boolean)"})
  public void testGetOperator_whenGreaterThanSignEqualsSign_thenReturnGreaterOrEqual() throws MVELTranslationException {
    // Arrange, Act and Assert
    assertEquals(BLCOperator.GREATER_OR_EQUAL,
        phraseTranslator.getOperator("Field", ">=", "null", false, false, false));
  }

  /**
   * Test {@link PhraseTranslator#getOperator(String, String, String, boolean, boolean, boolean)}.
   * <ul>
   *   <li>When {@code >=}.</li>
   *   <li>Then return {@code GREATER_OR_EQUAL_FIELD}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PhraseTranslator#getOperator(String, String, String, boolean, boolean, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"BLCOperator PhraseTranslator.getOperator(String, String, String, boolean, boolean, boolean)"})
  public void testGetOperator_whenGreaterThanSignEqualsSign_thenReturnGreaterOrEqualField()
      throws MVELTranslationException {
    // Arrange, Act and Assert
    assertEquals(BLCOperator.GREATER_OR_EQUAL_FIELD,
        phraseTranslator.getOperator("Field", ">=", "42", true, true, true));
  }

  /**
   * Test {@link PhraseTranslator#getOperator(String, String, String, boolean, boolean, boolean)}.
   * <ul>
   *   <li>When {@code >}.</li>
   *   <li>Then return {@code GREATER_THAN}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PhraseTranslator#getOperator(String, String, String, boolean, boolean, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"BLCOperator PhraseTranslator.getOperator(String, String, String, boolean, boolean, boolean)"})
  public void testGetOperator_whenGreaterThanSign_thenReturnGreaterThan() throws MVELTranslationException {
    // Arrange, Act and Assert
    assertEquals(BLCOperator.GREATER_THAN, phraseTranslator.getOperator("Field", ">", "null", false, false, false));
  }

  /**
   * Test {@link PhraseTranslator#getOperator(String, String, String, boolean, boolean, boolean)}.
   * <ul>
   *   <li>When {@code >}.</li>
   *   <li>Then return {@code GREATER_THAN_FIELD}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PhraseTranslator#getOperator(String, String, String, boolean, boolean, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"BLCOperator PhraseTranslator.getOperator(String, String, String, boolean, boolean, boolean)"})
  public void testGetOperator_whenGreaterThanSign_thenReturnGreaterThanField() throws MVELTranslationException {
    // Arrange, Act and Assert
    assertEquals(BLCOperator.GREATER_THAN_FIELD, phraseTranslator.getOperator("Field", ">", "42", true, true, true));
  }

  /**
   * Test {@link PhraseTranslator#getOperator(String, String, String, boolean, boolean, boolean)}.
   * <ul>
   *   <li>When {@code <=}.</li>
   *   <li>Then return {@code LESS_OR_EQUAL}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PhraseTranslator#getOperator(String, String, String, boolean, boolean, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"BLCOperator PhraseTranslator.getOperator(String, String, String, boolean, boolean, boolean)"})
  public void testGetOperator_whenLessThanSignEqualsSign_thenReturnLessOrEqual() throws MVELTranslationException {
    // Arrange, Act and Assert
    assertEquals(BLCOperator.LESS_OR_EQUAL, phraseTranslator.getOperator("Field", "<=", "null", false, false, false));
  }

  /**
   * Test {@link PhraseTranslator#getOperator(String, String, String, boolean, boolean, boolean)}.
   * <ul>
   *   <li>When {@code <=}.</li>
   *   <li>Then return {@code LESS_OR_EQUAL_FIELD}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PhraseTranslator#getOperator(String, String, String, boolean, boolean, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"BLCOperator PhraseTranslator.getOperator(String, String, String, boolean, boolean, boolean)"})
  public void testGetOperator_whenLessThanSignEqualsSign_thenReturnLessOrEqualField() throws MVELTranslationException {
    // Arrange, Act and Assert
    assertEquals(BLCOperator.LESS_OR_EQUAL_FIELD, phraseTranslator.getOperator("Field", "<=", "42", true, true, true));
  }

  /**
   * Test {@link PhraseTranslator#getOperator(String, String, String, boolean, boolean, boolean)}.
   * <ul>
   *   <li>When {@code <}.</li>
   *   <li>Then return {@code LESS_THAN}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PhraseTranslator#getOperator(String, String, String, boolean, boolean, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"BLCOperator PhraseTranslator.getOperator(String, String, String, boolean, boolean, boolean)"})
  public void testGetOperator_whenLessThanSign_thenReturnLessThan() throws MVELTranslationException {
    // Arrange, Act and Assert
    assertEquals(BLCOperator.LESS_THAN, phraseTranslator.getOperator("Field", "<", "null", false, false, false));
  }

  /**
   * Test {@link PhraseTranslator#getOperator(String, String, String, boolean, boolean, boolean)}.
   * <ul>
   *   <li>When {@code <}.</li>
   *   <li>Then return {@code LESS_THAN_FIELD}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PhraseTranslator#getOperator(String, String, String, boolean, boolean, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"BLCOperator PhraseTranslator.getOperator(String, String, String, boolean, boolean, boolean)"})
  public void testGetOperator_whenLessThanSign_thenReturnLessThanField() throws MVELTranslationException {
    // Arrange, Act and Assert
    assertEquals(BLCOperator.LESS_THAN_FIELD, phraseTranslator.getOperator("Field", "<", "42", true, true, true));
  }

  /**
   * Test {@link PhraseTranslator#getOperator(String, String, String, boolean, boolean, boolean)}.
   * <ul>
   *   <li>When {@code Operator}.</li>
   *   <li>Then throw {@link MVELTranslationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PhraseTranslator#getOperator(String, String, String, boolean, boolean, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"BLCOperator PhraseTranslator.getOperator(String, String, String, boolean, boolean, boolean)"})
  public void testGetOperator_whenOperator_thenThrowMVELTranslationException() throws MVELTranslationException {
    // Arrange, Act and Assert
    assertThrows(MVELTranslationException.class,
        () -> phraseTranslator.getOperator("Field", "Operator", "42", true, true, true));
  }

  /**
   * Test {@link PhraseTranslator#getOperator(String, String, String, boolean, boolean, boolean)}.
   * <ul>
   *   <li>When {@code Operator}.</li>
   *   <li>Then throw {@link MVELTranslationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PhraseTranslator#getOperator(String, String, String, boolean, boolean, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"BLCOperator PhraseTranslator.getOperator(String, String, String, boolean, boolean, boolean)"})
  public void testGetOperator_whenOperator_thenThrowMVELTranslationException2() throws MVELTranslationException {
    // Arrange, Act and Assert
    assertThrows(MVELTranslationException.class,
        () -> phraseTranslator.getOperator("Field", "Operator", "42", false, true, true));
  }

  /**
   * Test {@link PhraseTranslator#getOperator(String, String, String, boolean, boolean, boolean)}.
   * <ul>
   *   <li>When {@code org.apache.commons.lang3.StringUtils.contains}.</li>
   *   <li>Then return {@code CONTAINS}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PhraseTranslator#getOperator(String, String, String, boolean, boolean, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"BLCOperator PhraseTranslator.getOperator(String, String, String, boolean, boolean, boolean)"})
  public void testGetOperator_whenOrgApacheCommonsLang3StringUtilsContains_thenReturnContains()
      throws MVELTranslationException {
    // Arrange, Act and Assert
    assertEquals(BLCOperator.CONTAINS, phraseTranslator.getOperator("Field",
        "org.apache.commons.lang3.StringUtils.contains", "null", false, false, false));
  }

  /**
   * Test {@link PhraseTranslator#getOperator(String, String, String, boolean, boolean, boolean)}.
   * <ul>
   *   <li>When {@code org.apache.commons.lang3.StringUtils.endsWith}.</li>
   *   <li>Then return {@code ENDS_WITH}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PhraseTranslator#getOperator(String, String, String, boolean, boolean, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"BLCOperator PhraseTranslator.getOperator(String, String, String, boolean, boolean, boolean)"})
  public void testGetOperator_whenOrgApacheCommonsLang3StringUtilsEndsWith_thenReturnEndsWith()
      throws MVELTranslationException {
    // Arrange, Act and Assert
    assertEquals(BLCOperator.ENDS_WITH, phraseTranslator.getOperator("Field",
        "org.apache.commons.lang3.StringUtils.endsWith", "null", false, false, false));
  }

  /**
   * Test {@link PhraseTranslator#getOperator(String, String, String, boolean, boolean, boolean)}.
   * <ul>
   *   <li>When {@code .size()>0}.</li>
   *   <li>Then return {@code COLLECTION_IN}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PhraseTranslator#getOperator(String, String, String, boolean, boolean, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"BLCOperator PhraseTranslator.getOperator(String, String, String, boolean, boolean, boolean)"})
  public void testGetOperator_whenSize0_thenReturnCollectionIn() throws MVELTranslationException {
    // Arrange, Act and Assert
    assertEquals(BLCOperator.COLLECTION_IN,
        phraseTranslator.getOperator("Field", ".size()>0", "null", false, false, false));
  }

  /**
   * Test {@link PhraseTranslator#getOperator(String, String, String, boolean, boolean, boolean)}.
   * <ul>
   *   <li>When {@code .size()==0}.</li>
   *   <li>Then return {@code COLLECTION_NOT_IN}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PhraseTranslator#getOperator(String, String, String, boolean, boolean, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"BLCOperator PhraseTranslator.getOperator(String, String, String, boolean, boolean, boolean)"})
  public void testGetOperator_whenSize0_thenReturnCollectionNotIn() throws MVELTranslationException {
    // Arrange, Act and Assert
    assertEquals(BLCOperator.COLLECTION_NOT_IN,
        phraseTranslator.getOperator("Field", ".size()==0", "null", false, false, false));
  }

  /**
   * Test {@link PhraseTranslator#getOperator(String, String, String, boolean, boolean, boolean)}.
   * <ul>
   *   <li>When {@code .size()==}.</li>
   *   <li>Then return {@code COUNT_EQUALS}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PhraseTranslator#getOperator(String, String, String, boolean, boolean, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"BLCOperator PhraseTranslator.getOperator(String, String, String, boolean, boolean, boolean)"})
  public void testGetOperator_whenSize_thenReturnCountEquals() throws MVELTranslationException {
    // Arrange, Act and Assert
    assertEquals(BLCOperator.COUNT_EQUALS,
        phraseTranslator.getOperator("Field", ".size()==", "null", false, false, false));
  }

  /**
   * Test {@link PhraseTranslator#getOperator(String, String, String, boolean, boolean, boolean)}.
   * <ul>
   *   <li>When {@code .size()>=}.</li>
   *   <li>Then return {@code COUNT_GREATER_OR_EQUAL}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PhraseTranslator#getOperator(String, String, String, boolean, boolean, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"BLCOperator PhraseTranslator.getOperator(String, String, String, boolean, boolean, boolean)"})
  public void testGetOperator_whenSize_thenReturnCountGreaterOrEqual() throws MVELTranslationException {
    // Arrange, Act and Assert
    assertEquals(BLCOperator.COUNT_GREATER_OR_EQUAL,
        phraseTranslator.getOperator("Field", ".size()>=", "null", false, false, false));
  }

  /**
   * Test {@link PhraseTranslator#getOperator(String, String, String, boolean, boolean, boolean)}.
   * <ul>
   *   <li>When {@code .size()>}.</li>
   *   <li>Then return {@code COUNT_GREATER_THAN}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PhraseTranslator#getOperator(String, String, String, boolean, boolean, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"BLCOperator PhraseTranslator.getOperator(String, String, String, boolean, boolean, boolean)"})
  public void testGetOperator_whenSize_thenReturnCountGreaterThan() throws MVELTranslationException {
    // Arrange, Act and Assert
    assertEquals(BLCOperator.COUNT_GREATER_THAN,
        phraseTranslator.getOperator("Field", ".size()>", "null", false, false, false));
  }

  /**
   * Test {@link PhraseTranslator#getOperator(String, String, String, boolean, boolean, boolean)}.
   * <ul>
   *   <li>When {@code .size()<=}.</li>
   *   <li>Then return {@code COUNT_LESS_OR_EQUAL}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PhraseTranslator#getOperator(String, String, String, boolean, boolean, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"BLCOperator PhraseTranslator.getOperator(String, String, String, boolean, boolean, boolean)"})
  public void testGetOperator_whenSize_thenReturnCountLessOrEqual() throws MVELTranslationException {
    // Arrange, Act and Assert
    assertEquals(BLCOperator.COUNT_LESS_OR_EQUAL,
        phraseTranslator.getOperator("Field", ".size()<=", "null", false, false, false));
  }

  /**
   * Test {@link PhraseTranslator#getOperator(String, String, String, boolean, boolean, boolean)}.
   * <ul>
   *   <li>When {@code .size()<}.</li>
   *   <li>Then return {@code COUNT_LESS_THAN}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PhraseTranslator#getOperator(String, String, String, boolean, boolean, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"BLCOperator PhraseTranslator.getOperator(String, String, String, boolean, boolean, boolean)"})
  public void testGetOperator_whenSize_thenReturnCountLessThan() throws MVELTranslationException {
    // Arrange, Act and Assert
    assertEquals(BLCOperator.COUNT_LESS_THAN,
        phraseTranslator.getOperator("Field", ".size()<", "null", false, false, false));
  }

  /**
   * Test {@link PhraseTranslator#getOperator(String, String, String, boolean, boolean, boolean)}.
   * <ul>
   *   <li>When {@code .startsWith}.</li>
   *   <li>Then return {@code STARTS_WITH}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PhraseTranslator#getOperator(String, String, String, boolean, boolean, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"BLCOperator PhraseTranslator.getOperator(String, String, String, boolean, boolean, boolean)"})
  public void testGetOperator_whenStartsWith_thenReturnStartsWith() throws MVELTranslationException {
    // Arrange, Act and Assert
    assertEquals(BLCOperator.STARTS_WITH,
        phraseTranslator.getOperator("Field", ".startsWith", "null", false, false, false));
  }
}
