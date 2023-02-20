JFLAGS = -d bin
JC = javac

.SUFFIXES: .java .class

.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
	src/Server.java \
	src/Client.java 
	

default: classes

classes: $(CLASSES:.java=.class)

clean:
	$(RM) src/*.class
