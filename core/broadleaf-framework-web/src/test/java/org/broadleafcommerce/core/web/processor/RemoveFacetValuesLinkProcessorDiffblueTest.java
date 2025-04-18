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
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.core.web.service.SearchFacetDTOService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class RemoveFacetValuesLinkProcessorDiffblueTest {
  @InjectMocks
  private RemoveFacetValuesLinkProcessor removeFacetValuesLinkProcessor;

  @Mock
  private SearchFacetDTOService searchFacetDTOService;

  /**
   * Test {@link RemoveFacetValuesLinkProcessor#getName()}.
   * <p>
   * Method under test: {@link RemoveFacetValuesLinkProcessor#getName()}
   */
  @Test
  @DisplayName("Test getName()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String RemoveFacetValuesLinkProcessor.getName()"})
  void testGetName() {
    // Arrange, Act and Assert
    assertEquals("removefacetvalueslink", (new RemoveFacetValuesLinkProcessor()).getName());
  }

  /**
   * Test {@link RemoveFacetValuesLinkProcessor#getPrecedence()}.
   * <p>
   * Method under test: {@link RemoveFacetValuesLinkProcessor#getPrecedence()}
   */
  @Test
  @DisplayName("Test getPrecedence()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int RemoveFacetValuesLinkProcessor.getPrecedence()"})
  void testGetPrecedence() {
    // Arrange, Act and Assert
    assertEquals(10000, removeFacetValuesLinkProcessor.getPrecedence());
  }
}
