/*-
 * #%L
 * BroadleafCommerce Open Admin Platform
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
package org.broadleafcommerce.openadmin.server.service.persistence.validation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Map;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {RequiredIfPropertyValidator.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class RequiredIfPropertyValidatorDiffblueTest {
  @Autowired private RequiredIfPropertyValidator requiredIfPropertyValidator;

  /**
   * Test {@link RequiredIfPropertyValidator#lookupCompareFieldName(String, Map)}.
   *
   * <ul>
   *   <li>Given {@code compareField}.
   *   <li>Then return {@code .Validation Configuration}.
   * </ul>
   *
   * <p>Method under test: {@link RequiredIfPropertyValidator#lookupCompareFieldName(String, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String RequiredIfPropertyValidator.lookupCompareFieldName(String, Map)"})
  public void testLookupCompareFieldName_givenCompareField_thenReturnValidationConfiguration() {
    // Arrange
    HashMap<String, String> validationConfiguration = new HashMap<>();
    validationConfiguration.put("compareField", "Validation Configuration");

    // Act and Assert
    assertEquals(
        ".Validation Configuration",
        requiredIfPropertyValidator.lookupCompareFieldName(".", validationConfiguration));
  }

  /**
   * Test {@link RequiredIfPropertyValidator#lookupCompareFieldName(String, Map)}.
   *
   * <ul>
   *   <li>When {@code Current Field Name}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link RequiredIfPropertyValidator#lookupCompareFieldName(String, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String RequiredIfPropertyValidator.lookupCompareFieldName(String, Map)"})
  public void testLookupCompareFieldName_whenCurrentFieldName_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(
        requiredIfPropertyValidator.lookupCompareFieldName("Current Field Name", new HashMap<>()));
  }
}
