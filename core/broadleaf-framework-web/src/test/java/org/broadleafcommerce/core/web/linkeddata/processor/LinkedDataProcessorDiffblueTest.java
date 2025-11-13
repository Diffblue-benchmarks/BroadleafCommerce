package org.broadleafcommerce.core.web.linkeddata.processor;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.broadleafcommerce.core.web.linkeddata.generator.CategoryLinkedDataGeneratorImpl;
import org.broadleafcommerce.core.web.linkeddata.generator.DefaultLinkedDataGeneratorImpl;
import org.broadleafcommerce.core.web.linkeddata.generator.LinkedDataGenerator;
import org.broadleafcommerce.presentation.model.BroadleafTemplateContext;
import org.broadleafcommerce.presentation.model.BroadleafTemplateElement;
import org.broadleafcommerce.presentation.model.BroadleafTemplateModel;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.mock.web.MockHttpServletRequest;

@RunWith(MockitoJUnitRunner.class)
public class LinkedDataProcessorDiffblueTest {
  @InjectMocks private LinkedDataProcessor linkedDataProcessor;

  @Mock private List<LinkedDataGenerator> list;

  /**
   * Test {@link LinkedDataProcessor#getReplacementModel(String, Map, BroadleafTemplateContext)}.
   *
   * <p>Method under test: {@link LinkedDataProcessor#getReplacementModel(String, Map,
   * BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BroadleafTemplateModel LinkedDataProcessor.getReplacementModel(String, Map, BroadleafTemplateContext)"
  })
  public void testGetReplacementModel() throws JSONException {
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

    BroadleafTemplateModel broadleafTemplateModel = mock(BroadleafTemplateModel.class);
    doNothing().when(broadleafTemplateModel).addElement(Mockito.<BroadleafTemplateElement>any());

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.createTextElement(Mockito.<String>any()))
        .thenReturn(mock(BroadleafTemplateElement.class));
    when(context.createModel()).thenReturn(broadleafTemplateModel);
    when(context.getRequest()).thenReturn(new MockHttpServletRequest());

    // Act
    linkedDataProcessor.getReplacementModel("foo", map, context);

    // Assert
    verify(list).iterator();
    verify(defaultLinkedDataGeneratorImpl)
        .getLinkedDataJSON(
            eq("http://localhost"), isA(HttpServletRequest.class), isA(JSONArray.class));
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BroadleafTemplateModel LinkedDataProcessor.getReplacementModel(String, Map, BroadleafTemplateContext)"
  })
  public void testGetReplacementModel2() throws JSONException {
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

    BroadleafTemplateModel broadleafTemplateModel = mock(BroadleafTemplateModel.class);
    doNothing().when(broadleafTemplateModel).addElement(Mockito.<BroadleafTemplateElement>any());

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.createTextElement(Mockito.<String>any()))
        .thenReturn(mock(BroadleafTemplateElement.class));
    when(context.createModel()).thenReturn(broadleafTemplateModel);
    when(context.getRequest()).thenReturn(new MockHttpServletRequest());

    // Act
    linkedDataProcessor.getReplacementModel("foo", map, context);

    // Assert
    verify(list).iterator();
    verify(defaultLinkedDataGeneratorImpl)
        .getLinkedDataJSON(
            eq("http://localhost"), isA(HttpServletRequest.class), isA(JSONArray.class));
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
   *   <li>Given {@link ArrayList#ArrayList()} add {@link CategoryLinkedDataGeneratorImpl} (default
   *       constructor).
   * </ul>
   *
   * <p>Method under test: {@link LinkedDataProcessor#getReplacementModel(String, Map,
   * BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BroadleafTemplateModel LinkedDataProcessor.getReplacementModel(String, Map, BroadleafTemplateContext)"
  })
  public void testGetReplacementModel_givenArrayListAddCategoryLinkedDataGeneratorImpl() {
    // Arrange
    ArrayList<LinkedDataGenerator> linkedDataGeneratorList = new ArrayList<>();
    linkedDataGeneratorList.add(new CategoryLinkedDataGeneratorImpl());
    when(list.iterator()).thenReturn(linkedDataGeneratorList.iterator());
    HashMap<String, String> map = new HashMap<>();

    BroadleafTemplateModel broadleafTemplateModel = mock(BroadleafTemplateModel.class);
    doNothing().when(broadleafTemplateModel).addElement(Mockito.<BroadleafTemplateElement>any());

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.createTextElement(Mockito.<String>any()))
        .thenReturn(mock(BroadleafTemplateElement.class));
    when(context.createModel()).thenReturn(broadleafTemplateModel);
    when(context.getRequest()).thenReturn(new MockHttpServletRequest());

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
   * <ul>
   *   <li>Then calls {@link List#iterator()}.
   * </ul>
   *
   * <p>Method under test: {@link LinkedDataProcessor#getReplacementModel(String, Map,
   * BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BroadleafTemplateModel LinkedDataProcessor.getReplacementModel(String, Map, BroadleafTemplateContext)"
  })
  public void testGetReplacementModel_thenCallsIterator() {
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
    when(context.getRequest()).thenReturn(new MockHttpServletRequest());

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
   * Test {@link LinkedDataProcessor#getData(HttpServletRequest)}.
   *
   * <p>Method under test: {@link LinkedDataProcessor#getData(HttpServletRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String LinkedDataProcessor.getData(HttpServletRequest)"})
  public void testGetData() throws JSONException {
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

    // Act
    String actualData = linkedDataProcessor.getData(new MockHttpServletRequest());

    // Assert
    verify(list).iterator();
    verify(defaultLinkedDataGeneratorImpl)
        .getLinkedDataJSON(
            eq("http://localhost"), isA(HttpServletRequest.class), isA(JSONArray.class));
    verify(defaultLinkedDataGeneratorImpl).canHandle(isA(HttpServletRequest.class));
    assertEquals("[]", actualData);
  }

  /**
   * Test {@link LinkedDataProcessor#getData(HttpServletRequest)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link CategoryLinkedDataGeneratorImpl} (default
   *       constructor).
   * </ul>
   *
   * <p>Method under test: {@link LinkedDataProcessor#getData(HttpServletRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String LinkedDataProcessor.getData(HttpServletRequest)"})
  public void testGetData_givenArrayListAddCategoryLinkedDataGeneratorImpl() {
    // Arrange
    ArrayList<LinkedDataGenerator> linkedDataGeneratorList = new ArrayList<>();
    linkedDataGeneratorList.add(new CategoryLinkedDataGeneratorImpl());
    when(list.iterator()).thenReturn(linkedDataGeneratorList.iterator());

    // Act
    String actualData = linkedDataProcessor.getData(new MockHttpServletRequest());

    // Assert
    verify(list).iterator();
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String LinkedDataProcessor.getData(HttpServletRequest)"})
  public void testGetData_givenDefaultLinkedDataGeneratorImplGetLinkedDataJSONDoesNothing()
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

    // Act
    String actualData = linkedDataProcessor.getData(new MockHttpServletRequest());

    // Assert
    verify(list).iterator();
    verify(defaultLinkedDataGeneratorImpl)
        .getLinkedDataJSON(
            eq("http://localhost"), isA(HttpServletRequest.class), isA(JSONArray.class));
    verify(defaultLinkedDataGeneratorImpl).canHandle(isA(HttpServletRequest.class));
    assertEquals("[]", actualData);
  }

  /**
   * Test {@link LinkedDataProcessor#getData(HttpServletRequest)}.
   *
   * <ul>
   *   <li>Then return {@code []}.
   * </ul>
   *
   * <p>Method under test: {@link LinkedDataProcessor#getData(HttpServletRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String LinkedDataProcessor.getData(HttpServletRequest)"})
  public void testGetData_thenReturnLeftSquareBracketRightSquareBracket() {
    // Arrange
    ArrayList<LinkedDataGenerator> linkedDataGeneratorList = new ArrayList<>();
    when(list.iterator()).thenReturn(linkedDataGeneratorList.iterator());

    // Act
    String actualData = linkedDataProcessor.getData(new MockHttpServletRequest());

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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String LinkedDataProcessor.getName()"})
  public void testGetName() {
    // Arrange, Act and Assert
    assertEquals("linkedData", new LinkedDataProcessor().getName());
  }
}
