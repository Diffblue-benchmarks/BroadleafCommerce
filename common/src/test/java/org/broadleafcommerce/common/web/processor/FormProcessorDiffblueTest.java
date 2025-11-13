package org.broadleafcommerce.common.web.processor;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Map;
import org.broadleafcommerce.common.exception.ServiceException;
import org.broadleafcommerce.common.security.service.ExploitProtectionService;
import org.broadleafcommerce.common.security.service.StaleStateProtectionService;
import org.broadleafcommerce.presentation.model.BroadleafTemplateContext;
import org.broadleafcommerce.presentation.model.BroadleafTemplateElement;
import org.broadleafcommerce.presentation.model.BroadleafTemplateModel;
import org.broadleafcommerce.presentation.model.BroadleafTemplateModelModifierDTO;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class FormProcessorDiffblueTest {
  @Mock private ExploitProtectionService exploitProtectionService;

  @InjectMocks private FormProcessor formProcessor;

  @Mock private StaleStateProtectionService staleStateProtectionService;

  /**
   * Test {@link FormProcessor#getName()}.
   *
   * <p>Method under test: {@link FormProcessor#getName()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String FormProcessor.getName()"})
  public void testGetName() {
    // Arrange, Act and Assert
    assertEquals("form", new FormProcessor().getName());
  }

  /**
   * Test {@link FormProcessor#getPrecedence()}.
   *
   * <p>Method under test: {@link FormProcessor#getPrecedence()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int FormProcessor.getPrecedence()"})
  public void testGetPrecedence() {
    // Arrange, Act and Assert
    assertEquals(1001, new FormProcessor().getPrecedence());
  }

  /**
   * Test {@link FormProcessor#getInjectedModelAndTagAttributes(String, Map,
   * BroadleafTemplateContext)}.
   *
   * <p>Method under test: {@link FormProcessor#getInjectedModelAndTagAttributes(String, Map,
   * BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BroadleafTemplateModelModifierDTO FormProcessor.getInjectedModelAndTagAttributes(String, Map, BroadleafTemplateContext)"
  })
  public void testGetInjectedModelAndTagAttributes() throws ServiceException {
    // Arrange
    when(exploitProtectionService.getCSRFToken())
        .thenThrow(new ServiceException("An error occurred"));
    HashMap<String, String> rootTagAttributes = new HashMap<>();

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.createModel()).thenReturn(mock(BroadleafTemplateModel.class));

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            formProcessor.getInjectedModelAndTagAttributes(
                "Root Tag Name", rootTagAttributes, context));
    verify(exploitProtectionService).getCSRFToken();
    verify(context).createModel();
  }

  /**
   * Test {@link FormProcessor#getInjectedModelAndTagAttributes(String, Map,
   * BroadleafTemplateContext)}.
   *
   * <p>Method under test: {@link FormProcessor#getInjectedModelAndTagAttributes(String, Map,
   * BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BroadleafTemplateModelModifierDTO FormProcessor.getInjectedModelAndTagAttributes(String, Map, BroadleafTemplateContext)"
  })
  public void testGetInjectedModelAndTagAttributes2() throws ServiceException {
    // Arrange
    when(exploitProtectionService.getCSRFToken()).thenReturn("ABC123");
    when(staleStateProtectionService.isEnabled()).thenThrow(new RuntimeException());
    HashMap<String, String> rootTagAttributes = new HashMap<>();

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.createModel()).thenReturn(mock(BroadleafTemplateModel.class));

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            formProcessor.getInjectedModelAndTagAttributes(
                "Root Tag Name", rootTagAttributes, context));
    verify(exploitProtectionService).getCSRFToken();
    verify(staleStateProtectionService).isEnabled();
    verify(context).createModel();
  }

  /**
   * Test {@link FormProcessor#getInjectedModelAndTagAttributes(String, Map,
   * BroadleafTemplateContext)}.
   *
   * <p>Method under test: {@link FormProcessor#getInjectedModelAndTagAttributes(String, Map,
   * BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BroadleafTemplateModelModifierDTO FormProcessor.getInjectedModelAndTagAttributes(String, Map, BroadleafTemplateContext)"
  })
  public void testGetInjectedModelAndTagAttributes3() throws ServiceException {
    // Arrange
    when(exploitProtectionService.getCSRFToken()).thenReturn("ABC123");
    when(staleStateProtectionService.getStateVersionToken()).thenThrow(new RuntimeException());
    when(staleStateProtectionService.isEnabled()).thenReturn(true);
    HashMap<String, String> rootTagAttributes = new HashMap<>();

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.createModel()).thenReturn(mock(BroadleafTemplateModel.class));

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            formProcessor.getInjectedModelAndTagAttributes(
                "Root Tag Name", rootTagAttributes, context));
    verify(exploitProtectionService).getCSRFToken();
    verify(staleStateProtectionService).getStateVersionToken();
    verify(staleStateProtectionService).isEnabled();
    verify(context).createModel();
  }

  /**
   * Test {@link FormProcessor#getInjectedModelAndTagAttributes(String, Map,
   * BroadleafTemplateContext)}.
   *
   * <p>Method under test: {@link FormProcessor#getInjectedModelAndTagAttributes(String, Map,
   * BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BroadleafTemplateModelModifierDTO FormProcessor.getInjectedModelAndTagAttributes(String, Map, BroadleafTemplateContext)"
  })
  public void testGetInjectedModelAndTagAttributes4() throws ServiceException {
    // Arrange
    when(exploitProtectionService.getCSRFToken()).thenReturn("ABC123");
    when(exploitProtectionService.getCsrfTokenParameter()).thenReturn("ABC123");
    when(staleStateProtectionService.getStateVersionTokenParameter()).thenReturn("MD");
    when(staleStateProtectionService.getStateVersionToken()).thenReturn("MD");
    when(staleStateProtectionService.isEnabled()).thenReturn(true);
    HashMap<String, String> rootTagAttributes = new HashMap<>();

    BroadleafTemplateModel broadleafTemplateModel = mock(BroadleafTemplateModel.class);
    doNothing().when(broadleafTemplateModel).addElement(Mockito.<BroadleafTemplateElement>any());

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.createStandaloneElement(
            Mockito.<String>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(mock(BroadleafTemplateElement.class));
    when(context.createModel()).thenReturn(broadleafTemplateModel);

    // Act
    BroadleafTemplateModelModifierDTO actualInjectedModelAndTagAttributes =
        formProcessor.getInjectedModelAndTagAttributes("Root Tag Name", rootTagAttributes, context);

    // Assert
    verify(exploitProtectionService).getCSRFToken();
    verify(exploitProtectionService).getCsrfTokenParameter();
    verify(staleStateProtectionService).getStateVersionToken();
    verify(staleStateProtectionService).getStateVersionTokenParameter();
    verify(staleStateProtectionService).isEnabled();
    verify(context).createModel();
    verify(context, atLeast(1))
        .createStandaloneElement(eq("input"), Mockito.<Map<String, String>>any(), eq(true));
    verify(broadleafTemplateModel, atLeast(1)).addElement(isA(BroadleafTemplateElement.class));
    assertEquals("form", actualInjectedModelAndTagAttributes.getReplacementTagName());
    assertTrue(actualInjectedModelAndTagAttributes.getFormLocalVariables().isEmpty());
    assertTrue(actualInjectedModelAndTagAttributes.getFormParameters().isEmpty());
  }

  /**
   * Test {@link FormProcessor#getInjectedModelAndTagAttributes(String, Map,
   * BroadleafTemplateContext)}.
   *
   * <p>Method under test: {@link FormProcessor#getInjectedModelAndTagAttributes(String, Map,
   * BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BroadleafTemplateModelModifierDTO FormProcessor.getInjectedModelAndTagAttributes(String, Map, BroadleafTemplateContext)"
  })
  public void testGetInjectedModelAndTagAttributes5() throws ServiceException {
    // Arrange
    when(exploitProtectionService.getCSRFToken()).thenReturn("ABC123");
    when(exploitProtectionService.getCsrfTokenParameter()).thenReturn("ABC123");
    when(staleStateProtectionService.getStateVersionTokenParameter())
        .thenThrow(new RuntimeException());
    when(staleStateProtectionService.getStateVersionToken()).thenReturn("MD");
    when(staleStateProtectionService.isEnabled()).thenReturn(true);
    HashMap<String, String> rootTagAttributes = new HashMap<>();

    BroadleafTemplateModel broadleafTemplateModel = mock(BroadleafTemplateModel.class);
    doNothing().when(broadleafTemplateModel).addElement(Mockito.<BroadleafTemplateElement>any());

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.createStandaloneElement(
            Mockito.<String>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(mock(BroadleafTemplateElement.class));
    when(context.createModel()).thenReturn(broadleafTemplateModel);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            formProcessor.getInjectedModelAndTagAttributes(
                "Root Tag Name", rootTagAttributes, context));
    verify(exploitProtectionService).getCSRFToken();
    verify(exploitProtectionService).getCsrfTokenParameter();
    verify(staleStateProtectionService).getStateVersionToken();
    verify(staleStateProtectionService).getStateVersionTokenParameter();
    verify(staleStateProtectionService).isEnabled();
    verify(context).createModel();
    verify(context).createStandaloneElement(eq("input"), isA(Map.class), eq(true));
    verify(broadleafTemplateModel).addElement(isA(BroadleafTemplateElement.class));
  }

  /**
   * Test {@link FormProcessor#getInjectedModelAndTagAttributes(String, Map,
   * BroadleafTemplateContext)}.
   *
   * <p>Method under test: {@link FormProcessor#getInjectedModelAndTagAttributes(String, Map,
   * BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BroadleafTemplateModelModifierDTO FormProcessor.getInjectedModelAndTagAttributes(String, Map, BroadleafTemplateContext)"
  })
  public void testGetInjectedModelAndTagAttributes6() throws ServiceException {
    // Arrange
    when(exploitProtectionService.getCSRFToken()).thenReturn("ABC123");
    when(exploitProtectionService.getCsrfTokenParameter()).thenReturn("ABC123");
    when(staleStateProtectionService.getStateVersionToken()).thenReturn(null);
    when(staleStateProtectionService.isEnabled()).thenReturn(true);
    HashMap<String, String> rootTagAttributes = new HashMap<>();

    BroadleafTemplateModel broadleafTemplateModel = mock(BroadleafTemplateModel.class);
    doNothing().when(broadleafTemplateModel).addElement(Mockito.<BroadleafTemplateElement>any());

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.createStandaloneElement(
            Mockito.<String>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(mock(BroadleafTemplateElement.class));
    when(context.createModel()).thenReturn(broadleafTemplateModel);

    // Act
    BroadleafTemplateModelModifierDTO actualInjectedModelAndTagAttributes =
        formProcessor.getInjectedModelAndTagAttributes("Root Tag Name", rootTagAttributes, context);

    // Assert
    verify(exploitProtectionService).getCSRFToken();
    verify(exploitProtectionService).getCsrfTokenParameter();
    verify(staleStateProtectionService).getStateVersionToken();
    verify(staleStateProtectionService).isEnabled();
    verify(context).createModel();
    verify(context).createStandaloneElement(eq("input"), isA(Map.class), eq(true));
    verify(broadleafTemplateModel).addElement(isA(BroadleafTemplateElement.class));
    assertEquals("form", actualInjectedModelAndTagAttributes.getReplacementTagName());
    assertTrue(actualInjectedModelAndTagAttributes.getFormLocalVariables().isEmpty());
    assertTrue(actualInjectedModelAndTagAttributes.getFormParameters().isEmpty());
  }

  /**
   * Test {@link FormProcessor#getInjectedModelAndTagAttributes(String, Map,
   * BroadleafTemplateContext)}.
   *
   * <p>Method under test: {@link FormProcessor#getInjectedModelAndTagAttributes(String, Map,
   * BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BroadleafTemplateModelModifierDTO FormProcessor.getInjectedModelAndTagAttributes(String, Map, BroadleafTemplateContext)"
  })
  public void testGetInjectedModelAndTagAttributes7() throws ServiceException {
    // Arrange
    when(exploitProtectionService.getCSRFToken()).thenReturn("ABC123");
    when(exploitProtectionService.getCsrfTokenParameter()).thenReturn("ABC123");
    when(staleStateProtectionService.isEnabled()).thenReturn(false);
    HashMap<String, String> rootTagAttributes = new HashMap<>();

    BroadleafTemplateModel broadleafTemplateModel = mock(BroadleafTemplateModel.class);
    doNothing().when(broadleafTemplateModel).addElement(Mockito.<BroadleafTemplateElement>any());

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.createStandaloneElement(
            Mockito.<String>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(mock(BroadleafTemplateElement.class));
    when(context.createModel()).thenReturn(broadleafTemplateModel);

    // Act
    BroadleafTemplateModelModifierDTO actualInjectedModelAndTagAttributes =
        formProcessor.getInjectedModelAndTagAttributes("Root Tag Name", rootTagAttributes, context);

    // Assert
    verify(exploitProtectionService).getCSRFToken();
    verify(exploitProtectionService).getCsrfTokenParameter();
    verify(staleStateProtectionService).isEnabled();
    verify(context).createModel();
    verify(context).createStandaloneElement(eq("input"), isA(Map.class), eq(true));
    verify(broadleafTemplateModel).addElement(isA(BroadleafTemplateElement.class));
    assertEquals("form", actualInjectedModelAndTagAttributes.getReplacementTagName());
    assertTrue(actualInjectedModelAndTagAttributes.getFormLocalVariables().isEmpty());
    assertTrue(actualInjectedModelAndTagAttributes.getFormParameters().isEmpty());
  }

  /**
   * Test {@link FormProcessor#getInjectedModelAndTagAttributes(String, Map,
   * BroadleafTemplateContext)}.
   *
   * <ul>
   *   <li>Given {@link FormProcessor} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link FormProcessor#getInjectedModelAndTagAttributes(String, Map,
   * BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BroadleafTemplateModelModifierDTO FormProcessor.getInjectedModelAndTagAttributes(String, Map, BroadleafTemplateContext)"
  })
  public void testGetInjectedModelAndTagAttributes_givenFormProcessor() {
    // Arrange
    FormProcessor formProcessor = new FormProcessor();
    HashMap<String, String> rootTagAttributes = new HashMap<>();

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.createModel()).thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            formProcessor.getInjectedModelAndTagAttributes(
                "Root Tag Name", rootTagAttributes, context));
    verify(context).createModel();
  }

  /**
   * Test {@link FormProcessor#reprocessModel()}.
   *
   * <p>Method under test: {@link FormProcessor#reprocessModel()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FormProcessor.reprocessModel()"})
  public void testReprocessModel() {
    // Arrange, Act and Assert
    assertTrue(new FormProcessor().reprocessModel());
  }
}
