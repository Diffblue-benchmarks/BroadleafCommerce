package org.broadleafcommerce.core.search.domain;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class SearchInterceptImplDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
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
  public void testGettersAndSetters() {
    // Arrange and Act
    SearchInterceptImpl actualSearchInterceptImpl = new SearchInterceptImpl();
    actualSearchInterceptImpl.setId(1L);
    actualSearchInterceptImpl.setRedirect("Redirect");
    actualSearchInterceptImpl.setTerm("Term");
    Long actualId = actualSearchInterceptImpl.getId();
    String actualRedirect = actualSearchInterceptImpl.getRedirect();

    // Assert that nothing has changed
    assertEquals("Redirect", actualRedirect);
    assertEquals("Term", actualSearchInterceptImpl.getTerm());
    assertEquals(1L, actualId.longValue());
  }
}
