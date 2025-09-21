/*-
 * #%L
 * BroadleafCommerce Framework Web
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
package org.broadleafcommerce.core.web.linkeddata.generator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.common.web.BaseUrlResolver;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.core.env.Environment;

@ExtendWith(MockitoExtension.class)
class AbstractLinkedDataGeneratorDiffblueTest {
  @Mock private BaseUrlResolver baseUrlResolver;

  @InjectMocks private CategoryLinkedDataGeneratorImpl categoryLinkedDataGeneratorImpl;

  @Mock private Environment environment;

  /**
   * Test {@link AbstractLinkedDataGenerator#getSiteBaseUrl()}.
   *
   * <ul>
   *   <li>Then return {@code https://example.org/example}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractLinkedDataGenerator#getSiteBaseUrl()}
   */
  @Test
  @DisplayName("Test getSiteBaseUrl(); then return 'https://example.org/example'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String AbstractLinkedDataGenerator.getSiteBaseUrl()"})
  void testGetSiteBaseUrl_thenReturnHttpsExampleOrgExample() {
    // Arrange
    when(baseUrlResolver.getSiteBaseUrl()).thenReturn("https://example.org/example");

    // Act
    String actualSiteBaseUrl = categoryLinkedDataGeneratorImpl.getSiteBaseUrl();

    // Assert
    verify(baseUrlResolver).getSiteBaseUrl();
    assertEquals("https://example.org/example", actualSiteBaseUrl);
  }

  /**
   * Test {@link AbstractLinkedDataGenerator#getStructuredDataContext()}.
   *
   * <ul>
   *   <li>Then return {@code Property}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractLinkedDataGenerator#getStructuredDataContext()}
   */
  @Test
  @DisplayName("Test getStructuredDataContext(); then return 'Property'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String AbstractLinkedDataGenerator.getStructuredDataContext()"})
  void testGetStructuredDataContext_thenReturnProperty() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn("Property");

    // Act
    String actualStructuredDataContext = categoryLinkedDataGeneratorImpl.getStructuredDataContext();

    // Assert
    verify(environment).getProperty("structured.data.context", "http://schema.org/");
    assertEquals("Property", actualStructuredDataContext);
  }
}
