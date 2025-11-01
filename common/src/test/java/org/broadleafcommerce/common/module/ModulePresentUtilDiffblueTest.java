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
package org.broadleafcommerce.common.module;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class ModulePresentUtilDiffblueTest {
  /**
   * Method under test:
   * {@link ModulePresentUtil#isPresent(BroadleafModuleRegistration.BroadleafModuleEnum)}
   */
  @Test
  public void testIsPresent() {
    // Arrange, Act and Assert
    assertFalse(ModulePresentUtil.isPresent(BroadleafModuleRegistration.BroadleafModuleEnum.ACCOUNT));
    assertFalse(ModulePresentUtil.isPresent("Module In Question"));
    assertTrue(ModulePresentUtil.isPresent("CommonTest"));
  }

  /**
   * Method under test: {@link ModulePresentUtil#allPresent(List)}
   */
  @Test
  public void testAllPresent() {
    // Arrange, Act and Assert
    assertTrue(ModulePresentUtil.allPresent(new ArrayList<>()));
  }

  /**
   * Method under test: {@link ModulePresentUtil#allPresent(List)}
   */
  @Test
  public void testAllPresent2() {
    // Arrange
    ArrayList<String> modulesInQuestion = new ArrayList<>();
    modulesInQuestion.add("foo");

    // Act and Assert
    assertFalse(ModulePresentUtil.allPresent(modulesInQuestion));
  }

  /**
   * Method under test: {@link ModulePresentUtil#allPresent(List)}
   */
  @Test
  public void testAllPresent3() {
    // Arrange
    ArrayList<String> modulesInQuestion = new ArrayList<>();
    modulesInQuestion.add("foo");
    modulesInQuestion.add("foo");

    // Act and Assert
    assertFalse(ModulePresentUtil.allPresent(modulesInQuestion));
  }

  /**
   * Method under test: {@link ModulePresentUtil#allPresent(List)}
   */
  @Test
  public void testAllPresent4() {
    // Arrange
    ArrayList<String> modulesInQuestion = new ArrayList<>();
    modulesInQuestion.add("CommonTest");

    // Act and Assert
    assertTrue(ModulePresentUtil.allPresent(modulesInQuestion));
  }

  /**
   * Method under test: {@link ModulePresentUtil#allPresent(List)}
   */
  @Test
  public void testAllPresent5() {
    // Arrange
    ArrayList<String> modulesInQuestion = new ArrayList<>();
    modulesInQuestion.add("");

    // Act and Assert
    assertFalse(ModulePresentUtil.allPresent(modulesInQuestion));
  }
}
