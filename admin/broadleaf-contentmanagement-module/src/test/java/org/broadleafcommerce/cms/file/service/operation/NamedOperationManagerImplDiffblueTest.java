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
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
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
public class NamedOperationManagerImplDiffblueTest {
  @Autowired
  private NamedOperationManagerImpl namedOperationManagerImpl;

  /**
   * Test {@link NamedOperationManagerImpl#manageNamedParameters(Map)}.
   * <p>
   * Method under test:
   * {@link NamedOperationManagerImpl#manageNamedParameters(Map)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testManageNamedParameters() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.file.service.operation;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-cms-contentClient-applicationContext.xml","/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-applicationContext-entity.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass10418 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.file.service.operation.NamedOperationManagerImpl namedOperationManagerImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    namedOperationManagerImpl.manageNamedParameters(new HashMap<>());
  }

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
