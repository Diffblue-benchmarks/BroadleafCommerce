package org.broadleafcommerce.core.web.processor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.broadleafcommerce.common.audit.Auditable;
import org.broadleafcommerce.common.currency.domain.BroadleafCurrencyImpl;
import org.broadleafcommerce.common.locale.domain.LocaleImpl;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.core.catalog.domain.CategoryImpl;
import org.broadleafcommerce.core.order.domain.BundleOrderItemImpl;
import org.broadleafcommerce.core.order.domain.FulfillmentGroup;
import org.broadleafcommerce.core.order.domain.FulfillmentGroupImpl;
import org.broadleafcommerce.core.order.domain.FulfillmentGroupItemImpl;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.order.domain.OrderImpl;
import org.broadleafcommerce.core.order.domain.OrderItem;
import org.broadleafcommerce.core.order.domain.OrderItemAttribute;
import org.broadleafcommerce.core.order.domain.OrderItemAttributeImpl;
import org.broadleafcommerce.core.order.domain.OrderItemImpl;
import org.broadleafcommerce.core.order.service.type.OrderStatus;
import org.broadleafcommerce.presentation.model.BroadleafTemplateContext;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml",
    "/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml",
    "/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
@ExtendWith(SpringExtension.class)
class GoogleAnalytics4ProcessorDiffblueTest {
  @Autowired
  private GoogleAnalytics4Processor googleAnalytics4Processor;

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link GoogleAnalytics4Processor#getName()}
   *   <li>{@link GoogleAnalytics4Processor#getPrecedence()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange
    GoogleAnalytics4Processor googleAnalytics4Processor = new GoogleAnalytics4Processor();

    // Act
    String actualName = googleAnalytics4Processor.getName();

    // Assert
    assertEquals("google_analytics_4", actualName);
    assertEquals(0, googleAnalytics4Processor.getPrecedence());
  }

  /**
   * Test
   * {@link GoogleAnalytics4Processor#getReplacementModel(String, Map, BroadleafTemplateContext)}.
   * <p>
   * Method under test:
   * {@link GoogleAnalytics4Processor#getReplacementModel(String, Map, BroadleafTemplateContext)}
   */
  @Test
  @DisplayName("Test getReplacementModel(String, Map, BroadleafTemplateContext)")
  @Disabled("TODO: Complete this test")
  void testGetReplacementModel() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.processor;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass9978 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.processor.GoogleAnalytics4Processor googleAnalytics4Processor;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    GoogleAnalytics4Processor googleAnalytics4Processor2 = new GoogleAnalytics4Processor();

