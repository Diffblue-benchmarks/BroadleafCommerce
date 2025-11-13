package org.broadleafcommerce.core.order.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.core.offer.domain.CandidateFulfillmentGroupOffer;
import org.broadleafcommerce.core.offer.domain.CandidateFulfillmentGroupOfferImpl;
import org.broadleafcommerce.core.offer.domain.FulfillmentGroupAdjustment;
import org.broadleafcommerce.core.order.service.type.FulfillmentGroupStatusType;
import org.broadleafcommerce.core.order.service.type.FulfillmentType;
import org.broadleafcommerce.profile.core.domain.Address;
import org.broadleafcommerce.profile.core.domain.AddressImpl;
import org.broadleafcommerce.profile.core.domain.Phone;
import org.broadleafcommerce.profile.core.domain.PhoneImpl;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml"})
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(SpringJUnit4ClassRunner.class)
public class FulfillmentGroupImplDiffblueTest {
  @Autowired private FulfillmentGroupImpl fulfillmentGroupImpl;

  /**
   * Test {@link FulfillmentGroupImpl#addFulfillmentGroupItem(FulfillmentGroupItem)}.
   *
   * <ul>
   *   <li>Given {@link FulfillmentGroupImpl}.
   * </ul>
   *
   * <p>Method under test: {@link
   * FulfillmentGroupImpl#addFulfillmentGroupItem(FulfillmentGroupItem)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void FulfillmentGroupImpl.addFulfillmentGroupItem(FulfillmentGroupItem)"})
  public void testAddFulfillmentGroupItem_givenFulfillmentGroupImpl() {
    // Arrange
    FulfillmentGroupItemImpl fulfillmentGroupItem = new FulfillmentGroupItemImpl();

    // Act
    fulfillmentGroupImpl.addFulfillmentGroupItem(fulfillmentGroupItem);

    // Assert
    List<FulfillmentGroupItem> fulfillmentGroupItems =
        fulfillmentGroupImpl.getFulfillmentGroupItems();
    assertEquals(1, fulfillmentGroupItems.size());
    assertTrue(fulfillmentGroupImpl.getDiscreteOrderItems().isEmpty());
    assertSame(fulfillmentGroupItem, fulfillmentGroupItems.get(0));
  }

  /**
   * Test {@link FulfillmentGroupImpl#addFulfillmentGroupItem(FulfillmentGroupItem)}.
   *
   * <ul>
   *   <li>Given {@link FulfillmentGroupImpl} FulfillmentGroupItems is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * FulfillmentGroupImpl#addFulfillmentGroupItem(FulfillmentGroupItem)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void FulfillmentGroupImpl.addFulfillmentGroupItem(FulfillmentGroupItem)"})
  public void testAddFulfillmentGroupItem_givenFulfillmentGroupImplFulfillmentGroupItemsIsNull() {
    // Arrange
    fulfillmentGroupImpl.setFulfillmentGroupItems(null);
    FulfillmentGroupItemImpl fulfillmentGroupItem = new FulfillmentGroupItemImpl();

    // Act
    fulfillmentGroupImpl.addFulfillmentGroupItem(fulfillmentGroupItem);

    // Assert
    List<FulfillmentGroupItem> fulfillmentGroupItems =
        fulfillmentGroupImpl.getFulfillmentGroupItems();
    assertEquals(1, fulfillmentGroupItems.size());
    assertTrue(fulfillmentGroupImpl.getDiscreteOrderItems().isEmpty());
    assertSame(fulfillmentGroupItem, fulfillmentGroupItems.get(0));
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link FulfillmentGroupImpl#setAddress(Address)}
   *   <li>{@link FulfillmentGroupImpl#setCandidateFulfillmentGroupOffer(List)}
   *   <li>{@link FulfillmentGroupImpl#setDeliveryInstruction(String)}
   *   <li>{@link FulfillmentGroupImpl#setFulfillmentGroupAdjustments(List)}
   *   <li>{@link FulfillmentGroupImpl#setFulfillmentGroupFees(List)}
   *   <li>{@link FulfillmentGroupImpl#setFulfillmentGroupItems(List)}
   *   <li>{@link FulfillmentGroupImpl#setFulfillmentOption(FulfillmentOption)}
   *   <li>{@link FulfillmentGroupImpl#setId(Long)}
   *   <li>{@link FulfillmentGroupImpl#setIsShippingPriceTaxable(Boolean)}
   *   <li>{@link FulfillmentGroupImpl#setMethod(String)}
   *   <li>{@link FulfillmentGroupImpl#setOrder(Order)}
   *   <li>{@link FulfillmentGroupImpl#setPersonalMessage(PersonalMessage)}
   *   <li>{@link FulfillmentGroupImpl#setPhone(Phone)}
   *   <li>{@link FulfillmentGroupImpl#setPrimary(boolean)}
   *   <li>{@link FulfillmentGroupImpl#setReferenceNumber(String)}
   *   <li>{@link FulfillmentGroupImpl#setSequence(Integer)}
   *   <li>{@link FulfillmentGroupImpl#setService(String)}
   *   <li>{@link FulfillmentGroupImpl#setShippingOverride(Boolean)}
   *   <li>{@link FulfillmentGroupImpl#setTaxes(List)}
   *   <li>{@link FulfillmentGroupImpl#getAddress()}
   *   <li>{@link FulfillmentGroupImpl#getCandidateFulfillmentGroupOffers()}
   *   <li>{@link FulfillmentGroupImpl#getDeliveryInstruction()}
   *   <li>{@link FulfillmentGroupImpl#getFulfillmentGroupAdjustments()}
   *   <li>{@link FulfillmentGroupImpl#getFulfillmentGroupFees()}
   *   <li>{@link FulfillmentGroupImpl#getFulfillmentGroupItems()}
   *   <li>{@link FulfillmentGroupImpl#getFulfillmentOption()}
   *   <li>{@link FulfillmentGroupImpl#getId()}
   *   <li>{@link FulfillmentGroupImpl#getMethod()}
   *   <li>{@link FulfillmentGroupImpl#getOrder()}
   *   <li>{@link FulfillmentGroupImpl#getPersonalMessage()}
   *   <li>{@link FulfillmentGroupImpl#getPhone()}
   *   <li>{@link FulfillmentGroupImpl#getReferenceNumber()}
   *   <li>{@link FulfillmentGroupImpl#getSequence()}
   *   <li>{@link FulfillmentGroupImpl#getService()}
   *   <li>{@link FulfillmentGroupImpl#getTaxes()}
   *   <li>{@link FulfillmentGroupImpl#isPrimary()}
   *   <li>{@link FulfillmentGroupImpl#isShippingPriceTaxable()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Address FulfillmentGroupImpl.getAddress()",
    "List FulfillmentGroupImpl.getCandidateFulfillmentGroupOffers()",
    "String FulfillmentGroupImpl.getDeliveryInstruction()",
    "List FulfillmentGroupImpl.getFulfillmentGroupAdjustments()",
    "List FulfillmentGroupImpl.getFulfillmentGroupFees()",
    "List FulfillmentGroupImpl.getFulfillmentGroupItems()",
    "FulfillmentOption FulfillmentGroupImpl.getFulfillmentOption()",
    "Long FulfillmentGroupImpl.getId()",
    "String FulfillmentGroupImpl.getMethod()",
    "Order FulfillmentGroupImpl.getOrder()",
    "PersonalMessage FulfillmentGroupImpl.getPersonalMessage()",
    "Phone FulfillmentGroupImpl.getPhone()",
    "String FulfillmentGroupImpl.getReferenceNumber()",
    "Integer FulfillmentGroupImpl.getSequence()",
    "String FulfillmentGroupImpl.getService()",
    "List FulfillmentGroupImpl.getTaxes()",
    "boolean FulfillmentGroupImpl.isPrimary()",
    "Boolean FulfillmentGroupImpl.isShippingPriceTaxable()",
    "void FulfillmentGroupImpl.setAddress(Address)",
    "void FulfillmentGroupImpl.setCandidateFulfillmentGroupOffer(List)",
    "void FulfillmentGroupImpl.setDeliveryInstruction(String)",
    "void FulfillmentGroupImpl.setFulfillmentGroupAdjustments(List)",
    "void FulfillmentGroupImpl.setFulfillmentGroupFees(List)",
    "void FulfillmentGroupImpl.setFulfillmentGroupItems(List)",
    "void FulfillmentGroupImpl.setFulfillmentOption(FulfillmentOption)",
    "void FulfillmentGroupImpl.setId(Long)",
    "void FulfillmentGroupImpl.setIsShippingPriceTaxable(Boolean)",
    "void FulfillmentGroupImpl.setMethod(String)",
    "void FulfillmentGroupImpl.setOrder(Order)",
    "void FulfillmentGroupImpl.setPersonalMessage(PersonalMessage)",
    "void FulfillmentGroupImpl.setPhone(Phone)",
    "void FulfillmentGroupImpl.setPrimary(boolean)",
    "void FulfillmentGroupImpl.setReferenceNumber(String)",
    "void FulfillmentGroupImpl.setSequence(Integer)",
    "void FulfillmentGroupImpl.setService(String)",
    "void FulfillmentGroupImpl.setShippingOverride(Boolean)",
    "void FulfillmentGroupImpl.setTaxes(List)"
  })
  public void testGettersAndSetters() {
    // Arrange
    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    AddressImpl address = new AddressImpl();

    // Act
    fulfillmentGroupImpl.setAddress(address);
    ArrayList<CandidateFulfillmentGroupOffer> candidateOffers = new ArrayList<>();
    fulfillmentGroupImpl.setCandidateFulfillmentGroupOffer(candidateOffers);
    fulfillmentGroupImpl.setDeliveryInstruction("Delivery Instruction");
    ArrayList<FulfillmentGroupAdjustment> fulfillmentGroupAdjustments = new ArrayList<>();
    fulfillmentGroupImpl.setFulfillmentGroupAdjustments(fulfillmentGroupAdjustments);
    ArrayList<FulfillmentGroupFee> fulfillmentGroupFees = new ArrayList<>();
    fulfillmentGroupImpl.setFulfillmentGroupFees(fulfillmentGroupFees);
    ArrayList<FulfillmentGroupItem> fulfillmentGroupItems = new ArrayList<>();
    fulfillmentGroupImpl.setFulfillmentGroupItems(fulfillmentGroupItems);
    FulfillmentOptionImpl fulfillmentOption = new FulfillmentOptionImpl();
    fulfillmentGroupImpl.setFulfillmentOption(fulfillmentOption);
    fulfillmentGroupImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    fulfillmentGroupImpl.setIsShippingPriceTaxable(true);
    fulfillmentGroupImpl.setMethod("Fulfillment Method");
    Order order = NullOrderFactoryImpl.NULL_ORDER;
    fulfillmentGroupImpl.setOrder(order);
    PersonalMessageImpl personalMessage = new PersonalMessageImpl();
    fulfillmentGroupImpl.setPersonalMessage(personalMessage);
    PhoneImpl phone = new PhoneImpl();
    fulfillmentGroupImpl.setPhone(phone);
    fulfillmentGroupImpl.setPrimary(true);
    fulfillmentGroupImpl.setReferenceNumber("42");
    fulfillmentGroupImpl.setSequence(1);
    fulfillmentGroupImpl.setService("Service");
    fulfillmentGroupImpl.setShippingOverride(true);
    ArrayList<TaxDetail> taxes = new ArrayList<>();
    fulfillmentGroupImpl.setTaxes(taxes);
    Address actualAddress = fulfillmentGroupImpl.getAddress();
    List<CandidateFulfillmentGroupOffer> actualCandidateFulfillmentGroupOffers =
        fulfillmentGroupImpl.getCandidateFulfillmentGroupOffers();
    String actualDeliveryInstruction = fulfillmentGroupImpl.getDeliveryInstruction();
    List<FulfillmentGroupAdjustment> actualFulfillmentGroupAdjustments =
        fulfillmentGroupImpl.getFulfillmentGroupAdjustments();
    List<FulfillmentGroupFee> actualFulfillmentGroupFees =
        fulfillmentGroupImpl.getFulfillmentGroupFees();
    List<FulfillmentGroupItem> actualFulfillmentGroupItems =
        fulfillmentGroupImpl.getFulfillmentGroupItems();
    FulfillmentOption actualFulfillmentOption = fulfillmentGroupImpl.getFulfillmentOption();
    Long actualId = fulfillmentGroupImpl.getId();
    String actualMethod = fulfillmentGroupImpl.getMethod();
    Order actualOrder = fulfillmentGroupImpl.getOrder();
    PersonalMessage actualPersonalMessage = fulfillmentGroupImpl.getPersonalMessage();
    Phone actualPhone = fulfillmentGroupImpl.getPhone();
    String actualReferenceNumber = fulfillmentGroupImpl.getReferenceNumber();
    Integer actualSequence = fulfillmentGroupImpl.getSequence();
    String actualService = fulfillmentGroupImpl.getService();
    List<TaxDetail> actualTaxes = fulfillmentGroupImpl.getTaxes();
    boolean actualIsPrimaryResult = fulfillmentGroupImpl.isPrimary();
    Boolean actualIsShippingPriceTaxableResult = fulfillmentGroupImpl.isShippingPriceTaxable();

    // Assert
    assertTrue(actualPersonalMessage instanceof PersonalMessageImpl);
    assertTrue(actualPhone instanceof PhoneImpl);
    assertEquals("42", actualReferenceNumber);
    assertEquals("Delivery Instruction", actualDeliveryInstruction);
    assertEquals("Fulfillment Method", actualMethod);
    assertEquals("Service", actualService);
    assertEquals(1, actualSequence.intValue());
    assertTrue(actualCandidateFulfillmentGroupOffers.isEmpty());
    assertTrue(actualFulfillmentGroupAdjustments.isEmpty());
    assertTrue(actualFulfillmentGroupFees.isEmpty());
    assertTrue(actualFulfillmentGroupItems.isEmpty());
    assertTrue(actualIsPrimaryResult);
    assertTrue(actualIsShippingPriceTaxableResult);
    assertEquals(OrderItemQualifierImpl.serialVersionUID, actualId.longValue());
    assertSame(candidateOffers, actualCandidateFulfillmentGroupOffers);
    assertSame(fulfillmentGroupAdjustments, actualFulfillmentGroupAdjustments);
    assertSame(fulfillmentGroupFees, actualFulfillmentGroupFees);
    assertSame(fulfillmentGroupItems, actualFulfillmentGroupItems);
    assertSame(taxes, actualTaxes);
    assertSame(fulfillmentOption, actualFulfillmentOption);
    assertSame(personalMessage, actualPersonalMessage);
    assertSame(address, actualAddress);
    assertSame(phone, actualPhone);
    assertSame(order, actualOrder);
  }

  /**
   * Test {@link
   * FulfillmentGroupImpl#addCandidateFulfillmentGroupOffer(CandidateFulfillmentGroupOffer)}.
   *
   * <p>Method under test: {@link
   * FulfillmentGroupImpl#addCandidateFulfillmentGroupOffer(CandidateFulfillmentGroupOffer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void FulfillmentGroupImpl.addCandidateFulfillmentGroupOffer(CandidateFulfillmentGroupOffer)"
  })
  public void testAddCandidateFulfillmentGroupOffer() {
    // Arrange
    CandidateFulfillmentGroupOfferImpl candidateOffer = new CandidateFulfillmentGroupOfferImpl();

    // Act
    fulfillmentGroupImpl.addCandidateFulfillmentGroupOffer(candidateOffer);

    // Assert
    List<CandidateFulfillmentGroupOffer> candidateFulfillmentGroupOffers =
        fulfillmentGroupImpl.getCandidateFulfillmentGroupOffers();
    assertEquals(1, candidateFulfillmentGroupOffers.size());
    assertSame(candidateOffer, candidateFulfillmentGroupOffers.get(0));
  }

  /**
   * Test {@link FulfillmentGroupImpl#addFulfillmentGroupFee(FulfillmentGroupFee)}.
   *
   * <ul>
   *   <li>Given {@link FulfillmentGroupImpl}.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupImpl#addFulfillmentGroupFee(FulfillmentGroupFee)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void FulfillmentGroupImpl.addFulfillmentGroupFee(FulfillmentGroupFee)"})
  public void testAddFulfillmentGroupFee_givenFulfillmentGroupImpl() {
    // Arrange
    FulfillmentGroupFeeImpl fulfillmentGroupFee = new FulfillmentGroupFeeImpl();

    // Act
    fulfillmentGroupImpl.addFulfillmentGroupFee(fulfillmentGroupFee);

    // Assert
    List<FulfillmentGroupFee> fulfillmentGroupFees = fulfillmentGroupImpl.getFulfillmentGroupFees();
    assertEquals(1, fulfillmentGroupFees.size());
    assertSame(fulfillmentGroupFee, fulfillmentGroupFees.get(0));
  }

  /**
   * Test {@link FulfillmentGroupImpl#addFulfillmentGroupFee(FulfillmentGroupFee)}.
   *
   * <ul>
   *   <li>Given {@link FulfillmentGroupImpl} FulfillmentGroupFees is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupImpl#addFulfillmentGroupFee(FulfillmentGroupFee)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void FulfillmentGroupImpl.addFulfillmentGroupFee(FulfillmentGroupFee)"})
  public void testAddFulfillmentGroupFee_givenFulfillmentGroupImplFulfillmentGroupFeesIsNull() {
    // Arrange
    fulfillmentGroupImpl.setFulfillmentGroupFees(null);
    FulfillmentGroupFeeImpl fulfillmentGroupFee = new FulfillmentGroupFeeImpl();

    // Act
    fulfillmentGroupImpl.addFulfillmentGroupFee(fulfillmentGroupFee);

    // Assert
    List<FulfillmentGroupFee> fulfillmentGroupFees = fulfillmentGroupImpl.getFulfillmentGroupFees();
    assertEquals(1, fulfillmentGroupFees.size());
    assertSame(fulfillmentGroupFee, fulfillmentGroupFees.get(0));
  }

  /**
   * Test {@link FulfillmentGroupImpl#equals(Object)}, and {@link FulfillmentGroupImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link FulfillmentGroupImpl#equals(Object)}
   *   <li>{@link FulfillmentGroupImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean FulfillmentGroupImpl.equals(Object)",
    "int FulfillmentGroupImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    fulfillmentGroupImpl.setAddress(new AddressImpl());
    fulfillmentGroupImpl.setCandidateFulfillmentGroupOffer(new ArrayList<>());
    fulfillmentGroupImpl.setDeliveryInstruction("Delivery Instruction");
    fulfillmentGroupImpl.setFulfillmentGroupAdjustments(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentGroupFees(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentGroupItems(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentOption(new FulfillmentOptionImpl());
    fulfillmentGroupImpl.setFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    fulfillmentGroupImpl.setIsShippingPriceTaxable(true);
    fulfillmentGroupImpl.setMerchandiseTotal(new Money());
    fulfillmentGroupImpl.setMethod("Fulfillment Method");
    fulfillmentGroupImpl.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    fulfillmentGroupImpl.setPersonalMessage(new PersonalMessageImpl());
    fulfillmentGroupImpl.setPhone(new PhoneImpl());
    fulfillmentGroupImpl.setPrimary(true);
    fulfillmentGroupImpl.setReferenceNumber("42");
    fulfillmentGroupImpl.setRetailFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setSaleFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setSequence(1);
    fulfillmentGroupImpl.setService("Service");
    fulfillmentGroupImpl.setShippingOverride(true);
    fulfillmentGroupImpl.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroupImpl.setTaxes(new ArrayList<>());
    fulfillmentGroupImpl.setTotal(new Money());
    fulfillmentGroupImpl.setTotalFeeTax(new Money());
    fulfillmentGroupImpl.setTotalFulfillmentGroupTax(new Money());
    fulfillmentGroupImpl.setTotalItemTax(new Money());
    fulfillmentGroupImpl.setTotalTax(new Money());
    fulfillmentGroupImpl.setType(FulfillmentType.DIGITAL);

    FulfillmentGroupImpl fulfillmentGroupImpl2 = new FulfillmentGroupImpl();
    fulfillmentGroupImpl2.setAddress(new AddressImpl());
    fulfillmentGroupImpl2.setCandidateFulfillmentGroupOffer(new ArrayList<>());
    fulfillmentGroupImpl2.setDeliveryInstruction("Delivery Instruction");
    fulfillmentGroupImpl2.setFulfillmentGroupAdjustments(new ArrayList<>());
    fulfillmentGroupImpl2.setFulfillmentGroupFees(new ArrayList<>());
    fulfillmentGroupImpl2.setFulfillmentGroupItems(new ArrayList<>());
    fulfillmentGroupImpl2.setFulfillmentOption(new FulfillmentOptionImpl());
    fulfillmentGroupImpl2.setFulfillmentPrice(new Money());
    fulfillmentGroupImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    fulfillmentGroupImpl2.setIsShippingPriceTaxable(true);
    fulfillmentGroupImpl2.setMerchandiseTotal(new Money());
    fulfillmentGroupImpl2.setMethod("Fulfillment Method");
    fulfillmentGroupImpl2.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    fulfillmentGroupImpl2.setPersonalMessage(new PersonalMessageImpl());
    fulfillmentGroupImpl2.setPhone(new PhoneImpl());
    fulfillmentGroupImpl2.setPrimary(true);
    fulfillmentGroupImpl2.setReferenceNumber("42");
    fulfillmentGroupImpl2.setRetailFulfillmentPrice(new Money());
    fulfillmentGroupImpl2.setSaleFulfillmentPrice(new Money());
    fulfillmentGroupImpl2.setSequence(1);
    fulfillmentGroupImpl2.setService("Service");
    fulfillmentGroupImpl2.setShippingOverride(true);
    fulfillmentGroupImpl2.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroupImpl2.setTaxes(new ArrayList<>());
    fulfillmentGroupImpl2.setTotal(new Money());
    fulfillmentGroupImpl2.setTotalFeeTax(new Money());
    fulfillmentGroupImpl2.setTotalFulfillmentGroupTax(new Money());
    fulfillmentGroupImpl2.setTotalItemTax(new Money());
    fulfillmentGroupImpl2.setTotalTax(new Money());
    fulfillmentGroupImpl2.setType(FulfillmentType.DIGITAL);

    // Act and Assert
    assertEquals(fulfillmentGroupImpl, fulfillmentGroupImpl2);
    assertEquals(fulfillmentGroupImpl.hashCode(), fulfillmentGroupImpl2.hashCode());
  }

  /**
   * Test {@link FulfillmentGroupImpl#equals(Object)}, and {@link FulfillmentGroupImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link FulfillmentGroupImpl#equals(Object)}
   *   <li>{@link FulfillmentGroupImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean FulfillmentGroupImpl.equals(Object)",
    "int FulfillmentGroupImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    fulfillmentGroupImpl.setAddress(new AddressImpl());
    fulfillmentGroupImpl.setCandidateFulfillmentGroupOffer(new ArrayList<>());
    fulfillmentGroupImpl.setDeliveryInstruction("Delivery Instruction");
    fulfillmentGroupImpl.setFulfillmentGroupAdjustments(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentGroupFees(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentGroupItems(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentOption(new FulfillmentOptionImpl());
    fulfillmentGroupImpl.setFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setId(null);
    fulfillmentGroupImpl.setIsShippingPriceTaxable(true);
    fulfillmentGroupImpl.setMerchandiseTotal(new Money());
    fulfillmentGroupImpl.setMethod("Fulfillment Method");
    fulfillmentGroupImpl.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    fulfillmentGroupImpl.setPersonalMessage(new PersonalMessageImpl());
    fulfillmentGroupImpl.setPhone(new PhoneImpl());
    fulfillmentGroupImpl.setPrimary(true);
    fulfillmentGroupImpl.setReferenceNumber("42");
    fulfillmentGroupImpl.setRetailFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setSaleFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setSequence(1);
    fulfillmentGroupImpl.setService("Service");
    fulfillmentGroupImpl.setShippingOverride(true);
    fulfillmentGroupImpl.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroupImpl.setTaxes(new ArrayList<>());
    fulfillmentGroupImpl.setTotal(new Money());
    fulfillmentGroupImpl.setTotalFeeTax(new Money());
    fulfillmentGroupImpl.setTotalFulfillmentGroupTax(new Money());
    fulfillmentGroupImpl.setTotalItemTax(new Money());
    fulfillmentGroupImpl.setTotalTax(new Money());
    fulfillmentGroupImpl.setType(FulfillmentType.DIGITAL);

    FulfillmentGroupImpl fulfillmentGroupImpl2 = new FulfillmentGroupImpl();
    fulfillmentGroupImpl2.setAddress(new AddressImpl());
    fulfillmentGroupImpl2.setCandidateFulfillmentGroupOffer(new ArrayList<>());
    fulfillmentGroupImpl2.setDeliveryInstruction("Delivery Instruction");
    fulfillmentGroupImpl2.setFulfillmentGroupAdjustments(new ArrayList<>());
    fulfillmentGroupImpl2.setFulfillmentGroupFees(new ArrayList<>());
    fulfillmentGroupImpl2.setFulfillmentGroupItems(new ArrayList<>());
    fulfillmentGroupImpl2.setFulfillmentOption(new FulfillmentOptionImpl());
    fulfillmentGroupImpl2.setFulfillmentPrice(new Money());
    fulfillmentGroupImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    fulfillmentGroupImpl2.setIsShippingPriceTaxable(true);
    fulfillmentGroupImpl2.setMerchandiseTotal(new Money());
    fulfillmentGroupImpl2.setMethod("Fulfillment Method");
    fulfillmentGroupImpl2.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    fulfillmentGroupImpl2.setPersonalMessage(new PersonalMessageImpl());
    fulfillmentGroupImpl2.setPhone(new PhoneImpl());
    fulfillmentGroupImpl2.setPrimary(true);
    fulfillmentGroupImpl2.setReferenceNumber("42");
    fulfillmentGroupImpl2.setRetailFulfillmentPrice(new Money());
    fulfillmentGroupImpl2.setSaleFulfillmentPrice(new Money());
    fulfillmentGroupImpl2.setSequence(1);
    fulfillmentGroupImpl2.setService("Service");
    fulfillmentGroupImpl2.setShippingOverride(true);
    fulfillmentGroupImpl2.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroupImpl2.setTaxes(new ArrayList<>());
    fulfillmentGroupImpl2.setTotal(new Money());
    fulfillmentGroupImpl2.setTotalFeeTax(new Money());
    fulfillmentGroupImpl2.setTotalFulfillmentGroupTax(new Money());
    fulfillmentGroupImpl2.setTotalItemTax(new Money());
    fulfillmentGroupImpl2.setTotalTax(new Money());
    fulfillmentGroupImpl2.setType(FulfillmentType.DIGITAL);

    // Act and Assert
    assertEquals(fulfillmentGroupImpl, fulfillmentGroupImpl2);
    assertEquals(fulfillmentGroupImpl.hashCode(), fulfillmentGroupImpl2.hashCode());
  }

  /**
   * Test {@link FulfillmentGroupImpl#equals(Object)}, and {@link FulfillmentGroupImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link FulfillmentGroupImpl#equals(Object)}
   *   <li>{@link FulfillmentGroupImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean FulfillmentGroupImpl.equals(Object)",
    "int FulfillmentGroupImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    fulfillmentGroupImpl.setAddress(new AddressImpl());
    fulfillmentGroupImpl.setCandidateFulfillmentGroupOffer(new ArrayList<>());
    fulfillmentGroupImpl.setDeliveryInstruction("Delivery Instruction");
    fulfillmentGroupImpl.setFulfillmentGroupAdjustments(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentGroupFees(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentGroupItems(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentOption(new FulfillmentOptionImpl());
    fulfillmentGroupImpl.setFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    fulfillmentGroupImpl.setIsShippingPriceTaxable(true);
    fulfillmentGroupImpl.setMerchandiseTotal(new Money());
    fulfillmentGroupImpl.setMethod("Fulfillment Method");
    fulfillmentGroupImpl.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    fulfillmentGroupImpl.setPersonalMessage(new PersonalMessageImpl());
    fulfillmentGroupImpl.setPhone(new PhoneImpl());
    fulfillmentGroupImpl.setPrimary(true);
    fulfillmentGroupImpl.setReferenceNumber("42");
    fulfillmentGroupImpl.setRetailFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setSaleFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setSequence(1);
    fulfillmentGroupImpl.setService("Service");
    fulfillmentGroupImpl.setShippingOverride(true);
    fulfillmentGroupImpl.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroupImpl.setTaxes(new ArrayList<>());
    fulfillmentGroupImpl.setTotal(new Money());
    fulfillmentGroupImpl.setTotalFeeTax(new Money());
    fulfillmentGroupImpl.setTotalFulfillmentGroupTax(new Money());
    fulfillmentGroupImpl.setTotalItemTax(new Money());
    fulfillmentGroupImpl.setTotalTax(new Money());
    fulfillmentGroupImpl.setType(FulfillmentType.DIGITAL);

    FulfillmentGroupImpl fulfillmentGroupImpl2 = new FulfillmentGroupImpl();
    fulfillmentGroupImpl2.setAddress(new AddressImpl());
    fulfillmentGroupImpl2.setCandidateFulfillmentGroupOffer(new ArrayList<>());
    fulfillmentGroupImpl2.setDeliveryInstruction("Delivery Instruction");
    fulfillmentGroupImpl2.setFulfillmentGroupAdjustments(new ArrayList<>());
    fulfillmentGroupImpl2.setFulfillmentGroupFees(new ArrayList<>());
    fulfillmentGroupImpl2.setFulfillmentGroupItems(new ArrayList<>());
    fulfillmentGroupImpl2.setFulfillmentOption(new FulfillmentOptionImpl());
    fulfillmentGroupImpl2.setFulfillmentPrice(new Money());
    fulfillmentGroupImpl2.setId(null);
    fulfillmentGroupImpl2.setIsShippingPriceTaxable(true);
    fulfillmentGroupImpl2.setMerchandiseTotal(new Money());
    fulfillmentGroupImpl2.setMethod("Fulfillment Method");
    fulfillmentGroupImpl2.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    fulfillmentGroupImpl2.setPersonalMessage(new PersonalMessageImpl());
    fulfillmentGroupImpl2.setPhone(new PhoneImpl());
    fulfillmentGroupImpl2.setPrimary(true);
    fulfillmentGroupImpl2.setReferenceNumber("42");
    fulfillmentGroupImpl2.setRetailFulfillmentPrice(new Money());
    fulfillmentGroupImpl2.setSaleFulfillmentPrice(new Money());
    fulfillmentGroupImpl2.setSequence(1);
    fulfillmentGroupImpl2.setService("Service");
    fulfillmentGroupImpl2.setShippingOverride(true);
    fulfillmentGroupImpl2.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroupImpl2.setTaxes(new ArrayList<>());
    fulfillmentGroupImpl2.setTotal(new Money());
    fulfillmentGroupImpl2.setTotalFeeTax(new Money());
    fulfillmentGroupImpl2.setTotalFulfillmentGroupTax(new Money());
    fulfillmentGroupImpl2.setTotalItemTax(new Money());
    fulfillmentGroupImpl2.setTotalTax(new Money());
    fulfillmentGroupImpl2.setType(FulfillmentType.DIGITAL);

    // Act and Assert
    assertEquals(fulfillmentGroupImpl, fulfillmentGroupImpl2);
    assertEquals(fulfillmentGroupImpl.hashCode(), fulfillmentGroupImpl2.hashCode());
  }

  /**
   * Test {@link FulfillmentGroupImpl#equals(Object)}, and {@link FulfillmentGroupImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link FulfillmentGroupImpl#equals(Object)}
   *   <li>{@link FulfillmentGroupImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean FulfillmentGroupImpl.equals(Object)",
    "int FulfillmentGroupImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    fulfillmentGroupImpl.setAddress(null);
    fulfillmentGroupImpl.setCandidateFulfillmentGroupOffer(new ArrayList<>());
    fulfillmentGroupImpl.setDeliveryInstruction("Delivery Instruction");
    fulfillmentGroupImpl.setFulfillmentGroupAdjustments(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentGroupFees(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentGroupItems(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentOption(new FulfillmentOptionImpl());
    fulfillmentGroupImpl.setFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setId(null);
    fulfillmentGroupImpl.setIsShippingPriceTaxable(true);
    fulfillmentGroupImpl.setMerchandiseTotal(new Money());
    fulfillmentGroupImpl.setMethod("Fulfillment Method");
    fulfillmentGroupImpl.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    fulfillmentGroupImpl.setPersonalMessage(new PersonalMessageImpl());
    fulfillmentGroupImpl.setPhone(new PhoneImpl());
    fulfillmentGroupImpl.setPrimary(true);
    fulfillmentGroupImpl.setReferenceNumber("42");
    fulfillmentGroupImpl.setRetailFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setSaleFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setSequence(1);
    fulfillmentGroupImpl.setService("Service");
    fulfillmentGroupImpl.setShippingOverride(true);
    fulfillmentGroupImpl.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroupImpl.setTaxes(new ArrayList<>());
    fulfillmentGroupImpl.setTotal(new Money());
    fulfillmentGroupImpl.setTotalFeeTax(new Money());
    fulfillmentGroupImpl.setTotalFulfillmentGroupTax(new Money());
    fulfillmentGroupImpl.setTotalItemTax(new Money());
    fulfillmentGroupImpl.setTotalTax(new Money());
    fulfillmentGroupImpl.setType(FulfillmentType.DIGITAL);

    FulfillmentGroupImpl fulfillmentGroupImpl2 = new FulfillmentGroupImpl();
    fulfillmentGroupImpl2.setAddress(null);
    fulfillmentGroupImpl2.setCandidateFulfillmentGroupOffer(new ArrayList<>());
    fulfillmentGroupImpl2.setDeliveryInstruction("Delivery Instruction");
    fulfillmentGroupImpl2.setFulfillmentGroupAdjustments(new ArrayList<>());
    fulfillmentGroupImpl2.setFulfillmentGroupFees(new ArrayList<>());
    fulfillmentGroupImpl2.setFulfillmentGroupItems(new ArrayList<>());
    fulfillmentGroupImpl2.setFulfillmentOption(new FulfillmentOptionImpl());
    fulfillmentGroupImpl2.setFulfillmentPrice(new Money());
    fulfillmentGroupImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    fulfillmentGroupImpl2.setIsShippingPriceTaxable(true);
    fulfillmentGroupImpl2.setMerchandiseTotal(new Money());
    fulfillmentGroupImpl2.setMethod("Fulfillment Method");
    fulfillmentGroupImpl2.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    fulfillmentGroupImpl2.setPersonalMessage(new PersonalMessageImpl());
    fulfillmentGroupImpl2.setPhone(new PhoneImpl());
    fulfillmentGroupImpl2.setPrimary(true);
    fulfillmentGroupImpl2.setReferenceNumber("42");
    fulfillmentGroupImpl2.setRetailFulfillmentPrice(new Money());
    fulfillmentGroupImpl2.setSaleFulfillmentPrice(new Money());
    fulfillmentGroupImpl2.setSequence(1);
    fulfillmentGroupImpl2.setService("Service");
    fulfillmentGroupImpl2.setShippingOverride(true);
    fulfillmentGroupImpl2.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroupImpl2.setTaxes(new ArrayList<>());
    fulfillmentGroupImpl2.setTotal(new Money());
    fulfillmentGroupImpl2.setTotalFeeTax(new Money());
    fulfillmentGroupImpl2.setTotalFulfillmentGroupTax(new Money());
    fulfillmentGroupImpl2.setTotalItemTax(new Money());
    fulfillmentGroupImpl2.setTotalTax(new Money());
    fulfillmentGroupImpl2.setType(FulfillmentType.DIGITAL);

    // Act and Assert
    assertEquals(fulfillmentGroupImpl, fulfillmentGroupImpl2);
    assertEquals(fulfillmentGroupImpl.hashCode(), fulfillmentGroupImpl2.hashCode());
  }

  /**
   * Test {@link FulfillmentGroupImpl#equals(Object)}, and {@link FulfillmentGroupImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link FulfillmentGroupImpl#equals(Object)}
   *   <li>{@link FulfillmentGroupImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean FulfillmentGroupImpl.equals(Object)",
    "int FulfillmentGroupImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    fulfillmentGroupImpl.setAddress(new AddressImpl());
    fulfillmentGroupImpl.setCandidateFulfillmentGroupOffer(new ArrayList<>());
    fulfillmentGroupImpl.setDeliveryInstruction("Delivery Instruction");
    fulfillmentGroupImpl.setFulfillmentGroupAdjustments(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentGroupFees(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentGroupItems(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentOption(new FulfillmentOptionImpl());
    fulfillmentGroupImpl.setFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    fulfillmentGroupImpl.setIsShippingPriceTaxable(true);
    fulfillmentGroupImpl.setMerchandiseTotal(new Money());
    fulfillmentGroupImpl.setMethod("Fulfillment Method");
    fulfillmentGroupImpl.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    fulfillmentGroupImpl.setPersonalMessage(new PersonalMessageImpl());
    fulfillmentGroupImpl.setPhone(new PhoneImpl());
    fulfillmentGroupImpl.setPrimary(true);
    fulfillmentGroupImpl.setReferenceNumber("42");
    fulfillmentGroupImpl.setRetailFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setSaleFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setSequence(1);
    fulfillmentGroupImpl.setService("Service");
    fulfillmentGroupImpl.setShippingOverride(true);
    fulfillmentGroupImpl.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroupImpl.setTaxes(new ArrayList<>());
    fulfillmentGroupImpl.setTotal(new Money());
    fulfillmentGroupImpl.setTotalFeeTax(new Money());
    fulfillmentGroupImpl.setTotalFulfillmentGroupTax(new Money());
    fulfillmentGroupImpl.setTotalItemTax(new Money());
    fulfillmentGroupImpl.setTotalTax(new Money());
    fulfillmentGroupImpl.setType(FulfillmentType.DIGITAL);

    // Act and Assert
    assertEquals(fulfillmentGroupImpl, fulfillmentGroupImpl);
    int expectedHashCodeResult = fulfillmentGroupImpl.hashCode();
    assertEquals(expectedHashCodeResult, fulfillmentGroupImpl.hashCode());
  }

  /**
   * Test {@link FulfillmentGroupImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean FulfillmentGroupImpl.equals(Object)",
    "int FulfillmentGroupImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    fulfillmentGroupImpl.setAddress(new AddressImpl());
    fulfillmentGroupImpl.setCandidateFulfillmentGroupOffer(new ArrayList<>());
    fulfillmentGroupImpl.setDeliveryInstruction("Delivery Instruction");
    fulfillmentGroupImpl.setFulfillmentGroupAdjustments(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentGroupFees(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentGroupItems(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentOption(new FulfillmentOptionImpl());
    fulfillmentGroupImpl.setFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setId(2L);
    fulfillmentGroupImpl.setIsShippingPriceTaxable(true);
    fulfillmentGroupImpl.setMerchandiseTotal(new Money());
    fulfillmentGroupImpl.setMethod("Fulfillment Method");
    fulfillmentGroupImpl.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    fulfillmentGroupImpl.setPersonalMessage(new PersonalMessageImpl());
    fulfillmentGroupImpl.setPhone(new PhoneImpl());
    fulfillmentGroupImpl.setPrimary(true);
    fulfillmentGroupImpl.setReferenceNumber("42");
    fulfillmentGroupImpl.setRetailFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setSaleFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setSequence(1);
    fulfillmentGroupImpl.setService("Service");
    fulfillmentGroupImpl.setShippingOverride(true);
    fulfillmentGroupImpl.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroupImpl.setTaxes(new ArrayList<>());
    fulfillmentGroupImpl.setTotal(new Money());
    fulfillmentGroupImpl.setTotalFeeTax(new Money());
    fulfillmentGroupImpl.setTotalFulfillmentGroupTax(new Money());
    fulfillmentGroupImpl.setTotalItemTax(new Money());
    fulfillmentGroupImpl.setTotalTax(new Money());
    fulfillmentGroupImpl.setType(FulfillmentType.DIGITAL);

    FulfillmentGroupImpl fulfillmentGroupImpl2 = new FulfillmentGroupImpl();
    fulfillmentGroupImpl2.setAddress(new AddressImpl());
    fulfillmentGroupImpl2.setCandidateFulfillmentGroupOffer(new ArrayList<>());
    fulfillmentGroupImpl2.setDeliveryInstruction("Delivery Instruction");
    fulfillmentGroupImpl2.setFulfillmentGroupAdjustments(new ArrayList<>());
    fulfillmentGroupImpl2.setFulfillmentGroupFees(new ArrayList<>());
    fulfillmentGroupImpl2.setFulfillmentGroupItems(new ArrayList<>());
    fulfillmentGroupImpl2.setFulfillmentOption(new FulfillmentOptionImpl());
    fulfillmentGroupImpl2.setFulfillmentPrice(new Money());
    fulfillmentGroupImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    fulfillmentGroupImpl2.setIsShippingPriceTaxable(true);
    fulfillmentGroupImpl2.setMerchandiseTotal(new Money());
    fulfillmentGroupImpl2.setMethod("Fulfillment Method");
    fulfillmentGroupImpl2.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    fulfillmentGroupImpl2.setPersonalMessage(new PersonalMessageImpl());
    fulfillmentGroupImpl2.setPhone(new PhoneImpl());
    fulfillmentGroupImpl2.setPrimary(true);
    fulfillmentGroupImpl2.setReferenceNumber("42");
    fulfillmentGroupImpl2.setRetailFulfillmentPrice(new Money());
    fulfillmentGroupImpl2.setSaleFulfillmentPrice(new Money());
    fulfillmentGroupImpl2.setSequence(1);
    fulfillmentGroupImpl2.setService("Service");
    fulfillmentGroupImpl2.setShippingOverride(true);
    fulfillmentGroupImpl2.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroupImpl2.setTaxes(new ArrayList<>());
    fulfillmentGroupImpl2.setTotal(new Money());
    fulfillmentGroupImpl2.setTotalFeeTax(new Money());
    fulfillmentGroupImpl2.setTotalFulfillmentGroupTax(new Money());
    fulfillmentGroupImpl2.setTotalItemTax(new Money());
    fulfillmentGroupImpl2.setTotalTax(new Money());
    fulfillmentGroupImpl2.setType(FulfillmentType.DIGITAL);

    // Act and Assert
    assertNotEquals(fulfillmentGroupImpl, fulfillmentGroupImpl2);
  }

  /**
   * Test {@link FulfillmentGroupImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean FulfillmentGroupImpl.equals(Object)",
    "int FulfillmentGroupImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    fulfillmentGroupImpl.setAddress(null);
    fulfillmentGroupImpl.setCandidateFulfillmentGroupOffer(new ArrayList<>());
    fulfillmentGroupImpl.setDeliveryInstruction("Delivery Instruction");
    fulfillmentGroupImpl.setFulfillmentGroupAdjustments(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentGroupFees(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentGroupItems(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentOption(new FulfillmentOptionImpl());
    fulfillmentGroupImpl.setFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setId(null);
    fulfillmentGroupImpl.setIsShippingPriceTaxable(true);
    fulfillmentGroupImpl.setMerchandiseTotal(new Money());
    fulfillmentGroupImpl.setMethod("Fulfillment Method");
    fulfillmentGroupImpl.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    fulfillmentGroupImpl.setPersonalMessage(new PersonalMessageImpl());
    fulfillmentGroupImpl.setPhone(new PhoneImpl());
    fulfillmentGroupImpl.setPrimary(true);
    fulfillmentGroupImpl.setReferenceNumber("42");
    fulfillmentGroupImpl.setRetailFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setSaleFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setSequence(1);
    fulfillmentGroupImpl.setService("Service");
    fulfillmentGroupImpl.setShippingOverride(true);
    fulfillmentGroupImpl.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroupImpl.setTaxes(new ArrayList<>());
    fulfillmentGroupImpl.setTotal(new Money());
    fulfillmentGroupImpl.setTotalFeeTax(new Money());
    fulfillmentGroupImpl.setTotalFulfillmentGroupTax(new Money());
    fulfillmentGroupImpl.setTotalItemTax(new Money());
    fulfillmentGroupImpl.setTotalTax(new Money());
    fulfillmentGroupImpl.setType(FulfillmentType.DIGITAL);

    FulfillmentGroupImpl fulfillmentGroupImpl2 = new FulfillmentGroupImpl();
    fulfillmentGroupImpl2.setAddress(new AddressImpl());
    fulfillmentGroupImpl2.setCandidateFulfillmentGroupOffer(new ArrayList<>());
    fulfillmentGroupImpl2.setDeliveryInstruction("Delivery Instruction");
    fulfillmentGroupImpl2.setFulfillmentGroupAdjustments(new ArrayList<>());
    fulfillmentGroupImpl2.setFulfillmentGroupFees(new ArrayList<>());
    fulfillmentGroupImpl2.setFulfillmentGroupItems(new ArrayList<>());
    fulfillmentGroupImpl2.setFulfillmentOption(new FulfillmentOptionImpl());
    fulfillmentGroupImpl2.setFulfillmentPrice(new Money());
    fulfillmentGroupImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    fulfillmentGroupImpl2.setIsShippingPriceTaxable(true);
    fulfillmentGroupImpl2.setMerchandiseTotal(new Money());
    fulfillmentGroupImpl2.setMethod("Fulfillment Method");
    fulfillmentGroupImpl2.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    fulfillmentGroupImpl2.setPersonalMessage(new PersonalMessageImpl());
    fulfillmentGroupImpl2.setPhone(new PhoneImpl());
    fulfillmentGroupImpl2.setPrimary(true);
    fulfillmentGroupImpl2.setReferenceNumber("42");
    fulfillmentGroupImpl2.setRetailFulfillmentPrice(new Money());
    fulfillmentGroupImpl2.setSaleFulfillmentPrice(new Money());
    fulfillmentGroupImpl2.setSequence(1);
    fulfillmentGroupImpl2.setService("Service");
    fulfillmentGroupImpl2.setShippingOverride(true);
    fulfillmentGroupImpl2.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroupImpl2.setTaxes(new ArrayList<>());
    fulfillmentGroupImpl2.setTotal(new Money());
    fulfillmentGroupImpl2.setTotalFeeTax(new Money());
    fulfillmentGroupImpl2.setTotalFulfillmentGroupTax(new Money());
    fulfillmentGroupImpl2.setTotalItemTax(new Money());
    fulfillmentGroupImpl2.setTotalTax(new Money());
    fulfillmentGroupImpl2.setType(FulfillmentType.DIGITAL);

    // Act and Assert
    assertNotEquals(fulfillmentGroupImpl, fulfillmentGroupImpl2);
  }

  /**
   * Test {@link FulfillmentGroupImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean FulfillmentGroupImpl.equals(Object)",
    "int FulfillmentGroupImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    fulfillmentGroupImpl.setAddress(mock(AddressImpl.class));
    fulfillmentGroupImpl.setCandidateFulfillmentGroupOffer(new ArrayList<>());
    fulfillmentGroupImpl.setDeliveryInstruction("Delivery Instruction");
    fulfillmentGroupImpl.setFulfillmentGroupAdjustments(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentGroupFees(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentGroupItems(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentOption(new FulfillmentOptionImpl());
    fulfillmentGroupImpl.setFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setId(null);
    fulfillmentGroupImpl.setIsShippingPriceTaxable(true);
    fulfillmentGroupImpl.setMerchandiseTotal(new Money());
    fulfillmentGroupImpl.setMethod("Fulfillment Method");
    fulfillmentGroupImpl.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    fulfillmentGroupImpl.setPersonalMessage(new PersonalMessageImpl());
    fulfillmentGroupImpl.setPhone(new PhoneImpl());
    fulfillmentGroupImpl.setPrimary(true);
    fulfillmentGroupImpl.setReferenceNumber("42");
    fulfillmentGroupImpl.setRetailFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setSaleFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setSequence(1);
    fulfillmentGroupImpl.setService("Service");
    fulfillmentGroupImpl.setShippingOverride(true);
    fulfillmentGroupImpl.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroupImpl.setTaxes(new ArrayList<>());
    fulfillmentGroupImpl.setTotal(new Money());
    fulfillmentGroupImpl.setTotalFeeTax(new Money());
    fulfillmentGroupImpl.setTotalFulfillmentGroupTax(new Money());
    fulfillmentGroupImpl.setTotalItemTax(new Money());
    fulfillmentGroupImpl.setTotalTax(new Money());
    fulfillmentGroupImpl.setType(FulfillmentType.DIGITAL);

    FulfillmentGroupImpl fulfillmentGroupImpl2 = new FulfillmentGroupImpl();
    fulfillmentGroupImpl2.setAddress(new AddressImpl());
    fulfillmentGroupImpl2.setCandidateFulfillmentGroupOffer(new ArrayList<>());
    fulfillmentGroupImpl2.setDeliveryInstruction("Delivery Instruction");
    fulfillmentGroupImpl2.setFulfillmentGroupAdjustments(new ArrayList<>());
    fulfillmentGroupImpl2.setFulfillmentGroupFees(new ArrayList<>());
    fulfillmentGroupImpl2.setFulfillmentGroupItems(new ArrayList<>());
    fulfillmentGroupImpl2.setFulfillmentOption(new FulfillmentOptionImpl());
    fulfillmentGroupImpl2.setFulfillmentPrice(new Money());
    fulfillmentGroupImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    fulfillmentGroupImpl2.setIsShippingPriceTaxable(true);
    fulfillmentGroupImpl2.setMerchandiseTotal(new Money());
    fulfillmentGroupImpl2.setMethod("Fulfillment Method");
    fulfillmentGroupImpl2.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    fulfillmentGroupImpl2.setPersonalMessage(new PersonalMessageImpl());
    fulfillmentGroupImpl2.setPhone(new PhoneImpl());
    fulfillmentGroupImpl2.setPrimary(true);
    fulfillmentGroupImpl2.setReferenceNumber("42");
    fulfillmentGroupImpl2.setRetailFulfillmentPrice(new Money());
    fulfillmentGroupImpl2.setSaleFulfillmentPrice(new Money());
    fulfillmentGroupImpl2.setSequence(1);
    fulfillmentGroupImpl2.setService("Service");
    fulfillmentGroupImpl2.setShippingOverride(true);
    fulfillmentGroupImpl2.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroupImpl2.setTaxes(new ArrayList<>());
    fulfillmentGroupImpl2.setTotal(new Money());
    fulfillmentGroupImpl2.setTotalFeeTax(new Money());
    fulfillmentGroupImpl2.setTotalFulfillmentGroupTax(new Money());
    fulfillmentGroupImpl2.setTotalItemTax(new Money());
    fulfillmentGroupImpl2.setTotalTax(new Money());
    fulfillmentGroupImpl2.setType(FulfillmentType.DIGITAL);

    // Act and Assert
    assertNotEquals(fulfillmentGroupImpl, fulfillmentGroupImpl2);
  }

  /**
   * Test {@link FulfillmentGroupImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean FulfillmentGroupImpl.equals(Object)",
    "int FulfillmentGroupImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    ArrayList<FulfillmentGroupItem> fulfillmentGroupItems = new ArrayList<>();
    fulfillmentGroupItems.add(new FulfillmentGroupItemImpl());

    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    fulfillmentGroupImpl.setAddress(new AddressImpl());
    fulfillmentGroupImpl.setCandidateFulfillmentGroupOffer(new ArrayList<>());
    fulfillmentGroupImpl.setDeliveryInstruction("Delivery Instruction");
    fulfillmentGroupImpl.setFulfillmentGroupAdjustments(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentGroupFees(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentGroupItems(fulfillmentGroupItems);
    fulfillmentGroupImpl.setFulfillmentOption(new FulfillmentOptionImpl());
    fulfillmentGroupImpl.setFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setId(null);
    fulfillmentGroupImpl.setIsShippingPriceTaxable(true);
    fulfillmentGroupImpl.setMerchandiseTotal(new Money());
    fulfillmentGroupImpl.setMethod("Fulfillment Method");
    fulfillmentGroupImpl.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    fulfillmentGroupImpl.setPersonalMessage(new PersonalMessageImpl());
    fulfillmentGroupImpl.setPhone(new PhoneImpl());
    fulfillmentGroupImpl.setPrimary(true);
    fulfillmentGroupImpl.setReferenceNumber("42");
    fulfillmentGroupImpl.setRetailFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setSaleFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setSequence(1);
    fulfillmentGroupImpl.setService("Service");
    fulfillmentGroupImpl.setShippingOverride(true);
    fulfillmentGroupImpl.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroupImpl.setTaxes(new ArrayList<>());
    fulfillmentGroupImpl.setTotal(new Money());
    fulfillmentGroupImpl.setTotalFeeTax(new Money());
    fulfillmentGroupImpl.setTotalFulfillmentGroupTax(new Money());
    fulfillmentGroupImpl.setTotalItemTax(new Money());
    fulfillmentGroupImpl.setTotalTax(new Money());
    fulfillmentGroupImpl.setType(FulfillmentType.DIGITAL);

    FulfillmentGroupImpl fulfillmentGroupImpl2 = new FulfillmentGroupImpl();
    fulfillmentGroupImpl2.setAddress(new AddressImpl());
    fulfillmentGroupImpl2.setCandidateFulfillmentGroupOffer(new ArrayList<>());
    fulfillmentGroupImpl2.setDeliveryInstruction("Delivery Instruction");
    fulfillmentGroupImpl2.setFulfillmentGroupAdjustments(new ArrayList<>());
    fulfillmentGroupImpl2.setFulfillmentGroupFees(new ArrayList<>());
    fulfillmentGroupImpl2.setFulfillmentGroupItems(new ArrayList<>());
    fulfillmentGroupImpl2.setFulfillmentOption(new FulfillmentOptionImpl());
    fulfillmentGroupImpl2.setFulfillmentPrice(new Money());
    fulfillmentGroupImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    fulfillmentGroupImpl2.setIsShippingPriceTaxable(true);
    fulfillmentGroupImpl2.setMerchandiseTotal(new Money());
    fulfillmentGroupImpl2.setMethod("Fulfillment Method");
    fulfillmentGroupImpl2.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    fulfillmentGroupImpl2.setPersonalMessage(new PersonalMessageImpl());
    fulfillmentGroupImpl2.setPhone(new PhoneImpl());
    fulfillmentGroupImpl2.setPrimary(true);
    fulfillmentGroupImpl2.setReferenceNumber("42");
    fulfillmentGroupImpl2.setRetailFulfillmentPrice(new Money());
    fulfillmentGroupImpl2.setSaleFulfillmentPrice(new Money());
    fulfillmentGroupImpl2.setSequence(1);
    fulfillmentGroupImpl2.setService("Service");
    fulfillmentGroupImpl2.setShippingOverride(true);
    fulfillmentGroupImpl2.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroupImpl2.setTaxes(new ArrayList<>());
    fulfillmentGroupImpl2.setTotal(new Money());
    fulfillmentGroupImpl2.setTotalFeeTax(new Money());
    fulfillmentGroupImpl2.setTotalFulfillmentGroupTax(new Money());
    fulfillmentGroupImpl2.setTotalItemTax(new Money());
    fulfillmentGroupImpl2.setTotalTax(new Money());
    fulfillmentGroupImpl2.setType(FulfillmentType.DIGITAL);

    // Act and Assert
    assertNotEquals(fulfillmentGroupImpl, fulfillmentGroupImpl2);
  }

  /**
   * Test {@link FulfillmentGroupImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean FulfillmentGroupImpl.equals(Object)",
    "int FulfillmentGroupImpl.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    fulfillmentGroupImpl.setAddress(new AddressImpl());
    fulfillmentGroupImpl.setCandidateFulfillmentGroupOffer(new ArrayList<>());
    fulfillmentGroupImpl.setDeliveryInstruction("Delivery Instruction");
    fulfillmentGroupImpl.setFulfillmentGroupAdjustments(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentGroupFees(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentGroupItems(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentOption(new FulfillmentOptionImpl());
    fulfillmentGroupImpl.setFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    fulfillmentGroupImpl.setIsShippingPriceTaxable(true);
    fulfillmentGroupImpl.setMerchandiseTotal(new Money());
    fulfillmentGroupImpl.setMethod("Fulfillment Method");
    fulfillmentGroupImpl.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    fulfillmentGroupImpl.setPersonalMessage(new PersonalMessageImpl());
    fulfillmentGroupImpl.setPhone(new PhoneImpl());
    fulfillmentGroupImpl.setPrimary(true);
    fulfillmentGroupImpl.setReferenceNumber("42");
    fulfillmentGroupImpl.setRetailFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setSaleFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setSequence(1);
    fulfillmentGroupImpl.setService("Service");
    fulfillmentGroupImpl.setShippingOverride(true);
    fulfillmentGroupImpl.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroupImpl.setTaxes(new ArrayList<>());
    fulfillmentGroupImpl.setTotal(new Money());
    fulfillmentGroupImpl.setTotalFeeTax(new Money());
    fulfillmentGroupImpl.setTotalFulfillmentGroupTax(new Money());
    fulfillmentGroupImpl.setTotalItemTax(new Money());
    fulfillmentGroupImpl.setTotalTax(new Money());
    fulfillmentGroupImpl.setType(FulfillmentType.DIGITAL);

    // Act and Assert
    assertNotEquals(fulfillmentGroupImpl, null);
  }

  /**
   * Test {@link FulfillmentGroupImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean FulfillmentGroupImpl.equals(Object)",
    "int FulfillmentGroupImpl.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    fulfillmentGroupImpl.setAddress(new AddressImpl());
    fulfillmentGroupImpl.setCandidateFulfillmentGroupOffer(new ArrayList<>());
    fulfillmentGroupImpl.setDeliveryInstruction("Delivery Instruction");
    fulfillmentGroupImpl.setFulfillmentGroupAdjustments(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentGroupFees(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentGroupItems(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentOption(new FulfillmentOptionImpl());
    fulfillmentGroupImpl.setFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    fulfillmentGroupImpl.setIsShippingPriceTaxable(true);
    fulfillmentGroupImpl.setMerchandiseTotal(new Money());
    fulfillmentGroupImpl.setMethod("Fulfillment Method");
    fulfillmentGroupImpl.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    fulfillmentGroupImpl.setPersonalMessage(new PersonalMessageImpl());
    fulfillmentGroupImpl.setPhone(new PhoneImpl());
    fulfillmentGroupImpl.setPrimary(true);
    fulfillmentGroupImpl.setReferenceNumber("42");
    fulfillmentGroupImpl.setRetailFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setSaleFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setSequence(1);
    fulfillmentGroupImpl.setService("Service");
    fulfillmentGroupImpl.setShippingOverride(true);
    fulfillmentGroupImpl.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroupImpl.setTaxes(new ArrayList<>());
    fulfillmentGroupImpl.setTotal(new Money());
    fulfillmentGroupImpl.setTotalFeeTax(new Money());
    fulfillmentGroupImpl.setTotalFulfillmentGroupTax(new Money());
    fulfillmentGroupImpl.setTotalItemTax(new Money());
    fulfillmentGroupImpl.setTotalTax(new Money());
    fulfillmentGroupImpl.setType(FulfillmentType.DIGITAL);

    // Act and Assert
    assertNotEquals(fulfillmentGroupImpl, "Different type to FulfillmentGroupImpl");
  }

  /**
   * Test new {@link FulfillmentGroupImpl} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link FulfillmentGroupImpl}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void FulfillmentGroupImpl.<init>()"})
  public void testNewFulfillmentGroupImpl() {
    // Arrange and Act
    FulfillmentGroupImpl actualFulfillmentGroupImpl = new FulfillmentGroupImpl();

    // Assert
    assertNull(actualFulfillmentGroupImpl.shippingOverride);
    assertNull(actualFulfillmentGroupImpl.getSequence());
    assertNull(actualFulfillmentGroupImpl.getId());
    assertNull(actualFulfillmentGroupImpl.getDeliveryInstruction());
    assertNull(actualFulfillmentGroupImpl.getMethod());
    assertNull(actualFulfillmentGroupImpl.getReferenceNumber());
    assertNull(actualFulfillmentGroupImpl.getService());
    assertNull(actualFulfillmentGroupImpl.status);
    assertNull(actualFulfillmentGroupImpl.type);
    assertNull(actualFulfillmentGroupImpl.fulfillmentPrice);
    assertNull(actualFulfillmentGroupImpl.merchandiseTotal);
    assertNull(actualFulfillmentGroupImpl.retailFulfillmentPrice);
    assertNull(actualFulfillmentGroupImpl.saleFulfillmentPrice);
    assertNull(actualFulfillmentGroupImpl.total);
    assertNull(actualFulfillmentGroupImpl.totalFeeTax);
    assertNull(actualFulfillmentGroupImpl.totalFulfillmentGroupTax);
    assertNull(actualFulfillmentGroupImpl.totalItemTax);
    assertNull(actualFulfillmentGroupImpl.totalTax);
    assertNull(actualFulfillmentGroupImpl.getFulfillmentPrice());
    assertNull(actualFulfillmentGroupImpl.getMerchandiseTotal());
    assertNull(actualFulfillmentGroupImpl.getRetailFulfillmentPrice());
    assertNull(actualFulfillmentGroupImpl.getRetailShippingPrice());
    assertNull(actualFulfillmentGroupImpl.getSaleFulfillmentPrice());
    assertNull(actualFulfillmentGroupImpl.getSaleShippingPrice());
    assertNull(actualFulfillmentGroupImpl.getShippingPrice());
    assertNull(actualFulfillmentGroupImpl.getTotal());
    assertNull(actualFulfillmentGroupImpl.getTotalFeeTax());
    assertNull(actualFulfillmentGroupImpl.getTotalFulfillmentGroupTax());
    assertNull(actualFulfillmentGroupImpl.getTotalItemTax());
    assertNull(actualFulfillmentGroupImpl.getTotalTax());
    assertNull(actualFulfillmentGroupImpl.getFulfillmentOption());
    assertNull(actualFulfillmentGroupImpl.getOrder());
    assertNull(actualFulfillmentGroupImpl.getPersonalMessage());
    assertNull(actualFulfillmentGroupImpl.getStatus());
    assertNull(actualFulfillmentGroupImpl.getType());
    assertNull(actualFulfillmentGroupImpl.getAddress());
    assertNull(actualFulfillmentGroupImpl.getPhone());
    assertFalse(actualFulfillmentGroupImpl.getShippingOverride());
    assertFalse(actualFulfillmentGroupImpl.isPrimary());
    assertFalse(actualFulfillmentGroupImpl.isShippingPriceTaxable());
    assertTrue(actualFulfillmentGroupImpl.getCandidateFulfillmentGroupOffers().isEmpty());
    assertTrue(actualFulfillmentGroupImpl.getDiscreteOrderItems().isEmpty());
    assertTrue(actualFulfillmentGroupImpl.getFulfillmentGroupAdjustments().isEmpty());
    assertTrue(actualFulfillmentGroupImpl.getFulfillmentGroupFees().isEmpty());
    assertTrue(actualFulfillmentGroupImpl.getFulfillmentGroupItems().isEmpty());
    assertTrue(actualFulfillmentGroupImpl.getFutureCreditFulfillmentGroupAdjustments().isEmpty());
    assertTrue(actualFulfillmentGroupImpl.getTaxes().isEmpty());
  }
}
