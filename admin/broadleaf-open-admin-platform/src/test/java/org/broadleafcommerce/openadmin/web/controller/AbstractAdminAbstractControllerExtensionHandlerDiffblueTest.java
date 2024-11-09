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
package org.broadleafcommerce.openadmin.web.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.broadleafcommerce.common.extension.ExtensionResultHolder;
import org.broadleafcommerce.common.extension.ExtensionResultStatusType;
import org.broadleafcommerce.common.web.util.FileSystemResponseWrapper;
import org.broadleafcommerce.openadmin.dto.ClassMetadata;
import org.broadleafcommerce.openadmin.dto.ClassTree;
import org.broadleafcommerce.openadmin.dto.Entity;
import org.broadleafcommerce.openadmin.dto.MapMetadata;
import org.broadleafcommerce.openadmin.dto.Property;
import org.broadleafcommerce.openadmin.dto.TabMetadata;
import org.broadleafcommerce.openadmin.web.compatibility.JSCompatibilityRequestWrapper;
import org.broadleafcommerce.openadmin.web.form.entity.DefaultAdornedEntityFormActions;
import org.broadleafcommerce.openadmin.web.form.entity.EntityForm;
import org.broadleafcommerce.openadmin.web.form.entity.EntityFormAction;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.ui.ConcurrentModel;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.multipart.support.DefaultMultipartHttpServletRequest;

