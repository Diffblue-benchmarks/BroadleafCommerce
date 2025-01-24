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
