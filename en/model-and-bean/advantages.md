#The Main Advantages of Model-Bean combo

- Make the moste use of 3rd-party tools designed for Bean, like jackson, freemarker
- Quickly response for changes of databases, refactor rapidly, increse development efficiency, improve the code quality
- Through code hinting, avoid memorizing column names in databases, eliminate the burden of memory, avoid mistakes of writing column names manually.
- The design of `BaseModel` keeps `Model` still being clean and refactor related code rapidly when the structure of tables change.
- Automate the mapping from table to `Model`
- Automate the recognition and mapping of primary key or composite primary keys.
- `MappingKit` holds mapping code to keep `JFinalConfig` clean.
- Be benificial to distributed and non-datasource scenarios to use `Model`
