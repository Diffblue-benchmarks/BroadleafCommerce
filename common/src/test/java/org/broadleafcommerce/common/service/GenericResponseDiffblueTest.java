/*-
 * #%L
 * BroadleafCommerce Common Libraries
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
package org.broadleafcommerce.common.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {GenericResponse.class})
@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class GenericResponseDiffblueTest {
  @Autowired
  private GenericResponse genericResponse;

  /**
   * Method under test: {@link GenericResponse#getHasErrors()}
   */
  @Test
  public void testGetHasErrors() {
    // Arrange, Act and Assert
    assertFalse((new GenericResponse()).getHasErrors());
  }

  /**
   * Method under test: {@link GenericResponse#getHasErrors()}
   */
  @Test
  public void testGetHasErrors2() {
    // Arrange
    GenericResponse genericResponse = new GenericResponse();
    genericResponse.addErrorCode("An error occurred");

    // Act and Assert
    assertTrue(genericResponse.getHasErrors());
  }

  /**
   * Method under test: {@link GenericResponse#addErrorCode(String)}
   */
  @Test
  public void testAddErrorCode() {
    // Arrange and Act
    genericResponse.addErrorCode("An error occurred");

    // Assert
    List<String> errorCodesList = genericResponse.getErrorCodesList();
    assertEquals(1, errorCodesList.size());
    assertEquals("An error occurred", errorCodesList.get(0));
    assertTrue(genericResponse.getHasErrors());
  }

  /**
   * Method under test: {@link GenericResponse#addErrorCode(String, List)}
   */
  @Test
  public void testAddErrorCode2() {
    // Arrange and Act
    genericResponse.addErrorCode("An error occurred", new ArrayList<>());

    // Assert
    List<String> errorCodesList = genericResponse.getErrorCodesList();
    assertEquals(1, errorCodesList.size());
    assertEquals("An error occurred", errorCodesList.get(0));
    assertTrue(genericResponse.getHasErrors());
  }

  /**
   * Method under test: {@link GenericResponse#addErrorCode(String, List)}
   */
  @Test
  public void testAddErrorCode3() {
    // Arrange
    ArrayList<String> arguments = new ArrayList<>();
    arguments.add("foo");

    // Act
    genericResponse.addErrorCode("An error occurred", arguments);

    // Assert
    List<String> errorCodesList = genericResponse.getErrorCodesList();
    assertEquals(1, errorCodesList.size());
    assertEquals("An error occurred", errorCodesList.get(0));
    assertTrue(genericResponse.getHasErrors());
  }

  /**
   * Method under test: {@link GenericResponse#addErrorCode(String, List)}
   */
  @Test
  public void testAddErrorCode4() {
    // Arrange
    ArrayList<String> arguments = new ArrayList<>();
    arguments.add("42");
    arguments.add("foo");

    // Act
    genericResponse.addErrorCode("An error occurred", arguments);

    // Assert
    List<String> errorCodesList = genericResponse.getErrorCodesList();
    assertEquals(1, errorCodesList.size());
    assertEquals("An error occurred", errorCodesList.get(0));
    assertTrue(genericResponse.getHasErrors());
  }

  /**
   * Method under test: {@link GenericResponse#getErrorCodeArguments(String)}
   */
  @Test
  public void testGetErrorCodeArguments() {
    // Arrange, Act and Assert
    assertEquals(0, genericResponse.getErrorCodeArguments("An error occurred").length);
    assertEquals(0, genericResponse.getErrorCodeArguments("Error Code").length);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link GenericResponse}
   *   <li>{@link GenericResponse#getErrorCodesList()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertTrue((new GenericResponse()).getErrorCodesList().isEmpty());
  }
}
