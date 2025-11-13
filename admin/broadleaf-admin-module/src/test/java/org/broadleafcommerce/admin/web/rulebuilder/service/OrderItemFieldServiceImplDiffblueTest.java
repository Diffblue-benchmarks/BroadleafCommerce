package org.broadleafcommerce.admin.web.rulebuilder.service;

import static org.junit.Assert.assertEquals;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import org.broadleafcommerce.openadmin.web.rulebuilder.dto.FieldData;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;

@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class OrderItemFieldServiceImplDiffblueTest {
  /**
   * Test {@link OrderItemFieldServiceImpl#init()}.
   *
   * <ul>
   *   <li>Then {@link OrderItemFieldServiceImpl} (default constructor) Fields is {@link
   *       ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemFieldServiceImpl#init()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void OrderItemFieldServiceImpl.init()"})
  public void testInit_thenOrderItemFieldServiceImplFieldsIsArrayList() {
    // Arrange
    OrderItemFieldServiceImpl orderItemFieldServiceImpl = new OrderItemFieldServiceImpl();
    ArrayList<FieldData> fields = new ArrayList<>();
    orderItemFieldServiceImpl.setFields(fields);

    // Act
    orderItemFieldServiceImpl.init();

    // Assert
    assertEquals(fields, orderItemFieldServiceImpl.getFields());
  }

  /**
   * Test {@link OrderItemFieldServiceImpl#init()}.
   *
   * <ul>
   *   <li>Then {@link OrderItemFieldServiceImpl} (default constructor) Fields size is seven.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemFieldServiceImpl#init()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void OrderItemFieldServiceImpl.init()"})
  public void testInit_thenOrderItemFieldServiceImplFieldsSizeIsSeven() {
    // Arrange
    OrderItemFieldServiceImpl orderItemFieldServiceImpl = new OrderItemFieldServiceImpl();

    // Act
    orderItemFieldServiceImpl.init();

    // Assert
    assertEquals(7, orderItemFieldServiceImpl.getFields().size());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OrderItemFieldServiceImpl#getDtoClassName()}
   *   <li>{@link OrderItemFieldServiceImpl#getName()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String OrderItemFieldServiceImpl.getDtoClassName()",
    "String OrderItemFieldServiceImpl.getName()"
  })
  public void testGettersAndSetters() {
    // Arrange
    OrderItemFieldServiceImpl orderItemFieldServiceImpl = new OrderItemFieldServiceImpl();

    // Act
    String actualDtoClassName = orderItemFieldServiceImpl.getDtoClassName();

    // Assert
    assertEquals("ORDER_ITEM_FIELDS", orderItemFieldServiceImpl.getName());
    assertEquals("org.broadleafcommerce.core.order.domain.OrderItemImpl", actualDtoClassName);
  }
}
