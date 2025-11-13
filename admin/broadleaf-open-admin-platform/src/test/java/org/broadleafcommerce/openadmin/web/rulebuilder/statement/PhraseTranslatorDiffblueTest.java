package org.broadleafcommerce.openadmin.web.rulebuilder.statement;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
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
  @Autowired private PhraseTranslator phraseTranslator;

  /**
   * Test {@link PhraseTranslator#createExpression(String)}.
   *
   * <ul>
   *   <li>Given {@link PhraseTranslator} (default constructor).
   *   <li>When {@code .contains")}.
   * </ul>
   *
   * <p>Method under test: {@link PhraseTranslator#createExpression(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Expression PhraseTranslator.createExpression(String)"})
  public void testCreateExpression_givenPhraseTranslator_whenContains()
      throws MVELTranslationException {
    // Arrange, Act and Assert
    assertThrows(
        MVELTranslationException.class,
        () -> new PhraseTranslator().createExpression(".contains\")"));
  }

  /**
   * Test {@link PhraseTranslator#createExpression(String)}.
   *
   * <ul>
   *   <li>Then return Operator is {@code NOT_EQUAL}.
   * </ul>
   *
   * <p>Method under test: {@link PhraseTranslator#createExpression(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Expression PhraseTranslator.createExpression(String)"})
  public void testCreateExpression_thenReturnOperatorIsNotEqual() throws MVELTranslationException {
    // Arrange and Act
    Expression actualCreateExpressionResult = new PhraseTranslator().createExpression(".!=");

    // Assert
    assertEquals("", actualCreateExpressionResult.getEntityKey());
    assertEquals("", actualCreateExpressionResult.getField());
    assertEquals("", actualCreateExpressionResult.getValue());
    assertEquals(BLCOperator.NOT_EQUAL, actualCreateExpressionResult.getOperator());
  }

  /**
   * Test {@link PhraseTranslator#createExpression(String)}.
   *
   * <ul>
   *   <li>When {@code !=CollectionUtils.intersection}.
   * </ul>
   *
   * <p>Method under test: {@link PhraseTranslator#createExpression(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Expression PhraseTranslator.createExpression(String)"})
  public void testCreateExpression_whenCollectionUtilsIntersection()
      throws MVELTranslationException {
    // Arrange, Act and Assert
    assertThrows(
        MVELTranslationException.class,
        () -> phraseTranslator.createExpression("!=CollectionUtils.intersection"));
  }

  /**
   * Test {@link PhraseTranslator#createExpression(String)}.
   *
   * <ul>
   *   <li>When {@code .contains}.
   *   <li>Then throw {@link MVELTranslationException}.
   * </ul>
   *
   * <p>Method under test: {@link PhraseTranslator#createExpression(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Expression PhraseTranslator.createExpression(String)"})
  public void testCreateExpression_whenContains_thenThrowMVELTranslationException()
      throws MVELTranslationException {
    // Arrange, Act and Assert
    assertThrows(
        MVELTranslationException.class, () -> phraseTranslator.createExpression(".contains"));
  }

  /**
   * Test {@link PhraseTranslator#createExpression(String)}.
   *
   * <ul>
   *   <li>When {@code !=}.
   * </ul>
   *
   * <p>Method under test: {@link PhraseTranslator#createExpression(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Expression PhraseTranslator.createExpression(String)"})
  public void testCreateExpression_whenExclamationMarkEqualsSign() throws MVELTranslationException {
    // Arrange, Act and Assert
    assertThrows(MVELTranslationException.class, () -> phraseTranslator.createExpression("!="));
  }

  /**
   * Test {@link PhraseTranslator#createExpression(String)}.
   *
   * <ul>
   *   <li>When {@code !!=}.
   * </ul>
   *
   * <p>Method under test: {@link PhraseTranslator#createExpression(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Expression PhraseTranslator.createExpression(String)"})
  public void testCreateExpression_whenExclamationMarkExclamationMarkEqualsSign()
      throws MVELTranslationException {
    // Arrange, Act and Assert
    assertThrows(MVELTranslationException.class, () -> phraseTranslator.createExpression("!!="));
  }

  /**
   * Test {@link PhraseTranslator#createExpression(String)}.
   *
   * <ul>
   *   <li>When {@code Phrase}.
   *   <li>Then throw {@link MVELTranslationException}.
   * </ul>
   *
   * <p>Method under test: {@link PhraseTranslator#createExpression(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Expression PhraseTranslator.createExpression(String)"})
  public void testCreateExpression_whenPhrase_thenThrowMVELTranslationException()
      throws MVELTranslationException {
    // Arrange, Act and Assert
    assertThrows(MVELTranslationException.class, () -> phraseTranslator.createExpression("Phrase"));
  }

  /**
   * Test {@link PhraseTranslator#createExpression(String)}.
   *
   * <ul>
   *   <li>When {@code ..size()<}.
   *   <li>Then return Operator is {@code COUNT_LESS_THAN}.
   * </ul>
   *
   * <p>Method under test: {@link PhraseTranslator#createExpression(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Expression PhraseTranslator.createExpression(String)"})
  public void testCreateExpression_whenSize_thenReturnOperatorIsCountLessThan()
      throws MVELTranslationException {
    // Arrange and Act
    Expression actualCreateExpressionResult = new PhraseTranslator().createExpression("..size()<");

    // Assert
    assertEquals("", actualCreateExpressionResult.getEntityKey());
    assertEquals("", actualCreateExpressionResult.getField());
    assertEquals("", actualCreateExpressionResult.getValue());
    assertEquals(BLCOperator.COUNT_LESS_THAN, actualCreateExpressionResult.getOperator());
  }

  /**
   * Test {@link PhraseTranslator#createExpression(String)}.
   *
   * <ul>
   *   <li>When {@code .size()<}.
   *   <li>Then throw {@link MVELTranslationException}.
   * </ul>
   *
   * <p>Method under test: {@link PhraseTranslator#createExpression(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Expression PhraseTranslator.createExpression(String)"})
  public void testCreateExpression_whenSize_thenThrowMVELTranslationException()
      throws MVELTranslationException {
    // Arrange, Act and Assert
    assertThrows(
        MVELTranslationException.class, () -> phraseTranslator.createExpression(".size()<"));
  }

  /**
   * Test {@link PhraseTranslator#extractComponents(String)}.
   *
   * <p>Method under test: {@link PhraseTranslator#extractComponents(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String[] PhraseTranslator.extractComponents(String)"})
  public void testExtractComponents() throws MVELTranslationException {
    // Arrange, Act and Assert
    assertArrayEquals(new String[] {"", "!=", ""}, phraseTranslator.extractComponents("!="));
  }

  /**
   * Test {@link PhraseTranslator#extractComponents(String)}.
   *
   * <ul>
   *   <li>When {@code .contains}.
   *   <li>Then throw {@link MVELTranslationException}.
   * </ul>
   *
   * <p>Method under test: {@link PhraseTranslator#extractComponents(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String[] PhraseTranslator.extractComponents(String)"})
  public void testExtractComponents_whenContains_thenThrowMVELTranslationException()
      throws MVELTranslationException {
    // Arrange, Act and Assert
    assertThrows(
        MVELTranslationException.class, () -> phraseTranslator.extractComponents(".contains"));
  }

  /**
   * Test {@link PhraseTranslator#extractComponents(String)}.
   *
   * <ul>
   *   <li>When {@code Phrase}.
   *   <li>Then throw {@link MVELTranslationException}.
   * </ul>
   *
   * <p>Method under test: {@link PhraseTranslator#extractComponents(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String[] PhraseTranslator.extractComponents(String)"})
  public void testExtractComponents_whenPhrase_thenThrowMVELTranslationException()
      throws MVELTranslationException {
    // Arrange, Act and Assert
    assertThrows(
        MVELTranslationException.class, () -> phraseTranslator.extractComponents("Phrase"));
  }

  /**
   * Test {@link PhraseTranslator#convertMapAccessSyntax(String)}.
   *
   * <ul>
   *   <li>Given {@link PhraseTranslator} (default constructor).
   *   <li>When {@code 42xx["xx"]xx}.
   *   <li>Then return {@code 42xx---xxxx}.
   * </ul>
   *
   * <p>Method under test: {@link PhraseTranslator#convertMapAccessSyntax(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String PhraseTranslator.convertMapAccessSyntax(String)"})
  public void testConvertMapAccessSyntax_givenPhraseTranslator_when42xxXxXx_thenReturn42xxXxxx() {
    // Arrange, Act and Assert
    assertEquals("42xx---xxxx", new PhraseTranslator().convertMapAccessSyntax("42xx[\"xx\"]xx"));
  }

  /**
   * Test {@link PhraseTranslator#convertMapAccessSyntax(String)}.
   *
   * <ul>
   *   <li>Given {@link PhraseTranslator}.
   *   <li>When {@code Field}.
   *   <li>Then return {@code Field}.
   * </ul>
   *
   * <p>Method under test: {@link PhraseTranslator#convertMapAccessSyntax(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String PhraseTranslator.convertMapAccessSyntax(String)"})
  public void testConvertMapAccessSyntax_givenPhraseTranslator_whenField_thenReturnField() {
    // Arrange, Act and Assert
    assertEquals("Field", phraseTranslator.convertMapAccessSyntax("Field"));
  }

  /**
   * Test {@link PhraseTranslator#convertMapAccessSyntax(String)}.
   *
   * <ul>
   *   <li>Given {@link PhraseTranslator}.
   *   <li>When {@code xx["xx"]xx42}.
   *   <li>Then return {@code xx---xxxx42}.
   * </ul>
   *
   * <p>Method under test: {@link PhraseTranslator#convertMapAccessSyntax(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String PhraseTranslator.convertMapAccessSyntax(String)"})
  public void testConvertMapAccessSyntax_givenPhraseTranslator_whenXxXxXx42_thenReturnXxXxxx42() {
    // Arrange, Act and Assert
    assertEquals("xx---xxxx42", phraseTranslator.convertMapAccessSyntax("xx[\"xx\"]xx42"));
  }

  /**
   * Test {@link PhraseTranslator#convertMapAccessSyntax(String)}.
   *
   * <ul>
   *   <li>Given {@link PhraseTranslator}.
   *   <li>When {@code xx["xx"]xx]}.
   *   <li>Then return {@code xx---xx"]x}.
   * </ul>
   *
   * <p>Method under test: {@link PhraseTranslator#convertMapAccessSyntax(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String PhraseTranslator.convertMapAccessSyntax(String)"})
  public void testConvertMapAccessSyntax_givenPhraseTranslator_whenXxXxXx_thenReturnXxXxX() {
    // Arrange, Act and Assert
    assertEquals("xx---xx\"]x", phraseTranslator.convertMapAccessSyntax("xx[\"xx\"]xx]"));
  }

  /**
   * Test {@link PhraseTranslator#convertMapAccessSyntax(String)}.
   *
   * <ul>
   *   <li>Given {@link PhraseTranslator}.
   *   <li>When {@code xx["xx"]xx.*\[".*?"\].*}.
   *   <li>Then return {@code xx["xx"]xx.*\---.*?".*}.
   * </ul>
   *
   * <p>Method under test: {@link PhraseTranslator#convertMapAccessSyntax(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String PhraseTranslator.convertMapAccessSyntax(String)"})
  public void testConvertMapAccessSyntax_givenPhraseTranslator_whenXxXxXx_thenReturnXxXxXx() {
    // Arrange, Act and Assert
    assertEquals(
        "xx[\"xx\"]xx.*\\---.*?\".*",
        phraseTranslator.convertMapAccessSyntax("xx[\"xx\"]xx.*\\[\".*?\"\\].*"));
  }

  /**
   * Test {@link PhraseTranslator#convertMapAccessSyntax(String)}.
   *
   * <ul>
   *   <li>Given {@link PhraseTranslator}.
   *   <li>When {@code xx["xx"]xx}.
   *   <li>Then return {@code xx---xxxx}.
   * </ul>
   *
   * <p>Method under test: {@link PhraseTranslator#convertMapAccessSyntax(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String PhraseTranslator.convertMapAccessSyntax(String)"})
  public void testConvertMapAccessSyntax_givenPhraseTranslator_whenXxXxXx_thenReturnXxXxxx() {
    // Arrange, Act and Assert
    assertEquals("xx---xxxx", phraseTranslator.convertMapAccessSyntax("xx[\"xx\"]xx"));
  }

  /**
   * Test {@link PhraseTranslator#convertMapAccessSyntax(String)}.
   *
   * <ul>
   *   <li>Given {@link PhraseTranslator}.
   *   <li>When {@code xx["xx"]xx!}.
   *   <li>Then return {@code xx---xxxx!}.
   * </ul>
   *
   * <p>Method under test: {@link PhraseTranslator#convertMapAccessSyntax(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String PhraseTranslator.convertMapAccessSyntax(String)"})
  public void testConvertMapAccessSyntax_givenPhraseTranslator_whenXxXxXx_thenReturnXxXxxx2() {
    // Arrange, Act and Assert
    assertEquals("xx---xxxx!", phraseTranslator.convertMapAccessSyntax("xx[\"xx\"]xx!"));
  }

  /**
   * Test {@link PhraseTranslator#convertMapAccessSyntax(String)}.
   *
   * <ul>
   *   <li>Given {@link PhraseTranslator}.
   *   <li>When {@code xx["xx"]xx!=}.
   *   <li>Then return {@code xx---xxxx!=}.
   * </ul>
   *
   * <p>Method under test: {@link PhraseTranslator#convertMapAccessSyntax(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String PhraseTranslator.convertMapAccessSyntax(String)"})
  public void testConvertMapAccessSyntax_givenPhraseTranslator_whenXxXxXx_thenReturnXxXxxx3() {
    // Arrange, Act and Assert
    assertEquals("xx---xxxx!=", phraseTranslator.convertMapAccessSyntax("xx[\"xx\"]xx!="));
  }

  /**
   * Test {@link PhraseTranslator#convertMapAccessSyntax(String)}.
   *
   * <ul>
   *   <li>Given {@link PhraseTranslator}.
   *   <li>When {@code xx["xx"]xx"}.
   *   <li>Then return {@code xx---xxxx"}.
   * </ul>
   *
   * <p>Method under test: {@link PhraseTranslator#convertMapAccessSyntax(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String PhraseTranslator.convertMapAccessSyntax(String)"})
  public void testConvertMapAccessSyntax_givenPhraseTranslator_whenXxXxXx_thenReturnXxXxxx4() {
    // Arrange, Act and Assert
    assertEquals("xx---xxxx\"", phraseTranslator.convertMapAccessSyntax("xx[\"xx\"]xx\""));
  }

  /**
   * Test {@link PhraseTranslator#convertMapAccessSyntax(String)}.
   *
   * <ul>
   *   <li>Given {@link PhraseTranslator}.
   *   <li>When {@code xx["xx"]xx")}.
   *   <li>Then return {@code xx---xxxx")}.
   * </ul>
   *
   * <p>Method under test: {@link PhraseTranslator#convertMapAccessSyntax(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String PhraseTranslator.convertMapAccessSyntax(String)"})
  public void testConvertMapAccessSyntax_givenPhraseTranslator_whenXxXxXx_thenReturnXxXxxx5() {
    // Arrange, Act and Assert
    assertEquals("xx---xxxx\")", phraseTranslator.convertMapAccessSyntax("xx[\"xx\"]xx\")"));
  }

  /**
   * Test {@link PhraseTranslator#convertMapAccessSyntax(String)}.
   *
   * <ul>
   *   <li>Given {@link PhraseTranslator}.
   *   <li>When {@code xx["xx"]xx)}.
   *   <li>Then return {@code xx---xxxx)}.
   * </ul>
   *
   * <p>Method under test: {@link PhraseTranslator#convertMapAccessSyntax(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String PhraseTranslator.convertMapAccessSyntax(String)"})
  public void testConvertMapAccessSyntax_givenPhraseTranslator_whenXxXxXx_thenReturnXxXxxx6() {
    // Arrange, Act and Assert
    assertEquals("xx---xxxx)", phraseTranslator.convertMapAccessSyntax("xx[\"xx\"]xx)"));
  }

  /**
   * Test {@link PhraseTranslator#convertMapAccessSyntax(String)}.
   *
   * <ul>
   *   <li>Given {@link PhraseTranslator}.
   *   <li>When {@code xx["xx"]xx.}.
   *   <li>Then return {@code xx---xxxx.}.
   * </ul>
   *
   * <p>Method under test: {@link PhraseTranslator#convertMapAccessSyntax(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String PhraseTranslator.convertMapAccessSyntax(String)"})
  public void testConvertMapAccessSyntax_givenPhraseTranslator_whenXxXxXx_thenReturnXxXxxx7() {
    // Arrange, Act and Assert
    assertEquals("xx---xxxx.", phraseTranslator.convertMapAccessSyntax("xx[\"xx\"]xx."));
  }

  /**
   * Test {@link PhraseTranslator#convertMapAccessSyntax(String)}.
   *
   * <ul>
   *   <li>Given {@link PhraseTranslator}.
   *   <li>When {@code .*\[".*?"\].*xx["xx"]xx}.
   *   <li>Then return {@code .*\[".*?"\].*xx---xxxx}.
   * </ul>
   *
   * <p>Method under test: {@link PhraseTranslator#convertMapAccessSyntax(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String PhraseTranslator.convertMapAccessSyntax(String)"})
  public void testConvertMapAccessSyntax_givenPhraseTranslator_whenXxXxXx_thenReturnXxXxxx8() {
    // Arrange, Act and Assert
    assertEquals(
        ".*\\[\".*?\"\\].*xx---xxxx",
        phraseTranslator.convertMapAccessSyntax(".*\\[\".*?\"\\].*xx[\"xx\"]xx"));
  }

  /**
   * Test {@link PhraseTranslator#convertMapAccessSyntax(String)}.
   *
   * <ul>
   *   <li>Given {@link PhraseTranslator} (default constructor).
   *   <li>When {@code !xx["xx"]xx}.
   *   <li>Then return {@code !xx---xxxx}.
   * </ul>
   *
   * <p>Method under test: {@link PhraseTranslator#convertMapAccessSyntax(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String PhraseTranslator.convertMapAccessSyntax(String)"})
  public void testConvertMapAccessSyntax_givenPhraseTranslator_whenXxXxXx_thenReturnXxXxxx9() {
    // Arrange, Act and Assert
    assertEquals("!xx---xxxx", new PhraseTranslator().convertMapAccessSyntax("!xx[\"xx\"]xx"));
  }

  /**
   * Test {@link PhraseTranslator#convertMapAccessSyntax(String)}.
   *
   * <ul>
   *   <li>Given {@link PhraseTranslator} (default constructor).
   *   <li>When {@code !=xx["xx"]xx}.
   *   <li>Then return {@code !=xx---xxxx}.
   * </ul>
   *
   * <p>Method under test: {@link PhraseTranslator#convertMapAccessSyntax(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String PhraseTranslator.convertMapAccessSyntax(String)"})
  public void testConvertMapAccessSyntax_givenPhraseTranslator_whenXxXxXx_thenReturnXxXxxx10() {
    // Arrange, Act and Assert
    assertEquals("!=xx---xxxx", new PhraseTranslator().convertMapAccessSyntax("!=xx[\"xx\"]xx"));
  }

  /**
   * Test {@link PhraseTranslator#convertMapAccessSyntax(String)}.
   *
   * <ul>
   *   <li>Given {@link PhraseTranslator} (default constructor).
   *   <li>When {@code [xx["xx"]xx}.
   *   <li>Then return {@code [xx---xxxx}.
   * </ul>
   *
   * <p>Method under test: {@link PhraseTranslator#convertMapAccessSyntax(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String PhraseTranslator.convertMapAccessSyntax(String)"})
  public void testConvertMapAccessSyntax_givenPhraseTranslator_whenXxXxXx_thenReturnXxXxxx11() {
    // Arrange, Act and Assert
    assertEquals("[xx---xxxx", new PhraseTranslator().convertMapAccessSyntax("[xx[\"xx\"]xx"));
  }

  /**
   * Test {@link PhraseTranslator#convertMapAccessSyntax(String)}.
   *
   * <ul>
   *   <li>Given {@link PhraseTranslator} (default constructor).
   *   <li>When {@code ]xx["xx"]xx}.
   *   <li>Then return {@code ]xx---xxxx}.
   * </ul>
   *
   * <p>Method under test: {@link PhraseTranslator#convertMapAccessSyntax(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String PhraseTranslator.convertMapAccessSyntax(String)"})
  public void testConvertMapAccessSyntax_givenPhraseTranslator_whenXxXxXx_thenReturnXxXxxx12() {
    // Arrange, Act and Assert
    assertEquals("]xx---xxxx", new PhraseTranslator().convertMapAccessSyntax("]xx[\"xx\"]xx"));
  }

  /**
   * Test {@link PhraseTranslator#convertMapAccessSyntax(String)}.
   *
   * <ul>
   *   <li>Given {@link PhraseTranslator} (default constructor).
   *   <li>When {@code "xx["xx"]xx}.
   *   <li>Then return {@code "xx---xxxx}.
   * </ul>
   *
   * <p>Method under test: {@link PhraseTranslator#convertMapAccessSyntax(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String PhraseTranslator.convertMapAccessSyntax(String)"})
  public void testConvertMapAccessSyntax_givenPhraseTranslator_whenXxXxXx_thenReturnXxXxxx13() {
    // Arrange, Act and Assert
    assertEquals("\"xx---xxxx", new PhraseTranslator().convertMapAccessSyntax("\"xx[\"xx\"]xx"));
  }

  /**
   * Test {@link PhraseTranslator#convertMapAccessSyntax(String)}.
   *
   * <ul>
   *   <li>Then return {@code xx?get("xx").?getValue()xxxx---xxxx}.
   * </ul>
   *
   * <p>Method under test: {@link PhraseTranslator#convertMapAccessSyntax(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String PhraseTranslator.convertMapAccessSyntax(String)"})
  public void testConvertMapAccessSyntax_thenReturnXxGetXxGetValueXxxxXxxx() {
    // Arrange, Act and Assert
    assertEquals(
        "xx?get(\"xx\").?getValue()xxxx---xxxx",
        phraseTranslator.convertMapAccessSyntax("xx?get(\"xx\").?getValue()xxxx[\"xx\"]xx"));
  }

  /**
   * Test {@link PhraseTranslator#convertMapAccessSyntax(String)}.
   *
   * <ul>
   *   <li>Then return {@code xx?get("xx").?valuexxxx---xxxx}.
   * </ul>
   *
   * <p>Method under test: {@link PhraseTranslator#convertMapAccessSyntax(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String PhraseTranslator.convertMapAccessSyntax(String)"})
  public void testConvertMapAccessSyntax_thenReturnXxGetXxValuexxxxXxxx() {
    // Arrange, Act and Assert
    assertEquals(
        "xx?get(\"xx\").?valuexxxx---xxxx",
        phraseTranslator.convertMapAccessSyntax("xx?get(\"xx\").?valuexxxx[\"xx\"]xx"));
  }

  /**
   * Test {@link PhraseTranslator#convertMapAccessSyntax(String)}.
   *
   * <ul>
   *   <li>Then return {@code xx---xxxxxx?get("xx").?getValue()xx}.
   * </ul>
   *
   * <p>Method under test: {@link PhraseTranslator#convertMapAccessSyntax(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String PhraseTranslator.convertMapAccessSyntax(String)"})
  public void testConvertMapAccessSyntax_thenReturnXxXxxxxxGetXxGetValueXx() {
    // Arrange, Act and Assert
    assertEquals(
        "xx---xxxxxx?get(\"xx\").?getValue()xx",
        phraseTranslator.convertMapAccessSyntax("xx[\"xx\"]xxxx?get(\"xx\").?getValue()xx"));
  }

  /**
   * Test {@link PhraseTranslator#convertMapAccessSyntax(String)}.
   *
   * <ul>
   *   <li>Then return {@code xx---xxxxxx?get("xx").?valuexx}.
   * </ul>
   *
   * <p>Method under test: {@link PhraseTranslator#convertMapAccessSyntax(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String PhraseTranslator.convertMapAccessSyntax(String)"})
  public void testConvertMapAccessSyntax_thenReturnXxXxxxxxGetXxValuexx() {
    // Arrange, Act and Assert
    assertEquals(
        "xx---xxxxxx?get(\"xx\").?valuexx",
        phraseTranslator.convertMapAccessSyntax("xx[\"xx\"]xxxx?get(\"xx\").?valuexx"));
  }

  /**
   * Test {@link PhraseTranslator#convertMapAccessSyntax(String)}.
   *
   * <ul>
   *   <li>When {@code Fieldxx["xx"]xx}.
   *   <li>Then return {@code Fieldxx---xxxx}.
   * </ul>
   *
   * <p>Method under test: {@link PhraseTranslator#convertMapAccessSyntax(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String PhraseTranslator.convertMapAccessSyntax(String)"})
  public void testConvertMapAccessSyntax_whenFieldxxXxXx_thenReturnFieldxxXxxx() {
    // Arrange, Act and Assert
    assertEquals(
        "Fieldxx---xxxx", new PhraseTranslator().convertMapAccessSyntax("Fieldxx[\"xx\"]xx"));
  }

  /**
   * Test {@link PhraseTranslator#convertMapAccessSyntax(String)}.
   *
   * <ul>
   *   <li>When {@code .*\?get\(".*?"\)\.\?getValue\(\).*xx["xx"]xx}.
   *   <li>Then return {@code .*\?get\(".*?"\)\.\?getValue\(\).*xx---xxxx}.
   * </ul>
   *
   * <p>Method under test: {@link PhraseTranslator#convertMapAccessSyntax(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String PhraseTranslator.convertMapAccessSyntax(String)"})
  public void testConvertMapAccessSyntax_whenGetGetValueXxXxXx_thenReturnGetGetValueXxXxxx() {
    // Arrange, Act and Assert
    assertEquals(
        ".*\\?get\\(\".*?\"\\)\\.\\?getValue\\(\\).*xx---xxxx",
        phraseTranslator.convertMapAccessSyntax(
            ".*\\?get\\(\".*?\"\\)\\.\\?getValue\\(\\).*xx[\"xx\"]xx"));
  }

  /**
   * Test {@link PhraseTranslator#convertMapAccessSyntax(String)}.
   *
   * <ul>
   *   <li>When {@code .*\?get\(".*?"\)\.\?value.*xx["xx"]xx}.
   *   <li>Then return {@code .*\?get\(".*?"\)\.\?value.*xx---xxxx}.
   * </ul>
   *
   * <p>Method under test: {@link PhraseTranslator#convertMapAccessSyntax(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String PhraseTranslator.convertMapAccessSyntax(String)"})
  public void testConvertMapAccessSyntax_whenGetValueXxXxXx_thenReturnGetValueXxXxxx() {
    // Arrange, Act and Assert
    assertEquals(
        ".*\\?get\\(\".*?\"\\)\\.\\?value.*xx---xxxx",
        phraseTranslator.convertMapAccessSyntax(".*\\?get\\(\".*?\"\\)\\.\\?value.*xx[\"xx\"]xx"));
  }

  /**
   * Test {@link PhraseTranslator#convertMapAccessSyntax(String)}.
   *
   * <ul>
   *   <li>When {@code ).?getValue()xx["xx"]xx}.
   *   <li>Then return {@code ).?getValue()xx---xxxx}.
   * </ul>
   *
   * <p>Method under test: {@link PhraseTranslator#convertMapAccessSyntax(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String PhraseTranslator.convertMapAccessSyntax(String)"})
  public void testConvertMapAccessSyntax_whenGetValueXxXxXx_thenReturnGetValueXxXxxx2() {
    // Arrange, Act and Assert
    assertEquals(
        ").?getValue()xx---xxxx",
        new PhraseTranslator().convertMapAccessSyntax(").?getValue()xx[\"xx\"]xx"));
  }

  /**
   * Test {@link PhraseTranslator#convertMapAccessSyntax(String)}.
   *
   * <ul>
   *   <li>When {@code .?get(xx?get("xx").?getValue()xx}.
   *   <li>Then return {@code ---x?get("xxxx}.
   * </ul>
   *
   * <p>Method under test: {@link PhraseTranslator#convertMapAccessSyntax(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String PhraseTranslator.convertMapAccessSyntax(String)"})
  public void testConvertMapAccessSyntax_whenGetXxGetXxGetValueXx_thenReturnXGetXxxx() {
    // Arrange, Act and Assert
    assertEquals(
        "---x?get(\"xxxx",
        new PhraseTranslator().convertMapAccessSyntax(".?get(xx?get(\"xx\").?getValue()xx"));
  }

  /**
   * Test {@link PhraseTranslator#convertMapAccessSyntax(String)}.
   *
   * <ul>
   *   <li>When {@code .?get(xx?get("xx").?valuexx}.
   *   <li>Then return {@code ---x?get("xxxx}.
   * </ul>
   *
   * <p>Method under test: {@link PhraseTranslator#convertMapAccessSyntax(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String PhraseTranslator.convertMapAccessSyntax(String)"})
  public void testConvertMapAccessSyntax_whenGetXxGetXxValuexx_thenReturnXGetXxxx() {
    // Arrange, Act and Assert
    assertEquals(
        "---x?get(\"xxxx",
        new PhraseTranslator().convertMapAccessSyntax(".?get(xx?get(\"xx\").?valuexx"));
  }

  /**
   * Test {@link PhraseTranslator#convertMapAccessSyntax(String)}.
   *
   * <ul>
   *   <li>When {@code .?get(xx["xx"]xx}.
   *   <li>Then return {@code .?get(xx---xxxx}.
   * </ul>
   *
   * <p>Method under test: {@link PhraseTranslator#convertMapAccessSyntax(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String PhraseTranslator.convertMapAccessSyntax(String)"})
  public void testConvertMapAccessSyntax_whenGetXxXxXx_thenReturnGetXxXxxx() {
    // Arrange, Act and Assert
    assertEquals(
        ".?get(xx---xxxx", new PhraseTranslator().convertMapAccessSyntax(".?get(xx[\"xx\"]xx"));
  }

  /**
   * Test {@link PhraseTranslator#convertMapAccessSyntax(String)}.
   *
   * <ul>
   *   <li>When {@code ).?valuexx["xx"]xx}.
   *   <li>Then return {@code ).?valuexx---xxxx}.
   * </ul>
   *
   * <p>Method under test: {@link PhraseTranslator#convertMapAccessSyntax(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String PhraseTranslator.convertMapAccessSyntax(String)"})
  public void testConvertMapAccessSyntax_whenValuexxXxXx_thenReturnValuexxXxxx() {
    // Arrange, Act and Assert
    assertEquals(
        ").?valuexx---xxxx", new PhraseTranslator().convertMapAccessSyntax(").?valuexx[\"xx\"]xx"));
  }

  /**
   * Test {@link PhraseTranslator#convertMapAccessSyntax(String)}.
   *
   * <ul>
   *   <li>When {@code xx["xx"]xxField}.
   *   <li>Then return {@code xx---xxxxField}.
   * </ul>
   *
   * <p>Method under test: {@link PhraseTranslator#convertMapAccessSyntax(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String PhraseTranslator.convertMapAccessSyntax(String)"})
  public void testConvertMapAccessSyntax_whenXxXxXxField_thenReturnXxXxxxField() {
    // Arrange, Act and Assert
    assertEquals("xx---xxxxField", phraseTranslator.convertMapAccessSyntax("xx[\"xx\"]xxField"));
  }

  /**
   * Test {@link PhraseTranslator#convertMapAccessSyntax(String)}.
   *
   * <ul>
   *   <li>When {@code xx["xx"]xx.*\?get\(".*?"\)\.\?getValue\(\).*}.
   *   <li>Then return {@code xx---xxxx.*\?get\(".*?"\)\.\?getValue\(\).*}.
   * </ul>
   *
   * <p>Method under test: {@link PhraseTranslator#convertMapAccessSyntax(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String PhraseTranslator.convertMapAccessSyntax(String)"})
  public void testConvertMapAccessSyntax_whenXxXxXxGetGetValue_thenReturnXxXxxxGetGetValue() {
    // Arrange, Act and Assert
    assertEquals(
        "xx---xxxx.*\\?get\\(\".*?\"\\)\\.\\?getValue\\(\\).*",
        phraseTranslator.convertMapAccessSyntax(
            "xx[\"xx\"]xx.*\\?get\\(\".*?\"\\)\\.\\?getValue\\(\\).*"));
  }

  /**
   * Test {@link PhraseTranslator#convertMapAccessSyntax(String)}.
   *
   * <ul>
   *   <li>When {@code xx["xx"]xx.*\?get\(".*?"\)\.\?value.*}.
   *   <li>Then return {@code xx---xxxx.*\?get\(".*?"\)\.\?value.*}.
   * </ul>
   *
   * <p>Method under test: {@link PhraseTranslator#convertMapAccessSyntax(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String PhraseTranslator.convertMapAccessSyntax(String)"})
  public void testConvertMapAccessSyntax_whenXxXxXxGetValue_thenReturnXxXxxxGetValue() {
    // Arrange, Act and Assert
    assertEquals(
        "xx---xxxx.*\\?get\\(\".*?\"\\)\\.\\?value.*",
        phraseTranslator.convertMapAccessSyntax("xx[\"xx\"]xx.*\\?get\\(\".*?\"\\)\\.\\?value.*"));
  }

  /**
   * Test {@link PhraseTranslator#convertMapAccessSyntax(String)}.
   *
   * <ul>
   *   <li>When {@code xx["xx"]xx).?getValue()}.
   *   <li>Then return {@code xx---xxxx).?getValue()}.
   * </ul>
   *
   * <p>Method under test: {@link PhraseTranslator#convertMapAccessSyntax(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String PhraseTranslator.convertMapAccessSyntax(String)"})
  public void testConvertMapAccessSyntax_whenXxXxXxGetValue_thenReturnXxXxxxGetValue2() {
    // Arrange, Act and Assert
    assertEquals(
        "xx---xxxx).?getValue()",
        phraseTranslator.convertMapAccessSyntax("xx[\"xx\"]xx).?getValue()"));
  }

  /**
   * Test {@link PhraseTranslator#convertMapAccessSyntax(String)}.
   *
   * <ul>
   *   <li>When {@code xx["xx"]xx.?get(}.
   *   <li>Then return {@code xx---xxxx.?get(}.
   * </ul>
   *
   * <p>Method under test: {@link PhraseTranslator#convertMapAccessSyntax(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String PhraseTranslator.convertMapAccessSyntax(String)"})
  public void testConvertMapAccessSyntax_whenXxXxXxGet_thenReturnXxXxxxGet() {
    // Arrange, Act and Assert
    assertEquals("xx---xxxx.?get(", phraseTranslator.convertMapAccessSyntax("xx[\"xx\"]xx.?get("));
  }

  /**
   * Test {@link PhraseTranslator#convertMapAccessSyntax(String)}.
   *
   * <ul>
   *   <li>When {@code xx["xx"]xx).?value}.
   *   <li>Then return {@code xx---xxxx).?value}.
   * </ul>
   *
   * <p>Method under test: {@link PhraseTranslator#convertMapAccessSyntax(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String PhraseTranslator.convertMapAccessSyntax(String)"})
  public void testConvertMapAccessSyntax_whenXxXxXxValue_thenReturnXxXxxxValue() {
    // Arrange, Act and Assert
    assertEquals(
        "xx---xxxx).?value", phraseTranslator.convertMapAccessSyntax("xx[\"xx\"]xx).?value"));
  }

  /**
   * Test {@link PhraseTranslator#convertMapAccessSyntax(String)}.
   *
   * <ul>
   *   <li>When {@code xx["xx"]xxxx["xx"]xx}.
   *   <li>Then return {@code xx["xx"]xxxx---xxxx}.
   * </ul>
   *
   * <p>Method under test: {@link PhraseTranslator#convertMapAccessSyntax(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String PhraseTranslator.convertMapAccessSyntax(String)"})
  public void testConvertMapAccessSyntax_whenXxXxXxxxXxXx_thenReturnXxXxXxxxXxxx() {
    // Arrange, Act and Assert
    assertEquals(
        "xx[\"xx\"]xxxx---xxxx",
        phraseTranslator.convertMapAccessSyntax("xx[\"xx\"]xxxx[\"xx\"]xx"));
  }

  /**
   * Test {@link PhraseTranslator#extractProjection(String[])}.
   *
   * <p>Method under test: {@link PhraseTranslator#extractProjection(String[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String[] PhraseTranslator.extractProjection(String[])"})
  public void testExtractProjection() {
    // Arrange and Act
    String[] actualExtractProjectionResult =
        new PhraseTranslator().extractProjection(new String[] {".*\\[\".*?\"\\].*"});

    // Assert
    assertArrayEquals(new String[] {"\"\\].*", "==", "[\".*?\"\\]"}, actualExtractProjectionResult);
  }

  /**
   * Test {@link PhraseTranslator#extractOldSpecialComponents(String, String)}.
   *
   * <p>Method under test: {@link PhraseTranslator#extractOldSpecialComponents(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String[] PhraseTranslator.extractOldSpecialComponents(String, String)"})
  public void testExtractOldSpecialComponents() {
    // Arrange, Act and Assert
    assertArrayEquals(
        new String[] {"", "", ""}, phraseTranslator.extractOldSpecialComponents("\")", ""));
  }

  /**
   * Test {@link PhraseTranslator#extractStandardComponents(String, String)}.
   *
   * <p>Method under test: {@link PhraseTranslator#extractStandardComponents(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String[] PhraseTranslator.extractStandardComponents(String, String)"})
  public void testExtractStandardComponents() {
    // Arrange, Act and Assert
    assertArrayEquals(
        new String[] {"", "", "Phrase"}, phraseTranslator.extractStandardComponents("Phrase", ""));
  }

  /**
   * Test {@link PhraseTranslator#getOperator(String, String, String, boolean, boolean, boolean)}.
   *
   * <ul>
   *   <li>Given {@link PhraseTranslator}.
   *   <li>When {@code .contains}.
   *   <li>Then return {@code CONTAINS}.
   * </ul>
   *
   * <p>Method under test: {@link PhraseTranslator#getOperator(String, String, String, boolean,
   * boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BLCOperator PhraseTranslator.getOperator(String, String, String, boolean, boolean, boolean)"
  })
  public void testGetOperator_givenPhraseTranslator_whenContains_thenReturnContains()
      throws MVELTranslationException {
    // Arrange, Act and Assert
    assertEquals(
        BLCOperator.CONTAINS,
        phraseTranslator.getOperator("Field", ".contains", "null", false, false, false));
  }

  /**
   * Test {@link PhraseTranslator#getOperator(String, String, String, boolean, boolean, boolean)}.
   *
   * <ul>
   *   <li>Given {@link PhraseTranslator}.
   *   <li>When {@code .endsWith}.
   *   <li>Then return {@code ENDS_WITH}.
   * </ul>
   *
   * <p>Method under test: {@link PhraseTranslator#getOperator(String, String, String, boolean,
   * boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BLCOperator PhraseTranslator.getOperator(String, String, String, boolean, boolean, boolean)"
  })
  public void testGetOperator_givenPhraseTranslator_whenEndsWith_thenReturnEndsWith()
      throws MVELTranslationException {
    // Arrange, Act and Assert
    assertEquals(
        BLCOperator.ENDS_WITH,
        phraseTranslator.getOperator("Field", ".endsWith", "null", false, false, false));
  }

  /**
   * Test {@link PhraseTranslator#getOperator(String, String, String, boolean, boolean, boolean)}.
   *
   * <ul>
   *   <li>Given {@link PhraseTranslator} (default constructor).
   *   <li>When {@code ==}.
   *   <li>Then return {@code EQUALS}.
   * </ul>
   *
   * <p>Method under test: {@link PhraseTranslator#getOperator(String, String, String, boolean,
   * boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BLCOperator PhraseTranslator.getOperator(String, String, String, boolean, boolean, boolean)"
  })
  public void testGetOperator_givenPhraseTranslator_whenEqualsSignEqualsSign_thenReturnEquals()
      throws MVELTranslationException {
    // Arrange, Act and Assert
    assertEquals(
        BLCOperator.EQUALS,
        new PhraseTranslator().getOperator("Field", "==", "42", true, false, false));
  }

  /**
   * Test {@link PhraseTranslator#getOperator(String, String, String, boolean, boolean, boolean)}.
   *
   * <ul>
   *   <li>Given {@link PhraseTranslator}.
   *   <li>When {@code ==}.
   *   <li>Then return {@code IEQUALS}.
   * </ul>
   *
   * <p>Method under test: {@link PhraseTranslator#getOperator(String, String, String, boolean,
   * boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BLCOperator PhraseTranslator.getOperator(String, String, String, boolean, boolean, boolean)"
  })
  public void testGetOperator_givenPhraseTranslator_whenEqualsSignEqualsSign_thenReturnIequals()
      throws MVELTranslationException {
    // Arrange, Act and Assert
    assertEquals(
        BLCOperator.IEQUALS, phraseTranslator.getOperator("Field", "==", "42", true, false, true));
  }

  /**
   * Test {@link PhraseTranslator#getOperator(String, String, String, boolean, boolean, boolean)}.
   *
   * <ul>
   *   <li>Given {@link PhraseTranslator}.
   *   <li>When {@code ==}.
   *   <li>Then return {@code IS_NULL}.
   * </ul>
   *
   * <p>Method under test: {@link PhraseTranslator#getOperator(String, String, String, boolean,
   * boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BLCOperator PhraseTranslator.getOperator(String, String, String, boolean, boolean, boolean)"
  })
  public void testGetOperator_givenPhraseTranslator_whenEqualsSignEqualsSign_thenReturnIsNull()
      throws MVELTranslationException {
    // Arrange, Act and Assert
    assertEquals(
        BLCOperator.IS_NULL,
        phraseTranslator.getOperator("Field", "==", "null", false, false, false));
  }

  /**
   * Test {@link PhraseTranslator#getOperator(String, String, String, boolean, boolean, boolean)}.
   *
   * <ul>
   *   <li>Given {@link PhraseTranslator}.
   *   <li>When {@code >}.
   *   <li>Then return {@code GREATER_THAN}.
   * </ul>
   *
   * <p>Method under test: {@link PhraseTranslator#getOperator(String, String, String, boolean,
   * boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BLCOperator PhraseTranslator.getOperator(String, String, String, boolean, boolean, boolean)"
  })
  public void testGetOperator_givenPhraseTranslator_whenGreaterThanSign_thenReturnGreaterThan()
      throws MVELTranslationException {
    // Arrange, Act and Assert
    assertEquals(
        BLCOperator.GREATER_THAN,
        phraseTranslator.getOperator("Field", ">", "null", false, false, false));
  }

  /**
   * Test {@link PhraseTranslator#getOperator(String, String, String, boolean, boolean, boolean)}.
   *
   * <ul>
   *   <li>Given {@link PhraseTranslator}.
   *   <li>When {@code <}.
   *   <li>Then return {@code LESS_THAN}.
   * </ul>
   *
   * <p>Method under test: {@link PhraseTranslator#getOperator(String, String, String, boolean,
   * boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BLCOperator PhraseTranslator.getOperator(String, String, String, boolean, boolean, boolean)"
  })
  public void testGetOperator_givenPhraseTranslator_whenLessThanSign_thenReturnLessThan()
      throws MVELTranslationException {
    // Arrange, Act and Assert
    assertEquals(
        BLCOperator.LESS_THAN,
        phraseTranslator.getOperator("Field", "<", "null", false, false, false));
  }

  /**
   * Test {@link PhraseTranslator#getOperator(String, String, String, boolean, boolean, boolean)}.
   *
   * <ul>
   *   <li>Given {@link PhraseTranslator}.
   *   <li>When {@code <}.
   *   <li>Then return {@code LESS_THAN_FIELD}.
   * </ul>
   *
   * <p>Method under test: {@link PhraseTranslator#getOperator(String, String, String, boolean,
   * boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BLCOperator PhraseTranslator.getOperator(String, String, String, boolean, boolean, boolean)"
  })
  public void testGetOperator_givenPhraseTranslator_whenLessThanSign_thenReturnLessThanField()
      throws MVELTranslationException {
    // Arrange, Act and Assert
    assertEquals(
        BLCOperator.LESS_THAN_FIELD,
        phraseTranslator.getOperator("Field", "<", "42", true, true, true));
  }

  /**
   * Test {@link PhraseTranslator#getOperator(String, String, String, boolean, boolean, boolean)}.
   *
   * <ul>
   *   <li>Given {@link PhraseTranslator}.
   *   <li>When {@code .size()>0}.
   *   <li>Then return {@code COLLECTION_IN}.
   * </ul>
   *
   * <p>Method under test: {@link PhraseTranslator#getOperator(String, String, String, boolean,
   * boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BLCOperator PhraseTranslator.getOperator(String, String, String, boolean, boolean, boolean)"
  })
  public void testGetOperator_givenPhraseTranslator_whenSize0_thenReturnCollectionIn()
      throws MVELTranslationException {
    // Arrange, Act and Assert
    assertEquals(
        BLCOperator.COLLECTION_IN,
        phraseTranslator.getOperator("Field", ".size()>0", "null", false, false, false));
  }

  /**
   * Test {@link PhraseTranslator#getOperator(String, String, String, boolean, boolean, boolean)}.
   *
   * <ul>
   *   <li>Given {@link PhraseTranslator}.
   *   <li>When {@code .size()==0}.
   *   <li>Then return {@code COLLECTION_NOT_IN}.
   * </ul>
   *
   * <p>Method under test: {@link PhraseTranslator#getOperator(String, String, String, boolean,
   * boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BLCOperator PhraseTranslator.getOperator(String, String, String, boolean, boolean, boolean)"
  })
  public void testGetOperator_givenPhraseTranslator_whenSize0_thenReturnCollectionNotIn()
      throws MVELTranslationException {
    // Arrange, Act and Assert
    assertEquals(
        BLCOperator.COLLECTION_NOT_IN,
        phraseTranslator.getOperator("Field", ".size()==0", "null", false, false, false));
  }

  /**
   * Test {@link PhraseTranslator#getOperator(String, String, String, boolean, boolean, boolean)}.
   *
   * <ul>
   *   <li>Given {@link PhraseTranslator}.
   *   <li>When {@code .size()==}.
   *   <li>Then return {@code COUNT_EQUALS}.
   * </ul>
   *
   * <p>Method under test: {@link PhraseTranslator#getOperator(String, String, String, boolean,
   * boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BLCOperator PhraseTranslator.getOperator(String, String, String, boolean, boolean, boolean)"
  })
  public void testGetOperator_givenPhraseTranslator_whenSize_thenReturnCountEquals()
      throws MVELTranslationException {
    // Arrange, Act and Assert
    assertEquals(
        BLCOperator.COUNT_EQUALS,
        phraseTranslator.getOperator("Field", ".size()==", "null", false, false, false));
  }

  /**
   * Test {@link PhraseTranslator#getOperator(String, String, String, boolean, boolean, boolean)}.
   *
   * <ul>
   *   <li>Given {@link PhraseTranslator}.
   *   <li>When {@code .size()>=}.
   *   <li>Then return {@code COUNT_GREATER_OR_EQUAL}.
   * </ul>
   *
   * <p>Method under test: {@link PhraseTranslator#getOperator(String, String, String, boolean,
   * boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BLCOperator PhraseTranslator.getOperator(String, String, String, boolean, boolean, boolean)"
  })
  public void testGetOperator_givenPhraseTranslator_whenSize_thenReturnCountGreaterOrEqual()
      throws MVELTranslationException {
    // Arrange, Act and Assert
    assertEquals(
        BLCOperator.COUNT_GREATER_OR_EQUAL,
        phraseTranslator.getOperator("Field", ".size()>=", "null", false, false, false));
  }

  /**
   * Test {@link PhraseTranslator#getOperator(String, String, String, boolean, boolean, boolean)}.
   *
   * <ul>
   *   <li>Given {@link PhraseTranslator}.
   *   <li>When {@code .size()>}.
   *   <li>Then return {@code COUNT_GREATER_THAN}.
   * </ul>
   *
   * <p>Method under test: {@link PhraseTranslator#getOperator(String, String, String, boolean,
   * boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BLCOperator PhraseTranslator.getOperator(String, String, String, boolean, boolean, boolean)"
  })
  public void testGetOperator_givenPhraseTranslator_whenSize_thenReturnCountGreaterThan()
      throws MVELTranslationException {
    // Arrange, Act and Assert
    assertEquals(
        BLCOperator.COUNT_GREATER_THAN,
        phraseTranslator.getOperator("Field", ".size()>", "null", false, false, false));
  }

  /**
   * Test {@link PhraseTranslator#getOperator(String, String, String, boolean, boolean, boolean)}.
   *
   * <ul>
   *   <li>Given {@link PhraseTranslator}.
   *   <li>When {@code .size()<=}.
   *   <li>Then return {@code COUNT_LESS_OR_EQUAL}.
   * </ul>
   *
   * <p>Method under test: {@link PhraseTranslator#getOperator(String, String, String, boolean,
   * boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BLCOperator PhraseTranslator.getOperator(String, String, String, boolean, boolean, boolean)"
  })
  public void testGetOperator_givenPhraseTranslator_whenSize_thenReturnCountLessOrEqual()
      throws MVELTranslationException {
    // Arrange, Act and Assert
    assertEquals(
        BLCOperator.COUNT_LESS_OR_EQUAL,
        phraseTranslator.getOperator("Field", ".size()<=", "null", false, false, false));
  }

  /**
   * Test {@link PhraseTranslator#getOperator(String, String, String, boolean, boolean, boolean)}.
   *
   * <ul>
   *   <li>Given {@link PhraseTranslator}.
   *   <li>When {@code .size()<}.
   *   <li>Then return {@code COUNT_LESS_THAN}.
   * </ul>
   *
   * <p>Method under test: {@link PhraseTranslator#getOperator(String, String, String, boolean,
   * boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BLCOperator PhraseTranslator.getOperator(String, String, String, boolean, boolean, boolean)"
  })
  public void testGetOperator_givenPhraseTranslator_whenSize_thenReturnCountLessThan()
      throws MVELTranslationException {
    // Arrange, Act and Assert
    assertEquals(
        BLCOperator.COUNT_LESS_THAN,
        phraseTranslator.getOperator("Field", ".size()<", "null", false, false, false));
  }

  /**
   * Test {@link PhraseTranslator#getOperator(String, String, String, boolean, boolean, boolean)}.
   *
   * <ul>
   *   <li>Given {@link PhraseTranslator}.
   *   <li>When {@code .startsWith}.
   *   <li>Then return {@code STARTS_WITH}.
   * </ul>
   *
   * <p>Method under test: {@link PhraseTranslator#getOperator(String, String, String, boolean,
   * boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BLCOperator PhraseTranslator.getOperator(String, String, String, boolean, boolean, boolean)"
  })
  public void testGetOperator_givenPhraseTranslator_whenStartsWith_thenReturnStartsWith()
      throws MVELTranslationException {
    // Arrange, Act and Assert
    assertEquals(
        BLCOperator.STARTS_WITH,
        phraseTranslator.getOperator("Field", ".startsWith", "null", false, false, false));
  }

  /**
   * Test {@link PhraseTranslator#getOperator(String, String, String, boolean, boolean, boolean)}.
   *
   * <ul>
   *   <li>Then return {@code CONTAINS_FIELD}.
   * </ul>
   *
   * <p>Method under test: {@link PhraseTranslator#getOperator(String, String, String, boolean,
   * boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BLCOperator PhraseTranslator.getOperator(String, String, String, boolean, boolean, boolean)"
  })
  public void testGetOperator_thenReturnContainsField() throws MVELTranslationException {
    // Arrange, Act and Assert
    assertEquals(
        BLCOperator.CONTAINS_FIELD,
        new PhraseTranslator()
            .getOperator(
                "Field",
                "org.apache.commons.lang3.StringUtils.contains",
                "42",
                false,
                true,
                false));
  }

  /**
   * Test {@link PhraseTranslator#getOperator(String, String, String, boolean, boolean, boolean)}.
   *
   * <ul>
   *   <li>Then return {@code INOT_CONTAINS}.
   * </ul>
   *
   * <p>Method under test: {@link PhraseTranslator#getOperator(String, String, String, boolean,
   * boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BLCOperator PhraseTranslator.getOperator(String, String, String, boolean, boolean, boolean)"
  })
  public void testGetOperator_thenReturnInotContains() throws MVELTranslationException {
    // Arrange, Act and Assert
    assertEquals(
        BLCOperator.INOT_CONTAINS,
        phraseTranslator.getOperator(
            "Field", "org.apache.commons.lang3.StringUtils.contains", "42", true, true, true));
  }

  /**
   * Test {@link PhraseTranslator#getOperator(String, String, String, boolean, boolean, boolean)}.
   *
   * <ul>
   *   <li>Then return {@code INOT_STARTS_WITH}.
   * </ul>
   *
   * <p>Method under test: {@link PhraseTranslator#getOperator(String, String, String, boolean,
   * boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BLCOperator PhraseTranslator.getOperator(String, String, String, boolean, boolean, boolean)"
  })
  public void testGetOperator_thenReturnInotStartsWith() throws MVELTranslationException {
    // Arrange, Act and Assert
    assertEquals(
        BLCOperator.INOT_STARTS_WITH,
        phraseTranslator.getOperator(
            "Field", "org.apache.commons.lang3.StringUtils.startsWith", "42", true, true, true));
  }

  /**
   * Test {@link PhraseTranslator#getOperator(String, String, String, boolean, boolean, boolean)}.
   *
   * <ul>
   *   <li>Then return {@code ISTARTS_WITH}.
   * </ul>
   *
   * <p>Method under test: {@link PhraseTranslator#getOperator(String, String, String, boolean,
   * boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BLCOperator PhraseTranslator.getOperator(String, String, String, boolean, boolean, boolean)"
  })
  public void testGetOperator_thenReturnIstartsWith() throws MVELTranslationException {
    // Arrange, Act and Assert
    assertEquals(
        BLCOperator.ISTARTS_WITH,
        new PhraseTranslator()
            .getOperator(
                "Field",
                "org.apache.commons.lang3.StringUtils.startsWith",
                "42",
                false,
                true,
                true));
  }

  /**
   * Test {@link PhraseTranslator#getOperator(String, String, String, boolean, boolean, boolean)}.
   *
   * <ul>
   *   <li>Then return {@code NOT_CONTAINS}.
   * </ul>
   *
   * <p>Method under test: {@link PhraseTranslator#getOperator(String, String, String, boolean,
   * boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BLCOperator PhraseTranslator.getOperator(String, String, String, boolean, boolean, boolean)"
  })
  public void testGetOperator_thenReturnNotContains() throws MVELTranslationException {
    // Arrange, Act and Assert
    assertEquals(
        BLCOperator.NOT_CONTAINS,
        phraseTranslator.getOperator(
            "Field", "org.apache.commons.lang3.StringUtils.contains", "42", true, true, false));
  }

  /**
   * Test {@link PhraseTranslator#getOperator(String, String, String, boolean, boolean, boolean)}.
   *
   * <ul>
   *   <li>Then return {@code NOT_STARTS_WITH}.
   * </ul>
   *
   * <p>Method under test: {@link PhraseTranslator#getOperator(String, String, String, boolean,
   * boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BLCOperator PhraseTranslator.getOperator(String, String, String, boolean, boolean, boolean)"
  })
  public void testGetOperator_thenReturnNotStartsWith() throws MVELTranslationException {
    // Arrange, Act and Assert
    assertEquals(
        BLCOperator.NOT_STARTS_WITH,
        new PhraseTranslator()
            .getOperator(
                "Field",
                "org.apache.commons.lang3.StringUtils.startsWith",
                "42",
                true,
                true,
                false));
  }

  /**
   * Test {@link PhraseTranslator#getOperator(String, String, String, boolean, boolean, boolean)}.
   *
   * <ul>
   *   <li>Then return {@code STARTS_WITH}.
   * </ul>
   *
   * <p>Method under test: {@link PhraseTranslator#getOperator(String, String, String, boolean,
   * boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BLCOperator PhraseTranslator.getOperator(String, String, String, boolean, boolean, boolean)"
  })
  public void testGetOperator_thenReturnStartsWith() throws MVELTranslationException {
    // Arrange, Act and Assert
    assertEquals(
        BLCOperator.STARTS_WITH,
        phraseTranslator.getOperator(
            "Field",
            "org.apache.commons.lang3.StringUtils.startsWith",
            "null",
            false,
            false,
            false));
  }

  /**
   * Test {@link PhraseTranslator#getOperator(String, String, String, boolean, boolean, boolean)}.
   *
   * <ul>
   *   <li>Then return {@code STARTS_WITH_FIELD}.
   * </ul>
   *
   * <p>Method under test: {@link PhraseTranslator#getOperator(String, String, String, boolean,
   * boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BLCOperator PhraseTranslator.getOperator(String, String, String, boolean, boolean, boolean)"
  })
  public void testGetOperator_thenReturnStartsWithField() throws MVELTranslationException {
    // Arrange, Act and Assert
    assertEquals(
        BLCOperator.STARTS_WITH_FIELD,
        new PhraseTranslator()
            .getOperator(
                "Field",
                "org.apache.commons.lang3.StringUtils.startsWith",
                "42",
                false,
                true,
                false));
  }

  /**
   * Test {@link PhraseTranslator#getOperator(String, String, String, boolean, boolean, boolean)}.
   *
   * <ul>
   *   <li>When {@code ==}.
   *   <li>Then return {@code EQUALS_FIELD}.
   * </ul>
   *
   * <p>Method under test: {@link PhraseTranslator#getOperator(String, String, String, boolean,
   * boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BLCOperator PhraseTranslator.getOperator(String, String, String, boolean, boolean, boolean)"
  })
  public void testGetOperator_whenEqualsSignEqualsSign_thenReturnEqualsField()
      throws MVELTranslationException {
    // Arrange, Act and Assert
    assertEquals(
        BLCOperator.EQUALS_FIELD,
        phraseTranslator.getOperator("Field", "==", "42", true, true, true));
  }

  /**
   * Test {@link PhraseTranslator#getOperator(String, String, String, boolean, boolean, boolean)}.
   *
   * <ul>
   *   <li>When {@code !=}.
   *   <li>Then return {@code INOT_EQUAL}.
   * </ul>
   *
   * <p>Method under test: {@link PhraseTranslator#getOperator(String, String, String, boolean,
   * boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BLCOperator PhraseTranslator.getOperator(String, String, String, boolean, boolean, boolean)"
  })
  public void testGetOperator_whenExclamationMarkEqualsSign_thenReturnInotEqual()
      throws MVELTranslationException {
    // Arrange, Act and Assert
    assertEquals(
        BLCOperator.INOT_EQUAL,
        phraseTranslator.getOperator("Field", "!=", "42", true, false, true));
  }

  /**
   * Test {@link PhraseTranslator#getOperator(String, String, String, boolean, boolean, boolean)}.
   *
   * <ul>
   *   <li>When {@code !=}.
   *   <li>Then return {@code NOT_EQUAL}.
   * </ul>
   *
   * <p>Method under test: {@link PhraseTranslator#getOperator(String, String, String, boolean,
   * boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BLCOperator PhraseTranslator.getOperator(String, String, String, boolean, boolean, boolean)"
  })
  public void testGetOperator_whenExclamationMarkEqualsSign_thenReturnNotEqual()
      throws MVELTranslationException {
    // Arrange, Act and Assert
    assertEquals(
        BLCOperator.NOT_EQUAL,
        new PhraseTranslator().getOperator("Field", "!=", "42", true, false, false));
  }

  /**
   * Test {@link PhraseTranslator#getOperator(String, String, String, boolean, boolean, boolean)}.
   *
   * <ul>
   *   <li>When {@code !=}.
   *   <li>Then return {@code NOT_EQUAL_FIELD}.
   * </ul>
   *
   * <p>Method under test: {@link PhraseTranslator#getOperator(String, String, String, boolean,
   * boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BLCOperator PhraseTranslator.getOperator(String, String, String, boolean, boolean, boolean)"
  })
  public void testGetOperator_whenExclamationMarkEqualsSign_thenReturnNotEqualField()
      throws MVELTranslationException {
    // Arrange, Act and Assert
    assertEquals(
        BLCOperator.NOT_EQUAL_FIELD,
        phraseTranslator.getOperator("Field", "!=", "42", true, true, true));
  }

  /**
   * Test {@link PhraseTranslator#getOperator(String, String, String, boolean, boolean, boolean)}.
   *
   * <ul>
   *   <li>When {@code !=}.
   *   <li>Then return {@code NOT_NULL}.
   * </ul>
   *
   * <p>Method under test: {@link PhraseTranslator#getOperator(String, String, String, boolean,
   * boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BLCOperator PhraseTranslator.getOperator(String, String, String, boolean, boolean, boolean)"
  })
  public void testGetOperator_whenExclamationMarkEqualsSign_thenReturnNotNull()
      throws MVELTranslationException {
    // Arrange, Act and Assert
    assertEquals(
        BLCOperator.NOT_NULL,
        phraseTranslator.getOperator("Field", "!=", "null", false, false, false));
  }

  /**
   * Test {@link PhraseTranslator#getOperator(String, String, String, boolean, boolean, boolean)}.
   *
   * <ul>
   *   <li>When {@code >=}.
   *   <li>Then return {@code GREATER_OR_EQUAL}.
   * </ul>
   *
   * <p>Method under test: {@link PhraseTranslator#getOperator(String, String, String, boolean,
   * boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BLCOperator PhraseTranslator.getOperator(String, String, String, boolean, boolean, boolean)"
  })
  public void testGetOperator_whenGreaterThanSignEqualsSign_thenReturnGreaterOrEqual()
      throws MVELTranslationException {
    // Arrange, Act and Assert
    assertEquals(
        BLCOperator.GREATER_OR_EQUAL,
        phraseTranslator.getOperator("Field", ">=", "null", false, false, false));
  }

  /**
   * Test {@link PhraseTranslator#getOperator(String, String, String, boolean, boolean, boolean)}.
   *
   * <ul>
   *   <li>When {@code >=}.
   *   <li>Then return {@code GREATER_OR_EQUAL_FIELD}.
   * </ul>
   *
   * <p>Method under test: {@link PhraseTranslator#getOperator(String, String, String, boolean,
   * boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BLCOperator PhraseTranslator.getOperator(String, String, String, boolean, boolean, boolean)"
  })
  public void testGetOperator_whenGreaterThanSignEqualsSign_thenReturnGreaterOrEqualField()
      throws MVELTranslationException {
    // Arrange, Act and Assert
    assertEquals(
        BLCOperator.GREATER_OR_EQUAL_FIELD,
        phraseTranslator.getOperator("Field", ">=", "42", true, true, true));
  }

  /**
   * Test {@link PhraseTranslator#getOperator(String, String, String, boolean, boolean, boolean)}.
   *
   * <ul>
   *   <li>When {@code >}.
   *   <li>Then return {@code GREATER_THAN_FIELD}.
   * </ul>
   *
   * <p>Method under test: {@link PhraseTranslator#getOperator(String, String, String, boolean,
   * boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BLCOperator PhraseTranslator.getOperator(String, String, String, boolean, boolean, boolean)"
  })
  public void testGetOperator_whenGreaterThanSign_thenReturnGreaterThanField()
      throws MVELTranslationException {
    // Arrange, Act and Assert
    assertEquals(
        BLCOperator.GREATER_THAN_FIELD,
        phraseTranslator.getOperator("Field", ">", "42", true, true, true));
  }

  /**
   * Test {@link PhraseTranslator#getOperator(String, String, String, boolean, boolean, boolean)}.
   *
   * <ul>
   *   <li>When {@code <=}.
   *   <li>Then return {@code LESS_OR_EQUAL}.
   * </ul>
   *
   * <p>Method under test: {@link PhraseTranslator#getOperator(String, String, String, boolean,
   * boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BLCOperator PhraseTranslator.getOperator(String, String, String, boolean, boolean, boolean)"
  })
  public void testGetOperator_whenLessThanSignEqualsSign_thenReturnLessOrEqual()
      throws MVELTranslationException {
    // Arrange, Act and Assert
    assertEquals(
        BLCOperator.LESS_OR_EQUAL,
        phraseTranslator.getOperator("Field", "<=", "null", false, false, false));
  }

  /**
   * Test {@link PhraseTranslator#getOperator(String, String, String, boolean, boolean, boolean)}.
   *
   * <ul>
   *   <li>When {@code <=}.
   *   <li>Then return {@code LESS_OR_EQUAL_FIELD}.
   * </ul>
   *
   * <p>Method under test: {@link PhraseTranslator#getOperator(String, String, String, boolean,
   * boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BLCOperator PhraseTranslator.getOperator(String, String, String, boolean, boolean, boolean)"
  })
  public void testGetOperator_whenLessThanSignEqualsSign_thenReturnLessOrEqualField()
      throws MVELTranslationException {
    // Arrange, Act and Assert
    assertEquals(
        BLCOperator.LESS_OR_EQUAL_FIELD,
        phraseTranslator.getOperator("Field", "<=", "42", true, true, true));
  }

  /**
   * Test {@link PhraseTranslator#getOperator(String, String, String, boolean, boolean, boolean)}.
   *
   * <ul>
   *   <li>When {@code Operator}.
   *   <li>Then throw {@link MVELTranslationException}.
   * </ul>
   *
   * <p>Method under test: {@link PhraseTranslator#getOperator(String, String, String, boolean,
   * boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BLCOperator PhraseTranslator.getOperator(String, String, String, boolean, boolean, boolean)"
  })
  public void testGetOperator_whenOperator_thenThrowMVELTranslationException()
      throws MVELTranslationException {
    // Arrange, Act and Assert
    assertThrows(
        MVELTranslationException.class,
        () -> phraseTranslator.getOperator("Field", "Operator", "42", true, true, true));
  }

  /**
   * Test {@link PhraseTranslator#getOperator(String, String, String, boolean, boolean, boolean)}.
   *
   * <ul>
   *   <li>When {@code Operator}.
   *   <li>Then throw {@link MVELTranslationException}.
   * </ul>
   *
   * <p>Method under test: {@link PhraseTranslator#getOperator(String, String, String, boolean,
   * boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BLCOperator PhraseTranslator.getOperator(String, String, String, boolean, boolean, boolean)"
  })
  public void testGetOperator_whenOperator_thenThrowMVELTranslationException2()
      throws MVELTranslationException {
    // Arrange, Act and Assert
    assertThrows(
        MVELTranslationException.class,
        () -> phraseTranslator.getOperator("Field", "Operator", "42", false, true, true));
  }

  /**
   * Test {@link PhraseTranslator#getOperator(String, String, String, boolean, boolean, boolean)}.
   *
   * <ul>
   *   <li>When {@code org.apache.commons.lang3.StringUtils.contains}.
   *   <li>Then return {@code CONTAINS}.
   * </ul>
   *
   * <p>Method under test: {@link PhraseTranslator#getOperator(String, String, String, boolean,
   * boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BLCOperator PhraseTranslator.getOperator(String, String, String, boolean, boolean, boolean)"
  })
  public void testGetOperator_whenOrgApacheCommonsLang3StringUtilsContains_thenReturnContains()
      throws MVELTranslationException {
    // Arrange, Act and Assert
    assertEquals(
        BLCOperator.CONTAINS,
        phraseTranslator.getOperator(
            "Field", "org.apache.commons.lang3.StringUtils.contains", "null", false, false, false));
  }

  /**
   * Test {@link PhraseTranslator#getOperator(String, String, String, boolean, boolean, boolean)}.
   *
   * <ul>
   *   <li>When {@code org.apache.commons.lang3.StringUtils.contains}.
   *   <li>Then return {@code ICONTAINS}.
   * </ul>
   *
   * <p>Method under test: {@link PhraseTranslator#getOperator(String, String, String, boolean,
   * boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BLCOperator PhraseTranslator.getOperator(String, String, String, boolean, boolean, boolean)"
  })
  public void testGetOperator_whenOrgApacheCommonsLang3StringUtilsContains_thenReturnIcontains()
      throws MVELTranslationException {
    // Arrange, Act and Assert
    assertEquals(
        BLCOperator.ICONTAINS,
        phraseTranslator.getOperator(
            "Field", "org.apache.commons.lang3.StringUtils.contains", "42", false, true, true));
  }

  /**
   * Test {@link PhraseTranslator#getOperator(String, String, String, boolean, boolean, boolean)}.
   *
   * <ul>
   *   <li>When {@code org.apache.commons.lang3.StringUtils.endsWith}.
   *   <li>Then return {@code ENDS_WITH}.
   * </ul>
   *
   * <p>Method under test: {@link PhraseTranslator#getOperator(String, String, String, boolean,
   * boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BLCOperator PhraseTranslator.getOperator(String, String, String, boolean, boolean, boolean)"
  })
  public void testGetOperator_whenOrgApacheCommonsLang3StringUtilsEndsWith_thenReturnEndsWith()
      throws MVELTranslationException {
    // Arrange, Act and Assert
    assertEquals(
        BLCOperator.ENDS_WITH,
        phraseTranslator.getOperator(
            "Field", "org.apache.commons.lang3.StringUtils.endsWith", "null", false, false, false));
  }
}
