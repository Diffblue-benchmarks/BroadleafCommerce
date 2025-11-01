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
package org.broadleafcommerce.openadmin.server.security.service;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import org.broadleafcommerce.openadmin.dto.Entity;
import org.broadleafcommerce.openadmin.server.security.domain.AdminUser;
import org.broadleafcommerce.openadmin.server.security.domain.AdminUserImpl;
import org.broadleafcommerce.openadmin.web.form.component.ListGrid;
import org.broadleafcommerce.openadmin.web.form.entity.EntityForm;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {EntityFormModifierRequest.class})
@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class EntityFormModifierRequestDiffblueTest {
  @Autowired
  private EntityFormModifierRequest entityFormModifierRequest;

  /**
   * Method under test:
   * {@link EntityFormModifierRequest#withEntityForm(EntityForm)}
   */
  @Test
  public void testWithEntityForm() {
    // Arrange
    EntityFormModifierRequest entityFormModifierRequest = new EntityFormModifierRequest();
    EntityForm entityForm = new EntityForm();

    // Act and Assert
    assertSame(entityFormModifierRequest, entityFormModifierRequest.withEntityForm(entityForm));
    assertSame(entityForm, entityFormModifierRequest.getEntityForm());
  }

  /**
   * Method under test: {@link EntityFormModifierRequest#withListGrid(ListGrid)}
   */
  @Test
  public void testWithListGrid() {
    // Arrange
    EntityFormModifierRequest entityFormModifierRequest = new EntityFormModifierRequest();
    ListGrid listGrid = new ListGrid();

    // Act and Assert
    assertSame(entityFormModifierRequest, entityFormModifierRequest.withListGrid(listGrid));
    assertSame(listGrid, entityFormModifierRequest.getListGrid());
  }

  /**
   * Method under test:
   * {@link EntityFormModifierRequest#withConfiguration(EntityFormModifierData)}
   */
  @Test
  public void testWithConfiguration() {
    // Arrange
    EntityFormModifierData<EntityFormModifierDataPoint> configuration = new EntityFormModifierData<>();

    // Act
    EntityFormModifierRequest actualWithConfigurationResult = entityFormModifierRequest
        .withConfiguration(configuration);

    // Assert
    assertSame(configuration, entityFormModifierRequest.getConfiguration());
    assertSame(entityFormModifierRequest, actualWithConfigurationResult);
  }

  /**
   * Method under test:
   * {@link EntityFormModifierRequest#withConfiguration(EntityFormModifierData)}
   */
  @Test
  public void testWithConfiguration2() {
    // Arrange
    EntityFormModifierDataPoint entityFormModifierDataPoint = new EntityFormModifierDataPoint();
    entityFormModifierDataPoint.setKey("Key");
    entityFormModifierDataPoint.setValue("Value");

    EntityFormModifierData<EntityFormModifierDataPoint> configuration = new EntityFormModifierData<>();
    configuration.add(entityFormModifierDataPoint);

    // Act
    EntityFormModifierRequest actualWithConfigurationResult = entityFormModifierRequest
        .withConfiguration(configuration);

    // Assert
    assertSame(configuration, entityFormModifierRequest.getConfiguration());
    assertSame(entityFormModifierRequest, actualWithConfigurationResult);
  }

  /**
   * Method under test:
   * {@link EntityFormModifierRequest#withConfiguration(EntityFormModifierData)}
   */
  @Test
  public void testWithConfiguration3() {
    // Arrange
    EntityFormModifierDataPoint entityFormModifierDataPoint = new EntityFormModifierDataPoint();
    entityFormModifierDataPoint.setKey("Key");
    entityFormModifierDataPoint.setValue("Value");

    EntityFormModifierDataPoint entityFormModifierDataPoint2 = new EntityFormModifierDataPoint();
    entityFormModifierDataPoint2.setKey("Key");
    entityFormModifierDataPoint2.setValue("Value");

    EntityFormModifierData<EntityFormModifierDataPoint> configuration = new EntityFormModifierData<>();
    configuration.add(entityFormModifierDataPoint2);
    configuration.add(entityFormModifierDataPoint);

    // Act
    EntityFormModifierRequest actualWithConfigurationResult = entityFormModifierRequest
        .withConfiguration(configuration);

    // Assert
    assertSame(configuration, entityFormModifierRequest.getConfiguration());
    assertSame(entityFormModifierRequest, actualWithConfigurationResult);
  }

  /**
   * Method under test:
   * {@link EntityFormModifierRequest#withConfiguration(EntityFormModifierData)}
   */
  @Test
  public void testWithConfiguration4() {
    // Arrange
    EntityFormModifierDataPoint entityFormModifierDataPoint = mock(EntityFormModifierDataPoint.class);
    doNothing().when(entityFormModifierDataPoint).setKey(Mockito.<Object>any());
    doNothing().when(entityFormModifierDataPoint).setValue(Mockito.<Object>any());
    entityFormModifierDataPoint.setKey("Key");
    entityFormModifierDataPoint.setValue("Value");

    EntityFormModifierData<EntityFormModifierDataPoint> configuration = new EntityFormModifierData<>();
    configuration.add(entityFormModifierDataPoint);

    // Act
    EntityFormModifierRequest actualWithConfigurationResult = entityFormModifierRequest
        .withConfiguration(configuration);

    // Assert
    verify(entityFormModifierDataPoint).setKey(isA(Object.class));
    verify(entityFormModifierDataPoint).setValue(isA(Object.class));
    assertSame(configuration, entityFormModifierRequest.getConfiguration());
    assertSame(entityFormModifierRequest, actualWithConfigurationResult);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link EntityFormModifierRequest}
   *   <li>
   * {@link EntityFormModifierRequest#setConfiguration(EntityFormModifierData)}
   *   <li>{@link EntityFormModifierRequest#setCurrentUser(AdminUser)}
   *   <li>{@link EntityFormModifierRequest#setEntity(Entity)}
   *   <li>{@link EntityFormModifierRequest#setEntityForm(EntityForm)}
   *   <li>{@link EntityFormModifierRequest#setListGrid(ListGrid)}
   *   <li>
   * {@link EntityFormModifierRequest#setRowLevelSecurityService(RowLevelSecurityService)}
   *   <li>{@link EntityFormModifierRequest#getConfiguration()}
   *   <li>{@link EntityFormModifierRequest#getCurrentUser()}
   *   <li>{@link EntityFormModifierRequest#getEntity()}
   *   <li>{@link EntityFormModifierRequest#getEntityForm()}
   *   <li>{@link EntityFormModifierRequest#getListGrid()}
   *   <li>{@link EntityFormModifierRequest#getRowLevelSecurityService()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    EntityFormModifierRequest actualEntityFormModifierRequest = new EntityFormModifierRequest();
    EntityFormModifierData<EntityFormModifierDataPoint> configuration = new EntityFormModifierData<>();
    actualEntityFormModifierRequest.setConfiguration(configuration);
    AdminUserImpl currentUser = new AdminUserImpl();
    actualEntityFormModifierRequest.setCurrentUser(currentUser);
    Entity entity = new Entity();
    actualEntityFormModifierRequest.setEntity(entity);
    EntityForm entityForm = new EntityForm();
    actualEntityFormModifierRequest.setEntityForm(entityForm);
    ListGrid listGrid = new ListGrid();
    actualEntityFormModifierRequest.setListGrid(listGrid);
    RowLevelSecurityServiceImpl rowLevelSecurityService = new RowLevelSecurityServiceImpl();
    actualEntityFormModifierRequest.setRowLevelSecurityService(rowLevelSecurityService);
    EntityFormModifierData<EntityFormModifierDataPoint> actualConfiguration = actualEntityFormModifierRequest
        .getConfiguration();
    AdminUser actualCurrentUser = actualEntityFormModifierRequest.getCurrentUser();
    Entity actualEntity = actualEntityFormModifierRequest.getEntity();
    EntityForm actualEntityForm = actualEntityFormModifierRequest.getEntityForm();
    ListGrid actualListGrid = actualEntityFormModifierRequest.getListGrid();
    RowLevelSecurityService actualRowLevelSecurityService = actualEntityFormModifierRequest
        .getRowLevelSecurityService();

    // Assert that nothing has changed
    assertTrue(actualRowLevelSecurityService instanceof RowLevelSecurityServiceImpl);
    assertSame(entity, actualEntity);
    assertSame(currentUser, actualCurrentUser);
    assertSame(configuration, actualConfiguration);
    assertSame(rowLevelSecurityService, actualRowLevelSecurityService);
    assertSame(listGrid, actualListGrid);
    assertSame(entityForm, actualEntityForm);
  }

  /**
   * Method under test:
   * {@link EntityFormModifierRequest#withCurrentUser(AdminUser)}
   */
  @Test
  public void testWithCurrentUser() {
    // Arrange
    EntityFormModifierRequest entityFormModifierRequest = new EntityFormModifierRequest();
    AdminUserImpl currentUser = new AdminUserImpl();

    // Act
    EntityFormModifierRequest actualWithCurrentUserResult = entityFormModifierRequest.withCurrentUser(currentUser);

    // Assert
    assertSame(currentUser, entityFormModifierRequest.getCurrentUser());
    assertSame(entityFormModifierRequest, actualWithCurrentUserResult);
  }

  /**
   * Method under test:
   * {@link EntityFormModifierRequest#withCurrentUser(AdminUser)}
   */
  @Test
  public void testWithCurrentUser2() {
    // Arrange
    EntityFormModifierRequest entityFormModifierRequest = new EntityFormModifierRequest();
    AdminUser currentUser = mock(AdminUser.class);

    // Act and Assert
    assertSame(entityFormModifierRequest, entityFormModifierRequest.withCurrentUser(currentUser));
    assertSame(currentUser, entityFormModifierRequest.getCurrentUser());
  }

  /**
   * Method under test: {@link EntityFormModifierRequest#withEntity(Entity)}
   */
  @Test
  public void testWithEntity() {
    // Arrange
    EntityFormModifierRequest entityFormModifierRequest = new EntityFormModifierRequest();
    Entity entity = new Entity();

    // Act
    EntityFormModifierRequest actualWithEntityResult = entityFormModifierRequest.withEntity(entity);

    // Assert
    assertSame(entity, entityFormModifierRequest.getEntity());
    assertSame(entityFormModifierRequest, actualWithEntityResult);
  }

  /**
   * Method under test: {@link EntityFormModifierRequest#withEntity(Entity)}
   */
  @Test
  public void testWithEntity2() {
    // Arrange
    EntityFormModifierRequest entityFormModifierRequest = new EntityFormModifierRequest();
    entityFormModifierRequest.setCurrentUser(mock(AdminUser.class));
    Entity entity = new Entity();

    // Act
    EntityFormModifierRequest actualWithEntityResult = entityFormModifierRequest.withEntity(entity);

    // Assert
    assertSame(entity, entityFormModifierRequest.getEntity());
    assertSame(entityFormModifierRequest, actualWithEntityResult);
  }

  /**
   * Method under test:
   * {@link EntityFormModifierRequest#withRowLevelSecurityService(RowLevelSecurityService)}
   */
  @Test
  public void testWithRowLevelSecurityService() {
    // Arrange
    EntityFormModifierRequest entityFormModifierRequest = new EntityFormModifierRequest();
    RowLevelSecurityServiceImpl rowLevelSecurityService = new RowLevelSecurityServiceImpl();

    // Act and Assert
    assertSame(entityFormModifierRequest,
        entityFormModifierRequest.withRowLevelSecurityService(rowLevelSecurityService));
    assertSame(rowLevelSecurityService, entityFormModifierRequest.getRowLevelSecurityService());
  }
}
