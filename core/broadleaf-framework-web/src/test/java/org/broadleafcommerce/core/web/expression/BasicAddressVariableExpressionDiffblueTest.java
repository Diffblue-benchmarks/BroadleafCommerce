package org.broadleafcommerce.core.web.expression;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
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
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class BasicAddressVariableExpressionDiffblueTest {
  @InjectMocks private BasicAddressVariableExpression basicAddressVariableExpression;

  @Mock private CountryService countryService;

  @Mock private CountrySubdivisionService countrySubdivisionService;

  @Mock private StateService stateService;

  /**
   * Test {@link BasicAddressVariableExpression#getName()}.
   *
   * <p>Method under test: {@link BasicAddressVariableExpression#getName()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BasicAddressVariableExpression.getName()"})
  public void testGetName() {
    // Arrange, Act and Assert
    assertEquals("address", new BasicAddressVariableExpression().getName());
  }

  /**
   * Test {@link BasicAddressVariableExpression#getStateOptions()}.
   *
   * <p>Method under test: {@link BasicAddressVariableExpression#getStateOptions()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List BasicAddressVariableExpression.getStateOptions()"})
  public void testGetStateOptions() {
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
   *
   * <ul>
   *   <li>Given {@link BasicAddressVariableExpression} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * BasicAddressVariableExpression#getCountrySubOptionsByISOCountry(ISOCountry)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List BasicAddressVariableExpression.getCountrySubOptionsByISOCountry(ISOCountry)"
  })
  public void testGetCountrySubOptionsByISOCountry_givenBasicAddressVariableExpression() {
    // Arrange, Act and Assert
    assertTrue(
        new BasicAddressVariableExpression().getCountrySubOptionsByISOCountry(null).isEmpty());
  }

  /**
   * Test {@link BasicAddressVariableExpression#getCountrySubOptionsByISOCountry(ISOCountry)}.
   *
   * <ul>
   *   <li>Then calls {@link CountrySubdivisionService#findSubdivisions(String)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * BasicAddressVariableExpression#getCountrySubOptionsByISOCountry(ISOCountry)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List BasicAddressVariableExpression.getCountrySubOptionsByISOCountry(ISOCountry)"
  })
  public void testGetCountrySubOptionsByISOCountry_thenCallsFindSubdivisions() {
    // Arrange
    when(countrySubdivisionService.findSubdivisions(Mockito.<String>any()))
        .thenReturn(new ArrayList<>());

    // Act
    List<CountrySubdivision> actualCountrySubOptionsByISOCountry =
        basicAddressVariableExpression.getCountrySubOptionsByISOCountry(new ISOCountryImpl());

    // Assert
    verify(countrySubdivisionService).findSubdivisions(null);
    assertTrue(actualCountrySubOptionsByISOCountry.isEmpty());
  }

  /**
   * Test {@link BasicAddressVariableExpression#getCountrySubOptionsByCountryAbbrev(String)}.
   *
   * <p>Method under test: {@link
   * BasicAddressVariableExpression#getCountrySubOptionsByCountryAbbrev(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List BasicAddressVariableExpression.getCountrySubOptionsByCountryAbbrev(String)"
  })
  public void testGetCountrySubOptionsByCountryAbbrev() {
    // Arrange
    when(countrySubdivisionService.findSubdivisions(Mockito.<String>any()))
        .thenReturn(new ArrayList<>());

    // Act
    List<CountrySubdivision> actualCountrySubOptionsByCountryAbbrev =
        basicAddressVariableExpression.getCountrySubOptionsByCountryAbbrev("GB");

    // Assert
    verify(countrySubdivisionService).findSubdivisions("GB");
    assertTrue(actualCountrySubOptionsByCountryAbbrev.isEmpty());
  }

  /**
   * Test {@link BasicAddressVariableExpression#getCountryOptions()}.
   *
   * <p>Method under test: {@link BasicAddressVariableExpression#getCountryOptions()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List BasicAddressVariableExpression.getCountryOptions()"})
  public void testGetCountryOptions() {
    // Arrange
    when(countryService.findCountries()).thenReturn(new ArrayList<>());

    // Act
    List<Country> actualCountryOptions = basicAddressVariableExpression.getCountryOptions();

    // Assert
    verify(countryService).findCountries();
    assertTrue(actualCountryOptions.isEmpty());
  }
}
