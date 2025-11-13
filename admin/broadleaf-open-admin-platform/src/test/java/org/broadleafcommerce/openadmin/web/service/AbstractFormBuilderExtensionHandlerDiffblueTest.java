package org.broadleafcommerce.openadmin.web.service;

import static org.junit.Assert.assertEquals;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.common.extension.ExtensionResultStatusType;
import org.broadleafcommerce.openadmin.dto.Entity;
import org.broadleafcommerce.openadmin.web.form.component.ListGrid;
import org.broadleafcommerce.openadmin.web.form.component.ListGridRecord;
import org.broadleafcommerce.openadmin.web.form.entity.EntityForm;
import org.broadleafcommerce.openadmin.web.service.extension.TranslationsFormBuilderExtensionHandler;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {TranslationsFormBuilderExtensionHandler.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class AbstractFormBuilderExtensionHandlerDiffblueTest {
  @Autowired private AbstractFormBuilderExtensionHandler abstractFormBuilderExtensionHandler;

  @MockBean(name = "blFormBuilderExtensionManager")
  private FormBuilderExtensionManager formBuilderExtensionManager;

  /**
   * Test {@link AbstractFormBuilderExtensionHandler#modifyUnpopulatedEntityForm(EntityForm)}.
   *
   * <p>Method under test: {@link
   * AbstractFormBuilderExtensionHandler#modifyUnpopulatedEntityForm(EntityForm)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType AbstractFormBuilderExtensionHandler.modifyUnpopulatedEntityForm(EntityForm)"
  })
  public void testModifyUnpopulatedEntityForm() {
    // Arrange, Act and Assert
    assertEquals(
        ExtensionResultStatusType.NOT_HANDLED,
        abstractFormBuilderExtensionHandler.modifyUnpopulatedEntityForm(new EntityForm()));
  }

  /**
   * Test {@link AbstractFormBuilderExtensionHandler#modifyPopulatedEntityForm(EntityForm, Entity)}.
   *
   * <p>Method under test: {@link
   * AbstractFormBuilderExtensionHandler#modifyPopulatedEntityForm(EntityForm, Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType AbstractFormBuilderExtensionHandler.modifyPopulatedEntityForm(EntityForm, Entity)"
  })
  public void testModifyPopulatedEntityForm() {
    // Arrange
    EntityForm ef = new EntityForm();

    // Act and Assert
    assertEquals(
        ExtensionResultStatusType.NOT_HANDLED,
        abstractFormBuilderExtensionHandler.modifyPopulatedEntityForm(ef, new Entity()));
  }

  /**
   * Test {@link AbstractFormBuilderExtensionHandler#modifyDetailEntityForm(EntityForm)}.
   *
   * <p>Method under test: {@link
   * AbstractFormBuilderExtensionHandler#modifyDetailEntityForm(EntityForm)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType AbstractFormBuilderExtensionHandler.modifyDetailEntityForm(EntityForm)"
  })
  public void testModifyDetailEntityForm() {
    // Arrange, Act and Assert
    assertEquals(
        ExtensionResultStatusType.NOT_HANDLED,
        abstractFormBuilderExtensionHandler.modifyDetailEntityForm(new EntityForm()));
  }

  /**
   * Test {@link AbstractFormBuilderExtensionHandler#modifyListGridRecord(String, ListGridRecord,
   * Entity)}.
   *
   * <p>Method under test: {@link AbstractFormBuilderExtensionHandler#modifyListGridRecord(String,
   * ListGridRecord, Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType AbstractFormBuilderExtensionHandler.modifyListGridRecord(String, ListGridRecord, Entity)"
  })
  public void testModifyListGridRecord() {
    // Arrange
    TranslationsFormBuilderExtensionHandler translationsFormBuilderExtensionHandler =
        new TranslationsFormBuilderExtensionHandler();
    ListGridRecord resultRecord = new ListGridRecord();

    // Act and Assert
    assertEquals(
        ExtensionResultStatusType.NOT_HANDLED,
        translationsFormBuilderExtensionHandler.modifyListGridRecord(
            "Class Name", resultRecord, new Entity()));
  }

  /**
   * Test {@link AbstractFormBuilderExtensionHandler#addAdditionalFormActions(EntityForm)}.
   *
   * <p>Method under test: {@link
   * AbstractFormBuilderExtensionHandler#addAdditionalFormActions(EntityForm)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType AbstractFormBuilderExtensionHandler.addAdditionalFormActions(EntityForm)"
  })
  public void testAddAdditionalFormActions() {
    // Arrange, Act and Assert
    assertEquals(
        ExtensionResultStatusType.NOT_HANDLED,
        abstractFormBuilderExtensionHandler.addAdditionalFormActions(new EntityForm()));
  }

  /**
   * Test {@link AbstractFormBuilderExtensionHandler#modifyListGrid(String, ListGrid)}.
   *
   * <p>Method under test: {@link AbstractFormBuilderExtensionHandler#modifyListGrid(String,
   * ListGrid)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType AbstractFormBuilderExtensionHandler.modifyListGrid(String, ListGrid)"
  })
  public void testModifyListGrid() {
    // Arrange, Act and Assert
    assertEquals(
        ExtensionResultStatusType.NOT_HANDLED,
        abstractFormBuilderExtensionHandler.modifyListGrid("Class Name", new ListGrid()));
  }

  /**
   * Test {@link AbstractFormBuilderExtensionHandler#addAdditionalAdornedFormActions(EntityForm)}.
   *
   * <p>Method under test: {@link
   * AbstractFormBuilderExtensionHandler#addAdditionalAdornedFormActions(EntityForm)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType AbstractFormBuilderExtensionHandler.addAdditionalAdornedFormActions(EntityForm)"
  })
  public void testAddAdditionalAdornedFormActions() {
    // Arrange, Act and Assert
    assertEquals(
        ExtensionResultStatusType.NOT_HANDLED,
        abstractFormBuilderExtensionHandler.addAdditionalAdornedFormActions(new EntityForm()));
  }
}