@ContextConfiguration(classes = {AbstractAdminAbstractControllerExtensionHandler.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class AbstractAdminAbstractControllerExtensionHandlerDiffblueTest {
  @Autowired
  private AbstractAdminAbstractControllerExtensionHandler abstractAdminAbstractControllerExtensionHandler;

  /**
   * Test
   * {@link AbstractAdminAbstractControllerExtensionHandler#addAdditionalMainActions(String, List)}.
   * <ul>
   *   <li>Given {@link DefaultAdornedEntityFormActions#Add}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add
   * {@link DefaultAdornedEntityFormActions#Add}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractAdminAbstractControllerExtensionHandler#addAdditionalMainActions(String, List)}
   */
  @Test
  public void testAddAdditionalMainActions_givenAdd_whenArrayListAddAdd() {
    // Arrange
    ArrayList<EntityFormAction> actions = new ArrayList<>();
    actions.add(DefaultAdornedEntityFormActions.Add);

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        abstractAdminAbstractControllerExtensionHandler.addAdditionalMainActions("Section Class Name", actions));
  }

  /**
   * Test
   * {@link AbstractAdminAbstractControllerExtensionHandler#addAdditionalMainActions(String, List)}.
   * <ul>
   *   <li>Given {@link DefaultAdornedEntityFormActions#Add}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add
   * {@link DefaultAdornedEntityFormActions#Add}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractAdminAbstractControllerExtensionHandler#addAdditionalMainActions(String, List)}
   */
  @Test
  public void testAddAdditionalMainActions_givenAdd_whenArrayListAddAdd2() {
    // Arrange
    ArrayList<EntityFormAction> actions = new ArrayList<>();
    actions.add(DefaultAdornedEntityFormActions.Add);
    actions.add(DefaultAdornedEntityFormActions.Add);

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        abstractAdminAbstractControllerExtensionHandler.addAdditionalMainActions("Section Class Name", actions));
  }

  /**
   * Test
   * {@link AbstractAdminAbstractControllerExtensionHandler#addAdditionalMainActions(String, List)}.
   * <ul>
   *   <li>Given {@link EntityFormAction}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractAdminAbstractControllerExtensionHandler#addAdditionalMainActions(String, List)}
   */
  @Test
  public void testAddAdditionalMainActions_givenEntityFormAction() {
    // Arrange
    ArrayList<EntityFormAction> actions = new ArrayList<>();
    actions.add(mock(EntityFormAction.class));

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        abstractAdminAbstractControllerExtensionHandler.addAdditionalMainActions("Section Class Name", actions));
  }

  /**
   * Test
   * {@link AbstractAdminAbstractControllerExtensionHandler#addAdditionalMainActions(String, List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractAdminAbstractControllerExtensionHandler#addAdditionalMainActions(String, List)}
   */
  @Test
  public void testAddAdditionalMainActions_whenArrayList() {
    // Arrange, Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, abstractAdminAbstractControllerExtensionHandler
        .addAdditionalMainActions("Section Class Name", new ArrayList<>()));
  }

  /**
   * Test
   * {@link AbstractAdminAbstractControllerExtensionHandler#modifyMainActions(ClassMetadata, List)}.
   * <ul>
   *   <li>Given {@link DefaultAdornedEntityFormActions#Add}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add
   * {@link DefaultAdornedEntityFormActions#Add}.</li>
   *   <li>Then calls {@link ClassMetadata#setCeilingType(String)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractAdminAbstractControllerExtensionHandler#modifyMainActions(ClassMetadata, List)}
   */
  @Test
  public void testModifyMainActions_givenAdd_whenArrayListAddAdd_thenCallsSetCeilingType() {
    // Arrange
    ClassMetadata cmd = mock(ClassMetadata.class);
    doNothing().when(cmd).setCeilingType(Mockito.<String>any());
    doNothing().when(cmd).setCurrencyCode(Mockito.<String>any());
    doNothing().when(cmd).setPolymorphicEntities(Mockito.<ClassTree>any());
    doNothing().when(cmd).setProperties(Mockito.<Property[]>any());
    doNothing().when(cmd).setSecurityCeilingType(Mockito.<String>any());
    doNothing().when(cmd).setTabAndGroupMetadata(Mockito.<Map<String, TabMetadata>>any());
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[]{new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    ArrayList<EntityFormAction> mainActions = new ArrayList<>();
    mainActions.add(DefaultAdornedEntityFormActions.Add);

    // Act
    ExtensionResultStatusType actualModifyMainActionsResult = abstractAdminAbstractControllerExtensionHandler
        .modifyMainActions(cmd, mainActions);

    // Assert
    verify(cmd).setCeilingType(eq("Type"));
    verify(cmd).setCurrencyCode(eq("GBP"));
    verify(cmd).setPolymorphicEntities(isA(ClassTree.class));
    verify(cmd).setProperties(isA(Property[].class));
    verify(cmd).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(cmd).setTabAndGroupMetadata(isA(Map.class));
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, actualModifyMainActionsResult);
  }

  /**
   * Test
   * {@link AbstractAdminAbstractControllerExtensionHandler#modifyMainActions(ClassMetadata, List)}.
   * <ul>
   *   <li>Given {@link DefaultAdornedEntityFormActions#Add}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add
   * {@link DefaultAdornedEntityFormActions#Add}.</li>
   *   <li>Then calls {@link ClassMetadata#setCeilingType(String)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractAdminAbstractControllerExtensionHandler#modifyMainActions(ClassMetadata, List)}
   */
  @Test
  public void testModifyMainActions_givenAdd_whenArrayListAddAdd_thenCallsSetCeilingType2() {
    // Arrange
    ClassMetadata cmd = mock(ClassMetadata.class);
    doNothing().when(cmd).setCeilingType(Mockito.<String>any());
    doNothing().when(cmd).setCurrencyCode(Mockito.<String>any());
    doNothing().when(cmd).setPolymorphicEntities(Mockito.<ClassTree>any());
    doNothing().when(cmd).setProperties(Mockito.<Property[]>any());
    doNothing().when(cmd).setSecurityCeilingType(Mockito.<String>any());
    doNothing().when(cmd).setTabAndGroupMetadata(Mockito.<Map<String, TabMetadata>>any());
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[]{new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    ArrayList<EntityFormAction> mainActions = new ArrayList<>();
    mainActions.add(DefaultAdornedEntityFormActions.Add);
    mainActions.add(DefaultAdornedEntityFormActions.Add);

    // Act
    ExtensionResultStatusType actualModifyMainActionsResult = abstractAdminAbstractControllerExtensionHandler
        .modifyMainActions(cmd, mainActions);

    // Assert
    verify(cmd).setCeilingType(eq("Type"));
    verify(cmd).setCurrencyCode(eq("GBP"));
    verify(cmd).setPolymorphicEntities(isA(ClassTree.class));
    verify(cmd).setProperties(isA(Property[].class));
    verify(cmd).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(cmd).setTabAndGroupMetadata(isA(Map.class));
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, actualModifyMainActionsResult);
  }

  /**
   * Test
   * {@link AbstractAdminAbstractControllerExtensionHandler#modifyMainActions(ClassMetadata, List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then calls {@link ClassMetadata#setCeilingType(String)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractAdminAbstractControllerExtensionHandler#modifyMainActions(ClassMetadata, List)}
   */
  @Test
  public void testModifyMainActions_whenArrayList_thenCallsSetCeilingType() {
    // Arrange
    ClassMetadata cmd = mock(ClassMetadata.class);
    doNothing().when(cmd).setCeilingType(Mockito.<String>any());
    doNothing().when(cmd).setCurrencyCode(Mockito.<String>any());
    doNothing().when(cmd).setPolymorphicEntities(Mockito.<ClassTree>any());
    doNothing().when(cmd).setProperties(Mockito.<Property[]>any());
    doNothing().when(cmd).setSecurityCeilingType(Mockito.<String>any());
    doNothing().when(cmd).setTabAndGroupMetadata(Mockito.<Map<String, TabMetadata>>any());
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[]{new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act
    ExtensionResultStatusType actualModifyMainActionsResult = abstractAdminAbstractControllerExtensionHandler
        .modifyMainActions(cmd, new ArrayList<>());

    // Assert
    verify(cmd).setCeilingType(eq("Type"));
    verify(cmd).setCurrencyCode(eq("GBP"));
    verify(cmd).setPolymorphicEntities(isA(ClassTree.class));
    verify(cmd).setProperties(isA(Property[].class));
    verify(cmd).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(cmd).setTabAndGroupMetadata(isA(Map.class));
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, actualModifyMainActionsResult);
  }

  /**
   * Test
   * {@link AbstractAdminAbstractControllerExtensionHandler#modifyMainActions(ClassMetadata, List)}.
   * <ul>
   *   <li>When {@link ClassMetadata} (default constructor) CeilingType is
   * {@code Type}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractAdminAbstractControllerExtensionHandler#modifyMainActions(ClassMetadata, List)}
   */
  @Test
  public void testModifyMainActions_whenClassMetadataCeilingTypeIsType() {
    // Arrange
    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[]{new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        abstractAdminAbstractControllerExtensionHandler.modifyMainActions(cmd, new ArrayList<>()));
  }

  /**
   * Test
   * {@link AbstractAdminAbstractControllerExtensionHandler#setAdditionalModelAttributes(Model, String)}.
   * <ul>
   *   <li>Given {@link Function} {@link Function#apply(Object)} return
   * {@code Apply}.</li>
   *   <li>Then calls {@link Function#apply(Object)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractAdminAbstractControllerExtensionHandler#setAdditionalModelAttributes(Model, String)}
   */
  @Test
  public void testSetAdditionalModelAttributes_givenFunctionApplyReturnApply_thenCallsApply() {
    // Arrange
    Function<String, Object> function = mock(Function.class);
    when(function.apply(Mockito.<String>any())).thenReturn("Apply");

    ConcurrentModel model = new ConcurrentModel();
    model.computeIfAbsent("foo", function);

    // Act
    ExtensionResultStatusType actualSetAdditionalModelAttributesResult = abstractAdminAbstractControllerExtensionHandler
        .setAdditionalModelAttributes(model, "Section Key");

    // Assert
    verify(function).apply(eq("foo"));
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, actualSetAdditionalModelAttributesResult);
  }

  /**
   * Test
   * {@link AbstractAdminAbstractControllerExtensionHandler#setAdditionalModelAttributes(Model, String)}.
   * <ul>
   *   <li>When {@link ConcurrentModel#ConcurrentModel()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractAdminAbstractControllerExtensionHandler#setAdditionalModelAttributes(Model, String)}
   */
  @Test
  public void testSetAdditionalModelAttributes_whenConcurrentModel() {
    // Arrange, Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, abstractAdminAbstractControllerExtensionHandler
        .setAdditionalModelAttributes(new ConcurrentModel(), "Section Key"));
  }

  /**
   * Test
   * {@link AbstractAdminAbstractControllerExtensionHandler#modifyDynamicForm(EntityForm, String)}.
   * <ul>
   *   <li>When {@link EntityForm} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractAdminAbstractControllerExtensionHandler#modifyDynamicForm(EntityForm, String)}
   */
  @Test
  public void testModifyDynamicForm_whenEntityForm() {
    // Arrange, Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        abstractAdminAbstractControllerExtensionHandler.modifyDynamicForm(new EntityForm(), "42"));
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        abstractAdminAbstractControllerExtensionHandler.modifyDynamicForm(mock(EntityForm.class), "42"));
  }

  /**
   * Test
   * {@link AbstractAdminAbstractControllerExtensionHandler#modifyModelForAddCollectionType(HttpServletRequest, HttpServletResponse, Model, String, String, MultiValueMap, MapMetadata)}.
   * <p>
   * Method under test:
   * {@link AbstractAdminAbstractControllerExtensionHandler#modifyModelForAddCollectionType(HttpServletRequest, HttpServletResponse, Model, String, String, MultiValueMap, MapMetadata)}
   */
  @Test
  public void testModifyModelForAddCollectionType() {
    // Arrange
    JSCompatibilityRequestWrapper request = new JSCompatibilityRequestWrapper(new MockHttpServletRequest());
    MockHttpServletResponse response = new MockHttpServletResponse();
    ConcurrentModel model = new ConcurrentModel();
    HttpHeaders requestParams = new HttpHeaders();

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        abstractAdminAbstractControllerExtensionHandler.modifyModelForAddCollectionType(request, response, model,
            "Section Key", "42", requestParams, new MapMetadata()));
  }

  /**
   * Test
   * {@link AbstractAdminAbstractControllerExtensionHandler#modifyModelForAddCollectionType(HttpServletRequest, HttpServletResponse, Model, String, String, MultiValueMap, MapMetadata)}.
   * <p>
   * Method under test:
   * {@link AbstractAdminAbstractControllerExtensionHandler#modifyModelForAddCollectionType(HttpServletRequest, HttpServletResponse, Model, String, String, MultiValueMap, MapMetadata)}
   */
  @Test
  public void testModifyModelForAddCollectionType2() {
    // Arrange
    JSCompatibilityRequestWrapper request = new JSCompatibilityRequestWrapper(
        mock(DefaultMultipartHttpServletRequest.class));
    MockHttpServletResponse response = new MockHttpServletResponse();
    ConcurrentModel model = new ConcurrentModel();
    HttpHeaders requestParams = new HttpHeaders();

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        abstractAdminAbstractControllerExtensionHandler.modifyModelForAddCollectionType(request, response, model,
            "Section Key", "42", requestParams, new MapMetadata()));
  }

  /**
   * Test
   * {@link AbstractAdminAbstractControllerExtensionHandler#isAddRequest(Entity, ExtensionResultHolder)}.
   * <p>
   * Method under test:
   * {@link AbstractAdminAbstractControllerExtensionHandler#isAddRequest(Entity, ExtensionResultHolder)}
   */
  @Test
  public void testIsAddRequest() {
    // Arrange
    AbstractAdminAbstractControllerExtensionHandler abstractAdminAbstractControllerExtensionHandler = new AbstractAdminAbstractControllerExtensionHandler();
    Entity entity = new Entity();

    ExtensionResultHolder<Boolean> resultHolder = new ExtensionResultHolder<>();
    resultHolder.setResult(true);
    resultHolder.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        abstractAdminAbstractControllerExtensionHandler.isAddRequest(entity, resultHolder));
  }

  /**
   * Test
   * {@link AbstractAdminAbstractControllerExtensionHandler#overrideSaveEntityJsonResponse(HttpServletResponse, boolean, String, String, ExtensionResultHolder)}.
   * <ul>
   *   <li>When {@link FileSystemResponseWrapper}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractAdminAbstractControllerExtensionHandler#overrideSaveEntityJsonResponse(HttpServletResponse, boolean, String, String, ExtensionResultHolder)}
   */
  @Test
  public void testOverrideSaveEntityJsonResponse_whenFileSystemResponseWrapper() {
    // Arrange
    FileSystemResponseWrapper response = mock(FileSystemResponseWrapper.class);

    ExtensionResultHolder<String> resultHolder = new ExtensionResultHolder<>();
    resultHolder.setResult("Result");
    resultHolder.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, abstractAdminAbstractControllerExtensionHandler
        .overrideSaveEntityJsonResponse(response, true, "Section Key", "42", resultHolder));
  }

  /**
   * Test
   * {@link AbstractAdminAbstractControllerExtensionHandler#overrideSaveEntityJsonResponse(HttpServletResponse, boolean, String, String, ExtensionResultHolder)}.
   * <ul>
   *   <li>When {@link MockHttpServletResponse} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractAdminAbstractControllerExtensionHandler#overrideSaveEntityJsonResponse(HttpServletResponse, boolean, String, String, ExtensionResultHolder)}
   */
  @Test
  public void testOverrideSaveEntityJsonResponse_whenMockHttpServletResponse() {
    // Arrange
    MockHttpServletResponse response = new MockHttpServletResponse();

    ExtensionResultHolder<String> resultHolder = new ExtensionResultHolder<>();
    resultHolder.setResult("Result");
    resultHolder.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, abstractAdminAbstractControllerExtensionHandler
        .overrideSaveEntityJsonResponse(response, true, "Section Key", "42", resultHolder));
  }

  /**
   * Test
   * {@link AbstractAdminAbstractControllerExtensionHandler#modifyPreAddEntityForm(EntityForm, ClassMetadata, Map)}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractAdminAbstractControllerExtensionHandler#modifyPreAddEntityForm(EntityForm, ClassMetadata, Map)}
   */
  @Test
  public void testModifyPreAddEntityForm_givenHashMap() {
    // Arrange
    AbstractAdminAbstractControllerExtensionHandler abstractAdminAbstractControllerExtensionHandler = new AbstractAdminAbstractControllerExtensionHandler();
    EntityForm entityForm = new EntityForm();

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[]{new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        abstractAdminAbstractControllerExtensionHandler.modifyPreAddEntityForm(entityForm, cmd, new HashMap<>()));
  }

  /**
   * Test
   * {@link AbstractAdminAbstractControllerExtensionHandler#modifyPreAddEntityForm(EntityForm, ClassMetadata, Map)}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} computeIfPresent {@code foo} and
   * {@link BiFunction}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractAdminAbstractControllerExtensionHandler#modifyPreAddEntityForm(EntityForm, ClassMetadata, Map)}
   */
  @Test
  public void testModifyPreAddEntityForm_givenHashMapComputeIfPresentFooAndBiFunction() {
    // Arrange
    AbstractAdminAbstractControllerExtensionHandler abstractAdminAbstractControllerExtensionHandler = new AbstractAdminAbstractControllerExtensionHandler();
    EntityForm entityForm = new EntityForm();

    HashMap<String, TabMetadata> tabAndGroupMetadata = new HashMap<>();
    tabAndGroupMetadata.computeIfPresent("foo", mock(BiFunction.class));

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[]{new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(tabAndGroupMetadata);

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        abstractAdminAbstractControllerExtensionHandler.modifyPreAddEntityForm(entityForm, cmd, new HashMap<>()));
  }

  /**
   * Test new {@link AbstractAdminAbstractControllerExtensionHandler} (default
   * constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link AbstractAdminAbstractControllerExtensionHandler}
   */
  @Test
  public void testNewAbstractAdminAbstractControllerExtensionHandler() {
    // Arrange and Act
    AbstractAdminAbstractControllerExtensionHandler actualAbstractAdminAbstractControllerExtensionHandler = new AbstractAdminAbstractControllerExtensionHandler();

    // Assert
    assertEquals(0, actualAbstractAdminAbstractControllerExtensionHandler.getPriority());
    assertTrue(actualAbstractAdminAbstractControllerExtensionHandler.isEnabled());
  }
}
