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
package org.broadleafcommerce.cms.admin.web.controller;

import java.io.InputStream;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.broadleafcommerce.cms.file.service.StaticAssetService;
import org.broadleafcommerce.cms.file.service.StaticAssetStorageService;
import org.broadleafcommerce.common.persistence.EntityConfiguration;
import org.broadleafcommerce.common.security.service.ExploitProtectionService;
import org.broadleafcommerce.openadmin.security.ClassNameRequestParamValidationService;
import org.broadleafcommerce.openadmin.server.security.remote.SecurityVerifier;
import org.broadleafcommerce.openadmin.server.security.service.navigation.AdminNavigationService;
import org.broadleafcommerce.openadmin.server.service.AdminEntityService;
import org.broadleafcommerce.openadmin.server.service.AdminSectionCustomCriteriaService;
import org.broadleafcommerce.openadmin.server.service.extension.FilterProductTypePersistenceHandlerExtensionManager;
import org.broadleafcommerce.openadmin.web.controller.AdminAbstractControllerExtensionManager;
import org.broadleafcommerce.openadmin.web.form.entity.EntityFormValidator;
import org.broadleafcommerce.openadmin.web.service.FormBuilderService;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.multipart.MultipartFile;

@ContextConfiguration(classes = {AdminAssetUploadController.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class AdminAssetUploadControllerDiffblueTest {
  @MockBean(name = "blAdminAbstractControllerExtensionManager")
  private AdminAbstractControllerExtensionManager adminAbstractControllerExtensionManager;

  @MockBean(name = "blAdminAssetController")
  private AdminAssetController adminAssetController;

  @Autowired
  private AdminAssetUploadController adminAssetUploadController;

  @MockBean
  private AdminEntityService adminEntityService;

  @MockBean
  private AdminNavigationService adminNavigationService;

  @MockBean
  private AdminSectionCustomCriteriaService adminSectionCustomCriteriaService;

  @MockBean
  private ClassNameRequestParamValidationService classNameRequestParamValidationService;

  @MockBean(name = "blEntityConfiguration")
  private EntityConfiguration entityConfiguration;

  @MockBean(name = "blEntityFormValidator")
  private EntityFormValidator entityFormValidator;

  @MockBean
  private ExploitProtectionService exploitProtectionService;

  @MockBean(name = "blFilterProductTypePersistenceHandlerExtensionManager")
  private FilterProductTypePersistenceHandlerExtensionManager filterProductTypePersistenceHandlerExtensionManager;

  @MockBean
  private FormBuilderService formBuilderService;

  @MockBean
  private SecurityVerifier securityVerifier;

  @MockBean
  private StaticAssetService staticAssetService;

  @MockBean
  private StaticAssetStorageService staticAssetStorageService;

  /**
   * Test
   * {@link AdminAssetUploadController#chooseMediaForMapKey(HttpServletRequest, HttpServletResponse, Model, String, String, String, MultiValueMap)}
   * with {@code request}, {@code response}, {@code model}, {@code sectionKey},
   * {@code addlSectionKey}, {@code id}, {@code requestParams}.
   * <p>
   * Method under test:
   * {@link AdminAssetUploadController#chooseMediaForMapKey(HttpServletRequest, HttpServletResponse, Model, String, String, String, MultiValueMap)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testChooseMediaForMapKeyWithRequestResponseModelSectionKeyAddlSectionKeyIdRequestParams()
      throws Exception {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.admin.web.controller;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.cms.admin.web.controller.AdminAssetUploadController.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3094 {
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blAdminAbstractControllerExtensionManager") org.broadleafcommerce.openadmin.web.controller.AdminAbstractControllerExtensionManager adminAbstractControllerExtensionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blAdminAssetController") org.broadleafcommerce.cms.admin.web.controller.AdminAssetController adminAssetController;
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.admin.web.controller.AdminAssetUploadController adminAssetUploadController;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.server.service.AdminEntityService adminEntityService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.server.security.service.navigation.AdminNavigationService adminNavigationService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.server.service.AdminSectionCustomCriteriaService adminSectionCustomCriteriaService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.security.ClassNameRequestParamValidationService classNameRequestParamValidationService;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blEntityConfiguration") org.broadleafcommerce.common.persistence.EntityConfiguration entityConfiguration;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blEntityFormValidator") org.broadleafcommerce.openadmin.web.form.entity.EntityFormValidator entityFormValidator;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.common.security.service.ExploitProtectionService exploitProtectionService;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blFilterProductTypePersistenceHandlerExtensionManager") org.broadleafcommerce.openadmin.server.service.extension.FilterProductTypePersistenceHandlerExtensionManager filterProductTypePersistenceHandlerExtensionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.web.service.FormBuilderService formBuilderService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.server.security.remote.SecurityVerifier securityVerifier;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.cms.file.service.StaticAssetService staticAssetService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.cms.file.service.StaticAssetStorageService staticAssetStorageService;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
        .get("/{sectionKey}/{addlSectionKey}/{id}/chooseAsset", "Section Key", "Addl Section Key", "42");

    // Act
    MockMvcBuilders.standaloneSetup(adminAssetUploadController).build().perform(requestBuilder);
  }

  /**
   * Test
   * {@link AdminAssetUploadController#chooseMediaForMapKey(HttpServletRequest, HttpServletResponse, Model, String, String, MultiValueMap)}
   * with {@code request}, {@code response}, {@code model}, {@code sectionKey},
   * {@code id}, {@code requestParams}.
   * <p>
   * Method under test:
   * {@link AdminAssetUploadController#chooseMediaForMapKey(HttpServletRequest, HttpServletResponse, Model, String, String, MultiValueMap)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testChooseMediaForMapKeyWithRequestResponseModelSectionKeyIdRequestParams() throws Exception {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.admin.web.controller;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.cms.admin.web.controller.AdminAssetUploadController.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3095 {
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blAdminAbstractControllerExtensionManager") org.broadleafcommerce.openadmin.web.controller.AdminAbstractControllerExtensionManager adminAbstractControllerExtensionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blAdminAssetController") org.broadleafcommerce.cms.admin.web.controller.AdminAssetController adminAssetController;
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.admin.web.controller.AdminAssetUploadController adminAssetUploadController;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.server.service.AdminEntityService adminEntityService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.server.security.service.navigation.AdminNavigationService adminNavigationService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.server.service.AdminSectionCustomCriteriaService adminSectionCustomCriteriaService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.security.ClassNameRequestParamValidationService classNameRequestParamValidationService;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blEntityConfiguration") org.broadleafcommerce.common.persistence.EntityConfiguration entityConfiguration;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blEntityFormValidator") org.broadleafcommerce.openadmin.web.form.entity.EntityFormValidator entityFormValidator;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.common.security.service.ExploitProtectionService exploitProtectionService;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blFilterProductTypePersistenceHandlerExtensionManager") org.broadleafcommerce.openadmin.server.service.extension.FilterProductTypePersistenceHandlerExtensionManager filterProductTypePersistenceHandlerExtensionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.web.service.FormBuilderService formBuilderService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.server.security.remote.SecurityVerifier securityVerifier;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.cms.file.service.StaticAssetService staticAssetService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.cms.file.service.StaticAssetStorageService staticAssetStorageService;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/{sectionKey}/{id}/chooseAsset",
        "Section Key", "42");

    // Act
    MockMvcBuilders.standaloneSetup(adminAssetUploadController).build().perform(requestBuilder);
  }

  /**
   * Test
   * {@link AdminAssetUploadController#upload(HttpServletRequest, MultipartFile, String, String, String)}
   * with {@code request}, {@code file}, {@code sectionKey},
   * {@code addlSectionKey}, {@code id}.
   * <p>
   * Method under test:
   * {@link AdminAssetUploadController#upload(HttpServletRequest, MultipartFile, String, String, String)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testUploadWithRequestFileSectionKeyAddlSectionKeyId() throws Exception {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.admin.web.controller;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.cms.admin.web.controller.AdminAssetUploadController.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3098 {
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blAdminAbstractControllerExtensionManager") org.broadleafcommerce.openadmin.web.controller.AdminAbstractControllerExtensionManager adminAbstractControllerExtensionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blAdminAssetController") org.broadleafcommerce.cms.admin.web.controller.AdminAssetController adminAssetController;
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.admin.web.controller.AdminAssetUploadController adminAssetUploadController;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.server.service.AdminEntityService adminEntityService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.server.security.service.navigation.AdminNavigationService adminNavigationService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.server.service.AdminSectionCustomCriteriaService adminSectionCustomCriteriaService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.security.ClassNameRequestParamValidationService classNameRequestParamValidationService;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blEntityConfiguration") org.broadleafcommerce.common.persistence.EntityConfiguration entityConfiguration;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blEntityFormValidator") org.broadleafcommerce.openadmin.web.form.entity.EntityFormValidator entityFormValidator;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.common.security.service.ExploitProtectionService exploitProtectionService;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blFilterProductTypePersistenceHandlerExtensionManager") org.broadleafcommerce.openadmin.server.service.extension.FilterProductTypePersistenceHandlerExtensionManager filterProductTypePersistenceHandlerExtensionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.web.service.FormBuilderService formBuilderService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.server.security.remote.SecurityVerifier securityVerifier;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.cms.file.service.StaticAssetService staticAssetService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.cms.file.service.StaticAssetStorageService staticAssetStorageService;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    MockHttpServletRequestBuilder postResult = MockMvcRequestBuilders
        .post("/{sectionKey}/{addlSectionKey}/{id}/uploadAsset", "Section Key", "Addl Section Key", "42");
    MockHttpServletRequestBuilder requestBuilder = postResult.param("file",
        String.valueOf(new MockMultipartFile("Name", (InputStream) null)));

    // Act
    MockMvcBuilders.standaloneSetup(adminAssetUploadController).build().perform(requestBuilder);
  }

  /**
   * Test
   * {@link AdminAssetUploadController#upload(HttpServletRequest, MultipartFile, String, String)}
   * with {@code request}, {@code file}, {@code sectionKey}, {@code id}.
   * <p>
   * Method under test:
   * {@link AdminAssetUploadController#upload(HttpServletRequest, MultipartFile, String, String)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testUploadWithRequestFileSectionKeyId() throws Exception {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.admin.web.controller;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.cms.admin.web.controller.AdminAssetUploadController.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3097 {
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blAdminAbstractControllerExtensionManager") org.broadleafcommerce.openadmin.web.controller.AdminAbstractControllerExtensionManager adminAbstractControllerExtensionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blAdminAssetController") org.broadleafcommerce.cms.admin.web.controller.AdminAssetController adminAssetController;
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.admin.web.controller.AdminAssetUploadController adminAssetUploadController;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.server.service.AdminEntityService adminEntityService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.server.security.service.navigation.AdminNavigationService adminNavigationService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.server.service.AdminSectionCustomCriteriaService adminSectionCustomCriteriaService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.security.ClassNameRequestParamValidationService classNameRequestParamValidationService;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blEntityConfiguration") org.broadleafcommerce.common.persistence.EntityConfiguration entityConfiguration;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blEntityFormValidator") org.broadleafcommerce.openadmin.web.form.entity.EntityFormValidator entityFormValidator;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.common.security.service.ExploitProtectionService exploitProtectionService;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blFilterProductTypePersistenceHandlerExtensionManager") org.broadleafcommerce.openadmin.server.service.extension.FilterProductTypePersistenceHandlerExtensionManager filterProductTypePersistenceHandlerExtensionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.web.service.FormBuilderService formBuilderService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.server.security.remote.SecurityVerifier securityVerifier;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.cms.file.service.StaticAssetService staticAssetService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.cms.file.service.StaticAssetStorageService staticAssetStorageService;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    MockHttpServletRequestBuilder postResult = MockMvcRequestBuilders.post("/{sectionKey}/{id}/uploadAsset",
        "Section Key", "42");
    MockHttpServletRequestBuilder requestBuilder = postResult.param("file",
        String.valueOf(new MockMultipartFile("Name", (InputStream) null)));

    // Act
    MockMvcBuilders.standaloneSetup(adminAssetUploadController).build().perform(requestBuilder);
  }

  /**
   * Test
   * {@link AdminAssetUploadController#upload(HttpServletRequest, HttpServletResponse, Model, Map, MultipartFile, MultiValueMap)}
   * with {@code request}, {@code response}, {@code model}, {@code pathVars},
   * {@code file}, {@code requestParams}.
   * <p>
   * Method under test:
   * {@link AdminAssetUploadController#upload(HttpServletRequest, HttpServletResponse, Model, Map, MultipartFile, MultiValueMap)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testUploadWithRequestResponseModelPathVarsFileRequestParams() throws Exception {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.admin.web.controller;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.cms.admin.web.controller.AdminAssetUploadController.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3096 {
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blAdminAbstractControllerExtensionManager") org.broadleafcommerce.openadmin.web.controller.AdminAbstractControllerExtensionManager adminAbstractControllerExtensionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blAdminAssetController") org.broadleafcommerce.cms.admin.web.controller.AdminAssetController adminAssetController;
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.admin.web.controller.AdminAssetUploadController adminAssetUploadController;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.server.service.AdminEntityService adminEntityService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.server.security.service.navigation.AdminNavigationService adminNavigationService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.server.service.AdminSectionCustomCriteriaService adminSectionCustomCriteriaService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.security.ClassNameRequestParamValidationService classNameRequestParamValidationService;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blEntityConfiguration") org.broadleafcommerce.common.persistence.EntityConfiguration entityConfiguration;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blEntityFormValidator") org.broadleafcommerce.openadmin.web.form.entity.EntityFormValidator entityFormValidator;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.common.security.service.ExploitProtectionService exploitProtectionService;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blFilterProductTypePersistenceHandlerExtensionManager") org.broadleafcommerce.openadmin.server.service.extension.FilterProductTypePersistenceHandlerExtensionManager filterProductTypePersistenceHandlerExtensionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.web.service.FormBuilderService formBuilderService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.server.security.remote.SecurityVerifier securityVerifier;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.cms.file.service.StaticAssetService staticAssetService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.cms.file.service.StaticAssetStorageService staticAssetStorageService;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    MockHttpServletRequestBuilder postResult = MockMvcRequestBuilders.post("/{sectionKey}/uploadAsset", "Section Key");
    MockHttpServletRequestBuilder requestBuilder = postResult.param("file",
        String.valueOf(new MockMultipartFile("Name", (InputStream) null)));

    // Act
    MockMvcBuilders.standaloneSetup(adminAssetUploadController).build().perform(requestBuilder);
  }
}
