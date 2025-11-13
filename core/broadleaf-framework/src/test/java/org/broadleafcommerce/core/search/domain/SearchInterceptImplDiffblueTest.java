package org.broadleafcommerce.core.search.domain;

import static org.junit.Assert.assertEquals;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class SearchInterceptImplDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link SearchInterceptImpl}
   *   <li>{@link SearchInterceptImpl#setId(Long)}
   *   <li>{@link SearchInterceptImpl#setRedirect(String)}
   *   <li>{@link SearchInterceptImpl#setTerm(String)}
   *   <li>{@link SearchInterceptImpl#getId()}
   *   <li>{@link SearchInterceptImpl#getRedirect()}
   *   <li>{@link SearchInterceptImpl#getTerm()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SearchInterceptImpl.<init>()",
    "Long SearchInterceptImpl.getId()",
    "String SearchInterceptImpl.getRedirect()",
    "String SearchInterceptImpl.getTerm()",
    "void SearchInterceptImpl.setId(Long)",
    "void SearchInterceptImpl.setRedirect(String)",
    "void SearchInterceptImpl.setTerm(String)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    SearchInterceptImpl actualSearchInterceptImpl = new SearchInterceptImpl();
    actualSearchInterceptImpl.setId(1L);
    actualSearchInterceptImpl.setRedirect("Redirect");
    actualSearchInterceptImpl.setTerm("Term");
    Long actualId = actualSearchInterceptImpl.getId();
    String actualRedirect = actualSearchInterceptImpl.getRedirect();

    // Assert
    assertEquals("Redirect", actualRedirect);
    assertEquals("Term", actualSearchInterceptImpl.getTerm());
    assertEquals(1L, actualId.longValue());
  }
}
