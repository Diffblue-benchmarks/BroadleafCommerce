package org.broadleafcommerce.cms.file.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import org.broadleafcommerce.cms.field.type.StorageType;
import org.broadleafcommerce.cms.file.domain.ImageStaticAssetImpl;
import org.broadleafcommerce.cms.file.domain.StaticAsset;
import org.broadleafcommerce.cms.file.domain.StaticAssetImpl;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.multipart.MultipartFile;

@ContextConfiguration(locations = {"/applicationContext-servlet-cms-contentClient.xml",
    "/applicationContext-servlet-cms-contentCreator.xml", "/bl-cms-applicationContext-entity.xml",
    "/bl-cms-contentClient-applicationContext.xml", "/bl-cms-contentCreator-applicationContext.xml",
    "/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml",
    "/blc-config/admin/framework/bl-cms-admin-applicationContext.xml",
    "/blc-config/site/framework/bl-cms-applicationContext-servlet.xml",
    "/blc-config/site/framework/bl-cms-applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class StaticAssetServiceImplDiffblueTest {
  @Autowired
  private StaticAssetServiceImpl staticAssetServiceImpl;

  /**
   * Test {@link StaticAssetServiceImpl#findStaticAssetById(Long)}.
   * <p>
   * Method under test: {@link StaticAssetServiceImpl#findStaticAssetById(Long)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testFindStaticAssetById() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.file.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-applicationContext-entity.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass6511 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.file.service.StaticAssetServiceImpl staticAssetServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new StaticAssetServiceImpl()).findStaticAssetById(1L);
  }

  /**
   * Test {@link StaticAssetServiceImpl#readAllStaticAssets()}.
   * <p>
   * Method under test: {@link StaticAssetServiceImpl#readAllStaticAssets()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testReadAllStaticAssets() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.file.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-applicationContext-entity.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass7324 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.file.service.StaticAssetServiceImpl staticAssetServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new StaticAssetServiceImpl()).readAllStaticAssets();
  }

  /**
   * Test {@link StaticAssetServiceImpl#findTotalStaticAssetCount()}.
   * <p>
   * Method under test: {@link StaticAssetServiceImpl#findTotalStaticAssetCount()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testFindTotalStaticAssetCount() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.file.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-applicationContext-entity.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass6530 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.file.service.StaticAssetServiceImpl staticAssetServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new StaticAssetServiceImpl()).findTotalStaticAssetCount();
  }

  /**
   * Test {@link StaticAssetServiceImpl#getFileExtension(String)} with
   * {@code fileName}.
   * <p>
   * Method under test: {@link StaticAssetServiceImpl#getFileExtension(String)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetFileExtensionWithFileName() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.file.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-applicationContext-entity.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass6568 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.file.service.StaticAssetServiceImpl staticAssetServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new StaticAssetServiceImpl()).getFileExtension("foo.txt");
  }

  /**
   * Test {@link StaticAssetServiceImpl#getFileExtension(String)} with
   * {@code fileName}.
   * <ul>
   *   <li>When {@code .}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StaticAssetServiceImpl#getFileExtension(String)}
   */
  @Test
  public void testGetFileExtensionWithFileName_whenDot_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new StaticAssetServiceImpl()).getFileExtension("."));
  }

  /**
   * Test {@link StaticAssetServiceImpl#getFileExtension(String)} with
   * {@code fileName}.
   * <ul>
   *   <li>When {@code File Name}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StaticAssetServiceImpl#getFileExtension(String)}
   */
  @Test
  public void testGetFileExtensionWithFileName_whenFileName_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new StaticAssetServiceImpl()).getFileExtension("File Name"));
  }

  /**
   * Test {@link StaticAssetServiceImpl#getFileExtension(String)} with
   * {@code fileName}.
   * <ul>
   *   <li>When {@code foo.txt}.</li>
   *   <li>Then return {@code txt}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StaticAssetServiceImpl#getFileExtension(String)}
   */
  @Test
  public void testGetFileExtensionWithFileName_whenFooTxt_thenReturnTxt() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("txt", (new StaticAssetServiceImpl()).getFileExtension("foo.txt"));
  }

  /**
   * Test {@link StaticAssetServiceImpl#validateFileExtension(MultipartFile)}.
   * <p>
   * Method under test:
   * {@link StaticAssetServiceImpl#validateFileExtension(MultipartFile)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testValidateFileExtension() throws IOException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.file.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-applicationContext-entity.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass7355 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.file.service.StaticAssetServiceImpl staticAssetServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    StaticAssetServiceImpl staticAssetServiceImpl2 = new StaticAssetServiceImpl();

    // Act
    staticAssetServiceImpl2
        .validateFileExtension(new MockMultipartFile("Name", new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));
  }

  /**
   * Test {@link StaticAssetServiceImpl#generateFileName(int)}.
   * <p>
   * Method under test: {@link StaticAssetServiceImpl#generateFileName(int)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGenerateFileName() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.file.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-applicationContext-entity.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass6535 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.file.service.StaticAssetServiceImpl staticAssetServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new StaticAssetServiceImpl()).generateFileName(3);
  }

  /**
   * Test {@link StaticAssetServiceImpl#buildAssetURL(Map, String)}.
   * <p>
   * Method under test: {@link StaticAssetServiceImpl#buildAssetURL(Map, String)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testBuildAssetURL() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.file.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-applicationContext-entity.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass5832 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.file.service.StaticAssetServiceImpl staticAssetServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    StaticAssetServiceImpl staticAssetServiceImpl2 = new StaticAssetServiceImpl();

    // Act
    staticAssetServiceImpl2.buildAssetURL(new HashMap<>(), "https://example.org/example");
  }

  /**
   * Test {@link StaticAssetServiceImpl#buildAssetURL(Map, String)}.
   * <ul>
   *   <li>Given {@link BiFunction}.</li>
   *   <li>When {@link HashMap#HashMap()} computeIfPresent {@code /} and
   * {@link BiFunction}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StaticAssetServiceImpl#buildAssetURL(Map, String)}
   */
  @Test
  public void testBuildAssetURL_givenBiFunction_whenHashMapComputeIfPresentSlashAndBiFunction() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StaticAssetServiceImpl staticAssetServiceImpl = new StaticAssetServiceImpl();

    HashMap<String, String> assetProperties = new HashMap<>();
    assetProperties.computeIfPresent("/", mock(BiFunction.class));

    // Act and Assert
    assertEquals("/https://example.org/example",
        staticAssetServiceImpl.buildAssetURL(assetProperties, "https://example.org/example"));
  }

  /**
   * Test {@link StaticAssetServiceImpl#buildAssetURL(Map, String)}.
   * <ul>
   *   <li>Given {@code /}.</li>
   *   <li>When {@link HashMap#HashMap()} {@code fileName} is {@code /}.</li>
   *   <li>Then return {@code //}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StaticAssetServiceImpl#buildAssetURL(Map, String)}
   */
  @Test
  public void testBuildAssetURL_givenSlash_whenHashMapFileNameIsSlash_thenReturnSlashSlash() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StaticAssetServiceImpl staticAssetServiceImpl = new StaticAssetServiceImpl();

    HashMap<String, String> assetProperties = new HashMap<>();
    assetProperties.put("entityType", null);
    assetProperties.put("entityId", null);
    assetProperties.put("fileName", "/");

    // Act and Assert
    assertEquals("//", staticAssetServiceImpl.buildAssetURL(assetProperties, "https://example.org/example"));
  }

  /**
   * Test {@link StaticAssetServiceImpl#buildAssetURL(Map, String)}.
   * <ul>
   *   <li>Then return {@code ///example.org/example}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StaticAssetServiceImpl#buildAssetURL(Map, String)}
   */
  @Test
  public void testBuildAssetURL_thenReturnExampleOrgExample() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StaticAssetServiceImpl staticAssetServiceImpl = new StaticAssetServiceImpl();

    HashMap<String, String> assetProperties = new HashMap<>();
    assetProperties.put("entityType", null);
    assetProperties.put("entityId", null);
    assetProperties.put("fileName", "https://example.org/example");

    // Act and Assert
    assertEquals("///example.org/example",
        staticAssetServiceImpl.buildAssetURL(assetProperties, "https://example.org/example"));
  }

  /**
   * Test {@link StaticAssetServiceImpl#buildAssetURL(Map, String)}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()} {@code entityId} is
   * {@code https://example.org/example}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StaticAssetServiceImpl#buildAssetURL(Map, String)}
   */
  @Test
  public void testBuildAssetURL_whenHashMapEntityIdIsHttpsExampleOrgExample() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StaticAssetServiceImpl staticAssetServiceImpl = new StaticAssetServiceImpl();

    HashMap<String, String> assetProperties = new HashMap<>();
    assetProperties.put("entityType", null);
    assetProperties.put("entityId", "https://example.org/example");
    assetProperties.put("fileName", null);

    // Act and Assert
    assertEquals("/https://example.org/example/https://example.org/example",
        staticAssetServiceImpl.buildAssetURL(assetProperties, "https://example.org/example"));
  }

  /**
   * Test {@link StaticAssetServiceImpl#buildAssetURL(Map, String)}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()} {@code entityType} is
   * {@code https://example.org/example}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StaticAssetServiceImpl#buildAssetURL(Map, String)}
   */
  @Test
  public void testBuildAssetURL_whenHashMapEntityTypeIsHttpsExampleOrgExample() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StaticAssetServiceImpl staticAssetServiceImpl = new StaticAssetServiceImpl();

    HashMap<String, String> assetProperties = new HashMap<>();
    assetProperties.put("entityType", "https://example.org/example");
    assetProperties.put("entityId", null);
    assetProperties.put("fileName", null);

    // Act and Assert
    assertEquals("/https://example.org/example/https://example.org/example",
        staticAssetServiceImpl.buildAssetURL(assetProperties, "https://example.org/example"));
  }

  /**
   * Test {@link StaticAssetServiceImpl#buildAssetURL(Map, String)}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()} {@code fileName} is {@code null}.</li>
   *   <li>Then return {@code /https://example.org/example}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StaticAssetServiceImpl#buildAssetURL(Map, String)}
   */
  @Test
  public void testBuildAssetURL_whenHashMapFileNameIsNull_thenReturnHttpsExampleOrgExample() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StaticAssetServiceImpl staticAssetServiceImpl = new StaticAssetServiceImpl();

    HashMap<String, String> assetProperties = new HashMap<>();
    assetProperties.put("entityType", null);
    assetProperties.put("entityId", "null");
    assetProperties.put("fileName", null);

    // Act and Assert
    assertEquals("/https://example.org/example",
        staticAssetServiceImpl.buildAssetURL(assetProperties, "https://example.org/example"));
  }

  /**
   * Test {@link StaticAssetServiceImpl#buildAssetURL(Map, String)}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()} {@code fileName} is {@code null}.</li>
   *   <li>Then return {@code /https://example.org/example}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StaticAssetServiceImpl#buildAssetURL(Map, String)}
   */
  @Test
  public void testBuildAssetURL_whenHashMapFileNameIsNull_thenReturnHttpsExampleOrgExample2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StaticAssetServiceImpl staticAssetServiceImpl = new StaticAssetServiceImpl();

    HashMap<String, String> assetProperties = new HashMap<>();
    assetProperties.put("entityType", "null");
    assetProperties.put("entityId", null);
    assetProperties.put("fileName", null);

    // Act and Assert
    assertEquals("/https://example.org/example",
        staticAssetServiceImpl.buildAssetURL(assetProperties, "https://example.org/example"));
  }

  /**
   * Test {@link StaticAssetServiceImpl#buildAssetURL(Map, String)}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.</li>
   *   <li>Then return {@code /https://example.org/example}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StaticAssetServiceImpl#buildAssetURL(Map, String)}
   */
  @Test
  public void testBuildAssetURL_whenHashMap_thenReturnHttpsExampleOrgExample() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StaticAssetServiceImpl staticAssetServiceImpl = new StaticAssetServiceImpl();

    // Act and Assert
    assertEquals("/https://example.org/example",
        staticAssetServiceImpl.buildAssetURL(new HashMap<>(), "https://example.org/example"));
  }

  /**
   * Test
   * {@link StaticAssetServiceImpl#createStaticAssetFromFile(MultipartFile, Map)}.
   * <p>
   * Method under test:
   * {@link StaticAssetServiceImpl#createStaticAssetFromFile(MultipartFile, Map)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCreateStaticAssetFromFile() throws IOException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.file.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-applicationContext-entity.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass6076 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.file.service.StaticAssetServiceImpl staticAssetServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    StaticAssetServiceImpl staticAssetServiceImpl2 = new StaticAssetServiceImpl();
    MockMultipartFile file = new MockMultipartFile("Name", new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));

    // Act
    staticAssetServiceImpl2.createStaticAssetFromFile(file, new HashMap<>());
  }

  /**
   * Test {@link StaticAssetServiceImpl#validateFileName(String)}.
   * <p>
   * Method under test: {@link StaticAssetServiceImpl#validateFileName(String)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testValidateFileName() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.file.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-applicationContext-entity.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass7440 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.file.service.StaticAssetServiceImpl staticAssetServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new StaticAssetServiceImpl()).validateFileName("foo.txt");
  }

  /**
   * Test {@link StaticAssetServiceImpl#validateFileName(String)}.
   * <ul>
   *   <li>When empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link StaticAssetServiceImpl#validateFileName(String)}
   */
  @Test
  public void testValidateFileName_whenEmptyString() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new StaticAssetServiceImpl()).validateFileName(""));
  }

  /**
   * Test {@link StaticAssetServiceImpl#validateFileName(String)}.
   * <ul>
   *   <li>When {@code foo.txt}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StaticAssetServiceImpl#validateFileName(String)}
   */
  @Test
  public void testValidateFileName_whenFooTxt() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new StaticAssetServiceImpl()).validateFileName("foo.txt"));
  }

  /**
   * Test
   * {@link StaticAssetServiceImpl#createStaticAsset(InputStream, String, long, Map)}.
   * <p>
   * Method under test:
   * {@link StaticAssetServiceImpl#createStaticAsset(InputStream, String, long, Map)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCreateStaticAsset() throws UnsupportedEncodingException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.file.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-applicationContext-entity.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass5978 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.file.service.StaticAssetServiceImpl staticAssetServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    StaticAssetServiceImpl staticAssetServiceImpl2 = new StaticAssetServiceImpl();
    ByteArrayInputStream inputStream = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));

    // Act
    staticAssetServiceImpl2.createStaticAsset(inputStream, "foo.txt", 3L, new HashMap<>());
  }

  /**
   * Test
   * {@link StaticAssetServiceImpl#createNonImageAsset(InputStream, String, Map)}.
   * <p>
   * Method under test:
   * {@link StaticAssetServiceImpl#createNonImageAsset(InputStream, String, Map)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCreateNonImageAsset() throws UnsupportedEncodingException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.file.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-applicationContext-entity.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass5885 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.file.service.StaticAssetServiceImpl staticAssetServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    StaticAssetServiceImpl staticAssetServiceImpl2 = new StaticAssetServiceImpl();
    ByteArrayInputStream inputStream = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));

    // Act
    staticAssetServiceImpl2.createNonImageAsset(inputStream, "foo.txt", new HashMap<>());
  }

  /**
   * Test
   * {@link StaticAssetServiceImpl#createNonImageAsset(InputStream, String, Map)}.
   * <ul>
   *   <li>When {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with
   * {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link StaticAssetServiceImpl#createNonImageAsset(InputStream, String, Map)}
   */
  @Test
  public void testCreateNonImageAsset_whenByteArrayInputStreamWithAxaxaxaxBytesIsUtf8()
      throws UnsupportedEncodingException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StaticAssetServiceImpl staticAssetServiceImpl = new StaticAssetServiceImpl();
    ByteArrayInputStream inputStream = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));

    // Act
    StaticAsset actualCreateNonImageAssetResult = staticAssetServiceImpl.createNonImageAsset(inputStream, "foo.txt",
        new HashMap<>());

    // Assert
    assertTrue(actualCreateNonImageAssetResult instanceof StaticAssetImpl);
    StorageType storageType = actualCreateNonImageAssetResult.getStorageType();
    assertEquals("DATABASE", storageType.getType());
    assertEquals("Database", storageType.getFriendlyType());
    assertNull(actualCreateNonImageAssetResult.getFileSize());
    assertNull(actualCreateNonImageAssetResult.getId());
    assertNull(actualCreateNonImageAssetResult.getAltText());
    assertNull(actualCreateNonImageAssetResult.getFileExtension());
    assertNull(actualCreateNonImageAssetResult.getFullUrl());
    assertNull(actualCreateNonImageAssetResult.getMimeType());
    assertNull(actualCreateNonImageAssetResult.getName());
    assertNull(actualCreateNonImageAssetResult.getTitle());
    assertNull(((StaticAssetImpl) actualCreateNonImageAssetResult).getMainEntityName());
    assertTrue(actualCreateNonImageAssetResult.getContentMessageValues().isEmpty());
  }

  /**
   * Test
   * {@link StaticAssetServiceImpl#createNonImageAsset(InputStream, String, Map)}.
   * <ul>
   *   <li>When {@link DataInputStream}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link StaticAssetServiceImpl#createNonImageAsset(InputStream, String, Map)}
   */
  @Test
  public void testCreateNonImageAsset_whenDataInputStream() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StaticAssetServiceImpl staticAssetServiceImpl = new StaticAssetServiceImpl();
    DataInputStream inputStream = mock(DataInputStream.class);

    // Act
    StaticAsset actualCreateNonImageAssetResult = staticAssetServiceImpl.createNonImageAsset(inputStream, "foo.txt",
        new HashMap<>());

    // Assert
    assertTrue(actualCreateNonImageAssetResult instanceof StaticAssetImpl);
    StorageType storageType = actualCreateNonImageAssetResult.getStorageType();
    assertEquals("DATABASE", storageType.getType());
    assertEquals("Database", storageType.getFriendlyType());
    assertNull(actualCreateNonImageAssetResult.getFileSize());
    assertNull(actualCreateNonImageAssetResult.getId());
    assertNull(actualCreateNonImageAssetResult.getAltText());
    assertNull(actualCreateNonImageAssetResult.getFileExtension());
    assertNull(actualCreateNonImageAssetResult.getFullUrl());
    assertNull(actualCreateNonImageAssetResult.getMimeType());
    assertNull(actualCreateNonImageAssetResult.getName());
    assertNull(actualCreateNonImageAssetResult.getTitle());
    assertNull(((StaticAssetImpl) actualCreateNonImageAssetResult).getMainEntityName());
    assertTrue(actualCreateNonImageAssetResult.getContentMessageValues().isEmpty());
  }

  /**
   * Test {@link StaticAssetServiceImpl#getCountUrl(String, int, boolean)}.
   * <p>
   * Method under test:
   * {@link StaticAssetServiceImpl#getCountUrl(String, int, boolean)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetCountUrl() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.file.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-applicationContext-entity.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass6545 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.file.service.StaticAssetServiceImpl staticAssetServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new StaticAssetServiceImpl()).getCountUrl("https://example.org/example", 3, true);
  }

  /**
   * Test {@link StaticAssetServiceImpl#getCountUrl(String, int, boolean)}.
   * <ul>
   *   <li>When {@code false}.</li>
   *   <li>Then return {@code https://example-3.org/example}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link StaticAssetServiceImpl#getCountUrl(String, int, boolean)}
   */
  @Test
  public void testGetCountUrl_whenFalse_thenReturnHttpsExample3OrgExample() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("https://example-3.org/example",
        (new StaticAssetServiceImpl()).getCountUrl("https://example.org/example", 3, false));
  }

  /**
   * Test {@link StaticAssetServiceImpl#getCountUrl(String, int, boolean)}.
   * <ul>
   *   <li>When {@code Full Url}.</li>
   *   <li>Then return {@code Full Url-3}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link StaticAssetServiceImpl#getCountUrl(String, int, boolean)}
   */
  @Test
  public void testGetCountUrl_whenFullUrl_thenReturnFullUrl3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("Full Url-3", (new StaticAssetServiceImpl()).getCountUrl("Full Url", 3, true));
  }

  /**
   * Test {@link StaticAssetServiceImpl#getCountUrl(String, int, boolean)}.
   * <ul>
   *   <li>When {@code https://example.org/example}.</li>
   *   <li>Then return {@code https://example.org/example-3}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link StaticAssetServiceImpl#getCountUrl(String, int, boolean)}
   */
  @Test
  public void testGetCountUrl_whenHttpsExampleOrgExample_thenReturnHttpsExampleOrgExample3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("https://example.org/example-3",
        (new StaticAssetServiceImpl()).getCountUrl("https://example.org/example", 3, true));
  }

  /**
   * Test
   * {@link StaticAssetServiceImpl#getMimeType(InputStream, String, StaticAsset)}.
   * <p>
   * Method under test:
   * {@link StaticAssetServiceImpl#getMimeType(InputStream, String, StaticAsset)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetMimeType() throws UnsupportedEncodingException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.file.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-applicationContext-entity.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass6885 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.file.service.StaticAssetServiceImpl staticAssetServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    StaticAssetServiceImpl staticAssetServiceImpl2 = new StaticAssetServiceImpl();
    ByteArrayInputStream inputStream = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));

    // Act
    staticAssetServiceImpl2.getMimeType(inputStream, "foo.txt", new ImageStaticAssetImpl());
  }

  /**
   * Test
   * {@link StaticAssetServiceImpl#getMimeType(InputStream, String, StaticAsset)}.
   * <ul>
   *   <li>When {@link DataInputStream}.</li>
   *   <li>Then {@link ImageStaticAssetImpl} (default constructor) MimeType is
   * {@code text/plain}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link StaticAssetServiceImpl#getMimeType(InputStream, String, StaticAsset)}
   */
  @Test
  public void testGetMimeType_whenDataInputStream_thenImageStaticAssetImplMimeTypeIsTextPlain() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StaticAssetServiceImpl staticAssetServiceImpl = new StaticAssetServiceImpl();
    DataInputStream inputStream = mock(DataInputStream.class);
    ImageStaticAssetImpl newAsset = new ImageStaticAssetImpl();

    // Act
    staticAssetServiceImpl.getMimeType(inputStream, "foo.txt", newAsset);

    // Assert
    assertEquals("text/plain", newAsset.getMimeType());
  }

  /**
   * Test
   * {@link StaticAssetServiceImpl#getMimeType(InputStream, String, StaticAsset)}.
   * <ul>
   *   <li>When {@code File Name}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link StaticAssetServiceImpl#getMimeType(InputStream, String, StaticAsset)}
   */
  @Test
  public void testGetMimeType_whenFileName() throws UnsupportedEncodingException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StaticAssetServiceImpl staticAssetServiceImpl = new StaticAssetServiceImpl();
    ByteArrayInputStream inputStream = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));
    ImageStaticAssetImpl newAsset = new ImageStaticAssetImpl();

    // Act
    staticAssetServiceImpl.getMimeType(inputStream, "File Name", newAsset);

    // Assert
    assertEquals("application/octet-stream", newAsset.getMimeType());
  }

  /**
   * Test
   * {@link StaticAssetServiceImpl#getMimeType(InputStream, String, StaticAsset)}.
   * <ul>
   *   <li>When {@code foo.txt}.</li>
   *   <li>Then {@link ImageStaticAssetImpl} (default constructor) MimeType is
   * {@code text/plain}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link StaticAssetServiceImpl#getMimeType(InputStream, String, StaticAsset)}
   */
  @Test
  public void testGetMimeType_whenFooTxt_thenImageStaticAssetImplMimeTypeIsTextPlain()
      throws UnsupportedEncodingException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StaticAssetServiceImpl staticAssetServiceImpl = new StaticAssetServiceImpl();
    ByteArrayInputStream inputStream = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));
    ImageStaticAssetImpl newAsset = new ImageStaticAssetImpl();

    // Act
    staticAssetServiceImpl.getMimeType(inputStream, "foo.txt", newAsset);

    // Assert
    assertEquals("text/plain", newAsset.getMimeType());
  }

  /**
   * Test
   * {@link StaticAssetServiceImpl#getMimeType(InputStream, String, StaticAsset)}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link StaticAssetServiceImpl#getMimeType(InputStream, String, StaticAsset)}
   */
  @Test
  public void testGetMimeType_whenNull() throws UnsupportedEncodingException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StaticAssetServiceImpl staticAssetServiceImpl = new StaticAssetServiceImpl();
    ByteArrayInputStream inputStream = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));
    ImageStaticAssetImpl newAsset = new ImageStaticAssetImpl();

    // Act
    staticAssetServiceImpl.getMimeType(inputStream, null, newAsset);

    // Assert
    assertEquals("application/octet-stream", newAsset.getMimeType());
  }

  /**
   * Test
   * {@link StaticAssetServiceImpl#getMimeType(InputStream, String, StaticAsset)}.
   * <ul>
   *   <li>When {@code /}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link StaticAssetServiceImpl#getMimeType(InputStream, String, StaticAsset)}
   */
  @Test
  public void testGetMimeType_whenSlash() throws UnsupportedEncodingException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StaticAssetServiceImpl staticAssetServiceImpl = new StaticAssetServiceImpl();
    ByteArrayInputStream inputStream = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));
    ImageStaticAssetImpl newAsset = new ImageStaticAssetImpl();

    // Act
    staticAssetServiceImpl.getMimeType(inputStream, "/", newAsset);

    // Assert
    assertEquals("application/octet-stream", newAsset.getMimeType());
  }

  /**
   * Test {@link StaticAssetServiceImpl#findStaticAssetByFullUrl(String)}.
   * <p>
   * Method under test:
   * {@link StaticAssetServiceImpl#findStaticAssetByFullUrl(String)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testFindStaticAssetByFullUrl() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.file.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-applicationContext-entity.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass6194 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.file.service.StaticAssetServiceImpl staticAssetServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new StaticAssetServiceImpl()).findStaticAssetByFullUrl("https://example.org/example");
  }

  /**
   * Test {@link StaticAssetServiceImpl#addStaticAsset(StaticAsset)}.
   * <p>
   * Method under test: {@link StaticAssetServiceImpl#addStaticAsset(StaticAsset)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testAddStaticAsset() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.file.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-applicationContext-entity.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass5806 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.file.service.StaticAssetServiceImpl staticAssetServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    StaticAssetServiceImpl staticAssetServiceImpl2 = new StaticAssetServiceImpl();

    // Act
    staticAssetServiceImpl2.addStaticAsset(new ImageStaticAssetImpl());
  }

  /**
   * Test {@link StaticAssetServiceImpl#updateStaticAsset(StaticAsset)}.
   * <p>
   * Method under test:
   * {@link StaticAssetServiceImpl#updateStaticAsset(StaticAsset)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testUpdateStaticAsset() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.file.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-applicationContext-entity.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass7329 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.file.service.StaticAssetServiceImpl staticAssetServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    StaticAssetServiceImpl staticAssetServiceImpl2 = new StaticAssetServiceImpl();

    // Act
    staticAssetServiceImpl2.updateStaticAsset(new ImageStaticAssetImpl());
  }

  /**
   * Test {@link StaticAssetServiceImpl#deleteStaticAsset(StaticAsset)}.
   * <p>
   * Method under test:
   * {@link StaticAssetServiceImpl#deleteStaticAsset(StaticAsset)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testDeleteStaticAsset() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.file.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-applicationContext-entity.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass6168 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.file.service.StaticAssetServiceImpl staticAssetServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    StaticAssetServiceImpl staticAssetServiceImpl2 = new StaticAssetServiceImpl();

    // Act
    staticAssetServiceImpl2.deleteStaticAsset(new ImageStaticAssetImpl());
  }

  /**
   * Test {@link StaticAssetServiceImpl#getStaticAssetUrlPrefix()}.
   * <p>
   * Method under test: {@link StaticAssetServiceImpl#getStaticAssetUrlPrefix()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetStaticAssetUrlPrefix() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.file.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-applicationContext-entity.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass7319 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.file.service.StaticAssetServiceImpl staticAssetServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new StaticAssetServiceImpl()).getStaticAssetUrlPrefix();
  }

  /**
   * Test {@link StaticAssetServiceImpl#getPrefixedStaticAssetUrl(String)}.
   * <p>
   * Method under test:
   * {@link StaticAssetServiceImpl#getPrefixedStaticAssetUrl(String)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetPrefixedStaticAssetUrl() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.file.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-applicationContext-entity.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass6992 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.file.service.StaticAssetServiceImpl staticAssetServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new StaticAssetServiceImpl()).getPrefixedStaticAssetUrl("https://example.org/example");
  }

  /**
   * Test {@link StaticAssetServiceImpl#getStaticAssetEnvironmentUrlPrefix()}.
   * <p>
   * Method under test:
   * {@link StaticAssetServiceImpl#getStaticAssetEnvironmentUrlPrefix()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetStaticAssetEnvironmentUrlPrefix() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.file.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-applicationContext-entity.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass7314 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.file.service.StaticAssetServiceImpl staticAssetServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new StaticAssetServiceImpl()).getStaticAssetEnvironmentUrlPrefix();
  }

  /**
   * Test
   * {@link StaticAssetServiceImpl#getStaticAssetEnvironmentSecureUrlPrefix()}.
   * <p>
   * Method under test:
   * {@link StaticAssetServiceImpl#getStaticAssetEnvironmentSecureUrlPrefix()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetStaticAssetEnvironmentSecureUrlPrefix() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.file.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-applicationContext-entity.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass7309 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.file.service.StaticAssetServiceImpl staticAssetServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new StaticAssetServiceImpl()).getStaticAssetEnvironmentSecureUrlPrefix();
  }

  /**
   * Test
   * {@link StaticAssetServiceImpl#convertAssetPath(String, String, boolean)}.
   * <p>
   * Method under test:
   * {@link StaticAssetServiceImpl#convertAssetPath(String, String, boolean)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testConvertAssetPath() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.file.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-applicationContext-entity.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass5857 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.file.service.StaticAssetServiceImpl staticAssetServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new StaticAssetServiceImpl()).convertAssetPath("Asset Path", "Context Path", true);
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link StaticAssetServiceImpl#setAllowedFileExtensions(String)}
   *   <li>{@link StaticAssetServiceImpl#setDisabledFileExtensions(String)}
   *   <li>{@link StaticAssetServiceImpl#setShouldAcceptNonImageAsset(boolean)}
   *   <li>{@link StaticAssetServiceImpl#getAllowedFileExtensions()}
   *   <li>{@link StaticAssetServiceImpl#getDisabledFileExtensions()}
   *   <li>{@link StaticAssetServiceImpl#getShouldAcceptNonImageAsset()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    StaticAssetServiceImpl staticAssetServiceImpl = new StaticAssetServiceImpl();

    // Act
    staticAssetServiceImpl.setAllowedFileExtensions("Allowed File Extensions");
    staticAssetServiceImpl.setDisabledFileExtensions("Disabled File Extensions");
    staticAssetServiceImpl.setShouldAcceptNonImageAsset(true);
    String actualAllowedFileExtensions = staticAssetServiceImpl.getAllowedFileExtensions();
    String actualDisabledFileExtensions = staticAssetServiceImpl.getDisabledFileExtensions();

    // Assert that nothing has changed
    assertEquals("Allowed File Extensions", actualAllowedFileExtensions);
    assertEquals("Disabled File Extensions", actualDisabledFileExtensions);
    assertTrue(staticAssetServiceImpl.getShouldAcceptNonImageAsset());
  }
}
