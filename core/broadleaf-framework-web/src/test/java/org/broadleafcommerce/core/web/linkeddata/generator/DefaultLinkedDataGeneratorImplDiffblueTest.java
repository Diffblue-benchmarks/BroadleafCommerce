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

import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import javax.servlet.http.HttpServletRequest;
import org.broadleafcommerce.core.web.search.SearchRequestWrapper;
import org.broadleafcommerce.core.web.security.XssRequestWrapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.core.env.Environment;
import org.springframework.mock.web.MockHttpServletRequest;

@ExtendWith(MockitoExtension.class)
class DefaultLinkedDataGeneratorImplDiffblueTest {
  @InjectMocks
  private DefaultLinkedDataGeneratorImpl defaultLinkedDataGeneratorImpl;

  @Mock
  private Environment environment;

  /**
   * Test {@link DefaultLinkedDataGeneratorImpl#canHandle(HttpServletRequest)}.
   * <p>
   * Method under test: {@link DefaultLinkedDataGeneratorImpl#canHandle(HttpServletRequest)}
   */
  @Test
  @DisplayName("Test canHandle(HttpServletRequest)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DefaultLinkedDataGeneratorImpl.canHandle(HttpServletRequest)"})
  void testCanHandle() {
    // Arrange, Act and Assert
    assertTrue(defaultLinkedDataGeneratorImpl.canHandle(new SearchRequestWrapper(
        new XssRequestWrapper(new MockHttpServletRequest(), environment, new String[]{"White List Param Names"}))));
  }
}
