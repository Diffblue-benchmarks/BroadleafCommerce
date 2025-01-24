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
package org.broadleafcommerce.common.util.tenant;

import static org.junit.Assert.assertSame;
import org.broadleafcommerce.common.site.domain.Site;
import org.broadleafcommerce.common.site.domain.SiteImpl;
import org.junit.Ignore;
import org.junit.Test;

public class IdentityUtilContextDiffblueTest {
  /**
   * Test {@link IdentityUtilContext#getUtilContext()}.
   * <p>
   * Method under test: {@link IdentityUtilContext#getUtilContext()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetUtilContext() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.util.EmptyStackException
    //       at java.base/java.util.Stack.peek(Stack.java:102)
    //       at org.broadleafcommerce.common.util.tenant.IdentityUtilContext.getUtilContext(IdentityUtilContext.java:41)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange and Act
    IdentityUtilContext.getUtilContext();
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link IdentityUtilContext}
   *   <li>{@link IdentityUtilContext#setIdentifier(Site)}
   *   <li>{@link IdentityUtilContext#getIdentifier()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    IdentityUtilContext actualIdentityUtilContext = new IdentityUtilContext();
    SiteImpl identifier = new SiteImpl();
    actualIdentityUtilContext.setIdentifier(identifier);

    // Assert that nothing has changed
    assertSame(identifier, actualIdentityUtilContext.getIdentifier());
  }
}
