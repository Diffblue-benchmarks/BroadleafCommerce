package org.broadleafcommerce.core.search.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import org.broadleafcommerce.common.copy.CreateResponse;
import org.broadleafcommerce.common.copy.MultiTenantCopierExtensionManager;
import org.broadleafcommerce.common.copy.MultiTenantCopyContext;
import org.broadleafcommerce.common.service.GenericEntityServiceImpl;
import org.broadleafcommerce.common.site.domain.CatalogImpl;
import org.broadleafcommerce.common.site.domain.SiteImpl;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
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
public class FieldImplDiffblueTest {
  @Autowired
  private FieldImpl fieldImpl;

  /**
   * Test {@link FieldImpl#getQualifiedFieldName()}.
   * <p>
   * Method under test: {@link FieldImpl#getQualifiedFieldName()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetQualifiedFieldName() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.domain;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass834 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.domain.FieldImpl fieldImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new FieldImpl()).getQualifiedFieldName();
  }

  /**
   * Test {@link FieldImpl#getQualifiedFieldName()}.
   * <ul>
   *   <li>Then return {@code Category.Property Name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldImpl#getQualifiedFieldName()}
   */
  @Test
  public void testGetQualifiedFieldName_thenReturnCategoryPropertyName() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FieldImpl fieldImpl = new FieldImpl();
    fieldImpl.setAbbreviation("Abbreviation");
    fieldImpl.setEntityType(FieldEntity.CATEGORY);
    fieldImpl.setFriendlyName("Friendly Name");
    fieldImpl.setId(1L);
    fieldImpl.setOverrideGeneratedPropertyName(true);
    fieldImpl.setPropertyName("Property Name");
    fieldImpl.setTranslatable(true);

