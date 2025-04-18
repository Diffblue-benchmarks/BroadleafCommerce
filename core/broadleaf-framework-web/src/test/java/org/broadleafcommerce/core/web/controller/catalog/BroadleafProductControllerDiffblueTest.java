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
package org.broadleafcommerce.core.web.controller.catalog;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.broadleafcommerce.common.audit.Auditable;
import org.broadleafcommerce.common.currency.domain.BroadleafCurrencyImpl;
import org.broadleafcommerce.common.file.service.StaticAssetPathService;
import org.broadleafcommerce.common.locale.domain.LocaleImpl;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.common.template.TemplateType;
import org.broadleafcommerce.core.catalog.domain.Product;
import org.broadleafcommerce.core.catalog.domain.ProductBundleImpl;
import org.broadleafcommerce.core.catalog.domain.SkuImpl;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.OrderImpl;
import org.broadleafcommerce.core.order.domain.OrderItem;
import org.broadleafcommerce.core.order.service.OrderItemService;
import org.broadleafcommerce.core.order.service.call.ConfigurableOrderItemRequest;
import org.broadleafcommerce.core.order.service.type.OrderStatus;
import org.broadleafcommerce.core.web.controller.catalog.BroadleafProductController.ResourceNotFoundException;
import org.broadleafcommerce.core.web.search.SearchRequestWrapper;
import org.broadleafcommerce.core.web.security.XssRequestWrapper;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.web.reactive.context.StandardReactiveWebEnvironment;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

@ExtendWith(MockitoExtension.class)
class BroadleafProductControllerDiffblueTest {
  @InjectMocks
  private BroadleafProductController broadleafProductController;

  @Mock
  private OrderItemService orderItemService;

  @Mock
  private StaticAssetPathService staticAssetPathService;

