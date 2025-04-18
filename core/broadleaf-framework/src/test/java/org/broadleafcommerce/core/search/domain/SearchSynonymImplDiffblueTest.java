/*-
 * #%L
 * BroadleafCommerce Framework
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
package org.broadleafcommerce.core.search.domain;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class SearchSynonymImplDiffblueTest {
  @Autowired
  private SearchSynonymImpl searchSynonymImpl;

  /**
   * Test {@link SearchSynonymImpl#getSynonyms()}.
   * <ul>
   *   <li>Then return array of {@link String} with {@code Synonyms}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SearchSynonymImpl#getSynonyms()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String[] SearchSynonymImpl.getSynonyms()"})
  public void testGetSynonyms_thenReturnArrayOfStringWithSynonyms() {
    // Arrange
    SearchSynonymImpl searchSynonymImpl2 = new SearchSynonymImpl();
    searchSynonymImpl2.setId(1L);
    searchSynonymImpl2.setSynonyms(new String[]{"Synonyms"});
    searchSynonymImpl2.setTerm("Term");

    // Act and Assert
    assertArrayEquals(new String[]{"Synonyms"}, searchSynonymImpl2.getSynonyms());
  }

  /**
   * Test {@link SearchSynonymImpl#setSynonyms(String[])}.
   * <ul>
   *   <li>Then {@link SearchSynonymImpl} (default constructor) Synonyms is array of {@link String} with empty string and {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SearchSynonymImpl#setSynonyms(String[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SearchSynonymImpl.setSynonyms(String[])"})
  public void testSetSynonyms_thenSearchSynonymImplSynonymsIsArrayOfStringWithEmptyStringAnd42() {
    // Arrange
    SearchSynonymImpl searchSynonymImpl2 = new SearchSynonymImpl();

    // Act
    searchSynonymImpl2.setSynonyms(new String[]{"", "42"});

    // Assert
    assertArrayEquals(new String[]{"", "42"}, searchSynonymImpl2.getSynonyms());
  }

  /**
   * Test {@link SearchSynonymImpl#setSynonyms(String[])}.
   * <ul>
   *   <li>Then {@link SearchSynonymImpl} (default constructor) Synonyms is array of {@link String} with {@code Synonyms}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SearchSynonymImpl#setSynonyms(String[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SearchSynonymImpl.setSynonyms(String[])"})
  public void testSetSynonyms_thenSearchSynonymImplSynonymsIsArrayOfStringWithSynonyms() {
    // Arrange
    SearchSynonymImpl searchSynonymImpl2 = new SearchSynonymImpl();

    // Act
    searchSynonymImpl2.setSynonyms(new String[]{"Synonyms"});

    // Assert
    assertArrayEquals(new String[]{"Synonyms"}, searchSynonymImpl2.getSynonyms());
  }

  /**
   * Test {@link SearchSynonymImpl#setSynonyms(String[])}.
   * <ul>
   *   <li>Then {@link SearchSynonymImpl} (default constructor) Synonyms is array of {@link String} with {@code Synonyms} and {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SearchSynonymImpl#setSynonyms(String[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SearchSynonymImpl.setSynonyms(String[])"})
  public void testSetSynonyms_thenSearchSynonymImplSynonymsIsArrayOfStringWithSynonymsAnd42() {
    // Arrange
    SearchSynonymImpl searchSynonymImpl2 = new SearchSynonymImpl();

    // Act
    searchSynonymImpl2.setSynonyms(new String[]{"Synonyms", "42"});

    // Assert
    assertArrayEquals(new String[]{"Synonyms", "42"}, searchSynonymImpl2.getSynonyms());
  }

  /**
   * Test {@link SearchSynonymImpl#setSynonyms(String[])}.
   * <ul>
   *   <li>When array of {@link String} with empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link SearchSynonymImpl#setSynonyms(String[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SearchSynonymImpl.setSynonyms(String[])"})
  public void testSetSynonyms_whenArrayOfStringWithEmptyString() {
    // Arrange
    SearchSynonymImpl searchSynonymImpl2 = new SearchSynonymImpl();

    // Act
    searchSynonymImpl2.setSynonyms(new String[]{""});

    // Assert
    assertArrayEquals(new String[]{""}, searchSynonymImpl2.getSynonyms());
  }

  /**
   * Test {@link SearchSynonymImpl#setSynonyms(String[])}.
   * <ul>
   *   <li>When empty array of {@link String}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SearchSynonymImpl#setSynonyms(String[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SearchSynonymImpl.setSynonyms(String[])"})
  public void testSetSynonyms_whenEmptyArrayOfString() {
    // Arrange
    SearchSynonymImpl searchSynonymImpl2 = new SearchSynonymImpl();

    // Act
    searchSynonymImpl2.setSynonyms(new String[]{});

    // Assert
    assertArrayEquals(new String[]{""}, searchSynonymImpl2.getSynonyms());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link SearchSynonymImpl}
   *   <li>{@link SearchSynonymImpl#setId(Long)}
   *   <li>{@link SearchSynonymImpl#setTerm(String)}
   *   <li>{@link SearchSynonymImpl#getId()}
   *   <li>{@link SearchSynonymImpl#getTerm()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SearchSynonymImpl.<init>()", "Long SearchSynonymImpl.getId()",
      "String SearchSynonymImpl.getTerm()", "void SearchSynonymImpl.setId(Long)",
      "void SearchSynonymImpl.setTerm(String)"})
  public void testGettersAndSetters() {
    // Arrange and Act
    SearchSynonymImpl actualSearchSynonymImpl = new SearchSynonymImpl();
    actualSearchSynonymImpl.setId(1L);
    actualSearchSynonymImpl.setTerm("Term");
    Long actualId = actualSearchSynonymImpl.getId();

    // Assert
    assertEquals("Term", actualSearchSynonymImpl.getTerm());
    assertEquals(1L, actualId.longValue());
  }
}
