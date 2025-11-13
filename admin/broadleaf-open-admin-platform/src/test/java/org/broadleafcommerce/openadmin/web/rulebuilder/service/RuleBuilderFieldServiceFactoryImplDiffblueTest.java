package org.broadleafcommerce.openadmin.web.rulebuilder.service;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;

@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class RuleBuilderFieldServiceFactoryImplDiffblueTest {
  /**
   * Test {@link RuleBuilderFieldServiceFactoryImpl#createInstance(String)}.
   *
   * <ul>
   *   <li>Given {@link RuleBuilderFieldService} {@link RuleBuilderFieldService#getName()} return
   *       {@code Name}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link RuleBuilderFieldServiceFactoryImpl#createInstance(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "RuleBuilderFieldService RuleBuilderFieldServiceFactoryImpl.createInstance(String)"
  })
  public void testCreateInstance_givenRuleBuilderFieldServiceGetNameReturnName_thenReturnNull() {
    // Arrange
    RuleBuilderFieldService ruleBuilderFieldService = mock(RuleBuilderFieldService.class);
    when(ruleBuilderFieldService.getName()).thenReturn("Name");

    ArrayList<RuleBuilderFieldService> fieldServices = new ArrayList<>();
    fieldServices.add(ruleBuilderFieldService);

    RuleBuilderFieldServiceFactoryImpl ruleBuilderFieldServiceFactoryImpl =
        new RuleBuilderFieldServiceFactoryImpl();
    ruleBuilderFieldServiceFactoryImpl.setFieldServices(fieldServices);

    // Act
    RuleBuilderFieldService actualCreateInstanceResult =
        ruleBuilderFieldServiceFactoryImpl.createInstance("Name");

    // Assert
    verify(ruleBuilderFieldService).getName();
    assertNull(actualCreateInstanceResult);
  }

  /**
   * Test {@link RuleBuilderFieldServiceFactoryImpl#createInstance(String)}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link RuleBuilderFieldServiceFactoryImpl#createInstance(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "RuleBuilderFieldService RuleBuilderFieldServiceFactoryImpl.createInstance(String)"
  })
  public void testCreateInstance_thenReturnNull() {
    // Arrange
    RuleBuilderFieldServiceFactoryImpl ruleBuilderFieldServiceFactoryImpl =
        new RuleBuilderFieldServiceFactoryImpl();
    ruleBuilderFieldServiceFactoryImpl.setFieldServices(new ArrayList<>());

    // Act and Assert
    assertNull(ruleBuilderFieldServiceFactoryImpl.createInstance("Name"));
  }

  /**
   * Test {@link RuleBuilderFieldServiceFactoryImpl#createInstance(String)}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link RuleBuilderFieldServiceFactoryImpl#createInstance(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "RuleBuilderFieldService RuleBuilderFieldServiceFactoryImpl.createInstance(String)"
  })
  public void testCreateInstance_thenThrowRuntimeException() {
    // Arrange
    RuleBuilderFieldService ruleBuilderFieldService = mock(RuleBuilderFieldService.class);
    when(ruleBuilderFieldService.getName()).thenThrow(new RuntimeException());

    ArrayList<RuleBuilderFieldService> fieldServices = new ArrayList<>();
    fieldServices.add(ruleBuilderFieldService);

    RuleBuilderFieldServiceFactoryImpl ruleBuilderFieldServiceFactoryImpl =
        new RuleBuilderFieldServiceFactoryImpl();
    ruleBuilderFieldServiceFactoryImpl.setFieldServices(fieldServices);

    // Act and Assert
    assertThrows(
        RuntimeException.class, () -> ruleBuilderFieldServiceFactoryImpl.createInstance("Name"));
    verify(ruleBuilderFieldService).getName();
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RuleBuilderFieldServiceFactoryImpl#setFieldServices(List)}
   *   <li>{@link RuleBuilderFieldServiceFactoryImpl#getFieldServices()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List RuleBuilderFieldServiceFactoryImpl.getFieldServices()",
    "void RuleBuilderFieldServiceFactoryImpl.setFieldServices(List)"
  })
  public void testGettersAndSetters() {
    // Arrange
    RuleBuilderFieldServiceFactoryImpl ruleBuilderFieldServiceFactoryImpl =
        new RuleBuilderFieldServiceFactoryImpl();
    ArrayList<RuleBuilderFieldService> fieldServices = new ArrayList<>();

    // Act
    ruleBuilderFieldServiceFactoryImpl.setFieldServices(fieldServices);
    List<RuleBuilderFieldService> actualFieldServices =
        ruleBuilderFieldServiceFactoryImpl.getFieldServices();

    // Assert
    assertTrue(actualFieldServices.isEmpty());
    assertSame(fieldServices, actualFieldServices);
  }
}
