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
import java.sql.Statement;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BiFunction;
import org.broadleafcommerce.common.extension.ExtensionResultStatusType;
import org.junit.Test;
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
   * Method under test:
   * {@link AbstractResourcePurgeExtensionHandler#addPurgeStatements(Statement, String)}
   */
  @Test
  public void testAddPurgeStatements() {
    // Arrange, Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        abstractResourcePurgeExtensionHandler.addPurgeStatements(mock(Statement.class), "42"));
  }

  /**
   * Method under test:
   * {@link AbstractResourcePurgeExtensionHandler#addPurgeDependencies(Map)}
   */
  @Test
  public void testAddPurgeDependencies() {
    // Arrange
    AbstractResourcePurgeExtensionHandler abstractResourcePurgeExtensionHandler = new AbstractResourcePurgeExtensionHandler();

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        abstractResourcePurgeExtensionHandler.addPurgeDependencies(new HashMap<>()));
  }

  /**
   * Method under test:
   * {@link AbstractResourcePurgeExtensionHandler#addPurgeDependencies(Map)}
   */
  @Test
  public void testAddPurgeDependencies2() {
    // Arrange
    AbstractResourcePurgeExtensionHandler abstractResourcePurgeExtensionHandler = new AbstractResourcePurgeExtensionHandler();

    HashMap<String, List<DeleteStatementGeneratorImpl.PathElement>> dependencies = new HashMap<>();
    dependencies.computeIfPresent("foo", mock(BiFunction.class));

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        abstractResourcePurgeExtensionHandler.addPurgeDependencies(dependencies));
  }

  /**
   * Method under test:
   * {@link AbstractResourcePurgeExtensionHandler#addPurgeExclusions(Set)}
   */
  @Test
  public void testAddPurgeExclusions() {
    // Arrange
    AbstractResourcePurgeExtensionHandler abstractResourcePurgeExtensionHandler = new AbstractResourcePurgeExtensionHandler();

    // Act and Assert
    assertNull(abstractResourcePurgeExtensionHandler.addPurgeExclusions(new HashSet<>()));
  }

  /**
   * Method under test:
   * {@link AbstractResourcePurgeExtensionHandler#addPurgeExclusions(Set)}
   */
  @Test
  public void testAddPurgeExclusions2() {
    // Arrange
    AbstractResourcePurgeExtensionHandler abstractResourcePurgeExtensionHandler = new AbstractResourcePurgeExtensionHandler();

    HashSet<String> exclusions = new HashSet<>();
    exclusions.add("foo");

    // Act and Assert
    assertNull(abstractResourcePurgeExtensionHandler.addPurgeExclusions(exclusions));
  }

  /**
   * Method under test:
   * {@link AbstractResourcePurgeExtensionHandler#addPurgeExclusions(Set)}
   */
  @Test
  public void testAddPurgeExclusions3() {
    // Arrange
    AbstractResourcePurgeExtensionHandler abstractResourcePurgeExtensionHandler = new AbstractResourcePurgeExtensionHandler();

    HashSet<String> exclusions = new HashSet<>();
    exclusions.add("42");
    exclusions.add("foo");

    // Act and Assert
    assertNull(abstractResourcePurgeExtensionHandler.addPurgeExclusions(exclusions));
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link AbstractResourcePurgeExtensionHandler}
   */
  @Test
  public void testNewAbstractResourcePurgeExtensionHandler() {
    // Arrange and Act
    AbstractResourcePurgeExtensionHandler actualAbstractResourcePurgeExtensionHandler = new AbstractResourcePurgeExtensionHandler();

    // Assert
    assertEquals(0, actualAbstractResourcePurgeExtensionHandler.getPriority());
    assertTrue(actualAbstractResourcePurgeExtensionHandler.isEnabled());
  }
}
