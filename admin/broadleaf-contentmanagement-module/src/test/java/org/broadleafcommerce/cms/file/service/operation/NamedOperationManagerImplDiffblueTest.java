/*-
 * #%L
 * BroadleafCommerce CMS Module
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
package org.broadleafcommerce.cms.file.service.operation;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Test;
import org.mockito.Mockito;

public class NamedOperationManagerImplDiffblueTest {
  /**
   * Test {@link NamedOperationManagerImpl#manageNamedParameters(Map)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code foo}.</li>
   *   <li>Then calls
   * {@link NamedOperationComponent#setOperationValues(Map, Map)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link NamedOperationManagerImpl#manageNamedParameters(Map)}
   */
  @Test
  public void testManageNamedParameters_givenArrayListAddFoo_thenCallsSetOperationValues() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ArrayList<String> stringList = new ArrayList<>();
    stringList.add("foo");
    NamedOperationComponent namedOperationComponent = mock(NamedOperationComponent.class);
    when(namedOperationComponent.setOperationValues(Mockito.<Map<String, String>>any(),
        Mockito.<Map<String, String>>any())).thenReturn(stringList);

    ArrayList<NamedOperationComponent> namedOperationComponents = new ArrayList<>();
    namedOperationComponents.add(namedOperationComponent);

    NamedOperationManagerImpl namedOperationManagerImpl = new NamedOperationManagerImpl();
    namedOperationManagerImpl.setNamedOperationComponents(namedOperationComponents);

    // Act
    Map<String, String> actualManageNamedParametersResult = namedOperationManagerImpl
        .manageNamedParameters(new HashMap<>());

    // Assert
    verify(namedOperationComponent).setOperationValues(isA(Map.class), isA(Map.class));
    assertTrue(actualManageNamedParametersResult.isEmpty());
  }

  /**
   * Test {@link NamedOperationManagerImpl#manageNamedParameters(Map)}.
   * <ul>
   *   <li>Given {@link NamedOperationManagerImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link NamedOperationManagerImpl#manageNamedParameters(Map)}
   */
  @Test
  public void testManageNamedParameters_givenNamedOperationManagerImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    NamedOperationManagerImpl namedOperationManagerImpl = new NamedOperationManagerImpl();

    // Act and Assert
    assertTrue(namedOperationManagerImpl.manageNamedParameters(new HashMap<>()).isEmpty());
  }

  /**
   * Test {@link NamedOperationManagerImpl#manageNamedParameters(Map)}.
   * <ul>
   *   <li>Then calls
   * {@link NamedOperationComponent#setOperationValues(Map, Map)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link NamedOperationManagerImpl#manageNamedParameters(Map)}
   */
  @Test
  public void testManageNamedParameters_thenCallsSetOperationValues() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    NamedOperationComponent namedOperationComponent = mock(NamedOperationComponent.class);
    when(namedOperationComponent.setOperationValues(Mockito.<Map<String, String>>any(),
        Mockito.<Map<String, String>>any())).thenReturn(new ArrayList<>());

    ArrayList<NamedOperationComponent> namedOperationComponents = new ArrayList<>();
    namedOperationComponents.add(namedOperationComponent);

    NamedOperationManagerImpl namedOperationManagerImpl = new NamedOperationManagerImpl();
    namedOperationManagerImpl.setNamedOperationComponents(namedOperationComponents);

    // Act
    Map<String, String> actualManageNamedParametersResult = namedOperationManagerImpl
        .manageNamedParameters(new HashMap<>());

    // Assert
    verify(namedOperationComponent).setOperationValues(isA(Map.class), isA(Map.class));
    assertTrue(actualManageNamedParametersResult.isEmpty());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link NamedOperationManagerImpl}
   *   <li>{@link NamedOperationManagerImpl#setNamedOperationComponents(List)}
   *   <li>{@link NamedOperationManagerImpl#getNamedOperationComponents()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    NamedOperationManagerImpl actualNamedOperationManagerImpl = new NamedOperationManagerImpl();
    ArrayList<NamedOperationComponent> namedOperationComponents = new ArrayList<>();
    actualNamedOperationManagerImpl.setNamedOperationComponents(namedOperationComponents);
    List<NamedOperationComponent> actualNamedOperationComponents = actualNamedOperationManagerImpl
        .getNamedOperationComponents();

    // Assert that nothing has changed
    assertTrue(actualNamedOperationComponents.isEmpty());
    assertSame(namedOperationComponents, actualNamedOperationComponents);
  }
}
