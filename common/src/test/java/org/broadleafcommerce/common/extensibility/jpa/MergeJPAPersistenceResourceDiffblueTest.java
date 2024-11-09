/*-
 * #%L
 * BroadleafCommerce Common Libraries
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
package org.broadleafcommerce.common.extensibility.jpa;

import static org.junit.Assert.assertThrows;
import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;
import org.broadleafcommerce.common.extensibility.context.merge.ResourceInputStream;
import org.junit.Test;
import org.springframework.beans.BeansException;
import org.springframework.beans.FatalBeanException;

public class MergeJPAPersistenceResourceDiffblueTest {
  /**
   * Test
   * {@link MergeJPAPersistenceResource#getMergedConfigResource(ResourceInputStream[])}.
   * <p>
   * Method under test:
   * {@link MergeJPAPersistenceResource#getMergedConfigResource(ResourceInputStream[])}
   */
  @Test
  public void testGetMergedConfigResource() throws UnsupportedEncodingException, BeansException {
    // Arrange
    MergeJPAPersistenceResource mergeJPAPersistenceResource = new MergeJPAPersistenceResource();

    // Act and Assert
    assertThrows(FatalBeanException.class,
        () -> mergeJPAPersistenceResource.getMergedConfigResource(new ResourceInputStream[]{
            new ResourceInputStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")), "Name")}));
  }
}
