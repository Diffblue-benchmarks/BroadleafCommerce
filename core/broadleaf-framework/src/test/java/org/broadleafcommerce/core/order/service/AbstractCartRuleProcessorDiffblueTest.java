package org.broadleafcommerce.core.order.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.broadleafcommerce.common.page.dto.PageDTO;
import org.broadleafcommerce.common.structure.dto.ItemCriteriaDTO;
import org.broadleafcommerce.core.order.dao.OrderDao;
import org.broadleafcommerce.core.order.dao.OrderDaoImpl;
import org.broadleafcommerce.core.order.domain.BundleOrderItemImpl;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.order.domain.OrderItem;
import org.broadleafcommerce.profile.core.domain.Customer;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {PageCartRuleProcessor.class})
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(SpringJUnit4ClassRunner.class)
public class AbstractCartRuleProcessorDiffblueTest {
  @Autowired private AbstractCartRuleProcessor<PageDTO> abstractCartRuleProcessor;

  /**
   * Test {@link AbstractCartRuleProcessor#lookupOrderForCustomer(Customer)}.
   *
   * <ul>
   *   <li>Then return {@link NullOrderImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link AbstractCartRuleProcessor#lookupOrderForCustomer(Customer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Order AbstractCartRuleProcessor.lookupOrderForCustomer(Customer)"})
  public void testLookupOrderForCustomer_thenReturnNullOrderImpl() {
    // Arrange
    OrderDaoImpl orderDao = mock(OrderDaoImpl.class);
    NullOrderImpl nullOrderImpl = new NullOrderImpl();
    when(orderDao.readCartForCustomer(Mockito.<Customer>any())).thenReturn(nullOrderImpl);

    PageCartRuleProcessor pageCartRuleProcessor = new PageCartRuleProcessor();
    pageCartRuleProcessor.setOrderDao(orderDao);

    // Act
    Order actualLookupOrderForCustomerResult =
        pageCartRuleProcessor.lookupOrderForCustomer(new CustomerImpl());

    // Assert
    verify(orderDao).readCartForCustomer(isA(Customer.class));
    assertSame(nullOrderImpl, actualLookupOrderForCustomerResult);
  }

  /**
   * Test {@link AbstractCartRuleProcessor#lookupOrderForCustomer(Customer)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractCartRuleProcessor#lookupOrderForCustomer(Customer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Order AbstractCartRuleProcessor.lookupOrderForCustomer(Customer)"})
  public void testLookupOrderForCustomer_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(abstractCartRuleProcessor.lookupOrderForCustomer(null));
  }

  /**
   * Test {@link AbstractCartRuleProcessor#checkItemCriteria(ItemCriteriaDTO, List)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ItemCriteriaDTO} (default constructor) MatchRule is {@code 42}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractCartRuleProcessor#checkItemCriteria(ItemCriteriaDTO,
   * List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AbstractCartRuleProcessor.checkItemCriteria(ItemCriteriaDTO, List)"})
  public void testCheckItemCriteria_given42_whenItemCriteriaDTOMatchRuleIs42_thenReturnFalse() {
    // Arrange
    ItemCriteriaDTO itemCriteria = new ItemCriteriaDTO();
    itemCriteria.setMatchRule("42");
    itemCriteria.setQty(1);

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(new BundleOrderItemImpl());

    // Act and Assert
    assertFalse(abstractCartRuleProcessor.checkItemCriteria(itemCriteria, orderItems));
  }

  /**
   * Test {@link AbstractCartRuleProcessor#checkItemCriteria(ItemCriteriaDTO, List)}.
   *
   * <ul>
   *   <li>Given {@code discreteOrderItem}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractCartRuleProcessor#checkItemCriteria(ItemCriteriaDTO,
   * List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AbstractCartRuleProcessor.checkItemCriteria(ItemCriteriaDTO, List)"})
  public void testCheckItemCriteria_givenDiscreteOrderItem() {
    // Arrange
    ItemCriteriaDTO itemCriteria = new ItemCriteriaDTO();
    itemCriteria.setMatchRule("discreteOrderItem");
    itemCriteria.setQty(1);

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(new BundleOrderItemImpl());

    // Act and Assert
    assertFalse(abstractCartRuleProcessor.checkItemCriteria(itemCriteria, orderItems));
  }

  /**
   * Test {@link AbstractCartRuleProcessor#checkItemCriteria(ItemCriteriaDTO, List)}.
   *
   * <ul>
   *   <li>Given empty string.
   *   <li>When {@link ItemCriteriaDTO} (default constructor) MatchRule is empty string.
   * </ul>
   *
   * <p>Method under test: {@link AbstractCartRuleProcessor#checkItemCriteria(ItemCriteriaDTO,
   * List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AbstractCartRuleProcessor.checkItemCriteria(ItemCriteriaDTO, List)"})
  public void testCheckItemCriteria_givenEmptyString_whenItemCriteriaDTOMatchRuleIsEmptyString() {
    // Arrange
    ItemCriteriaDTO itemCriteria = new ItemCriteriaDTO();
    itemCriteria.setMatchRule("");
    itemCriteria.setQty(1);

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(new BundleOrderItemImpl());

    // Act and Assert
    assertFalse(abstractCartRuleProcessor.checkItemCriteria(itemCriteria, orderItems));
  }

  /**
   * Test {@link AbstractCartRuleProcessor#checkItemCriteria(ItemCriteriaDTO, List)}.
   *
   * <ul>
   *   <li>Given {@code getAdditionalAttributes()[xx]}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractCartRuleProcessor#checkItemCriteria(ItemCriteriaDTO,
   * List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AbstractCartRuleProcessor.checkItemCriteria(ItemCriteriaDTO, List)"})
  public void testCheckItemCriteria_givenGetAdditionalAttributesXx() {
    // Arrange
    ItemCriteriaDTO itemCriteria = new ItemCriteriaDTO();
    itemCriteria.setMatchRule("getAdditionalAttributes()[xx]");
    itemCriteria.setQty(1);

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(new BundleOrderItemImpl());

    // Act and Assert
    assertFalse(abstractCartRuleProcessor.checkItemCriteria(itemCriteria, orderItems));
  }

  /**
   * Test {@link AbstractCartRuleProcessor#checkItemCriteria(ItemCriteriaDTO, List)}.
   *
   * <ul>
   *   <li>Given {@code getAdditionalFields()[xx]}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractCartRuleProcessor#checkItemCriteria(ItemCriteriaDTO,
   * List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AbstractCartRuleProcessor.checkItemCriteria(ItemCriteriaDTO, List)"})
  public void testCheckItemCriteria_givenGetAdditionalFieldsXx() {
    // Arrange
    ItemCriteriaDTO itemCriteria = new ItemCriteriaDTO();
    itemCriteria.setMatchRule("getAdditionalFields()[xx]");
    itemCriteria.setQty(1);

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(new BundleOrderItemImpl());

    // Act and Assert
    assertFalse(abstractCartRuleProcessor.checkItemCriteria(itemCriteria, orderItems));
  }

  /**
   * Test {@link AbstractCartRuleProcessor#checkItemCriteria(ItemCriteriaDTO, List)}.
   *
   * <ul>
   *   <li>Given {@code getCategoryAttributesMap()[xx]}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractCartRuleProcessor#checkItemCriteria(ItemCriteriaDTO,
   * List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AbstractCartRuleProcessor.checkItemCriteria(ItemCriteriaDTO, List)"})
  public void testCheckItemCriteria_givenGetCategoryAttributesMapXx() {
    // Arrange
    ItemCriteriaDTO itemCriteria = new ItemCriteriaDTO();
    itemCriteria.setMatchRule("getCategoryAttributesMap()[xx]");
    itemCriteria.setQty(1);

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(new BundleOrderItemImpl());

    // Act and Assert
    assertFalse(abstractCartRuleProcessor.checkItemCriteria(itemCriteria, orderItems));
  }

  /**
   * Test {@link AbstractCartRuleProcessor#checkItemCriteria(ItemCriteriaDTO, List)}.
   *
   * <ul>
   *   <li>Given {@code getCustomerAttributes()[xx]}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractCartRuleProcessor#checkItemCriteria(ItemCriteriaDTO,
   * List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AbstractCartRuleProcessor.checkItemCriteria(ItemCriteriaDTO, List)"})
  public void testCheckItemCriteria_givenGetCustomerAttributesXx() {
    // Arrange
    ItemCriteriaDTO itemCriteria = new ItemCriteriaDTO();
    itemCriteria.setMatchRule("getCustomerAttributes()[xx]");
    itemCriteria.setQty(1);

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(new BundleOrderItemImpl());

    // Act and Assert
    assertFalse(abstractCartRuleProcessor.checkItemCriteria(itemCriteria, orderItems));
  }

  /**
   * Test {@link AbstractCartRuleProcessor#checkItemCriteria(ItemCriteriaDTO, List)}.
   *
   * <ul>
   *   <li>Given {@code getOrderItemAttributes()[xx]}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractCartRuleProcessor#checkItemCriteria(ItemCriteriaDTO,
   * List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AbstractCartRuleProcessor.checkItemCriteria(ItemCriteriaDTO, List)"})
  public void testCheckItemCriteria_givenGetOrderItemAttributesXx() {
    // Arrange
    ItemCriteriaDTO itemCriteria = new ItemCriteriaDTO();
    itemCriteria.setMatchRule("getOrderItemAttributes()[xx]");
    itemCriteria.setQty(1);

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(new BundleOrderItemImpl());

    // Act and Assert
    assertFalse(abstractCartRuleProcessor.checkItemCriteria(itemCriteria, orderItems));
  }

  /**
   * Test {@link AbstractCartRuleProcessor#checkItemCriteria(ItemCriteriaDTO, List)}.
   *
   * <ul>
   *   <li>Given {@code getProductAttributes()[xx]}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractCartRuleProcessor#checkItemCriteria(ItemCriteriaDTO,
   * List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AbstractCartRuleProcessor.checkItemCriteria(ItemCriteriaDTO, List)"})
  public void testCheckItemCriteria_givenGetProductAttributesXx() {
    // Arrange
    ItemCriteriaDTO itemCriteria = new ItemCriteriaDTO();
    itemCriteria.setMatchRule("getProductAttributes()[xx]");
    itemCriteria.setQty(1);

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(new BundleOrderItemImpl());

    // Act and Assert
    assertFalse(abstractCartRuleProcessor.checkItemCriteria(itemCriteria, orderItems));
  }

  /**
   * Test {@link AbstractCartRuleProcessor#checkItemCriteria(ItemCriteriaDTO, List)}.
   *
   * <ul>
   *   <li>Given {@code getSkuAttributes()[xx]}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractCartRuleProcessor#checkItemCriteria(ItemCriteriaDTO,
   * List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AbstractCartRuleProcessor.checkItemCriteria(ItemCriteriaDTO, List)"})
  public void testCheckItemCriteria_givenGetSkuAttributesXx() {
    // Arrange
    ItemCriteriaDTO itemCriteria = new ItemCriteriaDTO();
    itemCriteria.setMatchRule("getSkuAttributes()[xx]");
    itemCriteria.setQty(1);

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(new BundleOrderItemImpl());

    // Act and Assert
    assertFalse(abstractCartRuleProcessor.checkItemCriteria(itemCriteria, orderItems));
  }

  /**
   * Test {@link AbstractCartRuleProcessor#checkItemCriteria(ItemCriteriaDTO, List)}.
   *
   * <ul>
   *   <li>Given {@code Match Rule}.
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractCartRuleProcessor#checkItemCriteria(ItemCriteriaDTO,
   * List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AbstractCartRuleProcessor.checkItemCriteria(ItemCriteriaDTO, List)"})
  public void testCheckItemCriteria_givenMatchRule_whenArrayList_thenReturnFalse() {
    // Arrange
    ItemCriteriaDTO itemCriteria = new ItemCriteriaDTO();
    itemCriteria.setMatchRule("Match Rule");
    itemCriteria.setQty(1);

    // Act and Assert
    assertFalse(abstractCartRuleProcessor.checkItemCriteria(itemCriteria, new ArrayList<>()));
  }

  /**
   * Test {@link AbstractCartRuleProcessor#checkItemCriteria(ItemCriteriaDTO, List)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link ItemCriteriaDTO} (default constructor) MatchRule is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractCartRuleProcessor#checkItemCriteria(ItemCriteriaDTO,
   * List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AbstractCartRuleProcessor.checkItemCriteria(ItemCriteriaDTO, List)"})
  public void testCheckItemCriteria_givenNull_whenItemCriteriaDTOMatchRuleIsNull() {
    // Arrange
    ItemCriteriaDTO itemCriteria = new ItemCriteriaDTO();
    itemCriteria.setMatchRule(null);
    itemCriteria.setQty(1);

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(new BundleOrderItemImpl());

    // Act and Assert
    assertFalse(abstractCartRuleProcessor.checkItemCriteria(itemCriteria, orderItems));
  }

  /**
   * Test {@link AbstractCartRuleProcessor#checkItemCriteria(ItemCriteriaDTO, List)}.
   *
   * <ul>
   *   <li>Given seven.
   *   <li>When {@link ItemCriteriaDTO} (default constructor) Qty is seven.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractCartRuleProcessor#checkItemCriteria(ItemCriteriaDTO,
   * List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AbstractCartRuleProcessor.checkItemCriteria(ItemCriteriaDTO, List)"})
  public void testCheckItemCriteria_givenSeven_whenItemCriteriaDTOQtyIsSeven_thenReturnFalse() {
    // Arrange
    ItemCriteriaDTO itemCriteria = new ItemCriteriaDTO();
    itemCriteria.setMatchRule("getProductAttributes()[xx]");
    itemCriteria.setQty(7);

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(new BundleOrderItemImpl());

    // Act and Assert
    assertFalse(abstractCartRuleProcessor.checkItemCriteria(itemCriteria, orderItems));
  }

  /**
   * Test {@link AbstractCartRuleProcessor#checkItemCriteria(ItemCriteriaDTO, List)}.
   *
   * <ul>
   *   <li>Given zero.
   *   <li>When {@link ItemCriteriaDTO} (default constructor) Qty is zero.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractCartRuleProcessor#checkItemCriteria(ItemCriteriaDTO,
   * List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AbstractCartRuleProcessor.checkItemCriteria(ItemCriteriaDTO, List)"})
  public void testCheckItemCriteria_givenZero_whenItemCriteriaDTOQtyIsZero_thenReturnTrue() {
    // Arrange
    ItemCriteriaDTO itemCriteria = new ItemCriteriaDTO();
    itemCriteria.setMatchRule("Match Rule");
    itemCriteria.setQty(0);

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(new BundleOrderItemImpl());

    // Act and Assert
    assertTrue(abstractCartRuleProcessor.checkItemCriteria(itemCriteria, orderItems));
  }

  /**
   * Test {@link AbstractCartRuleProcessor#setOrderDao(OrderDao)}.
   *
   * <p>Method under test: {@link AbstractCartRuleProcessor#setOrderDao(OrderDao)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractCartRuleProcessor.setOrderDao(OrderDao)"})
  public void testSetOrderDao() {
    // Arrange
    OrderDaoImpl orderDao = new OrderDaoImpl();

    // Act
    abstractCartRuleProcessor.setOrderDao(orderDao);

    // Assert
    assertTrue(abstractCartRuleProcessor instanceof PageCartRuleProcessor);
    assertSame(orderDao, abstractCartRuleProcessor.getOrderDao());
  }

  /**
   * Test {@link AbstractCartRuleProcessor#getOrderDao()}.
   *
   * <p>Method under test: {@link AbstractCartRuleProcessor#getOrderDao()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"OrderDao AbstractCartRuleProcessor.getOrderDao()"})
  public void testGetOrderDao() {
    // Arrange, Act and Assert
    assertNull(abstractCartRuleProcessor.getOrderDao());
  }
}
