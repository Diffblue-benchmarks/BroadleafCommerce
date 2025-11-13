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
public class ProductFieldServiceImplDiffblueTest {
  /**
   * Test {@link ProductFieldServiceImpl#init()}.
   *
   * <ul>
   *   <li>Then {@link ProductFieldServiceImpl} (default constructor) Fields is {@link
   *       ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link ProductFieldServiceImpl#init()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ProductFieldServiceImpl.init()"})
  public void testInit_thenProductFieldServiceImplFieldsIsArrayList() {
    // Arrange
    ProductFieldServiceImpl productFieldServiceImpl = new ProductFieldServiceImpl();
    ArrayList<FieldData> fields = new ArrayList<>();
    productFieldServiceImpl.setFields(fields);

    // Act
    productFieldServiceImpl.init();

    // Assert
    assertEquals(fields, productFieldServiceImpl.getFields());
  }

  /**
   * Test {@link ProductFieldServiceImpl#init()}.
   *
   * <ul>
   *   <li>Then {@link ProductFieldServiceImpl} (default constructor) Fields size is five.
   * </ul>
   *
   * <p>Method under test: {@link ProductFieldServiceImpl#init()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ProductFieldServiceImpl.init()"})
  public void testInit_thenProductFieldServiceImplFieldsSizeIsFive() {
    // Arrange
    ProductFieldServiceImpl productFieldServiceImpl = new ProductFieldServiceImpl();

    // Act
    productFieldServiceImpl.init();

    // Assert
    assertEquals(5, productFieldServiceImpl.getFields().size());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ProductFieldServiceImpl#getDtoClassName()}
   *   <li>{@link ProductFieldServiceImpl#getName()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String ProductFieldServiceImpl.getDtoClassName()",
    "String ProductFieldServiceImpl.getName()"
  })
  public void testGettersAndSetters() {
    // Arrange
    ProductFieldServiceImpl productFieldServiceImpl = new ProductFieldServiceImpl();

    // Act
    String actualDtoClassName = productFieldServiceImpl.getDtoClassName();

    // Assert
    assertEquals("PRODUCT_FIELDS", productFieldServiceImpl.getName());
    assertEquals("org.broadleafcommerce.core.catalog.domain.ProductImpl", actualDtoClassName);
  }
}
