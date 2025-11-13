package org.broadleafcommerce.core.order.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.broadleafcommerce.common.extension.ExtensionResultStatusType;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.profile.core.domain.Customer;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {AbstractOrderDaoExtensionHandler.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class AbstractOrderDaoExtensionHandlerDiffblueTest {
  @Autowired private AbstractOrderDaoExtensionHandler abstractOrderDaoExtensionHandler;

  /**
   * Test {@link AbstractOrderDaoExtensionHandler#attachAdditionalDataToNewCart(Customer, Order)}.
   *
   * <p>Method under test: {@link
   * AbstractOrderDaoExtensionHandler#attachAdditionalDataToNewCart(Customer, Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType AbstractOrderDaoExtensionHandler.attachAdditionalDataToNewCart(Customer, Order)"
  })
  public void testAttachAdditionalDataToNewCart() {
    // Arrange
    AbstractOrderDaoExtensionHandler abstractOrderDaoExtensionHandler =
        new AbstractOrderDaoExtensionHandler();
    CustomerImpl customer = new CustomerImpl();

    // Act and Assert
    assertEquals(
        ExtensionResultStatusType.NOT_HANDLED,
        abstractOrderDaoExtensionHandler.attachAdditionalDataToNewCart(
            customer, new NullOrderImpl()));
  }

  /**
   * Test {@link AbstractOrderDaoExtensionHandler#processPostSaveNewCart(Customer, Order)}.
   *
   * <p>Method under test: {@link AbstractOrderDaoExtensionHandler#processPostSaveNewCart(Customer,
   * Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType AbstractOrderDaoExtensionHandler.processPostSaveNewCart(Customer, Order)"
  })
  public void testProcessPostSaveNewCart() {
    // Arrange
    AbstractOrderDaoExtensionHandler abstractOrderDaoExtensionHandler =
        new AbstractOrderDaoExtensionHandler();
    CustomerImpl customer = new CustomerImpl();

    // Act and Assert
    assertEquals(
        ExtensionResultStatusType.NOT_HANDLED,
        abstractOrderDaoExtensionHandler.processPostSaveNewCart(customer, new NullOrderImpl()));
  }

  /**
   * Test {@link AbstractOrderDaoExtensionHandler#applyAdditionalOrderLookupFilter(Customer, String,
   * List)}.
   *
   * <ul>
   *   <li>Given {@link NullOrderImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * AbstractOrderDaoExtensionHandler#applyAdditionalOrderLookupFilter(Customer, String, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType AbstractOrderDaoExtensionHandler.applyAdditionalOrderLookupFilter(Customer, String, List)"
  })
  public void testApplyAdditionalOrderLookupFilter_givenNullOrderImpl() {
    // Arrange
    CustomerImpl customer = new CustomerImpl();

    ArrayList<Order> orders = new ArrayList<>();
    orders.add(new NullOrderImpl());

    // Act and Assert
    assertEquals(
        ExtensionResultStatusType.NOT_HANDLED,
        abstractOrderDaoExtensionHandler.applyAdditionalOrderLookupFilter(
            customer, "Name", orders));
  }

  /**
   * Test {@link AbstractOrderDaoExtensionHandler#applyAdditionalOrderLookupFilter(Customer, String,
   * List)}.
   *
   * <ul>
   *   <li>Given {@link NullOrderImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * AbstractOrderDaoExtensionHandler#applyAdditionalOrderLookupFilter(Customer, String, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType AbstractOrderDaoExtensionHandler.applyAdditionalOrderLookupFilter(Customer, String, List)"
  })
  public void testApplyAdditionalOrderLookupFilter_givenNullOrderImpl2() {
    // Arrange
    CustomerImpl customer = new CustomerImpl();

    ArrayList<Order> orders = new ArrayList<>();
    orders.add(new NullOrderImpl());
    orders.add(new NullOrderImpl());

    // Act and Assert
    assertEquals(
        ExtensionResultStatusType.NOT_HANDLED,
        abstractOrderDaoExtensionHandler.applyAdditionalOrderLookupFilter(
            customer, "Name", orders));
  }

  /**
   * Test {@link AbstractOrderDaoExtensionHandler#applyAdditionalOrderLookupFilter(Customer, String,
   * List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AbstractOrderDaoExtensionHandler#applyAdditionalOrderLookupFilter(Customer, String, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType AbstractOrderDaoExtensionHandler.applyAdditionalOrderLookupFilter(Customer, String, List)"
  })
  public void testApplyAdditionalOrderLookupFilter_whenArrayList() {
    // Arrange
    CustomerImpl customer = new CustomerImpl();

    // Act and Assert
    assertEquals(
        ExtensionResultStatusType.NOT_HANDLED,
        abstractOrderDaoExtensionHandler.applyAdditionalOrderLookupFilter(
            customer, "Name", new ArrayList<>()));
  }

  /**
   * Test new {@link AbstractOrderDaoExtensionHandler} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link
   * AbstractOrderDaoExtensionHandler}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractOrderDaoExtensionHandler.<init>()"})
  public void testNewAbstractOrderDaoExtensionHandler() {
    // Arrange and Act
    AbstractOrderDaoExtensionHandler actualAbstractOrderDaoExtensionHandler =
        new AbstractOrderDaoExtensionHandler();

    // Assert
    assertEquals(0, actualAbstractOrderDaoExtensionHandler.getPriority());
    assertTrue(actualAbstractOrderDaoExtensionHandler.isEnabled());
  }
}
