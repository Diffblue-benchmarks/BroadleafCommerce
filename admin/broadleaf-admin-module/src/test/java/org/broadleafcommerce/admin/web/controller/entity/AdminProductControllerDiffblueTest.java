package org.broadleafcommerce.admin.web.controller.entity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.broadleafcommerce.common.exception.ServiceException;
import org.broadleafcommerce.common.persistence.EntityConfiguration;
import org.broadleafcommerce.common.persistence.EntityDuplicator;
import org.broadleafcommerce.common.sandbox.SandBoxHelper;
import org.broadleafcommerce.common.security.service.ExploitProtectionService;
import org.broadleafcommerce.common.service.GenericEntityService;
import org.broadleafcommerce.core.catalog.service.CatalogService;
import org.broadleafcommerce.openadmin.dto.AdornedTargetCollectionMetadata;
import org.broadleafcommerce.openadmin.dto.ClassMetadata;
import org.broadleafcommerce.openadmin.dto.ClassTree;
import org.broadleafcommerce.openadmin.dto.DynamicResultSet;
import org.broadleafcommerce.openadmin.dto.Entity;
import org.broadleafcommerce.openadmin.dto.FieldMetadata;
import org.broadleafcommerce.openadmin.dto.Property;
import org.broadleafcommerce.openadmin.security.ClassNameRequestParamValidationService;
import org.broadleafcommerce.openadmin.server.dao.DynamicEntityDao;
import org.broadleafcommerce.openadmin.server.domain.PersistencePackageRequest;
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
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.ConcurrentModel;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;