  /**
   * Test {@link BroadleafProductController#handleRequest(HttpServletRequest, HttpServletResponse)}.
   * <ul>
   *   <li>Then throw {@link ResourceNotFoundException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafProductController#handleRequest(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @DisplayName("Test handleRequest(HttpServletRequest, HttpServletResponse); then throw ResourceNotFoundException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.springframework.web.servlet.ModelAndView BroadleafProductController.handleRequest(HttpServletRequest, HttpServletResponse)"})
  void testHandleRequest_thenThrowResourceNotFoundException() throws Exception {
    // Arrange
    ConfigurableOrderItemRequest configurableOrderItemRequest = new ConfigurableOrderItemRequest();
    configurableOrderItemRequest.setAdditionalAttributes(new HashMap<>());
    configurableOrderItemRequest.setCategoryId(1L);
    configurableOrderItemRequest.setChildOrderItems(new ArrayList<>());
    configurableOrderItemRequest.setDiscountsAllowed(true);
    configurableOrderItemRequest.setDisplayPrice(new Money());
    configurableOrderItemRequest.setExpandable(true);
    configurableOrderItemRequest.setFirstExpandable(true);
    configurableOrderItemRequest.setHasConfigurationError(true);
    configurableOrderItemRequest.setHasOverridenPrice(true);
    configurableOrderItemRequest.setIsMultiSelect(true);
    configurableOrderItemRequest.setItemAttributes(new HashMap<>());
    configurableOrderItemRequest.setLastExpandable(true);
    configurableOrderItemRequest.setMaxQuantity(3);
    configurableOrderItemRequest.setMinQuantity(1);
    configurableOrderItemRequest.setOrderItemId(1L);
    configurableOrderItemRequest.setOrderItemIndex(1);
    configurableOrderItemRequest.setOverrideRetailPrice(new Money());
    configurableOrderItemRequest.setOverrideSalePrice(new Money());
    configurableOrderItemRequest.setParentOrderItemId(1L);
    configurableOrderItemRequest.setPricingModelType("Pricing Model Type");
    configurableOrderItemRequest.setProduct(new ProductBundleImpl());
    configurableOrderItemRequest.setProductChoices(new ArrayList<>());
    configurableOrderItemRequest.setProductId(1L);
    configurableOrderItemRequest.setQuantity(1);
    configurableOrderItemRequest.setSku(new SkuImpl());
    configurableOrderItemRequest.setSkuId(1L);
    when(orderItemService.findAllProductsInRequest(Mockito.<ConfigurableOrderItemRequest>any()))
        .thenReturn(new HashSet<>());
    when(orderItemService.createConfigurableOrderItemRequestFromProduct(Mockito.<Product>any()))
        .thenReturn(configurableOrderItemRequest);
    doNothing().when(orderItemService).modifyOrderItemRequest(Mockito.<ConfigurableOrderItemRequest>any());
    ProductBundleImpl productBundleImpl = mock(ProductBundleImpl.class);
    when(productBundleImpl.getDisplayTemplate())
        .thenThrow((new BroadleafProductController()).new ResourceNotFoundException());
    MockHttpServletRequest servletRequest = mock(MockHttpServletRequest.class);
    when(servletRequest.getAttribute(Mockito.<String>any())).thenReturn(productBundleImpl);
    doNothing().when(servletRequest).addParameter(Mockito.<String>any(), Mockito.<String>any());
    servletRequest.addParameter("https://example.org/example", "https://example.org/example");
    SearchRequestWrapper request = new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
        new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}));

    // Act and Assert
    assertThrows(ResourceNotFoundException.class,
        () -> broadleafProductController.handleRequest(request, new MockHttpServletResponse()));
    verify(productBundleImpl).getDisplayTemplate();
    verify(orderItemService).createConfigurableOrderItemRequestFromProduct(isA(Product.class));
    verify(orderItemService).findAllProductsInRequest(isA(ConfigurableOrderItemRequest.class));
    verify(orderItemService).modifyOrderItemRequest(isA(ConfigurableOrderItemRequest.class));
    verify(servletRequest).addParameter(eq("https://example.org/example"), eq("https://example.org/example"));
    verify(servletRequest).getAttribute(eq("currentProduct"));
  }

  /**
   * Test {@link BroadleafProductController#orderItemBelongsToCurrentCustomer(OrderItem)}.
   * <ul>
   *   <li>Given {@link Auditable} (default constructor) CreatedBy is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafProductController#orderItemBelongsToCurrentCustomer(OrderItem)}
   */
  @Test
  @DisplayName("Test orderItemBelongsToCurrentCustomer(OrderItem); given Auditable (default constructor) CreatedBy is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean BroadleafProductController.orderItemBelongsToCurrentCustomer(OrderItem)"})
  void testOrderItemBelongsToCurrentCustomer_givenAuditableCreatedByIsOne() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    OrderImpl orderImpl = new OrderImpl();
    orderImpl.setAdditionalOfferInformation(new HashMap<>());
    orderImpl.setAuditable(auditable);
    orderImpl.setCandidateOrderOffers(new ArrayList<>());
    orderImpl.setCurrency(new BroadleafCurrencyImpl());
    orderImpl.setCustomer(new CustomerImpl());
    orderImpl.setEmailAddress("42 Main St");
    orderImpl.setFulfillmentGroups(new ArrayList<>());
    orderImpl.setId(1L);
    orderImpl.setLocale(new LocaleImpl());
    orderImpl.setName("ThreadLocalManager.notify.orphans");
    orderImpl.setOrderAttributes(new HashMap<>());
    orderImpl.setOrderItems(new ArrayList<>());
    orderImpl.setOrderMessages(new ArrayList<>());
    orderImpl.setOrderNumber("42");
    orderImpl.setPayments(new ArrayList<>());
    orderImpl.setStatus(new OrderStatus("ThreadLocalManager.notify.orphans", "ThreadLocalManager.notify.orphans"));
    orderImpl.setSubTotal(new Money());
    orderImpl.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    orderImpl.setTaxOverride(true);
    orderImpl.setTotal(new Money());
    orderImpl.setTotalFulfillmentCharges(new Money());
    orderImpl.setTotalTax(new Money());
    OrderItem orderItem = mock(OrderItem.class);
    when(orderItem.getOrder()).thenReturn(orderImpl);

    // Act
    boolean actualOrderItemBelongsToCurrentCustomerResult = broadleafProductController
        .orderItemBelongsToCurrentCustomer(orderItem);

    // Assert
    verify(orderItem).getOrder();
    assertFalse(actualOrderItemBelongsToCurrentCustomerResult);
  }

  /**
   * Test {@link BroadleafProductController#orderItemBelongsToCurrentCustomer(OrderItem)}.
   * <ul>
   *   <li>Given {@link NullOrderImpl} (default constructor).</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafProductController#orderItemBelongsToCurrentCustomer(OrderItem)}
   */
  @Test
  @DisplayName("Test orderItemBelongsToCurrentCustomer(OrderItem); given NullOrderImpl (default constructor); then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean BroadleafProductController.orderItemBelongsToCurrentCustomer(OrderItem)"})
  void testOrderItemBelongsToCurrentCustomer_givenNullOrderImpl_thenReturnTrue() {
    // Arrange
    OrderItem orderItem = mock(OrderItem.class);
    when(orderItem.getOrder()).thenReturn(new NullOrderImpl());

    // Act
    boolean actualOrderItemBelongsToCurrentCustomerResult = broadleafProductController
        .orderItemBelongsToCurrentCustomer(orderItem);

    // Assert
    verify(orderItem).getOrder();
    assertTrue(actualOrderItemBelongsToCurrentCustomerResult);
  }

  /**
   * Test {@link BroadleafProductController#orderItemBelongsToCurrentCustomer(OrderItem)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafProductController#orderItemBelongsToCurrentCustomer(OrderItem)}
   */
  @Test
  @DisplayName("Test orderItemBelongsToCurrentCustomer(OrderItem); when 'null'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean BroadleafProductController.orderItemBelongsToCurrentCustomer(OrderItem)"})
  void testOrderItemBelongsToCurrentCustomer_whenNull_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(broadleafProductController.orderItemBelongsToCurrentCustomer(null));
  }

  /**
   * Test {@link BroadleafProductController#getTemplateType(HttpServletRequest)}.
   * <p>
   * Method under test: {@link BroadleafProductController#getTemplateType(HttpServletRequest)}
   */
  @Test
  @DisplayName("Test getTemplateType(HttpServletRequest)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TemplateType BroadleafProductController.getTemplateType(HttpServletRequest)"})
  void testGetTemplateType() {
    // Arrange
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();

    // Act
    TemplateType actualTemplateType = broadleafProductController
        .getTemplateType(new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
            new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"})));

    // Assert
    assertSame(actualTemplateType.PRODUCT, actualTemplateType);
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link BroadleafProductController}
   *   <li>{@link BroadleafProductController#setDefaultProductView(String)}
   *   <li>{@link BroadleafProductController#getDefaultProductView()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BroadleafProductController.<init>()",
      "String BroadleafProductController.getDefaultProductView()",
      "void BroadleafProductController.setDefaultProductView(String)"})
  void testGettersAndSetters() {
    // Arrange and Act
    BroadleafProductController actualBroadleafProductController = new BroadleafProductController();
    actualBroadleafProductController.setDefaultProductView("Default Product View");

    // Assert
    assertEquals("Default Product View", actualBroadleafProductController.getDefaultProductView());
  }

  /**
   * Test ResourceNotFoundException {@link ResourceNotFoundException#ResourceNotFoundException(BroadleafProductController)}.
   * <p>
   * Method under test: {@link ResourceNotFoundException#ResourceNotFoundException(BroadleafProductController)}
   */
  @Test
  @DisplayName("Test ResourceNotFoundException new ResourceNotFoundException(BroadleafProductController)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ResourceNotFoundException.<init>(BroadleafProductController)"})
  void testResourceNotFoundExceptionNewResourceNotFoundException() {
    // Arrange and Act
    ResourceNotFoundException actualResourceNotFoundException = (new BroadleafProductController()).new ResourceNotFoundException();

    // Assert
    assertNull(actualResourceNotFoundException.getMessage());
    assertNull(actualResourceNotFoundException.getCause());
    assertEquals(0, actualResourceNotFoundException.getSuppressed().length);
  }
}
