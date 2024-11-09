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
package org.broadleafcommerce.openadmin.server.service.artifact.image;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import org.broadleafcommerce.openadmin.server.service.artifact.image.effects.chain.UnmarshalledParameter;
import org.junit.Test;

public class OperationDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link Operation}
   *   <li>{@link Operation#setFactor(Double)}
   *   <li>{@link Operation#setName(String)}
   *   <li>{@link Operation#setParameters(UnmarshalledParameter[])}
   *   <li>{@link Operation#getFactor()}
   *   <li>{@link Operation#getName()}
   *   <li>{@link Operation#getParameters()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    Operation actualOperation = new Operation();
    actualOperation.setFactor(10.0d);
    actualOperation.setName("Name");
    UnmarshalledParameter unmarshalledParameter = new UnmarshalledParameter();
    unmarshalledParameter.setApplyFactor(true);
    unmarshalledParameter.setName("Name");
    unmarshalledParameter.setType("Type");
    unmarshalledParameter.setValue("42");
    UnmarshalledParameter[] parameters = new UnmarshalledParameter[]{unmarshalledParameter};
    actualOperation.setParameters(parameters);
    Double actualFactor = actualOperation.getFactor();
    String actualName = actualOperation.getName();
    UnmarshalledParameter[] actualParameters = actualOperation.getParameters();

    // Assert that nothing has changed
    assertEquals("Name", actualName);
    assertEquals(10.0d, actualFactor.doubleValue(), 0.0);
    assertSame(parameters, actualParameters);
  }
}
