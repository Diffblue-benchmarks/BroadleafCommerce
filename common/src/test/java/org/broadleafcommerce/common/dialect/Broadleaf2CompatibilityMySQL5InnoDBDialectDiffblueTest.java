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
package org.broadleafcommerce.common.dialect;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import java.util.Comparator;
import java.util.Map;
import java.util.Properties;
import org.hibernate.dialect.function.SQLFunction;
import org.hibernate.dialect.function.StandardSQLFunction;
import org.hibernate.dialect.identity.IdentityColumnSupport;
import org.hibernate.dialect.identity.MySQLIdentityColumnSupport;
import org.hibernate.dialect.unique.MySQLUniqueDelegate;
import org.hibernate.engine.jdbc.env.internal.DefaultSchemaNameResolver;
import org.hibernate.hql.spi.id.local.LocalTemporaryTableBulkIdStrategy;
import org.hibernate.id.IdentityGenerator;
import org.hibernate.internal.util.compare.ComparableComparator;
import org.hibernate.procedure.internal.StandardCallableStatementSupport;
import org.hibernate.tool.schema.extract.internal.SequenceInformationExtractorNoOpImpl;
import org.hibernate.tool.schema.internal.StandardAuxiliaryDatabaseObjectExporter;
import org.hibernate.tool.schema.internal.StandardForeignKeyExporter;
import org.hibernate.tool.schema.internal.StandardIndexExporter;
import org.hibernate.tool.schema.internal.StandardSequenceExporter;
import org.hibernate.tool.schema.internal.StandardTableExporter;
import org.hibernate.tool.schema.internal.StandardUniqueKeyExporter;
import org.hibernate.type.IntegerType;
import org.hibernate.type.LongType;
import org.hibernate.type.StringType;
import org.hibernate.type.Type;
import org.hibernate.type.descriptor.java.ImmutableMutabilityPlan;
import org.hibernate.type.descriptor.java.IntegerTypeDescriptor;
import org.hibernate.type.descriptor.java.JavaTypeDescriptor;
import org.hibernate.type.descriptor.java.LongTypeDescriptor;
import org.hibernate.type.descriptor.java.MutabilityPlan;
import org.hibernate.type.descriptor.java.StringTypeDescriptor;
import org.hibernate.type.descriptor.sql.BigIntTypeDescriptor;
import org.hibernate.type.descriptor.sql.SqlTypeDescriptor;
import org.hibernate.type.descriptor.sql.VarcharTypeDescriptor;
import org.junit.Test;

