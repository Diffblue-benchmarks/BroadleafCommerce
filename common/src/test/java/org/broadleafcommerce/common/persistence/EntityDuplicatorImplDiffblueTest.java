package org.broadleafcommerce.common.persistence;

import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.common.service.GenericEntityService;
import org.broadleafcommerce.common.util.BLCFieldUtils;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;

@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(MockitoJUnitRunner.class)
public class EntityDuplicatorImplDiffblueTest {
  @InjectMocks private EntityDuplicatorImpl entityDuplicatorImpl;

  @Mock private GenericEntityService genericEntityService;

  /**
   * Test {@link EntityDuplicatorImpl#copy(Class, Long)} with {@code entityClass}, {@code id}.
   *
   * <p>Method under test: {@link EntityDuplicatorImpl#copy(Class, Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Object EntityDuplicatorImpl.copy(Class, Long)"})
  public void testCopyWithEntityClassId() {
    // Arrange
    doThrow(new UnsupportedOperationException()).when(genericEntityService).flush();
    Class<Object> entityClass = Object.class;

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class, () -> entityDuplicatorImpl.copy(entityClass, 1L));
    verify(genericEntityService).flush();
  }

  /**
   * Test {@link EntityDuplicatorImpl#copy(Class, Long)} with {@code entityClass}, {@code id}.
   *
   * <ul>
   *   <li>When {@code Object}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link EntityDuplicatorImpl#copy(Class, Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Object EntityDuplicatorImpl.copy(Class, Long)"})
  public void testCopyWithEntityClassId_whenJavaLangObject_thenThrowIllegalArgumentException() {
    // Arrange
    when(genericEntityService.readGenericEntity(eq(Object.class), Mockito.<Object>any()))
        .thenReturn(BLCFieldUtils.NULL_FIELD);
    doNothing().when(genericEntityService).clear();
    doNothing().when(genericEntityService).flush();
    Class<Object> entityClass = Object.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> entityDuplicatorImpl.copy(entityClass, 1L));
    verify(genericEntityService).clear();
    verify(genericEntityService).flush();
    verify(genericEntityService).readGenericEntity(isA(Class.class), isA(Object.class));
  }
}
