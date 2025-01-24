package org.broadleafcommerce.core.search.service.solr.index;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.broadleafcommerce.common.extension.ExtensionResultStatusType;
import org.broadleafcommerce.common.i18n.domain.TranslatedEntity;
import org.broadleafcommerce.core.catalog.domain.Indexable;
import org.broadleafcommerce.core.catalog.domain.ProductBundleImpl;
import org.broadleafcommerce.core.search.domain.Field;
import org.broadleafcommerce.core.search.domain.FieldImpl;
import org.broadleafcommerce.core.search.domain.solr.FieldType;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml",
    "/bl-framework-applicationContext-persistence.xml", "/bl-framework-applicationContext-workflow.xml",
    "/bl-framework-applicationContext.xml", "/blc-config/admin/framework/bl-framework-admin-applicationContext.xml",
    "/blc-config/site/framework/bl-framework-applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class I18nSolrIndexServiceExtensionHandlerDiffblueTest {
  @Autowired
  private I18nSolrIndexServiceExtensionHandler i18nSolrIndexServiceExtensionHandler;

  /**
   * Test {@link I18nSolrIndexServiceExtensionHandler#getTranslationEnabled()}.
   * <p>
   * Method under test:
   * {@link I18nSolrIndexServiceExtensionHandler#getTranslationEnabled()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetTranslationEnabled() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.service.solr.index;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1106 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.service.solr.index.I18nSolrIndexServiceExtensionHandler i18nSolrIndexServiceExtensionHandler;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new I18nSolrIndexServiceExtensionHandler()).getTranslationEnabled();
  }

  /**
   * Test {@link I18nSolrIndexServiceExtensionHandler#init()}.
   * <p>
   * Method under test: {@link I18nSolrIndexServiceExtensionHandler#init()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testInit() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.service.solr.index;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1111 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.service.solr.index.I18nSolrIndexServiceExtensionHandler i18nSolrIndexServiceExtensionHandler;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new I18nSolrIndexServiceExtensionHandler()).init();
  }

  /**
   * Test
   * {@link I18nSolrIndexServiceExtensionHandler#addPropertyValues(Indexable, Field, FieldType, Map, String, List)}.
   * <p>
   * Method under test:
   * {@link I18nSolrIndexServiceExtensionHandler#addPropertyValues(Indexable, Field, FieldType, Map, String, List)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testAddPropertyValues() throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.service.solr.index;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1041 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.service.solr.index.I18nSolrIndexServiceExtensionHandler i18nSolrIndexServiceExtensionHandler;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    I18nSolrIndexServiceExtensionHandler i18nSolrIndexServiceExtensionHandler2 = new I18nSolrIndexServiceExtensionHandler();
    ProductBundleImpl indexable = new ProductBundleImpl();
    FieldImpl field = new FieldImpl();
    HashMap<String, Object> values = new HashMap<>();

    // Act
    i18nSolrIndexServiceExtensionHandler2.addPropertyValues(indexable, field, FieldType.BOOLEAN, values,
        "Property Name", new ArrayList<>());
  }

  /**
   * Test
   * {@link I18nSolrIndexServiceExtensionHandler#addPropertyValues(Indexable, Field, FieldType, Map, String, List)}.
   * <ul>
   *   <li>When {@link FieldImpl} (default constructor).</li>
   *   <li>Then return {@code NOT_HANDLED}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link I18nSolrIndexServiceExtensionHandler#addPropertyValues(Indexable, Field, FieldType, Map, String, List)}
   */
  @Test
  public void testAddPropertyValues_whenFieldImpl_thenReturnNotHandled()
      throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    I18nSolrIndexServiceExtensionHandler i18nSolrIndexServiceExtensionHandler = new I18nSolrIndexServiceExtensionHandler();
    ProductBundleImpl indexable = new ProductBundleImpl();
    FieldImpl field = new FieldImpl();
    HashMap<String, Object> values = new HashMap<>();

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, i18nSolrIndexServiceExtensionHandler
        .addPropertyValues(indexable, field, FieldType.BOOLEAN, values, "Property Name", new ArrayList<>()));
  }

  /**
   * Test
   * {@link I18nSolrIndexServiceExtensionHandler#addPropertyValues(Indexable, Field, FieldType, Map, String, List)}.
   * <ul>
   *   <li>When {@link ProductBundleImpl}.</li>
   *   <li>Then return {@code NOT_HANDLED}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link I18nSolrIndexServiceExtensionHandler#addPropertyValues(Indexable, Field, FieldType, Map, String, List)}
   */
  @Test
  public void testAddPropertyValues_whenProductBundleImpl_thenReturnNotHandled()
      throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    I18nSolrIndexServiceExtensionHandler i18nSolrIndexServiceExtensionHandler = new I18nSolrIndexServiceExtensionHandler();
    ProductBundleImpl indexable = mock(ProductBundleImpl.class);
    FieldImpl field = new FieldImpl();
    HashMap<String, Object> values = new HashMap<>();

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, i18nSolrIndexServiceExtensionHandler
        .addPropertyValues(indexable, field, FieldType.BOOLEAN, values, "Property Name", new ArrayList<>()));
  }

  /**
   * Test
   * {@link I18nSolrIndexServiceExtensionHandler#getLocalePrefix(Field, List)}.
   * <p>
   * Method under test:
   * {@link I18nSolrIndexServiceExtensionHandler#getLocalePrefix(Field, List)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetLocalePrefix() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.service.solr.index;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1080 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.service.solr.index.I18nSolrIndexServiceExtensionHandler i18nSolrIndexServiceExtensionHandler;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    I18nSolrIndexServiceExtensionHandler i18nSolrIndexServiceExtensionHandler2 = new I18nSolrIndexServiceExtensionHandler();
    FieldImpl field = new FieldImpl();

    // Act
    i18nSolrIndexServiceExtensionHandler2.getLocalePrefix(field, new ArrayList<>());
  }

  /**
   * Test
   * {@link I18nSolrIndexServiceExtensionHandler#getLocalePrefix(Field, List)}.
   * <ul>
   *   <li>When {@link FieldImpl} (default constructor).</li>
   *   <li>Then return {@code NOT_HANDLED}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link I18nSolrIndexServiceExtensionHandler#getLocalePrefix(Field, List)}
   */
  @Test
  public void testGetLocalePrefix_whenFieldImpl_thenReturnNotHandled() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    I18nSolrIndexServiceExtensionHandler i18nSolrIndexServiceExtensionHandler = new I18nSolrIndexServiceExtensionHandler();
    FieldImpl field = new FieldImpl();

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        i18nSolrIndexServiceExtensionHandler.getLocalePrefix(field, new ArrayList<>()));
  }

  /**
   * Test {@link I18nSolrIndexServiceExtensionHandler#startBatchEvent(List)}.
   * <p>
   * Method under test:
   * {@link I18nSolrIndexServiceExtensionHandler#startBatchEvent(List)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testStartBatchEvent() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.service.solr.index;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1116 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.service.solr.index.I18nSolrIndexServiceExtensionHandler i18nSolrIndexServiceExtensionHandler;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    I18nSolrIndexServiceExtensionHandler i18nSolrIndexServiceExtensionHandler2 = new I18nSolrIndexServiceExtensionHandler();

    // Act
    i18nSolrIndexServiceExtensionHandler2.startBatchEvent(new ArrayList<>());
  }

  /**
   * Test
   * {@link I18nSolrIndexServiceExtensionHandler#addEntitiesToTranslationCache(List, TranslatedEntity)}.
   * <p>
   * Method under test:
   * {@link I18nSolrIndexServiceExtensionHandler#addEntitiesToTranslationCache(List, TranslatedEntity)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testAddEntitiesToTranslationCache() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.service.solr.index;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1025 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.service.solr.index.I18nSolrIndexServiceExtensionHandler i18nSolrIndexServiceExtensionHandler;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    I18nSolrIndexServiceExtensionHandler i18nSolrIndexServiceExtensionHandler2 = new I18nSolrIndexServiceExtensionHandler();
    ArrayList<String> entityIds = new ArrayList<>();

    // Act
    i18nSolrIndexServiceExtensionHandler2.addEntitiesToTranslationCache(entityIds,
        new TranslatedEntity("Type", "Friendly Type"));
  }

  /**
   * Test {@link I18nSolrIndexServiceExtensionHandler#endBatchEvent(List)}.
   * <p>
   * Method under test:
   * {@link I18nSolrIndexServiceExtensionHandler#endBatchEvent(List)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testEndBatchEvent() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.service.solr.index;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1071 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.service.solr.index.I18nSolrIndexServiceExtensionHandler i18nSolrIndexServiceExtensionHandler;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    I18nSolrIndexServiceExtensionHandler i18nSolrIndexServiceExtensionHandler2 = new I18nSolrIndexServiceExtensionHandler();

    // Act
    i18nSolrIndexServiceExtensionHandler2.endBatchEvent(new ArrayList<>());
  }

  /**
   * Test {@link I18nSolrIndexServiceExtensionHandler#getPriority()}.
   * <p>
   * Method under test: {@link I18nSolrIndexServiceExtensionHandler#getPriority()}
   */
  @Test
  public void testGetPriority() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals(1000, (new I18nSolrIndexServiceExtensionHandler()).getPriority());
  }

  /**
   * Test {@link I18nSolrIndexServiceExtensionHandler#getPriority()}.
   * <p>
   * Method under test: {@link I18nSolrIndexServiceExtensionHandler#getPriority()}
   */
  @Test
  public void testGetPriority2() throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    I18nSolrIndexServiceExtensionHandler i18nSolrIndexServiceExtensionHandler = new I18nSolrIndexServiceExtensionHandler();
    ProductBundleImpl indexable = mock(ProductBundleImpl.class);
    FieldImpl field = new FieldImpl();
    HashMap<String, Object> values = new HashMap<>();
    i18nSolrIndexServiceExtensionHandler.addPropertyValues(indexable, field, FieldType.BOOLEAN, values, "Property Name",
        new ArrayList<>());

    // Act and Assert
    assertEquals(1000, i18nSolrIndexServiceExtensionHandler.getPriority());
  }

  /**
   * Test {@link I18nSolrIndexServiceExtensionHandler#getPriority()}.
   * <p>
   * Method under test: {@link I18nSolrIndexServiceExtensionHandler#getPriority()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetPriority3() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.service.solr.index;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1101 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.service.solr.index.I18nSolrIndexServiceExtensionHandler i18nSolrIndexServiceExtensionHandler;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new I18nSolrIndexServiceExtensionHandler()).getPriority();
  }
}
