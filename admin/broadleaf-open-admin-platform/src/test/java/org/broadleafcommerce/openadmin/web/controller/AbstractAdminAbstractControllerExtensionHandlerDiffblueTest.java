/*-
 * #%L
 * BroadleafCommerce Open Admin Platform
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
package org.broadleafcommerce.openadmin.web.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import org.broadleafcommerce.common.extension.ExtensionResultHolder;
import org.broadleafcommerce.common.extension.ExtensionResultStatusType;
import org.broadleafcommerce.openadmin.dto.ClassMetadata;
import org.broadleafcommerce.openadmin.dto.ClassTree;
import org.broadleafcommerce.openadmin.dto.Entity;
import org.broadleafcommerce.openadmin.dto.MapMetadata;
import org.broadleafcommerce.openadmin.dto.Property;
import org.broadleafcommerce.openadmin.web.compatibility.JSCompatibilityRequestWrapper;
import org.broadleafcommerce.openadmin.web.form.entity.DefaultAdornedEntityFormActions;
import org.broadleafcommerce.openadmin.web.form.entity.EntityForm;
import org.broadleafcommerce.openadmin.web.form.entity.EntityFormAction;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.ui.ConcurrentModel;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;

@ContextConfiguration(classes = {AbstractAdminAbstractControllerExtensionHandler.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class AbstractAdminAbstractControllerExtensionHandlerDiffblueTest {
  @Autowired
  private AbstractAdminAbstractControllerExtensionHandler
      abstractAdminAbstractControllerExtensionHandler;

  /**
   * Test {@link AbstractAdminAbstractControllerExtensionHandler#addAdditionalMainActions(String,
   * List)}.
   *
   * <ul>
   *   <li>Given {@link DefaultAdornedEntityFormActions#Add}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link DefaultAdornedEntityFormActions#Add}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AbstractAdminAbstractControllerExtensionHandler#addAdditionalMainActions(String, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType AbstractAdminAbstractControllerExtensionHandler.addAdditionalMainActions(String, List)"
  })
  public void testAddAdditionalMainActions_givenAdd_whenArrayListAddAdd() {
    // Arrange
    ArrayList<EntityFormAction> actions = new ArrayList<>();
    actions.add(DefaultAdornedEntityFormActions.Add);

    // Act and Assert
    assertEquals(
        ExtensionResultStatusType.NOT_HANDLED,
        abstractAdminAbstractControllerExtensionHandler.addAdditionalMainActions(
            "Section Class Name", actions));
  }

  /**
   * Test {@link AbstractAdminAbstractControllerExtensionHandler#addAdditionalMainActions(String,
   * List)}.
   *
   * <ul>
   *   <li>Given {@link DefaultAdornedEntityFormActions#Add}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link DefaultAdornedEntityFormActions#Add}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AbstractAdminAbstractControllerExtensionHandler#addAdditionalMainActions(String, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType AbstractAdminAbstractControllerExtensionHandler.addAdditionalMainActions(String, List)"
  })
  public void testAddAdditionalMainActions_givenAdd_whenArrayListAddAdd2() {
    // Arrange
    ArrayList<EntityFormAction> actions = new ArrayList<>();
    actions.add(DefaultAdornedEntityFormActions.Add);
    actions.add(DefaultAdornedEntityFormActions.Add);

    // Act and Assert
    assertEquals(
        ExtensionResultStatusType.NOT_HANDLED,
        abstractAdminAbstractControllerExtensionHandler.addAdditionalMainActions(
            "Section Class Name", actions));
  }

  /**
   * Test {@link AbstractAdminAbstractControllerExtensionHandler#addAdditionalMainActions(String,
   * List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AbstractAdminAbstractControllerExtensionHandler#addAdditionalMainActions(String, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType AbstractAdminAbstractControllerExtensionHandler.addAdditionalMainActions(String, List)"
  })
  public void testAddAdditionalMainActions_whenArrayList() {
    // Arrange, Act and Assert
    assertEquals(
        ExtensionResultStatusType.NOT_HANDLED,
        abstractAdminAbstractControllerExtensionHandler.addAdditionalMainActions(
            "Section Class Name", new ArrayList<>()));
  }

  /**
   * Test {@link AbstractAdminAbstractControllerExtensionHandler#modifyMainActions(ClassMetadata,
   * List)}.
   *
   * <ul>
   *   <li>Given {@link DefaultAdornedEntityFormActions#Add}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link DefaultAdornedEntityFormActions#Add}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AbstractAdminAbstractControllerExtensionHandler#modifyMainActions(ClassMetadata, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType AbstractAdminAbstractControllerExtensionHandler.modifyMainActions(ClassMetadata, List)"
  })
  public void testModifyMainActions_givenAdd_whenArrayListAddAdd() {
    // Arrange
    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[] {new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    ArrayList<EntityFormAction> mainActions = new ArrayList<>();
    mainActions.add(DefaultAdornedEntityFormActions.Add);

    // Act and Assert
    assertEquals(
        ExtensionResultStatusType.NOT_HANDLED,
        abstractAdminAbstractControllerExtensionHandler.modifyMainActions(cmd, mainActions));
  }

  /**
   * Test {@link AbstractAdminAbstractControllerExtensionHandler#modifyMainActions(ClassMetadata,
   * List)}.
   *
   * <ul>
   *   <li>Given {@link DefaultAdornedEntityFormActions#Add}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link DefaultAdornedEntityFormActions#Add}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AbstractAdminAbstractControllerExtensionHandler#modifyMainActions(ClassMetadata, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType AbstractAdminAbstractControllerExtensionHandler.modifyMainActions(ClassMetadata, List)"
  })
  public void testModifyMainActions_givenAdd_whenArrayListAddAdd2() {
    // Arrange
    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[] {new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    ArrayList<EntityFormAction> mainActions = new ArrayList<>();
    mainActions.add(DefaultAdornedEntityFormActions.Add);
    mainActions.add(DefaultAdornedEntityFormActions.Add);

    // Act and Assert
    assertEquals(
        ExtensionResultStatusType.NOT_HANDLED,
        abstractAdminAbstractControllerExtensionHandler.modifyMainActions(cmd, mainActions));
  }

  /**
   * Test {@link AbstractAdminAbstractControllerExtensionHandler#modifyMainActions(ClassMetadata,
   * List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AbstractAdminAbstractControllerExtensionHandler#modifyMainActions(ClassMetadata, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType AbstractAdminAbstractControllerExtensionHandler.modifyMainActions(ClassMetadata, List)"
  })
  public void testModifyMainActions_whenArrayList() {
    // Arrange
    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[] {new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act and Assert
    assertEquals(
        ExtensionResultStatusType.NOT_HANDLED,
        abstractAdminAbstractControllerExtensionHandler.modifyMainActions(cmd, new ArrayList<>()));
  }

  /**
   * Test {@link AbstractAdminAbstractControllerExtensionHandler#setAdditionalModelAttributes(Model,
   * String)}.
   *
   * <p>Method under test: {@link
   * AbstractAdminAbstractControllerExtensionHandler#setAdditionalModelAttributes(Model, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType AbstractAdminAbstractControllerExtensionHandler.setAdditionalModelAttributes(Model, String)"
  })
  public void testSetAdditionalModelAttributes() {
    // Arrange, Act and Assert
    assertEquals(
        ExtensionResultStatusType.NOT_HANDLED,
        abstractAdminAbstractControllerExtensionHandler.setAdditionalModelAttributes(
            new ConcurrentModel(), "Section Key"));
  }

  /**
   * Test {@link AbstractAdminAbstractControllerExtensionHandler#modifyDynamicForm(EntityForm,
   * String)}.
   *
   * <p>Method under test: {@link
   * AbstractAdminAbstractControllerExtensionHandler#modifyDynamicForm(EntityForm, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType AbstractAdminAbstractControllerExtensionHandler.modifyDynamicForm(EntityForm, String)"
  })
  public void testModifyDynamicForm() {
    // Arrange, Act and Assert
    assertEquals(
        ExtensionResultStatusType.NOT_HANDLED,
        abstractAdminAbstractControllerExtensionHandler.modifyDynamicForm(new EntityForm(), "42"));
  }

  /**
   * Test {@link
   * AbstractAdminAbstractControllerExtensionHandler#modifyModelForAddCollectionType(HttpServletRequest,
   * HttpServletResponse, Model, String, String, MultiValueMap, MapMetadata)}.
   *
   * <p>Method under test: {@link
   * AbstractAdminAbstractControllerExtensionHandler#modifyModelForAddCollectionType(HttpServletRequest,
   * HttpServletResponse, Model, String, String, MultiValueMap, MapMetadata)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType AbstractAdminAbstractControllerExtensionHandler.modifyModelForAddCollectionType(HttpServletRequest, HttpServletResponse, Model, String, String, MultiValueMap, MapMetadata)"
  })
  public void testModifyModelForAddCollectionType() {
    // Arrange
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(
            new JSCompatibilityRequestWrapper(new MockHttpServletRequest()));
    MockHttpServletResponse response = new MockHttpServletResponse();
    ConcurrentModel model = new ConcurrentModel();
    HttpHeaders requestParams = new HttpHeaders();

    // Act and Assert
    assertEquals(
        ExtensionResultStatusType.NOT_HANDLED,
        abstractAdminAbstractControllerExtensionHandler.modifyModelForAddCollectionType(
            request, response, model, "Section Key", "42", requestParams, new MapMetadata()));
  }

  /**
   * Test {@link AbstractAdminAbstractControllerExtensionHandler#isAddRequest(Entity,
   * ExtensionResultHolder)}.
   *
   * <p>Method under test: {@link
   * AbstractAdminAbstractControllerExtensionHandler#isAddRequest(Entity, ExtensionResultHolder)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType AbstractAdminAbstractControllerExtensionHandler.isAddRequest(Entity, ExtensionResultHolder)"
  })
  public void testIsAddRequest() {
    // Arrange
    AbstractAdminAbstractControllerExtensionHandler
        abstractAdminAbstractControllerExtensionHandler =
            new AbstractAdminAbstractControllerExtensionHandler();
    Entity entity = new Entity();

    ExtensionResultHolder<Boolean> resultHolder = new ExtensionResultHolder<>();
    resultHolder.setResult(true);
    resultHolder.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(
        ExtensionResultStatusType.NOT_HANDLED,
        abstractAdminAbstractControllerExtensionHandler.isAddRequest(entity, resultHolder));
  }

  /**
   * Test {@link
   * AbstractAdminAbstractControllerExtensionHandler#overrideSaveEntityJsonResponse(HttpServletResponse,
   * boolean, String, String, ExtensionResultHolder)}.
   *
   * <p>Method under test: {@link
   * AbstractAdminAbstractControllerExtensionHandler#overrideSaveEntityJsonResponse(HttpServletResponse,
   * boolean, String, String, ExtensionResultHolder)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType AbstractAdminAbstractControllerExtensionHandler.overrideSaveEntityJsonResponse(HttpServletResponse, boolean, String, String, ExtensionResultHolder)"
  })
  public void testOverrideSaveEntityJsonResponse() {
    // Arrange
    MockHttpServletResponse response = new MockHttpServletResponse();

    ExtensionResultHolder<String> resultHolder = new ExtensionResultHolder<>();
    resultHolder.setResult("Result");
    resultHolder.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(
        ExtensionResultStatusType.NOT_HANDLED,
        abstractAdminAbstractControllerExtensionHandler.overrideSaveEntityJsonResponse(
            response, true, "Section Key", "42", resultHolder));
  }

  /**
   * Test {@link AbstractAdminAbstractControllerExtensionHandler#modifyPreAddEntityForm(EntityForm,
   * ClassMetadata, Map)}.
   *
   * <p>Method under test: {@link
   * AbstractAdminAbstractControllerExtensionHandler#modifyPreAddEntityForm(EntityForm,
   * ClassMetadata, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType AbstractAdminAbstractControllerExtensionHandler.modifyPreAddEntityForm(EntityForm, ClassMetadata, Map)"
  })
  public void testModifyPreAddEntityForm() {
    // Arrange
    AbstractAdminAbstractControllerExtensionHandler
        abstractAdminAbstractControllerExtensionHandler =
            new AbstractAdminAbstractControllerExtensionHandler();
    EntityForm entityForm = new EntityForm();

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[] {new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act and Assert
    assertEquals(
        ExtensionResultStatusType.NOT_HANDLED,
        abstractAdminAbstractControllerExtensionHandler.modifyPreAddEntityForm(
            entityForm, cmd, new HashMap<>()));
  }

  /**
   * Test new {@link AbstractAdminAbstractControllerExtensionHandler} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link
   * AbstractAdminAbstractControllerExtensionHandler}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractAdminAbstractControllerExtensionHandler.<init>()"})
  public void testNewAbstractAdminAbstractControllerExtensionHandler() {
    // Arrange and Act
    AbstractAdminAbstractControllerExtensionHandler
        actualAbstractAdminAbstractControllerExtensionHandler =
            new AbstractAdminAbstractControllerExtensionHandler();

    // Assert
    assertEquals(0, actualAbstractAdminAbstractControllerExtensionHandler.getPriority());
    assertTrue(actualAbstractAdminAbstractControllerExtensionHandler.isEnabled());
  }
}
