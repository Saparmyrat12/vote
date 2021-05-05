### Developing vote system

- [Tasks](https://github.com/AzarenkaA/vote/blob/tasks/tasks.md#tasks)


#### Tasks
- [[1-0001: Fork and setting git]](https://github.com/AzarenkaA/vote/blob/tasks/tasks.md#task1-0001-fork-and-setting-git)
- [[1-0002: Create infrastructure for project]](https://github.com/AzarenkaA/vote/blob/tasks/tasks.md#task1-0002-create-infrastructure-for-project)
- [[1-0003: Create infrastructure for database and create db for the project]](https://github.com/AzarenkaA/vote/blob/tasks/tasks.md#task1-0003-create-infrastructure-for-database-and-create-db-for-the-project)

##### Task[1-0001: Fork and setting git]  
    1. Make fork of project to personal repository.
    2. Make clone of project to from personal repository to your owner computer.
    3. Add upstream to git on your owner computer for remote repository(from which you made fork).

##### Task[1-0002: Create infrastructure for project]
    As developer I want to be able start this application on my local computer.
        1. Add dependencies which reqire for start. Controller layer will be enough.
        2. Add context configuration.
        3. Add required setting to web.xml
        4. Create test REST controller 
    Assumptions:
        * Base application url will be '/api'. For example http://localhost:8080/api
        * Rest controller by base url will be display 'Hello world'
        * Service and other modules won't be incuded to the project yet.

##### Task[1-0003: Create infrastructure for database and create db for the project]
     As developer I want to keep all data in DataBase.
        1. Add dependecies for start liquibase scripts.
        2. Add needed params to start liquibase script on applicatin startup.
        3. Add needed properties for get access to database
        4. Created schema with name 'epam'

     Assumptions:
        1. All modules will be included in the project.
        2. All scripts will be located in db module. Test module should be include only in domain module.
        3. Will be created common script for start (changelog.xml).
        4. Will be created script to inital db (init-database-changelog.xml).
        5. Will be created script to create tables (create-tables-changlog.xml).
        6. Will be created script to populate tables (populate-tables-changlog.xml).
        7. Will be added file application.properties.
        8. init-database-changelog.xml file should be contains script to create new schema.
