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
package org.broadleafcommerce.openadmin.web.compatibility;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import org.broadleafcommerce.openadmin.dto.Entity;
import org.broadleafcommerce.openadmin.dto.Property;
import org.broadleafcommerce.openadmin.web.form.entity.EntityForm;
import org.broadleafcommerce.openadmin.web.form.entity.Field;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.Mockito;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

public class JSFieldNameCompatibilityInterceptorDiffblueTest {
  /**
   * Test {@link JSFieldNameCompatibilityInterceptor#postHandle(HttpServletRequest,
   * HttpServletResponse, Object, ModelAndView)}.
   *
   * <p>Method under test: {@link JSFieldNameCompatibilityInterceptor#postHandle(HttpServletRequest,
   * HttpServletResponse, Object, ModelAndView)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void JSFieldNameCompatibilityInterceptor.postHandle(HttpServletRequest, HttpServletResponse, Object, ModelAndView)"
  })
  public void testPostHandle() throws Exception {
    // Arrange
    JSFieldNameCompatibilityInterceptor jsFieldNameCompatibilityInterceptor =
        new JSFieldNameCompatibilityInterceptor();
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(
            new JSCompatibilityRequestWrapper(new MockHttpServletRequest()));
    MockHttpServletResponse response = new MockHttpServletResponse();

    Entity entity = mock(Entity.class);
    when(entity.getProperties()).thenReturn(new Property[] {new Property("entity", "42")});

    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.getFields()).thenReturn(new HashMap<>());
    doNothing().when(entityForm).clearFieldsMap();

    ModelMap modelMap = new ModelMap();
    modelMap.put("entity", entity);
    modelMap.put("entityForm", entityForm);

    ModelAndView modelAndView = mock(ModelAndView.class);
    when(modelAndView.getModelMap()).thenReturn(modelMap);
    when(modelAndView.addObject(Mockito.<String>any(), Mockito.<Object>any()))
        .thenReturn(new ModelAndView("View Name"));
    modelAndView.addObject("entity", "Attribute Value");

    // Act
    jsFieldNameCompatibilityInterceptor.postHandle(request, response, "Handler", modelAndView);

    // Assert
    verify(entity, atLeast(1)).getProperties();
    verify(entityForm, atLeast(1)).clearFieldsMap();
    verify(entityForm).getFields();
    verify(modelAndView).addObject(eq("entity"), isA(Object.class));
    verify(modelAndView, atLeast(1)).getModelMap();
  }

  /**
   * Test {@link JSFieldNameCompatibilityInterceptor#postHandle(HttpServletRequest,
   * HttpServletResponse, Object, ModelAndView)}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code .} is {@link Field} (default constructor).
   *   <li>Then calls {@link Property#getName()}.
   * </ul>
   *
   * <p>Method under test: {@link JSFieldNameCompatibilityInterceptor#postHandle(HttpServletRequest,
   * HttpServletResponse, Object, ModelAndView)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void JSFieldNameCompatibilityInterceptor.postHandle(HttpServletRequest, HttpServletResponse, Object, ModelAndView)"
  })
  public void testPostHandle_givenHashMapDotIsField_thenCallsGetName() throws Exception {
    // Arrange
    JSFieldNameCompatibilityInterceptor jsFieldNameCompatibilityInterceptor =
        new JSFieldNameCompatibilityInterceptor();
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(
            new JSCompatibilityRequestWrapper(new MockHttpServletRequest()));
    MockHttpServletResponse response = new MockHttpServletResponse();

    Property property = mock(Property.class);
    doNothing().when(property).setName(Mockito.<String>any());
    when(property.getName()).thenReturn(".");

    Entity entity = mock(Entity.class);
    when(entity.getProperties()).thenReturn(new Property[] {property});

    HashMap<String, Field> stringFieldMap = new HashMap<>();
    stringFieldMap.put(".", new Field());

    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.getFields()).thenReturn(stringFieldMap);
    doNothing().when(entityForm).clearFieldsMap();

    ModelMap modelMap = new ModelMap();
    modelMap.put("entity", entity);
    modelMap.put("entityForm", entityForm);

    ModelAndView modelAndView = mock(ModelAndView.class);
    when(modelAndView.getModelMap()).thenReturn(modelMap);
    when(modelAndView.addObject(Mockito.<String>any(), Mockito.<Object>any()))
        .thenReturn(new ModelAndView("View Name"));
    modelAndView.addObject("entity", "Attribute Value");

    // Act
    jsFieldNameCompatibilityInterceptor.postHandle(request, response, "Handler", modelAndView);

    // Assert
    verify(entity, atLeast(1)).getProperties();
    verify(property, atLeast(1)).getName();
    verify(property).setName("__");
    verify(entityForm, atLeast(1)).clearFieldsMap();
    verify(entityForm).getFields();
    verify(modelAndView).addObject(eq("entity"), isA(Object.class));
    verify(modelAndView, atLeast(1)).getModelMap();
  }

  /**
   * Test {@link JSFieldNameCompatibilityInterceptor#postHandle(HttpServletRequest,
   * HttpServletResponse, Object, ModelAndView)}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code entity} is {@link Field} (default constructor).
   *   <li>Then calls {@link EntityForm#clearFieldsMap()}.
   * </ul>
   *
   * <p>Method under test: {@link JSFieldNameCompatibilityInterceptor#postHandle(HttpServletRequest,
   * HttpServletResponse, Object, ModelAndView)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void JSFieldNameCompatibilityInterceptor.postHandle(HttpServletRequest, HttpServletResponse, Object, ModelAndView)"
  })
  public void testPostHandle_givenHashMapEntityIsField_thenCallsClearFieldsMap() throws Exception {
    // Arrange
    JSFieldNameCompatibilityInterceptor jsFieldNameCompatibilityInterceptor =
        new JSFieldNameCompatibilityInterceptor();
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(
            new JSCompatibilityRequestWrapper(new MockHttpServletRequest()));
    MockHttpServletResponse response = new MockHttpServletResponse();

    HashMap<String, Field> stringFieldMap = new HashMap<>();
    stringFieldMap.put("entity", new Field());

    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.getFields()).thenReturn(stringFieldMap);
    doNothing().when(entityForm).clearFieldsMap();

    ModelMap modelMap = new ModelMap();
    modelMap.put("entity", null);
    modelMap.put("entityForm", entityForm);

    ModelAndView modelAndView = mock(ModelAndView.class);
    when(modelAndView.getModelMap()).thenReturn(modelMap);
    when(modelAndView.addObject(Mockito.<String>any(), Mockito.<Object>any()))
        .thenReturn(new ModelAndView("View Name"));
    modelAndView.addObject("entity", "Attribute Value");

    // Act
    jsFieldNameCompatibilityInterceptor.postHandle(request, response, "Handler", modelAndView);

    // Assert
    verify(entityForm, atLeast(1)).clearFieldsMap();
    verify(entityForm).getFields();
    verify(modelAndView).addObject(eq("entity"), isA(Object.class));
    verify(modelAndView, atLeast(1)).getModelMap();
  }

  /**
   * Test {@link JSFieldNameCompatibilityInterceptor#postHandle(HttpServletRequest,
   * HttpServletResponse, Object, ModelAndView)}.
   *
   * <ul>
   *   <li>Given {@link ModelMap#ModelMap()} {@code entityForm} is {@link EntityForm} (default
   *       constructor).
   *   <li>Then calls {@link ModelAndView#addObject(String, Object)}.
   * </ul>
   *
   * <p>Method under test: {@link JSFieldNameCompatibilityInterceptor#postHandle(HttpServletRequest,
   * HttpServletResponse, Object, ModelAndView)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void JSFieldNameCompatibilityInterceptor.postHandle(HttpServletRequest, HttpServletResponse, Object, ModelAndView)"
  })
  public void testPostHandle_givenModelMapEntityFormIsEntityForm_thenCallsAddObject()
      throws Exception {
    // Arrange
    JSFieldNameCompatibilityInterceptor jsFieldNameCompatibilityInterceptor =
        new JSFieldNameCompatibilityInterceptor();
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(
            new JSCompatibilityRequestWrapper(new MockHttpServletRequest()));
    MockHttpServletResponse response = new MockHttpServletResponse();

    ModelMap modelMap = new ModelMap();
    modelMap.put("entity", null);
    modelMap.put("entityForm", new EntityForm());

    ModelAndView modelAndView = mock(ModelAndView.class);
    when(modelAndView.getModelMap()).thenReturn(modelMap);
    when(modelAndView.addObject(Mockito.<String>any(), Mockito.<Object>any()))
        .thenReturn(new ModelAndView("View Name"));
    modelAndView.addObject("entity", "Attribute Value");

    // Act
    jsFieldNameCompatibilityInterceptor.postHandle(request, response, "Handler", modelAndView);

    // Assert
    verify(modelAndView).addObject(eq("entity"), isA(Object.class));
    verify(modelAndView, atLeast(1)).getModelMap();
  }

  /**
   * Test {@link JSFieldNameCompatibilityInterceptor#postHandle(HttpServletRequest,
   * HttpServletResponse, Object, ModelAndView)}.
   *
   * <ul>
   *   <li>Given {@link ModelMap#ModelMap()} {@code entity} is {@link Entity} (default constructor).
   *   <li>Then calls {@link EntityForm#clearFieldsMap()}.
   * </ul>
   *
   * <p>Method under test: {@link JSFieldNameCompatibilityInterceptor#postHandle(HttpServletRequest,
   * HttpServletResponse, Object, ModelAndView)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void JSFieldNameCompatibilityInterceptor.postHandle(HttpServletRequest, HttpServletResponse, Object, ModelAndView)"
  })
  public void testPostHandle_givenModelMapEntityIsEntity_thenCallsClearFieldsMap()
      throws Exception {
    // Arrange
    JSFieldNameCompatibilityInterceptor jsFieldNameCompatibilityInterceptor =
        new JSFieldNameCompatibilityInterceptor();
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(
            new JSCompatibilityRequestWrapper(new MockHttpServletRequest()));
    MockHttpServletResponse response = new MockHttpServletResponse();

    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.getFields()).thenReturn(new HashMap<>());
    doNothing().when(entityForm).clearFieldsMap();

    ModelMap modelMap = new ModelMap();
    modelMap.put("entity", new Entity());
    modelMap.put("entityForm", entityForm);

    ModelAndView modelAndView = mock(ModelAndView.class);
    when(modelAndView.getModelMap()).thenReturn(modelMap);
    when(modelAndView.addObject(Mockito.<String>any(), Mockito.<Object>any()))
        .thenReturn(new ModelAndView("View Name"));
    modelAndView.addObject("entity", "Attribute Value");

    // Act
    jsFieldNameCompatibilityInterceptor.postHandle(request, response, "Handler", modelAndView);

    // Assert
    verify(entityForm, atLeast(1)).clearFieldsMap();
    verify(entityForm).getFields();
    verify(modelAndView).addObject(eq("entity"), isA(Object.class));
    verify(modelAndView, atLeast(1)).getModelMap();
  }

  /**
   * Test {@link JSFieldNameCompatibilityInterceptor#postHandle(HttpServletRequest,
   * HttpServletResponse, Object, ModelAndView)}.
   *
   * <ul>
   *   <li>Given {@link ModelMap#ModelMap()} {@code entity} is {@code null}.
   *   <li>Then calls {@link EntityForm#clearFieldsMap()}.
   * </ul>
   *
   * <p>Method under test: {@link JSFieldNameCompatibilityInterceptor#postHandle(HttpServletRequest,
   * HttpServletResponse, Object, ModelAndView)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void JSFieldNameCompatibilityInterceptor.postHandle(HttpServletRequest, HttpServletResponse, Object, ModelAndView)"
  })
  public void testPostHandle_givenModelMapEntityIsNull_thenCallsClearFieldsMap() throws Exception {
    // Arrange
    JSFieldNameCompatibilityInterceptor jsFieldNameCompatibilityInterceptor =
        new JSFieldNameCompatibilityInterceptor();
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(
            new JSCompatibilityRequestWrapper(new MockHttpServletRequest()));
    MockHttpServletResponse response = new MockHttpServletResponse();

    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.getFields()).thenReturn(new HashMap<>());
    doNothing().when(entityForm).clearFieldsMap();

    ModelMap modelMap = new ModelMap();
    modelMap.put("entity", null);
    modelMap.put("entityForm", entityForm);

    ModelAndView modelAndView = mock(ModelAndView.class);
    when(modelAndView.getModelMap()).thenReturn(modelMap);
    when(modelAndView.addObject(Mockito.<String>any(), Mockito.<Object>any()))
        .thenReturn(new ModelAndView("View Name"));
    modelAndView.addObject("entity", "Attribute Value");

    // Act
    jsFieldNameCompatibilityInterceptor.postHandle(request, response, "Handler", modelAndView);

    // Assert
    verify(entityForm, atLeast(1)).clearFieldsMap();
    verify(entityForm).getFields();
    verify(modelAndView).addObject(eq("entity"), isA(Object.class));
    verify(modelAndView, atLeast(1)).getModelMap();
  }

  /**
   * Test {@link JSFieldNameCompatibilityInterceptor#postHandle(HttpServletRequest,
   * HttpServletResponse, Object, ModelAndView)}.
   *
   * <ul>
   *   <li>Given {@link Property} {@link Property#setName(String)} does nothing.
   *   <li>Then calls {@link Property#getName()}.
   * </ul>
   *
   * <p>Method under test: {@link JSFieldNameCompatibilityInterceptor#postHandle(HttpServletRequest,
   * HttpServletResponse, Object, ModelAndView)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void JSFieldNameCompatibilityInterceptor.postHandle(HttpServletRequest, HttpServletResponse, Object, ModelAndView)"
  })
  public void testPostHandle_givenPropertySetNameDoesNothing_thenCallsGetName() throws Exception {
    // Arrange
    JSFieldNameCompatibilityInterceptor jsFieldNameCompatibilityInterceptor =
        new JSFieldNameCompatibilityInterceptor();
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(
            new JSCompatibilityRequestWrapper(new MockHttpServletRequest()));
    MockHttpServletResponse response = new MockHttpServletResponse();

    Property property = mock(Property.class);
    doNothing().when(property).setName(Mockito.<String>any());
    when(property.getName()).thenReturn(".");

    Entity entity = mock(Entity.class);
    when(entity.getProperties()).thenReturn(new Property[] {property});

    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.getFields()).thenReturn(new HashMap<>());
    doNothing().when(entityForm).clearFieldsMap();

    ModelMap modelMap = new ModelMap();
    modelMap.put("entity", entity);
    modelMap.put("entityForm", entityForm);

    ModelAndView modelAndView = mock(ModelAndView.class);
    when(modelAndView.getModelMap()).thenReturn(modelMap);
    when(modelAndView.addObject(Mockito.<String>any(), Mockito.<Object>any()))
        .thenReturn(new ModelAndView("View Name"));
    modelAndView.addObject("entity", "Attribute Value");

    // Act
    jsFieldNameCompatibilityInterceptor.postHandle(request, response, "Handler", modelAndView);

    // Assert
    verify(entity, atLeast(1)).getProperties();
    verify(property, atLeast(1)).getName();
    verify(property).setName("__");
    verify(entityForm, atLeast(1)).clearFieldsMap();
    verify(entityForm).getFields();
    verify(modelAndView).addObject(eq("entity"), isA(Object.class));
    verify(modelAndView, atLeast(1)).getModelMap();
  }
}
