package org.broadleafcommerce.core.web.processor;

import static org.junit.Assert.assertEquals;
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
import java.util.Map;
import org.broadleafcommerce.presentation.model.BroadleafTemplateContext;
import org.broadleafcommerce.presentation.model.BroadleafTemplateElement;
import org.broadleafcommerce.presentation.model.BroadleafTemplateModel;
import org.broadleafcommerce.presentation.model.BroadleafTemplateNonVoidElement;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {GoogleTagManagerProcessor.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class GoogleTagManagerProcessorDiffblueTest {
  @MockBean private Environment environment;

  @Autowired private GoogleTagManagerProcessor googleTagManagerProcessor;

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link GoogleTagManagerProcessor#getName()}
   *   <li>{@link GoogleTagManagerProcessor#getPrecedence()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String GoogleTagManagerProcessor.getName()",
    "int GoogleTagManagerProcessor.getPrecedence()"
  })
  public void testGettersAndSetters() {
    // Arrange
    GoogleTagManagerProcessor googleTagManagerProcessor = new GoogleTagManagerProcessor();

    // Act
    String actualName = googleTagManagerProcessor.getName();

    // Assert
    assertEquals("google_tag_manager", actualName);
    assertEquals(0, googleTagManagerProcessor.getPrecedence());
  }

  /**
   * Test {@link GoogleTagManagerProcessor#getReplacementModel(String, Map,
   * BroadleafTemplateContext)}.
   *
   * <ul>
   *   <li>Given {@link Environment} {@link Environment#getProperty(String)} return empty string.
   * </ul>
   *
   * <p>Method under test: {@link GoogleTagManagerProcessor#getReplacementModel(String, Map,
   * BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BroadleafTemplateModel GoogleTagManagerProcessor.getReplacementModel(String, Map, BroadleafTemplateContext)"
  })
  public void testGetReplacementModel_givenEnvironmentGetPropertyReturnEmptyString() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any())).thenReturn("");
    HashMap<String, String> tagAttributes = new HashMap<>();

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.createModel()).thenReturn(mock(BroadleafTemplateModel.class));

    // Act
    googleTagManagerProcessor.getReplacementModel("Tag Name", tagAttributes, context);

    // Assert
    verify(context).createModel();
    verify(environment).getProperty("googleTagManager.accountId");
  }

  /**
   * Test {@link GoogleTagManagerProcessor#getReplacementModel(String, Map,
   * BroadleafTemplateContext)}.
   *
   * <ul>
   *   <li>Then calls {@link BroadleafTemplateContext#createNonVoidElement(String)}.
   * </ul>
   *
   * <p>Method under test: {@link GoogleTagManagerProcessor#getReplacementModel(String, Map,
   * BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BroadleafTemplateModel GoogleTagManagerProcessor.getReplacementModel(String, Map, BroadleafTemplateContext)"
  })
  public void testGetReplacementModel_thenCallsCreateNonVoidElement() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any())).thenReturn("Property");
    HashMap<String, String> tagAttributes = new HashMap<>();

    BroadleafTemplateModel broadleafTemplateModel = mock(BroadleafTemplateModel.class);
    doNothing().when(broadleafTemplateModel).addElement(Mockito.<BroadleafTemplateElement>any());

    BroadleafTemplateNonVoidElement broadleafTemplateNonVoidElement =
        mock(BroadleafTemplateNonVoidElement.class);
    doNothing()
        .when(broadleafTemplateNonVoidElement)
        .addChild(Mockito.<BroadleafTemplateElement>any());

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.createTextElement(Mockito.<String>any()))
        .thenReturn(mock(BroadleafTemplateElement.class));
    when(context.createNonVoidElement(Mockito.<String>any()))
        .thenReturn(broadleafTemplateNonVoidElement);
    when(context.createModel()).thenReturn(broadleafTemplateModel);

    // Act
    googleTagManagerProcessor.getReplacementModel("Tag Name", tagAttributes, context);

    // Assert
    verify(context).createModel();
    verify(context).createNonVoidElement("script");
    verify(context)
        .createTextElement(
            "dataLayer = [];(function(w,d,s,l,i){w[l]=w[l]||[];w[l].push({'gtm.start':new Date().getTime(),event:'gtm.js'});var f=d.getElementsByTagName(s)[0],j=d.createElement(s),dl=l!='dataLayer'?'&l='+l:'';j.async=true;j.src='https://www.googletagmanager.com/gtm.js?id='+i+dl;f.parentNode.insertBefore(j,f);})(window,document,'script','dataLayer','Property');");
    verify(broadleafTemplateModel).addElement(isA(BroadleafTemplateElement.class));
    verify(broadleafTemplateNonVoidElement).addChild(isA(BroadleafTemplateElement.class));
    verify(environment, atLeast(1)).getProperty("googleTagManager.accountId");
  }
}
