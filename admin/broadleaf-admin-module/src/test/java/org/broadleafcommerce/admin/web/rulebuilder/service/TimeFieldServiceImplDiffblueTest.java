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
public class TimeFieldServiceImplDiffblueTest {
  /**
   * Test {@link TimeFieldServiceImpl#init()}.
   *
   * <ul>
   *   <li>Given {@link TimeFieldServiceImpl} (default constructor).
   *   <li>Then {@link TimeFieldServiceImpl} (default constructor) Fields size is six.
   * </ul>
   *
   * <p>Method under test: {@link TimeFieldServiceImpl#init()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TimeFieldServiceImpl.init()"})
  public void testInit_givenTimeFieldServiceImpl_thenTimeFieldServiceImplFieldsSizeIsSix() {
    // Arrange
    TimeFieldServiceImpl timeFieldServiceImpl = new TimeFieldServiceImpl();

    // Act
    timeFieldServiceImpl.init();

    // Assert
    assertEquals(6, timeFieldServiceImpl.getFields().size());
  }

  /**
   * Test {@link TimeFieldServiceImpl#init()}.
   *
   * <ul>
   *   <li>Then {@link TimeFieldServiceImpl} (default constructor) Fields is {@link
   *       ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link TimeFieldServiceImpl#init()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TimeFieldServiceImpl.init()"})
  public void testInit_thenTimeFieldServiceImplFieldsIsArrayList() {
    // Arrange
    TimeFieldServiceImpl timeFieldServiceImpl = new TimeFieldServiceImpl();
    ArrayList<FieldData> fields = new ArrayList<>();
    timeFieldServiceImpl.setFields(fields);

    // Act
    timeFieldServiceImpl.init();

    // Assert
    assertEquals(fields, timeFieldServiceImpl.getFields());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TimeFieldServiceImpl#getDtoClassName()}
   *   <li>{@link TimeFieldServiceImpl#getName()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String TimeFieldServiceImpl.getDtoClassName()",
    "String TimeFieldServiceImpl.getName()"
  })
  public void testGettersAndSetters() {
    // Arrange
    TimeFieldServiceImpl timeFieldServiceImpl = new TimeFieldServiceImpl();

    // Act
    String actualDtoClassName = timeFieldServiceImpl.getDtoClassName();

    // Assert
    assertEquals("TIME_FIELDS", timeFieldServiceImpl.getName());
    assertEquals("org.broadleafcommerce.common.TimeDTO", actualDtoClassName);
  }
}
