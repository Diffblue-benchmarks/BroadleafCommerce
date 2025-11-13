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
public class RequestFieldServiceImplDiffblueTest {
  /**
   * Test {@link RequestFieldServiceImpl#init()}.
   *
   * <ul>
   *   <li>Then {@link RequestFieldServiceImpl} (default constructor) Fields is {@link
   *       ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link RequestFieldServiceImpl#init()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void RequestFieldServiceImpl.init()"})
  public void testInit_thenRequestFieldServiceImplFieldsIsArrayList() {
    // Arrange
    RequestFieldServiceImpl requestFieldServiceImpl = new RequestFieldServiceImpl();
    ArrayList<FieldData> fields = new ArrayList<>();
    requestFieldServiceImpl.setFields(fields);

    // Act
    requestFieldServiceImpl.init();

    // Assert
    assertEquals(fields, requestFieldServiceImpl.getFields());
  }

  /**
   * Test {@link RequestFieldServiceImpl#init()}.
   *
   * <ul>
   *   <li>Then {@link RequestFieldServiceImpl} (default constructor) Fields size is five.
   * </ul>
   *
   * <p>Method under test: {@link RequestFieldServiceImpl#init()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void RequestFieldServiceImpl.init()"})
  public void testInit_thenRequestFieldServiceImplFieldsSizeIsFive() {
    // Arrange
    RequestFieldServiceImpl requestFieldServiceImpl = new RequestFieldServiceImpl();

    // Act
    requestFieldServiceImpl.init();

    // Assert
    assertEquals(5, requestFieldServiceImpl.getFields().size());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RequestFieldServiceImpl#getDtoClassName()}
   *   <li>{@link RequestFieldServiceImpl#getName()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String RequestFieldServiceImpl.getDtoClassName()",
    "String RequestFieldServiceImpl.getName()"
  })
  public void testGettersAndSetters() {
    // Arrange
    RequestFieldServiceImpl requestFieldServiceImpl = new RequestFieldServiceImpl();

    // Act
    String actualDtoClassName = requestFieldServiceImpl.getDtoClassName();

    // Assert
    assertEquals("REQUEST_FIELDS", requestFieldServiceImpl.getName());
    assertEquals("org.broadleafcommerce.common.RequestDTOImpl", actualDtoClassName);
  }
}
