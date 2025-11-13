package org.broadleafcommerce.openadmin.server.service.persistence.validation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.broadleafcommerce.openadmin.dto.Entity;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;

@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(MockitoJUnitRunner.class)
public class EntityValidatorServiceImplDiffblueTest {
  @Mock private ApplicationContext applicationContext;

  @InjectMocks private EntityValidatorServiceImpl entityValidatorServiceImpl;

  /**
   * Test {@link EntityValidatorServiceImpl#populateBroadleafValidatorMap()}.
   *
   * <p>Method under test: {@link EntityValidatorServiceImpl#populateBroadleafValidatorMap()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void EntityValidatorServiceImpl.populateBroadleafValidatorMap()"})
  public void testPopulateBroadleafValidatorMap() {
    // Arrange
    when(applicationContext.getBeanNamesForType(Mockito.<Class<?>>any()))
        .thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(
        RuntimeException.class, () -> entityValidatorServiceImpl.populateBroadleafValidatorMap());
    verify(applicationContext).getBeanNamesForType(isA(Class.class));
  }

  /**
   * Test {@link EntityValidatorServiceImpl#populateBroadleafValidatorMap()}.
   *
   * <p>Method under test: {@link EntityValidatorServiceImpl#populateBroadleafValidatorMap()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void EntityValidatorServiceImpl.populateBroadleafValidatorMap()"})
  public void testPopulateBroadleafValidatorMap2() throws BeansException {
    // Arrange
    when(applicationContext.getBean(Mockito.<String>any(), eq(BroadleafEntityValidator.class)))
        .thenThrow(new RuntimeException());
    when(applicationContext.getBeanNamesForType(Mockito.<Class<?>>any()))
        .thenReturn(new String[] {"Bean Names For Type"});

    // Act and Assert
    assertThrows(
        RuntimeException.class, () -> entityValidatorServiceImpl.populateBroadleafValidatorMap());
    verify(applicationContext).getBean(eq("Bean Names For Type"), isA(Class.class));
    verify(applicationContext).getBeanNamesForType(isA(Class.class));
  }

  /**
   * Test {@link EntityValidatorServiceImpl#populateBroadleafValidatorMap()}.
   *
   * <p>Method under test: {@link EntityValidatorServiceImpl#populateBroadleafValidatorMap()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void EntityValidatorServiceImpl.populateBroadleafValidatorMap()"})
  public void testPopulateBroadleafValidatorMap3() {
    // Arrange
    when(applicationContext.getBeanNamesForType(Mockito.<Class<?>>any()))
        .thenReturn(new String[] {});

    // Act
    entityValidatorServiceImpl.populateBroadleafValidatorMap();

    // Assert
    verify(applicationContext).getBeanNamesForType(isA(Class.class));
  }

  /**
   * Test {@link EntityValidatorServiceImpl#populateBroadleafValidatorMap()}.
   *
   * <p>Method under test: {@link EntityValidatorServiceImpl#populateBroadleafValidatorMap()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void EntityValidatorServiceImpl.populateBroadleafValidatorMap()"})
  public void testPopulateBroadleafValidatorMap4() throws BeansException {
    // Arrange
    when(applicationContext.getBean(Mockito.<String>any(), eq(BroadleafEntityValidator.class)))
        .thenReturn(mock(BroadleafEntityValidator.class));
    when(applicationContext.getBeanNamesForType(Mockito.<Class<?>>any()))
        .thenReturn(new String[] {"foo"});

    // Act
    entityValidatorServiceImpl.populateBroadleafValidatorMap();

    // Assert
    verify(applicationContext).getBean(eq("foo"), isA(Class.class));
    verify(applicationContext).getBeanNamesForType(isA(Class.class));
  }

  /**
   * Test {@link EntityValidatorServiceImpl#getTypeHierarchy(Entity)}.
   *
   * <ul>
   *   <li>Given array of {@link String} with {@code Type}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link EntityValidatorServiceImpl#getTypeHierarchy(Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List EntityValidatorServiceImpl.getTypeHierarchy(Entity)"})
  public void testGetTypeHierarchy_givenArrayOfStringWithType_thenThrowRuntimeException() {
    // Arrange
    EntityValidatorServiceImpl entityValidatorServiceImpl = new EntityValidatorServiceImpl();

    Entity entity = mock(Entity.class);
    when(entity.getType()).thenReturn(new String[] {"Type"});

    // Act and Assert
    assertThrows(RuntimeException.class, () -> entityValidatorServiceImpl.getTypeHierarchy(entity));
    verify(entity).getType();
  }

  /**
   * Test {@link EntityValidatorServiceImpl#getTypeHierarchy(Entity)}.
   *
   * <ul>
   *   <li>Then return first is {@code Entity}.
   * </ul>
   *
   * <p>Method under test: {@link EntityValidatorServiceImpl#getTypeHierarchy(Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List EntityValidatorServiceImpl.getTypeHierarchy(Entity)"})
  public void testGetTypeHierarchy_thenReturnFirstIsOrgBroadleafcommerceOpenadminDtoEntity() {
    // Arrange
    EntityValidatorServiceImpl entityValidatorServiceImpl = new EntityValidatorServiceImpl();

    Entity entity = mock(Entity.class);
    when(entity.getType()).thenReturn(new String[] {"org.broadleafcommerce.openadmin.dto.Entity"});

    // Act
    List<String> actualTypeHierarchy = entityValidatorServiceImpl.getTypeHierarchy(entity);

    // Assert
    verify(entity).getType();
    assertEquals(1, actualTypeHierarchy.size());
    assertEquals("org.broadleafcommerce.openadmin.dto.Entity", actualTypeHierarchy.get(0));
  }

  /**
   * Test {@link EntityValidatorServiceImpl#getTypeHierarchy(Entity)}.
   *
   * <ul>
   *   <li>When {@link Entity} {@link Entity#getType()} return array of {@link String} with {@code
   *       List}.
   * </ul>
   *
   * <p>Method under test: {@link EntityValidatorServiceImpl#getTypeHierarchy(Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List EntityValidatorServiceImpl.getTypeHierarchy(Entity)"})
  public void testGetTypeHierarchy_whenEntityGetTypeReturnArrayOfStringWithJavaUtilList() {
    // Arrange
    EntityValidatorServiceImpl entityValidatorServiceImpl = new EntityValidatorServiceImpl();

    Entity entity = mock(Entity.class);
    when(entity.getType()).thenReturn(new String[] {"java.util.List"});

    // Act
    List<String> actualTypeHierarchy = entityValidatorServiceImpl.getTypeHierarchy(entity);

    // Assert
    verify(entity).getType();
    assertEquals(1, actualTypeHierarchy.size());
    assertEquals("java.util.List", actualTypeHierarchy.get(0));
  }

  /**
   * Test {@link EntityValidatorServiceImpl#getTypeHierarchy(Entity)}.
   *
   * <ul>
   *   <li>When {@link Entity} (default constructor) Type is array of {@link String} with {@code
   *       List}.
   * </ul>
   *
   * <p>Method under test: {@link EntityValidatorServiceImpl#getTypeHierarchy(Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List EntityValidatorServiceImpl.getTypeHierarchy(Entity)"})
  public void testGetTypeHierarchy_whenEntityTypeIsArrayOfStringWithJavaUtilList() {
    // Arrange
    Entity entity = new Entity();
    entity.setType(new String[] {"java.util.List"});

    // Act
    List<String> actualTypeHierarchy = entityValidatorServiceImpl.getTypeHierarchy(entity);

    // Assert
    assertEquals(1, actualTypeHierarchy.size());
    assertEquals("java.util.List", actualTypeHierarchy.get(0));
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityValidatorServiceImpl#setGlobalEntityValidators(List)}
   *   <li>{@link EntityValidatorServiceImpl#getGlobalEntityValidators()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List EntityValidatorServiceImpl.getGlobalEntityValidators()",
    "void EntityValidatorServiceImpl.setGlobalEntityValidators(List)"
  })
  public void testGettersAndSetters() {
    // Arrange
    EntityValidatorServiceImpl entityValidatorServiceImpl = new EntityValidatorServiceImpl();
    ArrayList<GlobalPropertyValidator> globalEntityValidators = new ArrayList<>();

    // Act
    entityValidatorServiceImpl.setGlobalEntityValidators(globalEntityValidators);
    List<GlobalPropertyValidator> actualGlobalEntityValidators =
        entityValidatorServiceImpl.getGlobalEntityValidators();

    // Assert
    assertTrue(actualGlobalEntityValidators.isEmpty());
    assertSame(globalEntityValidators, actualGlobalEntityValidators);
  }
}
