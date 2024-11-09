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
package org.broadleafcommerce.openadmin.web.service;

import static org.junit.Assert.assertNull;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

public class MediaBuilderServiceImplDiffblueTest {
  /**
   * Test {@link MediaBuilderServiceImpl#convertJsonToMedia(String, Class)}.
   * <ul>
   *   <li>When {@link ObjectMapper#ObjectMapper()} writeValueAsString
   * {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MediaBuilderServiceImpl#convertJsonToMedia(String, Class)}
   */
  @Test
  public void testConvertJsonToMedia_whenObjectMapperWriteValueAsStringNull_thenReturnNull()
      throws JsonProcessingException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MediaBuilderServiceImpl mediaBuilderServiceImpl = new MediaBuilderServiceImpl();
    String json = (new ObjectMapper()).writeValueAsString(null);
    Class<Object> type = Object.class;

    // Act and Assert
    assertNull(mediaBuilderServiceImpl.convertJsonToMedia(json, type));
  }
}
