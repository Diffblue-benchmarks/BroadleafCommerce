package org.broadleafcommerce.core.search.dao;

import static org.junit.Assert.assertFalse;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class SearchFacetDaoImplDiffblueTest {
  /**
   * Test {@link SearchFacetDaoImpl#isSearchFacetRangeArchivable()}.
   *
   * <p>Method under test: {@link SearchFacetDaoImpl#isSearchFacetRangeArchivable()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SearchFacetDaoImpl.isSearchFacetRangeArchivable()"})
  public void testIsSearchFacetRangeArchivable() {
    // Arrange, Act and Assert
    assertFalse(new SearchFacetDaoImpl().isSearchFacetRangeArchivable());
  }
}
