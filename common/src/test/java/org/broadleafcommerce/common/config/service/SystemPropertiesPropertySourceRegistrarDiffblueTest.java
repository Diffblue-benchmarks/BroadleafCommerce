package org.broadleafcommerce.common.config.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.common.config.service.SystemPropertiesPropertySourceRegistrar.SystemPropertyPropertySource;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.Mockito;

public class SystemPropertiesPropertySourceRegistrarDiffblueTest {
  /**
   * Test SystemPropertyPropertySource {@link SystemPropertyPropertySource#getProperty(String)}.
   *
   * <ul>
   *   <li>Then return {@code Resolve System Property}.
   * </ul>
   *
   * <p>Method under test: {@link SystemPropertyPropertySource#getProperty(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Object SystemPropertyPropertySource.getProperty(String)"})
  public void testSystemPropertyPropertySourceGetProperty_thenReturnResolveSystemProperty() {
    // Arrange
    SystemPropertiesServiceImpl source = mock(SystemPropertiesServiceImpl.class);
    when(source.resolveSystemProperty(Mockito.<String>any())).thenReturn("Resolve System Property");
    SystemPropertyPropertySource systemPropertyPropertySource =
        new SystemPropertyPropertySource("Name", source);

    // Act
    Object actualProperty = systemPropertyPropertySource.getProperty("Name");

    // Assert
    verify(source).resolveSystemProperty("Name");
    assertEquals("Resolve System Property", actualProperty);
  }
}
