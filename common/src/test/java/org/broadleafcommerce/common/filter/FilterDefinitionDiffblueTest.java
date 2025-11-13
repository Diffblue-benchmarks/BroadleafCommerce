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

public class FilterDefinitionDiffblueTest {
  /**
   * Test {@link FilterDefinition#copy()}.
   *
   * <ul>
   *   <li>Given {@link FilterDefinition} (default constructor) Params is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link FilterDefinition#copy()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"FilterDefinition FilterDefinition.copy()"})
  public void testCopy_givenFilterDefinitionParamsIsNull() {
    // Arrange
    FilterDefinition filterDefinition = new FilterDefinition();
    filterDefinition.setParams(null);

    // Act
    FilterDefinition actualCopyResult = filterDefinition.copy();

    // Assert
    assertNull(actualCopyResult.getEntityImplementationClassName());
    assertNull(actualCopyResult.getName());
    assertTrue(actualCopyResult.getParams().isEmpty());
  }

  /**
   * Test {@link FilterDefinition#copy()}.
   *
   * <ul>
   *   <li>Given {@link FilterDefinition} (default constructor).
   *   <li>Then return EntityImplementationClassName is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link FilterDefinition#copy()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"FilterDefinition FilterDefinition.copy()"})
  public void testCopy_givenFilterDefinition_thenReturnEntityImplementationClassNameIsNull() {
    // Arrange and Act
    FilterDefinition actualCopyResult = new FilterDefinition().copy();

    // Assert
    assertNull(actualCopyResult.getEntityImplementationClassName());
    assertNull(actualCopyResult.getName());
    assertTrue(actualCopyResult.getParams().isEmpty());
  }

  /**
   * Test {@link FilterDefinition#copy()}.
   *
   * <ul>
   *   <li>Given {@link FilterParameter} (default constructor) Name is {@code Name}.
   *   <li>Then return Params is {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link FilterDefinition#copy()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"FilterDefinition FilterDefinition.copy()"})
  public void testCopy_givenFilterParameterNameIsName_thenReturnParamsIsArrayList() {
    // Arrange
    FilterParameter filterParameter = new FilterParameter();
    filterParameter.setName("Name");
    filterParameter.setType("Type");

    ArrayList<FilterParameter> params = new ArrayList<>();
    params.add(filterParameter);

    FilterDefinition filterDefinition = new FilterDefinition();
    filterDefinition.setParams(params);

    // Act and Assert
    assertEquals(params, filterDefinition.copy().getParams());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link FilterDefinition}
   *   <li>{@link FilterDefinition#setEntityImplementationClassName(String)}
   *   <li>{@link FilterDefinition#setName(String)}
   *   <li>{@link FilterDefinition#setParams(List)}
   *   <li>{@link FilterDefinition#getEntityImplementationClassName()}
   *   <li>{@link FilterDefinition#getName()}
   *   <li>{@link FilterDefinition#getParams()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void FilterDefinition.<init>()",
    "String FilterDefinition.getEntityImplementationClassName()",
    "String FilterDefinition.getName()",
    "List FilterDefinition.getParams()",
    "void FilterDefinition.setEntityImplementationClassName(String)",
    "void FilterDefinition.setName(String)",
    "void FilterDefinition.setParams(List)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    FilterDefinition actualFilterDefinition = new FilterDefinition();
    actualFilterDefinition.setEntityImplementationClassName("Entity Implementation Class Name");
    actualFilterDefinition.setName("Name");
    ArrayList<FilterParameter> params = new ArrayList<>();
    actualFilterDefinition.setParams(params);
    String actualEntityImplementationClassName =
        actualFilterDefinition.getEntityImplementationClassName();
    String actualName = actualFilterDefinition.getName();
    List<FilterParameter> actualParams = actualFilterDefinition.getParams();

    // Assert
    assertEquals("Entity Implementation Class Name", actualEntityImplementationClassName);
    assertEquals("Name", actualName);
    assertTrue(actualParams.isEmpty());
    assertSame(params, actualParams);
  }
}
