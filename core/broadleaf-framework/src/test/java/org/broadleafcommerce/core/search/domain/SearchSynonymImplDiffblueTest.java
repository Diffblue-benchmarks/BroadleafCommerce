package org.broadleafcommerce.core.search.domain;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml"})
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(SpringJUnit4ClassRunner.class)
public class SearchSynonymImplDiffblueTest {
  @Autowired private SearchSynonymImpl searchSynonymImpl;

  /**
   * Test {@link SearchSynonymImpl#getSynonyms()}.
   *
   * <ul>
   *   <li>Then return array of {@link String} with {@code \}.
   * </ul>
   *
   * <p>Method under test: {@link SearchSynonymImpl#getSynonyms()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String[] SearchSynonymImpl.getSynonyms()"})
  public void testGetSynonyms_thenReturnArrayOfStringWithBackslash() {
    // Arrange
    SearchSynonymImpl searchSynonymImpl = new SearchSynonymImpl();
    searchSynonymImpl.setSynonyms(new String[] {"\\|"});

    // Act and Assert
    assertArrayEquals(new String[] {"\\"}, searchSynonymImpl.getSynonyms());
  }

  /**
   * Test {@link SearchSynonymImpl#setSynonyms(String[])}.
   *
   * <ul>
   *   <li>Then {@link SearchSynonymImpl} Synonyms is array of {@link String} with empty string and
   *       {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link SearchSynonymImpl#setSynonyms(String[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SearchSynonymImpl.setSynonyms(String[])"})
  public void testSetSynonyms_thenSearchSynonymImplSynonymsIsArrayOfStringWithEmptyStringAnd42() {
    // Arrange and Act
    searchSynonymImpl.setSynonyms(new String[] {"", "42"});

    // Assert
    assertArrayEquals(new String[] {"", "42"}, searchSynonymImpl.getSynonyms());
  }

  /**
   * Test {@link SearchSynonymImpl#setSynonyms(String[])}.
   *
   * <ul>
   *   <li>Then {@link SearchSynonymImpl} Synonyms is array of {@link String} with {@code Synonyms}.
   * </ul>
   *
   * <p>Method under test: {@link SearchSynonymImpl#setSynonyms(String[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SearchSynonymImpl.setSynonyms(String[])"})
  public void testSetSynonyms_thenSearchSynonymImplSynonymsIsArrayOfStringWithSynonyms() {
    // Arrange and Act
    searchSynonymImpl.setSynonyms(new String[] {"Synonyms"});

    // Assert
    assertArrayEquals(new String[] {"Synonyms"}, searchSynonymImpl.getSynonyms());
  }

  /**
   * Test {@link SearchSynonymImpl#setSynonyms(String[])}.
   *
   * <ul>
   *   <li>Then {@link SearchSynonymImpl} Synonyms is array of {@link String} with {@code Synonyms}
   *       and {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link SearchSynonymImpl#setSynonyms(String[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SearchSynonymImpl.setSynonyms(String[])"})
  public void testSetSynonyms_thenSearchSynonymImplSynonymsIsArrayOfStringWithSynonymsAnd42() {
    // Arrange and Act
    searchSynonymImpl.setSynonyms(new String[] {"Synonyms", "42"});

    // Assert
    assertArrayEquals(new String[] {"Synonyms", "42"}, searchSynonymImpl.getSynonyms());
  }

  /**
   * Test {@link SearchSynonymImpl#setSynonyms(String[])}.
   *
   * <ul>
   *   <li>When array of {@link String} with empty string.
   * </ul>
   *
   * <p>Method under test: {@link SearchSynonymImpl#setSynonyms(String[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SearchSynonymImpl.setSynonyms(String[])"})
  public void testSetSynonyms_whenArrayOfStringWithEmptyString() {
    // Arrange and Act
    searchSynonymImpl.setSynonyms(new String[] {""});

    // Assert
    assertArrayEquals(new String[] {""}, searchSynonymImpl.getSynonyms());
  }

  /**
   * Test {@link SearchSynonymImpl#setSynonyms(String[])}.
   *
   * <ul>
   *   <li>When array of {@link String} with {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SearchSynonymImpl#setSynonyms(String[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SearchSynonymImpl.setSynonyms(String[])"})
  public void testSetSynonyms_whenArrayOfStringWithNull() {
    // Arrange and Act
    searchSynonymImpl.setSynonyms(new String[] {null});

    // Assert
    assertArrayEquals(new String[] {""}, searchSynonymImpl.getSynonyms());
  }

  /**
   * Test {@link SearchSynonymImpl#setSynonyms(String[])}.
   *
   * <ul>
   *   <li>When empty array of {@link String}.
   * </ul>
   *
   * <p>Method under test: {@link SearchSynonymImpl#setSynonyms(String[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SearchSynonymImpl.setSynonyms(String[])"})
  public void testSetSynonyms_whenEmptyArrayOfString() {
    // Arrange and Act
    searchSynonymImpl.setSynonyms(new String[] {});

    // Assert
    assertArrayEquals(new String[] {""}, searchSynonymImpl.getSynonyms());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link SearchSynonymImpl}
   *   <li>{@link SearchSynonymImpl#setId(Long)}
   *   <li>{@link SearchSynonymImpl#setTerm(String)}
   *   <li>{@link SearchSynonymImpl#getId()}
   *   <li>{@link SearchSynonymImpl#getTerm()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SearchSynonymImpl.<init>()",
    "Long SearchSynonymImpl.getId()",
    "String SearchSynonymImpl.getTerm()",
    "void SearchSynonymImpl.setId(Long)",
    "void SearchSynonymImpl.setTerm(String)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    SearchSynonymImpl actualSearchSynonymImpl = new SearchSynonymImpl();
    actualSearchSynonymImpl.setId(1L);
    actualSearchSynonymImpl.setTerm("Term");
    Long actualId = actualSearchSynonymImpl.getId();

    // Assert
    assertEquals("Term", actualSearchSynonymImpl.getTerm());
    assertEquals(1L, actualId.longValue());
  }
}
