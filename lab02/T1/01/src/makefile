JCC = javac

JFLAGS = -g -d bin

FILE ?= default.txt

# Compilar todos os arquivos .java
compile:
	$(JCC) $(JFLAGS) WSSolver.java WSGenerator.java Functions.java Direction.java

# Executar o programa principal (WSSolver) com um arquivo .txt especificado
run1: compile
	java -cp bin WSSolver $(FILE)

run2: compile
	java -cp bin WSGenerator $(FILE)

# Limpar os arquivos .class
clean:
	$(RM) bin/*.class
