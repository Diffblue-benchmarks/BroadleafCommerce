/*-
 * #%L
 * BroadleafCommerce Open Admin Platform
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
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class RuleBuilderFieldServiceFactoryImplDiffblueTest {
  @Mock private List<RuleBuilderFieldService> list;

  @InjectMocks private RuleBuilderFieldServiceFactoryImpl ruleBuilderFieldServiceFactoryImpl;

  /**
   * Test {@link RuleBuilderFieldServiceFactoryImpl#createInstance(String)}.
   *
   * <ul>
   *   <li>Given {@link List} {@link List#iterator()} return {@link ArrayList#ArrayList()} iterator.
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
  public void testCreateInstance_givenListIteratorReturnArrayListIterator_thenReturnNull() {
    // Arrange
    ArrayList<RuleBuilderFieldService> ruleBuilderFieldServiceList = new ArrayList<>();
    when(list.iterator()).thenReturn(ruleBuilderFieldServiceList.iterator());

    // Act
    RuleBuilderFieldService actualCreateInstanceResult =
        ruleBuilderFieldServiceFactoryImpl.createInstance("Name");

    // Assert
    verify(list).iterator();
    assertNull(actualCreateInstanceResult);
  }

  /**
   * Test {@link RuleBuilderFieldServiceFactoryImpl#createInstance(String)}.
   *
   * <ul>
   *   <li>Given {@link RuleBuilderFieldService} {@link RuleBuilderFieldService#getName()} return
   *       {@code foo}.
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
  public void testCreateInstance_givenRuleBuilderFieldServiceGetNameReturnFoo_thenReturnNull() {
    // Arrange
    RuleBuilderFieldService ruleBuilderFieldService = mock(RuleBuilderFieldService.class);
    when(ruleBuilderFieldService.getName()).thenReturn("Name");

    RuleBuilderFieldService ruleBuilderFieldService2 = mock(RuleBuilderFieldService.class);
    when(ruleBuilderFieldService2.getName()).thenReturn("foo");

    ArrayList<RuleBuilderFieldService> ruleBuilderFieldServiceList = new ArrayList<>();
    ruleBuilderFieldServiceList.add(ruleBuilderFieldService2);
    ruleBuilderFieldServiceList.add(ruleBuilderFieldService);
    ruleBuilderFieldServiceList.add(mock(RuleBuilderFieldService.class));
    ruleBuilderFieldServiceList.add(mock(RuleBuilderFieldService.class));
    ruleBuilderFieldServiceList.add(mock(RuleBuilderFieldService.class));
    ruleBuilderFieldServiceList.add(mock(RuleBuilderFieldService.class));
    ruleBuilderFieldServiceList.add(mock(RuleBuilderFieldService.class));
    ruleBuilderFieldServiceList.add(mock(RuleBuilderFieldService.class));
    ruleBuilderFieldServiceList.add(mock(RuleBuilderFieldService.class));
    ruleBuilderFieldServiceList.add(mock(RuleBuilderFieldService.class));
    ruleBuilderFieldServiceList.add(mock(RuleBuilderFieldService.class));
    ruleBuilderFieldServiceList.add(mock(RuleBuilderFieldService.class));
    ruleBuilderFieldServiceList.add(mock(RuleBuilderFieldService.class));
    ruleBuilderFieldServiceList.add(mock(RuleBuilderFieldService.class));
    ruleBuilderFieldServiceList.add(mock(RuleBuilderFieldService.class));
    ruleBuilderFieldServiceList.add(mock(RuleBuilderFieldService.class));
    ruleBuilderFieldServiceList.add(mock(RuleBuilderFieldService.class));
    ruleBuilderFieldServiceList.add(mock(RuleBuilderFieldService.class));
    ruleBuilderFieldServiceList.add(mock(RuleBuilderFieldService.class));
    ruleBuilderFieldServiceList.add(mock(RuleBuilderFieldService.class));
    ruleBuilderFieldServiceList.add(mock(RuleBuilderFieldService.class));
    ruleBuilderFieldServiceList.add(mock(RuleBuilderFieldService.class));
    ruleBuilderFieldServiceList.add(mock(RuleBuilderFieldService.class));
    ruleBuilderFieldServiceList.add(mock(RuleBuilderFieldService.class));
    ruleBuilderFieldServiceList.add(mock(RuleBuilderFieldService.class));
    ruleBuilderFieldServiceList.add(mock(RuleBuilderFieldService.class));
    ruleBuilderFieldServiceList.add(mock(RuleBuilderFieldService.class));
    ruleBuilderFieldServiceList.add(mock(RuleBuilderFieldService.class));
    ruleBuilderFieldServiceList.add(mock(RuleBuilderFieldService.class));
    ruleBuilderFieldServiceList.add(mock(RuleBuilderFieldService.class));
    ruleBuilderFieldServiceList.add(mock(RuleBuilderFieldService.class));
    ruleBuilderFieldServiceList.add(mock(RuleBuilderFieldService.class));
    ruleBuilderFieldServiceList.add(mock(RuleBuilderFieldService.class));
    ruleBuilderFieldServiceList.add(mock(RuleBuilderFieldService.class));
    ruleBuilderFieldServiceList.add(mock(RuleBuilderFieldService.class));
    ruleBuilderFieldServiceList.add(mock(RuleBuilderFieldService.class));
    ruleBuilderFieldServiceList.add(mock(RuleBuilderFieldService.class));
    ruleBuilderFieldServiceList.add(mock(RuleBuilderFieldService.class));
    ruleBuilderFieldServiceList.add(mock(RuleBuilderFieldService.class));
    ruleBuilderFieldServiceList.add(mock(RuleBuilderFieldService.class));
    ruleBuilderFieldServiceList.add(mock(RuleBuilderFieldService.class));
    ruleBuilderFieldServiceList.add(mock(RuleBuilderFieldService.class));
    ruleBuilderFieldServiceList.add(mock(RuleBuilderFieldService.class));
    ruleBuilderFieldServiceList.add(mock(RuleBuilderFieldService.class));
    ruleBuilderFieldServiceList.add(mock(RuleBuilderFieldService.class));
    ruleBuilderFieldServiceList.add(mock(RuleBuilderFieldService.class));
    ruleBuilderFieldServiceList.add(mock(RuleBuilderFieldService.class));
    ruleBuilderFieldServiceList.add(mock(RuleBuilderFieldService.class));
    ruleBuilderFieldServiceList.add(mock(RuleBuilderFieldService.class));
    ruleBuilderFieldServiceList.add(mock(RuleBuilderFieldService.class));
    ruleBuilderFieldServiceList.add(mock(RuleBuilderFieldService.class));
    ruleBuilderFieldServiceList.add(mock(RuleBuilderFieldService.class));
    ruleBuilderFieldServiceList.add(mock(RuleBuilderFieldService.class));
    ruleBuilderFieldServiceList.add(mock(RuleBuilderFieldService.class));
    ruleBuilderFieldServiceList.add(mock(RuleBuilderFieldService.class));
    ruleBuilderFieldServiceList.add(mock(RuleBuilderFieldService.class));
    ruleBuilderFieldServiceList.add(mock(RuleBuilderFieldService.class));
    ruleBuilderFieldServiceList.add(mock(RuleBuilderFieldService.class));
    ruleBuilderFieldServiceList.add(mock(RuleBuilderFieldService.class));
    ruleBuilderFieldServiceList.add(mock(RuleBuilderFieldService.class));
    ruleBuilderFieldServiceList.add(mock(RuleBuilderFieldService.class));
    ruleBuilderFieldServiceList.add(mock(RuleBuilderFieldService.class));
    ruleBuilderFieldServiceList.add(mock(RuleBuilderFieldService.class));
    ruleBuilderFieldServiceList.add(mock(RuleBuilderFieldService.class));
    ruleBuilderFieldServiceList.add(mock(RuleBuilderFieldService.class));
    ruleBuilderFieldServiceList.add(mock(RuleBuilderFieldService.class));
    ruleBuilderFieldServiceList.add(mock(RuleBuilderFieldService.class));
    ruleBuilderFieldServiceList.add(mock(RuleBuilderFieldService.class));
    ruleBuilderFieldServiceList.add(mock(RuleBuilderFieldService.class));
    ruleBuilderFieldServiceList.add(mock(RuleBuilderFieldService.class));
    ruleBuilderFieldServiceList.add(mock(RuleBuilderFieldService.class));
    ruleBuilderFieldServiceList.add(mock(RuleBuilderFieldService.class));
    ruleBuilderFieldServiceList.add(mock(RuleBuilderFieldService.class));
    ruleBuilderFieldServiceList.add(mock(RuleBuilderFieldService.class));
    ruleBuilderFieldServiceList.add(mock(RuleBuilderFieldService.class));
    ruleBuilderFieldServiceList.add(mock(RuleBuilderFieldService.class));
    ruleBuilderFieldServiceList.add(mock(RuleBuilderFieldService.class));
    ruleBuilderFieldServiceList.add(mock(RuleBuilderFieldService.class));
    ruleBuilderFieldServiceList.add(mock(RuleBuilderFieldService.class));
    ruleBuilderFieldServiceList.add(mock(RuleBuilderFieldService.class));
    ruleBuilderFieldServiceList.add(mock(RuleBuilderFieldService.class));
    ruleBuilderFieldServiceList.add(mock(RuleBuilderFieldService.class));
    ruleBuilderFieldServiceList.add(mock(RuleBuilderFieldService.class));
    ruleBuilderFieldServiceList.add(mock(RuleBuilderFieldService.class));
    ruleBuilderFieldServiceList.add(mock(RuleBuilderFieldService.class));
    ruleBuilderFieldServiceList.add(mock(RuleBuilderFieldService.class));
    ruleBuilderFieldServiceList.add(mock(RuleBuilderFieldService.class));
    ruleBuilderFieldServiceList.add(mock(RuleBuilderFieldService.class));
    ruleBuilderFieldServiceList.add(mock(RuleBuilderFieldService.class));
    ruleBuilderFieldServiceList.add(mock(RuleBuilderFieldService.class));
    ruleBuilderFieldServiceList.add(mock(RuleBuilderFieldService.class));
    ruleBuilderFieldServiceList.add(mock(RuleBuilderFieldService.class));
    ruleBuilderFieldServiceList.add(mock(RuleBuilderFieldService.class));
    ruleBuilderFieldServiceList.add(mock(RuleBuilderFieldService.class));
    ruleBuilderFieldServiceList.add(mock(RuleBuilderFieldService.class));
    ruleBuilderFieldServiceList.add(mock(RuleBuilderFieldService.class));
    ruleBuilderFieldServiceList.add(mock(RuleBuilderFieldService.class));
    ruleBuilderFieldServiceList.add(mock(RuleBuilderFieldService.class));
    when(list.iterator()).thenReturn(ruleBuilderFieldServiceList.iterator());

    // Act
    RuleBuilderFieldService actualCreateInstanceResult =
        ruleBuilderFieldServiceFactoryImpl.createInstance("Name");

    // Assert
    verify(list).iterator();
    verify(ruleBuilderFieldService2).getName();
    verify(ruleBuilderFieldService).getName();
    assertNull(actualCreateInstanceResult);
  }

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

    ArrayList<RuleBuilderFieldService> ruleBuilderFieldServiceList = new ArrayList<>();
    ruleBuilderFieldServiceList.add(ruleBuilderFieldService);
    when(list.iterator()).thenReturn(ruleBuilderFieldServiceList.iterator());

    // Act
    RuleBuilderFieldService actualCreateInstanceResult =
        ruleBuilderFieldServiceFactoryImpl.createInstance("Name");

    // Assert
    verify(list).iterator();
    verify(ruleBuilderFieldService).getName();
    assertNull(actualCreateInstanceResult);
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

    ArrayList<RuleBuilderFieldService> ruleBuilderFieldServiceList = new ArrayList<>();
    ruleBuilderFieldServiceList.add(ruleBuilderFieldService);
    when(list.iterator()).thenReturn(ruleBuilderFieldServiceList.iterator());

    // Act and Assert
    assertThrows(
        RuntimeException.class, () -> ruleBuilderFieldServiceFactoryImpl.createInstance("Name"));
    verify(list).iterator();
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
