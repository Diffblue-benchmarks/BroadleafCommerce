/*-
 * #%L
 * BroadleafCommerce Common Libraries
 * %%
 * Copyright (C) 2009 - 2024 Broadleaf Commerce
 * %%
 * Licensed under the Broadleaf Fair Use License Agreement, Version 1.0
 * (the "Fair Use License" located  at http://license.broadleafcommerce.org/fair_use_license-1.0.txt)
 * unless the restrictions on use therein are violated and require payment to Broadleaf in which case
 * the Broadleaf End User License Agreement (EULA), Version 1.1
 * (the "Commercial License" located at http://license.broadleafcommerce.org/commercial_license-1.1.txt)
 * shall apply.
 * 
 * Alternatively, the Commercial License may be replaced with a mutually agreed upon license (the "Custom License")
 * between you and Broadleaf Commerce. You may not use this file except in compliance with the applicable license.
 * #L%
 */
package org.broadleafcommerce.common.extensibility.jpa.convert;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Properties;
import org.broadleafcommerce.common.extensibility.jpa.copy.DirectCopyIgnorePattern;
import org.broadleafcommerce.common.util.BLCFieldUtils;
import org.junit.Test;
import org.mockito.Mockito;

public class EntityMarkerClassTransformerDiffblueTest {
  /**
   * Test {@link EntityMarkerClassTransformer#isIgnored(String)}.
   * <ul>
   *   <li>Given {@link DirectCopyIgnorePattern} (default constructor) Patterns is
   * array of {@link String} with {@code Patterns}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityMarkerClassTransformer#isIgnored(String)}
   */
  @Test
  public void testIsIgnored_givenDirectCopyIgnorePatternPatternsIsArrayOfStringWithPatterns() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DirectCopyIgnorePattern directCopyIgnorePattern = new DirectCopyIgnorePattern();
    directCopyIgnorePattern.setPatterns(new String[]{"Patterns"});
    directCopyIgnorePattern.setTemplateTokenPatterns(null);

    ArrayList<DirectCopyIgnorePattern> ignorePatterns = new ArrayList<>();
    ignorePatterns.add(directCopyIgnorePattern);

    EntityMarkerClassTransformer entityMarkerClassTransformer = new EntityMarkerClassTransformer();
    entityMarkerClassTransformer.setIgnorePatterns(ignorePatterns);

