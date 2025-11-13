package org.broadleafcommerce.common.filter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class FilterDiffblueTest {
  /**
   * Test {@link Filter#copy()}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code foo}.
   *   <li>Then return IndexColumnNames size is one.
   * </ul>
   *
   * <p>Method under test: {@link Filter#copy()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Filter Filter.copy()"})
  public void testCopy_givenArrayListAddFoo_thenReturnIndexColumnNamesSizeIsOne() {
    // Arrange
    ArrayList<String> indexColumnNames = new ArrayList<>();
    indexColumnNames.add("foo");

    Filter filter = new Filter();
    filter.setIndexColumnNames(indexColumnNames);

    // Act
    Filter actualCopyResult = filter.copy();

    // Assert
    List<String> indexColumnNames2 = actualCopyResult.getIndexColumnNames();
    assertEquals(1, indexColumnNames2.size());
    assertEquals("foo", indexColumnNames2.get(0));
    assertNull(actualCopyResult.getCondition());
    assertNull(actualCopyResult.getEntityImplementationClassName());
    assertNull(actualCopyResult.getName());
    assertNull(actualCopyResult.getOverrideIndexNameKey());
  }

  /**
   * Test {@link Filter#copy()}.
   *
   * <ul>
   *   <li>Given {@link Filter} (default constructor) IndexColumnNames is {@link
   *       ArrayList#ArrayList()}.
   *   <li>Then return IndexColumnNames is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Filter#copy()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Filter Filter.copy()"})
  public void testCopy_givenFilterIndexColumnNamesIsArrayList_thenReturnIndexColumnNamesIsNull() {
    // Arrange
    Filter filter = new Filter();
    filter.setIndexColumnNames(new ArrayList<>());

    // Act
    Filter actualCopyResult = filter.copy();

    // Assert
    assertNull(actualCopyResult.getCondition());
    assertNull(actualCopyResult.getEntityImplementationClassName());
    assertNull(actualCopyResult.getName());
    assertNull(actualCopyResult.getOverrideIndexNameKey());
    assertNull(actualCopyResult.getIndexColumnNames());
  }

  /**
   * Test {@link Filter#copy()}.
   *
   * <ul>
   *   <li>Given {@link Filter} (default constructor).
   *   <li>Then return IndexColumnNames is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Filter#copy()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Filter Filter.copy()"})
  public void testCopy_givenFilter_thenReturnIndexColumnNamesIsNull() {
    // Arrange and Act
    Filter actualCopyResult = new Filter().copy();

    // Assert
    assertNull(actualCopyResult.getCondition());
    assertNull(actualCopyResult.getEntityImplementationClassName());
    assertNull(actualCopyResult.getName());
    assertNull(actualCopyResult.getOverrideIndexNameKey());
    assertNull(actualCopyResult.getIndexColumnNames());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link Filter}
   *   <li>{@link Filter#setCondition(String)}
   *   <li>{@link Filter#setEntityImplementationClassName(String)}
   *   <li>{@link Filter#setIndexColumnNames(List)}
   *   <li>{@link Filter#setName(String)}
   *   <li>{@link Filter#setOverrideIndexNameKey(String)}
   *   <li>{@link Filter#getCondition()}
   *   <li>{@link Filter#getEntityImplementationClassName()}
   *   <li>{@link Filter#getIndexColumnNames()}
   *   <li>{@link Filter#getName()}
   *   <li>{@link Filter#getOverrideIndexNameKey()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Filter.<init>()",
    "String Filter.getCondition()",
    "String Filter.getEntityImplementationClassName()",
    "List Filter.getIndexColumnNames()",
    "String Filter.getName()",
    "String Filter.getOverrideIndexNameKey()",
    "void Filter.setCondition(String)",
    "void Filter.setEntityImplementationClassName(String)",
    "void Filter.setIndexColumnNames(List)",
    "void Filter.setName(String)",
    "void Filter.setOverrideIndexNameKey(String)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    Filter actualFilter = new Filter();
    actualFilter.setCondition("Condition");
    actualFilter.setEntityImplementationClassName("Entity Implementation Class Name");
    ArrayList<String> indexColumnNames = new ArrayList<>();
    actualFilter.setIndexColumnNames(indexColumnNames);
    actualFilter.setName("Name");
    actualFilter.setOverrideIndexNameKey("Override Index Name Key");
    String actualCondition = actualFilter.getCondition();
    String actualEntityImplementationClassName = actualFilter.getEntityImplementationClassName();
    List<String> actualIndexColumnNames = actualFilter.getIndexColumnNames();
    String actualName = actualFilter.getName();

    // Assert
    assertEquals("Condition", actualCondition);
    assertEquals("Entity Implementation Class Name", actualEntityImplementationClassName);
    assertEquals("Name", actualName);
    assertEquals("Override Index Name Key", actualFilter.getOverrideIndexNameKey());
    assertTrue(actualIndexColumnNames.isEmpty());
    assertSame(indexColumnNames, actualIndexColumnNames);
  }
}
