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
public class CustomerFieldServiceImplDiffblueTest {
  /**
   * Test {@link CustomerFieldServiceImpl#init()}.
   *
   * <ul>
   *   <li>Then {@link CustomerFieldServiceImpl} (default constructor) Fields is {@link
   *       ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link CustomerFieldServiceImpl#init()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CustomerFieldServiceImpl.init()"})
  public void testInit_thenCustomerFieldServiceImplFieldsIsArrayList() {
    // Arrange
    CustomerFieldServiceImpl customerFieldServiceImpl = new CustomerFieldServiceImpl();
    ArrayList<FieldData> fields = new ArrayList<>();
    customerFieldServiceImpl.setFields(fields);

    // Act
    customerFieldServiceImpl.init();

    // Assert
    assertEquals(fields, customerFieldServiceImpl.getFields());
  }

  /**
   * Test {@link CustomerFieldServiceImpl#init()}.
   *
   * <ul>
   *   <li>Then {@link CustomerFieldServiceImpl} (default constructor) Fields size is eight.
   * </ul>
   *
   * <p>Method under test: {@link CustomerFieldServiceImpl#init()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CustomerFieldServiceImpl.init()"})
  public void testInit_thenCustomerFieldServiceImplFieldsSizeIsEight() {
    // Arrange
    CustomerFieldServiceImpl customerFieldServiceImpl = new CustomerFieldServiceImpl();

    // Act
    customerFieldServiceImpl.init();

    // Assert
    assertEquals(8, customerFieldServiceImpl.getFields().size());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CustomerFieldServiceImpl#getDtoClassName()}
   *   <li>{@link CustomerFieldServiceImpl#getName()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String CustomerFieldServiceImpl.getDtoClassName()",
    "String CustomerFieldServiceImpl.getName()"
  })
  public void testGettersAndSetters() {
    // Arrange
    CustomerFieldServiceImpl customerFieldServiceImpl = new CustomerFieldServiceImpl();

    // Act
    String actualDtoClassName = customerFieldServiceImpl.getDtoClassName();

    // Assert
    assertEquals("CUSTOMER_FIELDS", customerFieldServiceImpl.getName());
    assertEquals("org.broadleafcommerce.profile.core.domain.CustomerImpl", actualDtoClassName);
  }
}
