package org.broadleafcommerce.openadmin.server.service;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.Map;
import org.broadleafcommerce.openadmin.server.service.extension.AbstractAdminSectionCustomCriteriaExtensionHandler;
import org.broadleafcommerce.openadmin.server.service.extension.AdminSectionCustomCriteriaExtensionManager;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class AdminSectionCustomCriteriaServiceImplDiffblueTest {
  @Mock
  private AdminSectionCustomCriteriaExtensionManager adminSectionCustomCriteriaExtensionManager;

  @InjectMocks private AdminSectionCustomCriteriaServiceImpl adminSectionCustomCriteriaServiceImpl;

  @Mock private Map<String, ArrayList<String>> map;

  /**
   * Test {@link AdminSectionCustomCriteriaServiceImpl#mergeSectionCustomCriteria(String,
   * String[])}.
   *
   * <ul>
   *   <li>Then return array length is zero.
   * </ul>
   *
   * <p>Method under test: {@link
   * AdminSectionCustomCriteriaServiceImpl#mergeSectionCustomCriteria(String, String[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String[] AdminSectionCustomCriteriaServiceImpl.mergeSectionCustomCriteria(String, String[])"
  })
  public void testMergeSectionCustomCriteria_thenReturnArrayLengthIsZero() {
    // Arrange
    when(map.get(Mockito.<Object>any())).thenReturn(new ArrayList<>());
    when(adminSectionCustomCriteriaExtensionManager.getProxy())
        .thenReturn(new AbstractAdminSectionCustomCriteriaExtensionHandler());

    // Act
    String[] actualMergeSectionCustomCriteriaResult =
        adminSectionCustomCriteriaServiceImpl.mergeSectionCustomCriteria(
            "Ceiling Entity Class Name", null);

    // Assert
    verify(map).get(isA(Object.class));
    verify(adminSectionCustomCriteriaExtensionManager).getProxy();
    assertEquals(0, actualMergeSectionCustomCriteriaResult.length);
  }

  /**
   * Test {@link AdminSectionCustomCriteriaServiceImpl#mergeSectionCustomCriteria(String,
   * String[])}.
   *
   * <ul>
   *   <li>Then return array of {@link String} with {@code Controller Criteria}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AdminSectionCustomCriteriaServiceImpl#mergeSectionCustomCriteria(String, String[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String[] AdminSectionCustomCriteriaServiceImpl.mergeSectionCustomCriteria(String, String[])"
  })
  public void testMergeSectionCustomCriteria_thenReturnArrayOfStringWithControllerCriteria() {
    // Arrange
    when(map.get(Mockito.<Object>any())).thenReturn(new ArrayList<>());
    when(adminSectionCustomCriteriaExtensionManager.getProxy())
        .thenReturn(new AbstractAdminSectionCustomCriteriaExtensionHandler());

    // Act
    String[] actualMergeSectionCustomCriteriaResult =
        adminSectionCustomCriteriaServiceImpl.mergeSectionCustomCriteria(
            "Ceiling Entity Class Name", new String[] {"Controller Criteria"});

    // Assert
    verify(map).get(isA(Object.class));
    verify(adminSectionCustomCriteriaExtensionManager).getProxy();
    assertArrayEquals(new String[] {"Controller Criteria"}, actualMergeSectionCustomCriteriaResult);
  }

  /**
   * Test {@link AdminSectionCustomCriteriaServiceImpl#mergeSectionCustomCriteria(String,
   * String[])}.
   *
   * <ul>
   *   <li>Then return array of {@link String} with {@code Controller Criteria}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AdminSectionCustomCriteriaServiceImpl#mergeSectionCustomCriteria(String, String[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String[] AdminSectionCustomCriteriaServiceImpl.mergeSectionCustomCriteria(String, String[])"
  })
  public void testMergeSectionCustomCriteria_thenReturnArrayOfStringWithControllerCriteria2() {
    // Arrange
    when(map.get(Mockito.<Object>any())).thenReturn(new ArrayList<>());

    // Act
    String[] actualMergeSectionCustomCriteriaResult =
        adminSectionCustomCriteriaServiceImpl.mergeSectionCustomCriteria(
            null, new String[] {"Controller Criteria"});

    // Assert
    verify(map).get(isNull());
    assertArrayEquals(new String[] {"Controller Criteria"}, actualMergeSectionCustomCriteriaResult);
  }
}
