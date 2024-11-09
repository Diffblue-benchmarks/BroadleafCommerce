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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.broadleafcommerce.core.catalog.domain.Category;
import org.broadleafcommerce.core.catalog.domain.CategoryImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {SearchCriteria.class})
@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class SearchCriteriaDiffblueTest {
  @Autowired
  private SearchCriteria searchCriteria;

  /**
   * Test {@link SearchCriteria#addFilterQuery(String)}.
   * <p>
   * Method under test: {@link SearchCriteria#addFilterQuery(String)}
   */
  @Test
  public void testAddFilterQuery() {
    // Arrange and Act
    searchCriteria.addFilterQuery("Query");

    // Assert
    Collection<String> filterQueries = searchCriteria.getFilterQueries();
    assertEquals(1, filterQueries.size());
    assertTrue(filterQueries instanceof List);
    assertEquals("Query", ((List<String>) filterQueries).get(0));
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link SearchCriteria}
   *   <li>{@link SearchCriteria#setCategory(Category)}
   *   <li>{@link SearchCriteria#setFilterCriteria(Map)}
   *   <li>{@link SearchCriteria#setFilterQueries(Collection)}
   *   <li>{@link SearchCriteria#setPage(Integer)}
   *   <li>{@link SearchCriteria#setPageSize(Integer)}
   *   <li>{@link SearchCriteria#setQuery(String)}
   *   <li>{@link SearchCriteria#setRequestHandler(String)}
   *   <li>{@link SearchCriteria#setSearchExplicitCategory(boolean)}
   *   <li>{@link SearchCriteria#setSortQuery(String)}
   *   <li>{@link SearchCriteria#setStartIndex(Integer)}
   *   <li>{@link SearchCriteria#getCategory()}
   *   <li>{@link SearchCriteria#getFilterCriteria()}
   *   <li>{@link SearchCriteria#getFilterQueries()}
   *   <li>{@link SearchCriteria#getPage()}
   *   <li>{@link SearchCriteria#getPageSize()}
   *   <li>{@link SearchCriteria#getQuery()}
   *   <li>{@link SearchCriteria#getRequestHandler()}
   *   <li>{@link SearchCriteria#getSearchExplicitCategory()}
   *   <li>{@link SearchCriteria#getSortQuery()}
   *   <li>{@link SearchCriteria#getStartIndex()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    SearchCriteria actualSearchCriteria = new SearchCriteria();
    CategoryImpl category = new CategoryImpl();
    actualSearchCriteria.setCategory(category);
    HashMap<String, String[]> filterCriteria = new HashMap<>();
    actualSearchCriteria.setFilterCriteria(filterCriteria);
    ArrayList<String> filterQueries = new ArrayList<>();
    actualSearchCriteria.setFilterQueries(filterQueries);
    actualSearchCriteria.setPage(1);
    actualSearchCriteria.setPageSize(3);
    actualSearchCriteria.setQuery("Query");
    actualSearchCriteria.setRequestHandler("Request Handler");
    actualSearchCriteria.setSearchExplicitCategory(true);
    actualSearchCriteria.setSortQuery("Sort Query");
    actualSearchCriteria.setStartIndex(1);
    Category actualCategory = actualSearchCriteria.getCategory();
    Map<String, String[]> actualFilterCriteria = actualSearchCriteria.getFilterCriteria();
    Collection<String> actualFilterQueries = actualSearchCriteria.getFilterQueries();
    Integer actualPage = actualSearchCriteria.getPage();
    Integer actualPageSize = actualSearchCriteria.getPageSize();
    String actualQuery = actualSearchCriteria.getQuery();
    String actualRequestHandler = actualSearchCriteria.getRequestHandler();
    boolean actualSearchExplicitCategory = actualSearchCriteria.getSearchExplicitCategory();
    String actualSortQuery = actualSearchCriteria.getSortQuery();
    Integer actualStartIndex = actualSearchCriteria.getStartIndex();

    // Assert that nothing has changed
    assertTrue(actualFilterQueries instanceof List);
    assertEquals("Query", actualQuery);
    assertEquals("Request Handler", actualRequestHandler);
    assertEquals("Sort Query", actualSortQuery);
    assertEquals(1, actualPage.intValue());
    assertEquals(1, actualStartIndex.intValue());
    assertEquals(3, actualPageSize.intValue());
    assertTrue(actualFilterCriteria.isEmpty());
    assertTrue(actualSearchExplicitCategory);
    assertSame(filterQueries, actualFilterQueries);
    assertSame(filterCriteria, actualFilterCriteria);
    assertSame(category, actualCategory);
  }
}
