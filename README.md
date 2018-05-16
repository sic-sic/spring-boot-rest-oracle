# spring-boot-rest-oracle
Simple spring-boot crud rest application using oracle database.

## Setup project
Due to oracle restrictions, we cannot directly fetch oracle jdbc driver (ojdbc) from maven central.
I am going to download it independantly and install it in my local maven repository.

Go to ojdbc download page, accept licence agreement and download it :
[Donwload page](http://www.oracle.com/technetwork/database/features/jdbc/jdbc-ucp-122-3110062.html)

Now let's install it in our local maven repository
```
$ cd /path/to/your/ojdbc8-dest-folder
$ mvn install:install-file -Dfile=ojdbc8.jar -DgroupId=com.oracle -DartifactId=ojdbc8 -Dversion=12.2.0.1 -Dpackaging=jar
```

## Run application
You can run the application using the simple following command
```
$ mvnw spring-boot:run
```

## Restful endpoints
* `GET`    /customers      : List of customers
* `GET`    /customers/{id} : Get a single customer by ID
* `POST`   /customers 	   : Save a new Customer
* `PUT`    /customers 	   : Update a given customer
* `DELETE` /customers/{id} : Delete a customer by ID

## Test endpoints
Let's save a demo customer
```
$ curl -d '{"name": "John Doe", "email": "john.doe@email", "age": 28}' -H "Content-Type: application/json" http://localhost:8080/customers
```
Now let's see if the user was successfully saved
```
$ curl http://localhost:8080/customers
```
Result :
```json
[
	{
		"id": 1000,
		"name": "John Doe",
		"email": "john.doe@email",
		"age": 28
	}
]
```

Get John by Id
```
$ curl http://localhost:8080/customers/1000
```
Result :
```json
{
	"id": 1000,
	"name": "John Doe",
	"email": "john.doe@email",
	"age": 28
}
```

Let's update john email adress
```
$ curl -X PUT -d '{"id": 1, "name": "John Doe", "email": "john.doe@spring-newbe", "age": 28}' -H "Content-Type: application/json" http://localhost:8080/customers
```

And that's it!

Last thing is the delete option:
```
$ curl -X DELETE http://localhost:8080/customers/1000
```

## Build the project
Use maven `install` command to generate the .jar file under `target` folder
```
$ mvnw install
```

You can run the generated jar file as any java jar file.
```
$ java -jar target/spring-boot-rest-oracle-0.0.1-SNAPSHOT.jar
```

Hope you enjoyed it!
