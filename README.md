# My University Management System

As it stands now, focus is specifically placed on the admission management. That is, everything pertaining to admission is what is being coded now. Classes mapped to database tables alongside class members mapped to table columns have been created for this.

Hibernate Annotations used in doing these include
- @Entity: This annotation indicates to the Java Persistence API (JPA) that the class represents a database table. That is, maps the Java class to a database table.

- @Table: This provides for more detail and customization with the Java class which is an entity. It provides attributes such as 'name' to change the table name, 'schema' to specify the schema name etc.

- @Id: Is used to specify the primary key of the entity.

- @GeneratedValue: This helps to achieve auto-generation of the id. It contains 'strategy' attribute to specify what manner in which the auto-generation should happen, whether, IDENTITY (as used in Microsft SQL Server or MySQL etc) or SEQUENCE (as used in older versions of PostgreSQL) or AUTO (depenedent on the database used).

- @Column: Is used to alter or detail the attributes of a column. Attributes such as 'name' helps to rename the table column, 'unique' helps to specify a unique constraint on the field, 'nullable' helps to specify whether or not that field can hold null value.

- @JoinColumn: Is used to establish the relationship between two entities eg foreign keys are established using this annotation. 'name' attribute is the column name, 'referencedColumnName' is the column name in the other table that is being referenced.

- @OneToOne: Establishes the relationship type between class members or database fields.
