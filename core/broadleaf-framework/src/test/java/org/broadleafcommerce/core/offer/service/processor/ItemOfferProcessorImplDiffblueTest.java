package org.broadleafcommerce.core.offer.service.processor;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import org.broadleafcommerce.common.audit.Auditable;
import org.broadleafcommerce.common.currency.domain.BroadleafCurrencyImpl;
import org.broadleafcommerce.common.locale.domain.LocaleImpl;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.core.offer.domain.Offer;
import org.broadleafcommerce.core.offer.domain.OfferImpl;
import org.broadleafcommerce.core.offer.service.discount.PromotionDiscount;
import org.broadleafcommerce.core.offer.service.discount.domain.PromotableCandidateItemOffer;
import org.broadleafcommerce.core.offer.service.discount.domain.PromotableCandidateItemOfferImpl;
import org.broadleafcommerce.core.offer.service.discount.domain.PromotableCandidateOrderOffer;
import org.broadleafcommerce.core.offer.service.discount.domain.PromotableItemFactoryImpl;
import org.broadleafcommerce.core.offer.service.discount.domain.PromotableOfferUtility;
import org.broadleafcommerce.core.offer.service.discount.domain.PromotableOfferUtilityImpl;
import org.broadleafcommerce.core.offer.service.discount.domain.PromotableOrder;
import org.broadleafcommerce.core.offer.service.discount.domain.PromotableOrderImpl;
import org.broadleafcommerce.core.offer.service.discount.domain.PromotableOrderItem;
import org.broadleafcommerce.core.offer.service.discount.domain.PromotableOrderItemImpl;
import org.broadleafcommerce.core.order.domain.BundleOrderItemImpl;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.OrderImpl;
import org.broadleafcommerce.core.order.domain.OrderItem;
import org.broadleafcommerce.core.order.service.type.OrderStatus;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml",
    "/bl-framework-applicationContext-persistence.xml", "/bl-framework-applicationContext-workflow.xml",
    "/bl-framework-applicationContext.xml", "/blc-config/admin/framework/bl-framework-admin-applicationContext.xml",
    "/blc-config/site/framework/bl-framework-applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class ItemOfferProcessorImplDiffblueTest {
  @Autowired
  private ItemOfferProcessorImpl itemOfferProcessorImpl;

  /**
   * Test
   * {@link ItemOfferProcessorImpl#filterItemLevelOffer(PromotableOrder, List, Offer)}.
   * <p>
   * Method under test:
   * {@link ItemOfferProcessorImpl#filterItemLevelOffer(PromotableOrder, List, Offer)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testFilterItemLevelOffer() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.offer.service.processor;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2774 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.offer.service.processor.ItemOfferProcessorImpl itemOfferProcessorImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    ItemOfferProcessorImpl itemOfferProcessorImpl2 = new ItemOfferProcessorImpl(new PromotableOfferUtilityImpl());
    NullOrderImpl order = new NullOrderImpl();
    PromotableOrderImpl order2 = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    ArrayList<PromotableCandidateItemOffer> qualifiedItemOffers = new ArrayList<>();

    // Act
    itemOfferProcessorImpl2.filterItemLevelOffer(order2, qualifiedItemOffers, new OfferImpl());
  }

  /**
   * Test
   * {@link ItemOfferProcessorImpl#createCandidateItemOffer(List, Offer, PromotableOrder)}.
   * <p>
   * Method under test:
   * {@link ItemOfferProcessorImpl#createCandidateItemOffer(List, Offer, PromotableOrder)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCreateCandidateItemOffer() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.offer.service.processor;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2714 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.offer.service.processor.ItemOfferProcessorImpl itemOfferProcessorImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    ItemOfferProcessorImpl itemOfferProcessorImpl2 = new ItemOfferProcessorImpl(new PromotableOfferUtilityImpl());
    ArrayList<PromotableCandidateItemOffer> qualifiedItemOffers = new ArrayList<>();
    OfferImpl offer = new OfferImpl();
    NullOrderImpl order = new NullOrderImpl();

    // Act
    itemOfferProcessorImpl2.createCandidateItemOffer(qualifiedItemOffers, offer,
        new PromotableOrderImpl(order, new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true));
  }

  /**
   * Test
   * {@link ItemOfferProcessorImpl#applyAllItemOffers(List, PromotableOrder)}.
   * <p>
   * Method under test:
   * {@link ItemOfferProcessorImpl#applyAllItemOffers(List, PromotableOrder)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testApplyAllItemOffers() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.offer.service.processor;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2376 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.offer.service.processor.ItemOfferProcessorImpl itemOfferProcessorImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    ItemOfferProcessorImpl itemOfferProcessorImpl2 = new ItemOfferProcessorImpl(new PromotableOfferUtilityImpl());
    ArrayList<PromotableCandidateItemOffer> itemOffers = new ArrayList<>();
    NullOrderImpl order = new NullOrderImpl();

    // Act
    itemOfferProcessorImpl2.applyAllItemOffers(itemOffers,
        new PromotableOrderImpl(order, new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true));
  }

  /**
   * Test
   * {@link ItemOfferProcessorImpl#orderMeetsQualifyingSubtotalRequirements(PromotableOrder, PromotableCandidateItemOffer)}
   * with {@code order}, {@code itemOffer}.
   * <p>
   * Method under test:
   * {@link ItemOfferProcessorImpl#orderMeetsQualifyingSubtotalRequirements(PromotableOrder, PromotableCandidateItemOffer)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testOrderMeetsQualifyingSubtotalRequirementsWithOrderItemOffer() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.offer.service.processor;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3119 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.offer.service.processor.ItemOfferProcessorImpl itemOfferProcessorImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    ItemOfferProcessorImpl itemOfferProcessorImpl2 = new ItemOfferProcessorImpl(new PromotableOfferUtilityImpl());
    NullOrderImpl order = new NullOrderImpl();
    PromotableOrderImpl order2 = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    NullOrderImpl order3 = new NullOrderImpl();
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(order3,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    // Act
    itemOfferProcessorImpl2.orderMeetsQualifyingSubtotalRequirements(order2,
        new PromotableCandidateItemOfferImpl(promotableOrder, new OfferImpl()));
  }

  /**
   * Test
   * {@link ItemOfferProcessorImpl#orderMeetsTargetSubtotalRequirements(PromotableOrder, PromotableCandidateItemOffer)}.
   * <p>
   * Method under test:
   * {@link ItemOfferProcessorImpl#orderMeetsTargetSubtotalRequirements(PromotableOrder, PromotableCandidateItemOffer)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testOrderMeetsTargetSubtotalRequirements() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.offer.service.processor;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3179 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.offer.service.processor.ItemOfferProcessorImpl itemOfferProcessorImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    ItemOfferProcessorImpl itemOfferProcessorImpl2 = new ItemOfferProcessorImpl(new PromotableOfferUtilityImpl());
    NullOrderImpl order = new NullOrderImpl();
    PromotableOrderImpl order2 = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    NullOrderImpl order3 = new NullOrderImpl();
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(order3,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    // Act
    itemOfferProcessorImpl2.orderMeetsTargetSubtotalRequirements(order2,
        new PromotableCandidateItemOfferImpl(promotableOrder, new OfferImpl()));
  }

  /**
   * Test
   * {@link ItemOfferProcessorImpl#orderMeetsSubtotalRequirements(PromotableOrder, PromotableCandidateItemOffer)}
   * with {@code order}, {@code itemOffer}.
   * <p>
   * Method under test:
   * {@link ItemOfferProcessorImpl#orderMeetsSubtotalRequirements(PromotableOrder, PromotableCandidateItemOffer)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testOrderMeetsSubtotalRequirementsWithOrderItemOffer() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.offer.service.processor;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3149 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.offer.service.processor.ItemOfferProcessorImpl itemOfferProcessorImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    ItemOfferProcessorImpl itemOfferProcessorImpl2 = new ItemOfferProcessorImpl(new PromotableOfferUtilityImpl());
    NullOrderImpl order = new NullOrderImpl();
    PromotableOrderImpl order2 = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    NullOrderImpl order3 = new NullOrderImpl();
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(order3,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    // Act
    itemOfferProcessorImpl2.orderMeetsSubtotalRequirements(order2,
        new PromotableCandidateItemOfferImpl(promotableOrder, new OfferImpl()));
  }

  /**
   * Test
   * {@link ItemOfferProcessorImpl#isTotalitarianOfferAppliedToAnyItem(PromotableOrder)}.
   * <p>
   * Method under test:
   * {@link ItemOfferProcessorImpl#isTotalitarianOfferAppliedToAnyItem(PromotableOrder)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testIsTotalitarianOfferAppliedToAnyItem() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.offer.service.processor;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2894 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.offer.service.processor.ItemOfferProcessorImpl itemOfferProcessorImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    ItemOfferProcessorImpl itemOfferProcessorImpl2 = new ItemOfferProcessorImpl(new PromotableOfferUtilityImpl());
    NullOrderImpl order = new NullOrderImpl();

    // Act
    itemOfferProcessorImpl2.isTotalitarianOfferAppliedToAnyItem(
        new PromotableOrderImpl(order, new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true));
  }

  /**
   * Test
   * {@link ItemOfferProcessorImpl#isTotalitarianOfferAppliedToAnyItem(PromotableOrder)}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ItemOfferProcessorImpl#isTotalitarianOfferAppliedToAnyItem(PromotableOrder)}
   */
  @Test
  public void testIsTotalitarianOfferAppliedToAnyItem_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ItemOfferProcessorImpl itemOfferProcessorImpl = new ItemOfferProcessorImpl(new PromotableOfferUtilityImpl());

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
    order.setName("Name");
    order.setOrderAttributes(new HashMap<>());
    order.setOrderItems(new ArrayList<>());
    order.setOrderMessages(new ArrayList<>());
    order.setOrderNumber("42");
    order.setPayments(new ArrayList<>());
    order.setStatus(OrderStatus.ARCHIVED);
    order.setSubTotal(new Money());
    order.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalShipping(new Money());
    order.setTotalTax(new Money());

    // Act and Assert
    assertFalse(itemOfferProcessorImpl.isTotalitarianOfferAppliedToAnyItem(
        new PromotableOrderImpl(order, new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true)));
  }

  /**
   * Test
   * {@link ItemOfferProcessorImpl#applyAdjustments(PromotableOrder, PromotableCandidateItemOffer)}.
   * <p>
   * Method under test:
   * {@link ItemOfferProcessorImpl#applyAdjustments(PromotableOrder, PromotableCandidateItemOffer)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testApplyAdjustments() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.offer.service.processor;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2346 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.offer.service.processor.ItemOfferProcessorImpl itemOfferProcessorImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    ItemOfferProcessorImpl itemOfferProcessorImpl2 = new ItemOfferProcessorImpl(new PromotableOfferUtilityImpl());
    NullOrderImpl order = new NullOrderImpl();
    PromotableOrderImpl order2 = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    NullOrderImpl order3 = new NullOrderImpl();
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(order3,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    // Act
    itemOfferProcessorImpl2.applyAdjustments(order2,
        new PromotableCandidateItemOfferImpl(promotableOrder, new OfferImpl()));
  }

  /**
   * Test
   * {@link ItemOfferProcessorImpl#applyItemOfferExtension(PromotableOrder, PromotableCandidateItemOffer)}.
   * <p>
   * Method under test:
   * {@link ItemOfferProcessorImpl#applyItemOfferExtension(PromotableOrder, PromotableCandidateItemOffer)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testApplyItemOfferExtension() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.offer.service.processor;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2466 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.offer.service.processor.ItemOfferProcessorImpl itemOfferProcessorImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    ItemOfferProcessorImpl itemOfferProcessorImpl2 = new ItemOfferProcessorImpl(new PromotableOfferUtilityImpl());
    NullOrderImpl order = new NullOrderImpl();
    PromotableOrderImpl order2 = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    NullOrderImpl order3 = new NullOrderImpl();
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(order3,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    // Act
    itemOfferProcessorImpl2.applyItemOfferExtension(order2,
        new PromotableCandidateItemOfferImpl(promotableOrder, new OfferImpl()));
  }

  /**
   * Test
   * {@link ItemOfferProcessorImpl#applyItemOffer(PromotableOrder, PromotableCandidateItemOffer)}.
   * <p>
   * Method under test:
   * {@link ItemOfferProcessorImpl#applyItemOffer(PromotableOrder, PromotableCandidateItemOffer)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testApplyItemOffer() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.offer.service.processor;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2436 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.offer.service.processor.ItemOfferProcessorImpl itemOfferProcessorImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    ItemOfferProcessorImpl itemOfferProcessorImpl2 = new ItemOfferProcessorImpl(new PromotableOfferUtilityImpl());
    NullOrderImpl order = new NullOrderImpl();
    PromotableOrderImpl order2 = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    NullOrderImpl order3 = new NullOrderImpl();
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(order3,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    // Act
    itemOfferProcessorImpl2.applyItemOffer(order2,
        new PromotableCandidateItemOfferImpl(promotableOrder, new OfferImpl()));
  }

  /**
   * Test
   * {@link ItemOfferProcessorImpl#chooseSaleOrRetailAdjustments(PromotableOrder)}.
   * <p>
   * Method under test:
   * {@link ItemOfferProcessorImpl#chooseSaleOrRetailAdjustments(PromotableOrder)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testChooseSaleOrRetailAdjustments() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.offer.service.processor;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2669 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.offer.service.processor.ItemOfferProcessorImpl itemOfferProcessorImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    ItemOfferProcessorImpl itemOfferProcessorImpl2 = new ItemOfferProcessorImpl(new PromotableOfferUtilityImpl());
    NullOrderImpl order = new NullOrderImpl();

    // Act
    itemOfferProcessorImpl2.chooseSaleOrRetailAdjustments(
        new PromotableOrderImpl(order, new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true));
  }

  /**
   * Test {@link ItemOfferProcessorImpl#mergePriceDetails(PromotableOrder)}.
   * <p>
   * Method under test:
   * {@link ItemOfferProcessorImpl#mergePriceDetails(PromotableOrder)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testMergePriceDetails() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.offer.service.processor;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3074 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.offer.service.processor.ItemOfferProcessorImpl itemOfferProcessorImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    ItemOfferProcessorImpl itemOfferProcessorImpl2 = new ItemOfferProcessorImpl(new PromotableOfferUtilityImpl());
    NullOrderImpl order = new NullOrderImpl();

    // Act
    itemOfferProcessorImpl2.mergePriceDetails(
        new PromotableOrderImpl(order, new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true));
  }

  /**
   * Test
   * {@link ItemOfferProcessorImpl#applyItemQualifiersAndTargets(PromotableCandidateItemOffer, PromotableOrder)}.
   * <p>
   * Method under test:
   * {@link ItemOfferProcessorImpl#applyItemQualifiersAndTargets(PromotableCandidateItemOffer, PromotableOrder)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testApplyItemQualifiersAndTargets() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.offer.service.processor;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2496 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.offer.service.processor.ItemOfferProcessorImpl itemOfferProcessorImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    ItemOfferProcessorImpl itemOfferProcessorImpl2 = new ItemOfferProcessorImpl(new PromotableOfferUtilityImpl());
    NullOrderImpl order = new NullOrderImpl();
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    PromotableCandidateItemOfferImpl itemOffer = new PromotableCandidateItemOfferImpl(promotableOrder, new OfferImpl());

    NullOrderImpl order2 = new NullOrderImpl();

    // Act
    itemOfferProcessorImpl2.applyItemQualifiersAndTargets(itemOffer,
        new PromotableOrderImpl(order2, new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true));
  }

  /**
   * Test
   * {@link ItemOfferProcessorImpl#applyItemQualifiersAndTargets(PromotableCandidateItemOffer, PromotableOrder)}.
   * <ul>
   *   <li>Then calls
   * {@link PromotableCandidateItemOffer#getCandidateFixedTargetsMap()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ItemOfferProcessorImpl#applyItemQualifiersAndTargets(PromotableCandidateItemOffer, PromotableOrder)}
   */
  @Test
  public void testApplyItemQualifiersAndTargets_thenCallsGetCandidateFixedTargetsMap() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ItemOfferProcessorImpl itemOfferProcessorImpl = new ItemOfferProcessorImpl(new PromotableOfferUtilityImpl());
    PromotableCandidateItemOffer itemOffer = mock(PromotableCandidateItemOffer.class);
    when(itemOffer.getCandidateFixedTargetsMap()).thenReturn(new HashMap<>());
    when(itemOffer.getCandidateQualifiersMap()).thenReturn(new HashMap<>());
    when(itemOffer.getCandidateTargetsMap()).thenReturn(new HashMap<>());
    when(itemOffer.getOffer()).thenReturn(new OfferImpl());

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
    order.setName("Name");
    order.setOrderAttributes(new HashMap<>());
    order.setOrderItems(new ArrayList<>());
    order.setOrderMessages(new ArrayList<>());
    order.setOrderNumber("42");
    order.setPayments(new ArrayList<>());
    order.setStatus(OrderStatus.ARCHIVED);
    order.setSubTotal(new Money());
    order.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalShipping(new Money());
    order.setTotalTax(new Money());

    // Act
    itemOfferProcessorImpl.applyItemQualifiersAndTargets(itemOffer,
        new PromotableOrderImpl(order, new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true));

    // Assert
    verify(itemOffer).getCandidateFixedTargetsMap();
    verify(itemOffer).getCandidateQualifiersMap();
    verify(itemOffer).getCandidateTargetsMap();
    verify(itemOffer, atLeast(1)).getOffer();
  }

  /**
   * Test {@link ItemOfferProcessorImpl#buildPriceDetailListFromOrderItems(List)}.
   * <p>
   * Method under test:
   * {@link ItemOfferProcessorImpl#buildPriceDetailListFromOrderItems(List)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testBuildPriceDetailListFromOrderItems() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.offer.service.processor;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2541 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.offer.service.processor.ItemOfferProcessorImpl itemOfferProcessorImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    ItemOfferProcessorImpl itemOfferProcessorImpl2 = new ItemOfferProcessorImpl(new PromotableOfferUtilityImpl());

    // Act
    itemOfferProcessorImpl2.buildPriceDetailListFromOrderItems(new ArrayList<>());
  }

  /**
   * Test
   * {@link ItemOfferProcessorImpl#markQualifiers(PromotableCandidateItemOffer, PromotableOrder)}.
   * <p>
   * Method under test:
   * {@link ItemOfferProcessorImpl#markQualifiers(PromotableCandidateItemOffer, PromotableOrder)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testMarkQualifiers() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.offer.service.processor;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2924 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.offer.service.processor.ItemOfferProcessorImpl itemOfferProcessorImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    ItemOfferProcessorImpl itemOfferProcessorImpl2 = new ItemOfferProcessorImpl(new PromotableOfferUtilityImpl());
    NullOrderImpl order = new NullOrderImpl();
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    PromotableCandidateItemOfferImpl itemOffer = new PromotableCandidateItemOfferImpl(promotableOrder, new OfferImpl());

    NullOrderImpl order2 = new NullOrderImpl();

    // Act
    itemOfferProcessorImpl2.markQualifiers(itemOffer,
        new PromotableOrderImpl(order2, new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true));
  }

  /**
   * Test
   * {@link ItemOfferProcessorImpl#markTargets(PromotableCandidateItemOffer, PromotableOrder, OrderItem)}
   * with {@code itemOffer}, {@code order}, {@code relatedQualifier}.
   * <p>
   * Method under test:
   * {@link ItemOfferProcessorImpl#markTargets(PromotableCandidateItemOffer, PromotableOrder, OrderItem)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testMarkTargetsWithItemOfferOrderRelatedQualifier() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.offer.service.processor;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3014 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.offer.service.processor.ItemOfferProcessorImpl itemOfferProcessorImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    ItemOfferProcessorImpl itemOfferProcessorImpl2 = new ItemOfferProcessorImpl(new PromotableOfferUtilityImpl());
    NullOrderImpl order = new NullOrderImpl();
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    PromotableCandidateItemOfferImpl itemOffer = new PromotableCandidateItemOfferImpl(promotableOrder, new OfferImpl());

    NullOrderImpl order2 = new NullOrderImpl();
    PromotableOrderImpl order3 = new PromotableOrderImpl(order2,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    // Act
    itemOfferProcessorImpl2.markTargets(itemOffer, order3, new BundleOrderItemImpl());
  }

  /**
   * Test
   * {@link ItemOfferProcessorImpl#markTargets(PromotableCandidateItemOffer, PromotableOrder, OrderItem, boolean)}
   * with {@code itemOffer}, {@code order}, {@code relatedQualifier},
   * {@code checkOnly}.
   * <p>
   * Method under test:
   * {@link ItemOfferProcessorImpl#markTargets(PromotableCandidateItemOffer, PromotableOrder, OrderItem, boolean)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testMarkTargetsWithItemOfferOrderRelatedQualifierCheckOnly() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.offer.service.processor;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3044 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.offer.service.processor.ItemOfferProcessorImpl itemOfferProcessorImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    ItemOfferProcessorImpl itemOfferProcessorImpl2 = new ItemOfferProcessorImpl(new PromotableOfferUtilityImpl());
    NullOrderImpl order = new NullOrderImpl();
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    PromotableCandidateItemOfferImpl itemOffer = new PromotableCandidateItemOfferImpl(promotableOrder, new OfferImpl());

    NullOrderImpl order2 = new NullOrderImpl();
    PromotableOrderImpl order3 = new PromotableOrderImpl(order2,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    // Act
    itemOfferProcessorImpl2.markTargets(itemOffer, order3, new BundleOrderItemImpl(), true);
  }

  /**
   * Test
   * {@link ItemOfferProcessorImpl#markRelatedQualifiersAndTargets(PromotableCandidateItemOffer, PromotableOrder)}.
   * <p>
   * Method under test:
   * {@link ItemOfferProcessorImpl#markRelatedQualifiersAndTargets(PromotableCandidateItemOffer, PromotableOrder)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testMarkRelatedQualifiersAndTargets() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.offer.service.processor;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2984 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.offer.service.processor.ItemOfferProcessorImpl itemOfferProcessorImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    ItemOfferProcessorImpl itemOfferProcessorImpl2 = new ItemOfferProcessorImpl(new PromotableOfferUtilityImpl());
    NullOrderImpl order = new NullOrderImpl();
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    PromotableCandidateItemOfferImpl itemOffer = new PromotableCandidateItemOfferImpl(promotableOrder, new OfferImpl());

    NullOrderImpl order2 = new NullOrderImpl();

    // Act
    itemOfferProcessorImpl2.markRelatedQualifiersAndTargets(itemOffer,
        new PromotableOrderImpl(order2, new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true));
  }

  /**
   * Test
   * {@link ItemOfferProcessorImpl#filterOffers(PromotableOrder, List, List, List)}
   * with {@code order}, {@code filteredOffers}, {@code qualifiedOrderOffers},
   * {@code qualifiedItemOffers}.
   * <p>
   * Method under test:
   * {@link ItemOfferProcessorImpl#filterOffers(PromotableOrder, List, List, List)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testFilterOffersWithOrderFilteredOffersQualifiedOrderOffersQualifiedItemOffers() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.offer.service.processor;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2804 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.offer.service.processor.ItemOfferProcessorImpl itemOfferProcessorImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    ItemOfferProcessorImpl itemOfferProcessorImpl2 = new ItemOfferProcessorImpl(new PromotableOfferUtilityImpl());
    NullOrderImpl order = new NullOrderImpl();
    PromotableOrderImpl order2 = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    ArrayList<Offer> filteredOffers = new ArrayList<>();
    ArrayList<PromotableCandidateOrderOffer> qualifiedOrderOffers = new ArrayList<>();

    // Act
    itemOfferProcessorImpl2.filterOffers(order2, filteredOffers, qualifiedOrderOffers, new ArrayList<>());
  }

  /**
   * Test
   * {@link ItemOfferProcessorImpl#calculatePotentialSavingsForOrderItem(PromotableCandidateItemOffer, PromotableOrderItem, int)}.
   * <p>
   * Method under test:
   * {@link ItemOfferProcessorImpl#calculatePotentialSavingsForOrderItem(PromotableCandidateItemOffer, PromotableOrderItem, int)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCalculatePotentialSavingsForOrderItem() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.offer.service.processor;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2609 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.offer.service.processor.ItemOfferProcessorImpl itemOfferProcessorImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    ItemOfferProcessorImpl itemOfferProcessorImpl2 = new ItemOfferProcessorImpl(new PromotableOfferUtilityImpl());
    NullOrderImpl order = new NullOrderImpl();
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    PromotableCandidateItemOfferImpl itemOffer = new PromotableCandidateItemOfferImpl(promotableOrder, new OfferImpl());

    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();
    NullOrderImpl order2 = new NullOrderImpl();
    PromotableOrderImpl promotableOrder2 = new PromotableOrderImpl(order2,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    // Act
    itemOfferProcessorImpl2.calculatePotentialSavingsForOrderItem(itemOffer, new PromotableOrderItemImpl(orderItem,
        promotableOrder2, new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true), 1);
  }

  /**
   * Test
   * {@link ItemOfferProcessorImpl#calculatePotentialSavings(List, PromotableOrder)}.
   * <p>
   * Method under test:
   * {@link ItemOfferProcessorImpl#calculatePotentialSavings(List, PromotableOrder)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCalculatePotentialSavings() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.offer.service.processor;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2579 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.offer.service.processor.ItemOfferProcessorImpl itemOfferProcessorImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    ItemOfferProcessorImpl itemOfferProcessorImpl2 = new ItemOfferProcessorImpl(new PromotableOfferUtilityImpl());
    ArrayList<PromotableCandidateItemOffer> itemOffers = new ArrayList<>();
    NullOrderImpl order = new NullOrderImpl();

    // Act
    itemOfferProcessorImpl2.calculatePotentialSavings(itemOffers,
        new PromotableOrderImpl(order, new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true));
  }

  /**
   * Test {@link ItemOfferProcessorImpl#calculatePercent(Money, Money)}.
   * <p>
   * Method under test:
   * {@link ItemOfferProcessorImpl#calculatePercent(Money, Money)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCalculatePercent() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.offer.service.processor;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2556 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.offer.service.processor.ItemOfferProcessorImpl itemOfferProcessorImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    ItemOfferProcessorImpl itemOfferProcessorImpl2 = new ItemOfferProcessorImpl(new PromotableOfferUtilityImpl());
    Money itemSubTotal = new Money();

    // Act
    itemOfferProcessorImpl2.calculatePercent(itemSubTotal, new Money());
  }

  /**
   * Test {@link ItemOfferProcessorImpl#calculatePercent(Money, Money)}.
   * <ul>
   *   <li>Given {@link BigDecimal#BigDecimal(String)} with {@code 2.3}.</li>
   *   <li>Then return {@link BigDecimal#BigDecimal(String)} with {@code 0.00}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ItemOfferProcessorImpl#calculatePercent(Money, Money)}
   */
  @Test
  public void testCalculatePercent_givenBigDecimalWith23_thenReturnBigDecimalWith000() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ItemOfferProcessorImpl itemOfferProcessorImpl = new ItemOfferProcessorImpl(new PromotableOfferUtilityImpl());
    Money itemSubTotal = mock(Money.class);
    when(itemSubTotal.getAmount()).thenReturn(new BigDecimal("2.3"));

    // Act
    BigDecimal actualCalculatePercentResult = itemOfferProcessorImpl.calculatePercent(itemSubTotal, new Money());

    // Assert
    verify(itemSubTotal).getAmount();
    assertEquals(new BigDecimal("0.00"), actualCalculatePercentResult);
  }

  /**
   * Test {@link ItemOfferProcessorImpl#calculatePercent(Money, Money)}.
   * <ul>
   *   <li>Given {@link BigDecimal#BigDecimal(String)} with {@code 2.3}.</li>
   *   <li>Then return {@link BigDecimal#BigDecimal(String)} with
   * {@code 100.0}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ItemOfferProcessorImpl#calculatePercent(Money, Money)}
   */
  @Test
  public void testCalculatePercent_givenBigDecimalWith23_thenReturnBigDecimalWith1000() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ItemOfferProcessorImpl itemOfferProcessorImpl = new ItemOfferProcessorImpl(new PromotableOfferUtilityImpl());
    Money itemSubTotal = mock(Money.class);
    when(itemSubTotal.getAmount()).thenReturn(new BigDecimal("2.3"));
    Money itemSavings = mock(Money.class);
    when(itemSavings.getAmount()).thenReturn(new BigDecimal("2.3"));

    // Act
    BigDecimal actualCalculatePercentResult = itemOfferProcessorImpl.calculatePercent(itemSubTotal, itemSavings);

    // Assert
    verify(itemSubTotal).getAmount();
    verify(itemSavings).getAmount();
    assertEquals(new BigDecimal("100.0"), actualCalculatePercentResult);
  }

  /**
   * Test {@link ItemOfferProcessorImpl#calculatePercent(Money, Money)}.
   * <ul>
   *   <li>Given
   * {@link ItemOfferProcessorImpl#ItemOfferProcessorImpl(PromotableOfferUtility)}
   * with {@link PromotableOfferUtility}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ItemOfferProcessorImpl#calculatePercent(Money, Money)}
   */
  @Test
  public void testCalculatePercent_givenItemOfferProcessorImplWithPromotableOfferUtility() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ItemOfferProcessorImpl itemOfferProcessorImpl = new ItemOfferProcessorImpl(mock(PromotableOfferUtility.class));
    Money itemSubTotal = new Money();

    // Act
    BigDecimal actualCalculatePercentResult = itemOfferProcessorImpl.calculatePercent(itemSubTotal, new Money());

    // Assert
    assertEquals(new BigDecimal("0"), actualCalculatePercentResult);
  }

  /**
   * Test {@link ItemOfferProcessorImpl#calculatePercent(Money, Money)}.
   * <ul>
   *   <li>When {@link Money#Money(double)} with amount is ten.</li>
   *   <li>Then return {@link BigDecimal#BigDecimal(String)} with {@code 0.00}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ItemOfferProcessorImpl#calculatePercent(Money, Money)}
   */
  @Test
  public void testCalculatePercent_whenMoneyWithAmountIsTen_thenReturnBigDecimalWith000() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ItemOfferProcessorImpl itemOfferProcessorImpl = new ItemOfferProcessorImpl(new PromotableOfferUtilityImpl());
    Money itemSubTotal = new Money(10.0d);

    // Act
    BigDecimal actualCalculatePercentResult = itemOfferProcessorImpl.calculatePercent(itemSubTotal, new Money());

    // Assert
    assertEquals(new BigDecimal("0.00"), actualCalculatePercentResult);
  }

  /**
   * Test {@link ItemOfferProcessorImpl#calculatePercent(Money, Money)}.
   * <ul>
   *   <li>When {@link Money#Money()}.</li>
   *   <li>Then return {@link BigDecimal#BigDecimal(String)} with {@code 0}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ItemOfferProcessorImpl#calculatePercent(Money, Money)}
   */
  @Test
  public void testCalculatePercent_whenMoney_thenReturnBigDecimalWith0() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ItemOfferProcessorImpl itemOfferProcessorImpl = new ItemOfferProcessorImpl(new PromotableOfferUtilityImpl());
    Money itemSubTotal = new Money();

    // Act
    BigDecimal actualCalculatePercentResult = itemOfferProcessorImpl.calculatePercent(itemSubTotal, new Money());

    // Assert
    assertEquals(new BigDecimal("0"), actualCalculatePercentResult);
  }

  /**
   * Test
   * {@link ItemOfferProcessorImpl#calculateWeightedPercent(PromotionDiscount, PromotableOrderItem, Money)}.
   * <p>
   * Method under test:
   * {@link ItemOfferProcessorImpl#calculateWeightedPercent(PromotionDiscount, PromotableOrderItem, Money)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCalculateWeightedPercent() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.offer.service.processor;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2639 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.offer.service.processor.ItemOfferProcessorImpl itemOfferProcessorImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    ItemOfferProcessorImpl itemOfferProcessorImpl2 = new ItemOfferProcessorImpl(new PromotableOfferUtilityImpl());
    PromotionDiscount discount = new PromotionDiscount();
    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();
    NullOrderImpl order = new NullOrderImpl();
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    PromotableOrderItemImpl item = new PromotableOrderItemImpl(orderItem, promotableOrder,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    // Act
    itemOfferProcessorImpl2.calculateWeightedPercent(discount, item, new Money());
  }

  /**
   * Test {@link ItemOfferProcessorImpl#useCalculatePercent(Offer)}.
   * <p>
   * Method under test: {@link ItemOfferProcessorImpl#useCalculatePercent(Offer)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testUseCalculatePercent() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.offer.service.processor;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3273 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.offer.service.processor.ItemOfferProcessorImpl itemOfferProcessorImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    ItemOfferProcessorImpl itemOfferProcessorImpl2 = new ItemOfferProcessorImpl(new PromotableOfferUtilityImpl());

    // Act
    itemOfferProcessorImpl2.useCalculatePercent(new OfferImpl());
  }

  /**
   * Test {@link ItemOfferProcessorImpl#useCalculatePercent(Offer)}.
   * <ul>
   *   <li>Given
   * {@link ItemOfferProcessorImpl#ItemOfferProcessorImpl(PromotableOfferUtility)}
   * with {@link PromotableOfferUtility}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ItemOfferProcessorImpl#useCalculatePercent(Offer)}
   */
  @Test
  public void testUseCalculatePercent_givenItemOfferProcessorImplWithPromotableOfferUtility() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ItemOfferProcessorImpl itemOfferProcessorImpl = new ItemOfferProcessorImpl(mock(PromotableOfferUtility.class));

    // Act and Assert
    assertTrue(itemOfferProcessorImpl.useCalculatePercent(new OfferImpl()));
  }

  /**
   * Test {@link ItemOfferProcessorImpl#useCalculatePercent(Offer)}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ItemOfferProcessorImpl#useCalculatePercent(Offer)}
   */
  @Test
  public void testUseCalculatePercent_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ItemOfferProcessorImpl itemOfferProcessorImpl = new ItemOfferProcessorImpl(new PromotableOfferUtilityImpl());

    // Act and Assert
    assertTrue(itemOfferProcessorImpl.useCalculatePercent(new OfferImpl()));
  }

  /**
   * Test {@link ItemOfferProcessorImpl#isPercentOffOffer(Offer)}.
   * <p>
   * Method under test: {@link ItemOfferProcessorImpl#isPercentOffOffer(Offer)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testIsPercentOffOffer() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.offer.service.processor;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2864 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.offer.service.processor.ItemOfferProcessorImpl itemOfferProcessorImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    ItemOfferProcessorImpl itemOfferProcessorImpl2 = new ItemOfferProcessorImpl(new PromotableOfferUtilityImpl());

    // Act
    itemOfferProcessorImpl2.isPercentOffOffer(new OfferImpl());
  }

  /**
   * Test {@link ItemOfferProcessorImpl#isPercentOffOffer(Offer)}.
   * <ul>
   *   <li>Given
   * {@link ItemOfferProcessorImpl#ItemOfferProcessorImpl(PromotableOfferUtility)}
   * with {@link PromotableOfferUtility}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ItemOfferProcessorImpl#isPercentOffOffer(Offer)}
   */
  @Test
  public void testIsPercentOffOffer_givenItemOfferProcessorImplWithPromotableOfferUtility() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ItemOfferProcessorImpl itemOfferProcessorImpl = new ItemOfferProcessorImpl(mock(PromotableOfferUtility.class));

    // Act and Assert
    assertFalse(itemOfferProcessorImpl.isPercentOffOffer(new OfferImpl()));
  }

  /**
   * Test {@link ItemOfferProcessorImpl#isPercentOffOffer(Offer)}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ItemOfferProcessorImpl#isPercentOffOffer(Offer)}
   */
  @Test
  public void testIsPercentOffOffer_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ItemOfferProcessorImpl itemOfferProcessorImpl = new ItemOfferProcessorImpl(new PromotableOfferUtilityImpl());

    // Act and Assert
    assertFalse(itemOfferProcessorImpl.isPercentOffOffer(new OfferImpl()));
  }

  /**
   * Test {@link ItemOfferProcessorImpl#usePercentOffValue(Offer)}.
   * <p>
   * Method under test: {@link ItemOfferProcessorImpl#usePercentOffValue(Offer)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testUsePercentOffValue() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.offer.service.processor;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3303 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.offer.service.processor.ItemOfferProcessorImpl itemOfferProcessorImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    ItemOfferProcessorImpl itemOfferProcessorImpl2 = new ItemOfferProcessorImpl(new PromotableOfferUtilityImpl());

    // Act
    itemOfferProcessorImpl2.usePercentOffValue(new OfferImpl());
  }

  /**
   * Test {@link ItemOfferProcessorImpl#usePercentOffValue(Offer)}.
   * <ul>
   *   <li>Given
   * {@link ItemOfferProcessorImpl#ItemOfferProcessorImpl(PromotableOfferUtility)}
   * with {@link PromotableOfferUtility}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ItemOfferProcessorImpl#usePercentOffValue(Offer)}
   */
  @Test
  public void testUsePercentOffValue_givenItemOfferProcessorImplWithPromotableOfferUtility() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ItemOfferProcessorImpl itemOfferProcessorImpl = new ItemOfferProcessorImpl(mock(PromotableOfferUtility.class));

    // Act and Assert
    assertFalse(itemOfferProcessorImpl.usePercentOffValue(new OfferImpl()));
  }

  /**
   * Test {@link ItemOfferProcessorImpl#usePercentOffValue(Offer)}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ItemOfferProcessorImpl#usePercentOffValue(Offer)}
   */
  @Test
  public void testUsePercentOffValue_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ItemOfferProcessorImpl itemOfferProcessorImpl = new ItemOfferProcessorImpl(new PromotableOfferUtilityImpl());

    // Act and Assert
    assertFalse(itemOfferProcessorImpl.usePercentOffValue(new OfferImpl()));
  }

  /**
   * Test
   * {@link ItemOfferProcessorImpl#markQualifiersAndTargets(PromotableOrder, PromotableCandidateItemOffer)}.
   * <p>
   * Method under test:
   * {@link ItemOfferProcessorImpl#markQualifiersAndTargets(PromotableOrder, PromotableCandidateItemOffer)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testMarkQualifiersAndTargets() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.offer.service.processor;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2954 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.offer.service.processor.ItemOfferProcessorImpl itemOfferProcessorImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    ItemOfferProcessorImpl itemOfferProcessorImpl2 = new ItemOfferProcessorImpl(new PromotableOfferUtilityImpl());
    NullOrderImpl order = new NullOrderImpl();
    PromotableOrderImpl order2 = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    NullOrderImpl order3 = new NullOrderImpl();
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(order3,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    // Act
    itemOfferProcessorImpl2.markQualifiersAndTargets(order2,
        new PromotableCandidateItemOfferImpl(promotableOrder, new OfferImpl()));
  }

  /**
   * Test {@link ItemOfferProcessorImpl#offerListStartsWithNonCombinable(List)}.
   * <p>
   * Method under test:
   * {@link ItemOfferProcessorImpl#offerListStartsWithNonCombinable(List)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testOfferListStartsWithNonCombinable() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.offer.service.processor;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3104 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.offer.service.processor.ItemOfferProcessorImpl itemOfferProcessorImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    ItemOfferProcessorImpl itemOfferProcessorImpl2 = new ItemOfferProcessorImpl(new PromotableOfferUtilityImpl());

    // Act
    itemOfferProcessorImpl2.offerListStartsWithNonCombinable(new ArrayList<>());
  }

  /**
   * Test {@link ItemOfferProcessorImpl#buildItemOfferPermutations(List)}.
   * <p>
   * Method under test:
   * {@link ItemOfferProcessorImpl#buildItemOfferPermutations(List)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testBuildItemOfferPermutations() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.offer.service.processor;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2526 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.offer.service.processor.ItemOfferProcessorImpl itemOfferProcessorImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    ItemOfferProcessorImpl itemOfferProcessorImpl2 = new ItemOfferProcessorImpl(new PromotableOfferUtilityImpl());

    // Act
    itemOfferProcessorImpl2.buildItemOfferPermutations(new ArrayList<>());
  }

  /**
   * Test
   * {@link ItemOfferProcessorImpl#removeTotalitarianAndNonCombinableOffers(List, List)}.
   * <p>
   * Method under test:
   * {@link ItemOfferProcessorImpl#removeTotalitarianAndNonCombinableOffers(List, List)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testRemoveTotalitarianAndNonCombinableOffers() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.offer.service.processor;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3224 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.offer.service.processor.ItemOfferProcessorImpl itemOfferProcessorImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    ItemOfferProcessorImpl itemOfferProcessorImpl2 = new ItemOfferProcessorImpl(new PromotableOfferUtilityImpl());
    ArrayList<PromotableCandidateItemOffer> offers = new ArrayList<>();

    // Act
    itemOfferProcessorImpl2.removeTotalitarianAndNonCombinableOffers(offers, new ArrayList<>());
  }

  /**
   * Test
   * {@link ItemOfferProcessorImpl#getPermutationByComparator(List, Comparator)}.
   * <p>
   * Method under test:
   * {@link ItemOfferProcessorImpl#getPermutationByComparator(List, Comparator)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetPermutationByComparator() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.offer.service.processor;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2834 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.offer.service.processor.ItemOfferProcessorImpl itemOfferProcessorImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    ItemOfferProcessorImpl itemOfferProcessorImpl2 = new ItemOfferProcessorImpl(new PromotableOfferUtilityImpl());

    // Act
    itemOfferProcessorImpl2.getPermutationByComparator(new ArrayList<>(), mock(Comparator.class));
  }

  /**
   * Test {@link ItemOfferProcessorImpl#restPriceDetails(PromotableOrderItem)}.
   * <p>
   * Method under test:
   * {@link ItemOfferProcessorImpl#restPriceDetails(PromotableOrderItem)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testRestPriceDetails() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.offer.service.processor;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3243 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.offer.service.processor.ItemOfferProcessorImpl itemOfferProcessorImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    ItemOfferProcessorImpl itemOfferProcessorImpl2 = new ItemOfferProcessorImpl(new PromotableOfferUtilityImpl());
    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();
    NullOrderImpl order = new NullOrderImpl();
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    // Act
    itemOfferProcessorImpl2.restPriceDetails(new PromotableOrderItemImpl(orderItem, promotableOrder,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true));
  }

  /**
   * Test
   * {@link ItemOfferProcessorImpl#determineBestPermutation(List, PromotableOrder)}.
   * <p>
   * Method under test:
   * {@link ItemOfferProcessorImpl#determineBestPermutation(List, PromotableOrder)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testDetermineBestPermutation() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.offer.service.processor;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2744 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.offer.service.processor.ItemOfferProcessorImpl itemOfferProcessorImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    ItemOfferProcessorImpl itemOfferProcessorImpl2 = new ItemOfferProcessorImpl(new PromotableOfferUtilityImpl());
    ArrayList<PromotableCandidateItemOffer> itemOffers = new ArrayList<>();
    NullOrderImpl order = new NullOrderImpl();

    // Act
    itemOfferProcessorImpl2.determineBestPermutation(itemOffers,
        new PromotableOrderImpl(order, new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true));
  }

  /**
   * Test {@link ItemOfferProcessorImpl#removeDuplicatePermutations(List)}.
   * <p>
   * Method under test:
   * {@link ItemOfferProcessorImpl#removeDuplicatePermutations(List)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testRemoveDuplicatePermutations() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.offer.service.processor;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3209 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.offer.service.processor.ItemOfferProcessorImpl itemOfferProcessorImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    ItemOfferProcessorImpl itemOfferProcessorImpl2 = new ItemOfferProcessorImpl(new PromotableOfferUtilityImpl());

    // Act
    itemOfferProcessorImpl2.removeDuplicatePermutations(new ArrayList<>());
  }

  /**
   * Test {@link ItemOfferProcessorImpl#convertToIdList(List)}.
   * <p>
   * Method under test: {@link ItemOfferProcessorImpl#convertToIdList(List)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testConvertToIdList() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.offer.service.processor;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2699 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.offer.service.processor.ItemOfferProcessorImpl itemOfferProcessorImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    ItemOfferProcessorImpl itemOfferProcessorImpl2 = new ItemOfferProcessorImpl(new PromotableOfferUtilityImpl());

    // Act
    itemOfferProcessorImpl2.convertToIdList(new ArrayList<>());
  }

  /**
   * Test
   * {@link ItemOfferProcessorImpl#applyAndCompareOrderAndItemOffers(PromotableOrder, List, List)}.
   * <p>
   * Method under test:
   * {@link ItemOfferProcessorImpl#applyAndCompareOrderAndItemOffers(PromotableOrder, List, List)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testApplyAndCompareOrderAndItemOffers() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.offer.service.processor;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2406 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.offer.service.processor.ItemOfferProcessorImpl itemOfferProcessorImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    ItemOfferProcessorImpl itemOfferProcessorImpl2 = new ItemOfferProcessorImpl(new PromotableOfferUtilityImpl());
    NullOrderImpl order = new NullOrderImpl();
    PromotableOrderImpl order2 = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    ArrayList<PromotableCandidateOrderOffer> qualifiedOrderOffers = new ArrayList<>();

    // Act
    itemOfferProcessorImpl2.applyAndCompareOrderAndItemOffers(order2, qualifiedOrderOffers, new ArrayList<>());
  }
}
