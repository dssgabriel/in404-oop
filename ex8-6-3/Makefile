JC = javac
JVM = java
MAIN = Main
ARCHIVE = cli_drawing

run: build
	$(JVM) -cp target/ $(MAIN)

build:
	$(JC) -d target/ src/*.java

clean:
	rm -Rf target/

archive: clean
	mkdir -p ${ARCHIVE}
	cp -R src/ ${ARCHIVE}
	cp Makefile ${ARCHIVE}
	cp README.org ${ARCHIVE}
	tar -zcvf ${ARCHIVE}.tar ${ARCHIVE}
	rm -Rf ${ARCHIVE}