    // Act and Assert
    assertFalse(entityMarkerClassTransformer.isIgnored("Converted Class Name"));
  }

  /**
   * Test {@link EntityMarkerClassTransformer#isIgnored(String)}.
   * <ul>
   *   <li>Given {@link EntityMarkerClassTransformer} (default constructor).</li>
   *   <li>When {@code Converted Class Name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityMarkerClassTransformer#isIgnored(String)}
   */
  @Test
  public void testIsIgnored_givenEntityMarkerClassTransformer_whenConvertedClassName() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new EntityMarkerClassTransformer()).isIgnored("Converted Class Name"));
  }

  /**
   * Test {@link EntityMarkerClassTransformer#isIgnored(String)}.
   * <ul>
   *   <li>Then calls {@link DirectCopyIgnorePattern#getPatterns()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityMarkerClassTransformer#isIgnored(String)}
   */
  @Test
  public void testIsIgnored_thenCallsGetPatterns() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DirectCopyIgnorePattern directCopyIgnorePattern = mock(DirectCopyIgnorePattern.class);
    when(directCopyIgnorePattern.getPatterns()).thenReturn(new String[]{"Patterns"});
    doNothing().when(directCopyIgnorePattern).setPatterns(Mockito.<String[]>any());
    doNothing().when(directCopyIgnorePattern).setTemplateTokenPatterns(Mockito.<String[]>any());
    directCopyIgnorePattern.setPatterns(new String[]{"Patterns"});
    directCopyIgnorePattern.setTemplateTokenPatterns(null);

    ArrayList<DirectCopyIgnorePattern> ignorePatterns = new ArrayList<>();
    ignorePatterns.add(directCopyIgnorePattern);

    EntityMarkerClassTransformer entityMarkerClassTransformer = new EntityMarkerClassTransformer();
    entityMarkerClassTransformer.setIgnorePatterns(ignorePatterns);

    // Act
    boolean actualIsIgnoredResult = entityMarkerClassTransformer.isIgnored("Converted Class Name");

    // Assert
    verify(directCopyIgnorePattern).getPatterns();
    verify(directCopyIgnorePattern).setPatterns(isA(String[].class));
    verify(directCopyIgnorePattern).setTemplateTokenPatterns(isNull());
    assertFalse(actualIsIgnoredResult);
  }

  /**
   * Test {@link EntityMarkerClassTransformer#isIgnored(String)}.
   * <ul>
   *   <li>Then calls
   * {@link DirectCopyIgnorePattern#getTemplateTokenPatterns()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityMarkerClassTransformer#isIgnored(String)}
   */
  @Test
  public void testIsIgnored_thenCallsGetTemplateTokenPatterns() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DirectCopyIgnorePattern directCopyIgnorePattern = mock(DirectCopyIgnorePattern.class);
    when(directCopyIgnorePattern.getTemplateTokenPatterns()).thenReturn(new String[]{"ABC123"});
    when(directCopyIgnorePattern.getPatterns()).thenReturn(new String[]{"Patterns"});
    doNothing().when(directCopyIgnorePattern).setPatterns(Mockito.<String[]>any());
    doNothing().when(directCopyIgnorePattern).setTemplateTokenPatterns(Mockito.<String[]>any());
    directCopyIgnorePattern.setPatterns(new String[]{"Patterns"});
    directCopyIgnorePattern.setTemplateTokenPatterns(null);

    ArrayList<DirectCopyIgnorePattern> ignorePatterns = new ArrayList<>();
    ignorePatterns.add(directCopyIgnorePattern);

    EntityMarkerClassTransformer entityMarkerClassTransformer = new EntityMarkerClassTransformer();
    entityMarkerClassTransformer.setIgnorePatterns(ignorePatterns);

    // Act
    boolean actualIsIgnoredResult = entityMarkerClassTransformer.isIgnored("Patterns");

    // Assert
    verify(directCopyIgnorePattern).getPatterns();
    verify(directCopyIgnorePattern).getTemplateTokenPatterns();
    verify(directCopyIgnorePattern).setPatterns(isA(String[].class));
    verify(directCopyIgnorePattern).setTemplateTokenPatterns(isNull());
    assertFalse(actualIsIgnoredResult);
  }

  /**
   * Test {@link EntityMarkerClassTransformer#isIgnored(String)}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityMarkerClassTransformer#isIgnored(String)}
   */
  @Test
  public void testIsIgnored_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DirectCopyIgnorePattern directCopyIgnorePattern = mock(DirectCopyIgnorePattern.class);
    when(directCopyIgnorePattern.getTemplateTokenPatterns()).thenReturn(null);
    when(directCopyIgnorePattern.getPatterns()).thenReturn(new String[]{"Patterns"});
    doNothing().when(directCopyIgnorePattern).setPatterns(Mockito.<String[]>any());
    doNothing().when(directCopyIgnorePattern).setTemplateTokenPatterns(Mockito.<String[]>any());
    directCopyIgnorePattern.setPatterns(new String[]{"Patterns"});
    directCopyIgnorePattern.setTemplateTokenPatterns(null);

    ArrayList<DirectCopyIgnorePattern> ignorePatterns = new ArrayList<>();
    ignorePatterns.add(directCopyIgnorePattern);

    EntityMarkerClassTransformer entityMarkerClassTransformer = new EntityMarkerClassTransformer();
    entityMarkerClassTransformer.setIgnorePatterns(ignorePatterns);

    // Act
    boolean actualIsIgnoredResult = entityMarkerClassTransformer.isIgnored("Patterns");

    // Assert
    verify(directCopyIgnorePattern).getPatterns();
    verify(directCopyIgnorePattern).getTemplateTokenPatterns();
    verify(directCopyIgnorePattern).setPatterns(isA(String[].class));
    verify(directCopyIgnorePattern).setTemplateTokenPatterns(isNull());
    assertTrue(actualIsIgnoredResult);
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link EntityMarkerClassTransformer}
   *   <li>{@link EntityMarkerClassTransformer#setIgnorePatterns(List)}
   *   <li>
   * {@link EntityMarkerClassTransformer#compileJPAProperties(Properties, Object)}
   *   <li>{@link EntityMarkerClassTransformer#getIgnorePatterns()}
   *   <li>{@link EntityMarkerClassTransformer#getTransformedEntityClassNames()}
   *   <li>{@link EntityMarkerClassTransformer#getTransformedNonEntityClassNames()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() throws Exception {
    // Arrange and Act
    EntityMarkerClassTransformer actualEntityMarkerClassTransformer = new EntityMarkerClassTransformer();
    ArrayList<DirectCopyIgnorePattern> ignorePatterns = new ArrayList<>();
    actualEntityMarkerClassTransformer.setIgnorePatterns(ignorePatterns);
    actualEntityMarkerClassTransformer.compileJPAProperties(new Properties(), BLCFieldUtils.NULL_FIELD);
    List<DirectCopyIgnorePattern> actualIgnorePatterns = actualEntityMarkerClassTransformer.getIgnorePatterns();
    HashSet<String> actualTransformedEntityClassNames = actualEntityMarkerClassTransformer
        .getTransformedEntityClassNames();
    HashSet<String> actualTransformedNonEntityClassNames = actualEntityMarkerClassTransformer
        .getTransformedNonEntityClassNames();

    // Assert that nothing has changed
    assertTrue(actualTransformedEntityClassNames.isEmpty());
    assertTrue(actualTransformedNonEntityClassNames.isEmpty());
    assertTrue(actualIgnorePatterns.isEmpty());
    assertSame(ignorePatterns, actualIgnorePatterns);
  }
}
