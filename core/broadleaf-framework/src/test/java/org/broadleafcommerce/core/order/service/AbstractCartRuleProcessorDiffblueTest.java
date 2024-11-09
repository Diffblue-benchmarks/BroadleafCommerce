/*-
 * #%L
 * BroadleafCommerce Framework
 * %%
 * Copyright (C) 2009 - 2024 Broadleaf Commerce
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
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
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
import org.mockito.Mockito;

public class AbstractCartRuleProcessorDiffblueTest {
  /**
   * Test {@link AbstractCartRuleProcessor#lookupOrderForCustomer(Customer)}.
   * <ul>
   *   <li>Given {@link PageCartRuleProcessor} (default constructor).</li>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractCartRuleProcessor#lookupOrderForCustomer(Customer)}
   */
  @Test
  public void testLookupOrderForCustomer_givenPageCartRuleProcessor_whenNull_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new PageCartRuleProcessor()).lookupOrderForCustomer(null));
  }

  /**
   * Test {@link AbstractCartRuleProcessor#lookupOrderForCustomer(Customer)}.
   * <ul>
   *   <li>Then return {@link NullOrderImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractCartRuleProcessor#lookupOrderForCustomer(Customer)}
   */
  @Test
  public void testLookupOrderForCustomer_thenReturnNullOrderImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderDaoImpl orderDao = mock(OrderDaoImpl.class);
    NullOrderImpl nullOrderImpl = new NullOrderImpl();
    when(orderDao.readCartForCustomer(Mockito.<Customer>any())).thenReturn(nullOrderImpl);

    PageCartRuleProcessor pageCartRuleProcessor = new PageCartRuleProcessor();
    pageCartRuleProcessor.setOrderDao(orderDao);

    // Act
    Order actualLookupOrderForCustomerResult = pageCartRuleProcessor.lookupOrderForCustomer(new CustomerImpl());

    // Assert
    verify(orderDao).readCartForCustomer(isA(Customer.class));
    assertSame(nullOrderImpl, actualLookupOrderForCustomerResult);
  }

  /**
   * Test
   * {@link AbstractCartRuleProcessor#checkItemCriteria(ItemCriteriaDTO, List)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link ItemCriteriaDTO} {@link ItemCriteriaDTO#getMatchRule()}
   * return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractCartRuleProcessor#checkItemCriteria(ItemCriteriaDTO, List)}
   */
  @Test
  public void testCheckItemCriteria_given42_whenItemCriteriaDTOGetMatchRuleReturn42() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PageCartRuleProcessor pageCartRuleProcessor = new PageCartRuleProcessor();
    ItemCriteriaDTO itemCriteria = mock(ItemCriteriaDTO.class);
    when(itemCriteria.getMatchRule()).thenReturn("42");
    when(itemCriteria.getQty()).thenReturn(1);
    doNothing().when(itemCriteria).setMatchRule(Mockito.<String>any());
    doNothing().when(itemCriteria).setQty(Mockito.<Integer>any());
    itemCriteria.setMatchRule("Match Rule");
    itemCriteria.setQty(1);

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(new BundleOrderItemImpl());

    // Act
    boolean actualCheckItemCriteriaResult = pageCartRuleProcessor.checkItemCriteria(itemCriteria, orderItems);

    // Assert
    verify(itemCriteria).getMatchRule();
    verify(itemCriteria, atLeast(1)).getQty();
    verify(itemCriteria).setMatchRule(eq("Match Rule"));
    verify(itemCriteria).setQty(eq(1));
    assertFalse(actualCheckItemCriteriaResult);
  }

  /**
   * Test
   * {@link AbstractCartRuleProcessor#checkItemCriteria(ItemCriteriaDTO, List)}.
   * <ul>
   *   <li>Given {@code discreteOrderItem}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractCartRuleProcessor#checkItemCriteria(ItemCriteriaDTO, List)}
   */
  @Test
  public void testCheckItemCriteria_givenDiscreteOrderItem() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PageCartRuleProcessor pageCartRuleProcessor = new PageCartRuleProcessor();
    ItemCriteriaDTO itemCriteria = mock(ItemCriteriaDTO.class);
    when(itemCriteria.getMatchRule()).thenReturn("discreteOrderItem");
    when(itemCriteria.getQty()).thenReturn(1);
    doNothing().when(itemCriteria).setMatchRule(Mockito.<String>any());
    doNothing().when(itemCriteria).setQty(Mockito.<Integer>any());
    itemCriteria.setMatchRule("Match Rule");
    itemCriteria.setQty(1);

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(new BundleOrderItemImpl());
    orderItems.add(new BundleOrderItemImpl());

    // Act
    boolean actualCheckItemCriteriaResult = pageCartRuleProcessor.checkItemCriteria(itemCriteria, orderItems);

    // Assert
    verify(itemCriteria, atLeast(1)).getMatchRule();
    verify(itemCriteria, atLeast(1)).getQty();
    verify(itemCriteria).setMatchRule(eq("Match Rule"));
    verify(itemCriteria).setQty(eq(1));
    assertFalse(actualCheckItemCriteriaResult);
  }

  /**
   * Test
   * {@link AbstractCartRuleProcessor#checkItemCriteria(ItemCriteriaDTO, List)}.
   * <ul>
   *   <li>Given empty string.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractCartRuleProcessor#checkItemCriteria(ItemCriteriaDTO, List)}
   */
  @Test
  public void testCheckItemCriteria_givenEmptyString() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PageCartRuleProcessor pageCartRuleProcessor = new PageCartRuleProcessor();
    ItemCriteriaDTO itemCriteria = mock(ItemCriteriaDTO.class);
    when(itemCriteria.getMatchRule()).thenReturn("");
    when(itemCriteria.getQty()).thenReturn(1);
    doNothing().when(itemCriteria).setMatchRule(Mockito.<String>any());
    doNothing().when(itemCriteria).setQty(Mockito.<Integer>any());
    itemCriteria.setMatchRule("Match Rule");
    itemCriteria.setQty(1);

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(new BundleOrderItemImpl());

    // Act
    boolean actualCheckItemCriteriaResult = pageCartRuleProcessor.checkItemCriteria(itemCriteria, orderItems);

    // Assert
    verify(itemCriteria).getMatchRule();
    verify(itemCriteria, atLeast(1)).getQty();
    verify(itemCriteria).setMatchRule(eq("Match Rule"));
    verify(itemCriteria).setQty(eq(1));
    assertFalse(actualCheckItemCriteriaResult);
  }

  /**
   * Test
   * {@link AbstractCartRuleProcessor#checkItemCriteria(ItemCriteriaDTO, List)}.
   * <ul>
   *   <li>Given {@code foo}.</li>
   *   <li>When {@link ItemCriteriaDTO} {@link ItemCriteriaDTO#getMatchRule()}
   * return {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractCartRuleProcessor#checkItemCriteria(ItemCriteriaDTO, List)}
   */
  @Test
  public void testCheckItemCriteria_givenFoo_whenItemCriteriaDTOGetMatchRuleReturnFoo() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PageCartRuleProcessor pageCartRuleProcessor = new PageCartRuleProcessor();
    ItemCriteriaDTO itemCriteria = mock(ItemCriteriaDTO.class);
    when(itemCriteria.getMatchRule()).thenReturn("foo");
    when(itemCriteria.getQty()).thenReturn(1);
    doNothing().when(itemCriteria).setMatchRule(Mockito.<String>any());
    doNothing().when(itemCriteria).setQty(Mockito.<Integer>any());
    itemCriteria.setMatchRule("Match Rule");
    itemCriteria.setQty(1);

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(new BundleOrderItemImpl());

    // Act
    boolean actualCheckItemCriteriaResult = pageCartRuleProcessor.checkItemCriteria(itemCriteria, orderItems);

    // Assert
    verify(itemCriteria).getMatchRule();
    verify(itemCriteria, atLeast(1)).getQty();
    verify(itemCriteria).setMatchRule(eq("Match Rule"));
    verify(itemCriteria).setQty(eq(1));
    assertFalse(actualCheckItemCriteriaResult);
  }

  /**
   * Test
   * {@link AbstractCartRuleProcessor#checkItemCriteria(ItemCriteriaDTO, List)}.
   * <ul>
   *   <li>Given {@code getAdditionalAttributes()[UU]}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractCartRuleProcessor#checkItemCriteria(ItemCriteriaDTO, List)}
   */
  @Test
  public void testCheckItemCriteria_givenGetAdditionalAttributesUu() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PageCartRuleProcessor pageCartRuleProcessor = new PageCartRuleProcessor();
    ItemCriteriaDTO itemCriteria = mock(ItemCriteriaDTO.class);
    when(itemCriteria.getMatchRule()).thenReturn("getAdditionalAttributes()[UU]");
    when(itemCriteria.getQty()).thenReturn(1);
    doNothing().when(itemCriteria).setMatchRule(Mockito.<String>any());
    doNothing().when(itemCriteria).setQty(Mockito.<Integer>any());
    itemCriteria.setMatchRule("Match Rule");
    itemCriteria.setQty(1);

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(new BundleOrderItemImpl());
    orderItems.add(new BundleOrderItemImpl());

    // Act
    boolean actualCheckItemCriteriaResult = pageCartRuleProcessor.checkItemCriteria(itemCriteria, orderItems);

    // Assert
    verify(itemCriteria, atLeast(1)).getMatchRule();
    verify(itemCriteria, atLeast(1)).getQty();
    verify(itemCriteria).setMatchRule(eq("Match Rule"));
    verify(itemCriteria).setQty(eq(1));
    assertFalse(actualCheckItemCriteriaResult);
  }

  /**
   * Test
   * {@link AbstractCartRuleProcessor#checkItemCriteria(ItemCriteriaDTO, List)}.
   * <ul>
   *   <li>Given {@code getAdditionalFields()[UU]}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractCartRuleProcessor#checkItemCriteria(ItemCriteriaDTO, List)}
   */
  @Test
  public void testCheckItemCriteria_givenGetAdditionalFieldsUu() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PageCartRuleProcessor pageCartRuleProcessor = new PageCartRuleProcessor();
    ItemCriteriaDTO itemCriteria = mock(ItemCriteriaDTO.class);
    when(itemCriteria.getMatchRule()).thenReturn("getAdditionalFields()[UU]");
    when(itemCriteria.getQty()).thenReturn(1);
    doNothing().when(itemCriteria).setMatchRule(Mockito.<String>any());
    doNothing().when(itemCriteria).setQty(Mockito.<Integer>any());
    itemCriteria.setMatchRule("Match Rule");
    itemCriteria.setQty(1);

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(new BundleOrderItemImpl());
    orderItems.add(new BundleOrderItemImpl());

    // Act
    boolean actualCheckItemCriteriaResult = pageCartRuleProcessor.checkItemCriteria(itemCriteria, orderItems);

    // Assert
    verify(itemCriteria, atLeast(1)).getMatchRule();
    verify(itemCriteria, atLeast(1)).getQty();
    verify(itemCriteria).setMatchRule(eq("Match Rule"));
    verify(itemCriteria).setQty(eq(1));
    assertFalse(actualCheckItemCriteriaResult);
  }

  /**
   * Test
   * {@link AbstractCartRuleProcessor#checkItemCriteria(ItemCriteriaDTO, List)}.
   * <ul>
   *   <li>Given {@code getCategoryAttributesMap()[UU]}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractCartRuleProcessor#checkItemCriteria(ItemCriteriaDTO, List)}
   */
  @Test
  public void testCheckItemCriteria_givenGetCategoryAttributesMapUu() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PageCartRuleProcessor pageCartRuleProcessor = new PageCartRuleProcessor();
    ItemCriteriaDTO itemCriteria = mock(ItemCriteriaDTO.class);
    when(itemCriteria.getMatchRule()).thenReturn("getCategoryAttributesMap()[UU]");
    when(itemCriteria.getQty()).thenReturn(1);
    doNothing().when(itemCriteria).setMatchRule(Mockito.<String>any());
    doNothing().when(itemCriteria).setQty(Mockito.<Integer>any());
    itemCriteria.setMatchRule("Match Rule");
    itemCriteria.setQty(1);

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(new BundleOrderItemImpl());
    orderItems.add(new BundleOrderItemImpl());

    // Act
    boolean actualCheckItemCriteriaResult = pageCartRuleProcessor.checkItemCriteria(itemCriteria, orderItems);

    // Assert
    verify(itemCriteria, atLeast(1)).getMatchRule();
    verify(itemCriteria, atLeast(1)).getQty();
    verify(itemCriteria).setMatchRule(eq("Match Rule"));
    verify(itemCriteria).setQty(eq(1));
    assertFalse(actualCheckItemCriteriaResult);
  }

  /**
   * Test
   * {@link AbstractCartRuleProcessor#checkItemCriteria(ItemCriteriaDTO, List)}.
   * <ul>
   *   <li>Given {@code getCustomerAttributes()[UU]}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractCartRuleProcessor#checkItemCriteria(ItemCriteriaDTO, List)}
   */
  @Test
  public void testCheckItemCriteria_givenGetCustomerAttributesUu() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PageCartRuleProcessor pageCartRuleProcessor = new PageCartRuleProcessor();
    ItemCriteriaDTO itemCriteria = mock(ItemCriteriaDTO.class);
    when(itemCriteria.getMatchRule()).thenReturn("getCustomerAttributes()[UU]");
    when(itemCriteria.getQty()).thenReturn(1);
    doNothing().when(itemCriteria).setMatchRule(Mockito.<String>any());
    doNothing().when(itemCriteria).setQty(Mockito.<Integer>any());
    itemCriteria.setMatchRule("Match Rule");
    itemCriteria.setQty(1);

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(new BundleOrderItemImpl());
    orderItems.add(new BundleOrderItemImpl());

    // Act
    boolean actualCheckItemCriteriaResult = pageCartRuleProcessor.checkItemCriteria(itemCriteria, orderItems);

    // Assert
    verify(itemCriteria, atLeast(1)).getMatchRule();
    verify(itemCriteria, atLeast(1)).getQty();
    verify(itemCriteria).setMatchRule(eq("Match Rule"));
    verify(itemCriteria).setQty(eq(1));
    assertFalse(actualCheckItemCriteriaResult);
  }

  /**
   * Test
   * {@link AbstractCartRuleProcessor#checkItemCriteria(ItemCriteriaDTO, List)}.
   * <ul>
   *   <li>Given {@code getOrderItemAttributes()[UU]}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractCartRuleProcessor#checkItemCriteria(ItemCriteriaDTO, List)}
   */
  @Test
  public void testCheckItemCriteria_givenGetOrderItemAttributesUu() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PageCartRuleProcessor pageCartRuleProcessor = new PageCartRuleProcessor();
    ItemCriteriaDTO itemCriteria = mock(ItemCriteriaDTO.class);
    when(itemCriteria.getMatchRule()).thenReturn("getOrderItemAttributes()[UU]");
    when(itemCriteria.getQty()).thenReturn(1);
    doNothing().when(itemCriteria).setMatchRule(Mockito.<String>any());
    doNothing().when(itemCriteria).setQty(Mockito.<Integer>any());
    itemCriteria.setMatchRule("Match Rule");
    itemCriteria.setQty(1);

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(new BundleOrderItemImpl());
    orderItems.add(new BundleOrderItemImpl());

    // Act
    boolean actualCheckItemCriteriaResult = pageCartRuleProcessor.checkItemCriteria(itemCriteria, orderItems);

    // Assert
    verify(itemCriteria, atLeast(1)).getMatchRule();
    verify(itemCriteria, atLeast(1)).getQty();
    verify(itemCriteria).setMatchRule(eq("Match Rule"));
    verify(itemCriteria).setQty(eq(1));
    assertFalse(actualCheckItemCriteriaResult);
  }

  /**
   * Test
   * {@link AbstractCartRuleProcessor#checkItemCriteria(ItemCriteriaDTO, List)}.
   * <ul>
   *   <li>Given {@code getProductAttributes()[UU]}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractCartRuleProcessor#checkItemCriteria(ItemCriteriaDTO, List)}
   */
  @Test
  public void testCheckItemCriteria_givenGetProductAttributesUu() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PageCartRuleProcessor pageCartRuleProcessor = new PageCartRuleProcessor();
    ItemCriteriaDTO itemCriteria = mock(ItemCriteriaDTO.class);
    when(itemCriteria.getMatchRule()).thenReturn("getProductAttributes()[UU]");
    when(itemCriteria.getQty()).thenReturn(1);
    doNothing().when(itemCriteria).setMatchRule(Mockito.<String>any());
    doNothing().when(itemCriteria).setQty(Mockito.<Integer>any());
    itemCriteria.setMatchRule("Match Rule");
    itemCriteria.setQty(1);

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(new BundleOrderItemImpl());
    orderItems.add(new BundleOrderItemImpl());

    // Act
    boolean actualCheckItemCriteriaResult = pageCartRuleProcessor.checkItemCriteria(itemCriteria, orderItems);

    // Assert
    verify(itemCriteria, atLeast(1)).getMatchRule();
    verify(itemCriteria, atLeast(1)).getQty();
    verify(itemCriteria).setMatchRule(eq("Match Rule"));
    verify(itemCriteria).setQty(eq(1));
    assertFalse(actualCheckItemCriteriaResult);
  }

  /**
   * Test
   * {@link AbstractCartRuleProcessor#checkItemCriteria(ItemCriteriaDTO, List)}.
   * <ul>
   *   <li>Given {@code getSkuAttributes()[UU]}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractCartRuleProcessor#checkItemCriteria(ItemCriteriaDTO, List)}
   */
  @Test
  public void testCheckItemCriteria_givenGetSkuAttributesUu() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PageCartRuleProcessor pageCartRuleProcessor = new PageCartRuleProcessor();
    ItemCriteriaDTO itemCriteria = mock(ItemCriteriaDTO.class);
    when(itemCriteria.getMatchRule()).thenReturn("getSkuAttributes()[UU]");
    when(itemCriteria.getQty()).thenReturn(1);
    doNothing().when(itemCriteria).setMatchRule(Mockito.<String>any());
    doNothing().when(itemCriteria).setQty(Mockito.<Integer>any());
    itemCriteria.setMatchRule("Match Rule");
    itemCriteria.setQty(1);

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(new BundleOrderItemImpl());
    orderItems.add(new BundleOrderItemImpl());

    // Act
    boolean actualCheckItemCriteriaResult = pageCartRuleProcessor.checkItemCriteria(itemCriteria, orderItems);

    // Assert
    verify(itemCriteria, atLeast(1)).getMatchRule();
    verify(itemCriteria, atLeast(1)).getQty();
    verify(itemCriteria).setMatchRule(eq("Match Rule"));
    verify(itemCriteria).setQty(eq(1));
    assertFalse(actualCheckItemCriteriaResult);
  }

  /**
   * Test
   * {@link AbstractCartRuleProcessor#checkItemCriteria(ItemCriteriaDTO, List)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then calls {@link ItemCriteriaDTO#getQty()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractCartRuleProcessor#checkItemCriteria(ItemCriteriaDTO, List)}
   */
  @Test
  public void testCheckItemCriteria_givenOne_whenArrayList_thenCallsGetQty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PageCartRuleProcessor pageCartRuleProcessor = new PageCartRuleProcessor();
    ItemCriteriaDTO itemCriteria = mock(ItemCriteriaDTO.class);
    when(itemCriteria.getQty()).thenReturn(1);
    doNothing().when(itemCriteria).setMatchRule(Mockito.<String>any());
    doNothing().when(itemCriteria).setQty(Mockito.<Integer>any());
    itemCriteria.setMatchRule("Match Rule");
    itemCriteria.setQty(1);

    // Act
    boolean actualCheckItemCriteriaResult = pageCartRuleProcessor.checkItemCriteria(itemCriteria, new ArrayList<>());

    // Assert
    verify(itemCriteria, atLeast(1)).getQty();
    verify(itemCriteria).setMatchRule(eq("Match Rule"));
    verify(itemCriteria).setQty(eq(1));
    assertFalse(actualCheckItemCriteriaResult);
  }

  /**
   * Test
   * {@link AbstractCartRuleProcessor#checkItemCriteria(ItemCriteriaDTO, List)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>When {@link ItemCriteriaDTO} (default constructor) Qty is one.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractCartRuleProcessor#checkItemCriteria(ItemCriteriaDTO, List)}
   */
  @Test
  public void testCheckItemCriteria_givenOne_whenItemCriteriaDTOQtyIsOne_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PageCartRuleProcessor pageCartRuleProcessor = new PageCartRuleProcessor();

    ItemCriteriaDTO itemCriteria = new ItemCriteriaDTO();
    itemCriteria.setMatchRule("Match Rule");
    itemCriteria.setQty(1);

    // Act and Assert
    assertFalse(pageCartRuleProcessor.checkItemCriteria(itemCriteria, new ArrayList<>()));
  }

  /**
   * Test
   * {@link AbstractCartRuleProcessor#checkItemCriteria(ItemCriteriaDTO, List)}.
   * <ul>
   *   <li>Given seven.</li>
   *   <li>When {@link ItemCriteriaDTO} {@link ItemCriteriaDTO#getQty()} return
   * seven.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractCartRuleProcessor#checkItemCriteria(ItemCriteriaDTO, List)}
   */
  @Test
  public void testCheckItemCriteria_givenSeven_whenItemCriteriaDTOGetQtyReturnSeven() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PageCartRuleProcessor pageCartRuleProcessor = new PageCartRuleProcessor();
    ItemCriteriaDTO itemCriteria = mock(ItemCriteriaDTO.class);
    when(itemCriteria.getMatchRule()).thenReturn("foo");
    when(itemCriteria.getQty()).thenReturn(7);
    doNothing().when(itemCriteria).setMatchRule(Mockito.<String>any());
    doNothing().when(itemCriteria).setQty(Mockito.<Integer>any());
    itemCriteria.setMatchRule("Match Rule");
    itemCriteria.setQty(1);

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(new BundleOrderItemImpl());

    // Act
    boolean actualCheckItemCriteriaResult = pageCartRuleProcessor.checkItemCriteria(itemCriteria, orderItems);

    // Assert
    verify(itemCriteria).getMatchRule();
    verify(itemCriteria, atLeast(1)).getQty();
    verify(itemCriteria).setMatchRule(eq("Match Rule"));
    verify(itemCriteria).setQty(eq(1));
    assertFalse(actualCheckItemCriteriaResult);
  }

  /**
   * Test
   * {@link AbstractCartRuleProcessor#checkItemCriteria(ItemCriteriaDTO, List)}.
   * <ul>
   *   <li>Given zero.</li>
   *   <li>When {@link ItemCriteriaDTO} (default constructor) Qty is zero.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractCartRuleProcessor#checkItemCriteria(ItemCriteriaDTO, List)}
   */
  @Test
  public void testCheckItemCriteria_givenZero_whenItemCriteriaDTOQtyIsZero_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PageCartRuleProcessor pageCartRuleProcessor = new PageCartRuleProcessor();

    ItemCriteriaDTO itemCriteria = new ItemCriteriaDTO();
    itemCriteria.setMatchRule("Match Rule");
    itemCriteria.setQty(0);

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(new BundleOrderItemImpl());

    // Act and Assert
    assertTrue(pageCartRuleProcessor.checkItemCriteria(itemCriteria, orderItems));
  }

  /**
   * Test {@link AbstractCartRuleProcessor#setOrderDao(OrderDao)}.
   * <ul>
   *   <li>When {@link OrderDaoImpl} (default constructor).</li>
   *   <li>Then {@link PageCartRuleProcessor} (default constructor) OrderDao is
   * {@link OrderDaoImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractCartRuleProcessor#setOrderDao(OrderDao)}
   */
  @Test
  public void testSetOrderDao_whenOrderDaoImpl_thenPageCartRuleProcessorOrderDaoIsOrderDaoImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PageCartRuleProcessor pageCartRuleProcessor = new PageCartRuleProcessor();
    OrderDaoImpl orderDao = new OrderDaoImpl();

    // Act
    pageCartRuleProcessor.setOrderDao(orderDao);

    // Assert
    assertSame(orderDao, pageCartRuleProcessor.getOrderDao());
  }

  /**
   * Test {@link AbstractCartRuleProcessor#setOrderDao(OrderDao)}.
   * <ul>
   *   <li>When {@link OrderDaoImpl}.</li>
   *   <li>Then {@link PageCartRuleProcessor} (default constructor) OrderDao is
   * {@link OrderDaoImpl}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractCartRuleProcessor#setOrderDao(OrderDao)}
   */
  @Test
  public void testSetOrderDao_whenOrderDaoImpl_thenPageCartRuleProcessorOrderDaoIsOrderDaoImpl2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PageCartRuleProcessor pageCartRuleProcessor = new PageCartRuleProcessor();
    OrderDaoImpl orderDao = mock(OrderDaoImpl.class);

    // Act
    pageCartRuleProcessor.setOrderDao(orderDao);

    // Assert
    assertSame(orderDao, pageCartRuleProcessor.getOrderDao());
  }

  /**
   * Test {@link AbstractCartRuleProcessor#getOrderDao()}.
   * <ul>
   *   <li>Given {@link PageCartRuleProcessor} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractCartRuleProcessor#getOrderDao()}
   */
  @Test
  public void testGetOrderDao_givenPageCartRuleProcessor_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new PageCartRuleProcessor()).getOrderDao());
  }

  /**
   * Test {@link AbstractCartRuleProcessor#getOrderDao()}.
   * <ul>
   *   <li>Then return {@link PageCartRuleProcessor} (default constructor)
   * {@link AbstractCartRuleProcessor#orderDao}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractCartRuleProcessor#getOrderDao()}
   */
  @Test
  public void testGetOrderDao_thenReturnPageCartRuleProcessorOrderDao() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PageCartRuleProcessor pageCartRuleProcessor = new PageCartRuleProcessor();
    pageCartRuleProcessor.setOrderDao(mock(OrderDaoImpl.class));

    // Act and Assert
    assertSame(pageCartRuleProcessor.orderDao, pageCartRuleProcessor.getOrderDao());
  }
}
