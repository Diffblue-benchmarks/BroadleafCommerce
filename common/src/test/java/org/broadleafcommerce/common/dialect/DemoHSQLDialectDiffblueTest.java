/*-
 * #%L
 * BroadleafCommerce Common Libraries
 * %%
 * Copyright (C) 2009 - 2025 Broadleaf Commerce
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
package org.broadleafcommerce.common.dialect;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Map;
import java.util.Properties;
import org.hibernate.dialect.function.SQLFunction;
import org.hibernate.dialect.identity.HSQLIdentityColumnSupport;
import org.hibernate.dialect.unique.DefaultUniqueDelegate;
import org.hibernate.engine.jdbc.env.internal.DefaultSchemaNameResolver;
import org.hibernate.engine.jdbc.env.spi.NameQualifierSupport;
import org.hibernate.hql.spi.id.local.LocalTemporaryTableBulkIdStrategy;
import org.hibernate.id.IdentityGenerator;
import org.hibernate.procedure.internal.StandardCallableStatementSupport;
import org.hibernate.tool.schema.extract.internal.SequenceInformationExtractorHSQLDBDatabaseImpl;
import org.hibernate.tool.schema.internal.StandardAuxiliaryDatabaseObjectExporter;
import org.hibernate.tool.schema.internal.StandardForeignKeyExporter;
import org.hibernate.tool.schema.internal.StandardIndexExporter;
import org.hibernate.tool.schema.internal.StandardSequenceExporter;
import org.hibernate.tool.schema.internal.StandardTableExporter;
import org.hibernate.tool.schema.internal.StandardUniqueKeyExporter;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class DemoHSQLDialectDiffblueTest {
  /**
   * Test {@link DemoHSQLDialect#dropConstraints()}.
   *
   * <p>Method under test: {@link DemoHSQLDialect#dropConstraints()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DemoHSQLDialect.dropConstraints()"})
  public void testDropConstraints() {
    // Arrange, Act and Assert
    assertFalse(new DemoHSQLDialect().dropConstraints());
  }

  /**
   * Test {@link DemoHSQLDialect#getCascadeConstraintsString()}.
   *
   * <p>Method under test: {@link DemoHSQLDialect#getCascadeConstraintsString()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DemoHSQLDialect.getCascadeConstraintsString()"})
  public void testGetCascadeConstraintsString() {
    // Arrange, Act and Assert
    assertEquals(" cascade ", new DemoHSQLDialect().getCascadeConstraintsString());
  }

  /**
   * Test {@link DemoHSQLDialect#supportsIfExistsBeforeTableName()}.
   *
   * <p>Method under test: {@link DemoHSQLDialect#supportsIfExistsBeforeTableName()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DemoHSQLDialect.supportsIfExistsBeforeTableName()"})
  public void testSupportsIfExistsBeforeTableName() {
    // Arrange, Act and Assert
    assertTrue(new DemoHSQLDialect().supportsIfExistsBeforeTableName());
  }

  /**
   * Test {@link DemoHSQLDialect#supportsIfExistsAfterTableName()}.
   *
   * <p>Method under test: {@link DemoHSQLDialect#supportsIfExistsAfterTableName()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DemoHSQLDialect.supportsIfExistsAfterTableName()"})
  public void testSupportsIfExistsAfterTableName() {
    // Arrange, Act and Assert
    assertFalse(new DemoHSQLDialect().supportsIfExistsAfterTableName());
  }

  /**
   * Test new {@link DemoHSQLDialect} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link DemoHSQLDialect}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DemoHSQLDialect.<init>()"})
  public void testNewDemoHSQLDialect() {
    // Arrange and Act
    DemoHSQLDialect actualDemoHSQLDialect = new DemoHSQLDialect();

    // Assert
    assertTrue(
        actualDemoHSQLDialect.getIdentityColumnSupport() instanceof HSQLIdentityColumnSupport);
    assertTrue(actualDemoHSQLDialect.getUniqueDelegate() instanceof DefaultUniqueDelegate);
    assertTrue(actualDemoHSQLDialect.getSchemaNameResolver() instanceof DefaultSchemaNameResolver);
    assertTrue(
        actualDemoHSQLDialect.getDefaultMultiTableBulkIdStrategy()
            instanceof LocalTemporaryTableBulkIdStrategy);
    assertTrue(
        actualDemoHSQLDialect.getCallableStatementSupport()
            instanceof StandardCallableStatementSupport);
    assertTrue(
        actualDemoHSQLDialect.getSequenceInformationExtractor()
            instanceof SequenceInformationExtractorHSQLDBDatabaseImpl);
    assertTrue(
        actualDemoHSQLDialect.getAuxiliaryDatabaseObjectExporter()
            instanceof StandardAuxiliaryDatabaseObjectExporter);
    assertTrue(actualDemoHSQLDialect.getForeignKeyExporter() instanceof StandardForeignKeyExporter);
    assertTrue(actualDemoHSQLDialect.getIndexExporter() instanceof StandardIndexExporter);
    assertTrue(actualDemoHSQLDialect.getSequenceExporter() instanceof StandardSequenceExporter);
    assertTrue(actualDemoHSQLDialect.getTableExporter() instanceof StandardTableExporter);
    assertTrue(actualDemoHSQLDialect.getUniqueKeyExporter() instanceof StandardUniqueKeyExporter);
    assertEquals(" cascade ", actualDemoHSQLDialect.getCascadeConstraintsString());
    assertEquals(" cross join ", actualDemoHSQLDialect.getCrossJoinSeparator());
    assertEquals(" drop constraint ", actualDemoHSQLDialect.getDropForeignKeyString());
    assertEquals(" for update", actualDemoHSQLDialect.getForUpdateNowaitString());
    assertEquals(" for update", actualDemoHSQLDialect.getForUpdateSkipLockedString());
    assertEquals(" for update", actualDemoHSQLDialect.getForUpdateString());
    assertEquals("", actualDemoHSQLDialect.getAddColumnSuffixString());
    assertEquals("", actualDemoHSQLDialect.getNullColumnString());
    assertEquals("", actualDemoHSQLDialect.getTableTypeString());
    assertEquals("add column", actualDemoHSQLDialect.getAddColumnString());
    assertEquals("call current_timestamp", actualDemoHSQLDialect.getCurrentTimestampSelectString());
    assertEquals("create table", actualDemoHSQLDialect.getCreateMultisetTableString());
    assertEquals("create table", actualDemoHSQLDialect.getCreateTableString());
    assertEquals("current_timestamp", actualDemoHSQLDialect.getCurrentTimestampSQLFunctionName());
    assertEquals("identity", actualDemoHSQLDialect.getNativeIdentifierGeneratorStrategy());
    assertEquals("like", actualDemoHSQLDialect.getCaseInsensitiveLike());
    assertEquals("lower", actualDemoHSQLDialect.getLowercaseFunction());
    assertEquals(
        "select * from information_schema.sequences",
        actualDemoHSQLDialect.getQuerySequencesString());
    assertEquals("values ( )", actualDemoHSQLDialect.getNoColumnsInsertString());
    assertNull(actualDemoHSQLDialect.getCurrentSchemaCommand());
    assertEquals(0, actualDemoHSQLDialect.getInExpressionCountLimit());
    Properties defaultProperties = actualDemoHSQLDialect.getDefaultProperties();
    assertEquals(1, defaultProperties.size());
    assertEquals(10, actualDemoHSQLDialect.getMaxAliasLength());
    Map<String, SQLFunction> functions = actualDemoHSQLDialect.getFunctions();
    assertEquals(77, functions.size());
    assertEquals(NameQualifierSupport.SCHEMA, actualDemoHSQLDialect.getNameQualifierSupport());
    assertFalse(actualDemoHSQLDialect.hasSelfReferentialForeignKeyBug());
    assertFalse(actualDemoHSQLDialect.isLegacyLimitHandlerBehaviorEnabled());
    assertFalse(actualDemoHSQLDialect.isLockTimeoutParameterized());
    assertFalse(actualDemoHSQLDialect.isCurrentTimestampSelectStringCallable());
    assertTrue(functions.containsKey("cos"));
    assertTrue(functions.containsKey("cot"));
    assertTrue(functions.containsKey("mod"));
    assertTrue(functions.containsKey("sign"));
    assertTrue(functions.containsKey("upper"));
    assertTrue(functions.containsKey("year"));
    assertTrue(defaultProperties.containsKey("hibernate.jdbc.batch_size"));
    assertTrue(actualDemoHSQLDialect.getKeywords().isEmpty());
    assertTrue(actualDemoHSQLDialect.hasAlterTable());
    assertTrue(actualDemoHSQLDialect.isJdbcLogWarningsEnabledByDefault());
    Class<IdentityGenerator> expectedNativeIdentifierGeneratorClass = IdentityGenerator.class;
    assertEquals(
        expectedNativeIdentifierGeneratorClass,
        actualDemoHSQLDialect.getNativeIdentifierGeneratorClass());
  }
}
