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
package org.broadleafcommerce.openadmin.web.rulebuilder.grouping;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import org.broadleafcommerce.openadmin.web.rulebuilder.BLCOperator;
import org.broadleafcommerce.openadmin.web.rulebuilder.MVELTranslationException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {GroupingTranslator.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class GroupingTranslatorDiffblueTest {
  @Autowired
  private GroupingTranslator groupingTranslator;

  /**
   * Test {@link GroupingTranslator#createGroups(String)}.
   * <p>
   * Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  public void testCreateGroups() throws MVELTranslationException {
    // Arrange and Act
    Group actualCreateGroupsResult = groupingTranslator.createGroups("\t&&\\|\\|");

    // Assert
    List<String> phrases = actualCreateGroupsResult.getPhrases();
    assertEquals(1, phrases.size());
    assertEquals("\\|\\|", phrases.get(0));
    assertEquals(BLCOperator.AND, actualCreateGroupsResult.getOperatorType());
    assertTrue(actualCreateGroupsResult.getSubGroups().isEmpty());
  }

  /**
   * Test {@link GroupingTranslator#createGroups(String)}.
   * <ul>
   *   <li>Then return Phrases first is {@code ||}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  public void testCreateGroups_thenReturnPhrasesFirstIsVerticalLineVerticalLine() throws MVELTranslationException {
    // Arrange and Act
    Group actualCreateGroupsResult = groupingTranslator.createGroups("\t&&||");

    // Assert
    List<String> phrases = actualCreateGroupsResult.getPhrases();
    assertEquals(1, phrases.size());
    assertEquals("||", phrases.get(0));
    assertEquals(BLCOperator.AND, actualCreateGroupsResult.getOperatorType());
    assertTrue(actualCreateGroupsResult.getSubGroups().isEmpty());
  }

  /**
   * Test {@link GroupingTranslator#createGroups(String)}.
   * <ul>
   *   <li>Then return Phrases size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  public void testCreateGroups_thenReturnPhrasesSizeIsTwo() throws MVELTranslationException {
    // Arrange and Act
    Group actualCreateGroupsResult = groupingTranslator.createGroups("\\|\\|||");

    // Assert
    List<String> phrases = actualCreateGroupsResult.getPhrases();
    assertEquals(2, phrases.size());
    assertEquals("\\|\\", phrases.get(0));
    assertEquals("|", phrases.get(1));
    assertEquals(BLCOperator.OR, actualCreateGroupsResult.getOperatorType());
  }

  /**
   * Test {@link GroupingTranslator#createGroups(String)}.
   * <ul>
   *   <li>Then return SubGroups size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  public void testCreateGroups_thenReturnSubGroupsSizeIsOne() throws MVELTranslationException {
    // Arrange, Act and Assert
    List<Group> subGroups = groupingTranslator.createGroups("()").getSubGroups();
    assertEquals(1, subGroups.size());
    Group getResult = subGroups.get(0);
    assertNull(getResult.getOperatorType());
    assertFalse(getResult.getIsTopGroup());
    assertTrue(getResult.getPhrases().isEmpty());
    assertTrue(getResult.getSubGroups().isEmpty());
  }

  /**
   * Test {@link GroupingTranslator#createGroups(String)}.
   * <ul>
   *   <li>Then return SubGroups size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  public void testCreateGroups_thenReturnSubGroupsSizeIsOne2() throws MVELTranslationException {
    // Arrange, Act and Assert
    List<Group> subGroups = groupingTranslator.createGroups("\t()").getSubGroups();
    assertEquals(1, subGroups.size());
    Group getResult = subGroups.get(0);
    assertNull(getResult.getOperatorType());
    assertFalse(getResult.getIsTopGroup());
    assertTrue(getResult.getPhrases().isEmpty());
    assertTrue(getResult.getSubGroups().isEmpty());
  }

  /**
   * Test {@link GroupingTranslator#createGroups(String)}.
   * <ul>
   *   <li>When {@code 42}.</li>
   *   <li>Then return Phrases first is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  public void testCreateGroups_when42_thenReturnPhrasesFirstIs42() throws MVELTranslationException {
    // Arrange and Act
    Group actualCreateGroupsResult = groupingTranslator.createGroups("\t42");

    // Assert
    List<String> phrases = actualCreateGroupsResult.getPhrases();
    assertEquals(1, phrases.size());
    assertEquals("42", phrases.get(0));
    assertEquals(BLCOperator.AND, actualCreateGroupsResult.getOperatorType());
    assertTrue(actualCreateGroupsResult.getSubGroups().isEmpty());
  }

  /**
   * Test {@link GroupingTranslator#createGroups(String)}.
   * <ul>
   *   <li>When {@code 42}.</li>
   *   <li>Then return Phrases first is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  public void testCreateGroups_when42_thenReturnPhrasesFirstIs422() throws MVELTranslationException {
    // Arrange and Act
    Group actualCreateGroupsResult = groupingTranslator.createGroups("42\t");

    // Assert
    List<String> phrases = actualCreateGroupsResult.getPhrases();
    assertEquals(1, phrases.size());
    assertEquals("42", phrases.get(0));
    assertEquals(BLCOperator.AND, actualCreateGroupsResult.getOperatorType());
    assertTrue(actualCreateGroupsResult.getSubGroups().isEmpty());
  }

  /**
   * Test {@link GroupingTranslator#createGroups(String)}.
   * <ul>
   *   <li>When {@code 42}.</li>
   *   <li>Then return Phrases first is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  public void testCreateGroups_when42_thenReturnPhrasesFirstIs423() throws MVELTranslationException {
    // Arrange and Act
    Group actualCreateGroupsResult = groupingTranslator.createGroups("\t\t42");

    // Assert
    List<String> phrases = actualCreateGroupsResult.getPhrases();
    assertEquals(1, phrases.size());
    assertEquals("42", phrases.get(0));
    assertEquals(BLCOperator.AND, actualCreateGroupsResult.getOperatorType());
    assertTrue(actualCreateGroupsResult.getSubGroups().isEmpty());
  }

  /**
   * Test {@link GroupingTranslator#createGroups(String)}.
   * <ul>
   *   <li>When {@code &&42}.</li>
   *   <li>Then return Phrases first is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  public void testCreateGroups_when42_thenReturnPhrasesFirstIs424() throws MVELTranslationException {
    // Arrange and Act
    Group actualCreateGroupsResult = groupingTranslator.createGroups("\t&&42");

    // Assert
    List<String> phrases = actualCreateGroupsResult.getPhrases();
    assertEquals(1, phrases.size());
    assertEquals("42", phrases.get(0));
    assertEquals(BLCOperator.AND, actualCreateGroupsResult.getOperatorType());
    assertTrue(actualCreateGroupsResult.getSubGroups().isEmpty());
  }

  /**
   * Test {@link GroupingTranslator#createGroups(String)}.
   * <ul>
   *   <li>When {@code ;42}.</li>
   *   <li>Then throw {@link MVELTranslationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  public void testCreateGroups_when42_thenThrowMVELTranslationException() throws MVELTranslationException {
    // Arrange, Act and Assert
    assertThrows(MVELTranslationException.class, () -> groupingTranslator.createGroups("\t;42"));
    assertThrows(MVELTranslationException.class, () -> groupingTranslator.createGroups("\t(42"));
  }

  /**
   * Test {@link GroupingTranslator#createGroups(String)}.
   * <ul>
   *   <li>When {@code &&&&}.</li>
   *   <li>Then return Phrases Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  public void testCreateGroups_whenAmpersandAmpersandAmpersandAmpersand_thenReturnPhrasesEmpty()
      throws MVELTranslationException {
    // Arrange and Act
    Group actualCreateGroupsResult = groupingTranslator.createGroups("\t&&&&");

    // Assert
    assertEquals(BLCOperator.AND, actualCreateGroupsResult.getOperatorType());
    assertTrue(actualCreateGroupsResult.getPhrases().isEmpty());
    assertTrue(actualCreateGroupsResult.getSubGroups().isEmpty());
    assertTrue(actualCreateGroupsResult.getIsTopGroup());
  }

  /**
   * Test {@link GroupingTranslator#createGroups(String)}.
   * <ul>
   *   <li>When {@code &&(}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  public void testCreateGroups_whenAmpersandAmpersandLeftParenthesis() throws MVELTranslationException {
    // Arrange, Act and Assert
    assertThrows(MVELTranslationException.class, () -> groupingTranslator.createGroups("&&("));
    assertThrows(MVELTranslationException.class, () -> groupingTranslator.createGroups("\t&&("));
  }

  /**
   * Test {@link GroupingTranslator#createGroups(String)}.
   * <ul>
   *   <li>When {@code &&)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  public void testCreateGroups_whenAmpersandAmpersandRightParenthesis() throws MVELTranslationException {
    // Arrange and Act
    Group actualCreateGroupsResult = groupingTranslator.createGroups("\t&&)");

    // Assert
    List<String> phrases = actualCreateGroupsResult.getPhrases();
    assertEquals(1, phrases.size());
    assertEquals(BLCOperator.AND, actualCreateGroupsResult.getOperatorType());
    assertTrue(actualCreateGroupsResult.getSubGroups().isEmpty());
    assertEquals(GroupingTranslator.GROUPENDCHAR, phrases.get(0));
  }

  /**
   * Test {@link GroupingTranslator#createGroups(String)}.
   * <ul>
   *   <li>When {@code &&;}.</li>
   *   <li>Then return Phrases Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  public void testCreateGroups_whenAmpersandAmpersandSemicolon_thenReturnPhrasesEmpty()
      throws MVELTranslationException {
    // Arrange and Act
    Group actualCreateGroupsResult = groupingTranslator.createGroups("\t&&;");

    // Assert
    assertEquals(BLCOperator.AND, actualCreateGroupsResult.getOperatorType());
    assertTrue(actualCreateGroupsResult.getPhrases().isEmpty());
    assertTrue(actualCreateGroupsResult.getSubGroups().isEmpty());
    assertTrue(actualCreateGroupsResult.getIsTopGroup());
  }

  /**
   * Test {@link GroupingTranslator#createGroups(String)}.
   * <ul>
   *   <li>When {@code &&}.</li>
   *   <li>Then return Phrases Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  public void testCreateGroups_whenAmpersandAmpersand_thenReturnPhrasesEmpty() throws MVELTranslationException {
    // Arrange and Act
    Group actualCreateGroupsResult = groupingTranslator.createGroups("&&");

    // Assert
    assertEquals(BLCOperator.AND, actualCreateGroupsResult.getOperatorType());
    assertTrue(actualCreateGroupsResult.getPhrases().isEmpty());
    assertTrue(actualCreateGroupsResult.getSubGroups().isEmpty());
    assertTrue(actualCreateGroupsResult.getIsTopGroup());
  }

  /**
   * Test {@link GroupingTranslator#createGroups(String)}.
   * <ul>
   *   <li>When {@code &&}.</li>
   *   <li>Then return Phrases Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  public void testCreateGroups_whenAmpersandAmpersand_thenReturnPhrasesEmpty2() throws MVELTranslationException {
    // Arrange and Act
    Group actualCreateGroupsResult = groupingTranslator.createGroups("\t&&");

    // Assert
    assertEquals(BLCOperator.AND, actualCreateGroupsResult.getOperatorType());
    assertTrue(actualCreateGroupsResult.getPhrases().isEmpty());
    assertTrue(actualCreateGroupsResult.getSubGroups().isEmpty());
    assertTrue(actualCreateGroupsResult.getIsTopGroup());
  }

  /**
   * Test {@link GroupingTranslator#createGroups(String)}.
   * <ul>
   *   <li>When {@code &&}.</li>
   *   <li>Then return Phrases Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  public void testCreateGroups_whenAmpersandAmpersand_thenReturnPhrasesEmpty3() throws MVELTranslationException {
    // Arrange and Act
    Group actualCreateGroupsResult = groupingTranslator.createGroups("&&\t");

    // Assert
    assertEquals(BLCOperator.AND, actualCreateGroupsResult.getOperatorType());
    assertTrue(actualCreateGroupsResult.getPhrases().isEmpty());
    assertTrue(actualCreateGroupsResult.getSubGroups().isEmpty());
    assertTrue(actualCreateGroupsResult.getIsTopGroup());
  }

  /**
   * Test {@link GroupingTranslator#createGroups(String)}.
   * <ul>
   *   <li>When {@code &&}.</li>
   *   <li>Then return Phrases Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  public void testCreateGroups_whenAmpersandAmpersand_thenReturnPhrasesEmpty4() throws MVELTranslationException {
    // Arrange and Act
    Group actualCreateGroupsResult = groupingTranslator.createGroups("\t\t&&");

    // Assert
    assertEquals(BLCOperator.AND, actualCreateGroupsResult.getOperatorType());
    assertTrue(actualCreateGroupsResult.getPhrases().isEmpty());
    assertTrue(actualCreateGroupsResult.getSubGroups().isEmpty());
    assertTrue(actualCreateGroupsResult.getIsTopGroup());
  }

  /**
   * Test {@link GroupingTranslator#createGroups(String)}.
   * <ul>
   *   <li>When {@code &&}.</li>
   *   <li>Then return Phrases Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  public void testCreateGroups_whenAmpersandAmpersand_thenReturnPhrasesEmpty5() throws MVELTranslationException {
    // Arrange and Act
    Group actualCreateGroupsResult = groupingTranslator.createGroups("\t&&\t");

    // Assert
    assertEquals(BLCOperator.AND, actualCreateGroupsResult.getOperatorType());
    assertTrue(actualCreateGroupsResult.getPhrases().isEmpty());
    assertTrue(actualCreateGroupsResult.getSubGroups().isEmpty());
    assertTrue(actualCreateGroupsResult.getIsTopGroup());
  }

  /**
   * Test {@link GroupingTranslator#createGroups(String)}.
   * <ul>
   *   <li>When {@code \|\|}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  public void testCreateGroups_whenBackslashVerticalLineBackslashVerticalLine() throws MVELTranslationException {
    // Arrange and Act
    Group actualCreateGroupsResult = groupingTranslator.createGroups("\t\\|\\|");

    // Assert
    List<String> phrases = actualCreateGroupsResult.getPhrases();
    assertEquals(1, phrases.size());
    assertEquals("\\|\\|", phrases.get(0));
    assertEquals(BLCOperator.AND, actualCreateGroupsResult.getOperatorType());
    assertTrue(actualCreateGroupsResult.getSubGroups().isEmpty());
  }

  /**
   * Test {@link GroupingTranslator#createGroups(String)}.
   * <ul>
   *   <li>When {@code \|\|}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  public void testCreateGroups_whenBackslashVerticalLineBackslashVerticalLine2() throws MVELTranslationException {
    // Arrange and Act
    Group actualCreateGroupsResult = groupingTranslator.createGroups("\\|\\|\t");

    // Assert
    List<String> phrases = actualCreateGroupsResult.getPhrases();
    assertEquals(1, phrases.size());
    assertEquals("\\|\\|", phrases.get(0));
    assertEquals(BLCOperator.AND, actualCreateGroupsResult.getOperatorType());
    assertTrue(actualCreateGroupsResult.getSubGroups().isEmpty());
  }

  /**
   * Test {@link GroupingTranslator#createGroups(String)}.
   * <ul>
   *   <li>When {@code \|\|}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  public void testCreateGroups_whenBackslashVerticalLineBackslashVerticalLine3() throws MVELTranslationException {
    // Arrange and Act
    Group actualCreateGroupsResult = groupingTranslator.createGroups("\t\t\\|\\|");

    // Assert
    List<String> phrases = actualCreateGroupsResult.getPhrases();
    assertEquals(1, phrases.size());
    assertEquals("\\|\\|", phrases.get(0));
    assertEquals(BLCOperator.AND, actualCreateGroupsResult.getOperatorType());
    assertTrue(actualCreateGroupsResult.getSubGroups().isEmpty());
  }

  /**
   * Test {@link GroupingTranslator#createGroups(String)}.
   * <ul>
   *   <li>When {@code \|\|(}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  public void testCreateGroups_whenBackslashVerticalLineBackslashVerticalLineLeftParenthesis()
      throws MVELTranslationException {
    // Arrange, Act and Assert
    assertThrows(MVELTranslationException.class, () -> groupingTranslator.createGroups("\\|\\|("));
  }

  /**
   * Test {@link GroupingTranslator#createGroups(String)}.
   * <ul>
   *   <li>When {@link GroupingTranslator#GROUPSTARTCHAR}.</li>
   *   <li>Then throw {@link MVELTranslationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  public void testCreateGroups_whenGroupstartchar_thenThrowMVELTranslationException() throws MVELTranslationException {
    // Arrange, Act and Assert
    assertThrows(MVELTranslationException.class,
        () -> groupingTranslator.createGroups(GroupingTranslator.GROUPSTARTCHAR));
  }

  /**
   * Test {@link GroupingTranslator#createGroups(String)}.
   * <ul>
   *   <li>When {@code (&&}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  public void testCreateGroups_whenLeftParenthesisAmpersandAmpersand() throws MVELTranslationException {
    // Arrange, Act and Assert
    assertThrows(MVELTranslationException.class, () -> groupingTranslator.createGroups("\t(&&"));
  }

  /**
   * Test {@link GroupingTranslator#createGroups(String)}.
   * <ul>
   *   <li>When {@code (\|\|}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  public void testCreateGroups_whenLeftParenthesisBackslashVerticalLineBackslashVerticalLine()
      throws MVELTranslationException {
    // Arrange, Act and Assert
    assertThrows(MVELTranslationException.class, () -> groupingTranslator.createGroups("\t(\\|\\|"));
  }

  /**
   * Test {@link GroupingTranslator#createGroups(String)}.
   * <ul>
   *   <li>When {@code ((}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  public void testCreateGroups_whenLeftParenthesisLeftParenthesis() throws MVELTranslationException {
    // Arrange, Act and Assert
    assertThrows(MVELTranslationException.class, () -> groupingTranslator.createGroups("\t(("));
  }

  /**
   * Test {@link GroupingTranslator#createGroups(String)}.
   * <ul>
   *   <li>When {@code (;}.</li>
   *   <li>Then throw {@link MVELTranslationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  public void testCreateGroups_whenLeftParenthesisSemicolon_thenThrowMVELTranslationException()
      throws MVELTranslationException {
    // Arrange, Act and Assert
    assertThrows(MVELTranslationException.class, () -> groupingTranslator.createGroups("\t(;"));
  }

  /**
   * Test {@link GroupingTranslator#createGroups(String)}.
   * <ul>
   *   <li>When {@code (||}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  public void testCreateGroups_whenLeftParenthesisVerticalLineVerticalLine() throws MVELTranslationException {
    // Arrange, Act and Assert
    assertThrows(MVELTranslationException.class, () -> groupingTranslator.createGroups("\t(||"));
  }

  /**
   * Test {@link GroupingTranslator#createGroups(String)}.
   * <ul>
   *   <li>When {@code (}.</li>
   *   <li>Then throw {@link MVELTranslationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  public void testCreateGroups_whenLeftParenthesis_thenThrowMVELTranslationException() throws MVELTranslationException {
    // Arrange, Act and Assert
    assertThrows(MVELTranslationException.class, () -> groupingTranslator.createGroups("\t("));
    assertThrows(MVELTranslationException.class, () -> groupingTranslator.createGroups("(\t"));
    assertThrows(MVELTranslationException.class, () -> groupingTranslator.createGroups("\t\t("));
    assertThrows(MVELTranslationException.class, () -> groupingTranslator.createGroups("\t(\t"));
  }

  /**
   * Test {@link GroupingTranslator#createGroups(String)}.
   * <ul>
   *   <li>When {@code Mvel[\t\n\r]}.</li>
   *   <li>Then return Phrases first is {@code Mvel[\t\n\r]}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  public void testCreateGroups_whenMvelTNR_thenReturnPhrasesFirstIsMvelTNR() throws MVELTranslationException {
    // Arrange and Act
    Group actualCreateGroupsResult = groupingTranslator.createGroups("\tMvel[\\t\\n\\r]");

    // Assert
    List<String> phrases = actualCreateGroupsResult.getPhrases();
    assertEquals(1, phrases.size());
    assertEquals("Mvel[\\t\\n\\r]", phrases.get(0));
    assertEquals(BLCOperator.AND, actualCreateGroupsResult.getOperatorType());
    assertTrue(actualCreateGroupsResult.getSubGroups().isEmpty());
  }

  /**
   * Test {@link GroupingTranslator#createGroups(String)}.
   * <ul>
   *   <li>When {@code Mvel}.</li>
   *   <li>Then return Phrases first is {@code Mvel}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  public void testCreateGroups_whenMvel_thenReturnPhrasesFirstIsMvel() throws MVELTranslationException {
    // Arrange and Act
    Group actualCreateGroupsResult = groupingTranslator.createGroups("Mvel");

    // Assert
    List<String> phrases = actualCreateGroupsResult.getPhrases();
    assertEquals(1, phrases.size());
    assertEquals("Mvel", phrases.get(0));
    assertEquals(BLCOperator.AND, actualCreateGroupsResult.getOperatorType());
    assertTrue(actualCreateGroupsResult.getSubGroups().isEmpty());
  }

  /**
   * Test {@link GroupingTranslator#createGroups(String)}.
   * <ul>
   *   <li>When {@code Mvel}.</li>
   *   <li>Then return Phrases first is {@code Mvel}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  public void testCreateGroups_whenMvel_thenReturnPhrasesFirstIsMvel2() throws MVELTranslationException {
    // Arrange and Act
    Group actualCreateGroupsResult = groupingTranslator.createGroups("\tMvel");

    // Assert
    List<String> phrases = actualCreateGroupsResult.getPhrases();
    assertEquals(1, phrases.size());
    assertEquals("Mvel", phrases.get(0));
    assertEquals(BLCOperator.AND, actualCreateGroupsResult.getOperatorType());
    assertTrue(actualCreateGroupsResult.getSubGroups().isEmpty());
  }

  /**
   * Test {@link GroupingTranslator#createGroups(String)}.
   * <ul>
   *   <li>When {@code Mvel}.</li>
   *   <li>Then return Phrases first is {@code Mvel}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  public void testCreateGroups_whenMvel_thenReturnPhrasesFirstIsMvel3() throws MVELTranslationException {
    // Arrange and Act
    Group actualCreateGroupsResult = groupingTranslator.createGroups("Mvel\t");

    // Assert
    List<String> phrases = actualCreateGroupsResult.getPhrases();
    assertEquals(1, phrases.size());
    assertEquals("Mvel", phrases.get(0));
    assertEquals(BLCOperator.AND, actualCreateGroupsResult.getOperatorType());
    assertTrue(actualCreateGroupsResult.getSubGroups().isEmpty());
  }

  /**
   * Test {@link GroupingTranslator#createGroups(String)}.
   * <ul>
   *   <li>When {@code Mvel}.</li>
   *   <li>Then return Phrases first is {@code Mvel}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  public void testCreateGroups_whenMvel_thenReturnPhrasesFirstIsMvel4() throws MVELTranslationException {
    // Arrange and Act
    Group actualCreateGroupsResult = groupingTranslator.createGroups("\t\tMvel");

    // Assert
    List<String> phrases = actualCreateGroupsResult.getPhrases();
    assertEquals(1, phrases.size());
    assertEquals("Mvel", phrases.get(0));
    assertEquals(BLCOperator.AND, actualCreateGroupsResult.getOperatorType());
    assertTrue(actualCreateGroupsResult.getSubGroups().isEmpty());
  }

  /**
   * Test {@link GroupingTranslator#createGroups(String)}.
   * <ul>
   *   <li>When {@code &&Mvel}.</li>
   *   <li>Then return Phrases first is {@code Mvel}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  public void testCreateGroups_whenMvel_thenReturnPhrasesFirstIsMvel5() throws MVELTranslationException {
    // Arrange and Act
    Group actualCreateGroupsResult = groupingTranslator.createGroups("\t&&Mvel");

    // Assert
    List<String> phrases = actualCreateGroupsResult.getPhrases();
    assertEquals(1, phrases.size());
    assertEquals("Mvel", phrases.get(0));
    assertEquals(BLCOperator.AND, actualCreateGroupsResult.getOperatorType());
    assertTrue(actualCreateGroupsResult.getSubGroups().isEmpty());
  }

  /**
   * Test {@link GroupingTranslator#createGroups(String)}.
   * <ul>
   *   <li>When {@code Mvel}.</li>
   *   <li>Then return Phrases first is {@code Mvel}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  public void testCreateGroups_whenMvel_thenReturnPhrasesFirstIsMvel6() throws MVELTranslationException {
    // Arrange and Act
    Group actualCreateGroupsResult = groupingTranslator.createGroups("\tMvel\t");

    // Assert
    List<String> phrases = actualCreateGroupsResult.getPhrases();
    assertEquals(1, phrases.size());
    assertEquals("Mvel", phrases.get(0));
    assertEquals(BLCOperator.AND, actualCreateGroupsResult.getOperatorType());
    assertTrue(actualCreateGroupsResult.getSubGroups().isEmpty());
  }

  /**
   * Test {@link GroupingTranslator#createGroups(String)}.
   * <ul>
   *   <li>When {@code Mvel;}.</li>
   *   <li>Then return Phrases first is {@code Mvel}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  public void testCreateGroups_whenMvel_thenReturnPhrasesFirstIsMvel7() throws MVELTranslationException {
    // Arrange and Act
    Group actualCreateGroupsResult = groupingTranslator.createGroups("\tMvel;");

    // Assert
    List<String> phrases = actualCreateGroupsResult.getPhrases();
    assertEquals(1, phrases.size());
    assertEquals("Mvel", phrases.get(0));
    assertEquals(BLCOperator.AND, actualCreateGroupsResult.getOperatorType());
    assertTrue(actualCreateGroupsResult.getSubGroups().isEmpty());
  }

  /**
   * Test {@link GroupingTranslator#createGroups(String)}.
   * <ul>
   *   <li>When {@code Mvel(}.</li>
   *   <li>Then return Phrases first is {@code Mvel(}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  public void testCreateGroups_whenMvel_thenReturnPhrasesFirstIsMvel8() throws MVELTranslationException {
    // Arrange and Act
    Group actualCreateGroupsResult = groupingTranslator.createGroups("\tMvel(");

    // Assert
    List<String> phrases = actualCreateGroupsResult.getPhrases();
    assertEquals(1, phrases.size());
    assertEquals("Mvel(", phrases.get(0));
    assertEquals(BLCOperator.AND, actualCreateGroupsResult.getOperatorType());
    assertTrue(actualCreateGroupsResult.getSubGroups().isEmpty());
  }

  /**
   * Test {@link GroupingTranslator#createGroups(String)}.
   * <ul>
   *   <li>When {@code ;Mvel}.</li>
   *   <li>Then throw {@link MVELTranslationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  public void testCreateGroups_whenMvel_thenThrowMVELTranslationException() throws MVELTranslationException {
    // Arrange, Act and Assert
    assertThrows(MVELTranslationException.class, () -> groupingTranslator.createGroups("\t;Mvel"));
    assertThrows(MVELTranslationException.class, () -> groupingTranslator.createGroups("\t(Mvel"));
  }

  /**
   * Test {@link GroupingTranslator#createGroups(String)}.
   * <ul>
   *   <li>When {@code )}.</li>
   *   <li>Then return Phrases first is
   * {@link GroupingTranslator#GROUPENDCHAR}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  public void testCreateGroups_whenRightParenthesis_thenReturnPhrasesFirstIsGroupendchar()
      throws MVELTranslationException {
    // Arrange and Act
    Group actualCreateGroupsResult = groupingTranslator.createGroups("\t)");

    // Assert
    List<String> phrases = actualCreateGroupsResult.getPhrases();
    assertEquals(1, phrases.size());
    assertEquals(BLCOperator.AND, actualCreateGroupsResult.getOperatorType());
    assertTrue(actualCreateGroupsResult.getSubGroups().isEmpty());
    assertEquals(GroupingTranslator.GROUPENDCHAR, phrases.get(0));
  }

  /**
   * Test {@link GroupingTranslator#createGroups(String)}.
   * <ul>
   *   <li>When {@code )}.</li>
   *   <li>Then return Phrases first is
   * {@link GroupingTranslator#GROUPENDCHAR}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  public void testCreateGroups_whenRightParenthesis_thenReturnPhrasesFirstIsGroupendchar2()
      throws MVELTranslationException {
    // Arrange and Act
    Group actualCreateGroupsResult = groupingTranslator.createGroups(")\t");

    // Assert
    List<String> phrases = actualCreateGroupsResult.getPhrases();
    assertEquals(1, phrases.size());
    assertEquals(BLCOperator.AND, actualCreateGroupsResult.getOperatorType());
    assertTrue(actualCreateGroupsResult.getSubGroups().isEmpty());
    assertEquals(GroupingTranslator.GROUPENDCHAR, phrases.get(0));
  }

  /**
   * Test {@link GroupingTranslator#createGroups(String)}.
   * <ul>
   *   <li>When {@code )}.</li>
   *   <li>Then return Phrases first is
   * {@link GroupingTranslator#GROUPENDCHAR}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  public void testCreateGroups_whenRightParenthesis_thenReturnPhrasesFirstIsGroupendchar3()
      throws MVELTranslationException {
    // Arrange and Act
    Group actualCreateGroupsResult = groupingTranslator.createGroups("\t\t)");

    // Assert
    List<String> phrases = actualCreateGroupsResult.getPhrases();
    assertEquals(1, phrases.size());
    assertEquals(BLCOperator.AND, actualCreateGroupsResult.getOperatorType());
    assertTrue(actualCreateGroupsResult.getSubGroups().isEmpty());
    assertEquals(GroupingTranslator.GROUPENDCHAR, phrases.get(0));
  }

  /**
   * Test {@link GroupingTranslator#createGroups(String)}.
   * <ul>
   *   <li>When {@code ;&&}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  public void testCreateGroups_whenSemicolonAmpersandAmpersand() throws MVELTranslationException {
    // Arrange, Act and Assert
    assertThrows(MVELTranslationException.class, () -> groupingTranslator.createGroups("\t;&&"));
  }

  /**
   * Test {@link GroupingTranslator#createGroups(String)}.
   * <ul>
   *   <li>When {@code ;\|\|}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  public void testCreateGroups_whenSemicolonBackslashVerticalLineBackslashVerticalLine()
      throws MVELTranslationException {
    // Arrange, Act and Assert
    assertThrows(MVELTranslationException.class, () -> groupingTranslator.createGroups("\t;\\|\\|"));
  }

  /**
   * Test {@link GroupingTranslator#createGroups(String)}.
   * <ul>
   *   <li>When {@code ;(}.</li>
   *   <li>Then throw {@link MVELTranslationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  public void testCreateGroups_whenSemicolonLeftParenthesis_thenThrowMVELTranslationException()
      throws MVELTranslationException {
    // Arrange, Act and Assert
    assertThrows(MVELTranslationException.class, () -> groupingTranslator.createGroups("\t;("));
  }

  /**
   * Test {@link GroupingTranslator#createGroups(String)}.
   * <ul>
   *   <li>When {@code ;)}.</li>
   *   <li>Then throw {@link MVELTranslationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  public void testCreateGroups_whenSemicolonRightParenthesis_thenThrowMVELTranslationException()
      throws MVELTranslationException {
    // Arrange, Act and Assert
    assertThrows(MVELTranslationException.class, () -> groupingTranslator.createGroups("\t;)"));
  }

  /**
   * Test {@link GroupingTranslator#createGroups(String)}.
   * <ul>
   *   <li>When {@code ;||}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  public void testCreateGroups_whenSemicolonVerticalLineVerticalLine() throws MVELTranslationException {
    // Arrange, Act and Assert
    assertThrows(MVELTranslationException.class, () -> groupingTranslator.createGroups("\t;||"));
  }

  /**
   * Test {@link GroupingTranslator#createGroups(String)}.
   * <ul>
   *   <li>When {@code [\t\n\r]42}.</li>
   *   <li>Then return Phrases first is {@code [\t\n\r]42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  public void testCreateGroups_whenTNR42_thenReturnPhrasesFirstIsTNR42() throws MVELTranslationException {
    // Arrange and Act
    Group actualCreateGroupsResult = groupingTranslator.createGroups("\t[\\t\\n\\r]42");

    // Assert
    List<String> phrases = actualCreateGroupsResult.getPhrases();
    assertEquals(1, phrases.size());
    assertEquals("[\\t\\n\\r]42", phrases.get(0));
    assertEquals(BLCOperator.AND, actualCreateGroupsResult.getOperatorType());
    assertTrue(actualCreateGroupsResult.getSubGroups().isEmpty());
  }

  /**
   * Test {@link GroupingTranslator#createGroups(String)}.
   * <ul>
   *   <li>When {@code [\t\n\r]Mvel}.</li>
   *   <li>Then return Phrases first is {@code [\t\n\r]Mvel}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  public void testCreateGroups_whenTNRMvel_thenReturnPhrasesFirstIsTNRMvel() throws MVELTranslationException {
    // Arrange and Act
    Group actualCreateGroupsResult = groupingTranslator.createGroups("\t[\\t\\n\\r]Mvel");

    // Assert
    List<String> phrases = actualCreateGroupsResult.getPhrases();
    assertEquals(1, phrases.size());
    assertEquals("[\\t\\n\\r]Mvel", phrases.get(0));
    assertEquals(BLCOperator.AND, actualCreateGroupsResult.getOperatorType());
    assertTrue(actualCreateGroupsResult.getSubGroups().isEmpty());
  }

  /**
   * Test {@link GroupingTranslator#createGroups(String)}.
   * <ul>
   *   <li>When {@code [\t\n\r][\t\n\r]}.</li>
   *   <li>Then return Phrases first is {@code [\t\n\r][\t\n\r]}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  public void testCreateGroups_whenTNRTNR_thenReturnPhrasesFirstIsTNRTNR() throws MVELTranslationException {
    // Arrange and Act
    Group actualCreateGroupsResult = groupingTranslator.createGroups("\t[\\t\\n\\r][\\t\\n\\r]");

    // Assert
    List<String> phrases = actualCreateGroupsResult.getPhrases();
    assertEquals(1, phrases.size());
    assertEquals("[\\t\\n\\r][\\t\\n\\r]", phrases.get(0));
    assertEquals(BLCOperator.AND, actualCreateGroupsResult.getOperatorType());
    assertTrue(actualCreateGroupsResult.getSubGroups().isEmpty());
  }

  /**
   * Test {@link GroupingTranslator#createGroups(String)}.
   * <ul>
   *   <li>When {@code [\t\n\r]||}.</li>
   *   <li>Then return OperatorType is {@code OR}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  public void testCreateGroups_whenTNR_thenReturnOperatorTypeIsOr() throws MVELTranslationException {
    // Arrange and Act
    Group actualCreateGroupsResult = groupingTranslator.createGroups("\t[\\t\\n\\r]||");

    // Assert
    List<String> phrases = actualCreateGroupsResult.getPhrases();
    assertEquals(1, phrases.size());
    assertEquals("[\\t\\n\\r]", phrases.get(0));
    assertEquals(BLCOperator.OR, actualCreateGroupsResult.getOperatorType());
    assertTrue(actualCreateGroupsResult.getSubGroups().isEmpty());
  }

  /**
   * Test {@link GroupingTranslator#createGroups(String)}.
   * <ul>
   *   <li>When {@code [\t\n\r]}.</li>
   *   <li>Then return Phrases first is {@code [\t\n\r]}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  public void testCreateGroups_whenTNR_thenReturnPhrasesFirstIsTNR() throws MVELTranslationException {
    // Arrange and Act
    Group actualCreateGroupsResult = groupingTranslator.createGroups("\t[\\t\\n\\r]");

    // Assert
    List<String> phrases = actualCreateGroupsResult.getPhrases();
    assertEquals(1, phrases.size());
    assertEquals("[\\t\\n\\r]", phrases.get(0));
    assertEquals(BLCOperator.AND, actualCreateGroupsResult.getOperatorType());
    assertTrue(actualCreateGroupsResult.getSubGroups().isEmpty());
  }

  /**
   * Test {@link GroupingTranslator#createGroups(String)}.
   * <ul>
   *   <li>When {@code [\t\n\r]}.</li>
   *   <li>Then return Phrases first is {@code [\t\n\r]}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  public void testCreateGroups_whenTNR_thenReturnPhrasesFirstIsTNR2() throws MVELTranslationException {
    // Arrange and Act
    Group actualCreateGroupsResult = groupingTranslator.createGroups("[\\t\\n\\r]\t");

    // Assert
    List<String> phrases = actualCreateGroupsResult.getPhrases();
    assertEquals(1, phrases.size());
    assertEquals("[\\t\\n\\r]", phrases.get(0));
    assertEquals(BLCOperator.AND, actualCreateGroupsResult.getOperatorType());
    assertTrue(actualCreateGroupsResult.getSubGroups().isEmpty());
  }

  /**
   * Test {@link GroupingTranslator#createGroups(String)}.
   * <ul>
   *   <li>When {@code [\t\n\r](}.</li>
   *   <li>Then return Phrases first is {@code [\t\n\r](}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  public void testCreateGroups_whenTNR_thenReturnPhrasesFirstIsTNR3() throws MVELTranslationException {
    // Arrange and Act
    Group actualCreateGroupsResult = groupingTranslator.createGroups("[\\t\\n\\r](");

    // Assert
    List<String> phrases = actualCreateGroupsResult.getPhrases();
    assertEquals(1, phrases.size());
    assertEquals("[\\t\\n\\r](", phrases.get(0));
    assertEquals(BLCOperator.AND, actualCreateGroupsResult.getOperatorType());
    assertTrue(actualCreateGroupsResult.getSubGroups().isEmpty());
  }

  /**
   * Test {@link GroupingTranslator#createGroups(String)}.
   * <ul>
   *   <li>When {@code &&[\t\n\r]}.</li>
   *   <li>Then return Phrases first is {@code [\t\n\r]}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  public void testCreateGroups_whenTNR_thenReturnPhrasesFirstIsTNR4() throws MVELTranslationException {
    // Arrange and Act
    Group actualCreateGroupsResult = groupingTranslator.createGroups("&&[\\t\\n\\r]");

    // Assert
    List<String> phrases = actualCreateGroupsResult.getPhrases();
    assertEquals(1, phrases.size());
    assertEquals("[\\t\\n\\r]", phrases.get(0));
    assertEquals(BLCOperator.AND, actualCreateGroupsResult.getOperatorType());
    assertTrue(actualCreateGroupsResult.getSubGroups().isEmpty());
  }

  /**
   * Test {@link GroupingTranslator#createGroups(String)}.
   * <ul>
   *   <li>When {@code [\t\n\r]}.</li>
   *   <li>Then return Phrases first is {@code [\t\n\r]}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  public void testCreateGroups_whenTNR_thenReturnPhrasesFirstIsTNR5() throws MVELTranslationException {
    // Arrange and Act
    Group actualCreateGroupsResult = groupingTranslator.createGroups("\t\t[\\t\\n\\r]");

    // Assert
    List<String> phrases = actualCreateGroupsResult.getPhrases();
    assertEquals(1, phrases.size());
    assertEquals("[\\t\\n\\r]", phrases.get(0));
    assertEquals(BLCOperator.AND, actualCreateGroupsResult.getOperatorType());
    assertTrue(actualCreateGroupsResult.getSubGroups().isEmpty());
  }

  /**
   * Test {@link GroupingTranslator#createGroups(String)}.
   * <ul>
   *   <li>When {@code [\t\n\r]}.</li>
   *   <li>Then return Phrases first is {@code [\t\n\r]}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  public void testCreateGroups_whenTNR_thenReturnPhrasesFirstIsTNR6() throws MVELTranslationException {
    // Arrange and Act
    Group actualCreateGroupsResult = groupingTranslator.createGroups("\t[\\t\\n\\r]\t");

    // Assert
    List<String> phrases = actualCreateGroupsResult.getPhrases();
    assertEquals(1, phrases.size());
    assertEquals("[\\t\\n\\r]", phrases.get(0));
    assertEquals(BLCOperator.AND, actualCreateGroupsResult.getOperatorType());
    assertTrue(actualCreateGroupsResult.getSubGroups().isEmpty());
  }

  /**
   * Test {@link GroupingTranslator#createGroups(String)}.
   * <ul>
   *   <li>When {@code [\t\n\r];}.</li>
   *   <li>Then return Phrases first is {@code [\t\n\r]}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  public void testCreateGroups_whenTNR_thenReturnPhrasesFirstIsTNR7() throws MVELTranslationException {
    // Arrange and Act
    Group actualCreateGroupsResult = groupingTranslator.createGroups("\t[\\t\\n\\r];");

    // Assert
    List<String> phrases = actualCreateGroupsResult.getPhrases();
    assertEquals(1, phrases.size());
    assertEquals("[\\t\\n\\r]", phrases.get(0));
    assertEquals(BLCOperator.AND, actualCreateGroupsResult.getOperatorType());
    assertTrue(actualCreateGroupsResult.getSubGroups().isEmpty());
  }

  /**
   * Test {@link GroupingTranslator#createGroups(String)}.
   * <ul>
   *   <li>When {@code [\t\n\r](}.</li>
   *   <li>Then return Phrases first is {@code [\t\n\r](}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  public void testCreateGroups_whenTNR_thenReturnPhrasesFirstIsTNR8() throws MVELTranslationException {
    // Arrange and Act
    Group actualCreateGroupsResult = groupingTranslator.createGroups("\t[\\t\\n\\r](");

    // Assert
    List<String> phrases = actualCreateGroupsResult.getPhrases();
    assertEquals(1, phrases.size());
    assertEquals("[\\t\\n\\r](", phrases.get(0));
    assertEquals(BLCOperator.AND, actualCreateGroupsResult.getOperatorType());
    assertTrue(actualCreateGroupsResult.getSubGroups().isEmpty());
  }

  /**
   * Test {@link GroupingTranslator#createGroups(String)}.
   * <ul>
   *   <li>When {@code [\t\n\r]&&}.</li>
   *   <li>Then return Phrases first is {@code [\t\n\r]}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  public void testCreateGroups_whenTNR_thenReturnPhrasesFirstIsTNR9() throws MVELTranslationException {
    // Arrange and Act
    Group actualCreateGroupsResult = groupingTranslator.createGroups("\t[\\t\\n\\r]&&");

    // Assert
    List<String> phrases = actualCreateGroupsResult.getPhrases();
    assertEquals(1, phrases.size());
    assertEquals("[\\t\\n\\r]", phrases.get(0));
    assertEquals(BLCOperator.AND, actualCreateGroupsResult.getOperatorType());
    assertTrue(actualCreateGroupsResult.getSubGroups().isEmpty());
  }

  /**
   * Test {@link GroupingTranslator#createGroups(String)}.
   * <ul>
   *   <li>When {@code [\t\n\r]\|\|}.</li>
   *   <li>Then return Phrases first is {@code [\t\n\r]\|\|}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  public void testCreateGroups_whenTNR_thenReturnPhrasesFirstIsTNR10() throws MVELTranslationException {
    // Arrange and Act
    Group actualCreateGroupsResult = groupingTranslator.createGroups("\t[\\t\\n\\r]\\|\\|");

    // Assert
    List<String> phrases = actualCreateGroupsResult.getPhrases();
    assertEquals(1, phrases.size());
    assertEquals("[\\t\\n\\r]\\|\\|", phrases.get(0));
    assertEquals(BLCOperator.AND, actualCreateGroupsResult.getOperatorType());
    assertTrue(actualCreateGroupsResult.getSubGroups().isEmpty());
  }

  /**
   * Test {@link GroupingTranslator#createGroups(String)}.
   * <ul>
   *   <li>When {@code [\t\n\r])}.</li>
   *   <li>Then return Phrases first is {@code [\t\n\r])}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  public void testCreateGroups_whenTNR_thenReturnPhrasesFirstIsTNR11() throws MVELTranslationException {
    // Arrange and Act
    Group actualCreateGroupsResult = groupingTranslator.createGroups("\t[\\t\\n\\r])");

    // Assert
    List<String> phrases = actualCreateGroupsResult.getPhrases();
    assertEquals(1, phrases.size());
    assertEquals("[\\t\\n\\r])", phrases.get(0));
    assertEquals(BLCOperator.AND, actualCreateGroupsResult.getOperatorType());
    assertTrue(actualCreateGroupsResult.getSubGroups().isEmpty());
  }

  /**
   * Test {@link GroupingTranslator#createGroups(String)}.
   * <ul>
   *   <li>When {@code &&[\t\n\r]}.</li>
   *   <li>Then return Phrases first is {@code [\t\n\r]}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  public void testCreateGroups_whenTNR_thenReturnPhrasesFirstIsTNR12() throws MVELTranslationException {
    // Arrange and Act
    Group actualCreateGroupsResult = groupingTranslator.createGroups("\t&&[\\t\\n\\r]");

    // Assert
    List<String> phrases = actualCreateGroupsResult.getPhrases();
    assertEquals(1, phrases.size());
    assertEquals("[\\t\\n\\r]", phrases.get(0));
    assertEquals(BLCOperator.AND, actualCreateGroupsResult.getOperatorType());
    assertTrue(actualCreateGroupsResult.getSubGroups().isEmpty());
  }

  /**
   * Test {@link GroupingTranslator#createGroups(String)}.
   * <ul>
   *   <li>When {@code ;[\t\n\r]}.</li>
   *   <li>Then throw {@link MVELTranslationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  public void testCreateGroups_whenTNR_thenThrowMVELTranslationException() throws MVELTranslationException {
    // Arrange, Act and Assert
    assertThrows(MVELTranslationException.class, () -> groupingTranslator.createGroups(";[\\t\\n\\r]"));
    assertThrows(MVELTranslationException.class, () -> groupingTranslator.createGroups("([\\t\\n\\r]"));
    assertThrows(MVELTranslationException.class, () -> groupingTranslator.createGroups("\t;[\\t\\n\\r]"));
    assertThrows(MVELTranslationException.class, () -> groupingTranslator.createGroups("\t([\\t\\n\\r]"));
  }

  /**
   * Test {@link GroupingTranslator#createGroups(String)}.
   * <ul>
   *   <li>When tab tab tab.</li>
   *   <li>Then return OperatorType is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  public void testCreateGroups_whenTabTabTab_thenReturnOperatorTypeIsNull() throws MVELTranslationException {
    // Arrange and Act
    Group actualCreateGroupsResult = groupingTranslator.createGroups("\t\t\t");

    // Assert
    assertNull(actualCreateGroupsResult.getOperatorType());
    assertTrue(actualCreateGroupsResult.getPhrases().isEmpty());
    assertTrue(actualCreateGroupsResult.getSubGroups().isEmpty());
    assertTrue(actualCreateGroupsResult.getIsTopGroup());
  }

  /**
   * Test {@link GroupingTranslator#createGroups(String)}.
   * <ul>
   *   <li>When tab tab.</li>
   *   <li>Then return OperatorType is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  public void testCreateGroups_whenTabTab_thenReturnOperatorTypeIsNull() throws MVELTranslationException {
    // Arrange and Act
    Group actualCreateGroupsResult = groupingTranslator.createGroups("\t\t");

    // Assert
    assertNull(actualCreateGroupsResult.getOperatorType());
    assertTrue(actualCreateGroupsResult.getPhrases().isEmpty());
    assertTrue(actualCreateGroupsResult.getSubGroups().isEmpty());
    assertTrue(actualCreateGroupsResult.getIsTopGroup());
  }

  /**
   * Test {@link GroupingTranslator#createGroups(String)}.
   * <ul>
   *   <li>When tab.</li>
   *   <li>Then return OperatorType is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  public void testCreateGroups_whenTab_thenReturnOperatorTypeIsNull() throws MVELTranslationException {
    // Arrange and Act
    Group actualCreateGroupsResult = groupingTranslator.createGroups("\t");

    // Assert
    assertNull(actualCreateGroupsResult.getOperatorType());
    assertTrue(actualCreateGroupsResult.getPhrases().isEmpty());
    assertTrue(actualCreateGroupsResult.getSubGroups().isEmpty());
    assertTrue(actualCreateGroupsResult.getIsTopGroup());
  }

  /**
   * Test {@link GroupingTranslator#createGroups(String)}.
   * <ul>
   *   <li>When {@code ||}.</li>
   *   <li>Then return OperatorType is {@code OR}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  public void testCreateGroups_whenVerticalLineVerticalLine_thenReturnOperatorTypeIsOr()
      throws MVELTranslationException {
    // Arrange and Act
    Group actualCreateGroupsResult = groupingTranslator.createGroups("||");

    // Assert
    assertEquals(BLCOperator.OR, actualCreateGroupsResult.getOperatorType());
    assertTrue(actualCreateGroupsResult.getPhrases().isEmpty());
    assertTrue(actualCreateGroupsResult.getSubGroups().isEmpty());
    assertTrue(actualCreateGroupsResult.getIsTopGroup());
  }

  /**
   * Test {@link GroupingTranslator#createGroups(String)}.
   * <ul>
   *   <li>When {@code ||}.</li>
   *   <li>Then return OperatorType is {@code OR}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  public void testCreateGroups_whenVerticalLineVerticalLine_thenReturnOperatorTypeIsOr2()
      throws MVELTranslationException {
    // Arrange and Act
    Group actualCreateGroupsResult = groupingTranslator.createGroups("\t||");

    // Assert
    assertEquals(BLCOperator.OR, actualCreateGroupsResult.getOperatorType());
    assertTrue(actualCreateGroupsResult.getPhrases().isEmpty());
    assertTrue(actualCreateGroupsResult.getSubGroups().isEmpty());
    assertTrue(actualCreateGroupsResult.getIsTopGroup());
  }

  /**
   * Test {@link GroupingTranslator#createGroups(String)}.
   * <ul>
   *   <li>When {@code ||}.</li>
   *   <li>Then return OperatorType is {@code OR}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  public void testCreateGroups_whenVerticalLineVerticalLine_thenReturnOperatorTypeIsOr3()
      throws MVELTranslationException {
    // Arrange and Act
    Group actualCreateGroupsResult = groupingTranslator.createGroups("||\t");

    // Assert
    assertEquals(BLCOperator.OR, actualCreateGroupsResult.getOperatorType());
    assertTrue(actualCreateGroupsResult.getPhrases().isEmpty());
    assertTrue(actualCreateGroupsResult.getSubGroups().isEmpty());
    assertTrue(actualCreateGroupsResult.getIsTopGroup());
  }

  /**
   * Test {@link GroupingTranslator#createGroups(String)}.
   * <ul>
   *   <li>When {@code ||}.</li>
   *   <li>Then return OperatorType is {@code OR}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  public void testCreateGroups_whenVerticalLineVerticalLine_thenReturnOperatorTypeIsOr4()
      throws MVELTranslationException {
    // Arrange and Act
    Group actualCreateGroupsResult = groupingTranslator.createGroups("\t\t||");

    // Assert
    assertEquals(BLCOperator.OR, actualCreateGroupsResult.getOperatorType());
    assertTrue(actualCreateGroupsResult.getPhrases().isEmpty());
    assertTrue(actualCreateGroupsResult.getSubGroups().isEmpty());
    assertTrue(actualCreateGroupsResult.getIsTopGroup());
  }

  /**
   * Test {@link GroupingTranslator#findGroupStart(String, int)}.
   * <p>
   * Method under test: {@link GroupingTranslator#findGroupStart(String, int)}
   */
  @Test
  public void testFindGroupStart() {
    // Arrange, Act and Assert
    assertEquals(-1, groupingTranslator.findGroupStart("Segment", 1));
  }

  /**
   * Test {@link GroupingTranslator#findGroupEnd(String, int)}.
   * <ul>
   *   <li>When {@code Segment}.</li>
   *   <li>Then throw {@link MVELTranslationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GroupingTranslator#findGroupEnd(String, int)}
   */
  @Test
  public void testFindGroupEnd_whenSegment_thenThrowMVELTranslationException() throws MVELTranslationException {
    // Arrange, Act and Assert
    assertThrows(MVELTranslationException.class, () -> groupingTranslator.findGroupEnd("Segment", 1));
  }

  /**
   * Test {@link GroupingTranslator#findGroupEnd(String, int)}.
   * <ul>
   *   <li>When
   * {@code Unable to find an end parenthesis for the group started at (}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GroupingTranslator#findGroupEnd(String, int)}
   */
  @Test
  public void testFindGroupEnd_whenUnableToFindAnEndParenthesisForTheGroupStartedAt() throws MVELTranslationException {
    // Arrange, Act and Assert
    assertThrows(MVELTranslationException.class,
        () -> groupingTranslator.findGroupEnd("Unable to find an end parenthesis for the group started at (", 1));
  }

  /**
   * Test {@link GroupingTranslator#stripWhiteSpace(String)}.
   * <p>
   * Method under test: {@link GroupingTranslator#stripWhiteSpace(String)}
   */
  @Test
  public void testStripWhiteSpace() {
    // Arrange, Act and Assert
    assertEquals("&&\\|\\|", groupingTranslator.stripWhiteSpace("\t&&\\|\\|"));
  }

  /**
   * Test {@link GroupingTranslator#stripWhiteSpace(String)}.
   * <ul>
   *   <li>Then return {@code &&&&}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GroupingTranslator#stripWhiteSpace(String)}
   */
  @Test
  public void testStripWhiteSpace_thenReturnAmpersandAmpersandAmpersandAmpersand() {
    // Arrange, Act and Assert
    assertEquals("&&&&", groupingTranslator.stripWhiteSpace("\t&&&&"));
  }

  /**
   * Test {@link GroupingTranslator#stripWhiteSpace(String)}.
   * <ul>
   *   <li>Then return {@code &&(}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GroupingTranslator#stripWhiteSpace(String)}
   */
  @Test
  public void testStripWhiteSpace_thenReturnAmpersandAmpersandLeftParenthesis() {
    // Arrange, Act and Assert
    assertEquals("&&(", groupingTranslator.stripWhiteSpace("\t&&("));
  }

  /**
   * Test {@link GroupingTranslator#stripWhiteSpace(String)}.
   * <ul>
   *   <li>Then return {@code &&)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GroupingTranslator#stripWhiteSpace(String)}
   */
  @Test
  public void testStripWhiteSpace_thenReturnAmpersandAmpersandRightParenthesis() {
    // Arrange, Act and Assert
    assertEquals("&&)", groupingTranslator.stripWhiteSpace("\t&&)"));
  }

  /**
   * Test {@link GroupingTranslator#stripWhiteSpace(String)}.
   * <ul>
   *   <li>Then return {@code &&;}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GroupingTranslator#stripWhiteSpace(String)}
   */
  @Test
  public void testStripWhiteSpace_thenReturnAmpersandAmpersandSemicolon() {
    // Arrange, Act and Assert
    assertEquals("&&;", groupingTranslator.stripWhiteSpace("\t&&;"));
  }

  /**
   * Test {@link GroupingTranslator#stripWhiteSpace(String)}.
   * <ul>
   *   <li>Then return {@code &&||}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GroupingTranslator#stripWhiteSpace(String)}
   */
  @Test
  public void testStripWhiteSpace_thenReturnAmpersandAmpersandVerticalLineVerticalLine() {
    // Arrange, Act and Assert
    assertEquals("&&||", groupingTranslator.stripWhiteSpace("\t&&||"));
  }

  /**
   * Test {@link GroupingTranslator#stripWhiteSpace(String)}.
   * <ul>
   *   <li>Then return {@code \|\|}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GroupingTranslator#stripWhiteSpace(String)}
   */
  @Test
  public void testStripWhiteSpace_thenReturnBackslashVerticalLineBackslashVerticalLine() {
    // Arrange, Act and Assert
    assertEquals("\\|\\|", groupingTranslator.stripWhiteSpace("\t\\|\\|"));
    assertEquals("\\|\\|", groupingTranslator.stripWhiteSpace("\\|\\|\t"));
    assertEquals("\\|\\|", groupingTranslator.stripWhiteSpace("\t\t\\|\\|"));
  }

  /**
   * Test {@link GroupingTranslator#stripWhiteSpace(String)}.
   * <ul>
   *   <li>Then return {@code (&&}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GroupingTranslator#stripWhiteSpace(String)}
   */
  @Test
  public void testStripWhiteSpace_thenReturnLeftParenthesisAmpersandAmpersand() {
    // Arrange, Act and Assert
    assertEquals("(&&", groupingTranslator.stripWhiteSpace("\t(&&"));
  }

  /**
   * Test {@link GroupingTranslator#stripWhiteSpace(String)}.
   * <ul>
   *   <li>Then return {@code ||}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GroupingTranslator#stripWhiteSpace(String)}
   */
  @Test
  public void testStripWhiteSpace_thenReturnVerticalLineVerticalLine() {
    // Arrange, Act and Assert
    assertEquals("||", groupingTranslator.stripWhiteSpace("\t||"));
    assertEquals("||", groupingTranslator.stripWhiteSpace("||\t"));
    assertEquals("||", groupingTranslator.stripWhiteSpace("\t\t||"));
  }

  /**
   * Test {@link GroupingTranslator#stripWhiteSpace(String)}.
   * <ul>
   *   <li>When {@code 42Mvel}.</li>
   *   <li>Then return {@code 42Mvel}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GroupingTranslator#stripWhiteSpace(String)}
   */
  @Test
  public void testStripWhiteSpace_when42Mvel_thenReturn42Mvel() {
    // Arrange, Act and Assert
    assertEquals("42Mvel", groupingTranslator.stripWhiteSpace("\t42Mvel"));
  }

  /**
   * Test {@link GroupingTranslator#stripWhiteSpace(String)}.
   * <ul>
   *   <li>When {@code 42[\t\n\r]}.</li>
   *   <li>Then return {@code 42[\t\n\r]}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GroupingTranslator#stripWhiteSpace(String)}
   */
  @Test
  public void testStripWhiteSpace_when42TNR_thenReturn42TNR() {
    // Arrange, Act and Assert
    assertEquals("42[\\t\\n\\r]", groupingTranslator.stripWhiteSpace("\t42[\\t\\n\\r]"));
  }

  /**
   * Test {@link GroupingTranslator#stripWhiteSpace(String)}.
   * <ul>
   *   <li>When {@code 42}.</li>
   *   <li>Then return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GroupingTranslator#stripWhiteSpace(String)}
   */
  @Test
  public void testStripWhiteSpace_when42_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("42", groupingTranslator.stripWhiteSpace("\t42"));
    assertEquals("42", groupingTranslator.stripWhiteSpace("42\t"));
    assertEquals("42", groupingTranslator.stripWhiteSpace("\t\t42"));
    assertEquals("&&42", groupingTranslator.stripWhiteSpace("\t&&42"));
    assertEquals("42", groupingTranslator.stripWhiteSpace("\t42\t"));
    assertEquals("42&&", groupingTranslator.stripWhiteSpace("\t42&&"));
    assertEquals("42(", groupingTranslator.stripWhiteSpace("\t42("));
    assertEquals("42)", groupingTranslator.stripWhiteSpace("\t42)"));
    assertEquals("42;", groupingTranslator.stripWhiteSpace("\t42;"));
    assertEquals("42\\|\\|", groupingTranslator.stripWhiteSpace("\t42\\|\\|"));
    assertEquals("42||", groupingTranslator.stripWhiteSpace("\t42||"));
    assertEquals("(42", groupingTranslator.stripWhiteSpace("\t(42"));
  }

  /**
   * Test {@link GroupingTranslator#stripWhiteSpace(String)}.
   * <ul>
   *   <li>When {@code 4242}.</li>
   *   <li>Then return {@code 4242}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GroupingTranslator#stripWhiteSpace(String)}
   */
  @Test
  public void testStripWhiteSpace_when4242_thenReturn4242() {
    // Arrange, Act and Assert
    assertEquals("4242", groupingTranslator.stripWhiteSpace("\t4242"));
  }

  /**
   * Test {@link GroupingTranslator#stripWhiteSpace(String)}.
   * <ul>
   *   <li>When {@code &&}.</li>
   *   <li>Then return {@code &&}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GroupingTranslator#stripWhiteSpace(String)}
   */
  @Test
  public void testStripWhiteSpace_whenAmpersandAmpersand_thenReturnAmpersandAmpersand() {
    // Arrange, Act and Assert
    assertEquals("&&", groupingTranslator.stripWhiteSpace("\t&&"));
    assertEquals("&&", groupingTranslator.stripWhiteSpace("&&\t"));
    assertEquals("&&", groupingTranslator.stripWhiteSpace("\t\t&&"));
    assertEquals("&&", groupingTranslator.stripWhiteSpace("\t&&\t"));
  }

  /**
   * Test {@link GroupingTranslator#stripWhiteSpace(String)}.
   * <ul>
   *   <li>When {@code (}.</li>
   *   <li>Then return {@link GroupingTranslator#GROUPSTARTCHAR}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GroupingTranslator#stripWhiteSpace(String)}
   */
  @Test
  public void testStripWhiteSpace_whenLeftParenthesis_thenReturnGroupstartchar() {
    // Arrange, Act and Assert
    assertEquals(GroupingTranslator.GROUPSTARTCHAR, groupingTranslator.stripWhiteSpace("\t("));
    assertEquals(GroupingTranslator.GROUPSTARTCHAR, groupingTranslator.stripWhiteSpace("(\t"));
    assertEquals(GroupingTranslator.GROUPSTARTCHAR, groupingTranslator.stripWhiteSpace("\t\t("));
    assertEquals(GroupingTranslator.GROUPSTARTCHAR, groupingTranslator.stripWhiteSpace("\t(\t"));
  }

  /**
   * Test {@link GroupingTranslator#stripWhiteSpace(String)}.
   * <ul>
   *   <li>When {@code Mvel42}.</li>
   *   <li>Then return {@code Mvel42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GroupingTranslator#stripWhiteSpace(String)}
   */
  @Test
  public void testStripWhiteSpace_whenMvel42_thenReturnMvel42() {
    // Arrange, Act and Assert
    assertEquals("Mvel42", groupingTranslator.stripWhiteSpace("\tMvel42"));
  }

  /**
   * Test {@link GroupingTranslator#stripWhiteSpace(String)}.
   * <ul>
   *   <li>When {@code MvelMvel}.</li>
   *   <li>Then return {@code MvelMvel}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GroupingTranslator#stripWhiteSpace(String)}
   */
  @Test
  public void testStripWhiteSpace_whenMvelMvel_thenReturnMvelMvel() {
    // Arrange, Act and Assert
    assertEquals("MvelMvel", groupingTranslator.stripWhiteSpace("\tMvelMvel"));
  }

  /**
   * Test {@link GroupingTranslator#stripWhiteSpace(String)}.
   * <ul>
   *   <li>When {@code Mvel[\t\n\r]}.</li>
   *   <li>Then return {@code Mvel[\t\n\r]}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GroupingTranslator#stripWhiteSpace(String)}
   */
  @Test
  public void testStripWhiteSpace_whenMvelTNR_thenReturnMvelTNR() {
    // Arrange, Act and Assert
    assertEquals("Mvel[\\t\\n\\r]", groupingTranslator.stripWhiteSpace("\tMvel[\\t\\n\\r]"));
  }

  /**
   * Test {@link GroupingTranslator#stripWhiteSpace(String)}.
   * <ul>
   *   <li>When {@code Mvel}.</li>
   *   <li>Then return {@code Mvel}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GroupingTranslator#stripWhiteSpace(String)}
   */
  @Test
  public void testStripWhiteSpace_whenMvel_thenReturnMvel() {
    // Arrange, Act and Assert
    assertEquals("Mvel", groupingTranslator.stripWhiteSpace("Mvel"));
    assertEquals("Mvel", groupingTranslator.stripWhiteSpace("\tMvel"));
    assertEquals("Mvel", groupingTranslator.stripWhiteSpace("Mvel\t"));
    assertEquals("Mvel", groupingTranslator.stripWhiteSpace("\t\tMvel"));
    assertEquals("Mvel", groupingTranslator.stripWhiteSpace("\tMvel\t"));
    assertEquals("Mvel&&", groupingTranslator.stripWhiteSpace("\tMvel&&"));
    assertEquals("Mvel(", groupingTranslator.stripWhiteSpace("\tMvel("));
    assertEquals("Mvel)", groupingTranslator.stripWhiteSpace("\tMvel)"));
    assertEquals("Mvel;", groupingTranslator.stripWhiteSpace("\tMvel;"));
    assertEquals("Mvel\\|\\|", groupingTranslator.stripWhiteSpace("\tMvel\\|\\|"));
    assertEquals("Mvel||", groupingTranslator.stripWhiteSpace("\tMvel||"));
    assertEquals("&&Mvel", groupingTranslator.stripWhiteSpace("\t&&Mvel"));
    assertEquals("(Mvel", groupingTranslator.stripWhiteSpace("\t(Mvel"));
  }

  /**
   * Test {@link GroupingTranslator#stripWhiteSpace(String)}.
   * <ul>
   *   <li>When {@code )}.</li>
   *   <li>Then return {@link GroupingTranslator#GROUPENDCHAR}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GroupingTranslator#stripWhiteSpace(String)}
   */
  @Test
  public void testStripWhiteSpace_whenRightParenthesis_thenReturnGroupendchar() {
    // Arrange, Act and Assert
    assertEquals(GroupingTranslator.GROUPENDCHAR, groupingTranslator.stripWhiteSpace("\t)"));
    assertEquals(GroupingTranslator.GROUPENDCHAR, groupingTranslator.stripWhiteSpace(")\t"));
    assertEquals(GroupingTranslator.GROUPENDCHAR, groupingTranslator.stripWhiteSpace("\t\t)"));
  }

  /**
   * Test {@link GroupingTranslator#stripWhiteSpace(String)}.
   * <ul>
   *   <li>When {@code ;}.</li>
   *   <li>Then return {@link GroupingTranslator#STATEMENTENDCHAR}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GroupingTranslator#stripWhiteSpace(String)}
   */
  @Test
  public void testStripWhiteSpace_whenSemicolon_thenReturnStatementendchar() {
    // Arrange, Act and Assert
    assertEquals(GroupingTranslator.STATEMENTENDCHAR, groupingTranslator.stripWhiteSpace("\t;"));
    assertEquals(GroupingTranslator.STATEMENTENDCHAR, groupingTranslator.stripWhiteSpace(";\t"));
    assertEquals(GroupingTranslator.STATEMENTENDCHAR, groupingTranslator.stripWhiteSpace("\t\t;"));
  }

  /**
   * Test {@link GroupingTranslator#stripWhiteSpace(String)}.
   * <ul>
   *   <li>When {@code [\t\n\r]42}.</li>
   *   <li>Then return {@code [\t\n\r]42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GroupingTranslator#stripWhiteSpace(String)}
   */
  @Test
  public void testStripWhiteSpace_whenTNR42_thenReturnTNR42() {
    // Arrange, Act and Assert
    assertEquals("[\\t\\n\\r]42", groupingTranslator.stripWhiteSpace("\t[\\t\\n\\r]42"));
  }

  /**
   * Test {@link GroupingTranslator#stripWhiteSpace(String)}.
   * <ul>
   *   <li>When {@code [\t\n\r]Mvel}.</li>
   *   <li>Then return {@code [\t\n\r]Mvel}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GroupingTranslator#stripWhiteSpace(String)}
   */
  @Test
  public void testStripWhiteSpace_whenTNRMvel_thenReturnTNRMvel() {
    // Arrange, Act and Assert
    assertEquals("[\\t\\n\\r]Mvel", groupingTranslator.stripWhiteSpace("\t[\\t\\n\\r]Mvel"));
  }

  /**
   * Test {@link GroupingTranslator#stripWhiteSpace(String)}.
   * <ul>
   *   <li>When {@code [\t\n\r][\t\n\r]}.</li>
   *   <li>Then return {@code [\t\n\r][\t\n\r]}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GroupingTranslator#stripWhiteSpace(String)}
   */
  @Test
  public void testStripWhiteSpace_whenTNRTNR_thenReturnTNRTNR() {
    // Arrange, Act and Assert
    assertEquals("[\\t\\n\\r][\\t\\n\\r]", groupingTranslator.stripWhiteSpace("\t[\\t\\n\\r][\\t\\n\\r]"));
  }

  /**
   * Test {@link GroupingTranslator#stripWhiteSpace(String)}.
   * <ul>
   *   <li>When {@code [\t\n\r]}.</li>
   *   <li>Then return {@code [\t\n\r]}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GroupingTranslator#stripWhiteSpace(String)}
   */
  @Test
  public void testStripWhiteSpace_whenTNR_thenReturnTNR() {
    // Arrange, Act and Assert
    assertEquals("[\\t\\n\\r]", groupingTranslator.stripWhiteSpace("\t[\\t\\n\\r]"));
    assertEquals("[\\t\\n\\r]", groupingTranslator.stripWhiteSpace("[\\t\\n\\r]\t"));
    assertEquals("[\\t\\n\\r]", groupingTranslator.stripWhiteSpace("\t\t[\\t\\n\\r]"));
    assertEquals("[\\t\\n\\r]", groupingTranslator.stripWhiteSpace("\t[\\t\\n\\r]\t"));
    assertEquals("[\\t\\n\\r]&&", groupingTranslator.stripWhiteSpace("\t[\\t\\n\\r]&&"));
    assertEquals("[\\t\\n\\r](", groupingTranslator.stripWhiteSpace("\t[\\t\\n\\r]("));
    assertEquals("[\\t\\n\\r])", groupingTranslator.stripWhiteSpace("\t[\\t\\n\\r])"));
    assertEquals("[\\t\\n\\r];", groupingTranslator.stripWhiteSpace("\t[\\t\\n\\r];"));
    assertEquals("[\\t\\n\\r]\\|\\|", groupingTranslator.stripWhiteSpace("\t[\\t\\n\\r]\\|\\|"));
    assertEquals("[\\t\\n\\r]||", groupingTranslator.stripWhiteSpace("\t[\\t\\n\\r]||"));
    assertEquals("&&[\\t\\n\\r]", groupingTranslator.stripWhiteSpace("\t&&[\\t\\n\\r]"));
    assertEquals("([\\t\\n\\r]", groupingTranslator.stripWhiteSpace("\t([\\t\\n\\r]"));
  }

  /**
   * Test {@link GroupingTranslator#stripWhiteSpace(String)}.
   * <ul>
   *   <li>When tab tab tab.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link GroupingTranslator#stripWhiteSpace(String)}
   */
  @Test
  public void testStripWhiteSpace_whenTabTabTab_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", groupingTranslator.stripWhiteSpace("\t\t\t"));
  }

  /**
   * Test {@link GroupingTranslator#stripWhiteSpace(String)}.
   * <ul>
   *   <li>When tab tab.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link GroupingTranslator#stripWhiteSpace(String)}
   */
  @Test
  public void testStripWhiteSpace_whenTabTab_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", groupingTranslator.stripWhiteSpace("\t\t"));
  }

  /**
   * Test {@link GroupingTranslator#stripWhiteSpace(String)}.
   * <ul>
   *   <li>When tab.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link GroupingTranslator#stripWhiteSpace(String)}
   */
  @Test
  public void testStripWhiteSpace_whenTab_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", groupingTranslator.stripWhiteSpace("\t"));
  }

  /**
   * Test {@link GroupingTranslator#parseGroups(Group, String)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.</li>
   *   <li>When {@link GroupingTranslator#GROUPSTARTCHAR}.</li>
   *   <li>Then calls {@link Group#getSubGroups()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GroupingTranslator#parseGroups(Group, String)}
   */
  @Test
  public void testParseGroups_givenArrayList_whenGroupstartchar_thenCallsGetSubGroups()
      throws MVELTranslationException {
    // Arrange
    Group myGroup = mock(Group.class);
    when(myGroup.getSubGroups()).thenReturn(new ArrayList<>());
    doNothing().when(myGroup).setIsTopGroup(Mockito.<Boolean>any());
    doNothing().when(myGroup).setOperatorType(Mockito.<BLCOperator>any());
    myGroup.setIsTopGroup(true);
    myGroup.setOperatorType(BLCOperator.EQUALS);

    // Act and Assert
    assertThrows(MVELTranslationException.class,
        () -> groupingTranslator.parseGroups(myGroup, GroupingTranslator.GROUPSTARTCHAR));
    verify(myGroup).getSubGroups();
    verify(myGroup).setIsTopGroup(eq(true));
    verify(myGroup).setOperatorType(eq(BLCOperator.EQUALS));
  }

  /**
   * Test {@link GroupingTranslator#parseGroups(Group, String)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.</li>
   *   <li>When {@code Segment}.</li>
   *   <li>Then calls {@link Group#getPhrases()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GroupingTranslator#parseGroups(Group, String)}
   */
  @Test
  public void testParseGroups_givenArrayList_whenSegment_thenCallsGetPhrases() throws MVELTranslationException {
    // Arrange
    Group myGroup = mock(Group.class);
    when(myGroup.getPhrases()).thenReturn(new ArrayList<>());
    when(myGroup.getOperatorType()).thenReturn(BLCOperator.EQUALS);
    doNothing().when(myGroup).setIsTopGroup(Mockito.<Boolean>any());
    doNothing().when(myGroup).setOperatorType(Mockito.<BLCOperator>any());
    myGroup.setIsTopGroup(true);
    myGroup.setOperatorType(BLCOperator.EQUALS);

    // Act
    groupingTranslator.parseGroups(myGroup, "Segment");

    // Assert
    verify(myGroup).getOperatorType();
    verify(myGroup).getPhrases();
    verify(myGroup).setIsTopGroup(eq(true));
    verify(myGroup).setOperatorType(eq(BLCOperator.EQUALS));
  }

  /**
   * Test {@link GroupingTranslator#parseGroups(Group, String)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link Group} {@link Group#getOperatorType()} return
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GroupingTranslator#parseGroups(Group, String)}
   */
  @Test
  public void testParseGroups_givenNull_whenGroupGetOperatorTypeReturnNull() throws MVELTranslationException {
    // Arrange
    Group myGroup = mock(Group.class);
    when(myGroup.getOperatorType()).thenReturn(null);
    doNothing().when(myGroup).setIsTopGroup(Mockito.<Boolean>any());
    doNothing().when(myGroup).setOperatorType(Mockito.<BLCOperator>any());
    myGroup.setIsTopGroup(true);
    myGroup.setOperatorType(BLCOperator.EQUALS);

    // Act
    groupingTranslator.parseGroups(myGroup, "||");

    // Assert
    verify(myGroup).getOperatorType();
    verify(myGroup).setIsTopGroup(eq(true));
    verify(myGroup, atLeast(1)).setOperatorType(Mockito.<BLCOperator>any());
  }

  /**
   * Test {@link GroupingTranslator#parseGroups(Group, String)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link Group} {@link Group#getOperatorType()} return
   * {@code null}.</li>
   *   <li>Then calls {@link Group#getPhrases()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GroupingTranslator#parseGroups(Group, String)}
   */
  @Test
  public void testParseGroups_givenNull_whenGroupGetOperatorTypeReturnNull_thenCallsGetPhrases()
      throws MVELTranslationException {
    // Arrange
    Group myGroup = mock(Group.class);
    when(myGroup.getPhrases()).thenReturn(new ArrayList<>());
    when(myGroup.getOperatorType()).thenReturn(null);
    doNothing().when(myGroup).setIsTopGroup(Mockito.<Boolean>any());
    doNothing().when(myGroup).setOperatorType(Mockito.<BLCOperator>any());
    myGroup.setIsTopGroup(true);
    myGroup.setOperatorType(BLCOperator.EQUALS);

    // Act
    groupingTranslator.parseGroups(myGroup, "Segment");

    // Assert
    verify(myGroup).getOperatorType();
    verify(myGroup).getPhrases();
    verify(myGroup).setIsTopGroup(eq(true));
    verify(myGroup, atLeast(1)).setOperatorType(Mockito.<BLCOperator>any());
  }

  /**
   * Test {@link GroupingTranslator#parseGroups(Group, String)}.
   * <ul>
   *   <li>When {@code &&}.</li>
   *   <li>Then calls {@link Group#getOperatorType()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GroupingTranslator#parseGroups(Group, String)}
   */
  @Test
  public void testParseGroups_whenAmpersandAmpersand_thenCallsGetOperatorType() throws MVELTranslationException {
    // Arrange
    Group myGroup = mock(Group.class);
    when(myGroup.getOperatorType()).thenReturn(BLCOperator.EQUALS);
    doNothing().when(myGroup).setIsTopGroup(Mockito.<Boolean>any());
    doNothing().when(myGroup).setOperatorType(Mockito.<BLCOperator>any());
    myGroup.setIsTopGroup(true);
    myGroup.setOperatorType(BLCOperator.EQUALS);

    // Act
    groupingTranslator.parseGroups(myGroup, "&&");

    // Assert
    verify(myGroup).getOperatorType();
    verify(myGroup).setIsTopGroup(eq(true));
    verify(myGroup).setOperatorType(eq(BLCOperator.EQUALS));
  }

  /**
   * Test {@link GroupingTranslator#parseGroups(Group, String)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then calls {@link Group#setIsTopGroup(Boolean)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GroupingTranslator#parseGroups(Group, String)}
   */
  @Test
  public void testParseGroups_whenEmptyString_thenCallsSetIsTopGroup() throws MVELTranslationException {
    // Arrange
    Group myGroup = mock(Group.class);
    doNothing().when(myGroup).setIsTopGroup(Mockito.<Boolean>any());
    doNothing().when(myGroup).setOperatorType(Mockito.<BLCOperator>any());
    myGroup.setIsTopGroup(true);
    myGroup.setOperatorType(BLCOperator.EQUALS);

    // Act
    groupingTranslator.parseGroups(myGroup, "");

    // Assert that nothing has changed
    verify(myGroup).setIsTopGroup(eq(true));
    verify(myGroup).setOperatorType(eq(BLCOperator.EQUALS));
  }

  /**
   * Test {@link GroupingTranslator#parseGroups(Group, String)}.
   * <ul>
   *   <li>When {@link Group} (default constructor) IsTopGroup is {@code true}.</li>
   *   <li>Then {@link Group} (default constructor) Phrases size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link GroupingTranslator#parseGroups(Group, String)}
   */
  @Test
  public void testParseGroups_whenGroupIsTopGroupIsTrue_thenGroupPhrasesSizeIsOne() throws MVELTranslationException {
    // Arrange
    Group myGroup = new Group();
    myGroup.setIsTopGroup(true);
    myGroup.setOperatorType(BLCOperator.EQUALS);

    // Act
    groupingTranslator.parseGroups(myGroup, "Segment");

    // Assert
    List<String> phrases = myGroup.getPhrases();
    assertEquals(1, phrases.size());
    assertEquals("Segment", phrases.get(0));
  }

  /**
   * Test {@link GroupingTranslator#parseGroups(Group, String)}.
   * <ul>
   *   <li>When
   * {@code Unable to find an end parenthesis for the group started at (}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GroupingTranslator#parseGroups(Group, String)}
   */
  @Test
  public void testParseGroups_whenUnableToFindAnEndParenthesisForTheGroupStartedAt() throws MVELTranslationException {
    // Arrange
    Group myGroup = mock(Group.class);
    when(myGroup.getPhrases()).thenReturn(new ArrayList<>());
    when(myGroup.getOperatorType()).thenReturn(BLCOperator.EQUALS);
    doNothing().when(myGroup).setIsTopGroup(Mockito.<Boolean>any());
    doNothing().when(myGroup).setOperatorType(Mockito.<BLCOperator>any());
    myGroup.setIsTopGroup(true);
    myGroup.setOperatorType(BLCOperator.EQUALS);

    // Act
    groupingTranslator.parseGroups(myGroup, "Unable to find an end parenthesis for the group started at (");

    // Assert
    verify(myGroup).getOperatorType();
    verify(myGroup).getPhrases();
    verify(myGroup).setIsTopGroup(eq(true));
    verify(myGroup).setOperatorType(eq(BLCOperator.EQUALS));
  }

  /**
   * Test {@link GroupingTranslator#parseGroups(Group, String)}.
   * <ul>
   *   <li>When {@code ||}.</li>
   *   <li>Then throw {@link MVELTranslationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GroupingTranslator#parseGroups(Group, String)}
   */
  @Test
  public void testParseGroups_whenVerticalLineVerticalLine_thenThrowMVELTranslationException()
      throws MVELTranslationException {
    // Arrange
    Group myGroup = mock(Group.class);
    when(myGroup.getOperatorType()).thenReturn(BLCOperator.EQUALS);
    doNothing().when(myGroup).setIsTopGroup(Mockito.<Boolean>any());
    doNothing().when(myGroup).setOperatorType(Mockito.<BLCOperator>any());
    myGroup.setIsTopGroup(true);
    myGroup.setOperatorType(BLCOperator.EQUALS);

    // Act and Assert
    assertThrows(MVELTranslationException.class, () -> groupingTranslator.parseGroups(myGroup, "||"));
    verify(myGroup, atLeast(1)).getOperatorType();
    verify(myGroup).setIsTopGroup(eq(true));
    verify(myGroup).setOperatorType(eq(BLCOperator.EQUALS));
  }

  /**
   * Test {@link GroupingTranslator#compilePhrases(String, Group, boolean)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.</li>
   *   <li>Then calls {@link Group#getPhrases()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link GroupingTranslator#compilePhrases(String, Group, boolean)}
   */
  @Test
  public void testCompilePhrases_givenArrayList_thenCallsGetPhrases() throws MVELTranslationException {
    // Arrange
    Group myGroup = mock(Group.class);
    when(myGroup.getPhrases()).thenReturn(new ArrayList<>());
    when(myGroup.getOperatorType()).thenReturn(BLCOperator.EQUALS);
    doNothing().when(myGroup).setIsTopGroup(Mockito.<Boolean>any());
    doNothing().when(myGroup).setOperatorType(Mockito.<BLCOperator>any());
    myGroup.setIsTopGroup(true);
    myGroup.setOperatorType(BLCOperator.EQUALS);

    // Act
    groupingTranslator.compilePhrases("Segment", myGroup, true);

    // Assert
    verify(myGroup).getOperatorType();
    verify(myGroup).getPhrases();
    verify(myGroup).setIsTopGroup(eq(true));
    verify(myGroup).setOperatorType(eq(BLCOperator.EQUALS));
  }

  /**
   * Test {@link GroupingTranslator#compilePhrases(String, Group, boolean)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.</li>
   *   <li>Then calls {@link Group#getPhrases()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link GroupingTranslator#compilePhrases(String, Group, boolean)}
   */
  @Test
  public void testCompilePhrases_givenArrayList_thenCallsGetPhrases2() throws MVELTranslationException {
    // Arrange
    Group myGroup = mock(Group.class);
    when(myGroup.getPhrases()).thenReturn(new ArrayList<>());
    when(myGroup.getOperatorType()).thenReturn(null);
    doNothing().when(myGroup).setIsTopGroup(Mockito.<Boolean>any());
    doNothing().when(myGroup).setOperatorType(Mockito.<BLCOperator>any());
    myGroup.setIsTopGroup(true);
    myGroup.setOperatorType(BLCOperator.EQUALS);

    // Act
    groupingTranslator.compilePhrases("Segment", myGroup, true);

    // Assert
    verify(myGroup).getOperatorType();
    verify(myGroup).getPhrases();
    verify(myGroup).setIsTopGroup(eq(true));
    verify(myGroup, atLeast(1)).setOperatorType(Mockito.<BLCOperator>any());
  }

  /**
   * Test {@link GroupingTranslator#compilePhrases(String, Group, boolean)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@code ||}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link GroupingTranslator#compilePhrases(String, Group, boolean)}
   */
  @Test
  public void testCompilePhrases_givenNull_whenVerticalLineVerticalLine() throws MVELTranslationException {
    // Arrange
    Group myGroup = mock(Group.class);
    when(myGroup.getOperatorType()).thenReturn(null);
    doNothing().when(myGroup).setIsTopGroup(Mockito.<Boolean>any());
    doNothing().when(myGroup).setOperatorType(Mockito.<BLCOperator>any());
    myGroup.setIsTopGroup(true);
    myGroup.setOperatorType(BLCOperator.EQUALS);

    // Act
    groupingTranslator.compilePhrases("||", myGroup, true);

    // Assert
    verify(myGroup).getOperatorType();
    verify(myGroup).setIsTopGroup(eq(true));
    verify(myGroup, atLeast(1)).setOperatorType(Mockito.<BLCOperator>any());
  }

  /**
   * Test {@link GroupingTranslator#compilePhrases(String, Group, boolean)}.
   * <ul>
   *   <li>Then throw {@link MVELTranslationException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link GroupingTranslator#compilePhrases(String, Group, boolean)}
   */
  @Test
  public void testCompilePhrases_thenThrowMVELTranslationException() throws MVELTranslationException {
    // Arrange
    Group myGroup = new Group();
    myGroup.setIsTopGroup(true);
    myGroup.setOperatorType(BLCOperator.EQUALS);

    // Act and Assert
    assertThrows(MVELTranslationException.class, () -> groupingTranslator.compilePhrases("||", myGroup, true));
  }

  /**
   * Test {@link GroupingTranslator#compilePhrases(String, Group, boolean)}.
   * <ul>
   *   <li>When {@code &&}.</li>
   *   <li>Then {@link Group} (default constructor) Phrases Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link GroupingTranslator#compilePhrases(String, Group, boolean)}
   */
  @Test
  public void testCompilePhrases_whenAmpersandAmpersand_thenGroupPhrasesEmpty() throws MVELTranslationException {
    // Arrange
    Group myGroup = new Group();
    myGroup.setIsTopGroup(true);
    myGroup.setOperatorType(BLCOperator.EQUALS);

    // Act
    groupingTranslator.compilePhrases("&&", myGroup, true);

    // Assert that nothing has changed
    assertTrue(myGroup.getPhrases().isEmpty());
  }

  /**
   * Test {@link GroupingTranslator#compilePhrases(String, Group, boolean)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then {@link Group} (default constructor) Phrases Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link GroupingTranslator#compilePhrases(String, Group, boolean)}
   */
  @Test
  public void testCompilePhrases_whenEmptyString_thenGroupPhrasesEmpty() throws MVELTranslationException {
    // Arrange
    Group myGroup = new Group();
    myGroup.setIsTopGroup(true);
    myGroup.setOperatorType(BLCOperator.EQUALS);

    // Act
    groupingTranslator.compilePhrases("", myGroup, true);

    // Assert that nothing has changed
    assertTrue(myGroup.getPhrases().isEmpty());
  }

  /**
   * Test {@link GroupingTranslator#compilePhrases(String, Group, boolean)}.
   * <ul>
   *   <li>When {@code false}.</li>
   *   <li>Then calls {@link Group#getOperatorType()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link GroupingTranslator#compilePhrases(String, Group, boolean)}
   */
  @Test
  public void testCompilePhrases_whenFalse_thenCallsGetOperatorType() throws MVELTranslationException {
    // Arrange
    Group myGroup = mock(Group.class);
    when(myGroup.getOperatorType()).thenReturn(BLCOperator.EQUALS);
    doNothing().when(myGroup).setIsTopGroup(Mockito.<Boolean>any());
    doNothing().when(myGroup).setOperatorType(Mockito.<BLCOperator>any());
    myGroup.setIsTopGroup(true);
    myGroup.setOperatorType(BLCOperator.EQUALS);

    // Act
    groupingTranslator.compilePhrases("&&", myGroup, false);

    // Assert
    verify(myGroup).getOperatorType();
    verify(myGroup).setIsTopGroup(eq(true));
    verify(myGroup).setOperatorType(eq(BLCOperator.EQUALS));
  }

  /**
   * Test {@link GroupingTranslator#compilePhrases(String, Group, boolean)}.
   * <ul>
   *   <li>When {@code Segment}.</li>
   *   <li>Then {@link Group} (default constructor) Phrases size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link GroupingTranslator#compilePhrases(String, Group, boolean)}
   */
  @Test
  public void testCompilePhrases_whenSegment_thenGroupPhrasesSizeIsOne() throws MVELTranslationException {
    // Arrange
    Group myGroup = new Group();
    myGroup.setIsTopGroup(true);
    myGroup.setOperatorType(BLCOperator.EQUALS);

    // Act
    groupingTranslator.compilePhrases("Segment", myGroup, true);

    // Assert
    List<String> phrases = myGroup.getPhrases();
    assertEquals(1, phrases.size());
    assertEquals("Segment", phrases.get(0));
  }

  /**
   * Test
   * {@link GroupingTranslator#setGroupOperator(String, Group, boolean, boolean, boolean)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link Group} {@link Group#getOperatorType()} return
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link GroupingTranslator#setGroupOperator(String, Group, boolean, boolean, boolean)}
   */
  @Test
  public void testSetGroupOperator_givenNull_whenGroupGetOperatorTypeReturnNull() throws MVELTranslationException {
    // Arrange
    Group myGroup = mock(Group.class);
    when(myGroup.getOperatorType()).thenReturn(null);
    doNothing().when(myGroup).setIsTopGroup(Mockito.<Boolean>any());
    doNothing().when(myGroup).setOperatorType(Mockito.<BLCOperator>any());
    myGroup.setIsTopGroup(true);
    myGroup.setOperatorType(BLCOperator.EQUALS);

    // Act
    groupingTranslator.setGroupOperator("Segment", myGroup, true, true, true);

    // Assert
    verify(myGroup).getOperatorType();
    verify(myGroup).setIsTopGroup(eq(true));
    verify(myGroup, atLeast(1)).setOperatorType(Mockito.<BLCOperator>any());
  }

  /**
   * Test
   * {@link GroupingTranslator#setGroupOperator(String, Group, boolean, boolean, boolean)}.
   * <ul>
   *   <li>When {@link Group} {@link Group#getOperatorType()} return
   * {@code EQUALS}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link GroupingTranslator#setGroupOperator(String, Group, boolean, boolean, boolean)}
   */
  @Test
  public void testSetGroupOperator_whenGroupGetOperatorTypeReturnEquals() throws MVELTranslationException {
    // Arrange
    Group myGroup = mock(Group.class);
    when(myGroup.getOperatorType()).thenReturn(BLCOperator.EQUALS);
    doNothing().when(myGroup).setIsTopGroup(Mockito.<Boolean>any());
    doNothing().when(myGroup).setOperatorType(Mockito.<BLCOperator>any());
    myGroup.setIsTopGroup(true);
    myGroup.setOperatorType(BLCOperator.EQUALS);

    // Act
    groupingTranslator.setGroupOperator("Segment", myGroup, true, false, true);

    // Assert
    verify(myGroup).getOperatorType();
    verify(myGroup).setIsTopGroup(eq(true));
    verify(myGroup).setOperatorType(eq(BLCOperator.EQUALS));
  }

  /**
   * Test
   * {@link GroupingTranslator#setGroupOperator(String, Group, boolean, boolean, boolean)}.
   * <ul>
   *   <li>When {@link Group} (default constructor) IsTopGroup is {@code true}.</li>
   *   <li>Then throw {@link MVELTranslationException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link GroupingTranslator#setGroupOperator(String, Group, boolean, boolean, boolean)}
   */
  @Test
  public void testSetGroupOperator_whenGroupIsTopGroupIsTrue_thenThrowMVELTranslationException()
      throws MVELTranslationException {
    // Arrange
    Group myGroup = new Group();
    myGroup.setIsTopGroup(true);
    myGroup.setOperatorType(BLCOperator.EQUALS);

    // Act and Assert
    assertThrows(MVELTranslationException.class,
        () -> groupingTranslator.setGroupOperator("Segment", myGroup, true, true, true));
  }
}
