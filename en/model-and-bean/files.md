# Related Generated Files
`BaseModel` is the base class of derived class `Model` and contains all the generated getters and setters, which can keep `Model` lightweight. And you do not need to maintain `BaseModel` manually, only need to regenerate when there is any change in database.

`MappingKit` is used to generate  Mapping Relation from table to `Model`, and also generate the configuration of primary key or composite primary keys, so that boiler-plate code of mapping in `configPlugin(Plugins me)` is no longer needed in JFinal 2.1.


DataDictionary is the generated data dictionary, which contains all the information about column names, types, length, remarks and whether the it is the primary.
