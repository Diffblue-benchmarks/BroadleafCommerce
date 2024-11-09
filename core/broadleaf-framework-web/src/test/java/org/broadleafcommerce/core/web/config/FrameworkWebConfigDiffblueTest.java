/*-
 * #%L
 * BroadleafCommerce Framework Web
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
package org.broadleafcommerce.core.web.config;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.List;
import org.broadleafcommerce.core.web.seo.BasicSeoPropertyGeneratorImpl;
import org.broadleafcommerce.core.web.seo.SeoPropertyGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.ListFactoryBean;

class FrameworkWebConfigDiffblueTest {
  /**
   * Test
   * {@link FrameworkWebConfig#blSeoPropertyGenerators(BasicSeoPropertyGeneratorImpl)}.
   * <ul>
   *   <li>Then first return {@link BasicSeoPropertyGeneratorImpl}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FrameworkWebConfig#blSeoPropertyGenerators(BasicSeoPropertyGeneratorImpl)}
   */
  @Test
  @DisplayName("Test blSeoPropertyGenerators(BasicSeoPropertyGeneratorImpl); then first return BasicSeoPropertyGeneratorImpl")
  void testBlSeoPropertyGenerators_thenFirstReturnBasicSeoPropertyGeneratorImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FrameworkWebConfig frameworkWebConfig = new FrameworkWebConfig();
    BasicSeoPropertyGeneratorImpl basicSeo = new BasicSeoPropertyGeneratorImpl();

    // Act
    List<SeoPropertyGenerator> actualBlSeoPropertyGeneratorsResult = frameworkWebConfig
        .blSeoPropertyGenerators(basicSeo);

    // Assert
    assertEquals(1, actualBlSeoPropertyGeneratorsResult.size());
    SeoPropertyGenerator getResult = actualBlSeoPropertyGeneratorsResult.get(0);
    assertTrue(getResult instanceof BasicSeoPropertyGeneratorImpl);
    assertSame(basicSeo, getResult);
  }

  /**
   * Test
   * {@link FrameworkWebConfig#blSeoPropertyGenerators(BasicSeoPropertyGeneratorImpl)}.
   * <ul>
   *   <li>Then return first is {@link BasicSeoPropertyGeneratorImpl}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FrameworkWebConfig#blSeoPropertyGenerators(BasicSeoPropertyGeneratorImpl)}
   */
  @Test
  @DisplayName("Test blSeoPropertyGenerators(BasicSeoPropertyGeneratorImpl); then return first is BasicSeoPropertyGeneratorImpl")
  void testBlSeoPropertyGenerators_thenReturnFirstIsBasicSeoPropertyGeneratorImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicSeoPropertyGeneratorImpl basicSeo = mock(BasicSeoPropertyGeneratorImpl.class);

    // Act
    List<SeoPropertyGenerator> actualBlSeoPropertyGeneratorsResult = (new FrameworkWebConfig())
        .blSeoPropertyGenerators(basicSeo);

    // Assert
    assertEquals(1, actualBlSeoPropertyGeneratorsResult.size());
    assertSame(basicSeo, actualBlSeoPropertyGeneratorsResult.get(0));
  }

  /**
   * Test {@link FrameworkWebConfig#blCookieRuleConfigs()}.
   * <p>
   * Method under test: {@link FrameworkWebConfig#blCookieRuleConfigs()}
   */
  @Test
  @DisplayName("Test blCookieRuleConfigs()")
  void testBlCookieRuleConfigs() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    ListFactoryBean actualBlCookieRuleConfigsResult = (new FrameworkWebConfig()).blCookieRuleConfigs();

    // Assert
    assertTrue(actualBlCookieRuleConfigsResult.isSingleton());
    Class<List> expectedObjectType = List.class;
    assertEquals(expectedObjectType, actualBlCookieRuleConfigsResult.getObjectType());
  }
}
