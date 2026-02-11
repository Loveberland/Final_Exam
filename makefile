# Define the compiler and runtime
JC = javac
JVM = java

# Main class entry point
MAIN_CLASS = Final_Exam.Main

# Detect the Operating System
ifeq ($(OS),Windows_NT)
    # --- Windows Settings ---
    SEP = \
    RM = rd /s /q
    MKDIR = mkdir

    # Path Configuration
    SRC_DIR = src\main\java
    BIN_DIR = bin
    RESOURCE_DIR = src\resources

    # Command to find sources recursively on Windows
    SOURCES = $(shell dir /s /b $(SRC_DIR)\*.java)

    # Executable logic for mkdir (suppress error if exists)
    MKDIR_CMD = if not exist $(BIN_DIR) $(MKDIR) $(BIN_DIR)
else
    # --- Linux / Unix / macOS Settings ---
    SEP = /
    RM = rm -rf
    MKDIR = mkdir -p

    # Path Configuration
    SRC_DIR = src/main/java
    BIN_DIR = bin
    RESOURCE_DIR = src/resources

    # Command to find sources recursively on Linux/Unix
    SOURCES = $(shell find $(SRC_DIR) -name "*.java")

    # Executable logic for mkdir
    MKDIR_CMD = $(MKDIR) $(BIN_DIR)
endif

# Compiler flags
JFLAGS = -d $(BIN_DIR) -sourcepath $(SRC_DIR)

# Default target
all: build

build:
	@echo Compiling Java files...
	$(MKDIR_CMD)
	$(JC) $(JFLAGS) $(SOURCES)
	@echo Build successful!

run: build
	@echo Running application...
	$(JVM) -cp $(BIN_DIR) $(MAIN_CLASS)

clean:
	@echo Cleaning bin directory...
	$(RM) $(BIN_DIR)
	@echo Clean complete!
