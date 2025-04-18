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
package org.broadleafcommerce.cms.file.service;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.HashMap;
import org.broadleafcommerce.cms.file.domain.ImageStaticAssetImpl;
import org.broadleafcommerce.cms.file.domain.StaticAssetStorageImpl;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"/applicationContext-servlet-cms-contentClient.xml",
    "/applicationContext-servlet-cms-contentCreator.xml", "/bl-cms-applicationContext-entity.xml",
    "/bl-cms-contentClient-applicationContext.xml", "/bl-cms-contentCreator-applicationContext.xml",
    "/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml",
    "/blc-config/admin/framework/bl-cms-admin-applicationContext.xml",
    "/blc-config/site/framework/bl-cms-applicationContext-servlet.xml",
    "/blc-config/site/framework/bl-cms-applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class StaticAssetStorageServiceImplDiffblueTest {
  /**
   * Test {@link StaticAssetStorageServiceImpl#findStaticAsset(String)}.
   * <p>
   * Method under test:
   * {@link StaticAssetStorageServiceImpl#findStaticAsset(String)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testFindStaticAsset() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.file.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-applicationContext-entity.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass8274 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.file.service.StaticAssetStorageServiceImpl staticAssetStorageServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new StaticAssetStorageServiceImpl()).findStaticAsset("https://example.org/example");
  }

  /**
   * Test {@link StaticAssetStorageServiceImpl#shouldUseSharedFile(InputStream)}.
   * <p>
   * Method under test:
   * {@link StaticAssetStorageServiceImpl#shouldUseSharedFile(InputStream)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testShouldUseSharedFile() throws UnsupportedEncodingException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.file.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-applicationContext-entity.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass10267 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.file.service.StaticAssetStorageServiceImpl staticAssetStorageServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    StaticAssetStorageServiceImpl staticAssetStorageServiceImpl2 = new StaticAssetStorageServiceImpl();

    // Act
    staticAssetStorageServiceImpl2.shouldUseSharedFile(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test
   * {@link StaticAssetStorageServiceImpl#getFileFromLocalRepository(String)}.
   * <p>
   * Method under test:
   * {@link StaticAssetStorageServiceImpl#getFileFromLocalRepository(String)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetFileFromLocalRepository() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.file.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-applicationContext-entity.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass8936 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.file.service.StaticAssetStorageServiceImpl staticAssetStorageServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new StaticAssetStorageServiceImpl()).getFileFromLocalRepository("foo.txt");
  }

  /**
   * Test
   * {@link StaticAssetStorageServiceImpl#lookupAssetAndCreateLocalFile(StaticAsset, File)}.
   * <p>
   * Method under test:
   * {@link StaticAssetStorageServiceImpl#lookupAssetAndCreateLocalFile(StaticAsset, File)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testLookupAssetAndCreateLocalFile() throws IOException, SQLException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.file.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-applicationContext-entity.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass9877 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.file.service.StaticAssetStorageServiceImpl staticAssetStorageServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    StaticAssetStorageServiceImpl staticAssetStorageServiceImpl2 = new StaticAssetStorageServiceImpl();
    ImageStaticAssetImpl staticAsset = new ImageStaticAssetImpl();

    // Act
    staticAssetStorageServiceImpl2.lookupAssetAndCreateLocalFile(staticAsset,
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());
  }

  /**
   * Test
   * {@link StaticAssetStorageServiceImpl#createLocalFileFromClassPathResource(StaticAsset, File)}.
   * <p>
   * Method under test:
   * {@link StaticAssetStorageServiceImpl#createLocalFileFromClassPathResource(StaticAsset, File)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCreateLocalFileFromClassPathResource() throws IOException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.file.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-applicationContext-entity.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass7967 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.file.service.StaticAssetStorageServiceImpl staticAssetStorageServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    StaticAssetStorageServiceImpl staticAssetStorageServiceImpl2 = new StaticAssetStorageServiceImpl();
    ImageStaticAssetImpl staticAsset = new ImageStaticAssetImpl();

    // Act
    staticAssetStorageServiceImpl2.createLocalFileFromClassPathResource(staticAsset,
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());
  }

  /**
   * Test
   * {@link StaticAssetStorageServiceImpl#createLocalFileFromInputStream(InputStream, File)}.
   * <p>
   * Method under test:
   * {@link StaticAssetStorageServiceImpl#createLocalFileFromInputStream(InputStream, File)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCreateLocalFileFromInputStream() throws IOException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.file.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-applicationContext-entity.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass7996 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.file.service.StaticAssetStorageServiceImpl staticAssetStorageServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    StaticAssetStorageServiceImpl staticAssetStorageServiceImpl2 = new StaticAssetStorageServiceImpl();
    ByteArrayInputStream is = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));

    // Act
    staticAssetStorageServiceImpl2.createLocalFileFromInputStream(is,
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());
  }

  /**
   * Test {@link StaticAssetStorageServiceImpl#getCacheFileModel(String, Map)}.
   * <p>
   * Method under test:
   * {@link StaticAssetStorageServiceImpl#getCacheFileModel(String, Map)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetCacheFileModel() throws Exception {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.file.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-applicationContext-entity.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass8603 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.file.service.StaticAssetStorageServiceImpl staticAssetStorageServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    StaticAssetStorageServiceImpl staticAssetStorageServiceImpl2 = new StaticAssetStorageServiceImpl();

    // Act
    staticAssetStorageServiceImpl2.getCacheFileModel("https://example.org/example", new HashMap<>());
  }

  /**
   * Test {@link StaticAssetStorageServiceImpl#shouldRecompress(String)}.
   * <p>
   * Method under test:
   * {@link StaticAssetStorageServiceImpl#shouldRecompress(String)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testShouldRecompress() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.file.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-applicationContext-entity.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass9955 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.file.service.StaticAssetStorageServiceImpl staticAssetStorageServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new StaticAssetStorageServiceImpl()).shouldRecompress("Mime Type");
  }

  /**
   * Test {@link StaticAssetStorageServiceImpl#buildModel(String, String)}.
   * <p>
   * Method under test:
   * {@link StaticAssetStorageServiceImpl#buildModel(String, String)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testBuildModel2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.file.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-applicationContext-entity.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass7757 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.file.service.StaticAssetStorageServiceImpl staticAssetStorageServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new StaticAssetStorageServiceImpl()).buildModel("/directory/foo.txt", "Mime Type");
  }

  /**
   * Test {@link StaticAssetStorageServiceImpl#findStaticAssetStorageById(Long)}.
   * <p>
   * Method under test:
   * {@link StaticAssetStorageServiceImpl#findStaticAssetStorageById(Long)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testFindStaticAssetStorageById() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.file.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-applicationContext-entity.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass8587 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.file.service.StaticAssetStorageServiceImpl staticAssetStorageServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new StaticAssetStorageServiceImpl()).findStaticAssetStorageById(1L);
  }

  /**
   * Test {@link StaticAssetStorageServiceImpl#create()}.
   * <p>
   * Method under test: {@link StaticAssetStorageServiceImpl#create()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCreate() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.file.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-applicationContext-entity.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass7810 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.file.service.StaticAssetStorageServiceImpl staticAssetStorageServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new StaticAssetStorageServiceImpl()).create();
  }

  /**
   * Test
   * {@link StaticAssetStorageServiceImpl#readStaticAssetStorageByStaticAssetId(Long)}.
   * <p>
   * Method under test:
   * {@link StaticAssetStorageServiceImpl#readStaticAssetStorageByStaticAssetId(Long)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testReadStaticAssetStorageByStaticAssetId() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.file.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-applicationContext-entity.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass9932 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.file.service.StaticAssetStorageServiceImpl staticAssetStorageServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new StaticAssetStorageServiceImpl()).readStaticAssetStorageByStaticAssetId(1L);
  }

  /**
   * Test {@link StaticAssetStorageServiceImpl#save(StaticAssetStorage)}.
   * <p>
   * Method under test:
   * {@link StaticAssetStorageServiceImpl#save(StaticAssetStorage)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testSave() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.file.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-applicationContext-entity.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass9947 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.file.service.StaticAssetStorageServiceImpl staticAssetStorageServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    StaticAssetStorageServiceImpl staticAssetStorageServiceImpl2 = new StaticAssetStorageServiceImpl();

    // Act
    staticAssetStorageServiceImpl2.save(new StaticAssetStorageImpl());
  }

  /**
   * Test {@link StaticAssetStorageServiceImpl#delete(StaticAssetStorage)}.
   * <p>
   * Method under test:
   * {@link StaticAssetStorageServiceImpl#delete(StaticAssetStorage)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testDelete() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.file.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-applicationContext-entity.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass8266 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.file.service.StaticAssetStorageServiceImpl staticAssetStorageServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    StaticAssetStorageServiceImpl staticAssetStorageServiceImpl2 = new StaticAssetStorageServiceImpl();

    // Act
    staticAssetStorageServiceImpl2.delete(new StaticAssetStorageImpl());
  }

  /**
   * Test {@link StaticAssetStorageServiceImpl#createBlob(MultipartFile)} with
   * {@code uploadedFile}.
   * <p>
   * Method under test:
   * {@link StaticAssetStorageServiceImpl#createBlob(MultipartFile)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCreateBlobWithUploadedFile() throws IOException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.file.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-applicationContext-entity.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass7886 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.file.service.StaticAssetStorageServiceImpl staticAssetStorageServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    StaticAssetStorageServiceImpl staticAssetStorageServiceImpl2 = new StaticAssetStorageServiceImpl();

    // Act
    staticAssetStorageServiceImpl2
        .createBlob(new MockMultipartFile("Name", new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));
  }

  /**
   * Test {@link StaticAssetStorageServiceImpl#createBlob(InputStream, long)} with
   * {@code uploadedFileInputStream}, {@code fileSize}.
   * <p>
   * Method under test:
   * {@link StaticAssetStorageServiceImpl#createBlob(InputStream, long)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCreateBlobWithUploadedFileInputStreamFileSize() throws IOException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.file.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-applicationContext-entity.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass7811 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.file.service.StaticAssetStorageServiceImpl staticAssetStorageServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    StaticAssetStorageServiceImpl staticAssetStorageServiceImpl2 = new StaticAssetStorageServiceImpl();

    // Act
    staticAssetStorageServiceImpl2.createBlob(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")), 3L);
  }

  /**
   * Test
   * {@link StaticAssetStorageServiceImpl#constructCacheFileName(StaticAsset, Map)}.
   * <p>
   * Method under test:
   * {@link StaticAssetStorageServiceImpl#constructCacheFileName(StaticAsset, Map)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testConstructCacheFileName4() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.file.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-applicationContext-entity.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass7781 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.file.service.StaticAssetStorageServiceImpl staticAssetStorageServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    StaticAssetStorageServiceImpl staticAssetStorageServiceImpl2 = new StaticAssetStorageServiceImpl();
    ImageStaticAssetImpl staticAsset = new ImageStaticAssetImpl();

    // Act
    staticAssetStorageServiceImpl2.constructCacheFileName(staticAsset, new HashMap<>());
  }

  /**
   * Test {@link StaticAssetStorageServiceImpl#pad(String, int, char)}.
   * <p>
   * Method under test:
   * {@link StaticAssetStorageServiceImpl#pad(String, int, char)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testPad() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.file.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-applicationContext-entity.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass9906 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.file.service.StaticAssetStorageServiceImpl staticAssetStorageServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new StaticAssetStorageServiceImpl()).pad("foo", 3, 'A');
  }

  /**
   * Test
   * {@link StaticAssetStorageServiceImpl#createStaticAssetStorageFromFile(MultipartFile, StaticAsset)}.
   * <p>
   * Method under test:
   * {@link StaticAssetStorageServiceImpl#createStaticAssetStorageFromFile(MultipartFile, StaticAsset)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCreateStaticAssetStorageFromFile() throws IOException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.file.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-applicationContext-entity.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass8164 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.file.service.StaticAssetStorageServiceImpl staticAssetStorageServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    StaticAssetStorageServiceImpl staticAssetStorageServiceImpl2 = new StaticAssetStorageServiceImpl();
    MockMultipartFile file = new MockMultipartFile("Name", new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));

    // Act
    staticAssetStorageServiceImpl2.createStaticAssetStorageFromFile(file, new ImageStaticAssetImpl());
  }

  /**
   * Test
   * {@link StaticAssetStorageServiceImpl#createStaticAssetStorage(InputStream, StaticAsset)}.
   * <p>
   * Method under test:
   * {@link StaticAssetStorageServiceImpl#createStaticAssetStorage(InputStream, StaticAsset)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCreateStaticAssetStorage() throws IOException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.file.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-applicationContext-entity.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass8073 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.file.service.StaticAssetStorageServiceImpl staticAssetStorageServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    StaticAssetStorageServiceImpl staticAssetStorageServiceImpl2 = new StaticAssetStorageServiceImpl();
    ByteArrayInputStream fileInputStream = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));

    // Act
    staticAssetStorageServiceImpl2.createStaticAssetStorage(fileInputStream, new ImageStaticAssetImpl());
  }

  /**
   * Test {@link StaticAssetStorageServiceImpl#getMaxUploadSizeForFile(String)}.
   * <p>
   * Method under test:
   * {@link StaticAssetStorageServiceImpl#getMaxUploadSizeForFile(String)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetMaxUploadSizeForFile() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.file.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-applicationContext-entity.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass9249 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.file.service.StaticAssetStorageServiceImpl staticAssetStorageServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new StaticAssetStorageServiceImpl()).getMaxUploadSizeForFile("foo.txt");
  }

  /**
   * Test {@link StaticAssetStorageServiceImpl#isImageFile(String)}.
   * <p>
   * Method under test: {@link StaticAssetStorageServiceImpl#isImageFile(String)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testIsImageFile() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.file.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-applicationContext-entity.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass9564 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.file.service.StaticAssetStorageServiceImpl staticAssetStorageServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new StaticAssetStorageServiceImpl()).isImageFile("foo.txt");
  }

  /**
   * Test {@link StaticAssetStorageServiceImpl#getFileExtension(String)}.
   * <p>
   * Method under test:
   * {@link StaticAssetStorageServiceImpl#getFileExtension(String)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetFileExtension2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.file.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-applicationContext-entity.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass8624 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.file.service.StaticAssetStorageServiceImpl staticAssetStorageServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new StaticAssetStorageServiceImpl()).getFileExtension("Asset Path");
  }

  /**
   * Test {@link StaticAssetStorageServiceImpl#getMaxUploadableFileSize()}.
   * <p>
   * Method under test:
   * {@link StaticAssetStorageServiceImpl#getMaxUploadableFileSize()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetMaxUploadableFileSize() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.file.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-applicationContext-entity.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass9562 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.file.service.StaticAssetStorageServiceImpl staticAssetStorageServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new StaticAssetStorageServiceImpl()).getMaxUploadableFileSize();
  }

  /**
   * Test {@link StaticAssetStorageServiceImpl#getMaxUploadableImageSize()}.
   * <p>
   * Method under test:
   * {@link StaticAssetStorageServiceImpl#getMaxUploadableImageSize()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetMaxUploadableImageSize() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.file.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-applicationContext-entity.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass9563 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.file.service.StaticAssetStorageServiceImpl staticAssetStorageServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new StaticAssetStorageServiceImpl()).getMaxUploadableImageSize();
  }

  /**
   * Test {@link StaticAssetStorageServiceImpl#getFileBufferSize()}.
   * <p>
   * Method under test: {@link StaticAssetStorageServiceImpl#getFileBufferSize()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetFileBufferSize() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.file.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-applicationContext-entity.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass8623 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.file.service.StaticAssetStorageServiceImpl staticAssetStorageServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new StaticAssetStorageServiceImpl()).getFileBufferSize();
  }

  /**
   * Test {@link StaticAssetStorageServiceImpl#getAdminImageFileExtensions()}.
   * <p>
   * Method under test:
   * {@link StaticAssetStorageServiceImpl#getAdminImageFileExtensions()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetAdminImageFileExtensions() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.file.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-applicationContext-entity.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass8602 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.file.service.StaticAssetStorageServiceImpl staticAssetStorageServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new StaticAssetStorageServiceImpl()).getAdminImageFileExtensions();
  }

  /**
   * Test {@link StaticAssetStorageServiceImpl#validateFileSize(MultipartFile)}.
   * <p>
   * Method under test:
   * {@link StaticAssetStorageServiceImpl#validateFileSize(MultipartFile)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testValidateFileSize() throws IOException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.file.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-applicationContext-entity.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass10337 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.file.service.StaticAssetStorageServiceImpl staticAssetStorageServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    StaticAssetStorageServiceImpl staticAssetStorageServiceImpl2 = new StaticAssetStorageServiceImpl();

    // Act
    staticAssetStorageServiceImpl2
        .validateFileSize(new MockMultipartFile("Name", new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));
  }
}
