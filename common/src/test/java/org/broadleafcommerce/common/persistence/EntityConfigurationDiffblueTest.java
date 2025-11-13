package org.broadleafcommerce.common.persistence;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.Set;
import org.broadleafcommerce.common.resource.GeneratedResource;
import org.broadleafcommerce.common.util.BLCFieldUtils;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.FactoryBeanNotInitializedException;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;

@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(MockitoJUnitRunner.class)
public class EntityConfigurationDiffblueTest {
  @Mock private ApplicationContext applicationContext;

  @InjectMocks private EntityConfiguration entityConfiguration;

  @Mock private Set<String> set;

  /**
   * Test {@link EntityConfiguration#configureMergedItems()}.
   *
   * <p>Method under test: {@link EntityConfiguration#configureMergedItems()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void EntityConfiguration.configureMergedItems()"})
  public void testConfigureMergedItems() {
    // Arrange
    EntityConfiguration entityConfiguration = new EntityConfiguration();
    entityConfiguration.setEntityContexts(new Resource[] {});

    // Act
    entityConfiguration.configureMergedItems();

    // Assert
    assertEquals(0, entityConfiguration.getEntityBeanNames().length);
    assertEquals(0, entityConfiguration.getEntityContexts().length);
  }

  /**
   * Test {@link EntityConfiguration#configureMergedItems()}.
   *
   * <ul>
   *   <li>Given {@link EntityConfiguration} (default constructor).
   *   <li>Then array length is zero.
   * </ul>
   *
   * <p>Method under test: {@link EntityConfiguration#configureMergedItems()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void EntityConfiguration.configureMergedItems()"})
  public void testConfigureMergedItems_givenEntityConfiguration_thenArrayLengthIsZero() {
    // Arrange
    EntityConfiguration entityConfiguration = new EntityConfiguration();

    // Act
    entityConfiguration.configureMergedItems();

    // Assert
    assertEquals(0, entityConfiguration.getEntityBeanNames().length);
    assertEquals(0, entityConfiguration.getEntityContexts().length);
  }

  /**
   * Test {@link EntityConfiguration#configureMergedItems()}.
   *
   * <ul>
   *   <li>Given {@link Set} {@link Set#isEmpty()} return {@code false}.
   *   <li>Then calls {@link Set#iterator()}.
   * </ul>
   *
   * <p>Method under test: {@link EntityConfiguration#configureMergedItems()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void EntityConfiguration.configureMergedItems()"})
  public void testConfigureMergedItems_givenSetIsEmptyReturnFalse_thenCallsIterator() {
    // Arrange
    when(set.isEmpty()).thenReturn(false);

    ArrayList<String> stringList = new ArrayList<>();
    when(set.iterator()).thenReturn(stringList.iterator());

    // Act
    entityConfiguration.configureMergedItems();

    // Assert
    verify(set).isEmpty();
    verify(set).iterator();
    assertEquals(0, entityConfiguration.getEntityBeanNames().length);
    assertEquals(0, entityConfiguration.getEntityContexts().length);
  }

  /**
   * Test {@link EntityConfiguration#configureMergedItems()}.
   *
   * <ul>
   *   <li>Given {@link Set} {@link Set#isEmpty()} return {@code true}.
   *   <li>Then calls {@link Set#isEmpty()}.
   * </ul>
   *
   * <p>Method under test: {@link EntityConfiguration#configureMergedItems()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void EntityConfiguration.configureMergedItems()"})
  public void testConfigureMergedItems_givenSetIsEmptyReturnTrue_thenCallsIsEmpty() {
    // Arrange
    when(set.isEmpty()).thenReturn(true);

    // Act
    entityConfiguration.configureMergedItems();

    // Assert
    verify(set).isEmpty();
    assertEquals(0, entityConfiguration.getEntityBeanNames().length);
    assertEquals(0, entityConfiguration.getEntityContexts().length);
  }

  /**
   * Test {@link EntityConfiguration#lookupEntityClass(String, Class)} with {@code beanId}, {@code
   * resultClass}.
   *
   * <p>Method under test: {@link EntityConfiguration#lookupEntityClass(String, Class)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Class EntityConfiguration.lookupEntityClass(String, Class)"})
  public void testLookupEntityClassWithBeanIdResultClass() throws BeansException {
    // Arrange
    when(applicationContext.getBean(Mockito.<String>any()))
        .thenThrow(new FactoryBeanNotInitializedException());
    Class<Object> resultClass = Object.class;

    // Act and Assert
    assertThrows(
        FactoryBeanNotInitializedException.class,
        () -> entityConfiguration.lookupEntityClass("42", resultClass));
    verify(applicationContext).getBean("42");
  }

  /**
   * Test {@link EntityConfiguration#lookupEntityClass(String, Class)} with {@code beanId}, {@code
   * resultClass}.
   *
   * <ul>
   *   <li>Then return {@link Object}.
   * </ul>
   *
   * <p>Method under test: {@link EntityConfiguration#lookupEntityClass(String, Class)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Class EntityConfiguration.lookupEntityClass(String, Class)"})
  public void testLookupEntityClassWithBeanIdResultClass_thenReturnObject() throws BeansException {
    // Arrange
    when(applicationContext.getBean(Mockito.<String>any())).thenReturn(BLCFieldUtils.NULL_FIELD);
    Class<Object> resultClass = Object.class;

    // Act
    Class<Object> actualLookupEntityClassResult =
        entityConfiguration.lookupEntityClass("42", resultClass);

    // Assert
    verify(applicationContext).getBean("42");
    Class<Object> expectedLookupEntityClassResult = Object.class;
    assertEquals(expectedLookupEntityClassResult, actualLookupEntityClassResult);
  }

  /**
   * Test {@link EntityConfiguration#lookupEntityClass(String)} with {@code beanId}.
   *
   * <ul>
   *   <li>Then return {@link Object}.
   * </ul>
   *
   * <p>Method under test: {@link EntityConfiguration#lookupEntityClass(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Class EntityConfiguration.lookupEntityClass(String)"})
  public void testLookupEntityClassWithBeanId_thenReturnObject() throws BeansException {
    // Arrange
    when(applicationContext.getBean(Mockito.<String>any())).thenReturn(BLCFieldUtils.NULL_FIELD);

    // Act
    Class<?> actualLookupEntityClassResult = entityConfiguration.lookupEntityClass("42");

    // Assert
    verify(applicationContext).getBean("42");
    Class<Object> expectedLookupEntityClassResult = Object.class;
    assertEquals(expectedLookupEntityClassResult, actualLookupEntityClassResult);
  }

  /**
   * Test {@link EntityConfiguration#lookupEntityClass(String)} with {@code beanId}.
   *
   * <ul>
   *   <li>Then throw {@link FactoryBeanNotInitializedException}.
   * </ul>
   *
   * <p>Method under test: {@link EntityConfiguration#lookupEntityClass(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Class EntityConfiguration.lookupEntityClass(String)"})
  public void testLookupEntityClassWithBeanId_thenThrowFactoryBeanNotInitializedException()
      throws BeansException {
    // Arrange
    when(applicationContext.getBean(Mockito.<String>any()))
        .thenThrow(new FactoryBeanNotInitializedException());

    // Act and Assert
    assertThrows(
        FactoryBeanNotInitializedException.class,
        () -> entityConfiguration.lookupEntityClass("42"));
    verify(applicationContext).getBean("42");
  }

  /**
   * Test {@link EntityConfiguration#getEntityBeanNames()}.
   *
   * <ul>
   *   <li>Then return array of {@link String} with {@code Bean Definition Names}.
   * </ul>
   *
   * <p>Method under test: {@link EntityConfiguration#getEntityBeanNames()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String[] EntityConfiguration.getEntityBeanNames()"})
  public void testGetEntityBeanNames_thenReturnArrayOfStringWithBeanDefinitionNames() {
    // Arrange
    when(applicationContext.getBeanDefinitionNames())
        .thenReturn(new String[] {"Bean Definition Names"});

    // Act
    String[] actualEntityBeanNames = entityConfiguration.getEntityBeanNames();

    // Assert
    verify(applicationContext).getBeanDefinitionNames();
    assertArrayEquals(new String[] {"Bean Definition Names"}, actualEntityBeanNames);
  }

  /**
   * Test {@link EntityConfiguration#getEntityBeanNames()}.
   *
   * <ul>
   *   <li>Then throw {@link FactoryBeanNotInitializedException}.
   * </ul>
   *
   * <p>Method under test: {@link EntityConfiguration#getEntityBeanNames()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String[] EntityConfiguration.getEntityBeanNames()"})
  public void testGetEntityBeanNames_thenThrowFactoryBeanNotInitializedException() {
    // Arrange
    when(applicationContext.getBeanDefinitionNames())
        .thenThrow(new FactoryBeanNotInitializedException());

    // Act and Assert
    assertThrows(
        FactoryBeanNotInitializedException.class, () -> entityConfiguration.getEntityBeanNames());
    verify(applicationContext).getBeanDefinitionNames();
  }

  /**
   * Test {@link EntityConfiguration#createEntityInstance(String)} with {@code beanId}.
   *
   * <p>Method under test: {@link EntityConfiguration#createEntityInstance(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Object EntityConfiguration.createEntityInstance(String)"})
  public void testCreateEntityInstanceWithBeanId() throws BeansException {
    // Arrange
    when(applicationContext.getBean(Mockito.<String>any())).thenReturn(BLCFieldUtils.NULL_FIELD);

    // Act
    entityConfiguration.createEntityInstance("42");

    // Assert
    verify(applicationContext).getBean("42");
  }

  /**
   * Test {@link EntityConfiguration#createEntityInstance(String, Class)} with {@code beanId},
   * {@code resultClass}.
   *
   * <p>Method under test: {@link EntityConfiguration#createEntityInstance(String, Class)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Object EntityConfiguration.createEntityInstance(String, Class)"})
  public void testCreateEntityInstanceWithBeanIdResultClass() throws BeansException {
    // Arrange
    when(applicationContext.getBean(Mockito.<String>any())).thenReturn(BLCFieldUtils.NULL_FIELD);
    Class<Object> resultClass = Object.class;

    // Act
    entityConfiguration.createEntityInstance("42", resultClass);

    // Assert
    verify(applicationContext).getBean("42");
  }

  /**
   * Test {@link EntityConfiguration#createEntityInstance(String, Class)} with {@code beanId},
   * {@code resultClass}.
   *
   * <p>Method under test: {@link EntityConfiguration#createEntityInstance(String, Class)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Object EntityConfiguration.createEntityInstance(String, Class)"})
  public void testCreateEntityInstanceWithBeanIdResultClass2() throws BeansException {
    // Arrange
    when(applicationContext.getBean(Mockito.<String>any()))
        .thenThrow(new FactoryBeanNotInitializedException());
    Class<Object> resultClass = Object.class;

    // Act and Assert
    assertThrows(
        FactoryBeanNotInitializedException.class,
        () -> entityConfiguration.createEntityInstance("42", resultClass));
    verify(applicationContext).getBean("42");
  }

  /**
   * Test {@link EntityConfiguration#createEntityInstance(String)} with {@code beanId}.
   *
   * <ul>
   *   <li>Then throw {@link FactoryBeanNotInitializedException}.
   * </ul>
   *
   * <p>Method under test: {@link EntityConfiguration#createEntityInstance(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Object EntityConfiguration.createEntityInstance(String)"})
  public void testCreateEntityInstanceWithBeanId_thenThrowFactoryBeanNotInitializedException()
      throws BeansException {
    // Arrange
    when(applicationContext.getBean(Mockito.<String>any()))
        .thenThrow(new FactoryBeanNotInitializedException());

    // Act and Assert
    assertThrows(
        FactoryBeanNotInitializedException.class,
        () -> entityConfiguration.createEntityInstance("42"));
    verify(applicationContext).getBean("42");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityConfiguration#setApplicationContext(ApplicationContext)}
   *   <li>{@link EntityConfiguration#setEntityContexts(Resource[])}
   *   <li>{@link EntityConfiguration#getEntityContexts()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Resource[] EntityConfiguration.getEntityContexts()",
    "void EntityConfiguration.setApplicationContext(ApplicationContext)",
    "void EntityConfiguration.setEntityContexts(Resource[])"
  })
  public void testGettersAndSetters() throws BeansException {
    // Arrange
    EntityConfiguration entityConfiguration = new EntityConfiguration();

    // Act
    entityConfiguration.setApplicationContext(mock(ApplicationContext.class));
    Resource[] entityContexts = new Resource[] {new GeneratedResource()};
    entityConfiguration.setEntityContexts(entityContexts);

    // Assert
    assertSame(entityContexts, entityConfiguration.getEntityContexts());
  }
}
