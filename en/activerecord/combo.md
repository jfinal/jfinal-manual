#JaveBean-Model Combo
JFinal 2.1 version provides `ModelGenerator、BaseModelGenerator、MappingKitGernator、DataDictionaryGenerator` to generate `Model、BaseModel、MappingKit、DataDictionary` respectively.These four types of files can be generated automatically based on database.

Comparing with JFinal versions before 2.1, generated `Model` is extended from `BaseModel` not `Model`. `BaseModel` has getters and setters followed the traditional Javebean spec. `Model` can have the all the advantages of traditional JaveBean by extending from `BaseModel｀ － all without any manual intervention. Only need one-button operation when there is any change in database.
