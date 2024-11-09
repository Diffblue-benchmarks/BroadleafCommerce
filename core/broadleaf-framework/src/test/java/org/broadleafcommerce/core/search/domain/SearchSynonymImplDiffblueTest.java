/*-
 * #%L
 * BroadleafCommerce Framework
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
package org.broadleafcommerce.core.search.domain;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class SearchSynonymImplDiffblueTest {
  /**
   * Test {@link SearchSynonymImpl#getSynonyms()}.
   * <ul>
   *   <li>Then return array of {@link String} with {@code Synonyms}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SearchSynonymImpl#getSynonyms()}
   */
  @Test
  public void testGetSynonyms_thenReturnArrayOfStringWithSynonyms() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SearchSynonymImpl searchSynonymImpl = new SearchSynonymImpl();
    searchSynonymImpl.setId(1L);
    searchSynonymImpl.setSynonyms(new String[]{"Synonyms"});
    searchSynonymImpl.setTerm("Term");

    // Act and Assert
    assertArrayEquals(new String[]{"Synonyms"}, searchSynonymImpl.getSynonyms());
  }

  /**
   * Test {@link SearchSynonymImpl#setSynonyms(String[])}.
   * <ul>
   *   <li>Then {@link SearchSynonymImpl} (default constructor) Synonyms is array of
   * {@link String} with empty string and {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SearchSynonymImpl#setSynonyms(String[])}
   */
  @Test
  public void testSetSynonyms_thenSearchSynonymImplSynonymsIsArrayOfStringWithEmptyStringAnd42() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SearchSynonymImpl searchSynonymImpl = new SearchSynonymImpl();

    // Act
    searchSynonymImpl.setSynonyms(new String[]{"", "42"});

    // Assert
    assertArrayEquals(new String[]{"", "42"}, searchSynonymImpl.getSynonyms());
  }

  /**
   * Test {@link SearchSynonymImpl#setSynonyms(String[])}.
   * <ul>
   *   <li>Then {@link SearchSynonymImpl} (default constructor) Synonyms is array of
   * {@link String} with {@code Synonyms}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SearchSynonymImpl#setSynonyms(String[])}
   */
  @Test
  public void testSetSynonyms_thenSearchSynonymImplSynonymsIsArrayOfStringWithSynonyms() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SearchSynonymImpl searchSynonymImpl = new SearchSynonymImpl();

    // Act
    searchSynonymImpl.setSynonyms(new String[]{"Synonyms"});

    // Assert
    assertArrayEquals(new String[]{"Synonyms"}, searchSynonymImpl.getSynonyms());
  }

  /**
   * Test {@link SearchSynonymImpl#setSynonyms(String[])}.
   * <ul>
   *   <li>Then {@link SearchSynonymImpl} (default constructor) Synonyms is array of
   * {@link String} with {@code Synonyms} and {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SearchSynonymImpl#setSynonyms(String[])}
   */
  @Test
  public void testSetSynonyms_thenSearchSynonymImplSynonymsIsArrayOfStringWithSynonymsAnd42() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SearchSynonymImpl searchSynonymImpl = new SearchSynonymImpl();

    // Act
    searchSynonymImpl.setSynonyms(new String[]{"Synonyms", "42"});

    // Assert
    assertArrayEquals(new String[]{"Synonyms", "42"}, searchSynonymImpl.getSynonyms());
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
  public void testSetSynonyms_whenArrayOfStringWithEmptyString() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SearchSynonymImpl searchSynonymImpl = new SearchSynonymImpl();

    // Act
    searchSynonymImpl.setSynonyms(new String[]{""});

    // Assert
    assertArrayEquals(new String[]{""}, searchSynonymImpl.getSynonyms());
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
  public void testSetSynonyms_whenEmptyArrayOfString() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SearchSynonymImpl searchSynonymImpl = new SearchSynonymImpl();

    // Act
    searchSynonymImpl.setSynonyms(new String[]{});

    // Assert
    assertArrayEquals(new String[]{""}, searchSynonymImpl.getSynonyms());
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
  public void testGettersAndSetters() {
    // Arrange and Act
    SearchSynonymImpl actualSearchSynonymImpl = new SearchSynonymImpl();
    actualSearchSynonymImpl.setId(1L);
    actualSearchSynonymImpl.setTerm("Term");
    Long actualId = actualSearchSynonymImpl.getId();

    // Assert that nothing has changed
    assertEquals("Term", actualSearchSynonymImpl.getTerm());
    assertEquals(1L, actualId.longValue());
  }
}
