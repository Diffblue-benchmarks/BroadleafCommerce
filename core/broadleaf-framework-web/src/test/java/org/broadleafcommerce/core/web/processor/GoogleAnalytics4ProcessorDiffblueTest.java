package org.broadleafcommerce.core.web.processor;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import org.broadleafcommerce.common.audit.Auditable;
import org.broadleafcommerce.common.currency.domain.BroadleafCurrencyImpl;
import org.broadleafcommerce.common.locale.domain.LocaleImpl;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.core.catalog.domain.CategoryImpl;
import org.broadleafcommerce.core.order.domain.BundleOrderItemImpl;
import org.broadleafcommerce.core.order.domain.FulfillmentGroup;
import org.broadleafcommerce.core.order.domain.FulfillmentGroupImpl;
import org.broadleafcommerce.core.order.domain.FulfillmentGroupItemImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.order.domain.OrderImpl;
import org.broadleafcommerce.core.order.domain.OrderItem;
import org.broadleafcommerce.core.order.domain.OrderItemAttribute;
import org.broadleafcommerce.core.order.domain.OrderItemAttributeImpl;
import org.broadleafcommerce.core.order.service.type.OrderStatus;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class GoogleAnalytics4ProcessorDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link GoogleAnalytics4Processor#getName()}
   *   <li>{@link GoogleAnalytics4Processor#getPrecedence()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String GoogleAnalytics4Processor.getName()",
    "int GoogleAnalytics4Processor.getPrecedence()"
  })
  public void testGettersAndSetters() {
    // Arrange
    GoogleAnalytics4Processor googleAnalytics4Processor = new GoogleAnalytics4Processor();

    // Act
    String actualName = googleAnalytics4Processor.getName();

    // Assert
    assertEquals("google_analytics_4", actualName);
    assertEquals(0, googleAnalytics4Processor.getPrecedence());
  }

  /**
   * Test {@link GoogleAnalytics4Processor#getItemJs(Order)}.
   *
   * <p>Method under test: {@link GoogleAnalytics4Processor#getItemJs(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String GoogleAnalytics4Processor.getItemJs(Order)"})
  public void testGetItemJs() {
    // Arrange
    GoogleAnalytics4Processor googleAnalytics4Processor = new GoogleAnalytics4Processor();

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    fulfillmentGroupImpl.addFulfillmentGroupItem(new FulfillmentGroupItemImpl());

    ArrayList<FulfillmentGroup> fulfillmentGroups = new ArrayList<>();
    fulfillmentGroups.add(fulfillmentGroupImpl);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCurrency(new BroadleafCurrencyImpl());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setFulfillmentGroups(fulfillmentGroups);
    order.setId(1L);
    order.setLocale(new LocaleImpl());
    order.setName(",items:[");
    order.setOrderAttributes(new HashMap<>());
    order.setOrderItems(new ArrayList<>());
    order.setOrderMessages(new ArrayList<>());
    order.setOrderNumber("42");
    order.setPayments(new ArrayList<>());
    order.setStatus(new OrderStatus());
    order.setSubTotal(new Money());
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());

    // Act and Assert
    assertEquals(",items:[]", googleAnalytics4Processor.getItemJs(order));
  }

  /**
   * Test {@link GoogleAnalytics4Processor#getItemJs(Order)}.
   *
   * <ul>
   *   <li>Given {@link GoogleAnalytics4Processor} (default constructor).
   *   <li>Then return {@code ,items:[]}.
   * </ul>
   *
   * <p>Method under test: {@link GoogleAnalytics4Processor#getItemJs(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String GoogleAnalytics4Processor.getItemJs(Order)"})
  public void testGetItemJs_givenGoogleAnalytics4Processor_thenReturnItems() {
    // Arrange
    GoogleAnalytics4Processor googleAnalytics4Processor = new GoogleAnalytics4Processor();

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCurrency(new BroadleafCurrencyImpl());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setFulfillmentGroups(new ArrayList<>());
    order.setId(1L);
    order.setLocale(new LocaleImpl());
    order.setName(",items:[");
    order.setOrderAttributes(new HashMap<>());
    order.setOrderItems(new ArrayList<>());
    order.setOrderMessages(new ArrayList<>());
    order.setOrderNumber("42");
    order.setPayments(new ArrayList<>());
    order.setStatus(new OrderStatus());
    order.setSubTotal(new Money());
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());

    // Act and Assert
    assertEquals(",items:[]", googleAnalytics4Processor.getItemJs(order));
  }

  /**
   * Test {@link GoogleAnalytics4Processor#getItemJs(Order)}.
   *
   * <ul>
   *   <li>Given {@link GoogleAnalytics4Processor} (default constructor).
   *   <li>Then return {@code ,items:[]}.
   * </ul>
   *
   * <p>Method under test: {@link GoogleAnalytics4Processor#getItemJs(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String GoogleAnalytics4Processor.getItemJs(Order)"})
  public void testGetItemJs_givenGoogleAnalytics4Processor_thenReturnItems2() {
    // Arrange
    GoogleAnalytics4Processor googleAnalytics4Processor = new GoogleAnalytics4Processor();

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    ArrayList<FulfillmentGroup> fulfillmentGroups = new ArrayList<>();
    fulfillmentGroups.add(new FulfillmentGroupImpl());

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCurrency(new BroadleafCurrencyImpl());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setFulfillmentGroups(fulfillmentGroups);
    order.setId(1L);
    order.setLocale(new LocaleImpl());
    order.setName(",items:[");
    order.setOrderAttributes(new HashMap<>());
    order.setOrderItems(new ArrayList<>());
    order.setOrderMessages(new ArrayList<>());
    order.setOrderNumber("42");
    order.setPayments(new ArrayList<>());
    order.setStatus(new OrderStatus());
    order.setSubTotal(new Money());
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());

    // Act and Assert
    assertEquals(",items:[]", googleAnalytics4Processor.getItemJs(order));
  }

  /**
   * Test {@link GoogleAnalytics4Processor#getVariation(OrderItem)}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code name} is {@link OrderItemAttributeImpl} (default
   *       constructor).
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link GoogleAnalytics4Processor#getVariation(OrderItem)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String GoogleAnalytics4Processor.getVariation(OrderItem)"})
  public void testGetVariation_givenHashMapNameIsOrderItemAttributeImpl_thenReturnNull() {
    // Arrange
    GoogleAnalytics4Processor googleAnalytics4Processor = new GoogleAnalytics4Processor();

    HashMap<String, OrderItemAttribute> stringOrderItemAttributeMap = new HashMap<>();
    stringOrderItemAttributeMap.put("name", new OrderItemAttributeImpl());

    BundleOrderItemImpl item = mock(BundleOrderItemImpl.class);
    when(item.getOrderItemAttributes()).thenReturn(stringOrderItemAttributeMap);

    // Act
    String actualVariation = googleAnalytics4Processor.getVariation(item);

    // Assert
    verify(item, atLeast(1)).getOrderItemAttributes();
    assertEquals("null", actualVariation);
  }

  /**
   * Test {@link GoogleAnalytics4Processor#getVariation(OrderItem)}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()}.
   *   <li>Then calls {@link BundleOrderItemImpl#getCategory()}.
   * </ul>
   *
   * <p>Method under test: {@link GoogleAnalytics4Processor#getVariation(OrderItem)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String GoogleAnalytics4Processor.getVariation(OrderItem)"})
  public void testGetVariation_givenHashMap_thenCallsGetCategory() {
    // Arrange
    GoogleAnalytics4Processor googleAnalytics4Processor = new GoogleAnalytics4Processor();

    BundleOrderItemImpl item = mock(BundleOrderItemImpl.class);
    when(item.getOrderItemAttributes()).thenReturn(new HashMap<>());
    when(item.getCategory()).thenReturn(new CategoryImpl());

    // Act
    String actualVariation = googleAnalytics4Processor.getVariation(item);

    // Assert
    verify(item, atLeast(1)).getCategory();
    verify(item).getOrderItemAttributes();
    assertNull(actualVariation);
  }

  /**
   * Test {@link GoogleAnalytics4Processor#getVariation(OrderItem)}.
   *
   * <ul>
   *   <li>When {@link BundleOrderItemImpl} (default constructor).
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link GoogleAnalytics4Processor#getVariation(OrderItem)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String GoogleAnalytics4Processor.getVariation(OrderItem)"})
  public void testGetVariation_whenBundleOrderItemImpl_thenReturnEmptyString() {
    // Arrange
    GoogleAnalytics4Processor googleAnalytics4Processor = new GoogleAnalytics4Processor();

    // Act and Assert
    assertEquals("", googleAnalytics4Processor.getVariation(new BundleOrderItemImpl()));
  }
}
