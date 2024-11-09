/*-
 * #%L
 * BroadleafCommerce Common Libraries
 * %%
 * Copyright (C) 2009 - 2024 Broadleaf Commerce
 * %%
 * Licensed under the Broadleaf Fair Use License Agreement, Version 1.0
 * (the "Fair Use License" located  at http://license.broadleafcommerce.org/fair_use_license-1.0.txt)
 * unless the restrictions on use therein are violated and require payment to Broadleaf in which case
 * the Broadleaf End User License Agreement (EULA), Version 1.1
 * (the "Commercial License" located at http://license.broadleafcommerce.org/commercial_license-1.1.txt)
 * shall apply.
 * 
 * Alternatively, the Commercial License may be replaced with a mutually agreed upon license (the "Custom License")
 * between you and Broadleaf Commerce. You may not use this file except in compliance with the applicable license.
 * #L%
 */
package org.broadleafcommerce.common.filter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.junit.Test;

public class FilterDefinitionDiffblueTest {
  /**
   * Test {@link FilterDefinition#copy()}.
   * <ul>
   *   <li>Given {@link FilterDefinition} (default constructor) Params is
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FilterDefinition#copy()}
   */
  @Test
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
   * <ul>
   *   <li>Given {@link FilterDefinition} (default constructor).</li>
   *   <li>Then return EntityImplementationClassName is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FilterDefinition#copy()}
   */
  @Test
  public void testCopy_givenFilterDefinition_thenReturnEntityImplementationClassNameIsNull() {
    // Arrange and Act
    FilterDefinition actualCopyResult = (new FilterDefinition()).copy();

    // Assert
    assertNull(actualCopyResult.getEntityImplementationClassName());
    assertNull(actualCopyResult.getName());
    assertTrue(actualCopyResult.getParams().isEmpty());
  }

  /**
   * Test {@link FilterDefinition#copy()}.
   * <ul>
   *   <li>Given {@link FilterParameter} (default constructor) Name is
   * {@code Name}.</li>
   *   <li>Then return Params is {@link LinkedList#LinkedList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FilterDefinition#copy()}
   */
  @Test
  public void testCopy_givenFilterParameterNameIsName_thenReturnParamsIsLinkedList() {
    // Arrange
    FilterParameter filterParameter = new FilterParameter();
    filterParameter.setName("Name");
    filterParameter.setType("Type");

    LinkedList<FilterParameter> params = new LinkedList<>();
    params.add(filterParameter);

    FilterDefinition filterDefinition = new FilterDefinition();
    filterDefinition.setParams(params);

    // Act and Assert
    assertEquals(params, filterDefinition.copy().getParams());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
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
  public void testGettersAndSetters() {
    // Arrange and Act
    FilterDefinition actualFilterDefinition = new FilterDefinition();
    actualFilterDefinition.setEntityImplementationClassName("Entity Implementation Class Name");
    actualFilterDefinition.setName("Name");
    ArrayList<FilterParameter> params = new ArrayList<>();
    actualFilterDefinition.setParams(params);
    String actualEntityImplementationClassName = actualFilterDefinition.getEntityImplementationClassName();
    String actualName = actualFilterDefinition.getName();
    List<FilterParameter> actualParams = actualFilterDefinition.getParams();

    // Assert that nothing has changed
    assertEquals("Entity Implementation Class Name", actualEntityImplementationClassName);
    assertEquals("Name", actualName);
    assertTrue(actualParams.isEmpty());
    assertSame(params, actualParams);
  }
}
