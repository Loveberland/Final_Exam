# Java Application - Final Exam

This project includes automated build scripts to compile and run the Java application (`Final_Exam.Main`) easily across different operating systems. 

## Prerequisites
* **Java Development Kit (JDK):** Ensure the `javac` and `java` commands are available in your system's PATH.
* **Make (Optional for Windows):** Required if you intend to use the `makefile` on Linux or macOS.

---

## Instructions for Windows

You have two options on Windows: using the provided Batch script or using Make.

### Option 1: Using the Batch Script (`run.bat`)
The provided Windows script (`run.bat`) manages configuration and execution natively. Open your Command Prompt or PowerShell in the project's root directory and use the following commands:

* **Clean:** Run `run.bat clean` to delete the `bin` directory and remove old compiled files.
* **Build:** Run `run.bat build` (or simply `run.bat`) to compile all `.java` files from `src\main\java` into the `bin` directory.
* **Run:** Run `run.bat run` to automatically build the project and execute the application.

### Option 2: Using Make
If you have `make` installed on your Windows environment, the included `makefile` automatically detects Windows and uses the correct paths and commands.

* **Clean:** Run `make clean`
* **Build:** Run `make build` (or `make`)
* **Run:** Run `make run`

---

## Instructions for Linux & macOS

Linux and macOS rely on the provided `makefile`, which detects Unix-based systems and applies the correct file separators and shell commands. Open your terminal in the project directory and use the following commands:

* **Clean the project:** Run `make clean` to remove the `bin` directory.
* **Build the project:** Run `make build` (or just `make`) to compile the source code into the `bin` directory.
* **Run the application:** Run `make run` to compile the Java files and execute the program.

---

## Project Structure
* `src/main/java/`: Contains all Java source files.
* `src/resources/`: Contains application resources.
* `bin/`: The output directory where compiled `.class` files are stored.