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
   * Test {@link GenericResponse#getHasErrors()}.
   * <ul>
   *   <li>Given {@link GenericResponse} (default constructor) addErrorCode
   * {@code An error occurred}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GenericResponse#getHasErrors()}
   */
  @Test
  public void testGetHasErrors_givenGenericResponseAddErrorCodeAnErrorOccurred_thenReturnTrue() {
    // Arrange
    GenericResponse genericResponse = new GenericResponse();
    genericResponse.addErrorCode("An error occurred");

    // Act and Assert
    assertTrue(genericResponse.getHasErrors());
  }

  /**
   * Test {@link GenericResponse#getHasErrors()}.
   * <ul>
   *   <li>Given {@link GenericResponse} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GenericResponse#getHasErrors()}
   */
  @Test
  public void testGetHasErrors_givenGenericResponse_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new GenericResponse()).getHasErrors());
  }

  /**
   * Test {@link GenericResponse#addErrorCode(String)} with {@code errorCode}.
   * <p>
   * Method under test: {@link GenericResponse#addErrorCode(String)}
   */
  @Test
  public void testAddErrorCodeWithErrorCode() {
    // Arrange and Act
    genericResponse.addErrorCode("An error occurred");

    // Assert
    List<String> errorCodesList = genericResponse.getErrorCodesList();
    assertEquals(1, errorCodesList.size());
    assertEquals("An error occurred", errorCodesList.get(0));
    assertTrue(genericResponse.getHasErrors());
  }

  /**
   * Test {@link GenericResponse#addErrorCode(String, List)} with
   * {@code errorCode}, {@code arguments}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GenericResponse#addErrorCode(String, List)}
   */
  @Test
  public void testAddErrorCodeWithErrorCodeArguments_given42_whenArrayListAdd42() {
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
   * Test {@link GenericResponse#addErrorCode(String, List)} with
   * {@code errorCode}, {@code arguments}.
   * <ul>
   *   <li>Given {@code foo}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GenericResponse#addErrorCode(String, List)}
   */
  @Test
  public void testAddErrorCodeWithErrorCodeArguments_givenFoo_whenArrayListAddFoo() {
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
   * Test {@link GenericResponse#addErrorCode(String, List)} with
   * {@code errorCode}, {@code arguments}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GenericResponse#addErrorCode(String, List)}
   */
  @Test
  public void testAddErrorCodeWithErrorCodeArguments_whenArrayList() {
    // Arrange and Act
    genericResponse.addErrorCode("An error occurred", new ArrayList<>());

    // Assert
    List<String> errorCodesList = genericResponse.getErrorCodesList();
    assertEquals(1, errorCodesList.size());
    assertEquals("An error occurred", errorCodesList.get(0));
    assertTrue(genericResponse.getHasErrors());
  }

  /**
   * Test {@link GenericResponse#getErrorCodeArguments(String)}.
   * <ul>
   *   <li>When {@code An error occurred}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GenericResponse#getErrorCodeArguments(String)}
   */
  @Test
  public void testGetErrorCodeArguments_whenAnErrorOccurred() {
    // Arrange, Act and Assert
    assertEquals(0, genericResponse.getErrorCodeArguments("An error occurred").length);
  }

  /**
   * Test {@link GenericResponse#getErrorCodeArguments(String)}.
   * <ul>
   *   <li>When {@code Error Code}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GenericResponse#getErrorCodeArguments(String)}
   */
  @Test
  public void testGetErrorCodeArguments_whenErrorCode() {
    // Arrange, Act and Assert
    assertEquals(0, genericResponse.getErrorCodeArguments("Error Code").length);
  }

  /**
   * Test getters and setters.
   * <p>
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