    // Act and Assert
    assertEquals("Category.Property Name", fieldImpl.getQualifiedFieldName());
  }

  /**
   * Test {@link FieldImpl#getQualifiedFieldName()}.
   * <ul>
   *   <li>Then return {@code Friendly Type.Property Name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldImpl#getQualifiedFieldName()}
   */
  @Test
  public void testGetQualifiedFieldName_thenReturnFriendlyTypePropertyName() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FieldEntity entityType = mock(FieldEntity.class);
    when(entityType.getType()).thenReturn("Type");

    FieldImpl fieldImpl = new FieldImpl();
    fieldImpl.setAbbreviation("Abbreviation");
    fieldImpl.setEntityType(entityType);
    fieldImpl.setFriendlyName("Friendly Name");
    fieldImpl.setId(1L);
    fieldImpl.setOverrideGeneratedPropertyName(true);
    fieldImpl.setPropertyName("Property Name");
    fieldImpl.setTranslatable(true);

    // Act
    String actualQualifiedFieldName = fieldImpl.getQualifiedFieldName();

    // Assert
    verify(entityType).getType();
    assertEquals("Friendly Type.Property Name", actualQualifiedFieldName);
  }

  /**
   * Test {@link FieldImpl#getEntityType()}.
   * <p>
   * Method under test: {@link FieldImpl#getEntityType()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetEntityType() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.domain;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass798 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.domain.FieldImpl fieldImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new FieldImpl()).getEntityType();
  }

  /**
   * Test {@link FieldImpl#getEntityType()}.
   * <ul>
   *   <li>Given {@link FieldEntity} {@link FieldEntity#getType()} return
   * {@code Type}.</li>
   *   <li>Then return {@code Friendly Type}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldImpl#getEntityType()}
   */
  @Test
  public void testGetEntityType_givenFieldEntityGetTypeReturnType_thenReturnFriendlyType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FieldEntity entityType = mock(FieldEntity.class);
    when(entityType.getType()).thenReturn("Type");

    FieldImpl fieldImpl = new FieldImpl();
    fieldImpl.setEntityType(entityType);

    // Act
    FieldEntity actualEntityType = fieldImpl.getEntityType();

    // Assert
    verify(entityType).getType();
    assertEquals("Friendly Type", actualEntityType.getFriendlyType());
    List<String> allLookupTypes = actualEntityType.getAllLookupTypes();
    assertEquals(1, allLookupTypes.size());
    assertEquals("Type", allLookupTypes.get(0));
    assertEquals("Type", actualEntityType.getType());
    assertTrue(actualEntityType.getAdditionalLookupTypes().isEmpty());
    assertTrue(actualEntityType.additionalLookupTypes.isEmpty());
  }

  /**
   * Test {@link FieldImpl#getEntityType()}.
   * <ul>
   *   <li>Given {@link FieldImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldImpl#getEntityType()}
   */
  @Test
  public void testGetEntityType_givenFieldImpl_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new FieldImpl()).getEntityType());
  }

  /**
   * Test {@link FieldImpl#setEntityType(FieldEntity)}.
   * <p>
   * Method under test: {@link FieldImpl#setEntityType(FieldEntity)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testSetEntityType() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.domain;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass861 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.domain.FieldImpl fieldImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new FieldImpl()).setEntityType(FieldEntity.CATEGORY);
  }

  /**
   * Test {@link FieldImpl#setEntityType(FieldEntity)}.
   * <ul>
   *   <li>Given {@code Type}.</li>
   *   <li>Then {@link FieldImpl} (default constructor) EntityType FriendlyType is
   * {@code Friendly Type}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldImpl#setEntityType(FieldEntity)}
   */
  @Test
  public void testSetEntityType_givenType_thenFieldImplEntityTypeFriendlyTypeIsFriendlyType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FieldImpl fieldImpl = new FieldImpl();
    FieldEntity entityType = mock(FieldEntity.class);
    when(entityType.getType()).thenReturn("Type");

    // Act
    fieldImpl.setEntityType(entityType);

    // Assert
    verify(entityType).getType();
    FieldEntity entityType2 = fieldImpl.getEntityType();
    assertEquals("Friendly Type", entityType2.getFriendlyType());
    assertEquals("Friendly Type.null", fieldImpl.getQualifiedFieldName());
    List<String> allLookupTypes = entityType2.getAllLookupTypes();
    assertEquals(1, allLookupTypes.size());
    assertEquals("Type", allLookupTypes.get(0));
    assertEquals("Type", entityType2.getType());
    assertEquals("Type", fieldImpl.entityType);
    assertTrue(entityType2.getAdditionalLookupTypes().isEmpty());
    assertTrue(entityType2.additionalLookupTypes.isEmpty());
  }

  /**
   * Test {@link FieldImpl#setEntityType(FieldEntity)}.
   * <ul>
   *   <li>When {@link FieldEntity#CATEGORY}.</li>
   *   <li>Then {@link FieldImpl} (default constructor) {@link FieldImpl#entityType}
   * is {@code CATEGORY}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldImpl#setEntityType(FieldEntity)}
   */
  @Test
  public void testSetEntityType_whenCategory_thenFieldImplEntityTypeIsCategory() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FieldImpl fieldImpl = new FieldImpl();
    FieldEntity entityType = FieldEntity.CATEGORY;

    // Act
    fieldImpl.setEntityType(entityType);

    // Assert
    assertEquals("CATEGORY", fieldImpl.entityType);
    assertEquals("Category.null", fieldImpl.getQualifiedFieldName());
    FieldEntity expectedEntityType = entityType.CATEGORY;
    assertSame(expectedEntityType, fieldImpl.getEntityType());
  }

  /**
   * Test {@link FieldImpl#getOverrideGeneratedPropertyName()}.
   * <p>
   * Method under test: {@link FieldImpl#getOverrideGeneratedPropertyName()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetOverrideGeneratedPropertyName() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.domain;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass825 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.domain.FieldImpl fieldImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new FieldImpl()).getOverrideGeneratedPropertyName();
  }

  /**
   * Test {@link FieldImpl#getOverrideGeneratedPropertyName()}.
   * <ul>
   *   <li>Given {@link FieldImpl} (default constructor) EntityType is
   * {@link FieldEntity#CATEGORY}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldImpl#getOverrideGeneratedPropertyName()}
   */
  @Test
  public void testGetOverrideGeneratedPropertyName_givenFieldImplEntityTypeIsCategory() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FieldImpl fieldImpl = new FieldImpl();
    fieldImpl.setAbbreviation("Abbreviation");
    fieldImpl.setEntityType(FieldEntity.CATEGORY);
    fieldImpl.setFriendlyName("Friendly Name");
    fieldImpl.setId(1L);
    fieldImpl.setPropertyName("Property Name");
    fieldImpl.setTranslatable(true);
    fieldImpl.setOverrideGeneratedPropertyName(true);

    // Act and Assert
    assertTrue(fieldImpl.getOverrideGeneratedPropertyName());
  }

  /**
   * Test {@link FieldImpl#getOverrideGeneratedPropertyName()}.
   * <ul>
   *   <li>Given {@link FieldImpl} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldImpl#getOverrideGeneratedPropertyName()}
   */
  @Test
  public void testGetOverrideGeneratedPropertyName_givenFieldImpl_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new FieldImpl()).getOverrideGeneratedPropertyName());
  }

  /**
   * Test {@link FieldImpl#getOverrideGeneratedPropertyName()}.
   * <ul>
   *   <li>Then calls {@link FieldEntity#getType()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldImpl#getOverrideGeneratedPropertyName()}
   */
  @Test
  public void testGetOverrideGeneratedPropertyName_thenCallsGetType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FieldEntity entityType = mock(FieldEntity.class);
    when(entityType.getType()).thenReturn("Type");

    FieldImpl fieldImpl = new FieldImpl();
    fieldImpl.setAbbreviation("Abbreviation");
    fieldImpl.setEntityType(entityType);
    fieldImpl.setFriendlyName("Friendly Name");
    fieldImpl.setId(1L);
    fieldImpl.setPropertyName("Property Name");
    fieldImpl.setTranslatable(true);
    fieldImpl.setOverrideGeneratedPropertyName(true);

    // Act
    Boolean actualOverrideGeneratedPropertyName = fieldImpl.getOverrideGeneratedPropertyName();

    // Assert
    verify(entityType).getType();
    assertTrue(actualOverrideGeneratedPropertyName);
  }

  /**
   * Test {@link FieldImpl#setOverrideGeneratedPropertyName(Boolean)}.
   * <p>
   * Method under test:
   * {@link FieldImpl#setOverrideGeneratedPropertyName(Boolean)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testSetOverrideGeneratedPropertyName() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.domain;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass880 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.domain.FieldImpl fieldImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new FieldImpl()).setOverrideGeneratedPropertyName(true);
  }

  /**
   * Test {@link FieldImpl#setOverrideGeneratedPropertyName(Boolean)}.
   * <ul>
   *   <li>Given {@link FieldImpl} (default constructor) EntityType is
   * {@link FieldEntity#CATEGORY}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FieldImpl#setOverrideGeneratedPropertyName(Boolean)}
   */
  @Test
  public void testSetOverrideGeneratedPropertyName_givenFieldImplEntityTypeIsCategory() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FieldImpl fieldImpl = new FieldImpl();
    fieldImpl.setAbbreviation("Abbreviation");
    fieldImpl.setEntityType(FieldEntity.CATEGORY);
    fieldImpl.setFriendlyName("Friendly Name");
    fieldImpl.setId(1L);
    fieldImpl.setOverrideGeneratedPropertyName(true);
    fieldImpl.setPropertyName("Property Name");
    fieldImpl.setTranslatable(true);

    // Act
    fieldImpl.setOverrideGeneratedPropertyName(null);

    // Assert
    assertFalse(fieldImpl.getOverrideGeneratedPropertyName());
    assertFalse(fieldImpl.overrideGeneratedPropertyName);
  }

  /**
   * Test {@link FieldImpl#setOverrideGeneratedPropertyName(Boolean)}.
   * <ul>
   *   <li>Then calls {@link FieldEntity#getType()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FieldImpl#setOverrideGeneratedPropertyName(Boolean)}
   */
  @Test
  public void testSetOverrideGeneratedPropertyName_thenCallsGetType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FieldEntity entityType = mock(FieldEntity.class);
    when(entityType.getType()).thenReturn("Type");

    FieldImpl fieldImpl = new FieldImpl();
    fieldImpl.setAbbreviation("Abbreviation");
    fieldImpl.setEntityType(entityType);
    fieldImpl.setFriendlyName("Friendly Name");
    fieldImpl.setId(1L);
    fieldImpl.setOverrideGeneratedPropertyName(true);
    fieldImpl.setPropertyName("Property Name");
    fieldImpl.setTranslatable(true);

    // Act
    fieldImpl.setOverrideGeneratedPropertyName(null);

    // Assert
    verify(entityType).getType();
    assertFalse(fieldImpl.getOverrideGeneratedPropertyName());
    assertFalse(fieldImpl.overrideGeneratedPropertyName);
  }

  /**
   * Test {@link FieldImpl#setOverrideGeneratedPropertyName(Boolean)}.
   * <ul>
   *   <li>Then {@link FieldImpl} (default constructor)
   * OverrideGeneratedPropertyName.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FieldImpl#setOverrideGeneratedPropertyName(Boolean)}
   */
  @Test
  public void testSetOverrideGeneratedPropertyName_thenFieldImplOverrideGeneratedPropertyName() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FieldImpl fieldImpl = new FieldImpl();

    // Act
    fieldImpl.setOverrideGeneratedPropertyName(true);

    // Assert
    assertTrue(fieldImpl.getOverrideGeneratedPropertyName());
    assertTrue(fieldImpl.overrideGeneratedPropertyName);
  }

  /**
   * Test {@link FieldImpl#getFriendlyName()}.
   * <p>
   * Method under test: {@link FieldImpl#getFriendlyName()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetFriendlyName() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.domain;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass807 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.domain.FieldImpl fieldImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new FieldImpl()).getFriendlyName();
  }

  /**
   * Test {@link FieldImpl#getFriendlyName()}.
   * <ul>
   *   <li>Given {@link FieldEntity} {@link FieldEntity#getType()} return
   * {@code Type}.</li>
   *   <li>Then calls {@link FieldEntity#getType()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldImpl#getFriendlyName()}
   */
  @Test
  public void testGetFriendlyName_givenFieldEntityGetTypeReturnType_thenCallsGetType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FieldEntity entityType = mock(FieldEntity.class);
    when(entityType.getType()).thenReturn("Type");

    FieldImpl fieldImpl = new FieldImpl();
    fieldImpl.setEntityType(entityType);

    // Act
    String actualFriendlyName = fieldImpl.getFriendlyName();

    // Assert
    verify(entityType).getType();
    assertNull(actualFriendlyName);
  }

  /**
   * Test {@link FieldImpl#getFriendlyName()}.
   * <ul>
   *   <li>Given {@link FieldImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldImpl#getFriendlyName()}
   */
  @Test
  public void testGetFriendlyName_givenFieldImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new FieldImpl()).getFriendlyName());
  }

  /**
   * Test {@link FieldImpl#getTranslatable()}.
   * <p>
   * Method under test: {@link FieldImpl#getTranslatable()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetTranslatable() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.domain;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass852 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.domain.FieldImpl fieldImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new FieldImpl()).getTranslatable();
  }

  /**
   * Test {@link FieldImpl#getTranslatable()}.
   * <ul>
   *   <li>Given {@link FieldEntity} {@link FieldEntity#getType()} return
   * {@code Type}.</li>
   *   <li>Then calls {@link FieldEntity#getType()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldImpl#getTranslatable()}
   */
  @Test
  public void testGetTranslatable_givenFieldEntityGetTypeReturnType_thenCallsGetType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FieldEntity entityType = mock(FieldEntity.class);
    when(entityType.getType()).thenReturn("Type");

    FieldImpl fieldImpl = new FieldImpl();
    fieldImpl.setAbbreviation("Abbreviation");
    fieldImpl.setEntityType(entityType);
    fieldImpl.setFriendlyName("Friendly Name");
    fieldImpl.setId(1L);
    fieldImpl.setOverrideGeneratedPropertyName(true);
    fieldImpl.setPropertyName("Property Name");
    fieldImpl.setTranslatable(null);

    // Act
    Boolean actualTranslatable = fieldImpl.getTranslatable();

    // Assert
    verify(entityType).getType();
    assertFalse(actualTranslatable);
  }

  /**
   * Test {@link FieldImpl#getTranslatable()}.
   * <ul>
   *   <li>Given {@link FieldImpl} (default constructor) EntityType is
   * {@link FieldEntity#CATEGORY}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldImpl#getTranslatable()}
   */
  @Test
  public void testGetTranslatable_givenFieldImplEntityTypeIsCategory_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FieldImpl fieldImpl = new FieldImpl();
    fieldImpl.setAbbreviation("Abbreviation");
    fieldImpl.setEntityType(FieldEntity.CATEGORY);
    fieldImpl.setFriendlyName("Friendly Name");
    fieldImpl.setId(1L);
    fieldImpl.setOverrideGeneratedPropertyName(true);
    fieldImpl.setPropertyName("Property Name");
    fieldImpl.setTranslatable(null);

    // Act and Assert
    assertFalse(fieldImpl.getTranslatable());
  }

  /**
   * Test {@link FieldImpl#getTranslatable()}.
   * <ul>
   *   <li>Given {@link FieldImpl} (default constructor) Translatable is
   * {@code true}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldImpl#getTranslatable()}
   */
  @Test
  public void testGetTranslatable_givenFieldImplTranslatableIsTrue_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FieldImpl fieldImpl = new FieldImpl();
    fieldImpl.setAbbreviation("Abbreviation");
    fieldImpl.setEntityType(FieldEntity.CATEGORY);
    fieldImpl.setFriendlyName("Friendly Name");
    fieldImpl.setId(1L);
    fieldImpl.setOverrideGeneratedPropertyName(true);
    fieldImpl.setPropertyName("Property Name");
    fieldImpl.setTranslatable(true);

    // Act and Assert
    assertTrue(fieldImpl.getTranslatable());
  }

  /**
   * Test {@link FieldImpl#getTranslatable()}.
   * <ul>
   *   <li>Given {@link FieldImpl} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldImpl#getTranslatable()}
   */
  @Test
  public void testGetTranslatable_givenFieldImpl_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new FieldImpl()).getTranslatable());
  }

  /**
   * Test {@link FieldImpl#getSearchConfigs()}.
   * <p>
   * Method under test: {@link FieldImpl#getSearchConfigs()}
   */
  @Test
  public void testGetSearchConfigs() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new FieldImpl()).getSearchConfigs());
  }

  /**
   * Test {@link FieldImpl#getSearchConfigs()}.
   * <p>
   * Method under test: {@link FieldImpl#getSearchConfigs()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetSearchConfigs2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.domain;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass843 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.domain.FieldImpl fieldImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new FieldImpl()).getSearchConfigs();
  }

  /**
   * Test {@link FieldImpl#setSearchConfigs(List)}.
   * <p>
   * Method under test: {@link FieldImpl#setSearchConfigs(List)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testSetSearchConfigs() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.domain;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass889 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.domain.FieldImpl fieldImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    FieldImpl fieldImpl2 = new FieldImpl();

    // Act
    fieldImpl2.setSearchConfigs(new ArrayList<>());
  }

  /**
   * Test {@link FieldImpl#setSearchConfigs(List)}.
   * <ul>
   *   <li>Given {@link SearchConfig}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link SearchConfig}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldImpl#setSearchConfigs(List)}
   */
  @Test
  public void testSetSearchConfigs_givenSearchConfig_whenArrayListAddSearchConfig() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FieldImpl fieldImpl = new FieldImpl();

    ArrayList<SearchConfig> searchConfigs = new ArrayList<>();
    searchConfigs.add(mock(SearchConfig.class));

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> fieldImpl.setSearchConfigs(searchConfigs));
  }

  /**
   * Test {@link FieldImpl#setSearchConfigs(List)}.
   * <ul>
   *   <li>Given {@link SearchConfig}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link SearchConfig}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldImpl#setSearchConfigs(List)}
   */
  @Test
  public void testSetSearchConfigs_givenSearchConfig_whenArrayListAddSearchConfig2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FieldImpl fieldImpl = new FieldImpl();

    ArrayList<SearchConfig> searchConfigs = new ArrayList<>();
    searchConfigs.add(mock(SearchConfig.class));
    searchConfigs.add(mock(SearchConfig.class));

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> fieldImpl.setSearchConfigs(searchConfigs));
  }

  /**
   * Test {@link FieldImpl#setSearchConfigs(List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldImpl#setSearchConfigs(List)}
   */
  @Test
  public void testSetSearchConfigs_whenArrayList() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FieldImpl fieldImpl = new FieldImpl();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> fieldImpl.setSearchConfigs(new ArrayList<>()));
  }

  /**
   * Test {@link FieldImpl#getMainEntityName()}.
   * <p>
   * Method under test: {@link FieldImpl#getMainEntityName()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetMainEntityName() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.domain;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass816 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.domain.FieldImpl fieldImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new FieldImpl()).getMainEntityName();
  }

  /**
   * Test {@link FieldImpl#getMainEntityName()}.
   * <ul>
   *   <li>Given {@link FieldEntity} {@link FieldEntity#getType()} return
   * {@code Type}.</li>
   *   <li>Then calls {@link FieldEntity#getType()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldImpl#getMainEntityName()}
   */
  @Test
  public void testGetMainEntityName_givenFieldEntityGetTypeReturnType_thenCallsGetType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FieldEntity entityType = mock(FieldEntity.class);
    when(entityType.getType()).thenReturn("Type");

    FieldImpl fieldImpl = new FieldImpl();
    fieldImpl.setEntityType(entityType);

    // Act
    String actualMainEntityName = fieldImpl.getMainEntityName();

    // Assert
    verify(entityType).getType();
    assertNull(actualMainEntityName);
  }

  /**
   * Test {@link FieldImpl#getMainEntityName()}.
   * <ul>
   *   <li>Given {@link FieldImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldImpl#getMainEntityName()}
   */
  @Test
  public void testGetMainEntityName_givenFieldImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new FieldImpl()).getMainEntityName());
  }

  /**
   * Test {@link FieldImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <p>
   * Method under test:
   * {@link FieldImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  public void testCreateOrRetrieveCopyInstance() throws CloneNotSupportedException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FieldImpl fieldImpl = new FieldImpl();
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    CreateResponse<Object> createResponse = new CreateResponse<>("Clone", true);

    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<Field> actualCreateOrRetrieveCopyInstanceResult = fieldImpl.createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Test {@link FieldImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <p>
   * Method under test:
   * {@link FieldImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCreateOrRetrieveCopyInstance2() throws CloneNotSupportedException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.domain;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass768 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.domain.FieldImpl fieldImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    FieldImpl fieldImpl2 = new FieldImpl();
    CatalogImpl fromCatalog = new CatalogImpl();
    CatalogImpl toCatalog = new CatalogImpl();
    SiteImpl fromSite = new SiteImpl();
    SiteImpl toSite = new SiteImpl();
    GenericEntityServiceImpl genericEntityService = new GenericEntityServiceImpl();

    // Act
    fieldImpl2.createOrRetrieveCopyInstance(new MultiTenantCopyContext(fromCatalog, toCatalog, fromSite, toSite,
        genericEntityService, new MultiTenantCopierExtensionManager()));
  }

  /**
   * Test {@link FieldImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <ul>
   *   <li>Then calls {@link CreateResponse#getClone()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FieldImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  public void testCreateOrRetrieveCopyInstance_thenCallsGetClone() throws CloneNotSupportedException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FieldEntity entityType = mock(FieldEntity.class);
    when(entityType.getType()).thenReturn("Type");

    FieldImpl fieldImpl = new FieldImpl();
    fieldImpl.setEntityType(entityType);

    FieldImpl fieldImpl2 = new FieldImpl();
    fieldImpl2.setAbbreviation("Abbreviation");
    fieldImpl2.setEntityType(FieldEntity.CATEGORY);
    fieldImpl2.setFriendlyName("Friendly Name");
    fieldImpl2.setId(1L);
    fieldImpl2.setOverrideGeneratedPropertyName(true);
    fieldImpl2.setPropertyName("Property Name");
    fieldImpl2.setTranslatable(true);
    CreateResponse<Object> createResponse = mock(CreateResponse.class);
    when(createResponse.isAlreadyPopulated()).thenReturn(false);
    when(createResponse.getClone()).thenReturn(fieldImpl2);
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    fieldImpl.createOrRetrieveCopyInstance(context);

    // Assert
    verify(createResponse).getClone();
    verify(createResponse).isAlreadyPopulated();
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    verify(entityType).getType();
  }

  /**
   * Test {@link FieldImpl#equals(Object)}, and {@link FieldImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link FieldImpl#equals(Object)}
   *   <li>{@link FieldImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    FieldImpl fieldImpl = new FieldImpl();
    fieldImpl.setAbbreviation("Abbreviation");
    fieldImpl.setEntityType(FieldEntity.CATEGORY);
    fieldImpl.setFriendlyName("Friendly Name");
    fieldImpl.setId(1L);
    fieldImpl.setOverrideGeneratedPropertyName(true);
    fieldImpl.setPropertyName("Property Name");
    fieldImpl.setTranslatable(true);

    FieldImpl fieldImpl2 = new FieldImpl();
    fieldImpl2.setAbbreviation("Abbreviation");
    fieldImpl2.setEntityType(FieldEntity.CATEGORY);
    fieldImpl2.setFriendlyName("Friendly Name");
    fieldImpl2.setId(1L);
    fieldImpl2.setOverrideGeneratedPropertyName(true);
    fieldImpl2.setPropertyName("Property Name");
    fieldImpl2.setTranslatable(true);

    // Act and Assert
    assertEquals(fieldImpl, fieldImpl2);
    int expectedHashCodeResult = fieldImpl.hashCode();
    assertEquals(expectedHashCodeResult, fieldImpl2.hashCode());
  }

  /**
   * Test {@link FieldImpl#equals(Object)}, and {@link FieldImpl#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link FieldImpl#equals(Object)}
   *   <li>{@link FieldImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    FieldImpl fieldImpl = new FieldImpl();
    fieldImpl.setAbbreviation("Abbreviation");
    fieldImpl.setEntityType(FieldEntity.CATEGORY);
    fieldImpl.setFriendlyName("Friendly Name");
    fieldImpl.setId(1L);
    fieldImpl.setOverrideGeneratedPropertyName(true);
    fieldImpl.setPropertyName("Property Name");
    fieldImpl.setTranslatable(true);

    // Act and Assert
    assertEquals(fieldImpl, fieldImpl);
    int expectedHashCodeResult = fieldImpl.hashCode();
    assertEquals(expectedHashCodeResult, fieldImpl.hashCode());
  }

  /**
   * Test {@link FieldImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    FieldImpl fieldImpl = new FieldImpl();
    fieldImpl.setAbbreviation("Abbreviation");
    fieldImpl.setEntityType(FieldEntity.CUSTOMER);
    fieldImpl.setFriendlyName("Friendly Name");
    fieldImpl.setId(1L);
    fieldImpl.setOverrideGeneratedPropertyName(true);
    fieldImpl.setPropertyName("Property Name");
    fieldImpl.setTranslatable(true);

    FieldImpl fieldImpl2 = new FieldImpl();
    fieldImpl2.setAbbreviation("Abbreviation");
    fieldImpl2.setEntityType(FieldEntity.CATEGORY);
    fieldImpl2.setFriendlyName("Friendly Name");
    fieldImpl2.setId(1L);
    fieldImpl2.setOverrideGeneratedPropertyName(true);
    fieldImpl2.setPropertyName("Property Name");
    fieldImpl2.setTranslatable(true);

    // Act and Assert
    assertNotEquals(fieldImpl, fieldImpl2);
  }

  /**
   * Test {@link FieldImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    FieldEntity entityType = mock(FieldEntity.class);
    when(entityType.getType()).thenReturn("Type");

    FieldImpl fieldImpl = new FieldImpl();
    fieldImpl.setAbbreviation("Abbreviation");
    fieldImpl.setEntityType(entityType);
    fieldImpl.setFriendlyName("Friendly Name");
    fieldImpl.setId(1L);
    fieldImpl.setOverrideGeneratedPropertyName(true);
    fieldImpl.setPropertyName("Property Name");
    fieldImpl.setTranslatable(true);

    FieldImpl fieldImpl2 = new FieldImpl();
    fieldImpl2.setAbbreviation("Abbreviation");
    fieldImpl2.setEntityType(FieldEntity.CATEGORY);
    fieldImpl2.setFriendlyName("Friendly Name");
    fieldImpl2.setId(1L);
    fieldImpl2.setOverrideGeneratedPropertyName(true);
    fieldImpl2.setPropertyName("Property Name");
    fieldImpl2.setTranslatable(true);

    // Act and Assert
    assertNotEquals(fieldImpl, fieldImpl2);
  }

  /**
   * Test {@link FieldImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then throw exception.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldImpl#equals(Object)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testEquals_whenOtherIsDifferent_thenThrowException() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException
    //       at org.broadleafcommerce.core.search.domain.FieldImpl.equals(FieldImpl.java:243)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange
    FieldImpl fieldImpl = new FieldImpl();
    fieldImpl.setAbbreviation("Abbreviation");
    fieldImpl.setEntityType(new FieldEntity());
    fieldImpl.setFriendlyName("Friendly Name");
    fieldImpl.setId(1L);
    fieldImpl.setOverrideGeneratedPropertyName(true);
    fieldImpl.setPropertyName("Property Name");
    fieldImpl.setTranslatable(true);

    FieldImpl fieldImpl2 = new FieldImpl();
    fieldImpl2.setAbbreviation("Abbreviation");
    fieldImpl2.setEntityType(FieldEntity.CATEGORY);
    fieldImpl2.setFriendlyName("Friendly Name");
    fieldImpl2.setId(1L);
    fieldImpl2.setOverrideGeneratedPropertyName(true);
    fieldImpl2.setPropertyName("Property Name");
    fieldImpl2.setTranslatable(true);

    // Act and Assert
    assertThrows(NullPointerException.class, () -> fieldImpl.equals(fieldImpl2));
  }

  /**
   * Test {@link FieldImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then throw exception.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldImpl#equals(Object)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testEquals_whenOtherIsDifferent_thenThrowException2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException
    //       at org.broadleafcommerce.core.search.domain.FieldImpl.equals(FieldImpl.java:243)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange
    FieldEntity entityType = mock(FieldEntity.class);
    when(entityType.getType()).thenReturn("Type");

    FieldImpl fieldImpl = new FieldImpl();
    fieldImpl.setAbbreviation("Abbreviation");
    fieldImpl.setEntityType(entityType);
    fieldImpl.setFriendlyName("Friendly Name");
    fieldImpl.setId(1L);
    fieldImpl.setOverrideGeneratedPropertyName(true);
    fieldImpl.setPropertyName("Property Name");
    fieldImpl.setTranslatable(true);

    FieldImpl fieldImpl2 = new FieldImpl();
    fieldImpl2.setAbbreviation("Abbreviation");
    fieldImpl2.setEntityType(new FieldEntity());
    fieldImpl2.setFriendlyName("Friendly Name");
    fieldImpl2.setId(1L);
    fieldImpl2.setOverrideGeneratedPropertyName(true);
    fieldImpl2.setPropertyName("Property Name");
    fieldImpl2.setTranslatable(true);

    // Act and Assert
    assertThrows(NullPointerException.class, () -> fieldImpl.equals(fieldImpl2));
  }

  /**
   * Test {@link FieldImpl#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    FieldImpl fieldImpl = new FieldImpl();
    fieldImpl.setAbbreviation("Abbreviation");
    fieldImpl.setEntityType(FieldEntity.CATEGORY);
    fieldImpl.setFriendlyName("Friendly Name");
    fieldImpl.setId(1L);
    fieldImpl.setOverrideGeneratedPropertyName(true);
    fieldImpl.setPropertyName("Property Name");
    fieldImpl.setTranslatable(true);

    // Act and Assert
    assertNotEquals(fieldImpl, null);
  }

  /**
   * Test {@link FieldImpl#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    FieldImpl fieldImpl = new FieldImpl();
    fieldImpl.setAbbreviation("Abbreviation");
    fieldImpl.setEntityType(FieldEntity.CATEGORY);
    fieldImpl.setFriendlyName("Friendly Name");
    fieldImpl.setId(1L);
    fieldImpl.setOverrideGeneratedPropertyName(true);
    fieldImpl.setPropertyName("Property Name");
    fieldImpl.setTranslatable(true);

    // Act and Assert
    assertNotEquals(fieldImpl, "Different type to FieldImpl");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link FieldImpl}
   *   <li>{@link FieldImpl#setAbbreviation(String)}
   *   <li>{@link FieldImpl#setFriendlyName(String)}
   *   <li>{@link FieldImpl#setId(Long)}
   *   <li>{@link FieldImpl#setPropertyName(String)}
   *   <li>{@link FieldImpl#setTranslatable(Boolean)}
   *   <li>{@link FieldImpl#getAbbreviation()}
   *   <li>{@link FieldImpl#getId()}
   *   <li>{@link FieldImpl#getPropertyName()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    FieldImpl actualFieldImpl = new FieldImpl();
    actualFieldImpl.setAbbreviation("Abbreviation");
    actualFieldImpl.setFriendlyName("Friendly Name");
    actualFieldImpl.setId(1L);
    actualFieldImpl.setPropertyName("Property Name");
    actualFieldImpl.setTranslatable(true);
    String actualAbbreviation = actualFieldImpl.getAbbreviation();
    Long actualId = actualFieldImpl.getId();

    // Assert that nothing has changed
    assertEquals("Abbreviation", actualAbbreviation);
    assertEquals("Property Name", actualFieldImpl.getPropertyName());
    assertEquals(1L, actualId.longValue());
  }
}