    // Act
    googleAnalytics4Processor2.getReplacementModel("Tag Name", new HashMap<>(), mock(BroadleafTemplateContext.class));
  }

  /**
   * Test {@link GoogleAnalytics4Processor#getTransactionJs(Order)}.
   * <p>
   * Method under test: {@link GoogleAnalytics4Processor#getTransactionJs(Order)}
   */
  @Test
  @DisplayName("Test getTransactionJs(Order)")
  @Disabled("TODO: Complete this test")
  void testGetTransactionJs() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.processor;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass9997 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.processor.GoogleAnalytics4Processor googleAnalytics4Processor;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    GoogleAnalytics4Processor googleAnalytics4Processor2 = new GoogleAnalytics4Processor();

    // Act
    googleAnalytics4Processor2.getTransactionJs(new NullOrderImpl());
  }

  /**
   * Test {@link GoogleAnalytics4Processor#getItemJs(Order)}.
   * <p>
   * Method under test: {@link GoogleAnalytics4Processor#getItemJs(Order)}
   */
  @Test
  @DisplayName("Test getItemJs(Order)")
  void testGetItemJs() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    GoogleAnalytics4Processor googleAnalytics4Processor = new GoogleAnalytics4Processor();

    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    fulfillmentGroupImpl.addFulfillmentGroupItem(new FulfillmentGroupItemImpl());

    ArrayList<FulfillmentGroup> fulfillmentGroupList = new ArrayList<>();
    fulfillmentGroupList.add(fulfillmentGroupImpl);
    NullOrderImpl order = mock(NullOrderImpl.class);
    when(order.getFulfillmentGroups()).thenReturn(fulfillmentGroupList);

    // Act
    String actualItemJs = googleAnalytics4Processor.getItemJs(order);

    // Assert
    verify(order).getFulfillmentGroups();
    assertEquals(",items:[]", actualItemJs);
  }

  /**
   * Test {@link GoogleAnalytics4Processor#getItemJs(Order)}.
   * <p>
   * Method under test: {@link GoogleAnalytics4Processor#getItemJs(Order)}
   */
  @Test
  @DisplayName("Test getItemJs(Order)")
  @Disabled("TODO: Complete this test")
  void testGetItemJs2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.processor;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass9966 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.processor.GoogleAnalytics4Processor googleAnalytics4Processor;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    GoogleAnalytics4Processor googleAnalytics4Processor2 = new GoogleAnalytics4Processor();

    // Act
    googleAnalytics4Processor2.getItemJs(new NullOrderImpl());
  }

  /**
   * Test {@link GoogleAnalytics4Processor#getItemJs(Order)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.</li>
   *   <li>Then calls {@link NullOrderImpl#getFulfillmentGroups()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GoogleAnalytics4Processor#getItemJs(Order)}
   */
  @Test
  @DisplayName("Test getItemJs(Order); given ArrayList(); then calls getFulfillmentGroups()")
  void testGetItemJs_givenArrayList_thenCallsGetFulfillmentGroups() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    GoogleAnalytics4Processor googleAnalytics4Processor = new GoogleAnalytics4Processor();
    NullOrderImpl order = mock(NullOrderImpl.class);
    when(order.getFulfillmentGroups()).thenReturn(new ArrayList<>());

    // Act
    String actualItemJs = googleAnalytics4Processor.getItemJs(order);

    // Assert
    verify(order).getFulfillmentGroups();
    assertEquals(",items:[]", actualItemJs);
  }

  /**
   * Test {@link GoogleAnalytics4Processor#getItemJs(Order)}.
   * <ul>
   *   <li>Given {@link Auditable} (default constructor) CreatedBy is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link GoogleAnalytics4Processor#getItemJs(Order)}
   */
  @Test
  @DisplayName("Test getItemJs(Order); given Auditable (default constructor) CreatedBy is one")
  void testGetItemJs_givenAuditableCreatedByIsOne() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    GoogleAnalytics4Processor googleAnalytics4Processor = new GoogleAnalytics4Processor();

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    order.setStatus(new OrderStatus(",items:[", ",items:["));
    order.setSubTotal(new Money());
    order.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalShipping(new Money());
    order.setTotalTax(new Money());

    // Act and Assert
    assertEquals(",items:[]", googleAnalytics4Processor.getItemJs(order));
  }

  /**
   * Test {@link GoogleAnalytics4Processor#getItemJs(Order)}.
   * <ul>
   *   <li>Then calls {@link NullOrderImpl#getFulfillmentGroups()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GoogleAnalytics4Processor#getItemJs(Order)}
   */
  @Test
  @DisplayName("Test getItemJs(Order); then calls getFulfillmentGroups()")
  void testGetItemJs_thenCallsGetFulfillmentGroups() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    GoogleAnalytics4Processor googleAnalytics4Processor = new GoogleAnalytics4Processor();

    ArrayList<FulfillmentGroup> fulfillmentGroupList = new ArrayList<>();
    fulfillmentGroupList.add(new FulfillmentGroupImpl());
    NullOrderImpl order = mock(NullOrderImpl.class);
    when(order.getFulfillmentGroups()).thenReturn(fulfillmentGroupList);

    // Act
    String actualItemJs = googleAnalytics4Processor.getItemJs(order);

    // Assert
    verify(order).getFulfillmentGroups();
    assertEquals(",items:[]", actualItemJs);
  }

  /**
   * Test {@link GoogleAnalytics4Processor#getVariation(OrderItem)}.
   * <p>
   * Method under test: {@link GoogleAnalytics4Processor#getVariation(OrderItem)}
   */
  @Test
  @DisplayName("Test getVariation(OrderItem)")
  @Disabled("TODO: Complete this test")
  void testGetVariation() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.processor;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass10009 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.processor.GoogleAnalytics4Processor googleAnalytics4Processor;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    GoogleAnalytics4Processor googleAnalytics4Processor2 = new GoogleAnalytics4Processor();

    // Act
    googleAnalytics4Processor2.getVariation(new BundleOrderItemImpl());
  }

  /**
   * Test {@link GoogleAnalytics4Processor#getVariation(OrderItem)}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code name} is
   * {@link OrderItemAttributeImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GoogleAnalytics4Processor#getVariation(OrderItem)}
   */
  @Test
  @DisplayName("Test getVariation(OrderItem); given HashMap() 'name' is OrderItemAttributeImpl (default constructor); then return 'null'")
  void testGetVariation_givenHashMapNameIsOrderItemAttributeImpl_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
   * <ul>
   *   <li>Given {@link HashMap#HashMap()}.</li>
   *   <li>Then calls {@link OrderItemImpl#getCategory()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GoogleAnalytics4Processor#getVariation(OrderItem)}
   */
  @Test
  @DisplayName("Test getVariation(OrderItem); given HashMap(); then calls getCategory()")
  void testGetVariation_givenHashMap_thenCallsGetCategory() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
   * <ul>
   *   <li>When {@link BundleOrderItemImpl} (default constructor).</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link GoogleAnalytics4Processor#getVariation(OrderItem)}
   */
  @Test
  @DisplayName("Test getVariation(OrderItem); when BundleOrderItemImpl (default constructor); then return empty string")
  void testGetVariation_whenBundleOrderItemImpl_thenReturnEmptyString() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    GoogleAnalytics4Processor googleAnalytics4Processor = new GoogleAnalytics4Processor();

    // Act and Assert
    assertEquals("", googleAnalytics4Processor.getVariation(new BundleOrderItemImpl()));
  }

  /**
   * Test {@link GoogleAnalytics4Processor#getTagIdForProperty()}.
   * <p>
   * Method under test: {@link GoogleAnalytics4Processor#getTagIdForProperty()}
   */
  @Test
  @DisplayName("Test getTagIdForProperty()")
  @Disabled("TODO: Complete this test")
  void testGetTagIdForProperty() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.processor;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass9996 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.processor.GoogleAnalytics4Processor googleAnalytics4Processor;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new GoogleAnalytics4Processor()).getTagIdForProperty();
  }

  /**
   * Test {@link GoogleAnalytics4Processor#getWebPropertyId()}.
   * <p>
   * Method under test: {@link GoogleAnalytics4Processor#getWebPropertyId()}
   */
  @Test
  @DisplayName("Test getWebPropertyId()")
  @Disabled("TODO: Complete this test")
  void testGetWebPropertyId() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.processor;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass10061 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.processor.GoogleAnalytics4Processor googleAnalytics4Processor;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new GoogleAnalytics4Processor()).getWebPropertyId();
  }

  /**
   * Test {@link GoogleAnalytics4Processor#getAffiliation()}.
   * <p>
   * Method under test: {@link GoogleAnalytics4Processor#getAffiliation()}
   */
  @Test
  @DisplayName("Test getAffiliation()")
  @Disabled("TODO: Complete this test")
  void testGetAffiliation() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.processor;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass9965 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.processor.GoogleAnalytics4Processor googleAnalytics4Processor;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new GoogleAnalytics4Processor()).getAffiliation();
  }

  /**
   * Test {@link GoogleAnalytics4Processor#isIncludeLinkAttribution()}.
   * <p>
   * Method under test:
   * {@link GoogleAnalytics4Processor#isIncludeLinkAttribution()}
   */
  @Test
  @DisplayName("Test isIncludeLinkAttribution()")
  @Disabled("TODO: Complete this test")
  void testIsIncludeLinkAttribution() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.processor;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass10063 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.processor.GoogleAnalytics4Processor googleAnalytics4Processor;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new GoogleAnalytics4Processor()).isIncludeLinkAttribution();
  }

  /**
   * Test {@link GoogleAnalytics4Processor#isIncludeDisplayAdvertising()}.
   * <p>
   * Method under test:
   * {@link GoogleAnalytics4Processor#isIncludeDisplayAdvertising()}
   */
  @Test
  @DisplayName("Test isIncludeDisplayAdvertising()")
  @Disabled("TODO: Complete this test")
  void testIsIncludeDisplayAdvertising() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.processor;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass10062 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.processor.GoogleAnalytics4Processor googleAnalytics4Processor;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new GoogleAnalytics4Processor()).isIncludeDisplayAdvertising();
  }
}
