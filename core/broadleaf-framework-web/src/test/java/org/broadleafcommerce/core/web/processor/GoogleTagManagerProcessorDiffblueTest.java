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
package org.broadleafcommerce.core.web.processor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Map;
import org.broadleafcommerce.presentation.model.BroadleafTemplateContext;
import org.broadleafcommerce.presentation.model.BroadleafTemplateElement;
import org.broadleafcommerce.presentation.model.BroadleafTemplateModel;
import org.broadleafcommerce.presentation.model.BroadleafTemplateNonVoidElement;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {GoogleTagManagerProcessor.class})
@ExtendWith(SpringExtension.class)
class GoogleTagManagerProcessorDiffblueTest {
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
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String GoogleTagManagerProcessor.getName()",
    "int GoogleTagManagerProcessor.getPrecedence()"
  })
  void testGettersAndSetters() {
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
  @DisplayName(
      "Test getReplacementModel(String, Map, BroadleafTemplateContext); given Environment getProperty(String) return empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BroadleafTemplateModel GoogleTagManagerProcessor.getReplacementModel(String, Map, BroadleafTemplateContext)"
  })
  void testGetReplacementModel_givenEnvironmentGetPropertyReturnEmptyString() {
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
  @DisplayName(
      "Test getReplacementModel(String, Map, BroadleafTemplateContext); then calls createNonVoidElement(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BroadleafTemplateModel GoogleTagManagerProcessor.getReplacementModel(String, Map, BroadleafTemplateContext)"
  })
  void testGetReplacementModel_thenCallsCreateNonVoidElement() {
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
