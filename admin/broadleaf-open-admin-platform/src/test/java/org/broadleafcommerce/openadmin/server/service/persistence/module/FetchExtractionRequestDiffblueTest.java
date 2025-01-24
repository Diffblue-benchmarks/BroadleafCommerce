package org.broadleafcommerce.openadmin.server.service.persistence.module;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import org.broadleafcommerce.openadmin.dto.CriteriaTransferObject;
import org.broadleafcommerce.openadmin.dto.FieldMetadata;
import org.broadleafcommerce.openadmin.dto.PersistencePackage;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {FetchExtractionRequest.class, String.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class FetchExtractionRequestDiffblueTest {
  @MockBean
  private CriteriaTransferObject criteriaTransferObject;

  @Autowired
  private FetchExtractionRequest fetchExtractionRequest;

  @MockBean
  private FieldMetadata fieldMetadata;

  @Autowired
  private List<Serializable> list;

  @Autowired
  private Map<String, FieldMetadata> map;

  @MockBean
  private PersistencePackage persistencePackage;

  @MockBean
  private Serializable serializable;

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>
   * {@link FetchExtractionRequest#FetchExtractionRequest(PersistencePackage, CriteriaTransferObject, String, Map, List)}
   *   <li>
   * {@link FetchExtractionRequest#setAlternateUnfilteredMergedProperties(Map)}
   *   <li>{@link FetchExtractionRequest#setCeilingEntity(String)}
   *   <li>{@link FetchExtractionRequest#setCto(CriteriaTransferObject)}
   *   <li>{@link FetchExtractionRequest#setPathToTargetObject(String)}
   *   <li>{@link FetchExtractionRequest#setPersistencePackage(PersistencePackage)}
   *   <li>{@link FetchExtractionRequest#setPrimaryUnfilteredMergedProperties(Map)}
   *   <li>{@link FetchExtractionRequest#setRecords(List)}
   *   <li>{@link FetchExtractionRequest#getAlternateUnfilteredMergedProperties()}
   *   <li>{@link FetchExtractionRequest#getCeilingEntity()}
   *   <li>{@link FetchExtractionRequest#getCto()}
   *   <li>{@link FetchExtractionRequest#getPathToTargetObject()}
   *   <li>{@link FetchExtractionRequest#getPersistencePackage()}
   *   <li>{@link FetchExtractionRequest#getPrimaryUnfilteredMergedProperties()}
   *   <li>{@link FetchExtractionRequest#getRecords()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    PersistencePackage persistencePackage = new PersistencePackage();
    CriteriaTransferObject cto = new CriteriaTransferObject();
    HashMap<String, FieldMetadata> primaryUnfilteredMergedProperties = new HashMap<>();

    // Act
    FetchExtractionRequest actualFetchExtractionRequest = new FetchExtractionRequest(persistencePackage, cto,
        "0123456789ABCDEF", primaryUnfilteredMergedProperties, new ArrayList<>());
    HashMap<String, FieldMetadata> alternateUnfilteredMergedProperties = new HashMap<>();
    actualFetchExtractionRequest.setAlternateUnfilteredMergedProperties(alternateUnfilteredMergedProperties);
    actualFetchExtractionRequest.setCeilingEntity("0123456789ABCDEF");
    CriteriaTransferObject cto2 = new CriteriaTransferObject();
    actualFetchExtractionRequest.setCto(cto2);
    actualFetchExtractionRequest.setPathToTargetObject("0123456789ABCDEF");
    PersistencePackage persistencePackage2 = new PersistencePackage();
    actualFetchExtractionRequest.setPersistencePackage(persistencePackage2);
    HashMap<String, FieldMetadata> primaryUnfilteredMergedProperties2 = new HashMap<>();
    actualFetchExtractionRequest.setPrimaryUnfilteredMergedProperties(primaryUnfilteredMergedProperties2);
    ArrayList<Serializable> records = new ArrayList<>();
    actualFetchExtractionRequest.setRecords(records);
    Map<String, FieldMetadata> actualAlternateUnfilteredMergedProperties = actualFetchExtractionRequest
        .getAlternateUnfilteredMergedProperties();
    String actualCeilingEntity = actualFetchExtractionRequest.getCeilingEntity();
    CriteriaTransferObject actualCto = actualFetchExtractionRequest.getCto();
    String actualPathToTargetObject = actualFetchExtractionRequest.getPathToTargetObject();
    PersistencePackage actualPersistencePackage = actualFetchExtractionRequest.getPersistencePackage();
    Map<String, FieldMetadata> actualPrimaryUnfilteredMergedProperties = actualFetchExtractionRequest
        .getPrimaryUnfilteredMergedProperties();
    List<? extends Serializable> actualRecords = actualFetchExtractionRequest.getRecords();

    // Assert that nothing has changed
    assertEquals("0123456789ABCDEF", actualCeilingEntity);
    assertEquals("0123456789ABCDEF", actualPathToTargetObject);
    assertTrue(actualRecords.isEmpty());
    assertTrue(actualAlternateUnfilteredMergedProperties.isEmpty());
    assertTrue(actualPrimaryUnfilteredMergedProperties.isEmpty());
    assertSame(records, actualRecords);
    assertSame(alternateUnfilteredMergedProperties, actualAlternateUnfilteredMergedProperties);
    assertSame(primaryUnfilteredMergedProperties2, actualPrimaryUnfilteredMergedProperties);
    assertSame(cto2, actualCto);
    assertSame(persistencePackage2, actualPersistencePackage);
  }

  /**
   * Test {@link FetchExtractionRequest#withAlternateMergedProperties(Map)}.
   * <p>
   * Method under test:
   * {@link FetchExtractionRequest#withAlternateMergedProperties(Map)}
   */
  @Test
  public void testWithAlternateMergedProperties() {
    // Arrange
    PersistencePackage persistencePackage = new PersistencePackage();
    CriteriaTransferObject cto = new CriteriaTransferObject();
    HashMap<String, FieldMetadata> primaryUnfilteredMergedProperties = new HashMap<>();
    FetchExtractionRequest fetchExtractionRequest = new FetchExtractionRequest(persistencePackage, cto,
        "0123456789ABCDEF", primaryUnfilteredMergedProperties, new ArrayList<>());
    HashMap<String, FieldMetadata> alternateUnfilteredMergedProperties = new HashMap<>();

    // Act
    FetchExtractionRequest actualWithAlternateMergedPropertiesResult = fetchExtractionRequest
        .withAlternateMergedProperties(alternateUnfilteredMergedProperties);

    // Assert
    assertSame(alternateUnfilteredMergedProperties, fetchExtractionRequest.getAlternateUnfilteredMergedProperties());
    assertSame(fetchExtractionRequest, actualWithAlternateMergedPropertiesResult);
  }

  /**
   * Test {@link FetchExtractionRequest#withAlternateMergedProperties(Map)}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} computeIfPresent {@code foo} and
   * {@link BiFunction}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FetchExtractionRequest#withAlternateMergedProperties(Map)}
   */
  @Test
  public void testWithAlternateMergedProperties_givenHashMapComputeIfPresentFooAndBiFunction() {
    // Arrange
    HashMap<String, FieldMetadata> primaryUnfilteredMergedProperties = new HashMap<>();
    primaryUnfilteredMergedProperties.computeIfPresent("foo", mock(BiFunction.class));
    PersistencePackage persistencePackage = new PersistencePackage();
    CriteriaTransferObject cto = new CriteriaTransferObject();
    FetchExtractionRequest fetchExtractionRequest = new FetchExtractionRequest(persistencePackage, cto,
        "0123456789ABCDEF", primaryUnfilteredMergedProperties, new ArrayList<>());
    HashMap<String, FieldMetadata> alternateUnfilteredMergedProperties = new HashMap<>();

    // Act
    FetchExtractionRequest actualWithAlternateMergedPropertiesResult = fetchExtractionRequest
        .withAlternateMergedProperties(alternateUnfilteredMergedProperties);

    // Assert
    assertSame(alternateUnfilteredMergedProperties, fetchExtractionRequest.getAlternateUnfilteredMergedProperties());
    assertSame(fetchExtractionRequest, actualWithAlternateMergedPropertiesResult);
  }

  /**
   * Test {@link FetchExtractionRequest#withPathToTargetObject(String)}.
   * <p>
   * Method under test:
   * {@link FetchExtractionRequest#withPathToTargetObject(String)}
   */
  @Test
  public void testWithPathToTargetObject() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PersistencePackage persistencePackage = new PersistencePackage();
    CriteriaTransferObject cto = new CriteriaTransferObject();
    HashMap<String, FieldMetadata> primaryUnfilteredMergedProperties = new HashMap<>();
    FetchExtractionRequest fetchExtractionRequest = new FetchExtractionRequest(persistencePackage, cto,
        "0123456789ABCDEF", primaryUnfilteredMergedProperties, new ArrayList<>());

    // Act and Assert
    assertSame(fetchExtractionRequest, fetchExtractionRequest.withPathToTargetObject("0123456789ABCDEF"));
  }

  /**
   * Test {@link FetchExtractionRequest#withPathToTargetObject(String)}.
   * <p>
   * Method under test:
   * {@link FetchExtractionRequest#withPathToTargetObject(String)}
   */
  @Test
  public void testWithPathToTargetObject2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    CriteriaTransferObject cto = new CriteriaTransferObject();
    HashMap<String, FieldMetadata> primaryUnfilteredMergedProperties = new HashMap<>();
    FetchExtractionRequest fetchExtractionRequest = new FetchExtractionRequest(persistencePackage, cto,
        "0123456789ABCDEF", primaryUnfilteredMergedProperties, new ArrayList<>());

    // Act
    FetchExtractionRequest actualWithPathToTargetObjectResult = fetchExtractionRequest
        .withPathToTargetObject("0123456789ABCDEF");

    // Assert
    assertEquals("0123456789ABCDEF", fetchExtractionRequest.getPathToTargetObject());
    assertSame(fetchExtractionRequest, actualWithPathToTargetObjectResult);
  }

  /**
   * Test {@link FetchExtractionRequest#withPathToTargetObject(String)}.
   * <p>
   * Method under test:
   * {@link FetchExtractionRequest#withPathToTargetObject(String)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testWithPathToTargetObject3() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.service.persistence.module;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.openadmin.server.service.persistence.module.FetchExtractionRequest.class,java.lang.String.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass6338 {
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.dto.CriteriaTransferObject criteriaTransferObject;
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.service.persistence.module.FetchExtractionRequest fetchExtractionRequest;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.dto.FieldMetadata fieldMetadata;
    //     @org.springframework.beans.factory.annotation.Autowired java.util.List<Ljava.io.Serializable;> list;
    //     @org.springframework.beans.factory.annotation.Autowired java.util.Map<Ljava.lang.String;Lorg.broadleafcommerce.openadmin.dto.FieldMetadata;> map;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.dto.PersistencePackage persistencePackage;
    //     @org.springframework.boot.test.mock.mockito.MockBean java.io.Serializable serializable;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    fetchExtractionRequest.withPathToTargetObject("0123456789ABCDEF");
  }
}
