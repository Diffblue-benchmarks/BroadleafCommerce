package org.broadleafcommerce.openadmin.server.service.handler;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {DefaultCustomPersistenceHandlerFilter.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class DefaultCustomPersistenceHandlerFilterDiffblueTest {
  @Autowired
  private DefaultCustomPersistenceHandlerFilter defaultCustomPersistenceHandlerFilter;

  /**
   * Test {@link DefaultCustomPersistenceHandlerFilter#shouldUseHandler(String)}.
   * <p>
   * Method under test:
   * {@link DefaultCustomPersistenceHandlerFilter#shouldUseHandler(String)}
   */
  @Test
  public void testShouldUseHandler() {
    // Arrange, Act and Assert
    assertTrue(defaultCustomPersistenceHandlerFilter.shouldUseHandler("Handler Class Name"));
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link DefaultCustomPersistenceHandlerFilter}
   *   <li>
   * {@link DefaultCustomPersistenceHandlerFilter#setFilterCustomPersistenceHandlerClassnames(List)}
   *   <li>
   * {@link DefaultCustomPersistenceHandlerFilter#getFilterCustomPersistenceHandlerClassnames()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    DefaultCustomPersistenceHandlerFilter actualDefaultCustomPersistenceHandlerFilter = new DefaultCustomPersistenceHandlerFilter();
    ArrayList<String> filterCustomPersistenceHandlerClassnames = new ArrayList<>();
    actualDefaultCustomPersistenceHandlerFilter
        .setFilterCustomPersistenceHandlerClassnames(filterCustomPersistenceHandlerClassnames);
    List<String> actualFilterCustomPersistenceHandlerClassnames = actualDefaultCustomPersistenceHandlerFilter
        .getFilterCustomPersistenceHandlerClassnames();

    // Assert that nothing has changed
    assertTrue(actualFilterCustomPersistenceHandlerClassnames.isEmpty());
    assertSame(filterCustomPersistenceHandlerClassnames, actualFilterCustomPersistenceHandlerClassnames);
  }
}
