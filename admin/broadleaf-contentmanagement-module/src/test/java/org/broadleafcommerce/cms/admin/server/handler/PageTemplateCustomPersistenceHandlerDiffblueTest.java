package org.broadleafcommerce.cms.admin.server.handler;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import org.broadleafcommerce.cms.field.domain.FieldDefinition;
import org.broadleafcommerce.cms.field.domain.FieldDefinitionImpl;
import org.broadleafcommerce.cms.field.domain.FieldGroup;
import org.broadleafcommerce.cms.field.domain.FieldGroupImpl;
import org.broadleafcommerce.cms.page.domain.Page;
import org.broadleafcommerce.cms.page.domain.PageField;
import org.broadleafcommerce.cms.page.domain.PageImpl;
import org.broadleafcommerce.cms.page.domain.PageTemplate;
import org.broadleafcommerce.cms.page.domain.PageTemplateFieldGroupXref;
import org.broadleafcommerce.cms.page.domain.PageTemplateFieldGroupXrefImpl;
import org.broadleafcommerce.cms.page.domain.PageTemplateImpl;
import org.broadleafcommerce.common.exception.ServiceException;
import org.broadleafcommerce.common.locale.domain.LocaleImpl;
import org.broadleafcommerce.common.presentation.client.SupportedFieldType;
import org.broadleafcommerce.openadmin.dto.AdornedTargetCollectionMetadata;
import org.broadleafcommerce.openadmin.dto.BasicFieldMetadata;
import org.broadleafcommerce.openadmin.dto.CriteriaTransferObject;
import org.broadleafcommerce.openadmin.dto.Entity;
import org.broadleafcommerce.openadmin.dto.FieldMetadata;
import org.broadleafcommerce.openadmin.dto.PersistencePackage;
import org.broadleafcommerce.openadmin.dto.Property;
import org.broadleafcommerce.openadmin.server.dao.DynamicEntityDao;
import org.broadleafcommerce.openadmin.server.dao.DynamicEntityDaoImpl;
import org.broadleafcommerce.openadmin.server.service.persistence.PersistenceManagerImpl;
import org.broadleafcommerce.openadmin.server.service.persistence.module.AdornedTargetListPersistenceModule;
import org.broadleafcommerce.openadmin.server.service.persistence.module.InspectHelper;
import org.broadleafcommerce.openadmin.server.service.persistence.module.RecordHelper;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
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
public class PageTemplateCustomPersistenceHandlerDiffblueTest {
  @Autowired
  private PageTemplateCustomPersistenceHandler pageTemplateCustomPersistenceHandler;

