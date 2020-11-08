JC = javac
JVM = java
MAIN = DnsApp
ARCHIVE = dns_simulation

run: build
	$(JVM) -cp target/ $(MAIN)

build:
	$(JC) -d target/ src/*.java

clean:
	rm -Rf target/
	rm -Rf *.tar

archive: clean
	mkdir -p $(ARCHIVE)
	cp -R src/ $(ARCHIVE)
	cp database.txt $(ARCHIVE)
	cp Makefile $(ARCHIVE)
	cp README.org $(ARCHIVE)
	tar -zcvf $(ARCHIVE).tar $(ARCHIVE)
	rm -Rf $(ARCHIVE)
