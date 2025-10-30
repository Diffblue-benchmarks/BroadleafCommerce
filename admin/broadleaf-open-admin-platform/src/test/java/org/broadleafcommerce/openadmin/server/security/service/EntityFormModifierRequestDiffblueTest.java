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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.openadmin.dto.Entity;
import org.broadleafcommerce.openadmin.server.security.domain.AdminUser;
import org.broadleafcommerce.openadmin.server.security.domain.AdminUserImpl;
import org.broadleafcommerce.openadmin.web.form.component.ListGrid;
import org.broadleafcommerce.openadmin.web.form.entity.EntityForm;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {EntityFormModifierRequest.class})
@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class EntityFormModifierRequestDiffblueTest {
  @Autowired
  private EntityFormModifierRequest entityFormModifierRequest;

  /**
   * Test {@link EntityFormModifierRequest#withEntityForm(EntityForm)}.
   * <p>
   * Method under test: {@link EntityFormModifierRequest#withEntityForm(EntityForm)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"EntityFormModifierRequest EntityFormModifierRequest.withEntityForm(EntityForm)"})
  public void testWithEntityForm() {
    // Arrange
    EntityFormModifierRequest entityFormModifierRequest = new EntityFormModifierRequest();
    EntityForm entityForm = new EntityForm();

    // Act and Assert
    assertSame(entityFormModifierRequest, entityFormModifierRequest.withEntityForm(entityForm));
    assertSame(entityForm, entityFormModifierRequest.getEntityForm());
  }

  /**
   * Test {@link EntityFormModifierRequest#withListGrid(ListGrid)}.
   * <p>
   * Method under test: {@link EntityFormModifierRequest#withListGrid(ListGrid)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"EntityFormModifierRequest EntityFormModifierRequest.withListGrid(ListGrid)"})
  public void testWithListGrid() {
    // Arrange
    EntityFormModifierRequest entityFormModifierRequest = new EntityFormModifierRequest();
    ListGrid listGrid = new ListGrid();

    // Act and Assert
    assertSame(entityFormModifierRequest, entityFormModifierRequest.withListGrid(listGrid));
    assertSame(listGrid, entityFormModifierRequest.getListGrid());
  }

  /**
   * Test {@link EntityFormModifierRequest#withConfiguration(EntityFormModifierData)}.
   * <p>
   * Method under test: {@link EntityFormModifierRequest#withConfiguration(EntityFormModifierData)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"EntityFormModifierRequest EntityFormModifierRequest.withConfiguration(EntityFormModifierData)"})
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
   * Test {@link EntityFormModifierRequest#withConfiguration(EntityFormModifierData)}.
   * <ul>
   *   <li>Then return Configuration size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityFormModifierRequest#withConfiguration(EntityFormModifierData)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"EntityFormModifierRequest EntityFormModifierRequest.withConfiguration(EntityFormModifierData)"})
  public void testWithConfiguration_thenReturnConfigurationSizeIsOne() {
    // Arrange
    EntityFormModifierDataPoint entityFormModifierDataPoint = new EntityFormModifierDataPoint();
    entityFormModifierDataPoint.setKey("Key");
    entityFormModifierDataPoint.setValue("Value");

    EntityFormModifierData<EntityFormModifierDataPoint> configuration = new EntityFormModifierData<>();
    configuration.add(entityFormModifierDataPoint);

    // Act and Assert
    EntityFormModifierData<EntityFormModifierDataPoint> configuration2 = entityFormModifierRequest
        .withConfiguration(configuration)
        .getConfiguration();
    assertEquals(1, configuration2.size());
    assertSame(entityFormModifierDataPoint, configuration2.get(0));
  }

  /**
   * Test {@link EntityFormModifierRequest#withConfiguration(EntityFormModifierData)}.
   * <ul>
   *   <li>Then return Configuration size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityFormModifierRequest#withConfiguration(EntityFormModifierData)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"EntityFormModifierRequest EntityFormModifierRequest.withConfiguration(EntityFormModifierData)"})
  public void testWithConfiguration_thenReturnConfigurationSizeIsTwo() {
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

    // Act and Assert
    EntityFormModifierData<EntityFormModifierDataPoint> configuration2 = entityFormModifierRequest
        .withConfiguration(configuration)
        .getConfiguration();
    assertEquals(2, configuration2.size());
    assertSame(entityFormModifierDataPoint, configuration2.get(1));
  }

  /**
   * Test {@link EntityFormModifierRequest#withCurrentUser(AdminUser)}.
   * <p>
   * Method under test: {@link EntityFormModifierRequest#withCurrentUser(AdminUser)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"EntityFormModifierRequest EntityFormModifierRequest.withCurrentUser(AdminUser)"})
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
   * Test {@link EntityFormModifierRequest#withEntity(Entity)}.
   * <p>
   * Method under test: {@link EntityFormModifierRequest#withEntity(Entity)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"EntityFormModifierRequest EntityFormModifierRequest.withEntity(Entity)"})
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
   * Test {@link EntityFormModifierRequest#withRowLevelSecurityService(RowLevelSecurityService)}.
   * <p>
   * Method under test: {@link EntityFormModifierRequest#withRowLevelSecurityService(RowLevelSecurityService)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "EntityFormModifierRequest EntityFormModifierRequest.withRowLevelSecurityService(RowLevelSecurityService)"})
  public void testWithRowLevelSecurityService() {
    // Arrange
    EntityFormModifierRequest entityFormModifierRequest = new EntityFormModifierRequest();
    RowLevelSecurityServiceImpl rowLevelSecurityService = new RowLevelSecurityServiceImpl();

    // Act and Assert
    assertSame(entityFormModifierRequest,
        entityFormModifierRequest.withRowLevelSecurityService(rowLevelSecurityService));
    assertSame(rowLevelSecurityService, entityFormModifierRequest.getRowLevelSecurityService());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link EntityFormModifierRequest}
   *   <li>{@link EntityFormModifierRequest#setConfiguration(EntityFormModifierData)}
   *   <li>{@link EntityFormModifierRequest#setCurrentUser(AdminUser)}
   *   <li>{@link EntityFormModifierRequest#setEntity(Entity)}
   *   <li>{@link EntityFormModifierRequest#setEntityForm(EntityForm)}
   *   <li>{@link EntityFormModifierRequest#setListGrid(ListGrid)}
   *   <li>{@link EntityFormModifierRequest#setRowLevelSecurityService(RowLevelSecurityService)}
   *   <li>{@link EntityFormModifierRequest#getConfiguration()}
   *   <li>{@link EntityFormModifierRequest#getCurrentUser()}
   *   <li>{@link EntityFormModifierRequest#getEntity()}
   *   <li>{@link EntityFormModifierRequest#getEntityForm()}
   *   <li>{@link EntityFormModifierRequest#getListGrid()}
   *   <li>{@link EntityFormModifierRequest#getRowLevelSecurityService()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void EntityFormModifierRequest.<init>()",
      "EntityFormModifierData EntityFormModifierRequest.getConfiguration()",
      "AdminUser EntityFormModifierRequest.getCurrentUser()", "Entity EntityFormModifierRequest.getEntity()",
      "EntityForm EntityFormModifierRequest.getEntityForm()", "ListGrid EntityFormModifierRequest.getListGrid()",
      "RowLevelSecurityService EntityFormModifierRequest.getRowLevelSecurityService()",
      "void EntityFormModifierRequest.setConfiguration(EntityFormModifierData)",
      "void EntityFormModifierRequest.setCurrentUser(AdminUser)", "void EntityFormModifierRequest.setEntity(Entity)",
      "void EntityFormModifierRequest.setEntityForm(EntityForm)",
      "void EntityFormModifierRequest.setListGrid(ListGrid)",
      "void EntityFormModifierRequest.setRowLevelSecurityService(RowLevelSecurityService)"})
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

    // Assert
    assertTrue(actualRowLevelSecurityService instanceof RowLevelSecurityServiceImpl);
    assertSame(entity, actualEntity);
    assertSame(currentUser, actualCurrentUser);
    assertSame(configuration, actualConfiguration);
    assertSame(rowLevelSecurityService, actualRowLevelSecurityService);
    assertSame(listGrid, actualListGrid);
    assertSame(entityForm, actualEntityForm);
  }
}
