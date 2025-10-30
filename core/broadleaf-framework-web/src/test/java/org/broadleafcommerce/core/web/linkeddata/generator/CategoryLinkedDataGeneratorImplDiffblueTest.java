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

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
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
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.core.env.Environment;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.multipart.support.DefaultMultipartHttpServletRequest;

@ExtendWith(MockitoExtension.class)
class CategoryLinkedDataGeneratorImplDiffblueTest {
  @InjectMocks
  private CategoryLinkedDataGeneratorImpl categoryLinkedDataGeneratorImpl;

  @Mock
  private Environment environment;

  /**
   * Test {@link CategoryLinkedDataGeneratorImpl#canHandle(HttpServletRequest)}.
   * <ul>
   *   <li>Given {@code Attribute}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryLinkedDataGeneratorImpl#canHandle(HttpServletRequest)}
   */
  @Test
  @DisplayName("Test canHandle(HttpServletRequest); given 'Attribute'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean CategoryLinkedDataGeneratorImpl.canHandle(HttpServletRequest)"})
  void testCanHandle_givenAttribute_thenReturnTrue() {
    // Arrange
    DefaultMultipartHttpServletRequest servletRequest = mock(DefaultMultipartHttpServletRequest.class);
    when(servletRequest.getAttribute(Mockito.<String>any())).thenReturn("Attribute");

    // Act
    boolean actualCanHandleResult = categoryLinkedDataGeneratorImpl.canHandle(new SearchRequestWrapper(
        new XssRequestWrapper(servletRequest, environment, new String[]{"White List Param Names"})));

    // Assert
    verify(servletRequest).getAttribute(eq("category"));
    assertTrue(actualCanHandleResult);
  }

  /**
   * Test {@link CategoryLinkedDataGeneratorImpl#canHandle(HttpServletRequest)}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryLinkedDataGeneratorImpl#canHandle(HttpServletRequest)}
   */
  @Test
  @DisplayName("Test canHandle(HttpServletRequest); then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean CategoryLinkedDataGeneratorImpl.canHandle(HttpServletRequest)"})
  void testCanHandle_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(categoryLinkedDataGeneratorImpl.canHandle(new SearchRequestWrapper(
        new XssRequestWrapper(new MockHttpServletRequest(), environment, new String[]{"White List Param Names"}))));
  }
}
