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
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.broadleafcommerce.core.web.linkeddata.generator.CategoryLinkedDataGeneratorImpl;
import org.broadleafcommerce.core.web.linkeddata.generator.LinkedDataGenerator;
import org.broadleafcommerce.core.web.search.SearchRequestWrapper;
import org.broadleafcommerce.core.web.security.XssRequestWrapper;
import org.broadleafcommerce.presentation.model.BroadleafTemplateContext;
import org.broadleafcommerce.presentation.model.BroadleafTemplateElement;
import org.broadleafcommerce.presentation.model.BroadleafTemplateModel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.web.reactive.context.StandardReactiveWebEnvironment;
import org.springframework.mock.web.MockHttpServletRequest;

@ExtendWith(MockitoExtension.class)
class LinkedDataProcessorDiffblueTest {
  @InjectMocks
  private LinkedDataProcessor linkedDataProcessor;

  @Mock
  private List<LinkedDataGenerator> list;

  /**
   * Test {@link LinkedDataProcessor#getReplacementModel(String, Map, BroadleafTemplateContext)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link CategoryLinkedDataGeneratorImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link LinkedDataProcessor#getReplacementModel(String, Map, BroadleafTemplateContext)}
   */
  @Test
  @DisplayName("Test getReplacementModel(String, Map, BroadleafTemplateContext); given ArrayList() add CategoryLinkedDataGeneratorImpl (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "BroadleafTemplateModel LinkedDataProcessor.getReplacementModel(String, Map, BroadleafTemplateContext)"})
  void testGetReplacementModel_givenArrayListAddCategoryLinkedDataGeneratorImpl() {
    // Arrange
    ArrayList<LinkedDataGenerator> linkedDataGeneratorList = new ArrayList<>();
    linkedDataGeneratorList.add(new CategoryLinkedDataGeneratorImpl());
    when(list.iterator()).thenReturn(linkedDataGeneratorList.iterator());
    HashMap<String, String> map = new HashMap<>();
    BroadleafTemplateModel broadleafTemplateModel = mock(BroadleafTemplateModel.class);
    doNothing().when(broadleafTemplateModel).addElement(Mockito.<BroadleafTemplateElement>any());
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.createTextElement(Mockito.<String>any())).thenReturn(mock(BroadleafTemplateElement.class));
    when(context.createModel()).thenReturn(broadleafTemplateModel);
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    when(context.getRequest()).thenReturn(new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
        new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"})));

    // Act
    linkedDataProcessor.getReplacementModel("foo", map, context);

    // Assert
    verify(list).iterator();
    verify(context).createModel();
    verify(context).createTextElement(eq("<script type=\"application/ld+json\">\n[]\n</script>"));
    verify(context).getRequest();
    verify(broadleafTemplateModel).addElement(isA(BroadleafTemplateElement.class));
  }

  /**
   * Test {@link LinkedDataProcessor#getReplacementModel(String, Map, BroadleafTemplateContext)}.
   * <ul>
   *   <li>Then calls {@link List#iterator()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LinkedDataProcessor#getReplacementModel(String, Map, BroadleafTemplateContext)}
   */
  @Test
  @DisplayName("Test getReplacementModel(String, Map, BroadleafTemplateContext); then calls iterator()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "BroadleafTemplateModel LinkedDataProcessor.getReplacementModel(String, Map, BroadleafTemplateContext)"})
  void testGetReplacementModel_thenCallsIterator() {
    // Arrange
    ArrayList<LinkedDataGenerator> linkedDataGeneratorList = new ArrayList<>();
    when(list.iterator()).thenReturn(linkedDataGeneratorList.iterator());
    HashMap<String, String> map = new HashMap<>();
    BroadleafTemplateModel broadleafTemplateModel = mock(BroadleafTemplateModel.class);
    doNothing().when(broadleafTemplateModel).addElement(Mockito.<BroadleafTemplateElement>any());
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.createTextElement(Mockito.<String>any())).thenReturn(mock(BroadleafTemplateElement.class));
    when(context.createModel()).thenReturn(broadleafTemplateModel);
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    when(context.getRequest()).thenReturn(new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
        new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"})));

    // Act
    linkedDataProcessor.getReplacementModel("foo", map, context);

    // Assert
    verify(list).iterator();
    verify(context).createModel();
    verify(context).createTextElement(eq("<script type=\"application/ld+json\">\n[]\n</script>"));
    verify(context).getRequest();
    verify(broadleafTemplateModel).addElement(isA(BroadleafTemplateElement.class));
  }

  /**
   * Test {@link LinkedDataProcessor#getData(HttpServletRequest)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link CategoryLinkedDataGeneratorImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link LinkedDataProcessor#getData(HttpServletRequest)}
   */
  @Test
  @DisplayName("Test getData(HttpServletRequest); given ArrayList() add CategoryLinkedDataGeneratorImpl (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String LinkedDataProcessor.getData(HttpServletRequest)"})
  void testGetData_givenArrayListAddCategoryLinkedDataGeneratorImpl() {
    // Arrange
    ArrayList<LinkedDataGenerator> linkedDataGeneratorList = new ArrayList<>();
    linkedDataGeneratorList.add(new CategoryLinkedDataGeneratorImpl());
    when(list.iterator()).thenReturn(linkedDataGeneratorList.iterator());
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();

    // Act
    String actualData = linkedDataProcessor.getData(new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
        new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"})));

    // Assert
    verify(list).iterator();
    assertEquals("[]", actualData);
  }

  /**
   * Test {@link LinkedDataProcessor#getData(HttpServletRequest)}.
   * <ul>
   *   <li>Then return {@code []}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LinkedDataProcessor#getData(HttpServletRequest)}
   */
  @Test
  @DisplayName("Test getData(HttpServletRequest); then return '[]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String LinkedDataProcessor.getData(HttpServletRequest)"})
  void testGetData_thenReturnLeftSquareBracketRightSquareBracket() {
    // Arrange
    ArrayList<LinkedDataGenerator> linkedDataGeneratorList = new ArrayList<>();
    when(list.iterator()).thenReturn(linkedDataGeneratorList.iterator());
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();

    // Act
    String actualData = linkedDataProcessor.getData(new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
        new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"})));

    // Assert
    verify(list).iterator();
    assertEquals("[]", actualData);
  }

  /**
   * Test {@link LinkedDataProcessor#getName()}.
   * <p>
   * Method under test: {@link LinkedDataProcessor#getName()}
   */
  @Test
  @DisplayName("Test getName()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String LinkedDataProcessor.getName()"})
  void testGetName() {
    // Arrange, Act and Assert
    assertEquals("linkedData", (new LinkedDataProcessor()).getName());
  }
}