public class Broadleaf2CompatibilityMySQL5InnoDBDialectDiffblueTest {
  /**
   * Test new {@link Broadleaf2CompatibilityMySQL5InnoDBDialect} (default
   * constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link Broadleaf2CompatibilityMySQL5InnoDBDialect}
   */
  @Test
  public void testNewBroadleaf2CompatibilityMySQL5InnoDBDialect() {
    // Arrange and Act
    Broadleaf2CompatibilityMySQL5InnoDBDialect actualBroadleaf2CompatibilityMySQL5InnoDBDialect = new Broadleaf2CompatibilityMySQL5InnoDBDialect();

    // Assert
    Map<String, SQLFunction> functions = actualBroadleaf2CompatibilityMySQL5InnoDBDialect.getFunctions();
    assertEquals(108, functions.size());
    SQLFunction getResult = functions.get("bin");
    assertTrue(getResult instanceof StandardSQLFunction);
    SQLFunction getResult2 = functions.get("character_length");
    assertTrue(getResult2 instanceof StandardSQLFunction);
    SQLFunction getResult3 = functions.get("mod");
    assertTrue(getResult3 instanceof StandardSQLFunction);
    SQLFunction getResult4 = functions.get("upper");
    assertTrue(getResult4 instanceof StandardSQLFunction);
    SQLFunction getResult5 = functions.get("weekday");
    assertTrue(getResult5 instanceof StandardSQLFunction);
    SQLFunction getResult6 = functions.get("year");
    assertTrue(getResult6 instanceof StandardSQLFunction);
    IdentityColumnSupport identityColumnSupport = actualBroadleaf2CompatibilityMySQL5InnoDBDialect
        .getIdentityColumnSupport();
    assertTrue(identityColumnSupport instanceof MySQLIdentityColumnSupport);
    assertTrue(actualBroadleaf2CompatibilityMySQL5InnoDBDialect.getUniqueDelegate() instanceof MySQLUniqueDelegate);
    assertTrue(
        actualBroadleaf2CompatibilityMySQL5InnoDBDialect.getSchemaNameResolver() instanceof DefaultSchemaNameResolver);
    assertTrue(actualBroadleaf2CompatibilityMySQL5InnoDBDialect
        .getDefaultMultiTableBulkIdStrategy() instanceof LocalTemporaryTableBulkIdStrategy);
    Type type = ((StandardSQLFunction) getResult3).getType();
    Comparator<Integer> comparator = ((IntegerType) type).getComparator();
    assertTrue(comparator instanceof ComparableComparator);
    Type type2 = ((StandardSQLFunction) getResult2).getType();
    Comparator<Long> comparator2 = ((LongType) type2).getComparator();
    assertTrue(comparator2 instanceof ComparableComparator);
    assertTrue(actualBroadleaf2CompatibilityMySQL5InnoDBDialect
        .getCallableStatementSupport() instanceof StandardCallableStatementSupport);
    assertTrue(actualBroadleaf2CompatibilityMySQL5InnoDBDialect
        .getSequenceInformationExtractor() instanceof SequenceInformationExtractorNoOpImpl);
    assertTrue(actualBroadleaf2CompatibilityMySQL5InnoDBDialect
        .getAuxiliaryDatabaseObjectExporter() instanceof StandardAuxiliaryDatabaseObjectExporter);
    assertTrue(
        actualBroadleaf2CompatibilityMySQL5InnoDBDialect.getForeignKeyExporter() instanceof StandardForeignKeyExporter);
    assertTrue(actualBroadleaf2CompatibilityMySQL5InnoDBDialect.getIndexExporter() instanceof StandardIndexExporter);
    assertTrue(
        actualBroadleaf2CompatibilityMySQL5InnoDBDialect.getSequenceExporter() instanceof StandardSequenceExporter);
    assertTrue(actualBroadleaf2CompatibilityMySQL5InnoDBDialect.getTableExporter() instanceof StandardTableExporter);
    assertTrue(
        actualBroadleaf2CompatibilityMySQL5InnoDBDialect.getUniqueKeyExporter() instanceof StandardUniqueKeyExporter);
    assertTrue(type instanceof IntegerType);
    assertTrue(type2 instanceof LongType);
    Type type3 = ((StandardSQLFunction) getResult).getType();
    assertTrue(type3 instanceof StringType);
    JavaTypeDescriptor<Integer> javaTypeDescriptor = ((IntegerType) type).getJavaTypeDescriptor();
    MutabilityPlan<Integer> mutabilityPlan = javaTypeDescriptor.getMutabilityPlan();
    assertTrue(mutabilityPlan instanceof ImmutableMutabilityPlan);
    assertTrue(javaTypeDescriptor instanceof IntegerTypeDescriptor);
    JavaTypeDescriptor<Long> javaTypeDescriptor2 = ((LongType) type2).getJavaTypeDescriptor();
    assertTrue(javaTypeDescriptor2 instanceof LongTypeDescriptor);
    JavaTypeDescriptor<String> javaTypeDescriptor3 = ((StringType) type3).getJavaTypeDescriptor();
    assertTrue(javaTypeDescriptor3 instanceof StringTypeDescriptor);
    SqlTypeDescriptor sqlTypeDescriptor = ((LongType) type2).getSqlTypeDescriptor();
    assertTrue(sqlTypeDescriptor instanceof BigIntTypeDescriptor);
    SqlTypeDescriptor sqlTypeDescriptor2 = ((IntegerType) type).getSqlTypeDescriptor();
    assertTrue(sqlTypeDescriptor2 instanceof org.hibernate.type.descriptor.sql.IntegerTypeDescriptor);
    SqlTypeDescriptor sqlTypeDescriptor3 = ((StringType) type3).getSqlTypeDescriptor();
    assertTrue(sqlTypeDescriptor3 instanceof VarcharTypeDescriptor);
    assertEquals(" cross join ", actualBroadleaf2CompatibilityMySQL5InnoDBDialect.getCrossJoinSeparator());
    assertEquals(" drop foreign key ", actualBroadleaf2CompatibilityMySQL5InnoDBDialect.getDropForeignKeyString());
    assertEquals(" engine=InnoDB", actualBroadleaf2CompatibilityMySQL5InnoDBDialect.getTableTypeString());
    assertEquals(" for update", actualBroadleaf2CompatibilityMySQL5InnoDBDialect.getForUpdateNowaitString());
    assertEquals(" for update", actualBroadleaf2CompatibilityMySQL5InnoDBDialect.getForUpdateSkipLockedString());
    assertEquals(" for update", actualBroadleaf2CompatibilityMySQL5InnoDBDialect.getForUpdateString());
    assertEquals("", actualBroadleaf2CompatibilityMySQL5InnoDBDialect.getAddColumnSuffixString());
    assertEquals("", actualBroadleaf2CompatibilityMySQL5InnoDBDialect.getCascadeConstraintsString());
    assertEquals("", actualBroadleaf2CompatibilityMySQL5InnoDBDialect.getNullColumnString());
    Properties defaultProperties = actualBroadleaf2CompatibilityMySQL5InnoDBDialect.getDefaultProperties();
    assertEquals(2, defaultProperties.size());
    assertEquals("15", defaultProperties.get("hibernate.jdbc.batch_size"));
    assertEquals("2", defaultProperties.get("hibernate.max_fetch_depth"));
    assertEquals("add column", actualBroadleaf2CompatibilityMySQL5InnoDBDialect.getAddColumnString());
    assertEquals("bin", getResult.toString());
    assertEquals("bin", ((StandardSQLFunction) getResult).getName());
    assertEquals("character_length", getResult2.toString());
    assertEquals("character_length", ((StandardSQLFunction) getResult2).getName());
    assertEquals("create table", actualBroadleaf2CompatibilityMySQL5InnoDBDialect.getCreateMultisetTableString());
    assertEquals("create table", actualBroadleaf2CompatibilityMySQL5InnoDBDialect.getCreateTableString());
    assertEquals("current_timestamp",
        actualBroadleaf2CompatibilityMySQL5InnoDBDialect.getCurrentTimestampSQLFunctionName());
    assertEquals("identity", actualBroadleaf2CompatibilityMySQL5InnoDBDialect.getNativeIdentifierGeneratorStrategy());
    assertEquals("int", ((IntegerType) type).getPrimitiveClass().getName());
    assertEquals("integer", type.getName());
    assertEquals("like", actualBroadleaf2CompatibilityMySQL5InnoDBDialect.getCaseInsensitiveLike());
    assertEquals("long", ((LongType) type2).getPrimitiveClass().getName());
    assertEquals("long", type2.getName());
    assertEquals("lower", actualBroadleaf2CompatibilityMySQL5InnoDBDialect.getLowercaseFunction());
    assertEquals("mod", getResult3.toString());
    assertEquals("mod", ((StandardSQLFunction) getResult3).getName());
    assertEquals("select now()", actualBroadleaf2CompatibilityMySQL5InnoDBDialect.getCurrentTimestampSelectString());
    assertEquals("select uuid()", actualBroadleaf2CompatibilityMySQL5InnoDBDialect.getSelectGUIDString());
    assertEquals("string", type3.getName());
    assertEquals("upper", getResult4.toString());
    assertEquals("upper", ((StandardSQLFunction) getResult4).getName());
    assertEquals("values ( )", actualBroadleaf2CompatibilityMySQL5InnoDBDialect.getNoColumnsInsertString());
    assertEquals("weekday", getResult5.toString());
    assertEquals("weekday", ((StandardSQLFunction) getResult5).getName());
    assertEquals("year", getResult6.toString());
    assertEquals("year", ((StandardSQLFunction) getResult6).getName());
    assertNull(actualBroadleaf2CompatibilityMySQL5InnoDBDialect.getCurrentSchemaCommand());
    assertNull(actualBroadleaf2CompatibilityMySQL5InnoDBDialect.getQuerySequencesString());
    assertNull(identityColumnSupport.getIdentityInsertString());
    assertNull(actualBroadleaf2CompatibilityMySQL5InnoDBDialect.getNameQualifierSupport());
    assertNull(((StandardSQLFunction) getResult4).getType());
    assertEquals(-5, sqlTypeDescriptor.getSqlType());
    assertEquals(0, actualBroadleaf2CompatibilityMySQL5InnoDBDialect.getInExpressionCountLimit());
    assertEquals(10, actualBroadleaf2CompatibilityMySQL5InnoDBDialect.getMaxAliasLength());
    assertEquals(12, sqlTypeDescriptor3.getSqlType());
    assertEquals(4, sqlTypeDescriptor2.getSqlType());
    assertFalse(actualBroadleaf2CompatibilityMySQL5InnoDBDialect.isLegacyLimitHandlerBehaviorEnabled());
    assertFalse(actualBroadleaf2CompatibilityMySQL5InnoDBDialect.isLockTimeoutParameterized());
    assertFalse(actualBroadleaf2CompatibilityMySQL5InnoDBDialect.isCurrentTimestampSelectStringCallable());
    assertFalse(actualBroadleaf2CompatibilityMySQL5InnoDBDialect.isJdbcLogWarningsEnabledByDefault());
    assertFalse(((IntegerType) type).isXMLElement());
    assertFalse(((LongType) type2).isXMLElement());
    assertFalse(((StringType) type3).isXMLElement());
    assertFalse(type3.isAnyType());
    assertFalse(type2.isAnyType());
    assertFalse(type.isAnyType());
    assertFalse(type3.isAssociationType());
    assertFalse(type2.isAssociationType());
    assertFalse(type.isAssociationType());
    assertFalse(type3.isCollectionType());
    assertFalse(type2.isCollectionType());
    assertFalse(type.isCollectionType());
    assertFalse(type3.isComponentType());
    assertFalse(type2.isComponentType());
    assertFalse(type.isComponentType());
    assertFalse(type3.isEntityType());
    assertFalse(type2.isEntityType());
    assertFalse(type.isEntityType());
    assertFalse(type3.isMutable());
    assertFalse(type2.isMutable());
    assertFalse(type.isMutable());
    assertFalse(mutabilityPlan.isMutable());
    assertTrue(actualBroadleaf2CompatibilityMySQL5InnoDBDialect.getKeywords().isEmpty());
    assertTrue(actualBroadleaf2CompatibilityMySQL5InnoDBDialect.hasAlterTable());
    assertTrue(actualBroadleaf2CompatibilityMySQL5InnoDBDialect.hasSelfReferentialForeignKeyBug());
    assertTrue(getResult.hasArguments());
    assertTrue(getResult2.hasArguments());
    assertTrue(getResult3.hasArguments());
    assertTrue(getResult4.hasArguments());
    assertTrue(getResult5.hasArguments());
    assertTrue(getResult6.hasArguments());
    assertTrue(getResult.hasParenthesesIfNoArguments());
    assertTrue(getResult2.hasParenthesesIfNoArguments());
    assertTrue(getResult3.hasParenthesesIfNoArguments());
    assertTrue(getResult4.hasParenthesesIfNoArguments());
    assertTrue(getResult5.hasParenthesesIfNoArguments());
    assertTrue(getResult6.hasParenthesesIfNoArguments());
    assertTrue(identityColumnSupport.hasDataTypeInIdentityColumn());
    Class<Integer> expectedReturnedClass = Integer.class;
    Class returnedClass = type.getReturnedClass();
    assertEquals(expectedReturnedClass, returnedClass);
    Class<Long> expectedReturnedClass2 = Long.class;
    Class returnedClass2 = type2.getReturnedClass();
    assertEquals(expectedReturnedClass2, returnedClass2);
    Class<String> expectedReturnedClass3 = String.class;
    Class returnedClass3 = type3.getReturnedClass();
    assertEquals(expectedReturnedClass3, returnedClass3);
    Class<IdentityGenerator> expectedNativeIdentifierGeneratorClass = IdentityGenerator.class;
    assertEquals(expectedNativeIdentifierGeneratorClass,
        actualBroadleaf2CompatibilityMySQL5InnoDBDialect.getNativeIdentifierGeneratorClass());
    assertSame(returnedClass3, javaTypeDescriptor3.getJavaType());
    assertSame(returnedClass3, javaTypeDescriptor3.getJavaTypeClass());
    assertSame(returnedClass2, javaTypeDescriptor2.getJavaType());
    assertSame(returnedClass2, javaTypeDescriptor2.getJavaTypeClass());
    assertSame(returnedClass, javaTypeDescriptor.getJavaType());
    assertSame(returnedClass, javaTypeDescriptor.getJavaTypeClass());
    assertSame(comparator, javaTypeDescriptor.getComparator());
    assertSame(comparator, javaTypeDescriptor2.getComparator());
    assertSame(comparator, javaTypeDescriptor3.getComparator());
    assertSame(comparator, comparator2);
    assertSame(type, ((StandardSQLFunction) getResult5).getType());
    assertSame(type, ((StandardSQLFunction) getResult6).getType());
    assertSame(mutabilityPlan, javaTypeDescriptor2.getMutabilityPlan());
    assertSame(mutabilityPlan, javaTypeDescriptor3.getMutabilityPlan());
    assertArrayEquals(new String[]{"string", "java.lang.String"}, ((StringType) type3).getRegistrationKeys());
    assertArrayEquals(new String[]{"integer", "int", "java.lang.Integer"}, ((IntegerType) type).getRegistrationKeys());
    assertArrayEquals(new String[]{"long", "long", "java.lang.Long"}, ((LongType) type2).getRegistrationKeys());
  }
}
