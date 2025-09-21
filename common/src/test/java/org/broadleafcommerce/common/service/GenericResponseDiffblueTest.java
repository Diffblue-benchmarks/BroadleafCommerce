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

@ContextConfiguration(classes = {GenericResponse.class})
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(SpringJUnit4ClassRunner.class)
public class GenericResponseDiffblueTest {
  @Autowired private GenericResponse genericResponse;

  /**
   * Test {@link GenericResponse#getHasErrors()}.
   *
   * <ul>
   *   <li>Given {@link GenericResponse} (default constructor) addErrorCode {@code An error
   *       occurred}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link GenericResponse#getHasErrors()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean GenericResponse.getHasErrors()"})
  public void testGetHasErrors_givenGenericResponseAddErrorCodeAnErrorOccurred_thenReturnTrue() {
    // Arrange
    GenericResponse genericResponse = new GenericResponse();
    genericResponse.addErrorCode("An error occurred");

    // Act and Assert
    assertTrue(genericResponse.getHasErrors());
  }

  /**
   * Test {@link GenericResponse#getHasErrors()}.
   *
   * <ul>
   *   <li>Given {@link GenericResponse} (default constructor).
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link GenericResponse#getHasErrors()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean GenericResponse.getHasErrors()"})
  public void testGetHasErrors_givenGenericResponse_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new GenericResponse().getHasErrors());
  }

  /**
   * Test {@link GenericResponse#addErrorCode(String)} with {@code errorCode}.
   *
   * <p>Method under test: {@link GenericResponse#addErrorCode(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void GenericResponse.addErrorCode(String)"})
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
   * Test {@link GenericResponse#addErrorCode(String, List)} with {@code errorCode}, {@code
   * arguments}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link GenericResponse#addErrorCode(String, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void GenericResponse.addErrorCode(String, List)"})
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
   * Test {@link GenericResponse#addErrorCode(String, List)} with {@code errorCode}, {@code
   * arguments}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link GenericResponse#addErrorCode(String, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void GenericResponse.addErrorCode(String, List)"})
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
   * Test {@link GenericResponse#addErrorCode(String, List)} with {@code errorCode}, {@code
   * arguments}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link GenericResponse#addErrorCode(String, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void GenericResponse.addErrorCode(String, List)"})
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
   *
   * <ul>
   *   <li>Given {@link GenericResponse}.
   *   <li>When {@code An error occurred}.
   * </ul>
   *
   * <p>Method under test: {@link GenericResponse#getErrorCodeArguments(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Object[] GenericResponse.getErrorCodeArguments(String)"})
  public void testGetErrorCodeArguments_givenGenericResponse_whenAnErrorOccurred() {
    // Arrange, Act and Assert
    assertEquals(0, genericResponse.getErrorCodeArguments("An error occurred").length);
  }

  /**
   * Test {@link GenericResponse#getErrorCodeArguments(String)}.
   *
   * <ul>
   *   <li>Given {@link GenericResponse}.
   *   <li>When {@code Error Code}.
   * </ul>
   *
   * <p>Method under test: {@link GenericResponse#getErrorCodeArguments(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Object[] GenericResponse.getErrorCodeArguments(String)"})
  public void testGetErrorCodeArguments_givenGenericResponse_whenErrorCode() {
    // Arrange, Act and Assert
    assertEquals(0, genericResponse.getErrorCodeArguments("Error Code").length);
  }

  /**
   * Test {@link GenericResponse#getErrorCodeArguments(String)}.
   *
   * <ul>
   *   <li>Then return {@code String[]}.
   * </ul>
   *
   * <p>Method under test: {@link GenericResponse#getErrorCodeArguments(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Object[] GenericResponse.getErrorCodeArguments(String)"})
  public void testGetErrorCodeArguments_thenReturnString() {
    // Arrange
    GenericResponse genericResponse = new GenericResponse();
    genericResponse.addErrorCode("An error occurred");

    // Act
    Object[] actualErrorCodeArguments = genericResponse.getErrorCodeArguments("An error occurred");

    // Assert
    assertTrue(actualErrorCodeArguments instanceof String[]);
    assertEquals(0, actualErrorCodeArguments.length);
  }

  /**
   * Test new {@link GenericResponse} (default constructor).
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link GenericResponse}
   *   <li>{@link GenericResponse#getErrorCodesList()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void GenericResponse.<init>()", "List GenericResponse.getErrorCodesList()"})
  public void testNewGenericResponse() {
    // Arrange, Act and Assert
    assertTrue(new GenericResponse().getErrorCodesList().isEmpty());
  }
}
