package org.broadleafcommerce.core.web.expression;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
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
import java.util.List;
import org.broadleafcommerce.common.audit.Auditable;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.core.catalog.domain.Product;
import org.broadleafcommerce.core.catalog.domain.ProductBundleImpl;
import org.broadleafcommerce.core.offer.domain.OrderItemPriceDetailAdjustment;
import org.broadleafcommerce.core.offer.domain.OrderItemPriceDetailAdjustmentImpl;
import org.broadleafcommerce.core.order.domain.BundleOrderItemImpl;
import org.broadleafcommerce.core.order.domain.GiftWrapOrderItemImpl;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.OrderItem;
import org.broadleafcommerce.core.order.domain.OrderItemPriceDetail;
import org.broadleafcommerce.core.order.domain.OrderItemPriceDetailImpl;
import org.broadleafcommerce.core.order.domain.PersonalMessageImpl;
import org.broadleafcommerce.core.order.service.type.OrderItemType;
import org.broadleafcommerce.core.promotionMessage.dto.PromotionMessageDTO;
import org.broadleafcommerce.core.promotionMessage.service.PromotionMessageGenerator;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class PromotionMessageVariableExpressionDiffblueTest {
  @Mock private List<PromotionMessageGenerator> list;

  @InjectMocks private PromotionMessageVariableExpression promotionMessageVariableExpression;

  /**
   * Test {@link PromotionMessageVariableExpression#getName()}.
   *
   * <p>Method under test: {@link PromotionMessageVariableExpression#getName()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String PromotionMessageVariableExpression.getName()"})
  public void testGetName() {
    // Arrange, Act and Assert
    assertEquals("promotion_messages", new PromotionMessageVariableExpression().getName());
  }

  /**
   * Test {@link PromotionMessageVariableExpression#getProductPromotionMessages(Product, String[])}.
   *
   * <p>Method under test: {@link
   * PromotionMessageVariableExpression#getProductPromotionMessages(Product, String[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List PromotionMessageVariableExpression.getProductPromotionMessages(Product, String[])"
  })
  public void testGetProductPromotionMessages() {
    // Arrange
    HashMap<String, List<PromotionMessageDTO>> stringListMap = new HashMap<>();
    stringListMap.put("Stripping out invalid promotion message placement ", new ArrayList<>());

    PromotionMessageGenerator promotionMessageGenerator = mock(PromotionMessageGenerator.class);
    when(promotionMessageGenerator.generatePromotionMessages(Mockito.<Product>any()))
        .thenReturn(stringListMap);

    ArrayList<PromotionMessageGenerator> promotionMessageGeneratorList = new ArrayList<>();
    promotionMessageGeneratorList.add(promotionMessageGenerator);
    when(list.iterator()).thenReturn(promotionMessageGeneratorList.iterator());

    // Act
    List<PromotionMessageDTO> actualProductPromotionMessages =
        promotionMessageVariableExpression.getProductPromotionMessages(
            new ProductBundleImpl(), "Placements");

    // Assert
    verify(list).iterator();
    verify(promotionMessageGenerator).generatePromotionMessages(isA(Product.class));
    assertTrue(actualProductPromotionMessages.isEmpty());
  }

  /**
   * Test {@link PromotionMessageVariableExpression#getProductPromotionMessages(Product, String[])}.
   *
   * <ul>
   *   <li>Then calls {@link PromotionMessageGenerator#generatePromotionMessages(Product)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PromotionMessageVariableExpression#getProductPromotionMessages(Product, String[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List PromotionMessageVariableExpression.getProductPromotionMessages(Product, String[])"
  })
  public void testGetProductPromotionMessages_thenCallsGeneratePromotionMessages() {
    // Arrange
    PromotionMessageGenerator promotionMessageGenerator = mock(PromotionMessageGenerator.class);
    when(promotionMessageGenerator.generatePromotionMessages(Mockito.<Product>any()))
        .thenReturn(new HashMap<>());

    ArrayList<PromotionMessageGenerator> promotionMessageGeneratorList = new ArrayList<>();
    promotionMessageGeneratorList.add(promotionMessageGenerator);
    when(list.iterator()).thenReturn(promotionMessageGeneratorList.iterator());

    // Act
    List<PromotionMessageDTO> actualProductPromotionMessages =
        promotionMessageVariableExpression.getProductPromotionMessages(
            new ProductBundleImpl(), "Placements");

    // Assert
    verify(list).iterator();
    verify(promotionMessageGenerator).generatePromotionMessages(isA(Product.class));
    assertTrue(actualProductPromotionMessages.isEmpty());
  }

  /**
   * Test {@link PromotionMessageVariableExpression#getProductPromotionMessages(Product, String[])}.
   *
   * <ul>
   *   <li>When {@code Placements}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link
   * PromotionMessageVariableExpression#getProductPromotionMessages(Product, String[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List PromotionMessageVariableExpression.getProductPromotionMessages(Product, String[])"
  })
  public void testGetProductPromotionMessages_whenPlacements_thenReturnEmpty() {
    // Arrange
    ArrayList<PromotionMessageGenerator> promotionMessageGeneratorList = new ArrayList<>();
    when(list.iterator()).thenReturn(promotionMessageGeneratorList.iterator());

    // Act
    List<PromotionMessageDTO> actualProductPromotionMessages =
        promotionMessageVariableExpression.getProductPromotionMessages(
            new ProductBundleImpl(), "Placements");

    // Assert
    verify(list).iterator();
    assertTrue(actualProductPromotionMessages.isEmpty());
  }

  /**
   * Test {@link PromotionMessageVariableExpression#getItemPromotionMessages(OrderItem)}.
   *
   * <ul>
   *   <li>Then return size is two.
   * </ul>
   *
   * <p>Method under test: {@link
   * PromotionMessageVariableExpression#getItemPromotionMessages(OrderItem)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List PromotionMessageVariableExpression.getItemPromotionMessages(OrderItem)"})
  public void testGetItemPromotionMessages_thenReturnSizeIsTwo() {
    // Arrange
    PromotionMessageVariableExpression promotionMessageVariableExpression =
        new PromotionMessageVariableExpression();

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(1L);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(1L);

    ArrayList<OrderItemPriceDetailAdjustment> orderItemPriceDetailAdjustments = new ArrayList<>();
    orderItemPriceDetailAdjustments.add(new OrderItemPriceDetailAdjustmentImpl());

    OrderItemPriceDetailImpl orderItemPriceDetailImpl = new OrderItemPriceDetailImpl();
    orderItemPriceDetailImpl.setId(1L);
    orderItemPriceDetailImpl.setOrderItem(new BundleOrderItemImpl());
    orderItemPriceDetailImpl.setQuantity(1);
    orderItemPriceDetailImpl.setUseSalePrice(true);
    orderItemPriceDetailImpl.setOrderItemAdjustments(orderItemPriceDetailAdjustments);

    ArrayList<OrderItemPriceDetail> orderItemPriceDetails = new ArrayList<>();
    orderItemPriceDetails.add(orderItemPriceDetailImpl);

    BundleOrderItemImpl bundleOrderItemImpl = new BundleOrderItemImpl();
    bundleOrderItemImpl.setAuditable(auditable2);
    bundleOrderItemImpl.setBaseRetailPrice(new Money());
    bundleOrderItemImpl.setBaseSalePrice(new Money());
    bundleOrderItemImpl.setBundleOrderItemFeePrices(new ArrayList<>());
    bundleOrderItemImpl.setCandidateItemOffers(new ArrayList<>());
    bundleOrderItemImpl.setCartMessages(new ArrayList<>());
    bundleOrderItemImpl.setChildOrderItems(new ArrayList<>());
    bundleOrderItemImpl.setDiscountingAllowed(true);
    bundleOrderItemImpl.setDiscreteOrderItems(new ArrayList<>());
    bundleOrderItemImpl.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    bundleOrderItemImpl.setHasValidationError(true);
    bundleOrderItemImpl.setId(1L);
    bundleOrderItemImpl.setName("Name");
    bundleOrderItemImpl.setOrder(new NullOrderImpl());
    bundleOrderItemImpl.setOrderItemAdjustments(new ArrayList<>());
    bundleOrderItemImpl.setOrderItemAttributes(new HashMap<>());
    bundleOrderItemImpl.setOrderItemQualifiers(new ArrayList<>());
    bundleOrderItemImpl.setOrderItemType(new OrderItemType());
    bundleOrderItemImpl.setParentOrderItem(new BundleOrderItemImpl());
    bundleOrderItemImpl.setPersonalMessage(new PersonalMessageImpl());
    bundleOrderItemImpl.setPrice(new Money());
    bundleOrderItemImpl.setProratedOrderItemAdjustments(new ArrayList<>());
    bundleOrderItemImpl.setQuantity(1);
    bundleOrderItemImpl.setRetailPrice(new Money());
    bundleOrderItemImpl.setRetailPriceOverride(true);
    bundleOrderItemImpl.setSalePrice(new Money());
    bundleOrderItemImpl.setSalePriceOverride(true);
    bundleOrderItemImpl.setTaxable(true);
    bundleOrderItemImpl.updateSaleAndRetailPrices();
    bundleOrderItemImpl.setOrderItemPriceDetails(orderItemPriceDetails);

    ArrayList<OrderItem> childOrderItems = new ArrayList<>();
    childOrderItems.add(bundleOrderItemImpl);

    ArrayList<OrderItemPriceDetailAdjustment> orderItemPriceDetailAdjustments2 = new ArrayList<>();
    orderItemPriceDetailAdjustments2.add(new OrderItemPriceDetailAdjustmentImpl());

    OrderItemPriceDetailImpl orderItemPriceDetailImpl2 = new OrderItemPriceDetailImpl();
    orderItemPriceDetailImpl2.setId(1L);
    orderItemPriceDetailImpl2.setOrderItem(new BundleOrderItemImpl());
    orderItemPriceDetailImpl2.setQuantity(1);
    orderItemPriceDetailImpl2.setUseSalePrice(true);
    orderItemPriceDetailImpl2.setOrderItemAdjustments(orderItemPriceDetailAdjustments2);

    ArrayList<OrderItemPriceDetail> orderItemPriceDetails2 = new ArrayList<>();
    orderItemPriceDetails2.add(orderItemPriceDetailImpl2);

    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();
    orderItem.setAuditable(auditable);
    orderItem.setBaseRetailPrice(new Money());
    orderItem.setBaseSalePrice(new Money());
    orderItem.setBundleOrderItemFeePrices(new ArrayList<>());
    orderItem.setCandidateItemOffers(new ArrayList<>());
    orderItem.setCartMessages(new ArrayList<>());
    orderItem.setDiscountingAllowed(true);
    orderItem.setDiscreteOrderItems(new ArrayList<>());
    orderItem.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    orderItem.setHasValidationError(true);
    orderItem.setId(1L);
    orderItem.setName("Name");
    orderItem.setOrder(new NullOrderImpl());
    orderItem.setOrderItemAdjustments(new ArrayList<>());
    orderItem.setOrderItemAttributes(new HashMap<>());
    orderItem.setOrderItemQualifiers(new ArrayList<>());
    orderItem.setOrderItemType(new OrderItemType());
    orderItem.setParentOrderItem(new BundleOrderItemImpl());
    orderItem.setPersonalMessage(new PersonalMessageImpl());
    orderItem.setPrice(new Money());
    orderItem.setProratedOrderItemAdjustments(new ArrayList<>());
    orderItem.setQuantity(1);
    orderItem.setRetailPrice(new Money());
    orderItem.setRetailPriceOverride(true);
    orderItem.setSalePrice(new Money());
    orderItem.setSalePriceOverride(true);
    orderItem.setTaxable(true);
    orderItem.updateSaleAndRetailPrices();
    orderItem.setChildOrderItems(childOrderItems);
    orderItem.setOrderItemPriceDetails(orderItemPriceDetails2);

    // Act
    List<String> actualItemPromotionMessages =
        promotionMessageVariableExpression.getItemPromotionMessages(orderItem);

    // Assert
    assertEquals(2, actualItemPromotionMessages.size());
    assertNull(actualItemPromotionMessages.get(0));
    assertNull(actualItemPromotionMessages.get(1));
  }

  /**
   * Test {@link PromotionMessageVariableExpression#getItemPromotionMessages(OrderItem)}.
   *
   * <ul>
   *   <li>When {@link BundleOrderItemImpl} (default constructor).
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link
   * PromotionMessageVariableExpression#getItemPromotionMessages(OrderItem)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List PromotionMessageVariableExpression.getItemPromotionMessages(OrderItem)"})
  public void testGetItemPromotionMessages_whenBundleOrderItemImpl_thenReturnEmpty() {
    // Arrange
    PromotionMessageVariableExpression promotionMessageVariableExpression =
        new PromotionMessageVariableExpression();

    // Act and Assert
    assertTrue(
        promotionMessageVariableExpression
            .getItemPromotionMessages(new BundleOrderItemImpl())
            .isEmpty());
  }

  /**
   * Test {@link PromotionMessageVariableExpression#getAppliedOfferNamesForOrderItem(OrderItem)}.
   *
   * <ul>
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link
   * PromotionMessageVariableExpression#getAppliedOfferNamesForOrderItem(OrderItem)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List PromotionMessageVariableExpression.getAppliedOfferNamesForOrderItem(OrderItem)"
  })
  public void testGetAppliedOfferNamesForOrderItem_thenReturnSizeIsOne() {
    // Arrange
    PromotionMessageVariableExpression promotionMessageVariableExpression =
        new PromotionMessageVariableExpression();

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    ArrayList<OrderItemPriceDetailAdjustment> orderItemPriceDetailAdjustments = new ArrayList<>();
    orderItemPriceDetailAdjustments.add(new OrderItemPriceDetailAdjustmentImpl());

    OrderItemPriceDetailImpl orderItemPriceDetailImpl = new OrderItemPriceDetailImpl();
    orderItemPriceDetailImpl.setId(1L);
    orderItemPriceDetailImpl.setOrderItem(new BundleOrderItemImpl());
    orderItemPriceDetailImpl.setQuantity(1);
    orderItemPriceDetailImpl.setUseSalePrice(true);
    orderItemPriceDetailImpl.setOrderItemAdjustments(orderItemPriceDetailAdjustments);

    ArrayList<OrderItemPriceDetail> orderItemPriceDetails = new ArrayList<>();
    orderItemPriceDetails.add(orderItemPriceDetailImpl);

    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();
    orderItem.setAuditable(auditable);
    orderItem.setBaseRetailPrice(new Money());
    orderItem.setBaseSalePrice(new Money());
    orderItem.setBundleOrderItemFeePrices(new ArrayList<>());
    orderItem.setCandidateItemOffers(new ArrayList<>());
    orderItem.setCartMessages(new ArrayList<>());
    orderItem.setChildOrderItems(new ArrayList<>());
    orderItem.setDiscountingAllowed(true);
    orderItem.setDiscreteOrderItems(new ArrayList<>());
    orderItem.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    orderItem.setHasValidationError(true);
    orderItem.setId(1L);
    orderItem.setName("Name");
    orderItem.setOrder(new NullOrderImpl());
    orderItem.setOrderItemAdjustments(new ArrayList<>());
    orderItem.setOrderItemAttributes(new HashMap<>());
    orderItem.setOrderItemQualifiers(new ArrayList<>());
    orderItem.setOrderItemType(new OrderItemType());
    orderItem.setParentOrderItem(new BundleOrderItemImpl());
    orderItem.setPersonalMessage(new PersonalMessageImpl());
    orderItem.setPrice(new Money());
    orderItem.setProratedOrderItemAdjustments(new ArrayList<>());
    orderItem.setQuantity(1);
    orderItem.setRetailPrice(new Money());
    orderItem.setRetailPriceOverride(true);
    orderItem.setSalePrice(new Money());
    orderItem.setSalePriceOverride(true);
    orderItem.setTaxable(true);
    orderItem.updateSaleAndRetailPrices();
    orderItem.setOrderItemPriceDetails(orderItemPriceDetails);

    // Act
    List<String> actualAppliedOfferNamesForOrderItem =
        promotionMessageVariableExpression.getAppliedOfferNamesForOrderItem(orderItem);

    // Assert
    assertEquals(1, actualAppliedOfferNamesForOrderItem.size());
    assertNull(actualAppliedOfferNamesForOrderItem.get(0));
  }

  /**
   * Test {@link PromotionMessageVariableExpression#getAppliedOfferNamesForOrderItem(OrderItem)}.
   *
   * <ul>
   *   <li>When {@link BundleOrderItemImpl} (default constructor).
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link
   * PromotionMessageVariableExpression#getAppliedOfferNamesForOrderItem(OrderItem)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List PromotionMessageVariableExpression.getAppliedOfferNamesForOrderItem(OrderItem)"
  })
  public void testGetAppliedOfferNamesForOrderItem_whenBundleOrderItemImpl_thenReturnEmpty() {
    // Arrange
    PromotionMessageVariableExpression promotionMessageVariableExpression =
        new PromotionMessageVariableExpression();

    // Act and Assert
    assertTrue(
        promotionMessageVariableExpression
            .getAppliedOfferNamesForOrderItem(new BundleOrderItemImpl())
            .isEmpty());
  }

  /**
   * Test {@link PromotionMessageVariableExpression#filterInvalidPlacements(String[])}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link
   * PromotionMessageVariableExpression#filterInvalidPlacements(String[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List PromotionMessageVariableExpression.filterInvalidPlacements(String[])"})
  public void testFilterInvalidPlacements_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(
        new PromotionMessageVariableExpression()
            .filterInvalidPlacements(new String[] {"Placements"})
            .isEmpty());
  }

  /**
   * Test {@link PromotionMessageVariableExpression#isValidPlacementType(String)}.
   *
   * <p>Method under test: {@link PromotionMessageVariableExpression#isValidPlacementType(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PromotionMessageVariableExpression.isValidPlacementType(String)"})
  public void testIsValidPlacementType() {
    // Arrange, Act and Assert
    assertFalse(new PromotionMessageVariableExpression().isValidPlacementType("Placement"));
  }
}
