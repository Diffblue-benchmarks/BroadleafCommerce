/*-
 * #%L
 * BroadleafCommerce Framework
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
package org.broadleafcommerce.core.order.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.broadleafcommerce.common.page.dto.PageDTO;
import org.broadleafcommerce.common.structure.dto.ItemCriteriaDTO;
import org.broadleafcommerce.core.order.dao.OrderDao;
import org.broadleafcommerce.core.order.dao.OrderDaoImpl;
import org.broadleafcommerce.core.order.domain.BundleOrderItemImpl;
import org.broadleafcommerce.core.order.domain.OrderItem;
import org.broadleafcommerce.profile.core.domain.Customer;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {PageCartRuleProcessor.class})
@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class AbstractCartRuleProcessorDiffblueTest {
  @Autowired
  private AbstractCartRuleProcessor<PageDTO> abstractCartRuleProcessor;

  /**
   * Test {@link AbstractCartRuleProcessor#lookupOrderForCustomer(Customer)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractCartRuleProcessor#lookupOrderForCustomer(Customer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "org.broadleafcommerce.core.order.domain.Order AbstractCartRuleProcessor.lookupOrderForCustomer(Customer)"})
  public void testLookupOrderForCustomer_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(abstractCartRuleProcessor.lookupOrderForCustomer(null));
  }

  /**
   * Test {@link AbstractCartRuleProcessor#checkItemCriteria(ItemCriteriaDTO, List)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link ItemCriteriaDTO} (default constructor) MatchRule is {@code 42}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractCartRuleProcessor#checkItemCriteria(ItemCriteriaDTO, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
   * <ul>
   *   <li>Given {@code discreteOrderItem}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractCartRuleProcessor#checkItemCriteria(ItemCriteriaDTO, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
   * <ul>
   *   <li>Given empty string.</li>
   *   <li>When {@link ItemCriteriaDTO} (default constructor) MatchRule is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractCartRuleProcessor#checkItemCriteria(ItemCriteriaDTO, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
   * <ul>
   *   <li>Given {@code getAdditionalAttributes()[UU]}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractCartRuleProcessor#checkItemCriteria(ItemCriteriaDTO, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AbstractCartRuleProcessor.checkItemCriteria(ItemCriteriaDTO, List)"})
  public void testCheckItemCriteria_givenGetAdditionalAttributesUu() {
    // Arrange
    ItemCriteriaDTO itemCriteria = new ItemCriteriaDTO();
    itemCriteria.setMatchRule("getAdditionalAttributes()[UU]");
    itemCriteria.setQty(1);

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(new BundleOrderItemImpl());

    // Act and Assert
    assertFalse(abstractCartRuleProcessor.checkItemCriteria(itemCriteria, orderItems));
  }

  /**
   * Test {@link AbstractCartRuleProcessor#checkItemCriteria(ItemCriteriaDTO, List)}.
   * <ul>
   *   <li>Given {@code getAdditionalFields()[UU]}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractCartRuleProcessor#checkItemCriteria(ItemCriteriaDTO, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AbstractCartRuleProcessor.checkItemCriteria(ItemCriteriaDTO, List)"})
  public void testCheckItemCriteria_givenGetAdditionalFieldsUu() {
    // Arrange
    ItemCriteriaDTO itemCriteria = new ItemCriteriaDTO();
    itemCriteria.setMatchRule("getAdditionalFields()[UU]");
    itemCriteria.setQty(1);

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(new BundleOrderItemImpl());

    // Act and Assert
    assertFalse(abstractCartRuleProcessor.checkItemCriteria(itemCriteria, orderItems));
  }

  /**
   * Test {@link AbstractCartRuleProcessor#checkItemCriteria(ItemCriteriaDTO, List)}.
   * <ul>
   *   <li>Given {@code getCategoryAttributesMap()[UU]}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractCartRuleProcessor#checkItemCriteria(ItemCriteriaDTO, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AbstractCartRuleProcessor.checkItemCriteria(ItemCriteriaDTO, List)"})
  public void testCheckItemCriteria_givenGetCategoryAttributesMapUu() {
    // Arrange
    ItemCriteriaDTO itemCriteria = new ItemCriteriaDTO();
    itemCriteria.setMatchRule("getCategoryAttributesMap()[UU]");
    itemCriteria.setQty(1);

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(new BundleOrderItemImpl());

    // Act and Assert
    assertFalse(abstractCartRuleProcessor.checkItemCriteria(itemCriteria, orderItems));
  }

  /**
   * Test {@link AbstractCartRuleProcessor#checkItemCriteria(ItemCriteriaDTO, List)}.
   * <ul>
   *   <li>Given {@code getCustomerAttributes()[UU]}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractCartRuleProcessor#checkItemCriteria(ItemCriteriaDTO, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AbstractCartRuleProcessor.checkItemCriteria(ItemCriteriaDTO, List)"})
  public void testCheckItemCriteria_givenGetCustomerAttributesUu() {
    // Arrange
    ItemCriteriaDTO itemCriteria = new ItemCriteriaDTO();
    itemCriteria.setMatchRule("getCustomerAttributes()[UU]");
    itemCriteria.setQty(1);

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(new BundleOrderItemImpl());

    // Act and Assert
    assertFalse(abstractCartRuleProcessor.checkItemCriteria(itemCriteria, orderItems));
  }

  /**
   * Test {@link AbstractCartRuleProcessor#checkItemCriteria(ItemCriteriaDTO, List)}.
   * <ul>
   *   <li>Given {@code getOrderItemAttributes()[UU]}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractCartRuleProcessor#checkItemCriteria(ItemCriteriaDTO, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AbstractCartRuleProcessor.checkItemCriteria(ItemCriteriaDTO, List)"})
  public void testCheckItemCriteria_givenGetOrderItemAttributesUu() {
    // Arrange
    ItemCriteriaDTO itemCriteria = new ItemCriteriaDTO();
    itemCriteria.setMatchRule("getOrderItemAttributes()[UU]");
    itemCriteria.setQty(1);

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(new BundleOrderItemImpl());

    // Act and Assert
    assertFalse(abstractCartRuleProcessor.checkItemCriteria(itemCriteria, orderItems));
  }

  /**
   * Test {@link AbstractCartRuleProcessor#checkItemCriteria(ItemCriteriaDTO, List)}.
   * <ul>
   *   <li>Given {@code getProductAttributes()[UU]}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractCartRuleProcessor#checkItemCriteria(ItemCriteriaDTO, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AbstractCartRuleProcessor.checkItemCriteria(ItemCriteriaDTO, List)"})
  public void testCheckItemCriteria_givenGetProductAttributesUu() {
    // Arrange
    ItemCriteriaDTO itemCriteria = new ItemCriteriaDTO();
    itemCriteria.setMatchRule("getProductAttributes()[UU]");
    itemCriteria.setQty(1);

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(new BundleOrderItemImpl());

    // Act and Assert
    assertFalse(abstractCartRuleProcessor.checkItemCriteria(itemCriteria, orderItems));
  }

  /**
   * Test {@link AbstractCartRuleProcessor#checkItemCriteria(ItemCriteriaDTO, List)}.
   * <ul>
   *   <li>Given {@code getSkuAttributes()[UU]}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractCartRuleProcessor#checkItemCriteria(ItemCriteriaDTO, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AbstractCartRuleProcessor.checkItemCriteria(ItemCriteriaDTO, List)"})
  public void testCheckItemCriteria_givenGetSkuAttributesUu() {
    // Arrange
    ItemCriteriaDTO itemCriteria = new ItemCriteriaDTO();
    itemCriteria.setMatchRule("getSkuAttributes()[UU]");
    itemCriteria.setQty(1);

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(new BundleOrderItemImpl());

    // Act and Assert
    assertFalse(abstractCartRuleProcessor.checkItemCriteria(itemCriteria, orderItems));
  }

  /**
   * Test {@link AbstractCartRuleProcessor#checkItemCriteria(ItemCriteriaDTO, List)}.
   * <ul>
   *   <li>Given {@code Match Rule}.</li>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractCartRuleProcessor#checkItemCriteria(ItemCriteriaDTO, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
   * <ul>
   *   <li>Given seven.</li>
   *   <li>When {@link ItemCriteriaDTO} (default constructor) Qty is seven.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractCartRuleProcessor#checkItemCriteria(ItemCriteriaDTO, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AbstractCartRuleProcessor.checkItemCriteria(ItemCriteriaDTO, List)"})
  public void testCheckItemCriteria_givenSeven_whenItemCriteriaDTOQtyIsSeven_thenReturnFalse() {
    // Arrange
    ItemCriteriaDTO itemCriteria = new ItemCriteriaDTO();
    itemCriteria.setMatchRule("getProductAttributes()[UU]");
    itemCriteria.setQty(7);

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(new BundleOrderItemImpl());

    // Act and Assert
    assertFalse(abstractCartRuleProcessor.checkItemCriteria(itemCriteria, orderItems));
  }

  /**
   * Test {@link AbstractCartRuleProcessor#checkItemCriteria(ItemCriteriaDTO, List)}.
   * <ul>
   *   <li>Given zero.</li>
   *   <li>When {@link ItemCriteriaDTO} (default constructor) Qty is zero.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractCartRuleProcessor#checkItemCriteria(ItemCriteriaDTO, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
   * <p>
   * Method under test: {@link AbstractCartRuleProcessor#setOrderDao(OrderDao)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
   * <p>
   * Method under test: {@link AbstractCartRuleProcessor#getOrderDao()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"OrderDao AbstractCartRuleProcessor.getOrderDao()"})
  public void testGetOrderDao() {
    // Arrange, Act and Assert
    assertNull(abstractCartRuleProcessor.getOrderDao());
  }
}
