### Developing vote system

- [Tasks](https://github.com/AzarenkaA/vote/blob/tasks/tasks.md#tasks)


#### Tasks
- [[1-0001: Fork and setting git](https://github.com/AzarenkaA/vote/blob/tasks/tasks.md#task[1-0001])
- [[1-0002: Create infrastructure for project]](https://github.com/AzarenkaA/vote/blob/tasks/tasks.md#task[1-0001])

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
    Assuptions:
        * Base application url will be '/api'. For example http://localhost:8080/api
        * Rest controller by base url will be display 'Hello world'
        * Service and other modules won't be incuded to the project yet.
