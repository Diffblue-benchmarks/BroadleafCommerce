/*-
 * #%L
 * BroadleafCommerce Common Libraries
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
package org.broadleafcommerce.common.persistence;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.Set;
import org.broadleafcommerce.common.resource.GeneratedResource;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.BeansException;
import org.springframework.boot.web.reactive.context.AnnotationConfigReactiveWebApplicationContext;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;

@RunWith(MockitoJUnitRunner.class)
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class EntityConfigurationDiffblueTest {
  @InjectMocks
  private EntityConfiguration entityConfiguration;

  @Mock
  private Set<String> set;

  /**
   * Test {@link EntityConfiguration#configureMergedItems()}.
   * <ul>
   *   <li>Given {@link Set} {@link Set#isEmpty()} return {@code false}.</li>
   *   <li>Then calls {@link Set#iterator()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityConfiguration#configureMergedItems()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void EntityConfiguration.configureMergedItems()"})
  public void testConfigureMergedItems_givenSetIsEmptyReturnFalse_thenCallsIterator() {
    // Arrange
    when(set.isEmpty()).thenReturn(false);

    ArrayList<String> stringList = new ArrayList<>();
    when(set.iterator()).thenReturn(stringList.iterator());

    // Act
    entityConfiguration.configureMergedItems();

    // Assert
    verify(set).isEmpty();
    verify(set).iterator();
    assertEquals(0, entityConfiguration.getEntityBeanNames().length);
    assertEquals(0, entityConfiguration.getEntityContexts().length);
  }

  /**
   * Test {@link EntityConfiguration#configureMergedItems()}.
   * <ul>
   *   <li>Given {@link Set} {@link Set#isEmpty()} return {@code true}.</li>
   *   <li>Then array length is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityConfiguration#configureMergedItems()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void EntityConfiguration.configureMergedItems()"})
  public void testConfigureMergedItems_givenSetIsEmptyReturnTrue_thenArrayLengthIsZero() {
    // Arrange
    when(set.isEmpty()).thenReturn(true);

    // Act
    entityConfiguration.configureMergedItems();

    // Assert
    verify(set).isEmpty();
    assertEquals(0, entityConfiguration.getEntityBeanNames().length);
    assertEquals(0, entityConfiguration.getEntityContexts().length);
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EntityConfiguration#setApplicationContext(ApplicationContext)}
   *   <li>{@link EntityConfiguration#setEntityContexts(Resource[])}
   *   <li>{@link EntityConfiguration#getEntityContexts()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Resource[] EntityConfiguration.getEntityContexts()",
      "void EntityConfiguration.setApplicationContext(ApplicationContext)",
      "void EntityConfiguration.setEntityContexts(Resource[])"})
  public void testGettersAndSetters() throws BeansException {
    // Arrange
    EntityConfiguration entityConfiguration = new EntityConfiguration();

    // Act
    entityConfiguration.setApplicationContext(new AnnotationConfigReactiveWebApplicationContext());
    Resource[] entityContexts = new Resource[]{new GeneratedResource()};
    entityConfiguration.setEntityContexts(entityContexts);

    // Assert
    assertSame(entityContexts, entityConfiguration.getEntityContexts());
  }
}
