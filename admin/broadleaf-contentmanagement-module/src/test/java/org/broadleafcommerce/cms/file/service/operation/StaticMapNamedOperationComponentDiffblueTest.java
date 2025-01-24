package org.broadleafcommerce.cms.file.service.operation;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"/bl-cms-contentClient-applicationContext.xml",
    "/applicationContext-servlet-cms-contentClient.xml", "/applicationContext-servlet-cms-contentCreator.xml",
    "/bl-cms-applicationContext-entity.xml", "/bl-cms-contentCreator-applicationContext.xml",
    "/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml",
    "/blc-config/admin/framework/bl-cms-admin-applicationContext.xml",
    "/blc-config/site/framework/bl-cms-applicationContext-servlet.xml",
    "/blc-config/site/framework/bl-cms-applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class StaticMapNamedOperationComponentDiffblueTest {
  @Autowired
  private StaticMapNamedOperationComponent staticMapNamedOperationComponent;

  /**
   * Test {@link StaticMapNamedOperationComponent#setOperationValues(Map, Map)}.
   * <p>
   * Method under test:
   * {@link StaticMapNamedOperationComponent#setOperationValues(Map, Map)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testSetOperationValues() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.file.service.operation;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-cms-contentClient-applicationContext.xml","/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-applicationContext-entity.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass10447 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.file.service.operation.StaticMapNamedOperationComponent staticMapNamedOperationComponent;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    StaticMapNamedOperationComponent staticMapNamedOperationComponent2 = new StaticMapNamedOperationComponent();
    HashMap<String, String> originalParameters = new HashMap<>();

    // Act
    staticMapNamedOperationComponent2.setOperationValues(originalParameters, new HashMap<>());
  }

  /**
   * Test {@link StaticMapNamedOperationComponent#setOperationValues(Map, Map)}.
   * <ul>
   *   <li>Given {@link BiFunction}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link StaticMapNamedOperationComponent#setOperationValues(Map, Map)}
   */
  @Test
  public void testSetOperationValues_givenBiFunction() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StaticMapNamedOperationComponent staticMapNamedOperationComponent = new StaticMapNamedOperationComponent();

    HashMap<String, String> originalParameters = new HashMap<>();
    originalParameters.computeIfPresent("foo", mock(BiFunction.class));
    originalParameters.put("foo", "foo");

    // Act and Assert
    assertTrue(staticMapNamedOperationComponent.setOperationValues(originalParameters, new HashMap<>()).isEmpty());
  }

  /**
   * Test {@link StaticMapNamedOperationComponent#setOperationValues(Map, Map)}.
   * <ul>
   *   <li>Given {@code foo}.</li>
   *   <li>When {@link HashMap#HashMap()} {@code foo} is {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link StaticMapNamedOperationComponent#setOperationValues(Map, Map)}
   */
  @Test
  public void testSetOperationValues_givenFoo_whenHashMapFooIsFoo() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StaticMapNamedOperationComponent staticMapNamedOperationComponent = new StaticMapNamedOperationComponent();

    HashMap<String, String> originalParameters = new HashMap<>();
    originalParameters.put("foo", "foo");

    // Act and Assert
    assertTrue(staticMapNamedOperationComponent.setOperationValues(originalParameters, new HashMap<>()).isEmpty());
  }

  /**
   * Test {@link StaticMapNamedOperationComponent#setOperationValues(Map, Map)}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link StaticMapNamedOperationComponent#setOperationValues(Map, Map)}
   */
  @Test
  public void testSetOperationValues_whenHashMap() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StaticMapNamedOperationComponent staticMapNamedOperationComponent = new StaticMapNamedOperationComponent();
    HashMap<String, String> originalParameters = new HashMap<>();

    // Act and Assert
    assertTrue(staticMapNamedOperationComponent.setOperationValues(originalParameters, new HashMap<>()).isEmpty());
  }

  /**
   * Test
   * {@link StaticMapNamedOperationComponent#expandFulfilledMap(Map, Map, List)}.
   * <p>
   * Method under test:
   * {@link StaticMapNamedOperationComponent#expandFulfilledMap(Map, Map, List)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testExpandFulfilledMap() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.file.service.operation;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-cms-contentClient-applicationContext.xml","/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-applicationContext-entity.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass10426 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.file.service.operation.StaticMapNamedOperationComponent staticMapNamedOperationComponent;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    StaticMapNamedOperationComponent staticMapNamedOperationComponent2 = new StaticMapNamedOperationComponent();
    HashMap<String, String> originalParameters = new HashMap<>();
    HashMap<String, String> derivedParameters = new HashMap<>();

    // Act
    staticMapNamedOperationComponent2.expandFulfilledMap(originalParameters, derivedParameters, new ArrayList<>());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link StaticMapNamedOperationComponent}
   *   <li>
   * {@link StaticMapNamedOperationComponent#setNamedOperations(LinkedHashMap)}
   *   <li>{@link StaticMapNamedOperationComponent#getNamedOperations()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    StaticMapNamedOperationComponent actualStaticMapNamedOperationComponent = new StaticMapNamedOperationComponent();
    LinkedHashMap<String, LinkedHashMap<String, String>> namedOperations = new LinkedHashMap<>();
    actualStaticMapNamedOperationComponent.setNamedOperations(namedOperations);

    // Assert that nothing has changed
    assertSame(namedOperations, actualStaticMapNamedOperationComponent.getNamedOperations());
  }
}
