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

import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.common.exception.ServiceException;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class RegexPropertyValidatorDiffblueTest {
  @InjectMocks private RegexPropertyValidator regexPropertyValidator;

  /**
   * Test {@link RegexPropertyValidator#initExploitProtectionService()}.
   *
   * <p>Method under test: {@link RegexPropertyValidator#initExploitProtectionService()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.broadleafcommerce.common.security.service.ExploitProtectionService RegexPropertyValidator.initExploitProtectionService()"
  })
  public void testInitExploitProtectionService() throws ServiceException {
    // Arrange, Act and Assert
    assertThrows(
        ServiceException.class, () -> regexPropertyValidator.initExploitProtectionService());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RegexPropertyValidator#setSucceedForInvalidRegex(boolean)}
   *   <li>{@link RegexPropertyValidator#setSucceedForNullValues(boolean)}
   *   <li>{@link RegexPropertyValidator#isSucceedForInvalidRegex()}
   *   <li>{@link RegexPropertyValidator#isSucceedForNullValues()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RegexPropertyValidator.isSucceedForInvalidRegex()",
    "boolean RegexPropertyValidator.isSucceedForNullValues()",
    "void RegexPropertyValidator.setSucceedForInvalidRegex(boolean)",
    "void RegexPropertyValidator.setSucceedForNullValues(boolean)"
  })
  public void testGettersAndSetters() {
    // Arrange
    RegexPropertyValidator regexPropertyValidator = new RegexPropertyValidator();

    // Act
    regexPropertyValidator.setSucceedForInvalidRegex(true);
    regexPropertyValidator.setSucceedForNullValues(true);
    boolean actualIsSucceedForInvalidRegexResult =
        regexPropertyValidator.isSucceedForInvalidRegex();

    // Assert
    assertTrue(actualIsSucceedForInvalidRegexResult);
    assertTrue(regexPropertyValidator.isSucceedForNullValues());
  }
}
