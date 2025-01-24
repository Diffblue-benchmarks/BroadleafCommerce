package org.broadleafcommerce.admin.web.controller.entity;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import org.broadleafcommerce.common.persistence.EntityConfiguration;
import org.broadleafcommerce.common.persistence.EntityDuplicator;
import org.broadleafcommerce.common.sandbox.SandBoxHelper;
import org.broadleafcommerce.common.security.service.ExploitProtectionService;
import org.broadleafcommerce.common.service.GenericEntityService;
import org.broadleafcommerce.core.catalog.service.CatalogService;
import org.broadleafcommerce.openadmin.security.ClassNameRequestParamValidationService;
import org.broadleafcommerce.openadmin.server.dao.DynamicEntityDao;
import org.broadleafcommerce.openadmin.server.security.dao.AdminUserDao;
import org.broadleafcommerce.openadmin.server.security.remote.SecurityVerifier;
import org.broadleafcommerce.openadmin.server.security.service.RowLevelSecurityService;
import org.broadleafcommerce.openadmin.server.security.service.navigation.AdminNavigationService;
import org.broadleafcommerce.openadmin.server.service.AdminEntityService;
import org.broadleafcommerce.openadmin.server.service.AdminSectionCustomCriteriaService;
import org.broadleafcommerce.openadmin.server.service.extension.FilterProductTypePersistenceHandlerExtensionManager;
import org.broadleafcommerce.openadmin.server.service.persistence.extension.AdornedTargetAutoPopulateExtensionManager;
import org.broadleafcommerce.openadmin.web.controller.AdminAbstractControllerExtensionManager;
import org.broadleafcommerce.openadmin.web.dao.MultipleCatalogExtensionManager;
import org.broadleafcommerce.openadmin.web.form.entity.CodeField;
import org.broadleafcommerce.openadmin.web.form.entity.EntityForm;
import org.broadleafcommerce.openadmin.web.form.entity.EntityFormValidator;
import org.broadleafcommerce.openadmin.web.form.entity.Field;
import org.broadleafcommerce.openadmin.web.service.FormBuilderService;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {AdminCategoryController.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class AdminCategoryControllerDiffblueTest {
  @MockBean(name = "blAdminAbstractControllerExtensionManager")
  private AdminAbstractControllerExtensionManager adminAbstractControllerExtensionManager;

  @Autowired
  private AdminCategoryController adminCategoryController;

  @MockBean
  private AdminEntityService adminEntityService;

  @MockBean
  private AdminNavigationService adminNavigationService;

  @MockBean
  private AdminSectionCustomCriteriaService adminSectionCustomCriteriaService;

  @MockBean
  private AdminUserDao adminUserDao;

  @MockBean(name = "blAdornedTargetAutoPopulateExtensionManager")
  private AdornedTargetAutoPopulateExtensionManager adornedTargetAutoPopulateExtensionManager;

  @MockBean
  private CatalogService catalogService;

  @MockBean
  private ClassNameRequestParamValidationService classNameRequestParamValidationService;

  @MockBean
  private DynamicEntityDao dynamicEntityDao;

  @MockBean(name = "blEntityConfiguration")
  private EntityConfiguration entityConfiguration;

  @MockBean
  private EntityDuplicator entityDuplicator;

  @MockBean(name = "blEntityFormValidator")
  private EntityFormValidator entityFormValidator;

  @MockBean
  private ExploitProtectionService exploitProtectionService;

  @MockBean(name = "blFilterProductTypePersistenceHandlerExtensionManager")
  private FilterProductTypePersistenceHandlerExtensionManager filterProductTypePersistenceHandlerExtensionManager;

  @MockBean
  private FormBuilderService formBuilderService;

  @MockBean
  private GenericEntityService genericEntityService;

  @MockBean(name = "blMultipleCatalogExtensionManager")
  private MultipleCatalogExtensionManager multipleCatalogExtensionManager;

  @MockBean
  private RowLevelSecurityService rowLevelSecurityService;

  @MockBean
  private SandBoxHelper sandBoxHelper;

  @MockBean
  private SecurityVerifier securityVerifier;

  /**
   * Test {@link AdminCategoryController#getSectionKey(Map)}.
   * <p>
   * Method under test: {@link AdminCategoryController#getSectionKey(Map)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetSectionKey() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.admin.web.controller.entity;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.admin.web.controller.entity.AdminCategoryController.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass351 {
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blAdminAbstractControllerExtensionManager") org.broadleafcommerce.openadmin.web.controller.AdminAbstractControllerExtensionManager adminAbstractControllerExtensionManager;
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.admin.web.controller.entity.AdminCategoryController adminCategoryController;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.server.service.AdminEntityService adminEntityService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.server.security.service.navigation.AdminNavigationService adminNavigationService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.server.service.AdminSectionCustomCriteriaService adminSectionCustomCriteriaService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.server.security.dao.AdminUserDao adminUserDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blAdornedTargetAutoPopulateExtensionManager") org.broadleafcommerce.openadmin.server.service.persistence.extension.AdornedTargetAutoPopulateExtensionManager adornedTargetAutoPopulateExtensionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.service.CatalogService catalogService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.security.ClassNameRequestParamValidationService classNameRequestParamValidationService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.server.dao.DynamicEntityDao dynamicEntityDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blEntityConfiguration") org.broadleafcommerce.common.persistence.EntityConfiguration entityConfiguration;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.common.persistence.EntityDuplicator entityDuplicator;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blEntityFormValidator") org.broadleafcommerce.openadmin.web.form.entity.EntityFormValidator entityFormValidator;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.common.security.service.ExploitProtectionService exploitProtectionService;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blFilterProductTypePersistenceHandlerExtensionManager") org.broadleafcommerce.openadmin.server.service.extension.FilterProductTypePersistenceHandlerExtensionManager filterProductTypePersistenceHandlerExtensionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.web.service.FormBuilderService formBuilderService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.common.service.GenericEntityService genericEntityService;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blMultipleCatalogExtensionManager") org.broadleafcommerce.openadmin.web.dao.MultipleCatalogExtensionManager multipleCatalogExtensionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.server.security.service.RowLevelSecurityService rowLevelSecurityService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.common.sandbox.SandBoxHelper sandBoxHelper;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.server.security.remote.SecurityVerifier securityVerifier;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    adminCategoryController.getSectionKey(new HashMap<>());
  }

  /**
   * Test {@link AdminCategoryController#getSectionKey(Map)}.
   * <ul>
   *   <li>Given {@link BiFunction}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminCategoryController#getSectionKey(Map)}
   */
  @Test
  public void testGetSectionKey_givenBiFunction() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminCategoryController adminCategoryController = new AdminCategoryController();

    HashMap<String, String> pathVars = new HashMap<>();
    pathVars.computeIfPresent("sectionKey", mock(BiFunction.class));
    pathVars.put("sectionKey", "sectionKey");

    // Act and Assert
    assertEquals("sectionKey", adminCategoryController.getSectionKey(pathVars));
  }

  /**
   * Test {@link AdminCategoryController#getSectionKey(Map)}.
   * <ul>
   *   <li>Given {@code sectionKey}.</li>
   *   <li>Then return {@code sectionKey}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminCategoryController#getSectionKey(Map)}
   */
  @Test
  public void testGetSectionKey_givenSectionKey_thenReturnSectionKey() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminCategoryController adminCategoryController = new AdminCategoryController();

    HashMap<String, String> pathVars = new HashMap<>();
    pathVars.put("sectionKey", "sectionKey");

    // Act and Assert
    assertEquals("sectionKey", adminCategoryController.getSectionKey(pathVars));
  }

  /**
   * Test {@link AdminCategoryController#getSectionKey(Map)}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.</li>
   *   <li>Then return {@link AdminCategoryController#SECTION_KEY}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminCategoryController#getSectionKey(Map)}
   */
  @Test
  public void testGetSectionKey_whenHashMap_thenReturnSection_key() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminCategoryController adminCategoryController = new AdminCategoryController();

    // Act and Assert
    assertEquals(AdminCategoryController.SECTION_KEY, adminCategoryController.getSectionKey(new HashMap<>()));
  }

  /**
   * Test {@link AdminCategoryController#modifyAddEntityForm(EntityForm, Map)}.
   * <p>
   * Method under test:
   * {@link AdminCategoryController#modifyAddEntityForm(EntityForm, Map)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testModifyAddEntityForm() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.admin.web.controller.entity;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.admin.web.controller.entity.AdminCategoryController.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass352 {
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blAdminAbstractControllerExtensionManager") org.broadleafcommerce.openadmin.web.controller.AdminAbstractControllerExtensionManager adminAbstractControllerExtensionManager;
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.admin.web.controller.entity.AdminCategoryController adminCategoryController;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.server.service.AdminEntityService adminEntityService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.server.security.service.navigation.AdminNavigationService adminNavigationService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.server.service.AdminSectionCustomCriteriaService adminSectionCustomCriteriaService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.server.security.dao.AdminUserDao adminUserDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blAdornedTargetAutoPopulateExtensionManager") org.broadleafcommerce.openadmin.server.service.persistence.extension.AdornedTargetAutoPopulateExtensionManager adornedTargetAutoPopulateExtensionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.service.CatalogService catalogService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.security.ClassNameRequestParamValidationService classNameRequestParamValidationService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.server.dao.DynamicEntityDao dynamicEntityDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blEntityConfiguration") org.broadleafcommerce.common.persistence.EntityConfiguration entityConfiguration;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.common.persistence.EntityDuplicator entityDuplicator;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blEntityFormValidator") org.broadleafcommerce.openadmin.web.form.entity.EntityFormValidator entityFormValidator;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.common.security.service.ExploitProtectionService exploitProtectionService;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blFilterProductTypePersistenceHandlerExtensionManager") org.broadleafcommerce.openadmin.server.service.extension.FilterProductTypePersistenceHandlerExtensionManager filterProductTypePersistenceHandlerExtensionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.web.service.FormBuilderService formBuilderService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.common.service.GenericEntityService genericEntityService;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blMultipleCatalogExtensionManager") org.broadleafcommerce.openadmin.web.dao.MultipleCatalogExtensionManager multipleCatalogExtensionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.server.security.service.RowLevelSecurityService rowLevelSecurityService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.common.sandbox.SandBoxHelper sandBoxHelper;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.server.security.remote.SecurityVerifier securityVerifier;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    EntityForm ef = new EntityForm();

    // Act
    adminCategoryController.modifyAddEntityForm(ef, new HashMap<>());
  }

  /**
   * Test {@link AdminCategoryController#modifyAddEntityForm(EntityForm, Map)}.
   * <ul>
   *   <li>Given {@link CodeField} {@link Field#withAttribute(String, Object)}
   * return {@link Field} (default constructor).</li>
   *   <li>Then calls {@link Field#getValue()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminCategoryController#modifyAddEntityForm(EntityForm, Map)}
   */
  @Test
  public void testModifyAddEntityForm_givenCodeFieldWithAttributeReturnField_thenCallsGetValue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminCategoryController adminCategoryController = new AdminCategoryController();
    CodeField codeField = mock(CodeField.class);
    when(codeField.getValue()).thenReturn("42");
    when(codeField.withAttribute(Mockito.<String>any(), Mockito.<Object>any())).thenReturn(new Field());
    doNothing().when(codeField).setFieldType(Mockito.<String>any());
    EntityForm ef = mock(EntityForm.class);
    when(ef.findField(Mockito.<String>any())).thenReturn(codeField);

    // Act
    adminCategoryController.modifyAddEntityForm(ef, new HashMap<>());

    // Assert
    verify(ef, atLeast(1)).findField(Mockito.<String>any());
    verify(codeField).getValue();
    verify(codeField).setFieldType(eq("hidden"));
    verify(codeField).withAttribute(eq("overriddenUrl"), isA(Object.class));
  }

  /**
   * Test {@link AdminCategoryController#modifyAddEntityForm(EntityForm, Map)}.
   * <ul>
   *   <li>Given {@link CodeField} {@link Field#withAttribute(String, Object)}
   * return {@link Field} (default constructor).</li>
   *   <li>Then calls {@link Field#getValue()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminCategoryController#modifyAddEntityForm(EntityForm, Map)}
   */
  @Test
  public void testModifyAddEntityForm_givenCodeFieldWithAttributeReturnField_thenCallsGetValue2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminCategoryController adminCategoryController = new AdminCategoryController();
    CodeField codeField = mock(CodeField.class);
    when(codeField.withAttribute(Mockito.<String>any(), Mockito.<Object>any())).thenReturn(new Field());
    CodeField codeField2 = mock(CodeField.class);
    when(codeField2.getValue()).thenReturn("42");
    when(codeField2.withAttribute(Mockito.<String>any(), Mockito.<Object>any())).thenReturn(codeField);
    doNothing().when(codeField2).setFieldType(Mockito.<String>any());
    EntityForm ef = mock(EntityForm.class);
    when(ef.findField(Mockito.<String>any())).thenReturn(codeField2);

    // Act
    adminCategoryController.modifyAddEntityForm(ef, new HashMap<>());

    // Assert
    verify(ef, atLeast(1)).findField(Mockito.<String>any());
    verify(codeField2).getValue();
    verify(codeField2).setFieldType(eq("hidden"));
    verify(codeField2).withAttribute(eq("overriddenUrl"), isA(Object.class));
    verify(codeField).withAttribute(eq("sourceField"), isA(Object.class));
  }

  /**
   * Test {@link AdminCategoryController#modifyAddEntityForm(EntityForm, Map)}.
   * <ul>
   *   <li>Given {@link CodeField} {@link Field#withAttribute(String, Object)}
   * return {@link Field} (default constructor).</li>
   *   <li>Then calls {@link Field#getValue()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminCategoryController#modifyAddEntityForm(EntityForm, Map)}
   */
  @Test
  public void testModifyAddEntityForm_givenCodeFieldWithAttributeReturnField_thenCallsGetValue3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminCategoryController adminCategoryController = new AdminCategoryController();
    CodeField codeField = mock(CodeField.class);
    when(codeField.withAttribute(Mockito.<String>any(), Mockito.<Object>any())).thenReturn(new Field());
    CodeField codeField2 = mock(CodeField.class);
    when(codeField2.withAttribute(Mockito.<String>any(), Mockito.<Object>any())).thenReturn(codeField);
    CodeField codeField3 = mock(CodeField.class);
    when(codeField3.getValue()).thenReturn("42");
    when(codeField3.withAttribute(Mockito.<String>any(), Mockito.<Object>any())).thenReturn(codeField2);
    doNothing().when(codeField3).setFieldType(Mockito.<String>any());
    EntityForm ef = mock(EntityForm.class);
    when(ef.findField(Mockito.<String>any())).thenReturn(codeField3);

    // Act
    adminCategoryController.modifyAddEntityForm(ef, new HashMap<>());

    // Assert
    verify(ef, atLeast(1)).findField(Mockito.<String>any());
    verify(codeField3).getValue();
    verify(codeField3).setFieldType(eq("hidden"));
    verify(codeField3).withAttribute(eq("overriddenUrl"), isA(Object.class));
    verify(codeField2).withAttribute(eq("sourceField"), isA(Object.class));
    verify(codeField).withAttribute(eq("toggleField"), isA(Object.class));
  }

  /**
   * Test {@link AdminCategoryController#modifyAddEntityForm(EntityForm, Map)}.
   * <ul>
   *   <li>Given {@link Field} (default constructor).</li>
   *   <li>When {@link EntityForm} {@link EntityForm#findField(String)} return
   * {@link Field} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminCategoryController#modifyAddEntityForm(EntityForm, Map)}
   */
  @Test
  public void testModifyAddEntityForm_givenField_whenEntityFormFindFieldReturnField() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminCategoryController adminCategoryController = new AdminCategoryController();
    EntityForm ef = mock(EntityForm.class);
    when(ef.findField(Mockito.<String>any())).thenReturn(new Field());

    // Act
    adminCategoryController.modifyAddEntityForm(ef, new HashMap<>());

    // Assert
    verify(ef, atLeast(1)).findField(Mockito.<String>any());
  }

  /**
   * Test {@link AdminCategoryController#modifyAddEntityForm(EntityForm, Map)}.
   * <ul>
   *   <li>Then calls {@link Field#withFieldType(String)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminCategoryController#modifyAddEntityForm(EntityForm, Map)}
   */
  @Test
  public void testModifyAddEntityForm_thenCallsWithFieldType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminCategoryController adminCategoryController = new AdminCategoryController();
    CodeField codeField = mock(CodeField.class);
    when(codeField.withFieldType(Mockito.<String>any())).thenReturn(new Field());
    CodeField codeField2 = mock(CodeField.class);
    when(codeField2.withAttribute(Mockito.<String>any(), Mockito.<Object>any())).thenReturn(codeField);
    CodeField codeField3 = mock(CodeField.class);
    when(codeField3.withAttribute(Mockito.<String>any(), Mockito.<Object>any())).thenReturn(codeField2);
    CodeField codeField4 = mock(CodeField.class);
    when(codeField4.getValue()).thenReturn("42");
    when(codeField4.withAttribute(Mockito.<String>any(), Mockito.<Object>any())).thenReturn(codeField3);
    doNothing().when(codeField4).setFieldType(Mockito.<String>any());
    EntityForm ef = mock(EntityForm.class);
    when(ef.findField(Mockito.<String>any())).thenReturn(codeField4);

    // Act
    adminCategoryController.modifyAddEntityForm(ef, new HashMap<>());

    // Assert
    verify(ef, atLeast(1)).findField(Mockito.<String>any());
    verify(codeField4).getValue();
    verify(codeField4).setFieldType(eq("hidden"));
    verify(codeField4).withAttribute(eq("overriddenUrl"), isA(Object.class));
    verify(codeField3).withAttribute(eq("sourceField"), isA(Object.class));
    verify(codeField2).withAttribute(eq("toggleField"), isA(Object.class));
    verify(codeField).withFieldType(eq("generated_url"));
  }
}
