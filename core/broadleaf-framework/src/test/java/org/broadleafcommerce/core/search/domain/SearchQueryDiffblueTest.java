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
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {SearchQuery.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class SearchQueryDiffblueTest {
  @Autowired
  private SearchQuery searchQuery;

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link SearchQuery#SearchQuery()}
   *   <li>{@link SearchQuery#setQueryString(String)}
   *   <li>{@link SearchQuery#getQueryString()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    SearchQuery actualSearchQuery = new SearchQuery();
    actualSearchQuery.setQueryString("Query String");

    // Assert that nothing has changed
    assertEquals("Query String", actualSearchQuery.getQueryString());
  }

  /**
   * Test {@link SearchQuery#SearchQuery(String)}.
   * <p>
   * Method under test: {@link SearchQuery#SearchQuery(String)}
   */
  @Test
  public void testNewSearchQuery() {
    // Arrange, Act and Assert
    assertEquals("Query String", (new SearchQuery("Query String")).getQueryString());
  }
}
