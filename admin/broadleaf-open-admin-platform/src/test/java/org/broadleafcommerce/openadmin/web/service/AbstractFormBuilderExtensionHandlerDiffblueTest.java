package org.broadleafcommerce.openadmin.web.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.broadleafcommerce.common.extension.ExtensionResultStatusType;
import org.broadleafcommerce.openadmin.dto.Entity;
import org.broadleafcommerce.openadmin.web.form.component.ListGrid;
import org.broadleafcommerce.openadmin.web.form.component.ListGridRecord;
import org.broadleafcommerce.openadmin.web.form.entity.EntityForm;
import org.broadleafcommerce.openadmin.web.service.extension.TranslationsFormBuilderExtensionHandler;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml",
    "/bl-open-admin-applicationContext-entity.xml", "/bl-open-admin-contentClient-applicationContext.xml",
    "/bl-open-admin-contentCreator-applicationContext.xml",
    "/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml",
    "/blc-config/admin/framework/bl-open-admin-applicationContext.xml",
    "/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class AbstractFormBuilderExtensionHandlerDiffblueTest {
  @MockBean
  private AbstractFormBuilderExtensionHandler abstractFormBuilderExtensionHandler;

  /**
   * Test
   * {@link AbstractFormBuilderExtensionHandler#modifyUnpopulatedEntityForm(EntityForm)}.
   * <p>
   * Method under test:
   * {@link AbstractFormBuilderExtensionHandler#modifyUnpopulatedEntityForm(EntityForm)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testModifyUnpopulatedEntityForm() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.web.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass5973 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.web.service.AbstractFormBuilderExtensionHandler abstractFormBuilderExtensionHandler;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    TranslationsFormBuilderExtensionHandler translationsFormBuilderExtensionHandler = new TranslationsFormBuilderExtensionHandler();

    // Act
    translationsFormBuilderExtensionHandler.modifyUnpopulatedEntityForm(new EntityForm());
  }

  /**
   * Test
   * {@link AbstractFormBuilderExtensionHandler#modifyUnpopulatedEntityForm(EntityForm)}.
   * <ul>
   *   <li>When {@link EntityForm} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractFormBuilderExtensionHandler#modifyUnpopulatedEntityForm(EntityForm)}
   */
  @Test
  public void testModifyUnpopulatedEntityForm_whenEntityForm() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TranslationsFormBuilderExtensionHandler translationsFormBuilderExtensionHandler = new TranslationsFormBuilderExtensionHandler();

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        translationsFormBuilderExtensionHandler.modifyUnpopulatedEntityForm(new EntityForm()));
  }

  /**
   * Test
   * {@link AbstractFormBuilderExtensionHandler#modifyUnpopulatedEntityForm(EntityForm)}.
   * <ul>
   *   <li>When {@link EntityForm}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractFormBuilderExtensionHandler#modifyUnpopulatedEntityForm(EntityForm)}
   */
  @Test
  public void testModifyUnpopulatedEntityForm_whenEntityForm2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        (new TranslationsFormBuilderExtensionHandler()).modifyUnpopulatedEntityForm(mock(EntityForm.class)));
  }

  /**
   * Test
   * {@link AbstractFormBuilderExtensionHandler#modifyPopulatedEntityForm(EntityForm, Entity)}.
   * <p>
   * Method under test:
   * {@link AbstractFormBuilderExtensionHandler#modifyPopulatedEntityForm(EntityForm, Entity)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testModifyPopulatedEntityForm() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.web.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass5921 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.web.service.AbstractFormBuilderExtensionHandler abstractFormBuilderExtensionHandler;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    TranslationsFormBuilderExtensionHandler translationsFormBuilderExtensionHandler = new TranslationsFormBuilderExtensionHandler();
    EntityForm ef = new EntityForm();

    // Act
    translationsFormBuilderExtensionHandler.modifyPopulatedEntityForm(ef, new Entity());
  }

  /**
   * Test
   * {@link AbstractFormBuilderExtensionHandler#modifyPopulatedEntityForm(EntityForm, Entity)}.
   * <ul>
   *   <li>When {@link EntityForm} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractFormBuilderExtensionHandler#modifyPopulatedEntityForm(EntityForm, Entity)}
   */
  @Test
  public void testModifyPopulatedEntityForm_whenEntityForm() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TranslationsFormBuilderExtensionHandler translationsFormBuilderExtensionHandler = new TranslationsFormBuilderExtensionHandler();
    EntityForm ef = new EntityForm();

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        translationsFormBuilderExtensionHandler.modifyPopulatedEntityForm(ef, new Entity()));
  }

  /**
   * Test
   * {@link AbstractFormBuilderExtensionHandler#modifyPopulatedEntityForm(EntityForm, Entity)}.
   * <ul>
   *   <li>When {@link EntityForm}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractFormBuilderExtensionHandler#modifyPopulatedEntityForm(EntityForm, Entity)}
   */
  @Test
  public void testModifyPopulatedEntityForm_whenEntityForm2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TranslationsFormBuilderExtensionHandler translationsFormBuilderExtensionHandler = new TranslationsFormBuilderExtensionHandler();
    EntityForm ef = mock(EntityForm.class);

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        translationsFormBuilderExtensionHandler.modifyPopulatedEntityForm(ef, new Entity()));
  }

  /**
   * Test
   * {@link AbstractFormBuilderExtensionHandler#modifyDetailEntityForm(EntityForm)}.
   * <p>
   * Method under test:
   * {@link AbstractFormBuilderExtensionHandler#modifyDetailEntityForm(EntityForm)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testModifyDetailEntityForm() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.web.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass5826 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.web.service.AbstractFormBuilderExtensionHandler abstractFormBuilderExtensionHandler;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    TranslationsFormBuilderExtensionHandler translationsFormBuilderExtensionHandler = new TranslationsFormBuilderExtensionHandler();

    // Act
    translationsFormBuilderExtensionHandler.modifyDetailEntityForm(new EntityForm());
  }

  /**
   * Test
   * {@link AbstractFormBuilderExtensionHandler#modifyDetailEntityForm(EntityForm)}.
   * <ul>
   *   <li>When {@link EntityForm} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractFormBuilderExtensionHandler#modifyDetailEntityForm(EntityForm)}
   */
  @Test
  public void testModifyDetailEntityForm_whenEntityForm() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TranslationsFormBuilderExtensionHandler translationsFormBuilderExtensionHandler = new TranslationsFormBuilderExtensionHandler();

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        translationsFormBuilderExtensionHandler.modifyDetailEntityForm(new EntityForm()));
  }

  /**
   * Test
   * {@link AbstractFormBuilderExtensionHandler#modifyDetailEntityForm(EntityForm)}.
   * <ul>
   *   <li>When {@link EntityForm}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractFormBuilderExtensionHandler#modifyDetailEntityForm(EntityForm)}
   */
  @Test
  public void testModifyDetailEntityForm_whenEntityForm2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        (new TranslationsFormBuilderExtensionHandler()).modifyDetailEntityForm(mock(EntityForm.class)));
  }

  /**
   * Test
   * {@link AbstractFormBuilderExtensionHandler#modifyListGridRecord(String, ListGridRecord, Entity)}.
   * <p>
   * Method under test:
   * {@link AbstractFormBuilderExtensionHandler#modifyListGridRecord(String, ListGridRecord, Entity)}
   */
  @Test
  public void testModifyListGridRecord() {
    // Arrange
    when(abstractFormBuilderExtensionHandler.modifyListGridRecord(Mockito.<String>any(), Mockito.<ListGridRecord>any(),
        Mockito.<Entity>any())).thenReturn(ExtensionResultStatusType.HANDLED);
    ListGridRecord resultRecord = new ListGridRecord();

    // Act
    ExtensionResultStatusType actualModifyListGridRecordResult = abstractFormBuilderExtensionHandler
        .modifyListGridRecord("Class Name", resultRecord, new Entity());

    // Assert
    verify(abstractFormBuilderExtensionHandler).modifyListGridRecord(eq("Class Name"), isA(ListGridRecord.class),
        isA(Entity.class));
    assertEquals(ExtensionResultStatusType.HANDLED, actualModifyListGridRecordResult);
  }

  /**
   * Test
   * {@link AbstractFormBuilderExtensionHandler#addAdditionalFormActions(EntityForm)}.
   * <p>
   * Method under test:
   * {@link AbstractFormBuilderExtensionHandler#addAdditionalFormActions(EntityForm)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testAddAdditionalFormActions() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.web.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass5793 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.web.service.AbstractFormBuilderExtensionHandler abstractFormBuilderExtensionHandler;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    TranslationsFormBuilderExtensionHandler translationsFormBuilderExtensionHandler = new TranslationsFormBuilderExtensionHandler();

    // Act
    translationsFormBuilderExtensionHandler.addAdditionalFormActions(new EntityForm());
  }

  /**
   * Test
   * {@link AbstractFormBuilderExtensionHandler#addAdditionalFormActions(EntityForm)}.
   * <ul>
   *   <li>When {@link EntityForm} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractFormBuilderExtensionHandler#addAdditionalFormActions(EntityForm)}
   */
  @Test
  public void testAddAdditionalFormActions_whenEntityForm() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TranslationsFormBuilderExtensionHandler translationsFormBuilderExtensionHandler = new TranslationsFormBuilderExtensionHandler();

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        translationsFormBuilderExtensionHandler.addAdditionalFormActions(new EntityForm()));
  }

  /**
   * Test
   * {@link AbstractFormBuilderExtensionHandler#addAdditionalFormActions(EntityForm)}.
   * <ul>
   *   <li>When {@link EntityForm}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractFormBuilderExtensionHandler#addAdditionalFormActions(EntityForm)}
   */
  @Test
  public void testAddAdditionalFormActions_whenEntityForm2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        (new TranslationsFormBuilderExtensionHandler()).addAdditionalFormActions(mock(EntityForm.class)));
  }

  /**
   * Test
   * {@link AbstractFormBuilderExtensionHandler#modifyListGrid(String, ListGrid)}.
   * <p>
   * Method under test:
   * {@link AbstractFormBuilderExtensionHandler#modifyListGrid(String, ListGrid)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testModifyListGrid() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.web.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass5859 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.web.service.AbstractFormBuilderExtensionHandler abstractFormBuilderExtensionHandler;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    TranslationsFormBuilderExtensionHandler translationsFormBuilderExtensionHandler = new TranslationsFormBuilderExtensionHandler();

    // Act
    translationsFormBuilderExtensionHandler.modifyListGrid("Class Name", new ListGrid());
  }

  /**
   * Test
   * {@link AbstractFormBuilderExtensionHandler#modifyListGrid(String, ListGrid)}.
   * <ul>
   *   <li>When {@link ListGrid} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractFormBuilderExtensionHandler#modifyListGrid(String, ListGrid)}
   */
  @Test
  public void testModifyListGrid_whenListGrid() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TranslationsFormBuilderExtensionHandler translationsFormBuilderExtensionHandler = new TranslationsFormBuilderExtensionHandler();

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        translationsFormBuilderExtensionHandler.modifyListGrid("Class Name", new ListGrid()));
  }

  /**
   * Test
   * {@link AbstractFormBuilderExtensionHandler#modifyListGrid(String, ListGrid)}.
   * <ul>
   *   <li>When {@link ListGrid}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractFormBuilderExtensionHandler#modifyListGrid(String, ListGrid)}
   */
  @Test
  public void testModifyListGrid_whenListGrid2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        (new TranslationsFormBuilderExtensionHandler()).modifyListGrid("Class Name", mock(ListGrid.class)));
  }

  /**
   * Test
   * {@link AbstractFormBuilderExtensionHandler#addAdditionalAdornedFormActions(EntityForm)}.
   * <p>
   * Method under test:
   * {@link AbstractFormBuilderExtensionHandler#addAdditionalAdornedFormActions(EntityForm)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testAddAdditionalAdornedFormActions() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.web.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass5760 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.web.service.AbstractFormBuilderExtensionHandler abstractFormBuilderExtensionHandler;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    TranslationsFormBuilderExtensionHandler translationsFormBuilderExtensionHandler = new TranslationsFormBuilderExtensionHandler();

    // Act
    translationsFormBuilderExtensionHandler.addAdditionalAdornedFormActions(new EntityForm());
  }

  /**
   * Test
   * {@link AbstractFormBuilderExtensionHandler#addAdditionalAdornedFormActions(EntityForm)}.
   * <ul>
   *   <li>When {@link EntityForm} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractFormBuilderExtensionHandler#addAdditionalAdornedFormActions(EntityForm)}
   */
  @Test
  public void testAddAdditionalAdornedFormActions_whenEntityForm() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TranslationsFormBuilderExtensionHandler translationsFormBuilderExtensionHandler = new TranslationsFormBuilderExtensionHandler();

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        translationsFormBuilderExtensionHandler.addAdditionalAdornedFormActions(new EntityForm()));
  }

  /**
   * Test
   * {@link AbstractFormBuilderExtensionHandler#addAdditionalAdornedFormActions(EntityForm)}.
   * <ul>
   *   <li>When {@link EntityForm}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractFormBuilderExtensionHandler#addAdditionalAdornedFormActions(EntityForm)}
   */
  @Test
  public void testAddAdditionalAdornedFormActions_whenEntityForm2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        (new TranslationsFormBuilderExtensionHandler()).addAdditionalAdornedFormActions(mock(EntityForm.class)));
  }
}
