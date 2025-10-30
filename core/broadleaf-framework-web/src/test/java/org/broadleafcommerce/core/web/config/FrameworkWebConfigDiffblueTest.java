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
package org.broadleafcommerce.core.web.config;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.List;
import org.broadleafcommerce.core.web.seo.BasicSeoPropertyGeneratorImpl;
import org.broadleafcommerce.core.web.seo.SeoPropertyGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.ListFactoryBean;

class FrameworkWebConfigDiffblueTest {
  /**
   * Test {@link FrameworkWebConfig#blSeoPropertyGenerators(BasicSeoPropertyGeneratorImpl)}.
   * <p>
   * Method under test: {@link FrameworkWebConfig#blSeoPropertyGenerators(BasicSeoPropertyGeneratorImpl)}
   */
  @Test
  @DisplayName("Test blSeoPropertyGenerators(BasicSeoPropertyGeneratorImpl)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List FrameworkWebConfig.blSeoPropertyGenerators(BasicSeoPropertyGeneratorImpl)"})
  void testBlSeoPropertyGenerators() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

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
   * Test {@link FrameworkWebConfig#blCookieRuleConfigs()}.
   * <p>
   * Method under test: {@link FrameworkWebConfig#blCookieRuleConfigs()}
   */
  @Test
  @DisplayName("Test blCookieRuleConfigs()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ListFactoryBean FrameworkWebConfig.blCookieRuleConfigs()"})
  void testBlCookieRuleConfigs() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange and Act
    ListFactoryBean actualBlCookieRuleConfigsResult = (new FrameworkWebConfig()).blCookieRuleConfigs();

    // Assert
    assertTrue(actualBlCookieRuleConfigsResult.isSingleton());
    Class<List> expectedObjectType = List.class;
    assertEquals(expectedObjectType, actualBlCookieRuleConfigsResult.getObjectType());
  }
}
