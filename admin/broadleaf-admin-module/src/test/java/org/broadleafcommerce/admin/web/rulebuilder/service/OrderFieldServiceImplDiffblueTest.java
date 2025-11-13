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
public class OrderFieldServiceImplDiffblueTest {
  /**
   * Test {@link OrderFieldServiceImpl#init()}.
   *
   * <ul>
   *   <li>Given {@link OrderFieldServiceImpl} (default constructor).
   *   <li>Then {@link OrderFieldServiceImpl} (default constructor) Fields size is three.
   * </ul>
   *
   * <p>Method under test: {@link OrderFieldServiceImpl#init()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void OrderFieldServiceImpl.init()"})
  public void testInit_givenOrderFieldServiceImpl_thenOrderFieldServiceImplFieldsSizeIsThree() {
    // Arrange
    OrderFieldServiceImpl orderFieldServiceImpl = new OrderFieldServiceImpl();

    // Act
    orderFieldServiceImpl.init();

    // Assert
    assertEquals(3, orderFieldServiceImpl.getFields().size());
  }

  /**
   * Test {@link OrderFieldServiceImpl#init()}.
   *
   * <ul>
   *   <li>Then {@link OrderFieldServiceImpl} (default constructor) Fields is {@link
   *       ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link OrderFieldServiceImpl#init()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void OrderFieldServiceImpl.init()"})
  public void testInit_thenOrderFieldServiceImplFieldsIsArrayList() {
    // Arrange
    OrderFieldServiceImpl orderFieldServiceImpl = new OrderFieldServiceImpl();
    ArrayList<FieldData> fields = new ArrayList<>();
    orderFieldServiceImpl.setFields(fields);

    // Act
    orderFieldServiceImpl.init();

    // Assert
    assertEquals(fields, orderFieldServiceImpl.getFields());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OrderFieldServiceImpl#getDtoClassName()}
   *   <li>{@link OrderFieldServiceImpl#getName()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String OrderFieldServiceImpl.getDtoClassName()",
    "String OrderFieldServiceImpl.getName()"
  })
  public void testGettersAndSetters() {
    // Arrange
    OrderFieldServiceImpl orderFieldServiceImpl = new OrderFieldServiceImpl();

    // Act
    String actualDtoClassName = orderFieldServiceImpl.getDtoClassName();

    // Assert
    assertEquals("ORDER_FIELDS", orderFieldServiceImpl.getName());
    assertEquals("org.broadleafcommerce.core.order.domain.OrderImpl", actualDtoClassName);
  }
}
