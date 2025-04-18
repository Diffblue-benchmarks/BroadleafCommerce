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
package org.broadleafcommerce.core.web.expression;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.broadleafcommerce.common.i18n.domain.ISOCountry;
import org.broadleafcommerce.common.i18n.domain.ISOCountryImpl;
import org.broadleafcommerce.profile.core.domain.Country;
import org.broadleafcommerce.profile.core.domain.CountrySubdivision;
import org.broadleafcommerce.profile.core.domain.State;
import org.broadleafcommerce.profile.core.service.CountryService;
import org.broadleafcommerce.profile.core.service.CountrySubdivisionService;
import org.broadleafcommerce.profile.core.service.StateService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class BasicAddressVariableExpressionDiffblueTest {
  @InjectMocks
  private BasicAddressVariableExpression basicAddressVariableExpression;

  @Mock
  private CountryService countryService;

  @Mock
  private CountrySubdivisionService countrySubdivisionService;

  @Mock
  private StateService stateService;

  /**
   * Test {@link BasicAddressVariableExpression#getName()}.
   * <p>
   * Method under test: {@link BasicAddressVariableExpression#getName()}
   */
  @Test
  @DisplayName("Test getName()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String BasicAddressVariableExpression.getName()"})
  void testGetName() {
    // Arrange, Act and Assert
    assertEquals("address", (new BasicAddressVariableExpression()).getName());
  }

  /**
   * Test {@link BasicAddressVariableExpression#getStateOptions()}.
   * <p>
   * Method under test: {@link BasicAddressVariableExpression#getStateOptions()}
   */
  @Test
  @DisplayName("Test getStateOptions()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List BasicAddressVariableExpression.getStateOptions()"})
  void testGetStateOptions() {
    // Arrange
    when(stateService.findStates()).thenReturn(new ArrayList<>());

    // Act
    List<State> actualStateOptions = basicAddressVariableExpression.getStateOptions();

    // Assert
    verify(stateService).findStates();
    assertTrue(actualStateOptions.isEmpty());
  }

  /**
   * Test {@link BasicAddressVariableExpression#getCountrySubOptionsByISOCountry(ISOCountry)}.
   * <ul>
   *   <li>Given {@link CountrySubdivisionService}.</li>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicAddressVariableExpression#getCountrySubOptionsByISOCountry(ISOCountry)}
   */
  @Test
  @DisplayName("Test getCountrySubOptionsByISOCountry(ISOCountry); given CountrySubdivisionService; when 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List BasicAddressVariableExpression.getCountrySubOptionsByISOCountry(ISOCountry)"})
  void testGetCountrySubOptionsByISOCountry_givenCountrySubdivisionService_whenNull() {
    // Arrange, Act and Assert
    assertTrue(basicAddressVariableExpression.getCountrySubOptionsByISOCountry(null).isEmpty());
  }

  /**
   * Test {@link BasicAddressVariableExpression#getCountrySubOptionsByISOCountry(ISOCountry)}.
   * <ul>
   *   <li>Then calls {@link CountrySubdivisionService#findSubdivisions(String)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicAddressVariableExpression#getCountrySubOptionsByISOCountry(ISOCountry)}
   */
  @Test
  @DisplayName("Test getCountrySubOptionsByISOCountry(ISOCountry); then calls findSubdivisions(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List BasicAddressVariableExpression.getCountrySubOptionsByISOCountry(ISOCountry)"})
  void testGetCountrySubOptionsByISOCountry_thenCallsFindSubdivisions() {
    // Arrange
    when(countrySubdivisionService.findSubdivisions(Mockito.<String>any())).thenReturn(new ArrayList<>());

    // Act
    List<CountrySubdivision> actualCountrySubOptionsByISOCountry = basicAddressVariableExpression
        .getCountrySubOptionsByISOCountry(new ISOCountryImpl());

    // Assert
    verify(countrySubdivisionService).findSubdivisions(isNull());
    assertTrue(actualCountrySubOptionsByISOCountry.isEmpty());
  }

  /**
   * Test {@link BasicAddressVariableExpression#getCountrySubOptionsByCountryAbbrev(String)}.
   * <p>
   * Method under test: {@link BasicAddressVariableExpression#getCountrySubOptionsByCountryAbbrev(String)}
   */
  @Test
  @DisplayName("Test getCountrySubOptionsByCountryAbbrev(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List BasicAddressVariableExpression.getCountrySubOptionsByCountryAbbrev(String)"})
  void testGetCountrySubOptionsByCountryAbbrev() {
    // Arrange
    when(countrySubdivisionService.findSubdivisions(Mockito.<String>any())).thenReturn(new ArrayList<>());

    // Act
    List<CountrySubdivision> actualCountrySubOptionsByCountryAbbrev = basicAddressVariableExpression
        .getCountrySubOptionsByCountryAbbrev("GB");

    // Assert
    verify(countrySubdivisionService).findSubdivisions(eq("GB"));
    assertTrue(actualCountrySubOptionsByCountryAbbrev.isEmpty());
  }

  /**
   * Test {@link BasicAddressVariableExpression#getCountryOptions()}.
   * <p>
   * Method under test: {@link BasicAddressVariableExpression#getCountryOptions()}
   */
  @Test
  @DisplayName("Test getCountryOptions()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List BasicAddressVariableExpression.getCountryOptions()"})
  void testGetCountryOptions() {
    // Arrange
    when(countryService.findCountries()).thenReturn(new ArrayList<>());

    // Act
    List<Country> actualCountryOptions = basicAddressVariableExpression.getCountryOptions();

    // Assert
    verify(countryService).findCountries();
    assertTrue(actualCountryOptions.isEmpty());
  }
}
