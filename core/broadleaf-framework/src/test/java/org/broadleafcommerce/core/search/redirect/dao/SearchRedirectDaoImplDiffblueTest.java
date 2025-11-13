package org.broadleafcommerce.core.search.redirect.dao;

import static org.junit.Assert.assertEquals;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class SearchRedirectDaoImplDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SearchRedirectDaoImpl#setCurrentDateResolution(Long)}
   *   <li>{@link SearchRedirectDaoImpl#getCurrentDateResolution()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Long SearchRedirectDaoImpl.getCurrentDateResolution()",
    "void SearchRedirectDaoImpl.setCurrentDateResolution(Long)"
  })
  public void testGettersAndSetters() {
    // Arrange
    SearchRedirectDaoImpl searchRedirectDaoImpl = new SearchRedirectDaoImpl();

    // Act
    searchRedirectDaoImpl.setCurrentDateResolution(1L);

    // Assert
    assertEquals(1L, searchRedirectDaoImpl.getCurrentDateResolution().longValue());
  }
}
