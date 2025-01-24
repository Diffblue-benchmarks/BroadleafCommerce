package org.broadleafcommerce.core.search.domain;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml",
    "/bl-framework-applicationContext-persistence.xml", "/bl-framework-applicationContext-workflow.xml",
    "/bl-framework-applicationContext.xml", "/blc-config/admin/framework/bl-framework-admin-applicationContext.xml",
    "/blc-config/site/framework/bl-framework-applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class SearchSynonymImplDiffblueTest {
  @Autowired
  private SearchSynonymImpl searchSynonymImpl;

  /**
   * Test {@link SearchSynonymImpl#getSynonyms()}.
   * <p>
   * Method under test: {@link SearchSynonymImpl#getSynonyms()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetSynonyms() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.domain;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1268 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.domain.SearchSynonymImpl searchSynonymImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new SearchSynonymImpl()).getSynonyms();
  }

  /**
   * Test {@link SearchSynonymImpl#getSynonyms()}.
   * <ul>
   *   <li>Then return array of {@link String} with {@code Synonyms}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SearchSynonymImpl#getSynonyms()}
   */
  @Test
  public void testGetSynonyms_thenReturnArrayOfStringWithSynonyms() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SearchSynonymImpl searchSynonymImpl = new SearchSynonymImpl();
    searchSynonymImpl.setId(1L);
    searchSynonymImpl.setSynonyms(new String[]{"Synonyms"});
    searchSynonymImpl.setTerm("Term");

    // Act and Assert
    assertArrayEquals(new String[]{"Synonyms"}, searchSynonymImpl.getSynonyms());
  }

  /**
   * Test {@link SearchSynonymImpl#setSynonyms(String[])}.
   * <p>
   * Method under test: {@link SearchSynonymImpl#setSynonyms(String[])}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testSetSynonyms() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.domain;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1273 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.domain.SearchSynonymImpl searchSynonymImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new SearchSynonymImpl()).setSynonyms(new String[]{"Synonyms"});
  }

  /**
   * Test {@link SearchSynonymImpl#setSynonyms(String[])}.
   * <ul>
   *   <li>Then {@link SearchSynonymImpl} (default constructor) Synonyms is array of
   * {@link String} with empty string and {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SearchSynonymImpl#setSynonyms(String[])}
   */
  @Test
  public void testSetSynonyms_thenSearchSynonymImplSynonymsIsArrayOfStringWithEmptyStringAnd42() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SearchSynonymImpl searchSynonymImpl = new SearchSynonymImpl();

    // Act
    searchSynonymImpl.setSynonyms(new String[]{"", "42"});

    // Assert
    assertArrayEquals(new String[]{"", "42"}, searchSynonymImpl.getSynonyms());
  }

  /**
   * Test {@link SearchSynonymImpl#setSynonyms(String[])}.
   * <ul>
   *   <li>Then {@link SearchSynonymImpl} (default constructor) Synonyms is array of
   * {@link String} with {@code Synonyms}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SearchSynonymImpl#setSynonyms(String[])}
   */
  @Test
  public void testSetSynonyms_thenSearchSynonymImplSynonymsIsArrayOfStringWithSynonyms() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SearchSynonymImpl searchSynonymImpl = new SearchSynonymImpl();

    // Act
    searchSynonymImpl.setSynonyms(new String[]{"Synonyms"});

    // Assert
    assertArrayEquals(new String[]{"Synonyms"}, searchSynonymImpl.getSynonyms());
  }

  /**
   * Test {@link SearchSynonymImpl#setSynonyms(String[])}.
   * <ul>
   *   <li>Then {@link SearchSynonymImpl} (default constructor) Synonyms is array of
   * {@link String} with {@code Synonyms} and {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SearchSynonymImpl#setSynonyms(String[])}
   */
  @Test
  public void testSetSynonyms_thenSearchSynonymImplSynonymsIsArrayOfStringWithSynonymsAnd42() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SearchSynonymImpl searchSynonymImpl = new SearchSynonymImpl();

    // Act
    searchSynonymImpl.setSynonyms(new String[]{"Synonyms", "42"});

    // Assert
    assertArrayEquals(new String[]{"Synonyms", "42"}, searchSynonymImpl.getSynonyms());
  }

  /**
   * Test {@link SearchSynonymImpl#setSynonyms(String[])}.
   * <ul>
   *   <li>When array of {@link String} with empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link SearchSynonymImpl#setSynonyms(String[])}
   */
  @Test
  public void testSetSynonyms_whenArrayOfStringWithEmptyString() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SearchSynonymImpl searchSynonymImpl = new SearchSynonymImpl();

    // Act
    searchSynonymImpl.setSynonyms(new String[]{""});

    // Assert
    assertArrayEquals(new String[]{""}, searchSynonymImpl.getSynonyms());
  }

  /**
   * Test {@link SearchSynonymImpl#setSynonyms(String[])}.
   * <ul>
   *   <li>When empty array of {@link String}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SearchSynonymImpl#setSynonyms(String[])}
   */
  @Test
  public void testSetSynonyms_whenEmptyArrayOfString() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SearchSynonymImpl searchSynonymImpl = new SearchSynonymImpl();

    // Act
    searchSynonymImpl.setSynonyms(new String[]{});

    // Assert
    assertArrayEquals(new String[]{""}, searchSynonymImpl.getSynonyms());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link SearchSynonymImpl}
   *   <li>{@link SearchSynonymImpl#setId(Long)}
   *   <li>{@link SearchSynonymImpl#setTerm(String)}
   *   <li>{@link SearchSynonymImpl#getId()}
   *   <li>{@link SearchSynonymImpl#getTerm()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    SearchSynonymImpl actualSearchSynonymImpl = new SearchSynonymImpl();
    actualSearchSynonymImpl.setId(1L);
    actualSearchSynonymImpl.setTerm("Term");
    Long actualId = actualSearchSynonymImpl.getId();

    // Assert that nothing has changed
    assertEquals("Term", actualSearchSynonymImpl.getTerm());
    assertEquals(1L, actualId.longValue());
  }
}
