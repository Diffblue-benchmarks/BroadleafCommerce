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
package org.broadleafcommerce.common.i18n.dao;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import org.broadleafcommerce.common.i18n.domain.Translation;
import org.broadleafcommerce.common.i18n.domain.TranslationImpl;
import org.broadleafcommerce.common.util.dao.DynamicDaoHelper;
import org.broadleafcommerce.common.util.dao.DynamicDaoHelperImpl;
import org.junit.Test;

public class TranslationDaoImplDiffblueTest {
  /**
   * Test {@link TranslationDaoImpl#findBestTranslation(String, List)}.
   * <ul>
   *   <li>Then calls {@link TranslationImpl#getLocaleCode()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TranslationDaoImpl#findBestTranslation(String, List)}
   */
  @Test
  public void testFindBestTranslation_thenCallsGetLocaleCode() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TranslationDaoImpl translationDaoImpl = new TranslationDaoImpl();
    TranslationImpl translationImpl = mock(TranslationImpl.class);
    when(translationImpl.getLocaleCode()).thenReturn("en");

    ArrayList<Translation> translations = new ArrayList<>();
    translations.add(translationImpl);

    // Act
    translationDaoImpl.findBestTranslation("en", translations);

    // Assert
    verify(translationImpl).getLocaleCode();
  }

  /**
   * Test {@link TranslationDaoImpl#findBestTranslation(String, List)}.
   * <ul>
   *   <li>When {@code Specific Locale}.</li>
   *   <li>Then calls {@link TranslationImpl#getLocaleCode()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TranslationDaoImpl#findBestTranslation(String, List)}
   */
  @Test
  public void testFindBestTranslation_whenSpecificLocale_thenCallsGetLocaleCode() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TranslationDaoImpl translationDaoImpl = new TranslationDaoImpl();
    TranslationImpl translationImpl = mock(TranslationImpl.class);
    when(translationImpl.getLocaleCode()).thenReturn("en");

    ArrayList<Translation> translations = new ArrayList<>();
    translations.add(translationImpl);

    // Act
    translationDaoImpl.findBestTranslation("Specific Locale", translations);

    // Assert
    verify(translationImpl).getLocaleCode();
  }

  /**
   * Test {@link TranslationDaoImpl#findSpecificTranslation(String, List)}.
   * <ul>
   *   <li>Then calls {@link TranslationImpl#getLocaleCode()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TranslationDaoImpl#findSpecificTranslation(String, List)}
   */
  @Test
  public void testFindSpecificTranslation_thenCallsGetLocaleCode() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TranslationDaoImpl translationDaoImpl = new TranslationDaoImpl();
    TranslationImpl translationImpl = mock(TranslationImpl.class);
    when(translationImpl.getLocaleCode()).thenReturn("en");

    ArrayList<Translation> translations = new ArrayList<>();
    translations.add(translationImpl);

    // Act
    translationDaoImpl.findSpecificTranslation("en", translations);

    // Assert
    verify(translationImpl).getLocaleCode();
  }

  /**
   * Test {@link TranslationDaoImpl#findSpecificTranslation(String, List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TranslationDaoImpl#findSpecificTranslation(String, List)}
   */
  @Test
  public void testFindSpecificTranslation_whenArrayList_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TranslationDaoImpl translationDaoImpl = new TranslationDaoImpl();

    // Act and Assert
    assertNull(translationDaoImpl.findSpecificTranslation("en", new ArrayList<>()));
  }

  /**
   * Test {@link TranslationDaoImpl#findSpecificTranslation(String, List)}.
   * <ul>
   *   <li>When {@code GB}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TranslationDaoImpl#findSpecificTranslation(String, List)}
   */
  @Test
  public void testFindSpecificTranslation_whenGb_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TranslationDaoImpl translationDaoImpl = new TranslationDaoImpl();
    TranslationImpl translationImpl = mock(TranslationImpl.class);
    when(translationImpl.getLocaleCode()).thenReturn("en");

    ArrayList<Translation> translations = new ArrayList<>();
    translations.add(translationImpl);

    // Act
    Translation actualFindSpecificTranslationResult = translationDaoImpl.findSpecificTranslation("GB", translations);

    // Assert
    verify(translationImpl).getLocaleCode();
    assertNull(actualFindSpecificTranslationResult);
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TranslationDaoImpl#setDynamicDaoHelper(DynamicDaoHelper)}
   *   <li>{@link TranslationDaoImpl#getDynamicDaoHelper()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    TranslationDaoImpl translationDaoImpl = new TranslationDaoImpl();
    DynamicDaoHelperImpl dynamicDaoHelper = new DynamicDaoHelperImpl();

    // Act
    translationDaoImpl.setDynamicDaoHelper(dynamicDaoHelper);
    DynamicDaoHelper actualDynamicDaoHelper = translationDaoImpl.getDynamicDaoHelper();

    // Assert that nothing has changed
    assertTrue(actualDynamicDaoHelper instanceof DynamicDaoHelperImpl);
    assertSame(dynamicDaoHelper, actualDynamicDaoHelper);
  }
}
