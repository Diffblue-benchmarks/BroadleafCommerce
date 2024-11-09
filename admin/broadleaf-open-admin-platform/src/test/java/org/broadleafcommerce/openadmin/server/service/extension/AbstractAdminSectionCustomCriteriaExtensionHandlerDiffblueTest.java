/*-
 * #%L
 * BroadleafCommerce Open Admin Platform
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
package org.broadleafcommerce.openadmin.server.service.extension;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import org.broadleafcommerce.common.extension.ExtensionResultStatusType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {AbstractAdminSectionCustomCriteriaExtensionHandler.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class AbstractAdminSectionCustomCriteriaExtensionHandlerDiffblueTest {
  @Autowired
  private AbstractAdminSectionCustomCriteriaExtensionHandler abstractAdminSectionCustomCriteriaExtensionHandler;

  /**
   * Test
   * {@link AbstractAdminSectionCustomCriteriaExtensionHandler#addAdditionalSectionCustomCriteria(ArrayList, String)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractAdminSectionCustomCriteriaExtensionHandler#addAdditionalSectionCustomCriteria(ArrayList, String)}
   */
  @Test
  public void testAddAdditionalSectionCustomCriteria_given42_whenArrayListAdd42() {
    // Arrange
    ArrayList<String> customCriteria = new ArrayList<>();
    customCriteria.add("42");
    customCriteria.add("foo");

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, abstractAdminSectionCustomCriteriaExtensionHandler
        .addAdditionalSectionCustomCriteria(customCriteria, "Section Class Name"));
  }

  /**
   * Test
   * {@link AbstractAdminSectionCustomCriteriaExtensionHandler#addAdditionalSectionCustomCriteria(ArrayList, String)}.
   * <ul>
   *   <li>Given {@code foo}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractAdminSectionCustomCriteriaExtensionHandler#addAdditionalSectionCustomCriteria(ArrayList, String)}
   */
  @Test
  public void testAddAdditionalSectionCustomCriteria_givenFoo_whenArrayListAddFoo() {
    // Arrange
    ArrayList<String> customCriteria = new ArrayList<>();
    customCriteria.add("foo");

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, abstractAdminSectionCustomCriteriaExtensionHandler
        .addAdditionalSectionCustomCriteria(customCriteria, "Section Class Name"));
  }

  /**
   * Test
   * {@link AbstractAdminSectionCustomCriteriaExtensionHandler#addAdditionalSectionCustomCriteria(ArrayList, String)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractAdminSectionCustomCriteriaExtensionHandler#addAdditionalSectionCustomCriteria(ArrayList, String)}
   */
  @Test
  public void testAddAdditionalSectionCustomCriteria_whenArrayList() {
    // Arrange, Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, abstractAdminSectionCustomCriteriaExtensionHandler
        .addAdditionalSectionCustomCriteria(new ArrayList<>(), "Section Class Name"));
  }

  /**
   * Test new {@link AbstractAdminSectionCustomCriteriaExtensionHandler} (default
   * constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link AbstractAdminSectionCustomCriteriaExtensionHandler}
   */
  @Test
  public void testNewAbstractAdminSectionCustomCriteriaExtensionHandler() {
    // Arrange and Act
    AbstractAdminSectionCustomCriteriaExtensionHandler actualAbstractAdminSectionCustomCriteriaExtensionHandler = new AbstractAdminSectionCustomCriteriaExtensionHandler();

    // Assert
    assertEquals(0, actualAbstractAdminSectionCustomCriteriaExtensionHandler.getPriority());
    assertTrue(actualAbstractAdminSectionCustomCriteriaExtensionHandler.isEnabled());
  }
}
