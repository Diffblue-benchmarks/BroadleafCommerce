package org.broadleafcommerce.openadmin.server.service.handler;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {DefaultCustomPersistenceHandlerFilter.class})
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(SpringJUnit4ClassRunner.class)
public class DefaultCustomPersistenceHandlerFilterDiffblueTest {
  @Autowired private DefaultCustomPersistenceHandlerFilter defaultCustomPersistenceHandlerFilter;

  /**
   * Test {@link DefaultCustomPersistenceHandlerFilter#shouldUseHandler(String)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code 42}.
   *   <li>When {@code 42}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultCustomPersistenceHandlerFilter#shouldUseHandler(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DefaultCustomPersistenceHandlerFilter.shouldUseHandler(String)"})
  public void testShouldUseHandler_givenArrayListAdd42_when42_thenReturnFalse() {
    // Arrange
    ArrayList<String> filterCustomPersistenceHandlerClassnames = new ArrayList<>();
    filterCustomPersistenceHandlerClassnames.add("42");
    filterCustomPersistenceHandlerClassnames.add("foo");
    filterCustomPersistenceHandlerClassnames.add(2, "foo");

    DefaultCustomPersistenceHandlerFilter defaultCustomPersistenceHandlerFilter =
        new DefaultCustomPersistenceHandlerFilter();
    defaultCustomPersistenceHandlerFilter.setFilterCustomPersistenceHandlerClassnames(
        filterCustomPersistenceHandlerClassnames);

    // Act and Assert
    assertFalse(defaultCustomPersistenceHandlerFilter.shouldUseHandler("42"));
  }

  /**
   * Test {@link DefaultCustomPersistenceHandlerFilter#shouldUseHandler(String)}.
   *
   * <ul>
   *   <li>Given {@link DefaultCustomPersistenceHandlerFilter}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultCustomPersistenceHandlerFilter#shouldUseHandler(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DefaultCustomPersistenceHandlerFilter.shouldUseHandler(String)"})
  public void testShouldUseHandler_givenDefaultCustomPersistenceHandlerFilter_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(defaultCustomPersistenceHandlerFilter.shouldUseHandler("Handler Class Name"));
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link DefaultCustomPersistenceHandlerFilter}
   *   <li>{@link
   *       DefaultCustomPersistenceHandlerFilter#setFilterCustomPersistenceHandlerClassnames(List)}
   *   <li>{@link
   *       DefaultCustomPersistenceHandlerFilter#getFilterCustomPersistenceHandlerClassnames()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultCustomPersistenceHandlerFilter.<init>()",
    "List DefaultCustomPersistenceHandlerFilter.getFilterCustomPersistenceHandlerClassnames()",
    "void DefaultCustomPersistenceHandlerFilter.setFilterCustomPersistenceHandlerClassnames(List)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    DefaultCustomPersistenceHandlerFilter actualDefaultCustomPersistenceHandlerFilter =
        new DefaultCustomPersistenceHandlerFilter();
    ArrayList<String> filterCustomPersistenceHandlerClassnames = new ArrayList<>();
    actualDefaultCustomPersistenceHandlerFilter.setFilterCustomPersistenceHandlerClassnames(
        filterCustomPersistenceHandlerClassnames);
    List<String> actualFilterCustomPersistenceHandlerClassnames =
        actualDefaultCustomPersistenceHandlerFilter.getFilterCustomPersistenceHandlerClassnames();

    // Assert
    assertTrue(actualFilterCustomPersistenceHandlerClassnames.isEmpty());
    assertSame(
        filterCustomPersistenceHandlerClassnames, actualFilterCustomPersistenceHandlerClassnames);
  }
}
