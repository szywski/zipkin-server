/**
 * Copyright 2015 The OpenZipkin Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
/**
 * This class is generated by jOOQ
 */
package io.zipkin.jdbc.internal.generated.tables;


import io.zipkin.jdbc.internal.generated.Zipkin;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
	value = {
		"http://www.jooq.org",
		"jOOQ version:3.7.1"
	},
	comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class ZipkinAnnotations extends TableImpl<Record> {

	private static final long serialVersionUID = -1136257784;

	/**
	 * The reference instance of <code>zipkin.zipkin_annotations</code>
	 */
	public static final ZipkinAnnotations ZIPKIN_ANNOTATIONS = new ZipkinAnnotations();

	/**
	 * The class holding records for this type
	 */
	@Override
	public Class<Record> getRecordType() {
		return Record.class;
	}

	/**
	 * The column <code>zipkin.zipkin_annotations.trace_id</code>. coincides with zipkin_spans.trace_id
	 */
	public final TableField<Record, Long> TRACE_ID = createField("trace_id", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "coincides with zipkin_spans.trace_id");

	/**
	 * The column <code>zipkin.zipkin_annotations.span_id</code>. coincides with zipkin_spans.id
	 */
	public final TableField<Record, Long> SPAN_ID = createField("span_id", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "coincides with zipkin_spans.id");

	/**
	 * The column <code>zipkin.zipkin_annotations.a_key</code>. BinaryAnnotation.key or Annotation.value if type == -1
	 */
	public final TableField<Record, String> A_KEY = createField("a_key", org.jooq.impl.SQLDataType.VARCHAR.nullable(false), this, "BinaryAnnotation.key or Annotation.value if type == -1");

	/**
	 * The column <code>zipkin.zipkin_annotations.a_value</code>. BinaryAnnotation.value(), which must be smaller than 64KB
	 */
	public final TableField<Record, byte[]> A_VALUE = createField("a_value", org.jooq.impl.SQLDataType.BLOB, this, "BinaryAnnotation.value(), which must be smaller than 64KB");

	/**
	 * The column <code>zipkin.zipkin_annotations.a_type</code>. BinaryAnnotation.type() or -1 if Annotation
	 */
	public final TableField<Record, Integer> A_TYPE = createField("a_type", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "BinaryAnnotation.type() or -1 if Annotation");

	/**
	 * The column <code>zipkin.zipkin_annotations.a_timestamp</code>. Used to implement TTL; Annotation.timestamp or zipkin_spans.timestamp
	 */
	public final TableField<Record, Long> A_TIMESTAMP = createField("a_timestamp", org.jooq.impl.SQLDataType.BIGINT, this, "Used to implement TTL; Annotation.timestamp or zipkin_spans.timestamp");

	/**
	 * The column <code>zipkin.zipkin_annotations.endpoint_ipv4</code>. Null when Binary/Annotation.endpoint is null
	 */
	public final TableField<Record, Integer> ENDPOINT_IPV4 = createField("endpoint_ipv4", org.jooq.impl.SQLDataType.INTEGER, this, "Null when Binary/Annotation.endpoint is null");

	/**
	 * The column <code>zipkin.zipkin_annotations.endpoint_port</code>. Null when Binary/Annotation.endpoint is null
	 */
	public final TableField<Record, Short> ENDPOINT_PORT = createField("endpoint_port", org.jooq.impl.SQLDataType.SMALLINT, this, "Null when Binary/Annotation.endpoint is null");

	/**
	 * The column <code>zipkin.zipkin_annotations.endpoint_service_name</code>. Null when Binary/Annotation.endpoint is null
	 */
	public final TableField<Record, String> ENDPOINT_SERVICE_NAME = createField("endpoint_service_name", org.jooq.impl.SQLDataType.VARCHAR, this, "Null when Binary/Annotation.endpoint is null");

	/**
	 * Create a <code>zipkin.zipkin_annotations</code> table reference
	 */
	public ZipkinAnnotations() {
		this("zipkin_annotations", null);
	}

	/**
	 * Create an aliased <code>zipkin.zipkin_annotations</code> table reference
	 */
	public ZipkinAnnotations(String alias) {
		this(alias, ZIPKIN_ANNOTATIONS);
	}

	private ZipkinAnnotations(String alias, Table<Record> aliased) {
		this(alias, aliased, null);
	}

	private ZipkinAnnotations(String alias, Table<Record> aliased, Field<?>[] parameters) {
		super(alias, Zipkin.ZIPKIN, aliased, parameters, "");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ZipkinAnnotations as(String alias) {
		return new ZipkinAnnotations(alias, this);
	}

	/**
	 * Rename this table
	 */
	public ZipkinAnnotations rename(String name) {
		return new ZipkinAnnotations(name, null);
	}
}
