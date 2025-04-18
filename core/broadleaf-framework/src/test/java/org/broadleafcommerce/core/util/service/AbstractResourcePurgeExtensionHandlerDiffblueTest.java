/*-
 * #%L
 * BroadleafCommerce Framework
 * %%
 * Copyright (C) 2009 - 2025 Broadleaf Commerce
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
package org.broadleafcommerce.core.util.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.sql.Statement;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.broadleafcommerce.common.extension.ExtensionResultStatusType;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {AbstractResourcePurgeExtensionHandler.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class AbstractResourcePurgeExtensionHandlerDiffblueTest {
  @Autowired
  private AbstractResourcePurgeExtensionHandler abstractResourcePurgeExtensionHandler;

  /**
   * Test {@link AbstractResourcePurgeExtensionHandler#addPurgeStatements(Statement, String)}.
   * <p>
   * Method under test: {@link AbstractResourcePurgeExtensionHandler#addPurgeStatements(Statement, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "ExtensionResultStatusType AbstractResourcePurgeExtensionHandler.addPurgeStatements(Statement, String)"})
  public void testAddPurgeStatements() {
    // Arrange, Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        abstractResourcePurgeExtensionHandler.addPurgeStatements(mock(Statement.class), "42"));
  }

  /**
   * Test {@link AbstractResourcePurgeExtensionHandler#addPurgeDependencies(Map)}.
   * <p>
   * Method under test: {@link AbstractResourcePurgeExtensionHandler#addPurgeDependencies(Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ExtensionResultStatusType AbstractResourcePurgeExtensionHandler.addPurgeDependencies(Map)"})
  public void testAddPurgeDependencies() {
    // Arrange
    AbstractResourcePurgeExtensionHandler abstractResourcePurgeExtensionHandler = new AbstractResourcePurgeExtensionHandler();

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        abstractResourcePurgeExtensionHandler.addPurgeDependencies(new HashMap<>()));
  }

  /**
   * Test {@link AbstractResourcePurgeExtensionHandler#addPurgeExclusions(Set)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link HashSet#HashSet()} add {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractResourcePurgeExtensionHandler#addPurgeExclusions(Set)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ExtensionResultStatusType AbstractResourcePurgeExtensionHandler.addPurgeExclusions(Set)"})
  public void testAddPurgeExclusions_given42_whenHashSetAdd42() {
    // Arrange
    AbstractResourcePurgeExtensionHandler abstractResourcePurgeExtensionHandler = new AbstractResourcePurgeExtensionHandler();

    HashSet<String> exclusions = new HashSet<>();
    exclusions.add("42");
    exclusions.add("foo");

    // Act and Assert
    assertNull(abstractResourcePurgeExtensionHandler.addPurgeExclusions(exclusions));
  }

  /**
   * Test {@link AbstractResourcePurgeExtensionHandler#addPurgeExclusions(Set)}.
   * <ul>
   *   <li>Given {@code foo}.</li>
   *   <li>When {@link HashSet#HashSet()} add {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractResourcePurgeExtensionHandler#addPurgeExclusions(Set)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ExtensionResultStatusType AbstractResourcePurgeExtensionHandler.addPurgeExclusions(Set)"})
  public void testAddPurgeExclusions_givenFoo_whenHashSetAddFoo() {
    // Arrange
    AbstractResourcePurgeExtensionHandler abstractResourcePurgeExtensionHandler = new AbstractResourcePurgeExtensionHandler();

    HashSet<String> exclusions = new HashSet<>();
    exclusions.add("foo");

    // Act and Assert
    assertNull(abstractResourcePurgeExtensionHandler.addPurgeExclusions(exclusions));
  }

  /**
   * Test {@link AbstractResourcePurgeExtensionHandler#addPurgeExclusions(Set)}.
   * <ul>
   *   <li>When {@link HashSet#HashSet()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractResourcePurgeExtensionHandler#addPurgeExclusions(Set)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ExtensionResultStatusType AbstractResourcePurgeExtensionHandler.addPurgeExclusions(Set)"})
  public void testAddPurgeExclusions_whenHashSet() {
    // Arrange
    AbstractResourcePurgeExtensionHandler abstractResourcePurgeExtensionHandler = new AbstractResourcePurgeExtensionHandler();

    // Act and Assert
    assertNull(abstractResourcePurgeExtensionHandler.addPurgeExclusions(new HashSet<>()));
  }

  /**
   * Test new {@link AbstractResourcePurgeExtensionHandler} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link AbstractResourcePurgeExtensionHandler}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AbstractResourcePurgeExtensionHandler.<init>()"})
  public void testNewAbstractResourcePurgeExtensionHandler() {
    // Arrange and Act
    AbstractResourcePurgeExtensionHandler actualAbstractResourcePurgeExtensionHandler = new AbstractResourcePurgeExtensionHandler();

    // Assert
    assertEquals(0, actualAbstractResourcePurgeExtensionHandler.getPriority());
    assertTrue(actualAbstractResourcePurgeExtensionHandler.isEnabled());
  }
}
