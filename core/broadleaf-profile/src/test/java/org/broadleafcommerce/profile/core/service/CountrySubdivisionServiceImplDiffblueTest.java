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
import org.broadleafcommerce.profile.core.dao.CountrySubdivisionDao;
import org.broadleafcommerce.profile.core.domain.CountrySubdivision;
import org.broadleafcommerce.profile.core.domain.CountrySubdivisionImpl;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CountrySubdivisionServiceImplDiffblueTest {
  @Mock private CountrySubdivisionDao countrySubdivisionDao;

  @InjectMocks private CountrySubdivisionServiceImpl countrySubdivisionServiceImpl;

  /**
   * Test {@link CountrySubdivisionServiceImpl#findSubdivisions()}.
   *
   * <p>Method under test: {@link CountrySubdivisionServiceImpl#findSubdivisions()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List CountrySubdivisionServiceImpl.findSubdivisions()"})
  public void testFindSubdivisions() {
    // Arrange
    when(countrySubdivisionDao.findSubdivisions()).thenReturn(new ArrayList<>());

    // Act
    List<CountrySubdivision> actualFindSubdivisionsResult =
        countrySubdivisionServiceImpl.findSubdivisions();

    // Assert
    verify(countrySubdivisionDao).findSubdivisions();
    assertTrue(actualFindSubdivisionsResult.isEmpty());
  }

  /**
   * Test {@link CountrySubdivisionServiceImpl#findSubdivisions(String)} with {@code String}.
   *
   * <p>Method under test: {@link CountrySubdivisionServiceImpl#findSubdivisions(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List CountrySubdivisionServiceImpl.findSubdivisions(String)"})
  public void testFindSubdivisionsWithString() {
    // Arrange
    when(countrySubdivisionDao.findSubdivisions(Mockito.<String>any()))
        .thenReturn(new ArrayList<>());

    // Act
    List<CountrySubdivision> actualFindSubdivisionsResult =
        countrySubdivisionServiceImpl.findSubdivisions("GB");

    // Assert
    verify(countrySubdivisionDao).findSubdivisions("GB");
    assertTrue(actualFindSubdivisionsResult.isEmpty());
  }

  /**
   * Test {@link CountrySubdivisionServiceImpl#findSubdivisionsByCountryAndCategory(String,
   * String)}.
   *
   * <p>Method under test: {@link
   * CountrySubdivisionServiceImpl#findSubdivisionsByCountryAndCategory(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List CountrySubdivisionServiceImpl.findSubdivisionsByCountryAndCategory(String, String)"
  })
  public void testFindSubdivisionsByCountryAndCategory() {
    // Arrange
    when(countrySubdivisionDao.findSubdivisionsByCountryAndCategory(
            Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn(new ArrayList<>());

    // Act
    List<CountrySubdivision> actualFindSubdivisionsByCountryAndCategoryResult =
        countrySubdivisionServiceImpl.findSubdivisionsByCountryAndCategory("GB", "Category");

    // Assert
    verify(countrySubdivisionDao).findSubdivisionsByCountryAndCategory("GB", "Category");
    assertTrue(actualFindSubdivisionsByCountryAndCategoryResult.isEmpty());
  }

  /**
   * Test {@link CountrySubdivisionServiceImpl#findSubdivisionByAbbreviation(String)}.
   *
   * <p>Method under test: {@link
   * CountrySubdivisionServiceImpl#findSubdivisionByAbbreviation(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CountrySubdivision CountrySubdivisionServiceImpl.findSubdivisionByAbbreviation(String)"
  })
  public void testFindSubdivisionByAbbreviation() {
    // Arrange
    CountrySubdivisionImpl countrySubdivisionImpl = new CountrySubdivisionImpl();
    when(countrySubdivisionDao.findSubdivisionByAbbreviation(Mockito.<String>any()))
        .thenReturn(countrySubdivisionImpl);

    // Act
    CountrySubdivision actualFindSubdivisionByAbbreviationResult =
        countrySubdivisionServiceImpl.findSubdivisionByAbbreviation("Abbreviation");

    // Assert
    verify(countrySubdivisionDao).findSubdivisionByAbbreviation("Abbreviation");
    assertSame(countrySubdivisionImpl, actualFindSubdivisionByAbbreviationResult);
  }

  /**
   * Test {@link CountrySubdivisionServiceImpl#findSubdivisionByCountryAndAltAbbreviation(String,
   * String)}.
   *
   * <p>Method under test: {@link
   * CountrySubdivisionServiceImpl#findSubdivisionByCountryAndAltAbbreviation(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CountrySubdivision CountrySubdivisionServiceImpl.findSubdivisionByCountryAndAltAbbreviation(String, String)"
  })
  public void testFindSubdivisionByCountryAndAltAbbreviation() {
    // Arrange
    CountrySubdivisionImpl countrySubdivisionImpl = new CountrySubdivisionImpl();
    when(countrySubdivisionDao.findSubdivisionByCountryAndAltAbbreviation(
            Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn(countrySubdivisionImpl);

    // Act
    CountrySubdivision actualFindSubdivisionByCountryAndAltAbbreviationResult =
        countrySubdivisionServiceImpl.findSubdivisionByCountryAndAltAbbreviation(
            "GB", "Alt Abbreviation");

    // Assert
    verify(countrySubdivisionDao)
        .findSubdivisionByCountryAndAltAbbreviation("GB", "Alt Abbreviation");
    assertSame(countrySubdivisionImpl, actualFindSubdivisionByCountryAndAltAbbreviationResult);
  }

  /**
   * Test {@link CountrySubdivisionServiceImpl#findSubdivisionByCountryAndName(String, String)}.
   *
   * <p>Method under test: {@link
   * CountrySubdivisionServiceImpl#findSubdivisionByCountryAndName(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CountrySubdivision CountrySubdivisionServiceImpl.findSubdivisionByCountryAndName(String, String)"
  })
  public void testFindSubdivisionByCountryAndName() {
    // Arrange
    CountrySubdivisionImpl countrySubdivisionImpl = new CountrySubdivisionImpl();
    when(countrySubdivisionDao.findSubdivisionByCountryAndName(
            Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn(countrySubdivisionImpl);

    // Act
    CountrySubdivision actualFindSubdivisionByCountryAndNameResult =
        countrySubdivisionServiceImpl.findSubdivisionByCountryAndName("GB", "Name");

    // Assert
    verify(countrySubdivisionDao).findSubdivisionByCountryAndName("GB", "Name");
    assertSame(countrySubdivisionImpl, actualFindSubdivisionByCountryAndNameResult);
  }

  /**
   * Test {@link CountrySubdivisionServiceImpl#save(CountrySubdivision)}.
   *
   * <p>Method under test: {@link CountrySubdivisionServiceImpl#save(CountrySubdivision)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"CountrySubdivision CountrySubdivisionServiceImpl.save(CountrySubdivision)"})
  public void testSave() {
    // Arrange
    CountrySubdivisionImpl countrySubdivisionImpl = new CountrySubdivisionImpl();
    when(countrySubdivisionDao.save(Mockito.<CountrySubdivision>any()))
        .thenReturn(countrySubdivisionImpl);

    // Act
    CountrySubdivision actualSaveResult =
        countrySubdivisionServiceImpl.save(new CountrySubdivisionImpl());

    // Assert
    verify(countrySubdivisionDao).save(isA(CountrySubdivision.class));
    assertSame(countrySubdivisionImpl, actualSaveResult);
  }
}