  /**
   * Test
   * {@link PageTemplateCustomPersistenceHandler#canHandleFetch(PersistencePackage)}.
   * <p>
   * Method under test:
   * {@link PageTemplateCustomPersistenceHandler#canHandleFetch(PersistencePackage)}
   */
  @Test
  public void testCanHandleFetch() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PageTemplateCustomPersistenceHandler pageTemplateCustomPersistenceHandler = new PageTemplateCustomPersistenceHandler();
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getCustomCriteria())
        .thenThrow(new NumberFormatException("org.broadleafcommerce.cms.page.domain.PageTemplate"));
    when(persistencePackage.getCeilingEntityFullyQualifiedClassname())
        .thenReturn("org.broadleafcommerce.cms.page.domain.PageTemplate");

    // Act
    pageTemplateCustomPersistenceHandler.canHandleFetch(persistencePackage);

    // Assert
    verify(persistencePackage).getCeilingEntityFullyQualifiedClassname();
    verify(persistencePackage).getCustomCriteria();
  }

  /**
   * Test
   * {@link PageTemplateCustomPersistenceHandler#canHandleFetch(PersistencePackage)}.
   * <p>
   * Method under test:
   * {@link PageTemplateCustomPersistenceHandler#canHandleFetch(PersistencePackage)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCanHandleFetch2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.admin.server.handler;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-applicationContext-entity.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass644 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.admin.server.handler.PageTemplateCustomPersistenceHandler pageTemplateCustomPersistenceHandler;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    PageTemplateCustomPersistenceHandler pageTemplateCustomPersistenceHandler2 = new PageTemplateCustomPersistenceHandler();

    // Act
    pageTemplateCustomPersistenceHandler2.canHandleFetch(new PersistencePackage());
  }

  /**
   * Test
   * {@link PageTemplateCustomPersistenceHandler#canHandleFetch(PersistencePackage)}.
   * <ul>
   *   <li>Given array of {@link String} with {@code constructForm}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PageTemplateCustomPersistenceHandler#canHandleFetch(PersistencePackage)}
   */
  @Test
  public void testCanHandleFetch_givenArrayOfStringWithConstructForm_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PageTemplateCustomPersistenceHandler pageTemplateCustomPersistenceHandler = new PageTemplateCustomPersistenceHandler();
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getCustomCriteria()).thenReturn(new String[]{"constructForm"});
    when(persistencePackage.getCeilingEntityFullyQualifiedClassname())
        .thenReturn("org.broadleafcommerce.cms.page.domain.PageTemplate");

    // Act
    Boolean actualCanHandleFetchResult = pageTemplateCustomPersistenceHandler.canHandleFetch(persistencePackage);

    // Assert
    verify(persistencePackage).getCeilingEntityFullyQualifiedClassname();
    verify(persistencePackage, atLeast(1)).getCustomCriteria();
    assertTrue(actualCanHandleFetchResult);
  }

  /**
   * Test
   * {@link PageTemplateCustomPersistenceHandler#canHandleFetch(PersistencePackage)}.
   * <ul>
   *   <li>Given array of {@link String} with {@code Custom Criteria}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PageTemplateCustomPersistenceHandler#canHandleFetch(PersistencePackage)}
   */
  @Test
  public void testCanHandleFetch_givenArrayOfStringWithCustomCriteria() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PageTemplateCustomPersistenceHandler pageTemplateCustomPersistenceHandler = new PageTemplateCustomPersistenceHandler();
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getCustomCriteria()).thenReturn(new String[]{"Custom Criteria"});
    when(persistencePackage.getCeilingEntityFullyQualifiedClassname())
        .thenReturn("org.broadleafcommerce.cms.page.domain.PageTemplate");

    // Act
    Boolean actualCanHandleFetchResult = pageTemplateCustomPersistenceHandler.canHandleFetch(persistencePackage);

    // Assert
    verify(persistencePackage).getCeilingEntityFullyQualifiedClassname();
    verify(persistencePackage, atLeast(1)).getCustomCriteria();
    assertFalse(actualCanHandleFetchResult);
  }

  /**
   * Test
   * {@link PageTemplateCustomPersistenceHandler#canHandleFetch(PersistencePackage)}.
   * <ul>
   *   <li>Given {@code Dr Jane Doe}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PageTemplateCustomPersistenceHandler#canHandleFetch(PersistencePackage)}
   */
  @Test
  public void testCanHandleFetch_givenDrJaneDoe() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PageTemplateCustomPersistenceHandler pageTemplateCustomPersistenceHandler = new PageTemplateCustomPersistenceHandler();
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getCeilingEntityFullyQualifiedClassname()).thenReturn("Dr Jane Doe");

    // Act
    Boolean actualCanHandleFetchResult = pageTemplateCustomPersistenceHandler.canHandleFetch(persistencePackage);

    // Assert
    verify(persistencePackage).getCeilingEntityFullyQualifiedClassname();
    assertFalse(actualCanHandleFetchResult);
  }

  /**
   * Test
   * {@link PageTemplateCustomPersistenceHandler#canHandleFetch(PersistencePackage)}.
   * <ul>
   *   <li>Given empty array of {@link String}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PageTemplateCustomPersistenceHandler#canHandleFetch(PersistencePackage)}
   */
  @Test
  public void testCanHandleFetch_givenEmptyArrayOfString() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PageTemplateCustomPersistenceHandler pageTemplateCustomPersistenceHandler = new PageTemplateCustomPersistenceHandler();
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getCustomCriteria()).thenReturn(new String[]{});
    when(persistencePackage.getCeilingEntityFullyQualifiedClassname())
        .thenReturn("org.broadleafcommerce.cms.page.domain.PageTemplate");

    // Act
    Boolean actualCanHandleFetchResult = pageTemplateCustomPersistenceHandler.canHandleFetch(persistencePackage);

    // Assert
    verify(persistencePackage).getCeilingEntityFullyQualifiedClassname();
    verify(persistencePackage, atLeast(1)).getCustomCriteria();
    assertFalse(actualCanHandleFetchResult);
  }

  /**
   * Test
   * {@link PageTemplateCustomPersistenceHandler#canHandleFetch(PersistencePackage)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link PersistencePackage}
   * {@link PersistencePackage#getCustomCriteria()} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PageTemplateCustomPersistenceHandler#canHandleFetch(PersistencePackage)}
   */
  @Test
  public void testCanHandleFetch_givenNull_whenPersistencePackageGetCustomCriteriaReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PageTemplateCustomPersistenceHandler pageTemplateCustomPersistenceHandler = new PageTemplateCustomPersistenceHandler();
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getCustomCriteria()).thenReturn(null);
    when(persistencePackage.getCeilingEntityFullyQualifiedClassname())
        .thenReturn("org.broadleafcommerce.cms.page.domain.PageTemplate");

    // Act
    Boolean actualCanHandleFetchResult = pageTemplateCustomPersistenceHandler.canHandleFetch(persistencePackage);

    // Assert
    verify(persistencePackage).getCeilingEntityFullyQualifiedClassname();
    verify(persistencePackage).getCustomCriteria();
    assertFalse(actualCanHandleFetchResult);
  }

  /**
   * Test
   * {@link PageTemplateCustomPersistenceHandler#canHandleFetch(PersistencePackage)}.
   * <ul>
   *   <li>When {@link PersistencePackage#PersistencePackage()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PageTemplateCustomPersistenceHandler#canHandleFetch(PersistencePackage)}
   */
  @Test
  public void testCanHandleFetch_whenPersistencePackage_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PageTemplateCustomPersistenceHandler pageTemplateCustomPersistenceHandler = new PageTemplateCustomPersistenceHandler();

    // Act and Assert
    assertFalse(pageTemplateCustomPersistenceHandler.canHandleFetch(new PersistencePackage()));
  }

  /**
   * Test
   * {@link PageTemplateCustomPersistenceHandler#canHandleAdd(PersistencePackage)}.
   * <p>
   * Method under test:
   * {@link PageTemplateCustomPersistenceHandler#canHandleAdd(PersistencePackage)}
   */
  @Test
  public void testCanHandleAdd() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PageTemplateCustomPersistenceHandler pageTemplateCustomPersistenceHandler = new PageTemplateCustomPersistenceHandler();
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getCustomCriteria())
        .thenThrow(new NumberFormatException("org.broadleafcommerce.cms.page.domain.PageTemplate"));
    when(persistencePackage.getCeilingEntityFullyQualifiedClassname())
        .thenReturn("org.broadleafcommerce.cms.page.domain.PageTemplate");

    // Act
    pageTemplateCustomPersistenceHandler.canHandleAdd(persistencePackage);

    // Assert
    verify(persistencePackage).getCeilingEntityFullyQualifiedClassname();
    verify(persistencePackage).getCustomCriteria();
  }

  /**
   * Test
   * {@link PageTemplateCustomPersistenceHandler#canHandleAdd(PersistencePackage)}.
   * <p>
   * Method under test:
   * {@link PageTemplateCustomPersistenceHandler#canHandleAdd(PersistencePackage)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCanHandleAdd2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.admin.server.handler;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-applicationContext-entity.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass619 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.admin.server.handler.PageTemplateCustomPersistenceHandler pageTemplateCustomPersistenceHandler;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    PageTemplateCustomPersistenceHandler pageTemplateCustomPersistenceHandler2 = new PageTemplateCustomPersistenceHandler();

    // Act
    pageTemplateCustomPersistenceHandler2.canHandleAdd(new PersistencePackage());
  }

  /**
   * Test
   * {@link PageTemplateCustomPersistenceHandler#canHandleAdd(PersistencePackage)}.
   * <ul>
   *   <li>Given array of {@link String} with {@code constructForm}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PageTemplateCustomPersistenceHandler#canHandleAdd(PersistencePackage)}
   */
  @Test
  public void testCanHandleAdd_givenArrayOfStringWithConstructForm_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PageTemplateCustomPersistenceHandler pageTemplateCustomPersistenceHandler = new PageTemplateCustomPersistenceHandler();
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getCustomCriteria()).thenReturn(new String[]{"constructForm"});
    when(persistencePackage.getCeilingEntityFullyQualifiedClassname())
        .thenReturn("org.broadleafcommerce.cms.page.domain.PageTemplate");

    // Act
    Boolean actualCanHandleAddResult = pageTemplateCustomPersistenceHandler.canHandleAdd(persistencePackage);

    // Assert
    verify(persistencePackage).getCeilingEntityFullyQualifiedClassname();
    verify(persistencePackage, atLeast(1)).getCustomCriteria();
    assertTrue(actualCanHandleAddResult);
  }

  /**
   * Test
   * {@link PageTemplateCustomPersistenceHandler#canHandleAdd(PersistencePackage)}.
   * <ul>
   *   <li>Given array of {@link String} with {@code Custom Criteria}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PageTemplateCustomPersistenceHandler#canHandleAdd(PersistencePackage)}
   */
  @Test
  public void testCanHandleAdd_givenArrayOfStringWithCustomCriteria() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PageTemplateCustomPersistenceHandler pageTemplateCustomPersistenceHandler = new PageTemplateCustomPersistenceHandler();
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getCustomCriteria()).thenReturn(new String[]{"Custom Criteria"});
    when(persistencePackage.getCeilingEntityFullyQualifiedClassname())
        .thenReturn("org.broadleafcommerce.cms.page.domain.PageTemplate");

    // Act
    Boolean actualCanHandleAddResult = pageTemplateCustomPersistenceHandler.canHandleAdd(persistencePackage);

    // Assert
    verify(persistencePackage).getCeilingEntityFullyQualifiedClassname();
    verify(persistencePackage, atLeast(1)).getCustomCriteria();
    assertFalse(actualCanHandleAddResult);
  }

  /**
   * Test
   * {@link PageTemplateCustomPersistenceHandler#canHandleAdd(PersistencePackage)}.
   * <ul>
   *   <li>Given {@code Dr Jane Doe}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PageTemplateCustomPersistenceHandler#canHandleAdd(PersistencePackage)}
   */
  @Test
  public void testCanHandleAdd_givenDrJaneDoe() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PageTemplateCustomPersistenceHandler pageTemplateCustomPersistenceHandler = new PageTemplateCustomPersistenceHandler();
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getCeilingEntityFullyQualifiedClassname()).thenReturn("Dr Jane Doe");

    // Act
    Boolean actualCanHandleAddResult = pageTemplateCustomPersistenceHandler.canHandleAdd(persistencePackage);

    // Assert
    verify(persistencePackage).getCeilingEntityFullyQualifiedClassname();
    assertFalse(actualCanHandleAddResult);
  }

  /**
   * Test
   * {@link PageTemplateCustomPersistenceHandler#canHandleAdd(PersistencePackage)}.
   * <ul>
   *   <li>Given empty array of {@link String}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PageTemplateCustomPersistenceHandler#canHandleAdd(PersistencePackage)}
   */
  @Test
  public void testCanHandleAdd_givenEmptyArrayOfString() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PageTemplateCustomPersistenceHandler pageTemplateCustomPersistenceHandler = new PageTemplateCustomPersistenceHandler();
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getCustomCriteria()).thenReturn(new String[]{});
    when(persistencePackage.getCeilingEntityFullyQualifiedClassname())
        .thenReturn("org.broadleafcommerce.cms.page.domain.PageTemplate");

    // Act
    Boolean actualCanHandleAddResult = pageTemplateCustomPersistenceHandler.canHandleAdd(persistencePackage);

    // Assert
    verify(persistencePackage).getCeilingEntityFullyQualifiedClassname();
    verify(persistencePackage, atLeast(1)).getCustomCriteria();
    assertFalse(actualCanHandleAddResult);
  }

  /**
   * Test
   * {@link PageTemplateCustomPersistenceHandler#canHandleAdd(PersistencePackage)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link PersistencePackage}
   * {@link PersistencePackage#getCustomCriteria()} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PageTemplateCustomPersistenceHandler#canHandleAdd(PersistencePackage)}
   */
  @Test
  public void testCanHandleAdd_givenNull_whenPersistencePackageGetCustomCriteriaReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PageTemplateCustomPersistenceHandler pageTemplateCustomPersistenceHandler = new PageTemplateCustomPersistenceHandler();
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getCustomCriteria()).thenReturn(null);
    when(persistencePackage.getCeilingEntityFullyQualifiedClassname())
        .thenReturn("org.broadleafcommerce.cms.page.domain.PageTemplate");

    // Act
    Boolean actualCanHandleAddResult = pageTemplateCustomPersistenceHandler.canHandleAdd(persistencePackage);

    // Assert
    verify(persistencePackage).getCeilingEntityFullyQualifiedClassname();
    verify(persistencePackage).getCustomCriteria();
    assertFalse(actualCanHandleAddResult);
  }

  /**
   * Test
   * {@link PageTemplateCustomPersistenceHandler#canHandleAdd(PersistencePackage)}.
   * <ul>
   *   <li>When {@link PersistencePackage#PersistencePackage()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PageTemplateCustomPersistenceHandler#canHandleAdd(PersistencePackage)}
   */
  @Test
  public void testCanHandleAdd_whenPersistencePackage_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PageTemplateCustomPersistenceHandler pageTemplateCustomPersistenceHandler = new PageTemplateCustomPersistenceHandler();

    // Act and Assert
    assertFalse(pageTemplateCustomPersistenceHandler.canHandleAdd(new PersistencePackage()));
  }

  /**
   * Test
   * {@link PageTemplateCustomPersistenceHandler#canHandleInspect(PersistencePackage)}.
   * <p>
   * Method under test:
   * {@link PageTemplateCustomPersistenceHandler#canHandleInspect(PersistencePackage)}
   */
  @Test
  public void testCanHandleInspect() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PageTemplateCustomPersistenceHandler pageTemplateCustomPersistenceHandler = new PageTemplateCustomPersistenceHandler();
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getCustomCriteria())
        .thenThrow(new NumberFormatException("org.broadleafcommerce.cms.page.domain.PageTemplate"));
    when(persistencePackage.getCeilingEntityFullyQualifiedClassname())
        .thenReturn("org.broadleafcommerce.cms.page.domain.PageTemplate");

    // Act
    pageTemplateCustomPersistenceHandler.canHandleInspect(persistencePackage);

    // Assert
    verify(persistencePackage).getCeilingEntityFullyQualifiedClassname();
    verify(persistencePackage).getCustomCriteria();
  }

  /**
   * Test
   * {@link PageTemplateCustomPersistenceHandler#canHandleInspect(PersistencePackage)}.
   * <p>
   * Method under test:
   * {@link PageTemplateCustomPersistenceHandler#canHandleInspect(PersistencePackage)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCanHandleInspect2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.admin.server.handler;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-applicationContext-entity.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass669 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.admin.server.handler.PageTemplateCustomPersistenceHandler pageTemplateCustomPersistenceHandler;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    PageTemplateCustomPersistenceHandler pageTemplateCustomPersistenceHandler2 = new PageTemplateCustomPersistenceHandler();

    // Act
    pageTemplateCustomPersistenceHandler2.canHandleInspect(new PersistencePackage());
  }

  /**
   * Test
   * {@link PageTemplateCustomPersistenceHandler#canHandleInspect(PersistencePackage)}.
   * <ul>
   *   <li>Given array of {@link String} with {@code constructForm}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PageTemplateCustomPersistenceHandler#canHandleInspect(PersistencePackage)}
   */
  @Test
  public void testCanHandleInspect_givenArrayOfStringWithConstructForm_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PageTemplateCustomPersistenceHandler pageTemplateCustomPersistenceHandler = new PageTemplateCustomPersistenceHandler();
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getCustomCriteria()).thenReturn(new String[]{"constructForm"});
    when(persistencePackage.getCeilingEntityFullyQualifiedClassname())
        .thenReturn("org.broadleafcommerce.cms.page.domain.PageTemplate");

    // Act
    Boolean actualCanHandleInspectResult = pageTemplateCustomPersistenceHandler.canHandleInspect(persistencePackage);

    // Assert
    verify(persistencePackage).getCeilingEntityFullyQualifiedClassname();
    verify(persistencePackage, atLeast(1)).getCustomCriteria();
    assertTrue(actualCanHandleInspectResult);
  }

  /**
   * Test
   * {@link PageTemplateCustomPersistenceHandler#canHandleInspect(PersistencePackage)}.
   * <ul>
   *   <li>Given array of {@link String} with {@code Custom Criteria}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PageTemplateCustomPersistenceHandler#canHandleInspect(PersistencePackage)}
   */
  @Test
  public void testCanHandleInspect_givenArrayOfStringWithCustomCriteria() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PageTemplateCustomPersistenceHandler pageTemplateCustomPersistenceHandler = new PageTemplateCustomPersistenceHandler();
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getCustomCriteria()).thenReturn(new String[]{"Custom Criteria"});
    when(persistencePackage.getCeilingEntityFullyQualifiedClassname())
        .thenReturn("org.broadleafcommerce.cms.page.domain.PageTemplate");

    // Act
    Boolean actualCanHandleInspectResult = pageTemplateCustomPersistenceHandler.canHandleInspect(persistencePackage);

    // Assert
    verify(persistencePackage).getCeilingEntityFullyQualifiedClassname();
    verify(persistencePackage, atLeast(1)).getCustomCriteria();
    assertFalse(actualCanHandleInspectResult);
  }

  /**
   * Test
   * {@link PageTemplateCustomPersistenceHandler#canHandleInspect(PersistencePackage)}.
   * <ul>
   *   <li>Given {@code Dr Jane Doe}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PageTemplateCustomPersistenceHandler#canHandleInspect(PersistencePackage)}
   */
  @Test
  public void testCanHandleInspect_givenDrJaneDoe() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PageTemplateCustomPersistenceHandler pageTemplateCustomPersistenceHandler = new PageTemplateCustomPersistenceHandler();
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getCeilingEntityFullyQualifiedClassname()).thenReturn("Dr Jane Doe");

    // Act
    Boolean actualCanHandleInspectResult = pageTemplateCustomPersistenceHandler.canHandleInspect(persistencePackage);

    // Assert
    verify(persistencePackage).getCeilingEntityFullyQualifiedClassname();
    assertFalse(actualCanHandleInspectResult);
  }

  /**
   * Test
   * {@link PageTemplateCustomPersistenceHandler#canHandleInspect(PersistencePackage)}.
   * <ul>
   *   <li>Given empty array of {@link String}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PageTemplateCustomPersistenceHandler#canHandleInspect(PersistencePackage)}
   */
  @Test
  public void testCanHandleInspect_givenEmptyArrayOfString() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PageTemplateCustomPersistenceHandler pageTemplateCustomPersistenceHandler = new PageTemplateCustomPersistenceHandler();
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getCustomCriteria()).thenReturn(new String[]{});
    when(persistencePackage.getCeilingEntityFullyQualifiedClassname())
        .thenReturn("org.broadleafcommerce.cms.page.domain.PageTemplate");

    // Act
    Boolean actualCanHandleInspectResult = pageTemplateCustomPersistenceHandler.canHandleInspect(persistencePackage);

    // Assert
    verify(persistencePackage).getCeilingEntityFullyQualifiedClassname();
    verify(persistencePackage, atLeast(1)).getCustomCriteria();
    assertFalse(actualCanHandleInspectResult);
  }

  /**
   * Test
   * {@link PageTemplateCustomPersistenceHandler#canHandleInspect(PersistencePackage)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link PersistencePackage}
   * {@link PersistencePackage#getCustomCriteria()} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PageTemplateCustomPersistenceHandler#canHandleInspect(PersistencePackage)}
   */
  @Test
  public void testCanHandleInspect_givenNull_whenPersistencePackageGetCustomCriteriaReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PageTemplateCustomPersistenceHandler pageTemplateCustomPersistenceHandler = new PageTemplateCustomPersistenceHandler();
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getCustomCriteria()).thenReturn(null);
    when(persistencePackage.getCeilingEntityFullyQualifiedClassname())
        .thenReturn("org.broadleafcommerce.cms.page.domain.PageTemplate");

    // Act
    Boolean actualCanHandleInspectResult = pageTemplateCustomPersistenceHandler.canHandleInspect(persistencePackage);

    // Assert
    verify(persistencePackage).getCeilingEntityFullyQualifiedClassname();
    verify(persistencePackage).getCustomCriteria();
    assertFalse(actualCanHandleInspectResult);
  }

  /**
   * Test
   * {@link PageTemplateCustomPersistenceHandler#canHandleInspect(PersistencePackage)}.
   * <ul>
   *   <li>When {@link PersistencePackage#PersistencePackage()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PageTemplateCustomPersistenceHandler#canHandleInspect(PersistencePackage)}
   */
  @Test
  public void testCanHandleInspect_whenPersistencePackage_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PageTemplateCustomPersistenceHandler pageTemplateCustomPersistenceHandler = new PageTemplateCustomPersistenceHandler();

    // Act and Assert
    assertFalse(pageTemplateCustomPersistenceHandler.canHandleInspect(new PersistencePackage()));
  }

  /**
   * Test
   * {@link PageTemplateCustomPersistenceHandler#canHandleRemove(PersistencePackage)}.
   * <p>
   * Method under test:
   * {@link PageTemplateCustomPersistenceHandler#canHandleRemove(PersistencePackage)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCanHandleRemove() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.admin.server.handler;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-applicationContext-entity.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass694 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.admin.server.handler.PageTemplateCustomPersistenceHandler pageTemplateCustomPersistenceHandler;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    PageTemplateCustomPersistenceHandler pageTemplateCustomPersistenceHandler2 = new PageTemplateCustomPersistenceHandler();

    // Act
    pageTemplateCustomPersistenceHandler2.canHandleRemove(new PersistencePackage());
  }

  /**
   * Test
   * {@link PageTemplateCustomPersistenceHandler#canHandleRemove(PersistencePackage)}.
   * <ul>
   *   <li>When {@link PersistencePackage#PersistencePackage()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PageTemplateCustomPersistenceHandler#canHandleRemove(PersistencePackage)}
   */
  @Test
  public void testCanHandleRemove_whenPersistencePackage() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PageTemplateCustomPersistenceHandler pageTemplateCustomPersistenceHandler = new PageTemplateCustomPersistenceHandler();

    // Act and Assert
    assertFalse(pageTemplateCustomPersistenceHandler.canHandleRemove(new PersistencePackage()));
  }

  /**
   * Test
   * {@link PageTemplateCustomPersistenceHandler#canHandleRemove(PersistencePackage)}.
   * <ul>
   *   <li>When {@link PersistencePackage}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PageTemplateCustomPersistenceHandler#canHandleRemove(PersistencePackage)}
   */
  @Test
  public void testCanHandleRemove_whenPersistencePackage2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new PageTemplateCustomPersistenceHandler()).canHandleRemove(mock(PersistencePackage.class)));
  }

  /**
   * Test
   * {@link PageTemplateCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}.
   * <p>
   * Method under test:
   * {@link PageTemplateCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}
   */
  @Test
  public void testCanHandleUpdate() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PageTemplateCustomPersistenceHandler pageTemplateCustomPersistenceHandler = new PageTemplateCustomPersistenceHandler();
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getCustomCriteria())
        .thenThrow(new NumberFormatException("org.broadleafcommerce.cms.page.domain.PageTemplate"));
    when(persistencePackage.getCeilingEntityFullyQualifiedClassname())
        .thenReturn("org.broadleafcommerce.cms.page.domain.PageTemplate");

    // Act
    pageTemplateCustomPersistenceHandler.canHandleUpdate(persistencePackage);

    // Assert
    verify(persistencePackage).getCeilingEntityFullyQualifiedClassname();
    verify(persistencePackage).getCustomCriteria();
  }

  /**
   * Test
   * {@link PageTemplateCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}.
   * <p>
   * Method under test:
   * {@link PageTemplateCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCanHandleUpdate2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.admin.server.handler;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-applicationContext-entity.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass719 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.admin.server.handler.PageTemplateCustomPersistenceHandler pageTemplateCustomPersistenceHandler;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    PageTemplateCustomPersistenceHandler pageTemplateCustomPersistenceHandler2 = new PageTemplateCustomPersistenceHandler();

    // Act
    pageTemplateCustomPersistenceHandler2.canHandleUpdate(new PersistencePackage());
  }

  /**
   * Test
   * {@link PageTemplateCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}.
   * <ul>
   *   <li>Given array of {@link String} with {@code constructForm}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PageTemplateCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}
   */
  @Test
  public void testCanHandleUpdate_givenArrayOfStringWithConstructForm_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PageTemplateCustomPersistenceHandler pageTemplateCustomPersistenceHandler = new PageTemplateCustomPersistenceHandler();
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getCustomCriteria()).thenReturn(new String[]{"constructForm"});
    when(persistencePackage.getCeilingEntityFullyQualifiedClassname())
        .thenReturn("org.broadleafcommerce.cms.page.domain.PageTemplate");

    // Act
    Boolean actualCanHandleUpdateResult = pageTemplateCustomPersistenceHandler.canHandleUpdate(persistencePackage);

    // Assert
    verify(persistencePackage).getCeilingEntityFullyQualifiedClassname();
    verify(persistencePackage, atLeast(1)).getCustomCriteria();
    assertTrue(actualCanHandleUpdateResult);
  }

  /**
   * Test
   * {@link PageTemplateCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}.
   * <ul>
   *   <li>Given array of {@link String} with {@code Custom Criteria}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PageTemplateCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}
   */
  @Test
  public void testCanHandleUpdate_givenArrayOfStringWithCustomCriteria() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PageTemplateCustomPersistenceHandler pageTemplateCustomPersistenceHandler = new PageTemplateCustomPersistenceHandler();
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getCustomCriteria()).thenReturn(new String[]{"Custom Criteria"});
    when(persistencePackage.getCeilingEntityFullyQualifiedClassname())
        .thenReturn("org.broadleafcommerce.cms.page.domain.PageTemplate");

    // Act
    Boolean actualCanHandleUpdateResult = pageTemplateCustomPersistenceHandler.canHandleUpdate(persistencePackage);

    // Assert
    verify(persistencePackage).getCeilingEntityFullyQualifiedClassname();
    verify(persistencePackage, atLeast(1)).getCustomCriteria();
    assertFalse(actualCanHandleUpdateResult);
  }

  /**
   * Test
   * {@link PageTemplateCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}.
   * <ul>
   *   <li>Given {@code Dr Jane Doe}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PageTemplateCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}
   */
  @Test
  public void testCanHandleUpdate_givenDrJaneDoe() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PageTemplateCustomPersistenceHandler pageTemplateCustomPersistenceHandler = new PageTemplateCustomPersistenceHandler();
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getCeilingEntityFullyQualifiedClassname()).thenReturn("Dr Jane Doe");

    // Act
    Boolean actualCanHandleUpdateResult = pageTemplateCustomPersistenceHandler.canHandleUpdate(persistencePackage);

    // Assert
    verify(persistencePackage).getCeilingEntityFullyQualifiedClassname();
    assertFalse(actualCanHandleUpdateResult);
  }

  /**
   * Test
   * {@link PageTemplateCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}.
   * <ul>
   *   <li>Given empty array of {@link String}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PageTemplateCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}
   */
  @Test
  public void testCanHandleUpdate_givenEmptyArrayOfString() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PageTemplateCustomPersistenceHandler pageTemplateCustomPersistenceHandler = new PageTemplateCustomPersistenceHandler();
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getCustomCriteria()).thenReturn(new String[]{});
    when(persistencePackage.getCeilingEntityFullyQualifiedClassname())
        .thenReturn("org.broadleafcommerce.cms.page.domain.PageTemplate");

    // Act
    Boolean actualCanHandleUpdateResult = pageTemplateCustomPersistenceHandler.canHandleUpdate(persistencePackage);

    // Assert
    verify(persistencePackage).getCeilingEntityFullyQualifiedClassname();
    verify(persistencePackage, atLeast(1)).getCustomCriteria();
    assertFalse(actualCanHandleUpdateResult);
  }

  /**
   * Test
   * {@link PageTemplateCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link PersistencePackage}
   * {@link PersistencePackage#getCustomCriteria()} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PageTemplateCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}
   */
  @Test
  public void testCanHandleUpdate_givenNull_whenPersistencePackageGetCustomCriteriaReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PageTemplateCustomPersistenceHandler pageTemplateCustomPersistenceHandler = new PageTemplateCustomPersistenceHandler();
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getCustomCriteria()).thenReturn(null);
    when(persistencePackage.getCeilingEntityFullyQualifiedClassname())
        .thenReturn("org.broadleafcommerce.cms.page.domain.PageTemplate");

    // Act
    Boolean actualCanHandleUpdateResult = pageTemplateCustomPersistenceHandler.canHandleUpdate(persistencePackage);

    // Assert
    verify(persistencePackage).getCeilingEntityFullyQualifiedClassname();
    verify(persistencePackage).getCustomCriteria();
    assertFalse(actualCanHandleUpdateResult);
  }

  /**
   * Test
   * {@link PageTemplateCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}.
   * <ul>
   *   <li>When {@link PersistencePackage#PersistencePackage()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PageTemplateCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}
   */
  @Test
  public void testCanHandleUpdate_whenPersistencePackage_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PageTemplateCustomPersistenceHandler pageTemplateCustomPersistenceHandler = new PageTemplateCustomPersistenceHandler();

    // Act and Assert
    assertFalse(pageTemplateCustomPersistenceHandler.canHandleUpdate(new PersistencePackage()));
  }

  /**
   * Test {@link PageTemplateCustomPersistenceHandler#getSandBox()}.
   * <p>
   * Method under test: {@link PageTemplateCustomPersistenceHandler#getSandBox()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetSandBox() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.admin.server.handler;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-applicationContext-entity.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass980 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.admin.server.handler.PageTemplateCustomPersistenceHandler pageTemplateCustomPersistenceHandler;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new PageTemplateCustomPersistenceHandler()).getSandBox();
  }

  /**
   * Test
   * {@link PageTemplateCustomPersistenceHandler#getFieldGroups(Page, PageTemplate)}
   * with {@code page}, {@code template}.
   * <p>
   * Method under test:
   * {@link PageTemplateCustomPersistenceHandler#getFieldGroups(Page, PageTemplate)}
   */
  @Test
  public void testGetFieldGroupsWithPageTemplate() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PageTemplateCustomPersistenceHandler pageTemplateCustomPersistenceHandler = new PageTemplateCustomPersistenceHandler();
    PageImpl page = mock(PageImpl.class);
    when(page.getPageTemplate()).thenReturn(new PageTemplateImpl());

    // Act
    List<FieldGroup> actualFieldGroups = pageTemplateCustomPersistenceHandler.getFieldGroups(page,
        new PageTemplateImpl());

    // Assert
    verify(page, atLeast(1)).getPageTemplate();
    assertTrue(actualFieldGroups.isEmpty());
  }

  /**
   * Test
   * {@link PageTemplateCustomPersistenceHandler#getFieldGroups(Page, PageTemplate)}
   * with {@code page}, {@code template}.
   * <p>
   * Method under test:
   * {@link PageTemplateCustomPersistenceHandler#getFieldGroups(Page, PageTemplate)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetFieldGroupsWithPageTemplate2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.admin.server.handler;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-applicationContext-entity.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass911 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.admin.server.handler.PageTemplateCustomPersistenceHandler pageTemplateCustomPersistenceHandler;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    PageTemplateCustomPersistenceHandler pageTemplateCustomPersistenceHandler2 = new PageTemplateCustomPersistenceHandler();
    PageImpl page = new PageImpl();

    // Act
    pageTemplateCustomPersistenceHandler2.getFieldGroups(page, new PageTemplateImpl());
  }

  /**
   * Test
   * {@link PageTemplateCustomPersistenceHandler#getFieldGroups(Page, PageTemplate)}
   * with {@code page}, {@code template}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link PageImpl} (default constructor) PageTemplate is
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PageTemplateCustomPersistenceHandler#getFieldGroups(Page, PageTemplate)}
   */
  @Test
  public void testGetFieldGroupsWithPageTemplate_givenNull_whenPageImplPageTemplateIsNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PageTemplateCustomPersistenceHandler pageTemplateCustomPersistenceHandler = new PageTemplateCustomPersistenceHandler();

    PageImpl page = new PageImpl();
    page.setActiveEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    page.setActiveStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    page.setAdditionalAttributes(new HashMap<>());
    page.setDescription("The characteristics of someone or something");
    page.setExcludeFromSiteMap(true);
    page.setFullUrl("https://example.org/example");
    page.setId(1L);
    page.setMetaDescription("Meta Description");
    page.setMetaTitle("Dr");
    page.setOfflineFlag(true);
    page.setPageFields(new HashMap<>());
    page.setPageMatchRules(new HashMap<>());
    page.setPriority(1);
    page.setQualifyingItemCriteria(new HashSet<>());
    page.setPageTemplate(null);

    // Act and Assert
    assertTrue(pageTemplateCustomPersistenceHandler.getFieldGroups(page, null).isEmpty());
  }

  /**
   * Test
   * {@link PageTemplateCustomPersistenceHandler#getFieldGroups(Page, PageTemplate)}
   * with {@code page}, {@code template}.
   * <ul>
   *   <li>Given {@link NumberFormatException#NumberFormatException(String)} with
   * {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PageTemplateCustomPersistenceHandler#getFieldGroups(Page, PageTemplate)}
   */
  @Test
  public void testGetFieldGroupsWithPageTemplate_givenNumberFormatExceptionWithFoo() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PageTemplateCustomPersistenceHandler pageTemplateCustomPersistenceHandler = new PageTemplateCustomPersistenceHandler();
    PageImpl page = mock(PageImpl.class);
    new NumberFormatException("foo");
    PageTemplateImpl template = mock(PageTemplateImpl.class);
    when(template.getFieldGroupXrefs()).thenThrow(new NumberFormatException("foo"));

    // Act
    pageTemplateCustomPersistenceHandler.getFieldGroups(page, template);

    // Assert
    verify(template).getFieldGroupXrefs();
  }

  /**
   * Test
   * {@link PageTemplateCustomPersistenceHandler#getFieldGroups(Page, PageTemplate)}
   * with {@code page}, {@code template}.
   * <ul>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PageTemplateCustomPersistenceHandler#getFieldGroups(Page, PageTemplate)}
   */
  @Test
  public void testGetFieldGroupsWithPageTemplate_thenReturnSizeIsOne() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PageTemplateCustomPersistenceHandler pageTemplateCustomPersistenceHandler = new PageTemplateCustomPersistenceHandler();

    PageImpl page = new PageImpl();
    page.setActiveEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    page.setActiveStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    page.setAdditionalAttributes(new HashMap<>());
    page.setDescription("The characteristics of someone or something");
    page.setExcludeFromSiteMap(true);
    page.setFullUrl("https://example.org/example");
    page.setId(1L);
    page.setMetaDescription("Meta Description");
    page.setMetaTitle("Dr");
    page.setOfflineFlag(true);
    page.setPageFields(new HashMap<>());
    page.setPageMatchRules(new HashMap<>());
    page.setPriority(1);
    page.setQualifyingItemCriteria(new HashSet<>());
    page.setPageTemplate(null);

    ArrayList<PageTemplateFieldGroupXref> fieldGroups = new ArrayList<>();
    fieldGroups.add(new PageTemplateFieldGroupXrefImpl());

    PageTemplateImpl template = new PageTemplateImpl();
    template.setId(1L);
    template.setLocale(new LocaleImpl());
    template.setTemplateDescription("Template Description");
    template.setTemplateName("Template Name");
    template.setTemplatePath("Template Path");
    template.setFieldGroupXrefs(fieldGroups);

    // Act
    List<FieldGroup> actualFieldGroups = pageTemplateCustomPersistenceHandler.getFieldGroups(page, template);

    // Assert
    assertEquals(1, actualFieldGroups.size());
    assertNull(actualFieldGroups.get(0));
  }

  /**
   * Test
   * {@link PageTemplateCustomPersistenceHandler#getFieldGroups(Page, PageTemplate)}
   * with {@code page}, {@code template}.
   * <ul>
   *   <li>Then throw {@link NumberFormatException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PageTemplateCustomPersistenceHandler#getFieldGroups(Page, PageTemplate)}
   */
  @Test
  public void testGetFieldGroupsWithPageTemplate_thenThrowNumberFormatException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PageTemplateCustomPersistenceHandler pageTemplateCustomPersistenceHandler = new PageTemplateCustomPersistenceHandler();
    PageTemplateImpl pageTemplateImpl = mock(PageTemplateImpl.class);
    when(pageTemplateImpl.getFieldGroupXrefs()).thenThrow(new NumberFormatException("foo"));
    PageImpl page = mock(PageImpl.class);
    when(page.getPageTemplate()).thenReturn(pageTemplateImpl);

    // Act and Assert
    assertThrows(NumberFormatException.class,
        () -> pageTemplateCustomPersistenceHandler.getFieldGroups(page, new PageTemplateImpl()));
    verify(page, atLeast(1)).getPageTemplate();
    verify(pageTemplateImpl).getFieldGroupXrefs();
  }

  /**
   * Test
   * {@link PageTemplateCustomPersistenceHandler#getFieldGroups(Page, PageTemplate)}
   * with {@code page}, {@code template}.
   * <ul>
   *   <li>When {@link PageImpl} (default constructor) PageTemplate is
   * {@link PageTemplateImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PageTemplateCustomPersistenceHandler#getFieldGroups(Page, PageTemplate)}
   */
  @Test
  public void testGetFieldGroupsWithPageTemplate_whenPageImplPageTemplateIsPageTemplateImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PageTemplateCustomPersistenceHandler pageTemplateCustomPersistenceHandler = new PageTemplateCustomPersistenceHandler();

    PageImpl page = new PageImpl();
    page.setActiveEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    page.setActiveStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    page.setAdditionalAttributes(new HashMap<>());
    page.setDescription("The characteristics of someone or something");
    page.setExcludeFromSiteMap(true);
    page.setFullUrl("https://example.org/example");
    page.setId(1L);
    page.setMetaDescription("Meta Description");
    page.setMetaTitle("Dr");
    page.setOfflineFlag(true);
    page.setPageFields(new HashMap<>());
    page.setPageMatchRules(new HashMap<>());
    page.setPriority(1);
    page.setQualifyingItemCriteria(new HashSet<>());
    page.setPageTemplate(new PageTemplateImpl());

    // Act and Assert
    assertTrue(pageTemplateCustomPersistenceHandler.getFieldGroups(page, null).isEmpty());
  }

  /**
   * Test
   * {@link PageTemplateCustomPersistenceHandler#getFieldGroups(Page, PageTemplate)}
   * with {@code page}, {@code template}.
   * <ul>
   *   <li>When {@link PageImpl} (default constructor).</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PageTemplateCustomPersistenceHandler#getFieldGroups(Page, PageTemplate)}
   */
  @Test
  public void testGetFieldGroupsWithPageTemplate_whenPageImpl_thenReturnEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PageTemplateCustomPersistenceHandler pageTemplateCustomPersistenceHandler = new PageTemplateCustomPersistenceHandler();
    PageImpl page = new PageImpl();

    // Act and Assert
    assertTrue(pageTemplateCustomPersistenceHandler.getFieldGroups(page, new PageTemplateImpl()).isEmpty());
  }

  /**
   * Test
   * {@link PageTemplateCustomPersistenceHandler#getFieldGroups(PersistencePackage, DynamicEntityDao)}
   * with {@code pp}, {@code dynamicEntityDao}.
   * <p>
   * Method under test:
   * {@link PageTemplateCustomPersistenceHandler#getFieldGroups(PersistencePackage, DynamicEntityDao)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetFieldGroupsWithPpDynamicEntityDao() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.admin.server.handler;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-applicationContext-entity.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass945 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.admin.server.handler.PageTemplateCustomPersistenceHandler pageTemplateCustomPersistenceHandler;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    PageTemplateCustomPersistenceHandler pageTemplateCustomPersistenceHandler2 = new PageTemplateCustomPersistenceHandler();
    PersistencePackage pp = new PersistencePackage();

    // Act
    pageTemplateCustomPersistenceHandler2.getFieldGroups(pp, new DynamicEntityDaoImpl());
  }

  /**
   * Test
   * {@link PageTemplateCustomPersistenceHandler#getFieldGroups(PersistencePackage, DynamicEntityDao)}
   * with {@code pp}, {@code dynamicEntityDao}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PageTemplateCustomPersistenceHandler#getFieldGroups(PersistencePackage, DynamicEntityDao)}
   */
  @Test
  public void testGetFieldGroupsWithPpDynamicEntityDao_thenReturnEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PageTemplateCustomPersistenceHandler pageTemplateCustomPersistenceHandler = new PageTemplateCustomPersistenceHandler();
    PersistencePackage pp = mock(PersistencePackage.class);
    when(pp.getCustomCriteria()).thenReturn(new String[]{"foo", null});

    // Act
    List<FieldGroup> actualFieldGroups = pageTemplateCustomPersistenceHandler.getFieldGroups(pp,
        new DynamicEntityDaoImpl());

    // Assert
    verify(pp, atLeast(1)).getCustomCriteria();
    assertTrue(actualFieldGroups.isEmpty());
  }

  /**
   * Test
   * {@link PageTemplateCustomPersistenceHandler#inspect(PersistencePackage, DynamicEntityDao, InspectHelper)}.
   * <p>
   * Method under test:
   * {@link PageTemplateCustomPersistenceHandler#inspect(PersistencePackage, DynamicEntityDao, InspectHelper)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testInspect() throws ServiceException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.admin.server.handler;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-applicationContext-entity.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass983 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.admin.server.handler.PageTemplateCustomPersistenceHandler pageTemplateCustomPersistenceHandler;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    PageTemplateCustomPersistenceHandler pageTemplateCustomPersistenceHandler2 = new PageTemplateCustomPersistenceHandler();
    PersistencePackage persistencePackage = new PersistencePackage();
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    // Act
    pageTemplateCustomPersistenceHandler2.inspect(persistencePackage, dynamicEntityDao, new PersistenceManagerImpl());
  }

  /**
   * Test
   * {@link PageTemplateCustomPersistenceHandler#inspect(PersistencePackage, DynamicEntityDao, InspectHelper)}.
   * <ul>
   *   <li>Then throw {@link ServiceException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PageTemplateCustomPersistenceHandler#inspect(PersistencePackage, DynamicEntityDao, InspectHelper)}
   */
  @Test
  public void testInspect_thenThrowServiceException() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PageTemplateCustomPersistenceHandler pageTemplateCustomPersistenceHandler = new PageTemplateCustomPersistenceHandler();
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getCeilingEntityFullyQualifiedClassname()).thenReturn("Dr Jane Doe");
    when(persistencePackage.getCustomCriteria())
        .thenReturn(new String[]{"Unable to perform inspect for entity: ", "foo"});
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    // Act and Assert
    assertThrows(ServiceException.class, () -> pageTemplateCustomPersistenceHandler.inspect(persistencePackage,
        dynamicEntityDao, new PersistenceManagerImpl()));
    verify(persistencePackage).getCeilingEntityFullyQualifiedClassname();
    verify(persistencePackage, atLeast(1)).getCustomCriteria();
  }

  /**
   * Test
   * {@link PageTemplateCustomPersistenceHandler#fetch(PersistencePackage, CriteriaTransferObject, DynamicEntityDao, RecordHelper)}.
   * <p>
   * Method under test:
   * {@link PageTemplateCustomPersistenceHandler#fetch(PersistencePackage, CriteriaTransferObject, DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testFetch() throws ServiceException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.admin.server.handler;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-applicationContext-entity.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass744 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.admin.server.handler.PageTemplateCustomPersistenceHandler pageTemplateCustomPersistenceHandler;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    PageTemplateCustomPersistenceHandler pageTemplateCustomPersistenceHandler2 = new PageTemplateCustomPersistenceHandler();
    PersistencePackage persistencePackage = new PersistencePackage();
    CriteriaTransferObject cto = new CriteriaTransferObject();
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    // Act
    pageTemplateCustomPersistenceHandler2.fetch(persistencePackage, cto, dynamicEntityDao,
        new AdornedTargetListPersistenceModule());
  }

  /**
   * Test
   * {@link PageTemplateCustomPersistenceHandler#fetch(PersistencePackage, CriteriaTransferObject, DynamicEntityDao, RecordHelper)}.
   * <ul>
   *   <li>Then throw {@link ServiceException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PageTemplateCustomPersistenceHandler#fetch(PersistencePackage, CriteriaTransferObject, DynamicEntityDao, RecordHelper)}
   */
  @Test
  public void testFetch_thenThrowServiceException() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PageTemplateCustomPersistenceHandler pageTemplateCustomPersistenceHandler = new PageTemplateCustomPersistenceHandler();
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getCeilingEntityFullyQualifiedClassname()).thenReturn("Dr Jane Doe");
    when(persistencePackage.getCustomCriteria())
        .thenReturn(new String[]{"Unable to perform fetch for entity: ", "foo"});
    CriteriaTransferObject cto = new CriteriaTransferObject();
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    // Act and Assert
    assertThrows(ServiceException.class, () -> pageTemplateCustomPersistenceHandler.fetch(persistencePackage, cto,
        dynamicEntityDao, new AdornedTargetListPersistenceModule()));
    verify(persistencePackage).getCeilingEntityFullyQualifiedClassname();
    verify(persistencePackage).getCustomCriteria();
  }

  /**
   * Test
   * {@link PageTemplateCustomPersistenceHandler#populateFKLookupValues(DynamicEntityDao, Entity)}.
   * <p>
   * Method under test:
   * {@link PageTemplateCustomPersistenceHandler#populateFKLookupValues(DynamicEntityDao, Entity)}
   */
  @Test
  public void testPopulateFKLookupValues() throws ClassNotFoundException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PageTemplateCustomPersistenceHandler pageTemplateCustomPersistenceHandler = new PageTemplateCustomPersistenceHandler();
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();
    Property property = mock(Property.class);
    when(property.getMetadata()).thenReturn(new AdornedTargetCollectionMetadata());
    when(property.getValue()).thenReturn("42");
    Entity entity = mock(Entity.class);
    when(entity.getProperties()).thenReturn(new Property[]{property});

    // Act
    pageTemplateCustomPersistenceHandler.populateFKLookupValues(dynamicEntityDao, entity);

    // Assert
    verify(entity).getProperties();
    verify(property).getMetadata();
    verify(property).getValue();
  }

  /**
   * Test
   * {@link PageTemplateCustomPersistenceHandler#populateFKLookupValues(DynamicEntityDao, Entity)}.
   * <p>
   * Method under test:
   * {@link PageTemplateCustomPersistenceHandler#populateFKLookupValues(DynamicEntityDao, Entity)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testPopulateFKLookupValues2() throws ClassNotFoundException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.admin.server.handler;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-applicationContext-entity.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1032 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.admin.server.handler.PageTemplateCustomPersistenceHandler pageTemplateCustomPersistenceHandler;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    PageTemplateCustomPersistenceHandler pageTemplateCustomPersistenceHandler2 = new PageTemplateCustomPersistenceHandler();
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    // Act
    pageTemplateCustomPersistenceHandler2.populateFKLookupValues(dynamicEntityDao, new Entity());
  }

  /**
   * Test
   * {@link PageTemplateCustomPersistenceHandler#populateFKLookupValues(DynamicEntityDao, Entity)}.
   * <ul>
   *   <li>Given array of {@link Property} with {@link Property#Property()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PageTemplateCustomPersistenceHandler#populateFKLookupValues(DynamicEntityDao, Entity)}
   */
  @Test
  public void testPopulateFKLookupValues_givenArrayOfPropertyWithProperty() throws ClassNotFoundException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PageTemplateCustomPersistenceHandler pageTemplateCustomPersistenceHandler = new PageTemplateCustomPersistenceHandler();
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();
    Entity entity = mock(Entity.class);
    when(entity.getProperties()).thenReturn(new Property[]{new Property()});

    // Act
    pageTemplateCustomPersistenceHandler.populateFKLookupValues(dynamicEntityDao, entity);

    // Assert
    verify(entity).getProperties();
  }

  /**
   * Test
   * {@link PageTemplateCustomPersistenceHandler#populateFKLookupValues(DynamicEntityDao, Entity)}.
   * <ul>
   *   <li>Given array of {@link Property} with
   * {@link Property#Property(String, String)} with {@code Name} and value is
   * {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PageTemplateCustomPersistenceHandler#populateFKLookupValues(DynamicEntityDao, Entity)}
   */
  @Test
  public void testPopulateFKLookupValues_givenArrayOfPropertyWithPropertyWithNameAndValueIs42()
      throws ClassNotFoundException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PageTemplateCustomPersistenceHandler pageTemplateCustomPersistenceHandler = new PageTemplateCustomPersistenceHandler();
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();
    Entity entity = mock(Entity.class);
    when(entity.getProperties()).thenReturn(new Property[]{new Property("Name", "42")});

    // Act
    pageTemplateCustomPersistenceHandler.populateFKLookupValues(dynamicEntityDao, entity);

    // Assert
    verify(entity).getProperties();
  }

  /**
   * Test
   * {@link PageTemplateCustomPersistenceHandler#populateFKLookupValues(DynamicEntityDao, Entity)}.
   * <ul>
   *   <li>Then throw {@link NumberFormatException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PageTemplateCustomPersistenceHandler#populateFKLookupValues(DynamicEntityDao, Entity)}
   */
  @Test
  public void testPopulateFKLookupValues_thenThrowNumberFormatException() throws ClassNotFoundException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PageTemplateCustomPersistenceHandler pageTemplateCustomPersistenceHandler = new PageTemplateCustomPersistenceHandler();
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();
    Property property = mock(Property.class);
    when(property.getMetadata()).thenThrow(new NumberFormatException("foo"));
    when(property.getValue()).thenReturn("42");
    Entity entity = mock(Entity.class);
    when(entity.getProperties()).thenReturn(new Property[]{property});

    // Act and Assert
    assertThrows(NumberFormatException.class,
        () -> pageTemplateCustomPersistenceHandler.populateFKLookupValues(dynamicEntityDao, entity));
    verify(entity).getProperties();
    verify(property).getMetadata();
    verify(property).getValue();
  }

  /**
   * Test
   * {@link PageTemplateCustomPersistenceHandler#getFieldContainerClassName()}.
   * <p>
   * Method under test:
   * {@link PageTemplateCustomPersistenceHandler#getFieldContainerClassName()}
   */
  @Test
  public void testGetFieldContainerClassName() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("org.broadleafcommerce.cms.page.domain.Page",
        (new PageTemplateCustomPersistenceHandler()).getFieldContainerClassName());
  }

  /**
   * Test
   * {@link PageTemplateCustomPersistenceHandler#getFieldContainerClassName()}.
   * <p>
   * Method under test:
   * {@link PageTemplateCustomPersistenceHandler#getFieldContainerClassName()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetFieldContainerClassName2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.admin.server.handler;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-applicationContext-entity.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass908 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.admin.server.handler.PageTemplateCustomPersistenceHandler pageTemplateCustomPersistenceHandler;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new PageTemplateCustomPersistenceHandler()).getFieldContainerClassName();
  }

  /**
   * Test
   * {@link PageTemplateCustomPersistenceHandler#fetchEntityBasedOnId(String, List)}.
   * <p>
   * Method under test:
   * {@link PageTemplateCustomPersistenceHandler#fetchEntityBasedOnId(String, List)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testFetchEntityBasedOnId() throws Exception {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.admin.server.handler;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-applicationContext-entity.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass891 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.admin.server.handler.PageTemplateCustomPersistenceHandler pageTemplateCustomPersistenceHandler;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    PageTemplateCustomPersistenceHandler pageTemplateCustomPersistenceHandler2 = new PageTemplateCustomPersistenceHandler();

    // Act
    pageTemplateCustomPersistenceHandler2.fetchEntityBasedOnId("42", new ArrayList<>());
  }

  /**
   * Test
   * {@link PageTemplateCustomPersistenceHandler#fetchDynamicEntity(Serializable, List, boolean)}.
   * <p>
   * Method under test:
   * {@link PageTemplateCustomPersistenceHandler#fetchDynamicEntity(Serializable, List, boolean)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testFetchDynamicEntity() throws Exception {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.admin.server.handler;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-applicationContext-entity.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass814 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.admin.server.handler.PageTemplateCustomPersistenceHandler pageTemplateCustomPersistenceHandler;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    PageTemplateCustomPersistenceHandler pageTemplateCustomPersistenceHandler2 = new PageTemplateCustomPersistenceHandler();
    SimpleDateFormat root = new SimpleDateFormat("yyyy/mm/dd");

    // Act
    pageTemplateCustomPersistenceHandler2.fetchDynamicEntity(root, new ArrayList<>(), true);
  }

  /**
   * Test
   * {@link PageTemplateCustomPersistenceHandler#fetchDynamicEntity(Serializable, List, boolean)}.
   * <ul>
   *   <li>Given {@link java.sql.Date}.</li>
   *   <li>When {@link PageImpl} (default constructor) ActiveEndDate is
   * {@link java.sql.Date}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PageTemplateCustomPersistenceHandler#fetchDynamicEntity(Serializable, List, boolean)}
   */
  @Test
  public void testFetchDynamicEntity_givenDate_whenPageImplActiveEndDateIsDate() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PageTemplateCustomPersistenceHandler pageTemplateCustomPersistenceHandler = new PageTemplateCustomPersistenceHandler();

    PageImpl root = new PageImpl();
    root.setActiveEndDate(mock(java.sql.Date.class));
    root.setActiveStartDate(
        java.util.Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    root.setAdditionalAttributes(new HashMap<>());
    root.setDescription("The characteristics of someone or something");
    root.setExcludeFromSiteMap(true);
    root.setFullUrl("https://example.org/example");
    root.setId(1L);
    root.setMetaDescription("Meta Description");
    root.setMetaTitle("Dr");
    root.setOfflineFlag(true);
    root.setPageMatchRules(new HashMap<>());
    root.setPriority(1);
    root.setQualifyingItemCriteria(new HashSet<>());
    root.setPageFields(null);
    root.setPageTemplate(new PageTemplateImpl());

    // Act
    Entity actualFetchDynamicEntityResult = pageTemplateCustomPersistenceHandler.fetchDynamicEntity(root,
        new ArrayList<>(), false);

    // Assert
    assertNull(actualFetchDynamicEntityResult.getDeployDate());
    assertEquals(0, actualFetchDynamicEntityResult.getProperties().length);
    assertFalse(actualFetchDynamicEntityResult.getActive());
    assertFalse(actualFetchDynamicEntityResult.getDeleted());
    assertFalse(actualFetchDynamicEntityResult.getInactive());
    assertFalse(actualFetchDynamicEntityResult.isDirty());
    assertFalse(actualFetchDynamicEntityResult.isMultiPartAvailableOnThread());
    assertFalse(actualFetchDynamicEntityResult.isPreAdd());
    assertTrue(actualFetchDynamicEntityResult.getGlobalValidationErrors().isEmpty());
    assertTrue(actualFetchDynamicEntityResult.getPMap().isEmpty());
    Map<String, List<String>> propertyValidationErrors = actualFetchDynamicEntityResult.getPropertyValidationErrors();
    assertTrue(propertyValidationErrors.isEmpty());
    assertSame(propertyValidationErrors, actualFetchDynamicEntityResult.getValidationErrors());
    assertArrayEquals(new String[]{"org.broadleafcommerce.cms.page.domain.PageTemplateImpl"},
        actualFetchDynamicEntityResult.getType());
  }

  /**
   * Test
   * {@link PageTemplateCustomPersistenceHandler#fetchDynamicEntity(Serializable, List, boolean)}.
   * <ul>
   *   <li>Given {@link PageTemplateImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PageTemplateCustomPersistenceHandler#fetchDynamicEntity(Serializable, List, boolean)}
   */
  @Test
  public void testFetchDynamicEntity_givenPageTemplateImpl() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PageTemplateCustomPersistenceHandler pageTemplateCustomPersistenceHandler = new PageTemplateCustomPersistenceHandler();

    PageImpl root = new PageImpl();
    root.setActiveEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    root.setActiveStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    root.setAdditionalAttributes(new HashMap<>());
    root.setDescription("The characteristics of someone or something");
    root.setExcludeFromSiteMap(true);
    root.setFullUrl("https://example.org/example");
    root.setId(1L);
    root.setMetaDescription("Meta Description");
    root.setMetaTitle("Dr");
    root.setOfflineFlag(true);
    root.setPageMatchRules(new HashMap<>());
    root.setPriority(1);
    root.setQualifyingItemCriteria(new HashSet<>());
    root.setPageFields(null);
    root.setPageTemplate(new PageTemplateImpl());

    // Act
    Entity actualFetchDynamicEntityResult = pageTemplateCustomPersistenceHandler.fetchDynamicEntity(root, null, false);

    // Assert
    assertNull(actualFetchDynamicEntityResult.getDeployDate());
    assertEquals(0, actualFetchDynamicEntityResult.getProperties().length);
    assertFalse(actualFetchDynamicEntityResult.getActive());
    assertFalse(actualFetchDynamicEntityResult.getDeleted());
    assertFalse(actualFetchDynamicEntityResult.getInactive());
    assertFalse(actualFetchDynamicEntityResult.isDirty());
    assertFalse(actualFetchDynamicEntityResult.isMultiPartAvailableOnThread());
    assertFalse(actualFetchDynamicEntityResult.isPreAdd());
    assertTrue(actualFetchDynamicEntityResult.getGlobalValidationErrors().isEmpty());
    assertTrue(actualFetchDynamicEntityResult.getPMap().isEmpty());
    Map<String, List<String>> propertyValidationErrors = actualFetchDynamicEntityResult.getPropertyValidationErrors();
    assertTrue(propertyValidationErrors.isEmpty());
    assertSame(propertyValidationErrors, actualFetchDynamicEntityResult.getValidationErrors());
    assertArrayEquals(new String[]{"org.broadleafcommerce.cms.page.domain.PageTemplateImpl"},
        actualFetchDynamicEntityResult.getType());
  }

  /**
   * Test
   * {@link PageTemplateCustomPersistenceHandler#fetchDynamicEntity(Serializable, List, boolean)}.
   * <ul>
   *   <li>When {@link PageImpl} (default constructor) PageTemplate is
   * {@code null}.</li>
   *   <li>Then return DeployDate is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PageTemplateCustomPersistenceHandler#fetchDynamicEntity(Serializable, List, boolean)}
   */
  @Test
  public void testFetchDynamicEntity_whenPageImplPageTemplateIsNull_thenReturnDeployDateIsNull() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PageTemplateCustomPersistenceHandler pageTemplateCustomPersistenceHandler = new PageTemplateCustomPersistenceHandler();

    PageImpl root = new PageImpl();
    root.setActiveEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    root.setActiveStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    root.setAdditionalAttributes(new HashMap<>());
    root.setDescription("The characteristics of someone or something");
    root.setExcludeFromSiteMap(true);
    root.setFullUrl("https://example.org/example");
    root.setId(1L);
    root.setMetaDescription("Meta Description");
    root.setMetaTitle("Dr");
    root.setOfflineFlag(true);
    root.setPageMatchRules(new HashMap<>());
    root.setPriority(1);
    root.setQualifyingItemCriteria(new HashSet<>());
    root.setPageFields(null);
    root.setPageTemplate(null);

    // Act
    Entity actualFetchDynamicEntityResult = pageTemplateCustomPersistenceHandler.fetchDynamicEntity(root, null, false);

    // Assert
    assertNull(actualFetchDynamicEntityResult.getDeployDate());
    assertEquals(0, actualFetchDynamicEntityResult.getProperties().length);
    assertFalse(actualFetchDynamicEntityResult.getActive());
    assertFalse(actualFetchDynamicEntityResult.getDeleted());
    assertFalse(actualFetchDynamicEntityResult.getInactive());
    assertFalse(actualFetchDynamicEntityResult.isDirty());
    assertFalse(actualFetchDynamicEntityResult.isMultiPartAvailableOnThread());
    assertFalse(actualFetchDynamicEntityResult.isPreAdd());
    assertTrue(actualFetchDynamicEntityResult.getGlobalValidationErrors().isEmpty());
    assertTrue(actualFetchDynamicEntityResult.getPMap().isEmpty());
    Map<String, List<String>> propertyValidationErrors = actualFetchDynamicEntityResult.getPropertyValidationErrors();
    assertTrue(propertyValidationErrors.isEmpty());
    assertSame(propertyValidationErrors, actualFetchDynamicEntityResult.getValidationErrors());
    assertArrayEquals(new String[]{"org.broadleafcommerce.cms.page.domain.PageTemplateImpl"},
        actualFetchDynamicEntityResult.getType());
  }

  /**
   * Test
   * {@link PageTemplateCustomPersistenceHandler#fetchDynamicEntity(Serializable, List, boolean)}.
   * <ul>
   *   <li>When {@link PageImpl} (default constructor) PageTemplate is
   * {@code null}.</li>
   *   <li>Then return DeployDate is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PageTemplateCustomPersistenceHandler#fetchDynamicEntity(Serializable, List, boolean)}
   */
  @Test
  public void testFetchDynamicEntity_whenPageImplPageTemplateIsNull_thenReturnDeployDateIsNull2() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PageTemplateCustomPersistenceHandler pageTemplateCustomPersistenceHandler = new PageTemplateCustomPersistenceHandler();

    PageImpl root = new PageImpl();
    root.setActiveEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    root.setActiveStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    root.setAdditionalAttributes(new HashMap<>());
    root.setDescription("The characteristics of someone or something");
    root.setExcludeFromSiteMap(true);
    root.setFullUrl("https://example.org/example");
    root.setId(1L);
    root.setMetaDescription("Meta Description");
    root.setMetaTitle("Dr");
    root.setOfflineFlag(true);
    root.setPageMatchRules(new HashMap<>());
    root.setPriority(1);
    root.setQualifyingItemCriteria(new HashSet<>());
    root.setPageFields(null);
    root.setPageTemplate(null);

    // Act
    Entity actualFetchDynamicEntityResult = pageTemplateCustomPersistenceHandler.fetchDynamicEntity(root,
        new ArrayList<>(), false);

    // Assert
    assertNull(actualFetchDynamicEntityResult.getDeployDate());
    assertEquals(0, actualFetchDynamicEntityResult.getProperties().length);
    assertFalse(actualFetchDynamicEntityResult.getActive());
    assertFalse(actualFetchDynamicEntityResult.getDeleted());
    assertFalse(actualFetchDynamicEntityResult.getInactive());
    assertFalse(actualFetchDynamicEntityResult.isDirty());
    assertFalse(actualFetchDynamicEntityResult.isMultiPartAvailableOnThread());
    assertFalse(actualFetchDynamicEntityResult.isPreAdd());
    assertTrue(actualFetchDynamicEntityResult.getGlobalValidationErrors().isEmpty());
    assertTrue(actualFetchDynamicEntityResult.getPMap().isEmpty());
    Map<String, List<String>> propertyValidationErrors = actualFetchDynamicEntityResult.getPropertyValidationErrors();
    assertTrue(propertyValidationErrors.isEmpty());
    assertSame(propertyValidationErrors, actualFetchDynamicEntityResult.getValidationErrors());
    assertArrayEquals(new String[]{"org.broadleafcommerce.cms.page.domain.PageTemplateImpl"},
        actualFetchDynamicEntityResult.getType());
  }

  /**
   * Test
   * {@link PageTemplateCustomPersistenceHandler#processFieldGroups(List, Map, List, List)}.
   * <p>
   * Method under test:
   * {@link PageTemplateCustomPersistenceHandler#processFieldGroups(List, Map, List, List)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testProcessFieldGroups() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.admin.server.handler;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-applicationContext-entity.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1064 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.admin.server.handler.PageTemplateCustomPersistenceHandler pageTemplateCustomPersistenceHandler;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    PageTemplateCustomPersistenceHandler pageTemplateCustomPersistenceHandler2 = new PageTemplateCustomPersistenceHandler();
    ArrayList<String> dirtyFields = new ArrayList<>();
    HashMap<String, PageField> pageFieldMap = new HashMap<>();
    ArrayList<Property> propertiesList = new ArrayList<>();

    // Act
    pageTemplateCustomPersistenceHandler2.processFieldGroups(dirtyFields, pageFieldMap, propertiesList,
        new ArrayList<>());
  }

  /**
   * Test
   * {@link PageTemplateCustomPersistenceHandler#processFieldGroups(List, Map, List, List)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.</li>
   *   <li>Then {@link ArrayList#ArrayList()} Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PageTemplateCustomPersistenceHandler#processFieldGroups(List, Map, List, List)}
   */
  @Test
  public void testProcessFieldGroups_given42_whenArrayListAdd42_thenArrayListEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PageTemplateCustomPersistenceHandler pageTemplateCustomPersistenceHandler = new PageTemplateCustomPersistenceHandler();

    ArrayList<String> dirtyFields = new ArrayList<>();
    dirtyFields.add("42");
    dirtyFields.add("foo");
    HashMap<String, PageField> pageFieldMap = new HashMap<>();
    ArrayList<Property> propertiesList = new ArrayList<>();

    // Act
    pageTemplateCustomPersistenceHandler.processFieldGroups(dirtyFields, pageFieldMap, propertiesList,
        new ArrayList<>());

    // Assert that nothing has changed
    assertTrue(propertiesList.isEmpty());
  }

  /**
   * Test
   * {@link PageTemplateCustomPersistenceHandler#processFieldGroups(List, Map, List, List)}.
   * <ul>
   *   <li>Given {@link BiFunction}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PageTemplateCustomPersistenceHandler#processFieldGroups(List, Map, List, List)}
   */
  @Test
  public void testProcessFieldGroups_givenBiFunction() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PageTemplateCustomPersistenceHandler pageTemplateCustomPersistenceHandler = new PageTemplateCustomPersistenceHandler();
    ArrayList<String> dirtyFields = new ArrayList<>();

    HashMap<String, PageField> pageFieldMap = new HashMap<>();
    pageFieldMap.computeIfPresent("foo", mock(BiFunction.class));
    ArrayList<Property> propertiesList = new ArrayList<>();

    // Act
    pageTemplateCustomPersistenceHandler.processFieldGroups(dirtyFields, pageFieldMap, propertiesList,
        new ArrayList<>());

    // Assert that nothing has changed
    assertTrue(propertiesList.isEmpty());
  }

  /**
   * Test
   * {@link PageTemplateCustomPersistenceHandler#processFieldGroups(List, Map, List, List)}.
   * <ul>
   *   <li>Given {@link FieldGroupImpl} (default constructor).</li>
   *   <li>Then {@link ArrayList#ArrayList()} Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PageTemplateCustomPersistenceHandler#processFieldGroups(List, Map, List, List)}
   */
  @Test
  public void testProcessFieldGroups_givenFieldGroupImpl_thenArrayListEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PageTemplateCustomPersistenceHandler pageTemplateCustomPersistenceHandler = new PageTemplateCustomPersistenceHandler();
    ArrayList<String> dirtyFields = new ArrayList<>();
    HashMap<String, PageField> pageFieldMap = new HashMap<>();
    ArrayList<Property> propertiesList = new ArrayList<>();

    ArrayList<FieldGroup> fieldGroups = new ArrayList<>();
    fieldGroups.add(new FieldGroupImpl());
    fieldGroups.add(new FieldGroupImpl());

    // Act
    pageTemplateCustomPersistenceHandler.processFieldGroups(dirtyFields, pageFieldMap, propertiesList, fieldGroups);

    // Assert that nothing has changed
    assertTrue(propertiesList.isEmpty());
  }

  /**
   * Test
   * {@link PageTemplateCustomPersistenceHandler#processFieldGroups(List, Map, List, List)}.
   * <ul>
   *   <li>Given {@code foo}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code foo}.</li>
   *   <li>Then {@link ArrayList#ArrayList()} Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PageTemplateCustomPersistenceHandler#processFieldGroups(List, Map, List, List)}
   */
  @Test
  public void testProcessFieldGroups_givenFoo_whenArrayListAddFoo_thenArrayListEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PageTemplateCustomPersistenceHandler pageTemplateCustomPersistenceHandler = new PageTemplateCustomPersistenceHandler();

    ArrayList<String> dirtyFields = new ArrayList<>();
    dirtyFields.add("foo");
    HashMap<String, PageField> pageFieldMap = new HashMap<>();
    ArrayList<Property> propertiesList = new ArrayList<>();

    // Act
    pageTemplateCustomPersistenceHandler.processFieldGroups(dirtyFields, pageFieldMap, propertiesList,
        new ArrayList<>());

    // Assert that nothing has changed
    assertTrue(propertiesList.isEmpty());
  }

  /**
   * Test
   * {@link PageTemplateCustomPersistenceHandler#processFieldGroups(List, Map, List, List)}.
   * <ul>
   *   <li>Then {@link ArrayList#ArrayList()} first Name is empty string.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PageTemplateCustomPersistenceHandler#processFieldGroups(List, Map, List, List)}
   */
  @Test
  public void testProcessFieldGroups_thenArrayListFirstNameIsEmptyString() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PageTemplateCustomPersistenceHandler pageTemplateCustomPersistenceHandler = new PageTemplateCustomPersistenceHandler();
    HashMap<String, PageField> pageFieldMap = new HashMap<>();
    ArrayList<Property> propertiesList = new ArrayList<>();

    ArrayList<FieldDefinition> fieldDefinitions = new ArrayList<>();
    fieldDefinitions.add(new FieldDefinitionImpl());

    FieldGroupImpl fieldGroupImpl = new FieldGroupImpl();
    fieldGroupImpl.setFieldGroupXrefs(new ArrayList<>());
    fieldGroupImpl.setId(1L);
    fieldGroupImpl.setInitCollapsedFlag(true);
    fieldGroupImpl.setIsMasterFieldGroup(true);
    fieldGroupImpl.setName("Name");
    fieldGroupImpl.setFieldDefinitions(fieldDefinitions);

    ArrayList<FieldGroup> fieldGroups = new ArrayList<>();
    fieldGroups.add(fieldGroupImpl);

    // Act
    pageTemplateCustomPersistenceHandler.processFieldGroups(null, pageFieldMap, propertiesList, fieldGroups);

    // Assert
    assertEquals(1, propertiesList.size());
    Property getResult = propertiesList.get(0);
    FieldMetadata metadata = getResult.getMetadata();
    assertTrue(metadata instanceof BasicFieldMetadata);
    assertEquals("", getResult.getName());
    assertNull(metadata.getOwningClass());
    assertFalse(getResult.getIsDirty());
  }

  /**
   * Test
   * {@link PageTemplateCustomPersistenceHandler#processFieldGroups(List, Map, List, List)}.
   * <ul>
   *   <li>Then {@link ArrayList#ArrayList()} first Name is empty string.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PageTemplateCustomPersistenceHandler#processFieldGroups(List, Map, List, List)}
   */
  @Test
  public void testProcessFieldGroups_thenArrayListFirstNameIsEmptyString2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PageTemplateCustomPersistenceHandler pageTemplateCustomPersistenceHandler = new PageTemplateCustomPersistenceHandler();
    ArrayList<Property> propertiesList = new ArrayList<>();

    ArrayList<FieldDefinition> fieldDefinitions = new ArrayList<>();
    fieldDefinitions.add(new FieldDefinitionImpl());

    FieldGroupImpl fieldGroupImpl = new FieldGroupImpl();
    fieldGroupImpl.setFieldGroupXrefs(new ArrayList<>());
    fieldGroupImpl.setId(1L);
    fieldGroupImpl.setInitCollapsedFlag(true);
    fieldGroupImpl.setIsMasterFieldGroup(true);
    fieldGroupImpl.setName("Name");
    fieldGroupImpl.setFieldDefinitions(fieldDefinitions);

    ArrayList<FieldGroup> fieldGroups = new ArrayList<>();
    fieldGroups.add(fieldGroupImpl);

    // Act
    pageTemplateCustomPersistenceHandler.processFieldGroups(null, null, propertiesList, fieldGroups);

    // Assert
    assertEquals(1, propertiesList.size());
    Property getResult = propertiesList.get(0);
    FieldMetadata metadata = getResult.getMetadata();
    assertTrue(metadata instanceof BasicFieldMetadata);
    assertEquals("", getResult.getName());
    assertNull(metadata.getOwningClass());
    assertFalse(getResult.getIsDirty());
  }

  /**
   * Test
   * {@link PageTemplateCustomPersistenceHandler#processFieldGroups(List, Map, List, List)}.
   * <ul>
   *   <li>Then {@link ArrayList#ArrayList()} first Name is empty string.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PageTemplateCustomPersistenceHandler#processFieldGroups(List, Map, List, List)}
   */
  @Test
  public void testProcessFieldGroups_thenArrayListFirstNameIsEmptyString3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PageTemplateCustomPersistenceHandler pageTemplateCustomPersistenceHandler = new PageTemplateCustomPersistenceHandler();
    ArrayList<String> dirtyFields = new ArrayList<>();
    HashMap<String, PageField> pageFieldMap = new HashMap<>();
    ArrayList<Property> propertiesList = new ArrayList<>();

    ArrayList<FieldDefinition> fieldDefinitions = new ArrayList<>();
    fieldDefinitions.add(new FieldDefinitionImpl());

    FieldGroupImpl fieldGroupImpl = new FieldGroupImpl();
    fieldGroupImpl.setFieldGroupXrefs(new ArrayList<>());
    fieldGroupImpl.setId(1L);
    fieldGroupImpl.setInitCollapsedFlag(true);
    fieldGroupImpl.setIsMasterFieldGroup(true);
    fieldGroupImpl.setName("Name");
    fieldGroupImpl.setFieldDefinitions(fieldDefinitions);

    ArrayList<FieldGroup> fieldGroups = new ArrayList<>();
    fieldGroups.add(fieldGroupImpl);

    // Act
    pageTemplateCustomPersistenceHandler.processFieldGroups(dirtyFields, pageFieldMap, propertiesList, fieldGroups);

    // Assert
    assertEquals(1, propertiesList.size());
    Property getResult = propertiesList.get(0);
    FieldMetadata metadata = getResult.getMetadata();
    assertTrue(metadata instanceof BasicFieldMetadata);
    assertEquals("", getResult.getName());
    assertNull(metadata.getOwningClass());
    assertFalse(getResult.getIsDirty());
  }

  /**
   * Test
   * {@link PageTemplateCustomPersistenceHandler#processFieldGroups(List, Map, List, List)}.
   * <ul>
   *   <li>Then {@link ArrayList#ArrayList()} first Name is {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PageTemplateCustomPersistenceHandler#processFieldGroups(List, Map, List, List)}
   */
  @Test
  public void testProcessFieldGroups_thenArrayListFirstNameIsFoo() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PageTemplateCustomPersistenceHandler pageTemplateCustomPersistenceHandler = new PageTemplateCustomPersistenceHandler();

    ArrayList<String> dirtyFields = new ArrayList<>();
    dirtyFields.add("foo");
    HashMap<String, PageField> pageFieldMap = new HashMap<>();
    ArrayList<Property> propertiesList = new ArrayList<>();
    FieldDefinitionImpl fieldDefinitionImpl = mock(FieldDefinitionImpl.class);
    when(fieldDefinitionImpl.getAdditionalForeignKeyClass()).thenReturn("Additional Foreign Key Class");
    when(fieldDefinitionImpl.getName()).thenReturn("foo");

    ArrayList<FieldDefinition> fieldDefinitions = new ArrayList<>();
    fieldDefinitions.add(fieldDefinitionImpl);

    FieldGroupImpl fieldGroupImpl = new FieldGroupImpl();
    fieldGroupImpl.setFieldGroupXrefs(new ArrayList<>());
    fieldGroupImpl.setId(1L);
    fieldGroupImpl.setInitCollapsedFlag(true);
    fieldGroupImpl.setIsMasterFieldGroup(true);
    fieldGroupImpl.setName("Name");
    fieldGroupImpl.setFieldDefinitions(fieldDefinitions);

    ArrayList<FieldGroup> fieldGroups = new ArrayList<>();
    fieldGroups.add(fieldGroupImpl);

    // Act
    pageTemplateCustomPersistenceHandler.processFieldGroups(dirtyFields, pageFieldMap, propertiesList, fieldGroups);

    // Assert
    verify(fieldDefinitionImpl, atLeast(1)).getAdditionalForeignKeyClass();
    verify(fieldDefinitionImpl).getName();
    assertEquals(1, propertiesList.size());
    Property getResult = propertiesList.get(0);
    FieldMetadata metadata = getResult.getMetadata();
    assertTrue(metadata instanceof BasicFieldMetadata);
    assertEquals("Additional Foreign Key Class", metadata.getOwningClass());
    assertEquals("foo", getResult.getName());
    assertTrue(getResult.getIsDirty());
  }

  /**
   * Test
   * {@link PageTemplateCustomPersistenceHandler#processFieldGroups(List, Map, List, List)}.
   * <ul>
   *   <li>Then {@link ArrayList#ArrayList()} first Name is {@code Name}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PageTemplateCustomPersistenceHandler#processFieldGroups(List, Map, List, List)}
   */
  @Test
  public void testProcessFieldGroups_thenArrayListFirstNameIsName() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PageTemplateCustomPersistenceHandler pageTemplateCustomPersistenceHandler = new PageTemplateCustomPersistenceHandler();
    HashMap<String, PageField> pageFieldMap = new HashMap<>();
    ArrayList<Property> propertiesList = new ArrayList<>();
    FieldDefinitionImpl fieldDefinitionImpl = mock(FieldDefinitionImpl.class);
    when(fieldDefinitionImpl.getAdditionalForeignKeyClass()).thenReturn("Additional Foreign Key Class");
    when(fieldDefinitionImpl.getName()).thenReturn("Name");

    ArrayList<FieldDefinition> fieldDefinitions = new ArrayList<>();
    fieldDefinitions.add(fieldDefinitionImpl);

    FieldGroupImpl fieldGroupImpl = new FieldGroupImpl();
    fieldGroupImpl.setFieldGroupXrefs(new ArrayList<>());
    fieldGroupImpl.setId(1L);
    fieldGroupImpl.setInitCollapsedFlag(true);
    fieldGroupImpl.setIsMasterFieldGroup(true);
    fieldGroupImpl.setName("Name");
    fieldGroupImpl.setFieldDefinitions(fieldDefinitions);

    ArrayList<FieldGroup> fieldGroups = new ArrayList<>();
    fieldGroups.add(fieldGroupImpl);

    // Act
    pageTemplateCustomPersistenceHandler.processFieldGroups(null, pageFieldMap, propertiesList, fieldGroups);

    // Assert
    verify(fieldDefinitionImpl, atLeast(1)).getAdditionalForeignKeyClass();
    verify(fieldDefinitionImpl).getName();
    assertEquals(1, propertiesList.size());
    Property getResult = propertiesList.get(0);
    FieldMetadata metadata = getResult.getMetadata();
    assertTrue(metadata instanceof BasicFieldMetadata);
    assertEquals("Additional Foreign Key Class", metadata.getOwningClass());
    assertEquals("Name", getResult.getName());
    assertFalse(getResult.getIsDirty());
  }

  /**
   * Test
   * {@link PageTemplateCustomPersistenceHandler#processFieldGroups(List, Map, List, List)}.
   * <ul>
   *   <li>Then {@link ArrayList#ArrayList()} first Name is {@code Name}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PageTemplateCustomPersistenceHandler#processFieldGroups(List, Map, List, List)}
   */
  @Test
  public void testProcessFieldGroups_thenArrayListFirstNameIsName2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PageTemplateCustomPersistenceHandler pageTemplateCustomPersistenceHandler = new PageTemplateCustomPersistenceHandler();

    ArrayList<String> dirtyFields = new ArrayList<>();
    dirtyFields.add("foo");
    HashMap<String, PageField> pageFieldMap = new HashMap<>();
    ArrayList<Property> propertiesList = new ArrayList<>();
    FieldDefinitionImpl fieldDefinitionImpl = mock(FieldDefinitionImpl.class);
    when(fieldDefinitionImpl.getAdditionalForeignKeyClass()).thenReturn("Additional Foreign Key Class");
    when(fieldDefinitionImpl.getName()).thenReturn("Name");

    ArrayList<FieldDefinition> fieldDefinitions = new ArrayList<>();
    fieldDefinitions.add(fieldDefinitionImpl);

    FieldGroupImpl fieldGroupImpl = new FieldGroupImpl();
    fieldGroupImpl.setFieldGroupXrefs(new ArrayList<>());
    fieldGroupImpl.setId(1L);
    fieldGroupImpl.setInitCollapsedFlag(true);
    fieldGroupImpl.setIsMasterFieldGroup(true);
    fieldGroupImpl.setName("Name");
    fieldGroupImpl.setFieldDefinitions(fieldDefinitions);

    ArrayList<FieldGroup> fieldGroups = new ArrayList<>();
    fieldGroups.add(fieldGroupImpl);

    // Act
    pageTemplateCustomPersistenceHandler.processFieldGroups(dirtyFields, pageFieldMap, propertiesList, fieldGroups);

    // Assert
    verify(fieldDefinitionImpl, atLeast(1)).getAdditionalForeignKeyClass();
    verify(fieldDefinitionImpl).getName();
    assertEquals(1, propertiesList.size());
    Property getResult = propertiesList.get(0);
    FieldMetadata metadata = getResult.getMetadata();
    assertTrue(metadata instanceof BasicFieldMetadata);
    assertEquals("Additional Foreign Key Class", metadata.getOwningClass());
    assertEquals("Name", getResult.getName());
    assertFalse(getResult.getIsDirty());
  }

  /**
   * Test
   * {@link PageTemplateCustomPersistenceHandler#processFieldGroups(List, Map, List, List)}.
   * <ul>
   *   <li>Then {@link ArrayList#ArrayList()} size is two.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PageTemplateCustomPersistenceHandler#processFieldGroups(List, Map, List, List)}
   */
  @Test
  public void testProcessFieldGroups_thenArrayListSizeIsTwo() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PageTemplateCustomPersistenceHandler pageTemplateCustomPersistenceHandler = new PageTemplateCustomPersistenceHandler();
    HashMap<String, PageField> pageFieldMap = new HashMap<>();
    ArrayList<Property> propertiesList = new ArrayList<>();

    ArrayList<FieldDefinition> fieldDefinitions = new ArrayList<>();
    fieldDefinitions.add(new FieldDefinitionImpl());
    fieldDefinitions.add(new FieldDefinitionImpl());

    FieldGroupImpl fieldGroupImpl = new FieldGroupImpl();
    fieldGroupImpl.setFieldGroupXrefs(new ArrayList<>());
    fieldGroupImpl.setId(1L);
    fieldGroupImpl.setInitCollapsedFlag(true);
    fieldGroupImpl.setIsMasterFieldGroup(true);
    fieldGroupImpl.setName("Name");
    fieldGroupImpl.setFieldDefinitions(fieldDefinitions);

    ArrayList<FieldGroup> fieldGroups = new ArrayList<>();
    fieldGroups.add(fieldGroupImpl);

    // Act
    pageTemplateCustomPersistenceHandler.processFieldGroups(null, pageFieldMap, propertiesList, fieldGroups);

    // Assert
    assertEquals(2, propertiesList.size());
    Property expectedGetResult = propertiesList.get(0);
    assertEquals(expectedGetResult, propertiesList.get(1));
  }

  /**
   * Test
   * {@link PageTemplateCustomPersistenceHandler#processFieldGroups(List, Map, List, List)}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.</li>
   *   <li>Then {@link ArrayList#ArrayList()} Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PageTemplateCustomPersistenceHandler#processFieldGroups(List, Map, List, List)}
   */
  @Test
  public void testProcessFieldGroups_whenHashMap_thenArrayListEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PageTemplateCustomPersistenceHandler pageTemplateCustomPersistenceHandler = new PageTemplateCustomPersistenceHandler();
    ArrayList<String> dirtyFields = new ArrayList<>();
    HashMap<String, PageField> pageFieldMap = new HashMap<>();
    ArrayList<Property> propertiesList = new ArrayList<>();

    // Act
    pageTemplateCustomPersistenceHandler.processFieldGroups(dirtyFields, pageFieldMap, propertiesList,
        new ArrayList<>());

    // Assert that nothing has changed
    assertTrue(propertiesList.isEmpty());
  }

  /**
   * Test
   * {@link PageTemplateCustomPersistenceHandler#processIncludeId(boolean, Page, List)}.
   * <p>
   * Method under test:
   * {@link PageTemplateCustomPersistenceHandler#processIncludeId(boolean, Page, List)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testProcessIncludeId() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.admin.server.handler;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-applicationContext-entity.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1086 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.admin.server.handler.PageTemplateCustomPersistenceHandler pageTemplateCustomPersistenceHandler;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    PageTemplateCustomPersistenceHandler pageTemplateCustomPersistenceHandler2 = new PageTemplateCustomPersistenceHandler();
    PageImpl page = new PageImpl();

    // Act
    pageTemplateCustomPersistenceHandler2.processIncludeId(true, page, new ArrayList<>());
  }

  /**
   * Test
   * {@link PageTemplateCustomPersistenceHandler#processIncludeId(boolean, Page, List)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>Then {@link ArrayList#ArrayList()} first RawValue is {@code 1}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PageTemplateCustomPersistenceHandler#processIncludeId(boolean, Page, List)}
   */
  @Test
  public void testProcessIncludeId_givenOne_thenArrayListFirstRawValueIs1() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PageTemplateCustomPersistenceHandler pageTemplateCustomPersistenceHandler = new PageTemplateCustomPersistenceHandler();
    PageImpl page = mock(PageImpl.class);
    when(page.getId()).thenReturn(1L);
    ArrayList<Property> propertiesList = new ArrayList<>();

    // Act
    pageTemplateCustomPersistenceHandler.processIncludeId(true, page, propertiesList);

    // Assert
    verify(page).getId();
    assertEquals(1, propertiesList.size());
    Property getResult = propertiesList.get(0);
    FieldMetadata metadata = getResult.getMetadata();
    assertTrue(metadata instanceof BasicFieldMetadata);
    assertEquals("1", getResult.getRawValue());
    assertEquals("1", getResult.getUnHtmlEncodedValue());
    assertEquals("1", getResult.getValue());
    assertEquals("id", getResult.getName());
    assertNull(((BasicFieldMetadata) metadata).getCustomCriteria());
    assertNull(metadata.getAvailableToTypes());
    assertNull(((BasicFieldMetadata) metadata).getEnumerationValues());
    assertNull(((BasicFieldMetadata) metadata).getOptionFilterParams());
    assertNull(((BasicFieldMetadata) metadata).getCanLinkToExternalEntity());
    assertNull(((BasicFieldMetadata) metadata).getEnableTypeaheadLookup());
    assertNull(((BasicFieldMetadata) metadata).getForcePopulateChildProperties());
    assertNull(((BasicFieldMetadata) metadata).getGroupCollapsed());
    assertNull(((BasicFieldMetadata) metadata).getHideEnumerationIfEmpty());
    assertNull(((BasicFieldMetadata) metadata).getIsDerived());
    assertNull(((BasicFieldMetadata) metadata).getIsFilter());
    assertNull(((BasicFieldMetadata) metadata).getMutable());
    assertNull(((BasicFieldMetadata) metadata).getOptionCanEditValues());
    assertNull(((BasicFieldMetadata) metadata).getOptionHideIfEmpty());
    assertNull(((BasicFieldMetadata) metadata).getReadOnly());
    assertNull(((BasicFieldMetadata) metadata).getRequiredOverride());
    assertNull(((BasicFieldMetadata) metadata).getSearchable());
    assertNull(((BasicFieldMetadata) metadata).getToOneLookupCreatedViaAnnotation());
    assertNull(((BasicFieldMetadata) metadata).getTranslatable());
    assertNull(((BasicFieldMetadata) metadata).getUnique());
    assertNull(((BasicFieldMetadata) metadata).getUseServerSideInspectionCache());
    assertNull(((BasicFieldMetadata) metadata).isLargeEntry());
    assertNull(((BasicFieldMetadata) metadata).isProminent());
    assertNull(metadata.getChildrenExcluded());
    assertNull(metadata.getExcluded());
    assertNull(metadata.getLazyFetch());
    assertNull(((BasicFieldMetadata) metadata).getGridOrder());
    assertNull(((BasicFieldMetadata) metadata).getLength());
    assertNull(((BasicFieldMetadata) metadata).getPrecision());
    assertNull(((BasicFieldMetadata) metadata).getScale());
    assertNull(metadata.getGroupOrder());
    assertNull(metadata.getOrder());
    assertNull(metadata.getTabOrder());
    assertNull(((BasicFieldMetadata) metadata).getAssociatedFieldName());
    assertNull(((BasicFieldMetadata) metadata).getBroadleafEnumeration());
    assertNull(((BasicFieldMetadata) metadata).getColumnWidth());
    assertNull(((BasicFieldMetadata) metadata).getDefaultValue());
    assertNull(((BasicFieldMetadata) metadata).getEnumerationClass());
    assertNull(((BasicFieldMetadata) metadata).getFieldComponentRendererTemplate());
    assertNull(((BasicFieldMetadata) metadata).getForeignKeyClass());
    assertNull(((BasicFieldMetadata) metadata).getForeignKeyDisplayValueProperty());
    assertNull(((BasicFieldMetadata) metadata).getForeignKeyProperty());
    assertNull(((BasicFieldMetadata) metadata).getGridFieldComponentRendererTemplate());
    assertNull(((BasicFieldMetadata) metadata).getHelpText());
    assertNull(((BasicFieldMetadata) metadata).getHint());
    assertNull(((BasicFieldMetadata) metadata).getLookupDisplayProperty());
    assertNull(((BasicFieldMetadata) metadata).getManyToField());
    assertNull(((BasicFieldMetadata) metadata).getMapFieldValueClass());
    assertNull(((BasicFieldMetadata) metadata).getMapKeyValueProperty());
    assertNull(((BasicFieldMetadata) metadata).getName());
    assertNull(((BasicFieldMetadata) metadata).getOptionDisplayFieldName());
    assertNull(((BasicFieldMetadata) metadata).getOptionListEntity());
    assertNull(((BasicFieldMetadata) metadata).getOptionValueFieldName());
    assertNull(((BasicFieldMetadata) metadata).getRuleIdentifier());
    assertNull(((BasicFieldMetadata) metadata).getToOneParentProperty());
    assertNull(((BasicFieldMetadata) metadata).getToOneTargetProperty());
    assertNull(((BasicFieldMetadata) metadata).getTooltip());
    assertNull(metadata.getAddFriendlyName());
    assertNull(metadata.getCurrencyCodeField());
    assertNull(metadata.getFieldName());
    assertNull(metadata.getFriendlyName());
    assertNull(metadata.getGroup());
    assertNull(metadata.getInheritedFromType());
    assertNull(metadata.getOwningClass());
    assertNull(metadata.getOwningClassFriendlyName());
    assertNull(metadata.getPrefix());
    assertNull(metadata.getSecurityLevel());
    assertNull(metadata.getShowIfProperty());
    assertNull(metadata.getTab());
    assertNull(metadata.getTargetClass());
    assertNull(getResult.getDisplayValue());
    assertNull(getResult.getOriginalDisplayValue());
    assertNull(getResult.getOriginalValue());
    assertNull(getResult.getDeployDate());
    assertNull(metadata.getShowIfFieldEquals());
    assertNull(((BasicFieldMetadata) metadata).getLookupType());
    assertNull(((BasicFieldMetadata) metadata).getDisplayType());
    assertNull(((BasicFieldMetadata) metadata).getExplicitFieldType());
    assertNull(((BasicFieldMetadata) metadata).getFieldComponentRenderer());
    assertNull(((BasicFieldMetadata) metadata).getFieldType());
    assertNull(((BasicFieldMetadata) metadata).getGridFieldComponentRenderer());
    assertNull(((BasicFieldMetadata) metadata).getVisibility());
    assertNull(((BasicFieldMetadata) metadata).getMergedPropertyType());
    assertEquals(SupportedFieldType.INTEGER, ((BasicFieldMetadata) metadata).getSecondaryType());
    assertFalse(((BasicFieldMetadata) metadata).getForeignKeyCollection());
    assertFalse(((BasicFieldMetadata) metadata).getRequired());
    assertFalse(metadata.getManualFetch());
    assertFalse(getResult.getIsDirty());
    assertFalse(getResult.isAdvancedCollection());
    assertTrue(((BasicFieldMetadata) metadata).getValidationConfigurations().isEmpty());
    assertTrue(metadata.getAdditionalMetadata().isEmpty());
    assertTrue(((BasicFieldMetadata) metadata).getAllowNoValueEnumOption());
    assertTrue(getResult.getEnabled());
  }

  /**
   * Test
   * {@link PageTemplateCustomPersistenceHandler#processIncludeId(boolean, Page, List)}.
   * <ul>
   *   <li>Given {@link Property#Property()}.</li>
   *   <li>Then {@link ArrayList#ArrayList()} size is two.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PageTemplateCustomPersistenceHandler#processIncludeId(boolean, Page, List)}
   */
  @Test
  public void testProcessIncludeId_givenProperty_thenArrayListSizeIsTwo() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PageTemplateCustomPersistenceHandler pageTemplateCustomPersistenceHandler = new PageTemplateCustomPersistenceHandler();
    PageImpl page = mock(PageImpl.class);
    when(page.getId()).thenReturn(1L);

    ArrayList<Property> propertiesList = new ArrayList<>();
    propertiesList.add(new Property());

    // Act
    pageTemplateCustomPersistenceHandler.processIncludeId(true, page, propertiesList);

    // Assert
    verify(page).getId();
    assertEquals(2, propertiesList.size());
    Property getResult = propertiesList.get(1);
    assertTrue(getResult.getMetadata() instanceof BasicFieldMetadata);
    assertEquals("1", getResult.getRawValue());
    assertEquals("1", getResult.getUnHtmlEncodedValue());
    assertEquals("1", getResult.getValue());
    assertEquals("id", getResult.getName());
    assertNull(getResult.getDisplayValue());
    assertNull(getResult.getOriginalDisplayValue());
    assertNull(getResult.getOriginalValue());
    assertNull(getResult.getDeployDate());
    assertFalse(getResult.getIsDirty());
    assertFalse(getResult.isAdvancedCollection());
    assertTrue(getResult.getEnabled());
  }

  /**
   * Test
   * {@link PageTemplateCustomPersistenceHandler#processIncludeId(boolean, Page, List)}.
   * <ul>
   *   <li>When {@code false}.</li>
   *   <li>Then {@link ArrayList#ArrayList()} Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PageTemplateCustomPersistenceHandler#processIncludeId(boolean, Page, List)}
   */
  @Test
  public void testProcessIncludeId_whenFalse_thenArrayListEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PageTemplateCustomPersistenceHandler pageTemplateCustomPersistenceHandler = new PageTemplateCustomPersistenceHandler();
    PageImpl page = new PageImpl();
    ArrayList<Property> propertiesList = new ArrayList<>();

    // Act
    pageTemplateCustomPersistenceHandler.processIncludeId(false, page, propertiesList);

    // Assert that nothing has changed
    assertTrue(propertiesList.isEmpty());
  }

  /**
   * Test
   * {@link PageTemplateCustomPersistenceHandler#processIncludeId(boolean, Page, List)}.
   * <ul>
   *   <li>When {@link PageImpl} (default constructor).</li>
   *   <li>Then {@link ArrayList#ArrayList()} first RawValue is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PageTemplateCustomPersistenceHandler#processIncludeId(boolean, Page, List)}
   */
  @Test
  public void testProcessIncludeId_whenPageImpl_thenArrayListFirstRawValueIsNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PageTemplateCustomPersistenceHandler pageTemplateCustomPersistenceHandler = new PageTemplateCustomPersistenceHandler();
    PageImpl page = new PageImpl();
    ArrayList<Property> propertiesList = new ArrayList<>();

    // Act
    pageTemplateCustomPersistenceHandler.processIncludeId(true, page, propertiesList);

    // Assert
    assertEquals(1, propertiesList.size());
    Property getResult = propertiesList.get(0);
    FieldMetadata metadata = getResult.getMetadata();
    assertTrue(metadata instanceof BasicFieldMetadata);
    assertEquals("id", getResult.getName());
    assertEquals("null", getResult.getRawValue());
    assertEquals("null", getResult.getUnHtmlEncodedValue());
    assertEquals("null", getResult.getValue());
    assertNull(((BasicFieldMetadata) metadata).getCustomCriteria());
    assertNull(metadata.getAvailableToTypes());
    assertNull(((BasicFieldMetadata) metadata).getEnumerationValues());
    assertNull(((BasicFieldMetadata) metadata).getOptionFilterParams());
    assertNull(((BasicFieldMetadata) metadata).getCanLinkToExternalEntity());
    assertNull(((BasicFieldMetadata) metadata).getEnableTypeaheadLookup());
    assertNull(((BasicFieldMetadata) metadata).getForcePopulateChildProperties());
    assertNull(((BasicFieldMetadata) metadata).getGroupCollapsed());
    assertNull(((BasicFieldMetadata) metadata).getHideEnumerationIfEmpty());
    assertNull(((BasicFieldMetadata) metadata).getIsDerived());
    assertNull(((BasicFieldMetadata) metadata).getIsFilter());
    assertNull(((BasicFieldMetadata) metadata).getMutable());
    assertNull(((BasicFieldMetadata) metadata).getOptionCanEditValues());
    assertNull(((BasicFieldMetadata) metadata).getOptionHideIfEmpty());
    assertNull(((BasicFieldMetadata) metadata).getReadOnly());
    assertNull(((BasicFieldMetadata) metadata).getRequiredOverride());
    assertNull(((BasicFieldMetadata) metadata).getSearchable());
    assertNull(((BasicFieldMetadata) metadata).getToOneLookupCreatedViaAnnotation());
    assertNull(((BasicFieldMetadata) metadata).getTranslatable());
    assertNull(((BasicFieldMetadata) metadata).getUnique());
    assertNull(((BasicFieldMetadata) metadata).getUseServerSideInspectionCache());
    assertNull(((BasicFieldMetadata) metadata).isLargeEntry());
    assertNull(((BasicFieldMetadata) metadata).isProminent());
    assertNull(metadata.getChildrenExcluded());
    assertNull(metadata.getExcluded());
    assertNull(metadata.getLazyFetch());
    assertNull(((BasicFieldMetadata) metadata).getGridOrder());
    assertNull(((BasicFieldMetadata) metadata).getLength());
    assertNull(((BasicFieldMetadata) metadata).getPrecision());
    assertNull(((BasicFieldMetadata) metadata).getScale());
    assertNull(metadata.getGroupOrder());
    assertNull(metadata.getOrder());
    assertNull(metadata.getTabOrder());
    assertNull(((BasicFieldMetadata) metadata).getAssociatedFieldName());
    assertNull(((BasicFieldMetadata) metadata).getBroadleafEnumeration());
    assertNull(((BasicFieldMetadata) metadata).getColumnWidth());
    assertNull(((BasicFieldMetadata) metadata).getDefaultValue());
    assertNull(((BasicFieldMetadata) metadata).getEnumerationClass());
    assertNull(((BasicFieldMetadata) metadata).getFieldComponentRendererTemplate());
    assertNull(((BasicFieldMetadata) metadata).getForeignKeyClass());
    assertNull(((BasicFieldMetadata) metadata).getForeignKeyDisplayValueProperty());
    assertNull(((BasicFieldMetadata) metadata).getForeignKeyProperty());
    assertNull(((BasicFieldMetadata) metadata).getGridFieldComponentRendererTemplate());
    assertNull(((BasicFieldMetadata) metadata).getHelpText());
    assertNull(((BasicFieldMetadata) metadata).getHint());
    assertNull(((BasicFieldMetadata) metadata).getLookupDisplayProperty());
    assertNull(((BasicFieldMetadata) metadata).getManyToField());
    assertNull(((BasicFieldMetadata) metadata).getMapFieldValueClass());
    assertNull(((BasicFieldMetadata) metadata).getMapKeyValueProperty());
    assertNull(((BasicFieldMetadata) metadata).getName());
    assertNull(((BasicFieldMetadata) metadata).getOptionDisplayFieldName());
    assertNull(((BasicFieldMetadata) metadata).getOptionListEntity());
    assertNull(((BasicFieldMetadata) metadata).getOptionValueFieldName());
    assertNull(((BasicFieldMetadata) metadata).getRuleIdentifier());
    assertNull(((BasicFieldMetadata) metadata).getToOneParentProperty());
    assertNull(((BasicFieldMetadata) metadata).getToOneTargetProperty());
    assertNull(((BasicFieldMetadata) metadata).getTooltip());
    assertNull(metadata.getAddFriendlyName());
    assertNull(metadata.getCurrencyCodeField());
    assertNull(metadata.getFieldName());
    assertNull(metadata.getFriendlyName());
    assertNull(metadata.getGroup());
    assertNull(metadata.getInheritedFromType());
    assertNull(metadata.getOwningClass());
    assertNull(metadata.getOwningClassFriendlyName());
    assertNull(metadata.getPrefix());
    assertNull(metadata.getSecurityLevel());
    assertNull(metadata.getShowIfProperty());
    assertNull(metadata.getTab());
    assertNull(metadata.getTargetClass());
    assertNull(getResult.getDisplayValue());
    assertNull(getResult.getOriginalDisplayValue());
    assertNull(getResult.getOriginalValue());
    assertNull(getResult.getDeployDate());
    assertNull(metadata.getShowIfFieldEquals());
    assertNull(((BasicFieldMetadata) metadata).getLookupType());
    assertNull(((BasicFieldMetadata) metadata).getDisplayType());
    assertNull(((BasicFieldMetadata) metadata).getExplicitFieldType());
    assertNull(((BasicFieldMetadata) metadata).getFieldComponentRenderer());
    assertNull(((BasicFieldMetadata) metadata).getFieldType());
    assertNull(((BasicFieldMetadata) metadata).getGridFieldComponentRenderer());
    assertNull(((BasicFieldMetadata) metadata).getVisibility());
    assertNull(((BasicFieldMetadata) metadata).getMergedPropertyType());
    assertEquals(SupportedFieldType.INTEGER, ((BasicFieldMetadata) metadata).getSecondaryType());
    assertFalse(((BasicFieldMetadata) metadata).getForeignKeyCollection());
    assertFalse(((BasicFieldMetadata) metadata).getRequired());
    assertFalse(metadata.getManualFetch());
    assertFalse(getResult.getIsDirty());
    assertFalse(getResult.isAdvancedCollection());
    assertTrue(((BasicFieldMetadata) metadata).getValidationConfigurations().isEmpty());
    assertTrue(metadata.getAdditionalMetadata().isEmpty());
    assertTrue(((BasicFieldMetadata) metadata).getAllowNoValueEnumOption());
    assertTrue(getResult.getEnabled());
  }

  /**
   * Test
   * {@link PageTemplateCustomPersistenceHandler#update(PersistencePackage, DynamicEntityDao, RecordHelper)}.
   * <p>
   * Method under test:
   * {@link PageTemplateCustomPersistenceHandler#update(PersistencePackage, DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testUpdate() throws ServiceException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.admin.server.handler;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-applicationContext-entity.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1114 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.admin.server.handler.PageTemplateCustomPersistenceHandler pageTemplateCustomPersistenceHandler;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    PageTemplateCustomPersistenceHandler pageTemplateCustomPersistenceHandler2 = new PageTemplateCustomPersistenceHandler();
    PersistencePackage persistencePackage = new PersistencePackage();
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    // Act
    pageTemplateCustomPersistenceHandler2.update(persistencePackage, dynamicEntityDao,
        new AdornedTargetListPersistenceModule());
  }

  /**
   * Test
   * {@link PageTemplateCustomPersistenceHandler#update(PersistencePackage, DynamicEntityDao, RecordHelper)}.
   * <ul>
   *   <li>Given array of {@link String} with
   * {@code Unable to perform update for entity:} and {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PageTemplateCustomPersistenceHandler#update(PersistencePackage, DynamicEntityDao, RecordHelper)}
   */
  @Test
  public void testUpdate_givenArrayOfStringWithUnableToPerformUpdateForEntityAndFoo() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PageTemplateCustomPersistenceHandler pageTemplateCustomPersistenceHandler = new PageTemplateCustomPersistenceHandler();
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getCeilingEntityFullyQualifiedClassname()).thenReturn("Dr Jane Doe");
    when(persistencePackage.getCustomCriteria())
        .thenReturn(new String[]{"Unable to perform update for entity: ", "foo"});
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    // Act and Assert
    assertThrows(ServiceException.class, () -> pageTemplateCustomPersistenceHandler.update(persistencePackage,
        dynamicEntityDao, new AdornedTargetListPersistenceModule()));
    verify(persistencePackage).getCeilingEntityFullyQualifiedClassname();
    verify(persistencePackage).getCustomCriteria();
  }

  /**
   * Test
   * {@link PageTemplateCustomPersistenceHandler#update(PersistencePackage, DynamicEntityDao, RecordHelper)}.
   * <ul>
   *   <li>Given {@link Entity} (default constructor).</li>
   *   <li>Then return {@link Entity} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PageTemplateCustomPersistenceHandler#update(PersistencePackage, DynamicEntityDao, RecordHelper)}
   */
  @Test
  public void testUpdate_givenEntity_thenReturnEntity() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PageTemplateCustomPersistenceHandler pageTemplateCustomPersistenceHandler = new PageTemplateCustomPersistenceHandler();
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    Entity entity = new Entity();
    when(persistencePackage.getEntity()).thenReturn(entity);
    when(persistencePackage.getCeilingEntityFullyQualifiedClassname()).thenReturn("Dr Jane Doe");
    when(persistencePackage.getCustomCriteria()).thenReturn(new String[]{"Unable to perform update for entity: ", ""});
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    // Act
    Entity actualUpdateResult = pageTemplateCustomPersistenceHandler.update(persistencePackage, dynamicEntityDao,
        new AdornedTargetListPersistenceModule());

    // Assert
    verify(persistencePackage).getCeilingEntityFullyQualifiedClassname();
    verify(persistencePackage).getCustomCriteria();
    verify(persistencePackage).getEntity();
    assertSame(entity, actualUpdateResult);
  }

  /**
   * Test
   * {@link PageTemplateCustomPersistenceHandler#update(PersistencePackage, DynamicEntityDao, RecordHelper)}.
   * <ul>
   *   <li>Given {@link NumberFormatException#NumberFormatException(String)} with
   * {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PageTemplateCustomPersistenceHandler#update(PersistencePackage, DynamicEntityDao, RecordHelper)}
   */
  @Test
  public void testUpdate_givenNumberFormatExceptionWithFoo() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PageTemplateCustomPersistenceHandler pageTemplateCustomPersistenceHandler = new PageTemplateCustomPersistenceHandler();
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getEntity()).thenThrow(new NumberFormatException("foo"));
    when(persistencePackage.getCeilingEntityFullyQualifiedClassname()).thenReturn("Dr Jane Doe");
    when(persistencePackage.getCustomCriteria()).thenReturn(new String[]{"Unable to perform update for entity: ", ""});
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    // Act and Assert
    assertThrows(ServiceException.class, () -> pageTemplateCustomPersistenceHandler.update(persistencePackage,
        dynamicEntityDao, new AdornedTargetListPersistenceModule()));
    verify(persistencePackage).getCeilingEntityFullyQualifiedClassname();
    verify(persistencePackage).getCustomCriteria();
    verify(persistencePackage).getEntity();
  }

  /**
   * Test
   * {@link PageTemplateCustomPersistenceHandler#add(PersistencePackage, DynamicEntityDao, RecordHelper)}.
   * <p>
   * Method under test:
   * {@link PageTemplateCustomPersistenceHandler#add(PersistencePackage, DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testAdd() throws ServiceException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.admin.server.handler;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-applicationContext-entity.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass511 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.admin.server.handler.PageTemplateCustomPersistenceHandler pageTemplateCustomPersistenceHandler;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    PageTemplateCustomPersistenceHandler pageTemplateCustomPersistenceHandler2 = new PageTemplateCustomPersistenceHandler();
    PersistencePackage persistencePackage = new PersistencePackage();
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    // Act
    pageTemplateCustomPersistenceHandler2.add(persistencePackage, dynamicEntityDao,
        new AdornedTargetListPersistenceModule());
  }

  /**
   * Test
   * {@link PageTemplateCustomPersistenceHandler#add(PersistencePackage, DynamicEntityDao, RecordHelper)}.
   * <ul>
   *   <li>Given array of {@link String} with
   * {@code Unable to perform update for entity:} and {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PageTemplateCustomPersistenceHandler#add(PersistencePackage, DynamicEntityDao, RecordHelper)}
   */
  @Test
  public void testAdd_givenArrayOfStringWithUnableToPerformUpdateForEntityAndFoo() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PageTemplateCustomPersistenceHandler pageTemplateCustomPersistenceHandler = new PageTemplateCustomPersistenceHandler();
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getCeilingEntityFullyQualifiedClassname()).thenReturn("Dr Jane Doe");
    when(persistencePackage.getCustomCriteria())
        .thenReturn(new String[]{"Unable to perform update for entity: ", "foo"});
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    // Act and Assert
    assertThrows(ServiceException.class, () -> pageTemplateCustomPersistenceHandler.add(persistencePackage,
        dynamicEntityDao, new AdornedTargetListPersistenceModule()));
    verify(persistencePackage).getCeilingEntityFullyQualifiedClassname();
    verify(persistencePackage).getCustomCriteria();
  }

  /**
   * Test
   * {@link PageTemplateCustomPersistenceHandler#add(PersistencePackage, DynamicEntityDao, RecordHelper)}.
   * <ul>
   *   <li>Given {@link Entity} (default constructor).</li>
   *   <li>When {@link PersistencePackage} {@link PersistencePackage#getEntity()}
   * return {@link Entity} (default constructor).</li>
   *   <li>Then return {@link Entity} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PageTemplateCustomPersistenceHandler#add(PersistencePackage, DynamicEntityDao, RecordHelper)}
   */
  @Test
  public void testAdd_givenEntity_whenPersistencePackageGetEntityReturnEntity_thenReturnEntity()
      throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PageTemplateCustomPersistenceHandler pageTemplateCustomPersistenceHandler = new PageTemplateCustomPersistenceHandler();
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    Entity entity = new Entity();
    when(persistencePackage.getEntity()).thenReturn(entity);
    when(persistencePackage.getCeilingEntityFullyQualifiedClassname()).thenReturn("Dr Jane Doe");
    when(persistencePackage.getCustomCriteria()).thenReturn(new String[]{"Unable to perform update for entity: ", ""});
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    // Act
    Entity actualAddResult = pageTemplateCustomPersistenceHandler.add(persistencePackage, dynamicEntityDao,
        new AdornedTargetListPersistenceModule());

    // Assert
    verify(persistencePackage).getCeilingEntityFullyQualifiedClassname();
    verify(persistencePackage).getCustomCriteria();
    verify(persistencePackage).getEntity();
    assertSame(entity, actualAddResult);
  }

  /**
   * Test
   * {@link PageTemplateCustomPersistenceHandler#add(PersistencePackage, DynamicEntityDao, RecordHelper)}.
   * <ul>
   *   <li>Given {@link NumberFormatException#NumberFormatException(String)} with
   * {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PageTemplateCustomPersistenceHandler#add(PersistencePackage, DynamicEntityDao, RecordHelper)}
   */
  @Test
  public void testAdd_givenNumberFormatExceptionWithFoo() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PageTemplateCustomPersistenceHandler pageTemplateCustomPersistenceHandler = new PageTemplateCustomPersistenceHandler();
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getEntity()).thenThrow(new NumberFormatException("foo"));
    when(persistencePackage.getCeilingEntityFullyQualifiedClassname()).thenReturn("Dr Jane Doe");
    when(persistencePackage.getCustomCriteria()).thenReturn(new String[]{"Unable to perform update for entity: ", ""});
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    // Act and Assert
    assertThrows(ServiceException.class, () -> pageTemplateCustomPersistenceHandler.add(persistencePackage,
        dynamicEntityDao, new AdornedTargetListPersistenceModule()));
    verify(persistencePackage).getCeilingEntityFullyQualifiedClassname();
    verify(persistencePackage).getCustomCriteria();
    verify(persistencePackage).getEntity();
  }

  /**
   * Test
   * {@link PageTemplateCustomPersistenceHandler#addOrUpdate(PersistencePackage, DynamicEntityDao, RecordHelper)}.
   * <p>
   * Method under test:
   * {@link PageTemplateCustomPersistenceHandler#addOrUpdate(PersistencePackage, DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testAddOrUpdate() throws ServiceException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.admin.server.handler;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-applicationContext-entity.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass565 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.admin.server.handler.PageTemplateCustomPersistenceHandler pageTemplateCustomPersistenceHandler;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    PageTemplateCustomPersistenceHandler pageTemplateCustomPersistenceHandler2 = new PageTemplateCustomPersistenceHandler();
    PersistencePackage persistencePackage = new PersistencePackage();
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    // Act
    pageTemplateCustomPersistenceHandler2.addOrUpdate(persistencePackage, dynamicEntityDao,
        new AdornedTargetListPersistenceModule());
  }

  /**
   * Test
   * {@link PageTemplateCustomPersistenceHandler#addOrUpdate(PersistencePackage, DynamicEntityDao, RecordHelper)}.
   * <ul>
   *   <li>Given array of {@link String} with
   * {@code Unable to perform update for entity:} and {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PageTemplateCustomPersistenceHandler#addOrUpdate(PersistencePackage, DynamicEntityDao, RecordHelper)}
   */
  @Test
  public void testAddOrUpdate_givenArrayOfStringWithUnableToPerformUpdateForEntityAndFoo() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PageTemplateCustomPersistenceHandler pageTemplateCustomPersistenceHandler = new PageTemplateCustomPersistenceHandler();
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getCeilingEntityFullyQualifiedClassname()).thenReturn("Dr Jane Doe");
    when(persistencePackage.getCustomCriteria())
        .thenReturn(new String[]{"Unable to perform update for entity: ", "foo"});
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    // Act and Assert
    assertThrows(ServiceException.class, () -> pageTemplateCustomPersistenceHandler.addOrUpdate(persistencePackage,
        dynamicEntityDao, new AdornedTargetListPersistenceModule()));
    verify(persistencePackage).getCeilingEntityFullyQualifiedClassname();
    verify(persistencePackage).getCustomCriteria();
  }

  /**
   * Test
   * {@link PageTemplateCustomPersistenceHandler#addOrUpdate(PersistencePackage, DynamicEntityDao, RecordHelper)}.
   * <ul>
   *   <li>Given {@link Entity} (default constructor).</li>
   *   <li>Then return {@link Entity} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PageTemplateCustomPersistenceHandler#addOrUpdate(PersistencePackage, DynamicEntityDao, RecordHelper)}
   */
  @Test
  public void testAddOrUpdate_givenEntity_thenReturnEntity() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PageTemplateCustomPersistenceHandler pageTemplateCustomPersistenceHandler = new PageTemplateCustomPersistenceHandler();
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    Entity entity = new Entity();
    when(persistencePackage.getEntity()).thenReturn(entity);
    when(persistencePackage.getCeilingEntityFullyQualifiedClassname()).thenReturn("Dr Jane Doe");
    when(persistencePackage.getCustomCriteria()).thenReturn(new String[]{"Unable to perform update for entity: ", ""});
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    // Act
    Entity actualAddOrUpdateResult = pageTemplateCustomPersistenceHandler.addOrUpdate(persistencePackage,
        dynamicEntityDao, new AdornedTargetListPersistenceModule());

    // Assert
    verify(persistencePackage).getCeilingEntityFullyQualifiedClassname();
    verify(persistencePackage).getCustomCriteria();
    verify(persistencePackage).getEntity();
    assertSame(entity, actualAddOrUpdateResult);
  }

  /**
   * Test
   * {@link PageTemplateCustomPersistenceHandler#addOrUpdate(PersistencePackage, DynamicEntityDao, RecordHelper)}.
   * <ul>
   *   <li>Given {@link NumberFormatException#NumberFormatException(String)} with
   * {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PageTemplateCustomPersistenceHandler#addOrUpdate(PersistencePackage, DynamicEntityDao, RecordHelper)}
   */
  @Test
  public void testAddOrUpdate_givenNumberFormatExceptionWithFoo() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PageTemplateCustomPersistenceHandler pageTemplateCustomPersistenceHandler = new PageTemplateCustomPersistenceHandler();
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getEntity()).thenThrow(new NumberFormatException("foo"));
    when(persistencePackage.getCeilingEntityFullyQualifiedClassname()).thenReturn("Dr Jane Doe");
    when(persistencePackage.getCustomCriteria()).thenReturn(new String[]{"Unable to perform update for entity: ", ""});
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    // Act and Assert
    assertThrows(ServiceException.class, () -> pageTemplateCustomPersistenceHandler.addOrUpdate(persistencePackage,
        dynamicEntityDao, new AdornedTargetListPersistenceModule()));
    verify(persistencePackage).getCeilingEntityFullyQualifiedClassname();
    verify(persistencePackage).getCustomCriteria();
    verify(persistencePackage).getEntity();
  }
}
