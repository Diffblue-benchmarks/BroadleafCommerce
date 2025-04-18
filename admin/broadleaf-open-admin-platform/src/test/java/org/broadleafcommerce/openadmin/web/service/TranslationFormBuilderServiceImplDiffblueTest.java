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
package org.broadleafcommerce.openadmin.web.service;

import java.util.ArrayList;
import java.util.HashMap;
import org.broadleafcommerce.openadmin.dto.ClassMetadata;
import org.broadleafcommerce.openadmin.dto.ClassTree;
import org.broadleafcommerce.openadmin.dto.Property;
import org.broadleafcommerce.openadmin.web.form.TranslationForm;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml",
    "/bl-open-admin-applicationContext-entity.xml", "/bl-open-admin-contentClient-applicationContext.xml",
    "/bl-open-admin-contentCreator-applicationContext.xml",
    "/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml",
    "/blc-config/admin/framework/bl-open-admin-applicationContext.xml",
    "/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class TranslationFormBuilderServiceImplDiffblueTest {
  /**
   * Test {@link TranslationFormBuilderServiceImpl#buildListGrid(List, boolean)}.
   * <p>
   * Method under test:
   * {@link TranslationFormBuilderServiceImpl#buildListGrid(List, boolean)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testBuildListGrid() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.web.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass16669 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.web.service.TranslationFormBuilderServiceImpl translationFormBuilderServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    TranslationFormBuilderServiceImpl translationFormBuilderServiceImpl2 = new TranslationFormBuilderServiceImpl();

    // Act
    translationFormBuilderServiceImpl2.buildListGrid(new ArrayList<>(), true);
  }

  /**
   * Test
   * {@link TranslationFormBuilderServiceImpl#buildTranslationForm(ClassMetadata, TranslationForm, TranslationFormAction)}.
   * <p>
   * Method under test:
   * {@link TranslationFormBuilderServiceImpl#buildTranslationForm(ClassMetadata, TranslationForm, TranslationFormAction)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testBuildTranslationForm() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.web.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass16675 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.web.service.TranslationFormBuilderServiceImpl translationFormBuilderServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    TranslationFormBuilderServiceImpl translationFormBuilderServiceImpl2 = new TranslationFormBuilderServiceImpl();

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[]{new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    TranslationForm formProperties = new TranslationForm();
    formProperties.setCeilingEntity("Ceiling Entity");
    formProperties.setEntityId("42");
    formProperties.setFieldType("Field Type");
    formProperties.setIsRte(true);
    formProperties.setLocaleCode("en");
    formProperties.setPropertyName("Property Name");
    formProperties.setTranslatedValue("42");
    formProperties.setTranslationId(1L);

    // Act
    translationFormBuilderServiceImpl2.buildTranslationForm(cmd, formProperties, TranslationFormAction.ADD);
  }

  /**
   * Test
   * {@link TranslationFormBuilderServiceImpl#getFormFieldType(TranslationForm)}.
   * <p>
   * Method under test:
   * {@link TranslationFormBuilderServiceImpl#getFormFieldType(TranslationForm)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetFormFieldType() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.web.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass16964 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.web.service.TranslationFormBuilderServiceImpl translationFormBuilderServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    TranslationFormBuilderServiceImpl translationFormBuilderServiceImpl2 = new TranslationFormBuilderServiceImpl();

    TranslationForm formProperties = new TranslationForm();
    formProperties.setCeilingEntity("Ceiling Entity");
    formProperties.setEntityId("42");
    formProperties.setFieldType("Field Type");
    formProperties.setIsRte(true);
    formProperties.setLocaleCode("en");
    formProperties.setPropertyName("Property Name");
    formProperties.setTranslatedValue("42");
    formProperties.setTranslationId(1L);

    // Act
    translationFormBuilderServiceImpl2.getFormFieldType(formProperties);
  }

  /**
   * Test {@link TranslationFormBuilderServiceImpl#getLocaleField(String)}.
   * <p>
   * Method under test:
   * {@link TranslationFormBuilderServiceImpl#getLocaleField(String)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetLocaleField() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.web.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass17091 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.web.service.TranslationFormBuilderServiceImpl translationFormBuilderServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new TranslationFormBuilderServiceImpl()).getLocaleField("en");
  }

  /**
   * Test
   * {@link TranslationFormBuilderServiceImpl#getLocalizedEditToViewMessage()}.
   * <p>
   * Method under test:
   * {@link TranslationFormBuilderServiceImpl#getLocalizedEditToViewMessage()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetLocalizedEditToViewMessage2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.web.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass17350 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.web.service.TranslationFormBuilderServiceImpl translationFormBuilderServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new TranslationFormBuilderServiceImpl()).getLocalizedEditToViewMessage();
  }
}
