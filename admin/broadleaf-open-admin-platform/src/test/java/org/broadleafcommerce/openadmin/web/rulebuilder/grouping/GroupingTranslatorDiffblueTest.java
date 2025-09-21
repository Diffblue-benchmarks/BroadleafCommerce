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
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.List;
import org.broadleafcommerce.openadmin.web.rulebuilder.BLCOperator;
import org.broadleafcommerce.openadmin.web.rulebuilder.MVELTranslationException;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {GroupingTranslator.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class GroupingTranslatorDiffblueTest {
  @Autowired private GroupingTranslator groupingTranslator;

  /**
   * Test {@link GroupingTranslator#createGroups(String)}.
   *
   * <p>Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Group GroupingTranslator.createGroups(String)"})
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
   *
   * <p>Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Group GroupingTranslator.createGroups(String)"})
  public void testCreateGroups2() throws MVELTranslationException {
    // Arrange and Act
    Group actualCreateGroupsResult = new GroupingTranslator().createGroups("\t\\|\\|&&");

    // Assert
    List<String> phrases = actualCreateGroupsResult.getPhrases();
    assertEquals(1, phrases.size());
    assertEquals("\\|\\|", phrases.get(0));
    assertEquals(BLCOperator.AND, actualCreateGroupsResult.getOperatorType());
    assertTrue(actualCreateGroupsResult.getSubGroups().isEmpty());
  }

  /**
   * Test {@link GroupingTranslator#createGroups(String)}.
   *
   * <p>Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Group GroupingTranslator.createGroups(String)"})
  public void testCreateGroups3() throws MVELTranslationException {
    // Arrange and Act
    Group actualCreateGroupsResult = new GroupingTranslator().createGroups("\t\\|\\|\\|\\|");

    // Assert
    List<String> phrases = actualCreateGroupsResult.getPhrases();
    assertEquals(1, phrases.size());
    assertEquals("\\|\\|\\|\\|", phrases.get(0));
    assertEquals(BLCOperator.AND, actualCreateGroupsResult.getOperatorType());
    assertTrue(actualCreateGroupsResult.getSubGroups().isEmpty());
  }

  /**
   * Test {@link GroupingTranslator#createGroups(String)}.
   *
   * <p>Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Group GroupingTranslator.createGroups(String)"})
  public void testCreateGroups4() throws MVELTranslationException {
    // Arrange and Act
    Group actualCreateGroupsResult = new GroupingTranslator().createGroups("\t\\|\\|)");

    // Assert
    List<String> phrases = actualCreateGroupsResult.getPhrases();
    assertEquals(1, phrases.size());
    assertEquals("\\|\\|)", phrases.get(0));
    assertEquals(BLCOperator.AND, actualCreateGroupsResult.getOperatorType());
    assertTrue(actualCreateGroupsResult.getSubGroups().isEmpty());
  }

  /**
   * Test {@link GroupingTranslator#createGroups(String)}.
   *
   * <p>Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Group GroupingTranslator.createGroups(String)"})
  public void testCreateGroups5() throws MVELTranslationException {
    // Arrange and Act
    Group actualCreateGroupsResult = new GroupingTranslator().createGroups("\t||\\|\\|");

    // Assert
    List<String> phrases = actualCreateGroupsResult.getPhrases();
    assertEquals(1, phrases.size());
    assertEquals("\\|\\|", phrases.get(0));
    assertEquals(BLCOperator.OR, actualCreateGroupsResult.getOperatorType());
    assertTrue(actualCreateGroupsResult.getSubGroups().isEmpty());
  }

  /**
   * Test {@link GroupingTranslator#createGroups(String)}.
   *
   * <p>Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Group GroupingTranslator.createGroups(String)"})
  public void testCreateGroups6() throws MVELTranslationException {
    // Arrange and Act
    Group actualCreateGroupsResult = new GroupingTranslator().createGroups("\t)\\|\\|");

    // Assert
    List<String> phrases = actualCreateGroupsResult.getPhrases();
    assertEquals(1, phrases.size());
    assertEquals(")\\|\\|", phrases.get(0));
    assertEquals(BLCOperator.AND, actualCreateGroupsResult.getOperatorType());
    assertTrue(actualCreateGroupsResult.getSubGroups().isEmpty());
  }

  /**
   * Test {@link GroupingTranslator#createGroups(String)}.
   *
   * <ul>
   *   <li>Given {@link GroupingTranslator} (default constructor).
   *   <li>When {@code 42[\t\n\r]}.
   *   <li>Then return Phrases first is {@code 42[\t\n\r]}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Group GroupingTranslator.createGroups(String)"})
  public void testCreateGroups_givenGroupingTranslator_when42TNR_thenReturnPhrasesFirstIs42TNR()
      throws MVELTranslationException {
    // Arrange and Act
    Group actualCreateGroupsResult = new GroupingTranslator().createGroups("\t42[\\t\\n\\r]");

    // Assert
    List<String> phrases = actualCreateGroupsResult.getPhrases();
    assertEquals(1, phrases.size());
    assertEquals("42[\\t\\n\\r]", phrases.get(0));
    assertEquals(BLCOperator.AND, actualCreateGroupsResult.getOperatorType());
    assertTrue(actualCreateGroupsResult.getSubGroups().isEmpty());
  }

  /**
   * Test {@link GroupingTranslator#createGroups(String)}.
   *
   * <ul>
   *   <li>Given {@link GroupingTranslator}.
   *   <li>When {@code 42}.
   *   <li>Then return Phrases first is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Group GroupingTranslator.createGroups(String)"})
  public void testCreateGroups_givenGroupingTranslator_when42_thenReturnPhrasesFirstIs42()
      throws MVELTranslationException {
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
   *
   * <ul>
   *   <li>Given {@link GroupingTranslator}.
   *   <li>When {@code 42}.
   *   <li>Then return Phrases first is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Group GroupingTranslator.createGroups(String)"})
  public void testCreateGroups_givenGroupingTranslator_when42_thenReturnPhrasesFirstIs422()
      throws MVELTranslationException {
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
   *
   * <ul>
   *   <li>Given {@link GroupingTranslator}.
   *   <li>When {@code 42}.
   *   <li>Then return Phrases first is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Group GroupingTranslator.createGroups(String)"})
  public void testCreateGroups_givenGroupingTranslator_when42_thenReturnPhrasesFirstIs423()
      throws MVELTranslationException {
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
   *
   * <ul>
   *   <li>Given {@link GroupingTranslator}.
   *   <li>When {@code &&42}.
   *   <li>Then return Phrases first is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Group GroupingTranslator.createGroups(String)"})
  public void testCreateGroups_givenGroupingTranslator_when42_thenReturnPhrasesFirstIs424()
      throws MVELTranslationException {
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
   *
   * <ul>
   *   <li>Given {@link GroupingTranslator} (default constructor).
   *   <li>When {@code \|\|42}.
   *   <li>Then return Phrases first is {@code \|\|42}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Group GroupingTranslator.createGroups(String)"})
  public void testCreateGroups_givenGroupingTranslator_when42_thenReturnPhrasesFirstIs425()
      throws MVELTranslationException {
    // Arrange and Act
    Group actualCreateGroupsResult = new GroupingTranslator().createGroups("\t\\|\\|42");

    // Assert
    List<String> phrases = actualCreateGroupsResult.getPhrases();
    assertEquals(1, phrases.size());
    assertEquals("\\|\\|42", phrases.get(0));
    assertEquals(BLCOperator.AND, actualCreateGroupsResult.getOperatorType());
    assertTrue(actualCreateGroupsResult.getSubGroups().isEmpty());
  }

  /**
   * Test {@link GroupingTranslator#createGroups(String)}.
   *
   * <ul>
   *   <li>Given {@link GroupingTranslator} (default constructor).
   *   <li>When {@code 42}.
   *   <li>Then return Phrases first is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Group GroupingTranslator.createGroups(String)"})
  public void testCreateGroups_givenGroupingTranslator_when42_thenReturnPhrasesFirstIs426()
      throws MVELTranslationException {
    // Arrange and Act
    Group actualCreateGroupsResult = new GroupingTranslator().createGroups("\t42\t");

    // Assert
    List<String> phrases = actualCreateGroupsResult.getPhrases();
    assertEquals(1, phrases.size());
    assertEquals("42", phrases.get(0));
    assertEquals(BLCOperator.AND, actualCreateGroupsResult.getOperatorType());
    assertTrue(actualCreateGroupsResult.getSubGroups().isEmpty());
  }

  /**
   * Test {@link GroupingTranslator#createGroups(String)}.
   *
   * <ul>
   *   <li>Given {@link GroupingTranslator} (default constructor).
   *   <li>When {@code 42;}.
   *   <li>Then return Phrases first is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Group GroupingTranslator.createGroups(String)"})
  public void testCreateGroups_givenGroupingTranslator_when42_thenReturnPhrasesFirstIs427()
      throws MVELTranslationException {
    // Arrange and Act
    Group actualCreateGroupsResult = new GroupingTranslator().createGroups("\t42;");

    // Assert
    List<String> phrases = actualCreateGroupsResult.getPhrases();
    assertEquals(1, phrases.size());
    assertEquals("42", phrases.get(0));
    assertEquals(BLCOperator.AND, actualCreateGroupsResult.getOperatorType());
    assertTrue(actualCreateGroupsResult.getSubGroups().isEmpty());
  }

  /**
   * Test {@link GroupingTranslator#createGroups(String)}.
   *
   * <ul>
   *   <li>Given {@link GroupingTranslator} (default constructor).
   *   <li>When {@code 42(}.
   *   <li>Then return Phrases first is {@code 42(}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Group GroupingTranslator.createGroups(String)"})
  public void testCreateGroups_givenGroupingTranslator_when42_thenReturnPhrasesFirstIs428()
      throws MVELTranslationException {
    // Arrange and Act
    Group actualCreateGroupsResult = new GroupingTranslator().createGroups("\t42(");

    // Assert
    List<String> phrases = actualCreateGroupsResult.getPhrases();
    assertEquals(1, phrases.size());
    assertEquals("42(", phrases.get(0));
    assertEquals(BLCOperator.AND, actualCreateGroupsResult.getOperatorType());
    assertTrue(actualCreateGroupsResult.getSubGroups().isEmpty());
  }

  /**
   * Test {@link GroupingTranslator#createGroups(String)}.
   *
   * <ul>
   *   <li>Given {@link GroupingTranslator} (default constructor).
   *   <li>When {@code 42&&}.
   *   <li>Then return Phrases first is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Group GroupingTranslator.createGroups(String)"})
  public void testCreateGroups_givenGroupingTranslator_when42_thenReturnPhrasesFirstIs429()
      throws MVELTranslationException {
    // Arrange and Act
    Group actualCreateGroupsResult = new GroupingTranslator().createGroups("\t42&&");

    // Assert
    List<String> phrases = actualCreateGroupsResult.getPhrases();
    assertEquals(1, phrases.size());
    assertEquals("42", phrases.get(0));
    assertEquals(BLCOperator.AND, actualCreateGroupsResult.getOperatorType());
    assertTrue(actualCreateGroupsResult.getSubGroups().isEmpty());
  }

  /**
   * Test {@link GroupingTranslator#createGroups(String)}.
   *
   * <ul>
   *   <li>Given {@link GroupingTranslator} (default constructor).
   *   <li>When {@code 42\|\|}.
   *   <li>Then return Phrases first is {@code 42\|\|}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Group GroupingTranslator.createGroups(String)"})
  public void testCreateGroups_givenGroupingTranslator_when42_thenReturnPhrasesFirstIs4210()
      throws MVELTranslationException {
    // Arrange and Act
    Group actualCreateGroupsResult = new GroupingTranslator().createGroups("\t42\\|\\|");

    // Assert
    List<String> phrases = actualCreateGroupsResult.getPhrases();
    assertEquals(1, phrases.size());
    assertEquals("42\\|\\|", phrases.get(0));
    assertEquals(BLCOperator.AND, actualCreateGroupsResult.getOperatorType());
    assertTrue(actualCreateGroupsResult.getSubGroups().isEmpty());
  }

  /**
   * Test {@link GroupingTranslator#createGroups(String)}.
   *
   * <ul>
   *   <li>Given {@link GroupingTranslator} (default constructor).
   *   <li>When {@code 42||}.
   *   <li>Then return Phrases first is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Group GroupingTranslator.createGroups(String)"})
  public void testCreateGroups_givenGroupingTranslator_when42_thenReturnPhrasesFirstIs4211()
      throws MVELTranslationException {
    // Arrange and Act
    Group actualCreateGroupsResult = new GroupingTranslator().createGroups("\t42||");

    // Assert
    List<String> phrases = actualCreateGroupsResult.getPhrases();
    assertEquals(1, phrases.size());
    assertEquals("42", phrases.get(0));
    assertEquals(BLCOperator.OR, actualCreateGroupsResult.getOperatorType());
    assertTrue(actualCreateGroupsResult.getSubGroups().isEmpty());
  }

  /**
   * Test {@link GroupingTranslator#createGroups(String)}.
   *
   * <ul>
   *   <li>Given {@link GroupingTranslator} (default constructor).
   *   <li>When {@code 42)}.
   *   <li>Then return Phrases first is {@code 42)}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Group GroupingTranslator.createGroups(String)"})
  public void testCreateGroups_givenGroupingTranslator_when42_thenReturnPhrasesFirstIs4212()
      throws MVELTranslationException {
    // Arrange and Act
    Group actualCreateGroupsResult = new GroupingTranslator().createGroups("\t42)");

    // Assert
    List<String> phrases = actualCreateGroupsResult.getPhrases();
    assertEquals(1, phrases.size());
    assertEquals("42)", phrases.get(0));
    assertEquals(BLCOperator.AND, actualCreateGroupsResult.getOperatorType());
    assertTrue(actualCreateGroupsResult.getSubGroups().isEmpty());
  }

  /**
   * Test {@link GroupingTranslator#createGroups(String)}.
   *
   * <ul>
   *   <li>Given {@link GroupingTranslator} (default constructor).
   *   <li>When {@code ||42}.
   *   <li>Then return Phrases first is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Group GroupingTranslator.createGroups(String)"})
  public void testCreateGroups_givenGroupingTranslator_when42_thenReturnPhrasesFirstIs4213()
      throws MVELTranslationException {
    // Arrange and Act
    Group actualCreateGroupsResult = new GroupingTranslator().createGroups("\t||42");

    // Assert
    List<String> phrases = actualCreateGroupsResult.getPhrases();
    assertEquals(1, phrases.size());
    assertEquals("42", phrases.get(0));
    assertEquals(BLCOperator.OR, actualCreateGroupsResult.getOperatorType());
    assertTrue(actualCreateGroupsResult.getSubGroups().isEmpty());
  }

  /**
   * Test {@link GroupingTranslator#createGroups(String)}.
   *
   * <ul>
   *   <li>Given {@link GroupingTranslator} (default constructor).
   *   <li>When {@code )42}.
   *   <li>Then return Phrases first is {@code )42}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Group GroupingTranslator.createGroups(String)"})
  public void testCreateGroups_givenGroupingTranslator_when42_thenReturnPhrasesFirstIs4214()
      throws MVELTranslationException {
    // Arrange and Act
    Group actualCreateGroupsResult = new GroupingTranslator().createGroups("\t)42");

    // Assert
    List<String> phrases = actualCreateGroupsResult.getPhrases();
    assertEquals(1, phrases.size());
    assertEquals(")42", phrases.get(0));
    assertEquals(BLCOperator.AND, actualCreateGroupsResult.getOperatorType());
    assertTrue(actualCreateGroupsResult.getSubGroups().isEmpty());
  }

  /**
   * Test {@link GroupingTranslator#createGroups(String)}.
   *
   * <ul>
   *   <li>Given {@link GroupingTranslator} (default constructor).
   *   <li>When {@code 4242}.
   *   <li>Then return Phrases first is {@code 4242}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Group GroupingTranslator.createGroups(String)"})
  public void testCreateGroups_givenGroupingTranslator_when4242_thenReturnPhrasesFirstIs4242()
      throws MVELTranslationException {
    // Arrange and Act
    Group actualCreateGroupsResult = new GroupingTranslator().createGroups("\t4242");

    // Assert
    List<String> phrases = actualCreateGroupsResult.getPhrases();
    assertEquals(1, phrases.size());
    assertEquals("4242", phrases.get(0));
    assertEquals(BLCOperator.AND, actualCreateGroupsResult.getOperatorType());
    assertTrue(actualCreateGroupsResult.getSubGroups().isEmpty());
  }

  /**
   * Test {@link GroupingTranslator#createGroups(String)}.
   *
   * <ul>
   *   <li>Given {@link GroupingTranslator}.
   *   <li>When {@code Mvel}.
   *   <li>Then return Phrases first is {@code Mvel}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Group GroupingTranslator.createGroups(String)"})
  public void testCreateGroups_givenGroupingTranslator_whenMvel_thenReturnPhrasesFirstIsMvel()
      throws MVELTranslationException {
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
   *
   * <ul>
   *   <li>Given {@link GroupingTranslator}.
   *   <li>When {@code Mvel}.
   *   <li>Then return Phrases first is {@code Mvel}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Group GroupingTranslator.createGroups(String)"})
  public void testCreateGroups_givenGroupingTranslator_whenMvel_thenReturnPhrasesFirstIsMvel2()
      throws MVELTranslationException {
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
   *
   * <ul>
   *   <li>Given {@link GroupingTranslator}.
   *   <li>When {@code Mvel}.
   *   <li>Then return Phrases first is {@code Mvel}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Group GroupingTranslator.createGroups(String)"})
  public void testCreateGroups_givenGroupingTranslator_whenMvel_thenReturnPhrasesFirstIsMvel3()
      throws MVELTranslationException {
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
   *
   * <ul>
   *   <li>Given {@link GroupingTranslator}.
   *   <li>When {@code Mvel}.
   *   <li>Then return Phrases first is {@code Mvel}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Group GroupingTranslator.createGroups(String)"})
  public void testCreateGroups_givenGroupingTranslator_whenMvel_thenReturnPhrasesFirstIsMvel4()
      throws MVELTranslationException {
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
   *
   * <ul>
   *   <li>Given {@link GroupingTranslator}.
   *   <li>When {@code &&Mvel}.
   *   <li>Then return Phrases first is {@code Mvel}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Group GroupingTranslator.createGroups(String)"})
  public void testCreateGroups_givenGroupingTranslator_whenMvel_thenReturnPhrasesFirstIsMvel5()
      throws MVELTranslationException {
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
   *
   * <ul>
   *   <li>Given {@link GroupingTranslator}.
   *   <li>When {@code Mvel}.
   *   <li>Then return Phrases first is {@code Mvel}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Group GroupingTranslator.createGroups(String)"})
  public void testCreateGroups_givenGroupingTranslator_whenMvel_thenReturnPhrasesFirstIsMvel6()
      throws MVELTranslationException {
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
   *
   * <ul>
   *   <li>Given {@link GroupingTranslator}.
   *   <li>When {@code Mvel;}.
   *   <li>Then return Phrases first is {@code Mvel}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Group GroupingTranslator.createGroups(String)"})
  public void testCreateGroups_givenGroupingTranslator_whenMvel_thenReturnPhrasesFirstIsMvel7()
      throws MVELTranslationException {
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
   *
   * <ul>
   *   <li>Given {@link GroupingTranslator}.
   *   <li>When {@code Mvel(}.
   *   <li>Then return Phrases first is {@code Mvel(}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Group GroupingTranslator.createGroups(String)"})
  public void testCreateGroups_givenGroupingTranslator_whenMvel_thenReturnPhrasesFirstIsMvel8()
      throws MVELTranslationException {
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
   *
   * <ul>
   *   <li>Given {@link GroupingTranslator}.
   *   <li>When {@code Mvel&&}.
   *   <li>Then return Phrases first is {@code Mvel}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Group GroupingTranslator.createGroups(String)"})
  public void testCreateGroups_givenGroupingTranslator_whenMvel_thenReturnPhrasesFirstIsMvel9()
      throws MVELTranslationException {
    // Arrange and Act
    Group actualCreateGroupsResult = groupingTranslator.createGroups("\tMvel&&");

    // Assert
    List<String> phrases = actualCreateGroupsResult.getPhrases();
    assertEquals(1, phrases.size());
    assertEquals("Mvel", phrases.get(0));
    assertEquals(BLCOperator.AND, actualCreateGroupsResult.getOperatorType());
    assertTrue(actualCreateGroupsResult.getSubGroups().isEmpty());
  }

  /**
   * Test {@link GroupingTranslator#createGroups(String)}.
   *
   * <ul>
   *   <li>Given {@link GroupingTranslator} (default constructor).
   *   <li>When {@code Mvel\|\|}.
   *   <li>Then return Phrases first is {@code Mvel\|\|}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Group GroupingTranslator.createGroups(String)"})
  public void testCreateGroups_givenGroupingTranslator_whenMvel_thenReturnPhrasesFirstIsMvel10()
      throws MVELTranslationException {
    // Arrange and Act
    Group actualCreateGroupsResult = new GroupingTranslator().createGroups("\tMvel\\|\\|");

    // Assert
    List<String> phrases = actualCreateGroupsResult.getPhrases();
    assertEquals(1, phrases.size());
    assertEquals("Mvel\\|\\|", phrases.get(0));
    assertEquals(BLCOperator.AND, actualCreateGroupsResult.getOperatorType());
    assertTrue(actualCreateGroupsResult.getSubGroups().isEmpty());
  }

  /**
   * Test {@link GroupingTranslator#createGroups(String)}.
   *
   * <ul>
   *   <li>Given {@link GroupingTranslator} (default constructor).
   *   <li>When {@code Mvel||}.
   *   <li>Then return Phrases first is {@code Mvel}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Group GroupingTranslator.createGroups(String)"})
  public void testCreateGroups_givenGroupingTranslator_whenMvel_thenReturnPhrasesFirstIsMvel11()
      throws MVELTranslationException {
    // Arrange and Act
    Group actualCreateGroupsResult = new GroupingTranslator().createGroups("\tMvel||");

    // Assert
    List<String> phrases = actualCreateGroupsResult.getPhrases();
    assertEquals(1, phrases.size());
    assertEquals("Mvel", phrases.get(0));
    assertEquals(BLCOperator.OR, actualCreateGroupsResult.getOperatorType());
    assertTrue(actualCreateGroupsResult.getSubGroups().isEmpty());
  }

  /**
   * Test {@link GroupingTranslator#createGroups(String)}.
   *
   * <ul>
   *   <li>Given {@link GroupingTranslator} (default constructor).
   *   <li>When {@code Mvel)}.
   *   <li>Then return Phrases first is {@code Mvel)}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Group GroupingTranslator.createGroups(String)"})
  public void testCreateGroups_givenGroupingTranslator_whenMvel_thenReturnPhrasesFirstIsMvel12()
      throws MVELTranslationException {
    // Arrange and Act
    Group actualCreateGroupsResult = new GroupingTranslator().createGroups("\tMvel)");

    // Assert
    List<String> phrases = actualCreateGroupsResult.getPhrases();
    assertEquals(1, phrases.size());
    assertEquals("Mvel)", phrases.get(0));
    assertEquals(BLCOperator.AND, actualCreateGroupsResult.getOperatorType());
    assertTrue(actualCreateGroupsResult.getSubGroups().isEmpty());
  }

  /**
   * Test {@link GroupingTranslator#createGroups(String)}.
   *
   * <ul>
   *   <li>Given {@link GroupingTranslator} (default constructor).
   *   <li>When {@code \|\|Mvel}.
   *   <li>Then return Phrases first is {@code \|\|Mvel}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Group GroupingTranslator.createGroups(String)"})
  public void testCreateGroups_givenGroupingTranslator_whenMvel_thenReturnPhrasesFirstIsMvel13()
      throws MVELTranslationException {
    // Arrange and Act
    Group actualCreateGroupsResult = new GroupingTranslator().createGroups("\t\\|\\|Mvel");

    // Assert
    List<String> phrases = actualCreateGroupsResult.getPhrases();
    assertEquals(1, phrases.size());
    assertEquals("\\|\\|Mvel", phrases.get(0));
    assertEquals(BLCOperator.AND, actualCreateGroupsResult.getOperatorType());
    assertTrue(actualCreateGroupsResult.getSubGroups().isEmpty());
  }

  /**
   * Test {@link GroupingTranslator#createGroups(String)}.
   *
   * <ul>
   *   <li>Given {@link GroupingTranslator} (default constructor).
   *   <li>When {@code ||Mvel}.
   *   <li>Then return Phrases first is {@code Mvel}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Group GroupingTranslator.createGroups(String)"})
  public void testCreateGroups_givenGroupingTranslator_whenMvel_thenReturnPhrasesFirstIsMvel14()
      throws MVELTranslationException {
    // Arrange and Act
    Group actualCreateGroupsResult = new GroupingTranslator().createGroups("\t||Mvel");

    // Assert
    List<String> phrases = actualCreateGroupsResult.getPhrases();
    assertEquals(1, phrases.size());
    assertEquals("Mvel", phrases.get(0));
    assertEquals(BLCOperator.OR, actualCreateGroupsResult.getOperatorType());
    assertTrue(actualCreateGroupsResult.getSubGroups().isEmpty());
  }

  /**
   * Test {@link GroupingTranslator#createGroups(String)}.
   *
   * <ul>
   *   <li>Given {@link GroupingTranslator} (default constructor).
   *   <li>When {@code )Mvel}.
   *   <li>Then return Phrases first is {@code )Mvel}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Group GroupingTranslator.createGroups(String)"})
  public void testCreateGroups_givenGroupingTranslator_whenMvel_thenReturnPhrasesFirstIsMvel15()
      throws MVELTranslationException {
    // Arrange and Act
    Group actualCreateGroupsResult = new GroupingTranslator().createGroups("\t)Mvel");

    // Assert
    List<String> phrases = actualCreateGroupsResult.getPhrases();
    assertEquals(1, phrases.size());
    assertEquals(")Mvel", phrases.get(0));
    assertEquals(BLCOperator.AND, actualCreateGroupsResult.getOperatorType());
    assertTrue(actualCreateGroupsResult.getSubGroups().isEmpty());
  }

  /**
   * Test {@link GroupingTranslator#createGroups(String)}.
   *
   * <ul>
   *   <li>Given {@link GroupingTranslator}.
   *   <li>When {@code [\t\n\r]42}.
   *   <li>Then return Phrases first is {@code [\t\n\r]42}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Group GroupingTranslator.createGroups(String)"})
  public void testCreateGroups_givenGroupingTranslator_whenTNR42_thenReturnPhrasesFirstIsTNR42()
      throws MVELTranslationException {
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
   *
   * <ul>
   *   <li>Given {@link GroupingTranslator} (default constructor).
   *   <li>When {@code [\t\n\r] 42}.
   *   <li>Then return Phrases first is {@code [\t\n\r]42}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Group GroupingTranslator.createGroups(String)"})
  public void testCreateGroups_givenGroupingTranslator_whenTNR42_thenReturnPhrasesFirstIsTNR422()
      throws MVELTranslationException {
    // Arrange and Act
    Group actualCreateGroupsResult = new GroupingTranslator().createGroups("[\\t\\n\\r]\t42");

    // Assert
    List<String> phrases = actualCreateGroupsResult.getPhrases();
    assertEquals(1, phrases.size());
    assertEquals("[\\t\\n\\r]42", phrases.get(0));
    assertEquals(BLCOperator.AND, actualCreateGroupsResult.getOperatorType());
    assertTrue(actualCreateGroupsResult.getSubGroups().isEmpty());
  }

  /**
   * Test {@link GroupingTranslator#createGroups(String)}.
   *
   * <ul>
   *   <li>Given {@link GroupingTranslator}.
   *   <li>When {@code [\t\n\r]}.
   *   <li>Then return Phrases first is {@code [\t\n\r]}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Group GroupingTranslator.createGroups(String)"})
  public void testCreateGroups_givenGroupingTranslator_whenTNR_thenReturnPhrasesFirstIsTNR()
      throws MVELTranslationException {
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
   *
   * <ul>
   *   <li>Given {@link GroupingTranslator}.
   *   <li>When {@code [\t\n\r]}.
   *   <li>Then return Phrases first is {@code [\t\n\r]}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Group GroupingTranslator.createGroups(String)"})
  public void testCreateGroups_givenGroupingTranslator_whenTNR_thenReturnPhrasesFirstIsTNR2()
      throws MVELTranslationException {
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
   *
   * <ul>
   *   <li>Given {@link GroupingTranslator}.
   *   <li>When {@code [\t\n\r](}.
   *   <li>Then return Phrases first is {@code [\t\n\r](}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Group GroupingTranslator.createGroups(String)"})
  public void testCreateGroups_givenGroupingTranslator_whenTNR_thenReturnPhrasesFirstIsTNR3()
      throws MVELTranslationException {
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
   *
   * <ul>
   *   <li>Given {@link GroupingTranslator}.
   *   <li>When {@code &&[\t\n\r]}.
   *   <li>Then return Phrases first is {@code [\t\n\r]}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Group GroupingTranslator.createGroups(String)"})
  public void testCreateGroups_givenGroupingTranslator_whenTNR_thenReturnPhrasesFirstIsTNR4()
      throws MVELTranslationException {
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
   *
   * <ul>
   *   <li>Given {@link GroupingTranslator}.
   *   <li>When {@code [\t\n\r]}.
   *   <li>Then return Phrases first is {@code [\t\n\r]}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Group GroupingTranslator.createGroups(String)"})
  public void testCreateGroups_givenGroupingTranslator_whenTNR_thenReturnPhrasesFirstIsTNR5()
      throws MVELTranslationException {
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
   *
   * <ul>
   *   <li>Given {@link GroupingTranslator}.
   *   <li>When {@code [\t\n\r]}.
   *   <li>Then return Phrases first is {@code [\t\n\r]}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Group GroupingTranslator.createGroups(String)"})
  public void testCreateGroups_givenGroupingTranslator_whenTNR_thenReturnPhrasesFirstIsTNR6()
      throws MVELTranslationException {
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
   *
   * <ul>
   *   <li>Given {@link GroupingTranslator}.
   *   <li>When {@code [\t\n\r];}.
   *   <li>Then return Phrases first is {@code [\t\n\r]}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Group GroupingTranslator.createGroups(String)"})
  public void testCreateGroups_givenGroupingTranslator_whenTNR_thenReturnPhrasesFirstIsTNR7()
      throws MVELTranslationException {
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
   *
   * <ul>
   *   <li>Given {@link GroupingTranslator}.
   *   <li>When {@code [\t\n\r](}.
   *   <li>Then return Phrases first is {@code [\t\n\r](}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Group GroupingTranslator.createGroups(String)"})
  public void testCreateGroups_givenGroupingTranslator_whenTNR_thenReturnPhrasesFirstIsTNR8()
      throws MVELTranslationException {
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
   *
   * <ul>
   *   <li>Given {@link GroupingTranslator}.
   *   <li>When {@code [\t\n\r]&&}.
   *   <li>Then return Phrases first is {@code [\t\n\r]}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Group GroupingTranslator.createGroups(String)"})
  public void testCreateGroups_givenGroupingTranslator_whenTNR_thenReturnPhrasesFirstIsTNR9()
      throws MVELTranslationException {
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
   *
   * <ul>
   *   <li>Given {@link GroupingTranslator}.
   *   <li>When {@code [\t\n\r]\|\|}.
   *   <li>Then return Phrases first is {@code [\t\n\r]\|\|}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Group GroupingTranslator.createGroups(String)"})
  public void testCreateGroups_givenGroupingTranslator_whenTNR_thenReturnPhrasesFirstIsTNR10()
      throws MVELTranslationException {
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
   *
   * <ul>
   *   <li>Given {@link GroupingTranslator}.
   *   <li>When {@code [\t\n\r]||}.
   *   <li>Then return Phrases first is {@code [\t\n\r]}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Group GroupingTranslator.createGroups(String)"})
  public void testCreateGroups_givenGroupingTranslator_whenTNR_thenReturnPhrasesFirstIsTNR11()
      throws MVELTranslationException {
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
   *
   * <ul>
   *   <li>Given {@link GroupingTranslator}.
   *   <li>When {@code [\t\n\r])}.
   *   <li>Then return Phrases first is {@code [\t\n\r])}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Group GroupingTranslator.createGroups(String)"})
  public void testCreateGroups_givenGroupingTranslator_whenTNR_thenReturnPhrasesFirstIsTNR12()
      throws MVELTranslationException {
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
   *
   * <ul>
   *   <li>Given {@link GroupingTranslator}.
   *   <li>When {@code &&[\t\n\r]}.
   *   <li>Then return Phrases first is {@code [\t\n\r]}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Group GroupingTranslator.createGroups(String)"})
  public void testCreateGroups_givenGroupingTranslator_whenTNR_thenReturnPhrasesFirstIsTNR13()
      throws MVELTranslationException {
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
   *
   * <ul>
   *   <li>Given {@link GroupingTranslator} (default constructor).
   *   <li>When {@code \|\|[\t\n\r]}.
   *   <li>Then return Phrases first is {@code \|\|[\t\n\r]}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Group GroupingTranslator.createGroups(String)"})
  public void testCreateGroups_givenGroupingTranslator_whenTNR_thenReturnPhrasesFirstIsTNR14()
      throws MVELTranslationException {
    // Arrange and Act
    Group actualCreateGroupsResult = new GroupingTranslator().createGroups("\t\\|\\|[\\t\\n\\r]");

    // Assert
    List<String> phrases = actualCreateGroupsResult.getPhrases();
    assertEquals(1, phrases.size());
    assertEquals("\\|\\|[\\t\\n\\r]", phrases.get(0));
    assertEquals(BLCOperator.AND, actualCreateGroupsResult.getOperatorType());
    assertTrue(actualCreateGroupsResult.getSubGroups().isEmpty());
  }

  /**
   * Test {@link GroupingTranslator#createGroups(String)}.
   *
   * <ul>
   *   <li>Given {@link GroupingTranslator} (default constructor).
   *   <li>When {@code ||[\t\n\r]}.
   *   <li>Then return Phrases first is {@code [\t\n\r]}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Group GroupingTranslator.createGroups(String)"})
  public void testCreateGroups_givenGroupingTranslator_whenTNR_thenReturnPhrasesFirstIsTNR15()
      throws MVELTranslationException {
    // Arrange and Act
    Group actualCreateGroupsResult = new GroupingTranslator().createGroups("\t||[\\t\\n\\r]");

    // Assert
    List<String> phrases = actualCreateGroupsResult.getPhrases();
    assertEquals(1, phrases.size());
    assertEquals("[\\t\\n\\r]", phrases.get(0));
    assertEquals(BLCOperator.OR, actualCreateGroupsResult.getOperatorType());
    assertTrue(actualCreateGroupsResult.getSubGroups().isEmpty());
  }

  /**
   * Test {@link GroupingTranslator#createGroups(String)}.
   *
   * <ul>
   *   <li>Given {@link GroupingTranslator} (default constructor).
   *   <li>When {@code )[\t\n\r]}.
   *   <li>Then return Phrases first is {@code )[\t\n\r]}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Group GroupingTranslator.createGroups(String)"})
  public void testCreateGroups_givenGroupingTranslator_whenTNR_thenReturnPhrasesFirstIsTNR16()
      throws MVELTranslationException {
    // Arrange and Act
    Group actualCreateGroupsResult = new GroupingTranslator().createGroups("\t)[\\t\\n\\r]");

    // Assert
    List<String> phrases = actualCreateGroupsResult.getPhrases();
    assertEquals(1, phrases.size());
    assertEquals(")[\\t\\n\\r]", phrases.get(0));
    assertEquals(BLCOperator.AND, actualCreateGroupsResult.getOperatorType());
    assertTrue(actualCreateGroupsResult.getSubGroups().isEmpty());
  }

  /**
   * Test {@link GroupingTranslator#createGroups(String)}.
   *
   * <ul>
   *   <li>Given {@link GroupingTranslator} (default constructor).
   *   <li>When {@code [\t\n\r]}.
   *   <li>Then return Phrases first is {@code [\t\n\r]}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Group GroupingTranslator.createGroups(String)"})
  public void testCreateGroups_givenGroupingTranslator_whenTNR_thenReturnPhrasesFirstIsTNR17()
      throws MVELTranslationException {
    // Arrange and Act
    Group actualCreateGroupsResult = new GroupingTranslator().createGroups("[\\t\\n\\r]\t\t");

    // Assert
    List<String> phrases = actualCreateGroupsResult.getPhrases();
    assertEquals(1, phrases.size());
    assertEquals("[\\t\\n\\r]", phrases.get(0));
    assertEquals(BLCOperator.AND, actualCreateGroupsResult.getOperatorType());
    assertTrue(actualCreateGroupsResult.getSubGroups().isEmpty());
  }

  /**
   * Test {@link GroupingTranslator#createGroups(String)}.
   *
   * <ul>
   *   <li>Given {@link GroupingTranslator} (default constructor).
   *   <li>When {@code [\t\n\r] ;}.
   *   <li>Then return Phrases first is {@code [\t\n\r]}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Group GroupingTranslator.createGroups(String)"})
  public void testCreateGroups_givenGroupingTranslator_whenTNR_thenReturnPhrasesFirstIsTNR18()
      throws MVELTranslationException {
    // Arrange and Act
    Group actualCreateGroupsResult = new GroupingTranslator().createGroups("[\\t\\n\\r]\t;");

    // Assert
    List<String> phrases = actualCreateGroupsResult.getPhrases();
    assertEquals(1, phrases.size());
    assertEquals("[\\t\\n\\r]", phrases.get(0));
    assertEquals(BLCOperator.AND, actualCreateGroupsResult.getOperatorType());
    assertTrue(actualCreateGroupsResult.getSubGroups().isEmpty());
  }

  /**
   * Test {@link GroupingTranslator#createGroups(String)}.
   *
   * <ul>
   *   <li>Given {@link GroupingTranslator} (default constructor).
   *   <li>When {@code [\t\n\r] (}.
   *   <li>Then return Phrases first is {@code [\t\n\r](}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Group GroupingTranslator.createGroups(String)"})
  public void testCreateGroups_givenGroupingTranslator_whenTNR_thenReturnPhrasesFirstIsTNR19()
      throws MVELTranslationException {
    // Arrange and Act
    Group actualCreateGroupsResult = new GroupingTranslator().createGroups("[\\t\\n\\r]\t(");

    // Assert
    List<String> phrases = actualCreateGroupsResult.getPhrases();
    assertEquals(1, phrases.size());
    assertEquals("[\\t\\n\\r](", phrases.get(0));
    assertEquals(BLCOperator.AND, actualCreateGroupsResult.getOperatorType());
    assertTrue(actualCreateGroupsResult.getSubGroups().isEmpty());
  }

  /**
   * Test {@link GroupingTranslator#createGroups(String)}.
   *
   * <ul>
   *   <li>Given {@link GroupingTranslator} (default constructor).
   *   <li>When {@code [\t\n\r] &&}.
   *   <li>Then return Phrases first is {@code [\t\n\r]}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Group GroupingTranslator.createGroups(String)"})
  public void testCreateGroups_givenGroupingTranslator_whenTNR_thenReturnPhrasesFirstIsTNR20()
      throws MVELTranslationException {
    // Arrange and Act
    Group actualCreateGroupsResult = new GroupingTranslator().createGroups("[\\t\\n\\r]\t&&");

    // Assert
    List<String> phrases = actualCreateGroupsResult.getPhrases();
    assertEquals(1, phrases.size());
    assertEquals("[\\t\\n\\r]", phrases.get(0));
    assertEquals(BLCOperator.AND, actualCreateGroupsResult.getOperatorType());
    assertTrue(actualCreateGroupsResult.getSubGroups().isEmpty());
  }

  /**
   * Test {@link GroupingTranslator#createGroups(String)}.
   *
   * <ul>
   *   <li>Given {@link GroupingTranslator} (default constructor).
   *   <li>When {@code [\t\n\r] \|\|}.
   *   <li>Then return Phrases first is {@code [\t\n\r]\|\|}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Group GroupingTranslator.createGroups(String)"})
  public void testCreateGroups_givenGroupingTranslator_whenTNR_thenReturnPhrasesFirstIsTNR21()
      throws MVELTranslationException {
    // Arrange and Act
    Group actualCreateGroupsResult = new GroupingTranslator().createGroups("[\\t\\n\\r]\t\\|\\|");

    // Assert
    List<String> phrases = actualCreateGroupsResult.getPhrases();
    assertEquals(1, phrases.size());
    assertEquals("[\\t\\n\\r]\\|\\|", phrases.get(0));
    assertEquals(BLCOperator.AND, actualCreateGroupsResult.getOperatorType());
    assertTrue(actualCreateGroupsResult.getSubGroups().isEmpty());
  }

  /**
   * Test {@link GroupingTranslator#createGroups(String)}.
   *
   * <ul>
   *   <li>Given {@link GroupingTranslator} (default constructor).
   *   <li>When {@code [\t\n\r] ||}.
   *   <li>Then return Phrases first is {@code [\t\n\r]}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Group GroupingTranslator.createGroups(String)"})
  public void testCreateGroups_givenGroupingTranslator_whenTNR_thenReturnPhrasesFirstIsTNR22()
      throws MVELTranslationException {
    // Arrange and Act
    Group actualCreateGroupsResult = new GroupingTranslator().createGroups("[\\t\\n\\r]\t||");

    // Assert
    List<String> phrases = actualCreateGroupsResult.getPhrases();
    assertEquals(1, phrases.size());
    assertEquals("[\\t\\n\\r]", phrases.get(0));
    assertEquals(BLCOperator.OR, actualCreateGroupsResult.getOperatorType());
    assertTrue(actualCreateGroupsResult.getSubGroups().isEmpty());
  }

  /**
   * Test {@link GroupingTranslator#createGroups(String)}.
   *
   * <ul>
   *   <li>Given {@link GroupingTranslator} (default constructor).
   *   <li>When {@code [\t\n\r] )}.
   *   <li>Then return Phrases first is {@code [\t\n\r])}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Group GroupingTranslator.createGroups(String)"})
  public void testCreateGroups_givenGroupingTranslator_whenTNR_thenReturnPhrasesFirstIsTNR23()
      throws MVELTranslationException {
    // Arrange and Act
    Group actualCreateGroupsResult = new GroupingTranslator().createGroups("[\\t\\n\\r]\t)");

    // Assert
    List<String> phrases = actualCreateGroupsResult.getPhrases();
    assertEquals(1, phrases.size());
    assertEquals("[\\t\\n\\r])", phrases.get(0));
    assertEquals(BLCOperator.AND, actualCreateGroupsResult.getOperatorType());
    assertTrue(actualCreateGroupsResult.getSubGroups().isEmpty());
  }

  /**
   * Test {@link GroupingTranslator#createGroups(String)}.
   *
   * <ul>
   *   <li>Given {@link GroupingTranslator} (default constructor).
   *   <li>When {@code [\t\n\r];}.
   *   <li>Then return Phrases first is {@code [\t\n\r]}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Group GroupingTranslator.createGroups(String)"})
  public void testCreateGroups_givenGroupingTranslator_whenTNR_thenReturnPhrasesFirstIsTNR24()
      throws MVELTranslationException {
    // Arrange and Act
    Group actualCreateGroupsResult = new GroupingTranslator().createGroups("[\\t\\n\\r];\t");

    // Assert
    List<String> phrases = actualCreateGroupsResult.getPhrases();
    assertEquals(1, phrases.size());
    assertEquals("[\\t\\n\\r]", phrases.get(0));
    assertEquals(BLCOperator.AND, actualCreateGroupsResult.getOperatorType());
    assertTrue(actualCreateGroupsResult.getSubGroups().isEmpty());
  }

  /**
   * Test {@link GroupingTranslator#createGroups(String)}.
   *
   * <ul>
   *   <li>Given {@link GroupingTranslator} (default constructor).
   *   <li>When {@code [\t\n\r](}.
   *   <li>Then return Phrases first is {@code [\t\n\r](}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Group GroupingTranslator.createGroups(String)"})
  public void testCreateGroups_givenGroupingTranslator_whenTNR_thenReturnPhrasesFirstIsTNR25()
      throws MVELTranslationException {
    // Arrange and Act
    Group actualCreateGroupsResult = new GroupingTranslator().createGroups("[\\t\\n\\r](\t");

    // Assert
    List<String> phrases = actualCreateGroupsResult.getPhrases();
    assertEquals(1, phrases.size());
    assertEquals("[\\t\\n\\r](", phrases.get(0));
    assertEquals(BLCOperator.AND, actualCreateGroupsResult.getOperatorType());
    assertTrue(actualCreateGroupsResult.getSubGroups().isEmpty());
  }

  /**
   * Test {@link GroupingTranslator#createGroups(String)}.
   *
   * <ul>
   *   <li>Given {@link GroupingTranslator} (default constructor).
   *   <li>When {@code [\t\n\r]&&}.
   *   <li>Then return Phrases first is {@code [\t\n\r]}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Group GroupingTranslator.createGroups(String)"})
  public void testCreateGroups_givenGroupingTranslator_whenTNR_thenReturnPhrasesFirstIsTNR26()
      throws MVELTranslationException {
    // Arrange and Act
    Group actualCreateGroupsResult = new GroupingTranslator().createGroups("[\\t\\n\\r]&&\t");

    // Assert
    List<String> phrases = actualCreateGroupsResult.getPhrases();
    assertEquals(1, phrases.size());
    assertEquals("[\\t\\n\\r]", phrases.get(0));
    assertEquals(BLCOperator.AND, actualCreateGroupsResult.getOperatorType());
    assertTrue(actualCreateGroupsResult.getSubGroups().isEmpty());
  }

  /**
   * Test {@link GroupingTranslator#createGroups(String)}.
   *
   * <ul>
   *   <li>Given {@link GroupingTranslator}.
   *   <li>When tab tab.
   *   <li>Then return OperatorType is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Group GroupingTranslator.createGroups(String)"})
  public void testCreateGroups_givenGroupingTranslator_whenTabTab_thenReturnOperatorTypeIsNull()
      throws MVELTranslationException {
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
   *
   * <ul>
   *   <li>Given {@link GroupingTranslator}.
   *   <li>When tab.
   *   <li>Then return OperatorType is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Group GroupingTranslator.createGroups(String)"})
  public void testCreateGroups_givenGroupingTranslator_whenTab_thenReturnOperatorTypeIsNull()
      throws MVELTranslationException {
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
   *
   * <ul>
   *   <li>Then return Phrases first is {@code )(}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Group GroupingTranslator.createGroups(String)"})
  public void testCreateGroups_thenReturnPhrasesFirstIsRightParenthesisLeftParenthesis()
      throws MVELTranslationException {
    // Arrange and Act
    Group actualCreateGroupsResult = new GroupingTranslator().createGroups("\t)(");

    // Assert
    List<String> phrases = actualCreateGroupsResult.getPhrases();
    assertEquals(1, phrases.size());
    assertEquals(")(", phrases.get(0));
    assertEquals(BLCOperator.AND, actualCreateGroupsResult.getOperatorType());
    assertTrue(actualCreateGroupsResult.getSubGroups().isEmpty());
  }

  /**
   * Test {@link GroupingTranslator#createGroups(String)}.
   *
   * <ul>
   *   <li>Then return Phrases first is {@code ))}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Group GroupingTranslator.createGroups(String)"})
  public void testCreateGroups_thenReturnPhrasesFirstIsRightParenthesisRightParenthesis()
      throws MVELTranslationException {
    // Arrange and Act
    Group actualCreateGroupsResult = new GroupingTranslator().createGroups("\t))");

    // Assert
    List<String> phrases = actualCreateGroupsResult.getPhrases();
    assertEquals(1, phrases.size());
    assertEquals("))", phrases.get(0));
    assertEquals(BLCOperator.AND, actualCreateGroupsResult.getOperatorType());
    assertTrue(actualCreateGroupsResult.getSubGroups().isEmpty());
  }

  /**
   * Test {@link GroupingTranslator#createGroups(String)}.
   *
   * <ul>
   *   <li>Then return Phrases size is two.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Group GroupingTranslator.createGroups(String)"})
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
   *
   * <ul>
   *   <li>Then return Phrases size is two.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Group GroupingTranslator.createGroups(String)"})
  public void testCreateGroups_thenReturnPhrasesSizeIsTwo2() throws MVELTranslationException {
    // Arrange and Act
    Group actualCreateGroupsResult = new GroupingTranslator().createGroups("\t\\|\\|||");

    // Assert
    List<String> phrases = actualCreateGroupsResult.getPhrases();
    assertEquals(2, phrases.size());
    assertEquals("\\|\\", phrases.get(0));
    assertEquals("|", phrases.get(1));
    assertEquals(BLCOperator.OR, actualCreateGroupsResult.getOperatorType());
  }

  /**
   * Test {@link GroupingTranslator#createGroups(String)}.
   *
   * <ul>
   *   <li>Then return SubGroups size is one.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Group GroupingTranslator.createGroups(String)"})
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
   *
   * <ul>
   *   <li>Then return SubGroups size is one.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Group GroupingTranslator.createGroups(String)"})
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
   *
   * <ul>
   *   <li>When {@code 42Mvel}.
   *   <li>Then return Phrases first is {@code 42Mvel}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Group GroupingTranslator.createGroups(String)"})
  public void testCreateGroups_when42Mvel_thenReturnPhrasesFirstIs42Mvel()
      throws MVELTranslationException {
    // Arrange and Act
    Group actualCreateGroupsResult = new GroupingTranslator().createGroups("\t42Mvel");

    // Assert
    List<String> phrases = actualCreateGroupsResult.getPhrases();
    assertEquals(1, phrases.size());
    assertEquals("42Mvel", phrases.get(0));
    assertEquals(BLCOperator.AND, actualCreateGroupsResult.getOperatorType());
    assertTrue(actualCreateGroupsResult.getSubGroups().isEmpty());
  }

  /**
   * Test {@link GroupingTranslator#createGroups(String)}.
   *
   * <ul>
   *   <li>When {@code ;42}.
   *   <li>Then throw {@link MVELTranslationException}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Group GroupingTranslator.createGroups(String)"})
  public void testCreateGroups_when42_thenThrowMVELTranslationException()
      throws MVELTranslationException {
    // Arrange, Act and Assert
    assertThrows(MVELTranslationException.class, () -> groupingTranslator.createGroups("\t;42"));
  }

  /**
   * Test {@link GroupingTranslator#createGroups(String)}.
   *
   * <ul>
   *   <li>When {@code (42}.
   *   <li>Then throw {@link MVELTranslationException}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Group GroupingTranslator.createGroups(String)"})
  public void testCreateGroups_when42_thenThrowMVELTranslationException2()
      throws MVELTranslationException {
    // Arrange, Act and Assert
    assertThrows(MVELTranslationException.class, () -> groupingTranslator.createGroups("\t(42"));
  }

  /**
   * Test {@link GroupingTranslator#createGroups(String)}.
   *
   * <ul>
   *   <li>When {@code &&&&}.
   *   <li>Then return Phrases Empty.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Group GroupingTranslator.createGroups(String)"})
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
   *
   * <ul>
   *   <li>When {@code &&(}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Group GroupingTranslator.createGroups(String)"})
  public void testCreateGroups_whenAmpersandAmpersandLeftParenthesis()
      throws MVELTranslationException {
    // Arrange, Act and Assert
    assertThrows(MVELTranslationException.class, () -> groupingTranslator.createGroups("&&("));
  }

  /**
   * Test {@link GroupingTranslator#createGroups(String)}.
   *
   * <ul>
   *   <li>When {@code &&(}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Group GroupingTranslator.createGroups(String)"})
  public void testCreateGroups_whenAmpersandAmpersandLeftParenthesis2()
      throws MVELTranslationException {
    // Arrange, Act and Assert
    assertThrows(MVELTranslationException.class, () -> groupingTranslator.createGroups("\t&&("));
  }

  /**
   * Test {@link GroupingTranslator#createGroups(String)}.
   *
   * <ul>
   *   <li>When {@code &&)}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Group GroupingTranslator.createGroups(String)"})
  public void testCreateGroups_whenAmpersandAmpersandRightParenthesis()
      throws MVELTranslationException {
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
   *
   * <ul>
   *   <li>When {@code &&;}.
   *   <li>Then return Phrases Empty.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Group GroupingTranslator.createGroups(String)"})
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
   *
   * <ul>
   *   <li>When {@code &&||}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Group GroupingTranslator.createGroups(String)"})
  public void testCreateGroups_whenAmpersandAmpersandVerticalLineVerticalLine()
      throws MVELTranslationException {
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
   *
   * <ul>
   *   <li>When {@code &&}.
   *   <li>Then return Phrases Empty.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Group GroupingTranslator.createGroups(String)"})
  public void testCreateGroups_whenAmpersandAmpersand_thenReturnPhrasesEmpty()
      throws MVELTranslationException {
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
   *
   * <ul>
   *   <li>When {@code &&}.
   *   <li>Then return Phrases Empty.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Group GroupingTranslator.createGroups(String)"})
  public void testCreateGroups_whenAmpersandAmpersand_thenReturnPhrasesEmpty2()
      throws MVELTranslationException {
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
   *
   * <ul>
   *   <li>When {@code &&}.
   *   <li>Then return Phrases Empty.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Group GroupingTranslator.createGroups(String)"})
  public void testCreateGroups_whenAmpersandAmpersand_thenReturnPhrasesEmpty3()
      throws MVELTranslationException {
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
   *
   * <ul>
   *   <li>When {@code &&}.
   *   <li>Then return Phrases Empty.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Group GroupingTranslator.createGroups(String)"})
  public void testCreateGroups_whenAmpersandAmpersand_thenReturnPhrasesEmpty4()
      throws MVELTranslationException {
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
   *
   * <ul>
   *   <li>When {@code &&}.
   *   <li>Then return Phrases Empty.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Group GroupingTranslator.createGroups(String)"})
  public void testCreateGroups_whenAmpersandAmpersand_thenReturnPhrasesEmpty5()
      throws MVELTranslationException {
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
   *
   * <ul>
   *   <li>When {@code \|\|}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Group GroupingTranslator.createGroups(String)"})
  public void testCreateGroups_whenBackslashVerticalLineBackslashVerticalLine()
      throws MVELTranslationException {
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
   *
   * <ul>
   *   <li>When {@code \|\|}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Group GroupingTranslator.createGroups(String)"})
  public void testCreateGroups_whenBackslashVerticalLineBackslashVerticalLine2()
      throws MVELTranslationException {
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
   *
   * <ul>
   *   <li>When {@code \|\|}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Group GroupingTranslator.createGroups(String)"})
  public void testCreateGroups_whenBackslashVerticalLineBackslashVerticalLine3()
      throws MVELTranslationException {
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
   *
   * <ul>
   *   <li>When {@code \|\|}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Group GroupingTranslator.createGroups(String)"})
  public void testCreateGroups_whenBackslashVerticalLineBackslashVerticalLine4()
      throws MVELTranslationException {
    // Arrange and Act
    Group actualCreateGroupsResult = new GroupingTranslator().createGroups("\t\\|\\|\t");

    // Assert
    List<String> phrases = actualCreateGroupsResult.getPhrases();
    assertEquals(1, phrases.size());
    assertEquals("\\|\\|", phrases.get(0));
    assertEquals(BLCOperator.AND, actualCreateGroupsResult.getOperatorType());
    assertTrue(actualCreateGroupsResult.getSubGroups().isEmpty());
  }

  /**
   * Test {@link GroupingTranslator#createGroups(String)}.
   *
   * <ul>
   *   <li>When {@code \|\|(}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Group GroupingTranslator.createGroups(String)"})
  public void testCreateGroups_whenBackslashVerticalLineBackslashVerticalLineLeftParenthesis()
      throws MVELTranslationException {
    // Arrange, Act and Assert
    assertThrows(MVELTranslationException.class, () -> groupingTranslator.createGroups("\\|\\|("));
  }

  /**
   * Test {@link GroupingTranslator#createGroups(String)}.
   *
   * <ul>
   *   <li>When {@code \|\|(}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Group GroupingTranslator.createGroups(String)"})
  public void testCreateGroups_whenBackslashVerticalLineBackslashVerticalLineLeftParenthesis2()
      throws MVELTranslationException {
    // Arrange, Act and Assert
    assertThrows(
        MVELTranslationException.class, () -> new GroupingTranslator().createGroups("\t\\|\\|("));
  }

  /**
   * Test {@link GroupingTranslator#createGroups(String)}.
   *
   * <ul>
   *   <li>When {@code \|\|;}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Group GroupingTranslator.createGroups(String)"})
  public void testCreateGroups_whenBackslashVerticalLineBackslashVerticalLineSemicolon()
      throws MVELTranslationException {
    // Arrange and Act
    Group actualCreateGroupsResult = new GroupingTranslator().createGroups("\t\\|\\|;");

    // Assert
    List<String> phrases = actualCreateGroupsResult.getPhrases();
    assertEquals(1, phrases.size());
    assertEquals("\\|\\|", phrases.get(0));
    assertEquals(BLCOperator.AND, actualCreateGroupsResult.getOperatorType());
    assertTrue(actualCreateGroupsResult.getSubGroups().isEmpty());
  }

  /**
   * Test {@link GroupingTranslator#createGroups(String)}.
   *
   * <ul>
   *   <li>When {@link GroupingTranslator#GROUPSTARTCHAR}.
   *   <li>Then throw {@link MVELTranslationException}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Group GroupingTranslator.createGroups(String)"})
  public void testCreateGroups_whenGroupstartchar_thenThrowMVELTranslationException()
      throws MVELTranslationException {
    // Arrange, Act and Assert
    assertThrows(
        MVELTranslationException.class,
        () -> groupingTranslator.createGroups(GroupingTranslator.GROUPSTARTCHAR));
  }

  /**
   * Test {@link GroupingTranslator#createGroups(String)}.
   *
   * <ul>
   *   <li>When {@code (&&}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Group GroupingTranslator.createGroups(String)"})
  public void testCreateGroups_whenLeftParenthesisAmpersandAmpersand()
      throws MVELTranslationException {
    // Arrange, Act and Assert
    assertThrows(MVELTranslationException.class, () -> groupingTranslator.createGroups("\t(&&"));
  }

  /**
   * Test {@link GroupingTranslator#createGroups(String)}.
   *
   * <ul>
   *   <li>When {@code (\|\|}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Group GroupingTranslator.createGroups(String)"})
  public void testCreateGroups_whenLeftParenthesisBackslashVerticalLineBackslashVerticalLine()
      throws MVELTranslationException {
    // Arrange, Act and Assert
    assertThrows(
        MVELTranslationException.class, () -> groupingTranslator.createGroups("\t(\\|\\|"));
  }

  /**
   * Test {@link GroupingTranslator#createGroups(String)}.
   *
   * <ul>
   *   <li>When {@code ((}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Group GroupingTranslator.createGroups(String)"})
  public void testCreateGroups_whenLeftParenthesisLeftParenthesis()
      throws MVELTranslationException {
    // Arrange, Act and Assert
    assertThrows(MVELTranslationException.class, () -> groupingTranslator.createGroups("\t(("));
  }

  /**
   * Test {@link GroupingTranslator#createGroups(String)}.
   *
   * <ul>
   *   <li>When {@code (;}.
   *   <li>Then throw {@link MVELTranslationException}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Group GroupingTranslator.createGroups(String)"})
  public void testCreateGroups_whenLeftParenthesisSemicolon_thenThrowMVELTranslationException()
      throws MVELTranslationException {
    // Arrange, Act and Assert
    assertThrows(MVELTranslationException.class, () -> groupingTranslator.createGroups("\t(;"));
  }

  /**
   * Test {@link GroupingTranslator#createGroups(String)}.
   *
   * <ul>
   *   <li>When {@code (||}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Group GroupingTranslator.createGroups(String)"})
  public void testCreateGroups_whenLeftParenthesisVerticalLineVerticalLine()
      throws MVELTranslationException {
    // Arrange, Act and Assert
    assertThrows(MVELTranslationException.class, () -> groupingTranslator.createGroups("\t(||"));
  }

  /**
   * Test {@link GroupingTranslator#createGroups(String)}.
   *
   * <ul>
   *   <li>When {@code (}.
   *   <li>Then throw {@link MVELTranslationException}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Group GroupingTranslator.createGroups(String)"})
  public void testCreateGroups_whenLeftParenthesis_thenThrowMVELTranslationException()
      throws MVELTranslationException {
    // Arrange, Act and Assert
    assertThrows(MVELTranslationException.class, () -> groupingTranslator.createGroups("\t("));
  }

  /**
   * Test {@link GroupingTranslator#createGroups(String)}.
   *
   * <ul>
   *   <li>When {@code (}.
   *   <li>Then throw {@link MVELTranslationException}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Group GroupingTranslator.createGroups(String)"})
  public void testCreateGroups_whenLeftParenthesis_thenThrowMVELTranslationException2()
      throws MVELTranslationException {
    // Arrange, Act and Assert
    assertThrows(MVELTranslationException.class, () -> groupingTranslator.createGroups("(\t"));
  }

  /**
   * Test {@link GroupingTranslator#createGroups(String)}.
   *
   * <ul>
   *   <li>When {@code (}.
   *   <li>Then throw {@link MVELTranslationException}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Group GroupingTranslator.createGroups(String)"})
  public void testCreateGroups_whenLeftParenthesis_thenThrowMVELTranslationException3()
      throws MVELTranslationException {
    // Arrange, Act and Assert
    assertThrows(MVELTranslationException.class, () -> groupingTranslator.createGroups("\t\t("));
  }

  /**
   * Test {@link GroupingTranslator#createGroups(String)}.
   *
   * <ul>
   *   <li>When {@code (}.
   *   <li>Then throw {@link MVELTranslationException}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Group GroupingTranslator.createGroups(String)"})
  public void testCreateGroups_whenLeftParenthesis_thenThrowMVELTranslationException4()
      throws MVELTranslationException {
    // Arrange, Act and Assert
    assertThrows(MVELTranslationException.class, () -> groupingTranslator.createGroups("\t(\t"));
  }

  /**
   * Test {@link GroupingTranslator#createGroups(String)}.
   *
   * <ul>
   *   <li>When {@code Mvel42}.
   *   <li>Then return Phrases first is {@code Mvel42}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Group GroupingTranslator.createGroups(String)"})
  public void testCreateGroups_whenMvel42_thenReturnPhrasesFirstIsMvel42()
      throws MVELTranslationException {
    // Arrange and Act
    Group actualCreateGroupsResult = new GroupingTranslator().createGroups("\tMvel42");

    // Assert
    List<String> phrases = actualCreateGroupsResult.getPhrases();
    assertEquals(1, phrases.size());
    assertEquals("Mvel42", phrases.get(0));
    assertEquals(BLCOperator.AND, actualCreateGroupsResult.getOperatorType());
    assertTrue(actualCreateGroupsResult.getSubGroups().isEmpty());
  }

  /**
   * Test {@link GroupingTranslator#createGroups(String)}.
   *
   * <ul>
   *   <li>When {@code MvelMvel}.
   *   <li>Then return Phrases first is {@code MvelMvel}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Group GroupingTranslator.createGroups(String)"})
  public void testCreateGroups_whenMvelMvel_thenReturnPhrasesFirstIsMvelMvel()
      throws MVELTranslationException {
    // Arrange and Act
    Group actualCreateGroupsResult = new GroupingTranslator().createGroups("\tMvelMvel");

    // Assert
    List<String> phrases = actualCreateGroupsResult.getPhrases();
    assertEquals(1, phrases.size());
    assertEquals("MvelMvel", phrases.get(0));
    assertEquals(BLCOperator.AND, actualCreateGroupsResult.getOperatorType());
    assertTrue(actualCreateGroupsResult.getSubGroups().isEmpty());
  }

  /**
   * Test {@link GroupingTranslator#createGroups(String)}.
   *
   * <ul>
   *   <li>When {@code Mvel[\t\n\r]}.
   *   <li>Then return Phrases first is {@code Mvel[\t\n\r]}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Group GroupingTranslator.createGroups(String)"})
  public void testCreateGroups_whenMvelTNR_thenReturnPhrasesFirstIsMvelTNR()
      throws MVELTranslationException {
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
   *
   * <ul>
   *   <li>When {@code ;Mvel}.
   *   <li>Then throw {@link MVELTranslationException}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Group GroupingTranslator.createGroups(String)"})
  public void testCreateGroups_whenMvel_thenThrowMVELTranslationException()
      throws MVELTranslationException {
    // Arrange, Act and Assert
    assertThrows(MVELTranslationException.class, () -> groupingTranslator.createGroups("\t;Mvel"));
  }

  /**
   * Test {@link GroupingTranslator#createGroups(String)}.
   *
   * <ul>
   *   <li>When {@code (Mvel}.
   *   <li>Then throw {@link MVELTranslationException}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Group GroupingTranslator.createGroups(String)"})
  public void testCreateGroups_whenMvel_thenThrowMVELTranslationException2()
      throws MVELTranslationException {
    // Arrange, Act and Assert
    assertThrows(MVELTranslationException.class, () -> groupingTranslator.createGroups("\t(Mvel"));
  }

  /**
   * Test {@link GroupingTranslator#createGroups(String)}.
   *
   * <ul>
   *   <li>When {@code )&&}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Group GroupingTranslator.createGroups(String)"})
  public void testCreateGroups_whenRightParenthesisAmpersandAmpersand()
      throws MVELTranslationException {
    // Arrange and Act
    Group actualCreateGroupsResult = new GroupingTranslator().createGroups("\t)&&");

    // Assert
    List<String> phrases = actualCreateGroupsResult.getPhrases();
    assertEquals(1, phrases.size());
    assertEquals(BLCOperator.AND, actualCreateGroupsResult.getOperatorType());
    assertTrue(actualCreateGroupsResult.getSubGroups().isEmpty());
    assertEquals(GroupingTranslator.GROUPENDCHAR, phrases.get(0));
  }

  /**
   * Test {@link GroupingTranslator#createGroups(String)}.
   *
   * <ul>
   *   <li>When {@code );}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Group GroupingTranslator.createGroups(String)"})
  public void testCreateGroups_whenRightParenthesisSemicolon() throws MVELTranslationException {
    // Arrange and Act
    Group actualCreateGroupsResult = new GroupingTranslator().createGroups("\t);");

    // Assert
    List<String> phrases = actualCreateGroupsResult.getPhrases();
    assertEquals(1, phrases.size());
    assertEquals(BLCOperator.AND, actualCreateGroupsResult.getOperatorType());
    assertTrue(actualCreateGroupsResult.getSubGroups().isEmpty());
    assertEquals(GroupingTranslator.GROUPENDCHAR, phrases.get(0));
  }

  /**
   * Test {@link GroupingTranslator#createGroups(String)}.
   *
   * <ul>
   *   <li>When {@code )||}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Group GroupingTranslator.createGroups(String)"})
  public void testCreateGroups_whenRightParenthesisVerticalLineVerticalLine()
      throws MVELTranslationException {
    // Arrange and Act
    Group actualCreateGroupsResult = new GroupingTranslator().createGroups("\t)||");

    // Assert
    List<String> phrases = actualCreateGroupsResult.getPhrases();
    assertEquals(1, phrases.size());
    assertEquals(BLCOperator.OR, actualCreateGroupsResult.getOperatorType());
    assertTrue(actualCreateGroupsResult.getSubGroups().isEmpty());
    assertEquals(GroupingTranslator.GROUPENDCHAR, phrases.get(0));
  }

  /**
   * Test {@link GroupingTranslator#createGroups(String)}.
   *
   * <ul>
   *   <li>When {@code )}.
   *   <li>Then return Phrases first is {@link GroupingTranslator#GROUPENDCHAR}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Group GroupingTranslator.createGroups(String)"})
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
   *
   * <ul>
   *   <li>When {@code )}.
   *   <li>Then return Phrases first is {@link GroupingTranslator#GROUPENDCHAR}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Group GroupingTranslator.createGroups(String)"})
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
   *
   * <ul>
   *   <li>When {@code )}.
   *   <li>Then return Phrases first is {@link GroupingTranslator#GROUPENDCHAR}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Group GroupingTranslator.createGroups(String)"})
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
   *
   * <ul>
   *   <li>When {@code )}.
   *   <li>Then return Phrases first is {@link GroupingTranslator#GROUPENDCHAR}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Group GroupingTranslator.createGroups(String)"})
  public void testCreateGroups_whenRightParenthesis_thenReturnPhrasesFirstIsGroupendchar4()
      throws MVELTranslationException {
    // Arrange and Act
    Group actualCreateGroupsResult = new GroupingTranslator().createGroups("\t)\t");

    // Assert
    List<String> phrases = actualCreateGroupsResult.getPhrases();
    assertEquals(1, phrases.size());
    assertEquals(BLCOperator.AND, actualCreateGroupsResult.getOperatorType());
    assertTrue(actualCreateGroupsResult.getSubGroups().isEmpty());
    assertEquals(GroupingTranslator.GROUPENDCHAR, phrases.get(0));
  }

  /**
   * Test {@link GroupingTranslator#createGroups(String)}.
   *
   * <ul>
   *   <li>When {@code ;&&}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Group GroupingTranslator.createGroups(String)"})
  public void testCreateGroups_whenSemicolonAmpersandAmpersand() throws MVELTranslationException {
    // Arrange, Act and Assert
    assertThrows(MVELTranslationException.class, () -> groupingTranslator.createGroups("\t;&&"));
  }

  /**
   * Test {@link GroupingTranslator#createGroups(String)}.
   *
   * <ul>
   *   <li>When {@code ;\|\|}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Group GroupingTranslator.createGroups(String)"})
  public void testCreateGroups_whenSemicolonBackslashVerticalLineBackslashVerticalLine()
      throws MVELTranslationException {
    // Arrange, Act and Assert
    assertThrows(
        MVELTranslationException.class, () -> groupingTranslator.createGroups("\t;\\|\\|"));
  }

  /**
   * Test {@link GroupingTranslator#createGroups(String)}.
   *
   * <ul>
   *   <li>When {@code ;(}.
   *   <li>Then throw {@link MVELTranslationException}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Group GroupingTranslator.createGroups(String)"})
  public void testCreateGroups_whenSemicolonLeftParenthesis_thenThrowMVELTranslationException()
      throws MVELTranslationException {
    // Arrange, Act and Assert
    assertThrows(MVELTranslationException.class, () -> groupingTranslator.createGroups("\t;("));
  }

  /**
   * Test {@link GroupingTranslator#createGroups(String)}.
   *
   * <ul>
   *   <li>When {@code ;)}.
   *   <li>Then throw {@link MVELTranslationException}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Group GroupingTranslator.createGroups(String)"})
  public void testCreateGroups_whenSemicolonRightParenthesis_thenThrowMVELTranslationException()
      throws MVELTranslationException {
    // Arrange, Act and Assert
    assertThrows(MVELTranslationException.class, () -> groupingTranslator.createGroups("\t;)"));
  }

  /**
   * Test {@link GroupingTranslator#createGroups(String)}.
   *
   * <ul>
   *   <li>When {@code ;||}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Group GroupingTranslator.createGroups(String)"})
  public void testCreateGroups_whenSemicolonVerticalLineVerticalLine()
      throws MVELTranslationException {
    // Arrange, Act and Assert
    assertThrows(MVELTranslationException.class, () -> groupingTranslator.createGroups("\t;||"));
  }

  /**
   * Test {@link GroupingTranslator#createGroups(String)}.
   *
   * <ul>
   *   <li>When {@code [\t\n\r]Mvel}.
   *   <li>Then return Phrases first is {@code [\t\n\r]Mvel}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Group GroupingTranslator.createGroups(String)"})
  public void testCreateGroups_whenTNRMvel_thenReturnPhrasesFirstIsTNRMvel()
      throws MVELTranslationException {
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
   *
   * <ul>
   *   <li>When {@code [\t\n\r] Mvel}.
   *   <li>Then return Phrases first is {@code [\t\n\r]Mvel}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Group GroupingTranslator.createGroups(String)"})
  public void testCreateGroups_whenTNRMvel_thenReturnPhrasesFirstIsTNRMvel2()
      throws MVELTranslationException {
    // Arrange and Act
    Group actualCreateGroupsResult = new GroupingTranslator().createGroups("[\\t\\n\\r]\tMvel");

    // Assert
    List<String> phrases = actualCreateGroupsResult.getPhrases();
    assertEquals(1, phrases.size());
    assertEquals("[\\t\\n\\r]Mvel", phrases.get(0));
    assertEquals(BLCOperator.AND, actualCreateGroupsResult.getOperatorType());
    assertTrue(actualCreateGroupsResult.getSubGroups().isEmpty());
  }

  /**
   * Test {@link GroupingTranslator#createGroups(String)}.
   *
   * <ul>
   *   <li>When {@code [\t\n\r]Mvel}.
   *   <li>Then return Phrases first is {@code [\t\n\r]Mvel}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Group GroupingTranslator.createGroups(String)"})
  public void testCreateGroups_whenTNRMvel_thenReturnPhrasesFirstIsTNRMvel3()
      throws MVELTranslationException {
    // Arrange and Act
    Group actualCreateGroupsResult = new GroupingTranslator().createGroups("[\\t\\n\\r]Mvel\t");

    // Assert
    List<String> phrases = actualCreateGroupsResult.getPhrases();
    assertEquals(1, phrases.size());
    assertEquals("[\\t\\n\\r]Mvel", phrases.get(0));
    assertEquals(BLCOperator.AND, actualCreateGroupsResult.getOperatorType());
    assertTrue(actualCreateGroupsResult.getSubGroups().isEmpty());
  }

  /**
   * Test {@link GroupingTranslator#createGroups(String)}.
   *
   * <ul>
   *   <li>When {@code [\t\n\r][\t\n\r]}.
   *   <li>Then return Phrases first is {@code [\t\n\r][\t\n\r]}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Group GroupingTranslator.createGroups(String)"})
  public void testCreateGroups_whenTNRTNR_thenReturnPhrasesFirstIsTNRTNR()
      throws MVELTranslationException {
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
   *
   * <ul>
   *   <li>When {@code [\t\n\r] [\t\n\r]}.
   *   <li>Then return Phrases first is {@code [\t\n\r][\t\n\r]}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Group GroupingTranslator.createGroups(String)"})
  public void testCreateGroups_whenTNRTNR_thenReturnPhrasesFirstIsTNRTNR2()
      throws MVELTranslationException {
    // Arrange and Act
    Group actualCreateGroupsResult =
        new GroupingTranslator().createGroups("[\\t\\n\\r]\t[\\t\\n\\r]");

    // Assert
    List<String> phrases = actualCreateGroupsResult.getPhrases();
    assertEquals(1, phrases.size());
    assertEquals("[\\t\\n\\r][\\t\\n\\r]", phrases.get(0));
    assertEquals(BLCOperator.AND, actualCreateGroupsResult.getOperatorType());
    assertTrue(actualCreateGroupsResult.getSubGroups().isEmpty());
  }

  /**
   * Test {@link GroupingTranslator#createGroups(String)}.
   *
   * <ul>
   *   <li>When {@code [\t\n\r][\t\n\r]}.
   *   <li>Then return Phrases first is {@code [\t\n\r][\t\n\r]}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Group GroupingTranslator.createGroups(String)"})
  public void testCreateGroups_whenTNRTNR_thenReturnPhrasesFirstIsTNRTNR3()
      throws MVELTranslationException {
    // Arrange and Act
    Group actualCreateGroupsResult =
        new GroupingTranslator().createGroups("[\\t\\n\\r][\\t\\n\\r]\t");

    // Assert
    List<String> phrases = actualCreateGroupsResult.getPhrases();
    assertEquals(1, phrases.size());
    assertEquals("[\\t\\n\\r][\\t\\n\\r]", phrases.get(0));
    assertEquals(BLCOperator.AND, actualCreateGroupsResult.getOperatorType());
    assertTrue(actualCreateGroupsResult.getSubGroups().isEmpty());
  }

  /**
   * Test {@link GroupingTranslator#createGroups(String)}.
   *
   * <ul>
   *   <li>When {@code ;[\t\n\r]}.
   *   <li>Then throw {@link MVELTranslationException}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Group GroupingTranslator.createGroups(String)"})
  public void testCreateGroups_whenTNR_thenThrowMVELTranslationException()
      throws MVELTranslationException {
    // Arrange, Act and Assert
    assertThrows(
        MVELTranslationException.class, () -> groupingTranslator.createGroups(";[\\t\\n\\r]"));
  }

  /**
   * Test {@link GroupingTranslator#createGroups(String)}.
   *
   * <ul>
   *   <li>When {@code ([\t\n\r]}.
   *   <li>Then throw {@link MVELTranslationException}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Group GroupingTranslator.createGroups(String)"})
  public void testCreateGroups_whenTNR_thenThrowMVELTranslationException2()
      throws MVELTranslationException {
    // Arrange, Act and Assert
    assertThrows(
        MVELTranslationException.class, () -> groupingTranslator.createGroups("([\\t\\n\\r]"));
  }

  /**
   * Test {@link GroupingTranslator#createGroups(String)}.
   *
   * <ul>
   *   <li>When {@code ;[\t\n\r]}.
   *   <li>Then throw {@link MVELTranslationException}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Group GroupingTranslator.createGroups(String)"})
  public void testCreateGroups_whenTNR_thenThrowMVELTranslationException3()
      throws MVELTranslationException {
    // Arrange, Act and Assert
    assertThrows(
        MVELTranslationException.class, () -> groupingTranslator.createGroups("\t;[\\t\\n\\r]"));
  }

  /**
   * Test {@link GroupingTranslator#createGroups(String)}.
   *
   * <ul>
   *   <li>When {@code ([\t\n\r]}.
   *   <li>Then throw {@link MVELTranslationException}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Group GroupingTranslator.createGroups(String)"})
  public void testCreateGroups_whenTNR_thenThrowMVELTranslationException4()
      throws MVELTranslationException {
    // Arrange, Act and Assert
    assertThrows(
        MVELTranslationException.class, () -> groupingTranslator.createGroups("\t([\\t\\n\\r]"));
  }

  /**
   * Test {@link GroupingTranslator#createGroups(String)}.
   *
   * <ul>
   *   <li>When tab tab tab.
   *   <li>Then return OperatorType is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Group GroupingTranslator.createGroups(String)"})
  public void testCreateGroups_whenTabTabTab_thenReturnOperatorTypeIsNull()
      throws MVELTranslationException {
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
   *
   * <ul>
   *   <li>When {@code ||&&}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Group GroupingTranslator.createGroups(String)"})
  public void testCreateGroups_whenVerticalLineVerticalLineAmpersandAmpersand()
      throws MVELTranslationException {
    // Arrange and Act
    Group actualCreateGroupsResult = new GroupingTranslator().createGroups("\t||&&");

    // Assert
    List<String> phrases = actualCreateGroupsResult.getPhrases();
    assertEquals(1, phrases.size());
    assertEquals("||", phrases.get(0));
    assertEquals(BLCOperator.AND, actualCreateGroupsResult.getOperatorType());
    assertTrue(actualCreateGroupsResult.getSubGroups().isEmpty());
  }

  /**
   * Test {@link GroupingTranslator#createGroups(String)}.
   *
   * <ul>
   *   <li>When {@code ||(}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Group GroupingTranslator.createGroups(String)"})
  public void testCreateGroups_whenVerticalLineVerticalLineLeftParenthesis()
      throws MVELTranslationException {
    // Arrange, Act and Assert
    assertThrows(
        MVELTranslationException.class, () -> new GroupingTranslator().createGroups("\t||("));
  }

  /**
   * Test {@link GroupingTranslator#createGroups(String)}.
   *
   * <ul>
   *   <li>When {@code ||)}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Group GroupingTranslator.createGroups(String)"})
  public void testCreateGroups_whenVerticalLineVerticalLineRightParenthesis()
      throws MVELTranslationException {
    // Arrange and Act
    Group actualCreateGroupsResult = new GroupingTranslator().createGroups("\t||)");

    // Assert
    List<String> phrases = actualCreateGroupsResult.getPhrases();
    assertEquals(1, phrases.size());
    assertEquals(BLCOperator.OR, actualCreateGroupsResult.getOperatorType());
    assertTrue(actualCreateGroupsResult.getSubGroups().isEmpty());
    assertEquals(GroupingTranslator.GROUPENDCHAR, phrases.get(0));
  }

  /**
   * Test {@link GroupingTranslator#createGroups(String)}.
   *
   * <ul>
   *   <li>When {@code ||;}.
   *   <li>Then return Phrases Empty.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Group GroupingTranslator.createGroups(String)"})
  public void testCreateGroups_whenVerticalLineVerticalLineSemicolon_thenReturnPhrasesEmpty()
      throws MVELTranslationException {
    // Arrange and Act
    Group actualCreateGroupsResult = new GroupingTranslator().createGroups("\t||;");

    // Assert
    assertEquals(BLCOperator.OR, actualCreateGroupsResult.getOperatorType());
    assertTrue(actualCreateGroupsResult.getPhrases().isEmpty());
    assertTrue(actualCreateGroupsResult.getSubGroups().isEmpty());
    assertTrue(actualCreateGroupsResult.getIsTopGroup());
  }

  /**
   * Test {@link GroupingTranslator#createGroups(String)}.
   *
   * <ul>
   *   <li>When {@code ||||}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Group GroupingTranslator.createGroups(String)"})
  public void testCreateGroups_whenVerticalLineVerticalLineVerticalLineVerticalLine()
      throws MVELTranslationException {
    // Arrange and Act
    Group actualCreateGroupsResult = new GroupingTranslator().createGroups("\t||||");

    // Assert
    assertEquals(BLCOperator.OR, actualCreateGroupsResult.getOperatorType());
    assertTrue(actualCreateGroupsResult.getPhrases().isEmpty());
    assertTrue(actualCreateGroupsResult.getSubGroups().isEmpty());
    assertTrue(actualCreateGroupsResult.getIsTopGroup());
  }

  /**
   * Test {@link GroupingTranslator#createGroups(String)}.
   *
   * <ul>
   *   <li>When {@code ||}.
   *   <li>Then return Phrases Empty.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Group GroupingTranslator.createGroups(String)"})
  public void testCreateGroups_whenVerticalLineVerticalLine_thenReturnPhrasesEmpty()
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
   *
   * <ul>
   *   <li>When {@code ||}.
   *   <li>Then return Phrases Empty.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Group GroupingTranslator.createGroups(String)"})
  public void testCreateGroups_whenVerticalLineVerticalLine_thenReturnPhrasesEmpty2()
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
   *
   * <ul>
   *   <li>When {@code ||}.
   *   <li>Then return Phrases Empty.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Group GroupingTranslator.createGroups(String)"})
  public void testCreateGroups_whenVerticalLineVerticalLine_thenReturnPhrasesEmpty3()
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
   *
   * <ul>
   *   <li>When {@code ||}.
   *   <li>Then return Phrases Empty.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Group GroupingTranslator.createGroups(String)"})
  public void testCreateGroups_whenVerticalLineVerticalLine_thenReturnPhrasesEmpty4()
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
   * Test {@link GroupingTranslator#createGroups(String)}.
   *
   * <ul>
   *   <li>When {@code ||}.
   *   <li>Then return Phrases Empty.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#createGroups(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Group GroupingTranslator.createGroups(String)"})
  public void testCreateGroups_whenVerticalLineVerticalLine_thenReturnPhrasesEmpty5()
      throws MVELTranslationException {
    // Arrange and Act
    Group actualCreateGroupsResult = new GroupingTranslator().createGroups("\t||\t");

    // Assert
    assertEquals(BLCOperator.OR, actualCreateGroupsResult.getOperatorType());
    assertTrue(actualCreateGroupsResult.getPhrases().isEmpty());
    assertTrue(actualCreateGroupsResult.getSubGroups().isEmpty());
    assertTrue(actualCreateGroupsResult.getIsTopGroup());
  }

  /**
   * Test {@link GroupingTranslator#findGroupStart(String, int)}.
   *
   * <p>Method under test: {@link GroupingTranslator#findGroupStart(String, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int GroupingTranslator.findGroupStart(String, int)"})
  public void testFindGroupStart() {
    // Arrange, Act and Assert
    assertEquals(-1, groupingTranslator.findGroupStart("Segment", 1));
  }

  /**
   * Test {@link GroupingTranslator#findGroupEnd(String, int)}.
   *
   * <ul>
   *   <li>When {@code Segment}.
   *   <li>Then throw {@link MVELTranslationException}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#findGroupEnd(String, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int GroupingTranslator.findGroupEnd(String, int)"})
  public void testFindGroupEnd_whenSegment_thenThrowMVELTranslationException()
      throws MVELTranslationException {
    // Arrange, Act and Assert
    assertThrows(
        MVELTranslationException.class, () -> groupingTranslator.findGroupEnd("Segment", 1));
  }

  /**
   * Test {@link GroupingTranslator#findGroupEnd(String, int)}.
   *
   * <ul>
   *   <li>When {@code Unable to find an end parenthesis for the group started at (}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#findGroupEnd(String, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int GroupingTranslator.findGroupEnd(String, int)"})
  public void testFindGroupEnd_whenUnableToFindAnEndParenthesisForTheGroupStartedAt()
      throws MVELTranslationException {
    // Arrange, Act and Assert
    assertThrows(
        MVELTranslationException.class,
        () ->
            groupingTranslator.findGroupEnd(
                "Unable to find an end parenthesis for the group started at (", 1));
  }

  /**
   * Test {@link GroupingTranslator#stripWhiteSpace(String)}.
   *
   * <p>Method under test: {@link GroupingTranslator#stripWhiteSpace(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String GroupingTranslator.stripWhiteSpace(String)"})
  public void testStripWhiteSpace() {
    // Arrange, Act and Assert
    assertEquals("&&\\|\\|", groupingTranslator.stripWhiteSpace("\t&&\\|\\|"));
  }

  /**
   * Test {@link GroupingTranslator#stripWhiteSpace(String)}.
   *
   * <p>Method under test: {@link GroupingTranslator#stripWhiteSpace(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String GroupingTranslator.stripWhiteSpace(String)"})
  public void testStripWhiteSpace2() {
    // Arrange, Act and Assert
    assertEquals("(\\|\\|", new GroupingTranslator().stripWhiteSpace("\t(\\|\\|"));
  }

  /**
   * Test {@link GroupingTranslator#stripWhiteSpace(String)}.
   *
   * <p>Method under test: {@link GroupingTranslator#stripWhiteSpace(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String GroupingTranslator.stripWhiteSpace(String)"})
  public void testStripWhiteSpace3() {
    // Arrange, Act and Assert
    assertEquals(")\\|\\|", new GroupingTranslator().stripWhiteSpace("\t)\\|\\|"));
  }

  /**
   * Test {@link GroupingTranslator#stripWhiteSpace(String)}.
   *
   * <p>Method under test: {@link GroupingTranslator#stripWhiteSpace(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String GroupingTranslator.stripWhiteSpace(String)"})
  public void testStripWhiteSpace4() {
    // Arrange, Act and Assert
    assertEquals(";\\|\\|", new GroupingTranslator().stripWhiteSpace("\t;\\|\\|"));
  }

  /**
   * Test {@link GroupingTranslator#stripWhiteSpace(String)}.
   *
   * <p>Method under test: {@link GroupingTranslator#stripWhiteSpace(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String GroupingTranslator.stripWhiteSpace(String)"})
  public void testStripWhiteSpace5() {
    // Arrange, Act and Assert
    assertEquals("\\|\\|&&", new GroupingTranslator().stripWhiteSpace("\t\\|\\|&&"));
  }

  /**
   * Test {@link GroupingTranslator#stripWhiteSpace(String)}.
   *
   * <p>Method under test: {@link GroupingTranslator#stripWhiteSpace(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String GroupingTranslator.stripWhiteSpace(String)"})
  public void testStripWhiteSpace6() {
    // Arrange, Act and Assert
    assertEquals("\\|\\|(", new GroupingTranslator().stripWhiteSpace("\t\\|\\|("));
  }

  /**
   * Test {@link GroupingTranslator#stripWhiteSpace(String)}.
   *
   * <p>Method under test: {@link GroupingTranslator#stripWhiteSpace(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String GroupingTranslator.stripWhiteSpace(String)"})
  public void testStripWhiteSpace7() {
    // Arrange, Act and Assert
    assertEquals("\\|\\|)", new GroupingTranslator().stripWhiteSpace("\t\\|\\|)"));
  }

  /**
   * Test {@link GroupingTranslator#stripWhiteSpace(String)}.
   *
   * <p>Method under test: {@link GroupingTranslator#stripWhiteSpace(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String GroupingTranslator.stripWhiteSpace(String)"})
  public void testStripWhiteSpace8() {
    // Arrange, Act and Assert
    assertEquals("\\|\\|;", new GroupingTranslator().stripWhiteSpace("\t\\|\\|;"));
  }

  /**
   * Test {@link GroupingTranslator#stripWhiteSpace(String)}.
   *
   * <p>Method under test: {@link GroupingTranslator#stripWhiteSpace(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String GroupingTranslator.stripWhiteSpace(String)"})
  public void testStripWhiteSpace9() {
    // Arrange, Act and Assert
    assertEquals("\\|\\|\\|\\|", new GroupingTranslator().stripWhiteSpace("\t\\|\\|\\|\\|"));
  }

  /**
   * Test {@link GroupingTranslator#stripWhiteSpace(String)}.
   *
   * <p>Method under test: {@link GroupingTranslator#stripWhiteSpace(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String GroupingTranslator.stripWhiteSpace(String)"})
  public void testStripWhiteSpace10() {
    // Arrange, Act and Assert
    assertEquals("\\|\\|||", new GroupingTranslator().stripWhiteSpace("\t\\|\\|||"));
  }

  /**
   * Test {@link GroupingTranslator#stripWhiteSpace(String)}.
   *
   * <p>Method under test: {@link GroupingTranslator#stripWhiteSpace(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String GroupingTranslator.stripWhiteSpace(String)"})
  public void testStripWhiteSpace11() {
    // Arrange, Act and Assert
    assertEquals("||\\|\\|", new GroupingTranslator().stripWhiteSpace("\t||\\|\\|"));
  }

  /**
   * Test {@link GroupingTranslator#stripWhiteSpace(String)}.
   *
   * <ul>
   *   <li>Given {@link GroupingTranslator}.
   *   <li>When {@code 42Mvel}.
   *   <li>Then return {@code 42Mvel}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#stripWhiteSpace(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String GroupingTranslator.stripWhiteSpace(String)"})
  public void testStripWhiteSpace_givenGroupingTranslator_when42Mvel_thenReturn42Mvel() {
    // Arrange, Act and Assert
    assertEquals("42Mvel", groupingTranslator.stripWhiteSpace("\t42Mvel"));
  }

  /**
   * Test {@link GroupingTranslator#stripWhiteSpace(String)}.
   *
   * <ul>
   *   <li>Given {@link GroupingTranslator}.
   *   <li>When {@code 42[\t\n\r]}.
   *   <li>Then return {@code 42[\t\n\r]}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#stripWhiteSpace(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String GroupingTranslator.stripWhiteSpace(String)"})
  public void testStripWhiteSpace_givenGroupingTranslator_when42TNR_thenReturn42TNR() {
    // Arrange, Act and Assert
    assertEquals("42[\\t\\n\\r]", groupingTranslator.stripWhiteSpace("\t42[\\t\\n\\r]"));
  }

  /**
   * Test {@link GroupingTranslator#stripWhiteSpace(String)}.
   *
   * <ul>
   *   <li>Given {@link GroupingTranslator}.
   *   <li>When {@code 42}.
   *   <li>Then return {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#stripWhiteSpace(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String GroupingTranslator.stripWhiteSpace(String)"})
  public void testStripWhiteSpace_givenGroupingTranslator_when42_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("42", groupingTranslator.stripWhiteSpace("\t42"));
  }

  /**
   * Test {@link GroupingTranslator#stripWhiteSpace(String)}.
   *
   * <ul>
   *   <li>Given {@link GroupingTranslator}.
   *   <li>When {@code 42}.
   *   <li>Then return {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#stripWhiteSpace(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String GroupingTranslator.stripWhiteSpace(String)"})
  public void testStripWhiteSpace_givenGroupingTranslator_when42_thenReturn422() {
    // Arrange, Act and Assert
    assertEquals("42", groupingTranslator.stripWhiteSpace("42\t"));
  }

  /**
   * Test {@link GroupingTranslator#stripWhiteSpace(String)}.
   *
   * <ul>
   *   <li>Given {@link GroupingTranslator}.
   *   <li>When {@code 42}.
   *   <li>Then return {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#stripWhiteSpace(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String GroupingTranslator.stripWhiteSpace(String)"})
  public void testStripWhiteSpace_givenGroupingTranslator_when42_thenReturn423() {
    // Arrange, Act and Assert
    assertEquals("42", groupingTranslator.stripWhiteSpace("\t\t42"));
  }

  /**
   * Test {@link GroupingTranslator#stripWhiteSpace(String)}.
   *
   * <ul>
   *   <li>Given {@link GroupingTranslator}.
   *   <li>When {@code &&42}.
   *   <li>Then return {@code &&42}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#stripWhiteSpace(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String GroupingTranslator.stripWhiteSpace(String)"})
  public void testStripWhiteSpace_givenGroupingTranslator_when42_thenReturn424() {
    // Arrange, Act and Assert
    assertEquals("&&42", groupingTranslator.stripWhiteSpace("\t&&42"));
  }

  /**
   * Test {@link GroupingTranslator#stripWhiteSpace(String)}.
   *
   * <ul>
   *   <li>Given {@link GroupingTranslator}.
   *   <li>When {@code 42}.
   *   <li>Then return {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#stripWhiteSpace(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String GroupingTranslator.stripWhiteSpace(String)"})
  public void testStripWhiteSpace_givenGroupingTranslator_when42_thenReturn425() {
    // Arrange, Act and Assert
    assertEquals("42", groupingTranslator.stripWhiteSpace("\t42\t"));
  }

  /**
   * Test {@link GroupingTranslator#stripWhiteSpace(String)}.
   *
   * <ul>
   *   <li>Given {@link GroupingTranslator}.
   *   <li>When {@code 42&&}.
   *   <li>Then return {@code 42&&}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#stripWhiteSpace(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String GroupingTranslator.stripWhiteSpace(String)"})
  public void testStripWhiteSpace_givenGroupingTranslator_when42_thenReturn426() {
    // Arrange, Act and Assert
    assertEquals("42&&", groupingTranslator.stripWhiteSpace("\t42&&"));
  }

  /**
   * Test {@link GroupingTranslator#stripWhiteSpace(String)}.
   *
   * <ul>
   *   <li>Given {@link GroupingTranslator}.
   *   <li>When {@code 42(}.
   *   <li>Then return {@code 42(}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#stripWhiteSpace(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String GroupingTranslator.stripWhiteSpace(String)"})
  public void testStripWhiteSpace_givenGroupingTranslator_when42_thenReturn427() {
    // Arrange, Act and Assert
    assertEquals("42(", groupingTranslator.stripWhiteSpace("\t42("));
  }

  /**
   * Test {@link GroupingTranslator#stripWhiteSpace(String)}.
   *
   * <ul>
   *   <li>Given {@link GroupingTranslator}.
   *   <li>When {@code 42)}.
   *   <li>Then return {@code 42)}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#stripWhiteSpace(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String GroupingTranslator.stripWhiteSpace(String)"})
  public void testStripWhiteSpace_givenGroupingTranslator_when42_thenReturn428() {
    // Arrange, Act and Assert
    assertEquals("42)", groupingTranslator.stripWhiteSpace("\t42)"));
  }

  /**
   * Test {@link GroupingTranslator#stripWhiteSpace(String)}.
   *
   * <ul>
   *   <li>Given {@link GroupingTranslator}.
   *   <li>When {@code 42;}.
   *   <li>Then return {@code 42;}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#stripWhiteSpace(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String GroupingTranslator.stripWhiteSpace(String)"})
  public void testStripWhiteSpace_givenGroupingTranslator_when42_thenReturn429() {
    // Arrange, Act and Assert
    assertEquals("42;", groupingTranslator.stripWhiteSpace("\t42;"));
  }

  /**
   * Test {@link GroupingTranslator#stripWhiteSpace(String)}.
   *
   * <ul>
   *   <li>Given {@link GroupingTranslator}.
   *   <li>When {@code 42\|\|}.
   *   <li>Then return {@code 42\|\|}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#stripWhiteSpace(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String GroupingTranslator.stripWhiteSpace(String)"})
  public void testStripWhiteSpace_givenGroupingTranslator_when42_thenReturn4210() {
    // Arrange, Act and Assert
    assertEquals("42\\|\\|", groupingTranslator.stripWhiteSpace("\t42\\|\\|"));
  }

  /**
   * Test {@link GroupingTranslator#stripWhiteSpace(String)}.
   *
   * <ul>
   *   <li>Given {@link GroupingTranslator}.
   *   <li>When {@code 42||}.
   *   <li>Then return {@code 42||}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#stripWhiteSpace(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String GroupingTranslator.stripWhiteSpace(String)"})
  public void testStripWhiteSpace_givenGroupingTranslator_when42_thenReturn4211() {
    // Arrange, Act and Assert
    assertEquals("42||", groupingTranslator.stripWhiteSpace("\t42||"));
  }

  /**
   * Test {@link GroupingTranslator#stripWhiteSpace(String)}.
   *
   * <ul>
   *   <li>Given {@link GroupingTranslator}.
   *   <li>When {@code (42}.
   *   <li>Then return {@code (42}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#stripWhiteSpace(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String GroupingTranslator.stripWhiteSpace(String)"})
  public void testStripWhiteSpace_givenGroupingTranslator_when42_thenReturn4212() {
    // Arrange, Act and Assert
    assertEquals("(42", groupingTranslator.stripWhiteSpace("\t(42"));
  }

  /**
   * Test {@link GroupingTranslator#stripWhiteSpace(String)}.
   *
   * <ul>
   *   <li>Given {@link GroupingTranslator} (default constructor).
   *   <li>When {@code )42}.
   *   <li>Then return {@code )42}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#stripWhiteSpace(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String GroupingTranslator.stripWhiteSpace(String)"})
  public void testStripWhiteSpace_givenGroupingTranslator_when42_thenReturn4213() {
    // Arrange, Act and Assert
    assertEquals(")42", new GroupingTranslator().stripWhiteSpace("\t)42"));
  }

  /**
   * Test {@link GroupingTranslator#stripWhiteSpace(String)}.
   *
   * <ul>
   *   <li>Given {@link GroupingTranslator} (default constructor).
   *   <li>When {@code ;42}.
   *   <li>Then return {@code ;42}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#stripWhiteSpace(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String GroupingTranslator.stripWhiteSpace(String)"})
  public void testStripWhiteSpace_givenGroupingTranslator_when42_thenReturn4214() {
    // Arrange, Act and Assert
    assertEquals(";42", new GroupingTranslator().stripWhiteSpace("\t;42"));
  }

  /**
   * Test {@link GroupingTranslator#stripWhiteSpace(String)}.
   *
   * <ul>
   *   <li>Given {@link GroupingTranslator} (default constructor).
   *   <li>When {@code \|\|42}.
   *   <li>Then return {@code \|\|42}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#stripWhiteSpace(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String GroupingTranslator.stripWhiteSpace(String)"})
  public void testStripWhiteSpace_givenGroupingTranslator_when42_thenReturn4215() {
    // Arrange, Act and Assert
    assertEquals("\\|\\|42", new GroupingTranslator().stripWhiteSpace("\t\\|\\|42"));
  }

  /**
   * Test {@link GroupingTranslator#stripWhiteSpace(String)}.
   *
   * <ul>
   *   <li>Given {@link GroupingTranslator} (default constructor).
   *   <li>When {@code ||42}.
   *   <li>Then return {@code ||42}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#stripWhiteSpace(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String GroupingTranslator.stripWhiteSpace(String)"})
  public void testStripWhiteSpace_givenGroupingTranslator_when42_thenReturn4216() {
    // Arrange, Act and Assert
    assertEquals("||42", new GroupingTranslator().stripWhiteSpace("\t||42"));
  }

  /**
   * Test {@link GroupingTranslator#stripWhiteSpace(String)}.
   *
   * <ul>
   *   <li>Given {@link GroupingTranslator}.
   *   <li>When {@code 4242}.
   *   <li>Then return {@code 4242}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#stripWhiteSpace(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String GroupingTranslator.stripWhiteSpace(String)"})
  public void testStripWhiteSpace_givenGroupingTranslator_when4242_thenReturn4242() {
    // Arrange, Act and Assert
    assertEquals("4242", groupingTranslator.stripWhiteSpace("\t4242"));
  }

  /**
   * Test {@link GroupingTranslator#stripWhiteSpace(String)}.
   *
   * <ul>
   *   <li>Given {@link GroupingTranslator}.
   *   <li>When {@code Mvel42}.
   *   <li>Then return {@code Mvel42}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#stripWhiteSpace(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String GroupingTranslator.stripWhiteSpace(String)"})
  public void testStripWhiteSpace_givenGroupingTranslator_whenMvel42_thenReturnMvel42() {
    // Arrange, Act and Assert
    assertEquals("Mvel42", groupingTranslator.stripWhiteSpace("\tMvel42"));
  }

  /**
   * Test {@link GroupingTranslator#stripWhiteSpace(String)}.
   *
   * <ul>
   *   <li>Given {@link GroupingTranslator}.
   *   <li>When {@code MvelMvel}.
   *   <li>Then return {@code MvelMvel}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#stripWhiteSpace(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String GroupingTranslator.stripWhiteSpace(String)"})
  public void testStripWhiteSpace_givenGroupingTranslator_whenMvelMvel_thenReturnMvelMvel() {
    // Arrange, Act and Assert
    assertEquals("MvelMvel", groupingTranslator.stripWhiteSpace("\tMvelMvel"));
  }

  /**
   * Test {@link GroupingTranslator#stripWhiteSpace(String)}.
   *
   * <ul>
   *   <li>Given {@link GroupingTranslator}.
   *   <li>When {@code Mvel[\t\n\r]}.
   *   <li>Then return {@code Mvel[\t\n\r]}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#stripWhiteSpace(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String GroupingTranslator.stripWhiteSpace(String)"})
  public void testStripWhiteSpace_givenGroupingTranslator_whenMvelTNR_thenReturnMvelTNR() {
    // Arrange, Act and Assert
    assertEquals("Mvel[\\t\\n\\r]", groupingTranslator.stripWhiteSpace("\tMvel[\\t\\n\\r]"));
  }

  /**
   * Test {@link GroupingTranslator#stripWhiteSpace(String)}.
   *
   * <ul>
   *   <li>Given {@link GroupingTranslator}.
   *   <li>When {@code Mvel}.
   *   <li>Then return {@code Mvel}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#stripWhiteSpace(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String GroupingTranslator.stripWhiteSpace(String)"})
  public void testStripWhiteSpace_givenGroupingTranslator_whenMvel_thenReturnMvel() {
    // Arrange, Act and Assert
    assertEquals("Mvel", groupingTranslator.stripWhiteSpace("Mvel"));
  }

  /**
   * Test {@link GroupingTranslator#stripWhiteSpace(String)}.
   *
   * <ul>
   *   <li>Given {@link GroupingTranslator}.
   *   <li>When {@code Mvel}.
   *   <li>Then return {@code Mvel}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#stripWhiteSpace(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String GroupingTranslator.stripWhiteSpace(String)"})
  public void testStripWhiteSpace_givenGroupingTranslator_whenMvel_thenReturnMvel2() {
    // Arrange, Act and Assert
    assertEquals("Mvel", groupingTranslator.stripWhiteSpace("\tMvel"));
  }

  /**
   * Test {@link GroupingTranslator#stripWhiteSpace(String)}.
   *
   * <ul>
   *   <li>Given {@link GroupingTranslator}.
   *   <li>When {@code Mvel}.
   *   <li>Then return {@code Mvel}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#stripWhiteSpace(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String GroupingTranslator.stripWhiteSpace(String)"})
  public void testStripWhiteSpace_givenGroupingTranslator_whenMvel_thenReturnMvel3() {
    // Arrange, Act and Assert
    assertEquals("Mvel", groupingTranslator.stripWhiteSpace("Mvel\t"));
  }

  /**
   * Test {@link GroupingTranslator#stripWhiteSpace(String)}.
   *
   * <ul>
   *   <li>Given {@link GroupingTranslator}.
   *   <li>When {@code Mvel}.
   *   <li>Then return {@code Mvel}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#stripWhiteSpace(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String GroupingTranslator.stripWhiteSpace(String)"})
  public void testStripWhiteSpace_givenGroupingTranslator_whenMvel_thenReturnMvel4() {
    // Arrange, Act and Assert
    assertEquals("Mvel", groupingTranslator.stripWhiteSpace("\t\tMvel"));
  }

  /**
   * Test {@link GroupingTranslator#stripWhiteSpace(String)}.
   *
   * <ul>
   *   <li>Given {@link GroupingTranslator}.
   *   <li>When {@code Mvel}.
   *   <li>Then return {@code Mvel}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#stripWhiteSpace(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String GroupingTranslator.stripWhiteSpace(String)"})
  public void testStripWhiteSpace_givenGroupingTranslator_whenMvel_thenReturnMvel5() {
    // Arrange, Act and Assert
    assertEquals("Mvel", groupingTranslator.stripWhiteSpace("\tMvel\t"));
  }

  /**
   * Test {@link GroupingTranslator#stripWhiteSpace(String)}.
   *
   * <ul>
   *   <li>Given {@link GroupingTranslator}.
   *   <li>When {@code Mvel&&}.
   *   <li>Then return {@code Mvel&&}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#stripWhiteSpace(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String GroupingTranslator.stripWhiteSpace(String)"})
  public void testStripWhiteSpace_givenGroupingTranslator_whenMvel_thenReturnMvel6() {
    // Arrange, Act and Assert
    assertEquals("Mvel&&", groupingTranslator.stripWhiteSpace("\tMvel&&"));
  }

  /**
   * Test {@link GroupingTranslator#stripWhiteSpace(String)}.
   *
   * <ul>
   *   <li>Given {@link GroupingTranslator}.
   *   <li>When {@code Mvel(}.
   *   <li>Then return {@code Mvel(}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#stripWhiteSpace(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String GroupingTranslator.stripWhiteSpace(String)"})
  public void testStripWhiteSpace_givenGroupingTranslator_whenMvel_thenReturnMvel7() {
    // Arrange, Act and Assert
    assertEquals("Mvel(", groupingTranslator.stripWhiteSpace("\tMvel("));
  }

  /**
   * Test {@link GroupingTranslator#stripWhiteSpace(String)}.
   *
   * <ul>
   *   <li>Given {@link GroupingTranslator}.
   *   <li>When {@code Mvel)}.
   *   <li>Then return {@code Mvel)}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#stripWhiteSpace(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String GroupingTranslator.stripWhiteSpace(String)"})
  public void testStripWhiteSpace_givenGroupingTranslator_whenMvel_thenReturnMvel8() {
    // Arrange, Act and Assert
    assertEquals("Mvel)", groupingTranslator.stripWhiteSpace("\tMvel)"));
  }

  /**
   * Test {@link GroupingTranslator#stripWhiteSpace(String)}.
   *
   * <ul>
   *   <li>Given {@link GroupingTranslator}.
   *   <li>When {@code Mvel;}.
   *   <li>Then return {@code Mvel;}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#stripWhiteSpace(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String GroupingTranslator.stripWhiteSpace(String)"})
  public void testStripWhiteSpace_givenGroupingTranslator_whenMvel_thenReturnMvel9() {
    // Arrange, Act and Assert
    assertEquals("Mvel;", groupingTranslator.stripWhiteSpace("\tMvel;"));
  }

  /**
   * Test {@link GroupingTranslator#stripWhiteSpace(String)}.
   *
   * <ul>
   *   <li>Given {@link GroupingTranslator}.
   *   <li>When {@code Mvel\|\|}.
   *   <li>Then return {@code Mvel\|\|}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#stripWhiteSpace(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String GroupingTranslator.stripWhiteSpace(String)"})
  public void testStripWhiteSpace_givenGroupingTranslator_whenMvel_thenReturnMvel10() {
    // Arrange, Act and Assert
    assertEquals("Mvel\\|\\|", groupingTranslator.stripWhiteSpace("\tMvel\\|\\|"));
  }

  /**
   * Test {@link GroupingTranslator#stripWhiteSpace(String)}.
   *
   * <ul>
   *   <li>Given {@link GroupingTranslator}.
   *   <li>When {@code Mvel||}.
   *   <li>Then return {@code Mvel||}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#stripWhiteSpace(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String GroupingTranslator.stripWhiteSpace(String)"})
  public void testStripWhiteSpace_givenGroupingTranslator_whenMvel_thenReturnMvel11() {
    // Arrange, Act and Assert
    assertEquals("Mvel||", groupingTranslator.stripWhiteSpace("\tMvel||"));
  }

  /**
   * Test {@link GroupingTranslator#stripWhiteSpace(String)}.
   *
   * <ul>
   *   <li>Given {@link GroupingTranslator}.
   *   <li>When {@code &&Mvel}.
   *   <li>Then return {@code &&Mvel}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#stripWhiteSpace(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String GroupingTranslator.stripWhiteSpace(String)"})
  public void testStripWhiteSpace_givenGroupingTranslator_whenMvel_thenReturnMvel12() {
    // Arrange, Act and Assert
    assertEquals("&&Mvel", groupingTranslator.stripWhiteSpace("\t&&Mvel"));
  }

  /**
   * Test {@link GroupingTranslator#stripWhiteSpace(String)}.
   *
   * <ul>
   *   <li>Given {@link GroupingTranslator}.
   *   <li>When {@code (Mvel}.
   *   <li>Then return {@code (Mvel}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#stripWhiteSpace(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String GroupingTranslator.stripWhiteSpace(String)"})
  public void testStripWhiteSpace_givenGroupingTranslator_whenMvel_thenReturnMvel13() {
    // Arrange, Act and Assert
    assertEquals("(Mvel", groupingTranslator.stripWhiteSpace("\t(Mvel"));
  }

  /**
   * Test {@link GroupingTranslator#stripWhiteSpace(String)}.
   *
   * <ul>
   *   <li>Given {@link GroupingTranslator} (default constructor).
   *   <li>When {@code )Mvel}.
   *   <li>Then return {@code )Mvel}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#stripWhiteSpace(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String GroupingTranslator.stripWhiteSpace(String)"})
  public void testStripWhiteSpace_givenGroupingTranslator_whenMvel_thenReturnMvel14() {
    // Arrange, Act and Assert
    assertEquals(")Mvel", new GroupingTranslator().stripWhiteSpace("\t)Mvel"));
  }

  /**
   * Test {@link GroupingTranslator#stripWhiteSpace(String)}.
   *
   * <ul>
   *   <li>Given {@link GroupingTranslator} (default constructor).
   *   <li>When {@code ;Mvel}.
   *   <li>Then return {@code ;Mvel}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#stripWhiteSpace(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String GroupingTranslator.stripWhiteSpace(String)"})
  public void testStripWhiteSpace_givenGroupingTranslator_whenMvel_thenReturnMvel15() {
    // Arrange, Act and Assert
    assertEquals(";Mvel", new GroupingTranslator().stripWhiteSpace("\t;Mvel"));
  }

  /**
   * Test {@link GroupingTranslator#stripWhiteSpace(String)}.
   *
   * <ul>
   *   <li>Given {@link GroupingTranslator} (default constructor).
   *   <li>When {@code \|\|Mvel}.
   *   <li>Then return {@code \|\|Mvel}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#stripWhiteSpace(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String GroupingTranslator.stripWhiteSpace(String)"})
  public void testStripWhiteSpace_givenGroupingTranslator_whenMvel_thenReturnMvel16() {
    // Arrange, Act and Assert
    assertEquals("\\|\\|Mvel", new GroupingTranslator().stripWhiteSpace("\t\\|\\|Mvel"));
  }

  /**
   * Test {@link GroupingTranslator#stripWhiteSpace(String)}.
   *
   * <ul>
   *   <li>Given {@link GroupingTranslator} (default constructor).
   *   <li>When {@code ||Mvel}.
   *   <li>Then return {@code ||Mvel}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#stripWhiteSpace(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String GroupingTranslator.stripWhiteSpace(String)"})
  public void testStripWhiteSpace_givenGroupingTranslator_whenMvel_thenReturnMvel17() {
    // Arrange, Act and Assert
    assertEquals("||Mvel", new GroupingTranslator().stripWhiteSpace("\t||Mvel"));
  }

  /**
   * Test {@link GroupingTranslator#stripWhiteSpace(String)}.
   *
   * <ul>
   *   <li>Given {@link GroupingTranslator}.
   *   <li>When {@code [\t\n\r]42}.
   *   <li>Then return {@code [\t\n\r]42}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#stripWhiteSpace(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String GroupingTranslator.stripWhiteSpace(String)"})
  public void testStripWhiteSpace_givenGroupingTranslator_whenTNR42_thenReturnTNR42() {
    // Arrange, Act and Assert
    assertEquals("[\\t\\n\\r]42", groupingTranslator.stripWhiteSpace("\t[\\t\\n\\r]42"));
  }

  /**
   * Test {@link GroupingTranslator#stripWhiteSpace(String)}.
   *
   * <ul>
   *   <li>Given {@link GroupingTranslator} (default constructor).
   *   <li>When {@code [\t\n\r] 42}.
   *   <li>Then return {@code [\t\n\r]42}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#stripWhiteSpace(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String GroupingTranslator.stripWhiteSpace(String)"})
  public void testStripWhiteSpace_givenGroupingTranslator_whenTNR42_thenReturnTNR422() {
    // Arrange, Act and Assert
    assertEquals("[\\t\\n\\r]42", new GroupingTranslator().stripWhiteSpace("[\\t\\n\\r]\t42"));
  }

  /**
   * Test {@link GroupingTranslator#stripWhiteSpace(String)}.
   *
   * <ul>
   *   <li>Given {@link GroupingTranslator} (default constructor).
   *   <li>When {@code [\t\n\r]42}.
   *   <li>Then return {@code [\t\n\r]42}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#stripWhiteSpace(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String GroupingTranslator.stripWhiteSpace(String)"})
  public void testStripWhiteSpace_givenGroupingTranslator_whenTNR42_thenReturnTNR423() {
    // Arrange, Act and Assert
    assertEquals("[\\t\\n\\r]42", new GroupingTranslator().stripWhiteSpace("[\\t\\n\\r]42\t"));
  }

  /**
   * Test {@link GroupingTranslator#stripWhiteSpace(String)}.
   *
   * <ul>
   *   <li>Given {@link GroupingTranslator}.
   *   <li>When {@code [\t\n\r]Mvel}.
   *   <li>Then return {@code [\t\n\r]Mvel}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#stripWhiteSpace(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String GroupingTranslator.stripWhiteSpace(String)"})
  public void testStripWhiteSpace_givenGroupingTranslator_whenTNRMvel_thenReturnTNRMvel() {
    // Arrange, Act and Assert
    assertEquals("[\\t\\n\\r]Mvel", groupingTranslator.stripWhiteSpace("\t[\\t\\n\\r]Mvel"));
  }

  /**
   * Test {@link GroupingTranslator#stripWhiteSpace(String)}.
   *
   * <ul>
   *   <li>Given {@link GroupingTranslator} (default constructor).
   *   <li>When {@code [\t\n\r] Mvel}.
   *   <li>Then return {@code [\t\n\r]Mvel}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#stripWhiteSpace(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String GroupingTranslator.stripWhiteSpace(String)"})
  public void testStripWhiteSpace_givenGroupingTranslator_whenTNRMvel_thenReturnTNRMvel2() {
    // Arrange, Act and Assert
    assertEquals("[\\t\\n\\r]Mvel", new GroupingTranslator().stripWhiteSpace("[\\t\\n\\r]\tMvel"));
  }

  /**
   * Test {@link GroupingTranslator#stripWhiteSpace(String)}.
   *
   * <ul>
   *   <li>Given {@link GroupingTranslator} (default constructor).
   *   <li>When {@code [\t\n\r]Mvel}.
   *   <li>Then return {@code [\t\n\r]Mvel}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#stripWhiteSpace(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String GroupingTranslator.stripWhiteSpace(String)"})
  public void testStripWhiteSpace_givenGroupingTranslator_whenTNRMvel_thenReturnTNRMvel3() {
    // Arrange, Act and Assert
    assertEquals("[\\t\\n\\r]Mvel", new GroupingTranslator().stripWhiteSpace("[\\t\\n\\r]Mvel\t"));
  }

  /**
   * Test {@link GroupingTranslator#stripWhiteSpace(String)}.
   *
   * <ul>
   *   <li>Given {@link GroupingTranslator}.
   *   <li>When {@code [\t\n\r][\t\n\r]}.
   *   <li>Then return {@code [\t\n\r][\t\n\r]}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#stripWhiteSpace(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String GroupingTranslator.stripWhiteSpace(String)"})
  public void testStripWhiteSpace_givenGroupingTranslator_whenTNRTNR_thenReturnTNRTNR() {
    // Arrange, Act and Assert
    assertEquals(
        "[\\t\\n\\r][\\t\\n\\r]", groupingTranslator.stripWhiteSpace("\t[\\t\\n\\r][\\t\\n\\r]"));
  }

  /**
   * Test {@link GroupingTranslator#stripWhiteSpace(String)}.
   *
   * <ul>
   *   <li>Given {@link GroupingTranslator} (default constructor).
   *   <li>When {@code [\t\n\r] [\t\n\r]}.
   *   <li>Then return {@code [\t\n\r][\t\n\r]}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#stripWhiteSpace(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String GroupingTranslator.stripWhiteSpace(String)"})
  public void testStripWhiteSpace_givenGroupingTranslator_whenTNRTNR_thenReturnTNRTNR2() {
    // Arrange, Act and Assert
    assertEquals(
        "[\\t\\n\\r][\\t\\n\\r]",
        new GroupingTranslator().stripWhiteSpace("[\\t\\n\\r]\t[\\t\\n\\r]"));
  }

  /**
   * Test {@link GroupingTranslator#stripWhiteSpace(String)}.
   *
   * <ul>
   *   <li>Given {@link GroupingTranslator} (default constructor).
   *   <li>When {@code [\t\n\r][\t\n\r]}.
   *   <li>Then return {@code [\t\n\r][\t\n\r]}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#stripWhiteSpace(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String GroupingTranslator.stripWhiteSpace(String)"})
  public void testStripWhiteSpace_givenGroupingTranslator_whenTNRTNR_thenReturnTNRTNR3() {
    // Arrange, Act and Assert
    assertEquals(
        "[\\t\\n\\r][\\t\\n\\r]",
        new GroupingTranslator().stripWhiteSpace("[\\t\\n\\r][\\t\\n\\r]\t"));
  }

  /**
   * Test {@link GroupingTranslator#stripWhiteSpace(String)}.
   *
   * <ul>
   *   <li>Given {@link GroupingTranslator}.
   *   <li>When {@code [\t\n\r]}.
   *   <li>Then return {@code [\t\n\r]}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#stripWhiteSpace(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String GroupingTranslator.stripWhiteSpace(String)"})
  public void testStripWhiteSpace_givenGroupingTranslator_whenTNR_thenReturnTNR() {
    // Arrange, Act and Assert
    assertEquals("[\\t\\n\\r]", groupingTranslator.stripWhiteSpace("\t[\\t\\n\\r]"));
  }

  /**
   * Test {@link GroupingTranslator#stripWhiteSpace(String)}.
   *
   * <ul>
   *   <li>Given {@link GroupingTranslator}.
   *   <li>When {@code [\t\n\r]}.
   *   <li>Then return {@code [\t\n\r]}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#stripWhiteSpace(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String GroupingTranslator.stripWhiteSpace(String)"})
  public void testStripWhiteSpace_givenGroupingTranslator_whenTNR_thenReturnTNR2() {
    // Arrange, Act and Assert
    assertEquals("[\\t\\n\\r]", groupingTranslator.stripWhiteSpace("[\\t\\n\\r]\t"));
  }

  /**
   * Test {@link GroupingTranslator#stripWhiteSpace(String)}.
   *
   * <ul>
   *   <li>Given {@link GroupingTranslator}.
   *   <li>When {@code [\t\n\r]}.
   *   <li>Then return {@code [\t\n\r]}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#stripWhiteSpace(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String GroupingTranslator.stripWhiteSpace(String)"})
  public void testStripWhiteSpace_givenGroupingTranslator_whenTNR_thenReturnTNR3() {
    // Arrange, Act and Assert
    assertEquals("[\\t\\n\\r]", groupingTranslator.stripWhiteSpace("\t\t[\\t\\n\\r]"));
  }

  /**
   * Test {@link GroupingTranslator#stripWhiteSpace(String)}.
   *
   * <ul>
   *   <li>Given {@link GroupingTranslator}.
   *   <li>When {@code [\t\n\r]}.
   *   <li>Then return {@code [\t\n\r]}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#stripWhiteSpace(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String GroupingTranslator.stripWhiteSpace(String)"})
  public void testStripWhiteSpace_givenGroupingTranslator_whenTNR_thenReturnTNR4() {
    // Arrange, Act and Assert
    assertEquals("[\\t\\n\\r]", groupingTranslator.stripWhiteSpace("\t[\\t\\n\\r]\t"));
  }

  /**
   * Test {@link GroupingTranslator#stripWhiteSpace(String)}.
   *
   * <ul>
   *   <li>Given {@link GroupingTranslator}.
   *   <li>When {@code [\t\n\r]&&}.
   *   <li>Then return {@code [\t\n\r]&&}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#stripWhiteSpace(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String GroupingTranslator.stripWhiteSpace(String)"})
  public void testStripWhiteSpace_givenGroupingTranslator_whenTNR_thenReturnTNR5() {
    // Arrange, Act and Assert
    assertEquals("[\\t\\n\\r]&&", groupingTranslator.stripWhiteSpace("\t[\\t\\n\\r]&&"));
  }

  /**
   * Test {@link GroupingTranslator#stripWhiteSpace(String)}.
   *
   * <ul>
   *   <li>Given {@link GroupingTranslator}.
   *   <li>When {@code [\t\n\r](}.
   *   <li>Then return {@code [\t\n\r](}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#stripWhiteSpace(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String GroupingTranslator.stripWhiteSpace(String)"})
  public void testStripWhiteSpace_givenGroupingTranslator_whenTNR_thenReturnTNR6() {
    // Arrange, Act and Assert
    assertEquals("[\\t\\n\\r](", groupingTranslator.stripWhiteSpace("\t[\\t\\n\\r]("));
  }

  /**
   * Test {@link GroupingTranslator#stripWhiteSpace(String)}.
   *
   * <ul>
   *   <li>Given {@link GroupingTranslator}.
   *   <li>When {@code [\t\n\r])}.
   *   <li>Then return {@code [\t\n\r])}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#stripWhiteSpace(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String GroupingTranslator.stripWhiteSpace(String)"})
  public void testStripWhiteSpace_givenGroupingTranslator_whenTNR_thenReturnTNR7() {
    // Arrange, Act and Assert
    assertEquals("[\\t\\n\\r])", groupingTranslator.stripWhiteSpace("\t[\\t\\n\\r])"));
  }

  /**
   * Test {@link GroupingTranslator#stripWhiteSpace(String)}.
   *
   * <ul>
   *   <li>Given {@link GroupingTranslator}.
   *   <li>When {@code [\t\n\r];}.
   *   <li>Then return {@code [\t\n\r];}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#stripWhiteSpace(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String GroupingTranslator.stripWhiteSpace(String)"})
  public void testStripWhiteSpace_givenGroupingTranslator_whenTNR_thenReturnTNR8() {
    // Arrange, Act and Assert
    assertEquals("[\\t\\n\\r];", groupingTranslator.stripWhiteSpace("\t[\\t\\n\\r];"));
  }

  /**
   * Test {@link GroupingTranslator#stripWhiteSpace(String)}.
   *
   * <ul>
   *   <li>Given {@link GroupingTranslator}.
   *   <li>When {@code [\t\n\r]\|\|}.
   *   <li>Then return {@code [\t\n\r]\|\|}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#stripWhiteSpace(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String GroupingTranslator.stripWhiteSpace(String)"})
  public void testStripWhiteSpace_givenGroupingTranslator_whenTNR_thenReturnTNR9() {
    // Arrange, Act and Assert
    assertEquals("[\\t\\n\\r]\\|\\|", groupingTranslator.stripWhiteSpace("\t[\\t\\n\\r]\\|\\|"));
  }

  /**
   * Test {@link GroupingTranslator#stripWhiteSpace(String)}.
   *
   * <ul>
   *   <li>Given {@link GroupingTranslator}.
   *   <li>When {@code [\t\n\r]||}.
   *   <li>Then return {@code [\t\n\r]||}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#stripWhiteSpace(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String GroupingTranslator.stripWhiteSpace(String)"})
  public void testStripWhiteSpace_givenGroupingTranslator_whenTNR_thenReturnTNR10() {
    // Arrange, Act and Assert
    assertEquals("[\\t\\n\\r]||", groupingTranslator.stripWhiteSpace("\t[\\t\\n\\r]||"));
  }

  /**
   * Test {@link GroupingTranslator#stripWhiteSpace(String)}.
   *
   * <ul>
   *   <li>Given {@link GroupingTranslator}.
   *   <li>When {@code &&[\t\n\r]}.
   *   <li>Then return {@code &&[\t\n\r]}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#stripWhiteSpace(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String GroupingTranslator.stripWhiteSpace(String)"})
  public void testStripWhiteSpace_givenGroupingTranslator_whenTNR_thenReturnTNR11() {
    // Arrange, Act and Assert
    assertEquals("&&[\\t\\n\\r]", groupingTranslator.stripWhiteSpace("\t&&[\\t\\n\\r]"));
  }

  /**
   * Test {@link GroupingTranslator#stripWhiteSpace(String)}.
   *
   * <ul>
   *   <li>Given {@link GroupingTranslator}.
   *   <li>When {@code ([\t\n\r]}.
   *   <li>Then return {@code ([\t\n\r]}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#stripWhiteSpace(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String GroupingTranslator.stripWhiteSpace(String)"})
  public void testStripWhiteSpace_givenGroupingTranslator_whenTNR_thenReturnTNR12() {
    // Arrange, Act and Assert
    assertEquals("([\\t\\n\\r]", groupingTranslator.stripWhiteSpace("\t([\\t\\n\\r]"));
  }

  /**
   * Test {@link GroupingTranslator#stripWhiteSpace(String)}.
   *
   * <ul>
   *   <li>Given {@link GroupingTranslator} (default constructor).
   *   <li>When {@code )[\t\n\r]}.
   *   <li>Then return {@code )[\t\n\r]}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#stripWhiteSpace(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String GroupingTranslator.stripWhiteSpace(String)"})
  public void testStripWhiteSpace_givenGroupingTranslator_whenTNR_thenReturnTNR13() {
    // Arrange, Act and Assert
    assertEquals(")[\\t\\n\\r]", new GroupingTranslator().stripWhiteSpace("\t)[\\t\\n\\r]"));
  }

  /**
   * Test {@link GroupingTranslator#stripWhiteSpace(String)}.
   *
   * <ul>
   *   <li>Given {@link GroupingTranslator} (default constructor).
   *   <li>When {@code ;[\t\n\r]}.
   *   <li>Then return {@code ;[\t\n\r]}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#stripWhiteSpace(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String GroupingTranslator.stripWhiteSpace(String)"})
  public void testStripWhiteSpace_givenGroupingTranslator_whenTNR_thenReturnTNR14() {
    // Arrange, Act and Assert
    assertEquals(";[\\t\\n\\r]", new GroupingTranslator().stripWhiteSpace("\t;[\\t\\n\\r]"));
  }

  /**
   * Test {@link GroupingTranslator#stripWhiteSpace(String)}.
   *
   * <ul>
   *   <li>Given {@link GroupingTranslator} (default constructor).
   *   <li>When {@code \|\|[\t\n\r]}.
   *   <li>Then return {@code \|\|[\t\n\r]}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#stripWhiteSpace(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String GroupingTranslator.stripWhiteSpace(String)"})
  public void testStripWhiteSpace_givenGroupingTranslator_whenTNR_thenReturnTNR15() {
    // Arrange, Act and Assert
    assertEquals(
        "\\|\\|[\\t\\n\\r]", new GroupingTranslator().stripWhiteSpace("\t\\|\\|[\\t\\n\\r]"));
  }

  /**
   * Test {@link GroupingTranslator#stripWhiteSpace(String)}.
   *
   * <ul>
   *   <li>Given {@link GroupingTranslator} (default constructor).
   *   <li>When {@code ||[\t\n\r]}.
   *   <li>Then return {@code ||[\t\n\r]}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#stripWhiteSpace(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String GroupingTranslator.stripWhiteSpace(String)"})
  public void testStripWhiteSpace_givenGroupingTranslator_whenTNR_thenReturnTNR16() {
    // Arrange, Act and Assert
    assertEquals("||[\\t\\n\\r]", new GroupingTranslator().stripWhiteSpace("\t||[\\t\\n\\r]"));
  }

  /**
   * Test {@link GroupingTranslator#stripWhiteSpace(String)}.
   *
   * <ul>
   *   <li>Given {@link GroupingTranslator} (default constructor).
   *   <li>When {@code [\t\n\r]}.
   *   <li>Then return {@code [\t\n\r]}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#stripWhiteSpace(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String GroupingTranslator.stripWhiteSpace(String)"})
  public void testStripWhiteSpace_givenGroupingTranslator_whenTNR_thenReturnTNR17() {
    // Arrange, Act and Assert
    assertEquals("[\\t\\n\\r]", new GroupingTranslator().stripWhiteSpace("[\\t\\n\\r]\t\t"));
  }

  /**
   * Test {@link GroupingTranslator#stripWhiteSpace(String)}.
   *
   * <ul>
   *   <li>Given {@link GroupingTranslator} (default constructor).
   *   <li>When {@code [\t\n\r] &&}.
   *   <li>Then return {@code [\t\n\r]&&}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#stripWhiteSpace(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String GroupingTranslator.stripWhiteSpace(String)"})
  public void testStripWhiteSpace_givenGroupingTranslator_whenTNR_thenReturnTNR18() {
    // Arrange, Act and Assert
    assertEquals("[\\t\\n\\r]&&", new GroupingTranslator().stripWhiteSpace("[\\t\\n\\r]\t&&"));
  }

  /**
   * Test {@link GroupingTranslator#stripWhiteSpace(String)}.
   *
   * <ul>
   *   <li>Given {@link GroupingTranslator} (default constructor).
   *   <li>When {@code [\t\n\r] (}.
   *   <li>Then return {@code [\t\n\r](}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#stripWhiteSpace(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String GroupingTranslator.stripWhiteSpace(String)"})
  public void testStripWhiteSpace_givenGroupingTranslator_whenTNR_thenReturnTNR19() {
    // Arrange, Act and Assert
    assertEquals("[\\t\\n\\r](", new GroupingTranslator().stripWhiteSpace("[\\t\\n\\r]\t("));
  }

  /**
   * Test {@link GroupingTranslator#stripWhiteSpace(String)}.
   *
   * <ul>
   *   <li>Given {@link GroupingTranslator} (default constructor).
   *   <li>When {@code [\t\n\r] )}.
   *   <li>Then return {@code [\t\n\r])}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#stripWhiteSpace(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String GroupingTranslator.stripWhiteSpace(String)"})
  public void testStripWhiteSpace_givenGroupingTranslator_whenTNR_thenReturnTNR20() {
    // Arrange, Act and Assert
    assertEquals("[\\t\\n\\r])", new GroupingTranslator().stripWhiteSpace("[\\t\\n\\r]\t)"));
  }

  /**
   * Test {@link GroupingTranslator#stripWhiteSpace(String)}.
   *
   * <ul>
   *   <li>Given {@link GroupingTranslator} (default constructor).
   *   <li>When {@code [\t\n\r] ;}.
   *   <li>Then return {@code [\t\n\r];}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#stripWhiteSpace(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String GroupingTranslator.stripWhiteSpace(String)"})
  public void testStripWhiteSpace_givenGroupingTranslator_whenTNR_thenReturnTNR21() {
    // Arrange, Act and Assert
    assertEquals("[\\t\\n\\r];", new GroupingTranslator().stripWhiteSpace("[\\t\\n\\r]\t;"));
  }

  /**
   * Test {@link GroupingTranslator#stripWhiteSpace(String)}.
   *
   * <ul>
   *   <li>Given {@link GroupingTranslator} (default constructor).
   *   <li>When {@code [\t\n\r] \|\|}.
   *   <li>Then return {@code [\t\n\r]\|\|}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#stripWhiteSpace(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String GroupingTranslator.stripWhiteSpace(String)"})
  public void testStripWhiteSpace_givenGroupingTranslator_whenTNR_thenReturnTNR22() {
    // Arrange, Act and Assert
    assertEquals(
        "[\\t\\n\\r]\\|\\|", new GroupingTranslator().stripWhiteSpace("[\\t\\n\\r]\t\\|\\|"));
  }

  /**
   * Test {@link GroupingTranslator#stripWhiteSpace(String)}.
   *
   * <ul>
   *   <li>Given {@link GroupingTranslator} (default constructor).
   *   <li>When {@code [\t\n\r] ||}.
   *   <li>Then return {@code [\t\n\r]||}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#stripWhiteSpace(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String GroupingTranslator.stripWhiteSpace(String)"})
  public void testStripWhiteSpace_givenGroupingTranslator_whenTNR_thenReturnTNR23() {
    // Arrange, Act and Assert
    assertEquals("[\\t\\n\\r]||", new GroupingTranslator().stripWhiteSpace("[\\t\\n\\r]\t||"));
  }

  /**
   * Test {@link GroupingTranslator#stripWhiteSpace(String)}.
   *
   * <ul>
   *   <li>Given {@link GroupingTranslator} (default constructor).
   *   <li>When {@code [\t\n\r]&&}.
   *   <li>Then return {@code [\t\n\r]&&}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#stripWhiteSpace(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String GroupingTranslator.stripWhiteSpace(String)"})
  public void testStripWhiteSpace_givenGroupingTranslator_whenTNR_thenReturnTNR24() {
    // Arrange, Act and Assert
    assertEquals("[\\t\\n\\r]&&", new GroupingTranslator().stripWhiteSpace("[\\t\\n\\r]&&\t"));
  }

  /**
   * Test {@link GroupingTranslator#stripWhiteSpace(String)}.
   *
   * <ul>
   *   <li>Given {@link GroupingTranslator} (default constructor).
   *   <li>When {@code [\t\n\r](}.
   *   <li>Then return {@code [\t\n\r](}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#stripWhiteSpace(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String GroupingTranslator.stripWhiteSpace(String)"})
  public void testStripWhiteSpace_givenGroupingTranslator_whenTNR_thenReturnTNR25() {
    // Arrange, Act and Assert
    assertEquals("[\\t\\n\\r](", new GroupingTranslator().stripWhiteSpace("[\\t\\n\\r](\t"));
  }

  /**
   * Test {@link GroupingTranslator#stripWhiteSpace(String)}.
   *
   * <ul>
   *   <li>Given {@link GroupingTranslator} (default constructor).
   *   <li>When {@code [\t\n\r])}.
   *   <li>Then return {@code [\t\n\r])}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#stripWhiteSpace(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String GroupingTranslator.stripWhiteSpace(String)"})
  public void testStripWhiteSpace_givenGroupingTranslator_whenTNR_thenReturnTNR26() {
    // Arrange, Act and Assert
    assertEquals("[\\t\\n\\r])", new GroupingTranslator().stripWhiteSpace("[\\t\\n\\r])\t"));
  }

  /**
   * Test {@link GroupingTranslator#stripWhiteSpace(String)}.
   *
   * <ul>
   *   <li>Given {@link GroupingTranslator} (default constructor).
   *   <li>When {@code [\t\n\r];}.
   *   <li>Then return {@code [\t\n\r];}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#stripWhiteSpace(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String GroupingTranslator.stripWhiteSpace(String)"})
  public void testStripWhiteSpace_givenGroupingTranslator_whenTNR_thenReturnTNR27() {
    // Arrange, Act and Assert
    assertEquals("[\\t\\n\\r];", new GroupingTranslator().stripWhiteSpace("[\\t\\n\\r];\t"));
  }

  /**
   * Test {@link GroupingTranslator#stripWhiteSpace(String)}.
   *
   * <ul>
   *   <li>Given {@link GroupingTranslator} (default constructor).
   *   <li>When {@code [\t\n\r]\|\|}.
   *   <li>Then return {@code [\t\n\r]\|\|}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#stripWhiteSpace(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String GroupingTranslator.stripWhiteSpace(String)"})
  public void testStripWhiteSpace_givenGroupingTranslator_whenTNR_thenReturnTNR28() {
    // Arrange, Act and Assert
    assertEquals(
        "[\\t\\n\\r]\\|\\|", new GroupingTranslator().stripWhiteSpace("[\\t\\n\\r]\\|\\|\t"));
  }

  /**
   * Test {@link GroupingTranslator#stripWhiteSpace(String)}.
   *
   * <ul>
   *   <li>Given {@link GroupingTranslator} (default constructor).
   *   <li>When {@code [\t\n\r]||}.
   *   <li>Then return {@code [\t\n\r]||}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#stripWhiteSpace(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String GroupingTranslator.stripWhiteSpace(String)"})
  public void testStripWhiteSpace_givenGroupingTranslator_whenTNR_thenReturnTNR29() {
    // Arrange, Act and Assert
    assertEquals("[\\t\\n\\r]||", new GroupingTranslator().stripWhiteSpace("[\\t\\n\\r]||\t"));
  }

  /**
   * Test {@link GroupingTranslator#stripWhiteSpace(String)}.
   *
   * <ul>
   *   <li>Given {@link GroupingTranslator}.
   *   <li>When tab tab tab.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#stripWhiteSpace(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String GroupingTranslator.stripWhiteSpace(String)"})
  public void testStripWhiteSpace_givenGroupingTranslator_whenTabTabTab_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", groupingTranslator.stripWhiteSpace("\t\t\t"));
  }

  /**
   * Test {@link GroupingTranslator#stripWhiteSpace(String)}.
   *
   * <ul>
   *   <li>Given {@link GroupingTranslator}.
   *   <li>When tab tab.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#stripWhiteSpace(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String GroupingTranslator.stripWhiteSpace(String)"})
  public void testStripWhiteSpace_givenGroupingTranslator_whenTabTab_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", groupingTranslator.stripWhiteSpace("\t\t"));
  }

  /**
   * Test {@link GroupingTranslator#stripWhiteSpace(String)}.
   *
   * <ul>
   *   <li>Given {@link GroupingTranslator}.
   *   <li>When tab.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#stripWhiteSpace(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String GroupingTranslator.stripWhiteSpace(String)"})
  public void testStripWhiteSpace_givenGroupingTranslator_whenTab_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", groupingTranslator.stripWhiteSpace("\t"));
  }

  /**
   * Test {@link GroupingTranslator#stripWhiteSpace(String)}.
   *
   * <ul>
   *   <li>Then return {@code &&&&}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#stripWhiteSpace(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String GroupingTranslator.stripWhiteSpace(String)"})
  public void testStripWhiteSpace_thenReturnAmpersandAmpersandAmpersandAmpersand() {
    // Arrange, Act and Assert
    assertEquals("&&&&", groupingTranslator.stripWhiteSpace("\t&&&&"));
  }

  /**
   * Test {@link GroupingTranslator#stripWhiteSpace(String)}.
   *
   * <ul>
   *   <li>Then return {@code &&(}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#stripWhiteSpace(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String GroupingTranslator.stripWhiteSpace(String)"})
  public void testStripWhiteSpace_thenReturnAmpersandAmpersandLeftParenthesis() {
    // Arrange, Act and Assert
    assertEquals("&&(", groupingTranslator.stripWhiteSpace("\t&&("));
  }

  /**
   * Test {@link GroupingTranslator#stripWhiteSpace(String)}.
   *
   * <ul>
   *   <li>Then return {@code &&)}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#stripWhiteSpace(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String GroupingTranslator.stripWhiteSpace(String)"})
  public void testStripWhiteSpace_thenReturnAmpersandAmpersandRightParenthesis() {
    // Arrange, Act and Assert
    assertEquals("&&)", groupingTranslator.stripWhiteSpace("\t&&)"));
  }

  /**
   * Test {@link GroupingTranslator#stripWhiteSpace(String)}.
   *
   * <ul>
   *   <li>Then return {@code &&;}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#stripWhiteSpace(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String GroupingTranslator.stripWhiteSpace(String)"})
  public void testStripWhiteSpace_thenReturnAmpersandAmpersandSemicolon() {
    // Arrange, Act and Assert
    assertEquals("&&;", groupingTranslator.stripWhiteSpace("\t&&;"));
  }

  /**
   * Test {@link GroupingTranslator#stripWhiteSpace(String)}.
   *
   * <ul>
   *   <li>Then return {@code &&||}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#stripWhiteSpace(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String GroupingTranslator.stripWhiteSpace(String)"})
  public void testStripWhiteSpace_thenReturnAmpersandAmpersandVerticalLineVerticalLine() {
    // Arrange, Act and Assert
    assertEquals("&&||", groupingTranslator.stripWhiteSpace("\t&&||"));
  }

  /**
   * Test {@link GroupingTranslator#stripWhiteSpace(String)}.
   *
   * <ul>
   *   <li>Then return {@code \|\|}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#stripWhiteSpace(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String GroupingTranslator.stripWhiteSpace(String)"})
  public void testStripWhiteSpace_thenReturnBackslashVerticalLineBackslashVerticalLine() {
    // Arrange, Act and Assert
    assertEquals("\\|\\|", groupingTranslator.stripWhiteSpace("\t\\|\\|"));
  }

  /**
   * Test {@link GroupingTranslator#stripWhiteSpace(String)}.
   *
   * <ul>
   *   <li>Then return {@code \|\|}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#stripWhiteSpace(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String GroupingTranslator.stripWhiteSpace(String)"})
  public void testStripWhiteSpace_thenReturnBackslashVerticalLineBackslashVerticalLine2() {
    // Arrange, Act and Assert
    assertEquals("\\|\\|", groupingTranslator.stripWhiteSpace("\\|\\|\t"));
  }

  /**
   * Test {@link GroupingTranslator#stripWhiteSpace(String)}.
   *
   * <ul>
   *   <li>Then return {@code \|\|}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#stripWhiteSpace(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String GroupingTranslator.stripWhiteSpace(String)"})
  public void testStripWhiteSpace_thenReturnBackslashVerticalLineBackslashVerticalLine3() {
    // Arrange, Act and Assert
    assertEquals("\\|\\|", groupingTranslator.stripWhiteSpace("\t\t\\|\\|"));
  }

  /**
   * Test {@link GroupingTranslator#stripWhiteSpace(String)}.
   *
   * <ul>
   *   <li>Then return {@code \|\|}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#stripWhiteSpace(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String GroupingTranslator.stripWhiteSpace(String)"})
  public void testStripWhiteSpace_thenReturnBackslashVerticalLineBackslashVerticalLine4() {
    // Arrange, Act and Assert
    assertEquals("\\|\\|", new GroupingTranslator().stripWhiteSpace("\t\\|\\|\t"));
  }

  /**
   * Test {@link GroupingTranslator#stripWhiteSpace(String)}.
   *
   * <ul>
   *   <li>Then return {@code (&&}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#stripWhiteSpace(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String GroupingTranslator.stripWhiteSpace(String)"})
  public void testStripWhiteSpace_thenReturnLeftParenthesisAmpersandAmpersand() {
    // Arrange, Act and Assert
    assertEquals("(&&", groupingTranslator.stripWhiteSpace("\t(&&"));
  }

  /**
   * Test {@link GroupingTranslator#stripWhiteSpace(String)}.
   *
   * <ul>
   *   <li>Then return {@code ((}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#stripWhiteSpace(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String GroupingTranslator.stripWhiteSpace(String)"})
  public void testStripWhiteSpace_thenReturnLeftParenthesisLeftParenthesis() {
    // Arrange, Act and Assert
    assertEquals("((", groupingTranslator.stripWhiteSpace("\t(("));
  }

  /**
   * Test {@link GroupingTranslator#stripWhiteSpace(String)}.
   *
   * <ul>
   *   <li>Then return {@code ()}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#stripWhiteSpace(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String GroupingTranslator.stripWhiteSpace(String)"})
  public void testStripWhiteSpace_thenReturnLeftParenthesisRightParenthesis() {
    // Arrange, Act and Assert
    assertEquals("()", new GroupingTranslator().stripWhiteSpace("\t()"));
  }

  /**
   * Test {@link GroupingTranslator#stripWhiteSpace(String)}.
   *
   * <ul>
   *   <li>Then return {@code (;}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#stripWhiteSpace(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String GroupingTranslator.stripWhiteSpace(String)"})
  public void testStripWhiteSpace_thenReturnLeftParenthesisSemicolon() {
    // Arrange, Act and Assert
    assertEquals("(;", new GroupingTranslator().stripWhiteSpace("\t(;"));
  }

  /**
   * Test {@link GroupingTranslator#stripWhiteSpace(String)}.
   *
   * <ul>
   *   <li>Then return {@code (||}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#stripWhiteSpace(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String GroupingTranslator.stripWhiteSpace(String)"})
  public void testStripWhiteSpace_thenReturnLeftParenthesisVerticalLineVerticalLine() {
    // Arrange, Act and Assert
    assertEquals("(||", new GroupingTranslator().stripWhiteSpace("\t(||"));
  }

  /**
   * Test {@link GroupingTranslator#stripWhiteSpace(String)}.
   *
   * <ul>
   *   <li>Then return {@code )&&}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#stripWhiteSpace(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String GroupingTranslator.stripWhiteSpace(String)"})
  public void testStripWhiteSpace_thenReturnRightParenthesisAmpersandAmpersand() {
    // Arrange, Act and Assert
    assertEquals(")&&", new GroupingTranslator().stripWhiteSpace("\t)&&"));
  }

  /**
   * Test {@link GroupingTranslator#stripWhiteSpace(String)}.
   *
   * <ul>
   *   <li>Then return {@code )(}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#stripWhiteSpace(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String GroupingTranslator.stripWhiteSpace(String)"})
  public void testStripWhiteSpace_thenReturnRightParenthesisLeftParenthesis() {
    // Arrange, Act and Assert
    assertEquals(")(", new GroupingTranslator().stripWhiteSpace("\t)("));
  }

  /**
   * Test {@link GroupingTranslator#stripWhiteSpace(String)}.
   *
   * <ul>
   *   <li>Then return {@code ))}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#stripWhiteSpace(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String GroupingTranslator.stripWhiteSpace(String)"})
  public void testStripWhiteSpace_thenReturnRightParenthesisRightParenthesis() {
    // Arrange, Act and Assert
    assertEquals("))", new GroupingTranslator().stripWhiteSpace("\t))"));
  }

  /**
   * Test {@link GroupingTranslator#stripWhiteSpace(String)}.
   *
   * <ul>
   *   <li>Then return {@code );}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#stripWhiteSpace(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String GroupingTranslator.stripWhiteSpace(String)"})
  public void testStripWhiteSpace_thenReturnRightParenthesisSemicolon() {
    // Arrange, Act and Assert
    assertEquals(");", new GroupingTranslator().stripWhiteSpace("\t);"));
  }

  /**
   * Test {@link GroupingTranslator#stripWhiteSpace(String)}.
   *
   * <ul>
   *   <li>Then return {@code )||}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#stripWhiteSpace(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String GroupingTranslator.stripWhiteSpace(String)"})
  public void testStripWhiteSpace_thenReturnRightParenthesisVerticalLineVerticalLine() {
    // Arrange, Act and Assert
    assertEquals(")||", new GroupingTranslator().stripWhiteSpace("\t)||"));
  }

  /**
   * Test {@link GroupingTranslator#stripWhiteSpace(String)}.
   *
   * <ul>
   *   <li>Then return {@code ;&&}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#stripWhiteSpace(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String GroupingTranslator.stripWhiteSpace(String)"})
  public void testStripWhiteSpace_thenReturnSemicolonAmpersandAmpersand() {
    // Arrange, Act and Assert
    assertEquals(";&&", new GroupingTranslator().stripWhiteSpace("\t;&&"));
  }

  /**
   * Test {@link GroupingTranslator#stripWhiteSpace(String)}.
   *
   * <ul>
   *   <li>Then return {@code ;(}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#stripWhiteSpace(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String GroupingTranslator.stripWhiteSpace(String)"})
  public void testStripWhiteSpace_thenReturnSemicolonLeftParenthesis() {
    // Arrange, Act and Assert
    assertEquals(";(", new GroupingTranslator().stripWhiteSpace("\t;("));
  }

  /**
   * Test {@link GroupingTranslator#stripWhiteSpace(String)}.
   *
   * <ul>
   *   <li>Then return {@code ;)}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#stripWhiteSpace(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String GroupingTranslator.stripWhiteSpace(String)"})
  public void testStripWhiteSpace_thenReturnSemicolonRightParenthesis() {
    // Arrange, Act and Assert
    assertEquals(";)", new GroupingTranslator().stripWhiteSpace("\t;)"));
  }

  /**
   * Test {@link GroupingTranslator#stripWhiteSpace(String)}.
   *
   * <ul>
   *   <li>Then return {@code ;||}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#stripWhiteSpace(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String GroupingTranslator.stripWhiteSpace(String)"})
  public void testStripWhiteSpace_thenReturnSemicolonVerticalLineVerticalLine() {
    // Arrange, Act and Assert
    assertEquals(";||", new GroupingTranslator().stripWhiteSpace("\t;||"));
  }

  /**
   * Test {@link GroupingTranslator#stripWhiteSpace(String)}.
   *
   * <ul>
   *   <li>Then return {@code ||}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#stripWhiteSpace(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String GroupingTranslator.stripWhiteSpace(String)"})
  public void testStripWhiteSpace_thenReturnVerticalLineVerticalLine() {
    // Arrange, Act and Assert
    assertEquals("||", groupingTranslator.stripWhiteSpace("\t||"));
  }

  /**
   * Test {@link GroupingTranslator#stripWhiteSpace(String)}.
   *
   * <ul>
   *   <li>Then return {@code ||}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#stripWhiteSpace(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String GroupingTranslator.stripWhiteSpace(String)"})
  public void testStripWhiteSpace_thenReturnVerticalLineVerticalLine2() {
    // Arrange, Act and Assert
    assertEquals("||", groupingTranslator.stripWhiteSpace("||\t"));
  }

  /**
   * Test {@link GroupingTranslator#stripWhiteSpace(String)}.
   *
   * <ul>
   *   <li>Then return {@code ||}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#stripWhiteSpace(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String GroupingTranslator.stripWhiteSpace(String)"})
  public void testStripWhiteSpace_thenReturnVerticalLineVerticalLine3() {
    // Arrange, Act and Assert
    assertEquals("||", groupingTranslator.stripWhiteSpace("\t\t||"));
  }

  /**
   * Test {@link GroupingTranslator#stripWhiteSpace(String)}.
   *
   * <ul>
   *   <li>Then return {@code ||}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#stripWhiteSpace(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String GroupingTranslator.stripWhiteSpace(String)"})
  public void testStripWhiteSpace_thenReturnVerticalLineVerticalLine4() {
    // Arrange, Act and Assert
    assertEquals("||", new GroupingTranslator().stripWhiteSpace("\t||\t"));
  }

  /**
   * Test {@link GroupingTranslator#stripWhiteSpace(String)}.
   *
   * <ul>
   *   <li>Then return {@code ||&&}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#stripWhiteSpace(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String GroupingTranslator.stripWhiteSpace(String)"})
  public void testStripWhiteSpace_thenReturnVerticalLineVerticalLineAmpersandAmpersand() {
    // Arrange, Act and Assert
    assertEquals("||&&", new GroupingTranslator().stripWhiteSpace("\t||&&"));
  }

  /**
   * Test {@link GroupingTranslator#stripWhiteSpace(String)}.
   *
   * <ul>
   *   <li>Then return {@code ||(}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#stripWhiteSpace(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String GroupingTranslator.stripWhiteSpace(String)"})
  public void testStripWhiteSpace_thenReturnVerticalLineVerticalLineLeftParenthesis() {
    // Arrange, Act and Assert
    assertEquals("||(", new GroupingTranslator().stripWhiteSpace("\t||("));
  }

  /**
   * Test {@link GroupingTranslator#stripWhiteSpace(String)}.
   *
   * <ul>
   *   <li>Then return {@code ||)}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#stripWhiteSpace(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String GroupingTranslator.stripWhiteSpace(String)"})
  public void testStripWhiteSpace_thenReturnVerticalLineVerticalLineRightParenthesis() {
    // Arrange, Act and Assert
    assertEquals("||)", new GroupingTranslator().stripWhiteSpace("\t||)"));
  }

  /**
   * Test {@link GroupingTranslator#stripWhiteSpace(String)}.
   *
   * <ul>
   *   <li>Then return {@code ||;}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#stripWhiteSpace(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String GroupingTranslator.stripWhiteSpace(String)"})
  public void testStripWhiteSpace_thenReturnVerticalLineVerticalLineSemicolon() {
    // Arrange, Act and Assert
    assertEquals("||;", new GroupingTranslator().stripWhiteSpace("\t||;"));
  }

  /**
   * Test {@link GroupingTranslator#stripWhiteSpace(String)}.
   *
   * <ul>
   *   <li>Then return {@code ||||}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#stripWhiteSpace(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String GroupingTranslator.stripWhiteSpace(String)"})
  public void testStripWhiteSpace_thenReturnVerticalLineVerticalLineVerticalLineVerticalLine() {
    // Arrange, Act and Assert
    assertEquals("||||", new GroupingTranslator().stripWhiteSpace("\t||||"));
  }

  /**
   * Test {@link GroupingTranslator#stripWhiteSpace(String)}.
   *
   * <ul>
   *   <li>When {@code &&}.
   *   <li>Then return {@code &&}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#stripWhiteSpace(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String GroupingTranslator.stripWhiteSpace(String)"})
  public void testStripWhiteSpace_whenAmpersandAmpersand_thenReturnAmpersandAmpersand() {
    // Arrange, Act and Assert
    assertEquals("&&", groupingTranslator.stripWhiteSpace("\t&&"));
  }

  /**
   * Test {@link GroupingTranslator#stripWhiteSpace(String)}.
   *
   * <ul>
   *   <li>When {@code &&}.
   *   <li>Then return {@code &&}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#stripWhiteSpace(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String GroupingTranslator.stripWhiteSpace(String)"})
  public void testStripWhiteSpace_whenAmpersandAmpersand_thenReturnAmpersandAmpersand2() {
    // Arrange, Act and Assert
    assertEquals("&&", groupingTranslator.stripWhiteSpace("&&\t"));
  }

  /**
   * Test {@link GroupingTranslator#stripWhiteSpace(String)}.
   *
   * <ul>
   *   <li>When {@code &&}.
   *   <li>Then return {@code &&}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#stripWhiteSpace(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String GroupingTranslator.stripWhiteSpace(String)"})
  public void testStripWhiteSpace_whenAmpersandAmpersand_thenReturnAmpersandAmpersand3() {
    // Arrange, Act and Assert
    assertEquals("&&", groupingTranslator.stripWhiteSpace("\t\t&&"));
  }

  /**
   * Test {@link GroupingTranslator#stripWhiteSpace(String)}.
   *
   * <ul>
   *   <li>When {@code &&}.
   *   <li>Then return {@code &&}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#stripWhiteSpace(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String GroupingTranslator.stripWhiteSpace(String)"})
  public void testStripWhiteSpace_whenAmpersandAmpersand_thenReturnAmpersandAmpersand4() {
    // Arrange, Act and Assert
    assertEquals("&&", groupingTranslator.stripWhiteSpace("\t&&\t"));
  }

  /**
   * Test {@link GroupingTranslator#stripWhiteSpace(String)}.
   *
   * <ul>
   *   <li>When {@code (}.
   *   <li>Then return {@link GroupingTranslator#GROUPSTARTCHAR}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#stripWhiteSpace(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String GroupingTranslator.stripWhiteSpace(String)"})
  public void testStripWhiteSpace_whenLeftParenthesis_thenReturnGroupstartchar() {
    // Arrange, Act and Assert
    assertEquals(GroupingTranslator.GROUPSTARTCHAR, groupingTranslator.stripWhiteSpace("\t("));
  }

  /**
   * Test {@link GroupingTranslator#stripWhiteSpace(String)}.
   *
   * <ul>
   *   <li>When {@code (}.
   *   <li>Then return {@link GroupingTranslator#GROUPSTARTCHAR}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#stripWhiteSpace(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String GroupingTranslator.stripWhiteSpace(String)"})
  public void testStripWhiteSpace_whenLeftParenthesis_thenReturnGroupstartchar2() {
    // Arrange, Act and Assert
    assertEquals(GroupingTranslator.GROUPSTARTCHAR, groupingTranslator.stripWhiteSpace("(\t"));
  }

  /**
   * Test {@link GroupingTranslator#stripWhiteSpace(String)}.
   *
   * <ul>
   *   <li>When {@code (}.
   *   <li>Then return {@link GroupingTranslator#GROUPSTARTCHAR}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#stripWhiteSpace(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String GroupingTranslator.stripWhiteSpace(String)"})
  public void testStripWhiteSpace_whenLeftParenthesis_thenReturnGroupstartchar3() {
    // Arrange, Act and Assert
    assertEquals(GroupingTranslator.GROUPSTARTCHAR, groupingTranslator.stripWhiteSpace("\t\t("));
  }

  /**
   * Test {@link GroupingTranslator#stripWhiteSpace(String)}.
   *
   * <ul>
   *   <li>When {@code (}.
   *   <li>Then return {@link GroupingTranslator#GROUPSTARTCHAR}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#stripWhiteSpace(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String GroupingTranslator.stripWhiteSpace(String)"})
  public void testStripWhiteSpace_whenLeftParenthesis_thenReturnGroupstartchar4() {
    // Arrange, Act and Assert
    assertEquals(GroupingTranslator.GROUPSTARTCHAR, groupingTranslator.stripWhiteSpace("\t(\t"));
  }

  /**
   * Test {@link GroupingTranslator#stripWhiteSpace(String)}.
   *
   * <ul>
   *   <li>When {@code )}.
   *   <li>Then return {@link GroupingTranslator#GROUPENDCHAR}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#stripWhiteSpace(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String GroupingTranslator.stripWhiteSpace(String)"})
  public void testStripWhiteSpace_whenRightParenthesis_thenReturnGroupendchar() {
    // Arrange, Act and Assert
    assertEquals(GroupingTranslator.GROUPENDCHAR, groupingTranslator.stripWhiteSpace("\t)"));
  }

  /**
   * Test {@link GroupingTranslator#stripWhiteSpace(String)}.
   *
   * <ul>
   *   <li>When {@code )}.
   *   <li>Then return {@link GroupingTranslator#GROUPENDCHAR}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#stripWhiteSpace(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String GroupingTranslator.stripWhiteSpace(String)"})
  public void testStripWhiteSpace_whenRightParenthesis_thenReturnGroupendchar2() {
    // Arrange, Act and Assert
    assertEquals(GroupingTranslator.GROUPENDCHAR, groupingTranslator.stripWhiteSpace(")\t"));
  }

  /**
   * Test {@link GroupingTranslator#stripWhiteSpace(String)}.
   *
   * <ul>
   *   <li>When {@code )}.
   *   <li>Then return {@link GroupingTranslator#GROUPENDCHAR}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#stripWhiteSpace(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String GroupingTranslator.stripWhiteSpace(String)"})
  public void testStripWhiteSpace_whenRightParenthesis_thenReturnGroupendchar3() {
    // Arrange, Act and Assert
    assertEquals(GroupingTranslator.GROUPENDCHAR, groupingTranslator.stripWhiteSpace("\t\t)"));
  }

  /**
   * Test {@link GroupingTranslator#stripWhiteSpace(String)}.
   *
   * <ul>
   *   <li>When {@code )}.
   *   <li>Then return {@link GroupingTranslator#GROUPENDCHAR}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#stripWhiteSpace(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String GroupingTranslator.stripWhiteSpace(String)"})
  public void testStripWhiteSpace_whenRightParenthesis_thenReturnGroupendchar4() {
    // Arrange, Act and Assert
    assertEquals(
        GroupingTranslator.GROUPENDCHAR, new GroupingTranslator().stripWhiteSpace("\t)\t"));
  }

  /**
   * Test {@link GroupingTranslator#stripWhiteSpace(String)}.
   *
   * <ul>
   *   <li>When {@code ;;}.
   *   <li>Then return {@code ;;}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#stripWhiteSpace(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String GroupingTranslator.stripWhiteSpace(String)"})
  public void testStripWhiteSpace_whenSemicolonSemicolon_thenReturnSemicolonSemicolon() {
    // Arrange, Act and Assert
    assertEquals(";;", new GroupingTranslator().stripWhiteSpace("\t;;"));
  }

  /**
   * Test {@link GroupingTranslator#stripWhiteSpace(String)}.
   *
   * <ul>
   *   <li>When {@code ;}.
   *   <li>Then return {@link GroupingTranslator#STATEMENTENDCHAR}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#stripWhiteSpace(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String GroupingTranslator.stripWhiteSpace(String)"})
  public void testStripWhiteSpace_whenSemicolon_thenReturnStatementendchar() {
    // Arrange, Act and Assert
    assertEquals(GroupingTranslator.STATEMENTENDCHAR, groupingTranslator.stripWhiteSpace("\t;"));
  }

  /**
   * Test {@link GroupingTranslator#stripWhiteSpace(String)}.
   *
   * <ul>
   *   <li>When {@code ;}.
   *   <li>Then return {@link GroupingTranslator#STATEMENTENDCHAR}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#stripWhiteSpace(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String GroupingTranslator.stripWhiteSpace(String)"})
  public void testStripWhiteSpace_whenSemicolon_thenReturnStatementendchar2() {
    // Arrange, Act and Assert
    assertEquals(GroupingTranslator.STATEMENTENDCHAR, groupingTranslator.stripWhiteSpace(";\t"));
  }

  /**
   * Test {@link GroupingTranslator#stripWhiteSpace(String)}.
   *
   * <ul>
   *   <li>When {@code ;}.
   *   <li>Then return {@link GroupingTranslator#STATEMENTENDCHAR}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#stripWhiteSpace(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String GroupingTranslator.stripWhiteSpace(String)"})
  public void testStripWhiteSpace_whenSemicolon_thenReturnStatementendchar3() {
    // Arrange, Act and Assert
    assertEquals(GroupingTranslator.STATEMENTENDCHAR, groupingTranslator.stripWhiteSpace("\t\t;"));
  }

  /**
   * Test {@link GroupingTranslator#stripWhiteSpace(String)}.
   *
   * <ul>
   *   <li>When {@code ;}.
   *   <li>Then return {@link GroupingTranslator#STATEMENTENDCHAR}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#stripWhiteSpace(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String GroupingTranslator.stripWhiteSpace(String)"})
  public void testStripWhiteSpace_whenSemicolon_thenReturnStatementendchar4() {
    // Arrange, Act and Assert
    assertEquals(
        GroupingTranslator.STATEMENTENDCHAR, new GroupingTranslator().stripWhiteSpace("\t;\t"));
  }

  /**
   * Test {@link GroupingTranslator#parseGroups(Group, String)}.
   *
   * <ul>
   *   <li>Given {@code EQUALS}.
   *   <li>When {@code &&}.
   *   <li>Then {@link Group} (default constructor) OperatorType is {@code EQUALS}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#parseGroups(Group, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void GroupingTranslator.parseGroups(Group, String)"})
  public void testParseGroups_givenEquals_whenAmpersandAmpersand_thenGroupOperatorTypeIsEquals()
      throws MVELTranslationException {
    // Arrange
    Group myGroup = new Group();
    myGroup.setIsTopGroup(true);
    myGroup.setOperatorType(BLCOperator.EQUALS);

    // Act
    groupingTranslator.parseGroups(myGroup, "&&");

    // Assert that nothing has changed
    assertEquals(BLCOperator.EQUALS, myGroup.getOperatorType());
    assertTrue(myGroup.getPhrases().isEmpty());
  }

  /**
   * Test {@link GroupingTranslator#parseGroups(Group, String)}.
   *
   * <ul>
   *   <li>Given {@code EQUALS}.
   *   <li>When empty string.
   *   <li>Then {@link Group} (default constructor) OperatorType is {@code EQUALS}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#parseGroups(Group, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void GroupingTranslator.parseGroups(Group, String)"})
  public void testParseGroups_givenEquals_whenEmptyString_thenGroupOperatorTypeIsEquals()
      throws MVELTranslationException {
    // Arrange
    Group myGroup = new Group();
    myGroup.setIsTopGroup(true);
    myGroup.setOperatorType(BLCOperator.EQUALS);

    // Act
    groupingTranslator.parseGroups(myGroup, "");

    // Assert that nothing has changed
    assertEquals(BLCOperator.EQUALS, myGroup.getOperatorType());
    assertTrue(myGroup.getPhrases().isEmpty());
  }

  /**
   * Test {@link GroupingTranslator#parseGroups(Group, String)}.
   *
   * <ul>
   *   <li>Given {@code EQUALS}.
   *   <li>When {@link GroupingTranslator#GROUPSTARTCHAR}.
   *   <li>Then throw {@link MVELTranslationException}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#parseGroups(Group, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void GroupingTranslator.parseGroups(Group, String)"})
  public void testParseGroups_givenEquals_whenGroupstartchar_thenThrowMVELTranslationException()
      throws MVELTranslationException {
    // Arrange
    Group myGroup = new Group();
    myGroup.setIsTopGroup(true);
    myGroup.setOperatorType(BLCOperator.EQUALS);

    // Act and Assert
    assertThrows(
        MVELTranslationException.class,
        () -> groupingTranslator.parseGroups(myGroup, GroupingTranslator.GROUPSTARTCHAR));
  }

  /**
   * Test {@link GroupingTranslator#parseGroups(Group, String)}.
   *
   * <ul>
   *   <li>Given {@code EQUALS}.
   *   <li>When {@code Segment}.
   *   <li>Then {@link Group} (default constructor) Phrases size is one.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#parseGroups(Group, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void GroupingTranslator.parseGroups(Group, String)"})
  public void testParseGroups_givenEquals_whenSegment_thenGroupPhrasesSizeIsOne()
      throws MVELTranslationException {
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
    assertEquals(BLCOperator.EQUALS, myGroup.getOperatorType());
  }

  /**
   * Test {@link GroupingTranslator#parseGroups(Group, String)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link Group} (default constructor) OperatorType is {@code null}.
   *   <li>Then {@link Group} (default constructor) OperatorType is {@code AND}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#parseGroups(Group, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void GroupingTranslator.parseGroups(Group, String)"})
  public void testParseGroups_givenNull_whenGroupOperatorTypeIsNull_thenGroupOperatorTypeIsAnd()
      throws MVELTranslationException {
    // Arrange
    Group myGroup = new Group();
    myGroup.setIsTopGroup(true);
    myGroup.setOperatorType(null);

    // Act
    groupingTranslator.parseGroups(myGroup, "Segment");

    // Assert
    List<String> phrases = myGroup.getPhrases();
    assertEquals(1, phrases.size());
    assertEquals("Segment", phrases.get(0));
    assertEquals(BLCOperator.AND, myGroup.getOperatorType());
  }

  /**
   * Test {@link GroupingTranslator#parseGroups(Group, String)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link Group} (default constructor) OperatorType is {@code null}.
   *   <li>Then {@link Group} (default constructor) OperatorType is {@code OR}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#parseGroups(Group, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void GroupingTranslator.parseGroups(Group, String)"})
  public void testParseGroups_givenNull_whenGroupOperatorTypeIsNull_thenGroupOperatorTypeIsOr()
      throws MVELTranslationException {
    // Arrange
    Group myGroup = new Group();
    myGroup.setIsTopGroup(true);
    myGroup.setOperatorType(null);

    // Act
    groupingTranslator.parseGroups(myGroup, "||");

    // Assert
    assertEquals(BLCOperator.OR, myGroup.getOperatorType());
    assertTrue(myGroup.getPhrases().isEmpty());
  }

  /**
   * Test {@link GroupingTranslator#parseGroups(Group, String)}.
   *
   * <ul>
   *   <li>When {@code ||}.
   *   <li>Then throw {@link MVELTranslationException}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#parseGroups(Group, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void GroupingTranslator.parseGroups(Group, String)"})
  public void testParseGroups_whenVerticalLineVerticalLine_thenThrowMVELTranslationException()
      throws MVELTranslationException {
    // Arrange
    Group myGroup = new Group();
    myGroup.setIsTopGroup(true);
    myGroup.setOperatorType(BLCOperator.EQUALS);

    // Act and Assert
    assertThrows(
        MVELTranslationException.class, () -> groupingTranslator.parseGroups(myGroup, "||"));
  }

  /**
   * Test {@link GroupingTranslator#compilePhrases(String, Group, boolean)}.
   *
   * <ul>
   *   <li>Given {@code EQUALS}.
   *   <li>When {@code Segment}.
   *   <li>Then {@link Group} (default constructor) Phrases size is one.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#compilePhrases(String, Group, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void GroupingTranslator.compilePhrases(String, Group, boolean)"})
  public void testCompilePhrases_givenEquals_whenSegment_thenGroupPhrasesSizeIsOne()
      throws MVELTranslationException {
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
    assertEquals(BLCOperator.EQUALS, myGroup.getOperatorType());
  }

  /**
   * Test {@link GroupingTranslator#compilePhrases(String, Group, boolean)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@code &&}.
   *   <li>Then {@link Group} (default constructor) OperatorType is {@code AND}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#compilePhrases(String, Group, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void GroupingTranslator.compilePhrases(String, Group, boolean)"})
  public void testCompilePhrases_givenNull_whenAmpersandAmpersand_thenGroupOperatorTypeIsAnd()
      throws MVELTranslationException {
    // Arrange
    Group myGroup = new Group();
    myGroup.setIsTopGroup(true);
    myGroup.setOperatorType(null);

    // Act
    groupingTranslator.compilePhrases("&&", myGroup, false);

    // Assert
    assertEquals(BLCOperator.AND, myGroup.getOperatorType());
    assertTrue(myGroup.getPhrases().isEmpty());
  }

  /**
   * Test {@link GroupingTranslator#compilePhrases(String, Group, boolean)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When empty string.
   *   <li>Then {@link Group} (default constructor) Phrases Empty.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#compilePhrases(String, Group, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void GroupingTranslator.compilePhrases(String, Group, boolean)"})
  public void testCompilePhrases_givenNull_whenEmptyString_thenGroupPhrasesEmpty()
      throws MVELTranslationException {
    // Arrange
    Group myGroup = new Group();
    myGroup.setIsTopGroup(true);
    myGroup.setOperatorType(null);

    // Act
    groupingTranslator.compilePhrases("", myGroup, false);

    // Assert that nothing has changed
    assertTrue(myGroup.getPhrases().isEmpty());
  }

  /**
   * Test {@link GroupingTranslator#compilePhrases(String, Group, boolean)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@code foo&&bar}.
   *   <li>Then {@link Group} (default constructor) Phrases size is two.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#compilePhrases(String, Group, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void GroupingTranslator.compilePhrases(String, Group, boolean)"})
  public void testCompilePhrases_givenNull_whenFooBar_thenGroupPhrasesSizeIsTwo()
      throws MVELTranslationException {
    // Arrange
    Group myGroup = new Group();
    myGroup.setIsTopGroup(true);
    myGroup.setOperatorType(null);

    // Act
    groupingTranslator.compilePhrases("foo&&bar", myGroup, false);

    // Assert
    List<String> phrases = myGroup.getPhrases();
    assertEquals(2, phrases.size());
    assertEquals("bar", phrases.get(1));
    assertEquals("foo", phrases.get(0));
    assertEquals(BLCOperator.AND, myGroup.getOperatorType());
  }

  /**
   * Test {@link GroupingTranslator#compilePhrases(String, Group, boolean)}.
   *
   * <ul>
   *   <li>Then throw {@link MVELTranslationException}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#compilePhrases(String, Group, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void GroupingTranslator.compilePhrases(String, Group, boolean)"})
  public void testCompilePhrases_thenThrowMVELTranslationException()
      throws MVELTranslationException {
    // Arrange
    Group myGroup = new Group();
    myGroup.setIsTopGroup(true);
    myGroup.setOperatorType(BLCOperator.EQUALS);

    // Act and Assert
    assertThrows(
        MVELTranslationException.class,
        () -> groupingTranslator.compilePhrases("||", myGroup, false));
  }

  /**
   * Test {@link GroupingTranslator#compilePhrases(String, Group, boolean)}.
   *
   * <ul>
   *   <li>When {@code &&}.
   *   <li>Then {@link Group} (default constructor) OperatorType is {@code EQUALS}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#compilePhrases(String, Group, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void GroupingTranslator.compilePhrases(String, Group, boolean)"})
  public void testCompilePhrases_whenAmpersandAmpersand_thenGroupOperatorTypeIsEquals()
      throws MVELTranslationException {
    // Arrange
    Group myGroup = new Group();
    myGroup.setIsTopGroup(true);
    myGroup.setOperatorType(BLCOperator.EQUALS);

    // Act
    groupingTranslator.compilePhrases("&&", myGroup, true);

    // Assert that nothing has changed
    assertEquals(BLCOperator.EQUALS, myGroup.getOperatorType());
    assertTrue(myGroup.getPhrases().isEmpty());
  }

  /**
   * Test {@link GroupingTranslator#compilePhrases(String, Group, boolean)}.
   *
   * <ul>
   *   <li>When {@code ||}.
   *   <li>Then {@link Group} (default constructor) OperatorType is {@code OR}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#compilePhrases(String, Group, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void GroupingTranslator.compilePhrases(String, Group, boolean)"})
  public void testCompilePhrases_whenVerticalLineVerticalLine_thenGroupOperatorTypeIsOr()
      throws MVELTranslationException {
    // Arrange
    Group myGroup = new Group();
    myGroup.setIsTopGroup(true);
    myGroup.setOperatorType(null);

    // Act
    groupingTranslator.compilePhrases("||", myGroup, false);

    // Assert
    assertEquals(BLCOperator.OR, myGroup.getOperatorType());
    assertTrue(myGroup.getPhrases().isEmpty());
  }

  /**
   * Test {@link GroupingTranslator#setGroupOperator(String, Group, boolean, boolean, boolean)}.
   *
   * <ul>
   *   <li>Given {@code EQUALS}.
   *   <li>Then {@link Group} (default constructor) OperatorType is {@code EQUALS}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#setGroupOperator(String, Group, boolean,
   * boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void GroupingTranslator.setGroupOperator(String, Group, boolean, boolean, boolean)"
  })
  public void testSetGroupOperator_givenEquals_thenGroupOperatorTypeIsEquals()
      throws MVELTranslationException {
    // Arrange
    Group myGroup = new Group();
    myGroup.setIsTopGroup(true);
    myGroup.setOperatorType(BLCOperator.EQUALS);

    // Act
    groupingTranslator.setGroupOperator("Segment", myGroup, false, false, false);

    // Assert that nothing has changed
    assertEquals(BLCOperator.EQUALS, myGroup.getOperatorType());
  }

  /**
   * Test {@link GroupingTranslator#setGroupOperator(String, Group, boolean, boolean, boolean)}.
   *
   * <ul>
   *   <li>Given {@code EQUALS}.
   *   <li>Then throw {@link MVELTranslationException}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#setGroupOperator(String, Group, boolean,
   * boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void GroupingTranslator.setGroupOperator(String, Group, boolean, boolean, boolean)"
  })
  public void testSetGroupOperator_givenEquals_thenThrowMVELTranslationException()
      throws MVELTranslationException {
    // Arrange
    Group myGroup = new Group();
    myGroup.setIsTopGroup(true);
    myGroup.setOperatorType(BLCOperator.EQUALS);

    // Act and Assert
    assertThrows(
        MVELTranslationException.class,
        () -> groupingTranslator.setGroupOperator("Segment", myGroup, true, true, true));
  }

  /**
   * Test {@link GroupingTranslator#setGroupOperator(String, Group, boolean, boolean, boolean)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>Then {@link Group} (default constructor) OperatorType is {@code AND}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#setGroupOperator(String, Group, boolean,
   * boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void GroupingTranslator.setGroupOperator(String, Group, boolean, boolean, boolean)"
  })
  public void testSetGroupOperator_givenNull_thenGroupOperatorTypeIsAnd()
      throws MVELTranslationException {
    // Arrange
    Group myGroup = new Group();
    myGroup.setIsTopGroup(true);
    myGroup.setOperatorType(null);

    // Act
    groupingTranslator.setGroupOperator("Segment", myGroup, true, true, true);

    // Assert
    assertEquals(BLCOperator.AND, myGroup.getOperatorType());
  }

  /**
   * Test {@link GroupingTranslator#setGroupOperator(String, Group, boolean, boolean, boolean)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>Then {@link Group} (default constructor) OperatorType is {@code NOT}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#setGroupOperator(String, Group, boolean,
   * boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void GroupingTranslator.setGroupOperator(String, Group, boolean, boolean, boolean)"
  })
  public void testSetGroupOperator_givenNull_thenGroupOperatorTypeIsNot()
      throws MVELTranslationException {
    // Arrange
    Group myGroup = new Group();
    myGroup.setIsTopGroup(true);
    myGroup.setOperatorType(null);

    // Act
    groupingTranslator.setGroupOperator("Segment", myGroup, false, false, true);

    // Assert
    assertEquals(BLCOperator.NOT, myGroup.getOperatorType());
  }

  /**
   * Test {@link GroupingTranslator#setGroupOperator(String, Group, boolean, boolean, boolean)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>Then {@link Group} (default constructor) OperatorType is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#setGroupOperator(String, Group, boolean,
   * boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void GroupingTranslator.setGroupOperator(String, Group, boolean, boolean, boolean)"
  })
  public void testSetGroupOperator_givenNull_thenGroupOperatorTypeIsNull()
      throws MVELTranslationException {
    // Arrange
    Group myGroup = new Group();
    myGroup.setIsTopGroup(true);
    myGroup.setOperatorType(null);

    // Act
    groupingTranslator.setGroupOperator("Segment", myGroup, false, false, false);

    // Assert that nothing has changed
    assertNull(myGroup.getOperatorType());
  }

  /**
   * Test {@link GroupingTranslator#setGroupOperator(String, Group, boolean, boolean, boolean)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>Then {@link Group} (default constructor) OperatorType is {@code OR}.
   * </ul>
   *
   * <p>Method under test: {@link GroupingTranslator#setGroupOperator(String, Group, boolean,
   * boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void GroupingTranslator.setGroupOperator(String, Group, boolean, boolean, boolean)"
  })
  public void testSetGroupOperator_givenNull_thenGroupOperatorTypeIsOr()
      throws MVELTranslationException {
    // Arrange
    Group myGroup = new Group();
    myGroup.setIsTopGroup(true);
    myGroup.setOperatorType(null);

    // Act
    groupingTranslator.setGroupOperator("Segment", myGroup, false, true, true);

    // Assert
    assertEquals(BLCOperator.OR, myGroup.getOperatorType());
  }
}
