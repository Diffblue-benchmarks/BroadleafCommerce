/*-
 * #%L
 * BroadleafCommerce Framework Web
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
package org.broadleafcommerce.core.web.service;

import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import java.beans.PropertyEditor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.validation.DataBinder;
import org.springframework.web.bind.ServletRequestDataBinder;

class InitBinderServiceImplDiffblueTest {
  /**
   * Test
   * {@link InitBinderServiceImpl#configAddressInitBinder(ServletRequestDataBinder)}.
   * <ul>
   *   <li>Then calls
   * {@link DataBinder#registerCustomEditor(Class, String, PropertyEditor)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link InitBinderServiceImpl#configAddressInitBinder(ServletRequestDataBinder)}
   */
  @Test
  @DisplayName("Test configAddressInitBinder(ServletRequestDataBinder); then calls registerCustomEditor(Class, String, PropertyEditor)")
  void testConfigAddressInitBinder_thenCallsRegisterCustomEditor() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    InitBinderServiceImpl initBinderServiceImpl = new InitBinderServiceImpl();
    ServletRequestDataBinder binder = mock(ServletRequestDataBinder.class);
    doNothing().when(binder)
        .registerCustomEditor(Mockito.<Class<Object>>any(), Mockito.<String>any(), Mockito.<PropertyEditor>any());

    // Act
    initBinderServiceImpl.configAddressInitBinder(binder);

    // Assert
    verify(binder, atLeast(1)).registerCustomEditor(Mockito.<Class<Object>>any(), Mockito.<String>any(),
        Mockito.<PropertyEditor>any());
  }
}
