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
import org.junit.Test;

public class SearchSynonymImplDiffblueTest {
  /**
   * Method under test: {@link SearchSynonymImpl#getSynonyms()}
   */
  @Test
  public void testGetSynonyms() {
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
   * Method under test: {@link SearchSynonymImpl#setSynonyms(String[])}
   */
  @Test
  public void testSetSynonyms() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SearchSynonymImpl searchSynonymImpl = new SearchSynonymImpl();

    // Act
    searchSynonymImpl.setSynonyms(new String[]{"Synonyms"});

    // Assert
    assertArrayEquals(new String[]{"Synonyms"}, searchSynonymImpl.getSynonyms());
  }

  /**
   * Method under test: {@link SearchSynonymImpl#setSynonyms(String[])}
   */
  @Test
  public void testSetSynonyms2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SearchSynonymImpl searchSynonymImpl = new SearchSynonymImpl();

    // Act
    searchSynonymImpl.setSynonyms(new String[]{""});

    // Assert
    assertArrayEquals(new String[]{""}, searchSynonymImpl.getSynonyms());
  }

  /**
   * Method under test: {@link SearchSynonymImpl#setSynonyms(String[])}
   */
  @Test
  public void testSetSynonyms3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SearchSynonymImpl searchSynonymImpl = new SearchSynonymImpl();

    // Act
    searchSynonymImpl.setSynonyms(new String[]{});

    // Assert
    assertArrayEquals(new String[]{""}, searchSynonymImpl.getSynonyms());
  }

  /**
   * Method under test: {@link SearchSynonymImpl#setSynonyms(String[])}
   */
  @Test
  public void testSetSynonyms4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SearchSynonymImpl searchSynonymImpl = new SearchSynonymImpl();

    // Act
    searchSynonymImpl.setSynonyms(new String[]{"Synonyms", "42"});

    // Assert
    assertArrayEquals(new String[]{"Synonyms", "42"}, searchSynonymImpl.getSynonyms());
  }

  /**
   * Method under test: {@link SearchSynonymImpl#setSynonyms(String[])}
   */
  @Test
  public void testSetSynonyms5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SearchSynonymImpl searchSynonymImpl = new SearchSynonymImpl();

    // Act
    searchSynonymImpl.setSynonyms(new String[]{"", "42"});

    // Assert
    assertArrayEquals(new String[]{"", "42"}, searchSynonymImpl.getSynonyms());
  }

  /**
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
