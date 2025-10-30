/*-
 * #%L
 * BroadleafCommerce Admin Module
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
package org.broadleafcommerce.admin.web.controller.extension;

import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.common.admin.domain.TypedEntity;
import org.broadleafcommerce.openadmin.web.controller.AdminAbstractControllerExtensionManager;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {TypedEntityBasicEntityExtensionHandler.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class TypedEntityBasicEntityExtensionHandlerDiffblueTest {
  @MockBean(name = "blAdminAbstractControllerExtensionManager")
  private AdminAbstractControllerExtensionManager adminAbstractControllerExtensionManager;

  @Autowired
  private TypedEntityBasicEntityExtensionHandler typedEntityBasicEntityExtensionHandler;

  /**
   * Test {@link TypedEntityBasicEntityExtensionHandler#getDefaultType(Class)}.
   * <p>
   * Method under test: {@link TypedEntityBasicEntityExtensionHandler#getDefaultType(Class)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.String TypedEntityBasicEntityExtensionHandler.getDefaultType(Class)"})
  public void testGetDefaultType() {
    // Arrange
    Class<TypedEntityBasicEntityExtensionHandler> implClass = TypedEntityBasicEntityExtensionHandler.class;

    // Act and Assert
    assertNull(typedEntityBasicEntityExtensionHandler.getDefaultType(implClass));
  }

  /**
   * Test {@link TypedEntityBasicEntityExtensionHandler#getDefaultType(Class)}.
   * <ul>
   *   <li>When {@code Object}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TypedEntityBasicEntityExtensionHandler#getDefaultType(Class)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.String TypedEntityBasicEntityExtensionHandler.getDefaultType(Class)"})
  public void testGetDefaultType_whenJavaLangObject() {
    // Arrange
    Class<Object> implClass = Object.class;

    // Act and Assert
    assertNull(typedEntityBasicEntityExtensionHandler.getDefaultType(implClass));
  }

  /**
   * Test {@link TypedEntityBasicEntityExtensionHandler#getDefaultType(Class)}.
   * <ul>
   *   <li>When {@code TypedEntity}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TypedEntityBasicEntityExtensionHandler#getDefaultType(Class)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.String TypedEntityBasicEntityExtensionHandler.getDefaultType(Class)"})
  public void testGetDefaultType_whenOrgBroadleafcommerceCommonAdminDomainTypedEntity() {
    // Arrange
    Class<TypedEntity> implClass = TypedEntity.class;

    // Act and Assert
    assertNull(typedEntityBasicEntityExtensionHandler.getDefaultType(implClass));
  }

  /**
   * Test {@link TypedEntityBasicEntityExtensionHandler#getTypeFieldName(Class)}.
   * <p>
   * Method under test: {@link TypedEntityBasicEntityExtensionHandler#getTypeFieldName(Class)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.String TypedEntityBasicEntityExtensionHandler.getTypeFieldName(Class)"})
  public void testGetTypeFieldName() {
    // Arrange
    Class<TypedEntityBasicEntityExtensionHandler> implClass = TypedEntityBasicEntityExtensionHandler.class;

    // Act and Assert
    assertNull(typedEntityBasicEntityExtensionHandler.getTypeFieldName(implClass));
  }

  /**
   * Test {@link TypedEntityBasicEntityExtensionHandler#getTypeFieldName(Class)}.
   * <ul>
   *   <li>When {@code Object}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TypedEntityBasicEntityExtensionHandler#getTypeFieldName(Class)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.String TypedEntityBasicEntityExtensionHandler.getTypeFieldName(Class)"})
  public void testGetTypeFieldName_whenJavaLangObject() {
    // Arrange
    Class<Object> implClass = Object.class;

    // Act and Assert
    assertNull(typedEntityBasicEntityExtensionHandler.getTypeFieldName(implClass));
  }

  /**
   * Test {@link TypedEntityBasicEntityExtensionHandler#getTypeFieldName(Class)}.
   * <ul>
   *   <li>When {@code TypedEntity}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TypedEntityBasicEntityExtensionHandler#getTypeFieldName(Class)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.String TypedEntityBasicEntityExtensionHandler.getTypeFieldName(Class)"})
  public void testGetTypeFieldName_whenOrgBroadleafcommerceCommonAdminDomainTypedEntity() {
    // Arrange
    Class<TypedEntity> implClass = TypedEntity.class;

    // Act and Assert
    assertNull(typedEntityBasicEntityExtensionHandler.getTypeFieldName(implClass));
  }
}
