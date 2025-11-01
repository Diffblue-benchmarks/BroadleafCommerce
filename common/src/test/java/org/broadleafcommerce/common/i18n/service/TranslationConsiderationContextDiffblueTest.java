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
package org.broadleafcommerce.common.i18n.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import org.junit.Test;

public class TranslationConsiderationContextDiffblueTest {
  /**
   * Method under test:
   * {@link TranslationConsiderationContext#getTranslationConsiderationContext()}
   */
  @Test
  public void testGetTranslationConsiderationContext() {
    // Arrange and Act
    TranslationConsiderationContext actualTranslationConsiderationContext = TranslationConsiderationContext
        .getTranslationConsiderationContext();

    // Assert
    assertNull(actualTranslationConsiderationContext.service);
    assertFalse(actualTranslationConsiderationContext.enabled);
  }

  /**
   * Method under test: {@link TranslationConsiderationContext#hasTranslation()}
   */
  @Test
  public void testHasTranslation() {
    // Arrange, Act and Assert
    assertFalse(TranslationConsiderationContext.hasTranslation());
  }

  /**
   * Method under test:
   * {@link TranslationConsiderationContext#isTranslationConsiderationContextEnabled()}
   */
  @Test
  public void testIsTranslationConsiderationContextEnabled() {
    // Arrange, Act and Assert
    assertFalse(TranslationConsiderationContext.isTranslationConsiderationContextEnabled());
  }

  /**
   * Method under test:
   * {@link TranslationConsiderationContext#getTranslationService()}
   */
  @Test
  public void testGetTranslationService() {
    // Arrange, Act and Assert
    assertNull(TranslationConsiderationContext.getTranslationService());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link TranslationConsiderationContext}
   */
  @Test
  public void testNewTranslationConsiderationContext() {
    // Arrange and Act
    TranslationConsiderationContext actualTranslationConsiderationContext = new TranslationConsiderationContext();

    // Assert
    assertNull(actualTranslationConsiderationContext.service);
    assertFalse(actualTranslationConsiderationContext.enabled);
  }
}
