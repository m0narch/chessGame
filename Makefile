TARGET=$(LANG).$(CREAT).$(PROJECT).$(MAINCLASS)
TARGETDIR= $(LANG)/$(CREAT)/$(PROJECT)
ARGS=a
LANG=fr
CREAT=miblack
PROJECT=chess
MAINCLASS=Main

LIBDIR=lib
SRCDIR=src
BINDIR=bin

SRC=$(shell find $(SRCDIR) -name "*.java")
BIN=$(patsubst $(SRCDIR)/%.java,$(BINDIR)/%.class,$(SRC))
WARN=-Xlint:all
CLASSPATH=$(shell find $(LIBDIR) -name "*.jar" -printf "%p:")$(BINDIR)
RUN_OPTIONS=-classpath $(CLASSPATH) $(TARGET) $(ARGS)
COMPILE_OPTIONS=$(WARN) -d $(BINDIR) -sourcepath $(SRCDIR) -encoding UTF-8



all: compile

run: compile
#	java $(BINDIR)/$(TARGETDIR)/$(MAINCLASS)
	java $(RUN_OPTIONS)

compile: $(BINDIR) $(BIN)

$(BINDIR)/%.class: $(SRCDIR)/%.java
	javac $< $(COMPILE_OPTIONS)

$(BINDIR):
	@test -d $(BINDIR) || mkdir $(BINDIR)

clean:
	rm -fr $(BINDIR)
	rm -fr fr resources *.html *.css package-list html latex

manifest:
	mkdir $(BINDIR)/META-INF && touch $(BINDIR)/META-INF/MANIFEST.MF && echo "Main-Class: $(TARGET) " > $(BINDIR)/META-INF/MANIFEST.MF

jar:
	(cd $(BINDIR) && jar cvmf META-INF/MANIFEST.MF ../$(PROJECT).jar $(TARGETDIR)/* )

javadoc:
	javadoc $(shell find $(SRCDIR) -name "*.java")
#	javadoc  $(SRCDIR)/$(TARGETDIR)/*.java

commit:
	cp -R ./* ~/workspace/chess

update:
	cp -R ~/workspace/chess/* ./

doxygen:
	doxygen	 $(shell find $(SRCDIR) -name "*.java")
