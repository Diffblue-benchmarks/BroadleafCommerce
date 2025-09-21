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
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import org.broadleafcommerce.core.catalog.domain.CategoryImpl;
import org.broadleafcommerce.core.catalog.domain.Product;
import org.broadleafcommerce.core.catalog.service.CatalogService;
import org.broadleafcommerce.core.web.search.SearchRequestWrapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.multipart.support.DefaultMultipartHttpServletRequest;

@ExtendWith(MockitoExtension.class)
class CategoryLinkedDataGeneratorImplDiffblueTest {
  @Mock private CatalogService catalogService;

  @InjectMocks private CategoryLinkedDataGeneratorImpl categoryLinkedDataGeneratorImpl;

  /**
   * Test {@link CategoryLinkedDataGeneratorImpl#canHandle(HttpServletRequest)}.
   *
   * <ul>
   *   <li>Given {@code Attribute}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link CategoryLinkedDataGeneratorImpl#canHandle(HttpServletRequest)}
   */
  @Test
  @DisplayName("Test canHandle(HttpServletRequest); given 'Attribute'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CategoryLinkedDataGeneratorImpl.canHandle(HttpServletRequest)"})
  void testCanHandle_givenAttribute_thenReturnTrue() {
    // Arrange
    DefaultMultipartHttpServletRequest servletRequest =
        mock(DefaultMultipartHttpServletRequest.class);
    when(servletRequest.getAttribute(Mockito.<String>any())).thenReturn("Attribute");
    SearchRequestWrapper request = new SearchRequestWrapper(servletRequest);

    // Act
    boolean actualCanHandleResult =
        categoryLinkedDataGeneratorImpl.canHandle(new HttpServletRequestWrapper(request));

    // Assert
    verify(servletRequest).getAttribute("category");
    assertTrue(actualCanHandleResult);
  }

  /**
   * Test {@link CategoryLinkedDataGeneratorImpl#canHandle(HttpServletRequest)}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link CategoryLinkedDataGeneratorImpl#canHandle(HttpServletRequest)}
   */
  @Test
  @DisplayName("Test canHandle(HttpServletRequest); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CategoryLinkedDataGeneratorImpl.canHandle(HttpServletRequest)"})
  void testCanHandle_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(
        categoryLinkedDataGeneratorImpl.canHandle(
            new HttpServletRequestWrapper(new SearchRequestWrapper(new MockHttpServletRequest()))));
  }

  /**
   * Test {@link CategoryLinkedDataGeneratorImpl#getProducts(HttpServletRequest)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link CategoryLinkedDataGeneratorImpl#getProducts(HttpServletRequest)}
   */
  @Test
  @DisplayName("Test getProducts(HttpServletRequest); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List CategoryLinkedDataGeneratorImpl.getProducts(HttpServletRequest)"})
  void testGetProducts_thenReturnEmpty() throws UnsupportedEncodingException {
    // Arrange
    when(catalogService.findCategoryById(Mockito.<Long>any())).thenReturn(new CategoryImpl());

    MockHttpServletRequest servletRequest = mock(MockHttpServletRequest.class);
    doNothing().when(servletRequest).setCharacterEncoding(Mockito.<String>any());
    when(servletRequest.getAttribute(Mockito.<String>any())).thenReturn(new CategoryImpl());
    doNothing().when(servletRequest).addParameter(Mockito.<String>any(), Mockito.<String>any());
    doNothing().when(servletRequest).setAttribute(Mockito.<String>any(), Mockito.<Object>any());
    servletRequest.addParameter("category", "42");

    SearchRequestWrapper request = new SearchRequestWrapper(servletRequest);
    request.setCharacterEncoding("category");
    request.setAttribute("category", "42");

    // Act
    List<Product> actualProducts =
        categoryLinkedDataGeneratorImpl.getProducts(new HttpServletRequestWrapper(request));

    // Assert
    verify(catalogService).findCategoryById(isNull());
    verify(servletRequest).addParameter("category", "42");
    verify(servletRequest).getAttribute("category");
    verify(servletRequest).setAttribute(eq("category"), isA(Object.class));
    verify(servletRequest).setCharacterEncoding("category");
    assertTrue(actualProducts.isEmpty());
  }
}
