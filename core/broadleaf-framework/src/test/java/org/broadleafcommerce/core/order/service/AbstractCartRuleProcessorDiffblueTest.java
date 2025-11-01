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
   * Method under test:
   * {@link AbstractCartRuleProcessor#lookupOrderForCustomer(Customer)}
   */
  @Test
  public void testLookupOrderForCustomer() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new PageCartRuleProcessor()).lookupOrderForCustomer(null));
  }

  /**
   * Method under test:
   * {@link AbstractCartRuleProcessor#lookupOrderForCustomer(Customer)}
   */
  @Test
  public void testLookupOrderForCustomer2() {
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
   * Method under test:
   * {@link AbstractCartRuleProcessor#checkItemCriteria(ItemCriteriaDTO, List)}
   */
  @Test
  public void testCheckItemCriteria() {
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
   * Method under test:
   * {@link AbstractCartRuleProcessor#checkItemCriteria(ItemCriteriaDTO, List)}
   */
  @Test
  public void testCheckItemCriteria2() {
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
   * Method under test:
   * {@link AbstractCartRuleProcessor#checkItemCriteria(ItemCriteriaDTO, List)}
   */
  @Test
  public void testCheckItemCriteria3() {
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
   * Method under test:
   * {@link AbstractCartRuleProcessor#checkItemCriteria(ItemCriteriaDTO, List)}
   */
  @Test
  public void testCheckItemCriteria4() {
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
   * Method under test:
   * {@link AbstractCartRuleProcessor#checkItemCriteria(ItemCriteriaDTO, List)}
   */
  @Test
  public void testCheckItemCriteria5() {
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
   * Method under test:
   * {@link AbstractCartRuleProcessor#checkItemCriteria(ItemCriteriaDTO, List)}
   */
  @Test
  public void testCheckItemCriteria6() {
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
   * Method under test:
   * {@link AbstractCartRuleProcessor#checkItemCriteria(ItemCriteriaDTO, List)}
   */
  @Test
  public void testCheckItemCriteria7() {
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
   * Method under test:
   * {@link AbstractCartRuleProcessor#checkItemCriteria(ItemCriteriaDTO, List)}
   */
  @Test
  public void testCheckItemCriteria8() {
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
   * Method under test:
   * {@link AbstractCartRuleProcessor#checkItemCriteria(ItemCriteriaDTO, List)}
   */
  @Test
  public void testCheckItemCriteria9() {
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
   * Method under test:
   * {@link AbstractCartRuleProcessor#checkItemCriteria(ItemCriteriaDTO, List)}
   */
  @Test
  public void testCheckItemCriteria10() {
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
   * Method under test:
   * {@link AbstractCartRuleProcessor#checkItemCriteria(ItemCriteriaDTO, List)}
   */
  @Test
  public void testCheckItemCriteria11() {
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
   * Method under test:
   * {@link AbstractCartRuleProcessor#checkItemCriteria(ItemCriteriaDTO, List)}
   */
  @Test
  public void testCheckItemCriteria12() {
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
   * Method under test:
   * {@link AbstractCartRuleProcessor#checkItemCriteria(ItemCriteriaDTO, List)}
   */
  @Test
  public void testCheckItemCriteria13() {
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
   * Method under test:
   * {@link AbstractCartRuleProcessor#checkItemCriteria(ItemCriteriaDTO, List)}
   */
  @Test
  public void testCheckItemCriteria14() {
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
   * Method under test:
   * {@link AbstractCartRuleProcessor#checkItemCriteria(ItemCriteriaDTO, List)}
   */
  @Test
  public void testCheckItemCriteria15() {
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
   * Method under test: {@link AbstractCartRuleProcessor#setOrderDao(OrderDao)}
   */
  @Test
  public void testSetOrderDao() {
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
   * Method under test: {@link AbstractCartRuleProcessor#setOrderDao(OrderDao)}
   */
  @Test
  public void testSetOrderDao2() {
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
   * Method under test: {@link AbstractCartRuleProcessor#getOrderDao()}
   */
  @Test
  public void testGetOrderDao() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new PageCartRuleProcessor()).getOrderDao());
  }

  /**
   * Method under test: {@link AbstractCartRuleProcessor#getOrderDao()}
   */
  @Test
  public void testGetOrderDao2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PageCartRuleProcessor pageCartRuleProcessor = new PageCartRuleProcessor();
    pageCartRuleProcessor.setOrderDao(mock(OrderDaoImpl.class));

    // Act and Assert
    assertSame(pageCartRuleProcessor.orderDao, pageCartRuleProcessor.getOrderDao());
  }
}
