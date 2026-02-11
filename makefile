JC = javac
JVM = java

SRC_DIR = src/main/java
BIN_DIR = bin
RESOURCE_DIR = src/resources

SOURCES = $(shell find $(SRC_DIR) -name "*.java")

MAIN_CLASS = Final_Exam.Main

JFLAGS = -d $(BIN_DIR) -sourcepath $(SRC_DIR)

all: build

$(BIN_DIR):
	@mkdir -p $(BIN_DIR)

build: $(BIN_DIR)
	@echo "Compiling Java files..."
	$(JC) $(JFLAGS) $(SOURCES)
	@echo "Build successful!"

run: build
	@echo "Running application..."
	$(JVM) -cp $(BIN_DIR) $(MAIN_CLASS)

clean:
	@echo "Cleaning bin directory..."
	@rm -rf $(BIN_DIR)
	@echo "Clean complete!"
