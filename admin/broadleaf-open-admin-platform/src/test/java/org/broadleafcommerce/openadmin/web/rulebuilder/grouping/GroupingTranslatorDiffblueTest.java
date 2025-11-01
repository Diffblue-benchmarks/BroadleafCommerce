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
   * Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  public void testCreateGroups() throws MVELTranslationException {
    // Arrange and Act
    Group actualCreateGroupsResult = groupingTranslator.createGroups("Mvel");

    // Assert
    List<String> phrases = actualCreateGroupsResult.getPhrases();
    assertEquals(1, phrases.size());
    assertEquals("Mvel", phrases.get(0));
    assertEquals(BLCOperator.AND, actualCreateGroupsResult.getOperatorType());
    assertTrue(actualCreateGroupsResult.getSubGroups().isEmpty());
    assertTrue(actualCreateGroupsResult.getIsTopGroup());
  }

  /**
   * Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  public void testCreateGroups2() throws MVELTranslationException {
    // Arrange and Act
    Group actualCreateGroupsResult = groupingTranslator.createGroups("\t");

    // Assert
    assertNull(actualCreateGroupsResult.getOperatorType());
    assertTrue(actualCreateGroupsResult.getPhrases().isEmpty());
    assertTrue(actualCreateGroupsResult.getSubGroups().isEmpty());
    assertTrue(actualCreateGroupsResult.getIsTopGroup());
  }

  /**
   * Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  public void testCreateGroups3() throws MVELTranslationException {
    // Arrange, Act and Assert
    assertThrows(MVELTranslationException.class,
        () -> groupingTranslator.createGroups(GroupingTranslator.GROUPSTARTCHAR));
  }

  /**
   * Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  public void testCreateGroups4() throws MVELTranslationException {
    // Arrange and Act
    Group actualCreateGroupsResult = groupingTranslator.createGroups("&&");

    // Assert
    assertEquals(BLCOperator.AND, actualCreateGroupsResult.getOperatorType());
    assertTrue(actualCreateGroupsResult.getPhrases().isEmpty());
    assertTrue(actualCreateGroupsResult.getSubGroups().isEmpty());
    assertTrue(actualCreateGroupsResult.getIsTopGroup());
  }

  /**
   * Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  public void testCreateGroups5() throws MVELTranslationException {
    // Arrange and Act
    Group actualCreateGroupsResult = groupingTranslator.createGroups("||");

    // Assert
    assertEquals(BLCOperator.OR, actualCreateGroupsResult.getOperatorType());
    assertTrue(actualCreateGroupsResult.getPhrases().isEmpty());
    assertTrue(actualCreateGroupsResult.getSubGroups().isEmpty());
    assertTrue(actualCreateGroupsResult.getIsTopGroup());
  }

  /**
   * Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  public void testCreateGroups6() throws MVELTranslationException {
    // Arrange and Act
    Group actualCreateGroupsResult = groupingTranslator.createGroups("\t\t");

    // Assert
    assertNull(actualCreateGroupsResult.getOperatorType());
    assertTrue(actualCreateGroupsResult.getPhrases().isEmpty());
    assertTrue(actualCreateGroupsResult.getSubGroups().isEmpty());
    assertTrue(actualCreateGroupsResult.getIsTopGroup());
  }

  /**
   * Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  public void testCreateGroups7() throws MVELTranslationException {
    // Arrange and Act
    Group actualCreateGroupsResult = groupingTranslator.createGroups("\t[\\t\\n\\r]");

    // Assert
    List<String> phrases = actualCreateGroupsResult.getPhrases();
    assertEquals(1, phrases.size());
    assertEquals("[\\t\\n\\r]", phrases.get(0));
    assertEquals(BLCOperator.AND, actualCreateGroupsResult.getOperatorType());
    assertTrue(actualCreateGroupsResult.getSubGroups().isEmpty());
    assertTrue(actualCreateGroupsResult.getIsTopGroup());
  }

  /**
   * Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  public void testCreateGroups8() throws MVELTranslationException {
    // Arrange, Act and Assert
    assertThrows(MVELTranslationException.class, () -> groupingTranslator.createGroups("\t("));
  }

  /**
   * Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  public void testCreateGroups9() throws MVELTranslationException {
    // Arrange and Act
    Group actualCreateGroupsResult = groupingTranslator.createGroups("\t&&");

    // Assert
    assertEquals(BLCOperator.AND, actualCreateGroupsResult.getOperatorType());
    assertTrue(actualCreateGroupsResult.getPhrases().isEmpty());
    assertTrue(actualCreateGroupsResult.getSubGroups().isEmpty());
    assertTrue(actualCreateGroupsResult.getIsTopGroup());
  }

  /**
   * Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  public void testCreateGroups10() throws MVELTranslationException {
    // Arrange and Act
    Group actualCreateGroupsResult = groupingTranslator.createGroups("\tMvel");

    // Assert
    List<String> phrases = actualCreateGroupsResult.getPhrases();
    assertEquals(1, phrases.size());
    assertEquals("Mvel", phrases.get(0));
    assertEquals(BLCOperator.AND, actualCreateGroupsResult.getOperatorType());
    assertTrue(actualCreateGroupsResult.getSubGroups().isEmpty());
    assertTrue(actualCreateGroupsResult.getIsTopGroup());
  }

  /**
   * Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  public void testCreateGroups11() throws MVELTranslationException {
    // Arrange and Act
    Group actualCreateGroupsResult = groupingTranslator.createGroups("\t\\|\\|");

    // Assert
    List<String> phrases = actualCreateGroupsResult.getPhrases();
    assertEquals(1, phrases.size());
    assertEquals("\\|\\|", phrases.get(0));
    assertEquals(BLCOperator.AND, actualCreateGroupsResult.getOperatorType());
    assertTrue(actualCreateGroupsResult.getSubGroups().isEmpty());
    assertTrue(actualCreateGroupsResult.getIsTopGroup());
  }

  /**
   * Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  public void testCreateGroups12() throws MVELTranslationException {
    // Arrange and Act
    Group actualCreateGroupsResult = groupingTranslator.createGroups("\t42");

    // Assert
    List<String> phrases = actualCreateGroupsResult.getPhrases();
    assertEquals(1, phrases.size());
    assertEquals("42", phrases.get(0));
    assertEquals(BLCOperator.AND, actualCreateGroupsResult.getOperatorType());
    assertTrue(actualCreateGroupsResult.getSubGroups().isEmpty());
    assertTrue(actualCreateGroupsResult.getIsTopGroup());
  }

  /**
   * Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  public void testCreateGroups13() throws MVELTranslationException {
    // Arrange and Act
    Group actualCreateGroupsResult = groupingTranslator.createGroups("\t||");

    // Assert
    assertEquals(BLCOperator.OR, actualCreateGroupsResult.getOperatorType());
    assertTrue(actualCreateGroupsResult.getPhrases().isEmpty());
    assertTrue(actualCreateGroupsResult.getSubGroups().isEmpty());
    assertTrue(actualCreateGroupsResult.getIsTopGroup());
  }

  /**
   * Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  public void testCreateGroups14() throws MVELTranslationException {
    // Arrange and Act
    Group actualCreateGroupsResult = groupingTranslator.createGroups("\t)");

    // Assert
    List<String> phrases = actualCreateGroupsResult.getPhrases();
    assertEquals(1, phrases.size());
    assertEquals(BLCOperator.AND, actualCreateGroupsResult.getOperatorType());
    assertTrue(actualCreateGroupsResult.getSubGroups().isEmpty());
    assertTrue(actualCreateGroupsResult.getIsTopGroup());
    assertEquals(GroupingTranslator.GROUPENDCHAR, phrases.get(0));
  }

  /**
   * Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  public void testCreateGroups15() throws MVELTranslationException {
    // Arrange and Act
    Group actualCreateGroupsResult = groupingTranslator.createGroups("[\\t\\n\\r]\t");

    // Assert
    List<String> phrases = actualCreateGroupsResult.getPhrases();
    assertEquals(1, phrases.size());
    assertEquals("[\\t\\n\\r]", phrases.get(0));
    assertEquals(BLCOperator.AND, actualCreateGroupsResult.getOperatorType());
    assertTrue(actualCreateGroupsResult.getSubGroups().isEmpty());
    assertTrue(actualCreateGroupsResult.getIsTopGroup());
  }

  /**
   * Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  public void testCreateGroups16() throws MVELTranslationException {
    // Arrange and Act
    Group actualCreateGroupsResult = groupingTranslator.createGroups("[\\t\\n\\r](");

    // Assert
    List<String> phrases = actualCreateGroupsResult.getPhrases();
    assertEquals(1, phrases.size());
    assertEquals("[\\t\\n\\r](", phrases.get(0));
    assertEquals(BLCOperator.AND, actualCreateGroupsResult.getOperatorType());
    assertTrue(actualCreateGroupsResult.getSubGroups().isEmpty());
    assertTrue(actualCreateGroupsResult.getIsTopGroup());
  }

  /**
   * Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  public void testCreateGroups17() throws MVELTranslationException {
    // Arrange, Act and Assert
    assertThrows(MVELTranslationException.class, () -> groupingTranslator.createGroups(";[\\t\\n\\r]"));
  }

  /**
   * Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  public void testCreateGroups18() throws MVELTranslationException {
    // Arrange, Act and Assert
    assertThrows(MVELTranslationException.class, () -> groupingTranslator.createGroups("(\t"));
  }

  /**
   * Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  public void testCreateGroups19() throws MVELTranslationException {
    // Arrange, Act and Assert
    assertThrows(MVELTranslationException.class, () -> groupingTranslator.createGroups("([\\t\\n\\r]"));
  }

  /**
   * Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  public void testCreateGroups20() throws MVELTranslationException {
    // Arrange and Act
    Group actualCreateGroupsResult = groupingTranslator.createGroups("()");

    // Assert
    List<Group> subGroups = actualCreateGroupsResult.getSubGroups();
    assertEquals(1, subGroups.size());
    Group getResult = subGroups.get(0);
    assertNull(getResult.getOperatorType());
    assertNull(actualCreateGroupsResult.getOperatorType());
    assertFalse(getResult.getIsTopGroup());
    assertTrue(getResult.getPhrases().isEmpty());
    assertTrue(actualCreateGroupsResult.getPhrases().isEmpty());
    assertTrue(getResult.getSubGroups().isEmpty());
    assertTrue(actualCreateGroupsResult.getIsTopGroup());
  }

  /**
   * Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  public void testCreateGroups21() throws MVELTranslationException {
    // Arrange and Act
    Group actualCreateGroupsResult = groupingTranslator.createGroups("&&\t");

    // Assert
    assertEquals(BLCOperator.AND, actualCreateGroupsResult.getOperatorType());
    assertTrue(actualCreateGroupsResult.getPhrases().isEmpty());
    assertTrue(actualCreateGroupsResult.getSubGroups().isEmpty());
    assertTrue(actualCreateGroupsResult.getIsTopGroup());
  }

  /**
   * Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  public void testCreateGroups22() throws MVELTranslationException {
    // Arrange and Act
    Group actualCreateGroupsResult = groupingTranslator.createGroups("&&[\\t\\n\\r]");

    // Assert
    List<String> phrases = actualCreateGroupsResult.getPhrases();
    assertEquals(1, phrases.size());
    assertEquals("[\\t\\n\\r]", phrases.get(0));
    assertEquals(BLCOperator.AND, actualCreateGroupsResult.getOperatorType());
    assertTrue(actualCreateGroupsResult.getSubGroups().isEmpty());
    assertTrue(actualCreateGroupsResult.getIsTopGroup());
  }

  /**
   * Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  public void testCreateGroups23() throws MVELTranslationException {
    // Arrange, Act and Assert
    assertThrows(MVELTranslationException.class, () -> groupingTranslator.createGroups("&&("));
  }

  /**
   * Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  public void testCreateGroups24() throws MVELTranslationException {
    // Arrange and Act
    Group actualCreateGroupsResult = groupingTranslator.createGroups("Mvel\t");

    // Assert
    List<String> phrases = actualCreateGroupsResult.getPhrases();
    assertEquals(1, phrases.size());
    assertEquals("Mvel", phrases.get(0));
    assertEquals(BLCOperator.AND, actualCreateGroupsResult.getOperatorType());
    assertTrue(actualCreateGroupsResult.getSubGroups().isEmpty());
    assertTrue(actualCreateGroupsResult.getIsTopGroup());
  }

  /**
   * Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  public void testCreateGroups25() throws MVELTranslationException {
    // Arrange and Act
    Group actualCreateGroupsResult = groupingTranslator.createGroups("\\|\\|\t");

    // Assert
    List<String> phrases = actualCreateGroupsResult.getPhrases();
    assertEquals(1, phrases.size());
    assertEquals("\\|\\|", phrases.get(0));
    assertEquals(BLCOperator.AND, actualCreateGroupsResult.getOperatorType());
    assertTrue(actualCreateGroupsResult.getSubGroups().isEmpty());
    assertTrue(actualCreateGroupsResult.getIsTopGroup());
  }

  /**
   * Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  public void testCreateGroups26() throws MVELTranslationException {
    // Arrange, Act and Assert
    assertThrows(MVELTranslationException.class, () -> groupingTranslator.createGroups("\\|\\|("));
  }

  /**
   * Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  public void testCreateGroups27() throws MVELTranslationException {
    // Arrange and Act
    Group actualCreateGroupsResult = groupingTranslator.createGroups("\\|\\|||");

    // Assert
    List<String> phrases = actualCreateGroupsResult.getPhrases();
    assertEquals(2, phrases.size());
    assertEquals("\\|\\", phrases.get(0));
    assertEquals("|", phrases.get(1));
    assertEquals(BLCOperator.OR, actualCreateGroupsResult.getOperatorType());
    assertTrue(actualCreateGroupsResult.getSubGroups().isEmpty());
    assertTrue(actualCreateGroupsResult.getIsTopGroup());
  }

  /**
   * Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  public void testCreateGroups28() throws MVELTranslationException {
    // Arrange and Act
    Group actualCreateGroupsResult = groupingTranslator.createGroups("42\t");

    // Assert
    List<String> phrases = actualCreateGroupsResult.getPhrases();
    assertEquals(1, phrases.size());
    assertEquals("42", phrases.get(0));
    assertEquals(BLCOperator.AND, actualCreateGroupsResult.getOperatorType());
    assertTrue(actualCreateGroupsResult.getSubGroups().isEmpty());
    assertTrue(actualCreateGroupsResult.getIsTopGroup());
  }

  /**
   * Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  public void testCreateGroups29() throws MVELTranslationException {
    // Arrange and Act
    Group actualCreateGroupsResult = groupingTranslator.createGroups("||\t");

    // Assert
    assertEquals(BLCOperator.OR, actualCreateGroupsResult.getOperatorType());
    assertTrue(actualCreateGroupsResult.getPhrases().isEmpty());
    assertTrue(actualCreateGroupsResult.getSubGroups().isEmpty());
    assertTrue(actualCreateGroupsResult.getIsTopGroup());
  }

  /**
   * Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  public void testCreateGroups30() throws MVELTranslationException {
    // Arrange and Act
    Group actualCreateGroupsResult = groupingTranslator.createGroups(")\t");

    // Assert
    List<String> phrases = actualCreateGroupsResult.getPhrases();
    assertEquals(1, phrases.size());
    assertEquals(BLCOperator.AND, actualCreateGroupsResult.getOperatorType());
    assertTrue(actualCreateGroupsResult.getSubGroups().isEmpty());
    assertTrue(actualCreateGroupsResult.getIsTopGroup());
    assertEquals(GroupingTranslator.GROUPENDCHAR, phrases.get(0));
  }

  /**
   * Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  public void testCreateGroups31() throws MVELTranslationException {
    // Arrange and Act
    Group actualCreateGroupsResult = groupingTranslator.createGroups("\t\t\t");

    // Assert
    assertNull(actualCreateGroupsResult.getOperatorType());
    assertTrue(actualCreateGroupsResult.getPhrases().isEmpty());
    assertTrue(actualCreateGroupsResult.getSubGroups().isEmpty());
    assertTrue(actualCreateGroupsResult.getIsTopGroup());
  }

  /**
   * Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  public void testCreateGroups32() throws MVELTranslationException {
    // Arrange and Act
    Group actualCreateGroupsResult = groupingTranslator.createGroups("\t\t[\\t\\n\\r]");

    // Assert
    List<String> phrases = actualCreateGroupsResult.getPhrases();
    assertEquals(1, phrases.size());
    assertEquals("[\\t\\n\\r]", phrases.get(0));
    assertEquals(BLCOperator.AND, actualCreateGroupsResult.getOperatorType());
    assertTrue(actualCreateGroupsResult.getSubGroups().isEmpty());
    assertTrue(actualCreateGroupsResult.getIsTopGroup());
  }

  /**
   * Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  public void testCreateGroups33() throws MVELTranslationException {
    // Arrange, Act and Assert
    assertThrows(MVELTranslationException.class, () -> groupingTranslator.createGroups("\t\t("));
  }

  /**
   * Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  public void testCreateGroups34() throws MVELTranslationException {
    // Arrange and Act
    Group actualCreateGroupsResult = groupingTranslator.createGroups("\t\t&&");

    // Assert
    assertEquals(BLCOperator.AND, actualCreateGroupsResult.getOperatorType());
    assertTrue(actualCreateGroupsResult.getPhrases().isEmpty());
    assertTrue(actualCreateGroupsResult.getSubGroups().isEmpty());
    assertTrue(actualCreateGroupsResult.getIsTopGroup());
  }

  /**
   * Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  public void testCreateGroups35() throws MVELTranslationException {
    // Arrange and Act
    Group actualCreateGroupsResult = groupingTranslator.createGroups("\t\tMvel");

    // Assert
    List<String> phrases = actualCreateGroupsResult.getPhrases();
    assertEquals(1, phrases.size());
    assertEquals("Mvel", phrases.get(0));
    assertEquals(BLCOperator.AND, actualCreateGroupsResult.getOperatorType());
    assertTrue(actualCreateGroupsResult.getSubGroups().isEmpty());
    assertTrue(actualCreateGroupsResult.getIsTopGroup());
  }

  /**
   * Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  public void testCreateGroups36() throws MVELTranslationException {
    // Arrange and Act
    Group actualCreateGroupsResult = groupingTranslator.createGroups("\t\t\\|\\|");

    // Assert
    List<String> phrases = actualCreateGroupsResult.getPhrases();
    assertEquals(1, phrases.size());
    assertEquals("\\|\\|", phrases.get(0));
    assertEquals(BLCOperator.AND, actualCreateGroupsResult.getOperatorType());
    assertTrue(actualCreateGroupsResult.getSubGroups().isEmpty());
    assertTrue(actualCreateGroupsResult.getIsTopGroup());
  }

  /**
   * Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  public void testCreateGroups37() throws MVELTranslationException {
    // Arrange and Act
    Group actualCreateGroupsResult = groupingTranslator.createGroups("\t\t42");

    // Assert
    List<String> phrases = actualCreateGroupsResult.getPhrases();
    assertEquals(1, phrases.size());
    assertEquals("42", phrases.get(0));
    assertEquals(BLCOperator.AND, actualCreateGroupsResult.getOperatorType());
    assertTrue(actualCreateGroupsResult.getSubGroups().isEmpty());
    assertTrue(actualCreateGroupsResult.getIsTopGroup());
  }

  /**
   * Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  public void testCreateGroups38() throws MVELTranslationException {
    // Arrange and Act
    Group actualCreateGroupsResult = groupingTranslator.createGroups("\t\t||");

    // Assert
    assertEquals(BLCOperator.OR, actualCreateGroupsResult.getOperatorType());
    assertTrue(actualCreateGroupsResult.getPhrases().isEmpty());
    assertTrue(actualCreateGroupsResult.getSubGroups().isEmpty());
    assertTrue(actualCreateGroupsResult.getIsTopGroup());
  }

  /**
   * Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  public void testCreateGroups39() throws MVELTranslationException {
    // Arrange and Act
    Group actualCreateGroupsResult = groupingTranslator.createGroups("\t\t)");

    // Assert
    List<String> phrases = actualCreateGroupsResult.getPhrases();
    assertEquals(1, phrases.size());
    assertEquals(BLCOperator.AND, actualCreateGroupsResult.getOperatorType());
    assertTrue(actualCreateGroupsResult.getSubGroups().isEmpty());
    assertTrue(actualCreateGroupsResult.getIsTopGroup());
    assertEquals(GroupingTranslator.GROUPENDCHAR, phrases.get(0));
  }

  /**
   * Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  public void testCreateGroups40() throws MVELTranslationException {
    // Arrange and Act
    Group actualCreateGroupsResult = groupingTranslator.createGroups("\t[\\t\\n\\r]\t");

    // Assert
    List<String> phrases = actualCreateGroupsResult.getPhrases();
    assertEquals(1, phrases.size());
    assertEquals("[\\t\\n\\r]", phrases.get(0));
    assertEquals(BLCOperator.AND, actualCreateGroupsResult.getOperatorType());
    assertTrue(actualCreateGroupsResult.getSubGroups().isEmpty());
    assertTrue(actualCreateGroupsResult.getIsTopGroup());
  }

  /**
   * Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  public void testCreateGroups41() throws MVELTranslationException {
    // Arrange and Act
    Group actualCreateGroupsResult = groupingTranslator.createGroups("\t[\\t\\n\\r][\\t\\n\\r]");

    // Assert
    List<String> phrases = actualCreateGroupsResult.getPhrases();
    assertEquals(1, phrases.size());
    assertEquals("[\\t\\n\\r][\\t\\n\\r]", phrases.get(0));
    assertEquals(BLCOperator.AND, actualCreateGroupsResult.getOperatorType());
    assertTrue(actualCreateGroupsResult.getSubGroups().isEmpty());
    assertTrue(actualCreateGroupsResult.getIsTopGroup());
  }

  /**
   * Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  public void testCreateGroups42() throws MVELTranslationException {
    // Arrange and Act
    Group actualCreateGroupsResult = groupingTranslator.createGroups("\t[\\t\\n\\r];");

    // Assert
    List<String> phrases = actualCreateGroupsResult.getPhrases();
    assertEquals(1, phrases.size());
    assertEquals("[\\t\\n\\r]", phrases.get(0));
    assertEquals(BLCOperator.AND, actualCreateGroupsResult.getOperatorType());
    assertTrue(actualCreateGroupsResult.getSubGroups().isEmpty());
    assertTrue(actualCreateGroupsResult.getIsTopGroup());
  }

  /**
   * Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  public void testCreateGroups43() throws MVELTranslationException {
    // Arrange and Act
    Group actualCreateGroupsResult = groupingTranslator.createGroups("\t[\\t\\n\\r](");

    // Assert
    List<String> phrases = actualCreateGroupsResult.getPhrases();
    assertEquals(1, phrases.size());
    assertEquals("[\\t\\n\\r](", phrases.get(0));
    assertEquals(BLCOperator.AND, actualCreateGroupsResult.getOperatorType());
    assertTrue(actualCreateGroupsResult.getSubGroups().isEmpty());
    assertTrue(actualCreateGroupsResult.getIsTopGroup());
  }

  /**
   * Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  public void testCreateGroups44() throws MVELTranslationException {
    // Arrange and Act
    Group actualCreateGroupsResult = groupingTranslator.createGroups("\t[\\t\\n\\r]&&");

    // Assert
    List<String> phrases = actualCreateGroupsResult.getPhrases();
    assertEquals(1, phrases.size());
    assertEquals("[\\t\\n\\r]", phrases.get(0));
    assertEquals(BLCOperator.AND, actualCreateGroupsResult.getOperatorType());
    assertTrue(actualCreateGroupsResult.getSubGroups().isEmpty());
    assertTrue(actualCreateGroupsResult.getIsTopGroup());
  }

  /**
   * Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  public void testCreateGroups45() throws MVELTranslationException {
    // Arrange and Act
    Group actualCreateGroupsResult = groupingTranslator.createGroups("\t[\\t\\n\\r]Mvel");

    // Assert
    List<String> phrases = actualCreateGroupsResult.getPhrases();
    assertEquals(1, phrases.size());
    assertEquals("[\\t\\n\\r]Mvel", phrases.get(0));
    assertEquals(BLCOperator.AND, actualCreateGroupsResult.getOperatorType());
    assertTrue(actualCreateGroupsResult.getSubGroups().isEmpty());
    assertTrue(actualCreateGroupsResult.getIsTopGroup());
  }

  /**
   * Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  public void testCreateGroups46() throws MVELTranslationException {
    // Arrange and Act
    Group actualCreateGroupsResult = groupingTranslator.createGroups("\t[\\t\\n\\r]\\|\\|");

    // Assert
    List<String> phrases = actualCreateGroupsResult.getPhrases();
    assertEquals(1, phrases.size());
    assertEquals("[\\t\\n\\r]\\|\\|", phrases.get(0));
    assertEquals(BLCOperator.AND, actualCreateGroupsResult.getOperatorType());
    assertTrue(actualCreateGroupsResult.getSubGroups().isEmpty());
    assertTrue(actualCreateGroupsResult.getIsTopGroup());
  }

  /**
   * Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  public void testCreateGroups47() throws MVELTranslationException {
    // Arrange and Act
    Group actualCreateGroupsResult = groupingTranslator.createGroups("\t[\\t\\n\\r]42");

    // Assert
    List<String> phrases = actualCreateGroupsResult.getPhrases();
    assertEquals(1, phrases.size());
    assertEquals("[\\t\\n\\r]42", phrases.get(0));
    assertEquals(BLCOperator.AND, actualCreateGroupsResult.getOperatorType());
    assertTrue(actualCreateGroupsResult.getSubGroups().isEmpty());
    assertTrue(actualCreateGroupsResult.getIsTopGroup());
  }

  /**
   * Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  public void testCreateGroups48() throws MVELTranslationException {
    // Arrange and Act
    Group actualCreateGroupsResult = groupingTranslator.createGroups("\t[\\t\\n\\r]||");

    // Assert
    List<String> phrases = actualCreateGroupsResult.getPhrases();
    assertEquals(1, phrases.size());
    assertEquals("[\\t\\n\\r]", phrases.get(0));
    assertEquals(BLCOperator.OR, actualCreateGroupsResult.getOperatorType());
    assertTrue(actualCreateGroupsResult.getSubGroups().isEmpty());
    assertTrue(actualCreateGroupsResult.getIsTopGroup());
  }

  /**
   * Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  public void testCreateGroups49() throws MVELTranslationException {
    // Arrange and Act
    Group actualCreateGroupsResult = groupingTranslator.createGroups("\t[\\t\\n\\r])");

    // Assert
    List<String> phrases = actualCreateGroupsResult.getPhrases();
    assertEquals(1, phrases.size());
    assertEquals("[\\t\\n\\r])", phrases.get(0));
    assertEquals(BLCOperator.AND, actualCreateGroupsResult.getOperatorType());
    assertTrue(actualCreateGroupsResult.getSubGroups().isEmpty());
    assertTrue(actualCreateGroupsResult.getIsTopGroup());
  }

  /**
   * Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  public void testCreateGroups50() throws MVELTranslationException {
    // Arrange, Act and Assert
    assertThrows(MVELTranslationException.class, () -> groupingTranslator.createGroups("\t;[\\t\\n\\r]"));
  }

  /**
   * Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  public void testCreateGroups51() throws MVELTranslationException {
    // Arrange, Act and Assert
    assertThrows(MVELTranslationException.class, () -> groupingTranslator.createGroups("\t;("));
  }

  /**
   * Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  public void testCreateGroups52() throws MVELTranslationException {
    // Arrange, Act and Assert
    assertThrows(MVELTranslationException.class, () -> groupingTranslator.createGroups("\t;&&"));
  }

  /**
   * Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  public void testCreateGroups53() throws MVELTranslationException {
    // Arrange, Act and Assert
    assertThrows(MVELTranslationException.class, () -> groupingTranslator.createGroups("\t;Mvel"));
  }

  /**
   * Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  public void testCreateGroups54() throws MVELTranslationException {
    // Arrange, Act and Assert
    assertThrows(MVELTranslationException.class, () -> groupingTranslator.createGroups("\t;\\|\\|"));
  }

  /**
   * Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  public void testCreateGroups55() throws MVELTranslationException {
    // Arrange, Act and Assert
    assertThrows(MVELTranslationException.class, () -> groupingTranslator.createGroups("\t;42"));
  }

  /**
   * Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  public void testCreateGroups56() throws MVELTranslationException {
    // Arrange, Act and Assert
    assertThrows(MVELTranslationException.class, () -> groupingTranslator.createGroups("\t;||"));
  }

  /**
   * Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  public void testCreateGroups57() throws MVELTranslationException {
    // Arrange, Act and Assert
    assertThrows(MVELTranslationException.class, () -> groupingTranslator.createGroups("\t;)"));
  }

  /**
   * Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  public void testCreateGroups58() throws MVELTranslationException {
    // Arrange, Act and Assert
    assertThrows(MVELTranslationException.class, () -> groupingTranslator.createGroups("\t(\t"));
  }

  /**
   * Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  public void testCreateGroups59() throws MVELTranslationException {
    // Arrange, Act and Assert
    assertThrows(MVELTranslationException.class, () -> groupingTranslator.createGroups("\t([\\t\\n\\r]"));
  }

  /**
   * Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  public void testCreateGroups60() throws MVELTranslationException {
    // Arrange, Act and Assert
    assertThrows(MVELTranslationException.class, () -> groupingTranslator.createGroups("\t(;"));
  }

  /**
   * Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  public void testCreateGroups61() throws MVELTranslationException {
    // Arrange, Act and Assert
    assertThrows(MVELTranslationException.class, () -> groupingTranslator.createGroups("\t(("));
  }

  /**
   * Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  public void testCreateGroups62() throws MVELTranslationException {
    // Arrange, Act and Assert
    assertThrows(MVELTranslationException.class, () -> groupingTranslator.createGroups("\t(&&"));
  }

  /**
   * Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  public void testCreateGroups63() throws MVELTranslationException {
    // Arrange, Act and Assert
    assertThrows(MVELTranslationException.class, () -> groupingTranslator.createGroups("\t(Mvel"));
  }

  /**
   * Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  public void testCreateGroups64() throws MVELTranslationException {
    // Arrange, Act and Assert
    assertThrows(MVELTranslationException.class, () -> groupingTranslator.createGroups("\t(\\|\\|"));
  }

  /**
   * Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  public void testCreateGroups65() throws MVELTranslationException {
    // Arrange, Act and Assert
    assertThrows(MVELTranslationException.class, () -> groupingTranslator.createGroups("\t(42"));
  }

  /**
   * Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  public void testCreateGroups66() throws MVELTranslationException {
    // Arrange, Act and Assert
    assertThrows(MVELTranslationException.class, () -> groupingTranslator.createGroups("\t(||"));
  }

  /**
   * Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  public void testCreateGroups67() throws MVELTranslationException {
    // Arrange and Act
    Group actualCreateGroupsResult = groupingTranslator.createGroups("\t()");

    // Assert
    List<Group> subGroups = actualCreateGroupsResult.getSubGroups();
    assertEquals(1, subGroups.size());
    Group getResult = subGroups.get(0);
    assertNull(getResult.getOperatorType());
    assertNull(actualCreateGroupsResult.getOperatorType());
    assertFalse(getResult.getIsTopGroup());
    assertTrue(getResult.getPhrases().isEmpty());
    assertTrue(actualCreateGroupsResult.getPhrases().isEmpty());
    assertTrue(getResult.getSubGroups().isEmpty());
    assertTrue(actualCreateGroupsResult.getIsTopGroup());
  }

  /**
   * Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  public void testCreateGroups68() throws MVELTranslationException {
    // Arrange and Act
    Group actualCreateGroupsResult = groupingTranslator.createGroups("\t&&\t");

    // Assert
    assertEquals(BLCOperator.AND, actualCreateGroupsResult.getOperatorType());
    assertTrue(actualCreateGroupsResult.getPhrases().isEmpty());
    assertTrue(actualCreateGroupsResult.getSubGroups().isEmpty());
    assertTrue(actualCreateGroupsResult.getIsTopGroup());
  }

  /**
   * Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  public void testCreateGroups69() throws MVELTranslationException {
    // Arrange and Act
    Group actualCreateGroupsResult = groupingTranslator.createGroups("\t&&[\\t\\n\\r]");

    // Assert
    List<String> phrases = actualCreateGroupsResult.getPhrases();
    assertEquals(1, phrases.size());
    assertEquals("[\\t\\n\\r]", phrases.get(0));
    assertEquals(BLCOperator.AND, actualCreateGroupsResult.getOperatorType());
    assertTrue(actualCreateGroupsResult.getSubGroups().isEmpty());
    assertTrue(actualCreateGroupsResult.getIsTopGroup());
  }

  /**
   * Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  public void testCreateGroups70() throws MVELTranslationException {
    // Arrange and Act
    Group actualCreateGroupsResult = groupingTranslator.createGroups("\t&&;");

    // Assert
    assertEquals(BLCOperator.AND, actualCreateGroupsResult.getOperatorType());
    assertTrue(actualCreateGroupsResult.getPhrases().isEmpty());
    assertTrue(actualCreateGroupsResult.getSubGroups().isEmpty());
    assertTrue(actualCreateGroupsResult.getIsTopGroup());
  }

  /**
   * Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  public void testCreateGroups71() throws MVELTranslationException {
    // Arrange, Act and Assert
    assertThrows(MVELTranslationException.class, () -> groupingTranslator.createGroups("\t&&("));
  }

  /**
   * Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  public void testCreateGroups72() throws MVELTranslationException {
    // Arrange and Act
    Group actualCreateGroupsResult = groupingTranslator.createGroups("\t&&&&");

    // Assert
    assertEquals(BLCOperator.AND, actualCreateGroupsResult.getOperatorType());
    assertTrue(actualCreateGroupsResult.getPhrases().isEmpty());
    assertTrue(actualCreateGroupsResult.getSubGroups().isEmpty());
    assertTrue(actualCreateGroupsResult.getIsTopGroup());
  }

  /**
   * Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  public void testCreateGroups73() throws MVELTranslationException {
    // Arrange and Act
    Group actualCreateGroupsResult = groupingTranslator.createGroups("\t&&Mvel");

    // Assert
    List<String> phrases = actualCreateGroupsResult.getPhrases();
    assertEquals(1, phrases.size());
    assertEquals("Mvel", phrases.get(0));
    assertEquals(BLCOperator.AND, actualCreateGroupsResult.getOperatorType());
    assertTrue(actualCreateGroupsResult.getSubGroups().isEmpty());
    assertTrue(actualCreateGroupsResult.getIsTopGroup());
  }

  /**
   * Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  public void testCreateGroups74() throws MVELTranslationException {
    // Arrange and Act
    Group actualCreateGroupsResult = groupingTranslator.createGroups("\t&&\\|\\|");

    // Assert
    List<String> phrases = actualCreateGroupsResult.getPhrases();
    assertEquals(1, phrases.size());
    assertEquals("\\|\\|", phrases.get(0));
    assertEquals(BLCOperator.AND, actualCreateGroupsResult.getOperatorType());
    assertTrue(actualCreateGroupsResult.getSubGroups().isEmpty());
    assertTrue(actualCreateGroupsResult.getIsTopGroup());
  }

  /**
   * Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  public void testCreateGroups75() throws MVELTranslationException {
    // Arrange and Act
    Group actualCreateGroupsResult = groupingTranslator.createGroups("\t&&42");

    // Assert
    List<String> phrases = actualCreateGroupsResult.getPhrases();
    assertEquals(1, phrases.size());
    assertEquals("42", phrases.get(0));
    assertEquals(BLCOperator.AND, actualCreateGroupsResult.getOperatorType());
    assertTrue(actualCreateGroupsResult.getSubGroups().isEmpty());
    assertTrue(actualCreateGroupsResult.getIsTopGroup());
  }

  /**
   * Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  public void testCreateGroups76() throws MVELTranslationException {
    // Arrange and Act
    Group actualCreateGroupsResult = groupingTranslator.createGroups("\t&&||");

    // Assert
    List<String> phrases = actualCreateGroupsResult.getPhrases();
    assertEquals(1, phrases.size());
    assertEquals("||", phrases.get(0));
    assertEquals(BLCOperator.AND, actualCreateGroupsResult.getOperatorType());
    assertTrue(actualCreateGroupsResult.getSubGroups().isEmpty());
    assertTrue(actualCreateGroupsResult.getIsTopGroup());
  }

  /**
   * Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  public void testCreateGroups77() throws MVELTranslationException {
    // Arrange and Act
    Group actualCreateGroupsResult = groupingTranslator.createGroups("\t&&)");

    // Assert
    List<String> phrases = actualCreateGroupsResult.getPhrases();
    assertEquals(1, phrases.size());
    assertEquals(BLCOperator.AND, actualCreateGroupsResult.getOperatorType());
    assertTrue(actualCreateGroupsResult.getSubGroups().isEmpty());
    assertTrue(actualCreateGroupsResult.getIsTopGroup());
    assertEquals(GroupingTranslator.GROUPENDCHAR, phrases.get(0));
  }

  /**
   * Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  public void testCreateGroups78() throws MVELTranslationException {
    // Arrange and Act
    Group actualCreateGroupsResult = groupingTranslator.createGroups("\tMvel\t");

    // Assert
    List<String> phrases = actualCreateGroupsResult.getPhrases();
    assertEquals(1, phrases.size());
    assertEquals("Mvel", phrases.get(0));
    assertEquals(BLCOperator.AND, actualCreateGroupsResult.getOperatorType());
    assertTrue(actualCreateGroupsResult.getSubGroups().isEmpty());
    assertTrue(actualCreateGroupsResult.getIsTopGroup());
  }

  /**
   * Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  public void testCreateGroups79() throws MVELTranslationException {
    // Arrange and Act
    Group actualCreateGroupsResult = groupingTranslator.createGroups("\tMvel[\\t\\n\\r]");

    // Assert
    List<String> phrases = actualCreateGroupsResult.getPhrases();
    assertEquals(1, phrases.size());
    assertEquals("Mvel[\\t\\n\\r]", phrases.get(0));
    assertEquals(BLCOperator.AND, actualCreateGroupsResult.getOperatorType());
    assertTrue(actualCreateGroupsResult.getSubGroups().isEmpty());
    assertTrue(actualCreateGroupsResult.getIsTopGroup());
  }

  /**
   * Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  public void testCreateGroups80() throws MVELTranslationException {
    // Arrange and Act
    Group actualCreateGroupsResult = groupingTranslator.createGroups("\tMvel;");

    // Assert
    List<String> phrases = actualCreateGroupsResult.getPhrases();
    assertEquals(1, phrases.size());
    assertEquals("Mvel", phrases.get(0));
    assertEquals(BLCOperator.AND, actualCreateGroupsResult.getOperatorType());
    assertTrue(actualCreateGroupsResult.getSubGroups().isEmpty());
    assertTrue(actualCreateGroupsResult.getIsTopGroup());
  }

  /**
   * Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  public void testCreateGroups81() throws MVELTranslationException {
    // Arrange and Act
    Group actualCreateGroupsResult = groupingTranslator.createGroups("\tMvel(");

    // Assert
    List<String> phrases = actualCreateGroupsResult.getPhrases();
    assertEquals(1, phrases.size());
    assertEquals("Mvel(", phrases.get(0));
    assertEquals(BLCOperator.AND, actualCreateGroupsResult.getOperatorType());
    assertTrue(actualCreateGroupsResult.getSubGroups().isEmpty());
    assertTrue(actualCreateGroupsResult.getIsTopGroup());
  }

  /**
   * Method under test: {@link GroupingTranslator#findGroupStart(String, int)}
   */
  @Test
  public void testFindGroupStart() {
    // Arrange, Act and Assert
    assertEquals(-1, groupingTranslator.findGroupStart("Segment", 1));
  }

  /**
   * Method under test: {@link GroupingTranslator#findGroupEnd(String, int)}
   */
  @Test
  public void testFindGroupEnd() throws MVELTranslationException {
    // Arrange, Act and Assert
    assertThrows(MVELTranslationException.class, () -> groupingTranslator.findGroupEnd("Segment", 1));
    assertThrows(MVELTranslationException.class,
        () -> groupingTranslator.findGroupEnd("Unable to find an end parenthesis for the group started at (", 1));
  }

  /**
   * Method under test: {@link GroupingTranslator#stripWhiteSpace(String)}
   */
  @Test
  public void testStripWhiteSpace() {
    // Arrange, Act and Assert
    assertEquals("Mvel", groupingTranslator.stripWhiteSpace("Mvel"));
    assertEquals("", groupingTranslator.stripWhiteSpace("\t"));
    assertEquals("", groupingTranslator.stripWhiteSpace("\t\t"));
    assertEquals("[\\t\\n\\r]", groupingTranslator.stripWhiteSpace("\t[\\t\\n\\r]"));
    assertEquals("Mvel", groupingTranslator.stripWhiteSpace("\tMvel"));
    assertEquals("&&", groupingTranslator.stripWhiteSpace("\t&&"));
    assertEquals("42", groupingTranslator.stripWhiteSpace("\t42"));
    assertEquals(GroupingTranslator.GROUPSTARTCHAR, groupingTranslator.stripWhiteSpace("\t("));
    assertEquals(GroupingTranslator.GROUPENDCHAR, groupingTranslator.stripWhiteSpace("\t)"));
    assertEquals(GroupingTranslator.STATEMENTENDCHAR, groupingTranslator.stripWhiteSpace("\t;"));
    assertEquals("\\|\\|", groupingTranslator.stripWhiteSpace("\t\\|\\|"));
    assertEquals("||", groupingTranslator.stripWhiteSpace("\t||"));
    assertEquals("[\\t\\n\\r]", groupingTranslator.stripWhiteSpace("[\\t\\n\\r]\t"));
    assertEquals("Mvel", groupingTranslator.stripWhiteSpace("Mvel\t"));
    assertEquals("&&", groupingTranslator.stripWhiteSpace("&&\t"));
    assertEquals("42", groupingTranslator.stripWhiteSpace("42\t"));
    assertEquals(GroupingTranslator.GROUPSTARTCHAR, groupingTranslator.stripWhiteSpace("(\t"));
    assertEquals(GroupingTranslator.GROUPENDCHAR, groupingTranslator.stripWhiteSpace(")\t"));
    assertEquals(GroupingTranslator.STATEMENTENDCHAR, groupingTranslator.stripWhiteSpace(";\t"));
    assertEquals("\\|\\|", groupingTranslator.stripWhiteSpace("\\|\\|\t"));
    assertEquals("||", groupingTranslator.stripWhiteSpace("||\t"));
    assertEquals("", groupingTranslator.stripWhiteSpace("\t\t\t"));
    assertEquals("[\\t\\n\\r]", groupingTranslator.stripWhiteSpace("\t\t[\\t\\n\\r]"));
    assertEquals("Mvel", groupingTranslator.stripWhiteSpace("\t\tMvel"));
    assertEquals("&&", groupingTranslator.stripWhiteSpace("\t\t&&"));
    assertEquals("42", groupingTranslator.stripWhiteSpace("\t\t42"));
    assertEquals(GroupingTranslator.GROUPSTARTCHAR, groupingTranslator.stripWhiteSpace("\t\t("));
    assertEquals(GroupingTranslator.GROUPENDCHAR, groupingTranslator.stripWhiteSpace("\t\t)"));
    assertEquals(GroupingTranslator.STATEMENTENDCHAR, groupingTranslator.stripWhiteSpace("\t\t;"));
    assertEquals("\\|\\|", groupingTranslator.stripWhiteSpace("\t\t\\|\\|"));
    assertEquals("||", groupingTranslator.stripWhiteSpace("\t\t||"));
    assertEquals("[\\t\\n\\r]", groupingTranslator.stripWhiteSpace("\t[\\t\\n\\r]\t"));
    assertEquals("[\\t\\n\\r][\\t\\n\\r]", groupingTranslator.stripWhiteSpace("\t[\\t\\n\\r][\\t\\n\\r]"));
    assertEquals("[\\t\\n\\r]Mvel", groupingTranslator.stripWhiteSpace("\t[\\t\\n\\r]Mvel"));
    assertEquals("[\\t\\n\\r]&&", groupingTranslator.stripWhiteSpace("\t[\\t\\n\\r]&&"));
    assertEquals("[\\t\\n\\r]42", groupingTranslator.stripWhiteSpace("\t[\\t\\n\\r]42"));
    assertEquals("[\\t\\n\\r](", groupingTranslator.stripWhiteSpace("\t[\\t\\n\\r]("));
    assertEquals("[\\t\\n\\r])", groupingTranslator.stripWhiteSpace("\t[\\t\\n\\r])"));
    assertEquals("[\\t\\n\\r];", groupingTranslator.stripWhiteSpace("\t[\\t\\n\\r];"));
    assertEquals("[\\t\\n\\r]\\|\\|", groupingTranslator.stripWhiteSpace("\t[\\t\\n\\r]\\|\\|"));
    assertEquals("[\\t\\n\\r]||", groupingTranslator.stripWhiteSpace("\t[\\t\\n\\r]||"));
    assertEquals("Mvel", groupingTranslator.stripWhiteSpace("\tMvel\t"));
    assertEquals("Mvel[\\t\\n\\r]", groupingTranslator.stripWhiteSpace("\tMvel[\\t\\n\\r]"));
    assertEquals("MvelMvel", groupingTranslator.stripWhiteSpace("\tMvelMvel"));
    assertEquals("Mvel&&", groupingTranslator.stripWhiteSpace("\tMvel&&"));
    assertEquals("Mvel42", groupingTranslator.stripWhiteSpace("\tMvel42"));
    assertEquals("Mvel(", groupingTranslator.stripWhiteSpace("\tMvel("));
    assertEquals("Mvel)", groupingTranslator.stripWhiteSpace("\tMvel)"));
    assertEquals("Mvel;", groupingTranslator.stripWhiteSpace("\tMvel;"));
    assertEquals("Mvel\\|\\|", groupingTranslator.stripWhiteSpace("\tMvel\\|\\|"));
    assertEquals("Mvel||", groupingTranslator.stripWhiteSpace("\tMvel||"));
    assertEquals("&&", groupingTranslator.stripWhiteSpace("\t&&\t"));
    assertEquals("&&[\\t\\n\\r]", groupingTranslator.stripWhiteSpace("\t&&[\\t\\n\\r]"));
    assertEquals("&&Mvel", groupingTranslator.stripWhiteSpace("\t&&Mvel"));
    assertEquals("&&&&", groupingTranslator.stripWhiteSpace("\t&&&&"));
    assertEquals("&&42", groupingTranslator.stripWhiteSpace("\t&&42"));
    assertEquals("&&(", groupingTranslator.stripWhiteSpace("\t&&("));
    assertEquals("&&)", groupingTranslator.stripWhiteSpace("\t&&)"));
    assertEquals("&&;", groupingTranslator.stripWhiteSpace("\t&&;"));
    assertEquals("&&\\|\\|", groupingTranslator.stripWhiteSpace("\t&&\\|\\|"));
    assertEquals("&&||", groupingTranslator.stripWhiteSpace("\t&&||"));
    assertEquals("42", groupingTranslator.stripWhiteSpace("\t42\t"));
    assertEquals("42[\\t\\n\\r]", groupingTranslator.stripWhiteSpace("\t42[\\t\\n\\r]"));
    assertEquals("42Mvel", groupingTranslator.stripWhiteSpace("\t42Mvel"));
    assertEquals("42&&", groupingTranslator.stripWhiteSpace("\t42&&"));
    assertEquals("4242", groupingTranslator.stripWhiteSpace("\t4242"));
    assertEquals("42(", groupingTranslator.stripWhiteSpace("\t42("));
    assertEquals("42)", groupingTranslator.stripWhiteSpace("\t42)"));
    assertEquals("42;", groupingTranslator.stripWhiteSpace("\t42;"));
    assertEquals("42\\|\\|", groupingTranslator.stripWhiteSpace("\t42\\|\\|"));
    assertEquals("42||", groupingTranslator.stripWhiteSpace("\t42||"));
    assertEquals(GroupingTranslator.GROUPSTARTCHAR, groupingTranslator.stripWhiteSpace("\t(\t"));
    assertEquals("([\\t\\n\\r]", groupingTranslator.stripWhiteSpace("\t([\\t\\n\\r]"));
    assertEquals("(Mvel", groupingTranslator.stripWhiteSpace("\t(Mvel"));
    assertEquals("(&&", groupingTranslator.stripWhiteSpace("\t(&&"));
    assertEquals("(42", groupingTranslator.stripWhiteSpace("\t(42"));
  }

  /**
   * Method under test: {@link GroupingTranslator#parseGroups(Group, String)}
   */
  @Test
  public void testParseGroups() throws MVELTranslationException {
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
   * Method under test: {@link GroupingTranslator#parseGroups(Group, String)}
   */
  @Test
  public void testParseGroups2() throws MVELTranslationException {
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
   * Method under test: {@link GroupingTranslator#parseGroups(Group, String)}
   */
  @Test
  public void testParseGroups3() throws MVELTranslationException {
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
   * Method under test: {@link GroupingTranslator#parseGroups(Group, String)}
   */
  @Test
  public void testParseGroups4() throws MVELTranslationException {
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
   * Method under test: {@link GroupingTranslator#parseGroups(Group, String)}
   */
  @Test
  public void testParseGroups5() throws MVELTranslationException {
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
   * Method under test: {@link GroupingTranslator#parseGroups(Group, String)}
   */
  @Test
  public void testParseGroups6() throws MVELTranslationException {
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
   * Method under test: {@link GroupingTranslator#parseGroups(Group, String)}
   */
  @Test
  public void testParseGroups7() throws MVELTranslationException {
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
   * Method under test: {@link GroupingTranslator#parseGroups(Group, String)}
   */
  @Test
  public void testParseGroups8() throws MVELTranslationException {
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
   * Method under test: {@link GroupingTranslator#parseGroups(Group, String)}
   */
  @Test
  public void testParseGroups9() throws MVELTranslationException {
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
   * Method under test:
   * {@link GroupingTranslator#compilePhrases(String, Group, boolean)}
   */
  @Test
  public void testCompilePhrases() throws MVELTranslationException {
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
   * Method under test:
   * {@link GroupingTranslator#compilePhrases(String, Group, boolean)}
   */
  @Test
  public void testCompilePhrases2() throws MVELTranslationException {
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
   * Method under test:
   * {@link GroupingTranslator#compilePhrases(String, Group, boolean)}
   */
  @Test
  public void testCompilePhrases3() throws MVELTranslationException {
    // Arrange
    Group myGroup = new Group();
    myGroup.setIsTopGroup(true);
    myGroup.setOperatorType(BLCOperator.EQUALS);

    // Act and Assert
    assertThrows(MVELTranslationException.class, () -> groupingTranslator.compilePhrases("||", myGroup, true));
  }

  /**
   * Method under test:
   * {@link GroupingTranslator#compilePhrases(String, Group, boolean)}
   */
  @Test
  public void testCompilePhrases4() throws MVELTranslationException {
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
   * Method under test:
   * {@link GroupingTranslator#compilePhrases(String, Group, boolean)}
   */
  @Test
  public void testCompilePhrases5() throws MVELTranslationException {
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
   * Method under test:
   * {@link GroupingTranslator#compilePhrases(String, Group, boolean)}
   */
  @Test
  public void testCompilePhrases6() throws MVELTranslationException {
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
   * Method under test:
   * {@link GroupingTranslator#compilePhrases(String, Group, boolean)}
   */
  @Test
  public void testCompilePhrases7() throws MVELTranslationException {
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
   * Method under test:
   * {@link GroupingTranslator#compilePhrases(String, Group, boolean)}
   */
  @Test
  public void testCompilePhrases8() throws MVELTranslationException {
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
   * Method under test:
   * {@link GroupingTranslator#setGroupOperator(String, Group, boolean, boolean, boolean)}
   */
  @Test
  public void testSetGroupOperator() throws MVELTranslationException {
    // Arrange
    Group myGroup = new Group();
    myGroup.setIsTopGroup(true);
    myGroup.setOperatorType(BLCOperator.EQUALS);

    // Act and Assert
    assertThrows(MVELTranslationException.class,
        () -> groupingTranslator.setGroupOperator("Segment", myGroup, true, true, true));
  }

  /**
   * Method under test:
   * {@link GroupingTranslator#setGroupOperator(String, Group, boolean, boolean, boolean)}
   */
  @Test
  public void testSetGroupOperator2() throws MVELTranslationException {
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
   * Method under test:
   * {@link GroupingTranslator#setGroupOperator(String, Group, boolean, boolean, boolean)}
   */
  @Test
  public void testSetGroupOperator3() throws MVELTranslationException {
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
}
