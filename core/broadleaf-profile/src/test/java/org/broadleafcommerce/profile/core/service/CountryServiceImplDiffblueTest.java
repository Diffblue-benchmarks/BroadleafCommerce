package org.broadleafcommerce.profile.core.service;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.broadleafcommerce.profile.core.dao.CountryDao;
import org.broadleafcommerce.profile.core.domain.Country;
import org.broadleafcommerce.profile.core.domain.CountryImpl;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CountryServiceImplDiffblueTest {
  @Mock private CountryDao countryDao;

  @InjectMocks private CountryServiceImpl countryServiceImpl;

  /**
   * Test {@link CountryServiceImpl#findCountries()}.
   *
   * <p>Method under test: {@link CountryServiceImpl#findCountries()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List CountryServiceImpl.findCountries()"})
  public void testFindCountries() {
    // Arrange
    when(countryDao.findCountries()).thenReturn(new ArrayList<>());

    // Act
    List<Country> actualFindCountriesResult = countryServiceImpl.findCountries();

    // Assert
    verify(countryDao).findCountries();
    assertTrue(actualFindCountriesResult.isEmpty());
  }

  /**
   * Test {@link CountryServiceImpl#findCountryByAbbreviation(String)}.
   *
   * <p>Method under test: {@link CountryServiceImpl#findCountryByAbbreviation(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Country CountryServiceImpl.findCountryByAbbreviation(String)"})
  public void testFindCountryByAbbreviation() {
    // Arrange
    CountryImpl countryImpl = new CountryImpl();
    when(countryDao.findCountryByAbbreviation(Mockito.<String>any())).thenReturn(countryImpl);

    // Act
    Country actualFindCountryByAbbreviationResult =
        countryServiceImpl.findCountryByAbbreviation("Abbreviation");

    // Assert
    verify(countryDao).findCountryByAbbreviation("Abbreviation");
    assertSame(countryImpl, actualFindCountryByAbbreviationResult);
  }

  /**
   * Test {@link CountryServiceImpl#save(Country)}.
   *
   * <p>Method under test: {@link CountryServiceImpl#save(Country)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Country CountryServiceImpl.save(Country)"})
  public void testSave() {
    // Arrange
    CountryImpl countryImpl = new CountryImpl();
    when(countryDao.save(Mockito.<Country>any())).thenReturn(countryImpl);

    // Act
    Country actualSaveResult = countryServiceImpl.save(new CountryImpl());

    // Assert
    verify(countryDao).save(isA(Country.class));
    assertSame(countryImpl, actualSaveResult);
  }
}
