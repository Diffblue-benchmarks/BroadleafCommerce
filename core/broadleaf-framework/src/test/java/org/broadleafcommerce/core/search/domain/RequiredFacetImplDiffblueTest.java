package org.broadleafcommerce.core.search.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class RequiredFacetImplDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link RequiredFacetImpl}
   *   <li>{@link RequiredFacetImpl#setId(Long)}
   *   <li>{@link RequiredFacetImpl#setRequiredFacet(SearchFacet)}
   *   <li>{@link RequiredFacetImpl#setSearchFacet(SearchFacet)}
   *   <li>{@link RequiredFacetImpl#getId()}
   *   <li>{@link RequiredFacetImpl#getRequiredFacet()}
   *   <li>{@link RequiredFacetImpl#getSearchFacet()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void RequiredFacetImpl.<init>()",
    "Long RequiredFacetImpl.getId()",
    "SearchFacet RequiredFacetImpl.getRequiredFacet()",
    "SearchFacet RequiredFacetImpl.getSearchFacet()",
    "void RequiredFacetImpl.setId(Long)",
    "void RequiredFacetImpl.setRequiredFacet(SearchFacet)",
    "void RequiredFacetImpl.setSearchFacet(SearchFacet)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    RequiredFacetImpl actualRequiredFacetImpl = new RequiredFacetImpl();
    actualRequiredFacetImpl.setId(1L);
    SearchFacetImpl requiredFacet = new SearchFacetImpl();
    actualRequiredFacetImpl.setRequiredFacet(requiredFacet);
    SearchFacetImpl searchFacet = new SearchFacetImpl();
    actualRequiredFacetImpl.setSearchFacet(searchFacet);
    Long actualId = actualRequiredFacetImpl.getId();
    SearchFacet actualRequiredFacet = actualRequiredFacetImpl.getRequiredFacet();
    SearchFacet actualSearchFacet = actualRequiredFacetImpl.getSearchFacet();

    // Assert
    assertEquals(1L, actualId.longValue());
    assertSame(requiredFacet, actualRequiredFacet);
    assertSame(searchFacet, actualSearchFacet);
  }
}