@ContextConfiguration(classes = {AdminProductController.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class AdminProductControllerDiffblueTest {
  @MockBean(name = "blAdminAbstractControllerExtensionManager")
  private AdminAbstractControllerExtensionManager adminAbstractControllerExtensionManager;

  @MockBean
  private AdminEntityService adminEntityService;

  @MockBean
  private AdminNavigationService adminNavigationService;

  @Autowired
  private AdminProductController adminProductController;

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
   * Test {@link AdminProductController#getSectionKey(Map)}.
   * <p>
   * Method under test: {@link AdminProductController#getSectionKey(Map)}
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
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.admin.web.controller.entity.AdminProductController.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass369 {
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blAdminAbstractControllerExtensionManager") org.broadleafcommerce.openadmin.web.controller.AdminAbstractControllerExtensionManager adminAbstractControllerExtensionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.server.service.AdminEntityService adminEntityService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.server.security.service.navigation.AdminNavigationService adminNavigationService;
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.admin.web.controller.entity.AdminProductController adminProductController;
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
    adminProductController.getSectionKey(new HashMap<>());
  }

  /**
   * Test {@link AdminProductController#getSectionKey(Map)}.
   * <ul>
   *   <li>Given {@link BiFunction}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminProductController#getSectionKey(Map)}
   */
  @Test
  public void testGetSectionKey_givenBiFunction() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminProductController adminProductController = new AdminProductController();

    HashMap<String, String> pathVars = new HashMap<>();
    pathVars.computeIfPresent("sectionKey", mock(BiFunction.class));
    pathVars.put("sectionKey", "sectionKey");

    // Act and Assert
    assertEquals("sectionKey", adminProductController.getSectionKey(pathVars));
  }

  /**
   * Test {@link AdminProductController#getSectionKey(Map)}.
   * <ul>
   *   <li>Given {@code sectionKey}.</li>
   *   <li>Then return {@code sectionKey}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminProductController#getSectionKey(Map)}
   */
  @Test
  public void testGetSectionKey_givenSectionKey_thenReturnSectionKey() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminProductController adminProductController = new AdminProductController();

    HashMap<String, String> pathVars = new HashMap<>();
    pathVars.put("sectionKey", "sectionKey");

    // Act and Assert
    assertEquals("sectionKey", adminProductController.getSectionKey(pathVars));
  }

  /**
   * Test {@link AdminProductController#getSectionKey(Map)}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.</li>
   *   <li>Then return {@link AdminProductController#SECTION_KEY}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminProductController#getSectionKey(Map)}
   */
  @Test
  public void testGetSectionKey_whenHashMap_thenReturnSection_key() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminProductController adminProductController = new AdminProductController();

    // Act and Assert
    assertEquals(AdminProductController.SECTION_KEY, adminProductController.getSectionKey(new HashMap<>()));
  }

  /**
   * Test {@link AdminProductController#modifyAddEntityForm(EntityForm, Map)}.
   * <p>
   * Method under test:
   * {@link AdminProductController#modifyAddEntityForm(EntityForm, Map)}
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
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.admin.web.controller.entity.AdminProductController.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass370 {
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blAdminAbstractControllerExtensionManager") org.broadleafcommerce.openadmin.web.controller.AdminAbstractControllerExtensionManager adminAbstractControllerExtensionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.server.service.AdminEntityService adminEntityService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.server.security.service.navigation.AdminNavigationService adminNavigationService;
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.admin.web.controller.entity.AdminProductController adminProductController;
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
    adminProductController.modifyAddEntityForm(ef, new HashMap<>());
  }

  /**
   * Test {@link AdminProductController#modifyAddEntityForm(EntityForm, Map)}.
   * <ul>
   *   <li>Given {@link CodeField} {@link Field#withAttribute(String, Object)}
   * return {@link Field} (default constructor).</li>
   *   <li>Then calls {@link Field#getValue()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminProductController#modifyAddEntityForm(EntityForm, Map)}
   */
  @Test
  public void testModifyAddEntityForm_givenCodeFieldWithAttributeReturnField_thenCallsGetValue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminProductController adminProductController = new AdminProductController();
    CodeField codeField = mock(CodeField.class);
    when(codeField.getValue()).thenReturn(null);
    when(codeField.withAttribute(Mockito.<String>any(), Mockito.<Object>any())).thenReturn(new Field());
    doNothing().when(codeField).setFieldType(Mockito.<String>any());
    EntityForm ef = mock(EntityForm.class);
    when(ef.findField(Mockito.<String>any())).thenReturn(codeField);

    // Act
    adminProductController.modifyAddEntityForm(ef, new HashMap<>());

    // Assert
    verify(ef, atLeast(1)).findField(Mockito.<String>any());
    verify(codeField, atLeast(1)).getValue();
    verify(codeField).setFieldType(eq("hidden"));
    verify(codeField).withAttribute(eq("overriddenUrl"), isA(Object.class));
  }

  /**
   * Test {@link AdminProductController#modifyAddEntityForm(EntityForm, Map)}.
   * <ul>
   *   <li>Given {@link CodeField} {@link Field#withAttribute(String, Object)}
   * return {@link Field} (default constructor).</li>
   *   <li>Then calls {@link Field#getValue()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminProductController#modifyAddEntityForm(EntityForm, Map)}
   */
  @Test
  public void testModifyAddEntityForm_givenCodeFieldWithAttributeReturnField_thenCallsGetValue2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminProductController adminProductController = new AdminProductController();
    CodeField codeField = mock(CodeField.class);
    when(codeField.withAttribute(Mockito.<String>any(), Mockito.<Object>any())).thenReturn(new Field());
    CodeField codeField2 = mock(CodeField.class);
    when(codeField2.getValue()).thenReturn(null);
    when(codeField2.withAttribute(Mockito.<String>any(), Mockito.<Object>any())).thenReturn(codeField);
    doNothing().when(codeField2).setFieldType(Mockito.<String>any());
    EntityForm ef = mock(EntityForm.class);
    when(ef.findField(Mockito.<String>any())).thenReturn(codeField2);

    // Act
    adminProductController.modifyAddEntityForm(ef, new HashMap<>());

    // Assert
    verify(ef, atLeast(1)).findField(Mockito.<String>any());
    verify(codeField2, atLeast(1)).getValue();
    verify(codeField2).setFieldType(eq("hidden"));
    verify(codeField2).withAttribute(eq("overriddenUrl"), isA(Object.class));
    verify(codeField).withAttribute(eq("sourceField"), isA(Object.class));
  }

  /**
   * Test {@link AdminProductController#modifyAddEntityForm(EntityForm, Map)}.
   * <ul>
   *   <li>Given {@link CodeField} {@link Field#withAttribute(String, Object)}
   * return {@link Field} (default constructor).</li>
   *   <li>Then calls {@link Field#getValue()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminProductController#modifyAddEntityForm(EntityForm, Map)}
   */
  @Test
  public void testModifyAddEntityForm_givenCodeFieldWithAttributeReturnField_thenCallsGetValue3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminProductController adminProductController = new AdminProductController();
    CodeField codeField = mock(CodeField.class);
    when(codeField.withAttribute(Mockito.<String>any(), Mockito.<Object>any())).thenReturn(new Field());
    CodeField codeField2 = mock(CodeField.class);
    when(codeField2.withAttribute(Mockito.<String>any(), Mockito.<Object>any())).thenReturn(codeField);
    CodeField codeField3 = mock(CodeField.class);
    when(codeField3.getValue()).thenReturn(null);
    when(codeField3.withAttribute(Mockito.<String>any(), Mockito.<Object>any())).thenReturn(codeField2);
    doNothing().when(codeField3).setFieldType(Mockito.<String>any());
    EntityForm ef = mock(EntityForm.class);
    when(ef.findField(Mockito.<String>any())).thenReturn(codeField3);

    // Act
    adminProductController.modifyAddEntityForm(ef, new HashMap<>());

    // Assert
    verify(ef, atLeast(1)).findField(Mockito.<String>any());
    verify(codeField3, atLeast(1)).getValue();
    verify(codeField3).setFieldType(eq("hidden"));
    verify(codeField3).withAttribute(eq("overriddenUrl"), isA(Object.class));
    verify(codeField2).withAttribute(eq("sourceField"), isA(Object.class));
    verify(codeField).withAttribute(eq("toggleField"), isA(Object.class));
  }

  /**
   * Test {@link AdminProductController#modifyAddEntityForm(EntityForm, Map)}.
   * <ul>
   *   <li>Given {@link CodeField} {@link Field#withAttribute(String, Object)}
   * return {@link Field} (default constructor).</li>
   *   <li>Then calls {@link Field#getValue()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminProductController#modifyAddEntityForm(EntityForm, Map)}
   */
  @Test
  public void testModifyAddEntityForm_givenCodeFieldWithAttributeReturnField_thenCallsGetValue4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminProductController adminProductController = new AdminProductController();
    CodeField codeField = mock(CodeField.class);
    when(codeField.withAttribute(Mockito.<String>any(), Mockito.<Object>any())).thenReturn(new Field());
    CodeField codeField2 = mock(CodeField.class);
    when(codeField2.withAttribute(Mockito.<String>any(), Mockito.<Object>any())).thenReturn(codeField);
    CodeField codeField3 = mock(CodeField.class);
    when(codeField3.withAttribute(Mockito.<String>any(), Mockito.<Object>any())).thenReturn(codeField2);
    CodeField codeField4 = mock(CodeField.class);
    when(codeField4.getValue()).thenReturn(null);
    when(codeField4.withAttribute(Mockito.<String>any(), Mockito.<Object>any())).thenReturn(codeField3);
    doNothing().when(codeField4).setFieldType(Mockito.<String>any());
    EntityForm ef = mock(EntityForm.class);
    when(ef.findField(Mockito.<String>any())).thenReturn(codeField4);

    // Act
    adminProductController.modifyAddEntityForm(ef, new HashMap<>());

    // Assert
    verify(ef, atLeast(1)).findField(Mockito.<String>any());
    verify(codeField4, atLeast(1)).getValue();
    verify(codeField4).setFieldType(eq("hidden"));
    verify(codeField4).withAttribute(eq("overriddenUrl"), isA(Object.class));
    verify(codeField).withAttribute(eq("prefix-selector"), isA(Object.class));
    verify(codeField3).withAttribute(eq("sourceField"), isA(Object.class));
    verify(codeField2).withAttribute(eq("toggleField"), isA(Object.class));
  }

  /**
   * Test {@link AdminProductController#modifyAddEntityForm(EntityForm, Map)}.
   * <ul>
   *   <li>Given {@link CodeField} {@link Field#withAttribute(String, Object)}
   * return {@link Field} (default constructor).</li>
   *   <li>Then calls {@link Field#getValue()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminProductController#modifyAddEntityForm(EntityForm, Map)}
   */
  @Test
  public void testModifyAddEntityForm_givenCodeFieldWithAttributeReturnField_thenCallsGetValue5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminProductController adminProductController = new AdminProductController();
    CodeField codeField = mock(CodeField.class);
    when(codeField.withAttribute(Mockito.<String>any(), Mockito.<Object>any())).thenReturn(new Field());
    CodeField codeField2 = mock(CodeField.class);
    when(codeField2.withAttribute(Mockito.<String>any(), Mockito.<Object>any())).thenReturn(codeField);
    CodeField codeField3 = mock(CodeField.class);
    when(codeField3.withAttribute(Mockito.<String>any(), Mockito.<Object>any())).thenReturn(codeField2);
    CodeField codeField4 = mock(CodeField.class);
    when(codeField4.withAttribute(Mockito.<String>any(), Mockito.<Object>any())).thenReturn(codeField3);
    CodeField codeField5 = mock(CodeField.class);
    when(codeField5.getValue()).thenReturn(null);
    when(codeField5.withAttribute(Mockito.<String>any(), Mockito.<Object>any())).thenReturn(codeField4);
    doNothing().when(codeField5).setFieldType(Mockito.<String>any());
    EntityForm ef = mock(EntityForm.class);
    when(ef.findField(Mockito.<String>any())).thenReturn(codeField5);

    // Act
    adminProductController.modifyAddEntityForm(ef, new HashMap<>());

    // Assert
    verify(ef, atLeast(1)).findField(Mockito.<String>any());
    verify(codeField5, atLeast(1)).getValue();
    verify(codeField5).setFieldType(eq("hidden"));
    verify(codeField5).withAttribute(eq("overriddenUrl"), isA(Object.class));
    verify(codeField).withAttribute(eq("prefix"), isNull());
    verify(codeField2).withAttribute(eq("prefix-selector"), isA(Object.class));
    verify(codeField4).withAttribute(eq("sourceField"), isA(Object.class));
    verify(codeField3).withAttribute(eq("toggleField"), isA(Object.class));
  }

  /**
   * Test {@link AdminProductController#modifyAddEntityForm(EntityForm, Map)}.
   * <ul>
   *   <li>Given {@link Field} (default constructor).</li>
   *   <li>When {@link EntityForm} {@link EntityForm#findField(String)} return
   * {@link Field} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminProductController#modifyAddEntityForm(EntityForm, Map)}
   */
  @Test
  public void testModifyAddEntityForm_givenField_whenEntityFormFindFieldReturnField() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminProductController adminProductController = new AdminProductController();
    EntityForm ef = mock(EntityForm.class);
    when(ef.findField(Mockito.<String>any())).thenReturn(new Field());

    // Act
    adminProductController.modifyAddEntityForm(ef, new HashMap<>());

    // Assert
    verify(ef, atLeast(1)).findField(Mockito.<String>any());
  }

  /**
   * Test {@link AdminProductController#modifyAddEntityForm(EntityForm, Map)}.
   * <ul>
   *   <li>Then calls {@link Field#withFieldType(String)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminProductController#modifyAddEntityForm(EntityForm, Map)}
   */
  @Test
  public void testModifyAddEntityForm_thenCallsWithFieldType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminProductController adminProductController = new AdminProductController();
    CodeField codeField = mock(CodeField.class);
    when(codeField.withFieldType(Mockito.<String>any())).thenReturn(new Field());
    CodeField codeField2 = mock(CodeField.class);
    when(codeField2.withAttribute(Mockito.<String>any(), Mockito.<Object>any())).thenReturn(codeField);
    CodeField codeField3 = mock(CodeField.class);
    when(codeField3.withAttribute(Mockito.<String>any(), Mockito.<Object>any())).thenReturn(codeField2);
    CodeField codeField4 = mock(CodeField.class);
    when(codeField4.withAttribute(Mockito.<String>any(), Mockito.<Object>any())).thenReturn(codeField3);
    CodeField codeField5 = mock(CodeField.class);
    when(codeField5.withAttribute(Mockito.<String>any(), Mockito.<Object>any())).thenReturn(codeField4);
    CodeField codeField6 = mock(CodeField.class);
    when(codeField6.getValue()).thenReturn(null);
    when(codeField6.withAttribute(Mockito.<String>any(), Mockito.<Object>any())).thenReturn(codeField5);
    doNothing().when(codeField6).setFieldType(Mockito.<String>any());
    EntityForm ef = mock(EntityForm.class);
    when(ef.findField(Mockito.<String>any())).thenReturn(codeField6);

    // Act
    adminProductController.modifyAddEntityForm(ef, new HashMap<>());

    // Assert
    verify(ef, atLeast(1)).findField(Mockito.<String>any());
    verify(codeField6, atLeast(1)).getValue();
    verify(codeField6).setFieldType(eq("hidden"));
    verify(codeField6).withAttribute(eq("overriddenUrl"), isA(Object.class));
    verify(codeField2).withAttribute(eq("prefix"), isNull());
    verify(codeField3).withAttribute(eq("prefix-selector"), isA(Object.class));
    verify(codeField5).withAttribute(eq("sourceField"), isA(Object.class));
    verify(codeField4).withAttribute(eq("toggleField"), isA(Object.class));
    verify(codeField).withFieldType(eq("generated_url"));
  }

  /**
   * Test {@link AdminProductController#modifyEntityForm(EntityForm, Map)} with
   * {@code entityForm}, {@code pathVars}.
   * <p>
   * Method under test:
   * {@link AdminProductController#modifyEntityForm(EntityForm, Map)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testModifyEntityFormWithEntityFormPathVars() throws Exception {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.admin.web.controller.entity;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.admin.web.controller.entity.AdminProductController.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass372 {
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blAdminAbstractControllerExtensionManager") org.broadleafcommerce.openadmin.web.controller.AdminAbstractControllerExtensionManager adminAbstractControllerExtensionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.server.service.AdminEntityService adminEntityService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.server.security.service.navigation.AdminNavigationService adminNavigationService;
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.admin.web.controller.entity.AdminProductController adminProductController;
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
    EntityForm entityForm = new EntityForm();

    // Act
    adminProductController.modifyEntityForm(entityForm, new HashMap<>());
  }

  /**
   * Test {@link AdminProductController#modifyEntityForm(EntityForm, Map)} with
   * {@code entityForm}, {@code pathVars}.
   * <ul>
   *   <li>Given {@link Field} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminProductController#modifyEntityForm(EntityForm, Map)}
   */
  @Test
  public void testModifyEntityFormWithEntityFormPathVars_givenField() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminProductController adminProductController = new AdminProductController();
    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.findField(Mockito.<String>any())).thenReturn(new Field());

    // Act
    adminProductController.modifyEntityForm(entityForm, new HashMap<>());

    // Assert
    verify(entityForm, atLeast(1)).findField(Mockito.<String>any());
  }

  /**
   * Test {@link AdminProductController#modifyEntityForm(EntityForm, Map)} with
   * {@code entityForm}, {@code pathVars}.
   * <ul>
   *   <li>Then calls {@link Field#getValue()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminProductController#modifyEntityForm(EntityForm, Map)}
   */
  @Test
  public void testModifyEntityFormWithEntityFormPathVars_thenCallsGetValue() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminProductController adminProductController = new AdminProductController();
    CodeField codeField = mock(CodeField.class);
    when(codeField.getValue()).thenReturn("42");
    doNothing().when(codeField).setReadOnly(Mockito.<Boolean>any());
    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.findField(Mockito.<String>any())).thenReturn(codeField);

    // Act
    adminProductController.modifyEntityForm(entityForm, new HashMap<>());

    // Assert
    verify(entityForm, atLeast(1)).findField(Mockito.<String>any());
    verify(codeField).getValue();
    verify(codeField).setReadOnly(eq(true));
  }

  /**
   * Test
   * {@link AdminProductController#showAddAdditionalSku(HttpServletRequest, HttpServletResponse, Model, String, Map)}.
   * <p>
   * Method under test:
   * {@link AdminProductController#showAddAdditionalSku(HttpServletRequest, HttpServletResponse, Model, String, Map)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testShowAddAdditionalSku() throws Exception {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.admin.web.controller.entity;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.admin.web.controller.entity.AdminProductController.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass373 {
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blAdminAbstractControllerExtensionManager") org.broadleafcommerce.openadmin.web.controller.AdminAbstractControllerExtensionManager adminAbstractControllerExtensionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.server.service.AdminEntityService adminEntityService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.server.security.service.navigation.AdminNavigationService adminNavigationService;
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.admin.web.controller.entity.AdminProductController adminProductController;
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
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();
    ConcurrentModel model = new ConcurrentModel();

    // Act
    adminProductController.showAddAdditionalSku(request, response, model, "42", new HashMap<>());
  }

  /**
   * Test
   * {@link AdminProductController#buildAddCollectionItemModel(HttpServletRequest, HttpServletResponse, Model, String, String, String, Property, FieldMetadata, PersistencePackageRequest, EntityForm, Entity)}.
   * <p>
   * Method under test:
   * {@link AdminProductController#buildAddCollectionItemModel(HttpServletRequest, HttpServletResponse, Model, String, String, String, Property, FieldMetadata, PersistencePackageRequest, EntityForm, Entity)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testBuildAddCollectionItemModel() throws ServiceException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.admin.web.controller.entity;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.admin.web.controller.entity.AdminProductController.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass367 {
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blAdminAbstractControllerExtensionManager") org.broadleafcommerce.openadmin.web.controller.AdminAbstractControllerExtensionManager adminAbstractControllerExtensionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.server.service.AdminEntityService adminEntityService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.server.security.service.navigation.AdminNavigationService adminNavigationService;
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.admin.web.controller.entity.AdminProductController adminProductController;
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
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();
    ConcurrentModel model = new ConcurrentModel();
    Property collectionProperty = new Property();
    AdornedTargetCollectionMetadata md = new AdornedTargetCollectionMetadata();
    PersistencePackageRequest ppr = PersistencePackageRequest.adorned();
    EntityForm entityForm = new EntityForm();

    // Act
    adminProductController.buildAddCollectionItemModel(request, response, model, "42", "Collection Field",
        "Section Key", collectionProperty, md, ppr, entityForm, new Entity());
  }

  /**
   * Test
   * {@link AdminProductController#showUpdateAdditionalSku(HttpServletRequest, Model, String, String, Map, EntityForm)}.
   * <p>
   * Method under test:
   * {@link AdminProductController#showUpdateAdditionalSku(HttpServletRequest, Model, String, String, Map, EntityForm)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testShowUpdateAdditionalSku() throws Exception {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.admin.web.controller.entity;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.admin.web.controller.entity.AdminProductController.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass374 {
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blAdminAbstractControllerExtensionManager") org.broadleafcommerce.openadmin.web.controller.AdminAbstractControllerExtensionManager adminAbstractControllerExtensionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.server.service.AdminEntityService adminEntityService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.server.security.service.navigation.AdminNavigationService adminNavigationService;
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.admin.web.controller.entity.AdminProductController adminProductController;
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
    MockHttpServletRequest request = new MockHttpServletRequest();
    ConcurrentModel model = new ConcurrentModel();
    HashMap<String, String> pathVars = new HashMap<>();

    // Act
    adminProductController.showUpdateAdditionalSku(request, model, "42", "42", pathVars, new EntityForm());
  }

  /**
   * Test
   * {@link AdminProductController#viewEntityListSelectize(HttpServletRequest, HttpServletResponse, Model, Map, MultiValueMap)}.
   * <p>
   * Method under test:
   * {@link AdminProductController#viewEntityListSelectize(HttpServletRequest, HttpServletResponse, Model, Map, MultiValueMap)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testViewEntityListSelectize() throws Exception {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.admin.web.controller.entity;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.admin.web.controller.entity.AdminProductController.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass365 {
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blAdminAbstractControllerExtensionManager") org.broadleafcommerce.openadmin.web.controller.AdminAbstractControllerExtensionManager adminAbstractControllerExtensionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.server.service.AdminEntityService adminEntityService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.server.security.service.navigation.AdminNavigationService adminNavigationService;
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.admin.web.controller.entity.AdminProductController adminProductController;
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
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/product/selectize");

    // Act
    MockMvcBuilders.standaloneSetup(adminProductController).build().perform(requestBuilder);
  }

  /**
   * Test
   * {@link AdminProductController#constructSelectizeOptionMap(DynamicResultSet, ClassMetadata)}.
   * <p>
   * Method under test:
   * {@link AdminProductController#constructSelectizeOptionMap(DynamicResultSet, ClassMetadata)}
   */
  @Test
  public void testConstructSelectizeOptionMap() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminProductController adminProductController = new AdminProductController();

    DynamicResultSet drs = new DynamicResultSet();
    drs.setRecords(new Entity[]{new Entity()});

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[]{new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act
    Map<String, Object> actualConstructSelectizeOptionMapResult = adminProductController
        .constructSelectizeOptionMap(drs, cmd);

    // Assert
    assertEquals(1, actualConstructSelectizeOptionMapResult.size());
    Object getResult = actualConstructSelectizeOptionMapResult.get("options");
    assertTrue(getResult instanceof List);
    assertEquals(1, ((List<HashMap>) getResult).size());
    assertTrue(((List<HashMap>) getResult).get(0).isEmpty());
  }

  /**
   * Test
   * {@link AdminProductController#constructSelectizeOptionMap(DynamicResultSet, ClassMetadata)}.
   * <p>
   * Method under test:
   * {@link AdminProductController#constructSelectizeOptionMap(DynamicResultSet, ClassMetadata)}
   */
  @Test
  public void testConstructSelectizeOptionMap2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminProductController adminProductController = new AdminProductController();
    DynamicResultSet drs = mock(DynamicResultSet.class);
    when(drs.getRecords()).thenReturn(new Entity[]{new Entity()});

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[]{new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act
    Map<String, Object> actualConstructSelectizeOptionMapResult = adminProductController
        .constructSelectizeOptionMap(drs, cmd);

    // Assert
    verify(drs).getRecords();
    assertEquals(1, actualConstructSelectizeOptionMapResult.size());
    Object getResult = actualConstructSelectizeOptionMapResult.get("options");
    assertTrue(getResult instanceof List);
    assertEquals(1, ((List<HashMap>) getResult).size());
    assertTrue(((List<HashMap>) getResult).get(0).isEmpty());
  }

  /**
   * Test
   * {@link AdminProductController#constructSelectizeOptionMap(DynamicResultSet, ClassMetadata)}.
   * <p>
   * Method under test:
   * {@link AdminProductController#constructSelectizeOptionMap(DynamicResultSet, ClassMetadata)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testConstructSelectizeOptionMap3() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.admin.web.controller.entity;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.admin.web.controller.entity.AdminProductController.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass368 {
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blAdminAbstractControllerExtensionManager") org.broadleafcommerce.openadmin.web.controller.AdminAbstractControllerExtensionManager adminAbstractControllerExtensionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.server.service.AdminEntityService adminEntityService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.server.security.service.navigation.AdminNavigationService adminNavigationService;
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.admin.web.controller.entity.AdminProductController adminProductController;
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
    DynamicResultSet drs = new DynamicResultSet();

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[]{new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act
    adminProductController.constructSelectizeOptionMap(drs, cmd);
  }

  /**
   * Test
   * {@link AdminProductController#constructSelectizeOptionMap(DynamicResultSet, ClassMetadata)}.
   * <ul>
   *   <li>Then return {@code options} first {@code alternateId} is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminProductController#constructSelectizeOptionMap(DynamicResultSet, ClassMetadata)}
   */
  @Test
  public void testConstructSelectizeOptionMap_thenReturnOptionsFirstAlternateIdIs42() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminProductController adminProductController = new AdminProductController();
    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("42");
    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);
    DynamicResultSet drs = mock(DynamicResultSet.class);
    when(drs.getRecords()).thenReturn(new Entity[]{entity});

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[]{new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act
    Map<String, Object> actualConstructSelectizeOptionMapResult = adminProductController
        .constructSelectizeOptionMap(drs, cmd);

    // Assert
    verify(drs).getRecords();
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
    verify(property, atLeast(1)).getValue();
    assertEquals(1, actualConstructSelectizeOptionMapResult.size());
    Object getResult = actualConstructSelectizeOptionMapResult.get("options");
    assertTrue(getResult instanceof List);
    assertEquals(1, ((List<HashMap>) getResult).size());
    HashMap getResult2 = ((List<HashMap>) getResult).get(0);
    assertEquals(3, getResult2.size());
    assertEquals("42", getResult2.get("alternateId"));
    assertEquals("42", getResult2.get("id"));
    assertEquals("42", getResult2.get(AdminProductController.SELECTIZE_NAME_PROPERTY));
  }

  /**
   * Test
   * {@link AdminProductController#constructSelectizeOptionMap(DynamicResultSet, ClassMetadata)}.
   * <ul>
   *   <li>Then return {@code options} first {@code alternateId} is
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminProductController#constructSelectizeOptionMap(DynamicResultSet, ClassMetadata)}
   */
  @Test
  public void testConstructSelectizeOptionMap_thenReturnOptionsFirstAlternateIdIsNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminProductController adminProductController = new AdminProductController();
    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(new Property());
    DynamicResultSet drs = mock(DynamicResultSet.class);
    when(drs.getRecords()).thenReturn(new Entity[]{entity});

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[]{new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act
    Map<String, Object> actualConstructSelectizeOptionMapResult = adminProductController
        .constructSelectizeOptionMap(drs, cmd);

    // Assert
    verify(drs).getRecords();
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
    assertEquals(1, actualConstructSelectizeOptionMapResult.size());
    Object getResult = actualConstructSelectizeOptionMapResult.get("options");
    assertTrue(getResult instanceof List);
    assertEquals(1, ((List<HashMap>) getResult).size());
    HashMap getResult2 = ((List<HashMap>) getResult).get(0);
    assertEquals(3, getResult2.size());
    assertNull(getResult2.get("alternateId"));
    assertNull(getResult2.get("id"));
    assertNull(getResult2.get(AdminProductController.SELECTIZE_NAME_PROPERTY));
  }

  /**
   * Test
   * {@link AdminProductController#constructSelectizeOptionMap(DynamicResultSet, ClassMetadata)}.
   * <ul>
   *   <li>When {@link DynamicResultSet#DynamicResultSet()}.</li>
   *   <li>Then return {@code options} Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminProductController#constructSelectizeOptionMap(DynamicResultSet, ClassMetadata)}
   */
  @Test
  public void testConstructSelectizeOptionMap_whenDynamicResultSet_thenReturnOptionsEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminProductController adminProductController = new AdminProductController();
    DynamicResultSet drs = new DynamicResultSet();

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[]{new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act
    Map<String, Object> actualConstructSelectizeOptionMapResult = adminProductController
        .constructSelectizeOptionMap(drs, cmd);

    // Assert
    assertEquals(1, actualConstructSelectizeOptionMapResult.size());
    Object getResult = actualConstructSelectizeOptionMapResult.get("options");
    assertTrue(getResult instanceof List);
    assertTrue(((List<Object>) getResult).isEmpty());
  }

  /**
   * Test
   * {@link AdminProductController#showUpdateCollectionItem(HttpServletRequest, HttpServletResponse, Model, Map, String, String, String)}
   * with {@code request}, {@code response}, {@code model}, {@code pathVars},
   * {@code id}, {@code collectionField}, {@code collectionItemId}.
   * <p>
   * Method under test:
   * {@link AdminProductController#showUpdateCollectionItem(HttpServletRequest, HttpServletResponse, Model, Map, String, String, String)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testShowUpdateCollectionItemWithRequestResponseModelPathVarsIdCollectionFieldCollectionItemId()
      throws Exception {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.admin.web.controller.entity;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.admin.web.controller.entity.AdminProductController.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass363 {
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blAdminAbstractControllerExtensionManager") org.broadleafcommerce.openadmin.web.controller.AdminAbstractControllerExtensionManager adminAbstractControllerExtensionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.server.service.AdminEntityService adminEntityService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.server.security.service.navigation.AdminNavigationService adminNavigationService;
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.admin.web.controller.entity.AdminProductController adminProductController;
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
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
        .get("/product/{id}/{collectionField:.*}/{collectionItemId}", "42", "U", "42");

    // Act
    MockMvcBuilders.standaloneSetup(adminProductController).build().perform(requestBuilder);
  }

  /**
   * Test
   * {@link AdminProductController#showViewUpdateCollection(HttpServletRequest, Model, Map, String, String, String, String, String, EntityForm, Entity)}
   * with {@code request}, {@code model}, {@code pathVars}, {@code id},
   * {@code collectionField}, {@code collectionItemId}, {@code alternateId},
   * {@code modalHeaderType}, {@code entityForm}, {@code entity}.
   * <p>
   * Method under test:
   * {@link AdminProductController#showViewUpdateCollection(HttpServletRequest, Model, Map, String, String, String, String, String, EntityForm, Entity)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testShowViewUpdateCollectionWithRequestModelPathVarsIdCollectionFieldCollectionItemIdAlternateIdModalHeaderTypeEntityFormEntity()
      throws ServiceException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.admin.web.controller.entity;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.admin.web.controller.entity.AdminProductController.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass375 {
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blAdminAbstractControllerExtensionManager") org.broadleafcommerce.openadmin.web.controller.AdminAbstractControllerExtensionManager adminAbstractControllerExtensionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.server.service.AdminEntityService adminEntityService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.server.security.service.navigation.AdminNavigationService adminNavigationService;
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.admin.web.controller.entity.AdminProductController adminProductController;
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
    MockHttpServletRequest request = new MockHttpServletRequest();
    ConcurrentModel model = new ConcurrentModel();
    HashMap<String, String> pathVars = new HashMap<>();
    EntityForm entityForm = new EntityForm();

    // Act
    adminProductController.showViewUpdateCollection(request, model, pathVars, "42", "Collection Field", "42", "42",
        "Modal Header Type", entityForm, new Entity());
  }

  /**
   * Test
   * {@link AdminProductController#showAddCollectionItem(HttpServletRequest, HttpServletResponse, Model, Map, String, String, MultiValueMap)}.
   * <p>
   * Method under test:
   * {@link AdminProductController#showAddCollectionItem(HttpServletRequest, HttpServletResponse, Model, Map, String, String, MultiValueMap)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testShowAddCollectionItem() throws Exception {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.admin.web.controller.entity;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.admin.web.controller.entity.AdminProductController.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass362 {
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blAdminAbstractControllerExtensionManager") org.broadleafcommerce.openadmin.web.controller.AdminAbstractControllerExtensionManager adminAbstractControllerExtensionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.server.service.AdminEntityService adminEntityService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.server.security.service.navigation.AdminNavigationService adminNavigationService;
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.admin.web.controller.entity.AdminProductController adminProductController;
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
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/product/{id}/{collectionField}/add",
        "42", "Collection Field");

    // Act
    MockMvcBuilders.standaloneSetup(adminProductController).build().perform(requestBuilder);
  }

  /**
   * Test
   * {@link AdminProductController#viewEntityForm(HttpServletRequest, HttpServletResponse, Model, Map, String)}.
   * <p>
   * Method under test:
   * {@link AdminProductController#viewEntityForm(HttpServletRequest, HttpServletResponse, Model, Map, String)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testViewEntityForm() throws Exception {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.admin.web.controller.entity;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.admin.web.controller.entity.AdminProductController.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass364 {
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blAdminAbstractControllerExtensionManager") org.broadleafcommerce.openadmin.web.controller.AdminAbstractControllerExtensionManager adminAbstractControllerExtensionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.server.service.AdminEntityService adminEntityService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.server.security.service.navigation.AdminNavigationService adminNavigationService;
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.admin.web.controller.entity.AdminProductController adminProductController;
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
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/product/{id}", "42");

    // Act
    MockMvcBuilders.standaloneSetup(adminProductController).build().perform(requestBuilder);
  }

  /**
   * Test {@link AdminProductController#modifyCriteria(Map)}.
   * <p>
   * Method under test: {@link AdminProductController#modifyCriteria(Map)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testModifyCriteria() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.admin.web.controller.entity;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.admin.web.controller.entity.AdminProductController.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass371 {
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blAdminAbstractControllerExtensionManager") org.broadleafcommerce.openadmin.web.controller.AdminAbstractControllerExtensionManager adminAbstractControllerExtensionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.server.service.AdminEntityService adminEntityService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.server.security.service.navigation.AdminNavigationService adminNavigationService;
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.admin.web.controller.entity.AdminProductController adminProductController;
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
    adminProductController.modifyCriteria(new HashMap<>());
  }

  /**
   * Test
   * {@link AdminProductController#addCollectionItem(HttpServletRequest, HttpServletResponse, Model, Map, String, String, EntityForm, BindingResult)}
   * with {@code request}, {@code response}, {@code model}, {@code pathVars},
   * {@code id}, {@code collectionField}, {@code entityForm}, {@code result}.
   * <p>
   * Method under test:
   * {@link AdminProductController#addCollectionItem(HttpServletRequest, HttpServletResponse, Model, Map, String, String, EntityForm, BindingResult)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testAddCollectionItemWithRequestResponseModelPathVarsIdCollectionFieldEntityFormResult()
      throws Exception {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.admin.web.controller.entity;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.admin.web.controller.entity.AdminProductController.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass366 {
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blAdminAbstractControllerExtensionManager") org.broadleafcommerce.openadmin.web.controller.AdminAbstractControllerExtensionManager adminAbstractControllerExtensionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.server.service.AdminEntityService adminEntityService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.server.security.service.navigation.AdminNavigationService adminNavigationService;
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.admin.web.controller.entity.AdminProductController adminProductController;
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
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();
    ConcurrentModel model = new ConcurrentModel();
    HashMap<String, String> pathVars = new HashMap<>();
    EntityForm entityForm = new EntityForm();

    // Act
    adminProductController.addCollectionItem(request, response, model, pathVars, "42", "Collection Field", entityForm,
        new BindException("Target", "Object Name"));
  }
}
