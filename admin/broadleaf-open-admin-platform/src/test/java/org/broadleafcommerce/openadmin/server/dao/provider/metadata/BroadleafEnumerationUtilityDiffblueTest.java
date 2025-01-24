package org.broadleafcommerce.openadmin.server.dao.provider.metadata;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import org.broadleafcommerce.openadmin.server.dao.DynamicEntityDao;
import org.broadleafcommerce.openadmin.server.dao.DynamicEntityDaoImpl;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml",
    "/bl-open-admin-applicationContext-entity.xml", "/bl-open-admin-contentClient-applicationContext.xml",
    "/bl-open-admin-contentCreator-applicationContext.xml",
    "/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml",
    "/blc-config/admin/framework/bl-open-admin-applicationContext.xml",
    "/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class BroadleafEnumerationUtilityDiffblueTest {
  @Autowired
  private BroadleafEnumerationUtility broadleafEnumerationUtility;

  /**
   * Test
   * {@link BroadleafEnumerationUtility#getEnumerationValues(String, DynamicEntityDao)}.
   * <p>
   * Method under test:
   * {@link BroadleafEnumerationUtility#getEnumerationValues(String, DynamicEntityDao)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetEnumerationValues() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.dao.provider.metadata;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass22412 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.dao.provider.metadata.BroadleafEnumerationUtility broadleafEnumerationUtility;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    BroadleafEnumerationUtility broadleafEnumerationUtility2 = new BroadleafEnumerationUtility();

    // Act
    broadleafEnumerationUtility2.getEnumerationValues("Broadleaf Enumeration Class", new DynamicEntityDaoImpl());
  }

  /**
   * Test
   * {@link BroadleafEnumerationUtility#getEnumerationValues(String, DynamicEntityDao)}.
   * <ul>
   *   <li>When {@code Broadleaf Enumeration Class}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafEnumerationUtility#getEnumerationValues(String, DynamicEntityDao)}
   */
  @Test
  public void testGetEnumerationValues_whenBroadleafEnumerationClass() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafEnumerationUtility broadleafEnumerationUtility = new BroadleafEnumerationUtility();

    // Act and Assert
    assertThrows(RuntimeException.class, () -> broadleafEnumerationUtility
        .getEnumerationValues("Broadleaf Enumeration Class", new DynamicEntityDaoImpl()));
  }

  /**
   * Test
   * {@link BroadleafEnumerationUtility#getEnumerationValues(String, DynamicEntityDao)}.
   * <ul>
   *   <li>When {@code java.lang.Comparable}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafEnumerationUtility#getEnumerationValues(String, DynamicEntityDao)}
   */
  @Test
  public void testGetEnumerationValues_whenJavaLangComparable() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafEnumerationUtility broadleafEnumerationUtility = new BroadleafEnumerationUtility();

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> broadleafEnumerationUtility.getEnumerationValues("java.lang.Comparable", new DynamicEntityDaoImpl()));
  }

  /**
   * Test {@link BroadleafEnumerationUtility#getTypesMap(Field, Class)}.
   * <p>
   * Method under test:
   * {@link BroadleafEnumerationUtility#getTypesMap(Field, Class)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetTypesMap() throws IllegalAccessException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.dao.provider.metadata;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass22436 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.dao.provider.metadata.BroadleafEnumerationUtility broadleafEnumerationUtility;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    BroadleafEnumerationUtility broadleafEnumerationUtility2 = new BroadleafEnumerationUtility();
    Class<Object> broadleafEnumeration = Object.class;

    // Act
    broadleafEnumerationUtility2.getTypesMap(null, broadleafEnumeration);
  }

  /**
   * Test {@link BroadleafEnumerationUtility#getSortedEnumValues(Map)}.
   * <p>
   * Method under test:
   * {@link BroadleafEnumerationUtility#getSortedEnumValues(Map)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetSortedEnumValues() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.dao.provider.metadata;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass22428 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.dao.provider.metadata.BroadleafEnumerationUtility broadleafEnumerationUtility;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    BroadleafEnumerationUtility broadleafEnumerationUtility2 = new BroadleafEnumerationUtility();

    // Act
    broadleafEnumerationUtility2.getSortedEnumValues(new HashMap<>());
  }

  /**
   * Test {@link BroadleafEnumerationUtility#getSortedEnumValues(Map)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link HashMap#HashMap()} {@code 42} is {@code 42}.</li>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafEnumerationUtility#getSortedEnumValues(Map)}
   */
  @Test
  public void testGetSortedEnumValues_given42_whenHashMap42Is42_thenReturnSizeIsOne() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafEnumerationUtility broadleafEnumerationUtility = new BroadleafEnumerationUtility();

    HashMap<Object, Object> typesMap = new HashMap<>();
    typesMap.put("42", "42");

    // Act
    Collection<Object> actualSortedEnumValues = broadleafEnumerationUtility.getSortedEnumValues(typesMap);

    // Assert
    assertTrue(actualSortedEnumValues instanceof List);
    assertEquals(1, actualSortedEnumValues.size());
    assertEquals("42", ((List<Object>) actualSortedEnumValues).get(0));
  }

  /**
   * Test {@link BroadleafEnumerationUtility#getSortedEnumValues(Map)}.
   * <ul>
   *   <li>Given {@link BiFunction}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafEnumerationUtility#getSortedEnumValues(Map)}
   */
  @Test
  public void testGetSortedEnumValues_givenBiFunction() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafEnumerationUtility broadleafEnumerationUtility = new BroadleafEnumerationUtility();

    HashMap<Object, Object> typesMap = new HashMap<>();
    typesMap.computeIfPresent("42", mock(BiFunction.class));
    typesMap.put("42", "42");

    // Act
    Collection<Object> actualSortedEnumValues = broadleafEnumerationUtility.getSortedEnumValues(typesMap);

    // Assert
    assertTrue(actualSortedEnumValues instanceof List);
    assertEquals(1, actualSortedEnumValues.size());
    assertEquals("42", ((List<Object>) actualSortedEnumValues).get(0));
  }

  /**
   * Test {@link BroadleafEnumerationUtility#getSortedEnumValues(Map)}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafEnumerationUtility#getSortedEnumValues(Map)}
   */
  @Test
  public void testGetSortedEnumValues_whenHashMap_thenReturnEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafEnumerationUtility broadleafEnumerationUtility = new BroadleafEnumerationUtility();

    // Act
    Collection<Object> actualSortedEnumValues = broadleafEnumerationUtility.getSortedEnumValues(new HashMap<>());

    // Assert
    assertTrue(actualSortedEnumValues instanceof List);
    assertTrue(actualSortedEnumValues.isEmpty());
  }
}
