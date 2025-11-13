package org.broadleafcommerce.openadmin.server.security.dao;

import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class AdminNavigationDaoImplDiffblueTest {
  /**
   * Test {@link AdminNavigationDaoImpl#getSectionKey(boolean)}.
   *
   * <p>Method under test: {@link AdminNavigationDaoImpl#getSectionKey(boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String AdminNavigationDaoImpl.getSectionKey(boolean)"})
  public void testGetSectionKey() {
    // Arrange, Act and Assert
    assertNull(new AdminNavigationDaoImpl().getSectionKey(true));
  }
}
