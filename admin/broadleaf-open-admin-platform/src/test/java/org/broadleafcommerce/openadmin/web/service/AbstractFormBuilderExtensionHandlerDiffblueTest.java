/*-
 * #%L
 * BroadleafCommerce Open Admin Platform
 * %%
 * Copyright (C) 2009 - 2024 Broadleaf Commerce
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

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import org.broadleafcommerce.common.extension.ExtensionResultStatusType;
import org.broadleafcommerce.openadmin.dto.Entity;
import org.broadleafcommerce.openadmin.web.form.component.ListGrid;
import org.broadleafcommerce.openadmin.web.form.entity.EntityForm;
import org.broadleafcommerce.openadmin.web.service.extension.TranslationsFormBuilderExtensionHandler;
import org.junit.Test;

public class AbstractFormBuilderExtensionHandlerDiffblueTest {
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
