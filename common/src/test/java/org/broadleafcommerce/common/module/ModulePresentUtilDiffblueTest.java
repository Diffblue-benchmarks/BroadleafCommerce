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
package org.broadleafcommerce.common.module;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class ModulePresentUtilDiffblueTest {
  /**
   * Test {@link ModulePresentUtil#isPresent(BroadleafModuleEnum)} with
   * {@code BroadleafModuleEnum}.
   * <p>
   * Method under test:
   * {@link ModulePresentUtil#isPresent(BroadleafModuleRegistration.BroadleafModuleEnum)}
   */
  @Test
  public void testIsPresentWithBroadleafModuleEnum() {
    // Arrange, Act and Assert
    assertFalse(ModulePresentUtil.isPresent(BroadleafModuleRegistration.BroadleafModuleEnum.ACCOUNT));
  }

  /**
   * Test {@link ModulePresentUtil#isPresent(String)} with {@code String}.
   * <ul>
   *   <li>When {@code CommonTest}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ModulePresentUtil#isPresent(String)}
   */
  @Test
  public void testIsPresentWithString_whenCommonTest_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(ModulePresentUtil.isPresent("CommonTest"));
  }

  /**
   * Test {@link ModulePresentUtil#isPresent(String)} with {@code String}.
   * <ul>
   *   <li>When {@code Module In Question}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ModulePresentUtil#isPresent(String)}
   */
  @Test
  public void testIsPresentWithString_whenModuleInQuestion_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(ModulePresentUtil.isPresent("Module In Question"));
  }

  /**
   * Test {@link ModulePresentUtil#allPresent(List)}.
   * <ul>
   *   <li>Given {@code CommonTest}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code CommonTest}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ModulePresentUtil#allPresent(List)}
   */
  @Test
  public void testAllPresent_givenCommonTest_whenArrayListAddCommonTest_thenReturnTrue() {
    // Arrange
    ArrayList<String> modulesInQuestion = new ArrayList<>();
    modulesInQuestion.add("CommonTest");

    // Act and Assert
    assertTrue(ModulePresentUtil.allPresent(modulesInQuestion));
  }

  /**
   * Test {@link ModulePresentUtil#allPresent(List)}.
   * <ul>
   *   <li>Given empty string.</li>
   *   <li>When {@link ArrayList#ArrayList()} add empty string.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ModulePresentUtil#allPresent(List)}
   */
  @Test
  public void testAllPresent_givenEmptyString_whenArrayListAddEmptyString_thenReturnFalse() {
    // Arrange
    ArrayList<String> modulesInQuestion = new ArrayList<>();
    modulesInQuestion.add("");

    // Act and Assert
    assertFalse(ModulePresentUtil.allPresent(modulesInQuestion));
  }

  /**
   * Test {@link ModulePresentUtil#allPresent(List)}.
   * <ul>
   *   <li>Given {@code foo}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code foo}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ModulePresentUtil#allPresent(List)}
   */
  @Test
  public void testAllPresent_givenFoo_whenArrayListAddFoo_thenReturnFalse() {
    // Arrange
    ArrayList<String> modulesInQuestion = new ArrayList<>();
    modulesInQuestion.add("foo");

    // Act and Assert
    assertFalse(ModulePresentUtil.allPresent(modulesInQuestion));
  }

  /**
   * Test {@link ModulePresentUtil#allPresent(List)}.
   * <ul>
   *   <li>Given {@code foo}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code foo}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ModulePresentUtil#allPresent(List)}
   */
  @Test
  public void testAllPresent_givenFoo_whenArrayListAddFoo_thenReturnFalse2() {
    // Arrange
    ArrayList<String> modulesInQuestion = new ArrayList<>();
    modulesInQuestion.add("foo");
    modulesInQuestion.add("foo");

    // Act and Assert
    assertFalse(ModulePresentUtil.allPresent(modulesInQuestion));
  }

  /**
   * Test {@link ModulePresentUtil#allPresent(List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ModulePresentUtil#allPresent(List)}
   */
  @Test
  public void testAllPresent_whenArrayList_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(ModulePresentUtil.allPresent(new ArrayList<>()));
  }
}
