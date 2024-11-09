/*-
 * #%L
 * BroadleafCommerce Open Admin Platform
 * %%
 * Copyright (C) 2009 - 2024 Broadleaf Commerce
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
package org.broadleafcommerce.openadmin.server.service.persistence.validation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.broadleafcommerce.openadmin.dto.Entity;
import org.broadleafcommerce.openadmin.server.service.persistence.module.RecordHelper;
import org.junit.Test;

public class EntityValidatorServiceImplDiffblueTest {
  /**
   * Test
   * {@link EntityValidatorServiceImpl#validate(Entity, Serializable, Map, RecordHelper, boolean)}.
   * <ul>
   *   <li>Given array of {@link String} with {@code java.util.List}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EntityValidatorServiceImpl#validate(Entity, Serializable, Map, RecordHelper, boolean)}
   */
  @Test
  public void testValidate_givenArrayOfStringWithJavaUtilList() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EntityValidatorServiceImpl entityValidatorServiceImpl = new EntityValidatorServiceImpl();
    Entity submittedEntity = mock(Entity.class);
    when(submittedEntity.getType()).thenReturn(new String[]{"java.util.List"});

    // Act
    entityValidatorServiceImpl.validate(submittedEntity, null, new HashMap<>(), mock(RecordHelper.class), true);

    // Assert
    verify(submittedEntity).getType();
  }

  /**
   * Test
   * {@link EntityValidatorServiceImpl#validate(Entity, Serializable, Map, RecordHelper, boolean)}.
   * <ul>
   *   <li>Given array of {@link String} with
   * {@code org.broadleafcommerce.openadmin.dto.Entity}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EntityValidatorServiceImpl#validate(Entity, Serializable, Map, RecordHelper, boolean)}
   */
  @Test
  public void testValidate_givenArrayOfStringWithOrgBroadleafcommerceOpenadminDtoEntity() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EntityValidatorServiceImpl entityValidatorServiceImpl = new EntityValidatorServiceImpl();
    Entity submittedEntity = mock(Entity.class);
    when(submittedEntity.getType()).thenReturn(new String[]{"org.broadleafcommerce.openadmin.dto.Entity"});

    // Act
    entityValidatorServiceImpl.validate(submittedEntity, null, new HashMap<>(), mock(RecordHelper.class), true);

    // Assert
    verify(submittedEntity).getType();
  }

  /**
   * Test
   * {@link EntityValidatorServiceImpl#validate(Entity, Serializable, Map, RecordHelper, boolean)}.
   * <ul>
   *   <li>Given array of {@link String} with {@code Type}.</li>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EntityValidatorServiceImpl#validate(Entity, Serializable, Map, RecordHelper, boolean)}
   */
  @Test
  public void testValidate_givenArrayOfStringWithType_thenThrowRuntimeException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EntityValidatorServiceImpl entityValidatorServiceImpl = new EntityValidatorServiceImpl();
    Entity submittedEntity = mock(Entity.class);
    when(submittedEntity.getType()).thenReturn(new String[]{"Type"});

    // Act and Assert
    assertThrows(RuntimeException.class, () -> entityValidatorServiceImpl.validate(submittedEntity, null,
        new HashMap<>(), mock(RecordHelper.class), true));
    verify(submittedEntity).getType();
  }

  /**
   * Test {@link EntityValidatorServiceImpl#getTypeHierarchy(Entity)}.
   * <ul>
   *   <li>Given array of {@link String} with {@code Type}.</li>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EntityValidatorServiceImpl#getTypeHierarchy(Entity)}
   */
  @Test
  public void testGetTypeHierarchy_givenArrayOfStringWithType_thenThrowRuntimeException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EntityValidatorServiceImpl entityValidatorServiceImpl = new EntityValidatorServiceImpl();
    Entity entity = mock(Entity.class);
    when(entity.getType()).thenReturn(new String[]{"Type"});

    // Act and Assert
    assertThrows(RuntimeException.class, () -> entityValidatorServiceImpl.getTypeHierarchy(entity));
    verify(entity).getType();
  }

  /**
   * Test {@link EntityValidatorServiceImpl#getTypeHierarchy(Entity)}.
   * <ul>
   *   <li>Then return first is {@code java.util.List}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EntityValidatorServiceImpl#getTypeHierarchy(Entity)}
   */
  @Test
  public void testGetTypeHierarchy_thenReturnFirstIsJavaUtilList() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EntityValidatorServiceImpl entityValidatorServiceImpl = new EntityValidatorServiceImpl();
    Entity entity = mock(Entity.class);
    when(entity.getType()).thenReturn(new String[]{"java.util.List"});

    // Act
    List<String> actualTypeHierarchy = entityValidatorServiceImpl.getTypeHierarchy(entity);

    // Assert
    verify(entity).getType();
    assertEquals(1, actualTypeHierarchy.size());
    assertEquals("java.util.List", actualTypeHierarchy.get(0));
  }

  /**
   * Test {@link EntityValidatorServiceImpl#getTypeHierarchy(Entity)}.
   * <ul>
   *   <li>Then return first is
   * {@code org.broadleafcommerce.openadmin.dto.Entity}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EntityValidatorServiceImpl#getTypeHierarchy(Entity)}
   */
  @Test
  public void testGetTypeHierarchy_thenReturnFirstIsOrgBroadleafcommerceOpenadminDtoEntity() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EntityValidatorServiceImpl entityValidatorServiceImpl = new EntityValidatorServiceImpl();
    Entity entity = mock(Entity.class);
    when(entity.getType()).thenReturn(new String[]{"org.broadleafcommerce.openadmin.dto.Entity"});

    // Act
    List<String> actualTypeHierarchy = entityValidatorServiceImpl.getTypeHierarchy(entity);

    // Assert
    verify(entity).getType();
    assertEquals(1, actualTypeHierarchy.size());
    assertEquals("org.broadleafcommerce.openadmin.dto.Entity", actualTypeHierarchy.get(0));
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EntityValidatorServiceImpl#setGlobalEntityValidators(List)}
   *   <li>{@link EntityValidatorServiceImpl#getGlobalEntityValidators()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    EntityValidatorServiceImpl entityValidatorServiceImpl = new EntityValidatorServiceImpl();
    ArrayList<GlobalPropertyValidator> globalEntityValidators = new ArrayList<>();

    // Act
    entityValidatorServiceImpl.setGlobalEntityValidators(globalEntityValidators);
    List<GlobalPropertyValidator> actualGlobalEntityValidators = entityValidatorServiceImpl.getGlobalEntityValidators();

    // Assert that nothing has changed
    assertTrue(actualGlobalEntityValidators.isEmpty());
    assertSame(globalEntityValidators, actualGlobalEntityValidators);
  }
}
