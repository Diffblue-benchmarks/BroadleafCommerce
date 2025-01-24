/*-
 * #%L
 * BroadleafCommerce Common Libraries
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
package org.broadleafcommerce.common.extensibility.config;

import static org.junit.Assert.assertEquals;
import org.broadleafcommerce.common.resource.GeneratedResource;
import org.junit.Test;
import org.springframework.core.io.Resource;

public class PropertyConfigurerDiffblueTest {
  /**
   * Test {@link PropertyConfigurer#setLocation(Resource)}.
   * <ul>
   *   <li>When {@link GeneratedResource#GeneratedResource()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PropertyConfigurer#setLocation(Resource)}
   */
  @Test
  public void testSetLocation_whenGeneratedResource() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange
    PropertyConfigurer propertyConfigurer = new PropertyConfigurer();

    // Act
    propertyConfigurer.setLocation(new GeneratedResource());
  }

  /**
   * Test {@link PropertyConfigurer#setLocations(Resource[])}.
   * <ul>
   *   <li>When array of {@link Resource} with
   * {@link GeneratedResource#GeneratedResource()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PropertyConfigurer#setLocations(Resource[])}
   */
  @Test
  public void testSetLocations_whenArrayOfResourceWithGeneratedResource() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange
    PropertyConfigurer propertyConfigurer = new PropertyConfigurer();

    // Act
    propertyConfigurer.setLocations(new Resource[]{new GeneratedResource()});
  }

  /**
   * Test new {@link PropertyConfigurer} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link PropertyConfigurer}
   */
  @Test
  public void testNewPropertyConfigurer() {
    // Arrange, Act and Assert
    assertEquals(Integer.MAX_VALUE, (new PropertyConfigurer()).getOrder());
  }
}
