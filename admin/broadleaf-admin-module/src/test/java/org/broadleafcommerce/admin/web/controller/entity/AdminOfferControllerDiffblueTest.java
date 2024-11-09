/*-
 * #%L
 * BroadleafCommerce Admin Module
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
package org.broadleafcommerce.admin.web.controller.entity;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.ui.ConcurrentModel;
import org.springframework.ui.Model;

public class AdminOfferControllerDiffblueTest {
  /**
   * Test {@link AdminOfferController#getSectionKey(Map)}.
   * <ul>
   *   <li>Given {@link BiFunction}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminOfferController#getSectionKey(Map)}
   */
  @Test
  public void testGetSectionKey_givenBiFunction() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminOfferController adminOfferController = new AdminOfferController();

    HashMap<String, String> pathVars = new HashMap<>();
    pathVars.computeIfPresent("sectionKey", mock(BiFunction.class));
    pathVars.put("sectionKey", "sectionKey");

    // Act and Assert
    assertEquals("sectionKey", adminOfferController.getSectionKey(pathVars));
  }

  /**
   * Test {@link AdminOfferController#getSectionKey(Map)}.
   * <ul>
   *   <li>Given {@code sectionKey}.</li>
   *   <li>Then return {@code sectionKey}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminOfferController#getSectionKey(Map)}
   */
  @Test
  public void testGetSectionKey_givenSectionKey_thenReturnSectionKey() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminOfferController adminOfferController = new AdminOfferController();

    HashMap<String, String> pathVars = new HashMap<>();
    pathVars.put("sectionKey", "sectionKey");

    // Act and Assert
    assertEquals("sectionKey", adminOfferController.getSectionKey(pathVars));
  }

  /**
   * Test {@link AdminOfferController#getSectionKey(Map)}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.</li>
   *   <li>Then return {@link AdminOfferController#SECTION_KEY}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminOfferController#getSectionKey(Map)}
   */
  @Test
  public void testGetSectionKey_whenHashMap_thenReturnSection_key() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminOfferController adminOfferController = new AdminOfferController();

    // Act and Assert
    assertEquals(AdminOfferController.SECTION_KEY, adminOfferController.getSectionKey(new HashMap<>()));
  }

  /**
   * Test {@link AdminOfferController#getSectionCustomCriteria()}.
   * <p>
   * Method under test: {@link AdminOfferController#getSectionCustomCriteria()}
   */
  @Test
  public void testGetSectionCustomCriteria() {
    // Arrange, Act and Assert
    assertEquals(0, (new AdminOfferController()).getSectionCustomCriteria().length);
  }

  /**
   * Test {@link AdminOfferController#modifyModelAttributes(Model)}.
   * <ul>
   *   <li>Given {@link Function} {@link Function#apply(Object)} return
   * {@code Apply}.</li>
   *   <li>Then calls {@link Function#apply(Object)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminOfferController#modifyModelAttributes(Model)}
   */
  @Test
  public void testModifyModelAttributes_givenFunctionApplyReturnApply_thenCallsApply() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminOfferController adminOfferController = new AdminOfferController();
    Function<String, Object> function = mock(Function.class);
    when(function.apply(Mockito.<String>any())).thenReturn("Apply");

    ConcurrentModel model = new ConcurrentModel();
    model.computeIfAbsent("additionalControllerClasses", function);

    // Act
    adminOfferController.modifyModelAttributes(model);

    // Assert that nothing has changed
    verify(function).apply(eq("additionalControllerClasses"));
    assertEquals(1, model.size());
    assertEquals("offer-form", model.get("additionalControllerClasses"));
  }

  /**
   * Test {@link AdminOfferController#modifyModelAttributes(Model)}.
   * <ul>
   *   <li>When {@link ConcurrentModel#ConcurrentModel()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminOfferController#modifyModelAttributes(Model)}
   */
  @Test
  public void testModifyModelAttributes_whenConcurrentModel() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminOfferController adminOfferController = new AdminOfferController();
    ConcurrentModel model = new ConcurrentModel();

    // Act
    adminOfferController.modifyModelAttributes(model);

    // Assert that nothing has changed
    assertEquals(1, model.size());
    assertEquals("offer-form", model.get("additionalControllerClasses"));
  }
}
