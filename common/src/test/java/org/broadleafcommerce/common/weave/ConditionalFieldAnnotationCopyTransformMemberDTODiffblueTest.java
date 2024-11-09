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
package org.broadleafcommerce.common.weave;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import org.junit.Test;

public class ConditionalFieldAnnotationCopyTransformMemberDTODiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link ConditionalFieldAnnotationCopyTransformMemberDTO}
   *   <li>
   * {@link ConditionalFieldAnnotationCopyTransformMemberDTO#setConditionalProperty(String)}
   *   <li>
   * {@link ConditionalFieldAnnotationCopyTransformMemberDTO#setTemplateNames(String[])}
   *   <li>
   * {@link ConditionalFieldAnnotationCopyTransformMemberDTO#getConditionalProperty()}
   *   <li>
   * {@link ConditionalFieldAnnotationCopyTransformMemberDTO#getTemplateNames()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    ConditionalFieldAnnotationCopyTransformMemberDTO actualConditionalFieldAnnotationCopyTransformMemberDTO = new ConditionalFieldAnnotationCopyTransformMemberDTO();
    actualConditionalFieldAnnotationCopyTransformMemberDTO.setConditionalProperty("Property Name");
    String[] templateNames = new String[]{"Template Names"};
    actualConditionalFieldAnnotationCopyTransformMemberDTO.setTemplateNames(templateNames);
    String actualConditionalProperty = actualConditionalFieldAnnotationCopyTransformMemberDTO.getConditionalProperty();
    String[] actualTemplateNames = actualConditionalFieldAnnotationCopyTransformMemberDTO.getTemplateNames();

    // Assert that nothing has changed
    assertEquals("Property Name", actualConditionalProperty);
    assertSame(templateNames, actualTemplateNames);
    assertArrayEquals(new String[]{"Template Names"}, actualTemplateNames);
  }
}
