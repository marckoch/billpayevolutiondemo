This is my fork of Kirk Knoernschilds Demo Repository `billpayevolutiondemo`. He deserves all the applause and glory.

It is featured in chapter 7 of the (very good) book "Java Application Architecture" (BUY IT NOW!).

I found this chapter hard to follow without looking at the code, 
so I dug up the source code (the URL in the book is out dated, it pointed to Google Code)
and tried to have a look at it.

I used the tool "Sonargraph" to visualize the dependencys and cycles.

see README.md files in the subfolders.

please check the comments "NOTICE: ..." in the build.xml files

## Status

* [x] `InitialVersion` has been updated (Java 8, remove raw types, introduces typed collections, removed warnings in IntelliJ, etc.)
* [x] `Refactoring1PhysicalLayers` has been updated
* [x] `Refactoring2AbstractComponents` has been updated
* [x] `Refactoring3AcyclicRelationships` has been updated
* [ ] `Refactoring4SeparateAbstractions`
* [ ] `Refactoring5CollocateExceptions`
* [ ] `Refactoring6IndependentDeployment`
* [ ] `Refactoring7ImplementationFactory`

* i can open and test the code in IntelliJ (with Java8), IntelliJs internal ant-plugin works fine and I can run all given ant targets
* i have NOT tried to run/deploy the code (maybe I will try, maybe not, I just wanted to check the dependencys and cycles)

## TODO

the following points bother me, but I don't know if I want to tackle them:

* migrating to maven (ANT ... urgh)
* updating the code (uses struts 1.0 if I see correctly, JUnit 4)
