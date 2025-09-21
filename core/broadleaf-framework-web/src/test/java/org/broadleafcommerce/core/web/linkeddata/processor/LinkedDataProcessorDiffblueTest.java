/*-
 * #%L
 * BroadleafCommerce Framework Web
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
package org.broadleafcommerce.core.web.linkeddata.processor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import org.broadleafcommerce.core.web.linkeddata.generator.DefaultLinkedDataGeneratorImpl;
import org.broadleafcommerce.core.web.linkeddata.generator.HomepageLinkedDataGeneratorImpl;
import org.broadleafcommerce.core.web.linkeddata.generator.LinkedDataGenerator;
import org.broadleafcommerce.core.web.search.SearchRequestWrapper;
import org.broadleafcommerce.presentation.model.BroadleafTemplateContext;
import org.broadleafcommerce.presentation.model.BroadleafTemplateElement;
import org.broadleafcommerce.presentation.model.BroadleafTemplateModel;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.multipart.support.DefaultMultipartHttpServletRequest;

@ExtendWith(MockitoExtension.class)
class LinkedDataProcessorDiffblueTest {
  @InjectMocks private LinkedDataProcessor linkedDataProcessor;

  @Mock private List<LinkedDataGenerator> list;

  /**
   * Test {@link LinkedDataProcessor#getReplacementModel(String, Map, BroadleafTemplateContext)}.
   *
   * <p>Method under test: {@link LinkedDataProcessor#getReplacementModel(String, Map,
   * BroadleafTemplateContext)}
   */
  @Test
  @DisplayName("Test getReplacementModel(String, Map, BroadleafTemplateContext)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BroadleafTemplateModel LinkedDataProcessor.getReplacementModel(String, Map, BroadleafTemplateContext)"
  })
  void testGetReplacementModel() {
    // Arrange
    ArrayList<LinkedDataGenerator> linkedDataGeneratorList = new ArrayList<>();
    when(list.iterator()).thenReturn(linkedDataGeneratorList.iterator());
    HashMap<String, String> map = new HashMap<>();

    BroadleafTemplateModel broadleafTemplateModel = mock(BroadleafTemplateModel.class);
    doNothing().when(broadleafTemplateModel).addElement(Mockito.<BroadleafTemplateElement>any());

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.createTextElement(Mockito.<String>any()))
        .thenReturn(mock(BroadleafTemplateElement.class));
    when(context.createModel()).thenReturn(broadleafTemplateModel);
    when(context.getRequest())
        .thenReturn(
            new HttpServletRequestWrapper(new SearchRequestWrapper(new MockHttpServletRequest())));

    // Act
    linkedDataProcessor.getReplacementModel("foo", map, context);

    // Assert
    verify(list).iterator();
    verify(context).createModel();
    verify(context).createTextElement("<script type=\"application/ld+json\">\n[]\n</script>");
    verify(context).getRequest();
    verify(broadleafTemplateModel).addElement(isA(BroadleafTemplateElement.class));
  }

  /**
   * Test {@link LinkedDataProcessor#getReplacementModel(String, Map, BroadleafTemplateContext)}.
   *
   * <p>Method under test: {@link LinkedDataProcessor#getReplacementModel(String, Map,
   * BroadleafTemplateContext)}
   */
  @Test
  @DisplayName("Test getReplacementModel(String, Map, BroadleafTemplateContext)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BroadleafTemplateModel LinkedDataProcessor.getReplacementModel(String, Map, BroadleafTemplateContext)"
  })
  void testGetReplacementModel2() throws JSONException {
    // Arrange
    DefaultLinkedDataGeneratorImpl defaultLinkedDataGeneratorImpl =
        mock(DefaultLinkedDataGeneratorImpl.class);
    doNothing()
        .when(defaultLinkedDataGeneratorImpl)
        .getLinkedDataJSON(
            Mockito.<String>any(), Mockito.<HttpServletRequest>any(), Mockito.<JSONArray>any());
    when(defaultLinkedDataGeneratorImpl.canHandle(Mockito.<HttpServletRequest>any()))
        .thenReturn(true);

    ArrayList<LinkedDataGenerator> linkedDataGeneratorList = new ArrayList<>();
    linkedDataGeneratorList.add(defaultLinkedDataGeneratorImpl);
    when(list.iterator()).thenReturn(linkedDataGeneratorList.iterator());
    HashMap<String, String> map = new HashMap<>();

    DefaultMultipartHttpServletRequest servletRequest =
        mock(DefaultMultipartHttpServletRequest.class);
    when(servletRequest.getRequestURL()).thenReturn(new StringBuffer("foo"));
    SearchRequestWrapper request = new SearchRequestWrapper(servletRequest);
    HttpServletRequestWrapper httpServletRequestWrapper = new HttpServletRequestWrapper(request);

    BroadleafTemplateModel broadleafTemplateModel = mock(BroadleafTemplateModel.class);
    doNothing().when(broadleafTemplateModel).addElement(Mockito.<BroadleafTemplateElement>any());

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.createTextElement(Mockito.<String>any()))
        .thenReturn(mock(BroadleafTemplateElement.class));
    when(context.createModel()).thenReturn(broadleafTemplateModel);
    when(context.getRequest()).thenReturn(httpServletRequestWrapper);

    // Act
    linkedDataProcessor.getReplacementModel("foo", map, context);

    // Assert
    verify(list).iterator();
    verify(servletRequest).getRequestURL();
    verify(defaultLinkedDataGeneratorImpl)
        .getLinkedDataJSON(eq("foo"), isA(HttpServletRequest.class), isA(JSONArray.class));
    verify(defaultLinkedDataGeneratorImpl).canHandle(isA(HttpServletRequest.class));
    verify(context).createModel();
    verify(context).createTextElement("<script type=\"application/ld+json\">\n[]\n</script>");
    verify(context).getRequest();
    verify(broadleafTemplateModel).addElement(isA(BroadleafTemplateElement.class));
  }

  /**
   * Test {@link LinkedDataProcessor#getReplacementModel(String, Map, BroadleafTemplateContext)}.
   *
   * <p>Method under test: {@link LinkedDataProcessor#getReplacementModel(String, Map,
   * BroadleafTemplateContext)}
   */
  @Test
  @DisplayName("Test getReplacementModel(String, Map, BroadleafTemplateContext)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BroadleafTemplateModel LinkedDataProcessor.getReplacementModel(String, Map, BroadleafTemplateContext)"
  })
  void testGetReplacementModel3() throws JSONException {
    // Arrange
    DefaultLinkedDataGeneratorImpl defaultLinkedDataGeneratorImpl =
        mock(DefaultLinkedDataGeneratorImpl.class);
    doThrow(new JSONException("An error occurred"))
        .when(defaultLinkedDataGeneratorImpl)
        .getLinkedDataJSON(
            Mockito.<String>any(), Mockito.<HttpServletRequest>any(), Mockito.<JSONArray>any());
    when(defaultLinkedDataGeneratorImpl.canHandle(Mockito.<HttpServletRequest>any()))
        .thenReturn(true);

    ArrayList<LinkedDataGenerator> linkedDataGeneratorList = new ArrayList<>();
    linkedDataGeneratorList.add(defaultLinkedDataGeneratorImpl);
    when(list.iterator()).thenReturn(linkedDataGeneratorList.iterator());
    HashMap<String, String> map = new HashMap<>();

    DefaultMultipartHttpServletRequest servletRequest =
        mock(DefaultMultipartHttpServletRequest.class);
    when(servletRequest.getRequestURL()).thenReturn(new StringBuffer("foo"));
    SearchRequestWrapper request = new SearchRequestWrapper(servletRequest);
    HttpServletRequestWrapper httpServletRequestWrapper = new HttpServletRequestWrapper(request);

    BroadleafTemplateModel broadleafTemplateModel = mock(BroadleafTemplateModel.class);
    doNothing().when(broadleafTemplateModel).addElement(Mockito.<BroadleafTemplateElement>any());

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.createTextElement(Mockito.<String>any()))
        .thenReturn(mock(BroadleafTemplateElement.class));
    when(context.createModel()).thenReturn(broadleafTemplateModel);
    when(context.getRequest()).thenReturn(httpServletRequestWrapper);

    // Act
    linkedDataProcessor.getReplacementModel("foo", map, context);

    // Assert
    verify(list).iterator();
    verify(servletRequest).getRequestURL();
    verify(defaultLinkedDataGeneratorImpl)
        .getLinkedDataJSON(eq("foo"), isA(HttpServletRequest.class), isA(JSONArray.class));
    verify(defaultLinkedDataGeneratorImpl).canHandle(isA(HttpServletRequest.class));
    verify(context).createModel();
    verify(context).createTextElement("<script type=\"application/ld+json\">\n[]\n</script>");
    verify(context).getRequest();
    verify(broadleafTemplateModel).addElement(isA(BroadleafTemplateElement.class));
  }

  /**
   * Test {@link LinkedDataProcessor#getReplacementModel(String, Map, BroadleafTemplateContext)}.
   *
   * <ul>
   *   <li>Then calls {@link DefaultMultipartHttpServletRequest#getRequestURI()}.
   * </ul>
   *
   * <p>Method under test: {@link LinkedDataProcessor#getReplacementModel(String, Map,
   * BroadleafTemplateContext)}
   */
  @Test
  @DisplayName(
      "Test getReplacementModel(String, Map, BroadleafTemplateContext); then calls getRequestURI()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BroadleafTemplateModel LinkedDataProcessor.getReplacementModel(String, Map, BroadleafTemplateContext)"
  })
  void testGetReplacementModel_thenCallsGetRequestURI() {
    // Arrange
    ArrayList<LinkedDataGenerator> linkedDataGeneratorList = new ArrayList<>();
    linkedDataGeneratorList.add(new HomepageLinkedDataGeneratorImpl());
    when(list.iterator()).thenReturn(linkedDataGeneratorList.iterator());
    HashMap<String, String> map = new HashMap<>();

    DefaultMultipartHttpServletRequest servletRequest =
        mock(DefaultMultipartHttpServletRequest.class);
    when(servletRequest.getRequestURI()).thenReturn("https://example.org/example");
    when(servletRequest.getRequestURL()).thenReturn(new StringBuffer("foo"));
    SearchRequestWrapper request = new SearchRequestWrapper(servletRequest);
    HttpServletRequestWrapper httpServletRequestWrapper = new HttpServletRequestWrapper(request);

    BroadleafTemplateModel broadleafTemplateModel = mock(BroadleafTemplateModel.class);
    doNothing().when(broadleafTemplateModel).addElement(Mockito.<BroadleafTemplateElement>any());

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.createTextElement(Mockito.<String>any()))
        .thenReturn(mock(BroadleafTemplateElement.class));
    when(context.createModel()).thenReturn(broadleafTemplateModel);
    when(context.getRequest()).thenReturn(httpServletRequestWrapper);

    // Act
    linkedDataProcessor.getReplacementModel("foo", map, context);

    // Assert
    verify(list).iterator();
    verify(servletRequest).getRequestURI();
    verify(servletRequest).getRequestURL();
    verify(context).createModel();
    verify(context).createTextElement("<script type=\"application/ld+json\">\n[]\n</script>");
    verify(context).getRequest();
    verify(broadleafTemplateModel).addElement(isA(BroadleafTemplateElement.class));
  }

  /**
   * Test {@link LinkedDataProcessor#getData(HttpServletRequest)}.
   *
   * <p>Method under test: {@link LinkedDataProcessor#getData(HttpServletRequest)}
   */
  @Test
  @DisplayName("Test getData(HttpServletRequest)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String LinkedDataProcessor.getData(HttpServletRequest)"})
  void testGetData() throws JSONException {
    // Arrange
    DefaultLinkedDataGeneratorImpl defaultLinkedDataGeneratorImpl =
        mock(DefaultLinkedDataGeneratorImpl.class);
    doThrow(new JSONException("An error occurred"))
        .when(defaultLinkedDataGeneratorImpl)
        .getLinkedDataJSON(
            Mockito.<String>any(), Mockito.<HttpServletRequest>any(), Mockito.<JSONArray>any());
    when(defaultLinkedDataGeneratorImpl.canHandle(Mockito.<HttpServletRequest>any()))
        .thenReturn(true);

    ArrayList<LinkedDataGenerator> linkedDataGeneratorList = new ArrayList<>();
    linkedDataGeneratorList.add(defaultLinkedDataGeneratorImpl);
    when(list.iterator()).thenReturn(linkedDataGeneratorList.iterator());

    DefaultMultipartHttpServletRequest servletRequest =
        mock(DefaultMultipartHttpServletRequest.class);
    when(servletRequest.getRequestURL()).thenReturn(new StringBuffer("foo"));
    SearchRequestWrapper request = new SearchRequestWrapper(servletRequest);

    // Act
    String actualData = linkedDataProcessor.getData(new HttpServletRequestWrapper(request));

    // Assert
    verify(list).iterator();
    verify(servletRequest).getRequestURL();
    verify(defaultLinkedDataGeneratorImpl)
        .getLinkedDataJSON(eq("foo"), isA(HttpServletRequest.class), isA(JSONArray.class));
    verify(defaultLinkedDataGeneratorImpl).canHandle(isA(HttpServletRequest.class));
    assertEquals("[]", actualData);
  }

  /**
   * Test {@link LinkedDataProcessor#getData(HttpServletRequest)}.
   *
   * <ul>
   *   <li>Given {@link DefaultLinkedDataGeneratorImpl} {@link
   *       DefaultLinkedDataGeneratorImpl#getLinkedDataJSON(String, HttpServletRequest, JSONArray)}
   *       does nothing.
   * </ul>
   *
   * <p>Method under test: {@link LinkedDataProcessor#getData(HttpServletRequest)}
   */
  @Test
  @DisplayName(
      "Test getData(HttpServletRequest); given DefaultLinkedDataGeneratorImpl getLinkedDataJSON(String, HttpServletRequest, JSONArray) does nothing")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String LinkedDataProcessor.getData(HttpServletRequest)"})
  void testGetData_givenDefaultLinkedDataGeneratorImplGetLinkedDataJSONDoesNothing()
      throws JSONException {
    // Arrange
    DefaultLinkedDataGeneratorImpl defaultLinkedDataGeneratorImpl =
        mock(DefaultLinkedDataGeneratorImpl.class);
    doNothing()
        .when(defaultLinkedDataGeneratorImpl)
        .getLinkedDataJSON(
            Mockito.<String>any(), Mockito.<HttpServletRequest>any(), Mockito.<JSONArray>any());
    when(defaultLinkedDataGeneratorImpl.canHandle(Mockito.<HttpServletRequest>any()))
        .thenReturn(true);

    ArrayList<LinkedDataGenerator> linkedDataGeneratorList = new ArrayList<>();
    linkedDataGeneratorList.add(defaultLinkedDataGeneratorImpl);
    when(list.iterator()).thenReturn(linkedDataGeneratorList.iterator());

    DefaultMultipartHttpServletRequest servletRequest =
        mock(DefaultMultipartHttpServletRequest.class);
    when(servletRequest.getRequestURL()).thenReturn(new StringBuffer("foo"));
    SearchRequestWrapper request = new SearchRequestWrapper(servletRequest);

    // Act
    String actualData = linkedDataProcessor.getData(new HttpServletRequestWrapper(request));

    // Assert
    verify(list).iterator();
    verify(servletRequest).getRequestURL();
    verify(defaultLinkedDataGeneratorImpl)
        .getLinkedDataJSON(eq("foo"), isA(HttpServletRequest.class), isA(JSONArray.class));
    verify(defaultLinkedDataGeneratorImpl).canHandle(isA(HttpServletRequest.class));
    assertEquals("[]", actualData);
  }

  /**
   * Test {@link LinkedDataProcessor#getData(HttpServletRequest)}.
   *
   * <ul>
   *   <li>Then calls {@link DefaultMultipartHttpServletRequest#getRequestURI()}.
   * </ul>
   *
   * <p>Method under test: {@link LinkedDataProcessor#getData(HttpServletRequest)}
   */
  @Test
  @DisplayName("Test getData(HttpServletRequest); then calls getRequestURI()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String LinkedDataProcessor.getData(HttpServletRequest)"})
  void testGetData_thenCallsGetRequestURI() {
    // Arrange
    ArrayList<LinkedDataGenerator> linkedDataGeneratorList = new ArrayList<>();
    linkedDataGeneratorList.add(new HomepageLinkedDataGeneratorImpl());
    when(list.iterator()).thenReturn(linkedDataGeneratorList.iterator());

    DefaultMultipartHttpServletRequest servletRequest =
        mock(DefaultMultipartHttpServletRequest.class);
    when(servletRequest.getRequestURI()).thenReturn("https://example.org/example");
    when(servletRequest.getRequestURL()).thenReturn(new StringBuffer("foo"));
    SearchRequestWrapper request = new SearchRequestWrapper(servletRequest);

    // Act
    String actualData = linkedDataProcessor.getData(new HttpServletRequestWrapper(request));

    // Assert
    verify(list).iterator();
    verify(servletRequest).getRequestURI();
    verify(servletRequest).getRequestURL();
    assertEquals("[]", actualData);
  }

  /**
   * Test {@link LinkedDataProcessor#getData(HttpServletRequest)}.
   *
   * <ul>
   *   <li>When {@link SearchRequestWrapper#SearchRequestWrapper(HttpServletRequest)} with
   *       servletRequest is {@link MockHttpServletRequest#MockHttpServletRequest()}.
   * </ul>
   *
   * <p>Method under test: {@link LinkedDataProcessor#getData(HttpServletRequest)}
   */
  @Test
  @DisplayName(
      "Test getData(HttpServletRequest); when SearchRequestWrapper(HttpServletRequest) with servletRequest is MockHttpServletRequest()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String LinkedDataProcessor.getData(HttpServletRequest)"})
  void testGetData_whenSearchRequestWrapperWithServletRequestIsMockHttpServletRequest() {
    // Arrange
    ArrayList<LinkedDataGenerator> linkedDataGeneratorList = new ArrayList<>();
    when(list.iterator()).thenReturn(linkedDataGeneratorList.iterator());

    // Act
    String actualData =
        linkedDataProcessor.getData(
            new HttpServletRequestWrapper(new SearchRequestWrapper(new MockHttpServletRequest())));

    // Assert
    verify(list).iterator();
    assertEquals("[]", actualData);
  }

  /**
   * Test {@link LinkedDataProcessor#getName()}.
   *
   * <p>Method under test: {@link LinkedDataProcessor#getName()}
   */
  @Test
  @DisplayName("Test getName()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String LinkedDataProcessor.getName()"})
  void testGetName() {
    // Arrange, Act and Assert
    assertEquals("linkedData", new LinkedDataProcessor().getName());
  }
}
