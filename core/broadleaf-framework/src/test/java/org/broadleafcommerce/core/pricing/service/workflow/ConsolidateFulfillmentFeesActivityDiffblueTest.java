package org.broadleafcommerce.core.pricing.service.workflow;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import org.broadleafcommerce.common.audit.Auditable;
import org.broadleafcommerce.common.currency.domain.BroadleafCurrencyImpl;
import org.broadleafcommerce.common.locale.domain.LocaleImpl;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.core.catalog.domain.SkuFee;
import org.broadleafcommerce.core.catalog.domain.SkuFeeImpl;
import org.broadleafcommerce.core.catalog.service.type.SkuFeeType;
import org.broadleafcommerce.core.order.domain.FulfillmentGroup;
import org.broadleafcommerce.core.order.domain.FulfillmentGroupImpl;
import org.broadleafcommerce.core.order.domain.FulfillmentGroupItemImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.order.domain.OrderImpl;
import org.broadleafcommerce.core.order.service.type.OrderStatus;
import org.broadleafcommerce.core.workflow.DefaultProcessContextImpl;
import org.broadleafcommerce.core.workflow.ProcessContext;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml",
    "/bl-framework-applicationContext-persistence.xml", "/bl-framework-applicationContext-workflow.xml",
    "/bl-framework-applicationContext.xml", "/blc-config/admin/framework/bl-framework-admin-applicationContext.xml",
    "/blc-config/site/framework/bl-framework-applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class ConsolidateFulfillmentFeesActivityDiffblueTest {
  @Autowired
  private ConsolidateFulfillmentFeesActivity consolidateFulfillmentFeesActivity;

  /**
   * Test {@link ConsolidateFulfillmentFeesActivity#execute(ProcessContext)}.
   * <p>
   * Method under test:
   * {@link ConsolidateFulfillmentFeesActivity#execute(ProcessContext)}
   */
  @Test
  public void testExecute() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ConsolidateFulfillmentFeesActivity consolidateFulfillmentFeesActivity = new ConsolidateFulfillmentFeesActivity();

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    fulfillmentGroupImpl.addFulfillmentGroupItem(new FulfillmentGroupItemImpl());

    ArrayList<FulfillmentGroup> fulfillmentGroups = new ArrayList<>();
    fulfillmentGroups.add(fulfillmentGroupImpl);

    OrderImpl orderImpl = new OrderImpl();
    orderImpl.setAdditionalOfferInformation(new HashMap<>());
    orderImpl.setAuditable(auditable);
    orderImpl.setCandidateOrderOffers(new ArrayList<>());
    orderImpl.setCurrency(new BroadleafCurrencyImpl());
    orderImpl.setCustomer(new CustomerImpl());
    orderImpl.setEmailAddress("42 Main St");
    orderImpl.setFulfillmentGroups(fulfillmentGroups);
    orderImpl.setId(1L);
    orderImpl.setLocale(new LocaleImpl());
    orderImpl.setName("Name");
    orderImpl.setOrderAttributes(new HashMap<>());
    orderImpl.setOrderItems(new ArrayList<>());
    orderImpl.setOrderMessages(new ArrayList<>());
    orderImpl.setOrderNumber("42");
    orderImpl.setPayments(new ArrayList<>());
    orderImpl.setStatus(OrderStatus.ARCHIVED);
    orderImpl.setSubTotal(new Money());
    orderImpl.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    orderImpl.setTaxOverride(true);
    orderImpl.setTotal(new Money());
    orderImpl.setTotalFulfillmentCharges(new Money());
    orderImpl.setTotalShipping(new Money());
    orderImpl.setTotalTax(new Money());
    ProcessContext<Order> context = mock(ProcessContext.class);
    doNothing().when(context).setSeedData(Mockito.<Order>any());
    when(context.getSeedData()).thenReturn(orderImpl);

    // Act
    ProcessContext<Order> actualExecuteResult = consolidateFulfillmentFeesActivity.execute(context);

    // Assert
    verify(context).getSeedData();
    verify(context).setSeedData(isA(Order.class));
    assertSame(context, actualExecuteResult);
  }

  /**
   * Test {@link ConsolidateFulfillmentFeesActivity#execute(ProcessContext)}.
   * <p>
   * Method under test:
   * {@link ConsolidateFulfillmentFeesActivity#execute(ProcessContext)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testExecute2() throws Exception {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.pricing.service.workflow;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass0 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.pricing.service.workflow.ConsolidateFulfillmentFeesActivity consolidateFulfillmentFeesActivity;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    ConsolidateFulfillmentFeesActivity consolidateFulfillmentFeesActivity2 = new ConsolidateFulfillmentFeesActivity();

    // Act
    consolidateFulfillmentFeesActivity2.execute((ProcessContext<Order>) new DefaultProcessContextImpl<>());
  }

  /**
   * Test {@link ConsolidateFulfillmentFeesActivity#execute(ProcessContext)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link FulfillmentGroupImpl}
   * (default constructor).</li>
   *   <li>Then return {@link ProcessContext}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ConsolidateFulfillmentFeesActivity#execute(ProcessContext)}
   */
  @Test
  public void testExecute_givenArrayListAddFulfillmentGroupImpl_thenReturnProcessContext() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ConsolidateFulfillmentFeesActivity consolidateFulfillmentFeesActivity = new ConsolidateFulfillmentFeesActivity();

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    ArrayList<FulfillmentGroup> fulfillmentGroups = new ArrayList<>();
    fulfillmentGroups.add(new FulfillmentGroupImpl());

    OrderImpl orderImpl = new OrderImpl();
    orderImpl.setAdditionalOfferInformation(new HashMap<>());
    orderImpl.setAuditable(auditable);
    orderImpl.setCandidateOrderOffers(new ArrayList<>());
    orderImpl.setCurrency(new BroadleafCurrencyImpl());
    orderImpl.setCustomer(new CustomerImpl());
    orderImpl.setEmailAddress("42 Main St");
    orderImpl.setFulfillmentGroups(fulfillmentGroups);
    orderImpl.setId(1L);
    orderImpl.setLocale(new LocaleImpl());
    orderImpl.setName("Name");
    orderImpl.setOrderAttributes(new HashMap<>());
    orderImpl.setOrderItems(new ArrayList<>());
    orderImpl.setOrderMessages(new ArrayList<>());
    orderImpl.setOrderNumber("42");
    orderImpl.setPayments(new ArrayList<>());
    orderImpl.setStatus(OrderStatus.ARCHIVED);
    orderImpl.setSubTotal(new Money());
    orderImpl.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    orderImpl.setTaxOverride(true);
    orderImpl.setTotal(new Money());
    orderImpl.setTotalFulfillmentCharges(new Money());
    orderImpl.setTotalShipping(new Money());
    orderImpl.setTotalTax(new Money());
    ProcessContext<Order> context = mock(ProcessContext.class);
    doNothing().when(context).setSeedData(Mockito.<Order>any());
    when(context.getSeedData()).thenReturn(orderImpl);

    // Act
    ProcessContext<Order> actualExecuteResult = consolidateFulfillmentFeesActivity.execute(context);

    // Assert
    verify(context).getSeedData();
    verify(context).setSeedData(isA(Order.class));
    assertSame(context, actualExecuteResult);
  }

  /**
   * Test {@link ConsolidateFulfillmentFeesActivity#execute(ProcessContext)}.
   * <ul>
   *   <li>Given {@link Auditable} (default constructor) CreatedBy is one.</li>
   *   <li>Then return {@link ProcessContext}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ConsolidateFulfillmentFeesActivity#execute(ProcessContext)}
   */
  @Test
  public void testExecute_givenAuditableCreatedByIsOne_thenReturnProcessContext() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ConsolidateFulfillmentFeesActivity consolidateFulfillmentFeesActivity = new ConsolidateFulfillmentFeesActivity();

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
    orderImpl.setName("Name");
    orderImpl.setOrderAttributes(new HashMap<>());
    orderImpl.setOrderItems(new ArrayList<>());
    orderImpl.setOrderMessages(new ArrayList<>());
    orderImpl.setOrderNumber("42");
    orderImpl.setPayments(new ArrayList<>());
    orderImpl.setStatus(OrderStatus.ARCHIVED);
    orderImpl.setSubTotal(new Money());
    orderImpl.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    orderImpl.setTaxOverride(true);
    orderImpl.setTotal(new Money());
    orderImpl.setTotalFulfillmentCharges(new Money());
    orderImpl.setTotalShipping(new Money());
    orderImpl.setTotalTax(new Money());
    ProcessContext<Order> context = mock(ProcessContext.class);
    doNothing().when(context).setSeedData(Mockito.<Order>any());
    when(context.getSeedData()).thenReturn(orderImpl);

    // Act
    ProcessContext<Order> actualExecuteResult = consolidateFulfillmentFeesActivity.execute(context);

    // Assert
    verify(context).getSeedData();
    verify(context).setSeedData(isA(Order.class));
    assertSame(context, actualExecuteResult);
  }

  /**
   * Test
   * {@link ConsolidateFulfillmentFeesActivity#shouldApplyFeeToFulfillmentGroup(SkuFee, FulfillmentGroup)}.
   * <p>
   * Method under test:
   * {@link ConsolidateFulfillmentFeesActivity#shouldApplyFeeToFulfillmentGroup(SkuFee, FulfillmentGroup)}
   */
  @Test
  public void testShouldApplyFeeToFulfillmentGroup() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ConsolidateFulfillmentFeesActivity consolidateFulfillmentFeesActivity = new ConsolidateFulfillmentFeesActivity();
    SkuFeeImpl fee = mock(SkuFeeImpl.class);
    when(fee.getExpression()).thenReturn("org.broadleafcommerce.core.catalog.domain.SkuFeeImpl");

    // Act
    boolean actualShouldApplyFeeToFulfillmentGroupResult = consolidateFulfillmentFeesActivity
        .shouldApplyFeeToFulfillmentGroup(fee, new FulfillmentGroupImpl());

    // Assert
    verify(fee).getExpression();
    assertTrue(actualShouldApplyFeeToFulfillmentGroupResult);
  }

  /**
   * Test
   * {@link ConsolidateFulfillmentFeesActivity#shouldApplyFeeToFulfillmentGroup(SkuFee, FulfillmentGroup)}.
   * <p>
   * Method under test:
   * {@link ConsolidateFulfillmentFeesActivity#shouldApplyFeeToFulfillmentGroup(SkuFee, FulfillmentGroup)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testShouldApplyFeeToFulfillmentGroup2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.pricing.service.workflow;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass14 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.pricing.service.workflow.ConsolidateFulfillmentFeesActivity consolidateFulfillmentFeesActivity;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    ConsolidateFulfillmentFeesActivity consolidateFulfillmentFeesActivity2 = new ConsolidateFulfillmentFeesActivity();
    SkuFeeImpl fee = new SkuFeeImpl();

    // Act
    consolidateFulfillmentFeesActivity2.shouldApplyFeeToFulfillmentGroup(fee, new FulfillmentGroupImpl());
  }

  /**
   * Test
   * {@link ConsolidateFulfillmentFeesActivity#shouldApplyFeeToFulfillmentGroup(SkuFee, FulfillmentGroup)}.
   * <ul>
   *   <li>Given empty string.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ConsolidateFulfillmentFeesActivity#shouldApplyFeeToFulfillmentGroup(SkuFee, FulfillmentGroup)}
   */
  @Test
  public void testShouldApplyFeeToFulfillmentGroup_givenEmptyString() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ConsolidateFulfillmentFeesActivity consolidateFulfillmentFeesActivity = new ConsolidateFulfillmentFeesActivity();

    SkuFeeImpl fee = new SkuFeeImpl();
    fee.setAmount(new Money());
    fee.setCurrency(new BroadleafCurrencyImpl());
    fee.setDescription("The characteristics of someone or something");
    fee.setFeeType(SkuFeeType.FULFILLMENT);
    fee.setId(1L);
    fee.setName("Name");
    fee.setSkus(new ArrayList<>());
    fee.setTaxable(true);
    fee.setExpression("");

    // Act and Assert
    assertTrue(consolidateFulfillmentFeesActivity.shouldApplyFeeToFulfillmentGroup(fee, new FulfillmentGroupImpl()));
  }

  /**
   * Test
   * {@link ConsolidateFulfillmentFeesActivity#shouldApplyFeeToFulfillmentGroup(SkuFee, FulfillmentGroup)}.
   * <ul>
   *   <li>Given {@code Expression}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ConsolidateFulfillmentFeesActivity#shouldApplyFeeToFulfillmentGroup(SkuFee, FulfillmentGroup)}
   */
  @Test
  public void testShouldApplyFeeToFulfillmentGroup_givenExpression() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ConsolidateFulfillmentFeesActivity consolidateFulfillmentFeesActivity = new ConsolidateFulfillmentFeesActivity();
    SkuFeeImpl fee = mock(SkuFeeImpl.class);
    when(fee.getExpression()).thenReturn("Expression");

    // Act
    boolean actualShouldApplyFeeToFulfillmentGroupResult = consolidateFulfillmentFeesActivity
        .shouldApplyFeeToFulfillmentGroup(fee, new FulfillmentGroupImpl());

    // Assert
    verify(fee).getExpression();
    assertTrue(actualShouldApplyFeeToFulfillmentGroupResult);
  }

  /**
   * Test
   * {@link ConsolidateFulfillmentFeesActivity#shouldApplyFeeToFulfillmentGroup(SkuFee, FulfillmentGroup)}.
   * <ul>
   *   <li>Given {@code Expression}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ConsolidateFulfillmentFeesActivity#shouldApplyFeeToFulfillmentGroup(SkuFee, FulfillmentGroup)}
   */
  @Test
  public void testShouldApplyFeeToFulfillmentGroup_givenExpression2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ConsolidateFulfillmentFeesActivity consolidateFulfillmentFeesActivity = new ConsolidateFulfillmentFeesActivity();
    SkuFeeImpl fee = mock(SkuFeeImpl.class);
    when(fee.getExpression()).thenReturn("Expression");

    // Act
    boolean actualShouldApplyFeeToFulfillmentGroupResult = consolidateFulfillmentFeesActivity
        .shouldApplyFeeToFulfillmentGroup(fee, null);

    // Assert
    verify(fee).getExpression();
    assertTrue(actualShouldApplyFeeToFulfillmentGroupResult);
  }

  /**
   * Test
   * {@link ConsolidateFulfillmentFeesActivity#shouldApplyFeeToFulfillmentGroup(SkuFee, FulfillmentGroup)}.
   * <ul>
   *   <li>Given {@code Fee}.</li>
   *   <li>When {@link SkuFeeImpl} (default constructor) Expression is
   * {@code Fee}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ConsolidateFulfillmentFeesActivity#shouldApplyFeeToFulfillmentGroup(SkuFee, FulfillmentGroup)}
   */
  @Test
  public void testShouldApplyFeeToFulfillmentGroup_givenFee_whenSkuFeeImplExpressionIsFee() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ConsolidateFulfillmentFeesActivity consolidateFulfillmentFeesActivity = new ConsolidateFulfillmentFeesActivity();

    SkuFeeImpl fee = new SkuFeeImpl();
    fee.setAmount(new Money());
    fee.setCurrency(new BroadleafCurrencyImpl());
    fee.setDescription("The characteristics of someone or something");
    fee.setFeeType(SkuFeeType.FULFILLMENT);
    fee.setId(1L);
    fee.setName("Name");
    fee.setSkus(new ArrayList<>());
    fee.setTaxable(true);
    fee.setExpression("Fee");

    // Act and Assert
    assertTrue(consolidateFulfillmentFeesActivity.shouldApplyFeeToFulfillmentGroup(fee, new FulfillmentGroupImpl()));
  }

  /**
   * Test
   * {@link ConsolidateFulfillmentFeesActivity#shouldApplyFeeToFulfillmentGroup(SkuFee, FulfillmentGroup)}.
   * <ul>
   *   <li>Given {@code fulfillmentGroup}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ConsolidateFulfillmentFeesActivity#shouldApplyFeeToFulfillmentGroup(SkuFee, FulfillmentGroup)}
   */
  @Test
  public void testShouldApplyFeeToFulfillmentGroup_givenFulfillmentGroup() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ConsolidateFulfillmentFeesActivity consolidateFulfillmentFeesActivity = new ConsolidateFulfillmentFeesActivity();
    SkuFeeImpl fee = mock(SkuFeeImpl.class);
    when(fee.getExpression()).thenReturn("fulfillmentGroup");

    // Act
    boolean actualShouldApplyFeeToFulfillmentGroupResult = consolidateFulfillmentFeesActivity
        .shouldApplyFeeToFulfillmentGroup(fee, new FulfillmentGroupImpl());

    // Assert
    verify(fee).getExpression();
    assertTrue(actualShouldApplyFeeToFulfillmentGroupResult);
  }

  /**
   * Test
   * {@link ConsolidateFulfillmentFeesActivity#shouldApplyFeeToFulfillmentGroup(SkuFee, FulfillmentGroup)}.
   * <ul>
   *   <li>Given {@code fulfillmentGroup}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ConsolidateFulfillmentFeesActivity#shouldApplyFeeToFulfillmentGroup(SkuFee, FulfillmentGroup)}
   */
  @Test
  public void testShouldApplyFeeToFulfillmentGroup_givenFulfillmentGroup2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ConsolidateFulfillmentFeesActivity consolidateFulfillmentFeesActivity = new ConsolidateFulfillmentFeesActivity();
    SkuFeeImpl fee = mock(SkuFeeImpl.class);
    when(fee.getExpression()).thenReturn("fulfillmentGroup");

    // Act
    boolean actualShouldApplyFeeToFulfillmentGroupResult = consolidateFulfillmentFeesActivity
        .shouldApplyFeeToFulfillmentGroup(fee, null);

    // Assert
    verify(fee).getExpression();
    assertTrue(actualShouldApplyFeeToFulfillmentGroupResult);
  }

  /**
   * Test
   * {@link ConsolidateFulfillmentFeesActivity#shouldApplyFeeToFulfillmentGroup(SkuFee, FulfillmentGroup)}.
   * <ul>
   *   <li>Given {@code getAdditionalAttributes()[UU]}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ConsolidateFulfillmentFeesActivity#shouldApplyFeeToFulfillmentGroup(SkuFee, FulfillmentGroup)}
   */
  @Test
  public void testShouldApplyFeeToFulfillmentGroup_givenGetAdditionalAttributesUu() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ConsolidateFulfillmentFeesActivity consolidateFulfillmentFeesActivity = new ConsolidateFulfillmentFeesActivity();
    SkuFeeImpl fee = mock(SkuFeeImpl.class);
    when(fee.getExpression()).thenReturn("getAdditionalAttributes()[UU]");

    // Act
    boolean actualShouldApplyFeeToFulfillmentGroupResult = consolidateFulfillmentFeesActivity
        .shouldApplyFeeToFulfillmentGroup(fee, new FulfillmentGroupImpl());

    // Assert
    verify(fee).getExpression();
    assertTrue(actualShouldApplyFeeToFulfillmentGroupResult);
  }

  /**
   * Test
   * {@link ConsolidateFulfillmentFeesActivity#shouldApplyFeeToFulfillmentGroup(SkuFee, FulfillmentGroup)}.
   * <ul>
   *   <li>Given {@code getAdditionalFields()[UU]}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ConsolidateFulfillmentFeesActivity#shouldApplyFeeToFulfillmentGroup(SkuFee, FulfillmentGroup)}
   */
  @Test
  public void testShouldApplyFeeToFulfillmentGroup_givenGetAdditionalFieldsUu() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ConsolidateFulfillmentFeesActivity consolidateFulfillmentFeesActivity = new ConsolidateFulfillmentFeesActivity();
    SkuFeeImpl fee = mock(SkuFeeImpl.class);
    when(fee.getExpression()).thenReturn("getAdditionalFields()[UU]");

    // Act
    boolean actualShouldApplyFeeToFulfillmentGroupResult = consolidateFulfillmentFeesActivity
        .shouldApplyFeeToFulfillmentGroup(fee, new FulfillmentGroupImpl());

    // Assert
    verify(fee).getExpression();
    assertTrue(actualShouldApplyFeeToFulfillmentGroupResult);
  }

  /**
   * Test
   * {@link ConsolidateFulfillmentFeesActivity#shouldApplyFeeToFulfillmentGroup(SkuFee, FulfillmentGroup)}.
   * <ul>
   *   <li>Given {@code getCategoryAttributesMap()[UU]}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ConsolidateFulfillmentFeesActivity#shouldApplyFeeToFulfillmentGroup(SkuFee, FulfillmentGroup)}
   */
  @Test
  public void testShouldApplyFeeToFulfillmentGroup_givenGetCategoryAttributesMapUu() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ConsolidateFulfillmentFeesActivity consolidateFulfillmentFeesActivity = new ConsolidateFulfillmentFeesActivity();
    SkuFeeImpl fee = mock(SkuFeeImpl.class);
    when(fee.getExpression()).thenReturn("getCategoryAttributesMap()[UU]");

    // Act
    boolean actualShouldApplyFeeToFulfillmentGroupResult = consolidateFulfillmentFeesActivity
        .shouldApplyFeeToFulfillmentGroup(fee, new FulfillmentGroupImpl());

    // Assert
    verify(fee).getExpression();
    assertTrue(actualShouldApplyFeeToFulfillmentGroupResult);
  }

  /**
   * Test
   * {@link ConsolidateFulfillmentFeesActivity#shouldApplyFeeToFulfillmentGroup(SkuFee, FulfillmentGroup)}.
   * <ul>
   *   <li>Given {@code getCustomerAttributes()[UU]}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ConsolidateFulfillmentFeesActivity#shouldApplyFeeToFulfillmentGroup(SkuFee, FulfillmentGroup)}
   */
  @Test
  public void testShouldApplyFeeToFulfillmentGroup_givenGetCustomerAttributesUu() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ConsolidateFulfillmentFeesActivity consolidateFulfillmentFeesActivity = new ConsolidateFulfillmentFeesActivity();
    SkuFeeImpl fee = mock(SkuFeeImpl.class);
    when(fee.getExpression()).thenReturn("getCustomerAttributes()[UU]");

    // Act
    boolean actualShouldApplyFeeToFulfillmentGroupResult = consolidateFulfillmentFeesActivity
        .shouldApplyFeeToFulfillmentGroup(fee, new FulfillmentGroupImpl());

    // Assert
    verify(fee).getExpression();
    assertTrue(actualShouldApplyFeeToFulfillmentGroupResult);
  }

  /**
   * Test
   * {@link ConsolidateFulfillmentFeesActivity#shouldApplyFeeToFulfillmentGroup(SkuFee, FulfillmentGroup)}.
   * <ul>
   *   <li>Given {@code getOrderItemAttributes()[UU]}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ConsolidateFulfillmentFeesActivity#shouldApplyFeeToFulfillmentGroup(SkuFee, FulfillmentGroup)}
   */
  @Test
  public void testShouldApplyFeeToFulfillmentGroup_givenGetOrderItemAttributesUu() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ConsolidateFulfillmentFeesActivity consolidateFulfillmentFeesActivity = new ConsolidateFulfillmentFeesActivity();
    SkuFeeImpl fee = mock(SkuFeeImpl.class);
    when(fee.getExpression()).thenReturn("getOrderItemAttributes()[UU]");

    // Act
    boolean actualShouldApplyFeeToFulfillmentGroupResult = consolidateFulfillmentFeesActivity
        .shouldApplyFeeToFulfillmentGroup(fee, new FulfillmentGroupImpl());

    // Assert
    verify(fee).getExpression();
    assertTrue(actualShouldApplyFeeToFulfillmentGroupResult);
  }

  /**
   * Test
   * {@link ConsolidateFulfillmentFeesActivity#shouldApplyFeeToFulfillmentGroup(SkuFee, FulfillmentGroup)}.
   * <ul>
   *   <li>Given {@code getProductAttributes()[UU]}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ConsolidateFulfillmentFeesActivity#shouldApplyFeeToFulfillmentGroup(SkuFee, FulfillmentGroup)}
   */
  @Test
  public void testShouldApplyFeeToFulfillmentGroup_givenGetProductAttributesUu() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ConsolidateFulfillmentFeesActivity consolidateFulfillmentFeesActivity = new ConsolidateFulfillmentFeesActivity();
    SkuFeeImpl fee = mock(SkuFeeImpl.class);
    when(fee.getExpression()).thenReturn("getProductAttributes()[UU]");

    // Act
    boolean actualShouldApplyFeeToFulfillmentGroupResult = consolidateFulfillmentFeesActivity
        .shouldApplyFeeToFulfillmentGroup(fee, new FulfillmentGroupImpl());

    // Assert
    verify(fee).getExpression();
    assertTrue(actualShouldApplyFeeToFulfillmentGroupResult);
  }

  /**
   * Test
   * {@link ConsolidateFulfillmentFeesActivity#shouldApplyFeeToFulfillmentGroup(SkuFee, FulfillmentGroup)}.
   * <ul>
   *   <li>Given {@code getSkuAttributes()[UU]}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ConsolidateFulfillmentFeesActivity#shouldApplyFeeToFulfillmentGroup(SkuFee, FulfillmentGroup)}
   */
  @Test
  public void testShouldApplyFeeToFulfillmentGroup_givenGetSkuAttributesUu() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ConsolidateFulfillmentFeesActivity consolidateFulfillmentFeesActivity = new ConsolidateFulfillmentFeesActivity();
    SkuFeeImpl fee = mock(SkuFeeImpl.class);
    when(fee.getExpression()).thenReturn("getSkuAttributes()[UU]");

    // Act
    boolean actualShouldApplyFeeToFulfillmentGroupResult = consolidateFulfillmentFeesActivity
        .shouldApplyFeeToFulfillmentGroup(fee, new FulfillmentGroupImpl());

    // Assert
    verify(fee).getExpression();
    assertTrue(actualShouldApplyFeeToFulfillmentGroupResult);
  }

  /**
   * Test
   * {@link ConsolidateFulfillmentFeesActivity#shouldApplyFeeToFulfillmentGroup(SkuFee, FulfillmentGroup)}.
   * <ul>
   *   <li>Given {@code MVEL}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ConsolidateFulfillmentFeesActivity#shouldApplyFeeToFulfillmentGroup(SkuFee, FulfillmentGroup)}
   */
  @Test
  public void testShouldApplyFeeToFulfillmentGroup_givenMvel() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ConsolidateFulfillmentFeesActivity consolidateFulfillmentFeesActivity = new ConsolidateFulfillmentFeesActivity();
    SkuFeeImpl fee = mock(SkuFeeImpl.class);
    when(fee.getExpression()).thenReturn("MVEL");

    // Act
    boolean actualShouldApplyFeeToFulfillmentGroupResult = consolidateFulfillmentFeesActivity
        .shouldApplyFeeToFulfillmentGroup(fee, new FulfillmentGroupImpl());

    // Assert
    verify(fee).getExpression();
    assertTrue(actualShouldApplyFeeToFulfillmentGroupResult);
  }

  /**
   * Test
   * {@link ConsolidateFulfillmentFeesActivity#shouldApplyFeeToFulfillmentGroup(SkuFee, FulfillmentGroup)}.
   * <ul>
   *   <li>When {@link SkuFeeImpl} (default constructor).</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ConsolidateFulfillmentFeesActivity#shouldApplyFeeToFulfillmentGroup(SkuFee, FulfillmentGroup)}
   */
  @Test
  public void testShouldApplyFeeToFulfillmentGroup_whenSkuFeeImpl_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ConsolidateFulfillmentFeesActivity consolidateFulfillmentFeesActivity = new ConsolidateFulfillmentFeesActivity();
    SkuFeeImpl fee = new SkuFeeImpl();

    // Act and Assert
    assertTrue(consolidateFulfillmentFeesActivity.shouldApplyFeeToFulfillmentGroup(fee, new FulfillmentGroupImpl()));
  }
}
