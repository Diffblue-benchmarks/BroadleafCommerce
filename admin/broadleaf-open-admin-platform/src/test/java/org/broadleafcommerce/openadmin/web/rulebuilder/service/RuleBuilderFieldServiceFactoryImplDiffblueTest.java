/*-
 * #%L
 * BroadleafCommerce Open Admin Platform
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
package org.broadleafcommerce.openadmin.web.rulebuilder.service;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class RuleBuilderFieldServiceFactoryImplDiffblueTest {
  /**
   * Test {@link RuleBuilderFieldServiceFactoryImpl#createInstance(String)}.
   * <ul>
   *   <li>Given {@link RuleBuilderFieldService}
   * {@link RuleBuilderFieldService#getName()} return {@code Name}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RuleBuilderFieldServiceFactoryImpl#createInstance(String)}
   */
  @Test
  public void testCreateInstance_givenRuleBuilderFieldServiceGetNameReturnName_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RuleBuilderFieldService ruleBuilderFieldService = mock(RuleBuilderFieldService.class);
    when(ruleBuilderFieldService.getName()).thenReturn("Name");

    ArrayList<RuleBuilderFieldService> fieldServices = new ArrayList<>();
    fieldServices.add(ruleBuilderFieldService);

    RuleBuilderFieldServiceFactoryImpl ruleBuilderFieldServiceFactoryImpl = new RuleBuilderFieldServiceFactoryImpl();
    ruleBuilderFieldServiceFactoryImpl.setFieldServices(fieldServices);

    // Act
    RuleBuilderFieldService actualCreateInstanceResult = ruleBuilderFieldServiceFactoryImpl.createInstance("Name");

    // Assert
    verify(ruleBuilderFieldService).getName();
    assertNull(actualCreateInstanceResult);
  }

  /**
   * Test {@link RuleBuilderFieldServiceFactoryImpl#createInstance(String)}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RuleBuilderFieldServiceFactoryImpl#createInstance(String)}
   */
  @Test
  public void testCreateInstance_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RuleBuilderFieldServiceFactoryImpl ruleBuilderFieldServiceFactoryImpl = new RuleBuilderFieldServiceFactoryImpl();
    ruleBuilderFieldServiceFactoryImpl.setFieldServices(new ArrayList<>());

    // Act and Assert
    assertNull(ruleBuilderFieldServiceFactoryImpl.createInstance("Name"));
  }

  /**
   * Test {@link RuleBuilderFieldServiceFactoryImpl#createInstance(String)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RuleBuilderFieldServiceFactoryImpl#createInstance(String)}
   */
  @Test
  public void testCreateInstance_thenThrowRuntimeException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RuleBuilderFieldService ruleBuilderFieldService = mock(RuleBuilderFieldService.class);
    when(ruleBuilderFieldService.getName()).thenReturn("Name");
    RuleBuilderFieldService ruleBuilderFieldService2 = mock(RuleBuilderFieldService.class);
    when(ruleBuilderFieldService2.getName()).thenReturn("Name");
    RuleBuilderFieldService ruleBuilderFieldService3 = mock(RuleBuilderFieldService.class);
    when(ruleBuilderFieldService3.getName()).thenReturn("Name");
    RuleBuilderFieldService ruleBuilderFieldService4 = mock(RuleBuilderFieldService.class);
    when(ruleBuilderFieldService4.getName()).thenReturn("Name");
    RuleBuilderFieldService ruleBuilderFieldService5 = mock(RuleBuilderFieldService.class);
    when(ruleBuilderFieldService5.getName()).thenReturn("Name");
    RuleBuilderFieldService ruleBuilderFieldService6 = mock(RuleBuilderFieldService.class);
    when(ruleBuilderFieldService6.getName()).thenReturn("Name");
    RuleBuilderFieldService ruleBuilderFieldService7 = mock(RuleBuilderFieldService.class);
    when(ruleBuilderFieldService7.getName()).thenReturn("Name");
    RuleBuilderFieldService ruleBuilderFieldService8 = mock(RuleBuilderFieldService.class);
    when(ruleBuilderFieldService8.getName()).thenReturn("Name");
    RuleBuilderFieldService ruleBuilderFieldService9 = mock(RuleBuilderFieldService.class);
    when(ruleBuilderFieldService9.getName()).thenReturn("Name");
    RuleBuilderFieldService ruleBuilderFieldService10 = mock(RuleBuilderFieldService.class);
    when(ruleBuilderFieldService10.getName()).thenReturn("Name");
    RuleBuilderFieldService ruleBuilderFieldService11 = mock(RuleBuilderFieldService.class);
    when(ruleBuilderFieldService11.getName()).thenReturn("Name");
    RuleBuilderFieldService ruleBuilderFieldService12 = mock(RuleBuilderFieldService.class);
    when(ruleBuilderFieldService12.getName()).thenReturn("Name");
    RuleBuilderFieldService ruleBuilderFieldService13 = mock(RuleBuilderFieldService.class);
    when(ruleBuilderFieldService13.getName()).thenReturn("Name");
    RuleBuilderFieldService ruleBuilderFieldService14 = mock(RuleBuilderFieldService.class);
    when(ruleBuilderFieldService14.getName()).thenReturn("Name");
    RuleBuilderFieldService ruleBuilderFieldService15 = mock(RuleBuilderFieldService.class);
    when(ruleBuilderFieldService15.getName()).thenReturn("Name");
    RuleBuilderFieldService ruleBuilderFieldService16 = mock(RuleBuilderFieldService.class);
    when(ruleBuilderFieldService16.getName()).thenReturn("Name");
    RuleBuilderFieldService ruleBuilderFieldService17 = mock(RuleBuilderFieldService.class);
    when(ruleBuilderFieldService17.getName()).thenReturn("Name");
    RuleBuilderFieldService ruleBuilderFieldService18 = mock(RuleBuilderFieldService.class);
    when(ruleBuilderFieldService18.getName()).thenReturn("Name");
    RuleBuilderFieldService ruleBuilderFieldService19 = mock(RuleBuilderFieldService.class);
    when(ruleBuilderFieldService19.getName()).thenReturn("Name");
    RuleBuilderFieldService ruleBuilderFieldService20 = mock(RuleBuilderFieldService.class);
    when(ruleBuilderFieldService20.getName()).thenReturn("Name");
    RuleBuilderFieldService ruleBuilderFieldService21 = mock(RuleBuilderFieldService.class);
    when(ruleBuilderFieldService21.getName()).thenReturn("Name");
    RuleBuilderFieldService ruleBuilderFieldService22 = mock(RuleBuilderFieldService.class);
    when(ruleBuilderFieldService22.getName()).thenReturn("Name");
    RuleBuilderFieldService ruleBuilderFieldService23 = mock(RuleBuilderFieldService.class);
    when(ruleBuilderFieldService23.getName()).thenReturn("Name");
    RuleBuilderFieldService ruleBuilderFieldService24 = mock(RuleBuilderFieldService.class);
    when(ruleBuilderFieldService24.getName()).thenReturn("Name");
    RuleBuilderFieldService ruleBuilderFieldService25 = mock(RuleBuilderFieldService.class);
    when(ruleBuilderFieldService25.getName()).thenReturn("Name");
    RuleBuilderFieldService ruleBuilderFieldService26 = mock(RuleBuilderFieldService.class);
    when(ruleBuilderFieldService26.getName()).thenReturn("Name");
    RuleBuilderFieldService ruleBuilderFieldService27 = mock(RuleBuilderFieldService.class);
    when(ruleBuilderFieldService27.getName()).thenReturn("Name");
    RuleBuilderFieldService ruleBuilderFieldService28 = mock(RuleBuilderFieldService.class);
    when(ruleBuilderFieldService28.getName()).thenReturn("Name");
    RuleBuilderFieldService ruleBuilderFieldService29 = mock(RuleBuilderFieldService.class);
    when(ruleBuilderFieldService29.getName()).thenReturn("Name");
    RuleBuilderFieldService ruleBuilderFieldService30 = mock(RuleBuilderFieldService.class);
    when(ruleBuilderFieldService30.getName()).thenReturn("Name");
    RuleBuilderFieldService ruleBuilderFieldService31 = mock(RuleBuilderFieldService.class);
    when(ruleBuilderFieldService31.getName()).thenReturn("Name");
    RuleBuilderFieldService ruleBuilderFieldService32 = mock(RuleBuilderFieldService.class);
    when(ruleBuilderFieldService32.getName()).thenReturn("Name");
    RuleBuilderFieldService ruleBuilderFieldService33 = mock(RuleBuilderFieldService.class);
    when(ruleBuilderFieldService33.getName()).thenReturn("Name");
    RuleBuilderFieldService ruleBuilderFieldService34 = mock(RuleBuilderFieldService.class);
    when(ruleBuilderFieldService34.getName()).thenReturn("Name");
    RuleBuilderFieldService ruleBuilderFieldService35 = mock(RuleBuilderFieldService.class);
    when(ruleBuilderFieldService35.getName()).thenReturn("Name");
    RuleBuilderFieldService ruleBuilderFieldService36 = mock(RuleBuilderFieldService.class);
    when(ruleBuilderFieldService36.getName()).thenReturn("Name");
    RuleBuilderFieldService ruleBuilderFieldService37 = mock(RuleBuilderFieldService.class);
    when(ruleBuilderFieldService37.getName()).thenReturn("Name");
    RuleBuilderFieldService ruleBuilderFieldService38 = mock(RuleBuilderFieldService.class);
    when(ruleBuilderFieldService38.getName()).thenReturn("Name");
    RuleBuilderFieldService ruleBuilderFieldService39 = mock(RuleBuilderFieldService.class);
    when(ruleBuilderFieldService39.getName()).thenReturn("Name");
    RuleBuilderFieldService ruleBuilderFieldService40 = mock(RuleBuilderFieldService.class);
    when(ruleBuilderFieldService40.getName()).thenReturn("Name");
    RuleBuilderFieldService ruleBuilderFieldService41 = mock(RuleBuilderFieldService.class);
    when(ruleBuilderFieldService41.getName()).thenReturn("Name");
    RuleBuilderFieldService ruleBuilderFieldService42 = mock(RuleBuilderFieldService.class);
    when(ruleBuilderFieldService42.getName()).thenReturn("Name");
    RuleBuilderFieldService ruleBuilderFieldService43 = mock(RuleBuilderFieldService.class);
    when(ruleBuilderFieldService43.getName()).thenReturn("Name");
    RuleBuilderFieldService ruleBuilderFieldService44 = mock(RuleBuilderFieldService.class);
    when(ruleBuilderFieldService44.getName()).thenReturn("Name");
    RuleBuilderFieldService ruleBuilderFieldService45 = mock(RuleBuilderFieldService.class);
    when(ruleBuilderFieldService45.getName()).thenReturn("Name");
    RuleBuilderFieldService ruleBuilderFieldService46 = mock(RuleBuilderFieldService.class);
    when(ruleBuilderFieldService46.getName()).thenReturn("Name");
    RuleBuilderFieldService ruleBuilderFieldService47 = mock(RuleBuilderFieldService.class);
    when(ruleBuilderFieldService47.getName()).thenReturn("Name");
    RuleBuilderFieldService ruleBuilderFieldService48 = mock(RuleBuilderFieldService.class);
    when(ruleBuilderFieldService48.getName()).thenReturn("Name");
    RuleBuilderFieldService ruleBuilderFieldService49 = mock(RuleBuilderFieldService.class);
    when(ruleBuilderFieldService49.getName()).thenReturn("Name");
    RuleBuilderFieldService ruleBuilderFieldService50 = mock(RuleBuilderFieldService.class);
    when(ruleBuilderFieldService50.getName()).thenReturn("Name");
    RuleBuilderFieldService ruleBuilderFieldService51 = mock(RuleBuilderFieldService.class);
    when(ruleBuilderFieldService51.getName()).thenReturn("Name");
    RuleBuilderFieldService ruleBuilderFieldService52 = mock(RuleBuilderFieldService.class);
    when(ruleBuilderFieldService52.getName()).thenReturn("Name");
    RuleBuilderFieldService ruleBuilderFieldService53 = mock(RuleBuilderFieldService.class);
    when(ruleBuilderFieldService53.getName()).thenReturn("Name");
    RuleBuilderFieldService ruleBuilderFieldService54 = mock(RuleBuilderFieldService.class);
    when(ruleBuilderFieldService54.getName()).thenReturn("Name");
    RuleBuilderFieldService ruleBuilderFieldService55 = mock(RuleBuilderFieldService.class);
    when(ruleBuilderFieldService55.getName()).thenReturn("Name");
    RuleBuilderFieldService ruleBuilderFieldService56 = mock(RuleBuilderFieldService.class);
    when(ruleBuilderFieldService56.getName()).thenReturn("Name");
    RuleBuilderFieldService ruleBuilderFieldService57 = mock(RuleBuilderFieldService.class);
    when(ruleBuilderFieldService57.getName()).thenReturn("Name");
    RuleBuilderFieldService ruleBuilderFieldService58 = mock(RuleBuilderFieldService.class);
    when(ruleBuilderFieldService58.getName()).thenReturn("Name");
    RuleBuilderFieldService ruleBuilderFieldService59 = mock(RuleBuilderFieldService.class);
    when(ruleBuilderFieldService59.getName()).thenReturn("Name");
    RuleBuilderFieldService ruleBuilderFieldService60 = mock(RuleBuilderFieldService.class);
    when(ruleBuilderFieldService60.getName()).thenReturn("Name");
    RuleBuilderFieldService ruleBuilderFieldService61 = mock(RuleBuilderFieldService.class);
    when(ruleBuilderFieldService61.getName()).thenReturn("Name");
    RuleBuilderFieldService ruleBuilderFieldService62 = mock(RuleBuilderFieldService.class);
    when(ruleBuilderFieldService62.getName()).thenReturn("Name");
    RuleBuilderFieldService ruleBuilderFieldService63 = mock(RuleBuilderFieldService.class);
    when(ruleBuilderFieldService63.getName()).thenReturn("Name");
    RuleBuilderFieldService ruleBuilderFieldService64 = mock(RuleBuilderFieldService.class);
    when(ruleBuilderFieldService64.getName()).thenReturn("Name");
    RuleBuilderFieldService ruleBuilderFieldService65 = mock(RuleBuilderFieldService.class);
    when(ruleBuilderFieldService65.getName()).thenReturn("Name");
    RuleBuilderFieldService ruleBuilderFieldService66 = mock(RuleBuilderFieldService.class);
    when(ruleBuilderFieldService66.getName()).thenReturn("Name");
    RuleBuilderFieldService ruleBuilderFieldService67 = mock(RuleBuilderFieldService.class);
    when(ruleBuilderFieldService67.getName()).thenReturn("Name");
    RuleBuilderFieldService ruleBuilderFieldService68 = mock(RuleBuilderFieldService.class);
    when(ruleBuilderFieldService68.getName()).thenReturn("Name");
    RuleBuilderFieldService ruleBuilderFieldService69 = mock(RuleBuilderFieldService.class);
    when(ruleBuilderFieldService69.getName()).thenReturn("Name");
    RuleBuilderFieldService ruleBuilderFieldService70 = mock(RuleBuilderFieldService.class);
    when(ruleBuilderFieldService70.getName()).thenReturn("Name");
    RuleBuilderFieldService ruleBuilderFieldService71 = mock(RuleBuilderFieldService.class);
    when(ruleBuilderFieldService71.getName()).thenReturn("Name");
    RuleBuilderFieldService ruleBuilderFieldService72 = mock(RuleBuilderFieldService.class);
    when(ruleBuilderFieldService72.getName()).thenReturn("Name");
    RuleBuilderFieldService ruleBuilderFieldService73 = mock(RuleBuilderFieldService.class);
    when(ruleBuilderFieldService73.getName()).thenReturn("Name");
    RuleBuilderFieldService ruleBuilderFieldService74 = mock(RuleBuilderFieldService.class);
    when(ruleBuilderFieldService74.getName()).thenReturn("Name");
    RuleBuilderFieldService ruleBuilderFieldService75 = mock(RuleBuilderFieldService.class);
    when(ruleBuilderFieldService75.getName()).thenReturn("Name");
    RuleBuilderFieldService ruleBuilderFieldService76 = mock(RuleBuilderFieldService.class);
    when(ruleBuilderFieldService76.getName()).thenReturn("Name");
    RuleBuilderFieldService ruleBuilderFieldService77 = mock(RuleBuilderFieldService.class);
    when(ruleBuilderFieldService77.getName()).thenReturn("Name");
    RuleBuilderFieldService ruleBuilderFieldService78 = mock(RuleBuilderFieldService.class);
    when(ruleBuilderFieldService78.getName()).thenReturn("Name");
    RuleBuilderFieldService ruleBuilderFieldService79 = mock(RuleBuilderFieldService.class);
    when(ruleBuilderFieldService79.getName()).thenReturn("Name");
    RuleBuilderFieldService ruleBuilderFieldService80 = mock(RuleBuilderFieldService.class);
    when(ruleBuilderFieldService80.getName()).thenReturn("Name");
    RuleBuilderFieldService ruleBuilderFieldService81 = mock(RuleBuilderFieldService.class);
    when(ruleBuilderFieldService81.getName()).thenReturn("Name");
    RuleBuilderFieldService ruleBuilderFieldService82 = mock(RuleBuilderFieldService.class);
    when(ruleBuilderFieldService82.getName()).thenReturn("Name");
    RuleBuilderFieldService ruleBuilderFieldService83 = mock(RuleBuilderFieldService.class);
    when(ruleBuilderFieldService83.getName()).thenReturn("Name");
    RuleBuilderFieldService ruleBuilderFieldService84 = mock(RuleBuilderFieldService.class);
    when(ruleBuilderFieldService84.getName()).thenReturn("Name");
    RuleBuilderFieldService ruleBuilderFieldService85 = mock(RuleBuilderFieldService.class);
    when(ruleBuilderFieldService85.getName()).thenReturn("Name");
    RuleBuilderFieldService ruleBuilderFieldService86 = mock(RuleBuilderFieldService.class);
    when(ruleBuilderFieldService86.getName()).thenReturn("Name");
    RuleBuilderFieldService ruleBuilderFieldService87 = mock(RuleBuilderFieldService.class);
    when(ruleBuilderFieldService87.getName()).thenReturn("Name");
    RuleBuilderFieldService ruleBuilderFieldService88 = mock(RuleBuilderFieldService.class);
    when(ruleBuilderFieldService88.getName()).thenReturn("Name");
    RuleBuilderFieldService ruleBuilderFieldService89 = mock(RuleBuilderFieldService.class);
    when(ruleBuilderFieldService89.getName()).thenReturn("Name");
    RuleBuilderFieldService ruleBuilderFieldService90 = mock(RuleBuilderFieldService.class);
    when(ruleBuilderFieldService90.getName()).thenReturn("Name");
    RuleBuilderFieldService ruleBuilderFieldService91 = mock(RuleBuilderFieldService.class);
    when(ruleBuilderFieldService91.getName()).thenReturn("Name");
    RuleBuilderFieldService ruleBuilderFieldService92 = mock(RuleBuilderFieldService.class);
    when(ruleBuilderFieldService92.getName()).thenReturn("Name");
    RuleBuilderFieldService ruleBuilderFieldService93 = mock(RuleBuilderFieldService.class);
    when(ruleBuilderFieldService93.getName()).thenReturn("Name");
    RuleBuilderFieldService ruleBuilderFieldService94 = mock(RuleBuilderFieldService.class);
    when(ruleBuilderFieldService94.getName()).thenReturn("Name");
    RuleBuilderFieldService ruleBuilderFieldService95 = mock(RuleBuilderFieldService.class);
    when(ruleBuilderFieldService95.getName()).thenReturn("Name");
    RuleBuilderFieldService ruleBuilderFieldService96 = mock(RuleBuilderFieldService.class);
    when(ruleBuilderFieldService96.getName()).thenReturn("Name");
    RuleBuilderFieldService ruleBuilderFieldService97 = mock(RuleBuilderFieldService.class);
    when(ruleBuilderFieldService97.getName()).thenReturn("Name");
    RuleBuilderFieldService ruleBuilderFieldService98 = mock(RuleBuilderFieldService.class);
    when(ruleBuilderFieldService98.getName()).thenReturn("Name");
    RuleBuilderFieldService ruleBuilderFieldService99 = mock(RuleBuilderFieldService.class);
    when(ruleBuilderFieldService99.getName()).thenThrow(new RuntimeException("Name"));

    ArrayList<RuleBuilderFieldService> fieldServices = new ArrayList<>();
    fieldServices.add(ruleBuilderFieldService99);
    fieldServices.add(ruleBuilderFieldService98);
    fieldServices.add(ruleBuilderFieldService97);
    fieldServices.add(ruleBuilderFieldService96);
    fieldServices.add(ruleBuilderFieldService95);
    fieldServices.add(ruleBuilderFieldService94);
    fieldServices.add(ruleBuilderFieldService93);
    fieldServices.add(ruleBuilderFieldService92);
    fieldServices.add(ruleBuilderFieldService91);
    fieldServices.add(ruleBuilderFieldService90);
    fieldServices.add(ruleBuilderFieldService89);
    fieldServices.add(ruleBuilderFieldService88);
    fieldServices.add(ruleBuilderFieldService87);
    fieldServices.add(ruleBuilderFieldService86);
    fieldServices.add(ruleBuilderFieldService85);
    fieldServices.add(ruleBuilderFieldService84);
    fieldServices.add(ruleBuilderFieldService83);
    fieldServices.add(ruleBuilderFieldService82);
    fieldServices.add(ruleBuilderFieldService81);
    fieldServices.add(ruleBuilderFieldService80);
    fieldServices.add(ruleBuilderFieldService79);
    fieldServices.add(ruleBuilderFieldService78);
    fieldServices.add(ruleBuilderFieldService77);
    fieldServices.add(ruleBuilderFieldService76);
    fieldServices.add(ruleBuilderFieldService75);
    fieldServices.add(ruleBuilderFieldService74);
    fieldServices.add(ruleBuilderFieldService73);
    fieldServices.add(ruleBuilderFieldService72);
    fieldServices.add(ruleBuilderFieldService71);
    fieldServices.add(ruleBuilderFieldService70);
    fieldServices.add(ruleBuilderFieldService69);
    fieldServices.add(ruleBuilderFieldService68);
    fieldServices.add(ruleBuilderFieldService67);
    fieldServices.add(ruleBuilderFieldService66);
    fieldServices.add(ruleBuilderFieldService65);
    fieldServices.add(ruleBuilderFieldService64);
    fieldServices.add(ruleBuilderFieldService63);
    fieldServices.add(ruleBuilderFieldService62);
    fieldServices.add(ruleBuilderFieldService61);
    fieldServices.add(ruleBuilderFieldService60);
    fieldServices.add(ruleBuilderFieldService59);
    fieldServices.add(ruleBuilderFieldService58);
    fieldServices.add(ruleBuilderFieldService57);
    fieldServices.add(ruleBuilderFieldService56);
    fieldServices.add(ruleBuilderFieldService55);
    fieldServices.add(ruleBuilderFieldService54);
    fieldServices.add(ruleBuilderFieldService53);
    fieldServices.add(ruleBuilderFieldService52);
    fieldServices.add(ruleBuilderFieldService51);
    fieldServices.add(ruleBuilderFieldService50);
    fieldServices.add(ruleBuilderFieldService49);
    fieldServices.add(ruleBuilderFieldService48);
    fieldServices.add(ruleBuilderFieldService47);
    fieldServices.add(ruleBuilderFieldService46);
    fieldServices.add(ruleBuilderFieldService45);
    fieldServices.add(ruleBuilderFieldService44);
    fieldServices.add(ruleBuilderFieldService43);
    fieldServices.add(ruleBuilderFieldService42);
    fieldServices.add(ruleBuilderFieldService41);
    fieldServices.add(ruleBuilderFieldService40);
    fieldServices.add(ruleBuilderFieldService39);
    fieldServices.add(ruleBuilderFieldService38);
    fieldServices.add(ruleBuilderFieldService37);
    fieldServices.add(ruleBuilderFieldService36);
    fieldServices.add(ruleBuilderFieldService35);
    fieldServices.add(ruleBuilderFieldService34);
    fieldServices.add(ruleBuilderFieldService33);
    fieldServices.add(ruleBuilderFieldService32);
    fieldServices.add(ruleBuilderFieldService31);
    fieldServices.add(ruleBuilderFieldService30);
    fieldServices.add(ruleBuilderFieldService29);
    fieldServices.add(ruleBuilderFieldService28);
    fieldServices.add(ruleBuilderFieldService27);
    fieldServices.add(ruleBuilderFieldService26);
    fieldServices.add(ruleBuilderFieldService25);
    fieldServices.add(ruleBuilderFieldService24);
    fieldServices.add(ruleBuilderFieldService23);
    fieldServices.add(ruleBuilderFieldService22);
    fieldServices.add(ruleBuilderFieldService21);
    fieldServices.add(ruleBuilderFieldService20);
    fieldServices.add(ruleBuilderFieldService19);
    fieldServices.add(ruleBuilderFieldService18);
    fieldServices.add(ruleBuilderFieldService17);
    fieldServices.add(ruleBuilderFieldService16);
    fieldServices.add(ruleBuilderFieldService15);
    fieldServices.add(ruleBuilderFieldService14);
    fieldServices.add(ruleBuilderFieldService13);
    fieldServices.add(ruleBuilderFieldService12);
    fieldServices.add(ruleBuilderFieldService11);
    fieldServices.add(ruleBuilderFieldService10);
    fieldServices.add(ruleBuilderFieldService9);
    fieldServices.add(ruleBuilderFieldService8);
    fieldServices.add(ruleBuilderFieldService7);
    fieldServices.add(ruleBuilderFieldService6);
    fieldServices.add(ruleBuilderFieldService5);
    fieldServices.add(ruleBuilderFieldService4);
    fieldServices.add(ruleBuilderFieldService3);
    fieldServices.add(ruleBuilderFieldService2);
    fieldServices.add(ruleBuilderFieldService);

    RuleBuilderFieldServiceFactoryImpl ruleBuilderFieldServiceFactoryImpl = new RuleBuilderFieldServiceFactoryImpl();
    ruleBuilderFieldServiceFactoryImpl.setFieldServices(fieldServices);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> ruleBuilderFieldServiceFactoryImpl.createInstance("Name"));
    verify(ruleBuilderFieldService99).getName();
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link RuleBuilderFieldServiceFactoryImpl#setFieldServices(List)}
   *   <li>{@link RuleBuilderFieldServiceFactoryImpl#getFieldServices()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    RuleBuilderFieldServiceFactoryImpl ruleBuilderFieldServiceFactoryImpl = new RuleBuilderFieldServiceFactoryImpl();
    ArrayList<RuleBuilderFieldService> fieldServices = new ArrayList<>();

    // Act
    ruleBuilderFieldServiceFactoryImpl.setFieldServices(fieldServices);
    List<RuleBuilderFieldService> actualFieldServices = ruleBuilderFieldServiceFactoryImpl.getFieldServices();

    // Assert that nothing has changed
    assertTrue(actualFieldServices.isEmpty());
    assertSame(fieldServices, actualFieldServices);
  }
}
