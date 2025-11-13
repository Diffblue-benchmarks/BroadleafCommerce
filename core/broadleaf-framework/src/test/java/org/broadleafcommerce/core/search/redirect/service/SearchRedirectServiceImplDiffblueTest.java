package org.broadleafcommerce.core.search.redirect.service;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.core.search.redirect.dao.SearchRedirectDao;
import org.broadleafcommerce.core.search.redirect.domain.SearchRedirect;
import org.broadleafcommerce.core.search.redirect.domain.SearchRedirectImpl;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class SearchRedirectServiceImplDiffblueTest {
  @Mock private SearchRedirectDao searchRedirectDao;

  @InjectMocks private SearchRedirectServiceImpl searchRedirectServiceImpl;

  /**
   * Test {@link SearchRedirectServiceImpl#findSearchRedirectBySearchTerm(String)}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SearchRedirectServiceImpl#findSearchRedirectBySearchTerm(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "SearchRedirect SearchRedirectServiceImpl.findSearchRedirectBySearchTerm(String)"
  })
  public void testFindSearchRedirectBySearchTerm_thenReturnNull() {
    // Arrange
    when(searchRedirectDao.findSearchRedirectBySearchTerm(Mockito.<String>any())).thenReturn(null);

    // Act
    SearchRedirect actualFindSearchRedirectBySearchTermResult =
        searchRedirectServiceImpl.findSearchRedirectBySearchTerm("Uri");

    // Assert
    verify(searchRedirectDao).findSearchRedirectBySearchTerm("Uri");
    assertNull(actualFindSearchRedirectBySearchTermResult);
  }

  /**
   * Test {@link SearchRedirectServiceImpl#findSearchRedirectBySearchTerm(String)}.
   *
   * <ul>
   *   <li>Then return {@link SearchRedirectImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link SearchRedirectServiceImpl#findSearchRedirectBySearchTerm(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "SearchRedirect SearchRedirectServiceImpl.findSearchRedirectBySearchTerm(String)"
  })
  public void testFindSearchRedirectBySearchTerm_thenReturnSearchRedirectImpl() {
    // Arrange
    SearchRedirectImpl searchRedirectImpl = new SearchRedirectImpl();
    when(searchRedirectDao.findSearchRedirectBySearchTerm(Mockito.<String>any()))
        .thenReturn(searchRedirectImpl);

    // Act
    SearchRedirect actualFindSearchRedirectBySearchTermResult =
        searchRedirectServiceImpl.findSearchRedirectBySearchTerm("Uri");

    // Assert
    verify(searchRedirectDao).findSearchRedirectBySearchTerm("Uri");
    assertSame(searchRedirectImpl, actualFindSearchRedirectBySearchTermResult);
  }
}
