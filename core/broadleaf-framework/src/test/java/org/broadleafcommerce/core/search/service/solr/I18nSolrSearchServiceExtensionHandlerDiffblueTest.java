package org.broadleafcommerce.core.search.service.solr;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import org.broadleafcommerce.common.extension.ExtensionResultStatusType;
import org.broadleafcommerce.core.search.domain.Field;
import org.broadleafcommerce.core.search.domain.FieldImpl;
import org.broadleafcommerce.core.search.domain.IndexField;
import org.broadleafcommerce.core.search.domain.IndexFieldImpl;
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
public class I18nSolrSearchServiceExtensionHandlerDiffblueTest {
  @Autowired
  private I18nSolrSearchServiceExtensionHandler i18nSolrSearchServiceExtensionHandler;

  /**
   * Test {@link I18nSolrSearchServiceExtensionHandler#getTranslationEnabled()}.
   * <p>
   * Method under test:
   * {@link I18nSolrSearchServiceExtensionHandler#getTranslationEnabled()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetTranslationEnabled() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.service.solr;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass14067 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.service.solr.I18nSolrSearchServiceExtensionHandler i18nSolrSearchServiceExtensionHandler;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new I18nSolrSearchServiceExtensionHandler()).getTranslationEnabled();
  }

  /**
   * Test {@link I18nSolrSearchServiceExtensionHandler#init()}.
   * <p>
   * Method under test: {@link I18nSolrSearchServiceExtensionHandler#init()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testInit() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.service.solr;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass14070 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.service.solr.I18nSolrSearchServiceExtensionHandler i18nSolrSearchServiceExtensionHandler;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new I18nSolrSearchServiceExtensionHandler()).init();
  }

  /**
   * Test
   * {@link I18nSolrSearchServiceExtensionHandler#buildPrefixListForIndexField(IndexField, FieldType, List)}.
   * <p>
   * Method under test:
   * {@link I18nSolrSearchServiceExtensionHandler#buildPrefixListForIndexField(IndexField, FieldType, List)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testBuildPrefixListForIndexField() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.service.solr;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass14015 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.service.solr.I18nSolrSearchServiceExtensionHandler i18nSolrSearchServiceExtensionHandler;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    I18nSolrSearchServiceExtensionHandler i18nSolrSearchServiceExtensionHandler2 = new I18nSolrSearchServiceExtensionHandler();
    IndexFieldImpl field = new IndexFieldImpl();

    // Act
    i18nSolrSearchServiceExtensionHandler2.buildPrefixListForIndexField(field, FieldType.BOOLEAN, new ArrayList<>());
  }

  /**
   * Test
   * {@link I18nSolrSearchServiceExtensionHandler#buildPrefixListForIndexField(IndexField, FieldType, List)}.
   * <ul>
   *   <li>Given {@link FieldImpl} (default constructor).</li>
   *   <li>Then return {@code NOT_HANDLED}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link I18nSolrSearchServiceExtensionHandler#buildPrefixListForIndexField(IndexField, FieldType, List)}
   */
  @Test
  public void testBuildPrefixListForIndexField_givenFieldImpl_thenReturnNotHandled() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    I18nSolrSearchServiceExtensionHandler i18nSolrSearchServiceExtensionHandler = new I18nSolrSearchServiceExtensionHandler();
    IndexFieldImpl field = mock(IndexFieldImpl.class);
    when(field.getField()).thenReturn(new FieldImpl());

    // Act
    ExtensionResultStatusType actualBuildPrefixListForIndexFieldResult = i18nSolrSearchServiceExtensionHandler
        .buildPrefixListForIndexField(field, FieldType.BOOLEAN, new ArrayList<>());

    // Assert
    verify(field).getField();
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, actualBuildPrefixListForIndexFieldResult);
  }

  /**
   * Test
   * {@link I18nSolrSearchServiceExtensionHandler#getLocalePrefix(Field, List)}.
   * <p>
   * Method under test:
   * {@link I18nSolrSearchServiceExtensionHandler#getLocalePrefix(Field, List)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetLocalePrefix() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.service.solr;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass14045 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.service.solr.I18nSolrSearchServiceExtensionHandler i18nSolrSearchServiceExtensionHandler;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    I18nSolrSearchServiceExtensionHandler i18nSolrSearchServiceExtensionHandler2 = new I18nSolrSearchServiceExtensionHandler();
    FieldImpl field = new FieldImpl();

    // Act
    i18nSolrSearchServiceExtensionHandler2.getLocalePrefix(field, new ArrayList<>());
  }

  /**
   * Test
   * {@link I18nSolrSearchServiceExtensionHandler#getLocalePrefix(Field, List)}.
   * <ul>
   *   <li>When {@link FieldImpl} (default constructor).</li>
   *   <li>Then return {@code NOT_HANDLED}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link I18nSolrSearchServiceExtensionHandler#getLocalePrefix(Field, List)}
   */
  @Test
  public void testGetLocalePrefix_whenFieldImpl_thenReturnNotHandled() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    I18nSolrSearchServiceExtensionHandler i18nSolrSearchServiceExtensionHandler = new I18nSolrSearchServiceExtensionHandler();
    FieldImpl field = new FieldImpl();

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        i18nSolrSearchServiceExtensionHandler.getLocalePrefix(field, new ArrayList<>()));
  }

  /**
   * Test {@link I18nSolrSearchServiceExtensionHandler#getPriority()}.
   * <p>
   * Method under test:
   * {@link I18nSolrSearchServiceExtensionHandler#getPriority()}
   */
  @Test
  public void testGetPriority() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals(1000, (new I18nSolrSearchServiceExtensionHandler()).getPriority());
  }

  /**
   * Test {@link I18nSolrSearchServiceExtensionHandler#getPriority()}.
   * <p>
   * Method under test:
   * {@link I18nSolrSearchServiceExtensionHandler#getPriority()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetPriority2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.service.solr;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass14064 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.service.solr.I18nSolrSearchServiceExtensionHandler i18nSolrSearchServiceExtensionHandler;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new I18nSolrSearchServiceExtensionHandler()).getPriority();
  }
}
