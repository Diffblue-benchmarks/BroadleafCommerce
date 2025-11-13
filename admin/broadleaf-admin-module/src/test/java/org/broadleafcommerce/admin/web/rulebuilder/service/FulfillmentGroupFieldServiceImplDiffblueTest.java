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
public class FulfillmentGroupFieldServiceImplDiffblueTest {
  /**
   * Test {@link FulfillmentGroupFieldServiceImpl#init()}.
   *
   * <ul>
   *   <li>Then {@link FulfillmentGroupFieldServiceImpl} (default constructor) Fields is {@link
   *       ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupFieldServiceImpl#init()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void FulfillmentGroupFieldServiceImpl.init()"})
  public void testInit_thenFulfillmentGroupFieldServiceImplFieldsIsArrayList() {
    // Arrange
    FulfillmentGroupFieldServiceImpl fulfillmentGroupFieldServiceImpl =
        new FulfillmentGroupFieldServiceImpl();
    ArrayList<FieldData> fields = new ArrayList<>();
    fulfillmentGroupFieldServiceImpl.setFields(fields);

    // Act
    fulfillmentGroupFieldServiceImpl.init();

    // Assert
    assertEquals(fields, fulfillmentGroupFieldServiceImpl.getFields());
  }

  /**
   * Test {@link FulfillmentGroupFieldServiceImpl#init()}.
   *
   * <ul>
   *   <li>Then {@link FulfillmentGroupFieldServiceImpl} (default constructor) Fields size is
   *       nineteen.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupFieldServiceImpl#init()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void FulfillmentGroupFieldServiceImpl.init()"})
  public void testInit_thenFulfillmentGroupFieldServiceImplFieldsSizeIsNineteen() {
    // Arrange
    FulfillmentGroupFieldServiceImpl fulfillmentGroupFieldServiceImpl =
        new FulfillmentGroupFieldServiceImpl();

    // Act
    fulfillmentGroupFieldServiceImpl.init();

    // Assert
    assertEquals(19, fulfillmentGroupFieldServiceImpl.getFields().size());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link FulfillmentGroupFieldServiceImpl#getDtoClassName()}
   *   <li>{@link FulfillmentGroupFieldServiceImpl#getName()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String FulfillmentGroupFieldServiceImpl.getDtoClassName()",
    "String FulfillmentGroupFieldServiceImpl.getName()"
  })
  public void testGettersAndSetters() {
    // Arrange
    FulfillmentGroupFieldServiceImpl fulfillmentGroupFieldServiceImpl =
        new FulfillmentGroupFieldServiceImpl();

    // Act
    String actualDtoClassName = fulfillmentGroupFieldServiceImpl.getDtoClassName();

    // Assert
    assertEquals("FULFILLMENT_GROUP_FIELDS", fulfillmentGroupFieldServiceImpl.getName());
    assertEquals(
        "org.broadleafcommerce.core.order.domain.FulfillmentGroupImpl", actualDtoClassName);
  }
}
