# model-builder

## How to implement
public class PersonBuilder extends AbstractModelBuilder< Person > { }

## How to initialize

> ModelBuilder < Person > builder = new PersonBuilder();
 
 or
 
> PersonBuilder sut = new PersonBuilder();


## How to use
 
* create person instance within filled required fields
**Person person = builder.min();**
 
* create person instance within all fields
**Person person = builder.max();**
  
* create person instance within filled required or all fields
**Person person = builder.random();**

* create person within fix values
**Person person = builder.fix();**

* create person from Resource
**Person person = builder.fromResource(""file://var/person.xml");**

* create a List of person instances within filled required or all fields with random**[1..10]** size
**List<Person> persons = builder.list();**

* create a List of person instances within filled required or all fields with fixed size
**List<Person> persons =  builder.list(100);**

* create a Set of person instances within filled required or all fields with random**[1..10]** size
**Set<Person> persons =  builder.set();**

* create a Set of person instances within filled required or all fields with fixed size
**Set<Person> persons = builder.set(100);**
 