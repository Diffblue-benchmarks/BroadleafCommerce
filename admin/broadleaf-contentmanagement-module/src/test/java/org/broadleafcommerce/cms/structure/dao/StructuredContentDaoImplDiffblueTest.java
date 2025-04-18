/*-
 * #%L
 * BroadleafCommerce CMS Module
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
package org.broadleafcommerce.cms.structure.dao;

import org.broadleafcommerce.cms.structure.domain.StructuredContent;
import org.broadleafcommerce.cms.structure.domain.StructuredContentImpl;
import org.broadleafcommerce.cms.structure.domain.StructuredContentType;
import org.broadleafcommerce.cms.structure.domain.StructuredContentTypeImpl;
import org.broadleafcommerce.common.locale.domain.Locale;
import org.broadleafcommerce.common.locale.domain.LocaleImpl;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@ContextConfiguration(locations = {"/applicationContext-servlet-cms-contentClient.xml",
    "/applicationContext-servlet-cms-contentCreator.xml", "/bl-cms-applicationContext-entity.xml",
    "/bl-cms-contentClient-applicationContext.xml", "/bl-cms-contentCreator-applicationContext.xml",
    "/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml",
    "/blc-config/admin/framework/bl-cms-admin-applicationContext.xml",
    "/blc-config/site/framework/bl-cms-applicationContext-servlet.xml",
    "/blc-config/site/framework/bl-cms-applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class StructuredContentDaoImplDiffblueTest {
  @Autowired
  private StructuredContentDaoImpl structuredContentDaoImpl;

  /**
   * Test {@link StructuredContentDaoImpl#findStructuredContentById(Long)}.
   * <p>
   * Method under test:
   * {@link StructuredContentDaoImpl#findStructuredContentById(Long)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testFindStructuredContentById() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.structure.dao;
    //   @org.springframework.transaction.annotation.Transactional
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-applicationContext-entity.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3629 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.structure.dao.StructuredContentDaoImpl structuredContentDaoImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new StructuredContentDaoImpl()).findStructuredContentById(1L);
  }

  /**
   * Test {@link StructuredContentDaoImpl#findStructuredContentTypeById(Long)}.
   * <p>
   * Method under test:
   * {@link StructuredContentDaoImpl#findStructuredContentTypeById(Long)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testFindStructuredContentTypeById() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.structure.dao;
    //   @org.springframework.transaction.annotation.Transactional
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-applicationContext-entity.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3645 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.structure.dao.StructuredContentDaoImpl structuredContentDaoImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new StructuredContentDaoImpl()).findStructuredContentTypeById(1L);
  }

  /**
   * Test {@link StructuredContentDaoImpl#retrieveAllStructuredContentTypes()}.
   * <p>
   * Method under test:
   * {@link StructuredContentDaoImpl#retrieveAllStructuredContentTypes()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testRetrieveAllStructuredContentTypes() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.structure.dao;
    //   @org.springframework.transaction.annotation.Transactional
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-applicationContext-entity.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3677 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.structure.dao.StructuredContentDaoImpl structuredContentDaoImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new StructuredContentDaoImpl()).retrieveAllStructuredContentTypes();
  }

  /**
   * Test {@link StructuredContentDaoImpl#findAllContentItems()}.
   * <p>
   * Method under test: {@link StructuredContentDaoImpl#findAllContentItems()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testFindAllContentItems() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.structure.dao;
    //   @org.springframework.transaction.annotation.Transactional
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-applicationContext-entity.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3627 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.structure.dao.StructuredContentDaoImpl structuredContentDaoImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new StructuredContentDaoImpl()).findAllContentItems();
  }

  /**
   * Test
   * {@link StructuredContentDaoImpl#addOrUpdateContentItem(StructuredContent)}.
   * <p>
   * Method under test:
   * {@link StructuredContentDaoImpl#addOrUpdateContentItem(StructuredContent)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testAddOrUpdateContentItem() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.structure.dao;
    //   @org.springframework.transaction.annotation.Transactional
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-applicationContext-entity.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3448 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.structure.dao.StructuredContentDaoImpl structuredContentDaoImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    StructuredContentDaoImpl structuredContentDaoImpl2 = new StructuredContentDaoImpl();

    // Act
    structuredContentDaoImpl2.addOrUpdateContentItem(new StructuredContentImpl());
  }

  /**
   * Test {@link StructuredContentDaoImpl#delete(StructuredContent)}.
   * <p>
   * Method under test: {@link StructuredContentDaoImpl#delete(StructuredContent)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testDelete() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.structure.dao;
    //   @org.springframework.transaction.annotation.Transactional
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-applicationContext-entity.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3465 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.structure.dao.StructuredContentDaoImpl structuredContentDaoImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    StructuredContentDaoImpl structuredContentDaoImpl2 = new StructuredContentDaoImpl();

    // Act
    structuredContentDaoImpl2.delete(new StructuredContentImpl());
  }

  /**
   * Test
   * {@link StructuredContentDaoImpl#saveStructuredContentType(StructuredContentType)}.
   * <p>
   * Method under test:
   * {@link StructuredContentDaoImpl#saveStructuredContentType(StructuredContentType)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testSaveStructuredContentType() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.structure.dao;
    //   @org.springframework.transaction.annotation.Transactional
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-applicationContext-entity.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3679 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.structure.dao.StructuredContentDaoImpl structuredContentDaoImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    StructuredContentDaoImpl structuredContentDaoImpl2 = new StructuredContentDaoImpl();

    // Act
    structuredContentDaoImpl2.saveStructuredContentType(new StructuredContentTypeImpl());
  }

  /**
   * Test
   * {@link StructuredContentDaoImpl#findActiveStructuredContentByType(StructuredContentType, Locale, Locale)}
   * with {@code type}, {@code fullLocale}, {@code languageOnlyLocale}.
   * <p>
   * Method under test:
   * {@link StructuredContentDaoImpl#findActiveStructuredContentByType(StructuredContentType, Locale, Locale)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testFindActiveStructuredContentByTypeWithTypeFullLocaleLanguageOnlyLocale() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.structure.dao;
    //   @org.springframework.transaction.annotation.Transactional
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-applicationContext-entity.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3600 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.structure.dao.StructuredContentDaoImpl structuredContentDaoImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    StructuredContentDaoImpl structuredContentDaoImpl2 = new StructuredContentDaoImpl();
    StructuredContentTypeImpl type = new StructuredContentTypeImpl();
    LocaleImpl fullLocale = new LocaleImpl();

    // Act
    structuredContentDaoImpl2.findActiveStructuredContentByType(type, fullLocale, new LocaleImpl());
  }

  /**
   * Test
   * {@link StructuredContentDaoImpl#findActiveStructuredContentByType(StructuredContentType, Locale)}
   * with {@code type}, {@code locale}.
   * <p>
   * Method under test:
   * {@link StructuredContentDaoImpl#findActiveStructuredContentByType(StructuredContentType, Locale)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testFindActiveStructuredContentByTypeWithTypeLocale() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.structure.dao;
    //   @org.springframework.transaction.annotation.Transactional
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-applicationContext-entity.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3581 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.structure.dao.StructuredContentDaoImpl structuredContentDaoImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    StructuredContentDaoImpl structuredContentDaoImpl2 = new StructuredContentDaoImpl();
    StructuredContentTypeImpl type = new StructuredContentTypeImpl();

    // Act
    structuredContentDaoImpl2.findActiveStructuredContentByType(type, new LocaleImpl());
  }

  /**
   * Test
   * {@link StructuredContentDaoImpl#findActiveStructuredContentByNameAndType(StructuredContentType, String, Locale, Locale)}
   * with {@code type}, {@code name}, {@code fullLocale},
   * {@code languageOnlyLocale}.
   * <p>
   * Method under test:
   * {@link StructuredContentDaoImpl#findActiveStructuredContentByNameAndType(StructuredContentType, String, Locale, Locale)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testFindActiveStructuredContentByNameAndTypeWithTypeNameFullLocaleLanguageOnlyLocale() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.structure.dao;
    //   @org.springframework.transaction.annotation.Transactional
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-applicationContext-entity.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3552 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.structure.dao.StructuredContentDaoImpl structuredContentDaoImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    StructuredContentDaoImpl structuredContentDaoImpl2 = new StructuredContentDaoImpl();
    StructuredContentTypeImpl type = new StructuredContentTypeImpl();
    LocaleImpl fullLocale = new LocaleImpl();

    // Act
    structuredContentDaoImpl2.findActiveStructuredContentByNameAndType(type, "Name", fullLocale, new LocaleImpl());
  }

  /**
   * Test
   * {@link StructuredContentDaoImpl#findActiveStructuredContentByNameAndType(StructuredContentType, String, Locale)}
   * with {@code type}, {@code name}, {@code locale}.
   * <p>
   * Method under test:
   * {@link StructuredContentDaoImpl#findActiveStructuredContentByNameAndType(StructuredContentType, String, Locale)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testFindActiveStructuredContentByNameAndTypeWithTypeNameLocale() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.structure.dao;
    //   @org.springframework.transaction.annotation.Transactional
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-applicationContext-entity.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3531 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.structure.dao.StructuredContentDaoImpl structuredContentDaoImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    StructuredContentDaoImpl structuredContentDaoImpl2 = new StructuredContentDaoImpl();
    StructuredContentTypeImpl type = new StructuredContentTypeImpl();

    // Act
    structuredContentDaoImpl2.findActiveStructuredContentByNameAndType(type, "Name", new LocaleImpl());
  }

  /**
   * Test
   * {@link StructuredContentDaoImpl#findActiveStructuredContentByName(String, Locale, Locale)}
   * with {@code name}, {@code fullLocale}, {@code languageOnlyLocale}.
   * <p>
   * Method under test:
   * {@link StructuredContentDaoImpl#findActiveStructuredContentByName(String, Locale, Locale)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testFindActiveStructuredContentByNameWithNameFullLocaleLanguageOnlyLocale() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.structure.dao;
    //   @org.springframework.transaction.annotation.Transactional
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-applicationContext-entity.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3511 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.structure.dao.StructuredContentDaoImpl structuredContentDaoImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    StructuredContentDaoImpl structuredContentDaoImpl2 = new StructuredContentDaoImpl();
    LocaleImpl fullLocale = new LocaleImpl();

    // Act
    structuredContentDaoImpl2.findActiveStructuredContentByName("Name", fullLocale, new LocaleImpl());
  }

  /**
   * Test
   * {@link StructuredContentDaoImpl#findActiveStructuredContentByName(String, Locale)}
   * with {@code name}, {@code locale}.
   * <p>
   * Method under test:
   * {@link StructuredContentDaoImpl#findActiveStructuredContentByName(String, Locale)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testFindActiveStructuredContentByNameWithNameLocale() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.structure.dao;
    //   @org.springframework.transaction.annotation.Transactional
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-applicationContext-entity.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3499 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.structure.dao.StructuredContentDaoImpl structuredContentDaoImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    StructuredContentDaoImpl structuredContentDaoImpl2 = new StructuredContentDaoImpl();

    // Act
    structuredContentDaoImpl2.findActiveStructuredContentByName("Name", new LocaleImpl());
  }

  /**
   * Test
   * {@link StructuredContentDaoImpl#findStructuredContentTypeByName(String)}.
   * <p>
   * Method under test:
   * {@link StructuredContentDaoImpl#findStructuredContentTypeByName(String)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testFindStructuredContentTypeByName() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.structure.dao;
    //   @org.springframework.transaction.annotation.Transactional
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-applicationContext-entity.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3661 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.structure.dao.StructuredContentDaoImpl structuredContentDaoImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new StructuredContentDaoImpl()).findStructuredContentTypeByName("Name");
  }

  /**
   * Test {@link StructuredContentDaoImpl#detach(StructuredContent)}.
   * <p>
   * Method under test: {@link StructuredContentDaoImpl#detach(StructuredContent)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testDetach() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.structure.dao;
    //   @org.springframework.transaction.annotation.Transactional
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-applicationContext-entity.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3482 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.structure.dao.StructuredContentDaoImpl structuredContentDaoImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    StructuredContentDaoImpl structuredContentDaoImpl2 = new StructuredContentDaoImpl();

    // Act
    structuredContentDaoImpl2.detach(new StructuredContentImpl());
  }
}
