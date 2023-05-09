JC = javac
.SUFFIXES: .java .class
.java.class:
		$(JC) $(JFLAGS) $*.java

CLASSES = \
		PopulateDB.java \
		PokemonInterface.java

default: classes

classes: $(CLASSES:.java=.class)

clean:
		$(RM) *.class

rundb:
	java -cp .:mssql-jdbc-11.2.0.jre18.jar PopulateDB

run:
	java -cp .:mssql-jdbc-11.2.0.jre18.jar PokemonInterface